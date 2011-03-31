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

import java.util.HashSet;

import org.eclipse.ocl.examples.eventmanager.util.Bag;
import org.eclipse.ocl.examples.eventmanager.util.SingleSetAsBag;

/**
 * This class contains all registrations that are associated with a single filter
 * criterion in an {@link TableForEventFilter}. There are two types of
 * <code>Registrations</code>}:
 * <ul>
 * <li>the registrations that are registered to a certain filter criterion
 * </li>
 * <li>the registrations that are registered in a negated way to a certain
 * filter criterion</li>
 * </ul>
 * 
 * The registrations are stored keyed by the set of tables in which the {@link Registration}
 * is registered. With this, an intersection of the positive registrations in those tables
 * can be performed, restricted to the registrations that are registered for the same set of
 * tables.
 * 
 * @author Daniel Vocke (D044825)
 */
public class FilterTableEntry {

    private SingleSetAsBag<Registration>[] registrations;
    private SingleSetAsBag<Registration>[] negatedRegistrations;
    private int numberOfRegistrationSets;
    
    @SuppressWarnings("unchecked")
    FilterTableEntry(int numberOfFilterTables) {
        registrations = (SingleSetAsBag<Registration>[]) new SingleSetAsBag<?>[1<<numberOfFilterTables];
        negatedRegistrations = (SingleSetAsBag<Registration>[]) new SingleSetAsBag<?>[1<<numberOfFilterTables];
    };

    /**
     * @return true if both sets (the <code>YetSet</code> AND the
     * <code>NoSet</code>) are empty
     */
    boolean isEmpty() {
        return numberOfRegistrationSets == 0;
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("  yesSetSizes:");
        for (int i = 0; i < registrations.length; i++) {
            if (registrations[i] != null) {
                result.append("\n   registrations[" + i + "].size()=");
                result.append(registrations[i].size());
            }
        }
        result.append("\n  noSetSizes: ");
        for (int i = 0; i < negatedRegistrations.length; i++) {
            if (negatedRegistrations[i] != null) {
                result.append("\n   negatedRegistrations[" + i + "].size()=");
                result.append(negatedRegistrations[i].size());
            }
        }
        return result.toString();
    }

    public void addRegistrations(Registration registration) {
        addRegistrationTo(registration, registrations);
    }
    
    public void addNegatedRegistrations(Registration registration) {
        addRegistrationTo(registration, negatedRegistrations);
    }

    private void addRegistrationTo(Registration registration, SingleSetAsBag<Registration>[] registrationSetArray) {
        int bitSet = registration.getBitSetForTablesRegisteredWith();
        SingleSetAsBag<Registration> registrationSet = registrationSetArray[bitSet];
        if (registrationSet == null) {
            registrationSet = new SingleSetAsBag<Registration>(new HashSet<Registration>());
            registrationSetArray[bitSet] = registrationSet;
            numberOfRegistrationSets++;
        }
        registrationSet.getWrappedSet().add(registration);
    }

    public void remove(Registration registration) {
        removeFromRegistrationSet(registration, registrations);
        removeFromRegistrationSet(registration, negatedRegistrations);
    }
    
    private void removeFromRegistrationSet(Registration registration, SingleSetAsBag<Registration>[] registrationSetArray) {
        int bitSet = registration.getBitSetForTablesRegisteredWith();
        SingleSetAsBag<Registration> bag = registrationSetArray[bitSet];
        if (bag != null) {
            if (bag.getWrappedSet().remove(registration)) {
                numberOfRegistrationSets--;
            }
        }
    }
    
    public Bag<Registration> getYesSet(int bitSetForTableCombination) {
        return registrations[bitSetForTableCombination];
    }
    
    public Bag<Registration> getNoSet(int bitSetForTableCombination) {
        return negatedRegistrations[bitSetForTableCombination];
    }
    
    /**
     * The explicit "yes" registrations, as an array where each element corresponds to one bit set
     * that describes in which tables the registration is registered. Clients must not modify the array returned!
     */
    public Bag<Registration>[] getYesSets() {
        return registrations;
    }
    
    /**
     * The explicit "no" registrations, as an array where each element corresponds to one bit set
     * that describes in which tables the registration is registered. Clients must not modify the array returned!
     */
    public Bag<Registration>[] getNoSets() {
        return negatedRegistrations;
    }
}
