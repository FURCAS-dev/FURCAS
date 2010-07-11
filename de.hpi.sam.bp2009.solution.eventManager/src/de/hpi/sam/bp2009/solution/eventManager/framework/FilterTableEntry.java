package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains all registrations that are associated with a filter
 * criterion in an EventFilterTable. There are two types of
 * <code>Registrations</code>}:
 * <ul>
 * <li>the registrations that are registered to a certain filter criterion
 * </li>
 * <li>the registrations that are registered in a negated way to a certain
 * filter criterion</li>
 * </ul>
 * 
 * @author Daniel Vocke (D044825)
 */
public class FilterTableEntry<Type> {

    // TODO why are these lists? Would have expected that fast set operations are required as these collections may grow large
    private List<Type> registrations = new ArrayList<Type>();

    // TODO why are these lists? Would have expected that fast set operations are required as these collections may grow large
    private List<Type> negatedRegistrations = new ArrayList<Type>();
    
    FilterTableEntry() {
    };

    /**
     * the registrations that are registered in a negated way to a certain
     * filter criterion
     * 
     * @return Returns the NoSet.
     */
    List<Type> getNegatedRegistrations() {
        return negatedRegistrations;
    }

    /**
     * the registrations that are registered to a certain filter criterion
     * 
     * @return Returns the YesSet.
     */
    List<Type> getRegistrations() {
        return registrations;
    }
    
    /**
     * @return true if both sets (the <code>YetSet</code> AND the
     * <code>NoSet</code>) are empty
     */
    boolean isEmpty() {
        return registrations.isEmpty() && negatedRegistrations.isEmpty();
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("yesSetSize: ");
        result.append(getRegistrations().size());
        result.append(", noSetSize: ");
        result.append(getNegatedRegistrations().size());
        return result.toString();
    }
}