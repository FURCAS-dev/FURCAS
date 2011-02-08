package com.sap.furcas.runtime.referenceresolving;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzer;

import com.sap.emf.ocl.trigger.AbstractOCLBasedModelUpdater;
import com.sap.emf.ocl.trigger.ExpressionWithContext;
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;
import com.sap.furcas.runtime.parser.impl.ModelElementProxy;
import com.sap.furcas.runtime.tcs.TcsUtil;


/**
 * Offers some "text blocks magic" utility methods to subclasses, such as finding the text blocks and from those the
 * elements to which particular {@link InjectorAction}s were applied. This can be used, e.g., to filter result of the
 * {@link ImpactAnalyzer#getContextObjects(org.eclipse.emf.common.notify.Notification)} method further so as to only
 * re-apply an injector action to those elements to which the injector action was applied before.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public abstract class AbstractFurcasOCLBasedModelUpdater extends AbstractOCLBasedModelUpdater {
    
    public enum SelfKind { SELF, CONTEXT, FOREACH };
    
    private final SelfKind selfKind;
    private final String contextTag;

    protected AbstractFurcasOCLBasedModelUpdater(EStructuralFeature propertyToUpdate,
            EPackage.Registry metamodelPackageRegistry, OppositeEndFinder oppositeEndFinder,
            ExpressionWithContext triggerExpression, boolean notifyOnNewContextElements, SelfKind selfKind, String contextTag) {
        super(propertyToUpdate, metamodelPackageRegistry, oppositeEndFinder, triggerExpression, notifyOnNewContextElements);
        this.selfKind = selfKind;
        this.contextTag = contextTag;
    }
    
    protected SelfKind getSelfKind() {
        return selfKind;
    }

    /**
     * This default implementation re-evaluates the {@link #triggerExpression} on each element reported as affected and
     * sets the {@link #getPropertyToUpdate() property} to update by this updater to the evaluation result.
     */
    @Override
    public void notify(OCLExpression expression, Collection<EObject> affectedContextObjects,
            OppositeEndFinder oppositeEndFinder, Notification change) {
        OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(oppositeEndFinder);
        for (EObject eo : affectedContextObjects) {
            Object newValue = ocl.evaluate(eo, expression);
            // only assign if result was not "invalid"
            if (ocl.getEnvironment().getOCLStandardLibrary().getInvalid() != newValue) {
                if (!getPropertyToUpdate().isMany() && newValue instanceof Collection) {
                    // pick first result if it exists or leave null
                    newValue = ((Collection<?>) newValue).isEmpty() ? null : ((Collection<?>) newValue).iterator()
                            .next();
                }
                try {
                    for (EObject elementToUpdate : getElementsToUpdate(eo)) {
                        elementToUpdate.eSet(getPropertyToUpdate(), newValue);
                    }
                } catch (ParserException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    protected static Helper createOCLHelper(String oclExpression, Template contextTemplate, 
            OppositeEndFinder oppositeEndFinder) throws ParserException {
        Helper result = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(oppositeEndFinder).createOCLHelper();
        EClass parsingContext = (EClass) ContextAndForeachHelper.getParsingContext(oclExpression,
                contextTemplate);
        result.setContext(parsingContext);
        return result;
    }

    /**
     * The OCL impact analyzer determines OCL context elements for which an expression of this model updater may have
     * changed its value. But those elements are not necessarily the same elements on which a property is to be updated
     * with the new evaluation result. Instead, if <code>#context</code> or <code>#foreach</code> were used in the OCL
     * expression, then the element produced by some superior <code>context</code> template or a superior template's
     * <code>foreach</code> element is the context element of the OCL expression, and the element to be updated has to
     * be determined from the textblocks model which represents a record of template executions and lets us determine
     * the element for which <code>#context</code> or <code>#foreach</code>, respectively, identifies the element
     * delivered as OCL context element by the impact analyzer.
     * <p>
     * 
     * This method uses the {@link #selfKind} enumeration to determine the strategy by which to find the element to
     * update. We distinguish the following cases:
     * 
     * <ul>
     * 
     * <li>{@link SelfKind#SELF}: <code>self</code> is the element to update</li>
     * 
     * <li>{@link SelfKind#CONTEXT}: <code>self</code> is the element referred to as <code>#context</code> in the
     * original OCL expression (before <code>#context</code> was replaced by <code>self</code>). From the
     * <code>self</code> element we can determine the {@link TextBlock} and from it the {@link ContextTemplate} that
     * created the element. The text blocks tree also tells us which production rules were triggered from there, using
     * the template in which the OCL-expression injector action resides. But this is only necessary, not a sufficient
     * criterion. We additionally have to check if for this innermost text block the
     * {@link TextBlock#getParentAltChoices()} indicate that along nested alternatives the one was used that actually
     * contains our {@link #getSequenceElement() sequence element}. See also
     * {@link TcsUtil#wasExecuted(ContextTemplate, org.eclipse.emf.common.util.EList, SequenceElement)}.</li>
     * 
     * <li>{@link SelfKind#FOREACH}: <code>self</code> is the element referred to as <code>#foreach</code> in the
     * original OCL expression, before <code>#foreach</code> was replaced by <code>self</code>. There must have been a
     * {@link ForEachContext} whose {@link ForEachContext#getContextElement()} contains <code>self</code>. Once we've
     * found this {@link ForEachContext}, we can fetch its {@link ForEachContext#getResultModelElement()}. This may be
     * the element to be updated, if its production was actually selected by the <code>when</code> clauses of the
     * <code>foreach</code> clause whose execution is described by the {@link ForEachContext}.</li>
     * 
     * </ul>
     * 
     * @param self
     *            the context for the OCL expression as identified by the OCL impact analyzer; for the straightforward
     *            case where {@link #selfKind} is {@link SelfKind#SELF}, this is at the same time the result of this
     *            method; otherwise, the <code>inTextBlock</code> argument is used to compute the result
     */
    protected Set<EObject> getElementsToUpdate(EObject self) throws ParserException {
        // Collection<TextBlock> inTextBlocks = getTextBlocksInChosenAlternativeForInjectorAction(injectorAction);
        switch (selfKind) {
        case SELF:
            return Collections.singleton(self);
        case CONTEXT:
            return getElementsToUpdateFromContextElement(self);
        case FOREACH:
            return getElementToUpdateFromForeachElement(self);
        default:
            throw new RuntimeException("Unknown self kind: "+selfKind);
        }
    }
    
    

    private Set<EObject> getElementToUpdateFromForeachElement(EObject self) throws ParserException {
        Set<EObject> result = new HashSet<EObject>();
        OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(getOppositeEndFinder());
        // The following call may return many objects because
        //  1) a single template may use multiple foreach predicates whose foreach expressions produce
        //     overlapping element sets
        //  2) a single foreach expression may even produce multiple occurrences of the same element, e.g., in a bag
        // Each result indicates one production of one new element. It may be possible that the same template
        // gets executed more than once for the same foreach-element. Therefore, also the same injector action
        // may get executed several times for the same #foreach element: once per invocation of its owning
        // template for the same #foreach element.
        Collection<EObject> foreachContextsUsingSelfAsForeachElement = getOppositeEndFinder()
                .navigateOppositePropertyWithBackwardScope(
                        TextblocksPackage.eINSTANCE.getForEachContext_ContextElement(), self);
        Helper oclHelper = ocl.createOCLHelper();
        for (EObject eo : foreachContextsUsingSelfAsForeachElement) {
            ForEachContext foreachContext = (ForEachContext) eo;
            ForeachPredicatePropertyInit propInit = foreachContext.getForeachPedicatePropertyInit();
            oclHelper.setContext(self.eClass());
            if (propInit.getPredicateSemantic().isEmpty()) {
                // no when-clause; foreach produces an element in all cases
                result.add(foreachContext.getResultModelElement());
            } else {
                // now check which when-clause is chosen for the current foreach-element self
                for (PredicateSemantic whenClause : propInit.getPredicateSemantic()) {
                    if (whenClause.getWhen() == null
                            || (Boolean) ocl.evaluate(self, oclHelper.createQuery(whenClause.getWhen()))) {
                        // now we know the when-clause; determine template for when-clause and check if
                        // it contains injectorAction
                        Template t = whenClause.getAs();
                        if (EcoreUtil.isAncestor(t, getSequenceElement())) {
                            // yes, the self object led to the injector action firing because
                            // we excluded #foreach being nested inside semantic predicates which
                            // would be the only way to create alternatives without concrete-syntactical
                            // disambiguation. Remember that templates called by foreach(...) must not
                            // make concrete-syntactical contributions.
                            result.add(foreachContext.getResultModelElement());
                            break; // continue with the next ForEachContext element
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * We know the {@link #getSequenceElement() sequence element} in which the OCL expression was used
     * that contains the <code>#context</code> sub-expression. We also know the <code>contextElement</code> and from it
     * can determine the {@link TextBlock} that documents the creation of the context element. From {@link #contextTag}
     * we know if/which context tag was used. We need to find a path of text blocks to a text block documenting
     * the execution of the template containing the {@link #getSequenceElement() sequence element} containing
     * the OCL expression.
     */
    private Set<EObject> getElementsToUpdateFromContextElement(EObject contextElement) {
        Set<EObject> result = new HashSet<EObject>();
        Set<TextBlock> textBlocks = getTextBlocksInWhichSequenceElementWasExecuted(contextElement, true);
        for (TextBlock tb : textBlocks) {
            result.add(tb.getCorrespondingModelElements().get(0));
        }
        return result;
    }

    /**
     * We know the {@link #getSequenceElement() sequence element} in which the OCL expression was used that contains the
     * <code>#context</code> sub-expression. We also know the <code>contextElement</code> and from it can determine the
     * {@link TextBlock} that documents the creation of the context element. From {@link #contextTag} we know if/which
     * context tag was used. We need to find a path of text blocks to a text block documenting the execution of the
     * template containing the {@link #getSequenceElement() sequence element} containing the OCL expression.
     * 
     * @param context
     *            pass <code>true</code> if <code>element</code> is not the element produced by the template in which
     *            the property is to update but if <code>#context</code> was used in the OCL expression, thus referring
     *            to the element produced by the next-outer {@link ContextTemplate}.
     */
    protected Set<TextBlock> getTextBlocksInWhichSequenceElementWasExecuted(EObject element, boolean context) {
        Set<TextBlock> textBlocks = new HashSet<TextBlock>();
        Collection<EObject> textBlockDocumentingCreationOfContextElement = getOppositeEndFinder()
        .navigateOppositePropertyWithBackwardScope(
                TextblocksPackage.eINSTANCE.getDocumentNode_CorrespondingModelElements(), element);
        for (EObject eo : textBlockDocumentingCreationOfContextElement) {
            if (eo instanceof TextBlock) {
                TextBlock textBlock = (TextBlock) eo;
                Template template = textBlock.getType().getParseRule();
                if (!context
                        || (template instanceof ContextTemplate
                                && ((ContextTemplate) template).getContextTags() != null && ((ContextTemplate) template)
                                .getContextTags().getTags().contains(contextTag))) {
                    // either no #context was used, or the contextTemplate has the expected tag (e.g., "context(X)" if the
                    // usage was "#context(X)")
                    Set<TextBlock> textBlocksForSubordinateExecutionsOfSequenceElementHoldingTheOCLExpression =
                        getSubordinateTextBlocksLeadingTo(textBlock, getSequenceElement().getParentTemplate());
                    for (TextBlock tb : textBlocksForSubordinateExecutionsOfSequenceElementHoldingTheOCLExpression) {
                        // add the first element from correspondingModelElements because that's the one
                        // actually immediately created by the template holding the sequence element with
                        // the OCL expression
                        if (!tb.getCorrespondingModelElements().isEmpty()
                                && TcsUtil.wasExecuted((ContextTemplate) tb.getType().getParseRule(),
                                        tb.getParentAltChoices(), getSequenceElement())) {
                            textBlocks.add(tb);
                        }
                    }
                }
            }
        }
        return textBlocks;
    }

    protected Set<TextBlock> getSubordinateTextBlocksLeadingTo(TextBlock textBlock, Template templateHoldingSequenceElement) {
        if (textBlock.getType().getParseRule() == templateHoldingSequenceElement) {
            return Collections.singleton(textBlock);
        } else {
            Set<TextBlock> result = new HashSet<TextBlock>();
            for (TextBlock subBlock : textBlock.getSubBlocks()) {
                result.addAll(getSubordinateTextBlocksLeadingTo(subBlock, templateHoldingSequenceElement));
            }
            return result;
        }
    }

    /**
     * Tells the {@link SequenceElement} (e.g., an {@link InjectorActionsBlock} or a {@link Property})
     * from which this updater was created.
     */
    protected abstract SequenceElement getSequenceElement();

    /**
     * Determines which object will be used as <tt>self</tt> in evaluating the
     * OCL expression. Can either be a {@link ModelElementProxy proxy} or a
     * {@link RefObject}. If the OCL expression uses <tt>#context</tt>, the
     * {@link #getContextElement() context element} is used; otherwise the
     * {@link #getModelElement()} call is used.
     */
    protected static SelfKind determineSelfKind(String oclExpression) {
        if (ContextAndForeachHelper.usesContext(oclExpression)) {
            return SelfKind.CONTEXT;
        } else if (ContextAndForeachHelper.usesForeach(oclExpression)) {
            return SelfKind.FOREACH;
        } else {
            return SelfKind.SELF;
        }
    }

}
