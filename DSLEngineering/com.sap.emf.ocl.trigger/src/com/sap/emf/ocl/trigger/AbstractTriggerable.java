package com.sap.emf.ocl.trigger;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.ocl.ecore.OCLExpression;

/**
 * A simple abstract implementation of the {@link Triggerable} interface that can be constructed with a combination
 * of {@link OCLExpression}s and {@link ExpressionWithContext}s for whose value changes to listen. Subclasses then
 * only have to implement the {@link Triggerable#notify(OCLExpression, Collection, com.sap.emf.ocl.hiddenopposites.OppositeEndFinder)}
 * operation that tells what to do upon an expression changing its value.
 */
public abstract class AbstractTriggerable implements Triggerable {
    private final Collection<ExpressionWithContext> triggerExpressionsWithContext;
    private final Collection<OCLExpression> triggerExpressionsWithoutContext;
    private final boolean notifyOnNewContextElements;

    /**
     * Will get notified if any of the <code>triggerExpressions</code> changes its value. No notification will occur
     * for new elements being added to the scope observed.
     * 
     * @param triggerExpressions must not be <code>null</code>
     */
    public AbstractTriggerable(Collection<ExpressionWithContext> triggerExpressions) {
        if (triggerExpressions == null) {
            throw new RuntimeException("triggerExpressions argument must not be null");
        }
        this.triggerExpressionsWithContext = triggerExpressions;
        this.triggerExpressionsWithoutContext = Collections.emptySet();
        notifyOnNewContextElements = false;
    }

    /**
     * Will get notified if any of the <code>triggerExpressionsWithContext</code> or <code>triggerExpressionsWithoutContext</code>
     * changes its value. No notification will occur for new elements being added to the scope observed.
     * 
     * @param triggerExpressionsWithContext passing <code>null</code> is permissible
     * @param triggerExpressionsWithoutContext passing <code>null</code> is permissible
     */
    public AbstractTriggerable(Collection<ExpressionWithContext> triggerExpressionsWithContext, Collection<OCLExpression> triggerExpressionsWithoutContext) {
        if (triggerExpressionsWithContext == null) {
            triggerExpressionsWithContext = Collections.emptySet();
        }
        this.triggerExpressionsWithContext = triggerExpressionsWithContext;
        if (triggerExpressionsWithoutContext == null) {
            triggerExpressionsWithoutContext = Collections.emptySet();
        }
        this.triggerExpressionsWithoutContext = triggerExpressionsWithoutContext;
        notifyOnNewContextElements = false;
    }

    /**
     * Will get notified if any of the <code>triggerExpressions</code> changes its value. Notification will occur
     * for new elements being added to the scope observed if <code>notifyOnNewContextElements</code> is <code>true</code>.
     * 
     * @param triggerExpressions must not be <code>null</code>
     */
    public AbstractTriggerable(Collection<ExpressionWithContext> triggerExpressions, boolean notifyOnNewContextElements) {
        if (triggerExpressions == null) {
            throw new RuntimeException("triggerExpressions argument must not be null");
        }
        this.triggerExpressionsWithContext = triggerExpressions;
        this.triggerExpressionsWithoutContext = Collections.emptySet();
        this.notifyOnNewContextElements = notifyOnNewContextElements;
    }

    /**
     * Will get notified if any of the <code>triggerExpressionsWithContext</code> or <code>triggerExpressionsWithoutContext</code>
     * changes its value. Notification will occur for new elements being added to the scope observed if
     * <code>notifyOnNewContextElements</code> is <code>true</code>.
     * 
     * @param triggerExpressionsWithContext passing <code>null</code> is permissible
     * @param triggerExpressionsWithoutContext passing <code>null</code> is permissible
     */
    public AbstractTriggerable(Collection<ExpressionWithContext> triggerExpressionsWithContext,
            Collection<OCLExpression> triggerExpressionsWithoutContext, boolean notifyOnNewContextElements) {
        if (triggerExpressionsWithContext == null) {
            triggerExpressionsWithContext = Collections.emptySet();
        }
        this.triggerExpressionsWithContext = triggerExpressionsWithContext;
        if (triggerExpressionsWithoutContext == null) {
            triggerExpressionsWithoutContext = Collections.emptySet();
        }
        this.triggerExpressionsWithoutContext = triggerExpressionsWithoutContext;
        this.notifyOnNewContextElements = notifyOnNewContextElements;
    }

    @Override
    public Collection<ExpressionWithContext> getTriggerExpressionsWithContext() {
        return triggerExpressionsWithContext;
    }

    @Override
    public Collection<OCLExpression> getTriggerExpressionsWithoutContext() {
        return triggerExpressionsWithoutContext;
    }

    @Override
    public boolean notifyOnNewContextElements() {
        return notifyOnNewContextElements;
    }
}
