package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.instancescope;

import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.ExpressionsPackage;
import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;
import com.sap.emf.oppositeendfinder.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.traceback.TracebackStepCacheWithHiddenOpposites;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.AllInstancesNavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.PathCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.Tracer;

public class InstanceScopeAnalysisWithHiddenOpposites extends InstanceScopeAnalysis {
    /**
     * @param expression
     *            the OCL expression for which to perform instance scope impact analysis
     * @param oppositeEndFinder
     *            used during partial evaluation and for metamodel queries, e.g., finding opposite role names, or finding all
     *            subclasses of a class; as well as for obtaining all instances of a type while performing an
     *            {@link AllInstancesNavigationStep}. It is handed to the {@link PathCache} object from where
     *            {@link Tracer}s can retrieve it using {@link PathCache#getOppositeEndFinder()}.
     */
    public InstanceScopeAnalysisWithHiddenOpposites(OCLExpression expression, EClass exprContext, FilterSynthesisImpl filterSynthesizer, OppositeEndFinder oppositeEndFinder, ActivationOption configuration, OCLFactory oclFactory) {
        super(expression, exprContext, filterSynthesizer, oppositeEndFinder, configuration, oclFactory,
                /* pathCache */ configuration.isTracebackStepISAActive() ? null : new PathCache(oppositeEndFinder, null),
                /* tracebackStepCache */ configuration.isTracebackStepISAActive() ? new TracebackStepCacheWithHiddenOpposites(oppositeEndFinder) : null);
        if (!configuration.isTracebackStepISAActive()) {
            getPathCache().initInstanceScopeAnalysis(this);
        }
    }

    /**
     * Factory method that creates an instance of some {@link Tracer}-implementing class specific to the type of the OCL
     * <tt>expression</tt>.
     * @param caller the calling tracer from which the list of tuple part names to look for are copied
     * unchanged to the new tracer created by this operation. May be <tt>null</tt> in which case the
     * new tracer does not look for any tuple literal parts initially.
     */
    protected Tracer createTracer(OCLExpression expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
        // Using the class loader is another option, but that would create implicit naming conventions.
        // Thats why we do the mapping "manually".
        switch (expression.eClass().getClassifierID()) {
        case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP:
            return new OppositePropertyCallExpTracer((OppositePropertyCallExp) expression, tuplePartNames, oclFactory);
        default:
            return super.createTracer(expression, tuplePartNames, oclFactory);
        }
    }
}
