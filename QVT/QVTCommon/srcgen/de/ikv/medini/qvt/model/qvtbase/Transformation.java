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
import org.oslo.ocl20.semantics.bridge.DefinedClass;
import org.oslo.ocl20.semantics.bridge.DefinedPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Transformation#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Transformation#getModelParameter <em>Model Parameter</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Transformation#getExtends <em>Extends</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Transformation#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getTransformation()
 * @model
 * @generated
 */
public interface Transformation extends DefinedClass, DefinedPackage {
	/**
	 * Returns the value of the '<em><b>Owned Tag</b></em>' containment reference list.
	 * The list contents are of type {@link org.oslo.ocl20.semantics.bridge.Tag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Tag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Tag</em>' containment reference list.
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getTransformation_OwnedTag()
	 * @model type="org.oslo.ocl20.semantics.bridge.Tag" containment="true"
	 * @generated
	 */
	EList getOwnedTag();

	/**
	 * Returns the value of the '<em><b>Model Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link de.ikv.medini.qvt.model.qvtbase.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Parameter</em>' containment reference list.
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getTransformation_ModelParameter()
	 * @model type="de.ikv.medini.qvt.model.qvtbase.TypedModel" containment="true"
	 * @generated
	 */
	EList getModelParameter();

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference.
	 * @see #setExtends(Transformation)
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getTransformation_Extends()
	 * @model
	 * @generated
	 */
	Transformation getExtends();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtbase.Transformation#getExtends <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' reference.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(Transformation value);

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' containment reference list.
	 * The list contents are of type {@link de.ikv.medini.qvt.model.qvtbase.Rule}.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvtbase.Rule#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' containment reference list.
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getTransformation_Rule()
	 * @see de.ikv.medini.qvt.model.qvtbase.Rule#getTransformation
	 * @model type="de.ikv.medini.qvt.model.qvtbase.Rule" opposite="transformation" containment="true"
	 * @generated
	 */
	EList getRule();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((QvtVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // Transformation
