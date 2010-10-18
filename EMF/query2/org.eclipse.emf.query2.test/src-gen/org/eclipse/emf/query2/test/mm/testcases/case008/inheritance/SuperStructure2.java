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
package org.eclipse.emf.query2.test.mm.testcases.case008.inheritance;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Super Structure2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure2#getSuperField1From2 <em>Super Field1 From2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage#getSuperStructure2()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case008.inheritance.SuperStructure2' metaObjectMofId='487756D5CABCDC3E4F4711DD8CE3D7DB0A126A9B' isStructureType='true'"
 * @generated
 */
public interface SuperStructure2 extends EObject {
	/**
	 * Returns the value of the '<em><b>Super Field1 From2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Field1 From2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Field1 From2</em>' attribute.
	 * @see #setSuperField1From2(String)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage#getSuperStructure2_SuperField1From2()
	 * @model required="true"
	 * @generated
	 */
	String getSuperField1From2();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure2#getSuperField1From2 <em>Super Field1 From2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Field1 From2</em>' attribute.
	 * @see #getSuperField1From2()
	 * @generated
	 */
	void setSuperField1From2(String value);

} // SuperStructure2
