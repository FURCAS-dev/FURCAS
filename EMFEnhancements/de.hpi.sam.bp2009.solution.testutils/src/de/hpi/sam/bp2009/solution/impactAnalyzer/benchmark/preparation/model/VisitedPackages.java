package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.model;

import java.util.ArrayList;

public class VisitedPackages {
	ArrayList<ArrayList<Package>> packageDeleteTrace = new ArrayList<ArrayList<Package>>();
	
	private ArrayList<Package> currentTrace = new ArrayList<Package>();
	
	public void visit(Package deleted){
		currentTrace.add(deleted);
	}
	
	
}
