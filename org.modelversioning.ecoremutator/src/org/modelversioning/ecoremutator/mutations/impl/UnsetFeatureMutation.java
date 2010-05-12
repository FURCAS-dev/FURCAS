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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.modelversioning.ecoremutator.IModelProvider;
import org.modelversioning.ecoremutator.mutations.AbstractMutation;
import org.modelversioning.ecoremutator.tracker.IMutationTracker;

/**
 * Unsets a random {@link EStructuralFeature} (that is not a containment
 * feature) of a random {@link EObject}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class UnsetFeatureMutation extends AbstractMutation {

	/**
	 * {@inheritDoc}
	 * 
	 * Unsets a random {@link EStructuralFeature} (that is not a containment
	 * feature) of a random {@link EObject}.
	 */
	@Override
	public boolean mutate(IModelProvider modelProvider, IMutationTracker tracker) {
		Exception occurredException = null;

		// get object to update
		EObject eObjectToUpdate = modelProvider.getRandomEObject();
		if (eObjectToUpdate != null) {
			// get target feature
			EStructuralFeature targetFeature = modelProvider
					.getRandomFeature(eObjectToUpdate);
			// guard null and containment feature (otherwise it would be a move)
			if (targetFeature != null && !isContainmentFeature(targetFeature)) {
				try {
					eObjectToUpdate.eUnset(targetFeature);
					String message = "Unset " + eObjectToUpdate.toString()
							+ " at " + targetFeature.getName();
					log(IStatus.INFO, message);
					// track mutation
					tracker.track(this.getId(), message, true,
							toEObjectList(eObjectToUpdate),
							toFeatureList(targetFeature));
					return true;
				} catch (ClassCastException cce) {
					occurredException = cce;
				} catch (IllegalArgumentException iae) {
					occurredException = iae;
				} catch (ArrayStoreException ase) {
					occurredException = ase;
				}
			}
		}

		// track failing mutation
		String message = "Model provider did not return a suitable object, "
				+ "target feature, or value to update.";
		log(IStatus.WARNING, message, occurredException);
		tracker.track(this.getId(), message, false, toEObjectList(null),
				toFeatureList(null));

		return false;
	}

	/**
	 * Specifies whether the specified <code>feature</code> is a containment
	 * feature.
	 * 
	 * @param feature
	 *            to check.
	 * @return <code>true</code> if containment feature, otherwise
	 *         <code>false</code>.
	 */
	private boolean isContainmentFeature(EStructuralFeature feature) {
		if (feature instanceof EReference) {
			if (((EReference) feature).isContainment()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return "mutation.unsetFeature";
	}
}
