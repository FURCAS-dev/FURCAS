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
		Resource clonedModel = ModelCloner.cloneResource(modelToClone, "x" + containerId);
		//Resource clonedModel = modelToClone;
		for(BenchmarkTask task : this){
			((ModelSizeVariationBenchmarkTask)task).setModel(clonedModel);
		}
		OptimizationActivation.setOption(option);
	}

	@Override
	public void afterBenchmark() {
		
	}

}
