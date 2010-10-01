package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.DefaultOppositeEndFinder;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis;

/**
 * Implementation of the {@link ImpactAnalyzer}
 */
public class ImpactAnalyzerImpl implements ImpactAnalyzer {

    private final OCLExpression expression;
    private FilterSynthesisImpl filtersyn;
    private InstanceScopeAnalysis instanceScopeAnalysis;
    private final EClass context;
    private final OppositeEndFinder oppositeEndFinder;
    private final ActivationOption configuration;

    /**
     * Creates a new impact analyzer for the OCL expression given. For event filter synthesis (see
     * {@link #createFilterForExpression(boolean)}) no context type is required. Should
     * {@link #getContextObjects(Notification)} be called later, a context type may be needed. When this constructor is
     * used, it is inferred on demand using the {@link ContextTypeRetriever}, visiting all subexpressions looking for
     * <code>self</code> occurrences and picking their type.
     * <p>
     *
     * Should you conveniently have the context type available, consider using {@link #ImpactAnalyzerImpl(OCLExpression, EClass, ActivationOption)}
     * instead.
     */
    public ImpactAnalyzerImpl(OCLExpression expression, ActivationOption configuration) {
        this(expression, DefaultOppositeEndFinder.getInstance(), configuration);
    }

    public ImpactAnalyzerImpl(OCLExpression expression, EClass context, ActivationOption configuration) {
        this(expression, context, DefaultOppositeEndFinder.getInstance(), configuration);
    }

    /**
     * @param oppositeEndFinder used during partial navigation and for metamodel queries
     */
    public ImpactAnalyzerImpl(OCLExpression expression, OppositeEndFinder oppositeEndFinder, ActivationOption configuration) {
        this.expression = expression;
        this.context = expression.accept(new ContextTypeRetriever());
        if (this.context == null) {
            throw new IllegalArgumentException("Expression "+expression+" does not contain a \"self\" variable reference. "+
                    "Therefore, its context type cannot be inferred and needs to be provided explicitly. Consider using "+
                    getClass().getName()+"(OCLExpression, EClass, OppositeEndFinder) instead.");
        }
        this.oppositeEndFinder = oppositeEndFinder;
        this.configuration = configuration;
    }

    /**
     * @param oppositeEndFinder used during partial navigation and for metamodel queries
     */
    public ImpactAnalyzerImpl(OCLExpression expression, EClass context, OppositeEndFinder oppositeEndFinder, ActivationOption configuration) {
        this.expression = expression;
        this.context = context;
        this.oppositeEndFinder = oppositeEndFinder;
        this.configuration = configuration;
    }

    public EventFilter createFilterForExpression(boolean notifyNewContextElements) {
        filtersyn = new FilterSynthesisImpl(expression, notifyNewContextElements);
        return filtersyn.getSynthesisedFilter();
    }

    public Collection<EObject> getContextObjects(Notification event) {
        if (instanceScopeAnalysis == null) {
            if (filtersyn == null) {
                createFilterForExpression(true);
            }
            instanceScopeAnalysis = new InstanceScopeAnalysis(expression, context, filtersyn, oppositeEndFinder, configuration);
        }
        return instanceScopeAnalysis.getContextObjects(event);
    }

    protected OCLExpression getExpression() {
        return expression;
    }

} // ImpactAnalyzerImpl
