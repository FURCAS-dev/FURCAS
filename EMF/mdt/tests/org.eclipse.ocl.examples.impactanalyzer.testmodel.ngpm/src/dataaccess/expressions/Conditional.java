/**
 * <copyright>
 * </copyright>
 *
 * $Id: Conditional.java,v 1.1 2011/02/07 17:16:11 auhl Exp $
 */
package dataaccess.expressions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Some statement depending on a Boolean expression
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.Conditional#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.ExpressionsPackage#getConditional()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ConditionMustBeBoolean='self.condition.getType().upperMultiplicity = 1 and\r\n  self.condition.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n  self.condition.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name = \'Boolean\''"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ConditionMustBeBoolean'"
 * @generated
 */
public interface Conditional extends EObject {
	/**
     * Returns the value of the '<em><b>Condition</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getConditional <em>Conditional</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Condition</em>' containment reference.
     * @see #setCondition(Expression)
     * @see dataaccess.expressions.ExpressionsPackage#getConditional_Condition()
     * @see dataaccess.expressions.Expression#getConditional
     * @model opposite="conditional" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Expression getCondition();

	/**
     * Sets the value of the '{@link dataaccess.expressions.Conditional#getCondition <em>Condition</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Condition</em>' containment reference.
     * @see #getCondition()
     * @generated
     */
	void setCondition(Expression value);

} // Conditional
