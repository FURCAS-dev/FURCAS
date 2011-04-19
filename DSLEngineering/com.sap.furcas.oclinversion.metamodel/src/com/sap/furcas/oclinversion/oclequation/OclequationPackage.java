/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.oclinversion.oclequation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.sap.furcas.oclinversion.oclequation.OclequationFactory
 * @model kind="package"
 * @generated
 */
public interface OclequationPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "oclequation";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.furcas.org/oclinversion/oclequation";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "com.sap.furcas.oclinversion";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    OclequationPackage eINSTANCE = com.sap.furcas.oclinversion.oclequation.impl.OclequationPackageImpl.init();

    /**
     * The meta object id for the '{@link com.sap.furcas.oclinversion.oclequation.impl.OclEquationImpl <em>Ocl Equation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.sap.furcas.oclinversion.oclequation.impl.OclEquationImpl
     * @see com.sap.furcas.oclinversion.oclequation.impl.OclequationPackageImpl#getOclEquation()
     * @generated
     */
    int OCL_EQUATION = 0;

    /**
     * The feature id for the '<em><b>Left</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_EQUATION__LEFT = 0;

    /**
     * The feature id for the '<em><b>Right</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_EQUATION__RIGHT = 1;

    /**
     * The feature id for the '<em><b>Is Source</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_EQUATION__IS_SOURCE = 2;

    /**
     * The number of structural features of the '<em>Ocl Equation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_EQUATION_FEATURE_COUNT = 3;


    /**
     * Returns the meta object for class '{@link com.sap.furcas.oclinversion.oclequation.OclEquation <em>Ocl Equation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ocl Equation</em>'.
     * @see com.sap.furcas.oclinversion.oclequation.OclEquation
     * @generated
     */
    EClass getOclEquation();

    /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.oclinversion.oclequation.OclEquation#getLeft <em>Left</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Left</em>'.
     * @see com.sap.furcas.oclinversion.oclequation.OclEquation#getLeft()
     * @see #getOclEquation()
     * @generated
     */
    EReference getOclEquation_Left();

    /**
     * Returns the meta object for the containment reference '{@link com.sap.furcas.oclinversion.oclequation.OclEquation#getRight <em>Right</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Right</em>'.
     * @see com.sap.furcas.oclinversion.oclequation.OclEquation#getRight()
     * @see #getOclEquation()
     * @generated
     */
    EReference getOclEquation_Right();

    /**
     * Returns the meta object for the attribute '{@link com.sap.furcas.oclinversion.oclequation.OclEquation#isIsSource <em>Is Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Source</em>'.
     * @see com.sap.furcas.oclinversion.oclequation.OclEquation#isIsSource()
     * @see #getOclEquation()
     * @generated
     */
    EAttribute getOclEquation_IsSource();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    OclequationFactory getOclequationFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link com.sap.furcas.oclinversion.oclequation.impl.OclEquationImpl <em>Ocl Equation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.sap.furcas.oclinversion.oclequation.impl.OclEquationImpl
         * @see com.sap.furcas.oclinversion.oclequation.impl.OclequationPackageImpl#getOclEquation()
         * @generated
         */
        EClass OCL_EQUATION = eINSTANCE.getOclEquation();

        /**
         * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OCL_EQUATION__LEFT = eINSTANCE.getOclEquation_Left();

        /**
         * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OCL_EQUATION__RIGHT = eINSTANCE.getOclEquation_Right();

        /**
         * The meta object literal for the '<em><b>Is Source</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OCL_EQUATION__IS_SOURCE = eINSTANCE.getOclEquation_IsSource();

    }

} //OclequationPackage
