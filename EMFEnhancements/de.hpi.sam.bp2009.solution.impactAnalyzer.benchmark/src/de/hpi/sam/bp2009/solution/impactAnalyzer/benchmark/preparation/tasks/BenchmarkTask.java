package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Callable;

import org.eclipse.emf.ecore.EObject;

/**
 * A BenchmarkTask is a class which implements the callable interface, and
 * therefore contains the call of the logic or the algorithm, which shall be
 * measured by a benchmark. Thus, for different types of benchmarks different
 * BenchmarkTasks are necessary.
 *
 * @author Manuel Holzleitner (D049667)
 */
public interface BenchmarkTask extends Callable<Collection<EObject>> {
    public boolean activate();
    public void beforeCall();
    public void afterCall();
    public boolean deactivate();

    public void callEvaluation();

    public Map<String, String> getAdditionalMeasurementInformation();
    public Map<String, String> getAdditionalInformation();
    public Object getResult();
}
