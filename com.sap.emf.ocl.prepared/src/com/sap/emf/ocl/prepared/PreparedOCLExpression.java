package com.sap.emf.ocl.prepared;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ocl.ecore.LiteralExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.emf.ocl.prepared.parameters.Parameter;
import com.sap.emf.ocl.prepared.parameters.ParameterFactory;
import com.sap.emf.ocl.util.OclHelper;

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
    private OppositeEndFinder oppositeEndFinder;
    private EcoreEnvironmentFactoryWithHiddenOpposites environmentFactory;
    
    public PreparedOCLExpression(OCLExpression expression, LiteralExp... params) {
        for (LiteralExp param : params) {
            if (OclHelper.getRootExpression(param) != expression) {
                throw new RuntimeException("Parameter expression from wrong root expression: "+
                        "Should be "+expression+" but was "+OclHelper.getRootExpression(param));
            }
        }
        this.expression = expression;
        this.params = new ArrayList<Parameter>(params.length);
        ParameterFactory factory = ParameterFactory.INSTANCE;
        for (LiteralExp param : params) {
            this.params.add(factory.getParameterFor(param));
        }
    }
    
    public PreparedOCLExpression(EcoreEnvironmentFactoryWithHiddenOpposites environmentFactory,
            OCLExpression expression, LiteralExp... params) {
        this(expression, params);
        this.environmentFactory = environmentFactory;
    }
    
    public PreparedOCLExpression(OppositeEndFinder oppositeEndFinder,
            OCLExpression expression, LiteralExp... params) {
        this(expression, params);
        this.oppositeEndFinder = oppositeEndFinder;
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
        if (oppositeEndFinder != null) {
            return OCLWithHiddenOpposites.newInstance(oppositeEndFinder);
        } else {
            if (environmentFactory != null) {
                return OCLWithHiddenOpposites.newInstance(environmentFactory);
            } else {
                return OCLWithHiddenOpposites.newInstance();
            }
        }
    }
}
