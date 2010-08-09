package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.model.ModelCloner;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;

public class ModelSizeVariationBenchmarkTaskContainer extends BenchmarkTaskContainer{
	private static final long serialVersionUID = 1L;
	private final Resource modelToClone;
	private final String containerId;
	private final ActivationOption option;

	public ModelSizeVariationBenchmarkTaskContainer(Resource modelToClone, ActivationOption option, String containerId){
		this.modelToClone = modelToClone;
		this.option = option;
		this.containerId = containerId;
	}

	@Override
	public void beforeBenchmark() {
		cloneModelAndAttachToBenchmarkTasks();
		OptimizationActivation.setOption(option);
	}

	private void cloneModelAndAttachToBenchmarkTasks() {
	    Resource clonedModel = ModelCloner.cloneResource(modelToClone, "x" + containerId);
	    //Resource clonedModel = modelToClone;
	    for(BenchmarkTask task : this){
	    	((ModelSizeVariationBenchmarkTask)task).setModel(clonedModel);
	    }
	}

	@Override
	public void afterBenchmark() {
	    	//TODO: implement comparing if evaluation result stays the same
	    	//Resource clonedModel = ModelCloner.cloneResource(modelToClone, "x" + containerId);

	    	/*Resource clonedModel = ModelCloner.cloneResource(modelToClone, "y" + containerId);
	    	while(!this.isEmpty()){
	    	    ModelSizeVariationBenchmarkTask task = (ModelSizeVariationBenchmarkTask)this.remove();

	    	    if(task.getResult() != null && task.getResult() instanceof Collection<?>){
	    		@SuppressWarnings("unchecked")
			Collection<EObject> affectedElements = (Collection<EObject>)task.getResult();

	    		OCL ocl = task.getOcl();

	    		Collection<Object> beforeEvaluationResult = new LinkedList<Object>();
	    		for(EObject affectedElement : affectedElements){
	    		    beforeEvaluationResult.add(ocl.evaluate(affectedElement, task.getExpression().getExpression()));
	    		}

	    		// Now change model after notification
	    		task.getRawNotification().convertToNotification(clonedModel);

	    		task.getAdditionalInformation().put("beforeNoInvalidEvals", String.valueOf(task.getNoOfInvalidEvaluations(beforeEvaluationResult)));
	    		task.getAdditionalInformation().put("noEqualResultsBeforeAndAfter", String.valueOf(getNumberOfEqualResults(beforeEvaluationResult, task.getEvaluationResult())));
	    	    }
	    	}*/
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
