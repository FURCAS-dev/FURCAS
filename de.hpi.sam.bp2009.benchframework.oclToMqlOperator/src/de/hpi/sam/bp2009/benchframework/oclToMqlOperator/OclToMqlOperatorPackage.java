/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclToMqlOperator;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorFactory
 * @model kind="package"
 * @generated
 */
public interface OclToMqlOperatorPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "oclToMqlOperator";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://de.hpi.sam.bp2009.benchframework.oclToMqlOperator";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "benchframework.oclToMqlOperator";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    OclToMqlOperatorPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorPackageImpl.init();

    /**
     * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorImpl <em>Ocl To Mql Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorImpl
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorPackageImpl#getOclToMqlOperator()
     * @generated
     */
    int OCL_TO_MQL_OPERATOR = 0;

    /**
     * The feature id for the '<em><b>Option</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_TO_MQL_OPERATOR__OPTION = BenchframeworkPackage.OPERATOR__OPTION;

    /**
     * The feature id for the '<em><b>Result</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_TO_MQL_OPERATOR__RESULT = BenchframeworkPackage.OPERATOR__RESULT;

    /**
     * The feature id for the '<em><b>Test Run</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_TO_MQL_OPERATOR__TEST_RUN = BenchframeworkPackage.OPERATOR__TEST_RUN;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_TO_MQL_OPERATOR__NAME = BenchframeworkPackage.OPERATOR__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_TO_MQL_OPERATOR__DESCRIPTION = BenchframeworkPackage.OPERATOR__DESCRIPTION;

    /**
     * The number of structural features of the '<em>Ocl To Mql Operator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_TO_MQL_OPERATOR_FEATURE_COUNT = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlUtilImpl <em>Ocl To Mql Util</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlUtilImpl
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorPackageImpl#getOclToMqlUtil()
     * @generated
     */
    int OCL_TO_MQL_UTIL = 1;

    /**
     * The number of structural features of the '<em>Ocl To Mql Util</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_TO_MQL_UTIL_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlResultImpl <em>Ocl To Mql Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlResultImpl
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorPackageImpl#getOclToMqlResult()
     * @generated
     */
    int OCL_TO_MQL_RESULT = 2;

    /**
     * The feature id for the '<em><b>Status</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_TO_MQL_RESULT__STATUS = BenchframeworkPackage.RESULT_OBJECT__STATUS;

    /**
     * The feature id for the '<em><b>Message</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_TO_MQL_RESULT__MESSAGE = BenchframeworkPackage.RESULT_OBJECT__MESSAGE;

    /**
     * The feature id for the '<em><b>Queries To Results</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_TO_MQL_RESULT__QUERIES_TO_RESULTS = BenchframeworkPackage.RESULT_OBJECT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ocl To Mql Result</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_TO_MQL_RESULT_FEATURE_COUNT = BenchframeworkPackage.RESULT_OBJECT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOptionObjectImpl <em>Ocl To Mql Option Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOptionObjectImpl
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorPackageImpl#getOclToMqlOptionObject()
     * @generated
     */
    int OCL_TO_MQL_OPTION_OBJECT = 3;

    /**
     * The feature id for the '<em><b>Wizard Page</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_TO_MQL_OPTION_OBJECT__WIZARD_PAGE = BenchframeworkPackage.OPTION_OBJECT__WIZARD_PAGE;

    /**
     * The feature id for the '<em><b>Constraints</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_TO_MQL_OPTION_OBJECT__CONSTRAINTS = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 0;
    
    /**
     * The feature id for the '<em><b>Use Evaluator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OCL_TO_MQL_OPTION_OBJECT__USE_EVALUATOR = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 1;
    
    /**
     * The number of structural features of the '<em>Ocl To Mql Option Object</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    
    int OCL_TO_MQL_OPTION_OBJECT_FEATURE_COUNT = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 1;


    /**
     * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperator <em>Ocl To Mql Operator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ocl To Mql Operator</em>'.
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperator
     * @generated
     */
    EClass getOclToMqlOperator();

    /**
     * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlUtil <em>Ocl To Mql Util</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ocl To Mql Util</em>'.
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlUtil
     * @generated
     */
    EClass getOclToMqlUtil();

    /**
     * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlResult <em>Ocl To Mql Result</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ocl To Mql Result</em>'.
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlResult
     * @generated
     */
    EClass getOclToMqlResult();

    /**
     * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlResult#getQueriesToResults <em>Queries To Results</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Queries To Results</em>'.
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlResult#getQueriesToResults()
     * @see #getOclToMqlResult()
     * @generated
     */
    EAttribute getOclToMqlResult_QueriesToResults();

    /**
     * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOptionObject <em>Ocl To Mql Option Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ocl To Mql Option Object</em>'.
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOptionObject
     * @generated
     */
    EClass getOclToMqlOptionObject();

    /**
     * Returns the meta object for the attribute list '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOptionObject#getConstraints <em>Constraints</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Constraints</em>'.
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOptionObject#getConstraints()
     * @see #getOclToMqlOptionObject()
     * @generated
     */
    EAttribute getOclToMqlOptionObject_Constraints();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    OclToMqlOperatorFactory getOclToMqlOperatorFactory();

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
         * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorImpl <em>Ocl To Mql Operator</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorImpl
         * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorPackageImpl#getOclToMqlOperator()
         * @generated
         */
        EClass OCL_TO_MQL_OPERATOR = eINSTANCE.getOclToMqlOperator();

        /**
         * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlUtilImpl <em>Ocl To Mql Util</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlUtilImpl
         * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorPackageImpl#getOclToMqlUtil()
         * @generated
         */
        EClass OCL_TO_MQL_UTIL = eINSTANCE.getOclToMqlUtil();

        /**
         * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlResultImpl <em>Ocl To Mql Result</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlResultImpl
         * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorPackageImpl#getOclToMqlResult()
         * @generated
         */
        EClass OCL_TO_MQL_RESULT = eINSTANCE.getOclToMqlResult();

        /**
         * The meta object literal for the '<em><b>Queries To Results</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OCL_TO_MQL_RESULT__QUERIES_TO_RESULTS = eINSTANCE.getOclToMqlResult_QueriesToResults();

        /**
         * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOptionObjectImpl <em>Ocl To Mql Option Object</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOptionObjectImpl
         * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOperatorPackageImpl#getOclToMqlOptionObject()
         * @generated
         */
        EClass OCL_TO_MQL_OPTION_OBJECT = eINSTANCE.getOclToMqlOptionObject();

        /**
         * The meta object literal for the '<em><b>Constraints</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OCL_TO_MQL_OPTION_OBJECT__CONSTRAINTS = eINSTANCE.getOclToMqlOptionObject_Constraints();

    }

} //OclToMqlOperatorPackage
