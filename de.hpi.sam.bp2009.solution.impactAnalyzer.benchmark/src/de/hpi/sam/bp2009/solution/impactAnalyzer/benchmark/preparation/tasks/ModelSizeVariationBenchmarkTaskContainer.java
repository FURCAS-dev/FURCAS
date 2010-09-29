package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.model.ModelCloner;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;

public class ModelSizeVariationBenchmarkTaskContainer extends BenchmarkTaskContainer{
	private static final long serialVersionUID = 1L;
	private final Resource modelToClone;
	private final String containerId;
	private final ActivationOption option;

	private final HashMap<OCLExpressionWithContext, AllInstanceEvaluationMeasurement> allInstanceMeasureCache = new HashMap<OCLExpressionWithContext, AllInstanceEvaluationMeasurement>();

	public ModelSizeVariationBenchmarkTaskContainer(Resource modelToClone, ActivationOption option, String containerId){
		this.modelToClone = modelToClone;
		this.option = option;
		this.containerId = containerId;
	}

	@Override
	public void beforeBenchmark() {
		cloneModelAndAttachToBenchmarkTasks();
		OptimizationActivation.setOption(option);

		measureAllInstancesAndAttachToBenchmarkTasks();
	}

	private void cloneModelAndAttachToBenchmarkTasks() {
	    Resource clonedModel = ModelCloner.cloneResource(modelToClone, "x" + containerId);
	    Resource clonedModelBeforeChange = ModelCloner.cloneResource(modelToClone, "y" + containerId);
	    //Resource clonedModel = modelToClone;
	    for(BenchmarkTask task : this){
	    	((ModelSizeVariationBenchmarkTask)task).setModel(clonedModel);
	    	((ModelSizeVariationBenchmarkTask)task).setModelForIaAccuracyDetermination(clonedModelBeforeChange);
	    }
	}

	private void measureAllInstancesAndAttachToBenchmarkTasks(){
	    BenchmarkTask firstTask = this.element();

	    // Model and OppositeEndFinder is the same for all benchmark tasks in one container
	    Resource model = ((ModelSizeVariationBenchmarkTask)firstTask).getModel();
	    OppositeEndFinder oppositeEndFinder = ((ModelSizeVariationBenchmarkTask)firstTask).getOppositeEndFinder();

	    for(BenchmarkTask task : this){
	    	OCLExpressionWithContext expression = ((ModelSizeVariationBenchmarkTask)task).getExpression();

	    	if(allInstanceMeasureCache.containsKey(expression)){
	    	    ((ModelSizeVariationBenchmarkTask)task).setAllInstanceEvaluationMeasurement(allInstanceMeasureCache.get(expression));
	    	}else{
	    	    AllInstanceEvaluationMeasurement measurement = new AllInstanceEvaluationMeasurement(oppositeEndFinder, model, expression);
	    	    measurement.measureAllInstances();

	    	    allInstanceMeasureCache.put(expression, measurement);
	    	    ((ModelSizeVariationBenchmarkTask)task).setAllInstanceEvaluationMeasurement(measurement);
	    	}
	    }
	}

	@Override
	public void afterBenchmark() {

	}

	@SuppressWarnings("unused")
	private int getNumberOfEqualResults(Collection<Object> result1, Collection<Object> result2){
	    int equalCounter = 0;
	    for(Object elementInResult1 : result1){
		for(Object elementInResult2 : result2){
		    if(elementInResult1 instanceof EList<?> && elementInResult2 instanceof EList<?>){
			System.out.println("List result");
		    }else if(elementInResult1 instanceof EObject && elementInResult2 instanceof EObject){
			if(EcoreUtil.equals((EObject)elementInResult1, (EObject)elementInResult2)){
				equalCounter++;
				break;
			    }
		    }else{
			if(elementInResult1.equals(elementInResult2)){
			    equalCounter++;
			    break;
			}
		    }

		}
	    }
	    return equalCounter;
	}

}
