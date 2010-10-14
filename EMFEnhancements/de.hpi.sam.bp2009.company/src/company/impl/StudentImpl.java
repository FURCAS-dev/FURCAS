/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company.impl;

import org.eclipse.emf.ecore.EClass;

import company.CompanyPackage;
import company.Student;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Student</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StudentImpl extends EmployeeImpl implements Student {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected StudentImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompanyPackage.Literals.STUDENT;
    }

} //StudentImpl
