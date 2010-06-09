/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Freelance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link company.Freelance#getAssignment <em>Assignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see company.CompanyPackage#getFreelance()
 * @model annotation="http://de.hpi.sam.bp2009.OCL ValidAssignment='self.assignment >= 5 and self.assignment <= 30' ValidAssignmentWarning='self.assignment >= 5 and self.assignment <= 40' StudentAndFreelancesAge='self.age < 40'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidAssignment ValidAssignmentWarning StudentAndFreelancesAge'"
 * @generated
 */
public interface Freelance extends Employee {
    /**
         * Returns the value of the '<em><b>Assignment</b></em>' attribute.
         * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Assignment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
         * @return the value of the '<em>Assignment</em>' attribute.
         * @see #setAssignment(long)
         * @see company.CompanyPackage#getFreelance_Assignment()
         * @model dataType="primitivetypes.Integer"
         * @generated
         */
    long getAssignment();

    /**
         * Sets the value of the '{@link company.Freelance#getAssignment <em>Assignment</em>}' attribute.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @param value the new value of the '<em>Assignment</em>' attribute.
         * @see #getAssignment()
         * @generated
         */
    void setAssignment(long value);

} // Freelance
