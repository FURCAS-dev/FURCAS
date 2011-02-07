/**
 * <copyright>
 * </copyright>
 *
 * $Id: TypeDefinition.java,v 1.1 2011/02/07 16:49:09 auhl Exp $
 */
package data.classes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.TypeDefinition#getSignaturesWithOutput <em>Signatures With Output</em>}</li>
 *   <li>{@link data.classes.TypeDefinition#getOwnerTypedElement <em>Owner Typed Element</em>}</li>
 *   <li>{@link data.classes.TypeDefinition#getOwnerSignature <em>Owner Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getTypeDefinition()
 * @model abstract="true"
 * @generated
 */
public interface TypeDefinition extends Multiplicity {
	/**
     * Returns the value of the '<em><b>Signatures With Output</b></em>' reference list.
     * The list contents are of type {@link data.classes.Signature}.
     * It is bidirectional and its opposite is '{@link data.classes.Signature#getOutput <em>Output</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signatures With Output</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Signatures With Output</em>' reference list.
     * @see data.classes.ClassesPackage#getTypeDefinition_SignaturesWithOutput()
     * @see data.classes.Signature#getOutput
     * @model opposite="output"
     * @generated
     */
	EList<Signature> getSignaturesWithOutput();

	/**
     * Returns the value of the '<em><b>Owner Typed Element</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.TypedElement#getOwnedTypeDefinition <em>Owned Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner Typed Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owner Typed Element</em>' container reference.
     * @see #setOwnerTypedElement(TypedElement)
     * @see data.classes.ClassesPackage#getTypeDefinition_OwnerTypedElement()
     * @see data.classes.TypedElement#getOwnedTypeDefinition
     * @model opposite="ownedTypeDefinition"
     * @generated
     */
	TypedElement getOwnerTypedElement();

	/**
     * Sets the value of the '{@link data.classes.TypeDefinition#getOwnerTypedElement <em>Owner Typed Element</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owner Typed Element</em>' container reference.
     * @see #getOwnerTypedElement()
     * @generated
     */
	void setOwnerTypedElement(TypedElement value);

	/**
     * Returns the value of the '<em><b>Owner Signature</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.Signature#getOwnedTypeDefinitions <em>Owned Type Definitions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner Signature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owner Signature</em>' container reference.
     * @see #setOwnerSignature(Signature)
     * @see data.classes.ClassesPackage#getTypeDefinition_OwnerSignature()
     * @see data.classes.Signature#getOwnedTypeDefinitions
     * @model opposite="ownedTypeDefinitions"
     * @generated
     */
	Signature getOwnerSignature();

	/**
     * Sets the value of the '{@link data.classes.TypeDefinition#getOwnerSignature <em>Owner Signature</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owner Signature</em>' container reference.
     * @see #getOwnerSignature()
     * @generated
     */
	void setOwnerSignature(Signature value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model unique="false" required="true" ordered="false" typeDefUnique="false" typeDefRequired="true" typeDefOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.oclIsUndefined() then\n    false\n  else if self = typeDef then\n    true\n  else\n    self.conformsToExcluding(typeDef, Sequence{}, Sequence{})\n  endif\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean conformsTo(TypeDefinition typeDef);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Same as conformsTo(Featured):Boolean but with the possibility to pass pairs of Featured elements that are to be considered conforming and thus don't need further exploration. This can be used to avoid endless recursions in conformance testing.
     * <!-- end-model-doc -->
     * @model unique="false" required="true" ordered="false" tdUnique="false" tdRequired="true" tdOrdered="false" excludingConformingUnique="false" excludingConformingMany="true" excludingToUnique="false" excludingToMany="true"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if oclIsUndefined() then\n    false\n  else\n  if self = td then\n    true\n  else\n   self.multiplicityConformsTo(td) and\n   self.conformsToIgnoringMultiplicityExcluding(td, excludingConforming, excludingTo)\n  endif\n endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean conformsToExcluding(TypeDefinition td, EList<SapClass> excludingConforming, EList<SapClass> excludingTo);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Checks if this type definition's multiplicity conforms to td's multiplicity definitions. This is the case if all instances that conform to this type definition will also conform to td.
     * 
     * Multiplicity conforms if td includes self's multiplicity, thus td's lower multiplicity is equal or smaller, and td's upper multiplicity is equal or larger than self's.
     * 
     * Ordereness and uniquness conform if td has more relaxed requirements. Thus, they conform if they are equal, if td is neither ordered nor unique, or if self is ordered and unique
     * <!-- end-model-doc -->
     * @model unique="false" required="true" ordered="false" tdUnique="false" tdRequired="true" tdOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='-- check for multiplicity conformance\n    -- multiplicity of td must include multiplicity of td\n    td.lowerMultiplicity <= self.lowerMultiplicity\n    and\n    (\n        td.upperMultiplicity = -1\n        or \n        ( td.upperMultiplicity >= self.upperMultiplicity and self.upperMultiplicity <> -1 ) \n    ) \n    \n    -- check for conformance of orderedness and uniqueness\n    -- orderedness/uniqueness of td must be same or more relaxed than self\'s\n    and\n    (\n       not self.isMany()\n        or\n        ( ( self.ordered = td.ordered ) and ( self.unique = td.unique ) )\n        or\n        ( self.ordered and self.unique )\n        or\n        ( not ( td.ordered or td.unique ) )\n    )'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean multiplicityConformsTo(TypeDefinition td);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Same as conformsTo(Featured):Boolean but with the possibility to pass pairs of Featured elements that are to be considered conforming and thus don't need further exploration. This can be used to avoid endless recursions in conformance testing.
     * <!-- end-model-doc -->
     * @model unique="false" required="true" ordered="false" tdUnique="false" tdRequired="true" tdOrdered="false" excludingConformingUnique="false" excludingConformingMany="true" excludingToUnique="false" excludingToMany="true"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self = td then\n    true\n  else\n   if self.oclIsKindOf(ClassTypeDefinition) then\n    td.oclIsKindOf(ClassTypeDefinition) and\n    self.oclAsType(ClassTypeDefinition).clazz.conformsToExcluding(\n                td.oclAsType(ClassTypeDefinition).clazz, excludingConforming, excludingTo) and\n    self.oclAsType(ClassTypeDefinition).objectParametersConformTo(td.oclAsType(ClassTypeDefinition))\n  else\n    if self.oclIsKindOf(FunctionSignatureTypeDefinition) then\n      td.oclIsKindOf(FunctionSignatureTypeDefinition) and\n      self.oclAsType(FunctionSignatureTypeDefinition).signature.conformsToExcluding(\n           td.oclAsType(FunctionSignatureTypeDefinition).signature, excludingConforming, excludingTo)\n    else\n      td.oclIsKindOf(NestedTypeDefinition) and\n      self.oclAsType(NestedTypeDefinition).type.conformsToExcluding(\n          td.oclAsType(NestedTypeDefinition).type, excludingConforming, excludingTo)\n    endif\n  endif\n endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean conformsToIgnoringMultiplicityExcluding(TypeDefinition td, EList<SapClass> excludingConforming, EList<SapClass> excludingTo);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model unique="false" required="true" ordered="false" typeDefUnique="false" typeDefRequired="true" typeDefOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self = typeDef then\n   true\n  else\n    self.conformsToIgnoringMultiplicityExcluding(typeDef, Sequence{}, Sequence{})\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean conformsToIgnoringMultiplicity(TypeDefinition typeDef);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='TypedElement.allInstances()->select(te | te.getType() = self)'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<TypedElement> getTypeUsage();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * For nexted type definitions, navigates through to the inner type definition. For non-nested type definitions, that type definition is the result of this method.
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.oclIsKindOf(NestedTypeDefinition) then\n    self.oclAsType(NestedTypeDefinition).type.getInnermost()\n  else\n    self\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	TypeDefinition getInnermost();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.oclIsKindOf(NestedTypeDefinition) then\n    self.oclAsType(NestedTypeDefinition).type.getNestingLevel() + 1\n  else\n    0\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	int getNestingLevel();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Needs to find the owner of the type definition, then check if it's a statement such as a variable declaration, or a method signature (meaning the owner may contribute formal object parameters) or a function signature (meaning the function expression knows the NamedValues in scope), etc.
     * <!-- end-model-doc -->
     * @model kind="operation" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='-- find owner of type definition and collect the named values in scope for the owner\n  (let ownerSig:Signature = self.ownerSignature in\n  if ownerSig->notEmpty() and ownerSig.oclIsKindOf(Signature) then\n    ownerSig.oclAsType(Signature).getNamedValuesInScope()\n  else\n    Set{}   -- some boundary case such as TupleElement or ValueSet not currently supported\n  endif)->union(\n\n  if self.ownerTypedElement->notEmpty() then\n    if self.ownerTypedElement.oclIsKindOf(dataaccess::expressions::Expression) then\n      self.ownerTypedElement.oclAsType(dataaccess::expressions::Expression).getNamedValuesInScope()\n    else\n      if self.ownerTypedElement.oclIsKindOf(NamedValue) then\n        self.ownerTypedElement.oclAsType(NamedValue).getNamedValuesInScope()\n      else\n        Set{}   -- some boundary case such as TupleElement or ValueSet not currently supported\n      endif\n    endif\n  else\n    Set{}\n  endif)'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<NamedValue> getNamedValuesInScope();

} // TypeDefinition
