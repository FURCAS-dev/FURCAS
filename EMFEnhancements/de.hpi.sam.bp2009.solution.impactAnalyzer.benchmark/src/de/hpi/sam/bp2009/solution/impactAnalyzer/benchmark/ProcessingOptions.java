package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark;

public class ProcessingOptions {

    private static int warmUps;
    private static int measures;
    private static int numberOfJobs = 1;
    private static boolean verbose;

    public static void setNumberOfWarmUps(int warmUps) {
	ProcessingOptions.warmUps = warmUps;
    }

    public static int getNumberOfWarmUps() {
	return warmUps;
    }

    public static void setNumberOfMeasures(int measures) {
	ProcessingOptions.measures = measures;
    }

    public static int getNumberOfMeasures(){
	return measures;
    }

	public static void setNumberOfJobs(int numberOfJobs) {
		ProcessingOptions.numberOfJobs = numberOfJobs;
	}

	public static int getNumberOfJobs() {
		return numberOfJobs;
	}

	public static void setVerbose(boolean verbose) {
	    ProcessingOptions.verbose = verbose;
	}

	public static boolean isVerbose() {
	    return verbose;
	}



}
