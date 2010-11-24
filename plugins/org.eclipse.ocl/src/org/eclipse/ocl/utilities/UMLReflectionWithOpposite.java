package org.eclipse.ocl.utilities;


/**
 * Adds a method for retrieving a property's opposites
 * 
 * @since 3.1
 */
public interface UMLReflectionWithOpposite<P> {
    /**
     * Obtains the opposite property.
     * @since 3.1
     */
    P getOpposite(P property);
}
