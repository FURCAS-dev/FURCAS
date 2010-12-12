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
package org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.model;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Provides methods to extract model elements and model references out of a single resource.
 *
 * @author Manuel Holzleitner (D049667)
 */
public class ResourceTraversalHelper {

	public static Collection<EObject> getModelElementsInResource(Resource resource) {
		ArrayList<EObject> modelElementList = new ArrayList<EObject>();
		TreeIterator<EObject> iterator = resource.getAllContents();
		while(iterator.hasNext()){
			EObject fromObject = iterator.next();

			modelElementList.add(fromObject);
		}
		return modelElementList;
	}

	/**
	 * Creates a list of @{link ModelReferences} from all EObjects in the modelElementList
	 *
	 * @param modelElementList
	 * @return
	 */
	public static Collection<ModelReference> getModelReferencesForModelElements(Collection<EObject> modelElementList){
		ArrayList<ModelReference> modelReferenceList = new ArrayList<ModelReference>();

		for(EObject fromObject : modelElementList){
			for(EReference reference : fromObject.eClass().getEAllReferences()){
				addNewModelReference(modelReferenceList, fromObject, reference);
			}
		}

		return modelReferenceList;
	}

	/**
	 * Create {@link ModelReference} objects for references with one target or
	 * with multiple target model elements
	 *
	 * @param modelReferenceList
	 * @param fromObject
	 * @param reference
	 */
	private static void addNewModelReference(ArrayList<ModelReference> modelReferenceList, EObject fromObject, EReference reference) {
		if(fromObject.eGet(reference) instanceof EList<?>){
			for(Object referencedObject : (EList<?>)fromObject.eGet(reference)){
				if(referencedObject instanceof EObject){
					modelReferenceList.add(new ModelReference(fromObject, (EObject)referencedObject, reference));
				}
				//System.out.println(referencedObject);
			}
		}else if(fromObject.eGet(reference) instanceof EObject){
			modelReferenceList.add(new ModelReference(fromObject, (EObject)fromObject.eGet(reference), reference));
		}else{
			//System.out.println(fromObject.eGet(reference));
		}
	}
}
