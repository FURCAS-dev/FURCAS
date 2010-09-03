package com.sap.emf.ocl.prepared;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.LiteralExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * Similar to a JDBC prepared statement, where parameters can be set to specific values before executing it,
 * a prepared OCL expression can have a number of parameters which are substituted by values before
 * evaluating the expression. Only {@link LiteralExp} expressions can be configured using parameters.<p>
 * 
 * The expression that is parameterized will be modified upon evaluation. Therefore, evaluation is
 * synchronized on this prepared expression object so that no race conditions may occur when multiple
 * threads evaluate the same parameterized expression for different parameter values.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class PreparedOCLExpression {
    private final OCLExpression expression;
    private List<Parameter> params;
    
    public PreparedOCLExpression(OCLExpression expression, LiteralExp... params) {
        for (LiteralExp param : params) {
            if (OclHelper.getRootExpression(param) != expression) {
                throw new RuntimeException("Parameter expression from wrong root expression: "+
                        "Should be "+expression+" but was "+OclHelper.getRootExpression(param));
            }
        }
        this.expression = expression;
        this.params = new ArrayList<Parameter>(params.length);
        for (LiteralExp param : params) {
            this.params.add(getParameterFor(param));
        }
    }
    
    /**
     * Factory method that creates the appropriate {@link Parameter} implementation instance
     * for the parameterizable literal expression <code>param</code>.
     */
    private Parameter getParameterFor(LiteralExp param) {
        Parameter result;
        switch (param.eClass().getClassifierID()) {
        case EcorePackage.BOOLEAN_LITERAL_EXP:
            result = new BooleanParameter((BooleanLiteralExp) param);
            break;
        default:
            throw new RuntimeException("Unknown literal expression type "+param.getClass().getName());
        }
        return result;
    }

    public synchronized Object evaluate(Object context, Object... values) {
        if (values.length != params.size()) {
            throw new RuntimeException("Number of parameters does not match. Expected "+params.size()+
                    " but got "+values.length);
        }
        int i=0;
        for (Parameter p : params) {
            p.set(values[i++]);
        }
        return getOCL().evaluate(context, expression);
    }

    private OCL getOCL() {
        // TODO Auto-generated method stub
        return null;
    }
}
