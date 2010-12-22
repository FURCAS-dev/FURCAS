package com.sap.emf.ocl.trigger;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * Used to provide an {@link OCLExpression} with an optional context type. This is required if the expression
 * does not make use of the <code>self</code> variable which disallows inferring the context type automatically.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class ExpressionWithContext {
    private final OCLExpression expression;
    private final EClass context;

    /**
     * Providing a non-<code>context</code> class is necessary in case <code>expression</code> does not make use of the
     * <code>self</code> variable. Otherwise, if a redundant context type is specified, it must be the same as the context
     * type inferred from the <code>self</code> expression.
     */
    public ExpressionWithContext(OCLExpression expression, EClass context) {
        super();
        this.expression = expression;
        this.context = context;
    }
    
    public OCLExpression getExpression() {
        return expression;
    }
    public EClass getContext() {
        return context;
    }
    
    public String toString() {
        return "context "+context.getName()+": "+expression;
    }
}
