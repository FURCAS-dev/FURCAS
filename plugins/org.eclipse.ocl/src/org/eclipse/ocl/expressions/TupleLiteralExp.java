/**
 * <copyright>
 * </copyright>
 *
 * $Id: TupleLiteralExp.java,v 1.1 2007/01/25 18:24:32 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.TupleLiteralExp#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getTupleLiteralExp()
 * @model
 * @generated
 */
public interface TupleLiteralExp<C, P> extends LiteralExp<C> {
	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.expressions.TupleLiteralPart<C, P>}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference list.
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getTupleLiteralExp_Part()
	 * @model type="org.eclipse.ocl.expressions.TupleLiteralPart" containment="true"
	 * @generated
	 */
	EList<TupleLiteralPart<C, P>> getPart();

} // TupleLiteralExp
