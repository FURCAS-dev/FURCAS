package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution.BenchmarkExecutionProcessor;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationResourceLoader;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTask;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTaskPreparer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks.BenchmarkTaskStepwiseBuilder;

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
    public static void main(String[] args) throws NumberFormatException, IOException {
	try {
	    Options options = new Options();

	    options.addOption("wu", "warmups", true, "Number of warm ups before measuring task (required)");
	    options.addOption("m", "measures", true, "Number of measurements per benchmark task (required)");
	    options.addOption("o", "output", true, "Output file destination (required)");
	    options.addOption("j", "jobs", true, "Number of parallel jobs for benchmarking. Default is 1");
	    options.addOption("d", "delayprep",true, "Delay preparation of benchmark task (true[default]/false)");
	    options.addOption("e", "excdump", true, "An exception dump file will be written to the specified path");
	    options.addOption("ob", "outbuffer", true, "Buffer size of output stream");

	    options.addOption("tp", "tracepath", true, "Name of tracefile which shall be replayed");
	    options.addOption("mp", "modelpath", true, "Name of serialized model file");
	    options.addOption("sf", "showfiles", false, "Show which trace files and model files are available");

	    //Default option
	    //options.addOption("pd", "printdscr", true, "Print separate description files for R reports with mapping from result identifiers to descriptions for OCL Expressions, Notifications and Models");

	    options.addOption("v", "verbose", false, "Run in verbose mode");
	    options.addOption("h", "help", false, "Show this help");

	    CommandLineParser parser = new PosixParser();
	    CommandLine cmd = parser.parse(options, args);

	    if(cmd.hasOption("h") || !cmd.hasOption("wu") || !cmd.hasOption("m")||  !cmd.hasOption("o") ){
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp( "Impact Analysis Benchmark Environment v0.1", options );
	    }else{
	    int numberOfJobs = cmd.hasOption("j") ? Integer.parseInt(cmd.getOptionValue("j")) : 1;
	    boolean delayPreparation = cmd.hasOption("d") ? Boolean.parseBoolean(cmd.getOptionValue("d")) : true;


	    String modelFile = "";
	    String eventTraceFile = "";
	    if(cmd.hasOption("sf")){
	    	printAvailableEventFixtures();
	    	printAvailableModelFixtures();
	    }else{
	    	if(!cmd.hasOption("tp")){
	    		System.out.println("You started benchmarks without specifying a correct event trace fixture explicitly.");
	    		//printAvailableEventFixtures();

	    		eventTraceFile = "modifyElementaryTypesEventTrace.trace";
	    	}else{
	    		eventTraceFile = cmd.getOptionValue("tp");
	    	}
	    	System.out.println("Choosing fixture: " + eventTraceFile);
	    	System.out.println("");

	    	if(!cmd.hasOption("mp")){
	    		System.out.println("You started benchmarks without specifying a correct model fixture explicitly.");
	    		//printAvailableModelFixtures();

	    		modelFile = "NgpmModel.xmi";
	    	}else{
	    		modelFile = cmd.getOptionValue("mp");
	    	}
    		System.out.println("Choosing fixture: " + modelFile);
    		System.out.println("");
	    }

	    start(Integer.parseInt(cmd.getOptionValue("wu")),Integer.parseInt(cmd.getOptionValue("m")), cmd.getOptionValue("o"),  numberOfJobs, delayPreparation, cmd.getOptionValue("e"), cmd.hasOption("v"), eventTraceFile, modelFile);
	    }

	} catch (ParseException e) {
	    System.err.println( "Parsing failed.  Reason: " + e.getMessage() );
	}
    }

    	public static void printAvailableEventFixtures(){
    		System.out.println("The following event trace fixtures are available and can be specified with the --tracepath option:");

    		int number = 1;
    		for(String path : NotificationResourceLoader.getFilenamesOfEventFixtures()){
    			System.out.println("[" + number + "] " + path);
    			number++;
    		}
    	}

    	public static void printAvailableModelFixtures(){
    		System.out.println("The following model fixtures are available and can be specified with the --modelpath option:");

    		int number = 1;
    		for(String path : NotificationResourceLoader.getFilenamesOfModelFixture()){
    			System.out.println("[" + number + "] " + path);
    			number++;
    		}
    	}


    	public static void start(int warmUps, int measures, String outputPath, int numberOfJobs, boolean delayPreparation, String dumpFilePath, boolean verbose, String eventTraceFile, String modelFile) throws IOException {
    	    	System.out.println("Impact Analysis Benchmark started with " + warmUps + " warm-ups and " + measures + " measures per benchmark task");

    	    	ProcessingOptions.setNumberOfWarmUps(warmUps);
    	    	ProcessingOptions.setNumberOfMeasures(measures);
    	    	if(numberOfJobs > 1){
    	    		System.out.println("Started in parallel mode with " + numberOfJobs + " jobs");
    	    		ProcessingOptions.setNumberOfJobs(numberOfJobs);
    	    	}
    	    	ProcessingOptions.setVerbose(verbose);

    	    	PathOptions.setOutputPath(outputPath);
    	    	PathOptions.setExceptionDumpFilePath(dumpFilePath);

    	    	PathOptions.setModelFixturePath(modelFile);
    	    	PathOptions.setEventTraceFixturePath(eventTraceFile);

    	    	BenchmarkTaskStepwiseBuilder builder = BenchmarkTaskPreparer.createBenchmarkBuilder();
    	    	builder.printDescriptionFiles();
			// Preparing
			// Processing
			if (numberOfJobs > 1) {
				BenchmarkExecutionProcessor.processBenchmarksInParallel(builder, delayPreparation, numberOfJobs);
			} else {
				BenchmarkExecutionProcessor.processBenchmarks(builder, delayPreparation);
			}



	}
}