/**
 * <copyright>
 * </copyright>
 *
 * $Id: DimensionExpression.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package dataaccess.analytics;

import data.classes.Parameter;

import dataaccess.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dimension Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * For the given cell set, obtain all distinct characteristic values of the given dimension. For example, for a CellSet based on SalesOrderItem with one Dimension being Product, yield all products for which a SalesOrderItem exists in the CellSet.
 * 
 * The type of this DimensionExpression is Set<self.dimension.type>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.analytics.DimensionExpression#getCellSet <em>Cell Set</em>}</li>
 *   <li>{@link dataaccess.analytics.DimensionExpression#getDimensionParameter <em>Dimension Parameter</em>}</li>
 *   <li>{@link dataaccess.analytics.DimensionExpression#getFacts <em>Facts</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.analytics.AnalyticsPackage#getDimensionExpression()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL FactsTypeConformsToFirstFunctionParameterType='self.facts.getType().conformsTo(self.dimensionParameter.ownerSignature.input->at(1).getType())' CellSetExpressionMustHaveFunctionSignatureType='self.cellSet.getType().oclIsKindOf(data::classes::FunctionSignatureTypeDefinition)' DimensionParameterIsNotFirst='self.dimensionParameter.ownerSignature.input->indexOf(self.dimensionParameter) > 1'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='FactsTypeConformsToFirstFunctionParameterType CellSetExpressionMustHaveFunctionSignatureType DimensionParameterIsNotFirst'"
 * @generated
 */
public interface DimensionExpression extends Expression {
	/**
     * Returns the value of the '<em><b>Cell Set</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getCellSetOfDimensionExpression <em>Cell Set Of Dimension Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Cell Set</em>' containment reference.
     * @see #setCellSet(Expression)
     * @see dataaccess.analytics.AnalyticsPackage#getDimensionExpression_CellSet()
     * @see dataaccess.expressions.Expression#getCellSetOfDimensionExpression
     * @model opposite="cellSetOfDimensionExpression" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Expression getCellSet();

	/**
     * Sets the value of the '{@link dataaccess.analytics.DimensionExpression#getCellSet <em>Cell Set</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cell Set</em>' containment reference.
     * @see #getCellSet()
     * @generated
     */
	void setCellSet(Expression value);

	/**
     * Returns the value of the '<em><b>Dimension Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Dimension Parameter</em>' reference.
     * @see #setDimensionParameter(Parameter)
     * @see dataaccess.analytics.AnalyticsPackage#getDimensionExpression_DimensionParameter()
     * @model required="true"
     * @generated
     */
	Parameter getDimensionParameter();

	/**
     * Sets the value of the '{@link dataaccess.analytics.DimensionExpression#getDimensionParameter <em>Dimension Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dimension Parameter</em>' reference.
     * @see #getDimensionParameter()
     * @generated
     */
	void setDimensionParameter(Parameter value);

	/**
     * Returns the value of the '<em><b>Facts</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getFactsOfDimensionExpression <em>Facts Of Dimension Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facts</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Facts</em>' containment reference.
     * @see #setFacts(Expression)
     * @see dataaccess.analytics.AnalyticsPackage#getDimensionExpression_Facts()
     * @see dataaccess.expressions.Expression#getFactsOfDimensionExpression
     * @model opposite="factsOfDimensionExpression" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	Expression getFacts();

	/**
     * Sets the value of the '{@link dataaccess.analytics.DimensionExpression#getFacts <em>Facts</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Facts</em>' containment reference.
     * @see #getFacts()
     * @generated
     */
	void setFacts(Expression value);

} // DimensionExpression
