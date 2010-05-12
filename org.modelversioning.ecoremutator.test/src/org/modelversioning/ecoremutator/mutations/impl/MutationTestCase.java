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

package org.modelversioning.ecoremutator.mutations.impl;

import java.io.StringWriter;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.modelversioning.ecoremutator.IModelProvider;
import org.modelversioning.ecoremutator.mutations.ModelProvider;
import org.modelversioning.ecoremutator.tracker.IMutationTracker;

/**
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public abstract class MutationTestCase extends TestCase implements
		IMutationTracker {

	/**
	 * The separator.
	 */
	private static final String SEPARATOR = ",";
	private static final String LIST_SEPARATOR = "|";

	/**
	 * The end of line string.
	 */
	private static final String EOL = "\n";

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
	 * 
	 */
	@Override
	public void track(String mutatorId, String message, boolean successful,
			List<EObject> involvedObjects,
			List<EStructuralFeature> involvedFeatures) {
		StringWriter writer = new StringWriter();
		writer.append(mutatorId + SEPARATOR);
		writer.append(successful + SEPARATOR);
		writer.append(message + SEPARATOR);

		for (int i = 0; i < involvedObjects.size(); i++) {
			// out object
			EObject eObject = involvedObjects.get(i);
			String id = EcoreUtil.getID(eObject);
			if (id != null) {
				writer.append(id);
			} else {
				writer.append(eObject.toString());
			}
			// out internal list separator if not at the end
			if (i + 1 < involvedObjects.size()) {
				writer.append(LIST_SEPARATOR);
			}
		}

		for (int i = 0; i < involvedFeatures.size(); i++) {
			// out object
			EStructuralFeature feature = involvedFeatures.get(i);
			writer.append(feature.getName());
			// out internal list separator if not at the end
			if (i + 1 < involvedFeatures.size()) {
				writer.append(LIST_SEPARATOR);
			}
		}

		writer.append(EOL);
		System.out.println(writer.toString());
	}

}
