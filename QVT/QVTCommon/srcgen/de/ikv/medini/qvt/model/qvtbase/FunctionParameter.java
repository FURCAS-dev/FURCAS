/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtbase;

import org.oslo.ocl20.semantics.OclVisitor;
import de.ikv.medini.qvt.qvt.QvtVisitor;

import org.oslo.ocl20.semantics.bridge.Parameter;

import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getFunctionParameter()
 * @model
 * @generated
 */
public interface FunctionParameter extends Parameter, VariableDeclaration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // FunctionParameter
