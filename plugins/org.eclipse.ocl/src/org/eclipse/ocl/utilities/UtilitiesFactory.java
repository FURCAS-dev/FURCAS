/**
 * <copyright>
 * </copyright>
 *
 * $Id: UtilitiesFactory.java,v 1.1 2007/01/25 18:24:32 cdamus Exp $
 */
package org.eclipse.ocl.utilities;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.utilities.UtilitiesPackage
 * @generated
 */
public interface UtilitiesFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	UtilitiesFactory eINSTANCE = org.eclipse.ocl.utilities.impl.UtilitiesFactoryImpl.init();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	UtilitiesPackage getUtilitiesPackage();

} //UtilitiesFactory
