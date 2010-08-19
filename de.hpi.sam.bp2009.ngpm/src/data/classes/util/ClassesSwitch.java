/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes.util;

import behavioral.events.EventProducer;

import data.classes.*;

import java.util.List;

import modelmanagement.NamedElement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see data.classes.ClassesPackage
 * @generated
 */
public class ClassesSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static ClassesPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ClassesSwitch() {
        if (modelPackage == null) {
            modelPackage = ClassesPackage.eINSTANCE;
        }
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case ClassesPackage.ASSOCIATION: {
                Association association = (Association)theEObject;
                T result = caseAssociation(association);
                if (result == null) result = caseNamedElement(association);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.SIGNATURE: {
                Signature signature = (Signature)theEObject;
                T result = caseSignature(signature);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.ASSOCIATION_END: {
                AssociationEnd associationEnd = (AssociationEnd)theEObject;
                T result = caseAssociationEnd(associationEnd);
                if (result == null) result = caseNamedElement(associationEnd);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.SAP_CLASS: {
                SapClass sapClass = (SapClass)theEObject;
                T result = caseSapClass(sapClass);
                if (result == null) result = caseSignatureOwner(sapClass);
                if (result == null) result = caseEventProducer(sapClass);
                if (result == null) result = caseNamedElement(sapClass);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.DELEGATION: {
                Delegation delegation = (Delegation)theEObject;
                T result = caseDelegation(delegation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.TYPED_ELEMENT: {
                TypedElement typedElement = (TypedElement)theEObject;
                T result = caseTypedElement(typedElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.CONTEXT: {
                Context context = (Context)theEObject;
                T result = caseContext(context);
                if (result == null) result = caseNamedElement(context);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.MULTIPLICITY: {
                Multiplicity multiplicity = (Multiplicity)theEObject;
                T result = caseMultiplicity(multiplicity);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.SIGNATURE_IMPLEMENTATION: {
                SignatureImplementation signatureImplementation = (SignatureImplementation)theEObject;
                T result = caseSignatureImplementation(signatureImplementation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.LINK_TRAVERSAL: {
                LinkTraversal linkTraversal = (LinkTraversal)theEObject;
                T result = caseLinkTraversal(linkTraversal);
                if (result == null) result = caseAssociationEndSignatureImplementation(linkTraversal);
                if (result == null) result = caseSignatureImplementation(linkTraversal);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.LINK_ADDITION: {
                LinkAddition linkAddition = (LinkAddition)theEObject;
                T result = caseLinkAddition(linkAddition);
                if (result == null) result = caseLinkManipulationAtPosition(linkAddition);
                if (result == null) result = caseExtentModifyingAssociationEndSignatureImplementation(linkAddition);
                if (result == null) result = caseAssociationEndSignatureImplementation(linkAddition);
                if (result == null) result = caseSignatureImplementation(linkAddition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.LINK_REMOVAL: {
                LinkRemoval linkRemoval = (LinkRemoval)theEObject;
                T result = caseLinkRemoval(linkRemoval);
                if (result == null) result = caseLinkManipulationAtPosition(linkRemoval);
                if (result == null) result = caseExtentModifyingAssociationEndSignatureImplementation(linkRemoval);
                if (result == null) result = caseAssociationEndSignatureImplementation(linkRemoval);
                if (result == null) result = caseSignatureImplementation(linkRemoval);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.ASSOCIATION_END_SIGNATURE_IMPLEMENTATION: {
                AssociationEndSignatureImplementation associationEndSignatureImplementation = (AssociationEndSignatureImplementation)theEObject;
                T result = caseAssociationEndSignatureImplementation(associationEndSignatureImplementation);
                if (result == null) result = caseSignatureImplementation(associationEndSignatureImplementation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.CLASS_TYPE_DEFINITION: {
                ClassTypeDefinition classTypeDefinition = (ClassTypeDefinition)theEObject;
                T result = caseClassTypeDefinition(classTypeDefinition);
                if (result == null) result = caseTypeDefinition(classTypeDefinition);
                if (result == null) result = caseMultiplicity(classTypeDefinition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.TYPE_DEFINITION: {
                TypeDefinition typeDefinition = (TypeDefinition)theEObject;
                T result = caseTypeDefinition(typeDefinition);
                if (result == null) result = caseMultiplicity(typeDefinition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.NESTED_TYPE_DEFINITION: {
                NestedTypeDefinition nestedTypeDefinition = (NestedTypeDefinition)theEObject;
                T result = caseNestedTypeDefinition(nestedTypeDefinition);
                if (result == null) result = caseTypeDefinition(nestedTypeDefinition);
                if (result == null) result = caseMultiplicity(nestedTypeDefinition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION: {
                FunctionSignatureTypeDefinition functionSignatureTypeDefinition = (FunctionSignatureTypeDefinition)theEObject;
                T result = caseFunctionSignatureTypeDefinition(functionSignatureTypeDefinition);
                if (result == null) result = caseTypeDefinition(functionSignatureTypeDefinition);
                if (result == null) result = caseMultiplicity(functionSignatureTypeDefinition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.METHOD_SIGNATURE: {
                MethodSignature methodSignature = (MethodSignature)theEObject;
                T result = caseMethodSignature(methodSignature);
                if (result == null) result = caseSignature(methodSignature);
                if (result == null) result = caseNamedElement(methodSignature);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.FUNCTION_SIGNATURE: {
                FunctionSignature functionSignature = (FunctionSignature)theEObject;
                T result = caseFunctionSignature(functionSignature);
                if (result == null) result = caseSignature(functionSignature);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.LINK_SETTING: {
                LinkSetting linkSetting = (LinkSetting)theEObject;
                T result = caseLinkSetting(linkSetting);
                if (result == null) result = caseExtentModifyingAssociationEndSignatureImplementation(linkSetting);
                if (result == null) result = caseAssociationEndSignatureImplementation(linkSetting);
                if (result == null) result = caseSignatureImplementation(linkSetting);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.TYPE_ADAPTER: {
                TypeAdapter typeAdapter = (TypeAdapter)theEObject;
                T result = caseTypeAdapter(typeAdapter);
                if (result == null) result = caseSignatureOwner(typeAdapter);
                if (result == null) result = caseNamedElement(typeAdapter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.PARAMETER: {
                Parameter parameter = (Parameter)theEObject;
                T result = caseParameter(parameter);
                if (result == null) result = caseNamedValue(parameter);
                if (result == null) result = caseNamedElement(parameter);
                if (result == null) result = caseTypedElement(parameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.NAMED_VALUE: {
                NamedValue namedValue = (NamedValue)theEObject;
                T result = caseNamedValue(namedValue);
                if (result == null) result = caseNamedElement(namedValue);
                if (result == null) result = caseTypedElement(namedValue);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.PLATFORM_SPECIFIC_IMPLEMENTATION: {
                PlatformSpecificImplementation platformSpecificImplementation = (PlatformSpecificImplementation)theEObject;
                T result = casePlatformSpecificImplementation(platformSpecificImplementation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.NATIVE_IMPL: {
                NativeImpl nativeImpl = (NativeImpl)theEObject;
                T result = caseNativeImpl(nativeImpl);
                if (result == null) result = caseSignatureImplementation(nativeImpl);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.SIGNATURE_OWNER: {
                SignatureOwner signatureOwner = (SignatureOwner)theEObject;
                T result = caseSignatureOwner(signatureOwner);
                if (result == null) result = caseNamedElement(signatureOwner);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION: {
                ExtentModifyingAssociationEndSignatureImplementation extentModifyingAssociationEndSignatureImplementation = (ExtentModifyingAssociationEndSignatureImplementation)theEObject;
                T result = caseExtentModifyingAssociationEndSignatureImplementation(extentModifyingAssociationEndSignatureImplementation);
                if (result == null) result = caseAssociationEndSignatureImplementation(extentModifyingAssociationEndSignatureImplementation);
                if (result == null) result = caseSignatureImplementation(extentModifyingAssociationEndSignatureImplementation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION: {
                FunctionSignatureImplementation functionSignatureImplementation = (FunctionSignatureImplementation)theEObject;
                T result = caseFunctionSignatureImplementation(functionSignatureImplementation);
                if (result == null) result = caseSignatureImplementation(functionSignatureImplementation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER: {
                ActualObjectParameter actualObjectParameter = (ActualObjectParameter)theEObject;
                T result = caseActualObjectParameter(actualObjectParameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS: {
                ConverterBetweenParametrizations converterBetweenParametrizations = (ConverterBetweenParametrizations)theEObject;
                T result = caseConverterBetweenParametrizations(converterBetweenParametrizations);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.LINK_MANIPULATION_AT_POSITION: {
                LinkManipulationAtPosition linkManipulationAtPosition = (LinkManipulationAtPosition)theEObject;
                T result = caseLinkManipulationAtPosition(linkManipulationAtPosition);
                if (result == null) result = caseExtentModifyingAssociationEndSignatureImplementation(linkManipulationAtPosition);
                if (result == null) result = caseAssociationEndSignatureImplementation(linkManipulationAtPosition);
                if (result == null) result = caseSignatureImplementation(linkManipulationAtPosition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ClassesPackage.IN_SCOPE: {
                InScope inScope = (InScope)theEObject;
                T result = caseInScope(inScope);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Association</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Association</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAssociation(Association object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Signature</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Signature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSignature(Signature object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Association End</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Association End</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAssociationEnd(AssociationEnd object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Sap Class</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sap Class</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSapClass(SapClass object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Delegation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Delegation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDelegation(Delegation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTypedElement(TypedElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Context</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseContext(Context object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Multiplicity</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Multiplicity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMultiplicity(Multiplicity object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Signature Implementation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Signature Implementation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSignatureImplementation(SignatureImplementation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Link Traversal</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Link Traversal</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLinkTraversal(LinkTraversal object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Link Addition</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Link Addition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLinkAddition(LinkAddition object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Link Removal</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Link Removal</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLinkRemoval(LinkRemoval object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Association End Signature Implementation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Association End Signature Implementation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAssociationEndSignatureImplementation(AssociationEndSignatureImplementation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Class Type Definition</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Class Type Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseClassTypeDefinition(ClassTypeDefinition object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Type Definition</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTypeDefinition(TypeDefinition object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Nested Type Definition</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Nested Type Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNestedTypeDefinition(NestedTypeDefinition object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Function Signature Type Definition</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Function Signature Type Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseFunctionSignatureTypeDefinition(FunctionSignatureTypeDefinition object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Method Signature</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Method Signature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMethodSignature(MethodSignature object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Function Signature</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Function Signature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseFunctionSignature(FunctionSignature object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Link Setting</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Link Setting</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLinkSetting(LinkSetting object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Type Adapter</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Adapter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTypeAdapter(TypeAdapter object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseParameter(Parameter object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Named Value</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNamedValue(NamedValue object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Platform Specific Implementation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Platform Specific Implementation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePlatformSpecificImplementation(PlatformSpecificImplementation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Native Impl</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Native Impl</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNativeImpl(NativeImpl object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Signature Owner</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Signature Owner</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSignatureOwner(SignatureOwner object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Extent Modifying Association End Signature Implementation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Extent Modifying Association End Signature Implementation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseExtentModifyingAssociationEndSignatureImplementation(ExtentModifyingAssociationEndSignatureImplementation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Function Signature Implementation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Function Signature Implementation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseFunctionSignatureImplementation(FunctionSignatureImplementation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Actual Object Parameter</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Actual Object Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseActualObjectParameter(ActualObjectParameter object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Converter Between Parametrizations</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Converter Between Parametrizations</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseConverterBetweenParametrizations(ConverterBetweenParametrizations object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Link Manipulation At Position</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Link Manipulation At Position</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLinkManipulationAtPosition(LinkManipulationAtPosition object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>In Scope</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>In Scope</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseInScope(InScope object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNamedElement(NamedElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Event Producer</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Producer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEventProducer(EventProducer object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
	public T defaultCase(EObject object) {
        return null;
    }

} //ClassesSwitch
