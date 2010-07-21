package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.test;

import junit.framework.TestCase;

import org.junit.Test;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.BenchmarkProcessor;


public class BenchmarkAsPluginTest extends TestCase{
	@Test
	public void testStartBenchmarks(){
		BenchmarkProcessor.start(100, 200, "/tmp/result.data", 1);
	}
}
