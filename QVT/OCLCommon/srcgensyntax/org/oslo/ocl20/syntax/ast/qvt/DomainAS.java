/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.syntax.ast.Visitable;
import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.expressions.DotSelectionExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

import org.oslo.ocl20.syntax.ast.types.TypeAS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getExecutionKind <em>Execution Kind</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getModelId <em>Model Id</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getName <em>Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getImplementedBy <em>Implemented By</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getPropertyTemplates <em>Property Templates</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getType <em>Type</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getDomainAS()
 * @model
 * @generated
 */
public interface DomainAS extends GeneralDomainAS {
	/**
	 * Returns the value of the '<em><b>Execution Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.oslo.ocl20.syntax.ast.qvt.ExecutionKindAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Kind</em>' attribute.
	 * @see org.oslo.ocl20.syntax.ast.qvt.ExecutionKindAS
	 * @see #setExecutionKind(ExecutionKindAS)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getDomainAS_ExecutionKind()
	 * @model required="true"
	 * @generated
	 */
	ExecutionKindAS getExecutionKind();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getExecutionKind <em>Execution Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Kind</em>' attribute.
	 * @see org.oslo.ocl20.syntax.ast.qvt.ExecutionKindAS
	 * @see #getExecutionKind()
	 * @generated
	 */
	void setExecutionKind(ExecutionKindAS value);

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
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getDomainAS_ModelId()
	 * @model required="true"
	 * @generated
	 */
	String getModelId();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getModelId <em>Model Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Id</em>' attribute.
	 * @see #getModelId()
	 * @generated
	 */
	void setModelId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getDomainAS_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Implemented By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implemented By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implemented By</em>' reference.
	 * @see #setImplementedBy(DotSelectionExpAS)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getDomainAS_ImplementedBy()
	 * @model required="true"
	 * @generated
	 */
	DotSelectionExpAS getImplementedBy();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getImplementedBy <em>Implemented By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implemented By</em>' reference.
	 * @see #getImplementedBy()
	 * @generated
	 */
	void setImplementedBy(DotSelectionExpAS value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(TypeAS)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getDomainAS_Type()
	 * @model required="true"
	 * @generated
	 */
	TypeAS getType();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeAS value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' reference.
	 * @see #setBody(OclExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getDomainAS_Body()
	 * @model required="true"
	 * @generated
	 */
	OclExpressionAS getBody();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getBody <em>Body</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OclExpressionAS value);

	/**
	 * Returns the value of the '<em><b>Property Templates</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Templates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Templates</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getDomainAS_PropertyTemplates()
	 * @model type="org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS"
	 * @generated
	 */
	EList getPropertyTemplates();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // DomainAS
