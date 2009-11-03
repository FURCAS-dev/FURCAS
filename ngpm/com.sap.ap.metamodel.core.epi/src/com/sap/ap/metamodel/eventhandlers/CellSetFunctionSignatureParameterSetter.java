package com.sap.ap.metamodel.eventhandlers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.osgi.framework.BundleContext;

import com.sap.tc.moin.globalmodellistener.GlobalEventListener;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.AssociationFilter;
import com.sap.tc.moin.repository.events.filter.AttributeFilter;
import com.sap.tc.moin.repository.events.filter.ClassFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.AttributeValueEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.TypedElement;

import data.classes.AImplementationFunctionSignature;
import data.classes.FunctionSignature;
import data.classes.Parameter;
import dataaccess.analytics.ADimensionsCellSet;
import dataaccess.analytics.CellSet;
import dataaccess.analytics.Dimension;

/**
 * Due to the current limitations of the Furcas/TCS approach we cannot create the parameters
 * for the {@link FunctionSignature} used for the type of a {@link CellSet}. We want to
 * create one {@link Parameter} element per {@link Dimension} element where the name is
 * initialized from the dimension's name. The parameter's type is left unset because it is
 * inferred by {@link TypedElement#getType()}.<p>
 * 
 * This listener watches for establishing the link between a {@link CellSet} and its
 * {@link FunctionSignature} (see {@link CellSet#setFunctionSignature(FunctionSignature)}) as
 * well as for any changes in a cell set's dimensions (names, additions, deletions).
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class CellSetFunctionSignatureParameterSetter implements GlobalEventListener, UpdateListener {
    Logger log = Logger.getLogger(CellSetFunctionSignatureParameterSetter.class.getName());
    
    @Override
    public void notifyUpdate(EventChain events) {
	for (ChangeEvent event : events.getEvents()) {
	    Connection conn = event.getEventTriggerConnection();
	    if (event instanceof LinkChangeEvent) {
		LinkChangeEvent lce = (LinkChangeEvent) event;
		if (lce.getAffectedMetaObject(conn).equals(conn.getAssociation(ADimensionsCellSet.ASSOCIATION_DESCRIPTOR).refMetaObject())) {
		    Dimension dimension = (Dimension) lce.getFirstLinkEnd(conn);
		    CellSet cellSet = dimension.getCellSet();
		    // continue only if a function signature has already been set
		    if (cellSet.getFunctionSignature() != null) {
			int pos = lce.getPosition();
			if (event instanceof LinkAddEvent) {
			    Parameter p = conn.createElement(Parameter.CLASS_DESCRIPTOR);
			    p.setName(dimension.getName());
			    // add 1 to skip the first argument which is the facts base
			    cellSet.getFunctionSignature().getInput().add(
				    (pos == -1) ? cellSet.getFunctionSignature().getInput().size() : pos+1, p);
			}
			if (event instanceof LinkRemoveEvent) {
			    // add 1 to skip the first argument which is the facts base
			    cellSet.getFunctionSignature().getInput().remove(pos+1);
			}
		    }
		} else if (lce.getAffectedMetaObject(conn).equals(
			conn.getAssociation(AImplementationFunctionSignature.ASSOCIATION_DESCRIPTOR).refMetaObject())) {
		    if (lce instanceof LinkAddEvent) {
			CellSet cellSet = (CellSet) lce.getFirstLinkEnd(conn);
			setFactsAndDimensionParams(conn, cellSet,
				cellSet.getFunctionSignature());
		    }
		}
	    } else if (event instanceof AttributeValueEvent) {
		// synchronize the dimension's name to the parameter name
		AttributeValueEvent ave = (AttributeValueEvent) event;
		Dimension dim = (Dimension) ave.getAffectedElement(conn);
		if (dim.getCellSet() != null) {
		    FunctionSignature sig = dim.getCellSet().getFunctionSignature();
		    if (sig != null) {
			int pos = dim.getCellSet().getDimensions().indexOf(dim);
			if (pos < sig.getInput().size()) {
			    // add 1 to skip the first argument which is the facts base
			    sig.getInput().get(pos+1).setName(dim.getName());
			}
		    }
		}
	    }
	}
    }

    private void setFactsAndDimensionParams(Connection conn, CellSet cellSet, FunctionSignature functionSignature) {
	List<Parameter> params = new ArrayList<Parameter>(functionSignature.getInput());
	for (Parameter param : params) {
	    param.refDelete();
	}
	Parameter factsParam = conn.createElement(Parameter.CLASS_DESCRIPTOR);
	factsParam.setName("facts");
	functionSignature.getInput().add(factsParam);
	for (Dimension dim : cellSet.getDimensions()) {
	    Parameter p = conn.createElement(Parameter.CLASS_DESCRIPTOR);
	    p.setName(dim.getName());
	    functionSignature.getInput().add(p);
	}
    }

    @Override
    public Map<EventFilter, Map<ListenerType, EventListener>> getFilters(Connection connection, BundleContext context) {
	HashMap<EventFilter, Map<ListenerType, EventListener>> result = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	
	// the assoc between a function signature and its implementation (the cell set)
	Association sigImplAssoc = connection.getAssociation(
		AImplementationFunctionSignature.ASSOCIATION_DESCRIPTOR).refMetaObject();
	EventFilter assocFilter = new AssociationFilter(sigImplAssoc);
	EventFilter cellSetTypeFilter = new ClassFilter(connection.getClass(
		CellSet.CLASS_DESCRIPTOR).refMetaObject(),
		/* includeSubclasses */ true);
	EventFilter andFilter = new AndFilter(assocFilter, cellSetTypeFilter, new EventTypeFilter(LinkAddEvent.class));
	Map<ListenerType, EventListener> listenerForType = new HashMap<ListenerType, EventListener>();
	listenerForType.put(ListenerType.UPDATE, this);
	result.put(andFilter, listenerForType);
	
	// name change on Dimension
	MofClass dimension = connection.getClass(Dimension.CLASS_DESCRIPTOR).refMetaObject();
	Attribute dimNameAttr = connection.getJmiHelper().getAttributeByName(
		dimension, "name", /* includeSupertypes */true);
	EventFilter dimensionNameChangeFilter = new AttributeFilter(dimNameAttr);
	EventFilter dimTypeFilter = new ClassFilter(dimension, /* includeSubtypes */ true);
	AndFilter dimensionNameChangeFilterWithTypeFilter = new AndFilter(dimensionNameChangeFilter, dimTypeFilter);
	result.put(dimensionNameChangeFilterWithTypeFilter, listenerForType);
	
	// changes on dimensions of a CellSet
	Association dimensionsAssoc = connection.getAssociation(
		ADimensionsCellSet.ASSOCIATION_DESCRIPTOR).refMetaObject();
	EventFilter dimAssocFilter = new AssociationFilter(dimensionsAssoc);
	result.put(dimAssocFilter, listenerForType);
	
	return result;
    }

}
