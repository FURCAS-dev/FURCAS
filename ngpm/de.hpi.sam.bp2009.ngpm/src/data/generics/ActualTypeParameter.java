/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.generics;

import data.classes.SapClass;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actual Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.generics.ActualTypeParameter#getParameterizedClassInstantiation <em>Parameterized Class Instantiation</em>}</li>
 *   <li>{@link data.generics.ActualTypeParameter#getType <em>Type</em>}</li>
 *   <li>{@link data.generics.ActualTypeParameter#getFormalTypeParameter <em>Formal Type Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.generics.GenericsPackage#getActualTypeParameter()
 * @model annotation="http://de.hpi.sam.bp2009.OCL TypeConformsWithFormalParametersTypeConstraint='self.formalTypeParameter.typeConstraint->notEmpty() implies\r\n    self.type.conformsTo(self.formalTypeParameter.typeConstraint)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='TypeConformsWithFormalParametersTypeConstraint'"
 * @generated
 */
public interface ActualTypeParameter extends EObject {
	/**
     * Returns the value of the '<em><b>Parameterized Class Instantiation</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.generics.ParameterizedClassInstantiation#getActualTypeParametersForInstantiation <em>Actual Type Parameters For Instantiation</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameterized Class Instantiation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Parameterized Class Instantiation</em>' container reference.
     * @see #setParameterizedClassInstantiation(ParameterizedClassInstantiation)
     * @see data.generics.GenericsPackage#getActualTypeParameter_ParameterizedClassInstantiation()
     * @see data.generics.ParameterizedClassInstantiation#getActualTypeParametersForInstantiation
     * @model opposite="actualTypeParametersForInstantiation" required="true"
     * @generated
     */
	ParameterizedClassInstantiation getParameterizedClassInstantiation();

	/**
     * Sets the value of the '{@link data.generics.ActualTypeParameter#getParameterizedClassInstantiation <em>Parameterized Class Instantiation</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameterized Class Instantiation</em>' container reference.
     * @see #getParameterizedClassInstantiation()
     * @generated
     */
	void setParameterizedClassInstantiation(ParameterizedClassInstantiation value);

	/**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(SapClass)
     * @see data.generics.GenericsPackage#getActualTypeParameter_Type()
     * @model required="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='actualTypeParametersOfClass'"
     * @generated
     */
	SapClass getType();

	/**
     * Sets the value of the '{@link data.generics.ActualTypeParameter#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
	void setType(SapClass value);

	/**
     * Returns the value of the '<em><b>Formal Type Parameter</b></em>' reference.
     * It is bidirectional and its opposite is '{@link data.generics.FormalTypeParameter#getActualTypeParameters <em>Actual Type Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formal Type Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Formal Type Parameter</em>' reference.
     * @see #setFormalTypeParameter(FormalTypeParameter)
     * @see data.generics.GenericsPackage#getActualTypeParameter_FormalTypeParameter()
     * @see data.generics.FormalTypeParameter#getActualTypeParameters
     * @model opposite="actualTypeParameters" required="true"
     * @generated
     */
	FormalTypeParameter getFormalTypeParameter();

	/**
     * Sets the value of the '{@link data.generics.ActualTypeParameter#getFormalTypeParameter <em>Formal Type Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Formal Type Parameter</em>' reference.
     * @see #getFormalTypeParameter()
     * @generated
     */
	void setFormalTypeParameter(FormalTypeParameter value);

} // ActualTypeParameter
