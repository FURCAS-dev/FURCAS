/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.oclwithhiddenopposites.utilities;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;

import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitor With Hidden Opposite</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.sap.emf.ocl.oclwithhiddenopposites.utilities.UtilitiesPackage#getVisitorWithHiddenOpposite()
 * @model interface="true" abstract="true" superTypes="org.eclipse.ocl.utilities.Visitor<org.eclipse.emf.ecore.EJavaObject, org.eclipse.emf.ecore.EClassifier, org.eclipse.emf.ecore.EOperation, org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EEnumLiteral, org.eclipse.emf.ecore.EParameter, org.eclipse.emf.ecore.EObject, org.eclipse.ocl.ecore.CallOperationAction, org.eclipse.ocl.ecore.SendSignalAction, org.eclipse.ocl.ecore.Constraint>"
 * @generated
 */
public interface VisitorWithHiddenOpposite<T> extends Visitor<T, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {
	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @model callExpRequired="true"
         * @generated
         */
	T visitOppositePropertyCallExp(OppositePropertyCallExp callExp);

} // VisitorWithHiddenOpposite
