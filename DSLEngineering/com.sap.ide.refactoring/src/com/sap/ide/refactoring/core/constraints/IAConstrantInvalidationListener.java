package com.sap.ide.refactoring.core.constraints;

import java.util.HashSet;
import java.util.Set;

import com.sap.ide.refactoring.Activator;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;

public class IAConstrantInvalidationListener implements ChangeListener {

    private final ConstraintSpecificImpactAnalysisFacade impactAnalysisFacade;
    private final Set<MRI> elementsImpactedByEvents = new HashSet<MRI>();
    private final Connection connection;


    public IAConstrantInvalidationListener(Connection connection, ConstraintSpecificImpactAnalysisFacade impactAnalysisFacade) {
	this.connection = connection;
	this.impactAnalysisFacade = impactAnalysisFacade;
    }

    @Override
    public void notify(ChangeEvent event) {
	try {
	    if (event instanceof ModelChangeEvent) {
		ModelChangeEvent mce = (ModelChangeEvent) event;
		elementsImpactedByEvents.addAll(impactAnalysisFacade.getAffectedModelElements(connection, mce));
	    }
	} catch (Exception e) {
	    Activator.logError(e, "Failed to handle incoming change event");
	}
    }

    public EventFilter getEventFilter() {
	return impactAnalysisFacade.getEventFilter(connection, false);
    }

    public Set<MRI> getElementsImpactedByEvents() {
	return new HashSet<MRI>(elementsImpactedByEvents);
    }

}
