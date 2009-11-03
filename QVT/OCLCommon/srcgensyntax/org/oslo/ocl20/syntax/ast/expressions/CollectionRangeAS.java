/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions;

import org.oslo.ocl20.syntax.ast.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Range AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.CollectionRangeAS#getLast <em>Last</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.CollectionRangeAS#getFirst <em>First</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getCollectionRangeAS()
 * @model
 * @generated
 */
public interface CollectionRangeAS extends CollectionLiteralPartAS{
	/**
	 * Returns the value of the '<em><b>First</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First</em>' reference.
	 * @see #setFirst(OclExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getCollectionRangeAS_First()
	 * @model
	 * @generated
	 */
	OclExpressionAS getFirst();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionRangeAS#getFirst <em>First</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First</em>' reference.
	 * @see #getFirst()
	 * @generated
	 */
	void setFirst(OclExpressionAS value);

	/**
	 * Returns the value of the '<em><b>Last</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last</em>' reference.
	 * @see #setLast(OclExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getCollectionRangeAS_Last()
	 * @model
	 * @generated
	 */
	OclExpressionAS getLast();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionRangeAS#getLast <em>Last</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last</em>' reference.
	 * @see #getLast()
	 * @generated
	 */
	void setLast(OclExpressionAS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // CollectionRangeAS
