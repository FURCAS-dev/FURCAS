/**
 * <copyright>
 * </copyright>
 *
 * $Id: Ternary.java,v 1.1 2011/02/07 17:16:11 auhl Exp $
 */
package dataaccess.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ternary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.Ternary#getFalseExpr <em>False Expr</em>}</li>
 *   <li>{@link dataaccess.expressions.Ternary#getTrueExpr <em>True Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.ExpressionsPackage#getTernary()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL TrueAndFalseExprsConformToResultType='self.trueExpr.getType().conformsTo(self.getType()) or\r\n  self.falseExpr.getType().conformsTo(self.getType())'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='TrueAndFalseExprsConformToResultType'"
 * @generated
 */
public interface Ternary extends ConditionalExpression, Expression {
	/**
     * Returns the value of the '<em><b>False Expr</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>False Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>False Expr</em>' containment reference.
     * @see #setFalseExpr(Expression)
     * @see dataaccess.expressions.ExpressionsPackage#getTernary_FalseExpr()
     * @model containment="true" resolveProxies="true" required="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='falseOfTernary'"
     * @generated
     */
	Expression getFalseExpr();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Ternary#getFalseExpr <em>False Expr</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>False Expr</em>' containment reference.
     * @see #getFalseExpr()
     * @generated
     */
	void setFalseExpr(Expression value);

	/**
     * Returns the value of the '<em><b>True Expr</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>True Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>True Expr</em>' containment reference.
     * @see #setTrueExpr(Expression)
     * @see dataaccess.expressions.ExpressionsPackage#getTernary_TrueExpr()
     * @model containment="true" resolveProxies="true" required="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='trueOfTernary'"
     * @generated
     */
	Expression getTrueExpr();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Ternary#getTrueExpr <em>True Expr</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>True Expr</em>' containment reference.
     * @see #getTrueExpr()
     * @generated
     */
	void setTrueExpr(Expression value);

} // Ternary
