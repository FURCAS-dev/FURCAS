/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;

import java.util.Random;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Number Option Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This option object enables operators that use the random function to reexecuted with the same results for the "random" numbers.
 * When calling getNextInt() the object will return a random integer on the first iteration, and the same cached number will be returned on every following iteration. That means if you get 10 random numbers on first iteration, you'll get the same numbers on every following iteration.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.RandomNumberOptionObject#getNumberListIndex <em>Number List Index</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.RandomNumberOptionObject#getNumberList <em>Number List</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.RandomNumberOptionObject#getNumberGenerator <em>Number Generator</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getRandomNumberOptionObject()
 * @model
 * @generated
 */
public interface RandomNumberOptionObject extends OptionObject {
	/**
	 * Returns the value of the '<em><b>Number List Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number List Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number List Index</em>' attribute.
	 * @see #setNumberListIndex(int)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getRandomNumberOptionObject_NumberListIndex()
	 * @model
	 * @generated
	 */
	int getNumberListIndex();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.RandomNumberOptionObject#getNumberListIndex <em>Number List Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number List Index</em>' attribute.
	 * @see #getNumberListIndex()
	 * @generated
	 */
	void setNumberListIndex(int value);

	/**
	 * Returns the value of the '<em><b>Number List</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number List</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number List</em>' attribute list.
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getRandomNumberOptionObject_NumberList()
	 * @model transient="true"
	 * @generated
	 */
	EList<Integer> getNumberList();

	/**
	 * Returns the value of the '<em><b>Number Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Generator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Generator</em>' attribute.
	 * @see #setNumberGenerator(Random)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getRandomNumberOptionObject_NumberGenerator()
	 * @model dataType="de.hpi.sam.bp2009.benchframework.RandomNumberGenerator" transient="true"
	 * @generated
	 */
	Random getNumberGenerator();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.RandomNumberOptionObject#getNumberGenerator <em>Number Generator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Generator</em>' attribute.
	 * @see #getNumberGenerator()
	 * @generated
	 */
	void setNumberGenerator(Random value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Integer getNextInt(Integer upperLimit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Integer getNextInt();

} // RandomNumberOptionObject
