/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions;

import com.sap.tc.moin.repository.mmi.Model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.Model.Attribute;
import com.sap.tc.moin.repository.mmi.Model.Classifier;
import com.sap.tc.moin.repository.mmi.Model.Operation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.OCL.Expressions.OclExpression#getType <em>Type</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.OclExpression#getAppliedProperty <em>Applied Property</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.OclExpression#getParentOperation <em>Parent Operation</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.OclExpression#getAttributeForInitialValue <em>Attribute For Initial Value</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.OclExpression#getAssociationEndForInitialValue <em>Association End For Initial Value</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.OclExpression#getDefines <em>Defines</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.OclExpression#getAssociationEndForDerivationExpression <em>Association End For Derivation Expression</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.OclExpression#getAttributeForDerivationExpression <em>Attribute For Derivation Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.OCL.Expressions.ExpressionsPackage#getOclExpression()
 * @model abstract="true"
 * @generated
 */
public interface OclExpression extends OclNamedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Classifier)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getOclExpression_Type()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.A_type_oclExpression' metaObjectMofId='45ED2E29A8976A898EAF47150D76C377A0EDBAC2' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	Classifier getType();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.OclExpression#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Classifier value);

	/**
	 * Returns the value of the '<em><b>Applied Property</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.omg.OCL.Expressions.PropertyCallExp#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Property</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applied Property</em>' container reference.
	 * @see #setAppliedProperty(PropertyCallExp)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getOclExpression_AppliedProperty()
	 * @see org.omg.OCL.Expressions.PropertyCallExp#getSource
	 * @model opposite="source" transient="false" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.A_appliedProperty_source' metaObjectMofId='45ED2E299BB9CF41F9C44C763865EFB27EADFA32' storedEnd='0' compositeEnd='0' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	PropertyCallExp getAppliedProperty();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.OclExpression#getAppliedProperty <em>Applied Property</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applied Property</em>' container reference.
	 * @see #getAppliedProperty()
	 * @generated
	 */
	void setAppliedProperty(PropertyCallExp value);

	/**
	 * Returns the value of the '<em><b>Parent Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.omg.OCL.Expressions.OperationCallExp#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Operation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Operation</em>' container reference.
	 * @see #setParentOperation(OperationCallExp)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getOclExpression_ParentOperation()
	 * @see org.omg.OCL.Expressions.OperationCallExp#getArguments
	 * @model opposite="arguments" transient="false" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.A_parentOperation_arguments' metaObjectMofId='45ED2E297046BE46EB524CAA1143F6FD9EE9162C' storedEnd='0' compositeEnd='0' orderedEnd='1' exposedEndNumber='1'"
	 * @generated
	 */
	OperationCallExp getParentOperation();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.OclExpression#getParentOperation <em>Parent Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Operation</em>' container reference.
	 * @see #getParentOperation()
	 * @generated
	 */
	void setParentOperation(OperationCallExp value);

	/**
	 * Returns the value of the '<em><b>Attribute For Initial Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute For Initial Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute For Initial Value</em>' reference.
	 * @see #setAttributeForInitialValue(Attribute)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getOclExpression_AttributeForInitialValue()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Attaching.AttributeInitalValue' metaObjectMofId='45ED2E29A286E6ED595D4D21383BDF80C5FFDA11' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	Attribute getAttributeForInitialValue();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.OclExpression#getAttributeForInitialValue <em>Attribute For Initial Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute For Initial Value</em>' reference.
	 * @see #getAttributeForInitialValue()
	 * @generated
	 */
	void setAttributeForInitialValue(Attribute value);

	/**
	 * Returns the value of the '<em><b>Association End For Initial Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association End For Initial Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association End For Initial Value</em>' reference.
	 * @see #setAssociationEndForInitialValue(AssociationEnd)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getOclExpression_AssociationEndForInitialValue()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Attaching.AssociationEndInitialValue' metaObjectMofId='45ED2E2900D7CC82F45E481F01A3CB414C39021A' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	AssociationEnd getAssociationEndForInitialValue();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.OclExpression#getAssociationEndForInitialValue <em>Association End For Initial Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association End For Initial Value</em>' reference.
	 * @see #getAssociationEndForInitialValue()
	 * @generated
	 */
	void setAssociationEndForInitialValue(AssociationEnd value);

	/**
	 * Returns the value of the '<em><b>Defines</b></em>' reference list.
	 * The list contents are of type {@link com.sap.tc.moin.repository.mmi.Model.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defines</em>' reference list.
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getOclExpression_Defines()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Attaching.OperationBodyDefinition' metaObjectMofId='45ED2E2931823687B9EA4F3B2FA8D1089389DA6A' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<Operation> getDefines();

	/**
	 * Returns the value of the '<em><b>Association End For Derivation Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association End For Derivation Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association End For Derivation Expression</em>' reference.
	 * @see #setAssociationEndForDerivationExpression(AssociationEnd)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getOclExpression_AssociationEndForDerivationExpression()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Attaching.AssociationEndDerivationExpression' metaObjectMofId='45ED2E29DA068B3F43BC491E1A0DB705FE6FEF09' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	AssociationEnd getAssociationEndForDerivationExpression();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.OclExpression#getAssociationEndForDerivationExpression <em>Association End For Derivation Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association End For Derivation Expression</em>' reference.
	 * @see #getAssociationEndForDerivationExpression()
	 * @generated
	 */
	void setAssociationEndForDerivationExpression(AssociationEnd value);

	/**
	 * Returns the value of the '<em><b>Attribute For Derivation Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute For Derivation Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute For Derivation Expression</em>' reference.
	 * @see #setAttributeForDerivationExpression(Attribute)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getOclExpression_AttributeForDerivationExpression()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Attaching.AttributeDerivationExpression' metaObjectMofId='45ED2E29AD7CF6B69D7E479E0A67C662FE56B082' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	Attribute getAttributeForDerivationExpression();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.OclExpression#getAttributeForDerivationExpression <em>Attribute For Derivation Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute For Derivation Expression</em>' reference.
	 * @see #getAttributeForDerivationExpression()
	 * @generated
	 */
	void setAttributeForDerivationExpression(Attribute value);

} // OclExpression
