package com.sap.furcas.runtime.referenceresolving;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluator;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluatorFactory;

import com.sap.emf.ocl.trigger.AbstractTriggerable;
import com.sap.emf.ocl.trigger.ExpressionWithContext;
import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;

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

    protected ForeachPropertyInitUpdater(ForeachPredicatePropertyInit foreachPredicatePropertyInit,
            EPackage.Registry metamodelPackageRegistry, OppositeEndFinder oppositeEndFinder) throws ParserException {
        super(foreachPredicatePropertyInit.getPropertyReference().getStrucfeature(), metamodelPackageRegistry,
              oppositeEndFinder,
              /* expression with context; provided later in getTriggerExpressionsWithContext() */null,
              /* notifyNewContextElements */true, getSelfKind(foreachPredicatePropertyInit.getValue()),
              ContextAndForeachHelper.getContextTag(foreachPredicatePropertyInit.getValue()));
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
                    // TODO implement basic solution by more or less copying from DelayedReferencesHelper
                }
            }
        }
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
