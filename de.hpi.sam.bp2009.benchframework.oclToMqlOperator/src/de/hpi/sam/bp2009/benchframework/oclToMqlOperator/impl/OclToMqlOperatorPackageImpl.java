/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.utilities.UtilitiesPackage;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperator;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorFactory;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOptionObject;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlResult;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OclToMqlOperatorPackageImpl extends EPackageImpl implements OclToMqlOperatorPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass oclToMqlOperatorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass oclToMqlUtilEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass oclToMqlResultEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass oclToMqlOptionObjectEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private OclToMqlOperatorPackageImpl() {
        super(eNS_URI, OclToMqlOperatorFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link OclToMqlOperatorPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static OclToMqlOperatorPackage init() {
        if (isInited) return (OclToMqlOperatorPackage)EPackage.Registry.INSTANCE.getEPackage(OclToMqlOperatorPackage.eNS_URI);

        // Obtain or create and register package
        OclToMqlOperatorPackageImpl theOclToMqlOperatorPackage = (OclToMqlOperatorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OclToMqlOperatorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OclToMqlOperatorPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        TypesPackage.eINSTANCE.eClass();
        UtilitiesPackage.eINSTANCE.eClass();
        ExpressionsPackage.eINSTANCE.eClass();
        
        // Create package meta-data objects
        theOclToMqlOperatorPackage.createPackageContents();

        // Initialize created meta-data
        theOclToMqlOperatorPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theOclToMqlOperatorPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(OclToMqlOperatorPackage.eNS_URI, theOclToMqlOperatorPackage);
        return theOclToMqlOperatorPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOclToMqlOperator() {
        return oclToMqlOperatorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOclToMqlUtil() {
        return oclToMqlUtilEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOclToMqlResult() {
        return oclToMqlResultEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOclToMqlResult_QueriesToResults() {
        return (EAttribute)oclToMqlResultEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOclToMqlOptionObject() {
        return oclToMqlOptionObjectEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOclToMqlOptionObject_Constraints() {
        return (EAttribute)oclToMqlOptionObjectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclToMqlOperatorFactory getOclToMqlOperatorFactory() {
        return (OclToMqlOperatorFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        oclToMqlOperatorEClass = createEClass(OCL_TO_MQL_OPERATOR);

        oclToMqlUtilEClass = createEClass(OCL_TO_MQL_UTIL);

        oclToMqlResultEClass = createEClass(OCL_TO_MQL_RESULT);
        createEAttribute(oclToMqlResultEClass, OCL_TO_MQL_RESULT__QUERIES_TO_RESULTS);

        oclToMqlOptionObjectEClass = createEClass(OCL_TO_MQL_OPTION_OBJECT);
        createEAttribute(oclToMqlOptionObjectEClass, OCL_TO_MQL_OPTION_OBJECT__CONSTRAINTS);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        BenchframeworkPackage theBenchframeworkPackage = (BenchframeworkPackage)EPackage.Registry.INSTANCE.getEPackage(BenchframeworkPackage.eNS_URI);
        ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        oclToMqlOperatorEClass.getESuperTypes().add(theBenchframeworkPackage.getOperator());
        oclToMqlResultEClass.getESuperTypes().add(theBenchframeworkPackage.getResultObject());
        oclToMqlOptionObjectEClass.getESuperTypes().add(theBenchframeworkPackage.getOptionObject());

        // Initialize classes and features; add operations and parameters
        initEClass(oclToMqlOperatorEClass, OclToMqlOperator.class, "OclToMqlOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        EOperation op = addEOperation(oclToMqlOperatorEClass, null, "executeQueries", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEResourceSet(), "resourceSet", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(oclToMqlUtilEClass, OclToMqlUtil.class, "OclToMqlUtil", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        op = addEOperation(oclToMqlUtilEClass, null, "evaluateMQL", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEString(), "completeConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEResourceSet(), "resourceSet", 0, 1, IS_UNIQUE, IS_ORDERED);
        

        op = addEOperation(oclToMqlUtilEClass, null, "evaluateOCL", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEString(), "completeConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEResourceSet(), "resourceSet", 0, 1, IS_UNIQUE, IS_ORDERED);
       

        op = addEOperation(oclToMqlUtilEClass, null, "getOCLExpressionForOCL", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEString(), "completeConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEResourceSet(), "resourceSet", 0, 1, IS_UNIQUE, IS_ORDERED);
        EGenericType g1 = createEGenericType(theExpressionsPackage.getOCLExpression());
        EGenericType g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        op = addEOperation(oclToMqlUtilEClass, null, "getOCLExpressionForMQL", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEString(), "completeConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEResourceSet(), "resourceSet", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(theExpressionsPackage.getOCLExpression());
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEClass(oclToMqlResultEClass, OclToMqlResult.class, "OclToMqlResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEString());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEBooleanObject());
        g1.getETypeArguments().add(g2);
        initEAttribute(getOclToMqlResult_QueriesToResults(), g1, "queriesToResults", null, 0, 1, OclToMqlResult.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(oclToMqlOptionObjectEClass, OclToMqlOptionObject.class, "OclToMqlOptionObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOclToMqlOptionObject_Constraints(), ecorePackage.getEString(), "constraints", null, 0, -1, OclToMqlOptionObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //OclToMqlOperatorPackageImpl
