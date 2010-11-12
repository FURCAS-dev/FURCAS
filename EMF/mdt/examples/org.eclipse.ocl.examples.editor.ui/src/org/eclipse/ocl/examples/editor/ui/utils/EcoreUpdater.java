/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.utils;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ocl.examples.common.utils.XMIUtils.IdCreator;

/**
 * EcoreUpdater provides facilities to take a copy of an Ecore model, and (subsequently)
 * to update an Ecore model from an edited copy. The update performs changes to the model
 * so that its content is the same as the edited copy, thereby preserving EObjects in so
 * far as possible.
 */
public class EcoreUpdater
{	
	public static void computeIdMaps(XMLResource resource, Map<String, EObject> idToObjectMap, Map<EObject, String> objectToIdMap) throws MissingXmiIdException {
		List<EObject> eObjects = computeIdMaps(resource, idToObjectMap, objectToIdMap, null);
		if (eObjects != null)
			throw new MissingXmiIdException(eObjects.get(0));
	}

	/**
	 * Compute one or both of the id-to-object and object-to-id maps for a resource.
	 * If idCreator is non-null, it is invoked to provide an id for each object that
	 * lacks an id. If on completion all objects have an id, null is returned,
	 * otherwise a list of id-less objects is returned.
	 * 
	 * @param resource
	 * @param idToObjectMap may be null
	 * @param objectToIdMap may be null
	 * @param idCreator may be null
	 * @return
	 */
	public static List<EObject> computeIdMaps(XMLResource resource, Map<String, EObject> idToObjectMap, Map<EObject, String> objectToIdMap, IdCreator idCreator) {
		if (idToObjectMap != null)
			idToObjectMap.clear();
		else
			idToObjectMap = new HashMap<String, EObject>();
		if (objectToIdMap != null)
			objectToIdMap.clear();
        List<EObject> idLess = null;
		for (TreeIterator<EObject> iterator = resource.getAllContents(); iterator.hasNext(); ) {
	        EObject object = iterator.next();
            if (!(object instanceof EGenericType)) {
		        String id = resource.getID(object);
		        if (id == null) {
		            if (idLess == null)
		            	idLess = new ArrayList<EObject>(100);
		        	idLess.add(object);
		        }
		        else {
			        idToObjectMap.put(id, object);
			        if (objectToIdMap != null)
						objectToIdMap.put(object, id);
		        }
            }
	    }
		if (idLess != null) {
			if (idCreator == null) {
		        if (objectToIdMap != null)
					for (EObject object : idLess)
						objectToIdMap.put(object, null);
				return idLess;
			}
			else {
				for (EObject object : idLess) {
			        String id = idCreator.createId(object, idToObjectMap.keySet());
			        idToObjectMap.put(id, object);
			        if (objectToIdMap != null)
						objectToIdMap.put(object, id);
			    }
			}
		}
		return null;
	}

	/**
	 * Return a copy of the contents (EObjects, uri and xmi:ids) of oldResource.
	 * <p>
	 * This is basically EcoreUtil.copyAll, wrapped up in an XMLResource with an
	 * added copy of uri and xmi:ids.
	 * <p>
	 * The copy is not registered with any ResourceSet. It is intended primarily for
	 * subsequent use by EcoreUpdater.
	 * <p>
	 * Use {@link org.eclipse.ocl.examples.common.utils.XMIUtils#assignIds} to avoid MissingXmiIdExceptions.
	 * 
	 * @param oldResource to be copied
	 * @return copy
	 * @throws MissingXmiIdException if any oldResource object lacks an xmi:id
	 */
	public static XMLResource copy(XMLResource oldResource) throws MissingXmiIdException {
		XMLResource newResource = new XMLResourceImpl();
		copy(newResource, oldResource);
        return newResource;
	}
		
	/**
	 * Copy the contents (EObjects, uri and xmi:ids) from oldResource to newResource.
	 * <p>
	 * This is basically EcoreUtil.copyAll, wrapped up in an XMLResource with an
	 * added copy of uri and xmi:ids.
	 * <p>
	 * The copy is not registered with any ResourceSet. It is intended primarily for
	 * subsequent use by EcoreUpdater.
	 * <p>
	 * Use {@link org.eclipse.ocl.examples.common.utils.XMIUtils#assignIds} to avoid MissingXmiIdExceptions.
	 * 
	 * @param newResource to be defined
	 * @param oldResource to be copied
	 * @throws MissingXmiIdException if any oldResource object lacks an xmi:id
	 */
	public static void copy(XMLResource newResource, XMLResource oldResource) throws MissingXmiIdException {
		newResource.setURI(oldResource.getURI());
	    Copier copier = new Copier();
	    newResource.getContents().addAll(copier.copyAll(oldResource.getContents()));
	    copier.copyReferences();		
		for (EObject oldObject : copier.keySet()) {
            EObject newObject = copier.get(oldObject);
            if (!(newObject instanceof EGenericType)) {
	            String id = oldResource.getID(oldObject);
	            if (id == null)
	            	throw new MissingXmiIdException(oldObject);
	            newResource.setID(newObject, id);
	        }
		}
        for (TreeIterator<EObject> iterator = newResource.getAllContents(); iterator.hasNext(); ) {
            EObject newObject = iterator.next();
            if (!(newObject instanceof EGenericType)) {
	            String id = newResource.getID(newObject);
	            if (id == null) {
	            	EObject newContainer = newObject.eContainer();
	                String containerId = newResource.getID(newContainer);
	                if (containerId == null)
	                	throw new MissingXmiIdException(newContainer);
	                EStructuralFeature containingFeature = newObject.eContainingFeature();
	            	EObject oldContainer = oldResource.getEObject(containerId);
	            	Object oldObject = oldContainer.eGet(containingFeature);
	            	if (containingFeature.isMany()) {
	            		List<?> newList = (List<?>) newContainer.eGet(containingFeature);
	            		int index = newList.indexOf(newObject);
	                	oldObject = ((List<?>)oldObject).get(index);
	            	}
	        		id = oldResource.getID((EObject) oldObject);
	        		newResource.setID(newObject, id);
	            }
            }
        }
	}

	public static void update(XMLResource oldResource, XMLResource newResource) throws MissingElementException {
		EcoreUpdater updater = new EcoreUpdater(oldResource, newResource);
		updater.initialize();
//		if (debug)
//			updater.debug(System.out);
		updater.update();
	}

    private final XMLResource resource;
    private final XMLResource newResource;
    private final Map<String, EObject> idToObjectMap = new HashMap<String, EObject>();
    private final Map<EObject, String> objectToIdMap = new HashMap<EObject, String>();
    private final Map<EObject, String> newObjectToIdMap = new HashMap<EObject, String>();
//    private final Map<String, List<ENamedElement>> debugMap = new HashMap<String, List<ENamedElement>>();

	public EcoreUpdater(XMLResource resource, XMLResource newResource) {	
		this.resource = resource;
		this.newResource = newResource;
	}

	protected void installCopy(EObject oldObject, EObject newObject) {
		String id = newObjectToIdMap.get(newObject);
		resource.setID(oldObject, id);
		idToObjectMap.put(id, oldObject);
		objectToIdMap.put(oldObject, id);
		for (EStructuralFeature feature : newObject.eClass().getEAllStructuralFeatures()) {
			if ((feature instanceof EReference) && ((EReference) feature).isContainment()) {
				Object newValue = newObject.eGet(feature);
				Object oldValue = oldObject.eGet(feature);
				if (newValue == null)
					;
				else if (!feature.isMany())
					installCopy((EObject)oldValue, (EObject)newValue);
				else if (newValue instanceof List<?>) {
					List<?> newList = (List<?>) newValue;
					List<?> oldList = (List<?>) oldValue;
					for (int i = 0; i < newList.size(); i++)
						installCopy((EObject)oldList.get(i), (EObject)newList.get(i));
				}
				else
					throw new UnsupportedOperationException(getClass().getName() + ".installCopy for " + newValue.getClass().getName());
			}
		}
	}

	public void debug(PrintStream s) {
    	System.out.println("-----------------------------------------------");
		List<String> keys = new ArrayList<String>(idToObjectMap.keySet());
		Collections.sort(keys);
		for (String key : keys) {
			EObject object = idToObjectMap.get(key);
	        if (object instanceof ENamedElement)
	        	System.out.println(key + " ==> " + object.eClass().getName() + "." + ((ENamedElement) object).getName());
	        else
	        	System.out.println(key + " ==> " + object.eClass().getName());
	    }
	}

	public void initialize() throws MissingXmiIdException {
		//
		//	Compute the maps:
		//	1) because access to the resource maps is deprecated
		//	2) because the resource maps exclude EGenericType
		//	3) because the resource maps are only computed on load, not on edit
		//
		computeIdMaps(resource, idToObjectMap, objectToIdMap);
		computeIdMaps(newResource, null, newObjectToIdMap);
//		for (TreeIterator<EObject> iterator = resource.getAllContents(); iterator.hasNext(); ) {
//	        EObject object = iterator.next();
//	        if (object instanceof ENamedElement) {
//	        	String name = ((ENamedElement) object).getName();
//	        	List<ENamedElement> list = debugMap.get(name);
//	        	if (list == null) {
//	        		list = new ArrayList<ENamedElement>();
//	        		debugMap.put(name, list);
//	        	}
//	        	list.add((ENamedElement) object);
//	        }
//	        if (object instanceof ENamedElement)
//	        	System.out.println(object.eClass().getName() + "." + ((ENamedElement) object).getName());
//	    }
	}
	
	protected <E extends EObject> E newOldObjectFor(E newObject) throws MissingElementException {
        if (newObject == null)
        	return newObject;
        if (newObject.eIsProxy())
        	return newObject;
        if (newObject.eResource() != newResource)
        	return newObject;
		String id = newObjectToIdMap.get(newObject);
        if (id == null)
        	throw new MissingXmiIdException(newObject);
        EObject oldObject = idToObjectMap.get(id);
        if (oldObject == null)
        	throw new MissingObjectException(newObject, id);
		return ClassUtils.asClassUnchecked(oldObject);
	}
	
	public void update() throws MissingElementException {			
		updateList(null, resource.getContents(), newResource.getContents());
 	}

	protected void updateEObject(EObject oldObject, EObject newObject) throws MissingElementException {
		List<EStructuralFeature> features = oldObject.eClass().getEAllStructuralFeatures();
		for (EStructuralFeature feature : features) {
			if (feature.isDerived() || feature.isVolatile() || feature.isTransient())
				continue;
			boolean oldIsSet = oldObject.eIsSet(feature);
			boolean newIsSet = newObject.eIsSet(feature);
			if (!newIsSet) {
				if (oldIsSet)
					oldObject.eUnset(feature);
			}
			else {
				Object newValue = newObject.eGet(feature, false);
				if (feature instanceof EAttribute) {
					if (!oldIsSet)
						oldObject.eSet(feature, newValue);
					else {
						Object oldValue = oldObject.eGet(feature, false);
						if ((newValue != oldValue) && ((newValue == null) || !newValue.equals(oldValue)))
							oldObject.eSet(feature, newValue);
					}
				} else if (!feature.isMany()) {
					if (((EReference) feature).isContainment()) {
						Object oldValue = oldObject.eGet(feature, false);
						if (!oldIsSet || (oldValue != null) || (newValue != null))
							updateEObject((EObject)oldValue, (EObject)newValue);
					}
					else {
						EObject newOldValue = newOldObjectFor((EObject)newValue);
						if (!oldIsSet) {
							if ((newOldValue != null) && newOldValue.eIsProxy())
								oldObject.eSet(feature, EcoreUtil.copy(newOldValue));
							else
								oldObject.eSet(feature, newOldValue);
						}
						else {
							Object oldValue = oldObject.eGet(feature, false);
							if (oldValue != newOldValue) {
								if ((newOldValue != null) && newOldValue.eIsProxy()) {
									if (oldValue != null)
										((InternalEObject)oldValue).eSetProxyURI(((InternalEObject)newOldValue).eProxyURI());
									else
										oldObject.eSet(feature, EcoreUtil.copy(newOldValue));
								}
								else {
									oldObject.eSet(feature, newOldValue);
								}
							}
						}
					}
				} else if (newValue instanceof List<?>) {
					Object oldValue = oldObject.eGet(feature, false);
					List<EObject> oldList = ClassUtils.asClassUnchecked(oldValue);
					List<EObject> newList = ClassUtils.asClassUnchecked(newValue);
					updateList((EReference) feature, oldList, newList);
				} else
					throw new UnsupportedOperationException(getClass().getName() + ".updateEObject for " + newValue.getClass().getName());
			}
		}		
	}
	
	protected <E extends EObject> void updateList(EReference feature, List<E> oldList, List<E> newList) throws MissingElementException {
		boolean isContainment = (feature == null) || feature.isContainment();
		int iMaxNew = newList.size();
		for (int i = 0; i < iMaxNew; i++) {
			E newObject = newList.get(i);
            EObject oldObject;
            if (isContainment) {					
    			String id = newObjectToIdMap.get(newObject);
                if (id == null)
                	throw new MissingXmiIdException(newObject);
				oldObject = idToObjectMap.get(id);
				if ((oldObject == null) || (oldObject.eClass() != (newObject).eClass())) {
					oldObject = EcoreUtil.copy(newObject);
					installCopy(oldObject, newObject);
				}
            }
			else
				oldObject = newOldObjectFor(newObject);
			int index = oldList.indexOf(oldObject);
			if (index == i)
				;
			else if ((index > i) && (oldList instanceof EList<?>))
				((EList<?>)oldList).move(i, index);
			else {
				E oldE = ClassUtils.asClassUnchecked(oldObject);
				oldList.add(i, oldE);
			}
			if (isContainment)
				updateEObject(oldObject, newObject);			
		}
		while (iMaxNew < oldList.size())
			oldList.remove(iMaxNew);
	}
}

