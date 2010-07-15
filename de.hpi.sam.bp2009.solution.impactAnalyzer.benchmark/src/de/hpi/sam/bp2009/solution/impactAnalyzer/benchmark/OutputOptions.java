package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark;

public class OutputOptions {
    private static String outputPath;

    public static void setOutputPath(String outputPath) {
	OutputOptions.outputPath = outputPath;
    }

    public static String getOutputPath(){
	return outputPath;
    }

}
