/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator;

import de.hpi.sam.bp2009.benchframework.OptionObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Option Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.OclOptionObject#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage#getOclOptionObject()
 * @model
 * @generated
 */
public interface OclOptionObject extends OptionObject {
	
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' attribute.
	 * @see #setConstraints(EList)
	 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage#getOclOptionObject_Constraints()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<String> getConstraints();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.oclOperator.OclOptionObject#getConstraints <em>Constraints</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraints</em>' attribute.
	 * @see #getConstraints()
	 * @generated
	 */
	void setConstraints(EList<String> value);
} // OclOptionObject
