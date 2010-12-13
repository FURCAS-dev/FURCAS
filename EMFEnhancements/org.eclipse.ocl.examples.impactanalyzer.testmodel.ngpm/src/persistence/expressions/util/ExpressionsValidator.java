/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package persistence.expressions.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import persistence.expressions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see persistence.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final ExpressionsValidator INSTANCE = new ExpressionsValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "persistence.expressions";

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
	public ExpressionsValidator() {
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
      return ExpressionsPackage.eINSTANCE;
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
            case ExpressionsPackage.ALL:
                return validateAll((All)value, diagnostics, context);
            case ExpressionsPackage.COMMIT:
                return validateCommit((Commit)value, diagnostics, context);
            case ExpressionsPackage.SNAPSHOT:
                return validateSnapshot((Snapshot)value, diagnostics, context);
            case ExpressionsPackage.SNAPSHOT_SELECTION:
                return validateSnapshotSelection((SnapshotSelection)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAll(All all, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(all, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(all, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(all, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(all, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(all, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(all, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(all, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(all, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(all, diagnostics, context);
        if (result || diagnostics != null) result &= validateAll_MustBeEntityClass(all, diagnostics, context);
        if (result || diagnostics != null) result &= validateAll_ExpressionMustBeSnapshotOrTimePoint(all, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the MustBeEntityClass constraint of '<em>All</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ALL__MUST_BE_ENTITY_CLASS__EEXPRESSION = "not self.ofClass.valueType";

	/**
     * Validates the MustBeEntityClass constraint of '<em>All</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAll_MustBeEntityClass(All all, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.ALL,
                 all,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "MustBeEntityClass",
                 ALL__MUST_BE_ENTITY_CLASS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the ExpressionMustBeSnapshotOrTimePoint constraint of '<em>All</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String ALL__EXPRESSION_MUST_BE_SNAPSHOT_OR_TIME_POINT__EEXPRESSION = "if self.snapshot = SnapshotSelection::SPECIFIED then\r\n" +
        "    self.snapshotIdentifier.getType().upperMultiplicity = 1 and\r\n" +
        "    self.snapshotIdentifier.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n" +
        "   Set{'Snapshot', 'TimePoint'}->includes(self.snapshotIdentifier.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name)\r\n" +
        "  else\r\n" +
        "    true\r\n" +
        "  endif";

	/**
     * Validates the ExpressionMustBeSnapshotOrTimePoint constraint of '<em>All</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateAll_ExpressionMustBeSnapshotOrTimePoint(All all, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.ALL,
                 all,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ExpressionMustBeSnapshotOrTimePoint",
                 ALL__EXPRESSION_MUST_BE_SNAPSHOT_OR_TIME_POINT__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCommit(Commit commit, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(commit, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(commit, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(commit, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(commit, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(commit, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(commit, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(commit, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(commit, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(commit, diagnostics, context);
        if (result || diagnostics != null) result &= validateCommit_ReturnsSnapshot(commit, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ReturnsSnapshot constraint of '<em>Commit</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String COMMIT__RETURNS_SNAPSHOT__EEXPRESSION = "self.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n" +
        "  self.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name = 'Snapshot'";

	/**
     * Validates the ReturnsSnapshot constraint of '<em>Commit</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCommit_ReturnsSnapshot(Commit commit, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.COMMIT,
                 commit,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ReturnsSnapshot",
                 COMMIT__RETURNS_SNAPSHOT__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSnapshot(Snapshot snapshot, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(snapshot, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(snapshot, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(snapshot, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(snapshot, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(snapshot, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(snapshot, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(snapshot, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(snapshot, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(snapshot, diagnostics, context);
        if (result || diagnostics != null) result &= validateSnapshot_SourceObjectIsOfClassType(snapshot, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the SourceObjectIsOfClassType constraint of '<em>Snapshot</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String SNAPSHOT__SOURCE_OBJECT_IS_OF_CLASS_TYPE__EEXPRESSION = "self.object.getType().oclIsKindOf(data::classes::ClassTypeDefinition)";

	/**
     * Validates the SourceObjectIsOfClassType constraint of '<em>Snapshot</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSnapshot_SourceObjectIsOfClassType(Snapshot snapshot, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ExpressionsPackage.Literals.SNAPSHOT,
                 snapshot,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "SourceObjectIsOfClassType",
                 SNAPSHOT__SOURCE_OBJECT_IS_OF_CLASS_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSnapshotSelection(SnapshotSelection snapshotSelection, DiagnosticChain diagnostics, Map<Object, Object> context) {
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

} //ExpressionsValidator
