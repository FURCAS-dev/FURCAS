/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelmanagementValidator.java,v 1.1 2011/02/07 16:57:59 auhl Exp $
 */
package modelmanagement.util;

import java.util.Map;

import modelmanagement.Application;
import modelmanagement.ModelmanagementPackage;
import modelmanagement.Module;
import modelmanagement.NamedElement;
import modelmanagement.PackageOwner;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see modelmanagement.ModelmanagementPackage
 * @generated
 */
public class ModelmanagementValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final ModelmanagementValidator INSTANCE = new ModelmanagementValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "modelmanagement";

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
	public ModelmanagementValidator() {
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
      return ModelmanagementPackage.eINSTANCE;
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
            case ModelmanagementPackage.PACKAGE:
                return validatePackage((modelmanagement.Package)value, diagnostics, context);
            case ModelmanagementPackage.NAMED_ELEMENT:
                return validateNamedElement((NamedElement)value, diagnostics, context);
            case ModelmanagementPackage.APPLICATION:
                return validateApplication((Application)value, diagnostics, context);
            case ModelmanagementPackage.PACKAGE_OWNER:
                return validatePackageOwner((PackageOwner)value, diagnostics, context);
            case ModelmanagementPackage.MODULE:
                return validateModule((Module)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePackage(modelmanagement.Package package_, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(package_, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(package_, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(package_, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(package_, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(package_, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(package_, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(package_, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(package_, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(package_, diagnostics, context);
        if (result || diagnostics != null) result &= validatePackage_DistinctClassNamesPerPackage(package_, diagnostics, context);
        if (result || diagnostics != null) result &= validatePackage_NoCyclicOwnership(package_, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the DistinctClassNamesPerPackage constraint of '<em>Package</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String PACKAGE__DISTINCT_CLASS_NAMES_PER_PACKAGE__EEXPRESSION = "self.classes->forAll( i, j | i <> j implies i.name <> j.name )";

	/**
     * Validates the DistinctClassNamesPerPackage constraint of '<em>Package</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePackage_DistinctClassNamesPerPackage(modelmanagement.Package package_, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ModelmanagementPackage.Literals.PACKAGE,
                 package_,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "DistinctClassNamesPerPackage",
                 PACKAGE__DISTINCT_CLASS_NAMES_PER_PACKAGE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the NoCyclicOwnership constraint of '<em>Package</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String PACKAGE__NO_CYCLIC_OWNERSHIP__EEXPRESSION = "not self.hasOwnershipCycle(Set{})";

	/**
     * Validates the NoCyclicOwnership constraint of '<em>Package</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePackage_NoCyclicOwnership(modelmanagement.Package package_, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ModelmanagementPackage.Literals.PACKAGE,
                 package_,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "NoCyclicOwnership",
                 PACKAGE__NO_CYCLIC_OWNERSHIP__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateNamedElement(NamedElement namedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(namedElement, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateApplication(Application application, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(application, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validatePackageOwner(PackageOwner packageOwner, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(packageOwner, diagnostics, context);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateModule(Module module, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(module, diagnostics, context);
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

} //ModelmanagementValidator
