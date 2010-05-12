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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.modelversioning.ecoremutator.IModelProvider;
import org.modelversioning.ecoremutator.mutations.ModelProvider;

/**
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class MoveObjectMutationTest extends MutationTestCase {

	/**
	 * Test method for
	 * {@link org.modelversioning.ecoremutator.mutations.impl.MoveObjectMutation#mutate(org.modelversioning.ecoremutator.mutations.ModelProvider, org.modelversioning.ecoremutator.tracker.IMutationTracker)}
	 * .
	 */
	public void testMutate() {
		// initialize model provider
		IModelProvider modelProvider = new ModelProvider();
		modelProvider.setModelResource(sample1Resource);

		MoveObjectMutation mutation = new MoveObjectMutation();
		for (int i = 0; i < 10; i++) {
			mutation.mutate(modelProvider, this);
		}
	}

	@Override
	public void track(String mutatorId, String message, boolean successful,
			List<EObject> involvedObjects,
			List<EStructuralFeature> involvedFeatures) {
		System.out.println(message);
		if (successful) {
			assertTrue(involvedObjects.size() == 1);
			EObject eObject = involvedObjects.get(0);
			System.out.println(eObject.eContainer());
		}
	}

}
