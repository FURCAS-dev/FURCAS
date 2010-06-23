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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.modelversioning.ecoremutator.IModelProvider;
import org.modelversioning.ecoremutator.mutations.AbstractMutation;
import org.modelversioning.ecoremutator.tracker.IMutationTracker;

/**
 * Deletes an {@link EObject}.
 * 
 * By default it only removes leave objects. Using the option <code>DELETE_MAX_MODEL_PERCENTAGE</code>, clients may specify how
 * many percent of the complete model, the object selected for deletion may contain.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class DeleteObjectMutation extends AbstractMutation {

    /**
     * Option specifying how many percent of the complete model, the object selected for deletion may contain. Default is 0.
     */
    public static String DELETE_MAX_MODEL_PERCENTAGE = DeleteObjectMutation.class.getCanonicalName()
            + "DELETE_MAX_MODEL_PERCENTAGE"; //$NON-NLS-1$

    /**
     * Default value for {@link #DELETE_MAX_MODEL_PERCENTAGE}.
     */
    private static int default_DELETE_MAX_MODEL_PERCENTAGE = 0;

    /**
     * {@inheritDoc}
     * 
     * Deletes a random leave object.
     */
    @Override
    public boolean mutate(IModelProvider modelProvider, IMutationTracker tracker) {
        boolean success = false;
        // compute model size to maximally delete
        int perc = (Integer) getOptionValue(DELETE_MAX_MODEL_PERCENTAGE, default_DELETE_MAX_MODEL_PERCENTAGE);
        int size = modelProvider.getModelSize() * perc;
        if (size > 0) {
            size = size / 100;
        }

        // get object to delete
        //at the moment we don't care how many objects are deleted
        EObject eObjectToDelete = modelProvider.getRandomEObject(); //NotContainingMoreObjectsThan(size);
        if (eObjectToDelete != null) {
            // delete
            EcoreUtil.delete(eObjectToDelete, true);
            log(IStatus.INFO, "Deleted " + eObjectToDelete.toString());
            // track mutation
            tracker.track(this.getId(), "Deleted " + eObjectToDelete.toString(), true, toEObjectList(eObjectToDelete),
                    toFeatureList(null));
            success = true;
        } else {
            log(IStatus.WARNING, "Model provider did not return a suitable object to delete.");
            tracker.track(this.getId(), "Model provider did not return a suitable object to delete.", false, toEObjectList(null),
                    toFeatureList(null));
            success = false;
        }

        return success;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return "mutation.deleteObject";
    }
}
