/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Constraint#getExpression <em>Expression</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Constraint#getLanguage <em>Language</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Constraint#getEvaluationPolicy <em>Evaluation Policy</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.Constraint#getConstrainedElements <em>Constrained Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getConstraint()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.Constraint' metaObjectMofId='45ED2E295D0743E18F8045991708E8A92C8F47B3' isStructureType='false'"
 * @generated
 */
public interface Constraint extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getConstraint_Expression()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.Constraint#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getConstraint_Language()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.Constraint#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Evaluation Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evaluation Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluation Policy</em>' attribute.
	 * @see #setEvaluationPolicy(String)
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getConstraint_EvaluationPolicy()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getEvaluationPolicy();

	/**
	 * Sets the value of the '{@link com.sap.tc.moin.repository.mmi.Model.Constraint#getEvaluationPolicy <em>Evaluation Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluation Policy</em>' attribute.
	 * @see #getEvaluationPolicy()
	 * @generated
	 */
	void setEvaluationPolicy(String value);

	/**
	 * Returns the value of the '<em><b>Constrained Elements</b></em>' reference list.
	 * The list contents are of type {@link com.sap.tc.moin.repository.mmi.Model.ModelElement}.
	 * It is bidirectional and its opposite is '{@link com.sap.tc.moin.repository.mmi.Model.ModelElement#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constrained Elements</em>' reference list.
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getConstraint_ConstrainedElements()
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelElement#getConstraints
	 * @model opposite="constraints" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='Model.Constrains' metaObjectMofId='45ED2E290BBB4E28BAC041E52E7FE0AD24662FFD' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<ModelElement> getConstrainedElements();

} // Constraint
