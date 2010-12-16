package com.sap.furcas.runtime.referenceresolving;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

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
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;
import com.sap.furcas.runtime.parser.impl.ModelElementProxy;
import com.sap.furcas.runtime.textblocks.TbUtil;


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

    /**
     * This default implementation re-evaluates the {@link #triggerExpression} on each element reported as affected and
     * sets the {@link #getPropertyToUpdate() property} to update by this updater to the evaluation result.
     */
    @Override
    public void notify(OCLExpression expression, Collection<EObject> affectedContextObjects,
            OppositeEndFinder oppositeEndFinder) {
        OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(oppositeEndFinder);
        // TODO use prepared expression and parameterize based on token value taken from text blocks model
        for (EObject eo : affectedContextObjects) {
            Object newValue = ocl.evaluate(eo, expression);
            // only assign if result was not "invalid"
            if (ocl.getEnvironment().getOCLStandardLibrary().getInvalid() != newValue) {
                if (!getPropertyToUpdate().isMany() && newValue instanceof Collection) {
                    // pick first result if it exists or leave null
                    newValue = ((Collection<?>) newValue).isEmpty() ? null : ((Collection<?>) newValue).iterator()
                            .next();
                }
                EObject elementToUpdate = getElementToUpdate(eo);
                if (elementToUpdate != null) {
                    elementToUpdate.eSet(getPropertyToUpdate(), newValue);
                }
            }
        }
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
            }
            Collection<EObject> additionalTextBlockCandidates = getOppositeEndFinder()
                    .navigateOppositePropertyWithBackwardScope(
                            TextblocksPackage.eINSTANCE.getTextBlock_AdditionalTemplates(), template);
            for (EObject textBlock : additionalTextBlockCandidates) {
                result.add((TextBlock) textBlock);
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
                    // check if injector action was in chosen alternative or
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
     * <li>{@link SelfKind#SELF}: <code>self</code> is the element to update</li>
     * <li>{@link SelfKind#CONTEXT}: <code>self</code> is the element referred to as <code>#context</code> in the
     * original OCL expression (before <code>#context</code> was replaced by <code>self</code>). From the
     * <code>inTextBlock</code> we can TODO</li>
     * <li>{@link SelfKind#FOREACH}: <code>self</code> is the element referred to as <code>#foreach</code> in the
     * original OCL expression, before <code>#foreach</code> was replaced by <code>self</code>. There must have been a
     * {@link ForEachContext} whose {@link ForEachContext#getContextElement()} contains <code>self</code>. Once we've
     * found this {@link ForEachContext}, we can fetch its {@link ForEachContext#getResultModelElement()}. This may be
     * the element to be updated, if its production was actually selected by the <code>when</code> clauses of the
     * <code>foreach</code> clause whose execution is described by the {@link ForEachContext}.</ul>
     * 
     * @param self
     *            the context for the OCL expression as identified by the OCL impact analyzer; for the straightforward
     *            case where {@link #selfKind} is {@link SelfKind#SELF}, this is at the same time the result of this
     *            method; otherwise, the <code>inTextBlock</code> argument is used to compute the result
     * @param inTextBlock
     *            needed for the cases where {@link #selfKind} is either {@link SelfKind#CONTEXT} or
     *            {@link SelfKind#FOREACH}. In the case of {@link SelfKind#CONTEXT}, a context stack is constructed
     *            starting at this text block, moving "up" the text blocks / template execution hierarchy.
     */
    protected EObject getElementToUpdate(EObject self) {
        // Collection<TextBlock> inTextBlocks = getTextBlocksInChosenAlternativeForInjectorAction(injectorAction);
        switch (selfKind) {
        case SELF:
            return self;
        case CONTEXT:
            return getElementToUpdateFromContextElement(self);
        case FOREACH:
            return getElementToUpdateFromForeachElement(self);
        default:
            throw new RuntimeException("Unknown self kind: "+selfKind);
        }
    }

    private EObject getElementToUpdateFromForeachElement(EObject self) {
        OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(getOppositeEndFinder());
        Collection<EObject> foreachContextsUsingSelfAsForeachElement = getOppositeEndFinder()
                .navigateOppositePropertyWithBackwardScope(
                        TextblocksPackage.eINSTANCE.getForEachContext_ContextElement(), self);
        for (EObject eo : foreachContextsUsingSelfAsForeachElement) {
            ForEachContext foreachContext = (ForEachContext) eo;
            ForeachPredicatePropertyInit propInit = foreachContext.getForeachPedicatePropertyInit();
            // now check which when-clause is chosen for the current foreach-element self
            for (PredicateSemantic whenClause : propInit.getPredicateSemantic()) {
                OCLExpression whenExpression = whenClause.getWhen();
                if (whenExpression == null || (Boolean) ocl.evaluate(self, whenExpression)) {
                    // now we know the when-clause; determine template for when-clause and check if
                    // it contains injectorAction
                    Template t = whenClause.getAs();
                    if (EcoreUtil.isAncestor(t, getSequenceElement())) {
                        // yes, the self object led to the injector action firing
                        return foreachContext.getResultModelElement();
                    }
                }
            }
        }
        return null;
    }

    /**
     * We know the {@link #getSequenceElement() sequence element} in which the OCL expression was used
     * that contains the <code>#context</code> sub-expression. We also know the <code>contextElement</code> and from it
     * can determine the {@link TextBlock} that documents the creation of the context element. From {@link #contextTag}
     * we know if/which context tag was used. We need to find a path of text blocks to a text block documenting
     * the execution of the template containing the {@link #getSequenceElement() sequence element} containing
     * the OCL expression.
     */
    private EObject getElementToUpdateFromContextElement(EObject contextElement) {
        // LocalContextBuilder contextBuilder = new LocalContextBuilder();
        // TbParsingUtil.constructContext(inTextBlock, contextBuilder);
        /* TODO really use */ contextTag.length();
        return null; // FIXME need to port LocalContextBuilder to retrieve context from regularSelf and template
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
    protected static SelfKind getSelfKind(String oclExpression) {
        if (ContextAndForeachHelper.usesContext(oclExpression)) {
            return SelfKind.CONTEXT;
        } else if (ContextAndForeachHelper.usesForeach(oclExpression)) {
            return SelfKind.FOREACH;
        } else {
            return SelfKind.SELF;
        }
    }

}
