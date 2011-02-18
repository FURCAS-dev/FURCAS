package com.sap.furcas.runtime.referenceresolving;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzer;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzerFactory;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluator;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluatorFactory;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;

import com.sap.emf.ocl.trigger.AbstractTriggerable;
import com.sap.emf.ocl.trigger.ExpressionWithContext;
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.common.interfaces.IRuleName;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;
import com.sap.furcas.runtime.parser.IParsingObserver;
import com.sap.furcas.runtime.parser.ModelElementCreationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.DelegationParsingObserver;
import com.sap.furcas.runtime.parser.impl.ForeachParsingObserver;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.textblocks.TbParsingUtil;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.ide.cts.parser.incremental.ParserFactory;

/**
 * Updates a model element property by evaluating a so-called <code>foreach</code> OCL expression. Based on the
 * evaluation result, a certain number of elements of a certain type is created and assigned to the property. Of which
 * types those elements are and how may there will be created depends on the parameterization of the updater.
 * <p>
 * 
 * If no further specifications are provided, for each evaluation result one element of corresponding type is created
 * using the respective template with empty (default) mode.
 * <p>
 * 
 * A <code>mode</code> argument may be provided, determining the template mode to use when creating elements. The
 * template resulting from this specification is stored in {@link PredicateSemantic#getAs()}.
 * <p>
 * 
 * If a sequence of <code>when/as/mode</code> combinations is provided, each element from the evaluation result is used
 * as context to evaluate the <code>when</code> clauses. The <code>as</code> template of the first one evaluating to
 * <code>true</code> is used to create the element. The mode specification is already factored into the template stored
 * in the {@link PredicateSemantic#getAs()} result. The <code>when</code> clause is optional. If not specified, all
 * elements match. This is useful when used as the last rule in a sequence, as a default rule, used if no other
 * <code>when</code> clause matches and is considered accordingly here.
 * <p>
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class ForeachPropertyInitUpdater extends AbstractFurcasOCLBasedModelUpdater {
    /**
     * Used to override {@link AbstractTriggerable#getTriggerExpressionsWithContext()}
     */
    private final Collection<ExpressionWithContext> triggerExpressionsWithContext;

    /**
     * The base expression "X" used in the <code>foreach(X ...)</code> property init
     */
    private final OCLExpression baseForeachExpression;

    /**
     * Enables mapping the OCL expressions used in the <code>when</code> clauses of the <code>foreach</code> predicate
     * to the {@link PredicateSemantic} objects representing the respective <code>when</code> clause
     */
    private final Map<OCLExpression, PredicateSemantic> expressionToWhenClause;

    private final ForeachPredicatePropertyInit foreachPredicatePropertyInit;

    private ImpactAnalyzer impactAnalyzerForBaseExpression;

    private final ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;

    protected ForeachPropertyInitUpdater(ForeachPredicatePropertyInit foreachPredicatePropertyInit,
            EPackage.Registry metamodelPackageRegistry,
            ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory,
            OppositeEndFinder oppositeEndFinder) throws ParserException {
        super(foreachPredicatePropertyInit.getPropertyReference().getStrucfeature(), metamodelPackageRegistry,
                oppositeEndFinder,
                /* expression with context; provided later in getTriggerExpressionsWithContext() */null,
                /* notifyNewContextElements */true, determineSelfKind(foreachPredicatePropertyInit.getValue()),
                ContextAndForeachHelper.getContextTag(foreachPredicatePropertyInit.getValue()));
        this.parserFactory = parserFactory;
        triggerExpressionsWithContext = new LinkedList<ExpressionWithContext>();
        this.foreachPredicatePropertyInit = foreachPredicatePropertyInit;
        Helper oclHelper = createOCLHelper();
        // add the base foreach expression:
        baseForeachExpression = oclHelper.createQuery(ContextAndForeachHelper
                .prepareOclQuery(foreachPredicatePropertyInit.getValue()));
        triggerExpressionsWithContext.add(new ExpressionWithContext(baseForeachExpression,
                (EClass) ContextAndForeachHelper.getParsingContext(foreachPredicatePropertyInit.getValue(),
                        ((InjectorActionsBlock) foreachPredicatePropertyInit.eContainer()).getParentTemplate())));
        if (this.foreachPredicatePropertyInit.getPredicateSemantic().isEmpty()) {
            expressionToWhenClause = Collections.emptyMap();
        } else {
            expressionToWhenClause = new HashMap<OCLExpression, PredicateSemantic>();
        }
        EClassifier baseType = baseForeachExpression.getType();
        if (baseType instanceof CollectionType) {
            baseType = ((CollectionType) baseType).getElementType();
        }
        oclHelper.setContext(baseType);
        for (PredicateSemantic whenClause : foreachPredicatePropertyInit.getPredicateSemantic()) {
            if (whenClause.getWhen() != null) {
                OCLExpression whenClausExpression = oclHelper.createQuery(whenClause.getWhen());
                expressionToWhenClause.put(whenClausExpression, whenClause);
                triggerExpressionsWithContext.add(new ExpressionWithContext(whenClausExpression,
                        (EClass) baseType));
            }
        }
    }

    private Helper createOCLHelper() throws ParserException {
        return createOCLHelper(foreachPredicatePropertyInit.getValue(),
                ((InjectorActionsBlock) foreachPredicatePropertyInit.eContainer()).getParentTemplate(),
                getOppositeEndFinder());
    }

    @Override
    public void notify(OCLExpression expression, Collection<EObject> affectedContextObjects,
            OppositeEndFinder oppositeEndFinder, Notification change) {
        if (expression == baseForeachExpression) {
            handleChangeOfBaseExpressionValue(affectedContextObjects, change);
        } else {
            PredicateSemantic whenClause = expressionToWhenClause.get(expression);
            if (whenClause != null) {
                handleChangeOfWhenClauseValue(whenClause, affectedContextObjects, change);
            }
        }
    }

    private void handleChangeOfBaseExpressionValue(Collection<EObject> affectedContextObjects, Notification change) {
        // the base expression changed; see what changed:
        PartialEvaluator partialEvaluator = PartialEvaluatorFactory.INSTANCE.createPartialEvaluator(change,
                getOppositeEndFinder(), OCLFactory.INSTANCE);
        OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(getOppositeEndFinder());
        for (EObject affectedContextObject : affectedContextObjects) {
            Object oldValue = partialEvaluator.evaluate(affectedContextObject, baseForeachExpression);
            Object newValue = ocl.evaluate(affectedContextObject, baseForeachExpression);
            if (oldValue != newValue && (oldValue == null || !oldValue.equals(newValue))) {
                // something changed
                // TODO sophisticated solution: find out what was removed and what was added from the result of the
                // foreach expression and which elements changed
                // Then we could try to selectively remove elements from the target feature.
                try {
                    // the getElementsToUpdate(affectedContextObject) is necessary because the foreach
                    // base expression may itself use #context or #foreach
                    updateFeature(getElementsToUpdate(affectedContextObject), newValue);
                } catch (ParserException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * The <code>change</code> event may have affected the value of the <code>whenClause</code>. The same change may
     * have had other effects as well, e.g., on the other <code>when</code>-clauses of the same <code>foreach</code>
     * construct.
     * <p>
     * 
     * The elements for which the <code>when</code>-clause value has changed may or may not have been results of a
     * <code>foreach</code> clause. To find this out, the impact analyzer can trace back the candidate object through
     * the <code>foreach</code> expression and see if there is a {@link TextBlock} documenting the execution of the
     * <code>foreach</code> clause for the respective element. If not, the change is simply ignored. If yes, and if the
     * <code>foreach</code> expression actually evaluates to the affected context object from
     * <code>affectedContextObjects</code>, the production of the corresponding result is triggered and the resulting
     * element is used to replace the old element from the {@link #getPropertyToUpdate() feature to update}.
     * 
     * @param whenClause
     *            the <code>when</code>-clause whose value may have changed due to <code>change</code>
     * @param affectedContextObjects
     *            the superset of the context objects for which the <code>when</code>-clause may have changed its value
     * @param change
     *            the original change that may have caused a change in <code>whenClause</code>'s value when evaluated on
     *            <code>affectedContextObjects</code>
     */
    private void handleChangeOfWhenClauseValue(PredicateSemantic whenClause,
            Collection<EObject> affectedContextObjects, Notification change) {
        // The context element of the when-clause is the result of the corresponding foreach element.
        // We need to use the impact analyzer to trace this back to the foreach "self" context and repeat
        // this as if the foreach expression itself had changed.
        // We assume here that no #context nor #foreach is used in the when-clause.
        // It wouldn't make much sense anyway because the when-clause should filter the foreach result.

        // TODO ImpactAnalyzer would need to make available barebones traceback functionality
        // We don't have a Notification, and we don't necessarily have a property change.
        // We only want to compute traceback(affectedContextObject) which then gives us those elements
        // for which the foreach base expression evaluates to affectedContextObject and hence
        // gives us the decisive clue on which element to update the property.
        ImpactAnalyzer ia = getImpactAnalyzerForBaseExpression();

        ia.toString(); // TODO remove this dummy usage again when I continue here...
        System.err.println("TODO Impact Analysis for when clause not yet active: " + whenClause.getWhen());
    }

    private ImpactAnalyzer getImpactAnalyzerForBaseExpression() {
        // TODO fetch the existing impact analyzer for the base expression created by the superclass
        if (impactAnalyzerForBaseExpression == null) {
            impactAnalyzerForBaseExpression = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(
                    baseForeachExpression, /* notifyOnNewContextElements */false, getOppositeEndFinder(),
                    OCLFactory.INSTANCE);
        }
        return impactAnalyzerForBaseExpression;
    }

    /**
     * Receives the current value of the foreach base expression and the elements on which to update the feature
     * indicated by {@link #foreachPredicatePropertyInit}.{@link ForeachPredicatePropertyInit#getPropertyReference()
     * getPropertyReference()}. {@link PropertyReference#getStrucfeature() getStrucfeature()}.
     * <p>
     * 
     * TODO The current implementation replaces all elements in the feature for each element in
     * <code>elementToUpdate</code>. Future implementations will be more sophisticated and make an effort to replace
     * only those elements that need replacement, particularly because they have to be produced by a different template
     * than before.
     * <p>
     * 
     * With the current coarse-grained replacement strategy, all {@link ForEachContext} elements attached to the
     * {@link TextBlock} documenting the creation of each of the <code>elementsToUpdate</code> are removed first. Then,
     * the new elements are produced using {@link #produceElement(Object, TextBlock, ResourceSet, OppositeEndFinder)}
     * operation. As a record of this, a new {@link ForEachContext} element is created for each object creation. They
     * are attached to the {@link TextBlock#getForEachContext()} collection of the text blocks documenting the creation
     * of the <code>elementsToUpdate</code>.
     */
    private void updateFeature(Set<EObject> elementsToUpdate, Object newValueOfForeachBaseExpression) {
        Collection<?> foreachElements;
        if (newValueOfForeachBaseExpression instanceof Collection<?>) {
            foreachElements = (Collection<?>) newValueOfForeachBaseExpression;
        } else {
            foreachElements = Collections.singleton(newValueOfForeachBaseExpression);
        }
        for (EObject elementToUpdate : elementsToUpdate) {
            // update the element only if a TextBlock documents its creation and indicates that the
            // InjectorActionsBlock containing the foreachPredicatePropertyInit has actually been executed
            // during its creation
            Collection<EObject> textBlocks = getOppositeEndFinder().navigateOppositePropertyWithBackwardScope(
                    TextblocksPackage.eINSTANCE.getDocumentNode_CorrespondingModelElements(), elementToUpdate);
            if (textBlocks != null && !textBlocks.isEmpty()) {
                // TODO can it happen that the same element is represented in multiple syntaxes using the same foreach predicate?
                TextBlock textBlock = (TextBlock) textBlocks.iterator().next();
                if (foreachWasExecutedFor(textBlock)) {
                    // TODO this would be the place where to identify changes and carefully replace/remove/add only single elements
                    Collection<Object> newFeatureValue = new BasicEList<Object>();
                    for (Object foreachElement : foreachElements) {
                        EObject producedElement = produceElement(foreachElement, textBlock, elementToUpdate,
                                getOppositeEndFinder());
                        if (!(foreachPredicatePropertyInit.getPropertyReference().getStrucfeature() instanceof EReference)
                                || !((EReference) foreachPredicatePropertyInit.getPropertyReference().getStrucfeature())
                                        .isContainment()) {
                            // assign to elementToUpdate's Resource as a default, in case it's not added to a
                            // containment reference
                            elementToUpdate.eResource().getContents().add(producedElement);
                        }
                        newFeatureValue.add(producedElement);
                    }
                    if (foreachPredicatePropertyInit.getPropertyReference().getStrucfeature().isMany()) {
                        elementToUpdate.eSet(foreachPredicatePropertyInit.getPropertyReference().getStrucfeature(),
                                newFeatureValue);
                    } else {
                        if (newFeatureValue.isEmpty()) {
                            elementToUpdate.eSet(foreachPredicatePropertyInit.getPropertyReference().getStrucfeature(),
                                    null);
                        } else {
                            elementToUpdate.eSet(foreachPredicatePropertyInit.getPropertyReference().getStrucfeature(),
                                    newFeatureValue.iterator().next()); // pick first element
                        }
                    }
                }
            }
        }
    }

    private void addForeachContext(TextBlock textBlock, Object foreachElement, EObject elementToUpdate,
            EObject producedElement) {
        ForEachContext foreachContext = createForeachContext(elementToUpdate, foreachElement, producedElement);
        textBlock.getForEachContext().add(foreachContext);
    }

    private void deleteObsoleteForeachContexts(TextBlock textBlock, Object foreachElement) {
        // delete now obsolete ForEachContext elements
        for (Iterator<ForEachContext> existingForeachContextIterator = textBlock.getForEachContext().iterator(); existingForeachContextIterator
                .hasNext();) {
            ForEachContext existingForeachContext = existingForeachContextIterator.next();
            if (existingForeachContext.getForeachPedicatePropertyInit() == foreachPredicatePropertyInit
                    && existingForeachContext.getContextElement() == foreachElement) {
                existingForeachContextIterator.remove();
            }
        }
    }

    private ForEachContext createForeachContext(EObject elementToUpdate, Object foreachElement, EObject producedElement) {
        // create ForEachContext element documenting what just happened in the TextBlocks model
        ForEachContext foreachContext = TextblocksFactory.eINSTANCE.createForEachContext();
        foreachContext.setForeachPedicatePropertyInit(foreachPredicatePropertyInit);
        foreachContext.setSourceModelElement(elementToUpdate);
        // TODO this cast is probably not safe, particularly if the foreach base expression return an non-EObject type
        // such as Boolean or Integer or String
        foreachContext.setContextElement((EObject) foreachElement);
        foreachContext.setResultModelElement(producedElement);
        return foreachContext;
    }

    /**
     * Tries to find the execution of {@link #foreachPredicatePropertyInit}.
     * {@link ForeachPredicatePropertyInit#getInjectorActionsBlock() getInjectorActionsBlock()} documented inside
     * <code>textBlock</code>.
     */
    private boolean foreachWasExecutedFor(TextBlock textBlock) {
        return TcsUtil.wasExecuted((ContextTemplate) textBlock.getType().getParseRule(),
                textBlock.getParentAltChoices(), getSequenceElement());
    }

    private EObject produceElement(Object foreachElement, TextBlock textBlock, EObject elementToUpdate,
            OppositeEndFinder oppositeEndFinder) {
        Template template = null; // null means "don't produce"
        if (foreachElement instanceof Boolean) {
            if ((Boolean) foreachElement) {
                template = foreachPredicatePropertyInit.getPredicateSemantic().iterator().next().getAs();
            }
        } else if (foreachElement instanceof EObject) {
            template = findTemplate((EObject) foreachElement);
        } else {
            // for other non-EObject, non-Boolean types produce using the template of the single when/as
            template = foreachPredicatePropertyInit.getPredicateSemantic().iterator().next().getAs();
        }
        EObject result = null;
        if (template != null) {
            result = produceWith(template, foreachElement, textBlock, elementToUpdate, oppositeEndFinder);
        }
        return result;
    }

    /**
     * Executes the <code>template</code>'s parse rule. The
     * {@link ObservableInjectingParser#setCurrentForeachElement(Object) foreach element} on the parser can easily be
     * set to <code>foreachElement</code>. Tricky is establishing the #context stack.
     * 
     * @return the element produced
     */
    private EObject produceWith(Template template, Object foreachElement, TextBlock textBlock, EObject elementToUpdate,
            OppositeEndFinder oppositeEndFinder) {
        IRuleName ruleNameFinder = parserFactory.getRuleNameFinder();
        String mode = null;
        try {
            String ruleName = ruleNameFinder.getRuleName(template, mode);
            Lexer lexer = parserFactory.createLexer(new ANTLRStringStream(getRootBlock(textBlock).getCachedString()));
            ObservableInjectingParser parser = parserFactory.createParser(new CommonTokenStream(lexer), elementToUpdate
                    .eResource().getResourceSet());
            DelegationParsingObserver delegator = new DelegationParsingObserver();
            IParsingObserver originalObserver = parser.getObserver();
            if (originalObserver != null) {
                delegator.addParsingObserver(originalObserver);
            }
            delegator.addParsingObserver(new ForeachParsingObserver(textBlock));
            parser.setObserver(delegator);
            // invoke the parser to execute the template
            Method methodToCall = parser.getClass().getMethod(ruleName);
            // parser.reset();
            if (!Modifier.isFinal(methodToCall.getModifiers())) {
                throw new UnknownProductionRuleException(ruleName + " is not a production rule in generated Parser.");
            }
            parser.setCurrentForeachElement(foreachElement);
            TbParsingUtil.constructContext(textBlock, parser);
            deleteObsoleteForeachContexts(textBlock, foreachElement); // must be deleted AFTER ContextBuilder was
                                                                      // constructed because it requires the
                                                                      // ForEachContext elements
            EObject parseReturn = (EObject) methodToCall.invoke(parser);
            if (parseReturn == null) {
                throw new ModelElementCreationException("Unable to create model element using parse rule " + ruleName
                        + ". Parse errors: " + parser.getInjector().getErrorList());
            }
            parser.setDelayedReferencesAfterParsing(); // TODO instead of using DelayedReference stuff, migrate to model updaters
            addForeachContext(textBlock, foreachElement, elementToUpdate, parseReturn);
            return parseReturn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private TextBlock getRootBlock(TextBlock textBlock) {
        TextBlock result = textBlock;
        while (result.eContainer() != null && result.eContainer() instanceof TextBlock) {
            result = (TextBlock) result.eContainer();
        }
        return result;
    }

    /**
     * Determines for an {@link EObject} result of the foreach base expression which template to use to produce the
     * element. If there is no {@link PredicateSemantic} associated, use the <code>foreachElement</code>'s type and the
     * {@link ForeachPredicatePropertyInit#getMode() global mode} to decide which template to use (using
     * {@link TcsUtil#getTemplateMode(Template)}). If no template is found, a {@link RuntimeException} is thrown.
     */
    private Template findTemplate(EObject foreachElement) {
        Template result = null;
        if (foreachPredicatePropertyInit.getPredicateSemantic().isEmpty()) {
            String mode = foreachPredicatePropertyInit.getMode();
            result = TcsUtil.findTemplate(foreachElement.eClass(), mode, /* TODO partition scope */null);
        } else {
            OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(getOppositeEndFinder());
            Helper oclHelper = ocl.createOCLHelper();
            oclHelper.setContext(foreachElement.eClass());
            for (PredicateSemantic whenClause : foreachPredicatePropertyInit.getPredicateSemantic()) {
                if (whenClause.getWhen() != null) {
                    OCLExpression when;
                    // TODO this try/catch will probably disappear when we're compiling the OCL ASTs into the FURCAS
                    // mapping
                    try {
                        when = oclHelper.createQuery(whenClause.getWhen());
                    } catch (ParserException e) {
                        throw new RuntimeException(e);
                    }
                    Boolean match = (Boolean) ocl.evaluate(foreachElement, when);
                    if (match) {
                        result = whenClause.getAs();
                        break;
                    }
                } else {
                    // no when clause means a match
                    result = whenClause.getAs();
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Collection<ExpressionWithContext> getTriggerExpressionsWithContext() {
        return triggerExpressionsWithContext;
    }

    @Override
    protected SequenceElement getSequenceElement() {
        return foreachPredicatePropertyInit.getInjectorActionsBlock();
    }

}
