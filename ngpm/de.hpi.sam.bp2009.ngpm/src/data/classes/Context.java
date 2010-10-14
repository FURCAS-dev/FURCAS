/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import data.constraints.Constraint;

import dataaccess.expressions.Expression;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An instance of a class can occur in a number of contexts. Each context has a characteristic condition that an object has to fulfill in order to "be in that context."
 * 
 * A context can specify constraints, additional events that the object may raise, or preconditions for operations of the object's class.
 * 
 * (Currently, the metamodel only describes context-based constraints; events and preconditions may have to be added later.)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.Context#getFor_ <em>For </em>}</li>
 *   <li>{@link data.classes.Context#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link data.classes.Context#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getContext()
 * @model annotation="http://de.hpi.sam.bp2009.OCL ConditionMustBeBoolean='self.condition.getType().upperMultiplicity = 1 and\r\n  self.condition.getType().oclIsKindOf(ClassTypeDefinition) and\r\n  self.condition.getType().oclAsType(ClassTypeDefinition).clazz.name = \'Boolean\'' ConstraintForRightClass='self.constraints->forAll(c | c.constrainedType = self.for_)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ConditionMustBeBoolean ConstraintForRightClass'"
 * @generated
 */
public interface Context extends NamedElement {
	/**
     * Returns the value of the '<em><b>For </b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For </em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>For </em>' reference.
     * @see #setFor_(SapClass)
     * @see data.classes.ClassesPackage#getContext_For_()
     * @model required="true"
     * @generated
     */
	SapClass getFor_();

	/**
     * Sets the value of the '{@link data.classes.Context#getFor_ <em>For </em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>For </em>' reference.
     * @see #getFor_()
     * @generated
     */
	void setFor_(SapClass value);

	/**
     * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
     * The list contents are of type {@link data.constraints.Constraint}.
     * It is bidirectional and its opposite is '{@link data.constraints.Constraint#getTheContext <em>The Context</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Constraints</em>' containment reference list.
     * @see data.classes.ClassesPackage#getContext_Constraints()
     * @see data.constraints.Constraint#getTheContext
     * @model opposite="theContext" containment="true" resolveProxies="true"
     * @generated
     */
	EList<Constraint> getConstraints();

	/**
     * Returns the value of the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Condition</em>' containment reference.
     * @see #setCondition(Expression)
     * @see data.classes.ClassesPackage#getContext_Condition()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Expression getCondition();

	/**
     * Sets the value of the '{@link data.classes.Context#getCondition <em>Condition</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Condition</em>' containment reference.
     * @see #getCondition()
     * @generated
     */
	void setCondition(Expression value);

} // Context
