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

    public Object evaluate(Object context, CallExp e, Object valueOfSourceExpression) {
        // TODO somehow set the value of the source expression in the evaluation environment, in a thread-safe manner
        factory.setExpressionValue((OCLExpression) e.getSource(), valueOfSourceExpression);
        // ((PartialEcoreEvaluationEnvironment) ocl.getEvaluationEnvironment()).set
        return ocl.evaluate(context, e);
    }
}
