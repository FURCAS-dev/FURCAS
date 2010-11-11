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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelmanagement.Package;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class PackageDependencyGraph {
    private Map<Package, Collection<EObject>> aggregatedElements;
    private Map<Package, List<Package>> dependencies;
    private Collection<EObject> modelElementList;
    	
	public PackageDependencyGraph(Resource resource) {
		buildDependencyGraph(resource);
	}
	
	public int getNumberOfPackages(){
		assert aggregatedElements.size() == dependencies.size();
		
		return dependencies.size();
	}
	
	public Map<Package, List<Package>> getDependencies(){
		return dependencies;
	}
	
	public Collection<Package> getAllPackages(){
		return dependencies.keySet();
	}
	
	public void removePackage(Package packageToRemove){	
		modelElementList.removeAll(aggregatedElements.get(packageToRemove));		
		aggregatedElements.remove(packageToRemove);
		
		for(Package pack : dependencies.keySet()){
			boolean packageWasRemoved = false;
			do{
				packageWasRemoved = dependencies.get(pack).remove(packageToRemove);
			}while(packageWasRemoved == true);
		}
		
		dependencies.remove(packageToRemove);
	}
	
    private void buildDependencyGraph(Resource resourceToShrink) {
        aggregateElementsInPackages(resourceToShrink);
        	
    	//System.out.println("\t\t\tBuild Dependency Graph");
    	
    	Collection<ModelReference> modelReferenceList = ResourceTraversalHelper
    		.getModelReferencesForModelElements(modelElementList);
    	
    	// FIXME: The following code is obviously not optimized for performance
    	for (Package key : aggregatedElements.keySet()) {
    	    Collection<EObject> elementInPackageList = aggregatedElements.get(key);
    	
    	    for (EObject elementInPackage : elementInPackageList) {
    		for (ModelReference modelReference : modelReferenceList) {
    	
    		    if (elementInPackage.equals(modelReference.getFrom())) {
    			Package referencedPackage = navigateToPackage(modelReference.getTo());
    	
    			List<Package> contents = dependencies.get(referencedPackage);
    			if (contents == null) {
    			    contents = new ArrayList<Package>();
    			}
    	
    			if ((referencedPackage == null || !referencedPackage.equals(key))) {
    			    contents.add(key);
    			}
    	
    			dependencies.put(referencedPackage, contents);
    		    }
    		}
    	    }
    	}
    }
	
	private void aggregateElementsInPackages(Resource resourceToShrink) {
		dependencies = new HashMap<Package, List<Package>>();
		modelElementList = ResourceTraversalHelper.getModelElementsInResource(resourceToShrink);
		aggregatedElements = aggregateElementsInPackages(modelElementList);
	}
	
    private HashMap<Package, Collection<EObject>> aggregateElementsInPackages(Collection<EObject> modelElementList) {
    	HashMap<Package, Collection<EObject>> result = new HashMap<Package, Collection<EObject>>();

    	for (EObject object : modelElementList) {
    	    Package pack = navigateToPackage(object);

    	    Collection<EObject> aggregatedElements = result.get(pack);

    	    if (aggregatedElements == null) {
    		aggregatedElements = new ArrayList<EObject>();
    	    }

    	    aggregatedElements.add(object);

    	    result.put(pack, aggregatedElements);
    }
    	return result;
    }
    
	private Package navigateToPackage(EObject containedElement) {
		EObject container = containedElement;

		while (container.eContainer() != null && !(container instanceof Package)) {
		    container = container.eContainer();
		}

		if(container.equals(containedElement))
		    return null;

		// FIXME: Add error handling
		// if(!(container instanceof Package))
		// throw new RuntimeException("Cannot determine toplevel package");
		if (container instanceof Package)
		    return (Package) container;

		return null;
	    }  
}
