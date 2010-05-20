package de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper;

import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.ocl.ecore.OCLExpression;

public class ExampleApp extends AdapterImpl {
    private final OCLExpression expression;
    private final HashSet<OCLExpression> affectedStmts;

    public ExampleApp(OCLExpression exp, HashSet<OCLExpression> affectedStmts) {
        this.expression = exp;
        this.affectedStmts = affectedStmts;
    }

    @Override
    public void notifyChanged(Notification msg) {
        this.affectedStmts.add(expression);

    }

}
