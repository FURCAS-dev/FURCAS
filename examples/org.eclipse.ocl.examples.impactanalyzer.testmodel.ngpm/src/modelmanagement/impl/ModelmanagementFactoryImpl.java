/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelmanagementFactoryImpl.java,v 1.1 2011/02/07 16:57:59 auhl Exp $
 */
package modelmanagement.impl;

import modelmanagement.Application;
import modelmanagement.ModelmanagementFactory;
import modelmanagement.ModelmanagementPackage;
import modelmanagement.Module;
import modelmanagement.PackageOwner;

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
public class ModelmanagementFactoryImpl extends EFactoryImpl implements ModelmanagementFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ModelmanagementFactory init() {
        try {
            ModelmanagementFactory theModelmanagementFactory = (ModelmanagementFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/modelmanagement.ecore"); 
            if (theModelmanagementFactory != null) {
                return theModelmanagementFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ModelmanagementFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ModelmanagementFactoryImpl() {
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
            case ModelmanagementPackage.PACKAGE: return createPackage();
            case ModelmanagementPackage.APPLICATION: return createApplication();
            case ModelmanagementPackage.PACKAGE_OWNER: return createPackageOwner();
            case ModelmanagementPackage.MODULE: return createModule();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public modelmanagement.Package createPackage() {
        PackageImpl package_ = new PackageImpl();
        return package_;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Application createApplication() {
        ApplicationImpl application = new ApplicationImpl();
        return application;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PackageOwner createPackageOwner() {
        PackageOwnerImpl packageOwner = new PackageOwnerImpl();
        return packageOwner;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Module createModule() {
        ModuleImpl module = new ModuleImpl();
        return module;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ModelmanagementPackage getModelmanagementPackage() {
        return (ModelmanagementPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static ModelmanagementPackage getPackage() {
        return ModelmanagementPackage.eINSTANCE;
    }

} //ModelmanagementFactoryImpl
