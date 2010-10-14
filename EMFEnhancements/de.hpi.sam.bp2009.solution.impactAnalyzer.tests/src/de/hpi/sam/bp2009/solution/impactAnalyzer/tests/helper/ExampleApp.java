package de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper;

import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.ocl.ecore.ExpressionInOCL;

public class ExampleApp extends AdapterImpl {
    private final ExpressionInOCL expression;
    private final HashSet<ExpressionInOCL> affectedStmts;

    public ExampleApp(ExpressionInOCL exp, HashSet<ExpressionInOCL> affectedStmts) {
        this.expression = exp;
        this.affectedStmts = affectedStmts;
    }

    @Override
    public void notifyChanged(Notification msg) {
        this.affectedStmts.add(expression);
    }

}
