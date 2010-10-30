/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.analytics.util;

import dataaccess.analytics.*;

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
 * @see dataaccess.analytics.AnalyticsPackage
 * @generated
 */
public class AnalyticsValidator extends EObjectValidator {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final AnalyticsValidator INSTANCE = new AnalyticsValidator();

	/**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
	public static final String DIAGNOSTIC_SOURCE = "dataaccess.analytics";

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
	public AnalyticsValidator() {
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
      return AnalyticsPackage.eINSTANCE;
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
            case AnalyticsPackage.DIMENSION:
                return validateDimension((Dimension)value, diagnostics, context);
            case AnalyticsPackage.CELL_SET:
                return validateCellSet((CellSet)value, diagnostics, context);
            case AnalyticsPackage.DIMENSION_EXPRESSION:
                return validateDimensionExpression((DimensionExpression)value, diagnostics, context);
            case AnalyticsPackage.GROUP_BY:
                return validateGroupBy((GroupBy)value, diagnostics, context);
            case AnalyticsPackage.DIMENSION_DEFINITION:
                return validateDimensionDefinition((DimensionDefinition)value, diagnostics, context);
            default:
                return true;
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateDimension(Dimension dimension, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(dimension, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(dimension, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dimension, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dimension, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dimension, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(dimension, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(dimension, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(dimension, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dimension, diagnostics, context);
        if (result || diagnostics != null) result &= validateDimension_BlockSignatureMustMatch(dimension, diagnostics, context);
        if (result || diagnostics != null) result &= validateDimension_CharacteristicFunctionMustNotBeAbstract(dimension, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the BlockSignatureMustMatch constraint of '<em>Dimension</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String DIMENSION__BLOCK_SIGNATURE_MUST_MATCH__EEXPRESSION = "self.characteristicFunction.input->size() = 1 and \r\n" +
        "  self.cellSet.factsType.conformsToIgnoringMultiplicity(self.characteristicFunction.input->at(1).getType())\r\n" +
        "    -- Add the following again once we have NestedTypeDefinitions under control...\r\n" +
        "    -- and  self.characteristicFunction.input->at(1).getType().upperMultiplicity = 1";

	/**
     * Validates the BlockSignatureMustMatch constraint of '<em>Dimension</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateDimension_BlockSignatureMustMatch(Dimension dimension, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AnalyticsPackage.Literals.DIMENSION,
                 dimension,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "BlockSignatureMustMatch",
                 DIMENSION__BLOCK_SIGNATURE_MUST_MATCH__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the CharacteristicFunctionMustNotBeAbstract constraint of '<em>Dimension</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String DIMENSION__CHARACTERISTIC_FUNCTION_MUST_NOT_BE_ABSTRACT__EEXPRESSION = "not self.characteristicFunction.isAbstract()";

	/**
     * Validates the CharacteristicFunctionMustNotBeAbstract constraint of '<em>Dimension</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateDimension_CharacteristicFunctionMustNotBeAbstract(Dimension dimension, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AnalyticsPackage.Literals.DIMENSION,
                 dimension,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "CharacteristicFunctionMustNotBeAbstract",
                 DIMENSION__CHARACTERISTIC_FUNCTION_MUST_NOT_BE_ABSTRACT__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCellSet(CellSet cellSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(cellSet, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(cellSet, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(cellSet, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(cellSet, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(cellSet, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(cellSet, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(cellSet, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(cellSet, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(cellSet, diagnostics, context);
        if (result || diagnostics != null) result &= validateCellSet_ValueFunctionSignatureMustMatch(cellSet, diagnostics, context);
        if (result || diagnostics != null) result &= validateCellSet_AggregationFunctionSignatureMustMatch(cellSet, diagnostics, context);
        if (result || diagnostics != null) result &= validateCellSet_AggregationFunctionMustNotBeAbstract(cellSet, diagnostics, context);
        if (result || diagnostics != null) result &= validateCellSet_ValueFunctionMustNotBeAbstract(cellSet, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the ValueFunctionSignatureMustMatch constraint of '<em>Cell Set</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CELL_SET__VALUE_FUNCTION_SIGNATURE_MUST_MATCH__EEXPRESSION = "self.valueFunction->notEmpty() implies\r\n" +
        "    (self.valueFunction.input->size() = 1 and\r\n" +
        "     self.factsType.conformsToIgnoringMultiplicity(self.valueFunction.input->at(1).getType())\r\n" +
        "    -- Add the following again once we have NestedTypeDefinitions under control...\r\n" +
        "    -- and  self.valueFunction.input->at(1).getType().upperMultiplicity = 1\r\n" +
        "    )";

	/**
     * Validates the ValueFunctionSignatureMustMatch constraint of '<em>Cell Set</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCellSet_ValueFunctionSignatureMustMatch(CellSet cellSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AnalyticsPackage.Literals.CELL_SET,
                 cellSet,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ValueFunctionSignatureMustMatch",
                 CELL_SET__VALUE_FUNCTION_SIGNATURE_MUST_MATCH__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the AggregationFunctionSignatureMustMatch constraint of '<em>Cell Set</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CELL_SET__AGGREGATION_FUNCTION_SIGNATURE_MUST_MATCH__EEXPRESSION = "self.aggregationFunction.input->size() = 1 and \r\n" +
        "  self.keyFigureType().conformsTo(self.aggregationFunction.input->at(1).getType())";

	/**
     * Validates the AggregationFunctionSignatureMustMatch constraint of '<em>Cell Set</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCellSet_AggregationFunctionSignatureMustMatch(CellSet cellSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AnalyticsPackage.Literals.CELL_SET,
                 cellSet,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "AggregationFunctionSignatureMustMatch",
                 CELL_SET__AGGREGATION_FUNCTION_SIGNATURE_MUST_MATCH__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the AggregationFunctionMustNotBeAbstract constraint of '<em>Cell Set</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CELL_SET__AGGREGATION_FUNCTION_MUST_NOT_BE_ABSTRACT__EEXPRESSION = "not self.aggregationFunction.isAbstract()";

	/**
     * Validates the AggregationFunctionMustNotBeAbstract constraint of '<em>Cell Set</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCellSet_AggregationFunctionMustNotBeAbstract(CellSet cellSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AnalyticsPackage.Literals.CELL_SET,
                 cellSet,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "AggregationFunctionMustNotBeAbstract",
                 CELL_SET__AGGREGATION_FUNCTION_MUST_NOT_BE_ABSTRACT__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the ValueFunctionMustNotBeAbstract constraint of '<em>Cell Set</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String CELL_SET__VALUE_FUNCTION_MUST_NOT_BE_ABSTRACT__EEXPRESSION = "self.valueFunction->forAll(vf | not vf.isAbstract())";

	/**
     * Validates the ValueFunctionMustNotBeAbstract constraint of '<em>Cell Set</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateCellSet_ValueFunctionMustNotBeAbstract(CellSet cellSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AnalyticsPackage.Literals.CELL_SET,
                 cellSet,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "ValueFunctionMustNotBeAbstract",
                 CELL_SET__VALUE_FUNCTION_MUST_NOT_BE_ABSTRACT__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateDimensionExpression(DimensionExpression dimensionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(dimensionExpression, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(dimensionExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dimensionExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dimensionExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dimensionExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(dimensionExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(dimensionExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(dimensionExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dimensionExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateDimensionExpression_FactsTypeConformsToFirstFunctionParameterType(dimensionExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateDimensionExpression_CellSetExpressionMustHaveFunctionSignatureType(dimensionExpression, diagnostics, context);
        if (result || diagnostics != null) result &= validateDimensionExpression_DimensionParameterIsNotFirst(dimensionExpression, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the FactsTypeConformsToFirstFunctionParameterType constraint of '<em>Dimension Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String DIMENSION_EXPRESSION__FACTS_TYPE_CONFORMS_TO_FIRST_FUNCTION_PARAMETER_TYPE__EEXPRESSION = "self.facts.getType().conformsTo(self.dimensionParameter.ownerSignature.input->at(1).getType())";

	/**
     * Validates the FactsTypeConformsToFirstFunctionParameterType constraint of '<em>Dimension Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateDimensionExpression_FactsTypeConformsToFirstFunctionParameterType(DimensionExpression dimensionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AnalyticsPackage.Literals.DIMENSION_EXPRESSION,
                 dimensionExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "FactsTypeConformsToFirstFunctionParameterType",
                 DIMENSION_EXPRESSION__FACTS_TYPE_CONFORMS_TO_FIRST_FUNCTION_PARAMETER_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the CellSetExpressionMustHaveFunctionSignatureType constraint of '<em>Dimension Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String DIMENSION_EXPRESSION__CELL_SET_EXPRESSION_MUST_HAVE_FUNCTION_SIGNATURE_TYPE__EEXPRESSION = "self.cellSet.getType().oclIsKindOf(data::classes::FunctionSignatureTypeDefinition)";

	/**
     * Validates the CellSetExpressionMustHaveFunctionSignatureType constraint of '<em>Dimension Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateDimensionExpression_CellSetExpressionMustHaveFunctionSignatureType(DimensionExpression dimensionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AnalyticsPackage.Literals.DIMENSION_EXPRESSION,
                 dimensionExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "CellSetExpressionMustHaveFunctionSignatureType",
                 DIMENSION_EXPRESSION__CELL_SET_EXPRESSION_MUST_HAVE_FUNCTION_SIGNATURE_TYPE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the DimensionParameterIsNotFirst constraint of '<em>Dimension Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String DIMENSION_EXPRESSION__DIMENSION_PARAMETER_IS_NOT_FIRST__EEXPRESSION = "self.dimensionParameter.ownerSignature.input->indexOf(self.dimensionParameter) > 1";

	/**
     * Validates the DimensionParameterIsNotFirst constraint of '<em>Dimension Expression</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateDimensionExpression_DimensionParameterIsNotFirst(DimensionExpression dimensionExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AnalyticsPackage.Literals.DIMENSION_EXPRESSION,
                 dimensionExpression,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "DimensionParameterIsNotFirst",
                 DIMENSION_EXPRESSION__DIMENSION_PARAMETER_IS_NOT_FIRST__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateGroupBy(GroupBy groupBy, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(groupBy, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(groupBy, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(groupBy, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(groupBy, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(groupBy, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(groupBy, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(groupBy, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(groupBy, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(groupBy, diagnostics, context);
        if (result || diagnostics != null) result &= validateGroupBy_GroupedFactsIteratorMustExistIfMapExpressionExists(groupBy, diagnostics, context);
        if (result || diagnostics != null) result &= validateGroupBy_MapExpressionMustBeSideEffectFree(groupBy, diagnostics, context);
        if (result || diagnostics != null) result &= validateGroupBy_GroupByIteratorsMustHaveDistinctNames(groupBy, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the GroupedFactsIteratorMustExistIfMapExpressionExists constraint of '<em>Group By</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String GROUP_BY__GROUPED_FACTS_ITERATOR_MUST_EXIST_IF_MAP_EXPRESSION_EXISTS__EEXPRESSION = "self.mapExpression->notEmpty() implies self.groupedFacts->notEmpty()";

	/**
     * Validates the GroupedFactsIteratorMustExistIfMapExpressionExists constraint of '<em>Group By</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateGroupBy_GroupedFactsIteratorMustExistIfMapExpressionExists(GroupBy groupBy, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AnalyticsPackage.Literals.GROUP_BY,
                 groupBy,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "GroupedFactsIteratorMustExistIfMapExpressionExists",
                 GROUP_BY__GROUPED_FACTS_ITERATOR_MUST_EXIST_IF_MAP_EXPRESSION_EXISTS__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the MapExpressionMustBeSideEffectFree constraint of '<em>Group By</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String GROUP_BY__MAP_EXPRESSION_MUST_BE_SIDE_EFFECT_FREE__EEXPRESSION = "if self.mapExpression->notEmpty() then\r\n" +
        "    self.mapExpression.isSideEffectFree()\r\n" +
        "  else\r\n" +
        "    true\r\n" +
        "  endif";

	/**
     * Validates the MapExpressionMustBeSideEffectFree constraint of '<em>Group By</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateGroupBy_MapExpressionMustBeSideEffectFree(GroupBy groupBy, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AnalyticsPackage.Literals.GROUP_BY,
                 groupBy,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "MapExpressionMustBeSideEffectFree",
                 GROUP_BY__MAP_EXPRESSION_MUST_BE_SIDE_EFFECT_FREE__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * The cached validation expression for the GroupByIteratorsMustHaveDistinctNames constraint of '<em>Group By</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String GROUP_BY__GROUP_BY_ITERATORS_MUST_HAVE_DISTINCT_NAMES__EEXPRESSION = "self.dimensions.iterator->asSet()->union(self.groupedFacts->asSet())->union(self.fact->asSet())->forAll(i, j | i<>j implies i.name<>j.name)";

	/**
     * Validates the GroupByIteratorsMustHaveDistinctNames constraint of '<em>Group By</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateGroupBy_GroupByIteratorsMustHaveDistinctNames(GroupBy groupBy, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AnalyticsPackage.Literals.GROUP_BY,
                 groupBy,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "GroupByIteratorsMustHaveDistinctNames",
                 GROUP_BY__GROUP_BY_ITERATORS_MUST_HAVE_DISTINCT_NAMES__EEXPRESSION,
                 Diagnostic.ERROR,
                 DIAGNOSTIC_SOURCE,
                 0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateDimensionDefinition(DimensionDefinition dimensionDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(dimensionDefinition, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(dimensionDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dimensionDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dimensionDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dimensionDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(dimensionDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(dimensionDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(dimensionDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dimensionDefinition, diagnostics, context);
        if (result || diagnostics != null) result &= validateDimensionDefinition_DimensionExpressionMustBeSideEffectFree(dimensionDefinition, diagnostics, context);
        return result;
    }

	/**
     * The cached validation expression for the DimensionExpressionMustBeSideEffectFree constraint of '<em>Dimension Definition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static final String DIMENSION_DEFINITION__DIMENSION_EXPRESSION_MUST_BE_SIDE_EFFECT_FREE__EEXPRESSION = "self.expression.isSideEffectFree()";

	/**
     * Validates the DimensionExpressionMustBeSideEffectFree constraint of '<em>Dimension Definition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean validateDimensionDefinition_DimensionExpressionMustBeSideEffectFree(DimensionDefinition dimensionDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
            validate
                (AnalyticsPackage.Literals.DIMENSION_DEFINITION,
                 dimensionDefinition,
                 diagnostics,
                 context,
                 "http://www.eclipse.org/emf/2002/Ecore/OCL",
                 "DimensionExpressionMustBeSideEffectFree",
                 DIMENSION_DEFINITION__DIMENSION_EXPRESSION_MUST_BE_SIDE_EFFECT_FREE__EEXPRESSION,
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

} //AnalyticsValidator
