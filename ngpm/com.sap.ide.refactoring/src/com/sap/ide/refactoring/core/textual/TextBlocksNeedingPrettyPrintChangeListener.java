/**
 *
 */
package com.sap.ide.refactoring.core.textual;

import java.util.List;
import java.util.Map;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.eclipse.emf.ecore.EObject;

import com.sap.ide.refactoring.core.textual.TextBlockInChangeCalculator.ModelElementTextBlockTuple;

public class TextBlocksNeedingPrettyPrintChangeListener implements ChangeListener {

    private TextBlockInChangeCalculator tbChangeCalculator = new TextBlockInChangeCalculator();

    @Override
    public void notify(ChangeEvent event) {
	if (event instanceof ElementChangeEvent) {
	    ElementChangeEvent elementEvent = (ElementChangeEvent) event;
	    EObject affectedElement = elementEvent.getAffectedElement(event.getEventTriggerConnection());
	    if (affectedElement != null) {
		tbChangeCalculator.add(affectedElement);
	    }
	}
	if (event instanceof LinkChangeEvent) {
	    LinkChangeEvent linkEvent = (LinkChangeEvent) event;
	    EObject affectedElement = linkEvent.getFirstLinkEnd(event.getEventTriggerConnection());
	    if (affectedElement != null) {
		tbChangeCalculator.add(affectedElement);
	    }
	    affectedElement = linkEvent.getSecondLinkEnd(event.getEventTriggerConnection());
	    if (affectedElement != null) {
		tbChangeCalculator.add(affectedElement);
	    }
	}
    }

    public Map<EObject, List<ModelElementTextBlockTuple>> getTextBlocksNeedingPrettyPrinting() {
	return tbChangeCalculator.getTextBlocksNeedingPrettyPrinting();
    }

    public Map<EObject, List<ModelElementTextBlockTuple>> getTextBlocksNeedingShortPrettyPrinting() {
	return tbChangeCalculator.getTextBlocksNeedingShortPrettyPrinting();
    }

}