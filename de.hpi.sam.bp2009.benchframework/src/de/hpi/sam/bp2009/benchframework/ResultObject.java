/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.swt.widgets.Composite;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.ResultObject#getResultDisplay <em>Result Display</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getResultObject()
 * @model
 * @generated
 */
public interface ResultObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Result Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Display</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Display</em>' attribute.
	 * @see #setResultDisplay(Composite)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getResultObject_ResultDisplay()
	 * @model dataType="de.hpi.sam.bp2009.benchframework.UIComponent"
	 * @generated
	 */
	Composite getResultDisplay();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.ResultObject#getResultDisplay <em>Result Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Display</em>' attribute.
	 * @see #getResultDisplay()
	 * @generated
	 */
	void setResultDisplay(Composite value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Map<String, Object> getPropertyMap();

} // ResultObject
