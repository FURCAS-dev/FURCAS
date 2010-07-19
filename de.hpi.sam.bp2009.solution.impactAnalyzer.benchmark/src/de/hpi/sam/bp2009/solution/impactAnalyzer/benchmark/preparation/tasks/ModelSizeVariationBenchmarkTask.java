package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;

public class ModelSizeVariationBenchmarkTask implements BenchmarkTask{
    private final ImpactAnalyzer ia;
    private final Notification notification;

    private final LinkedHashMap<String, String> additionalInformation = new LinkedHashMap<String, String>();
    private final LinkedHashMap<String, String> additionalMeasurementInformation = new LinkedHashMap<String, String>();

    private Collection<EObject> result = null;

    public ModelSizeVariationBenchmarkTask(OCLExpression expression, EClass context, Resource model, Notification notification, ImpactAnalyzer imp, String oclId, String notificationId, String benchmarkTaskId) {
	this.notification = notification;
	ia = imp;
		additionalInformation.put("benchmarkTaskId", benchmarkTaskId);
		//additionalInformation.put("notification", String.valueOf(notification.hashCode()));
		additionalInformation.put("notificationId", notificationId);
		additionalInformation.put("oclId", oclId);
		additionalInformation.put("modelSize", String.valueOf(getModelSize(model)));
		additionalInformation.put("resourceUri", String.valueOf(model.getURI().toString().replaceAll("\t", "")));
    }

    @Override
    public void beforeCall() {
	assert additionalMeasurementInformation.size() == 0;
	assert result == null;
    }

    @Override
    public Collection<EObject> call() throws Exception {
	result = ia.getContextObjects(notification);

	return null;
    }


    @Override
    public void afterCall() {
	assert result != null;

	additionalMeasurementInformation.put("noContextObjects", String.valueOf(result.size()));

	result = null;
    }

    public Notification getNotification(){
	return notification;
    }


    @Override
    public String toString(){
	return getAdditionalInformation().toString();
    }

    public Notification getRecentNotificiation() {
	return notification;
    }

    @Override
    public Map<String, String> getAdditionalInformation() {
    	return additionalInformation;
    }

    private int getModelSize(Resource resource){
	int resourceSize = 0;
	TreeIterator<EObject> iterator = resource.getAllContents();
	while(iterator.hasNext()){
	    iterator.next();
	    resourceSize++;
	}
	return resourceSize;
    }

    @Override
    public Map<String, String> getAdditionalMeasurementInformation() {
	LinkedHashMap<String, String> result = new LinkedHashMap<String,String>();
	result.putAll(additionalMeasurementInformation);
	additionalMeasurementInformation.clear();
	return result;
    }

}
