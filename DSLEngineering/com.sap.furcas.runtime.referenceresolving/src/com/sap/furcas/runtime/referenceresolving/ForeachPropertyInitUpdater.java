package com.sap.furcas.runtime.referenceresolving;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
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
import com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.modeladaptation.emf.lookup.QueryBasedEcoreMetaModelLookUp;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.common.util.FileResourceHelper;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.IParsingObserver;
import com.sap.furcas.runtime.parser.ModelElementCreationException;
import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandlerBaseImpl;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.furcas.runtime.parser.impl.DelegationParsingObserver;
import com.sap.furcas.runtime.parser.impl.ForeachParsingObserver;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.textblocks.TbParsingUtil;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;

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

    private final ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;
    
    private final ImpactAnalyzer impactAnalyzerForTracebackOfBaseExpression;

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
        impactAnalyzerForTracebackOfBaseExpression = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(baseForeachExpression,
                /* notifyOnNewContextElements */ false, oppositeEndFinder, OCLFactory.getInstance());
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
        PartialEvaluator partialEvaluator = PartialEvaluatorFactory.INSTANCE.createPartialEvaluator(change,
                getOppositeEndFinder(), OCLFactory.getInstance());
        OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(getOppositeEndFinder());
        for (EObject affectedContextObject : affectedContextObjects) {
            Object oldValue = partialEvaluator.evaluate(affectedContextObject, baseForeachExpression);
            Object newValue = ocl.evaluate(affectedContextObject, baseForeachExpression);
            if (oldValue != newValue && (oldValue == null || !oldValue.equals(newValue))) {
                // something changed
                // the getElementsToUpdate(affectedContextObject) is necessary because the foreach
                // base expression may itself use #context or #foreach
                updateFeature(getElementsToUpdate(affectedContextObject), newValue);
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
        for (EObject affectedContextObject : affectedContextObjects) {
            Template newTemplateToUse = findTemplate(affectedContextObject);
            // First try to see if a previous ForEachExecution is documented:
            Collection<EObject> foreachExecutionsUsingSelfAsForeachElement = getOppositeEndFinder()
                    .navigateOppositePropertyWithBackwardScope(
                            TextblocksPackage.eINSTANCE.getForEachExecution_ContextElement(), affectedContextObject);
            if (foreachExecutionsUsingSelfAsForeachElement != null && !foreachExecutionsUsingSelfAsForeachElement.isEmpty()) {
                for (EObject eo : foreachExecutionsUsingSelfAsForeachElement) {
                    if (eo.eContainer() != null) { // ignore stale ForEachContext that for unknown reasons are still
                                                   // returned by opposite end finder
                        ForEachExecution foreachExecution = (ForEachExecution) eo;
                        EObject elementToUpdate = foreachExecution.getSourceModelElement();
                        TextBlock textBlock = (TextBlock) foreachExecution.eContainer();
                        ForeachPredicatePropertyInit propInit = foreachExecution.getForeachPedicatePropertyInit();
                        if (propInit == foreachPredicatePropertyInit) {
                            Template oldTemplateUsedForProduction = foreachExecution.getTemplateUsedForProduction();
                            // check if the template to use for producing really changed; if so, execute the one
                            // production rule and carefully update the existing ForEachExecution
                            if (newTemplateToUse != oldTemplateUsedForProduction) {
                                if (newTemplateToUse == null) {
                                    // remove element and ForEachExecution record
                                    @SuppressWarnings("unchecked")
                                    List<EObject> l = (List<EObject>) elementToUpdate.eGet(getPropertyToUpdate());
                                    l.remove(foreachExecution.getResultModelElement());
                                    TbChangeUtil.delete(foreachExecution);
                                } else {
                                    // the supposed change really led to a change in production rule; produce anew
                                    EObject newObject = produceWith(newTemplateToUse, affectedContextObject, textBlock,
                                            elementToUpdate, getOppositeEndFinder());
                                    if (getPropertyToUpdate().isMany()) {
                                        int position = textBlock.getForEachExecutions().indexOf(foreachExecution);
                                        @SuppressWarnings("unchecked")
                                        List<EObject> l = (List<EObject>) elementToUpdate.eGet(getPropertyToUpdate());
                                        l.set(position, newObject);
                                    } else {
                                        elementToUpdate.eSet(getPropertyToUpdate(), newObject);
                                    }
                                    foreachExecution.setResultModelElement(newObject);
                                }
                            }
                        }
                    }
                }
            } else {
                // Perhaps the foreach element changed from no matching when-clause to at least one
                // matching when-clause because no ForEachExecution exists for the presumed foreach-element so far.
                // The affectedContextObject is likely the foreach result. Trace back through the foreach
                // expression to find out which the elements-to-update are and check if the foreach
                // property init actually got executed for the element-to-update.
                Collection<EObject> foreachBaseExpressionContexts = impactAnalyzerForTracebackOfBaseExpression
                        .getContextObjects(affectedContextObject);
                for (EObject foreachBaseExpressionContext : foreachBaseExpressionContexts) {
                    Collection<EObject> textBlocks = getOppositeEndFinder().navigateOppositePropertyWithBackwardScope(
                            TextblocksPackage.eINSTANCE.getTextBlock_CorrespondingModelElements(),
                            foreachBaseExpressionContext);
                    TextBlock textBlock = (TextBlock) textBlocks.iterator().next();
                    if (foreachWasExecutedFor(textBlock)) {
                        // resolve through use of #context / #foreach in base expression to find true element to update
                        try {
                            Set<EObject> elementsToUpdate = getElementsToUpdate(foreachBaseExpressionContext);
                            for (EObject elementToUpdate : elementsToUpdate) {
                                // if the result of the when-clauses is that there's still nothing to produce,
                                // then nothing needs to be done
                                if (newTemplateToUse != null) {
                                    // the supposed change really led to a change in production rule; produce anew
                                    EObject newObject = produceWith(newTemplateToUse, affectedContextObject, textBlock,
                                            elementToUpdate, getOppositeEndFinder());
                                    int position;
                                    if (getPropertyToUpdate().isMany()) {
                                        Object foreachBaseExpressionResult = createOCLHelper().getOCL().evaluate(
                                                foreachBaseExpressionContext, baseForeachExpression);
                                        @SuppressWarnings("unchecked")
                                        List<EObject> l = (List<EObject>) elementToUpdate.eGet(getPropertyToUpdate());
                                        if (foreachBaseExpressionResult instanceof List<?>) {
                                            position = ((List<?>) foreachBaseExpressionResult).indexOf(affectedContextObject);
                                        } else {
                                            // no list or not even a collection; append at end
                                            position = l.size();
                                        }
                                        l.add(position, newObject);
                                    } else {
                                        elementToUpdate.eSet(getPropertyToUpdate(), newObject);
                                        position = 0;
                                    }
                                    ForEachExecution foreachExecution = createForeachExecution(elementToUpdate,
                                            affectedContextObject, newObject, newTemplateToUse);
                                    textBlock.getForEachExecutions().add(position, foreachExecution);
                                }
                            }
                        } catch (ParserException e) {
                            // TODO this try/catch block will probably disappear when no OCL parsing is necessary in
                            // getElementsToUpdate
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        }
    }

    /**
     * Receives the current value of the foreach base expression and the elements on which to update the feature
     * indicated by {@link #foreachPredicatePropertyInit}.{@link ForeachPredicatePropertyInit#getPropertyReference()
     * getPropertyReference()}. {@link PropertyReference#getStrucfeature() getStrucfeature()}.
     * <p>
     * 
     * With the current coarse-grained replacement strategy, all {@link ForEachExecution} elements attached to the
     * {@link TextBlock} documenting the creation of each of the <code>elementsToUpdate</code> are removed first. Then,
     * the new elements are produced using {@link #produceElement(Object, TextBlock, ResourceSet, OppositeEndFinder)}
     * operation. As a record of this, a new {@link ForEachExecution} element is created for each object creation. They
     * are attached to the {@link TextBlock#getForEachExecutions()} collection of the text blocks documenting the creation
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
            // during its creation.
            // We assume that the when-clauses and their evaluation results haven't changed for those
            // elements to which foreach element production already applied. Such changes are handled
            // by the impact analyzer for the when-clause expressions.
            // We loop over the ForEachExecution elements attached to the TextBlock that documents
            // the creation of elementToUpdate, filtering for those that are for foreachPredicatePropertyInit
            // and having elementToUpdate as their source element (could be different in case of
            // nested foreach templates). Existing ForEachExecution objects are updated; new elements
            // are produced if the template of the foreach-element differ. Existing ForEachExecution
            // objects can be updated with newly-produced objects. If the ForEachExecution list is
            // preempted before all elements have been produced, new ForEachExecution elements are
            // appended to the text block. If there are trailing not re-used ForEachExecution elements,
            // they are deleted.

            // from the following ForEachExecution elements select the sub-sequence for which all elements
            // refer to the foreachPredicatePropertyInit
            Collection<EObject> textBlocks = getOppositeEndFinder().navigateOppositePropertyWithBackwardScope(
                    TextblocksPackage.eINSTANCE.getTextBlock_CorrespondingModelElements(), elementToUpdate);
            TextBlock textBlock = (TextBlock) textBlocks.iterator().next();
            if (foreachWasExecutedFor(textBlock)) {
                Iterator<ForEachExecution> foreachExecutionsIterator = textBlock.getForEachExecutions().iterator();
                ForEachExecution nextForEachExecution = getNextForeachExecution(foreachExecutionsIterator, elementToUpdate);
                Collection<Object> newFeatureValue = new BasicEList<Object>();
                for (Object foreachElement : foreachElements) {
                    EObject producedElement = produceElement(foreachElement, textBlock, elementToUpdate,
                            getOppositeEndFinder(), nextForEachExecution);
                    if (producedElement != null) {
                        if (!(foreachPredicatePropertyInit.getPropertyReference().getStrucfeature() instanceof EReference)
                                || !((EReference) foreachPredicatePropertyInit.getPropertyReference().getStrucfeature())
                                        .isContainment()) {
                            // assign to elementToUpdate's Resource as a default, in case it's not added to a
                            // containment reference
                            elementToUpdate.eResource().getContents().add(producedElement);
                        }
                        newFeatureValue.add(producedElement);
                        if (nextForEachExecution != null) {
                            nextForEachExecution = getNextForeachExecution(foreachExecutionsIterator, elementToUpdate);
                        }
                    }
                }
                // delete trailing ForEachExecutions
                while (nextForEachExecution != null) {
                    foreachExecutionsIterator.remove();
                    nextForEachExecution = getNextForeachExecution(foreachExecutionsIterator, elementToUpdate);
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

    /**
     * Finds the next {@link ForEachExecution} in the collection iterated by <code>foreachExecutionIterator</code> that is
     * for the same {@link #foreachPredicatePropertyInit property init} as this updater and has
     * <code>elementToUpdate</code> as its {@link ForEachExecution#getSourceModelElement() source element}. If no such
     * element is found, <code>null</code> is returned
     * 
     * Postcondition: if a non-<code>null</code> result is returned, the <code>foreachExecutionIterator</code> is at that
     * element so that calling {@link Iterator#remove()} removes the element just returned
     * 
     * @param foreachExecutionIterator
     *            must not be <code>null</code>
     */
    private ForEachExecution getNextForeachExecution(Iterator<ForEachExecution> foreachExecutionIterator, EObject elementToUpdate) {
        ForEachExecution result = null;
        while (foreachExecutionIterator.hasNext() && result == null) {
            ForEachExecution fec = foreachExecutionIterator.next();
            if (fec.getForeachPedicatePropertyInit().equals(foreachPredicatePropertyInit)) {
                result = fec;
            }
        }
        return result;
    }


    private ForEachExecution createForeachExecution(EObject elementToUpdate, Object foreachElement,
            EObject producedElement, Template template) {
        // create ForEachExecution element documenting what just happened in the TextBlocks model
        ForEachExecution foreachExecution = TextblocksFactory.eINSTANCE.createForEachExecution();
        foreachExecution.setForeachPedicatePropertyInit(foreachPredicatePropertyInit);
        foreachExecution.setSourceModelElement(elementToUpdate);
        if (foreachElement instanceof EObject) {
            foreachExecution.setContextElement((EObject) foreachElement);
        } else if (foreachElement instanceof String) {
            foreachExecution.setContextString((String) foreachElement);
        } // else it must have been a Boolean which we don't record
        foreachExecution.setTemplateUsedForProduction(template);
        foreachExecution.setResultModelElement(producedElement);
        return foreachExecution;
    }

    /**
     * Tries to find the execution of {@link #foreachPredicatePropertyInit}.
     * {@link ForeachPredicatePropertyInit#getInjectorActionsBlock() getInjectorActionsBlock()} documented inside
     * <code>textBlock</code>.
     */
    private boolean foreachWasExecutedFor(TextBlock textBlock) {
        return TcsUtil.wasExecuted((ContextTemplate) textBlock.getType(),
                textBlock.getParentAltChoices(), getSequenceElement());
    }

    /**
     * Determines the template to use to produce the element for the given <code>foreachElement</code> which is a result
     * object from the foreach-expression's evaluation result. If a <code>null</code> <code>forEachExecution</code> is
     * passed, a new element is produced and a new {@link ForEachExecution} will be constructed and appended to the
     * <code>textBlock</code>'s {@link TextBlock#getForEachExecutions() foreach contexts}, documenting this rule
     * execution.
     * <p>
     * 
     * If a non-<code>null</code> <code>forEachExecution</code> is passed, two cases are possible. If the template that
     * would be used now for production is the same as the one pointed to by the {@link ForEachExecution} and the same
     * foreach result was used, no production is necessary. The {@link ForEachExecution} as well as its element can be
     * re-used. The {@link ForEachExecution#getResultModelElement() result element} of the {@link ForEachExecution} is
     * used as this method's result in this case.
     * <p>
     * 
     * If the template to use for production differs from the one in the <code>forEachExecution</code> or the production
     * was carried out for a different foreach result, the production is executed and the {@link ForEachExecution} is
     * updated with the results.
     * 
     * @return the element produced or <code>null</code> if no matching template was found, e.g., because no
     *         "when"-clause matched the element
     */
    private EObject produceElement(Object foreachElement, TextBlock textBlock, EObject elementToUpdate,
            OppositeEndFinder oppositeEndFinder, ForEachExecution forEachExecution) {
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
            if (forEachExecution == null || forEachExecution.getTemplateUsedForProduction() != template ||
                    forEachExecution.getContextElement() != foreachElement) {
                result = produceWith(template, foreachElement, textBlock, elementToUpdate, oppositeEndFinder);
                if (forEachExecution == null) {
                    ForEachExecution newForEachExecution = createForeachExecution(elementToUpdate, foreachElement, result, template);
                    // no concurrent modification exception can occur here because forEachExecution is null
                    // which avoids further calls to the iterator's next() operation
                    textBlock.getForEachExecutions().add(newForEachExecution);
                } else {
                    forEachExecution.setTemplateUsedForProduction(template);
                    forEachExecution.setResultModelElement(result);
                    if (foreachElement instanceof EObject) {
                        forEachExecution.setContextElement((EObject) foreachElement);
                    } else if (foreachElement instanceof String) {
                        forEachExecution.setContextString((String) foreachElement);
                    }
                }
            } else {
                // re-use result object from ForEachExecution:
                result = forEachExecution.getResultModelElement();
            }
        }
        return result;
    }

    /**
     * Executes the <code>template</code>'s parse rule. The
     * {@link ObservableInjectingParser#setCurrentForeachElement(Object) foreach element} on the parser can easily be
     * set to <code>foreachElement</code>. Tricky is establishing the #context stack.
     * 
     * @param textBlock
     *            required to construct a context stack if necessary and to initialize the lexer's token stream
     * @return the element produced
     */
    private EObject produceWith(Template template, Object foreachElement, TextBlock textBlock, EObject elementToUpdate,
            OppositeEndFinder oppositeEndFinder) {
        
        ResourceSet resourceSet = elementToUpdate.eResource().getResourceSet();
        Resource transientResource = EcoreHelper.createTransientParsingResource(resourceSet, "http://furcas.org/foreach/reevaluation/");
        try {
            String ruleName = parserFactory.getRuleNameFinder().getRuleName(template, /*mode*/ null);
            String content = TbNavigationUtil.getUltraRoot(textBlock).getCachedString();
            Lexer lexer = parserFactory.createLexer(new ANTLRStringStream(content));
            
            // Construct scope that includes the additionalQueryScope as well as all dirty
            // resources. The latter includes the transient parsing resource used by the incremental parser.
            HashSet<URI> scope = new HashSet<URI>(parserFactory.getAdditionalQueryScope());
            scope.addAll(FileResourceHelper.getResourceSetAsScope(resourceSet));
            
            IMetaModelLookup<EObject> metamodelLookup = new QueryBasedEcoreMetaModelLookUp(resourceSet,
                    parserFactory.getMetamodelURIs());
            IModelAdapter modelAdapter = new DefaultTextAwareModelAdapter(new EMFModelAdapter(resourceSet,
                    new PartitionAssignmentHandlerBaseImpl(transientResource), metamodelLookup, scope));
            
            ObservableInjectingParser parser = parserFactory.createParser(new CommonTokenStream(lexer), modelAdapter);
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
            // TODO How can we be sure that the model is in a valid state when the parser is called?
            // Simply injecting (modifying) the domain model through the parser might lead to data loss
            EObject parseReturn = (EObject) methodToCall.invoke(parser);
            if (parseReturn == null) {
                throw new ModelElementCreationException("Unable to create model element using parse rule " + ruleName
                        + ". Parse errors: " + parser.getInjector().getErrorList());
            }
            parser.setDelayedReferencesAfterParsing(); // TODO instead of using DelayedReference stuff, migrate to model updaters
            return parseReturn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            transientResource.getContents().clear();
            resourceSet.getResources().remove(transientResource);
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
                    // TODO this try/catch will probably disappear when we're compiling the OCL ASTs into the FURCAS mapping
                    try {
                        // TODO cache compiled expressions; caution: foreachElement.eClass() may be more specific than real context type; obtain context type from foreach expression's type
                        // TODO use opposite direction of expressionToWhenClause, perhaps requiring another map?
                        when = oclHelper.createQuery(whenClause.getWhen());
                    } catch (ParserException e) {
                        throw new RuntimeException(e);
                    }
                    Object whenResult = ocl.evaluate(foreachElement, when);
                    if (ocl.getEnvironment().getOCLStandardLibrary().getInvalid() != whenResult) {
                        Boolean match = (Boolean) whenResult;
                        if (match) {
                            result = whenClause.getAs();
                            break;
                        }
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
