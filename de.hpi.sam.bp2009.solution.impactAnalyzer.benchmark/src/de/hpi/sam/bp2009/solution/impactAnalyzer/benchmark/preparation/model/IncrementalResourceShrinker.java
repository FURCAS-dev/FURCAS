package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import modelmanagement.Package;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * The {@link IncrementalResourceShrinker} class is responsible for cutting down
 * the size of emf models in one emf resource by removing packages and its model
 * elements bit by bit according to a dependency graph
 *
 * This class may be used for varying the size of models for benchmarking.
 *
 * @author Manuel Holzleitner (D049667)
 */

public class IncrementalResourceShrinker {

    public Collection<Resource> shrinkIncrementally(Resource fullSizeResource){
		ArrayList<Resource> result = new ArrayList<Resource>();
		
		int cloneId = 0;
		Resource nextResourceToShrink = ModelCloner.cloneResource(fullSizeResource, String.valueOf(cloneId));
		while(deletePackageWithFewestDependencies(nextResourceToShrink) >= 1){
			cloneId++;
			
		    result.add(nextResourceToShrink);
		    nextResourceToShrink = ModelCloner.cloneResource(nextResourceToShrink, String.valueOf(cloneId));
		}
		
		return result;    	
	}
    
    //FIXME: Needs refactoring. Extract combinational shrinking
    public void shrinkCombinational(Resource parent, ArrayList<Resource> result, ArrayList<Integer> visitedSizes){
      	PackageDependencyGraph dependencyGraph = new PackageDependencyGraph(parent);
		
    	List<Package> packageToDeleteList = calculatePossiblePackagesToDelete(dependencyGraph);
    	List<Resource> cloneList = new ArrayList<Resource>();
    	List<PackageDependencyGraph> dependencyGraphList = new ArrayList<PackageDependencyGraph>();
    	
    	
    	for(int i=0; i < packageToDeleteList.size(); i++){
    		Resource clone = ModelCloner.cloneResource(parent, String.valueOf(i));
    		cloneList.add(clone);
    		//List of packages which should be deleted of parent is not applicable for cloned resources
    		//Therefore recalculate packages to delete on clones and pick one alternative 
    		PackageDependencyGraph cloneDependencyGraph = new PackageDependencyGraph(clone);
    		dependencyGraphList.add(cloneDependencyGraph);
    		
    		List<Package> clonePackageToDeleteList = calculatePossiblePackagesToDelete(cloneDependencyGraph);
    		
    		if(cloneDependencyGraph.getNumberOfPackages() > 1){
	    		deletePackage(clonePackageToDeleteList.get(i), cloneDependencyGraph);
	    		
	    			int numberOfElementsInChild = getNumberOfElements(clone);
	    			if(!visitedSizes.contains(new Integer(numberOfElementsInChild))){
	    				result.add(clone);
	    				visitedSizes.add(numberOfElementsInChild);
	    			}
	    			System.out.println(visitedSizes.size());
    		}
    	}
    	
    	for(int i=0; i < packageToDeleteList.size(); i++){
    		if(dependencyGraphList.get(i).getNumberOfPackages() > 1 && visitedSizes.size() < 108){
    			shrinkCombinational(cloneList.get(i), result, visitedSizes);
    		}
    	}
    
    }
    
    private int getNumberOfElements(Resource resource){
	int resourceSize = 0;
	TreeIterator<EObject> iterator = resource.getAllContents();
	while (iterator.hasNext()) {
		iterator.next();
		resourceSize++;
	}
	return resourceSize;
    }
    
        
	private int deletePackageWithFewestDependencies(Resource resourceToShrink){
		//TODO: Actually, rebuilding the dependency graph should not be required for deleting the next package. Therefore, ensure
		// that after deleting a package the dependency graph is updated accordingly.
		PackageDependencyGraph dependencyGraph = new PackageDependencyGraph(resourceToShrink);
		
		ArrayList<Package> packagesToDeleteList = calculatePossiblePackagesToDelete(dependencyGraph);  	
		deletePackage(getPackageWithFewestDependencies(packagesToDeleteList, dependencyGraph), dependencyGraph);
	
		return dependencyGraph.getNumberOfPackages();
	}

	private ArrayList<Package> calculatePossiblePackagesToDelete(PackageDependencyGraph dependencyGraph) {
	int smallestAmountOfReferences = Integer.MAX_VALUE;
	for (Package pack : dependencyGraph.getAllPackages()) {
	    if (getListWithoutDuplicates(dependencyGraph.getDependencies().get(pack)).size() < smallestAmountOfReferences) {
		smallestAmountOfReferences = getListWithoutDuplicates(dependencyGraph.getDependencies().get(pack)).size();
	    }
	}
	ArrayList<Package> packagesToDeleteList = new ArrayList<Package>();
	for (Package pack : dependencyGraph.getAllPackages()) {
	    if (getListWithoutDuplicates(dependencyGraph.getDependencies().get(pack)).size() == smallestAmountOfReferences) {
		packagesToDeleteList.add(pack);
	    }
	}
	return packagesToDeleteList;
	}

	private Package getPackageWithFewestDependencies(ArrayList<Package> packagesToDeleteList, PackageDependencyGraph dependencyGraph){
		Package packageToDelete = null;
		if(packagesToDeleteList.size() == 1){
		    System.out.println("match");
		    packageToDelete = packagesToDeleteList.get(0);
		}else if(packagesToDeleteList.size() > 1){
		    System.out.println("choose");
		    packageToDelete = chooseBestPackageToDelete(packagesToDeleteList, dependencyGraph);
		}
		return packageToDelete;
	}

	private Package chooseBestPackageToDelete(ArrayList<Package> packagesToDeleteList, PackageDependencyGraph dependencyGraph) {
	
	Package packageToDelete = packagesToDeleteList.get(0);
	for(Package deletionCandidate : packagesToDeleteList){
	    if(dependencyGraph.getDependencies().get(deletionCandidate).size() < dependencyGraph.getDependencies().get(packageToDelete).size()){
		packageToDelete = deletionCandidate;
	    }
	}
	
	System.out.println(dependencyGraph.getDependencies().get(packageToDelete).size());
	
	return packageToDelete;
	}

	private Package deletePackage(Package packageToDelete, PackageDependencyGraph dependencyGraph) {
	Package deletedPackage = null;

	System.out.println("\t\t\tDelete package: " + packageToDelete);
	
	//EcoreUtil.delete(packageToDelete, true);
	//packageWasDeleted = true;
	//deletedPackage = packageToDelete;
	
	for (Package key : dependencyGraph.getAllPackages()) {
	    if (key != null && key.equals(packageToDelete)) {
		
	    /*System.out.println("Elements: " + aggregatedElements.get(key).size());
		for (EObject elementToDelete : aggregatedElements.get(key)) {
		    if(!(elementToDelete instanceof Package)) {
			EcoreUtil.delete(elementToDelete);
		    }
		   // System.out.println("\t\t\t\t\tdeleted:" + elementToDelete);
		}*/
	    EcoreUtil.delete(key, true);
		deletedPackage = key;
	    }
	}
	
	dependencyGraph.removePackage(packageToDelete);
	
	return deletedPackage;
	}
	
	/* TODO: Delete this commented debug code in final implementation
	
	for (Package key : dependencies.keySet()) {
	    System.out.println("P: " + key + " Number:" + dependencies.get(key).size() + " Elements:"
		    + aggregatedElements.get(key).size());
	    for (Package subPackage : dependencies.get(key)) {
		System.out.println("\t\t" + subPackage);
	    }
	}
	
	System.out.println(aggregatedElements.size() + "/" + modelElementList.size() + "/" + dependencies.size());
	*/


    private <T> ArrayList<T> getListWithoutDuplicates(List<T> arlList) {
		ArrayList<T> result = new ArrayList<T>(arlList.size());
		java.util.HashSet<T> h = new java.util.HashSet<T>(arlList);
		result.addAll(h);
		return result;
	}
}
