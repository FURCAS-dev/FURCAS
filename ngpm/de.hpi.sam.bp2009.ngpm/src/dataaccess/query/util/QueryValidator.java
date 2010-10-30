/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.query.util;

import dataaccess.query.*;

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
 * @see dataaccess.query.QueryPackage
 * @generated
 */
public class QueryValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final QueryValidator INSTANCE = new QueryValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "dataaccess.query";

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
	public QueryValidator() {
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
      return QueryPackage.eINSTANCE;
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
            case QueryPackage.SELECTION:
                return validateSelection((Selection)value, diagnostics, context);
            case QueryPackage.OQL_QUERY:
                return validateOqlQuery((OqlQuery)value, diagnostics, context);
            case QueryPackage.FROM_CLAUSE:
                return validateFromClause((FromClause)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSelection(Selection selection, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(selection, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(selection, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(selection, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(selection, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(selection, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(selection, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(selection, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(selection, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(selection, diagnostics, context);
        if (result || diagnostics != null) result &= validateSelection_ConditionMustBeSideEffectFree(selection, diagnostics, context);
        if (result || diagnostics != null) result &= validateSelection_ConditionMustBeBooleanOrNumeric(selection, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ConditionMustBeSideEffectFree constraint of '<em>Selection</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String SELECTION__CONDITION_MUST_BE_SIDE_EFFECT_FREE__EEXPRESSION = "self.selectionExpr.isSideEffectFree()";

	/**
     * Validates the ConditionMustBeSideEffectFree constraint of '<em>Selection</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSelection_ConditionMustBeSideEffectFree(Selection selection, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (QueryPackage.Literals.SELECTION,
                 selection,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ConditionMustBeSideEffectFree",
                 SELECTION__CONDITION_MUST_BE_SIDE_EFFECT_FREE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the ConditionMustBeBooleanOrNumeric constraint of '<em>Selection</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String SELECTION__CONDITION_MUST_BE_BOOLEAN_OR_NUMERIC__EEXPRESSION = "self.selectionExpr.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n" +
        " (\r\n" +
        "    (\r\n" +
        "      self.selectionExpr.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name = 'Boolean' and\r\n" +
        "      self.selectionExpr.getType().upperMultiplicity = 1\r\n" +
        "    )\r\n" +
        "    or\r\n" +
        "    (\r\n" +
        "      self.selectionExpr.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name = 'Number' \r\n" +
        "      and \r\n" +
        "      self.object.getType().ordered\r\n" +
        "    )\r\n" +
        "  )";

	/**
     * Validates the ConditionMustBeBooleanOrNumeric constraint of '<em>Selection</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateSelection_ConditionMustBeBooleanOrNumeric(Selection selection, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (QueryPackage.Literals.SELECTION,
                 selection,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ConditionMustBeBooleanOrNumeric",
                 SELECTION__CONDITION_MUST_BE_BOOLEAN_OR_NUMERIC__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateOqlQuery(OqlQuery oqlQuery, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(oqlQuery, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(oqlQuery, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(oqlQuery, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(oqlQuery, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(oqlQuery, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(oqlQuery, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(oqlQuery, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(oqlQuery, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(oqlQuery, diagnostics, context);
        if (result || diagnostics != null) result &= validateOqlQuery_ConditionMustBeBoolean(oqlQuery, diagnostics, context);
        if (result || diagnostics != null) result &= validateOqlQuery_WhereClauseMustBeSideEffectFree(oqlQuery, diagnostics, context);
        if (result || diagnostics != null) result &= validateOqlQuery_HasValueType(oqlQuery, diagnostics, context);
        if (result || diagnostics != null) result &= validateOqlQuery_SelectedIteratorsMustHaveClassTypeDefinitionAsType(oqlQuery, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ConditionMustBeBoolean constraint of '<em>Oql Query</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String OQL_QUERY__CONDITION_MUST_BE_BOOLEAN__EEXPRESSION = "self.condition->notEmpty() implies\r\n" +
        "    (self.condition.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n" +
        "     self.condition.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name='Boolean')";

	/**
     * Validates the ConditionMustBeBoolean constraint of '<em>Oql Query</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateOqlQuery_ConditionMustBeBoolean(OqlQuery oqlQuery, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (QueryPackage.Literals.OQL_QUERY,
                 oqlQuery,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ConditionMustBeBoolean",
                 OQL_QUERY__CONDITION_MUST_BE_BOOLEAN__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the WhereClauseMustBeSideEffectFree constraint of '<em>Oql Query</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String OQL_QUERY__WHERE_CLAUSE_MUST_BE_SIDE_EFFECT_FREE__EEXPRESSION = "self.condition->forAll(c | c.isSideEffectFree())";

	/**
     * Validates the WhereClauseMustBeSideEffectFree constraint of '<em>Oql Query</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateOqlQuery_WhereClauseMustBeSideEffectFree(OqlQuery oqlQuery, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (QueryPackage.Literals.OQL_QUERY,
                 oqlQuery,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "WhereClauseMustBeSideEffectFree",
                 OQL_QUERY__WHERE_CLAUSE_MUST_BE_SIDE_EFFECT_FREE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the HasValueType constraint of '<em>Oql Query</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String OQL_QUERY__HAS_VALUE_TYPE__EEXPRESSION = "self.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and self.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.valueType";

	/**
     * Validates the HasValueType constraint of '<em>Oql Query</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateOqlQuery_HasValueType(OqlQuery oqlQuery, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (QueryPackage.Literals.OQL_QUERY,
                 oqlQuery,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "HasValueType",
                 OQL_QUERY__HAS_VALUE_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the SelectedIteratorsMustHaveClassTypeDefinitionAsType constraint of '<em>Oql Query</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String OQL_QUERY__SELECTED_ITERATORS_MUST_HAVE_CLASS_TYPE_DEFINITION_AS_TYPE__EEXPRESSION = "self.selected->forAll(i | i.getType().oclIsKindOf(data::classes::ClassTypeDefinition))";

	/**
     * Validates the SelectedIteratorsMustHaveClassTypeDefinitionAsType constraint of '<em>Oql Query</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateOqlQuery_SelectedIteratorsMustHaveClassTypeDefinitionAsType(OqlQuery oqlQuery, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (QueryPackage.Literals.OQL_QUERY,
                 oqlQuery,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "SelectedIteratorsMustHaveClassTypeDefinitionAsType",
                 OQL_QUERY__SELECTED_ITERATORS_MUST_HAVE_CLASS_TYPE_DEFINITION_AS_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateFromClause(FromClause fromClause, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(fromClause, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(fromClause, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(fromClause, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(fromClause, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(fromClause, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(fromClause, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(fromClause, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(fromClause, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(fromClause, diagnostics, context);
        if (result || diagnostics != null) result &= validateFromClause_FromClausesMustBeSideEffectFree(fromClause, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the FromClausesMustBeSideEffectFree constraint of '<em>From Clause</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String FROM_CLAUSE__FROM_CLAUSES_MUST_BE_SIDE_EFFECT_FREE__EEXPRESSION = "self.fromExpression.isSideEffectFree()";

	/**
     * Validates the FromClausesMustBeSideEffectFree constraint of '<em>From Clause</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateFromClause_FromClausesMustBeSideEffectFree(FromClause fromClause, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (QueryPackage.Literals.FROM_CLAUSE,
                 fromClause,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "FromClausesMustBeSideEffectFree",
                 FROM_CLAUSE__FROM_CLAUSES_MUST_BE_SIDE_EFFECT_FREE__EEXPRESSION,
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

} //QueryValidator
