/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef#getReferredLiteral <em>Referred Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getLiteralRef()
 * @model
 * @generated
 */
public interface LiteralRef extends SequenceElement {
        /**
	 * Returns the value of the '<em><b>Referred Literal</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.Literal#getLiteralRefs <em>Literal Refs</em>}'.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Referred Literal</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Literal</em>' reference.
	 * @see #setReferredLiteral(Literal)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getLiteralRef_ReferredLiteral()
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.Literal#getLiteralRefs
	 * @model opposite="literalRefs" required="true" ordered="false"
	 * @generated
	 */
        Literal getReferredLiteral();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef#getReferredLiteral <em>Referred Literal</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Literal</em>' reference.
	 * @see #getReferredLiteral()
	 * @generated
	 */
        void setReferredLiteral(Literal value);

} // LiteralRef
