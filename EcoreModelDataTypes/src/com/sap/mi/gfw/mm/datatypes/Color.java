/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.mi.gfw.mm.datatypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Color</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.mi.gfw.mm.datatypes.Color#getRed <em>Red</em>}</li>
 *   <li>{@link com.sap.mi.gfw.mm.datatypes.Color#getGreen <em>Green</em>}</li>
 *   <li>{@link com.sap.mi.gfw.mm.datatypes.Color#getBlue <em>Blue</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.mi.gfw.mm.datatypes.DatatypesPackage#getColor()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/com/sap/mi/gfw/mm[1.0]' metaObject='datatypes.Color' metaObjectMofId='45E806E31BEE0BFC06414C9B3C40BD0ABFB5FC54' isStructureType='false'"
 * @generated
 */
public interface Color extends EObject {
	/**
	 * Returns the value of the '<em><b>Red</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Red</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Red</em>' attribute.
	 * @see #setRed(int)
	 * @see com.sap.mi.gfw.mm.datatypes.DatatypesPackage#getColor_Red()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getRed();

	/**
	 * Sets the value of the '{@link com.sap.mi.gfw.mm.datatypes.Color#getRed <em>Red</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Red</em>' attribute.
	 * @see #getRed()
	 * @generated
	 */
	void setRed(int value);

	/**
	 * Returns the value of the '<em><b>Green</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Green</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Green</em>' attribute.
	 * @see #setGreen(int)
	 * @see com.sap.mi.gfw.mm.datatypes.DatatypesPackage#getColor_Green()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getGreen();

	/**
	 * Sets the value of the '{@link com.sap.mi.gfw.mm.datatypes.Color#getGreen <em>Green</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Green</em>' attribute.
	 * @see #getGreen()
	 * @generated
	 */
	void setGreen(int value);

	/**
	 * Returns the value of the '<em><b>Blue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blue</em>' attribute.
	 * @see #setBlue(int)
	 * @see com.sap.mi.gfw.mm.datatypes.DatatypesPackage#getColor_Blue()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getBlue();

	/**
	 * Sets the value of the '{@link com.sap.mi.gfw.mm.datatypes.Color#getBlue <em>Blue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blue</em>' attribute.
	 * @see #getBlue()
	 * @generated
	 */
	void setBlue(int value);

} // Color
