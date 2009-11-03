/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.syntax.ast.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Literal Exp AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralExpAS#getKind <em>Kind</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralExpAS#getCollectionParts <em>Collection Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getCollectionLiteralExpAS()
 * @model
 * @generated
 */
public interface CollectionLiteralExpAS extends LiteralExpAS{
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS
	 * @see #setKind(CollectionKindAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getCollectionLiteralExpAS_Kind()
	 * @model required="true"
	 * @generated
	 */
	CollectionKindAS getKind();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralExpAS#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS
	 * @see #getKind()
	 * @generated
	 */
	void setKind(CollectionKindAS value);

	/**
	 * Returns the value of the '<em><b>Collection Parts</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralPartAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Parts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Parts</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getCollectionLiteralExpAS_CollectionParts()
	 * @model type="org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralPartAS"
	 * @generated
	 */
	EList getCollectionParts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // CollectionLiteralExpAS
