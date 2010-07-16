package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * The {@link ModelCloner} is able to clone resources and its elements in a new resource set
 * and also clones XML ids which are setted on a {@link XMLResource}
 */
public class ModelCloner {
	
	public static List<Resource> createResourceClones(Resource resourceToClone, int amountOfClones){
		List<Resource> cloneList = new ArrayList<Resource>(amountOfClones);
		
		for(int i=0; i < amountOfClones; i++){
			cloneList.add(cloneResource(resourceToClone, String.valueOf(i), false));
		}
		
		assert(cloneList.size() == amountOfClones);
		
		return cloneList;
	}
	
	public static Resource cloneResource(Resource resourceToClone, String cloneId){
		return cloneResource(resourceToClone, cloneId, true);
	}
	
	public static Resource cloneResource(Resource resourceToClone, String cloneId, boolean overwriteFirstId){
		int resourceSize = 0;
		TreeIterator<EObject> iterator = resourceToClone.getAllContents();
		while (iterator.hasNext()) {
			iterator.next();
			resourceSize++;
		}

		System.out.println("\t\t\tClone Resource: " + resourceToClone.getURI()
				+ " Elements:" + resourceSize);
		// Compute new URI by inserting "2" before the file extension
		URI uri = resourceToClone.getURI();
		String ext = uri.fileExtension();

		String name = "";

		name = uri.trimFileExtension().lastSegment() + "." + cloneId;

		
		uri = URI.createURI(name).resolve(uri).appendFileExtension(ext);
		
		Resource clone = resourceToClone.getResourceSet().createResource(uri);

		Copier copier = new Copier();
		clone.getContents().addAll(
				copier.copyAll(resourceToClone.getContents()));
		copier.copyReferences();

		clone = cloneXMLResourceIDs(resourceToClone, clone);

		return clone;
	}
	

	private static Resource cloneXMLResourceIDs(Resource resourceToClone,
			Resource clone) {
		if (resourceToClone instanceof XMLResource) {
			TreeIterator<EObject> iterator = resourceToClone.getAllContents();
			TreeIterator<EObject> cloneIterator = clone.getAllContents();
			while (iterator.hasNext()) {
				EObject next = iterator.next();
				EObject nextClone = cloneIterator.next();
				((XMLResource) clone).setID(nextClone,
						((XMLResource) resourceToClone).getID(next));
			}
		} else {
			System.out.println("Not XML Resource");
		}
		return clone;
	}


}
