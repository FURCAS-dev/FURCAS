package org.eclipse.ocl.ecore.util;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentWithHiddenOpposites;


/**
 * @since 3.1
 */
public class TypeUtil {
	/**
     * Gets the type of a property's (hidden) opposite.
     * 
     * @param env the OCL environment
     * @param owner the source of the navigation of the property, which may
     *     be an association class (the interesting scenario)
     * @param property the property to navigate
     * 
     * @return the effective type of the property, which may not be a
     *    collection type despite its declared multiplicity in the association
     *    class case
	 * @since 3.1
	 */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C getOppositePropertyType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner,
			P property) {
       return ((EnvironmentWithHiddenOpposites<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>) env).getOppositePropertyType(owner, property);
	}
}
