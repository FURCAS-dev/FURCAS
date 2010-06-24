/**
 *
 */
package com.sap.ide.refactoring.core.textual;

import java.util.List;
import java.util.Map;

import com.sap.ide.refactoring.core.textual.ModelElementDocumentNodeChangeDescriptor.ChangeType;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Listener that analyzes ModelChange events to determine the minimal TextBlock trees that need
 * pretty printing. We are interrested in a minimal tree because a) we want to retain formatting
 * as far as possible and b) it does not make sense to e.g. re-print a TextBlock if we already
 * pretty printed it's composite parent.
 * 
 * @author D049157
 *
 */
public class TextBlocksNeedingPrettyPrintChangeListener implements ChangeListener, PreChangeListener {

    private TextBlockInChangeCalculator tbChangeCalculator = new TextBlockInChangeCalculator();

    /**
     * Pre change events
     */
    @Override
    public void prepare(ChangeEvent event) {
	// We need to handle deleted elements before they are actually deleted.
	if (event instanceof ElementDeleteEvent) {
	    ElementDeleteEvent elementEvent = (ElementDeleteEvent) event;
	    RefObject affectedElement = elementEvent.getAffectedElement(event.getEventTriggerConnection());
	    if (affectedElement != null) {
		tbChangeCalculator.add(affectedElement, ChangeType.DELETED);
	    }
	}
    }

    /**
     * Post change events.
     */
    @Override
    public void notify(ChangeEvent event) {
	if (event instanceof ElementChangeEvent) {
	    ElementChangeEvent elementEvent = (ElementChangeEvent) event;
	    RefObject affectedElement = elementEvent.getAffectedElement(event.getEventTriggerConnection());
	    if (affectedElement != null) {
		if (event instanceof ElementCreateEvent) {
		    tbChangeCalculator.add(affectedElement, ChangeType.CREATED);
		} else if (event instanceof ElementDeleteEvent) {
		    // do nothing; already handled in the prepare handler
		} else {
		    tbChangeCalculator.add(affectedElement, ChangeType.CHANGED);
		}
	    }
	}
	if (event instanceof LinkChangeEvent) {
	    LinkChangeEvent linkEvent = (LinkChangeEvent) event;
	    // System.out.println(linkEvent.getAffectedMetaObject(event.getEventTriggerConnection()));
	    RefObject affectedElement = linkEvent.getFirstLinkEnd(event.getEventTriggerConnection());
	    if (affectedElement != null) {
		tbChangeCalculator.add(affectedElement, ChangeType.CHANGED);
	    }
	    affectedElement = linkEvent.getSecondLinkEnd(event.getEventTriggerConnection());
	    if (affectedElement != null) {
		tbChangeCalculator.add(affectedElement, ChangeType.CHANGED);
	    }
	}
    }

    public Map<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> getTextBlocksNeedingPrettyPrinting() {
	return tbChangeCalculator.getTextBlocksNeedingPrettyPrinting();
    }

    public Map<RefObject, List<ModelElementDocumentNodeChangeDescriptor>> getTextBlocksNeedingShortPrettyPrinting() {
	return tbChangeCalculator.getTextBlocksNeedingShortPrettyPrinting();
    }

}