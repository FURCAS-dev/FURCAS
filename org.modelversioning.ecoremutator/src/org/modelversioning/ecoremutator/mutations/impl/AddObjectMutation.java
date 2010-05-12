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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.modelversioning.ecoremutator.IModelProvider;
import org.modelversioning.ecoremutator.mutations.AbstractMutation;
import org.modelversioning.ecoremutator.tracker.IMutationTracker;

/**
 * Adds a random {@link EObject}.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class AddObjectMutation extends AbstractMutation {

	/**
	 * {@inheritDoc}
	 * 
	 * Adds a random {@link EObject}.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean mutate(IModelProvider modelProvider, IMutationTracker tracker) {
		boolean success = false;
		Exception occurredException = null;

		EClass eClass = modelProvider.getRandomConcreteClass();
		if (eClass != null) {
			EStructuralFeature feature = modelProvider
					.getRandomFeatureHavingType(eClass, true);
			if (feature != null) {
				EObject parent = modelProvider
						.getRandomEObjectHavingFeature(feature);
				if (parent != null) {
					EObject eObject = createInstance(eClass, modelProvider);
					try {
						if (!feature.isMany()) {
							parent.eSet(feature, eObject);
							success = true;
						} else {
							// get list
							Object listValue = parent.eGet(feature, true);
							success = true;
							if (listValue instanceof List) {
								((List) listValue).add(eObject);
								success = true;
							}
						}
						if (success) {
							String message = "Added " + eObject.toString()
									+ " to " + parent.toString()
									+ " using feature " + feature;
							log(IStatus.INFO, message);
							// track mutation
							List<EObject> involvedEObjects = toEObjectList(eObject);
							involvedEObjects.add(parent);
							tracker.track(this.getId(), message, true,
									involvedEObjects, toFeatureList(feature));
							return true;
						}
					} catch (ClassCastException cce) {
						occurredException = cce;
					} catch (IllegalArgumentException iae) {
						occurredException = iae;
					} catch (ArrayStoreException ase) {
						occurredException = ase;
					}
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
	 * Creates a new instance of the specified <code>eClass</code>.
	 * 
	 * @param eClass
	 *            to create instance for.
	 * @return new instance.
	 */
	private EObject createInstance(EClass eClass, IModelProvider modelProvider) {
		EObject instance = EcoreUtil.create(eClass);
		for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
			if (feature.isChangeable()) {
				try {
					instance.eSet(feature, modelProvider
							.getRandomValue(feature));
				} catch (ClassCastException cce) {
					continue;
				} catch (IllegalArgumentException iae) {
					continue;
				} catch (ArrayStoreException ase) {
					continue;
				} catch (NullPointerException npe) {
					continue;
				}
			}
		}
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return "mutation.addObject";
	}
}
