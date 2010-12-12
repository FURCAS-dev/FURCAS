/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.examples.impactanalyzer.example.signature_and_call.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.examples.impactanalyzer.example.signature_and_call.Call;
import org.eclipse.ocl.examples.impactanalyzer.example.signature_and_call.Expression;
import org.eclipse.ocl.examples.impactanalyzer.example.signature_and_call.Named;
import org.eclipse.ocl.examples.impactanalyzer.example.signature_and_call.Parameter;
import org.eclipse.ocl.examples.impactanalyzer.example.signature_and_call.Signature;
import org.eclipse.ocl.examples.impactanalyzer.example.signature_and_call.Signature_and_callFactory;
import org.eclipse.ocl.examples.impactanalyzer.example.signature_and_call.Signature_and_callPackage;
import org.eclipse.ocl.examples.impactanalyzer.example.signature_and_call.StringLiteral;

import org.eclipse.ocl.examples.impactanalyzer.example.signature_and_call.util.Signature_and_callValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Signature_and_callPackageImpl extends EPackageImpl implements Signature_and_callPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass signatureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass parameterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass namedEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass callEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass expressionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass stringLiteralEClass = null;

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
     * @see org.eclipse.ocl.examples.impactanalyzer.example.signature_and_call.Signature_and_callPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private Signature_and_callPackageImpl() {
        super(eNS_URI, Signature_and_callFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link Signature_and_callPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static Signature_and_callPackage init() {
        if (isInited) return (Signature_and_callPackage)EPackage.Registry.INSTANCE.getEPackage(Signature_and_callPackage.eNS_URI);

        // Obtain or create and register package
        Signature_and_callPackageImpl theSignature_and_callPackage = (Signature_and_callPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Signature_and_callPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Signature_and_callPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theSignature_and_callPackage.createPackageContents();

        // Initialize created meta-data
        theSignature_and_callPackage.initializePackageContents();

        // Register package validator
        EValidator.Registry.INSTANCE.put
            (theSignature_and_callPackage, 
             new EValidator.Descriptor() {
                 public EValidator getEValidator() {
                     return Signature_and_callValidator.INSTANCE;
                 }
             });

        // Mark meta-data to indicate it can't be changed
        theSignature_and_callPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(Signature_and_callPackage.eNS_URI, theSignature_and_callPackage);
        return theSignature_and_callPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSignature() {
        return signatureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSignature_Parameters() {
        return (EReference)signatureEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getParameter() {
        return parameterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNamed() {
        return namedEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNamed_Name() {
        return (EAttribute)namedEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCall() {
        return callEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCall_Signature() {
        return (EReference)callEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCall_Arguments() {
        return (EReference)callEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExpression() {
        return expressionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStringLiteral() {
        return stringLiteralEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getStringLiteral_Symbol() {
        return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Signature_and_callFactory getSignature_and_callFactory() {
        return (Signature_and_callFactory)getEFactoryInstance();
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
        signatureEClass = createEClass(SIGNATURE);
        createEReference(signatureEClass, SIGNATURE__PARAMETERS);

        parameterEClass = createEClass(PARAMETER);

        namedEClass = createEClass(NAMED);
        createEAttribute(namedEClass, NAMED__NAME);

        callEClass = createEClass(CALL);
        createEReference(callEClass, CALL__SIGNATURE);
        createEReference(callEClass, CALL__ARGUMENTS);

        expressionEClass = createEClass(EXPRESSION);

        stringLiteralEClass = createEClass(STRING_LITERAL);
        createEAttribute(stringLiteralEClass, STRING_LITERAL__SYMBOL);
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

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        signatureEClass.getESuperTypes().add(this.getNamed());
        parameterEClass.getESuperTypes().add(this.getNamed());
        callEClass.getESuperTypes().add(this.getExpression());
        stringLiteralEClass.getESuperTypes().add(this.getExpression());

        // Initialize classes and features; add operations and parameters
        initEClass(signatureEClass, Signature.class, "Signature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSignature_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(namedEClass, Named.class, "Named", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNamed_Name(), ecorePackage.getEString(), "name", null, 0, 1, Named.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(callEClass, Call.class, "Call", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getCall_Signature(), this.getSignature(), null, "signature", null, 1, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getCall_Arguments(), this.getExpression(), null, "arguments", null, 0, -1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getStringLiteral_Symbol(), ecorePackage.getEString(), "symbol", null, 1, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.eclipse.org/emf/2002/Ecore
        createEcoreAnnotations();
        // http://www.eclipse.org/emf/2002/Ecore/OCL
        createOCLAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createEcoreAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/Ecore";		
        addAnnotation
          (this, 
           source, 
           new String[] {
             "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
             "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL"
           });		
        addAnnotation
          (callEClass, 
           source, 
           new String[] {
             "constraints", "ArgumentsMustMatchParameterList"
           });	
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createOCLAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/Ecore/OCL";				
        addAnnotation
          (callEClass, 
           source, 
           new String[] {
             "ArgumentsMustMatchParameterList", "self.arguments->size() = self.signature.parameters->size()"
           });
    }

} //Signature_and_callPackageImpl
