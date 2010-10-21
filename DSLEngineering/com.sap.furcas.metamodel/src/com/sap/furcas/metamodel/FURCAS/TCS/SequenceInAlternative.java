/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence In Alternative</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative#getAlternativeContainer <em>Alternative Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative#getDisambiguate <em>Disambiguate</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSequenceInAlternative()
 * @model
 * @generated
 */
public interface SequenceInAlternative extends Sequence {
        /**
     * Returns the value of the '<em><b>Alternative Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.Alternative#getSequences <em>Sequences</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Alternative Container</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Alternative Container</em>' container reference.
     * @see #setAlternativeContainer(Alternative)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSequenceInAlternative_AlternativeContainer()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Alternative#getSequences
     * @model opposite="sequences" transient="false" ordered="false"
     * @generated
     */
        Alternative getAlternativeContainer();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative#getAlternativeContainer <em>Alternative Container</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Alternative Container</em>' container reference.
     * @see #getAlternativeContainer()
     * @generated
     */
        void setAlternativeContainer(Alternative value);

        /**
     * Returns the value of the '<em><b>Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Disambiguate</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Disambiguate</em>' attribute.
     * @see #setDisambiguate(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSequenceInAlternative_Disambiguate()
     * @model
     * @generated
     */
        String getDisambiguate();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative#getDisambiguate <em>Disambiguate</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Disambiguate</em>' attribute.
     * @see #getDisambiguate()
     * @generated
     */
        void setDisambiguate(String value);

} // SequenceInAlternative
