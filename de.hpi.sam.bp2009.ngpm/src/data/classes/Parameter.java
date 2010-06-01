/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import dataaccess.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.Parameter#getOwnerSignature <em>Owner Signature</em>}</li>
 *   <li>{@link data.classes.Parameter#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getParameter()
 * @model annotation="http://de.hpi.sam.bp2009.OCL DefaultValueType='self.defaultValue->notEmpty() implies self.defaultValue.getType().conformsTo(self.getType())'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='DefaultValueType'"
 * @generated
 */
public interface Parameter extends NamedValue {
	/**
	 * Returns the value of the '<em><b>Owner Signature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link data.classes.Signature#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner Signature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner Signature</em>' container reference.
	 * @see #setOwnerSignature(Signature)
	 * @see data.classes.ClassesPackage#getParameter_OwnerSignature()
	 * @see data.classes.Signature#getInput
	 * @model opposite="input"
	 * @generated
	 */
	Signature getOwnerSignature();

	/**
	 * Sets the value of the '{@link data.classes.Parameter#getOwnerSignature <em>Owner Signature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner Signature</em>' container reference.
	 * @see #getOwnerSignature()
	 * @generated
	 */
	void setOwnerSignature(Signature value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' containment reference.
	 * @see #setDefaultValue(Expression)
	 * @see data.classes.ClassesPackage#getParameter_DefaultValue()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
	 * @generated
	 */
	Expression getDefaultValue();

	/**
	 * Sets the value of the '{@link data.classes.Parameter#getDefaultValue <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' containment reference.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(Expression value);

} // Parameter
