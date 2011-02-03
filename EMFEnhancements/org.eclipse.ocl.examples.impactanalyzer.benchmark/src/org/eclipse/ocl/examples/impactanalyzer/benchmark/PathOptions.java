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

import java.io.File;

public class PathOptions {
    private static String outputPath;
    private static String exceptionDumpFilePath;

    private static String modelFixturePath;
    private static String eventTraceFixturePath;

    public static void setOutputPath(String outputPath) {
	File f = new File(outputPath);
	if(f.exists() && f.isDirectory()){
	    PathOptions.outputPath = outputPath + File.separator + "result.data";
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

    public static boolean isExceptionDumpFilePathDefined() {
        return getExceptionDumpFilePath() != null && !getExceptionDumpFilePath().equals("");
    }



}
