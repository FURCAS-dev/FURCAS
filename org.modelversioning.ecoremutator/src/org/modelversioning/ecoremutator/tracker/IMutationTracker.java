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

package org.modelversioning.ecoremutator.tracker;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Interface specifying the methods to be called to track mutator actions.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public interface IMutationTracker {

	/**
	 * Tracks a mutator action specifying some facts about the applied mutation.
	 * 
	 * @param mutatorId
	 *            the id of the mutator.
	 * @param message
	 *            a message describing the mutation.
	 * @param successful
	 *            specifies whether the mutation was successful.
	 * @param involvedObjects
	 *            a list of involved objects.
	 * @param involvedFeatures
	 *            a list of involved features (might be null).
	 */
	public void track(String mutatorId, String message, boolean successful,
			List<EObject> involvedObjects,
			List<EStructuralFeature> involvedFeatures);

}
