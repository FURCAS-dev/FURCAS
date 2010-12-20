/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.context_drivers.impl;

import configuration.context_drivers.*;

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
public class Context_driversFactoryImpl extends EFactoryImpl implements Context_driversFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static Context_driversFactory init() {
        try {
            Context_driversFactory theContext_driversFactory = (Context_driversFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/configuration/context_drivers.ecore"); 
            if (theContext_driversFactory != null) {
                return theContext_driversFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new Context_driversFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Context_driversFactoryImpl() {
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
            case Context_driversPackage.CONTEXT_CATEGORY: return createContextCategory();
            case Context_driversPackage.CONTEXT_CATEGORY_VALUE: return createContextCategoryValue();
            case Context_driversPackage.CONTEXTUAL_ELEMENT: return createContextualElement();
            case Context_driversPackage.CONTEX_CONFIGURATION: return createContexConfiguration();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ContextCategory createContextCategory() {
        ContextCategoryImpl contextCategory = new ContextCategoryImpl();
        return contextCategory;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ContextCategoryValue createContextCategoryValue() {
        ContextCategoryValueImpl contextCategoryValue = new ContextCategoryValueImpl();
        return contextCategoryValue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ContextualElement createContextualElement() {
        ContextualElementImpl contextualElement = new ContextualElementImpl();
        return contextualElement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ContexConfiguration createContexConfiguration() {
        ContexConfigurationImpl contexConfiguration = new ContexConfigurationImpl();
        return contexConfiguration;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Context_driversPackage getContext_driversPackage() {
        return (Context_driversPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static Context_driversPackage getPackage() {
        return Context_driversPackage.eINSTANCE;
    }

} //Context_driversFactoryImpl
