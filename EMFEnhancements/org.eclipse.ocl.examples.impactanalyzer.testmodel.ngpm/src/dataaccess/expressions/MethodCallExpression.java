/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions;

import data.classes.MethodSignature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Call Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The MethodCallExpression executes an implementation of the signature using the "parameters" expressions as arguments on the object evaluated by the "object" expression. For that, first the "object" expression is evaluated. the parameter expressions (if provided) are evaluated and then passed to the implementation.
 * 
 * The object expression must evaluate to a single value, i.e., a TypeDefinition with upperMultiplicity = 1.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.MethodCallExpression#isAsynchronous <em>Asynchronous</em>}</li>
 *   <li>{@link dataaccess.expressions.MethodCallExpression#getMethodSignature <em>Method Signature</em>}</li>
 *   <li>{@link dataaccess.expressions.MethodCallExpression#getCreationExpression <em>Creation Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.ExpressionsPackage#getMethodCallExpression()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ObjectMustSupportOperation='self.object.getType().getInnermost().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n  self.object.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.conformsTo(self.methodSignature.owner.oclAsType(data::classes::SapClass))' OutputMultiplicities='(self.object.getType().isMany() implies (self.getType().isMany() and not self.getType().unique)) and\r\n  (self.object.getType().lowerMultiplicity = 0 implies (self.getType()->isEmpty() or self.getType().lowerMultiplicity = 0))'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ObjectMustSupportOperation OutputMultiplicities'"
 * @generated
 */
public interface MethodCallExpression extends ObjectBasedExpression, SignatureCallExpression {
	/**
     * Returns the value of the '<em><b>Asynchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * An operation may be invoked asynchronously. If the operation returns a value, it is ignored, as are any exceptions raised by the operation. An OperationExpression with this attribute set to true has itself no type and therefore cannot reasonably be used in a side effect-free expression but only as a statement.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Asynchronous</em>' attribute.
     * @see #setAsynchronous(boolean)
     * @see dataaccess.expressions.ExpressionsPackage#getMethodCallExpression_Asynchronous()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isAsynchronous();

	/**
     * Sets the value of the '{@link dataaccess.expressions.MethodCallExpression#isAsynchronous <em>Asynchronous</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Asynchronous</em>' attribute.
     * @see #isAsynchronous()
     * @generated
     */
	void setAsynchronous(boolean value);

	/**
     * Returns the value of the '<em><b>Method Signature</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Signature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Method Signature</em>' reference.
     * @see #setMethodSignature(MethodSignature)
     * @see dataaccess.expressions.ExpressionsPackage#getMethodCallExpression_MethodSignature()
     * @model required="true"
     * @generated
     */
	MethodSignature getMethodSignature();

	/**
     * Sets the value of the '{@link dataaccess.expressions.MethodCallExpression#getMethodSignature <em>Method Signature</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Method Signature</em>' reference.
     * @see #getMethodSignature()
     * @generated
     */
	void setMethodSignature(MethodSignature value);

	/**
     * Returns the value of the '<em><b>Creation Expression</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.ObjectCreationExpression#getInitializers <em>Initializers</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Expression</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Creation Expression</em>' container reference.
     * @see #setCreationExpression(ObjectCreationExpression)
     * @see dataaccess.expressions.ExpressionsPackage#getMethodCallExpression_CreationExpression()
     * @see dataaccess.expressions.ObjectCreationExpression#getInitializers
     * @model opposite="initializers"
     * @generated
     */
	ObjectCreationExpression getCreationExpression();

	/**
     * Sets the value of the '{@link dataaccess.expressions.MethodCallExpression#getCreationExpression <em>Creation Expression</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Creation Expression</em>' container reference.
     * @see #getCreationExpression()
     * @generated
     */
	void setCreationExpression(ObjectCreationExpression value);

} // MethodCallExpression
