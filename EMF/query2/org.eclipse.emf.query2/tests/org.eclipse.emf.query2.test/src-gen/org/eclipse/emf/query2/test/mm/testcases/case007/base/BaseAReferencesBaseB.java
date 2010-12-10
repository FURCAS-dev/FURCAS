/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.testcases.case007.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AReferences Base B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseAReferencesBaseB#getBaseB <em>Base B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseAReferencesBaseB#getBaseA <em>Base A</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.BasePackage#getBaseAReferencesBaseB()
 * @model
 * @generated
 */
public interface BaseAReferencesBaseB extends EObject {
	/**
	 * Returns the value of the '<em><b>Base B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base B</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base B</em>' reference.
	 * @see #setBaseB(BaseB)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.BasePackage#getBaseAReferencesBaseB_BaseB()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case007.base.BaseAReferencesBaseB' metaObjectMofId='476118E36F91756AA96F11DCC6F3001558C93B47' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	BaseB getBaseB();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseAReferencesBaseB#getBaseB <em>Base B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base B</em>' reference.
	 * @see #getBaseB()
	 * @generated
	 */
	void setBaseB(BaseB value);

	/**
	 * Returns the value of the '<em><b>Base A</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base A</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base A</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.BasePackage#getBaseAReferencesBaseB_BaseA()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case007.base.BaseAReferencesBaseB' metaObjectMofId='476118E36F91756AA96F11DCC6F3001558C93B47' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<BaseA> getBaseA();

} // BaseAReferencesBaseB
