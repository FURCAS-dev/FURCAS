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

import java.util.Map;

import org.eclipse.core.runtime.ILog;
import org.modelversioning.ecoremutator.IModelProvider;
import org.modelversioning.ecoremutator.tracker.IMutationTracker;

/**
 * Represents a generic mutation.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public interface Mutation {

    /**
     * Returns the Id of this mutation.
     * 
     * @return
     */
    String getId();

    /**
     * Sets the logger to log the actions of this mutator to.
     * 
     * @param logger
     *            to set.
     */
    void setLogger(ILog logger);

    /**
     * Sets the options.
     * 
     * @param options
     *            to set.
     */
    void setOptions(Map<Object, Object> options);

    /**
     * Applies this mutation to the model provided by the specified <code>modelProvider</code>.
     * 
     * @param modelProvider
     *            the {@link ModelProvider} to set.
     * @param tracker
     *            to track mutator actions to.
     * @return <code>true</code> if mutation has been applied. Otherwise <code>false</code>.
     */
    boolean mutate(IModelProvider modelProvider, IMutationTracker tracker);

}
