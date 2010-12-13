/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions;

import data.classes.SapClass;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Creation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.ObjectCreationExpression#getClassToInstantiate <em>Class To Instantiate</em>}</li>
 *   <li>{@link dataaccess.expressions.ObjectCreationExpression#getInitializers <em>Initializers</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.ExpressionsPackage#getObjectCreationExpression()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL CannotInstantiateAbstractClass='not self.classToInstantiate.isAbstract()' ExpressionType='self.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n  self.getType().oclAsType(data::classes::ClassTypeDefinition).clazz = self.classToInstantiate and\r\n  self.getType().lowerMultiplicity = 1 and\r\n  self.getType().upperMultiplicity = 1' HasToOwnTypeDefinition='self.ownedTypeDefinition->notEmpty()' CannotInstantiateValueClass='not self.classToInstantiate.valueType' NoDuplicateInitializers='self.initializers->forAll( a, b | a <> b implies a.methodSignature <> b.methodSignature )'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='CannotInstantiateAbstractClass ExpressionType HasToOwnTypeDefinition CannotInstantiateValueClass NoDuplicateInitializers'"
 * @generated
 */
public interface ObjectCreationExpression extends Expression {
	/**
     * Returns the value of the '<em><b>Class To Instantiate</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class To Instantiate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Class To Instantiate</em>' reference.
     * @see #setClassToInstantiate(SapClass)
     * @see dataaccess.expressions.ExpressionsPackage#getObjectCreationExpression_ClassToInstantiate()
     * @model required="true"
     * @generated
     */
	SapClass getClassToInstantiate();

	/**
     * Sets the value of the '{@link dataaccess.expressions.ObjectCreationExpression#getClassToInstantiate <em>Class To Instantiate</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Class To Instantiate</em>' reference.
     * @see #getClassToInstantiate()
     * @generated
     */
	void setClassToInstantiate(SapClass value);

	/**
     * Returns the value of the '<em><b>Initializers</b></em>' containment reference list.
     * The list contents are of type {@link dataaccess.expressions.MethodCallExpression}.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.MethodCallExpression#getCreationExpression <em>Creation Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initializers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Initializers</em>' containment reference list.
     * @see dataaccess.expressions.ExpressionsPackage#getObjectCreationExpression_Initializers()
     * @see dataaccess.expressions.MethodCallExpression#getCreationExpression
     * @model opposite="creationExpression" containment="true" resolveProxies="true"
     * @generated
     */
	EList<MethodCallExpression> getInitializers();

} // ObjectCreationExpression
