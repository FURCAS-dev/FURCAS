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

package org.modelversioning.ecoremutator.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.modelversioning.ecoremutator.IModelProvider;
import org.modelversioning.ecoremutator.mutations.ModelProvider;

/**
 * Tests the class {@link ModelProvider}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class ModelProviderTest extends TestCase {

	ResourceSet resourceSet = new ResourceSetImpl();
	Resource sample1Resource;
	private IModelProvider modelProviderSample1;

	/**
	 * @throws java.lang.Exception
	 */
	protected void setUp() throws Exception {
		// load sample 1 model
		sample1Resource = loadResource("models/sample1.ecore");
		Assert.assertTrue(sample1Resource.getContents().size() == 1);
		// initialize sample 1 model provider
		modelProviderSample1 = new ModelProvider();
		modelProviderSample1.setModelResource(sample1Resource);
	}

	/**
	 * Loads the resource with the specified <code>fileURI</code>.
	 * 
	 * @param fileURI
	 *            to load.
	 * @return loaded resource.
	 */
	private Resource loadResource(String fileURIString) {
		URI fileURI = URI.createURI(fileURIString, true);
		return resourceSet.getResource(fileURI, true);
	}

	/**
	 * @throws java.lang.Exception
	 */
	protected void tearDown() throws Exception {
		sample1Resource.unload();
	}

	/**
	 * Test method for
	 * {@link org.modelversioning.ecoremutator.mutations.ModelProvider#getRandomEObject()}
	 * .
	 */
	public void testGetRandomEObject() {
		for (int i = 0; i < 50; i++) {
			EObject eObject = modelProviderSample1.getRandomEObject();
			assertNotNull(eObject);
			assertTrue(eObject instanceof EModelElement);
		}
	}

	/**
	 * Test method for
	 * {@link org.modelversioning.ecoremutator.mutations.ModelProvider#getRandomEObject(org.eclipse.emf.ecore.EClass)}
	 * .
	 */
	public void testGetRandomEObjectEClass() {
		for (int i = 0; i < 10; i++) {
			EObject eObject = modelProviderSample1
					.getRandomEObject(EcoreFactory.eINSTANCE.getEcorePackage()
							.getEClass());
			assertNotNull(eObject);
			assertTrue(eObject instanceof EClass);
		}

		for (int i = 0; i < 10; i++) {
			EObject eObject = modelProviderSample1
					.getRandomEObject(EcoreFactory.eINSTANCE.getEcorePackage()
							.getEAttribute());
			assertNotNull(eObject);
			assertTrue(eObject instanceof EAttribute);
		}

		for (int i = 0; i < 10; i++) {
			EObject eObject = modelProviderSample1
					.getRandomEObject(EcoreFactory.eINSTANCE.getEcorePackage()
							.getEOperation());
			assertNotNull(eObject);
			assertTrue(eObject instanceof EOperation);
		}
	}

	/**
	 * Test method for
	 * {@link org.modelversioning.ecoremutator.mutations.ModelProvider#getRandomEObjectNotContainingMoreObjectsThan(int)}
	 * .
	 */
	public void testGetRandomEObjectNotContainingMoreObjectsThan() {
		for (int i = 0; i < 50; i++) {
			EObject eObject = modelProviderSample1
					.getRandomEObjectNotContainingMoreObjectsThan(i);
			assertNotNull(eObject);
			assertTrue(eObject instanceof EModelElement);
		}
	}

	/**
	 * Test method for
	 * {@link org.modelversioning.ecoremutator.mutations.ModelProvider#getModelSize()}.
	 */
	public void testGetModelSize() {
		assertEquals(30, modelProviderSample1.getModelSize());
	}

	/**
	 * Test method for
	 * {@link org.modelversioning.ecoremutator.mutations.ModelProvider#getRandomFeature(org.eclipse.emf.ecore.EObject)}
	 * .
	 */
	public void testGetRandomFeature() {
		for (int i = 0; i < 50; i++) {
			EObject eObject = modelProviderSample1.getRandomEObject();
			EStructuralFeature feature = modelProviderSample1
					.getRandomFeature(eObject);
			assertNotNull(feature);
			try {
				eObject.eUnset(feature);
			} catch (IllegalArgumentException e) {
				fail(feature + " is not in the meta class or not changable");
			}
		}
	}

	/**
	 * Test method for
	 * {@link org.modelversioning.ecoremutator.mutations.ModelProvider#getRandomMultiValuedFeature(org.eclipse.emf.ecore.EObject)}
	 * .
	 */
	public void testGetRandomMultiValuedFeature() {
		for (int i = 0; i < 50; i++) {
			EObject eObject = modelProviderSample1.getRandomEObject();
			EStructuralFeature feature = modelProviderSample1
					.getRandomMultiValuedFeature(eObject);
			assertNotNull(feature);
			assertTrue(feature.isMany());
			assertTrue(eObject.eGet(feature) instanceof EList<?>);
			try {
				eObject.eUnset(feature);
			} catch (IllegalArgumentException e) {
				fail(feature + " is not in the meta class or not changable");
			}
		}
	}

	/**
	 * Test method for
	 * {@link org.modelversioning.ecoremutator.mutations.ModelProvider#getRandomSingleValuedFeature(org.eclipse.emf.ecore.EObject)}
	 * .
	 */
	public void testGetRandomSingleValuedFeature() {
		for (int i = 0; i < 50; i++) {
			EObject eObject = modelProviderSample1.getRandomEObject();
			EStructuralFeature feature = modelProviderSample1
					.getRandomSingleValuedFeature(eObject);
			assertNotNull(feature);
			assertTrue(!feature.isMany());
			assertTrue(!(eObject.eGet(feature) instanceof EList<?>));
			try {
				eObject.eUnset(feature);
			} catch (IllegalArgumentException e) {
				fail(feature + " is not in the meta class or not changable");
			}
		}
	}

	// /**
	// * Test method for
	// * {@link
	// org.modelversioning.ecoremutator.ModelProvider#getRandomValue(org.eclipse.emf.ecore.EStructuralFeature)}
	// * .
	// */
	// public void testGetRandomValue() {
	// for (int i = 0; i < 50; i++) {
	// EObject eObject = modelProviderSample1.getRandomEObject();
	// EStructuralFeature feature = modelProviderSample1
	// .getRandomFeature(eObject);
	// System.out.println(modelProviderSample1.getRandomValue(feature));
	// }
	// }

	/**
	 * Test method for
	 * {@link org.modelversioning.ecoremutator.mutations.ModelProvider#getAllStructuralFeatures()}
	 * .
	 */
	public void testGetAllStructuralFeatures() {
		EList<EStructuralFeature> features = modelProviderSample1
				.getAllStructuralFeatures();
		for (EStructuralFeature feature : features) {
			assertEquals(modelProviderSample1.getPackage(), feature
					.getEContainingClass().getEPackage());
		}
	}

	/**
	 * Test method for
	 * {@link org.modelversioning.ecoremutator.mutations.ModelProvider#getRandomConcreteClass()}
	 */
	public void testGetRandomConcreteClass() {
		for (int i = 0; i < 50; i++) {
			EClass eClass = modelProviderSample1.getRandomConcreteClass();
			assertNotNull(eClass);
			assertEquals(modelProviderSample1.getPackage(), eClass
					.getEPackage());
		}
	}

	/**
	 * Test method for
	 * {@link org.modelversioning.ecoremutator.mutations.ModelProvider#getRandomFeatureHavingType(EClass)}
	 */
	public void testGetRandomFeatureHavingType() {
		EClassifier eClassifier = modelProviderSample1.getPackage()
				.getEClassifier("EAttribute"); //$NON-NLS-1$
		assertNotNull(eClassifier);
		assertTrue(eClassifier instanceof EClass);
		EClass eAttributeClass = (EClass) eClassifier;
		for (int i = 0; i < 10; i++) {
			EStructuralFeature featureHavingType = modelProviderSample1
					.getRandomFeatureHavingType(eAttributeClass);
			assertTrue(eAttributeClass.equals(featureHavingType.getEType()));
		}
	}

}
