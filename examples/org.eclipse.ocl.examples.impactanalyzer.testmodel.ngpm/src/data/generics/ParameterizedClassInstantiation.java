/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParameterizedClassInstantiation.java,v 1.1 2011/02/07 16:49:10 auhl Exp $
 */
package data.generics;

import data.classes.SapClass;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameterized Class Instantiation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An instantiation of a parameterized class (a class that has one or more FormalTypeParameters associated) with a set of data types that match the parameterized type's signature. The instantiation is itself usable as a Class. It may as such itself still have formal type parameters which then make it a parameterized class that itself requires instantiation before it it a fully-specified type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.generics.ParameterizedClassInstantiation#getActualTypeParametersForInstantiation <em>Actual Type Parameters For Instantiation</em>}</li>
 *   <li>{@link data.generics.ParameterizedClassInstantiation#getParameterizedClass <em>Parameterized Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.generics.GenericsPackage#getParameterizedClassInstantiation()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ActualTypeParametersMatchSignature='self.actualTypeParametersForInstantiation->size() = self.parameterizedClass.parameterization.formalTypeParameters->size() and\r\n  Sequence{1..self.actualTypeParametersForInstantiation->size()}->forAll(i:Integer|\r\n    self.actualTypeParametersForInstantiation->at(i).formalTypeParameter =\r\n    self.parameterizedClass.parameterization.formalTypeParameters->at(i))' ClassMustBeParameterized='self.parameterizedClass.parameterization->notEmpty()'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ActualTypeParametersMatchSignature ClassMustBeParameterized'"
 * @generated
 */
public interface ParameterizedClassInstantiation extends SapClass {
	/**
     * Returns the value of the '<em><b>Actual Type Parameters For Instantiation</b></em>' containment reference list.
     * The list contents are of type {@link data.generics.ActualTypeParameter}.
     * It is bidirectional and its opposite is '{@link data.generics.ActualTypeParameter#getParameterizedClassInstantiation <em>Parameterized Class Instantiation</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Type Parameters For Instantiation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Actual Type Parameters For Instantiation</em>' containment reference list.
     * @see data.generics.GenericsPackage#getParameterizedClassInstantiation_ActualTypeParametersForInstantiation()
     * @see data.generics.ActualTypeParameter#getParameterizedClassInstantiation
     * @model opposite="parameterizedClassInstantiation" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	EList<ActualTypeParameter> getActualTypeParametersForInstantiation();

	/**
     * Returns the value of the '<em><b>Parameterized Class</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameterized Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Parameterized Class</em>' reference.
     * @see #setParameterizedClass(SapClass)
     * @see data.generics.GenericsPackage#getParameterizedClassInstantiation_ParameterizedClass()
     * @model required="true"
     * @generated
     */
	SapClass getParameterizedClass();

	/**
     * Sets the value of the '{@link data.generics.ParameterizedClassInstantiation#getParameterizedClass <em>Parameterized Class</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameterized Class</em>' reference.
     * @see #getParameterizedClass()
     * @generated
     */
	void setParameterizedClass(SapClass value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Returns the ActualTypeParameter's type (a Class) from the actualTypeParameters association end whose formalTypeParameter is the one passed. If no such formal type parameter is found, no object (null) is returned.
     * <!-- end-model-doc -->
     * @model unique="false" ordered="false" ftpUnique="false" ftpRequired="true" ftpOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.actualTypeParametersForInstantiation->select(atp:ActualTypeParameter |\n    atp.formalTypeParameter = ftp)->asSequence()->at(1).type'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	SapClass resolveFormalTypeParameter(FormalTypeParameter ftp);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='parameterizedClass.parameterization'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	ClassParameterization getClassParameterization();

} // ParameterizedClassInstantiation
