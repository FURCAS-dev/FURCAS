/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
 *   <li>{@link dataaccess.analytics.DimensionExpression#getDimension <em>Dimension</em>}</li>
 *   <li>{@link dataaccess.analytics.DimensionExpression#getFacts <em>Facts</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.analytics.AnalyticsPackage#getDimensionExpression()
 * @model annotation="http://de.hpi.sam.bp2009.OCL FactsTypeConformsToFirstFunctionParameterType='self.facts.getType().conformsTo(self.dimension.ownerSignature.input->at(1).getType())' CellSetExpressionMustHaveFunctionSignatureType='self.cellSet.getType().oclIsKindOf(data::classes::FunctionSignatureTypeDefinition)' DimensionParameterIsNotFirst='self.dimension.ownerSignature.input->indexOf(self.dimension) > 1'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='FactsTypeConformsToFirstFunctionParameterType CellSetExpressionMustHaveFunctionSignatureType DimensionParameterIsNotFirst'"
 * @generated
 */
public interface DimensionExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Cell Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cell Set</em>' containment reference.
	 * @see #setCellSet(Expression)
	 * @see dataaccess.analytics.AnalyticsPackage#getDimensionExpression_CellSet()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='cellSetOfDimensionExpression'"
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
	 * Returns the value of the '<em><b>Dimension</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimension</em>' reference.
	 * @see #setDimension(Parameter)
	 * @see dataaccess.analytics.AnalyticsPackage#getDimensionExpression_Dimension()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
	 * @generated
	 */
	Parameter getDimension();

	/**
	 * Sets the value of the '{@link dataaccess.analytics.DimensionExpression#getDimension <em>Dimension</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dimension</em>' reference.
	 * @see #getDimension()
	 * @generated
	 */
	void setDimension(Parameter value);

	/**
	 * Returns the value of the '<em><b>Facts</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facts</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facts</em>' containment reference.
	 * @see #setFacts(Expression)
	 * @see dataaccess.analytics.AnalyticsPackage#getDimensionExpression_Facts()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='factsOfDimensionExpression'"
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
