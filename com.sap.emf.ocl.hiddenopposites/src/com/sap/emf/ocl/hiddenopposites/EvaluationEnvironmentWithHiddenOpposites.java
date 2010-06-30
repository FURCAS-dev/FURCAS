package com.sap.emf.ocl.hiddenopposites;

import java.util.List;


/**
 * Introduces the {@link #navigateOppositeProperty(P, List, Object)} method to
 * {@link AbstractEvaluationEnvironment} which implements this interface.
 * 
 * @author Axel Uhl
 *
 */
public interface EvaluationEnvironmentWithHiddenOpposites<P> {
    /**
     * Obtains the value of the specified operation, for the given source element,
     * according to the particular metamodel semantics.
     * 
     * @param property the property to navigate in reverse direction
     * @param qualifiers the association-end qualifier values, or an empty list
     *     if none
     * @param source the source element from where to start navigating / querying
     * @return the property value
     * 
     * @throws IllegalArgumentException if the property is not supported by the
     *     element or by this environment
     * @since 3.0
     */
    Object navigateOppositeProperty(P property, List<?> qualifiers, Object source)
    	throws IllegalArgumentException;

}
