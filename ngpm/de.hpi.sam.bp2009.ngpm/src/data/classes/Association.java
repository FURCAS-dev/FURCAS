/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import abapmapping.AbapAssociationImplementationAnnotation;

import data.timedependency.TimeDependency;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.Association#getEnds <em>Ends</em>}</li>
 *   <li>{@link data.classes.Association#getPackage_ <em>Package </em>}</li>
 *   <li>{@link data.classes.Association#getTimeDependency <em>Time Dependency</em>}</li>
 *   <li>{@link data.classes.Association#getAbapAnnotation <em>Abap Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getAssociation()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL UniquenessOnBothEndsMustBeTheSame='self.ends->forAll( e1, e2 : AssociationEnd |\r\n              e1 <> e2 implies e1.type.unique = e2.type.unique)' AtMostOneCompositeEnd='self.ends->select(composite)->size() < 2' AtLeastOneNavigableEnd='self.ends->select(ae:AssociationEnd | ae.navigable)->notEmpty()' AtMostOneEqualityContributionForTwoValueClasses='self.ends->select(contributesToEquality and type.clazz.valueType)->size() < 2' AtMostOneOrderedEnd='self.ends->select(ae|ae.type.ordered)->size() < 2'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UniquenessOnBothEndsMustBeTheSame AtMostOneCompositeEnd AtLeastOneNavigableEnd AtMostOneEqualityContributionForTwoValueClasses AtMostOneOrderedEnd'"
 * @generated
 */
public interface Association extends NamedElement {
	/**
     * Returns the value of the '<em><b>Ends</b></em>' containment reference list.
     * The list contents are of type {@link data.classes.AssociationEnd}.
     * It is bidirectional and its opposite is '{@link data.classes.AssociationEnd#getAssociation <em>Association</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ends</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Ends</em>' containment reference list.
     * @see data.classes.ClassesPackage#getAssociation_Ends()
     * @see data.classes.AssociationEnd#getAssociation
     * @model opposite="association" containment="true" resolveProxies="true" lower="2" upper="2"
     * @generated
     */
	EList<AssociationEnd> getEnds();

	/**
     * Returns the value of the '<em><b>Package </b></em>' container reference.
     * It is bidirectional and its opposite is '{@link modelmanagement.Package#getAssociations <em>Associations</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package </em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Package </em>' container reference.
     * @see #setPackage_(modelmanagement.Package)
     * @see data.classes.ClassesPackage#getAssociation_Package_()
     * @see modelmanagement.Package#getAssociations
     * @model opposite="associations" required="true"
     * @generated
     */
	modelmanagement.Package getPackage_();

	/**
     * Sets the value of the '{@link data.classes.Association#getPackage_ <em>Package </em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Package </em>' container reference.
     * @see #getPackage_()
     * @generated
     */
	void setPackage_(modelmanagement.Package value);

	/**
     * Returns the value of the '<em><b>Time Dependency</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link data.timedependency.TimeDependency#getAssociation <em>Association</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Dependency</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Time Dependency</em>' containment reference.
     * @see #setTimeDependency(TimeDependency)
     * @see data.classes.ClassesPackage#getAssociation_TimeDependency()
     * @see data.timedependency.TimeDependency#getAssociation
     * @model opposite="association" containment="true" resolveProxies="true"
     * @generated
     */
	TimeDependency getTimeDependency();

	/**
     * Sets the value of the '{@link data.classes.Association#getTimeDependency <em>Time Dependency</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Time Dependency</em>' containment reference.
     * @see #getTimeDependency()
     * @generated
     */
	void setTimeDependency(TimeDependency value);

	/**
     * Returns the value of the '<em><b>Abap Annotation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abap Annotation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Abap Annotation</em>' reference.
     * @see #setAbapAnnotation(AbapAssociationImplementationAnnotation)
     * @see data.classes.ClassesPackage#getAssociation_AbapAnnotation()
     * @model
     * @generated
     */
	AbapAssociationImplementationAnnotation getAbapAnnotation();

	/**
     * Sets the value of the '{@link data.classes.Association#getAbapAnnotation <em>Abap Annotation</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Abap Annotation</em>' reference.
     * @see #getAbapAnnotation()
     * @generated
     */
	void setAbapAnnotation(AbapAssociationImplementationAnnotation value);

} // Association
