/**
 * <copyright>
 * </copyright>
 *
 * $Id: ClassParameterization.java,v 1.1 2011/02/07 16:49:10 auhl Exp $
 */
package data.generics;

import data.classes.SapClass;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Parameterization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.generics.ClassParameterization#getFormalTypeParameters <em>Formal Type Parameters</em>}</li>
 *   <li>{@link data.generics.ClassParameterization#getOwningClassDefinition <em>Owning Class Definition</em>}</li>
 *   <li>{@link data.generics.ClassParameterization#getPackage_ <em>Package </em>}</li>
 * </ul>
 * </p>
 *
 * @see data.generics.GenericsPackage#getClassParameterization()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL DistinctFormalTypeParameterNames='self.formalTypeParameters->forAll(i,j|i<>j implies i.name<>j.name)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='DistinctFormalTypeParameterNames'"
 * @generated
 */
public interface ClassParameterization extends EObject {
	/**
     * Returns the value of the '<em><b>Formal Type Parameters</b></em>' containment reference list.
     * The list contents are of type {@link data.generics.FormalTypeParameter}.
     * It is bidirectional and its opposite is '{@link data.generics.FormalTypeParameter#getParameterOf <em>Parameter Of</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formal Type Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Formal Type Parameters</em>' containment reference list.
     * @see data.generics.GenericsPackage#getClassParameterization_FormalTypeParameters()
     * @see data.generics.FormalTypeParameter#getParameterOf
     * @model opposite="parameterOf" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	EList<FormalTypeParameter> getFormalTypeParameters();

	/**
     * Returns the value of the '<em><b>Owning Class Definition</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getParameterization <em>Parameterization</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class Definition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owning Class Definition</em>' container reference.
     * @see #setOwningClassDefinition(SapClass)
     * @see data.generics.GenericsPackage#getClassParameterization_OwningClassDefinition()
     * @see data.classes.SapClass#getParameterization
     * @model opposite="parameterization"
     * @generated
     */
	SapClass getOwningClassDefinition();

	/**
     * Sets the value of the '{@link data.generics.ClassParameterization#getOwningClassDefinition <em>Owning Class Definition</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owning Class Definition</em>' container reference.
     * @see #getOwningClassDefinition()
     * @generated
     */
	void setOwningClassDefinition(SapClass value);

	/**
     * Returns the value of the '<em><b>Package </b></em>' container reference.
     * It is bidirectional and its opposite is '{@link modelmanagement.Package#getParameterizedClasses <em>Parameterized Classes</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package </em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Package </em>' container reference.
     * @see #setPackage_(modelmanagement.Package)
     * @see data.generics.GenericsPackage#getClassParameterization_Package_()
     * @see modelmanagement.Package#getParameterizedClasses
     * @model opposite="parameterizedClasses"
     * @generated
     */
	modelmanagement.Package getPackage_();

	/**
     * Sets the value of the '{@link data.generics.ClassParameterization#getPackage_ <em>Package </em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Package </em>' container reference.
     * @see #getPackage_()
     * @generated
     */
	void setPackage_(modelmanagement.Package value);

} // ClassParameterization
