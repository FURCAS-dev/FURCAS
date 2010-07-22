package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark;

import java.util.Queue;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution.BenchmarkExecutionProcessor;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTaskContainer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTaskPreparer;

/**
 * The {@link BenchmarkProcessor}s main purpose is to analyze the overall
 * performance of the instance scope analysis. However, the BenchmarkProcessor
 * could also be used for a broad range of micro-benchmarks.
 *
 * The BenchmarkProcessor is able to perform benchmarks in a simple and fast way
 * by measuring System.nanoTime without respecting e.g. hot spot compiling or
 * class loading. Additionally, extensive and robust benchmarks can be performed
 * by using the bb.util.Benchmark library [1]
 *
 * In order to implement a new benchmark a new class which implements the
 * {@link BenchmarkTask} interface shall be created.
 *
 * @see http://ellipticgroup.com/html/benchmarkingArticle.html
 *
 * @author Manuel Holzleitner (D049667)
 */

public class BenchmarkProcessor {
    //FIXME: Implement code for starting benchmark program
    public static void main(String[] args) {
	try {
	    Options options = new Options();

	    options.addOption("wu", "warmups", true, "Number of warm ups before measuring task (required)");
	    options.addOption("m", "measures", true, "Number of measurements per benchmark task (required)");
	    options.addOption("o", "output", true, "Output file destination (required)");
	    options.addOption("j", "jobs", true, "Number of parallel jobs for benchmarking. Default is 1");
	    options.addOption("h", "help", false, "Show this help");

	    CommandLineParser parser = new PosixParser();
	    CommandLine cmd = parser.parse(options, args);

	    if(cmd.hasOption("h") || !cmd.hasOption("wu") || !cmd.hasOption("m")||  !cmd.hasOption("o") ){
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp( "Impact Analysis Benchmark Environment", options );
	    }else{
	    int numberOfJobs = cmd.hasOption("j") ? Integer.parseInt(cmd.getOptionValue("j")) : 1;
		start(Integer.parseInt(cmd.getOptionValue("wu")),Integer.parseInt(cmd.getOptionValue("m")), cmd.getOptionValue("o"),  numberOfJobs);
	    }

	} catch (ParseException e) {
	    System.err.println( "Parsing failed.  Reason: " + e.getMessage() );
	}
    }

    	public static void start(int warmUps, int measures, String outputPath, int numberOfJobs) {
    	    	System.out.println("Impact Analysis Benchmark started with " + warmUps + " warm-ups and " + measures + " measures per benchmark task");
    	    	
    	    	ProcessingOptions.setNumberOfWarmUps(warmUps);
    	    	ProcessingOptions.setNumberOfMeasures(measures);
    	    	if(numberOfJobs > 1){
    	    		System.out.println("Started in parallel mode with " + numberOfJobs + " jobs");
    	    		ProcessingOptions.setNumberOfJobs(numberOfJobs);
    	    	}
    	    	
    	    	OutputOptions.setOutputPath(outputPath);

		// Preparing
		Queue<BenchmarkTaskContainer> containerQueue = BenchmarkTaskPreparer.prepareModelSizeVariationBenchmarkTasks();

		// Processing
		if(numberOfJobs > 1){
			BenchmarkExecutionProcessor.processBenchmarksInParallel(containerQueue, numberOfJobs);
		}else{
			BenchmarkExecutionProcessor.processBenchmarks(containerQueue);
		}
	}
}