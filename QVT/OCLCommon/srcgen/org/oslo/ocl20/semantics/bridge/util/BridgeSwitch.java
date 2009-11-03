/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.semantics.SemanticsVisitable;

import org.oslo.ocl20.semantics.bridge.*;

import org.oslo.ocl20.semantics.model.types.OclAnyType;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.oslo.ocl20.semantics.bridge.BridgePackage
 * @generated
 */
public class BridgeSwitch {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static BridgePackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BridgeSwitch() {
		if (modelPackage == null) {
			modelPackage = BridgePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch((EClass) eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BridgePackage.CALL_ACTION: {
				CallAction callAction = (CallAction) theEObject;
				Object result = caseCallAction(callAction);
				if (result == null)
					result = caseModelElement(callAction);
				if (result == null)
					result = caseSemanticsVisitable(callAction);
				if (result == null)
					result = caseElement(callAction);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.CLASSIFIER: {
				Classifier classifier = (Classifier) theEObject;
				Object result = caseClassifier(classifier);
				if (result == null)
					result = caseNamespace(classifier);
				if (result == null)
					result = caseModelElement(classifier);
				if (result == null)
					result = caseSemanticsVisitable(classifier);
				if (result == null)
					result = caseElement(classifier);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.DATA_TYPE: {
				DataType dataType = (DataType) theEObject;
				Object result = caseDataType(dataType);
				if (result == null)
					result = caseClassifier(dataType);
				if (result == null)
					result = caseNamespace(dataType);
				if (result == null)
					result = caseModelElement(dataType);
				if (result == null)
					result = caseSemanticsVisitable(dataType);
				if (result == null)
					result = caseElement(dataType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.DEFINED_CLASS: {
				DefinedClass definedClass = (DefinedClass) theEObject;
				Object result = caseDefinedClass(definedClass);
				if (result == null)
					result = caseClassifier(definedClass);
				if (result == null)
					result = caseNamespace(definedClass);
				if (result == null)
					result = caseModelElement(definedClass);
				if (result == null)
					result = caseSemanticsVisitable(definedClass);
				if (result == null)
					result = caseElement(definedClass);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.DEFINED_OPERATION: {
				DefinedOperation definedOperation = (DefinedOperation) theEObject;
				Object result = caseDefinedOperation(definedOperation);
				if (result == null)
					result = caseOperation(definedOperation);
				if (result == null)
					result = caseModelElement(definedOperation);
				if (result == null)
					result = caseSemanticsVisitable(definedOperation);
				if (result == null)
					result = caseElement(definedOperation);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.DEFINED_PACKAGE: {
				DefinedPackage definedPackage = (DefinedPackage) theEObject;
				Object result = caseDefinedPackage(definedPackage);
				if (result == null)
					result = caseNamespace(definedPackage);
				if (result == null)
					result = caseModelElement(definedPackage);
				if (result == null)
					result = caseSemanticsVisitable(definedPackage);
				if (result == null)
					result = caseElement(definedPackage);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.ELEMENT: {
				Element element = (Element) theEObject;
				Object result = caseElement(element);
				if (result == null)
					result = caseSemanticsVisitable(element);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.ENUM_LITERAL: {
				EnumLiteral enumLiteral = (EnumLiteral) theEObject;
				Object result = caseEnumLiteral(enumLiteral);
				if (result == null)
					result = caseProperty(enumLiteral);
				if (result == null)
					result = caseModelElement(enumLiteral);
				if (result == null)
					result = caseSemanticsVisitable(enumLiteral);
				if (result == null)
					result = caseElement(enumLiteral);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.ENUMERATION: {
				Enumeration enumeration = (Enumeration) theEObject;
				Object result = caseEnumeration(enumeration);
				if (result == null)
					result = caseDataType(enumeration);
				if (result == null)
					result = caseClassifier(enumeration);
				if (result == null)
					result = caseNamespace(enumeration);
				if (result == null)
					result = caseModelElement(enumeration);
				if (result == null)
					result = caseSemanticsVisitable(enumeration);
				if (result == null)
					result = caseElement(enumeration);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.ENVIRONMENT: {
				Environment environment = (Environment) theEObject;
				Object result = caseEnvironment(environment);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.MODEL_ELEMENT: {
				ModelElement modelElement = (ModelElement) theEObject;
				Object result = caseModelElement(modelElement);
				if (result == null)
					result = caseSemanticsVisitable(modelElement);
				if (result == null)
					result = caseElement(modelElement);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement) theEObject;
				Object result = caseNamedElement(namedElement);
				if (result == null)
					result = caseElement(namedElement);
				if (result == null)
					result = caseSemanticsVisitable(namedElement);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.NAMESPACE: {
				Namespace namespace = (Namespace) theEObject;
				Object result = caseNamespace(namespace);
				if (result == null)
					result = caseModelElement(namespace);
				if (result == null)
					result = caseSemanticsVisitable(namespace);
				if (result == null)
					result = caseElement(namespace);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.OCL_MODEL_ELEMENT_TYPE: {
				OclModelElementType oclModelElementType = (OclModelElementType) theEObject;
				Object result = caseOclModelElementType(oclModelElementType);
				if (result == null)
					result = caseOclAnyType(oclModelElementType);
				if (result == null)
					result = caseDataType(oclModelElementType);
				if (result == null)
					result = caseClassifier(oclModelElementType);
				if (result == null)
					result = caseNamespace(oclModelElementType);
				if (result == null)
					result = caseModelElement(oclModelElementType);
				if (result == null)
					result = caseSemanticsVisitable(oclModelElementType);
				if (result == null)
					result = caseElement(oclModelElementType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.OPERATION: {
				Operation operation = (Operation) theEObject;
				Object result = caseOperation(operation);
				if (result == null)
					result = caseModelElement(operation);
				if (result == null)
					result = caseSemanticsVisitable(operation);
				if (result == null)
					result = caseElement(operation);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.PARAMETER: {
				Parameter parameter = (Parameter) theEObject;
				Object result = caseParameter(parameter);
				if (result == null)
					result = caseModelElement(parameter);
				if (result == null)
					result = caseSemanticsVisitable(parameter);
				if (result == null)
					result = caseElement(parameter);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.PRIMITIVE: {
				Primitive primitive = (Primitive) theEObject;
				Object result = casePrimitive(primitive);
				if (result == null)
					result = caseOclAnyType(primitive);
				if (result == null)
					result = caseDataType(primitive);
				if (result == null)
					result = caseClassifier(primitive);
				if (result == null)
					result = caseNamespace(primitive);
				if (result == null)
					result = caseModelElement(primitive);
				if (result == null)
					result = caseSemanticsVisitable(primitive);
				if (result == null)
					result = caseElement(primitive);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.PROPERTY: {
				Property property = (Property) theEObject;
				Object result = caseProperty(property);
				if (result == null)
					result = caseModelElement(property);
				if (result == null)
					result = caseSemanticsVisitable(property);
				if (result == null)
					result = caseElement(property);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.SEND_ACTION: {
				SendAction sendAction = (SendAction) theEObject;
				Object result = caseSendAction(sendAction);
				if (result == null)
					result = caseModelElement(sendAction);
				if (result == null)
					result = caseSemanticsVisitable(sendAction);
				if (result == null)
					result = caseElement(sendAction);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.SIGNAL: {
				Signal signal = (Signal) theEObject;
				Object result = caseSignal(signal);
				if (result == null)
					result = caseModelElement(signal);
				if (result == null)
					result = caseSemanticsVisitable(signal);
				if (result == null)
					result = caseElement(signal);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case BridgePackage.TAG: {
				Tag tag = (Tag) theEObject;
				Object result = caseTag(tag);
				if (result == null)
					result = caseElement(tag);
				if (result == null)
					result = caseSemanticsVisitable(tag);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			default:
				return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Action</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCallAction(CallAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseClassifier(Classifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Defined Class</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Defined Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDefinedClass(DefinedClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Defined Operation</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Defined Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDefinedOperation(DefinedOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Defined Package</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Defined Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDefinedPackage(DefinedPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEnumLiteral(EnumLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEnumeration(Enumeration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Environment</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Environment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEnvironment(Environment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseModelElement(ModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNamespace(Namespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Ocl Model Element Type</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Ocl Model Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclModelElementType(OclModelElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimitive(Primitive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Send Action</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Send Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSendAction(SendAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signal</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSignal(Signal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTag(Tag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSemanticsVisitable(SemanticsVisitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Any Type</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Any Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclAnyType(OclAnyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} // BridgeSwitch
