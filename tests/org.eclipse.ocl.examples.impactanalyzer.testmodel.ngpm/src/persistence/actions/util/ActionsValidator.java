/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActionsValidator.java,v 1.1 2011/02/07 17:21:37 auhl Exp $
 */
package persistence.actions.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import persistence.actions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see persistence.actions.ActionsPackage
 * @generated
 */
public class ActionsValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final ActionsValidator INSTANCE = new ActionsValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "persistence.actions";

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
	public ActionsValidator() {
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
      return ActionsPackage.eINSTANCE;
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
            case ActionsPackage.STORE:
                return validateStore((Store)value, diagnostics, context);
            case ActionsPackage.DELETE:
                return validateDelete((Delete)value, diagnostics, context);
            case ActionsPackage.STATEMENT_WITH_ENTITY_ARGUMENT:
                return validateStatementWithEntityArgument((StatementWithEntityArgument)value, diagnostics, context);
            case ActionsPackage.ROLLBACK:
                return validateRollback((Rollback)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateStore(Store store, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(store, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(store, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(store, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(store, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(store, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(store, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(store, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(store, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(store, diagnostics, context);
        if (result || diagnostics != null) result &= validateStatementWithEntityArgument_CanStoreOnlyEntities(store, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateDelete(Delete delete, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(delete, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(delete, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(delete, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(delete, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(delete, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(delete, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(delete, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(delete, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(delete, diagnostics, context);
        if (result || diagnostics != null) result &= validateStatementWithEntityArgument_CanStoreOnlyEntities(delete, diagnostics, context);
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateStatementWithEntityArgument(StatementWithEntityArgument statementWithEntityArgument, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(statementWithEntityArgument, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(statementWithEntityArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(statementWithEntityArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(statementWithEntityArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(statementWithEntityArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(statementWithEntityArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(statementWithEntityArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(statementWithEntityArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(statementWithEntityArgument, diagnostics, context);
        if (result || diagnostics != null) result &= validateStatementWithEntityArgument_CanStoreOnlyEntities(statementWithEntityArgument, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the CanStoreOnlyEntities constraint of '<em>Statement With Entity Argument</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String STATEMENT_WITH_ENTITY_ARGUMENT__CAN_STORE_ONLY_ENTITIES__EEXPRESSION = "if self.argument.getType().oclIsKindOf(data::classes::ClassTypeDefinition) then\r\n" +
        "    not self.argument.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.valueType\r\n" +
        "  else\r\n" +
        "    false\r\n" +
        "  endif";

	/**
     * Validates the CanStoreOnlyEntities constraint of '<em>Statement With Entity Argument</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateStatementWithEntityArgument_CanStoreOnlyEntities(StatementWithEntityArgument statementWithEntityArgument, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (ActionsPackage.Literals.STATEMENT_WITH_ENTITY_ARGUMENT,
                 statementWithEntityArgument,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "CanStoreOnlyEntities",
                 STATEMENT_WITH_ENTITY_ARGUMENT__CAN_STORE_ONLY_ENTITIES__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateRollback(Rollback rollback, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(rollback, diagnostics, context);
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

} //ActionsValidator
