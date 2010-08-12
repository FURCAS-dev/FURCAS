package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark;

import java.io.File;

public class PathOptions {
    private static String outputPath;
    private static String exceptionDumpFilePath;

    private static String modelFixturePath;
    private static String eventTraceFixturePath;

    public static void setOutputPath(String outputPath) {
	File f = new File(outputPath);
	if(f.exists() && f.isDirectory()){
	    PathOptions.outputPath = outputPath + File.pathSeparator + "result.data";
	}else{
	    PathOptions.outputPath = outputPath;
	}
    }

    public static String getOutputPath(){
	return outputPath;
    }

    public static void setExceptionDumpFilePath(String exceptionDumpFilePath) {
	PathOptions.exceptionDumpFilePath = exceptionDumpFilePath;
    }

    public static String getExceptionDumpFilePath() {
	return exceptionDumpFilePath;
    }

	public static void setModelFixturePath(String modelFixturePath) {
		PathOptions.modelFixturePath = modelFixturePath;
	}

	public static String getModelFixturePath() {
		return modelFixturePath;
	}

	public static void setEventTraceFixturePath(String eventTraceFixturePath) {
		PathOptions.eventTraceFixturePath = eventTraceFixturePath;
	}

	public static String getEventTraceFixturePath() {
		return eventTraceFixturePath;
	}



}
