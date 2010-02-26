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
 * A representation of the model object '<em><b>Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.mi.gfw.mm.datatypes.Point#getX <em>X</em>}</li>
 *   <li>{@link com.sap.mi.gfw.mm.datatypes.Point#getY <em>Y</em>}</li>
 *   <li>{@link com.sap.mi.gfw.mm.datatypes.Point#getBefore <em>Before</em>}</li>
 *   <li>{@link com.sap.mi.gfw.mm.datatypes.Point#getAfter <em>After</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.mi.gfw.mm.datatypes.DatatypesPackage#getPoint()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/com/sap/mi/gfw/mm[1.0]' metaObject='datatypes.Point' metaObjectMofId='473ABD0053BA21A2929211DCC37B8000600FE800' isStructureType='true'"
 * @generated
 */
public interface Point extends EObject {
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see com.sap.mi.gfw.mm.datatypes.DatatypesPackage#getPoint_X()
	 * @model required="true"
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link com.sap.mi.gfw.mm.datatypes.Point#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see com.sap.mi.gfw.mm.datatypes.DatatypesPackage#getPoint_Y()
	 * @model required="true"
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link com.sap.mi.gfw.mm.datatypes.Point#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * Returns the value of the '<em><b>Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Before</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Before</em>' attribute.
	 * @see #setBefore(int)
	 * @see com.sap.mi.gfw.mm.datatypes.DatatypesPackage#getPoint_Before()
	 * @model required="true"
	 * @generated
	 */
	int getBefore();

	/**
	 * Sets the value of the '{@link com.sap.mi.gfw.mm.datatypes.Point#getBefore <em>Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Before</em>' attribute.
	 * @see #getBefore()
	 * @generated
	 */
	void setBefore(int value);

	/**
	 * Returns the value of the '<em><b>After</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>After</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>After</em>' attribute.
	 * @see #setAfter(int)
	 * @see com.sap.mi.gfw.mm.datatypes.DatatypesPackage#getPoint_After()
	 * @model required="true"
	 * @generated
	 */
	int getAfter();

	/**
	 * Sets the value of the '{@link com.sap.mi.gfw.mm.datatypes.Point#getAfter <em>After</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>After</em>' attribute.
	 * @see #getAfter()
	 * @generated
	 */
	void setAfter(int value);

} // Point
