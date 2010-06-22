/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package company.util;

import company.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see company.CompanyPackage
 * @generated
 */
public class CompanyValidator extends EObjectValidator {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final CompanyValidator INSTANCE = new CompanyValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "company";

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompanyValidator() {
        super();
    }

    /**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EPackage getEPackage() {
      return CompanyPackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        switch (classifierID) {
            case CompanyPackage.EMPLOYEE:
                return validateEmployee((Employee)value, diagnostics, context);
            case CompanyPackage.DEPARTMENT:
                return validateDepartment((Department)value, diagnostics, context);
            case CompanyPackage.FREELANCE:
                return validateFreelance((Freelance)value, diagnostics, context);
            case CompanyPackage.DIVISION:
                return validateDivision((Division)value, diagnostics, context);
            case CompanyPackage.STUDENT:
                return validateStudent((Student)value, diagnostics, context);
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEmployee(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_UniqueNames(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_BossIsOldest(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_divBossSecretary(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_secretaryOlderThanBoss(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_Boss10YearsOlderThanEmployee(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_Secretary10YearsOlderThanBoss(employee, diagnostics, context);
        return result;
    }

    /**
     * Validates the UniqueNames constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEmployee_UniqueNames(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "UniqueNames", getObjectLabel(employee, context) },
                         new Object[] { employee },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the BossIsOldest constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEmployee_BossIsOldest(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "BossIsOldest", getObjectLabel(employee, context) },
                         new Object[] { employee },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the divBossSecretary constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEmployee_divBossSecretary(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "divBossSecretary", getObjectLabel(employee, context) },
                         new Object[] { employee },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the secretaryOlderThanBoss constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEmployee_secretaryOlderThanBoss(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "secretaryOlderThanBoss", getObjectLabel(employee, context) },
                         new Object[] { employee },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the Boss10YearsOlderThanEmployee constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEmployee_Boss10YearsOlderThanEmployee(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "Boss10YearsOlderThanEmployee", getObjectLabel(employee, context) },
                         new Object[] { employee },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the Secretary10YearsOlderThanBoss constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEmployee_Secretary10YearsOlderThanBoss(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "Secretary10YearsOlderThanBoss", getObjectLabel(employee, context) },
                         new Object[] { employee },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(department, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(department, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(department, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(department, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(department, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(department, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(department, diagnostics, context);
        if (result || diagnostics != null) result &= validateDepartment_NotBossFreelance(department, diagnostics, context);
        if (result || diagnostics != null) result &= validateDepartment_OldEmployee(department, diagnostics, context);
        if (result || diagnostics != null) result &= validateDepartment_MaxJuniors(department, diagnostics, context);
        if (result || diagnostics != null) result &= validateDepartment_BossHighestSalary(department, diagnostics, context);
        if (result || diagnostics != null) result &= validateDepartment_boss10YearsOlderThanJunior(department, diagnostics, context);
        if (result || diagnostics != null) result &= validateDepartment_BudgetRestriction(department, diagnostics, context);
        if (result || diagnostics != null) result &= validateDepartment_MaxJuniorsWarning(department, diagnostics, context);
        if (result || diagnostics != null) result &= validateDepartment_departmentMustHaveDivision(department, diagnostics, context);
        return result;
    }

    /**
     * Validates the NotBossFreelance constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_NotBossFreelance(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "NotBossFreelance", getObjectLabel(department, context) },
                         new Object[] { department },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the OldEmployee constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_OldEmployee(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "OldEmployee", getObjectLabel(department, context) },
                         new Object[] { department },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the MaxJuniors constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_MaxJuniors(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "MaxJuniors", getObjectLabel(department, context) },
                         new Object[] { department },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the BossHighestSalary constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_BossHighestSalary(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "BossHighestSalary", getObjectLabel(department, context) },
                         new Object[] { department },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the boss10YearsOlderThanJunior constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_boss10YearsOlderThanJunior(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "boss10YearsOlderThanJunior", getObjectLabel(department, context) },
                         new Object[] { department },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the BudgetRestriction constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_BudgetRestriction(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "BudgetRestriction", getObjectLabel(department, context) },
                         new Object[] { department },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the MaxJuniorsWarning constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_MaxJuniorsWarning(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "MaxJuniorsWarning", getObjectLabel(department, context) },
                         new Object[] { department },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the departmentMustHaveDivision constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_departmentMustHaveDivision(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "departmentMustHaveDivision", getObjectLabel(department, context) },
                         new Object[] { department },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFreelance(Freelance freelance, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_UniqueNames(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_BossIsOldest(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_divBossSecretary(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_secretaryOlderThanBoss(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_Boss10YearsOlderThanEmployee(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_Secretary10YearsOlderThanBoss(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validateFreelance_ValidAssignment(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validateFreelance_ValidAssignmentWarning(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validateFreelance_StudentAndFreelancesAge(freelance, diagnostics, context);
        return result;
    }

    /**
     * Validates the ValidAssignment constraint of '<em>Freelance</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFreelance_ValidAssignment(Freelance freelance, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "ValidAssignment", getObjectLabel(freelance, context) },
                         new Object[] { freelance },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the ValidAssignmentWarning constraint of '<em>Freelance</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFreelance_ValidAssignmentWarning(Freelance freelance, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "ValidAssignmentWarning", getObjectLabel(freelance, context) },
                         new Object[] { freelance },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the StudentAndFreelancesAge constraint of '<em>Freelance</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFreelance_StudentAndFreelancesAge(Freelance freelance, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "StudentAndFreelancesAge", getObjectLabel(freelance, context) },
                         new Object[] { freelance },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDivision(Division division, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(division, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(division, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(division, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(division, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(division, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(division, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(division, diagnostics, context);
        if (result || diagnostics != null) result &= validateDivision_nasty(division, diagnostics, context);
        return result;
    }

    /**
     * Validates the nasty constraint of '<em>Division</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDivision_nasty(Division division, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "nasty", getObjectLabel(division, context) },
                         new Object[] { division },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateStudent(Student student, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(student, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(student, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(student, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(student, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(student, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(student, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(student, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_UniqueNames(student, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_BossIsOldest(student, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_divBossSecretary(student, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_secretaryOlderThanBoss(student, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_Boss10YearsOlderThanEmployee(student, diagnostics, context);
        if (result || diagnostics != null) result &= validateEmployee_Secretary10YearsOlderThanBoss(student, diagnostics, context);
        if (result || diagnostics != null) result &= validateStudent_StudentAndFreelancesAge(student, diagnostics, context);
        return result;
    }

    /**
     * Validates the StudentAndFreelancesAge constraint of '<em>Student</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateStudent_StudentAndFreelancesAge(Student student, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (createDiagnostic
                        (Diagnostic.ERROR,
                         DIAGNOSTIC_SOURCE,
                         0,
                         "_UI_GenericConstraint_diagnostic",
                         new Object[] { "StudentAndFreelancesAge", getObjectLabel(student, context) },
                         new Object[] { student },
                         context));
            }
            return false;
        }
        return true;
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        // TODO
        // Specialize this to return a resource locator for messages specific to this validator.
        // Ensure that you remove @generated or mark it @generated NOT
        return super.getResourceLocator();
    }

} //CompanyValidator
