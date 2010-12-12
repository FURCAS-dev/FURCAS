/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.benchmark;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.execution.BenchmarkExecutionProcessor;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.tasks.BenchmarkTask;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.tasks.BenchmarkTaskPreparer;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.tasks.BenchmarkTaskStepwiseBuilder;
import org.eclipse.ocl.examples.impactanalyzer.configuration.ActivationOption;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationResourceLoader;

/**
 * The {@link BenchmarkProcessor}s main purpose is to analyze the overall performance of the instance scope analysis. However, the
 * BenchmarkProcessor could also be used for a broad range of micro-benchmarks.
 * 
 * The BenchmarkProcessor is able to perform benchmarks in a simple and fast way by measuring System.nanoTime without respecting
 * e.g. hot spot compiling or class loading. Additionally, extensive and robust benchmarks can be performed by using the
 * bb.util.Benchmark library [1]
 * 
 * In order to implement a new benchmark a new class which implements the {@link BenchmarkTask} interface shall be created.
 * 
 * @see http://ellipticgroup.com/html/benchmarkingArticle.html
 * 
 * @author Manuel Holzleitner (D049667)
 */

public class BenchmarkProcessor {
    // FIXME: Implement code for starting benchmark program
    public static void main(String[] args) throws NumberFormatException, IOException {
        try {
           
            List<ActivationOption> optionList = new ArrayList<ActivationOption>();
            // TracebackStep
            optionList.add(new ActivationOption(true, true, true, true, "All optimizations activated, TracebackSteps"));
            optionList.add(new ActivationOption(false, true, true, true, "Without delta propagation, TracebackSteps"));
            optionList.add(new ActivationOption(true, false, true, true, "Without unused checks, TracebackSteps"));
            optionList.add(new ActivationOption(true, true, true, false, "Without OperationCallExp selection, TracebackSteps"));
            optionList.add(new ActivationOption(false, false, true, true, "Without delta propagation, without unused checks, TracebackSteps"));
            optionList.add(new ActivationOption(true, false, true, false, "Without unused checks, without OperationCallExp selection, TracebackSteps"));
            optionList.add(new ActivationOption(false, true, true, false, "Without delta propagation, without OperationCallExp selection, TracebackSteps"));
            optionList.add(new ActivationOption(false, false, true, false, "Without unused checks, without delta propagation, without OperationCallExp selection, TracebackSteps"));
            // NavigationStep
            optionList.add(new ActivationOption(true, true, false, false, "With delta propagation, NavigationSteps"));
            optionList.add(new ActivationOption(false, true, false, true, "Without delta propagation, NavigationSteps"));
            StringBuilder optionsDescription = new StringBuilder();
            for (int i = 0; i < optionList.size(); i++) {
                optionsDescription.append("\n  ");
                optionsDescription.append(i);
                optionsDescription.append(": ");
                optionsDescription.append(optionList.get(i).getOptionDescription());
            }
            Options options = new Options();
            options.addOption("wu", "warmups", true, "Number of warm ups before measuring task (required)");
            options.addOption("m", "measures", true, "Number of measurements per benchmark task (required)");
            options.addOption("o", "output", true, "Output file destination (required)");
            options.addOption("j", "jobs", true, "Number of parallel jobs for benchmarking. Default is 1");
            options.addOption("d", "delayprep", true, "Delay preparation of benchmark task (true[default]/false)");
            options.addOption("e", "excdump", true, "An exception dump file will be written to the specified path");
            options.addOption("ob", "outbuffer", true, "Buffer size of output stream");
            options.addOption("tp", "tracepath", true, "Name of tracefile which shall be replayed");
            options.addOption("mp", "modelpath", true, "Name of serialized model file");
            options.addOption("sf", "showfiles", false, "Show which trace files and model files are available");
            options.addOption("ns", "noshrinking", false, "Don't shrink models; just use the one full-size model");
            options.addOption("i", "oclId", true, "If provided, benchmark only the OCL expression with the given ID");
            options.addOption("p", "optimization", true, "If provided, selects one or more of the different optimization options (comma-separated, as in 1,3,5). Possible options:" + optionsDescription);

            // Default option
            // options.addOption("pd", "printdscr", true,
            // "Print separate description files for R reports with mapping from result identifiers to descriptions for OCL Expressions, Notifications and Models");

            options.addOption("v", "verbose", false, "Run in verbose mode");
            options.addOption("h", "help", false, "Show this help");

            CommandLineParser parser = new PosixParser();
            CommandLine cmd = parser.parse(options, args);
            boolean noShrinking = cmd.hasOption("ns");
            Integer oclId = null;
            if (cmd.hasOption("i")) {
                oclId = Integer.parseInt(cmd.getOptionValue("i"));
            }
            if (cmd.hasOption("h") || !cmd.hasOption("wu") || !cmd.hasOption("m") || !cmd.hasOption("o")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("Impact Analysis Benchmark Environment v0.1", options);
            } else {
                int numberOfJobs = cmd.hasOption("j") ? Integer.parseInt(cmd.getOptionValue("j")) : 1;
                boolean delayPreparation = cmd.hasOption("d") ? Boolean.parseBoolean(cmd.getOptionValue("d")) : true;
                if (cmd.hasOption("p")) {
                    List<ActivationOption> reducedOptionList = new ArrayList<ActivationOption>();
                    String commaSeparatedOptionIds = cmd.getOptionValue("p");
                    String[] optionIds = commaSeparatedOptionIds.split(",");
                    for (String optionId : optionIds) {
                        int pos = Integer.parseInt(optionId);
                        if (pos < 0 || pos > optionList.size() - 1) {
                            System.err.println("Option " + pos + " not defined.");
                            HelpFormatter formatter = new HelpFormatter();
                            formatter.printHelp("Impact Analysis Benchmark Environment v0.1", options);
                            reducedOptionList = null;
                            break;
                        } else {
                            ActivationOption selected = optionList.get(pos);
                            reducedOptionList.add(selected);
                        }
                    }
                    optionList = reducedOptionList;
                }
                if (optionList != null) {
                    String modelFile = "";
                    String eventTraceFile = "";
                    if (cmd.hasOption("sf")) {
                        printAvailableEventFixtures();
                        printAvailableModelFixtures();
                    } else {
                        if (!cmd.hasOption("tp")) {
                            System.out
                                    .println("You started benchmarks without specifying a correct event trace fixture explicitly.");
                            // printAvailableEventFixtures();

                            eventTraceFile = "modifyElementaryTypesEventTrace.trace";
                        } else {
                            eventTraceFile = cmd.getOptionValue("tp");
                        }
                        System.out.println("Choosing fixture: " + eventTraceFile);
                        System.out.println("");

                        if (!cmd.hasOption("mp")) {
                            System.out.println("You started benchmarks without specifying a correct model fixture explicitly.");
                            // printAvailableModelFixtures();

                            modelFile = "NgpmModel.xmi";
                        } else {
                            modelFile = cmd.getOptionValue("mp");
                        }
                        System.out.println("Choosing fixture: " + modelFile);
                        System.out.println("");
                    }

                    start(Integer.parseInt(cmd.getOptionValue("wu")), Integer.parseInt(cmd.getOptionValue("m")),
                            cmd.getOptionValue("o"), numberOfJobs, delayPreparation, cmd.getOptionValue("e"), cmd.hasOption("v"),
                            eventTraceFile, modelFile, noShrinking, oclId, optionList);
                }
            }
        } catch (ParseException e) {
            System.err.println("Parsing failed.  Reason: " + e.getMessage());
        }
    }

    public static void printAvailableEventFixtures() {
        System.out.println("The following event trace fixtures are available and can be specified with the --tracepath option:");

        int number = 1;
        for (String path : NotificationResourceLoader.getFilenamesOfEventFixtures()) {
            System.out.println("[" + number + "] " + path);
            number++;
        }
    }

    public static void printAvailableModelFixtures() {
        System.out.println("The following model fixtures are available and can be specified with the --modelpath option:");

        int number = 1;
        for (String path : NotificationResourceLoader.getFilenamesOfModelFixture()) {
            System.out.println("[" + number + "] " + path);
            number++;
        }
    }

    public static void start(int warmUps, int measures, String outputPath, int numberOfJobs, boolean delayPreparation,
            String dumpFilePath, boolean verbose, String eventTraceFile, String modelFile, boolean noShrinking, Integer oclId, List<ActivationOption> optionList)
            throws IOException {
        System.out.println("Impact Analysis Benchmark started with " + warmUps + " warm-ups and " + measures
                + " measures per benchmark task");

        ProcessingOptions.setNumberOfWarmUps(warmUps);
        ProcessingOptions.setNumberOfMeasures(measures);
        if (numberOfJobs > 1) {
            System.out.println("Started in parallel mode with " + numberOfJobs + " jobs");
            ProcessingOptions.setNumberOfJobs(numberOfJobs);
        }
        ProcessingOptions.setVerbose(verbose);

        PathOptions.setOutputPath(outputPath);
        PathOptions.setExceptionDumpFilePath(dumpFilePath);

        PathOptions.setModelFixturePath(modelFile);
        PathOptions.setEventTraceFixturePath(eventTraceFile);

        BenchmarkTaskStepwiseBuilder builder = BenchmarkTaskPreparer.createBenchmarkBuilder(noShrinking, oclId, optionList);
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
