/**
 * <copyright>
 * </copyright>
 *
 * $Id: Constraint.java,v 1.1 2011/02/07 16:49:10 auhl Exp $
 */
package data.constraints;

import data.classes.Context;
import data.classes.SapClass;

import dataaccess.expressions.Expression;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An instance of this class defines a subset of the instances of the type it constains. It does so by providing a predicate ("characteristic function"). Instances of the type constrained for which the predicate holds are part of the subset, the others are not.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.constraints.Constraint#getTheContext <em>The Context</em>}</li>
 *   <li>{@link data.constraints.Constraint#getConstrainedType <em>Constrained Type</em>}</li>
 *   <li>{@link data.constraints.Constraint#getSeverityInState <em>Severity In State</em>}</li>
 *   <li>{@link data.constraints.Constraint#getConstraintExpression <em>Constraint Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.constraints.ConstraintsPackage#getConstraint()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ExpressionTypeMustBeBoolean='self.constraintExpression.getType().upperMultiplicity = 1 and\r\n  self.constraintExpression.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n  self.constraintExpression.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name = \'Boolean\'' MustBeOwned='self.constrainedType->notEmpty() or\r\n  self.theContext->notEmpty() or\r\n  self.preconditionForSignature->notEmpty() or\r\n  self.postconditionForSignature->notEmpty()'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ExpressionTypeMustBeBoolean MustBeOwned'"
 * @generated
 */
public interface Constraint extends NamedElement {
	/**
     * Returns the value of the '<em><b>The Context</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.Context#getConstraints <em>Constraints</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>The Context</em>' container reference.
     * @see #setTheContext(Context)
     * @see data.constraints.ConstraintsPackage#getConstraint_TheContext()
     * @see data.classes.Context#getConstraints
     * @model opposite="constraints"
     * @generated
     */
	Context getTheContext();

	/**
     * Sets the value of the '{@link data.constraints.Constraint#getTheContext <em>The Context</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>The Context</em>' container reference.
     * @see #getTheContext()
     * @generated
     */
	void setTheContext(Context value);

	/**
     * Returns the value of the '<em><b>Constrained Type</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getConstraints <em>Constraints</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Constrained Type</em>' container reference.
     * @see #setConstrainedType(SapClass)
     * @see data.constraints.ConstraintsPackage#getConstraint_ConstrainedType()
     * @see data.classes.SapClass#getConstraints
     * @model opposite="constraints"
     * @generated
     */
	SapClass getConstrainedType();

	/**
     * Sets the value of the '{@link data.constraints.Constraint#getConstrainedType <em>Constrained Type</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Constrained Type</em>' container reference.
     * @see #getConstrainedType()
     * @generated
     */
	void setConstrainedType(SapClass value);

	/**
     * Returns the value of the '<em><b>Severity In State</b></em>' containment reference list.
     * The list contents are of type {@link data.constraints.SeverityInState}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity In State</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Severity In State</em>' containment reference list.
     * @see data.constraints.ConstraintsPackage#getConstraint_SeverityInState()
     * @model containment="true" resolveProxies="true" required="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='constraint'"
     * @generated
     */
	EList<SeverityInState> getSeverityInState();

	/**
     * Returns the value of the '<em><b>Constraint Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Constraint Expression</em>' containment reference.
     * @see #setConstraintExpression(Expression)
     * @see data.constraints.ConstraintsPackage#getConstraint_ConstraintExpression()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Expression getConstraintExpression();

	/**
     * Sets the value of the '{@link data.constraints.Constraint#getConstraintExpression <em>Constraint Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Constraint Expression</em>' containment reference.
     * @see #getConstraintExpression()
     * @generated
     */
	void setConstraintExpression(Expression value);

} // Constraint
