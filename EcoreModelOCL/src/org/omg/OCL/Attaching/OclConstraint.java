/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Attaching;

import com.sap.tc.moin.repository.mmi.Model.Attribute;
import com.sap.tc.moin.repository.mmi.Model.Classifier;
import com.sap.tc.moin.repository.mmi.Model.Constraint;
import com.sap.tc.moin.repository.mmi.Model.Operation;
import com.sap.tc.moin.repository.mmi.Model.TypedElement;

import org.eclipse.emf.common.util.EList;

import org.omg.OCL.Expressions.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.OCL.Attaching.OclConstraint#getOclExpression <em>Ocl Expression</em>}</li>
 *   <li>{@link org.omg.OCL.Attaching.OclConstraint#getInvariantOf <em>Invariant Of</em>}</li>
 *   <li>{@link org.omg.OCL.Attaching.OclConstraint#getPreconditionFor <em>Precondition For</em>}</li>
 *   <li>{@link org.omg.OCL.Attaching.OclConstraint#getPostconditionFor <em>Postcondition For</em>}</li>
 *   <li>{@link org.omg.OCL.Attaching.OclConstraint#getViolationMessageExpression <em>Violation Message Expression</em>}</li>
 *   <li>{@link org.omg.OCL.Attaching.OclConstraint#getInitializedAttribute <em>Initialized Attribute</em>}</li>
 *   <li>{@link org.omg.OCL.Attaching.OclConstraint#getInitializedElement <em>Initialized Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.OCL.Attaching.AttachingPackage#getOclConstraint()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Attaching.OclConstraint' metaObjectMofId='45ED2E296BF3BA190A154A871BE194593FC488D2' isStructureType='false'"
 * @generated
 */
public interface OclConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Ocl Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Expression</em>' containment reference.
	 * @see #setOclExpression(OclExpression)
	 * @see org.omg.OCL.Attaching.AttachingPackage#getOclConstraint_OclExpression()
	 * @model containment="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Attaching.OclConstraintExpression' metaObjectMofId='45ED2E2978C53990A5BC4C2422388AFB1EB36113' storedEnd='1' compositeEnd='1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	OclExpression getOclExpression();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Attaching.OclConstraint#getOclExpression <em>Ocl Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Expression</em>' containment reference.
	 * @see #getOclExpression()
	 * @generated
	 */
	void setOclExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Invariant Of</b></em>' reference list.
	 * The list contents are of type {@link com.sap.tc.moin.repository.mmi.Model.Classifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invariant Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invariant Of</em>' reference list.
	 * @see org.omg.OCL.Attaching.AttachingPackage#getOclConstraint_InvariantOf()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Attaching.ClassifierInvariant' metaObjectMofId='45ED2E29B18FDCFB1C7C45620794D5388EE71A7D' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<Classifier> getInvariantOf();

	/**
	 * Returns the value of the '<em><b>Precondition For</b></em>' reference list.
	 * The list contents are of type {@link com.sap.tc.moin.repository.mmi.Model.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precondition For</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precondition For</em>' reference list.
	 * @see org.omg.OCL.Attaching.AttachingPackage#getOclConstraint_PreconditionFor()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Attaching.PreconditionConstraint' metaObjectMofId='45ED2E297AA45A8BC6274DCA3556BA29F90C887A' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<Operation> getPreconditionFor();

	/**
	 * Returns the value of the '<em><b>Postcondition For</b></em>' reference list.
	 * The list contents are of type {@link com.sap.tc.moin.repository.mmi.Model.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postcondition For</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postcondition For</em>' reference list.
	 * @see org.omg.OCL.Attaching.AttachingPackage#getOclConstraint_PostconditionFor()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Attaching.PostconditionConstraint' metaObjectMofId='45ED2E298B6069BDF2AD46B50C9CE09F7EACD165' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<Operation> getPostconditionFor();

	/**
	 * Returns the value of the '<em><b>Violation Message Expression</b></em>' reference list.
	 * The list contents are of type {@link org.omg.OCL.Expressions.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Violation Message Expression</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Violation Message Expression</em>' reference list.
	 * @see org.omg.OCL.Attaching.AttachingPackage#getOclConstraint_ViolationMessageExpression()
	 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Attaching.ViolationMessageExpression' metaObjectMofId='465EBCDCE887F4120F7011DC8D6000199904B925' storedEnd='1' compositeEnd='-1' orderedEnd='0' exposedEndNumber='1'"
	 * @generated
	 */
	EList<OclExpression> getViolationMessageExpression();

	/**
	 * Returns the value of the '<em><b>Initialized Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialized Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized Attribute</em>' reference.
	 * @see #setInitializedAttribute(Attribute)
	 * @see org.omg.OCL.Attaching.AttachingPackage#getOclConstraint_InitializedAttribute()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Attaching.AttributeInitializerConstraint' metaObjectMofId='47CFA6A89B3BA5B2EB5411DC95AA00199904B925' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	Attribute getInitializedAttribute();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Attaching.OclConstraint#getInitializedAttribute <em>Initialized Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized Attribute</em>' reference.
	 * @see #getInitializedAttribute()
	 * @generated
	 */
	void setInitializedAttribute(Attribute value);

	/**
	 * Returns the value of the '<em><b>Initialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialized Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized Element</em>' reference.
	 * @see #setInitializedElement(TypedElement)
	 * @see org.omg.OCL.Attaching.AttachingPackage#getOclConstraint_InitializedElement()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Attaching.InitializedElement' metaObjectMofId='486E16B04485CCE349C411DDA8FD00199904B925' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	TypedElement getInitializedElement();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Attaching.OclConstraint#getInitializedElement <em>Initialized Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized Element</em>' reference.
	 * @see #getInitializedElement()
	 * @generated
	 */
	void setInitializedElement(TypedElement value);

} // OclConstraint
