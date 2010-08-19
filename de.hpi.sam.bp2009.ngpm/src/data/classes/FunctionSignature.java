/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import dataaccess.analytics.CellSet;
import dataaccess.analytics.Dimension;

import dataaccess.expressions.fp.AnonymousFunctionExpr;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * signature definition for an anonymous function that has to be implemented by a block
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.FunctionSignature#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link data.classes.FunctionSignature#getDimension <em>Dimension</em>}</li>
 *   <li>{@link data.classes.FunctionSignature#getCellSetForValueFunction <em>Cell Set For Value Function</em>}</li>
 *   <li>{@link data.classes.FunctionSignature#getCellSetForAggregationFunction <em>Cell Set For Aggregation Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getFunctionSignature()
 * @model
 * @generated
 */
public interface FunctionSignature extends Signature {
	/**
     * Returns the value of the '<em><b>Implementation</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link data.classes.FunctionSignatureImplementation#getFunctionSignature <em>Function Signature</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Implementation</em>' containment reference.
     * @see #setImplementation(FunctionSignatureImplementation)
     * @see data.classes.ClassesPackage#getFunctionSignature_Implementation()
     * @see data.classes.FunctionSignatureImplementation#getFunctionSignature
     * @model opposite="functionSignature" containment="true" resolveProxies="true"
     * @generated
     */
	FunctionSignatureImplementation getImplementation();

	/**
     * Sets the value of the '{@link data.classes.FunctionSignature#getImplementation <em>Implementation</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Implementation</em>' containment reference.
     * @see #getImplementation()
     * @generated
     */
	void setImplementation(FunctionSignatureImplementation value);

	/**
     * Returns the value of the '<em><b>Dimension</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.analytics.Dimension#getCharacteristicFunction <em>Characteristic Function</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Dimension</em>' container reference.
     * @see #setDimension(Dimension)
     * @see data.classes.ClassesPackage#getFunctionSignature_Dimension()
     * @see dataaccess.analytics.Dimension#getCharacteristicFunction
     * @model opposite="characteristicFunction"
     * @generated
     */
	Dimension getDimension();

	/**
     * Sets the value of the '{@link data.classes.FunctionSignature#getDimension <em>Dimension</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dimension</em>' container reference.
     * @see #getDimension()
     * @generated
     */
	void setDimension(Dimension value);

	/**
     * Returns the value of the '<em><b>Cell Set For Value Function</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.analytics.CellSet#getValueFunction <em>Value Function</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Set For Value Function</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Cell Set For Value Function</em>' container reference.
     * @see #setCellSetForValueFunction(CellSet)
     * @see data.classes.ClassesPackage#getFunctionSignature_CellSetForValueFunction()
     * @see dataaccess.analytics.CellSet#getValueFunction
     * @model opposite="valueFunction"
     * @generated
     */
	CellSet getCellSetForValueFunction();

	/**
     * Sets the value of the '{@link data.classes.FunctionSignature#getCellSetForValueFunction <em>Cell Set For Value Function</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cell Set For Value Function</em>' container reference.
     * @see #getCellSetForValueFunction()
     * @generated
     */
	void setCellSetForValueFunction(CellSet value);

	/**
     * Returns the value of the '<em><b>Cell Set For Aggregation Function</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link dataaccess.analytics.CellSet#getAggregationFunction <em>Aggregation Function</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Set For Aggregation Function</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Cell Set For Aggregation Function</em>' container reference.
     * @see #setCellSetForAggregationFunction(CellSet)
     * @see data.classes.ClassesPackage#getFunctionSignature_CellSetForAggregationFunction()
     * @see dataaccess.analytics.CellSet#getAggregationFunction
     * @model opposite="aggregationFunction"
     * @generated
     */
	CellSet getCellSetForAggregationFunction();

	/**
     * Sets the value of the '{@link data.classes.FunctionSignature#getCellSetForAggregationFunction <em>Cell Set For Aggregation Function</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cell Set For Aggregation Function</em>' container reference.
     * @see #getCellSetForAggregationFunction()
     * @generated
     */
	void setCellSetForAggregationFunction(CellSet value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://de.hpi.sam.bp2009.OCL body='self.implementation->isEmpty()'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean isAbstract();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" ordered="false"
     *        annotation="http://de.hpi.sam.bp2009.OCL body='let candidates:Sequence(dataaccess::expressions::fp::AnonymousFunctionExpr) =\n         self.typeDefinition.ownerTypedElement.oclAsType(dataaccess::expressions::fp::AnonymousFunctionExpr)->asSequence() in\n  if candidates->isEmpty() then\n    null\n  else\n    candidates->at(1)\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	AnonymousFunctionExpr getImplementedAnonymousFunctionExpression();

} // FunctionSignature
