/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExperimentalFactoryImpl.java,v 1.1 2011/02/07 16:48:24 auhl Exp $
 */
package configuration.businessconfiguration.experimental.impl;

import configuration.businessconfiguration.experimental.*;

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
public class ExperimentalFactoryImpl extends EFactoryImpl implements ExperimentalFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ExperimentalFactory init() {
        try {
            ExperimentalFactory theExperimentalFactory = (ExperimentalFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/configuration/businessconfiguration/experimental.ecore"); 
            if (theExperimentalFactory != null) {
                return theExperimentalFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ExperimentalFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExperimentalFactoryImpl() {
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
            case ExperimentalPackage.PACKAGE_USE: return createPackageUse();
            case ExperimentalPackage.CONFIGURATION_ENTITY: return createConfigurationEntity();
            case ExperimentalPackage.CONFIGURATION_SETTING: return createConfigurationSetting();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PackageUse createPackageUse() {
        PackageUseImpl packageUse = new PackageUseImpl();
        return packageUse;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ConfigurationEntity createConfigurationEntity() {
        ConfigurationEntityImpl configurationEntity = new ConfigurationEntityImpl();
        return configurationEntity;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ConfigurationSetting createConfigurationSetting() {
        ConfigurationSettingImpl configurationSetting = new ConfigurationSettingImpl();
        return configurationSetting;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExperimentalPackage getExperimentalPackage() {
        return (ExperimentalPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static ExperimentalPackage getPackage() {
        return ExperimentalPackage.eINSTANCE;
    }

} //ExperimentalFactoryImpl
