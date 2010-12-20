/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes.impl;

import data.classes.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassesFactoryImpl extends EFactoryImpl implements ClassesFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ClassesFactory init() {
        try {
            ClassesFactory theClassesFactory = (ClassesFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/data/classes.ecore"); 
            if (theClassesFactory != null) {
                return theClassesFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ClassesFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ClassesFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case ClassesPackage.ASSOCIATION: return createAssociation();
            case ClassesPackage.ASSOCIATION_END: return createAssociationEnd();
            case ClassesPackage.SAP_CLASS: return createSapClass();
            case ClassesPackage.DELEGATION: return createDelegation();
            case ClassesPackage.CONTEXT: return createContext();
            case ClassesPackage.LINK_TRAVERSAL: return createLinkTraversal();
            case ClassesPackage.LINK_ADDITION: return createLinkAddition();
            case ClassesPackage.LINK_REMOVAL: return createLinkRemoval();
            case ClassesPackage.CLASS_TYPE_DEFINITION: return createClassTypeDefinition();
            case ClassesPackage.NESTED_TYPE_DEFINITION: return createNestedTypeDefinition();
            case ClassesPackage.FUNCTION_SIGNATURE_TYPE_DEFINITION: return createFunctionSignatureTypeDefinition();
            case ClassesPackage.METHOD_SIGNATURE: return createMethodSignature();
            case ClassesPackage.FUNCTION_SIGNATURE: return createFunctionSignature();
            case ClassesPackage.LINK_SETTING: return createLinkSetting();
            case ClassesPackage.TYPE_ADAPTER: return createTypeAdapter();
            case ClassesPackage.PARAMETER: return createParameter();
            case ClassesPackage.PLATFORM_SPECIFIC_IMPLEMENTATION: return createPlatformSpecificImplementation();
            case ClassesPackage.NATIVE_IMPL: return createNativeImpl();
            case ClassesPackage.SIGNATURE_OWNER: return createSignatureOwner();
            case ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION: return createFunctionSignatureImplementation();
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER: return createActualObjectParameter();
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS: return createConverterBetweenParametrizations();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Association createAssociation() {
        AssociationImpl association = new AssociationImpl();
        return association;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEnd createAssociationEnd() {
        AssociationEndImpl associationEnd = new AssociationEndImpl();
        return associationEnd;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass createSapClass() {
        SapClassImpl sapClass = new SapClassImpl();
        return sapClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Delegation createDelegation() {
        DelegationImpl delegation = new DelegationImpl();
        return delegation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Context createContext() {
        ContextImpl context = new ContextImpl();
        return context;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LinkTraversal createLinkTraversal() {
        LinkTraversalImpl linkTraversal = new LinkTraversalImpl();
        return linkTraversal;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LinkAddition createLinkAddition() {
        LinkAdditionImpl linkAddition = new LinkAdditionImpl();
        return linkAddition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LinkRemoval createLinkRemoval() {
        LinkRemovalImpl linkRemoval = new LinkRemovalImpl();
        return linkRemoval;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ClassTypeDefinition createClassTypeDefinition() {
        ClassTypeDefinitionImpl classTypeDefinition = new ClassTypeDefinitionImpl();
        return classTypeDefinition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NestedTypeDefinition createNestedTypeDefinition() {
        NestedTypeDefinitionImpl nestedTypeDefinition = new NestedTypeDefinitionImpl();
        return nestedTypeDefinition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FunctionSignatureTypeDefinition createFunctionSignatureTypeDefinition() {
        FunctionSignatureTypeDefinitionImpl functionSignatureTypeDefinition = new FunctionSignatureTypeDefinitionImpl();
        return functionSignatureTypeDefinition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MethodSignature createMethodSignature() {
        MethodSignatureImpl methodSignature = new MethodSignatureImpl();
        return methodSignature;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FunctionSignature createFunctionSignature() {
        FunctionSignatureImpl functionSignature = new FunctionSignatureImpl();
        return functionSignature;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LinkSetting createLinkSetting() {
        LinkSettingImpl linkSetting = new LinkSettingImpl();
        return linkSetting;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeAdapter createTypeAdapter() {
        TypeAdapterImpl typeAdapter = new TypeAdapterImpl();
        return typeAdapter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Parameter createParameter() {
        ParameterImpl parameter = new ParameterImpl();
        return parameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PlatformSpecificImplementation createPlatformSpecificImplementation() {
        PlatformSpecificImplementationImpl platformSpecificImplementation = new PlatformSpecificImplementationImpl();
        return platformSpecificImplementation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NativeImpl createNativeImpl() {
        NativeImplImpl nativeImpl = new NativeImplImpl();
        return nativeImpl;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SignatureOwner createSignatureOwner() {
        SignatureOwnerImpl signatureOwner = new SignatureOwnerImpl();
        return signatureOwner;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FunctionSignatureImplementation createFunctionSignatureImplementation() {
        FunctionSignatureImplementationImpl functionSignatureImplementation = new FunctionSignatureImplementationImpl();
        return functionSignatureImplementation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ActualObjectParameter createActualObjectParameter() {
        ActualObjectParameterImpl actualObjectParameter = new ActualObjectParameterImpl();
        return actualObjectParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ConverterBetweenParametrizations createConverterBetweenParametrizations() {
        ConverterBetweenParametrizationsImpl converterBetweenParametrizations = new ConverterBetweenParametrizationsImpl();
        return converterBetweenParametrizations;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ClassesPackage getClassesPackage() {
        return (ClassesPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static ClassesPackage getPackage() {
        return ClassesPackage.eINSTANCE;
    }

} //ClassesFactoryImpl
