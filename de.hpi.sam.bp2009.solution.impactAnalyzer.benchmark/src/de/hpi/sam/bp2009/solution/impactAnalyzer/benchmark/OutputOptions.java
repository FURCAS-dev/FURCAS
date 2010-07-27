package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark;

public class OutputOptions {
    private static String outputPath;
    private static String exceptionDumpFilePath;

    public static void setOutputPath(String outputPath) {
	OutputOptions.outputPath = outputPath;
    }

    public static String getOutputPath(){
	return outputPath;
    }

    public static void setExceptionDumpFilePath(String exceptionDumpFilePath) {
	OutputOptions.exceptionDumpFilePath = exceptionDumpFilePath;
    }

    public static String getExceptionDumpFilePath() {
	return exceptionDumpFilePath;
    }

}
