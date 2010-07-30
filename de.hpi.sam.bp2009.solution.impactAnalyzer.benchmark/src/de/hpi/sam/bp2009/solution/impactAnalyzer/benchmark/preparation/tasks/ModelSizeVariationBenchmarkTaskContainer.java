package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import org.eclipse.emf.ecore.resource.Resource;

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

	    	/*for(BenchmarkTask task : this){
	    	    if(task.getResult() != null && task.getResult() instanceof Collection<?>){
	    		Collection<EObject> affectedElements = (Collection<EObject>)task.getResult();

	    		OCL ocl = OCLWithHiddenOpposites.newInstance();
			ocl = OCLWithHiddenOpposites.newInstance(ocl.getEnvironment().getFactory().createPackageContext(ocl.getEnvironment(), path));

			ocl.evaluate(null, (ModelSizeVariationBenchmarkTask));
	    	    }
	    	}*/

	}

}
