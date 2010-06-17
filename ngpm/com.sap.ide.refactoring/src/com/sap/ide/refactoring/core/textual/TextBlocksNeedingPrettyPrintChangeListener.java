/**
 *
 */
package com.sap.ide.refactoring.core.textual;

import java.util.List;
import java.util.Map;

import com.sap.ide.refactoring.core.textual.TextBlockInChangeCalculator.ModelElementTextBlockTuple;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class TextBlocksNeedingPrettyPrintChangeListener implements ChangeListener {

    private TextBlockInChangeCalculator tbChangeCalculator = new TextBlockInChangeCalculator();

    @Override
    public void notify(ChangeEvent event) {
	if (event instanceof ElementChangeEvent) {
	    ElementChangeEvent elementEvent = (ElementChangeEvent) event;
	    RefObject affectedElement = elementEvent.getAffectedElement(event.getEventTriggerConnection());
	    if (affectedElement != null) {
		tbChangeCalculator.add(affectedElement);
	    }
	}
	if (event instanceof LinkChangeEvent) {
	    LinkChangeEvent linkEvent = (LinkChangeEvent) event;
	    RefObject affectedElement = linkEvent.getFirstLinkEnd(event.getEventTriggerConnection());
	    if (affectedElement != null) {
		tbChangeCalculator.add(affectedElement);
	    }
	    affectedElement = linkEvent.getSecondLinkEnd(event.getEventTriggerConnection());
	    if (affectedElement != null) {
		tbChangeCalculator.add(affectedElement);
	    }
	}
    }

    public Map<RefObject, List<ModelElementTextBlockTuple>> getTextBlocksNeedingPrettyPrinting() {
	return tbChangeCalculator.getTextBlocksNeedingPrettyPrinting();
    }

    public Map<RefObject, List<ModelElementTextBlockTuple>> getTextBlocksNeedingShortPrettyPrinting() {
	return tbChangeCalculator.getTextBlocksNeedingShortPrettyPrinting();
    }

}