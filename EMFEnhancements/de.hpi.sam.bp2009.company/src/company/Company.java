/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link company.Company#getDivision <em>Division</em>}</li>
 *   <li>{@link company.Company#getEotmDelta <em>Eotm Delta</em>}</li>
 * </ul>
 * </p>
 *
 * @see company.CompanyPackage#getCompany()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL eotmDeltaMax='self.eotmDelta <= 5'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eotmDeltaMax'"
 * @generated
 */
public interface Company extends EObject {
    /**
     * Returns the value of the '<em><b>Division</b></em>' reference.
     * It is bidirectional and its opposite is '{@link company.Division#getCompany <em>Company</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Division</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Division</em>' reference.
     * @see #setDivision(Division)
     * @see company.CompanyPackage#getCompany_Division()
     * @see company.Division#getCompany
     * @model opposite="company"
     * @generated
     */
    Division getDivision();

    /**
     * Sets the value of the '{@link company.Company#getDivision <em>Division</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Division</em>' reference.
     * @see #getDivision()
     * @generated
     */
    void setDivision(Division value);

    /**
     * Returns the value of the '<em><b>Eotm Delta</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Eotm Delta</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Eotm Delta</em>' attribute.
     * @see company.CompanyPackage#getCompany_EotmDelta()
     * @model dataType="primitivetypes.Integer" transient="true" changeable="false" volatile="true" derived="true"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='let maxEOTMDivision:Division=self.division->sortedBy(i | i.numberEmployeesOfTheMonth)->last() in let minEOTMDivision:Division=self.division->sortedBy(i | i.numberEmployeesOfTheMonth)->first() in maxEOTMDivision.numberEmployeesOfTheMonth - minEOTMDivision.numberEmployeesOfTheMonth'"
     * @generated
     */
    int getEotmDelta();

} // Company
