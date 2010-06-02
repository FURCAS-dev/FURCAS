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

package org.modelversioning.ecoremutator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.modelversioning.ecoremutator.mutations.Mutation;
import org.modelversioning.ecoremutator.tracker.IMutationTracker;
import org.modelversioning.ecoremutator.tracker.impl.CSVMutationTracker;

/**
 * Mutates an ecore-based model with a set of {@link Mutation}s. Implementations of {@link Mutation}s can be set and weighted.
 * 
 * @author <a href="mailto:langer@big.tuwien.ac.at">Philip Langer</a>
 * 
 */
public class EcoreMutator {

    /**
     * The weights.
     */
    private Map<String, Integer> mutationWeights = new HashMap<String, Integer>();

    /**
     * The set mutations to use.
     */
    private Map<String, Mutation> mutations = new HashMap<String, Mutation>();

    /**
     * The randomizer to use.
     */
    private Random random = new Random();

    /**
     * Tracker to specify to called mutators.
     */
    private IMutationTracker tracker = new CSVMutationTracker();

    /**
     * Adds a mutation with default weight (1).
     * 
     * @param mutation
     *            to add.
     */
    public void addMutation(Mutation mutation) {
        addMutation(mutation, 1);
    }

    /**
     * Adds a mutation with the specified <code>weight</code>.
     * 
     * @param mutation
     *            to add.
     * @param weight
     *            to set.
     */
    public void addMutation(Mutation mutation, int weight) {
        mutations.put(mutation.getId(), mutation);
        mutationWeights.put(mutation.getId(), weight);
    }

    /**
     * Removes the mutation with the specified <code>id</code>.
     * 
     * @param id
     *            to remove.
     */
    public void removeMutation(String id) {
        mutations.remove(id);
        mutationWeights.remove(id);
    }

    /**
     * Removes the specified <code>mutation</code>.
     * 
     * @param mutation
     *            to remove.
     */
    public void removeMutation(Mutation mutation) {
        removeMutation(mutation.getId());
    }

    /**
     * Returns the currently set {@link IMutationTracker}.
     * 
     * @return the tracker.
     */
    public IMutationTracker getTracker() {
        return tracker;
    }

    /**
     * Sets the {@link IMutationTracker} to track mutator actions to.
     * 
     * @param tracker
     *            the tracker to set.
     */
    public void setTracker(IMutationTracker tracker) {
        this.tracker = tracker;
    }

    /**
     * Mutate the model provided by the specified <code>modelProvider</code> for <code>mutationCount</code> times.
     * 
     * @param modelProvider
     *            model provider.
     * @param mutationCount
     *            mutation count.
     */
    public void mutate(IModelProvider modelProvider, int mutationCount) {
        mutate(modelProvider, mutationCount, Collections.emptyMap());
    }

    /**
     * Mutate the model provided by the specified <code>modelProvider</code> for <code>mutationCount</code> times.
     * 
     * @param modelProvider
     *            model provider.
     * @param mutationCount
     *            mutation count.
     * @param options
     *            options for the mutation.
     */
    public void mutate(IModelProvider modelProvider, int mutationCount, Map<Object, Object> options) {
        // create weighted mutation list
        List<String> weightedMutationIds = new ArrayList<String>();
        for (String mutationId : this.mutations.keySet()) {
            for (int i = 0; i < mutationWeights.get(mutationId); i++) {
                weightedMutationIds.add(mutationId);
            }
        }

        // call a random mutation for <code>mutationCount</code> times
        for (int i = 0; i < mutationCount; i++) {
            int selectedMutationIndex = random.nextInt(weightedMutationIds.size());
            String selectedMutationId = weightedMutationIds.get(selectedMutationIndex);
            Mutation selectedMutator = mutations.get(selectedMutationId);
            boolean success = selectedMutator.mutate(modelProvider, tracker);
            if (!success) {
                // set counter one back
                i--;
            }
        }
    }

    /**
     * Use a new {@link Random}izer with the given seed.
     * 
     * @param seed
     *            the seed to use
     */
    public void seedRandomizer(long seed) {
        random = new Random(seed);
    }

}
