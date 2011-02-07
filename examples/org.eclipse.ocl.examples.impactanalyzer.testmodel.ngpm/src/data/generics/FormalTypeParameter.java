/**
 * <copyright>
 * </copyright>
 *
 * $Id: FormalTypeParameter.java,v 1.1 2011/02/07 16:49:10 auhl Exp $
 */
package data.generics;

import data.classes.SapClass;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A formal type argument to the ParameterizedClass owning this parameter object. It is valid only in the scope of the classDefinition owned by the ParameterizedClass that owns this parameter object.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.generics.FormalTypeParameter#getParameterOf <em>Parameter Of</em>}</li>
 *   <li>{@link data.generics.FormalTypeParameter#getTypeConstraint <em>Type Constraint</em>}</li>
 *   <li>{@link data.generics.FormalTypeParameter#getActualTypeParameters <em>Actual Type Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.generics.GenericsPackage#getFormalTypeParameter()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL UseInSignaturesOfOwningParamerizedClassOnly='self.elementsOfType.getTypeUsage()->forAll(s | s.oclIsKindOf(data::classes::Parameter) implies \r\n   (s.oclAsType(data::classes::Parameter).ownerSignature.oclIsKindOf(data::classes::MethodSignature) and\r\n    s.oclAsType(data::classes::Parameter).ownerSignature.oclAsType(data::classes::MethodSignature).owner=self.parameterOf .owningClassDefinition)) and\r\n  self.elementsOfType.signaturesWithOutput->forAll(s| s.oclIsKindOf(data::classes::MethodSignature) and \r\n    s.oclAsType(data::classes::MethodSignature).owner->notEmpty() and\r\n    s.oclAsType(data::classes::MethodSignature).owner=self.parameterOf.owningClassDefinition) and\r\n  self.signaturesWithFault->forAll(s| s.oclIsKindOf(data::classes::MethodSignature)  and \r\n    s.oclAsType(data::classes::MethodSignature).owner->notEmpty() and\r\n    s.oclAsType(data::classes::MethodSignature).owner=self.parameterOf.owningClassDefinition)' UseInAssociationsOfOwningParameterizedClassOnly='self.elementsOfType.associationEnd->\r\n    forAll(ae | ae.otherEnd().type.clazz = self.parameterOf.owningClassDefinition)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UseInSignaturesOfOwningParamerizedClassOnly UseInAssociationsOfOwningParameterizedClassOnly'"
 * @generated
 */
public interface FormalTypeParameter extends SapClass {
	/**
     * Returns the value of the '<em><b>Parameter Of</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.generics.ClassParameterization#getFormalTypeParameters <em>Formal Type Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Of</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter Of</em>' container reference.
     * @see #setParameterOf(ClassParameterization)
     * @see data.generics.GenericsPackage#getFormalTypeParameter_ParameterOf()
     * @see data.generics.ClassParameterization#getFormalTypeParameters
     * @model opposite="formalTypeParameters" required="true"
     * @generated
     */
	ClassParameterization getParameterOf();

	/**
     * Sets the value of the '{@link data.generics.FormalTypeParameter#getParameterOf <em>Parameter Of</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameter Of</em>' container reference.
     * @see #getParameterOf()
     * @generated
     */
	void setParameterOf(ClassParameterization value);

	/**
     * Returns the value of the '<em><b>Type Constraint</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Constraint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type Constraint</em>' reference.
     * @see #setTypeConstraint(SapClass)
     * @see data.generics.GenericsPackage#getFormalTypeParameter_TypeConstraint()
     * @model
     * @generated
     */
	SapClass getTypeConstraint();

	/**
     * Sets the value of the '{@link data.generics.FormalTypeParameter#getTypeConstraint <em>Type Constraint</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type Constraint</em>' reference.
     * @see #getTypeConstraint()
     * @generated
     */
	void setTypeConstraint(SapClass value);

	/**
     * Returns the value of the '<em><b>Actual Type Parameters</b></em>' reference list.
     * The list contents are of type {@link data.generics.ActualTypeParameter}.
     * It is bidirectional and its opposite is '{@link data.generics.ActualTypeParameter#getFormalTypeParameter <em>Formal Type Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Type Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Actual Type Parameters</em>' reference list.
     * @see data.generics.GenericsPackage#getFormalTypeParameter_ActualTypeParameters()
     * @see data.generics.ActualTypeParameter#getFormalTypeParameter
     * @model opposite="formalTypeParameter"
     * @generated
     */
	EList<ActualTypeParameter> getActualTypeParameters();

} // FormalTypeParameter
