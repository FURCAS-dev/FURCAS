/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.ecore.EPackage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.PackageFilter#getWantedPackage <em>Wanted Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getPackageFilter()
 * @model
 * @generated
 */
public interface PackageFilter extends EventFilter {

	/**
     * Returns the value of the '<em><b>Wanted Package</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wanted Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Wanted Package</em>' reference.
     * @see #setWantedPackage(EPackage)
     * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getPackageFilter_WantedPackage()
     * @model
     * @generated
     */
	EPackage getWantedPackage();

	/**
     * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.PackageFilter#getWantedPackage <em>Wanted Package</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Wanted Package</em>' reference.
     * @see #getWantedPackage()
     * @generated
     */
	void setWantedPackage(EPackage value);
} // PackageFilter
