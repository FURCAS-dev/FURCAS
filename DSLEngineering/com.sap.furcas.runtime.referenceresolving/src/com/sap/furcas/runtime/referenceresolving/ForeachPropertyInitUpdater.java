package com.sap.furcas.runtime.referenceresolving;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzer;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzerFactory;
import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluator;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluatorFactory;

import com.sap.emf.ocl.trigger.AbstractTriggerable;
import com.sap.emf.ocl.trigger.ExpressionWithContext;
import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.common.interfaces.IRuleName;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;
import com.sap.furcas.runtime.parser.IParsingObserver;
import com.sap.furcas.runtime.parser.ModelElementCreationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.DelegationParsingObserver;
import com.sap.furcas.runtime.parser.impl.ForeachParsingObserver;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
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
     * Enables mapping the OCL expressions used in the <code>when</code> clauses of the <code>foreach</code>
     * predicate to the {@link PredicateSemantic} objects representing the respective <code>when</code> clause
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
              /* notifyNewContextElements */true, getSelfKind(foreachPredicatePropertyInit.getValue()),
              ContextAndForeachHelper.getContextTag(foreachPredicatePropertyInit.getValue()));
        this.parserFactory = parserFactory;
        triggerExpressionsWithContext = new LinkedList<ExpressionWithContext>();
        this.foreachPredicatePropertyInit = foreachPredicatePropertyInit;
        Helper oclHelper = createOCLHelper();
        // add the base foreach expression:
        baseForeachExpression = oclHelper.createQuery(
                ContextAndForeachHelper.prepareOclQuery(foreachPredicatePropertyInit.getValue()));
        triggerExpressionsWithContext.add(new ExpressionWithContext(baseForeachExpression,
                (EClass) ContextAndForeachHelper.getParsingContext(foreachPredicatePropertyInit.getValue(),
                        ((InjectorActionsBlock) foreachPredicatePropertyInit.eContainer()).getParentTemplate())));
        if (this.foreachPredicatePropertyInit.getPredicateSemantic().isEmpty()) {
            expressionToWhenClause = Collections.emptyMap();
        } else {
            expressionToWhenClause = new HashMap<OCLExpression, PredicateSemantic>();
        }
        oclHelper.setContext(baseForeachExpression.getType());
        for (PredicateSemantic whenClause : foreachPredicatePropertyInit.getPredicateSemantic()) {
            if (whenClause.getWhen() != null) {
                OCLExpression whenClausExpression = oclHelper.createQuery(whenClause.getWhen());
                expressionToWhenClause.put(whenClausExpression, whenClause);
                triggerExpressionsWithContext.add(
                        new ExpressionWithContext(whenClausExpression, (EClass) baseForeachExpression.getType()));
            }
        }
    }

    private Helper createOCLHelper() throws ParserException {
        return createOCLHelper(foreachPredicatePropertyInit.getValue(),
                ((InjectorActionsBlock) foreachPredicatePropertyInit.eContainer()).getParentTemplate(),
                getOppositeEndFinder());
    }

    @Override
    public void notify(OCLExpression expression, Collection<EObject> affectedContextObjects, OppositeEndFinder oppositeEndFinder,
            Notification change) {
        if (expression == baseForeachExpression) {
            // the base expression changed; see what changed:
            PartialEvaluator partialEvaluator = PartialEvaluatorFactory.INSTANCE.createPartialEvaluator(change,
                    getOppositeEndFinder(), OCLFactory.INSTANCE);
            OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(getOppositeEndFinder());
            for (EObject affectedContextObject : affectedContextObjects) {
                Object oldValue = partialEvaluator.evaluate(affectedContextObject, baseForeachExpression);
                Object newValue = ocl.evaluate(affectedContextObject, baseForeachExpression);
                if (oldValue != newValue && (oldValue == null || !oldValue.equals(newValue))) {
                    // something changed
                    // TODO sophisticated solution: find out what was removed and what was added from the result of the foreach expression and which elements changed
                    // Then we could try to selectively remove elements from the target feature.
                    try {
                        // the getElementsToUpdate(affectedContextObject) is necessary because the foreach
                        // base expression may itself use #context or #foreach
                        updateFeature(expression, getElementsToUpdate(affectedContextObject), oldValue, newValue);
                    } catch (ParserException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } else {
            PredicateSemantic whenClause = expressionToWhenClause.get(expression);
            if (whenClause != null) {
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
                System.err.println("TODO Impact Analysis for when clause not yet active: "+whenClause.getWhen());
            }
        }
    }
    
    private ImpactAnalyzer getImpactAnalyzerForBaseExpression() {
        if (impactAnalyzerForBaseExpression == null) {
            impactAnalyzerForBaseExpression = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(baseForeachExpression, /* notifyOnNewContextElements */ false,
                    getOppositeEndFinder(), OCLFactory.INSTANCE);
        }
        return impactAnalyzerForBaseExpression;
    }

    private void updateFeature(OCLExpression expression, Set<EObject> elementsToUpdate, Object oldValue,
            Object newValue) {
        Collection<?> foreachElements;
        if (newValue instanceof Collection<?>) {
            foreachElements = (Collection<?>) newValue;
        } else {
            foreachElements = Collections.singleton(newValue);
        }
        for (EObject elementToUpdate : elementsToUpdate) {
            Collection<EObject> textBlocks = getOppositeEndFinder().navigateOppositePropertyWithBackwardScope(
                    TextblocksPackage.eINSTANCE.getDocumentNode_CorrespondingModelElements(), elementToUpdate);
            TextBlock textBlock = null;
            if (!textBlocks.isEmpty()) {
                textBlock = (TextBlock) textBlocks.iterator().next();
            }
            Collection<Object> newFeatureValue = new BasicEList<Object>();
            for (Object foreachElement : foreachElements) {
                newFeatureValue.add(produceElement(foreachElement, textBlock,
                        elementToUpdate.eResource().getResourceSet(), getOppositeEndFinder()));
            }
            if (foreachPredicatePropertyInit.getPropertyReference().getStrucfeature().isMany()) {
                elementToUpdate.eSet(foreachPredicatePropertyInit.getPropertyReference().getStrucfeature(), newFeatureValue);
            } else {
                if (newFeatureValue.isEmpty()) {
                    elementToUpdate.eSet(foreachPredicatePropertyInit.getPropertyReference().getStrucfeature(), null);
                } else {
                    elementToUpdate.eSet(foreachPredicatePropertyInit.getPropertyReference().getStrucfeature(),
                            newFeatureValue.iterator().next()); // pick first element
                }
            }
        }
    }

    private Object produceElement(Object foreachElement, TextBlock textBlock, ResourceSet resourceSet, OppositeEndFinder oppositeEndFinder) {
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
        Object result = null;
        if (template != null) {
            result = produceWith(template, foreachElement, textBlock, resourceSet, oppositeEndFinder);
        }
        return result;
    }

    /**
     * Executes the <code>template</code>'s parse rule. Tricky aspects are setting the #foreach and
     * #context stack stuff.
     * @param textBlock TODO
     * @param resourceSet 
     * @return the element produced
     */
    private Object produceWith(Template template, Object foreachElement, TextBlock textBlock,
            ResourceSet resourceSet, OppositeEndFinder oppositeEndFinder) {
        IRuleName ruleNameFinder = parserFactory.getRuleNameFinder();
        String mode = null;
        try {
            String ruleName = ruleNameFinder.getRuleName(template, mode);
            Lexer lexer = parserFactory.createLexer(
                    new ANTLRStringStream(getRootBlock(textBlock).getCachedString()));
            ObservableInjectingParser parser = parserFactory.createParser(new CommonTokenStream(lexer), resourceSet);
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
            // TODO do the context setup magic...
            /*
            if (parser.getContextManager().getContextForElement(reference.getContextElement()) == null) {
                parser.addContext(proxyForContextElement);
                if (proxyForContextElement.getRealObject() != null && reference.getContextElement() instanceof EObject) {
                    parser.getContextManager().notifyProxyResolvedWith(proxyForContextElement, reference.getContextElement(),
                    // no creation context element needs to be provided here because the proxy has just been created and has not been
                    // added to any other context
                    null);
                }
            } else {
                parser.getCurrentContextStack().push(proxyForContextElement); // the Context object was already created elsewhere
            }
            if (reference.hasContext() && foreachElement instanceof EObject) {
                ResolvedModelElementProxy proxyForNext = new ResolvedModelElementProxy(foreachElement);
                if (parser.getContextManager().getContextForElement(foreachElement) == null) {
                    parser.addContext(proxyForNext);
                    parser.getContextManager().notifyProxyResolvedWith(proxyForNext, foreachElement,
                    // no creation context element needs to be provided here because the proxy has just been created and has not been
                    // added to any other context
                     null);
                } else {
                    parser.getCurrentContextStack().push(proxyForNext); // the Context object was already created elsewhere
                }
            }
            */
            Object parseReturn = methodToCall.invoke(parser);
            if (parseReturn == null) {
                throw new ModelElementCreationException("Unable to create model element using parse rule " + ruleName
                        + ". Parse errors: " + parser.getInjector().getErrorList());
            }
            // TODO if parseReturn is a ModelElementProxy, resolve
            // TODO assign to elementToUpdate's Resource as a default, in case it's not added to a containment reference
            // TODO create ForEachContext elements documenting what just happened in the TextBlocks model. See DelayedReferencesHelper.addForEachContext
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

    /*
     * This code copied from DelayedReferencesHelper:
     * 
    private Object setReference(ObservableInjectingParser parser, Object foreachElement, String ruleName) throws Exception {
        // TODO need to determine and set context element
        
        // invoke the parser to execute the template
        Method methodToCall = parser.getClass().getMethod(ruleName);
        // parser.reset();
        if (!Modifier.isFinal(methodToCall.getModifiers())) {
            throw new UnknownProductionRuleException(ruleName + " is not a production rule in generated Parser.");
        }
        boolean originalResolveProxiesValue = parser.isResolveProxies();
        parser.setResolveProxies(false);
        DelegationParsingObserver delegator = new DelegationParsingObserver();
        IParsingObserver originalObserver = parser.getObserver();
        if (originalObserver != null) {
            delegator.addParsingObserver(originalObserver);
        }
        delegator.addParsingObserver(new ForeachParsingObserver((TextBlock) reference.getTextBlock()));
        parser.setObserver(delegator);

        IModelElementProxy proxyForContextElement = null;
        if (reference.getContextElement() instanceof IModelElementProxy) {
            proxyForContextElement = (IModelElementProxy) reference.getContextElement();
        } else {
            proxyForContextElement = new ResolvedModelElementProxy(reference.getContextElement());
        }

        parser.setCurrentForeachElement(foreachElement);

        if (parser.getContextManager().getContextForElement(reference.getContextElement()) == null) {
            parser.addContext(proxyForContextElement);
            if (proxyForContextElement.getRealObject() != null && reference.getContextElement() instanceof EObject) {
                parser.getContextManager().notifyProxyResolvedWith(proxyForContextElement, reference.getContextElement(),
                // no creation context element needs to be provided here because the proxy has just been created and has not been
                // added to any other context
                null);
            }
        } else {
            parser.getCurrentContextStack().push(proxyForContextElement); // the Context object was already created elsewhere
        }
        if (reference.hasContext() && foreachElement instanceof EObject) {
            ResolvedModelElementProxy proxyForNext = new ResolvedModelElementProxy(foreachElement);
            if (parser.getContextManager().getContextForElement(foreachElement) == null) {
                parser.addContext(proxyForNext);
                parser.getContextManager().notifyProxyResolvedWith(proxyForNext, foreachElement,
                // no creation context element needs to be provided here because the proxy has just been created and has not been
                // added to any other context
                 null);
            } else {
                parser.getCurrentContextStack().push(proxyForNext); // the Context object was already created elsewhere
            }
        }
        try {
            Object parseReturn = methodToCall.invoke(parser);
            if (parseReturn == null) {
                throw new ModelElementCreationException("Unable to create model element using parse rule " + ruleName
                        + ". Parse errors: " + parser.getInjector().getErrorList());
            }
            // add the parsed part to the object
            // first try to resolve if there is a model element that already
            // exists and can be reused
            // EObject candidate = findCandidateFromProxy((EObject)
            // reference.getModelElement(),
            // reference.getPropertyName(), parseReturn, (EObject)
            // reference.getElementForSelf(),//(EObject) next,
            // (ForeachPredicatePropertyInit) reference.getQueryElement(),
            // (TextBlock) reference.getTextBlock());
            if (reusableResultElement != null) {
                // element already exists so we can reuse it
                reference.setRealValue(reusableResultElement);
                ((ModelElementProxy) parseReturn).setRealObject(reusableResultElement);
                return;
            } else {
                reference.setRealValue(injector.createOrResolve(parseReturn, null, null));
                // by default use partition of reference.getModelElement
                if (reference.getModelElement() instanceof EObject && reference.getRealValue() instanceof EObject) {
                    ((EObject) reference.getModelElement()).eResource().getContents().add((EObject) reference.getRealValue());
                }
                modelAdapter.set(reference.getModelElement(), reference.getPropertyName(), reference.getRealValue());
                if (reference.getTextBlock() != null) {
                    addForEachContext((TextBlock) reference.getTextBlock(), (EObject) reference.getModelElement(),
                            (EObject) foreachElement, (ForeachPredicatePropertyInit) reference.getQueryElement(),
                            (EObject) reference.getRealValue(), ((EObject) reference.getModelElement()).eResource()
                                    .getResourceSet());
                }
            }
        } finally {
            if (reference.hasContext() && foreachElement instanceof EObject) {
                parser.leaveContext();
            }
            parser.getCurrentContextStack().pop();
            parser.setObserver(originalObserver);
            parser.setResolveProxies(originalResolveProxiesValue);
        }
    }
    */
    
    /**
     * Determines for an {@link EObject} result of the foreach base expression which template
     * to use to produce the element. If there is no {@link PredicateSemantic} associated, use the
     * <code>foreachElement</code>'s type and the {@link ForeachPredicatePropertyInit#getMode() global mode}
     * to decide which template to use (using {@link TcsUtil#getTemplateMode(Template)}). If no template
     * is found, a {@link RuntimeException} is thrown.
     */
    private Template findTemplate(EObject foreachElement) {
        Template result = null;
        if (foreachPredicatePropertyInit.getPredicateSemantic().isEmpty()) {
            String mode = foreachPredicatePropertyInit.getMode();
            result = TcsUtil.findTemplate(foreachElement.eClass(), mode, /* TODO partition scope */ null);
        } else {
            OCL ocl = org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(getOppositeEndFinder());
            Helper oclHelper = ocl.createOCLHelper();
            oclHelper.setContext(foreachElement.eClass());
            for (PredicateSemantic whenClause : foreachPredicatePropertyInit.getPredicateSemantic()) {
                if (whenClause.getWhen() != null) {
                    OCLExpression when;
                    // TODO this try/catch will probably disappear when we're compiling the OCL ASTs into the FURCAS mapping
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
