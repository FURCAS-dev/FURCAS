/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt;

import org.oslo.ocl20.syntax.ast.Visitable;
import org.oslo.ocl20.syntax.ast.Visitor;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>General Domain AS</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getGeneralDomainAS()
 * @model abstract="true"
 * @generated
 */
public interface GeneralDomainAS extends Visitable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // GeneralDomainAS
