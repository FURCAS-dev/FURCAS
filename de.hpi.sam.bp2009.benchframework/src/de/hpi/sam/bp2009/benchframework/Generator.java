/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.Generator#getDefaultOption <em>Default Option</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getGenerator()
 * @model abstract="true"
 * @generated
 */
public interface Generator extends EObject {
	/**
	 * Returns the value of the '<em><b>Default Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Option</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Option</em>' reference.
	 * @see #setDefaultOption(OptionObject)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getGenerator_DefaultOption()
	 * @model
	 * @generated
	 */
	OptionObject getDefaultOption();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.Generator#getDefaultOption <em>Default Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Option</em>' reference.
	 * @see #getDefaultOption()
	 * @generated
	 */
	void setDefaultOption(OptionObject value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Resource execute(OptionObject option);

} // Generator
