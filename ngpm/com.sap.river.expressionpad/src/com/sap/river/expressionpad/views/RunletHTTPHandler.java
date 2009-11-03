package com.sap.river.expressionpad.views;

import integration.binding.HttpBinding;
import integration.binding.SimpleUrlPattern;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

import com.sap.river.expressionpad.Activator;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.StackFrame;
import com.sap.river.interpreter.objects.FunctionObject;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.tc.moin.globalmodellistener.GlobalEventListener;
import com.sap.tc.moin.globalmodellistener.GlobalEventListenerRegistry;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.AttributeFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import data.classes.ClassTypeDefinition;
import data.classes.Parameter;
import dataaccess.expressions.Expression;

public class RunletHTTPHandler implements HttpHandler, Executor {
    private Logger log = Logger.getLogger(RunletHTTPHandler.class.getName());

    private RiverInterpreter interpreter;

    /**
     * mapping of URL paths to configured bindings
     */
    private Map<String, HttpBinding> pathBindings;

    public RunletHTTPHandler(RiverInterpreter theInterpreter) {
	interpreter = theInterpreter;
	Connection conn = interpreter.getConnection();
	pathBindings = new HashMap<String, HttpBinding>();

	loadHTTPBindings(conn);

	// register for all events on partitions
	MofClass simpleUrlPattern = interpreter.getConnection().getClass(
		SimpleUrlPattern.CLASS_DESCRIPTOR).refMetaObject();
	Attribute baseUrl = conn.getJmiHelper().getAttributeByName(simpleUrlPattern, "baseUrl", /* includeSupertypes */ false); //$NON-NLS-1$
	EventFilter filter = new AttributeFilter(baseUrl);
	// TODO add more fine-grained filters here, for associations, HttpBinding instance creation/deletion, ...

	 UpdateListener listener = new UpdateListener() {
	    @Override
	    public void notifyUpdate(EventChain event) {
		// TODO: quite unsave to just reload the binding here without
		// stopping the HTTP server.
		loadHTTPBindings(event.getEvents().get(0).getEventTriggerConnection());
	    }

	};
	// TODO register for service event; when global event registry service appears, register; avoids NPE or checking for NULL
	GlobalEventListenerRegistry globalRegistry = Activator.getGlobalEventListenerRegistry();
	if (globalRegistry == null) {
	    log.severe(Messages.RunletHTTPHandler_2);
	} else {
	    Map<EventFilter, Map<GlobalEventListener.ListenerType, EventListener>> listeners = new HashMap<EventFilter, Map<GlobalEventListener.ListenerType, EventListener>>();
	    Map<GlobalEventListener.ListenerType, EventListener> map = new HashMap<GlobalEventListener.ListenerType, EventListener>();
	    map.put(GlobalEventListener.ListenerType.UPDATE, listener);
	    listeners.put(filter, map);
	    globalRegistry.addFilters(listeners);
	}
    }

    protected void loadHTTPBindings(Connection fromWhereToLoad) {
	pathBindings.clear();
	// Load all HTTP Bindings
	MQLProcessor mql = fromWhereToLoad.getMQLProcessor();
	MQLResultSet queryResult = mql.execute(
		"select b from integration::binding::HttpBinding as b", mql.getQueryScopeProvider( //$NON-NLS-1$
		/* scopeInclusive */false, /* partitionScope */
		null, (String[]) null));
	for (int i = 0; i < queryResult.getSize(); i++) {
	    HttpBinding binding = (HttpBinding) queryResult.getRefObject(i, "b"); //$NON-NLS-1$
	    // For now we do not evaluate the Expression upon loading the configuration.
	    // This should be a lot more robust in the presence of changes to the function
	    // implementation.
	    // In the future it should be possible to optimize this part and evaluate the
	    // expressions
	    // right away. This would require to listen for changes on the implementation.
	    pathBindings.put(((SimpleUrlPattern) binding.getUrlPattern()).getBaseUrl(), binding);
	}
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
	String response = null;
	try {
	    // Find a suitable URL binding
	    Expression functionExpression = determineURLBinding(t.getRequestURI());
	    // Evaluate target to callable FunctionObject
	    RiverInterpreter requestInterpreter = interpreter.spawn();
	    FunctionObject callTarget = (FunctionObject) requestInterpreter
		    .evaluate(functionExpression);
	    // fill stack frame with actual parameters
	    fillStackFrame(requestInterpreter, callTarget.getImplementation()
		    .getImplementedSignature().getInput(), t.getRequestURI());
	    // Invoke function
	    RiverObject result = callTarget.evaluate(requestInterpreter);
	    // Marshall response
	    response = result.toString();
	    t.sendResponseHeaders(200, response.length());
	} catch (IllegalArgumentException iae) {
	    response = Messages.RunletHTTPHandler_5 + iae.getMessage();
	    t.sendResponseHeaders(404, response.length());
	} catch (Exception e) {
	    StringWriter output = new StringWriter();
	    output.write(Messages.RunletHTTPHandler_6);
	    e.printStackTrace(new PrintWriter(output));
	    response = output.getBuffer().toString();
	    t.sendResponseHeaders(500, response.length());
	}

	OutputStream os = t.getResponseBody();
	os.write(response.getBytes());
	os.close();
    }

    private void fillStackFrame(RiverInterpreter requestInterpreter,
	    List<Parameter> formalParameters, URI requestURI) throws UnsupportedEncodingException {
	requestInterpreter.getCallstack().push(new StackFrame());
	// get map of parameter names and values encoded in the URL
	Map<String, String> urlParameters = extractParameters(requestURI);
	// loop over formal parameters
	for (Parameter parameter : formalParameters) {
	    String value = urlParameters.get(parameter.getName());
	    if (value == null) {
		throw new IllegalStateException(Messages.RunletHTTPHandler_7
			+ parameter.getName());
	    }
	    ClassTypeDefinition clazz = (ClassTypeDefinition) parameter.getType();
	    // for now, only Number and String are supported
	    RiverObject nativeObject = null;
	    if (clazz.getClazz().getName().equals("Number")) { //$NON-NLS-1$
		nativeObject = new NativeObject(clazz, new BigDecimal(value), requestInterpreter.getDefaultSnapshot(), interpreter);
	    } else {
		// must be a String
		nativeObject = new NativeObject(clazz, value, requestInterpreter.getDefaultSnapshot(), interpreter);
	    }
	    requestInterpreter.getCallstack().peek().enterValue(parameter, nativeObject);
	}
    }

    private Expression determineURLBinding(URI requestURI) throws IllegalArgumentException {
	HttpBinding binding = pathBindings.get(requestURI.getPath());
	if (binding == null) {
	    StringBuilder str = new StringBuilder();
	    str.append(Messages.RunletHTTPHandler_9).append(requestURI.getPath()).append("\n"); //$NON-NLS-2$
	    str.append(Messages.RunletHTTPHandler_11);
	    for (String path : pathBindings.keySet()) {
		str.append(" ").append(path).append("\n"); //$NON-NLS-1$ //$NON-NLS-2$
	    }
	    throw new IllegalArgumentException(str.toString());
	}
	return binding.getFunction();
    }

    private Map<String, String> extractParameters(URI requestURI)
	    throws UnsupportedEncodingException {
	Map<String, String> result = new HashMap<String, String>();
	String rawQueryString = requestURI.getRawQuery();
	if (rawQueryString != null) {
	    String[] parameters = requestURI.getRawQuery().split("&"); //$NON-NLS-1$
	    for (String parameter : parameters) {
		String[] pair = parameter.split("="); //$NON-NLS-1$
		result.put(URLDecoder.decode(pair[0], "ISO-8859-1"), URLDecoder.decode(pair[1], //$NON-NLS-1$
			"ISO-8859-1")); //$NON-NLS-1$
	    }
	}
	return result;
    }

    /**
     * Implementation of handler method from interface Executor
     */
    public void execute(Runnable r) {
	new Thread(r).start();
    }

}
