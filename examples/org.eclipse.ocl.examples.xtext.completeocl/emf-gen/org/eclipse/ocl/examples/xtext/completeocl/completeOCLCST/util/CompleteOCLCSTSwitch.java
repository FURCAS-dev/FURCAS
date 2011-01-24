/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CompleteOCLCSTSwitch.java,v 1.4 2011/01/24 21:08:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.util.Nameable;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageArgCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreExpCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DecoratedNamedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS;

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
 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage
 * @generated
 */
public class CompleteOCLCSTSwitch<T>
{
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static CompleteOCLCSTPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CompleteOCLCSTSwitch()
  {
		if (modelPackage == null)
		{
			modelPackage = CompleteOCLCSTPackage.eINSTANCE;
		}
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  public T doSwitch(EObject theEObject)
  {
		return doSwitch(theEObject.eClass(), theEObject);
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
		if (theEClass.eContainer() == modelPackage)
		{
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else
		{
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
  protected T doSwitch(int classifierID, EObject theEObject)
  {
		switch (classifierID)
		{
			case CompleteOCLCSTPackage.BODY_CS:
			{
				BodyCS bodyCS = (BodyCS)theEObject;
				T result = caseBodyCS(bodyCS);
				if (result == null) result = caseExpConstraintCS(bodyCS);
				if (result == null) result = caseConstraintCS(bodyCS);
				if (result == null) result = caseNamedElementCS(bodyCS);
				if (result == null) result = caseMonikeredElementCS(bodyCS);
				if (result == null) result = caseNameable(bodyCS);
				if (result == null) result = caseModelElementCS(bodyCS);
				if (result == null) result = caseElementCS(bodyCS);
				if (result == null) result = casePivotable(bodyCS);
				if (result == null) result = caseVisitableCS(bodyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS:
			{
				ClassifierContextDeclCS classifierContextDeclCS = (ClassifierContextDeclCS)theEObject;
				T result = caseClassifierContextDeclCS(classifierContextDeclCS);
				if (result == null) result = caseContextDeclCS(classifierContextDeclCS);
				if (result == null) result = caseModelElementCS(classifierContextDeclCS);
				if (result == null) result = caseElementCS(classifierContextDeclCS);
				if (result == null) result = casePivotable(classifierContextDeclCS);
				if (result == null) result = caseVisitableCS(classifierContextDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.COMPLETE_OCL_DOCUMENT_CS:
			{
				CompleteOCLDocumentCS completeOCLDocumentCS = (CompleteOCLDocumentCS)theEObject;
				T result = caseCompleteOCLDocumentCS(completeOCLDocumentCS);
				if (result == null) result = caseRootPackageCS(completeOCLDocumentCS);
				if (result == null) result = casePackageCS(completeOCLDocumentCS);
				if (result == null) result = caseRootCS(completeOCLDocumentCS);
				if (result == null) result = caseNamespaceCS(completeOCLDocumentCS);
				if (result == null) result = caseNamedElementCS(completeOCLDocumentCS);
				if (result == null) result = caseMonikeredElementCS(completeOCLDocumentCS);
				if (result == null) result = caseNameable(completeOCLDocumentCS);
				if (result == null) result = caseModelElementCS(completeOCLDocumentCS);
				if (result == null) result = caseElementCS(completeOCLDocumentCS);
				if (result == null) result = casePivotable(completeOCLDocumentCS);
				if (result == null) result = caseVisitableCS(completeOCLDocumentCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.CONTEXT_DECL_CS:
			{
				ContextDeclCS contextDeclCS = (ContextDeclCS)theEObject;
				T result = caseContextDeclCS(contextDeclCS);
				if (result == null) result = caseModelElementCS(contextDeclCS);
				if (result == null) result = caseElementCS(contextDeclCS);
				if (result == null) result = casePivotable(contextDeclCS);
				if (result == null) result = caseVisitableCS(contextDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.DEF_CS:
			{
				DefCS defCS = (DefCS)theEObject;
				T result = caseDefCS(defCS);
				if (result == null) result = caseExpConstraintCS(defCS);
				if (result == null) result = caseConstraintCS(defCS);
				if (result == null) result = caseNamedElementCS(defCS);
				if (result == null) result = caseMonikeredElementCS(defCS);
				if (result == null) result = caseNameable(defCS);
				if (result == null) result = caseModelElementCS(defCS);
				if (result == null) result = caseElementCS(defCS);
				if (result == null) result = casePivotable(defCS);
				if (result == null) result = caseVisitableCS(defCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.DER_CS:
			{
				DerCS derCS = (DerCS)theEObject;
				T result = caseDerCS(derCS);
				if (result == null) result = caseExpConstraintCS(derCS);
				if (result == null) result = caseConstraintCS(derCS);
				if (result == null) result = caseNamedElementCS(derCS);
				if (result == null) result = caseMonikeredElementCS(derCS);
				if (result == null) result = caseNameable(derCS);
				if (result == null) result = caseModelElementCS(derCS);
				if (result == null) result = caseElementCS(derCS);
				if (result == null) result = casePivotable(derCS);
				if (result == null) result = caseVisitableCS(derCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.FEATURE_CONTEXT_DECL_CS:
			{
				FeatureContextDeclCS featureContextDeclCS = (FeatureContextDeclCS)theEObject;
				T result = caseFeatureContextDeclCS(featureContextDeclCS);
				if (result == null) result = caseContextDeclCS(featureContextDeclCS);
				if (result == null) result = caseModelElementCS(featureContextDeclCS);
				if (result == null) result = caseElementCS(featureContextDeclCS);
				if (result == null) result = casePivotable(featureContextDeclCS);
				if (result == null) result = caseVisitableCS(featureContextDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.INIT_CS:
			{
				InitCS initCS = (InitCS)theEObject;
				T result = caseInitCS(initCS);
				if (result == null) result = caseExpConstraintCS(initCS);
				if (result == null) result = caseConstraintCS(initCS);
				if (result == null) result = caseNamedElementCS(initCS);
				if (result == null) result = caseMonikeredElementCS(initCS);
				if (result == null) result = caseNameable(initCS);
				if (result == null) result = caseModelElementCS(initCS);
				if (result == null) result = caseElementCS(initCS);
				if (result == null) result = casePivotable(initCS);
				if (result == null) result = caseVisitableCS(initCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.INV_CS:
			{
				InvCS invCS = (InvCS)theEObject;
				T result = caseInvCS(invCS);
				if (result == null) result = caseExpConstraintCS(invCS);
				if (result == null) result = caseConstraintCS(invCS);
				if (result == null) result = caseNamedElementCS(invCS);
				if (result == null) result = caseMonikeredElementCS(invCS);
				if (result == null) result = caseNameable(invCS);
				if (result == null) result = caseModelElementCS(invCS);
				if (result == null) result = caseElementCS(invCS);
				if (result == null) result = casePivotable(invCS);
				if (result == null) result = caseVisitableCS(invCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.OCL_MESSAGE_ARG_CS:
			{
				OclMessageArgCS oclMessageArgCS = (OclMessageArgCS)theEObject;
				T result = caseOclMessageArgCS(oclMessageArgCS);
				if (result == null) result = caseExpCS(oclMessageArgCS);
				if (result == null) result = caseMonikeredElementCS(oclMessageArgCS);
				if (result == null) result = caseModelElementCS(oclMessageArgCS);
				if (result == null) result = caseElementCS(oclMessageArgCS);
				if (result == null) result = casePivotable(oclMessageArgCS);
				if (result == null) result = caseVisitableCS(oclMessageArgCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.OPERATION_CONTEXT_DECL_CS:
			{
				OperationContextDeclCS operationContextDeclCS = (OperationContextDeclCS)theEObject;
				T result = caseOperationContextDeclCS(operationContextDeclCS);
				if (result == null) result = caseFeatureContextDeclCS(operationContextDeclCS);
				if (result == null) result = caseContextDeclCS(operationContextDeclCS);
				if (result == null) result = caseModelElementCS(operationContextDeclCS);
				if (result == null) result = caseElementCS(operationContextDeclCS);
				if (result == null) result = casePivotable(operationContextDeclCS);
				if (result == null) result = caseVisitableCS(operationContextDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.PACKAGE_DECLARATION_CS:
			{
				PackageDeclarationCS packageDeclarationCS = (PackageDeclarationCS)theEObject;
				T result = casePackageDeclarationCS(packageDeclarationCS);
				if (result == null) result = caseMonikeredElementCS(packageDeclarationCS);
				if (result == null) result = caseModelElementCS(packageDeclarationCS);
				if (result == null) result = caseElementCS(packageDeclarationCS);
				if (result == null) result = casePivotable(packageDeclarationCS);
				if (result == null) result = caseVisitableCS(packageDeclarationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.POST_CS:
			{
				PostCS postCS = (PostCS)theEObject;
				T result = casePostCS(postCS);
				if (result == null) result = caseExpConstraintCS(postCS);
				if (result == null) result = caseConstraintCS(postCS);
				if (result == null) result = caseNamedElementCS(postCS);
				if (result == null) result = caseMonikeredElementCS(postCS);
				if (result == null) result = caseNameable(postCS);
				if (result == null) result = caseModelElementCS(postCS);
				if (result == null) result = caseElementCS(postCS);
				if (result == null) result = casePivotable(postCS);
				if (result == null) result = caseVisitableCS(postCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.PRE_CS:
			{
				PreCS preCS = (PreCS)theEObject;
				T result = casePreCS(preCS);
				if (result == null) result = caseExpConstraintCS(preCS);
				if (result == null) result = caseConstraintCS(preCS);
				if (result == null) result = caseNamedElementCS(preCS);
				if (result == null) result = caseMonikeredElementCS(preCS);
				if (result == null) result = caseNameable(preCS);
				if (result == null) result = caseModelElementCS(preCS);
				if (result == null) result = caseElementCS(preCS);
				if (result == null) result = casePivotable(preCS);
				if (result == null) result = caseVisitableCS(preCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.PRE_EXP_CS:
			{
				PreExpCS preExpCS = (PreExpCS)theEObject;
				T result = casePreExpCS(preExpCS);
				if (result == null) result = caseDecoratedNamedExpCS(preExpCS);
				if (result == null) result = caseNamedExpCS(preExpCS);
				if (result == null) result = caseExpCS(preExpCS);
				if (result == null) result = caseMonikeredElementCS(preExpCS);
				if (result == null) result = caseModelElementCS(preExpCS);
				if (result == null) result = caseElementCS(preExpCS);
				if (result == null) result = casePivotable(preExpCS);
				if (result == null) result = caseVisitableCS(preExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS:
			{
				PropertyContextDeclCS propertyContextDeclCS = (PropertyContextDeclCS)theEObject;
				T result = casePropertyContextDeclCS(propertyContextDeclCS);
				if (result == null) result = caseFeatureContextDeclCS(propertyContextDeclCS);
				if (result == null) result = caseContextDeclCS(propertyContextDeclCS);
				if (result == null) result = caseModelElementCS(propertyContextDeclCS);
				if (result == null) result = caseElementCS(propertyContextDeclCS);
				if (result == null) result = casePivotable(propertyContextDeclCS);
				if (result == null) result = caseVisitableCS(propertyContextDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Body CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Body CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseBodyCS(BodyCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Context Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseClassifierContextDeclCS(ClassifierContextDeclCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Complete OCL Document CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complete OCL Document CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCompleteOCLDocumentCS(CompleteOCLDocumentCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Exp Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp Constraint CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpConstraintCS(ExpConstraintCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseConstraintCS(ConstraintCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseContextDeclCS(ContextDeclCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Def CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Def CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDefCS(DefCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Der CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Der CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDerCS(DerCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Context Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseFeatureContextDeclCS(FeatureContextDeclCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Init CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Init CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseInitCS(InitCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Inv CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inv CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseInvCS(InvCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Message Arg CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Message Arg CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseOclMessageArgCS(OclMessageArgCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Context Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseOperationContextDeclCS(OperationContextDeclCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Package Declaration CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Declaration CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePackageDeclarationCS(PackageDeclarationCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Post CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePostCS(PostCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Pre CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pre CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePreCS(PreCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Pre Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pre Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreExpCS(PreExpCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Context Decl CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Context Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePropertyContextDeclCS(PropertyContextDeclCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitableCS(VisitableCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseElementCS(ElementCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePivotable(Pivotable object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseModelElementCS(ModelElementCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Monikered Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Monikered Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMonikeredElementCS(MonikeredElementCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseNamedElementCS(NamedElementCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseNamespaceCS(NamespaceCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageCS(PackageCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootCS(RootCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Root Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootPackageCS(RootPackageCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseExpCS(ExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Named Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedExpCS(NamedExpCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Decorated Named Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decorated Named Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecoratedNamedExpCS(DecoratedNamedExpCS object)
	{
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
  public T defaultCase(EObject object)
  {
		return null;
	}

} //CompleteOCLCSTSwitch
