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
package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.model;

import java.util.ArrayList;

public class VisitedPackages {
	ArrayList<ArrayList<Package>> packageDeleteTrace = new ArrayList<ArrayList<Package>>();
	
	private ArrayList<Package> currentTrace = new ArrayList<Package>();
	
	public void visit(Package deleted){
		currentTrace.add(deleted);
	}
	
	
}
