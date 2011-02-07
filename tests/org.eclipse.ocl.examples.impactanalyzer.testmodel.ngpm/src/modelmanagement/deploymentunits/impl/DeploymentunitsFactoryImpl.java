/**
 * <copyright>
 * </copyright>
 *
 * $Id: DeploymentunitsFactoryImpl.java,v 1.1 2011/02/07 17:21:37 auhl Exp $
 */
package modelmanagement.deploymentunits.impl;

import modelmanagement.deploymentunits.*;

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
public class DeploymentunitsFactoryImpl extends EFactoryImpl implements DeploymentunitsFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static DeploymentunitsFactory init() {
        try {
            DeploymentunitsFactory theDeploymentunitsFactory = (DeploymentunitsFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/modelmanagement/deploymentunits.ecore"); 
            if (theDeploymentunitsFactory != null) {
                return theDeploymentunitsFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new DeploymentunitsFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DeploymentunitsFactoryImpl() {
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
            case DeploymentunitsPackage.DEPLOYMENT_UNIT: return createDeploymentUnit();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DeploymentUnit createDeploymentUnit() {
        DeploymentUnitImpl deploymentUnit = new DeploymentUnitImpl();
        return deploymentUnit;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DeploymentunitsPackage getDeploymentunitsPackage() {
        return (DeploymentunitsPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static DeploymentunitsPackage getPackage() {
        return DeploymentunitsPackage.eINSTANCE;
    }

} //DeploymentunitsFactoryImpl
