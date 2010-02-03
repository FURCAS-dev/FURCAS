/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Encapsules a view for the results of an operator execution.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.ResultObject#getResultComposite <em>Result Composite</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.ResultObject#getStatus <em>Status</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.ResultObject#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getResultObject()
 * @model
 * @generated
 */
public interface ResultObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Result Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * used for eclipse wizard view
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Result Composite</em>' attribute.
	 * @see #setResultComposite(Composite)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getResultObject_ResultComposite()
	 * @model dataType="de.hpi.sam.bp2009.benchframework.UIComponent"
	 * @generated
	 */
	Composite getResultComposite();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.ResultObject#getResultComposite <em>Result Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Composite</em>' attribute.
	 * @see #getResultComposite()
	 * @generated
	 */
	void setResultComposite(Composite value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link de.hpi.sam.bp2009.benchframework.Status}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see de.hpi.sam.bp2009.benchframework.Status
	 * @see #setStatus(Status)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getResultObject_Status()
	 * @model
	 * @generated
	 */
	Status getStatus();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.ResultObject#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see de.hpi.sam.bp2009.benchframework.Status
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(Status value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getResultObject_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.ResultObject#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

} // ResultObject
