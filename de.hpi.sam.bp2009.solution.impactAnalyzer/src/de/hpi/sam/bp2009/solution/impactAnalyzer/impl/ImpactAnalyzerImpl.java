package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

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
    private boolean needToInferContextType;
    private EClass context;

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
        this.expression = expression;
        needToInferContextType = true;
    }

    public ImpactAnalyzerImpl(OCLExpression expression, EClass context) {
        this.expression = expression;
        needToInferContextType = false;
        this.context = context;
    }

    @Override
    public EventFilter createFilterForExpression(boolean notifyNewContextElements) {
        filtersyn = new FilterSynthesisImpl(expression, notifyNewContextElements);
        return filtersyn.getSynthesisedFilter();
    }

    @Override
    public Collection<EObject> getContextObjects(Notification event) {
        if (filtersyn == null) {
            createFilterForExpression(true);
        }
        if (needToInferContextType) {
            context = expression.accept(new ContextTypeRetriever());
            needToInferContextType = false;
        }
        InstanceScopeAnalysis instanceScopeAnalysis = new InstanceScopeAnalysis(expression, context, filtersyn);
        return instanceScopeAnalysis.getContextObjects(event);
    }
    
    protected OCLExpression getExpression() {
        return expression;
    }

} // ImpactAnalyzerImpl
