/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: EditorSwitch.java,v 1.2 2010/04/08 06:26:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.editor.*;

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
 * @see org.eclipse.ocl.examples.editor.EditorPackage
 * @generated
 */
public class EditorSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EditorPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditorSwitch() {
		if (modelPackage == null) {
			modelPackage = EditorPackage.eINSTANCE;
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
			case EditorPackage.ABSTRACT_LABEL_ELEMENT: {
				AbstractLabelElement abstractLabelElement = (AbstractLabelElement)theEObject;
				T result = caseAbstractLabelElement(abstractLabelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditorPackage.ABSTRACT_NODE: {
				AbstractNode abstractNode = (AbstractNode)theEObject;
				T result = caseAbstractNode(abstractNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditorPackage.ABSTRACT_OUTLINE_ELEMENT: {
				AbstractOutlineElement abstractOutlineElement = (AbstractOutlineElement)theEObject;
				T result = caseAbstractOutlineElement(abstractOutlineElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditorPackage.BEHAVIOR: {
				Behavior behavior = (Behavior)theEObject;
				T result = caseBehavior(behavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditorPackage.ECORE_LABEL_ELEMENT: {
				EcoreLabelElement ecoreLabelElement = (EcoreLabelElement)theEObject;
				T result = caseEcoreLabelElement(ecoreLabelElement);
				if (result == null) result = caseAbstractLabelElement(ecoreLabelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditorPackage.ECORE_NODE: {
				EcoreNode ecoreNode = (EcoreNode)theEObject;
				T result = caseEcoreNode(ecoreNode);
				if (result == null) result = caseAbstractNode(ecoreNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditorPackage.EDITOR_DEFINITION: {
				EditorDefinition editorDefinition = (EditorDefinition)theEObject;
				T result = caseEditorDefinition(editorDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditorPackage.FOLDING_BEHAVIOR: {
				FoldingBehavior foldingBehavior = (FoldingBehavior)theEObject;
				T result = caseFoldingBehavior(foldingBehavior);
				if (result == null) result = caseBehavior(foldingBehavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditorPackage.JAVA_LABEL_ELEMENT: {
				JavaLabelElement javaLabelElement = (JavaLabelElement)theEObject;
				T result = caseJavaLabelElement(javaLabelElement);
				if (result == null) result = caseAbstractLabelElement(javaLabelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditorPackage.JAVA_NODE: {
				JavaNode javaNode = (JavaNode)theEObject;
				T result = caseJavaNode(javaNode);
				if (result == null) result = caseAbstractNode(javaNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditorPackage.LABEL_BEHAVIOR: {
				LabelBehavior labelBehavior = (LabelBehavior)theEObject;
				T result = caseLabelBehavior(labelBehavior);
				if (result == null) result = caseBehavior(labelBehavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditorPackage.OUTLINE_BEHAVIOR: {
				OutlineBehavior outlineBehavior = (OutlineBehavior)theEObject;
				T result = caseOutlineBehavior(outlineBehavior);
				if (result == null) result = caseBehavior(outlineBehavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditorPackage.OUTLINE_ELEMENT: {
				OutlineElement outlineElement = (OutlineElement)theEObject;
				T result = caseOutlineElement(outlineElement);
				if (result == null) result = caseAbstractOutlineElement(outlineElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditorPackage.OUTLINE_GROUP: {
				OutlineGroup outlineGroup = (OutlineGroup)theEObject;
				T result = caseOutlineGroup(outlineGroup);
				if (result == null) result = caseAbstractOutlineElement(outlineGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Label Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Label Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractLabelElement(AbstractLabelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractNode(AbstractNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Outline Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Outline Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractOutlineElement(AbstractOutlineElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehavior(Behavior object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecore Label Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecore Label Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEcoreLabelElement(EcoreLabelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecore Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecore Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEcoreNode(EcoreNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditorDefinition(EditorDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Folding Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Folding Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFoldingBehavior(FoldingBehavior object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Label Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Label Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaLabelElement(JavaLabelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaNode(JavaNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabelBehavior(LabelBehavior object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Outline Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Outline Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutlineBehavior(OutlineBehavior object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Outline Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Outline Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutlineElement(OutlineElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Outline Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Outline Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutlineGroup(OutlineGroup object) {
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

} //EditorSwitch
