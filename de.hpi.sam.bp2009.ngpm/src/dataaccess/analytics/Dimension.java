/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.analytics;

import data.classes.FunctionSignature;

import modelmanagement.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Dimensions define characteristics of the elements in a cell set according to which they may be grouped. A dimension defines a block that receives a value from the cell set's domain (its "facts" expression) and that determines the characteristic for that value in this dimension.
 * 
 * For example, if a cell set's domain is the set of all SalesOrderItems, one dimension could be the Product, and therefore the product dimension's block would determine the product of the SalesOrderItem.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.analytics.Dimension#getCellSet <em>Cell Set</em>}</li>
 *   <li>{@link dataaccess.analytics.Dimension#getCharacteristicFunction <em>Characteristic Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.analytics.AnalyticsPackage#getDimension()
 * @model annotation="http://de.hpi.sam.bp2009.OCL BlockSignatureMustMatch='self.characteristicFunction.input->size() = 1 and \r\n  self.cellSet.factsType.conformsToIgnoringMultiplicity(self.characteristicFunction.input->at(1).getType())\r\n    -- Add the following again once we have NestedTypeDefinitions under control...\r\n    -- and  self.characteristicFunction.input->at(1).getType().upperMultiplicity = 1' CharacteristicFunctionMustNotBeAbstract='not self.characteristicFunction.isAbstract()'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='BlockSignatureMustMatch CharacteristicFunctionMustNotBeAbstract'"
 * @generated
 */
public interface Dimension extends NamedElement {
	/**
     * Returns the value of the '<em><b>Cell Set</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.analytics.CellSet#getDimensions <em>Dimensions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Set</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Cell Set</em>' container reference.
     * @see #setCellSet(CellSet)
     * @see dataaccess.analytics.AnalyticsPackage#getDimension_CellSet()
     * @see dataaccess.analytics.CellSet#getDimensions
     * @model opposite="dimensions" required="true"
     * @generated
     */
	CellSet getCellSet();

	/**
     * Sets the value of the '{@link dataaccess.analytics.Dimension#getCellSet <em>Cell Set</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cell Set</em>' container reference.
     * @see #getCellSet()
     * @generated
     */
	void setCellSet(CellSet value);

	/**
     * Returns the value of the '<em><b>Characteristic Function</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link data.classes.FunctionSignature#getDimension <em>Dimension</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Characteristic Function</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Characteristic Function</em>' containment reference.
     * @see #setCharacteristicFunction(FunctionSignature)
     * @see dataaccess.analytics.AnalyticsPackage#getDimension_CharacteristicFunction()
     * @see data.classes.FunctionSignature#getDimension
     * @model opposite="dimension" containment="true" resolveProxies="true" required="true"
     * @generated
     */
	FunctionSignature getCharacteristicFunction();

	/**
     * Sets the value of the '{@link dataaccess.analytics.Dimension#getCharacteristicFunction <em>Characteristic Function</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Characteristic Function</em>' containment reference.
     * @see #getCharacteristicFunction()
     * @generated
     */
	void setCharacteristicFunction(FunctionSignature value);

} // Dimension
