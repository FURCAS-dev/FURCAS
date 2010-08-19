/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import abapmapping.AbapAssociationEndImplementationAnnotation;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.AssociationEnd#isNavigable <em>Navigable</em>}</li>
 *   <li>{@link data.classes.AssociationEnd#isComposite <em>Composite</em>}</li>
 *   <li>{@link data.classes.AssociationEnd#isContributesToEquality <em>Contributes To Equality</em>}</li>
 *   <li>{@link data.classes.AssociationEnd#getAssociation <em>Association</em>}</li>
 *   <li>{@link data.classes.AssociationEnd#getDelegation <em>Delegation</em>}</li>
 *   <li>{@link data.classes.AssociationEnd#getSignatureImplementations <em>Signature Implementations</em>}</li>
 *   <li>{@link data.classes.AssociationEnd#getType <em>Type</em>}</li>
 *   <li>{@link data.classes.AssociationEnd#getAbapAnnotation <em>Abap Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getAssociationEnd()
 * @model annotation="http://de.hpi.sam.bp2009.OCL ExposingClassesEqualOppositeEndsType='self.signatureImplementations.implements_.owner->forAll(c:SignatureOwner | c = self.otherEnd().type.clazz)' NoCompositionWithValueClass='self.composite implies self.association.ends.type->forAll(ctd:ClassTypeDefinition | not ctd.clazz.valueType)' EqualityContributionsMustBeExposedAndNavigable='self.contributesToEquality implies (self.otherEnd().signatureImplementations->notEmpty() and self.otherEnd().navigable)' EqualityContributingEndOnValueMustHaveUnlimitedUpperBounds='(self.type.clazz.valueType and self.contributesToEquality and\r\n   self.type.clazz.getAssociationEnds()->exists(ae |\r\n     ae <> self and ae.contributesToEquality)) implies\r\n  self.type.isMany()'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ExposingClassesEqualOppositeEndsType NoCompositionWithValueClass EqualityContributionsMustBeExposedAndNavigable EqualityContributingEndOnValueMustHaveUnlimitedUpperBounds'"
 * @generated
 */
public interface AssociationEnd extends NamedElement {
	/**
     * Returns the value of the '<em><b>Navigable</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Means that the association can be navigated in that direction towards this end. Note that non-navigability does not serve as a security-related feature. If all objects of the type at the other end can be enumerated and because the association has to be navigable in at least one direction, it will be possible to find out those objects on the other end that are linked to an instance which semantically implements navigation again, only potentially very slowly if the extent to enumerate is large.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Navigable</em>' attribute.
     * @see #setNavigable(boolean)
     * @see data.classes.ClassesPackage#getAssociationEnd_Navigable()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isNavigable();

	/**
     * Sets the value of the '{@link data.classes.AssociationEnd#isNavigable <em>Navigable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Navigable</em>' attribute.
     * @see #isNavigable()
     * @generated
     */
	void setNavigable(boolean value);

	/**
     * Returns the value of the '<em><b>Composite</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Expresses ownership that for entity-to-entity associations also implies delete propagation. Only one of the two association ends can be marked as composite. The end marked in this way attaches to the "owning" class whereas the otherEnd() attaches to the "owned" class.
     * 
     * Composition cannot be used for value classes. Values cannot be owned, and values cannot own anything.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Composite</em>' attribute.
     * @see #setComposite(boolean)
     * @see data.classes.ClassesPackage#getAssociationEnd_Composite()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isComposite();

	/**
     * Sets the value of the '{@link data.classes.AssociationEnd#isComposite <em>Composite</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Composite</em>' attribute.
     * @see #isComposite()
     * @generated
     */
	void setComposite(boolean value);

	/**
     * Returns the value of the '<em><b>Contributes To Equality</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * If true, this association end contributes to the equality of the exposing class. An equality-contributing association end must be exposed (maybe with private visibility) because it is relevant for the contract of that class.
     * 
     * It is a questionable construct to have both ends contribute to equality if both classes are value classes because it would mean that values of either of the classes can be identified only in pairs. The equality definition would be recursive, and an implementation would have to understand this and cut short the recursion, comparing only all other equality-related association end values.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Contributes To Equality</em>' attribute.
     * @see #setContributesToEquality(boolean)
     * @see data.classes.ClassesPackage#getAssociationEnd_ContributesToEquality()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isContributesToEquality();

	/**
     * Sets the value of the '{@link data.classes.AssociationEnd#isContributesToEquality <em>Contributes To Equality</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Contributes To Equality</em>' attribute.
     * @see #isContributesToEquality()
     * @generated
     */
	void setContributesToEquality(boolean value);

	/**
     * Returns the value of the '<em><b>Association</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.Association#getEnds <em>Ends</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Association</em>' container reference.
     * @see #setAssociation(Association)
     * @see data.classes.ClassesPackage#getAssociationEnd_Association()
     * @see data.classes.Association#getEnds
     * @model opposite="ends" required="true"
     * @generated
     */
	Association getAssociation();

	/**
     * Sets the value of the '{@link data.classes.AssociationEnd#getAssociation <em>Association</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Association</em>' container reference.
     * @see #getAssociation()
     * @generated
     */
	void setAssociation(Association value);

	/**
     * Returns the value of the '<em><b>Delegation</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link data.classes.Delegation#getFrom <em>From</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delegation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Delegation</em>' containment reference.
     * @see #setDelegation(Delegation)
     * @see data.classes.ClassesPackage#getAssociationEnd_Delegation()
     * @see data.classes.Delegation#getFrom
     * @model opposite="from" containment="true" resolveProxies="true"
     * @generated
     */
	Delegation getDelegation();

	/**
     * Sets the value of the '{@link data.classes.AssociationEnd#getDelegation <em>Delegation</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Delegation</em>' containment reference.
     * @see #getDelegation()
     * @generated
     */
	void setDelegation(Delegation value);

	/**
     * Returns the value of the '<em><b>Signature Implementations</b></em>' reference list.
     * The list contents are of type {@link data.classes.AssociationEndSignatureImplementation}.
     * It is bidirectional and its opposite is '{@link data.classes.AssociationEndSignatureImplementation#getEnd <em>End</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature Implementations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Signature Implementations</em>' reference list.
     * @see data.classes.ClassesPackage#getAssociationEnd_SignatureImplementations()
     * @see data.classes.AssociationEndSignatureImplementation#getEnd
     * @model opposite="end"
     * @generated
     */
	EList<AssociationEndSignatureImplementation> getSignatureImplementations();

	/**
     * Returns the value of the '<em><b>Type</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link data.classes.ClassTypeDefinition#getAssociationEnd <em>Association End</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' containment reference.
     * @see #setType(ClassTypeDefinition)
     * @see data.classes.ClassesPackage#getAssociationEnd_Type()
     * @see data.classes.ClassTypeDefinition#getAssociationEnd
     * @model opposite="associationEnd" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	ClassTypeDefinition getType();

	/**
     * Sets the value of the '{@link data.classes.AssociationEnd#getType <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
	void setType(ClassTypeDefinition value);

	/**
     * Returns the value of the '<em><b>Abap Annotation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abap Annotation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Abap Annotation</em>' reference.
     * @see #setAbapAnnotation(AbapAssociationEndImplementationAnnotation)
     * @see data.classes.ClassesPackage#getAssociationEnd_AbapAnnotation()
     * @model
     * @generated
     */
	AbapAssociationEndImplementationAnnotation getAbapAnnotation();

	/**
     * Sets the value of the '{@link data.classes.AssociationEnd#getAbapAnnotation <em>Abap Annotation</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Abap Annotation</em>' reference.
     * @see #getAbapAnnotation()
     * @generated
     */
	void setAbapAnnotation(AbapAssociationEndImplementationAnnotation value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model unique="false" required="true" ordered="false"
     *        annotation="http://de.hpi.sam.bp2009.OCL body='association.ends->select(ae|ae <> self)->first()'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	AssociationEnd otherEnd();

} // AssociationEnd
