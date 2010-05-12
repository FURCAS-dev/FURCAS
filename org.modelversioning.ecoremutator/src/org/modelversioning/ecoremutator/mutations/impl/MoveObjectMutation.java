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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.modelversioning.ecoremutator.IModelProvider;
import org.modelversioning.ecoremutator.mutations.AbstractMutation;
import org.modelversioning.ecoremutator.tracker.IMutationTracker;

/**
 * Moves an {@link EObject}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class MoveObjectMutation extends AbstractMutation {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return "mutation.moveObject";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Moves a random object to a random feature of another random object.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean mutate(IModelProvider modelProvider, IMutationTracker tracker) {
		boolean success = false;

		// get object to move
		EObject eObjectToMove = modelProvider.getRandomEObject();
		if (eObjectToMove != null) {
			// get target feature
			EStructuralFeature targetFeature = modelProvider
					.getRandomFeatureHavingType(eObjectToMove.eClass(), true);
			if (targetFeature != null) {
				// get target object
				EObject targetObject = modelProvider
						.getRandomEObjectHavingFeature(targetFeature);
				if (targetObject != null) {

					if (!targetObject.equals(eObjectToMove)
							&& !EcoreUtil.isAncestor(targetObject,
									eObjectToMove)) {
						Object currentValue = targetObject.eGet(targetFeature,
								true);
						if (currentValue instanceof List) {
							// add to list
							try {
								((List) currentValue).add(eObjectToMove);
								success = true;
							} catch (ClassCastException e) {
								// do nothing
							}
						} else {
							// set to feature
							targetObject.eSet(targetFeature, eObjectToMove);
							success = true;
						}
						if (success) {
							String message = "Moved "
									+ eObjectToMove.toString() + " to "
									+ targetObject + " using feature "
									+ targetFeature.getName();
							log(IStatus.INFO, message);
							// track mutation
							tracker.track(this.getId(), message, true,
									toEObjectList(eObjectToMove),
									toFeatureList(targetFeature));
							return true;
						}
					}
				}
			}
		}

		// track failing mutation
		String message = "Model provider did not return a suitable object, "
				+ "target feature, or target to move.";
		log(IStatus.WARNING, message);
		tracker.track(this.getId(), message, false, toEObjectList(null),
				toFeatureList(null));

		return false;
	}
}
