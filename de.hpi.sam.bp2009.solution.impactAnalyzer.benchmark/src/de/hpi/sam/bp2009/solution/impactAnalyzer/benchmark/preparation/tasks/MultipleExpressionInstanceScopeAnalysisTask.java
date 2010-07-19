package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;

public class MultipleExpressionInstanceScopeAnalysisTask implements BenchmarkTask{

    private final Notification notification;
    private final Collection<ImpactAnalyzer> analyzerList;

    public MultipleExpressionInstanceScopeAnalysisTask(Collection<ImpactAnalyzer> analyzerList, Notification notification) {
	this.analyzerList = analyzerList;
	this.notification = notification;
    }

    @Override
    public Collection<EObject> call() throws Exception {
	for(ImpactAnalyzer analyzer : analyzerList){
		analyzer.getContextObjects(notification);
	}

	return null;
    }

    @Override
    public String toString(){
    	return notification.toString();
    }

    @Override
    public Map<String, String> getAdditionalInformation() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void beforeCall() {
	// TODO Auto-generated method stub

    }

    @Override
    public void afterCall() {
	// TODO Auto-generated method stub

    }

    @Override
    public Map<String, String> getAdditionalMeasurementInformation() {
	return new LinkedHashMap<String, String>();
    }

}
