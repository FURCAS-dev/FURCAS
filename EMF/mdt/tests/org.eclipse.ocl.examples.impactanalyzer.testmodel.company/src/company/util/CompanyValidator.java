/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompanyValidator.java,v 1.1 2011/01/20 15:52:51 auhl Exp $
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
            case CompanyPackage.COMPANY:
                return validateCompany((Company)value, diagnostics, context);
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
        if (!validate_NoCircularContainment(employee, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(employee, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(employee, diagnostics, context);
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
     * The cached validation expression for the UniqueNames constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String EMPLOYEE__UNIQUE_NAMES__EEXPRESSION = "Employee.allInstances()->forAll(e | e <> self implies e.name <> self.name)";

    /**
     * Validates the UniqueNames constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEmployee_UniqueNames(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.EMPLOYEE,
                 employee,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "UniqueNames",
                 EMPLOYEE__UNIQUE_NAMES__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the BossIsOldest constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String EMPLOYEE__BOSS_IS_OLDEST__EEXPRESSION = "self.age <= self.employer.boss.age";

    /**
     * Validates the BossIsOldest constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEmployee_BossIsOldest(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.EMPLOYEE,
                 employee,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "BossIsOldest",
                 EMPLOYEE__BOSS_IS_OLDEST__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the divBossSecretary constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String EMPLOYEE__DIV_BOSS_SECRETARY__EEXPRESSION = "if self.directed->isEmpty() then\r\n" +
        "self.secretary.oclIsUndefined()\r\n" +
        "else\r\n" +
        "not self.secretary.oclIsUndefined()\r\n" +
        "endif";

    /**
     * Validates the divBossSecretary constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEmployee_divBossSecretary(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.EMPLOYEE,
                 employee,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "divBossSecretary",
                 EMPLOYEE__DIV_BOSS_SECRETARY__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the secretaryOlderThanBoss constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String EMPLOYEE__SECRETARY_OLDER_THAN_BOSS__EEXPRESSION = "if self.directed->notEmpty() and\r\n" +
        "not self.secretary.oclIsUndefined() then\r\n" +
        "self.age < self.secretary.age \r\n" +
        "else true\r\n" +
        "endif";

    /**
     * Validates the secretaryOlderThanBoss constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEmployee_secretaryOlderThanBoss(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.EMPLOYEE,
                 employee,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "secretaryOlderThanBoss",
                 EMPLOYEE__SECRETARY_OLDER_THAN_BOSS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the Boss10YearsOlderThanEmployee constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String EMPLOYEE__BOSS10_YEARS_OLDER_THAN_EMPLOYEE__EEXPRESSION = "self.age + 10 <= self.employer.boss.age";

    /**
     * Validates the Boss10YearsOlderThanEmployee constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEmployee_Boss10YearsOlderThanEmployee(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.EMPLOYEE,
                 employee,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "Boss10YearsOlderThanEmployee",
                 EMPLOYEE__BOSS10_YEARS_OLDER_THAN_EMPLOYEE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the Secretary10YearsOlderThanBoss constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String EMPLOYEE__SECRETARY10_YEARS_OLDER_THAN_BOSS__EEXPRESSION = "if self.directed->notEmpty() and\r\n" +
        "not self.secretary.oclIsUndefined() then\r\n" +
        "self.age + 10 < self.secretary.age \r\n" +
        "else true\r\n" +
        "endif";

    /**
     * Validates the Secretary10YearsOlderThanBoss constraint of '<em>Employee</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEmployee_Secretary10YearsOlderThanBoss(Employee employee, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.EMPLOYEE,
                 employee,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "Secretary10YearsOlderThanBoss",
                 EMPLOYEE__SECRETARY10_YEARS_OLDER_THAN_BOSS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(department, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(department, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(department, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(department, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(department, diagnostics, context);
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
     * The cached validation expression for the NotBossFreelance constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String DEPARTMENT__NOT_BOSS_FREELANCE__EEXPRESSION = "not (self.boss.oclIsTypeOf(Freelance))";

    /**
     * Validates the NotBossFreelance constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_NotBossFreelance(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.DEPARTMENT,
                 department,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "NotBossFreelance",
                 DEPARTMENT__NOT_BOSS_FREELANCE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the OldEmployee constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String DEPARTMENT__OLD_EMPLOYEE__EEXPRESSION = "self.employee->exists(e | e.age > 45)";

    /**
     * Validates the OldEmployee constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_OldEmployee(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.DEPARTMENT,
                 department,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "OldEmployee",
                 DEPARTMENT__OLD_EMPLOYEE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the MaxJuniors constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String DEPARTMENT__MAX_JUNIORS__EEXPRESSION = "self.employee->select(e|e.age < 25)->size()\r\n" +
        "<self.maxJuniors";

    /**
     * Validates the MaxJuniors constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_MaxJuniors(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.DEPARTMENT,
                 department,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "MaxJuniors",
                 DEPARTMENT__MAX_JUNIORS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the BossHighestSalary constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String DEPARTMENT__BOSS_HIGHEST_SALARY__EEXPRESSION = "self.employee->select(e|e.salary >= self.boss.salary)->size() <= 1";

    /**
     * Validates the BossHighestSalary constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_BossHighestSalary(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.DEPARTMENT,
                 department,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "BossHighestSalary",
                 DEPARTMENT__BOSS_HIGHEST_SALARY__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the boss10YearsOlderThanJunior constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String DEPARTMENT__BOSS10_YEARS_OLDER_THAN_JUNIOR__EEXPRESSION = "let t:Tuple(boss:Employee,junior:Employee)=\r\n" +
        "Tuple{boss=self.boss, junior=self.employee->sortedBy(age)->first()} in\r\n" +
        "t.boss.age > t.junior.age + 10";

    /**
     * Validates the boss10YearsOlderThanJunior constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_boss10YearsOlderThanJunior(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.DEPARTMENT,
                 department,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "boss10YearsOlderThanJunior",
                 DEPARTMENT__BOSS10_YEARS_OLDER_THAN_JUNIOR__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the BudgetRestriction constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String DEPARTMENT__BUDGET_RESTRICTION__EEXPRESSION = "self.calcExpenses() <= self.budget";

    /**
     * Validates the BudgetRestriction constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_BudgetRestriction(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.DEPARTMENT,
                 department,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "BudgetRestriction",
                 DEPARTMENT__BUDGET_RESTRICTION__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the MaxJuniorsWarning constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String DEPARTMENT__MAX_JUNIORS_WARNING__EEXPRESSION = "if self.maxJuniors > 1\r\n" +
        "then\r\n" +
        "self.employee->select(e|e.age < 25)->size()\r\n" +
        "<self.maxJuniors - 1\r\n" +
        "else\r\n" +
        "true\r\n" +
        "endif";

    /**
     * Validates the MaxJuniorsWarning constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_MaxJuniorsWarning(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.DEPARTMENT,
                 department,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "MaxJuniorsWarning",
                 DEPARTMENT__MAX_JUNIORS_WARNING__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the departmentMustHaveDivision constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String DEPARTMENT__DEPARTMENT_MUST_HAVE_DIVISION__EEXPRESSION = "self.department2division->notEmpty()";

    /**
     * Validates the departmentMustHaveDivision constraint of '<em>Department</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDepartment_departmentMustHaveDivision(Department department, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.DEPARTMENT,
                 department,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "departmentMustHaveDivision",
                 DEPARTMENT__DEPARTMENT_MUST_HAVE_DIVISION__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFreelance(Freelance freelance, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(freelance, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(freelance, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(freelance, diagnostics, context);
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
     * The cached validation expression for the ValidAssignment constraint of '<em>Freelance</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String FREELANCE__VALID_ASSIGNMENT__EEXPRESSION = "self.assignment >= 5 and self.assignment <= 30";

    /**
     * Validates the ValidAssignment constraint of '<em>Freelance</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFreelance_ValidAssignment(Freelance freelance, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.FREELANCE,
                 freelance,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ValidAssignment",
                 FREELANCE__VALID_ASSIGNMENT__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the ValidAssignmentWarning constraint of '<em>Freelance</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String FREELANCE__VALID_ASSIGNMENT_WARNING__EEXPRESSION = "self.assignment >= 5 and self.assignment <= 40";

    /**
     * Validates the ValidAssignmentWarning constraint of '<em>Freelance</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFreelance_ValidAssignmentWarning(Freelance freelance, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.FREELANCE,
                 freelance,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ValidAssignmentWarning",
                 FREELANCE__VALID_ASSIGNMENT_WARNING__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the StudentAndFreelancesAge constraint of '<em>Freelance</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String FREELANCE__STUDENT_AND_FREELANCES_AGE__EEXPRESSION = "self.age < 40";

    /**
     * Validates the StudentAndFreelancesAge constraint of '<em>Freelance</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFreelance_StudentAndFreelancesAge(Freelance freelance, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.FREELANCE,
                 freelance,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "StudentAndFreelancesAge",
                 FREELANCE__STUDENT_AND_FREELANCES_AGE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDivision(Division division, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(division, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(division, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(division, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(division, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(division, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(division, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(division, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(division, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(division, diagnostics, context);
        if (result || diagnostics != null) result &= validateDivision_nasty(division, diagnostics, context);
        if (result || diagnostics != null) result &= validateDivision_limitEmployeesOfTheMonth(division, diagnostics, context);
        if (result || diagnostics != null) result &= validateDivision_nestedDerivation(division, diagnostics, context);
        return result;
    }

    /**
     * The cached validation expression for the nasty constraint of '<em>Division</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String DIVISION__NASTY__EEXPRESSION = "self.department->collect(d| \r\n" +
        "d.employee->including(d.boss)).salary->sum() < budget";

    /**
     * Validates the nasty constraint of '<em>Division</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDivision_nasty(Division division, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.DIVISION,
                 division,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "nasty",
                 DIVISION__NASTY__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the limitEmployeesOfTheMonth constraint of '<em>Division</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String DIVISION__LIMIT_EMPLOYEES_OF_THE_MONTH__EEXPRESSION = "self.employeesOfTheMonth->size() <= self.department->size()";

    /**
     * Validates the limitEmployeesOfTheMonth constraint of '<em>Division</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDivision_limitEmployeesOfTheMonth(Division division, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.DIVISION,
                 division,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "limitEmployeesOfTheMonth",
                 DIVISION__LIMIT_EMPLOYEES_OF_THE_MONTH__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * The cached validation expression for the nestedDerivation constraint of '<em>Division</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String DIVISION__NESTED_DERIVATION__EEXPRESSION = "self.numberEmployeesOfTheMonth <= self.department->size()";

    /**
     * Validates the nestedDerivation constraint of '<em>Division</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDivision_nestedDerivation(Division division, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.DIVISION,
                 division,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "nestedDerivation",
                 DIVISION__NESTED_DERIVATION__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateStudent(Student student, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(student, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(student, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(student, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(student, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(student, diagnostics, context);
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
     * The cached validation expression for the StudentAndFreelancesAge constraint of '<em>Student</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String STUDENT__STUDENT_AND_FREELANCES_AGE__EEXPRESSION = "self.age < 40";

    /**
     * Validates the StudentAndFreelancesAge constraint of '<em>Student</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateStudent_StudentAndFreelancesAge(Student student, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.STUDENT,
                 student,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "StudentAndFreelancesAge",
                 STUDENT__STUDENT_AND_FREELANCES_AGE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCompany(Company company, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(company, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(company, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(company, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(company, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(company, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(company, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(company, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(company, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(company, diagnostics, context);
        if (result || diagnostics != null) result &= validateCompany_eotmDeltaMax(company, diagnostics, context);
        return result;
    }

    /**
     * The cached validation expression for the eotmDeltaMax constraint of '<em>Company</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String COMPANY__EOTM_DELTA_MAX__EEXPRESSION = "self.eotmDelta <= 5";

    /**
     * Validates the eotmDeltaMax constraint of '<em>Company</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCompany_eotmDeltaMax(Company company, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (CompanyPackage.Literals.COMPANY,
                 company,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "eotmDeltaMax",
                 COMPANY__EOTM_DELTA_MAX__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
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
