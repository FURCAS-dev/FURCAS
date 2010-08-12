/**
 *
 */
package com.sap.ide.refactoring.core.textual;

import java.util.List;
import java.util.Map;

import com.sap.ide.refactoring.Activator;
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
 * pretty printing.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class TextBlocksNeedingPrettyPrintChangeListener implements ChangeListener, PreChangeListener {

    private final TextBlockInChangeCalculator tbChangeCalculator = new TextBlockInChangeCalculator();

    /**
     * Pre change events
     */
    @Override
    public void prepare(ChangeEvent event) {
	try {
	    // We need to handle deleted elements before they are actually deleted.
	    if (event instanceof ElementDeleteEvent) {
		ElementDeleteEvent elementEvent = (ElementDeleteEvent) event;
		RefObject affectedElement = elementEvent.getAffectedElement(event.getEventTriggerConnection());
		if (affectedElement != null) {
		    tbChangeCalculator.add(affectedElement, ChangeType.DELETED);
		}
	    }
	} catch (Exception e) {
	    Activator.logError(e, "Failed to calculate changed text blocks");
	}
    }

    /**
     * Post change events.
     */
    @Override
    public void notify(ChangeEvent event) {
	try {
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
		RefObject affectedElement = linkEvent.getFirstLinkEnd(event.getEventTriggerConnection());
		if (affectedElement != null) {
		    tbChangeCalculator.add(affectedElement, ChangeType.CHANGED);
		}
		affectedElement = linkEvent.getSecondLinkEnd(event.getEventTriggerConnection());
		if (affectedElement != null) {
		    tbChangeCalculator.add(affectedElement, ChangeType.CHANGED);
		}
	    }
	} catch (Exception e) {
	    Activator.logError(e, "Failed to calculate changed text blocks");
	}
    }

    public Map<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> getTextBlocksNeedingPrettyPrinting() {
	return tbChangeCalculator.getTextBlocksNeedingPrettyPrinting();
    }

    public Map<RootElementTextBlockTuple, List<ModelElementDocumentNodeChangeDescriptor>> getTextBlocksNeedingShortPrettyPrinting() {
	return tbChangeCalculator.getTextBlocksNeedingShortPrettyPrinting();
    }

}