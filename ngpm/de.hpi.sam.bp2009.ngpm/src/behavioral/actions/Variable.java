/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * As opposed to a Constant, a Variable can be used in an Assignment.
 * 
 * If a variable has no initExpression assigned, it's type needs to support a lower multiplicity of 0, and the value of the variable will be an empty multi-object.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.actions.Variable#getAssignments <em>Assignments</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.actions.ActionsPackage#getVariable()
 * @model annotation="http://de.hpi.sam.bp2009.OCL InitExpressionTypeMustMatchVariableType='self.initExpression->notEmpty() implies self.initExpression.getType().conformsTo(self.getType())'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='InitExpressionTypeMustMatchVariableType'"
 * @generated
 */
public interface Variable extends NamedValueWithOptionalInitExpression {
	/**
     * Returns the value of the '<em><b>Assignments</b></em>' reference list.
     * The list contents are of type {@link behavioral.actions.Assignment}.
     * It is bidirectional and its opposite is '{@link behavioral.actions.Assignment#getAssignTo <em>Assign To</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Assignments</em>' reference list.
     * @see behavioral.actions.ActionsPackage#getVariable_Assignments()
     * @see behavioral.actions.Assignment#getAssignTo
     * @model opposite="assignTo"
     * @generated
     */
	EList<Assignment> getAssignments();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
	void getCommonTypeOfAssignments();

} // Variable
