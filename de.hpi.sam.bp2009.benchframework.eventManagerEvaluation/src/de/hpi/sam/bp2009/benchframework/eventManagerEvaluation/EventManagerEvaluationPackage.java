/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventManagerEvaluation;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.EventManagerEvaluationFactory
 * @model kind="package"
 * @generated
 */
public interface EventManagerEvaluationPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "eventManagerEvaluation";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http.//de.hpi.sam.bp2009.benchframework.eventManagerEvaluation";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "de.hpi.sam.bp2009.benchframework";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EventManagerEvaluationPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.impl.EventManagerEvaluationPackageImpl.init();

    /**
     * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.impl.EventManagerOperatorImpl <em>Event Manager Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.impl.EventManagerOperatorImpl
     * @see de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.impl.EventManagerEvaluationPackageImpl#getEventManagerOperator()
     * @generated
     */
    int EVENT_MANAGER_OPERATOR = 0;

    /**
     * The feature id for the '<em><b>Option</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_MANAGER_OPERATOR__OPTION = BenchframeworkPackage.OPERATOR__OPTION;

    /**
     * The feature id for the '<em><b>Result</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_MANAGER_OPERATOR__RESULT = BenchframeworkPackage.OPERATOR__RESULT;

    /**
     * The feature id for the '<em><b>Test Run</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_MANAGER_OPERATOR__TEST_RUN = BenchframeworkPackage.OPERATOR__TEST_RUN;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_MANAGER_OPERATOR__NAME = BenchframeworkPackage.OPERATOR__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_MANAGER_OPERATOR__DESCRIPTION = BenchframeworkPackage.OPERATOR__DESCRIPTION;

    /**
     * The number of structural features of the '<em>Event Manager Operator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_MANAGER_OPERATOR_FEATURE_COUNT = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 0;


    /**
     * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.EventManagerOperator <em>Event Manager Operator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Manager Operator</em>'.
     * @see de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.EventManagerOperator
     * @generated
     */
    EClass getEventManagerOperator();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    EventManagerEvaluationFactory getEventManagerEvaluationFactory();

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
         * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.impl.EventManagerOperatorImpl <em>Event Manager Operator</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.impl.EventManagerOperatorImpl
         * @see de.hpi.sam.bp2009.benchframework.eventManagerEvaluation.impl.EventManagerEvaluationPackageImpl#getEventManagerOperator()
         * @generated
         */
        EClass EVENT_MANAGER_OPERATOR = eINSTANCE.getEventManagerOperator();

    }

} //EventManagerEvaluationPackage
