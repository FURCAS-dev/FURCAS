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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.modelversioning.ecoremutator.IModelProvider;
import org.modelversioning.ecoremutator.mutations.AbstractMutation;
import org.modelversioning.ecoremutator.tracker.IMutationTracker;

/**
 * Adds a random {@link EAnnotation} to a random {@link EObject}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class AddAnnotationMutation extends AbstractMutation {

	private static final String SOURCE_URI = "http://www.modelversioning.org/ecoremutator";

	/**
	 * {@inheritDoc}
	 * 
	 * Adds a random {@link EAnnotation} to a random {@link EObject}.
	 */
	@Override
	public boolean mutate(IModelProvider modelProvider, IMutationTracker tracker) {
		// get object to update
		EObject eObjectToUpdate = modelProvider.getRandomEObject();
		if (eObjectToUpdate != null && eObjectToUpdate instanceof EModelElement) {
			EcoreUtil.setAnnotation((EModelElement) eObjectToUpdate,
					SOURCE_URI, modelProvider.getRandomString(), modelProvider
							.getRandomString());
			log(IStatus.INFO, "Added annotation to "
					+ eObjectToUpdate.toString());
			// track mutation
			tracker.track(this.getId(), "Added annotation to "
					+ eObjectToUpdate.toString(), true,
					toEObjectList(eObjectToUpdate), toFeatureList(null));
			return true;
		}
		// track failing mutation
		String message = "Model provider did not return a suitable object.";
		log(IStatus.WARNING, message);
		tracker.track(this.getId(), message, false, toEObjectList(null),
				toFeatureList(null));

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return "mutation.addAnnotation";
	}
}
