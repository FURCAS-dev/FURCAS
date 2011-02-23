/**
 * <copyright>
 * </copyright>
 *
 * $Id: CountryImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package configuration.businessconfiguration.impl;

import configuration.businessconfiguration.BusinessconfigurationPackage;
import configuration.businessconfiguration.Country;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Country</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CountryImpl extends ScopingContextImpl implements Country {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CountryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return BusinessconfigurationPackage.Literals.COUNTRY;
    }

} //CountryImpl
