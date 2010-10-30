/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import abapmapping.AbapSignatureImplementationAnnotation;

import data.constraints.Constraint;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines an abstract callable operation or block signature with input parameter types, return type and exception / fault types. A signature may also be implemented by association navigation expressions or link set manipulation statements.
 * 
 * The enforcement of side effect freeness is the SignatureImplementation subclasses' responsibility.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.Signature#isSideEffectFree <em>Side Effect Free</em>}</li>
 *   <li>{@link data.classes.Signature#getFaults <em>Faults</em>}</li>
 *   <li>{@link data.classes.Signature#getOutput <em>Output</em>}</li>
 *   <li>{@link data.classes.Signature#getOwnedTypeDefinitions <em>Owned Type Definitions</em>}</li>
 *   <li>{@link data.classes.Signature#getInput <em>Input</em>}</li>
 *   <li>{@link data.classes.Signature#getTypeDefinition <em>Type Definition</em>}</li>
 *   <li>{@link data.classes.Signature#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link data.classes.Signature#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link data.classes.Signature#getAbapAnnotation <em>Abap Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getSignature()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL OnlyTrailingOptionalParameters='self.input->forAll(p | p.defaultValue->notEmpty() implies Sequence{(self.input->indexOf(p)+1)..self.input->size()}->forAll(\r\n    i | self.input->at(i).defaultValue->notEmpty()))'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='OnlyTrailingOptionalParameters'"
 * @generated
 */
public interface Signature extends EObject {
	/**
     * Returns the value of the '<em><b>Side Effect Free</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * If this flag is set, the signature's implementation must not use a link-modifying implementation on any object of an entity class. It is permissible for an implementation to create value objects. All signatures being called by an implementation must then also have this flag set.
     * 
     * This flag is also relevant for conformance. A signature only conforms to one with this flag set if it also has this flag set.
     * 
     * Note that activities that do not modify the link structure may still have side effects outside of the scope of this programming model, such as producing a log entry in some persistence layer about a query being executed. Such side effects that are outside of this programming model do not count as a side effect in the sense of this flag. In particular, they do not make the program's semantics depend on execution order of such signature implementations.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Side Effect Free</em>' attribute.
     * @see #setSideEffectFree(boolean)
     * @see data.classes.ClassesPackage#getSignature_SideEffectFree()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isSideEffectFree();

	/**
     * Sets the value of the '{@link data.classes.Signature#isSideEffectFree <em>Side Effect Free</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Side Effect Free</em>' attribute.
     * @see #isSideEffectFree()
     * @generated
     */
	void setSideEffectFree(boolean value);

	/**
     * Returns the value of the '<em><b>Faults</b></em>' reference.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getSignaturesWithFault <em>Signatures With Fault</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Faults</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Faults</em>' reference.
     * @see #setFaults(SapClass)
     * @see data.classes.ClassesPackage#getSignature_Faults()
     * @see data.classes.SapClass#getSignaturesWithFault
     * @model opposite="signaturesWithFault"
     * @generated
     */
	SapClass getFaults();

	/**
     * Sets the value of the '{@link data.classes.Signature#getFaults <em>Faults</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Faults</em>' reference.
     * @see #getFaults()
     * @generated
     */
	void setFaults(SapClass value);

	/**
     * Returns the value of the '<em><b>Output</b></em>' reference.
     * It is bidirectional and its opposite is '{@link data.classes.TypeDefinition#getSignaturesWithOutput <em>Signatures With Output</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Output</em>' reference.
     * @see #setOutput(TypeDefinition)
     * @see data.classes.ClassesPackage#getSignature_Output()
     * @see data.classes.TypeDefinition#getSignaturesWithOutput
     * @model opposite="signaturesWithOutput"
     * @generated
     */
	TypeDefinition getOutput();

	/**
     * Sets the value of the '{@link data.classes.Signature#getOutput <em>Output</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output</em>' reference.
     * @see #getOutput()
     * @generated
     */
	void setOutput(TypeDefinition value);

	/**
     * Returns the value of the '<em><b>Owned Type Definitions</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link data.classes.TypeDefinition#getOwnerSignature <em>Owner Signature</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Type Definitions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owned Type Definitions</em>' containment reference.
     * @see #setOwnedTypeDefinitions(TypeDefinition)
     * @see data.classes.ClassesPackage#getSignature_OwnedTypeDefinitions()
     * @see data.classes.TypeDefinition#getOwnerSignature
     * @model opposite="ownerSignature" containment="true" resolveProxies="true"
     * @generated
     */
	TypeDefinition getOwnedTypeDefinitions();

	/**
     * Sets the value of the '{@link data.classes.Signature#getOwnedTypeDefinitions <em>Owned Type Definitions</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owned Type Definitions</em>' containment reference.
     * @see #getOwnedTypeDefinitions()
     * @generated
     */
	void setOwnedTypeDefinitions(TypeDefinition value);

	/**
     * Returns the value of the '<em><b>Input</b></em>' containment reference list.
     * The list contents are of type {@link data.classes.Parameter}.
     * It is bidirectional and its opposite is '{@link data.classes.Parameter#getOwnerSignature <em>Owner Signature</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Input</em>' containment reference list.
     * @see data.classes.ClassesPackage#getSignature_Input()
     * @see data.classes.Parameter#getOwnerSignature
     * @model opposite="ownerSignature" containment="true" resolveProxies="true"
     * @generated
     */
	EList<Parameter> getInput();

	/**
     * Returns the value of the '<em><b>Type Definition</b></em>' reference list.
     * The list contents are of type {@link data.classes.FunctionSignatureTypeDefinition}.
     * It is bidirectional and its opposite is '{@link data.classes.FunctionSignatureTypeDefinition#getSignature <em>Signature</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Definition</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type Definition</em>' reference list.
     * @see data.classes.ClassesPackage#getSignature_TypeDefinition()
     * @see data.classes.FunctionSignatureTypeDefinition#getSignature
     * @model opposite="signature"
     * @generated
     */
	EList<FunctionSignatureTypeDefinition> getTypeDefinition();

	/**
     * Returns the value of the '<em><b>Preconditions</b></em>' containment reference list.
     * The list contents are of type {@link data.constraints.Constraint}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Preconditions</em>' containment reference list.
     * @see data.classes.ClassesPackage#getSignature_Preconditions()
     * @model containment="true" resolveProxies="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='preconditionForSignature'"
     * @generated
     */
	EList<Constraint> getPreconditions();

	/**
     * Returns the value of the '<em><b>Postconditions</b></em>' containment reference list.
     * The list contents are of type {@link data.constraints.Constraint}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postconditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Postconditions</em>' containment reference list.
     * @see data.classes.ClassesPackage#getSignature_Postconditions()
     * @model containment="true" resolveProxies="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='postconditionForSignature'"
     * @generated
     */
	EList<Constraint> getPostconditions();

	/**
     * Returns the value of the '<em><b>Abap Annotation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abap Annotation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Abap Annotation</em>' reference.
     * @see #setAbapAnnotation(AbapSignatureImplementationAnnotation)
     * @see data.classes.ClassesPackage#getSignature_AbapAnnotation()
     * @model
     * @generated
     */
	AbapSignatureImplementationAnnotation getAbapAnnotation();

	/**
     * Sets the value of the '{@link data.classes.Signature#getAbapAnnotation <em>Abap Annotation</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Abap Annotation</em>' reference.
     * @see #getAbapAnnotation()
     * @generated
     */
	void setAbapAnnotation(AbapSignatureImplementationAnnotation value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model unique="false" required="true" ordered="false" sUnique="false" sRequired="true" sOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self = s then\n    true\n  else\n    self.conformsToExcluding(s, Sequence{}, Sequence{})\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean conformsTo(Signature s);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Same as conformsTo(Featured):Boolean but with the possibility to pass pairs of Featured elements that are to be considered conforming and thus don't need further exploration. This can be used to avoid endless recursions in conformance testing.
     * <!-- end-model-doc -->
     * @model unique="false" required="true" ordered="false" sUnique="false" sRequired="true" sOrdered="false" excludingConformingUnique="false" excludingConformingMany="true" excludingToUnique="false" excludingToMany="true"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if s = self then\n    true\n  else\n    let nameConforms:Boolean = self.oclIsKindOf(MethodSignature) and s.oclIsKindOf(MethodSignature) \n       implies s.oclAsType(MethodSignature).name = self.oclAsType(MethodSignature).name in\n    nameConforms and\n    (s.sideEffectFree implies self.sideEffectFree) and\n    s.input->size() = self.input->size() and\n    Sequence{1..self.input->size()}->\n      forAll(i | s.input->at(i).getType().conformsToExcluding(self.input->at(i).getType(), excludingConforming, excludingTo)) and\n    s.output->size() = self.output->size() and\n    Sequence{1..self.output->size()}->\n      forAll(i | self.output->asSequence()->at(i).conformsToExcluding(s.output->asSequence()->at(i), excludingConforming, excludingTo))\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean conformsToExcluding(Signature s, EList<SapClass> excludingConforming, EList<SapClass> excludingTo);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * For a signature, only the owning class's formal object parameters are in scope.
     * <!-- end-model-doc -->
     * @model kind="operation" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getOwningClass().formalObjectParameters->asSet()'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<NamedValue> getNamedValuesInScope();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.oclIsKindOf(MethodSignature) then\n    let owner:SignatureOwner = self.oclAsType(MethodSignature).owner in\n    if owner.oclIsKindOf(SapClass) then\n      owner.oclAsType(SapClass)\n    else\n      null    -- e.g., TypeAdapter\n    endif\n  else\n    self.oclAsType(FunctionSignature).getImplementedAnonymousFunctionExpression().getOwningClass()\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	SapClass getOwningClass();

} // Signature
