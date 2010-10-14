/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.analytics;

import data.classes.FunctionSignature;
import data.classes.FunctionSignatureImplementation;
import data.classes.TypeDefinition;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cell Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A cell set computes an aggregated view on a domain of values, aggregated according to the different values for the different dimensions, using the aggregation function defined by the cell set. The domain (fact base) type is specified by factsType.
 * 
 * It subclasses FunctionSignatureImplementation. The function signature that a CellSet implements takes as its first argument a value whose type conforms to factsType, furthermore one argument per dimension and returns the aggregated cell value for the coordinate specified by the parameters. Therefore, the aggregationFunction's output type must conform to the CellSet's function signature's output type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.analytics.CellSet#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link dataaccess.analytics.CellSet#getValueFunction <em>Value Function</em>}</li>
 *   <li>{@link dataaccess.analytics.CellSet#getAggregationFunction <em>Aggregation Function</em>}</li>
 *   <li>{@link dataaccess.analytics.CellSet#getFactsType <em>Facts Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.analytics.AnalyticsPackage#getCellSet()
 * @model annotation="http://de.hpi.sam.bp2009.OCL ValueFunctionSignatureMustMatch='self.valueFunction->notEmpty() implies\r\n    (self.valueFunction.input->size() = 1 and\r\n     self.factsType.conformsToIgnoringMultiplicity(self.valueFunction.input->at(1).getType())\r\n    -- Add the following again once we have NestedTypeDefinitions under control...\r\n    -- and  self.valueFunction.input->at(1).getType().upperMultiplicity = 1\r\n    )' AggregationFunctionSignatureMustMatch='self.aggregationFunction.input->size() = 1 and \r\n  self.keyFigureType().conformsTo(self.aggregationFunction.input->at(1).getType())' AggregationFunctionMustNotBeAbstract='not self.aggregationFunction.isAbstract()' ValueFunctionMustNotBeAbstract='self.valueFunction->forAll(vf | not vf.isAbstract())'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValueFunctionSignatureMustMatch AggregationFunctionSignatureMustMatch AggregationFunctionMustNotBeAbstract ValueFunctionMustNotBeAbstract'"
 * @generated
 */
public interface CellSet extends FunctionSignatureImplementation {
	/**
     * Returns the value of the '<em><b>Dimensions</b></em>' containment reference list.
     * The list contents are of type {@link dataaccess.analytics.Dimension}.
     * It is bidirectional and its opposite is '{@link dataaccess.analytics.Dimension#getCellSet <em>Cell Set</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Dimensions</em>' containment reference list.
     * @see dataaccess.analytics.AnalyticsPackage#getCellSet_Dimensions()
     * @see dataaccess.analytics.Dimension#getCellSet
     * @model opposite="cellSet" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	EList<Dimension> getDimensions();

	/**
     * Returns the value of the '<em><b>Value Function</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link data.classes.FunctionSignature#getCellSetForValueFunction <em>Cell Set For Value Function</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Function</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Value Function</em>' containment reference.
     * @see #setValueFunction(FunctionSignature)
     * @see dataaccess.analytics.AnalyticsPackage#getCellSet_ValueFunction()
     * @see data.classes.FunctionSignature#getCellSetForValueFunction
     * @model opposite="cellSetForValueFunction" containment="true" resolveProxies="true"
     * @generated
     */
	FunctionSignature getValueFunction();

	/**
     * Sets the value of the '{@link dataaccess.analytics.CellSet#getValueFunction <em>Value Function</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value Function</em>' containment reference.
     * @see #getValueFunction()
     * @generated
     */
	void setValueFunction(FunctionSignature value);

	/**
     * Returns the value of the '<em><b>Aggregation Function</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link data.classes.FunctionSignature#getCellSetForAggregationFunction <em>Cell Set For Aggregation Function</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation Function</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Aggregation Function</em>' containment reference.
     * @see #setAggregationFunction(FunctionSignature)
     * @see dataaccess.analytics.AnalyticsPackage#getCellSet_AggregationFunction()
     * @see data.classes.FunctionSignature#getCellSetForAggregationFunction
     * @model opposite="cellSetForAggregationFunction" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	FunctionSignature getAggregationFunction();

	/**
     * Sets the value of the '{@link dataaccess.analytics.CellSet#getAggregationFunction <em>Aggregation Function</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Aggregation Function</em>' containment reference.
     * @see #getAggregationFunction()
     * @generated
     */
	void setAggregationFunction(FunctionSignature value);

	/**
     * Returns the value of the '<em><b>Facts Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facts Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Facts Type</em>' containment reference.
     * @see #setFactsType(TypeDefinition)
     * @see dataaccess.analytics.AnalyticsPackage#getCellSet_FactsType()
     * @model containment="true" resolveProxies="true" required="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='cellSet'"
     * @generated
     */
	TypeDefinition getFactsType();

	/**
     * Sets the value of the '{@link dataaccess.analytics.CellSet#getFactsType <em>Facts Type</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Facts Type</em>' containment reference.
     * @see #getFactsType()
     * @generated
     */
	void setFactsType(TypeDefinition value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Determines the type over which to aggregate. If no valueFunction is provided, this is the type of the cell set's elements. Otherwise, this is the type output by the valueFunction.
     * <!-- end-model-doc -->
     * @model unique="false" required="true" ordered="false"
     *        annotation="http://de.hpi.sam.bp2009.OCL body='if self.valueFunction->isEmpty() then\n    self.factsType\n  else\n    self.valueFunction.output\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	TypeDefinition keyFigureType();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model unique="false" required="true" ordered="false"
     *        annotation="http://de.hpi.sam.bp2009.OCL body='self.aggregationFunction.output'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	TypeDefinition cellType();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model unique="false" required="true" ordered="false"
     *        annotation="http://de.hpi.sam.bp2009.OCL body='self.dimensions->forAll(d|d.characteristicFunction.sideEffectFree) and\n  (self.valueFunction->notEmpty() implies self.valueFunction.sideEffectFree) and\n  self.aggregationFunction.sideEffectFree'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean localIsSideEffectFree();

} // CellSet
