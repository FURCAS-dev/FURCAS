/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimedependencyValidator.java,v 1.1 2011/02/07 16:49:09 auhl Exp $
 */
package data.timedependency.util;

import data.timedependency.*;

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
 * @see data.timedependency.TimedependencyPackage
 * @generated
 */
public class TimedependencyValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final TimedependencyValidator INSTANCE = new TimedependencyValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "data.timedependency";

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
	public TimedependencyValidator() {
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
      return TimedependencyPackage.eINSTANCE;
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
            case TimedependencyPackage.TIME_DEPENDENCY:
                return validateTimeDependency((TimeDependency)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateTimeDependency(TimeDependency timeDependency, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(timeDependency, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(timeDependency, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(timeDependency, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(timeDependency, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(timeDependency, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(timeDependency, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(timeDependency, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(timeDependency, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(timeDependency, diagnostics, context);
        if (result || diagnostics != null) result &= validateTimeDependency_RecordCutoffGreaterOrEqualZero(timeDependency, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the RecordCutoffGreaterOrEqualZero constraint of '<em>Time Dependency</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String TIME_DEPENDENCY__RECORD_CUTOFF_GREATER_OR_EQUAL_ZERO__EEXPRESSION = "self.recordCutoffInMilliseconds >= 0";

	/**
     * Validates the RecordCutoffGreaterOrEqualZero constraint of '<em>Time Dependency</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateTimeDependency_RecordCutoffGreaterOrEqualZero(TimeDependency timeDependency, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (TimedependencyPackage.Literals.TIME_DEPENDENCY,
                 timeDependency,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "RecordCutoffGreaterOrEqualZero",
                 TIME_DEPENDENCY__RECORD_CUTOFF_GREATER_OR_EQUAL_ZERO__EEXPRESSION,
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

} //TimedependencyValidator
