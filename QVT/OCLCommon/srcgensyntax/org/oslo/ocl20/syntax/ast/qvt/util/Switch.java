/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.syntax.ast.Visitable;

import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

import org.oslo.ocl20.syntax.ast.qvt.*;

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
 * @see org.oslo.ocl20.syntax.ast.qvt.Package
 * @generated
 */
public class Switch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static org.oslo.ocl20.syntax.ast.qvt.Package modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Switch() {
		if (modelPackage == null) {
			modelPackage = org.oslo.ocl20.syntax.ast.qvt.Package.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS: {
				CollectionTemplateAS collectionTemplateAS = (CollectionTemplateAS)theEObject;
				Object result = caseCollectionTemplateAS(collectionTemplateAS);
				if (result == null) result = caseTemplateAS(collectionTemplateAS);
				if (result == null) result = caseOclExpressionAS(collectionTemplateAS);
				if (result == null) result = caseVisitable(collectionTemplateAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS: {
				DomainAS domainAS = (DomainAS)theEObject;
				Object result = caseDomainAS(domainAS);
				if (result == null) result = caseGeneralDomainAS(domainAS);
				if (result == null) result = caseVisitable(domainAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.GENERAL_DOMAIN_AS: {
				GeneralDomainAS generalDomainAS = (GeneralDomainAS)theEObject;
				Object result = caseGeneralDomainAS(generalDomainAS);
				if (result == null) result = caseVisitable(generalDomainAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.KEY_DECLARATION_AS: {
				KeyDeclarationAS keyDeclarationAS = (KeyDeclarationAS)theEObject;
				Object result = caseKeyDeclarationAS(keyDeclarationAS);
				if (result == null) result = caseVisitable(keyDeclarationAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS: {
				MemberSelectionExpressionAS memberSelectionExpressionAS = (MemberSelectionExpressionAS)theEObject;
				Object result = caseMemberSelectionExpressionAS(memberSelectionExpressionAS);
				if (result == null) result = caseVisitable(memberSelectionExpressionAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.MODEL_DECLARATION_AS: {
				ModelDeclarationAS modelDeclarationAS = (ModelDeclarationAS)theEObject;
				Object result = caseModelDeclarationAS(modelDeclarationAS);
				if (result == null) result = caseVisitable(modelDeclarationAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.OBJECT_TEMPLATE_AS: {
				ObjectTemplateAS objectTemplateAS = (ObjectTemplateAS)theEObject;
				Object result = caseObjectTemplateAS(objectTemplateAS);
				if (result == null) result = caseTemplateAS(objectTemplateAS);
				if (result == null) result = caseOclExpressionAS(objectTemplateAS);
				if (result == null) result = caseVisitable(objectTemplateAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.PARAMETER_DECLARATION_AS: {
				ParameterDeclarationAS parameterDeclarationAS = (ParameterDeclarationAS)theEObject;
				Object result = caseParameterDeclarationAS(parameterDeclarationAS);
				if (result == null) result = caseVisitable(parameterDeclarationAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.PRIMITIVE_DOMAIN_AS: {
				PrimitiveDomainAS primitiveDomainAS = (PrimitiveDomainAS)theEObject;
				Object result = casePrimitiveDomainAS(primitiveDomainAS);
				if (result == null) result = caseGeneralDomainAS(primitiveDomainAS);
				if (result == null) result = caseVisitable(primitiveDomainAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.PROPERTY_TEMPLATE_AS: {
				PropertyTemplateAS propertyTemplateAS = (PropertyTemplateAS)theEObject;
				Object result = casePropertyTemplateAS(propertyTemplateAS);
				if (result == null) result = caseVisitable(propertyTemplateAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.QUERY_AS: {
				QueryAS queryAS = (QueryAS)theEObject;
				Object result = caseQueryAS(queryAS);
				if (result == null) result = caseVisitable(queryAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS: {
				RelationAS relationAS = (RelationAS)theEObject;
				Object result = caseRelationAS(relationAS);
				if (result == null) result = caseVisitable(relationAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS: {
				SetComprehensionExpressionAS setComprehensionExpressionAS = (SetComprehensionExpressionAS)theEObject;
				Object result = caseSetComprehensionExpressionAS(setComprehensionExpressionAS);
				if (result == null) result = caseVisitable(setComprehensionExpressionAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.TEMPLATE_AS: {
				TemplateAS templateAS = (TemplateAS)theEObject;
				Object result = caseTemplateAS(templateAS);
				if (result == null) result = caseOclExpressionAS(templateAS);
				if (result == null) result = caseVisitable(templateAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.TOP_LEVEL_AS: {
				TopLevelAS topLevelAS = (TopLevelAS)theEObject;
				Object result = caseTopLevelAS(topLevelAS);
				if (result == null) result = caseVisitable(topLevelAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS: {
				TransformationAS transformationAS = (TransformationAS)theEObject;
				Object result = caseTransformationAS(transformationAS);
				if (result == null) result = caseVisitable(transformationAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case org.oslo.ocl20.syntax.ast.qvt.Package.VARIABLE_DECLARATION_AS: {
				VariableDeclarationAS variableDeclarationAS = (VariableDeclarationAS)theEObject;
				Object result = caseVariableDeclarationAS(variableDeclarationAS);
				if (result == null) result = caseVisitable(variableDeclarationAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Template AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Template AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionTemplateAS(CollectionTemplateAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDomainAS(DomainAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>General Domain AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>General Domain AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGeneralDomainAS(GeneralDomainAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Key Declaration AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Key Declaration AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseKeyDeclarationAS(KeyDeclarationAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Member Selection Expression AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Member Selection Expression AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMemberSelectionExpressionAS(MemberSelectionExpressionAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Declaration AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Declaration AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseModelDeclarationAS(ModelDeclarationAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Template AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Template AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseObjectTemplateAS(ObjectTemplateAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Declaration AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Declaration AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseParameterDeclarationAS(ParameterDeclarationAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Domain AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Domain AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimitiveDomainAS(PrimitiveDomainAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Template AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Template AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePropertyTemplateAS(PropertyTemplateAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseQueryAS(QueryAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRelationAS(RelationAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Comprehension Expression AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Comprehension Expression AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSetComprehensionExpressionAS(SetComprehensionExpressionAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTemplateAS(TemplateAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Top Level AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Top Level AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTopLevelAS(TopLevelAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformation AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformation AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTransformationAS(TransformationAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariableDeclarationAS(VariableDeclarationAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVisitable(Visitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Expression AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Expression AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclExpressionAS(OclExpressionAS object) {
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
	public Object defaultCase(EObject object) {
		return null;
	}

} //Switch
