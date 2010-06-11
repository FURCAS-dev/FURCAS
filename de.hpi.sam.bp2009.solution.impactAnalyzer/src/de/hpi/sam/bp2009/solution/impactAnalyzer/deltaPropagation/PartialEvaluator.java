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

    // TODO allow clients to call evaluate without specifying a valid context object which leads to leaving self undefined, throwing an exception if self is being accessed
    public Object evaluate(Object context, CallExp e, Object valueOfSourceExpression) {
        factory.setExpressionValue((OCLExpression) e.getSource(), valueOfSourceExpression);
        return ocl.evaluate(context, e);
    }
}
