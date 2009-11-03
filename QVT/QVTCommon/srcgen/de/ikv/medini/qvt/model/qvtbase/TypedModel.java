/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtbase;

import de.ikv.medini.qvt.qvt.QvtVisitor;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.SemanticsVisitable;

import org.oslo.ocl20.semantics.bridge.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.TypedModel#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.TypedModel#getUsedPackage <em>Used Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getTypedModel()
 * @model
 * @generated
 */
public interface TypedModel extends NamedElement, SemanticsVisitable {
	/**
	 * Returns the value of the '<em><b>Depends On</b></em>' reference list.
	 * The list contents are of type {@link de.ikv.medini.qvt.model.qvtbase.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends On</em>' reference list.
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getTypedModel_DependsOn()
	 * @model type="de.ikv.medini.qvt.model.qvtbase.TypedModel"
	 * @generated
	 */
	EList getDependsOn();

	/**
	 * Returns the value of the '<em><b>Used Package</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.semantics.bridge.Namespace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Package</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Package</em>' reference list.
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getTypedModel_UsedPackage()
	 * @model type="org.oslo.ocl20.semantics.bridge.Namespace" required="true"
	 * @generated
	 */
	EList getUsedPackage();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((QvtVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // TypedModel
