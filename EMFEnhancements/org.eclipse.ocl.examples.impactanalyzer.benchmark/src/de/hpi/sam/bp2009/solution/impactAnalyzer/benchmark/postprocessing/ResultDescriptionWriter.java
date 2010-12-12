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
package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.PathOptions;

public class ResultDescriptionWriter extends Writer{
	private boolean withHeadline = true;
	private int lineOffset = 1;

	public ResultDescriptionWriter(String fileName) throws IOException {
		super(new File(PathOptions.getOutputPath()).getCanonicalFile().getParent().toString() + File.separator + fileName, false);

		System.out.println("\t Write description file: " + new File(PathOptions.getOutputPath()).getCanonicalFile().getParent().toString() + File.separator + fileName);
	}

    public void writeDescriptionLine(Map<String, Object> descriptionMap) {
	final String TAB = "\t";
	try {
	    if (withHeadline) {
		writer.write(" ");

		for (String label : descriptionMap.keySet()) {
		    writer.write(TAB + label);
		}

		writer.write(BREAK);
		withHeadline = false;
	    }

	    StringBuffer row = new StringBuffer();
	    row.append(lineOffset++);

	    for (Object information : descriptionMap.values()) {
		row.append(TAB + information.toString().replaceAll(TAB, " ").replaceAll(BREAK, " ").replaceAll("\n", " ").replace("\r", " "));
	    }

	    row.append(BREAK);
	    writer.write(row.toString());

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
