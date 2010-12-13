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
package org.eclipse.ocl.examples.impactanalyzer.benchmark.postprocessing;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.eclipse.ocl.examples.impactanalyzer.benchmark.PathOptions;


public class ExceptionDumpWriter extends Writer {

    public ExceptionDumpWriter() throws IOException {
    	super(PathOptions.getExceptionDumpFilePath(), false);
    }

    public void writeDump(HashMap<String, Throwable> dumpList){
	for(String key : dumpList.keySet()){
	    try {
		writer.write(key + BREAK);
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    PrintWriter printWriter = new PrintWriter(writer);
	    dumpList.get(key).printStackTrace(printWriter);
	    printWriter.flush();
	}
    }
}
