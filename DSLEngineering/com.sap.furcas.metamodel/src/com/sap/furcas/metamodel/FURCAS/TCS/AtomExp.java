/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atom Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.AtomExp#getAndExp <em>And Exp</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.AtomExp#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.AtomExp#getPropertyReference <em>Property Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getAtomExp()
 * @model abstract="true"
 * @generated
 */
public interface AtomExp extends LocatedElement {
        /**
     * Returns the value of the '<em><b>And Exp</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.AndExp#getExpressions <em>Expressions</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>And Exp</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>And Exp</em>' container reference.
     * @see #setAndExp(AndExp)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getAtomExp_AndExp()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AndExp#getExpressions
     * @model opposite="expressions" required="true" transient="false" ordered="false"
     * @generated
     */
        AndExp getAndExp();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.AtomExp#getAndExp <em>And Exp</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>And Exp</em>' container reference.
     * @see #getAndExp()
     * @generated
     */
        void setAndExp(AndExp value);

        /**
     * Returns the value of the '<em><b>Property Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Property Name</em>' attribute.
     * @see #setPropertyName(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getAtomExp_PropertyName()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
        String getPropertyName();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.AtomExp#getPropertyName <em>Property Name</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Property Name</em>' attribute.
     * @see #getPropertyName()
     * @generated
     */
        void setPropertyName(String value);

        /**
     * Returns the value of the '<em><b>Property Reference</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Property Reference</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Property Reference</em>' containment reference.
     * @see #setPropertyReference(PropertyReference)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getAtomExp_PropertyReference()
     * @model containment="true"
     * @generated
     */
        PropertyReference getPropertyReference();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.AtomExp#getPropertyReference <em>Property Reference</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Property Reference</em>' containment reference.
     * @see #getPropertyReference()
     * @generated
     */
        void setPropertyReference(PropertyReference value);

} // AtomExp
