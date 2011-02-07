/**
 * <copyright>
 * </copyright>
 *
 * $Id: ClassesAdapterFactory.java,v 1.1 2011/02/07 16:49:09 auhl Exp $
 */
package data.classes.util;

import behavioral.events.EventProducer;

import data.classes.*;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see data.classes.ClassesPackage
 * @generated
 */
public class ClassesAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static ClassesPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ClassesAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ClassesPackage.eINSTANCE;
        }
    }

	/**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
	@Override
	public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

	/**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ClassesSwitch<Adapter> modelSwitch =
		new ClassesSwitch<Adapter>() {
            @Override
            public Adapter caseAssociation(Association object) {
                return createAssociationAdapter();
            }
            @Override
            public Adapter caseSignature(Signature object) {
                return createSignatureAdapter();
            }
            @Override
            public Adapter caseAssociationEnd(AssociationEnd object) {
                return createAssociationEndAdapter();
            }
            @Override
            public Adapter caseSapClass(SapClass object) {
                return createSapClassAdapter();
            }
            @Override
            public Adapter caseDelegation(Delegation object) {
                return createDelegationAdapter();
            }
            @Override
            public Adapter caseTypedElement(TypedElement object) {
                return createTypedElementAdapter();
            }
            @Override
            public Adapter caseContext(Context object) {
                return createContextAdapter();
            }
            @Override
            public Adapter caseMultiplicity(Multiplicity object) {
                return createMultiplicityAdapter();
            }
            @Override
            public Adapter caseSignatureImplementation(SignatureImplementation object) {
                return createSignatureImplementationAdapter();
            }
            @Override
            public Adapter caseLinkTraversal(LinkTraversal object) {
                return createLinkTraversalAdapter();
            }
            @Override
            public Adapter caseLinkAddition(LinkAddition object) {
                return createLinkAdditionAdapter();
            }
            @Override
            public Adapter caseLinkRemoval(LinkRemoval object) {
                return createLinkRemovalAdapter();
            }
            @Override
            public Adapter caseAssociationEndSignatureImplementation(AssociationEndSignatureImplementation object) {
                return createAssociationEndSignatureImplementationAdapter();
            }
            @Override
            public Adapter caseClassTypeDefinition(ClassTypeDefinition object) {
                return createClassTypeDefinitionAdapter();
            }
            @Override
            public Adapter caseTypeDefinition(TypeDefinition object) {
                return createTypeDefinitionAdapter();
            }
            @Override
            public Adapter caseNestedTypeDefinition(NestedTypeDefinition object) {
                return createNestedTypeDefinitionAdapter();
            }
            @Override
            public Adapter caseFunctionSignatureTypeDefinition(FunctionSignatureTypeDefinition object) {
                return createFunctionSignatureTypeDefinitionAdapter();
            }
            @Override
            public Adapter caseMethodSignature(MethodSignature object) {
                return createMethodSignatureAdapter();
            }
            @Override
            public Adapter caseFunctionSignature(FunctionSignature object) {
                return createFunctionSignatureAdapter();
            }
            @Override
            public Adapter caseLinkSetting(LinkSetting object) {
                return createLinkSettingAdapter();
            }
            @Override
            public Adapter caseTypeAdapter(TypeAdapter object) {
                return createTypeAdapterAdapter();
            }
            @Override
            public Adapter caseParameter(Parameter object) {
                return createParameterAdapter();
            }
            @Override
            public Adapter caseNamedValue(NamedValue object) {
                return createNamedValueAdapter();
            }
            @Override
            public Adapter casePlatformSpecificImplementation(PlatformSpecificImplementation object) {
                return createPlatformSpecificImplementationAdapter();
            }
            @Override
            public Adapter caseNativeImpl(NativeImpl object) {
                return createNativeImplAdapter();
            }
            @Override
            public Adapter caseSignatureOwner(SignatureOwner object) {
                return createSignatureOwnerAdapter();
            }
            @Override
            public Adapter caseExtentModifyingAssociationEndSignatureImplementation(ExtentModifyingAssociationEndSignatureImplementation object) {
                return createExtentModifyingAssociationEndSignatureImplementationAdapter();
            }
            @Override
            public Adapter caseFunctionSignatureImplementation(FunctionSignatureImplementation object) {
                return createFunctionSignatureImplementationAdapter();
            }
            @Override
            public Adapter caseActualObjectParameter(ActualObjectParameter object) {
                return createActualObjectParameterAdapter();
            }
            @Override
            public Adapter caseConverterBetweenParametrizations(ConverterBetweenParametrizations object) {
                return createConverterBetweenParametrizationsAdapter();
            }
            @Override
            public Adapter caseLinkManipulationAtPosition(LinkManipulationAtPosition object) {
                return createLinkManipulationAtPositionAdapter();
            }
            @Override
            public Adapter caseInScope(InScope object) {
                return createInScopeAdapter();
            }
            @Override
            public Adapter caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
            }
            @Override
            public Adapter caseEventProducer(EventProducer object) {
                return createEventProducerAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

	/**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
	@Override
	public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


	/**
     * Creates a new adapter for an object of class '{@link data.classes.Association <em>Association</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.Association
     * @generated
     */
	public Adapter createAssociationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.Signature <em>Signature</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.Signature
     * @generated
     */
	public Adapter createSignatureAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.AssociationEnd <em>Association End</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.AssociationEnd
     * @generated
     */
	public Adapter createAssociationEndAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.SapClass <em>Sap Class</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.SapClass
     * @generated
     */
	public Adapter createSapClassAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.Delegation <em>Delegation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.Delegation
     * @generated
     */
	public Adapter createDelegationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.TypedElement <em>Typed Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.TypedElement
     * @generated
     */
	public Adapter createTypedElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.Context <em>Context</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.Context
     * @generated
     */
	public Adapter createContextAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.Multiplicity <em>Multiplicity</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.Multiplicity
     * @generated
     */
	public Adapter createMultiplicityAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.SignatureImplementation <em>Signature Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.SignatureImplementation
     * @generated
     */
	public Adapter createSignatureImplementationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.LinkTraversal <em>Link Traversal</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.LinkTraversal
     * @generated
     */
	public Adapter createLinkTraversalAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.LinkAddition <em>Link Addition</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.LinkAddition
     * @generated
     */
	public Adapter createLinkAdditionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.LinkRemoval <em>Link Removal</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.LinkRemoval
     * @generated
     */
	public Adapter createLinkRemovalAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.AssociationEndSignatureImplementation <em>Association End Signature Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.AssociationEndSignatureImplementation
     * @generated
     */
	public Adapter createAssociationEndSignatureImplementationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.ClassTypeDefinition <em>Class Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.ClassTypeDefinition
     * @generated
     */
	public Adapter createClassTypeDefinitionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.TypeDefinition <em>Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.TypeDefinition
     * @generated
     */
	public Adapter createTypeDefinitionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.NestedTypeDefinition <em>Nested Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.NestedTypeDefinition
     * @generated
     */
	public Adapter createNestedTypeDefinitionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.FunctionSignatureTypeDefinition <em>Function Signature Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.FunctionSignatureTypeDefinition
     * @generated
     */
	public Adapter createFunctionSignatureTypeDefinitionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.MethodSignature <em>Method Signature</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.MethodSignature
     * @generated
     */
	public Adapter createMethodSignatureAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.FunctionSignature <em>Function Signature</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.FunctionSignature
     * @generated
     */
	public Adapter createFunctionSignatureAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.LinkSetting <em>Link Setting</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.LinkSetting
     * @generated
     */
	public Adapter createLinkSettingAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.TypeAdapter <em>Type Adapter</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.TypeAdapter
     * @generated
     */
	public Adapter createTypeAdapterAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.Parameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.Parameter
     * @generated
     */
	public Adapter createParameterAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.NamedValue <em>Named Value</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.NamedValue
     * @generated
     */
	public Adapter createNamedValueAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.PlatformSpecificImplementation <em>Platform Specific Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.PlatformSpecificImplementation
     * @generated
     */
	public Adapter createPlatformSpecificImplementationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.NativeImpl <em>Native Impl</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.NativeImpl
     * @generated
     */
	public Adapter createNativeImplAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.SignatureOwner <em>Signature Owner</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.SignatureOwner
     * @generated
     */
	public Adapter createSignatureOwnerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.ExtentModifyingAssociationEndSignatureImplementation <em>Extent Modifying Association End Signature Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.ExtentModifyingAssociationEndSignatureImplementation
     * @generated
     */
	public Adapter createExtentModifyingAssociationEndSignatureImplementationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.FunctionSignatureImplementation <em>Function Signature Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.FunctionSignatureImplementation
     * @generated
     */
	public Adapter createFunctionSignatureImplementationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.ActualObjectParameter <em>Actual Object Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.ActualObjectParameter
     * @generated
     */
	public Adapter createActualObjectParameterAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.ConverterBetweenParametrizations <em>Converter Between Parametrizations</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.ConverterBetweenParametrizations
     * @generated
     */
	public Adapter createConverterBetweenParametrizationsAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.LinkManipulationAtPosition <em>Link Manipulation At Position</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.LinkManipulationAtPosition
     * @generated
     */
	public Adapter createLinkManipulationAtPositionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.InScope <em>In Scope</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.InScope
     * @generated
     */
	public Adapter createInScopeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link modelmanagement.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see modelmanagement.NamedElement
     * @generated
     */
	public Adapter createNamedElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.events.EventProducer <em>Event Producer</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.events.EventProducer
     * @generated
     */
	public Adapter createEventProducerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
	public Adapter createEObjectAdapter() {
        return null;
    }

} //ClassesAdapterFactory
