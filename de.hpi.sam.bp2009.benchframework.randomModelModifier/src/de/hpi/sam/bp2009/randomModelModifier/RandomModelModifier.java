/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.randomModelModifier;

import de.hpi.sam.bp2009.benchframework.Operator;
import java.util.Random;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Model Modifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.randomModelModifier.RandomModelModifier#getRandomNumberGenerator <em>Random Number Generator</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierPackage#getRandomModelModifier()
 * @model
 * @generated
 */
public interface RandomModelModifier extends Operator {

	/**
	 * Returns the value of the '<em><b>Random Number Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Random Number Generator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Random Number Generator</em>' attribute.
	 * @see #setRandomNumberGenerator(Random)
	 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierPackage#getRandomModelModifier_RandomNumberGenerator()
	 * @model dataType="de.hpi.sam.bp2009.randomModelModifier.Random"
	 * @generated
	 */
	Random getRandomNumberGenerator();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.randomModelModifier.RandomModelModifier#getRandomNumberGenerator <em>Random Number Generator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Random Number Generator</em>' attribute.
	 * @see #getRandomNumberGenerator()
	 * @generated
	 */
	void setRandomNumberGenerator(Random value);
} // RandomModelModifier
