package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelmanagement.Package;

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

    private Collection<EObject> modelElementList;
    private Map<Package, Collection<EObject>> aggregatedElements;
    private Map<Package, List<Package>> dependencies;

    private <T> ArrayList<T> getListWithoutDuplicates(List<T> arlList) {
	ArrayList<T> result = new ArrayList<T>(arlList.size());
	java.util.HashSet<T> h = new java.util.HashSet<T>(arlList);
	result.addAll(h);
	return result;
    }

    private void aggregateElementsInPackages(Resource resourceToShrink) {
	dependencies = new HashMap<Package, List<Package>>();
	modelElementList = ResourceTraversalHelper.getModelElementsInResource(resourceToShrink);
	aggregatedElements = aggregateElementsInPackages(modelElementList);
    }

    private Package deleteNextPackage() {
	ArrayList<Package> packagesToDeleteList = calculatePossiblePackagesToDelete();
	
	Package packageToDelete = null;
	if(packagesToDeleteList.size() == 1){
	    System.out.println("match");
	    packageToDelete = packagesToDeleteList.get(0);
	}else if(packagesToDeleteList.size() > 1){
	    System.out.println("choose");
	    packageToDelete = chooseBestPackageToDelete(packagesToDeleteList);
	}


	Package deletedPackage = null;
	boolean packageWasDeleted = false;

	//EcoreUtil.delete(packageToDelete, true);
	//packageWasDeleted = true;
	//deletedPackage = packageToDelete;

	for (Package key : dependencies.keySet()) {
	    if (key != null && key.equals(packageToDelete)) {
		System.out.println("Elements: " + aggregatedElements.get(key).size());
		for (EObject elementToDelete : aggregatedElements.get(key)) {
		    if(!(elementToDelete instanceof Package)) {
			EcoreUtil.delete(elementToDelete);
		    }
		   // System.out.println("\t\t\t\t\tdeleted:" + elementToDelete);
		}
		deletedPackage = key;
		packageWasDeleted = true;
	    }

	    aggregatedElements.remove(key);
	}

	if (packageWasDeleted) {
	    System.out.println("\t\t\tdelete: " + deletedPackage);
	    dependencies.remove(deletedPackage);
	}

	return deletedPackage;
    }

    private Package chooseBestPackageToDelete(ArrayList<Package> packagesToDeleteList) {

	Package packageToDelete = packagesToDeleteList.get(0);
	for(Package deletionCandidate : packagesToDeleteList){
	    if(dependencies.get(deletionCandidate).size() < dependencies.get(packageToDelete).size()){
		packageToDelete = deletionCandidate;
	    }
	}

	System.out.println(dependencies.get(packageToDelete).size());

	return packageToDelete;
    }

    private ArrayList<Package> calculatePossiblePackagesToDelete() {
	int smallestAmountOfReferences = Integer.MAX_VALUE;
	for (Package pack : dependencies.keySet()) {
	    if (getListWithoutDuplicates(dependencies.get(pack)).size() < smallestAmountOfReferences) {
		smallestAmountOfReferences = getListWithoutDuplicates(dependencies.get(pack)).size();
	    }
	}
	ArrayList<Package> packagesToDeleteList = new ArrayList<Package>();
	for (Package pack : dependencies.keySet()) {
	    if (getListWithoutDuplicates(dependencies.get(pack)).size() == smallestAmountOfReferences) {
		packagesToDeleteList.add(pack);
	    }
	}
	return packagesToDeleteList;
    }

    private void buildDependencyGraph() {
	System.out.println("\t\t\tBuild Dependency Graph");

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

    public int shrink(Resource resourceToShrink) {
	aggregateElementsInPackages(resourceToShrink);

	//TODO: Actually, rebuilding the dependency graph should not be required for deleting the next package. Therefore, ensure
	// that after deleting a package the dependency graph is updated accordingly.
	buildDependencyGraph();
	deleteNextPackage();

	return dependencies.size();
    }
}
