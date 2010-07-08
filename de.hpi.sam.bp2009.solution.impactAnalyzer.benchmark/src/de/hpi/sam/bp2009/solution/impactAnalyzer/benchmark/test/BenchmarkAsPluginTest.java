package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.test;

import org.junit.Test;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.BenchmarkProcessor;
import junit.framework.TestCase;


public class BenchmarkAsPluginTest extends TestCase{
	@Test
	public void testStartBenchmarks(){
		BenchmarkProcessor.start();
	}
}
