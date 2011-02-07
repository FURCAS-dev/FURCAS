/**
 * <copyright>
 * </copyright>
 *
 * $Id: XsdSwitch.java,v 1.1 2011/02/07 16:57:59 auhl Exp $
 */
package integration.xsd.util;

import integration.xsd.*;

import java.util.List;

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
 * @see integration.xsd.XsdPackage
 * @generated
 */
public class XsdSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static XsdPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public XsdSwitch() {
        if (modelPackage == null) {
            modelPackage = XsdPackage.eINSTANCE;
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
            case XsdPackage.SEQUENCE: {
                Sequence sequence = (Sequence)theEObject;
                T result = caseSequence(sequence);
                if (result == null) result = caseContainable(sequence);
                if (result == null) result = caseRoot(sequence);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.CHOICE: {
                Choice choice = (Choice)theEObject;
                T result = caseChoice(choice);
                if (result == null) result = caseContainable(choice);
                if (result == null) result = caseRoot(choice);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.COMPLEX_TYPE: {
                ComplexType complexType = (ComplexType)theEObject;
                T result = caseComplexType(complexType);
                if (result == null) result = caseAbstractType(complexType);
                if (result == null) result = caseNamedElement(complexType);
                if (result == null) result = caseRoot(complexType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.ELEMENT_DEFINITION: {
                ElementDefinition elementDefinition = (ElementDefinition)theEObject;
                T result = caseElementDefinition(elementDefinition);
                if (result == null) result = caseNamedElement(elementDefinition);
                if (result == null) result = caseRoot(elementDefinition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.NAMED_ELEMENT: {
                NamedElement namedElement = (NamedElement)theEObject;
                T result = caseNamedElement(namedElement);
                if (result == null) result = caseRoot(namedElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.ABSTRACT_TYPE: {
                AbstractType abstractType = (AbstractType)theEObject;
                T result = caseAbstractType(abstractType);
                if (result == null) result = caseNamedElement(abstractType);
                if (result == null) result = caseRoot(abstractType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.CONTAINABLE: {
                Containable containable = (Containable)theEObject;
                T result = caseContainable(containable);
                if (result == null) result = caseRoot(containable);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.ATTRIBUTE: {
                Attribute attribute = (Attribute)theEObject;
                T result = caseAttribute(attribute);
                if (result == null) result = caseNamedElement(attribute);
                if (result == null) result = caseRoot(attribute);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.ANY: {
                Any any = (Any)theEObject;
                T result = caseAny(any);
                if (result == null) result = caseContainable(any);
                if (result == null) result = caseRoot(any);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.ROOT: {
                Root root = (Root)theEObject;
                T result = caseRoot(root);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.GROUP: {
                Group group = (Group)theEObject;
                T result = caseGroup(group);
                if (result == null) result = caseContainable(group);
                if (result == null) result = caseNamedElement(group);
                if (result == null) result = caseRoot(group);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.ANNOTATION: {
                Annotation annotation = (Annotation)theEObject;
                T result = caseAnnotation(annotation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.NOTATION: {
                Notation notation = (Notation)theEObject;
                T result = caseNotation(notation);
                if (result == null) result = caseNamedElement(notation);
                if (result == null) result = caseRoot(notation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.SIMPLE_TYPE: {
                SimpleType simpleType = (SimpleType)theEObject;
                T result = caseSimpleType(simpleType);
                if (result == null) result = caseAbstractType(simpleType);
                if (result == null) result = caseNamedElement(simpleType);
                if (result == null) result = caseRoot(simpleType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.ELEMENT_REFERENCE: {
                ElementReference elementReference = (ElementReference)theEObject;
                T result = caseElementReference(elementReference);
                if (result == null) result = caseContainable(elementReference);
                if (result == null) result = caseNamedElement(elementReference);
                if (result == null) result = caseRoot(elementReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.ABSTRACT_CONTENT: {
                AbstractContent abstractContent = (AbstractContent)theEObject;
                T result = caseAbstractContent(abstractContent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.SIMPLE_CONTENT: {
                SimpleContent simpleContent = (SimpleContent)theEObject;
                T result = caseSimpleContent(simpleContent);
                if (result == null) result = caseAbstractContent(simpleContent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case XsdPackage.COMPLEX_CONTENT: {
                ComplexContent complexContent = (ComplexContent)theEObject;
                T result = caseComplexContent(complexContent);
                if (result == null) result = caseAbstractContent(complexContent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Sequence</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sequence</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSequence(Sequence object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Choice</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Choice</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseChoice(Choice object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Complex Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Complex Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseComplexType(ComplexType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Element Definition</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Element Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseElementDefinition(ElementDefinition object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Abstract Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAbstractType(AbstractType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Containable</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Containable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseContainable(Containable object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAttribute(Attribute object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Any</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Any</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAny(Any object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Root</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseRoot(Root object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Group</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Group</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseGroup(Group object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAnnotation(Annotation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Notation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Notation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNotation(Notation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Simple Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simple Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSimpleType(SimpleType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Element Reference</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Element Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseElementReference(ElementReference object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Content</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Content</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAbstractContent(AbstractContent object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Simple Content</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simple Content</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSimpleContent(SimpleContent object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Complex Content</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Complex Content</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseComplexContent(ComplexContent object) {
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

} //XsdSwitch
