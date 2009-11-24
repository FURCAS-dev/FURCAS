package com.sap.runlet.expressionpad.views;

import java.io.IOException;
import java.net.InetSocketAddress;

import behavioral.actions.Block;
import behavioral.actions.Statement;

import com.sap.runlet.abstractexpressionpad.views.ConsoleView;
import com.sap.runlet.expressionpad.RunletEvaluator;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sun.net.httpserver.HttpServer;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NamedValue;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class RunletConsoleView
extends ConsoleView<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition,
Statement, Expression, SignatureImplementation, RunletStackFrame<AssociationEnd, TypeDefinition, ClassTypeDefinition>,
NativeImpl, RunletInterpreter, Block, NamedValue> {

    /**^
     * TODO: will be moved into its own
     */
    private HttpServer runletHTTPServer;

    /*
     * The content provider class is responsible for providing objects to the
     * view. It can wrap existing objects in adapters or simply return objects
     * as-is. These objects may be sensitive to the current input of the view,
     * or ignore it and always show the same content (like Task List, for
     * example).
     */

    /**
     * The constructor.
     */
    public RunletConsoleView() {
	super(new RunletBlockService());
    }

    @Override
    protected void createEvaluator() {
	evaluator = new RunletEvaluator("ngpm.stdlib", //$NON-NLS-1$
	    com.sap.runlet.interpreter.Activator.getDefault().getRunletDataStore());
    }

    @Override
    protected void shutdownHTTPServer() {
	runletHTTPServer.stop(0);
	runletHTTPServer = null;
    }

    @Override
    protected void reloadHttp() {
	RunletHTTPHandler handler = (RunletHTTPHandler) runletHTTPServer.getExecutor();
	handler.loadHTTPBindings(evaluator.getInterpreter().getConnection());
	output.append("HTTP binding reloaded."); //$NON-NLS-1$
    }

    @Override
    protected void initializeHTTPServer() {
	try {
	    runletHTTPServer = HttpServer.create(new InetSocketAddress(8123), 8123);
	    RunletHTTPHandler handler = new RunletHTTPHandler((RunletInterpreter) evaluator.getInterpreter());
	    runletHTTPServer.createContext("/", handler); //$NON-NLS-1$
	    runletHTTPServer.setExecutor(handler); // creates a default executor
	    runletHTTPServer.start();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}