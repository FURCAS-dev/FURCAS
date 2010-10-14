package de.hpi.sam.bp2009.solution.impactAnalyzer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerFactoryImpl;

public interface ImpactAnalyzerFactory {
    static final ImpactAnalyzerFactory INSTANCE = new ImpactAnalyzerFactoryImpl();

    /**
     * Constructs an impact analyzer for the expression specified. The expression's context type is
     * inferred from any occurrence of <code>self</code> in the expression. If no <code>self</code>
     * occurrence can be found, an exception will be thrown. The configuration is taken from the
     * default {@link OptimizationActivation#getOption()}.
     */
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression);
    
    /**
     * Constructs an impact analyzer for the expression specified with an explicit context type
     * specification. Use this factory method if <code>expression</code> does not contain any reference
     * to <code>self</code>. The configuration is taken from the
     * default {@link OptimizationActivation#getOption()}.
     */
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context);

    /**
     * Constructs an impact analyzer for the expression specified with an explicit context type specification. Use this factory
     * method if <code>expression</code> does not contain any reference to <code>self</code>. The configuration is taken from the
     * default {@link OptimizationActivation#getOption()}.
     * 
     * @param oppositeEndFinder
     *            used to perform {@link OppositePropertyCallExp} when evaluating (parts of) <code>expression</code> and for
     *            evaluating <code>allInstances()</code> calls
     */
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, OppositeEndFinder oppositeEndFinder);

    /**
     * Constructs an impact analyzer for the expression specified. The expression's context type is
     * inferred from any occurrence of <code>self</code> in the expression. If no <code>self</code>
     * occurrence can be found, an exception will be thrown. The configuration is taken from the
     * default {@link OptimizationActivation#getOption()}.
     * 
     * @param oppositeEndFinder
     *            used to perform {@link OppositePropertyCallExp} when evaluating (parts of) <code>expression</code> and for
     *            evaluating <code>allInstances()</code> calls
     */
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, OppositeEndFinder oppositeEndFinder);

    /**
     * Constructs an impact analyzer for the expression specified. The expression's context type is
     * inferred from any occurrence of <code>self</code> in the expression. If no <code>self</code>
     * occurrence can be found, an exception will be thrown.
     */
    public abstract ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, OppositeEndFinder oppositeEndFinder,
            ActivationOption configuration);

    /**
     * Constructs an impact analyzer for the expression specified with an explicit context type
     * specification. Use this factory method if <code>expression</code> does not contain any reference
     * to <code>self</code>.
     */
    public abstract ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context,
            OppositeEndFinder oppositeEndFinder, ActivationOption configuration);

    /**
     * Constructs an impact analyzer for the expression specified with an explicit context type specification. Use this factory
     * method if <code>expression</code> does not contain any reference to <code>self</code>.
     * 
     * @param oppositeEndFinder
     *            used to perform {@link OppositePropertyCallExp} when evaluating (parts of) <code>expression</code> and for
     *            evaluating <code>allInstances()</code> calls
     */
    public abstract ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, ActivationOption configuration);

    /**
     * Constructs an impact analyzer for the expression specified. The expression's context type is
     * inferred from any occurrence of <code>self</code> in the expression. If no <code>self</code>
     * occurrence can be found, an exception will be thrown.
     * 
     * @param oppositeEndFinder
     *            used to perform {@link OppositePropertyCallExp} when evaluating (parts of) <code>expression</code> and for
     *            evaluating <code>allInstances()</code> calls
     */
    public abstract ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, ActivationOption configuration);
}
