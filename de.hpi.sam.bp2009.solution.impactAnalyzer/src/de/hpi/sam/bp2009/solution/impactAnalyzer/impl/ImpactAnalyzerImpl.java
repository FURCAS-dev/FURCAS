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
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis;

/**
 * Implementation of the {@link ImpactAnalyzer}
 */
public class ImpactAnalyzerImpl implements ImpactAnalyzer {

    private final OCLExpression expression;
    private FilterSynthesisImpl filtersyn;
    private InstanceScopeAnalysis instanceScopeAnalysis;
    private boolean needToInferContextType;
    private EClass context;
    private final OppositeEndFinder oppositeEndFinder;
    private final OppositeEndFinder reverseOppositeEndFinder;

    /**
     * Creates a new impact analyzer for the OCL expression given. For event filter synthesis (see
     * {@link #createFilterForExpression(boolean)}) no context type is required. Should
     * {@link #getContextObjects(Notification)} be called later, a context type may be needed. When this constructor is
     * used, it is inferred on demand using the {@link ContextTypeRetriever}, visiting all subexpressions looking for
     * <code>self</code> occurrences and picking their type.
     * <p>
     *
     * Should you conveniently have the context type available, consider using {@link #ImpactAnalyzerImpl(OCLExpression, EClass)}
     * instead.
     */
    public ImpactAnalyzerImpl(OCLExpression expression) {
        this(expression, DefaultOppositeEndFinder.getInstance(), DefaultOppositeEndFinder.getInstance());
    }

    public ImpactAnalyzerImpl(OCLExpression expression, EClass context) {
        this(expression, context, DefaultOppositeEndFinder.getInstance(), DefaultOppositeEndFinder.getInstance());
    }

    /**
     * @param oppositeEndFinder used during partial navigation and for metamodel queries
     */
    public ImpactAnalyzerImpl(OCLExpression expression, OppositeEndFinder oppositeEndFinder, OppositeEndFinder reverseOppositeEndFinder) {
        this.expression = expression;
	this.reverseOppositeEndFinder = reverseOppositeEndFinder;
        needToInferContextType = true;
        this.oppositeEndFinder = oppositeEndFinder;
    }

    /**
     * @param oppositeEndFinder used during partial navigation and for metamodel queries
     */
    public ImpactAnalyzerImpl(OCLExpression expression, EClass context, OppositeEndFinder oppositeEndFinder, OppositeEndFinder reverseOppositeEndFinder) {
        this.expression = expression;
	this.reverseOppositeEndFinder = reverseOppositeEndFinder;
        needToInferContextType = false;
        this.context = context;
        this.oppositeEndFinder = oppositeEndFinder;
    }

    @Override
    public EventFilter createFilterForExpression(boolean notifyNewContextElements) {
        filtersyn = new FilterSynthesisImpl(expression, notifyNewContextElements);
        return filtersyn.getSynthesisedFilter();
    }

    @Override
    public Collection<EObject> getContextObjects(Notification event) {
        if (instanceScopeAnalysis == null) {
            if (filtersyn == null) {
                createFilterForExpression(true);
            }
            if (needToInferContextType) {
                context = expression.accept(new ContextTypeRetriever());
                needToInferContextType = false;
            }
            instanceScopeAnalysis = new InstanceScopeAnalysis(expression, context, filtersyn, oppositeEndFinder, reverseOppositeEndFinder);
        }
        return instanceScopeAnalysis.getContextObjects(event);
    }

    protected OCLExpression getExpression() {
        return expression;
    }

} // ImpactAnalyzerImpl
