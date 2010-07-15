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
import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl;


public class ModelSizeVariationBenchmarkTask implements BenchmarkTask{
    private final OCLExpression expression;
    private final ImpactAnalyzer ia;
    private final Resource model;
    private final Notification notification;

    public ModelSizeVariationBenchmarkTask(OCLExpression expression, EClass context, Resource model, Notification notification) {
	this.expression = expression;
	this.model = model;
	this.notification = notification;
	ia = new ImpactAnalyzerImpl(expression, context);
    }

    @Override
    public Collection<EObject> call() throws Exception {
	ia.getContextObjects(notification);

	return null;
    }

    public Resource getModel(){
	return model;
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
	LinkedHashMap<String, String> additionalInformation = new LinkedHashMap<String, String>();
	additionalInformation.put("oclString", expression.toString().replaceAll("\t", "").replaceAll("\n", "").replaceAll(" ", ""));
	additionalInformation.put("modelSize", String.valueOf(getModelSize(model)));
	additionalInformation.put("resourceUri", String.valueOf(getModelSize(model)));

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

}
