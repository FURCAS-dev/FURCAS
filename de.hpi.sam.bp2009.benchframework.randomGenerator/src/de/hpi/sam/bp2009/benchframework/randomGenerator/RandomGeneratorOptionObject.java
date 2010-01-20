/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator;

import de.hpi.sam.bp2009.benchframework.OptionObject;

import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;

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
 *   <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject#getInstanceParameters <em>Instance Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage#getRandomGeneratorOptionObject()
 * @model
 * @generated
 */
public interface RandomGeneratorOptionObject extends OptionObject {
	/**
	 * Returns the value of the '<em><b>Meta Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model</em>' attribute.
	 * @see #setMetaModel(ResourceSet)
	 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage#getRandomGeneratorOptionObject_MetaModel()
	 * @model transient="true"
	 * @generated
	 */
	ResourceSet getMetaModel();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject#getMetaModel <em>Meta Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Model</em>' attribute.
	 * @see #getMetaModel()
	 * @generated
	 */
	void setMetaModel(ResourceSet value);

	/**
	 * Returns the value of the '<em><b>Instance Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Parameters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Parameters</em>' attribute.
	 * @see #setInstanceParameters(Map)
	 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage#getRandomGeneratorOptionObject_InstanceParameters()
	 * @model transient="true"
	 * @generated
	 */
	Map<String, Integer> getInstanceParameters();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject#getInstanceParameters <em>Instance Parameters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Parameters</em>' attribute.
	 * @see #getInstanceParameters()
	 * @generated
	 */
	void setInstanceParameters(Map<String, Integer> value);

} // RandomGeneratorOptionObject
