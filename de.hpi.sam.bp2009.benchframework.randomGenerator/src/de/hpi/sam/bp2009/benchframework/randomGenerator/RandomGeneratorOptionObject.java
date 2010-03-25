/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator;

import org.eclipse.emf.ecore.EPackage;

import de.hpi.sam.bp2009.benchframework.RandomNumberOptionObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This is the option object of a RandomGenerator. It holds the metaModel to instantiate along with a map of parameters the generated instance has to match.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject#getMetaModel <em>Meta Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage#getRandomGeneratorOptionObject()
 * @model
 * @generated
 */
public interface RandomGeneratorOptionObject extends RandomNumberOptionObject {
	/**
	 * Returns the value of the '<em><b>Meta Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model</em>' containment reference.
	 * @see #setMetaModel(EPackage)
	 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage#getRandomGeneratorOptionObject_MetaModel()
	 * @model containment="true"
	 * @generated
	 */
	EPackage getMetaModel();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject#getMetaModel <em>Meta Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Model</em>' containment reference.
	 * @see #getMetaModel()
	 * @generated
	 */
	void setMetaModel(EPackage value);

} // RandomGeneratorOptionObject
