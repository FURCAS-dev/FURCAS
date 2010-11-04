package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.oppositeendfinder.DefaultOppositeEndFinder;
import com.sap.emf.oppositeendfinder.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.instancescope.InstanceScopeAnalysisWithHiddenOpposites;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ContextTypeRetriever;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis;

/**
 * Implementation of the {@link ImpactAnalyzer}
 */
public class ImpactAnalyzerWithHiddenOppositesImpl extends ImpactAnalyzerImpl {

    /**
     * Creates a new impact analyzer for the OCL expression given. For event filter synthesis (see
     * {@link #createFilterForExpression()}) no context type is required. Should {@link #getContextObjects(Notification)}
     * be called later, a context type may be needed. When this constructor is used, it is inferred on demand using the
     * {@link ContextTypeRetriever}, visiting all subexpressions looking for <code>self</code> occurrences and picking their type.
     * <p>
     * 
     * Should you conveniently have the context type available, consider using
     * {@link #ImpactAnalyzerImpl(OCLExpression, EClass, boolean, ActivationOption, OCLFactory)} instead.
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation events on the
     *            context type or not. Registering for element creation on the context type is useful for invariants / constraints
     *            because when a new element is created, validating the constraint may be useful. For other use cases, registering
     *            for element creation may not be so useful. For example, when a type inferencer defines its rules using OCL, it
     *            only wants to receive <em>update</em> events after the element has been fully initialized from those OCL
     *            expressions. In those cases, some framework may be responsible for the initial evaluation of those OCL
     *            expressions on new element, and therefore, context element creation events are not of interest.
     */
    public ImpactAnalyzerWithHiddenOppositesImpl(OCLExpression expression, boolean notifyOnNewContextElements, ActivationOption configuration, OCLFactory oclFactory) {
        super(expression, notifyOnNewContextElements, DefaultOppositeEndFinder.getInstance(), configuration, oclFactory);
    }

    public ImpactAnalyzerWithHiddenOppositesImpl(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, ActivationOption configuration, OCLFactory oclFactory) {
        super(expression, context, notifyOnNewContextElements, DefaultOppositeEndFinder.getInstance(), configuration, oclFactory);
    }

    /**
     * @param oppositeEndFinder
     *            used during partial navigation and for metamodel queries
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation events on the
     *            context type or not. Registering for element creation on the context type is useful for invariants / constraints
     *            because when a new element is created, validating the constraint may be useful. For other use cases, registering
     *            for element creation may not be so useful. For example, when a type inferencer defines its rules using OCL, it
     *            only wants to receive <em>update</em> events after the element has been fully initialized from those OCL
     *            expressions. In those cases, some framework may be responsible for the initial evaluation of those OCL
     *            expressions on new element, and therefore, context element creation events are not of interest.
     */
    public ImpactAnalyzerWithHiddenOppositesImpl(OCLExpression expression, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, ActivationOption configuration, OCLFactory oclFactory) {
        super(expression, notifyOnNewContextElements, oppositeEndFinder, configuration, oclFactory);
    }

    /**
     * @param oppositeEndFinder
     *            used during partial navigation and for metamodel queries
     * @param notifyNewContextElements
     *            The analyzer can be parameterized during construction such that it either registers for creation events on the
     *            context type or not. Registering for element creation on the context type is useful for invariants / constraints
     *            because when a new element is created, validating the constraint may be useful. For other use cases, registering
     *            for element creation may not be so useful. For example, when a type inferencer defines its rules using OCL, it
     *            only wants to receive <em>update</em> events after the element has been fully initialized from those OCL
     *            expressions. In those cases, some framework may be responsible for the initial evaluation of those OCL
     *            expressions on new element, and therefore, context element creation events are not of interest.
     */
    public ImpactAnalyzerWithHiddenOppositesImpl(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, ActivationOption configuration, OCLFactory oclFactory) {
        super(expression, context, notifyOnNewContextElements, oppositeEndFinder, configuration, oclFactory);
    }

    @Override
    protected InstanceScopeAnalysis createInstanceScopeAnalysis(OCLExpression expression, EClass context, FilterSynthesisImpl filtersyn, OppositeEndFinder oppositeEndFinder, ActivationOption configuration, OCLFactory oclFactory) {
        return new InstanceScopeAnalysisWithHiddenOpposites(expression, context, filtersyn, oppositeEndFinder, configuration, oclFactory);
    }

    @Override
    protected FilterSynthesisImpl createFilterSynthesis(OCLExpression expression, boolean notifyOnNewContextElements, OCL ocl) {
        return new FilterSynthesisWithHiddenOppositesImpl(expression, notifyOnNewContextElements, ocl);
    }

    @Override
    protected ContextTypeRetriever createContextTypeRetriever() {
        return new ContextTypeRetrieverWithHiddenOpposites();
    }
}
