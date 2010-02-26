/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions;

import com.sap.tc.moin.repository.mmi.Model.AssociationEnd;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Navigation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.OCL.Expressions.NavigationCallExp#getNavigationSource <em>Navigation Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.OCL.Expressions.ExpressionsPackage#getNavigationCallExp()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.NavigationCallExp' metaObjectMofId='45ED2E29EFE35FF1987D4F740DA9CAEF5A8133E7' isStructureType='false'"
 * @generated
 */
public interface NavigationCallExp extends ModelPropertyCallExp {
	/**
	 * Returns the value of the '<em><b>Navigation Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Navigation Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Navigation Source</em>' reference.
	 * @see #setNavigationSource(AssociationEnd)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getNavigationCallExp_NavigationSource()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.A_navigationSource_navigationCallExp' metaObjectMofId='45ED2E29C3F3694401514BBF08EFC44C72D73F4A' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	AssociationEnd getNavigationSource();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.NavigationCallExp#getNavigationSource <em>Navigation Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Navigation Source</em>' reference.
	 * @see #getNavigationSource()
	 * @generated
	 */
	void setNavigationSource(AssociationEnd value);

} // NavigationCallExp
