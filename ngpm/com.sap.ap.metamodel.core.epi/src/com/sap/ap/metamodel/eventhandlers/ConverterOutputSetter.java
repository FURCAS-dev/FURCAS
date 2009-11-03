package com.sap.ap.metamodel.eventhandlers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import org.osgi.framework.BundleContext;

import com.sap.tc.moin.globalmodellistener.GlobalEventListener;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.AssociationFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import data.classes.AConversionMethodConverter;
import data.classes.ActualObjectParameter;
import data.classes.ClassTypeDefinition;
import data.classes.ConverterBetweenParametrizations;
import data.classes.MethodSignature;
import data.classes.Parameter;
import dataaccess.expressions.VariableExpression;

/**
 * Due to the current limitations of the Furcas/TCS approach we cannot create the actual object
 * parameters for the {@link ClassTypeDefinition} that is attached as the output of a converter
 * method for object-parameterized value classes, mostly because creating a number of elements
 * determined dynamically from the cardinality of some other feature is not supported at this time.
 * As a workaround, we install this global event listener which will get notified whenever a
 * {@link ConverterBetweenParametrizations} element is linked to a {@link MethodSignature} using the
 * {@link AConversionMethodConverter} association. This handler will determine the formal object
 * parameters of the class and create {@link VariableExpression}s, one for each input parameter of
 * the converter method signature, and set them as the actual object parameters for the class type
 * definition used as that very method's output. It does so in the scope of the connection that
 * caused the change event.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class ConverterOutputSetter implements GlobalEventListener, UpdateListener {
    Logger log = Logger.getLogger(ConverterOutputSetter.class.getName());
    
    @Override
    public void notifyUpdate(EventChain events) {
	for (ChangeEvent event : events.getEvents()) {
	    if (event instanceof LinkAddEvent) {
		LinkAddEvent lre = (LinkAddEvent) event;
		MRI thisMri = lre.getSecondLinkEndMri();
		Connection conn = event.getEventTriggerConnection();
		ConverterBetweenParametrizations converter = (ConverterBetweenParametrizations) conn.getElement(thisMri.getLri());
		MethodSignature methodSignature = (MethodSignature) conn.getElement(lre
			.getFirstLinkEndMri().getLri());
		constructActualObjectParams(converter, methodSignature, conn);
	    }
	}
    }

    private void constructActualObjectParams(ConverterBetweenParametrizations converter,
	    MethodSignature methodSignature, Connection conn) {
	if (methodSignature == null) {
	    log.severe("Converter's signature doesn't have input parameters yet."+
	    " Unable to establish actual object parameters on output.");
	} else {
	    RefClass vec = conn.getClass(VariableExpression.CLASS_DESCRIPTOR);
	    RefClass aopc = conn.getClass(ActualObjectParameter.CLASS_DESCRIPTOR);
	    Iterator<Parameter> formalObjectParamIter = converter.getClazz().getFormalObjectParameters().iterator();
	    for (Parameter param:methodSignature.getInput()) {
		VariableExpression ve = (VariableExpression) vec.refCreateInstance();
		ve.setVariable(param);
		ActualObjectParameter aop = (ActualObjectParameter) aopc.refCreateInstance();
		aop.setFormalObjectParameter(formalObjectParamIter.next());
		aop.setValue(ve);
		((ClassTypeDefinition) methodSignature.getOutput()).getObjectParameters().add(aop);
	    }
	}
    }

    @Override
    public Map<EventFilter, Map<ListenerType, EventListener>> getFilters(Connection connection, BundleContext context) {
	HashMap<EventFilter, Map<ListenerType, EventListener>> result = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	Association converterMethodAssoc = connection.getAssociation(
		AConversionMethodConverter.ASSOCIATION_DESCRIPTOR).refMetaObject();
	EventFilter assocFilter = new AssociationFilter(converterMethodAssoc);
	EventFilter andFilter = new AndFilter(assocFilter, new EventTypeFilter(LinkAddEvent.class));
	Map<ListenerType, EventListener> listenerForType = new HashMap<ListenerType, EventListener>();
	listenerForType.put(ListenerType.UPDATE, this);
	result.put(andFilter, listenerForType);
	return result;
    }

}
