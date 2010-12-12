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
