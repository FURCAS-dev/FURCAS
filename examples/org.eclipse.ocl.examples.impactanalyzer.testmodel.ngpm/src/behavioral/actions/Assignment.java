/**
 * <copyright>
 * </copyright>
 *
 * $Id: Assignment.java,v 1.1 2011/02/07 16:43:31 auhl Exp $
 */
package behavioral.actions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The argument tells the value to be assigned to the variable.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.actions.Assignment#getAssignTo <em>Assign To</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.actions.ActionsPackage#getAssignment()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL AssignmentCompatibility='self.argument.getType().conformsTo(self.assignTo.getType())' MustHaveArgument='self.argument->notEmpty()'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='AssignmentCompatibility MustHaveArgument'"
 * @generated
 */
public interface Assignment extends StatementWithArgument {
	/**
     * Returns the value of the '<em><b>Assign To</b></em>' reference.
     * It is bidirectional and its opposite is '{@link behavioral.actions.Variable#getAssignments <em>Assignments</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assign To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Assign To</em>' reference.
     * @see #setAssignTo(Variable)
     * @see behavioral.actions.ActionsPackage#getAssignment_AssignTo()
     * @see behavioral.actions.Variable#getAssignments
     * @model opposite="assignments" required="true"
     * @generated
     */
	Variable getAssignTo();

	/**
     * Sets the value of the '{@link behavioral.actions.Assignment#getAssignTo <em>Assign To</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Assign To</em>' reference.
     * @see #getAssignTo()
     * @generated
     */
	void setAssignTo(Variable value);

} // Assignment
