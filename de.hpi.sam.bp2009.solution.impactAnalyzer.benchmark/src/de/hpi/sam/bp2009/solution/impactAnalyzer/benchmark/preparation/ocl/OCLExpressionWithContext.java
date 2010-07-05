package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

public class OCLExpressionWithContext {
    private OCLExpression expr;
    private EClass classifier;

    public OCLExpressionWithContext(OCLExpression e, EClass c) {
        setContext(c);
        setExpression(e);
    }

    public String toString() {
        return "context " + getContext().getName() + " : " + getExpression().toString();
    }

    public void setContext(EClass classifier) {
	this.classifier = classifier;
    }

    public EClass getContext() {
	return classifier;
    }

    public void setExpression(OCLExpression expr) {
	this.expr = expr;
    }

    public OCLExpression getExpression() {
	return expr;
    }
}
