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
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.RawNotification;

public class ModelSizeVariationBenchmarkTask implements BenchmarkTask{

    private final ImpactAnalyzer ia;
    private final RawNotification rawNotification;
    private Notification notification;
    private Resource model;

    private final LinkedHashMap<String, String> additionalInformation = new LinkedHashMap<String, String>();
    private final LinkedHashMap<String, String> additionalMeasurementInformation = new LinkedHashMap<String, String>();

    private Collection<EObject> result = null;

    public ModelSizeVariationBenchmarkTask(OCLExpression expression, EClass context, RawNotification notification, ImpactAnalyzer imp, String oclId, String notificationId, String benchmarkTaskId, String optionId) {
    	rawNotification = notification;
		ia = imp;

		additionalInformation.put("optionId", optionId);
		additionalInformation.put("benchmarkTaskId", benchmarkTaskId);
		additionalInformation.put("notificationId", notificationId);
		additionalInformation.put("oclId", oclId);
    }

    @Override
    public boolean activate(){
    	// For creating the notification the model is changed. Therefore the
    	// creation of notifications shall be happen just before the benchmark task
    	// is executed.
    	assert getModel() != null;

    	additionalInformation.put("resourceUri", String.valueOf(getModel().getURI().toString().replaceAll("\t", "")));
    	additionalInformation.put("modelSize", String.valueOf(getModelSize(getModel())));

    	notification = rawNotification.convertToNotification(getModel());

    	if(notification == null) {
    		//System.out.println("activated: " + (notification != null));
    		//System.out.println(rawNotification.getEventType());
    	}

    	return notification != null;
    }

    @Override
    public void beforeCall() {
    	assert additionalMeasurementInformation.size() == 0;
    	assert result == null;

    	if(notification == null)
	    throw new RuntimeException("notification cannot be created");
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

	public void setModel(Resource model) {
		this.model = model;
	}

	public Resource getModel() {
		return model;
	}

}
