/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt;

import java.util.List;

import org.oslo.ocl20.syntax.ast.Visitable;
import org.oslo.ocl20.syntax.ast.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Declaration AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS#getModelId <em>Model Id</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS#getMetaModelIds <em>Meta Model Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getModelDeclarationAS()
 * @model
 * @generated
 */
public interface ModelDeclarationAS extends Visitable{
	/**
	 * Returns the value of the '<em><b>Model Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Id</em>' attribute.
	 * @see #setModelId(String)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getModelDeclarationAS_ModelId()
	 * @model required="true"
	 * @generated
	 */
	String getModelId();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS#getModelId <em>Model Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Id</em>' attribute.
	 * @see #getModelId()
	 * @generated
	 */
	void setModelId(String value);

	/**
	 * Returns the value of the '<em><b>Meta Model Ids</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model Ids</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model Ids</em>' attribute.
	 * @see #setMetaModelIds(List)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getModelDeclarationAS_MetaModelIds()
	 * @model dataType="org.oslo.ocl20.syntax.ast.List" required="true" many="false"
	 * @generated
	 */
	List getMetaModelIds();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS#getMetaModelIds <em>Meta Model Ids</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Model Ids</em>' attribute.
	 * @see #getMetaModelIds()
	 * @generated
	 */
	void setMetaModelIds(List value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // ModelDeclarationAS
