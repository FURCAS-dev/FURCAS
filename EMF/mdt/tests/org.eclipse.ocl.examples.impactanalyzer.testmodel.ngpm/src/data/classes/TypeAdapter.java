/**
 * <copyright>
 * </copyright>
 *
 * $Id: TypeAdapter.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package data.classes;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Adapter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.TypeAdapter#getTo <em>To</em>}</li>
 *   <li>{@link data.classes.TypeAdapter#getAdapted <em>Adapted</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getTypeAdapter()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL AllSignatureConforms='self.ownedSignatures->forAll(selfSig:MethodSignature |\r\n    self.to.signaturesWithDelegation()->exists(toSig:MethodSignature |\r\n       selfSig.conformsTo(toSig)))' SignaturesCannotBeAbstract='self.ownedSignatures->forAll(selfSig:MethodSignature | not selfSig.isAbstract())' IsFullAdaptationToTo='self.to.signaturesWithDelegation()->forAll(toSig|\r\n    self.adapted.signaturesWithDelegation()->exists(adaptedSig|\r\n      adaptedSig.conformsTo(toSig))\r\n    or self.ownedSignatures->exists(ownedSig|\r\n      ownedSig.conformsTo(toSig)))' ValuesToValues_EntitiesToEntities='self.adapted.valueType = self.to.valueType'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='AllSignatureConforms SignaturesCannotBeAbstract IsFullAdaptationToTo ValuesToValues_EntitiesToEntities'"
 * @generated
 */
public interface TypeAdapter extends SignatureOwner {
	/**
     * Returns the value of the '<em><b>To</b></em>' reference.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getAdaptedBy <em>Adapted By</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>To</em>' reference.
     * @see #setTo(SapClass)
     * @see data.classes.ClassesPackage#getTypeAdapter_To()
     * @see data.classes.SapClass#getAdaptedBy
     * @model opposite="adaptedBy" required="true"
     * @generated
     */
	SapClass getTo();

	/**
     * Sets the value of the '{@link data.classes.TypeAdapter#getTo <em>To</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>To</em>' reference.
     * @see #getTo()
     * @generated
     */
	void setTo(SapClass value);

	/**
     * Returns the value of the '<em><b>Adapted</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getAdapters <em>Adapters</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapted</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Adapted</em>' container reference.
     * @see #setAdapted(SapClass)
     * @see data.classes.ClassesPackage#getTypeAdapter_Adapted()
     * @see data.classes.SapClass#getAdapters
     * @model opposite="adapters" required="true"
     * @generated
     */
	SapClass getAdapted();

	/**
     * Sets the value of the '{@link data.classes.TypeAdapter#getAdapted <em>Adapted</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Adapted</em>' container reference.
     * @see #getAdapted()
     * @generated
     */
	void setAdapted(SapClass value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * A class A conforms to a class B if for every signature that B has (either directly or by delegation, but not from any adapters), A has a conforming signature, either immediately declared in A or by delegation or through a type adapter.
     * <!-- end-model-doc -->
     * @model unique="false" required="true" ordered="false" typeUnique="false" typeRequired="true" typeOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='type.signaturesWithDelegation()->forAll(typeSig:MethodSignature |\n    self.allSignatures()->exists(selfSig:MethodSignature |\n       selfSig.conformsToExcluding(typeSig, Sequence{self.to}, Sequence{type})))'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean conformsTo(SapClass type);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Same as conformsTo(Featured):Boolean but with the possibility to pass pairs of Featured elements that are to be considered conforming and thus don't need further exploration. This can be used to avoid endless recursions in conformance testing.
     * <!-- end-model-doc -->
     * @model unique="false" required="true" ordered="false" typeUnique="false" typeRequired="true" typeOrdered="false" excludingConformingUnique="false" excludingConformingMany="true" excludingToUnique="false" excludingToMany="true"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='Sequence{1..excludingConforming->size()}->exists(i|\n  excludingConforming->asSequence()->at(i) = self.to and excludingTo->asSequence()->at(i) = type) or\n  type.signaturesWithDelegation()->forAll(typeSig:MethodSignature |\n         self.allSignatures()->exists(selfSig:MethodSignature |\n            selfSig.conformsToExcluding(typeSig,\n                    excludingConforming->asSequence()->append(self.to),\n                    excludingTo->asSequence()->append(type))))'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean conformsToExcluding(SapClass type, EList<SapClass> excludingConforming, EList<SapClass> excludingTo);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Computes all locally-defined signatures plus not conforming signatures offered by 'To' Class. 
     * <!-- end-model-doc -->
     * @model ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.allSignaturesExcluding(Set{})'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<MethodSignature> allSignatures();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Same as allSignatures() but with the possibility to to avoid endless recursions.
     * <!-- end-model-doc -->
     * @model ordered="false" excludingMany="true" excludingOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.to.allSignaturesExcluding(excluding)->select(s |\n    not self.ownedSignatures->exists(os | os.conformsTo(s)))->union(\n  self.ownedSignatures)'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<MethodSignature> allSignaturesExcluding(EList<SapClass> excluding);

} // TypeAdapter
