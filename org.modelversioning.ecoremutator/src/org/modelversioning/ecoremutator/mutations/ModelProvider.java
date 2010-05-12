/**
 * <copyright>
 *
 * Copyright (c) 2010 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */

package org.modelversioning.ecoremutator.mutations;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.modelversioning.ecoremutator.IModelProvider;

/**
 * Provides access and convenient methods to the model to mutate.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class ModelProvider implements IModelProvider {

	/**
	 * The resource containing the model.
	 */
	private Resource modelResource;

	/**
	 * The randomizer to use.
	 */
	private Random random = new Random();

	/**
	 * A list of objects to exclude from selection for mutation.
	 */
	private Set<EObject> excludedObjects = new HashSet<EObject>();

	/**
	 * {@inheritDoc}
	 */
	public Resource getModelResource() {
		return modelResource;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setModelResource(Resource modelResource) {
		this.modelResource = modelResource;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addToExcludedObjects(EObject eObject, boolean excludeChildren) {
		this.excludedObjects.add(eObject);
		if (excludeChildren) {
			TreeIterator<Object> contents = EcoreUtil.getAllContents(eObject,
					true);
			while (contents.hasNext()) {
				Object next = contents.next();
				if (next instanceof EModelElement) {
					this.excludedObjects.add((EModelElement) next);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void addToExcludedObjects(Collection<EObject> listOfEObject,
			boolean excludeChildren) {
		for (EObject eObject : listOfEObject) {
			addToExcludedObjects(eObject, excludeChildren);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject getRandomEObject() {
		TreeIterator<Object> treeIterator = EcoreUtil.getAllContents(
				modelResource, true);
		EList<EObject> eObjectList = new BasicEList<EObject>();
		while (treeIterator.hasNext()) {
			Object object = treeIterator.next();
			if (object instanceof EModelElement) {
				EObject eObject = (EModelElement) object;
				eObjectList.add(eObject);
			}
		}
		eObjectList.removeAll(excludedObjects);
		if (eObjectList.size() > 0) {
			return eObjectList.get(random.nextInt(eObjectList.size()));
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject getRandomEObject(EClass metaClass) {
		TreeIterator<Object> treeIterator = EcoreUtil.getAllContents(
				modelResource, true);
		EList<EObject> eObjectList = new BasicEList<EObject>();
		while (treeIterator.hasNext()) {
			Object object = treeIterator.next();
			if (object instanceof EModelElement) {
				EObject eObject = (EModelElement) object;
				if (metaClass.equals(eObject.eClass())) {
					eObjectList.add(eObject);
				}
			}
		}
		eObjectList.removeAll(excludedObjects);
		if (eObjectList.size() > 0) {
			return eObjectList.get(random.nextInt(eObjectList.size()));
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject getRandomEObjectNotContainingMoreObjectsThan(int objectCount) {
		TreeIterator<Object> treeIterator = EcoreUtil.getAllContents(
				modelResource, true);
		EList<EObject> eObjectList = new BasicEList<EObject>();
		while (treeIterator.hasNext()) {
			Object object = treeIterator.next();
			if (object instanceof EModelElement) {
				EObject eObject = (EModelElement) object;
				if (objectCount >= getContentSize(eObject)) {
					eObjectList.add(eObject);
				}
			}
		}
		eObjectList.removeAll(excludedObjects);
		if (eObjectList.size() > 0) {
			return eObjectList.get(random.nextInt(eObjectList.size()));
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject getRandomEObjectHavingFeature(EStructuralFeature feature) {
		TreeIterator<Object> treeIterator = EcoreUtil.getAllContents(
				modelResource, true);
		EList<EObject> eObjectList = new BasicEList<EObject>();
		while (treeIterator.hasNext()) {
			Object object = treeIterator.next();
			if (object instanceof EModelElement) {
				EObject eObject = (EModelElement) object;
				EClass eClass = eObject.eClass();
				if (eClass.getEAllStructuralFeatures().contains(feature)) {
					eObjectList.add(eObject);
				}
			}
		}
		eObjectList.removeAll(excludedObjects);
		if (eObjectList.size() > 0) {
			return eObjectList.get(random.nextInt(eObjectList.size()));
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public int getModelSize() {
		TreeIterator<Object> allContents = EcoreUtil.getAllContents(
				this.modelResource, true);
		return count(allContents);
	}

	/**
	 * {@inheritDoc}
	 */
	public EStructuralFeature getRandomFeature(EObject eObject) {
		EList<EStructuralFeature> features = new BasicEList<EStructuralFeature>();
		for (EStructuralFeature feature : eObject.eClass()
				.getEAllStructuralFeatures()) {
			if (!feature.isTransient() && !feature.isDerived()) {
				features.add(feature);
			}
		}
		if (features.size() > 0) {
			return features.get(random.nextInt(features.size()));
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public EStructuralFeature getRandomMultiValuedFeature(EObject eObject) {
		EList<EStructuralFeature> multiValuedFeatures = new BasicEList<EStructuralFeature>();
		for (EStructuralFeature feature : eObject.eClass()
				.getEAllStructuralFeatures()) {
			if (feature.isMany() && !feature.isTransient()
					&& !feature.isDerived()) {
				multiValuedFeatures.add(feature);
			}
		}
		if (multiValuedFeatures.size() > 0) {
			return multiValuedFeatures.get(random.nextInt(multiValuedFeatures
					.size()));
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public EStructuralFeature getRandomSingleValuedFeature(EObject eObject) {
		EList<EStructuralFeature> singleValuedFeatures = new BasicEList<EStructuralFeature>();
		for (EStructuralFeature feature : eObject.eClass()
				.getEAllStructuralFeatures()) {
			if (!feature.isMany() && feature.isChangeable()
					&& !feature.isTransient() && !feature.isDerived()) {
				singleValuedFeatures.add(feature);
			}
		}
		if (singleValuedFeatures.size() > 0) {
			return singleValuedFeatures.get(random.nextInt(singleValuedFeatures
					.size()));
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public EPackage getPackage() {
		Assert.isTrue(modelResource.getContents().size() > 0);
		return modelResource.getContents().get(0).eClass().getEPackage();
	}

	/**
	 * {@inheritDoc}
	 */
	public EClass getRandomConcreteClass() {
		EList<EClass> classes = new BasicEList<EClass>();
		for (EClassifier classifier : getPackage().getEClassifiers()) {
			if (classifier instanceof EClass) {
				if (!((EClass) classifier).isAbstract()) {
					classes.add((EClass) classifier);
				}
			}
		}
		return classes.get(random.nextInt(classes.size()));
	}

	/**
	 * {@inheritDoc}
	 */
	public EList<EStructuralFeature> getAllStructuralFeatures() {
		EList<EStructuralFeature> features = new BasicEList<EStructuralFeature>();
		for (EClassifier classifyer : getPackage().getEClassifiers()) {
			if (classifyer instanceof EClass) {
				EClass eClass = (EClass) classifyer;
				for (EStructuralFeature feature : eClass
						.getEStructuralFeatures()) {
					features.add(feature);
				}
			}
		}
		return features;
	}

	/**
	 * {@inheritDoc}
	 */
	public EStructuralFeature getRandomFeatureHavingType(EClass eClass) {
		return getRandomFeatureHavingType(eClass, false);
	}

	/**
	 * {@inheritDoc}
	 */
	public EStructuralFeature getRandomFeatureHavingType(EClass eClass,
			boolean isContainment) {
		EList<EStructuralFeature> features = new BasicEList<EStructuralFeature>();
		for (EStructuralFeature feature : getAllStructuralFeatures()) {
			if (eClass.equals(feature.getEType())) {
				if (!isContainment) {
					features.add(feature);
				} else {
					if (feature instanceof EReference) {
						EReference eReference = (EReference) feature;
						if (eReference.isContainment()) {
							features.add(feature);
						}
					}
				}
			}
		}
		if (features.size() > 0) {
			return features.get(random.nextInt(features.size()));
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public EList<EObject> getChildren(EObject eObject) {
		EList<EObject> children = new BasicEList<EObject>();
		Iterator<EObject> iterator = EcoreUtil.getAllContents(eObject, true);
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (next instanceof EModelElement) {
				children.add(next);
			}
		}
		return children;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getRandomValue(EStructuralFeature feature) {
		try {

			EClassifier eType = feature.getEType();

			if (eType instanceof EClass) {

				return getRandomEObject((EClass) eType);

			} else if (eType instanceof EEnum) {

				EEnum eEnum = (EEnum) eType;
				return eEnum.getELiterals().get(
						random.nextInt(eEnum.getELiterals().size()));

			} else if (eType instanceof EDataType) {

				// handle String data types
				if ("java.lang.String".equals(eType.getInstanceClassName())) { //$NON-NLS-1$
					return getRandomString();
				} else if ("int".equals(eType.getInstanceClassName()) //$NON-NLS-1$
						|| "java.lang.Integer".equals(eType.getInstanceClassName()) //$NON-NLS-1$
						|| "java.math.BigDecimal".equals(eType.getInstanceClassName()) //$NON-NLS-1$
						|| "java.math.BigInteger".equals(eType.getInstanceClassName())) { //$NON-NLS-1$
					return random.nextInt(100);
				} else if ("boolean".equals(eType.getInstanceClassName()) //$NON-NLS-1$
						|| "java.lang.Boolean".equals(eType.getInstanceClassName())) { //$NON-NLS-1$
					return random.nextBoolean();
				} else if ("byte".equals(eType.getInstanceClassName()) //$NON-NLS-1$
						|| "java.lang.Byte".equals(eType.getInstanceClassName())) { //$NON-NLS-1$
					return (byte) random.nextInt(100);
				} else if ("char".equals(eType.getInstanceClassName()) //$NON-NLS-1$
						|| "java.lang.Character".equals(eType.getInstanceClassName())) { //$NON-NLS-1$
					return getRandomString().toCharArray();
				} else if ("java.lang.Date".equals(eType.getInstanceClassName())) { //$NON-NLS-1$
					return new Date();
				} else if ("double".equals(eType.getInstanceClassName()) //$NON-NLS-1$
						|| "java.lang.Double".equals(eType.getInstanceClassName())) { //$NON-NLS-1$
					return random.nextDouble();
				} else if ("float".equals(eType.getInstanceClassName()) //$NON-NLS-1$
						|| "java.lang.Float".equals(eType.getInstanceClassName())) { //$NON-NLS-1$
					return random.nextFloat();
				} else if ("long".equals(eType.getInstanceClassName()) //$NON-NLS-1$
						|| "java.lang.Long".equals(eType.getInstanceClassName())) { //$NON-NLS-1$
					return random.nextLong();
				} else if ("short".equals(eType.getInstanceClassName()) //$NON-NLS-1$
						|| "java.lang.Short".equals(eType.getInstanceClassName())) { //$NON-NLS-1$
					return (short) random.nextInt(100);
				}
			}

			return null;

		} catch (ClassCastException e) {
			return null;
		}
	}

	/**
	 * Returns the size of <em>all children</em> (including grand children and
	 * so on) of the specified <code>eObject</code>.
	 * 
	 * @param eObject
	 *            to get children size of.
	 * @return the size.
	 */
	private int getContentSize(EObject eObject) {
		TreeIterator<Object> allContents = EcoreUtil.getAllContents(eObject,
				true);
		return count(allContents);
	}

	/**
	 * Counts the contents of the specified <code>iterator</code>.
	 * 
	 * @param iterator
	 *            to count objects of.
	 * @return the size of all objects held by the iterator.
	 */
	private int count(TreeIterator<Object> iterator) {
		int size = 0;
		while (iterator.hasNext()) {
			if (iterator.next() instanceof EModelElement) {
				size++;
			}
		}
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getRandomString() {
		return EcoreUtil.generateUUID();
	}

}
