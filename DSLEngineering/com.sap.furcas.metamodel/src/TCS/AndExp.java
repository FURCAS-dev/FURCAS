/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>And Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.AndExp#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getAndExp()
 * @model
 * @generated
 */
public interface AndExp extends Expression {
	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link TCS.AtomExp}.
	 * It is bidirectional and its opposite is '{@link TCS.AtomExp#getAndExp <em>And Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see TCS.TCSPackage#getAndExp_Expressions()
	 * @see TCS.AtomExp#getAndExp
	 * @model opposite="andExp" containment="true"
	 * @generated
	 */
	EList<AtomExp> getExpressions();

} // AndExp
