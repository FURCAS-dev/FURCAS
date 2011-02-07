/**
 * <copyright>
 * </copyright>
 *
 * $Id: SapClass.java,v 1.1 2011/02/07 16:49:09 auhl Exp $
 */
package data.classes;

import abapmapping.AbapClassImplementationAnnotation;

import behavioral.events.EventProducer;
import behavioral.events.Subscription;

import behavioral.status_and_action.assembly.StatusSchema;

import behavioral.status_and_action_old.SAMAction;
import behavioral.status_and_action_old.SAMDerivator;
import behavioral.status_and_action_old.SAMStatusSchema;
import behavioral.status_and_action_old.SAMStatusVariable;

import data.constraints.Constraint;

import data.generics.ClassParameterization;

import data.timedependency.TimeDependency;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sap Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.SapClass#getSubscription <em>Subscription</em>}</li>
 *   <li>{@link data.classes.SapClass#getSamActions <em>Sam Actions</em>}</li>
 *   <li>{@link data.classes.SapClass#getSamStatusVariables <em>Sam Status Variables</em>}</li>
 *   <li>{@link data.classes.SapClass#getSamDerivators <em>Sam Derivators</em>}</li>
 *   <li>{@link data.classes.SapClass#getSamStatusSchema <em>Sam Status Schema</em>}</li>
 *   <li>{@link data.classes.SapClass#getBehaviouralModel <em>Behavioural Model</em>}</li>
 *   <li>{@link data.classes.SapClass#isValueType <em>Value Type</em>}</li>
 *   <li>{@link data.classes.SapClass#getSignaturesWithFault <em>Signatures With Fault</em>}</li>
 *   <li>{@link data.classes.SapClass#getElementsOfType <em>Elements Of Type</em>}</li>
 *   <li>{@link data.classes.SapClass#getPackage_ <em>Package </em>}</li>
 *   <li>{@link data.classes.SapClass#getAdaptedBy <em>Adapted By</em>}</li>
 *   <li>{@link data.classes.SapClass#getAdapters <em>Adapters</em>}</li>
 *   <li>{@link data.classes.SapClass#getFormalObjectParameters <em>Formal Object Parameters</em>}</li>
 *   <li>{@link data.classes.SapClass#getConverterBetweenParametrizations <em>Converter Between Parametrizations</em>}</li>
 *   <li>{@link data.classes.SapClass#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link data.classes.SapClass#getTimeDependency <em>Time Dependency</em>}</li>
 *   <li>{@link data.classes.SapClass#getParameterization <em>Parameterization</em>}</li>
 *   <li>{@link data.classes.SapClass#getAbapAnnotation <em>Abap Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getSapClass()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL OnlyValueClassesCanHaveObjectParameters='self.formalObjectParameters->notEmpty() implies self.valueType' OnlyObjectParameterizedClassesCanHaveConverter='self.converterBetweenParametrizations->notEmpty() implies self.formalObjectParameters->notEmpty()' OnlyTrailingOptionalParameters='self.formalObjectParameters->forAll(p | p.defaultValue->notEmpty() implies Sequence{(self.formalObjectParameters->indexOf(p)+1)..self.formalObjectParameters->size()}->forAll(\r\n    i | self.formalObjectParameters->at(i).defaultValue->notEmpty()))' NoRecursionForObjectParameters='true  --  TODO implement this'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='OnlyValueClassesCanHaveObjectParameters OnlyObjectParameterizedClassesCanHaveConverter OnlyTrailingOptionalParameters NoRecursionForObjectParameters'"
 * @generated
 */
public interface SapClass extends SignatureOwner, EventProducer {
	/**
     * Returns the value of the '<em><b>Subscription</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.events.Subscription}.
     * It is bidirectional and its opposite is '{@link behavioral.events.Subscription#getSubscribingClass <em>Subscribing Class</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscription</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Subscription</em>' containment reference list.
     * @see data.classes.ClassesPackage#getSapClass_Subscription()
     * @see behavioral.events.Subscription#getSubscribingClass
     * @model opposite="subscribingClass" containment="true" resolveProxies="true"
     * @generated
     */
	EList<Subscription> getSubscription();

	/**
     * Returns the value of the '<em><b>Sam Actions</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMAction}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMAction#getBusinessObjectNode <em>Business Object Node</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Actions</em>' containment reference list.
     * @see data.classes.ClassesPackage#getSapClass_SamActions()
     * @see behavioral.status_and_action_old.SAMAction#getBusinessObjectNode
     * @model opposite="businessObjectNode" containment="true" resolveProxies="true"
     * @generated
     */
	EList<SAMAction> getSamActions();

	/**
     * Returns the value of the '<em><b>Sam Status Variables</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMStatusVariable}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMStatusVariable#getBusinessObjectNode <em>Business Object Node</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Status Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Status Variables</em>' containment reference list.
     * @see data.classes.ClassesPackage#getSapClass_SamStatusVariables()
     * @see behavioral.status_and_action_old.SAMStatusVariable#getBusinessObjectNode
     * @model opposite="businessObjectNode" containment="true" resolveProxies="true"
     * @generated
     */
	EList<SAMStatusVariable> getSamStatusVariables();

	/**
     * Returns the value of the '<em><b>Sam Derivators</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMDerivator}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMDerivator#getBusinessObject <em>Business Object</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Derivators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Derivators</em>' containment reference list.
     * @see data.classes.ClassesPackage#getSapClass_SamDerivators()
     * @see behavioral.status_and_action_old.SAMDerivator#getBusinessObject
     * @model opposite="businessObject" containment="true" resolveProxies="true"
     * @generated
     */
	EList<SAMDerivator> getSamDerivators();

	/**
     * Returns the value of the '<em><b>Sam Status Schema</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.status_and_action_old.SAMStatusSchema}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action_old.SAMStatusSchema#getBusinessObjectNode <em>Business Object Node</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sam Status Schema</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sam Status Schema</em>' containment reference list.
     * @see data.classes.ClassesPackage#getSapClass_SamStatusSchema()
     * @see behavioral.status_and_action_old.SAMStatusSchema#getBusinessObjectNode
     * @model opposite="businessObjectNode" containment="true" resolveProxies="true"
     * @generated
     */
	EList<SAMStatusSchema> getSamStatusSchema();

	/**
     * Returns the value of the '<em><b>Behavioural Model</b></em>' reference list.
     * The list contents are of type {@link behavioral.status_and_action.assembly.StatusSchema}.
     * It is bidirectional and its opposite is '{@link behavioral.status_and_action.assembly.StatusSchema#getNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavioural Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Behavioural Model</em>' reference list.
     * @see data.classes.ClassesPackage#getSapClass_BehaviouralModel()
     * @see behavioral.status_and_action.assembly.StatusSchema#getNode
     * @model opposite="node"
     * @generated
     */
	EList<StatusSchema> getBehaviouralModel();

	/**
     * Returns the value of the '<em><b>Value Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * If true, instances of the class will be immutable. Comparison will be by equality. Their identity is defined by value equality. Value types can of course contain associations to non-value (or "entity") types.
     * 
     * As opposed to value types, instances of entity types have identity and mutable state. They are always passed by reference. Variables only hold a reference to a shared instance. Comparing two entity objects using "Equals" will compare their identities.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Value Type</em>' attribute.
     * @see #setValueType(boolean)
     * @see data.classes.ClassesPackage#getSapClass_ValueType()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isValueType();

	/**
     * Sets the value of the '{@link data.classes.SapClass#isValueType <em>Value Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value Type</em>' attribute.
     * @see #isValueType()
     * @generated
     */
	void setValueType(boolean value);

	/**
     * Returns the value of the '<em><b>Signatures With Fault</b></em>' reference list.
     * The list contents are of type {@link data.classes.Signature}.
     * It is bidirectional and its opposite is '{@link data.classes.Signature#getFaults <em>Faults</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signatures With Fault</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Signatures With Fault</em>' reference list.
     * @see data.classes.ClassesPackage#getSapClass_SignaturesWithFault()
     * @see data.classes.Signature#getFaults
     * @model opposite="faults"
     * @generated
     */
	EList<Signature> getSignaturesWithFault();

	/**
     * Returns the value of the '<em><b>Elements Of Type</b></em>' reference list.
     * The list contents are of type {@link data.classes.ClassTypeDefinition}.
     * It is bidirectional and its opposite is '{@link data.classes.ClassTypeDefinition#getClazz <em>Clazz</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements Of Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Elements Of Type</em>' reference list.
     * @see data.classes.ClassesPackage#getSapClass_ElementsOfType()
     * @see data.classes.ClassTypeDefinition#getClazz
     * @model opposite="clazz"
     * @generated
     */
	EList<ClassTypeDefinition> getElementsOfType();

	/**
     * Returns the value of the '<em><b>Package </b></em>' container reference.
     * It is bidirectional and its opposite is '{@link modelmanagement.Package#getClasses <em>Classes</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package </em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Package </em>' container reference.
     * @see #setPackage_(modelmanagement.Package)
     * @see data.classes.ClassesPackage#getSapClass_Package_()
     * @see modelmanagement.Package#getClasses
     * @model opposite="classes"
     * @generated
     */
	modelmanagement.Package getPackage_();

	/**
     * Sets the value of the '{@link data.classes.SapClass#getPackage_ <em>Package </em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Package </em>' container reference.
     * @see #getPackage_()
     * @generated
     */
	void setPackage_(modelmanagement.Package value);

	/**
     * Returns the value of the '<em><b>Adapted By</b></em>' reference list.
     * The list contents are of type {@link data.classes.TypeAdapter}.
     * It is bidirectional and its opposite is '{@link data.classes.TypeAdapter#getTo <em>To</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapted By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Adapted By</em>' reference list.
     * @see data.classes.ClassesPackage#getSapClass_AdaptedBy()
     * @see data.classes.TypeAdapter#getTo
     * @model opposite="to"
     * @generated
     */
	EList<TypeAdapter> getAdaptedBy();

	/**
     * Returns the value of the '<em><b>Adapters</b></em>' containment reference list.
     * The list contents are of type {@link data.classes.TypeAdapter}.
     * It is bidirectional and its opposite is '{@link data.classes.TypeAdapter#getAdapted <em>Adapted</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Adapters</em>' containment reference list.
     * @see data.classes.ClassesPackage#getSapClass_Adapters()
     * @see data.classes.TypeAdapter#getAdapted
     * @model opposite="adapted" containment="true" resolveProxies="true"
     * @generated
     */
	EList<TypeAdapter> getAdapters();

	/**
     * Returns the value of the '<em><b>Formal Object Parameters</b></em>' containment reference list.
     * The list contents are of type {@link data.classes.Parameter}.
     * It is bidirectional and its opposite is '{@link data.classes.Parameter#getParameterOfClass <em>Parameter Of Class</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formal Object Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Formal Object Parameters</em>' containment reference list.
     * @see data.classes.ClassesPackage#getSapClass_FormalObjectParameters()
     * @see data.classes.Parameter#getParameterOfClass
     * @model opposite="parameterOfClass" containment="true" resolveProxies="true"
     * @generated
     */
	EList<Parameter> getFormalObjectParameters();

	/**
     * Returns the value of the '<em><b>Converter Between Parametrizations</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link data.classes.ConverterBetweenParametrizations#getClazz <em>Clazz</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Converter Between Parametrizations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Converter Between Parametrizations</em>' containment reference.
     * @see #setConverterBetweenParametrizations(ConverterBetweenParametrizations)
     * @see data.classes.ClassesPackage#getSapClass_ConverterBetweenParametrizations()
     * @see data.classes.ConverterBetweenParametrizations#getClazz
     * @model opposite="clazz" containment="true" resolveProxies="true"
     * @generated
     */
	ConverterBetweenParametrizations getConverterBetweenParametrizations();

	/**
     * Sets the value of the '{@link data.classes.SapClass#getConverterBetweenParametrizations <em>Converter Between Parametrizations</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Converter Between Parametrizations</em>' containment reference.
     * @see #getConverterBetweenParametrizations()
     * @generated
     */
	void setConverterBetweenParametrizations(ConverterBetweenParametrizations value);

	/**
     * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
     * The list contents are of type {@link data.constraints.Constraint}.
     * It is bidirectional and its opposite is '{@link data.constraints.Constraint#getConstrainedType <em>Constrained Type</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Constraints</em>' containment reference list.
     * @see data.classes.ClassesPackage#getSapClass_Constraints()
     * @see data.constraints.Constraint#getConstrainedType
     * @model opposite="constrainedType" containment="true" resolveProxies="true"
     * @generated
     */
	EList<Constraint> getConstraints();

	/**
     * Returns the value of the '<em><b>Time Dependency</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link data.timedependency.TimeDependency#getTheClass <em>The Class</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Dependency</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Time Dependency</em>' containment reference.
     * @see #setTimeDependency(TimeDependency)
     * @see data.classes.ClassesPackage#getSapClass_TimeDependency()
     * @see data.timedependency.TimeDependency#getTheClass
     * @model opposite="theClass" containment="true" resolveProxies="true"
     * @generated
     */
	TimeDependency getTimeDependency();

	/**
     * Sets the value of the '{@link data.classes.SapClass#getTimeDependency <em>Time Dependency</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Time Dependency</em>' containment reference.
     * @see #getTimeDependency()
     * @generated
     */
	void setTimeDependency(TimeDependency value);

	/**
     * Returns the value of the '<em><b>Parameterization</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link data.generics.ClassParameterization#getOwningClassDefinition <em>Owning Class Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameterization</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Parameterization</em>' containment reference.
     * @see #setParameterization(ClassParameterization)
     * @see data.classes.ClassesPackage#getSapClass_Parameterization()
     * @see data.generics.ClassParameterization#getOwningClassDefinition
     * @model opposite="owningClassDefinition" containment="true" resolveProxies="true"
     * @generated
     */
	ClassParameterization getParameterization();

	/**
     * Sets the value of the '{@link data.classes.SapClass#getParameterization <em>Parameterization</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameterization</em>' containment reference.
     * @see #getParameterization()
     * @generated
     */
	void setParameterization(ClassParameterization value);

	/**
     * Returns the value of the '<em><b>Abap Annotation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abap Annotation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Abap Annotation</em>' reference.
     * @see #setAbapAnnotation(AbapClassImplementationAnnotation)
     * @see data.classes.ClassesPackage#getSapClass_AbapAnnotation()
     * @model
     * @generated
     */
	AbapClassImplementationAnnotation getAbapAnnotation();

	/**
     * Sets the value of the '{@link data.classes.SapClass#getAbapAnnotation <em>Abap Annotation</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Abap Annotation</em>' reference.
     * @see #getAbapAnnotation()
     * @generated
     */
	void setAbapAnnotation(AbapClassImplementationAnnotation value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='not (self.allSignatures()->forAll(s:MethodSignature | not s.isAbstract()))'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean isAbstract();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.parameterization->notEmpty()'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean isParameterizedClassDefinition();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * A class A conforms to a class B if they are the same or if there is a chain of (TypeAdapter_i, Class_i) pairs (0<=i<=n) where TypeAdapter_0 adapts A to Class_0, and where Class_n is B.
     * <!-- end-model-doc -->
     * @model unique="false" required="true" ordered="false" typeUnique="false" typeRequired="true" typeOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.oclIsUndefined() then\n    false\n  else\n    self.conformsToExcluding(type, Sequence{}, Sequence{})\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean conformsTo(SapClass type);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Computes all locally-defined signatures plus those signatures offered by any Class (directly, or by delegation or recursively by type adaptation) attached to this class as a type adapter, plus allSignatures() recursively of all classes to which this class delegates.
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
     * A class can delegate to another class via an attached association end that in turn has attached a Delegation element. The delegating class by this exposes all operations and association ends exposed by the delegate class (recursively). The semantics of such a delegation is that when invoked, the invocation will be forwarded to the delegate object transparently and recursively.
     * 
     * Note, that TypeAdapter objects cannot delegate because they cannot have association ends attached to them. They can only expose association ends whose other end is attached to a class to which the TypeAdapter conforms.
     * <!-- end-model-doc -->
     * @model ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.oclIsKindOf(data::generics::ParameterizedClassInstantiation) then\n    self.oclAsType(data::generics::ParameterizedClassInstantiation).parameterizedClass.delegatesTo()\n  else\n    if self.oclIsKindOf(data::generics::FormalTypeParameter) then\n      self.oclAsType(data::generics::FormalTypeParameter).typeConstraint->collect(c:SapClass | c.delegatesTo())->flatten()->asSet()\n    else\n      -- TODO improve OCL impact analysis algorithm so that this doesn\'t kill performance:\n      -- Set{}  -- use this for good performance\n      self.getAssociationEnds().otherEnd()->select(delegation->notEmpty()).type.clazz->reject(c|c=self)->asSet()    -- currently bad performance\n    endif\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<SapClass> delegatesTo();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Same as conformsTo(Featured):Boolean but with the possibility to pass pairs of Featured elements that are to be considered conforming and thus don't need further exploration. This can be used to avoid endless recursions in conformance testing.
     * <!-- end-model-doc -->
     * @model unique="false" required="true" ordered="false" typeUnique="false" typeRequired="true" typeOrdered="false" excludingConformingUnique="false" excludingConformingMany="true" excludingToUnique="false" excludingToMany="true"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if oclIsUndefined() then\n    false\n  else\n  if self = type then\n   true\n  else\n    if Sequence{1..excludingConforming->size()}->exists(i|\n        excludingConforming->asSequence()->at(i) = self and excludingTo->asSequence()->at(i) = type) then\n     true\n  else\n    self.adapters->exists(a|a.to.conformsToExcluding(type, excludingConforming->including(self), excludingTo->including(type))) or\n    (if self.oclIsKindOf(data::generics::FormalTypeParameter) then\n        if self.oclAsType(data::generics::FormalTypeParameter).typeConstraint->notEmpty() then\n            self.oclAsType(data::generics::FormalTypeParameter).typeConstraint.conformsToExcluding(type, excludingConforming->including(self), excludingTo->including(type))\n        else\n            false\n        endif\n    else\n        false\n    endif)\n  endif\n  endif\nendif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean conformsToExcluding(SapClass type, EList<SapClass> excludingConforming, EList<SapClass> excludingTo);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Signature declared directly by this class and those signatures obtained by delegation, recursively.
     * <!-- end-model-doc -->
     * @model ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.signaturesWithDelegationExcluding(Set{})'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<MethodSignature> signaturesWithDelegation();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Signatures obtained by delegation recursively.
     * <!-- end-model-doc -->
     * @model ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.delegatesTo().signaturesWithDelegation()->flatten()->asSet()'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<MethodSignature> delegatedSignatures();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Computes signatures offered by any Class (directly, or by delegation or recursively by type adaptation) attached to this class as a type adapter
     * <!-- end-model-doc -->
     * @model ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.adaptedSignaturesExcluding(Set{})'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<MethodSignature> adaptedSignatures();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Computes signatures offered by any type adapter adapting this class to another class, minus those signatures redefined in the local class
     * <!-- end-model-doc -->
     * @model ordered="false" excludingMany="true" excludingOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if excluding->count(self)=0 then\n    if self.oclIsKindOf(data::generics::ParameterizedClassInstantiation) then\n      self.oclAsType(data::generics::ParameterizedClassInstantiation).parameterizedClass.adaptedSignaturesExcluding(excluding->including(self))\n    else\n      if self.oclIsKindOf(data::generics::FormalTypeParameter) then\n        self.oclAsType(data::generics::FormalTypeParameter).typeConstraint->collect(c:SapClass | c.adaptedSignaturesExcluding(excluding->including(self)))->flatten()->asSet()\n      else\n        self.adapters.allSignaturesExcluding(excluding->including(self))\n          ->select(s | not self.ownedSignatures->exists(os | os.conformsTo(s)))\n          ->flatten()->asSet()\n      endif\n    endif\n  else\n    Set{}\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<MethodSignature> adaptedSignaturesExcluding(EList<SapClass> excluding);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Computes all locally-defined signatures plus those signatures offered by any Class (directly, or by delegation or recursively by type adaptation) attached to this class as a type adapter, plus allSignatures() recursively of all classes to which this class delegates.
     * <!-- end-model-doc -->
     * @model ordered="false" excludingMany="true" excludingOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if excluding->count(self)=0 then\n    if self.oclIsKindOf(data::generics::ParameterizedClassInstantiation) then\n      self.oclAsType(data::generics::ParameterizedClassInstantiation).parameterizedClass.allSignaturesExcluding(excluding->including(self))\n    else\n      if self.oclIsKindOf(data::generics::FormalTypeParameter) then\n        self.oclAsType(data::generics::FormalTypeParameter).typeConstraint->collect(c:SapClass | c.allSignaturesExcluding(excluding->including(self)))->flatten()->asSet()\n      else\n        self.signaturesWithDelegationExcluding(excluding)->union(self.adaptedSignaturesExcluding(excluding))\n      endif\n    endif\n  else\n    Set{}    \n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<MethodSignature> allSignaturesExcluding(EList<SapClass> excluding);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Signature declared directly by this class and those signatures obtained by delegation, recursively.
     * <!-- end-model-doc -->
     * @model ordered="false" excludingMany="true" excludingOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if excluding->count(self)=0 then \n    if self.oclIsKindOf(data::generics::ParameterizedClassInstantiation) then\n      self.oclAsType(data::generics::ParameterizedClassInstantiation).parameterizedClass.signaturesWithDelegationExcluding(excluding->including(self))\n    else\n      if self.oclIsKindOf(data::generics::FormalTypeParameter) then\n        self.oclAsType(data::generics::FormalTypeParameter).typeConstraint->collect(c:SapClass | c.signaturesWithDelegationExcluding(excluding->including(self)))->flatten()->asSet()\n      else\n        self.ownedSignatures->union(self.delegatesTo().signaturesWithDelegationExcluding(excluding->including(self)))->flatten()->asSet()\n      endif\n    endif\nelse\n  Set{}\nendif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<MethodSignature> signaturesWithDelegationExcluding(EList<SapClass> excluding);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Signatures obtained by delegation recursively.
     * <!-- end-model-doc -->
     * @model ordered="false" excludingMany="true" excludingOrdered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if excluding->count(self)=0 then\n  self.delegatesTo().signaturesWithDelegationExcluding(excluding->including(self))->flatten()->asSet()\nelse\n  Set{}\nendif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<MethodSignature> delegatedSignaturesExcluding(EList<SapClass> excluding);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.adaptedBy.adapted.getConformingClasses()->including(self)->asSet()'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<SapClass> getConformingClasses();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Retrieves those association ends that use this class in their type definition.
     * <!-- end-model-doc -->
     * @model kind="operation" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.elementsOfType->collect(associationEnd->asSet())->asSet()'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<AssociationEnd> getAssociationEnds();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Obtains all association ends that use this class in their type definition and that contribute to this class's equality, indicated by their contributesToEquality attribute being set to true.
     * <!-- end-model-doc -->
     * @model kind="operation" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getAssociationEnds()->select(ae|ae.contributesToEquality)'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<AssociationEnd> getEqualityRelevantAssociationEnds();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Determines all classes to which this class conforms, directly and transitively, through chains of TypeAdapters. The result includes this class itself.
     * <!-- end-model-doc -->
     * @model kind="operation" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.adapters.to.getConformsToClasses()->including(self)->asSet()'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<SapClass> getConformsToClasses();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Determines all association ends to whose type this class conforms. This means that an instance of this class can be inserted on that respective end of the corresponding association. For example, if there is an association between Order and Item with ends "order" and "items" and there are classes SalesOrder and SalesOrderItem conforming to Order and Item, respectively, then the "order" end will be returned by this method when invoked on the SalesOrder class because SalesOrder conforms to Order and therefore a SalesOrder can be inserted into the association in role "order."
     * <!-- end-model-doc -->
     * @model kind="operation" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getConformsToClasses().getAssociationEnds()->asSet()'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<AssociationEnd> getConformsToAssociationEnds();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Like getConformsToAssociationEnds(), but selects only those association ends that are marked as composite.
     * <!-- end-model-doc -->
     * @model kind="operation" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getConformsToClasses().getAssociationEnds()->select(ae|ae.composite)->asSet()'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<AssociationEnd> getConformsToCompositeParentAssociationEnds();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Like getConformsToAssociationEnds(), but selects only those association ends whose other ends are marked as composite.
     * <!-- end-model-doc -->
     * @model kind="operation" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getConformsToClasses().getAssociationEnds()->select(ae|ae.otherEnd().composite)->asSet()'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<AssociationEnd> getConformsToCompositeChildAssociationEnds();

} // SapClass
