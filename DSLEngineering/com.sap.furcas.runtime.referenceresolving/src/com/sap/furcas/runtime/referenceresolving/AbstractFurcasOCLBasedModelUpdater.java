package com.sap.furcas.runtime.referenceresolving;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.emf.ocl.trigger.AbstractOCLBasedModelUpdater;
import com.sap.emf.ocl.trigger.ExpressionWithContext;
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.textblocks.TbUtil;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;

/**
 * Offers some "text blocks magic" utility methods to subclasses, such as finding the text blocks and from those the
 * elements to which particular {@link InjectorAction}s were applied. This can be used, e.g., to filter result of the
 * {@link ImpactAnalyzer#getContextObjects(org.eclipse.emf.common.notify.Notification)} method further so as to only
 * re-apply an injector action to those elements to which the injector action was applied before.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class AbstractFurcasOCLBasedModelUpdater extends AbstractOCLBasedModelUpdater {

    protected AbstractFurcasOCLBasedModelUpdater(EStructuralFeature propertyToUpdate,
            OppositeEndFinder oppositeEndFinder, ExpressionWithContext triggerExpression,
            boolean notifyOnNewContextElements) {
        super(propertyToUpdate, oppositeEndFinder, triggerExpression, notifyOnNewContextElements);
    }

    private Collection<TextBlock> getTextBlocksUsingQueryElement(Template template) {
        Collection<TextBlock> result = new HashSet<TextBlock>();
        Collection<EObject> candidates = getOppositeEndFinder().navigateOppositePropertyWithBackwardScope(
                TextblockdefinitionPackage.eINSTANCE.getTextBlockDefinition_ParseRule(), template);
        if (candidates != null && !candidates.isEmpty()) {
            TextBlockDefinition def = (TextBlockDefinition) candidates.iterator().next();
            Collection<EObject> textBlockCandidates = getOppositeEndFinder().navigateOppositePropertyWithBackwardScope(
                    TextblocksPackage.eINSTANCE.getTextBlock_Type(), def);
            if (!textBlockCandidates.isEmpty()) {
                for (EObject textBlock : textBlockCandidates) {
                    result.add((TextBlock) textBlock);
                }
                Collection<EObject> additionalTextBlockCandidates = getOppositeEndFinder()
                        .navigateOppositePropertyWithBackwardScope(
                                TextblocksPackage.eINSTANCE.getTextBlock_AdditionalTemplates(), template);
                for (EObject textBlock : additionalTextBlockCandidates) {
                    result.add((TextBlock) textBlock);
                }
            }
        }
        // now find all TextBlocks that reference the template in their
        // "additionalTemplate"
        result = TbUtil.filterVersionedTextBlockForNewest(result);
        return result;
    }

    protected Collection<TextBlock> getTextBlocksInChosenAlternativeForInjectorAction(InjectorAction injectorAction) {
        Collection<TextBlock> result = new ArrayList<TextBlock>();
        if (injectorAction != null) {
            InjectorActionsBlock injectorActionsBlock = injectorAction.getInjectorActionsBlock();
            Template template = injectorActionsBlock.getParentTemplate();
            // now find all TextBlocks referencing this template;
            Collection<TextBlock> tbs = getTextBlocksUsingQueryElement(template);
            for (TextBlock textBlock : tbs) {
                // first check if the alternative in which the injector action
                // resides was chosen during the parsing process
                // TODO this is a workaround. to properly decide this we need to keep track of the alternative chosen at runtime of the parser
                boolean wasInChosenAlternative = isInjectorActionInChosenAlternative(injectorActionsBlock, textBlock);

                if (wasInChosenAlternative) {
                    result.add(textBlock);
                }
            }
        }
        return result;
    }

    private boolean isInjectorActionInChosenAlternative(InjectorActionsBlock injectorActionsBlock, TextBlock textBlock) {
        boolean wasInChosenAlternative = false;
        if (textBlock.getTokens().isEmpty()) {
            for (TextBlock tb : textBlock.getSubBlocks()) {
                if (tb.getSequenceElement() != null
                        && (tb.getSequenceElement().getElementSequence()
                                .equals(injectorActionsBlock.getElementSequence()) || injectorActionsBlock
                                .getElementSequence().eContainer() instanceof ContextTemplate)) {
                    wasInChosenAlternative = true;
                    break;
                }
            }
        } else {
            for (AbstractToken tok : textBlock.getTokens()) {
                if (tok instanceof LexedToken) {
                    LexedToken lt = (LexedToken) tok;
                    // check if injectoraction was in chosen alternative or
                    // directly in in the template
                    if (lt.getSequenceElement() != null
                            && (lt.getSequenceElement().getElementSequence()
                                    .equals(injectorActionsBlock.getElementSequence()) || injectorActionsBlock
                                    .getElementSequence().eContainer() instanceof ContextTemplate)) {
                        wasInChosenAlternative = true;
                        break;
                    }
                }
            }
        }
        return wasInChosenAlternative;
    }

}