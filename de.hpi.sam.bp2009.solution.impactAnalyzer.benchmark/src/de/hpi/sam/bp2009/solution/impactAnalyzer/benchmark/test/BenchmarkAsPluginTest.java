package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.test;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.BenchmarkProcessor;


public class BenchmarkAsPluginTest extends TestCase{
	@Test
	public void testStartBenchmarks() throws IOException{
        BenchmarkProcessor.start(1, 1, "C:\\tmp\\result.data", 7, true, "C:\\tmp\\exceptions.dump", true,
                "modifyElementaryTypesEventTrace.trace", "NgpmModel.xmi", /* noShrinking */false,
                /* oclId */ null /* meaning ALL */);
	}
}
