/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProcesscomponentsFactoryImpl.java,v 1.1 2011/02/07 16:57:59 auhl Exp $
 */
package modelmanagement.processcomponents.impl;

import modelmanagement.processcomponents.*;

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
public class ProcesscomponentsFactoryImpl extends EFactoryImpl implements ProcesscomponentsFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ProcesscomponentsFactory init() {
        try {
            ProcesscomponentsFactory theProcesscomponentsFactory = (ProcesscomponentsFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/modelmanagement/processcomponents.ecore"); 
            if (theProcesscomponentsFactory != null) {
                return theProcesscomponentsFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ProcesscomponentsFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcesscomponentsFactoryImpl() {
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
            case ProcesscomponentsPackage.PROCESS_COMPONENT_INSIDE_COMPANY: return createProcessComponentInsideCompany();
            case ProcesscomponentsPackage.PROCESS_COMPONENT_OUTSIDE_COMPANY: return createProcessComponentOutsideCompany();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcessComponentInsideCompany createProcessComponentInsideCompany() {
        ProcessComponentInsideCompanyImpl processComponentInsideCompany = new ProcessComponentInsideCompanyImpl();
        return processComponentInsideCompany;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcessComponentOutsideCompany createProcessComponentOutsideCompany() {
        ProcessComponentOutsideCompanyImpl processComponentOutsideCompany = new ProcessComponentOutsideCompanyImpl();
        return processComponentOutsideCompany;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ProcesscomponentsPackage getProcesscomponentsPackage() {
        return (ProcesscomponentsPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static ProcesscomponentsPackage getPackage() {
        return ProcesscomponentsPackage.eINSTANCE;
    }

} //ProcesscomponentsFactoryImpl
