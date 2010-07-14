package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;

public class SingleNotificationInstanceScopeAnalysisTask implements BenchmarkTask{
    private final OCLExpression expression;
    private Notification noti;
    private final ImpactAnalyzer ia;

    public SingleNotificationInstanceScopeAnalysisTask(OCLExpression expression, Notification noti,
            EClass context) {
	this.expression = expression;
	setNotification(noti);
	ia = new ImpactAnalyzerImpl(expression, context);
    }

    @Override
    public Collection<EObject> call() throws Exception {
	return ia.getContextObjects(getNotification());
    }

    @Override
    public String toString(){
	return expression.toString();
    }

    public void setNotification(Notification noti) {
	this.noti = noti;
    }

    public Notification getNotification() {
	return noti;
    }
}
