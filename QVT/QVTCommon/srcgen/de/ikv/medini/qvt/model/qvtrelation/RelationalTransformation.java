/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtrelation;

import de.ikv.medini.qvt.model.qvtbase.Transformation;

import de.ikv.medini.qvt.qvt.QvtVisitor;

import org.eclipse.emf.common.util.EList;
import org.oslo.ocl20.semantics.OclVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.RelationalTransformation#getOwnedKey <em>Owned Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelationalTransformation()
 * @model
 * @generated
 */
public interface RelationalTransformation extends Transformation {
	/**
	 * Returns the value of the '<em><b>Owned Key</b></em>' containment reference list.
	 * The list contents are of type {@link de.ikv.medini.qvt.model.qvtrelation.Key}.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvtrelation.Key#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Key</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Key</em>' containment reference list.
	 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelationalTransformation_OwnedKey()
	 * @see de.ikv.medini.qvt.model.qvtrelation.Key#getTransformation
	 * @model type="de.ikv.medini.qvt.model.qvtrelation.Key" opposite="transformation" containment="true"
	 * @generated
	 */
	EList getOwnedKey();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((QvtVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // RelationalTransformation
