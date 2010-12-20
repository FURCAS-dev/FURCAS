/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.businesstasks.impl;

import behavioral.businesstasks.*;

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
public class BusinesstasksFactoryImpl extends EFactoryImpl implements BusinesstasksFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static BusinesstasksFactory init() {
        try {
            BusinesstasksFactory theBusinesstasksFactory = (BusinesstasksFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/behavioral/businesstasks.ecore"); 
            if (theBusinesstasksFactory != null) {
                return theBusinesstasksFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new BusinesstasksFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusinesstasksFactoryImpl() {
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
            case BusinesstasksPackage.TASK_AGENT: return createTaskAgent();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TaskAgent createTaskAgent() {
        TaskAgentImpl taskAgent = new TaskAgentImpl();
        return taskAgent;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusinesstasksPackage getBusinesstasksPackage() {
        return (BusinesstasksPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static BusinesstasksPackage getPackage() {
        return BusinesstasksPackage.eINSTANCE;
    }

} //BusinesstasksFactoryImpl
