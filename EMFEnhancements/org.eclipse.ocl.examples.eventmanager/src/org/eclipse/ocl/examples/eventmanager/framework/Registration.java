/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.eventmanager.framework;



import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.ocl.examples.eventmanager.Statistics;
import org.eclipse.ocl.examples.eventmanager.filters.AndFilter;


/**
 * A Registration represents a set of events that a listener wants to receive. Due to the fact that one call to
 * register..() on the EventRegistry interface can result in multiple registrations (due to the internal design),
 * registrations can be pooled into a set (the {@link RegistrationSet}).
 * 
 * @author Daniel Vocke (D044825), Axel Uhl (D043530)
 */
class Registration {

    /**
     * Registration objects are re-used to keep the tables in the event manager as small as possible and
     * free of redundancy. Therefore, a registration can belong to multiple {@link RegistrationSet}s, each
     * representing a listener.
     */
    private Set<RegistrationSet> registrationSets;
    
    /**
     * A bit field where each bit is taken from the {@link RegistrationManagerTableBased#filterTypeToBitMask} values,
     * representing a table with which this registration is registered. This number can be used as index into
     * the registration sets stored in the filter tables.
     */
    private final int bitSetForTablesRegisteredWith;
    
    /**
     * Stores the <code>AndFilter</code> for which this registration was created.
     */
    private final AndFilter andFilter;

    /**
     * @param bitSetForTablesRegisteredWith a bit set indicating for which tables this listener is registered.
     * This bit set corresponds with what {@link RegistrationManagerTableBased#getTablesForBitSet(int)} takes as
     * an argument.
     * @param andFilter when running in "debug mode" with the {@link Statistics} capturing turned on, the
     * <code>andFilter</code> will be remembered (otherwise, a {@link Registration} doesn't know its filter, hence
     * the filter can eventually get garbage-collected) and will be shown in the {@link #toString()} output.
     */
    Registration(int bitSetForTablesRegisteredWith, AndFilter andFilter) {
        this.bitSetForTablesRegisteredWith = bitSetForTablesRegisteredWith;
        this.andFilter = andFilter;
        registrationSets = new HashSet<RegistrationSet>();
    }

    /**
     * Can be used as index into registration arrays, such as those managed by
     * {@link FilterTableEntry}.
     */
    public int getBitSetForTablesRegisteredWith() {
        return bitSetForTablesRegisteredWith;
    }

    /**
     * When a call to register...() on the EventRegistry interface results in multiple Registrations, those Registrations will be
     * pooled in a RegistrationSet. This can happen due to the internal design where "OR connected" filters are splitted into
     * multiple Registrations.
     * 
     * @return an unmodifiable collection of the RegistrationSets that pool all Registrations that were created during one
     *         registration call
     */
    Set<RegistrationSet> getRegistrationSets() {
        return Collections.unmodifiableSet(registrationSets);
    }

    /**
     * Adds the registration to the {@link #registrationSets} collection. Note that this operation
     * does not maintain any opposite reference in {@link RegistrationSet}.
     */
    void addRegistrationSet(RegistrationSet registrationSet) {
        registrationSets.add(registrationSet);
    }

    /**
     * Removes <code>registationSet</code> from {@link #registrationSets} and returns <code>true</code> if that removed the last
     * {@link RegistrationSet} of which this {@link Registration} was a part. Note, that <code>false</code> will be returned
     * if {@link #registrationSets} was already empty when calling this method. 
     */
    boolean removeRegistrationSet(RegistrationSet registrationSet) {
        boolean result = false;
        if (registrationSets.remove(registrationSet)) {
            result = registrationSets.size() == 0;
        }
        return result;
    }
    
    public String toString() {
        return super.toString()+" bitSet "+bitSetForTablesRegisteredWith;
    }

    public AndFilter getAndFilter() {
        return andFilter;
    }
}
