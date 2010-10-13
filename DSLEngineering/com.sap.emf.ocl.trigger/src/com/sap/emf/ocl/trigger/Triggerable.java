package com.sap.emf.ocl.trigger;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

/**
 * A callback that wants to get triggered when one of the expressions returned from {@link #getTriggerExpressions()} may
 * have changed its value on some object observed by the {@link TriggerManager}.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public interface Triggerable {
    Collection<ExpressionWithContext> getTriggerExpressions();
    void notify(OCLExpression expression, Collection<EObject> affectedContextObjects, OppositeEndFinder oppositeEndFinder);
    
    /**
     * Used to provide an {@link OCLExpression} with an optional context type. This is required if the expression
     * does not make use of the <code>self</code> variable which disallows inferring the context type automatically.
     * 
     * @author Axel Uhl (D043530)
     *
     */
    public static class ExpressionWithContext {
        private final OCLExpression expression;
        private final EClass context;
        private final boolean notifyNewContextElements;

        /**
         * Providing a non-<code>context</code> class is necessary in case <code>expression</code> does not make use of the
         * <code>self</code> variable. Otherwise, if a redundant context type is specified, it must be the same as the context
         * type inferred from the <code>self</code> expression.
         * 
         * @param notifyNewContextElements
         *            if <code>true</code>, events will be forwarded also if objects that conform to the context type (implicitly
         *            or explicitly provided) are added to the resource set(s) observed. This is useful if an <em>initial</em>
         *            evaluation of the <code>expression</code> is desired once an element enters a resource set.
         */
        public ExpressionWithContext(OCLExpression expression, EClass context, boolean notifyNewContextElements) {
            super();
            this.expression = expression;
            this.context = context;
            this.notifyNewContextElements = notifyNewContextElements;
        }
        
        public OCLExpression getExpression() {
            return expression;
        }
        public EClass getContext() {
            return context;
        }
        public boolean isNotifyNewContextElements() {
            return notifyNewContextElements;
        }
    }
}
