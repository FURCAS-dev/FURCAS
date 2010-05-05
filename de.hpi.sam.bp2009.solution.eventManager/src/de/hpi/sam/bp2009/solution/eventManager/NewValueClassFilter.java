/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Value Class Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.NewValueClassFilter#getAffectedClass <em>Affected Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getNewValueClassFilter()
 * @model
 * @generated
 */
public interface NewValueClassFilter extends EventFilter {
	/**
     * Returns the value of the '<em><b>Affected Class</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affected Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Affected Class</em>' reference.
     * @see #setAffectedClass(EClass)
     * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getNewValueClassFilter_AffectedClass()
     * @model
     * @generated
     */
	EClass getAffectedClass();

	/**
     * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.NewValueClassFilter#getAffectedClass <em>Affected Class</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Affected Class</em>' reference.
     * @see #getAffectedClass()
     * @generated
     */
	void setAffectedClass(EClass value);

} // NewValueClassFilter
