package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;

public class MultipleNotificationInstanceScopeAnalysisTask implements BenchmarkTask{
    private final OCLExpression expression;
    private final Collection<Notification> notiList;
    private final ImpactAnalyzer ia;

    public MultipleNotificationInstanceScopeAnalysisTask(OCLExpression expression, EClass context, Collection<Notification> noti) {
	this.expression = expression;
	this.notiList = noti;
	this.ia = new ImpactAnalyzerImpl(expression, context);
    }

    @Override
    public Collection<EObject> call() throws Exception {
	for(Notification notification : notiList){
		ia.getContextObjects(notification);
	}
	 
	return null;
    }

    @Override
    public String toString(){
	return expression.toString();
    }

}
