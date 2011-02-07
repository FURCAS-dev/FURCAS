/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProcessintegrationFactoryImpl.java,v 1.1 2011/02/07 16:57:59 auhl Exp $
 */
package integration.processintegration.impl;

import integration.processintegration.*;

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
public class ProcessintegrationFactoryImpl extends EFactoryImpl implements ProcessintegrationFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ProcessintegrationFactory init() {
        try {
            ProcessintegrationFactory theProcessintegrationFactory = (ProcessintegrationFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/integration/processintegration.ecore"); 
            if (theProcessintegrationFactory != null) {
                return theProcessintegrationFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ProcessintegrationFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcessintegrationFactoryImpl() {
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
            case ProcessintegrationPackage.INTEGRATION_SCENARIO: return createIntegrationScenario();
            case ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION: return createProcessComponentInteraction();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IntegrationScenario createIntegrationScenario() {
        IntegrationScenarioImpl integrationScenario = new IntegrationScenarioImpl();
        return integrationScenario;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcessComponentInteraction createProcessComponentInteraction() {
        ProcessComponentInteractionImpl processComponentInteraction = new ProcessComponentInteractionImpl();
        return processComponentInteraction;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcessintegrationPackage getProcessintegrationPackage() {
        return (ProcessintegrationPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static ProcessintegrationPackage getPackage() {
        return ProcessintegrationPackage.eINSTANCE;
    }

} //ProcessintegrationFactoryImpl
