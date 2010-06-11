package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * Can evaluate a {@link CallExp} expression, given the evaluation result of its {@link CallExp#getSource() source}
 * expression. For this, it uses an adapted OCL evaluation environment.
 * 
 * @author Axel Uhl
 *
 */
public class PartialEvaluator {
    private OCL ocl;
    private Helper helper;
    private PartialEcoreEnvironmentFactory factory = new PartialEcoreEnvironmentFactory();
    
    public PartialEvaluator() {
        ocl = OCL.newInstance(factory);
        helper = ocl.createOCLHelper();
    }
    
    public OCL getOcl() {
        return ocl;
    }

    public Helper getHelper() {
        return helper;
    }

    /**
     * Evaluates <tt>e</tt>, assuming <tt>valueOfSourceExpression</tt> is the value to which
     * {@link CallExp#getSource() e's source expression} evaluates. This means that during <tt>e</tt>'s
     * evaluation the evaluator won't attempt to evaluate the source expression but uses the
     * value provided in <tt>valueOfSourceExpression</tt> instead.<p>
     * 
     * @param context a value for <tt>self</tt> can optionally be provided here. If <tt>null</tt> is
     * specified, a {@link ValueNotFoundException} will be thrown upon trying to fetch the <tt>self</tt>
     * value.
     * @throws ValueNotFoundException in case a variable is accessed that hasn't previously been defined. This
     * can happen during partial evaluation when a variable would have been defined by a superior expression
     * of which <tt>e</tt> is only a subexpression.
     */
    public Object evaluate(Object context, CallExp e, Object valueOfSourceExpression) {
        factory.setExpressionValue((OCLExpression) e.getSource(), valueOfSourceExpression);
        return ocl.evaluate(context, e);
    }
}
