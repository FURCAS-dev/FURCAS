/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.businessconfiguration.impl;

import configuration.businessconfiguration.*;

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
public class BusinessconfigurationFactoryImpl extends EFactoryImpl implements BusinessconfigurationFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static BusinessconfigurationFactory init() {
        try {
            BusinessconfigurationFactory theBusinessconfigurationFactory = (BusinessconfigurationFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/configuration/businessconfiguration.ecore"); 
            if (theBusinessconfigurationFactory != null) {
                return theBusinessconfigurationFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new BusinessconfigurationFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusinessconfigurationFactoryImpl() {
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
            case BusinessconfigurationPackage.SCOPING_CONTEXT: return createScopingContext();
            case BusinessconfigurationPackage.INDUSTRY: return createIndustry();
            case BusinessconfigurationPackage.COUNTRY: return createCountry();
            case BusinessconfigurationPackage.CONFIGURATION_ELEMENT: return createConfigurationElement();
            case BusinessconfigurationPackage.BUSINESS_TOPIC: return createBusinessTopic();
            case BusinessconfigurationPackage.BUSINESS_PACKAGE: return createBusinessPackage();
            case BusinessconfigurationPackage.BUSINESS_OPTION: return createBusinessOption();
            case BusinessconfigurationPackage.BUSINESS_AREA: return createBusinessArea();
            case BusinessconfigurationPackage.VALUE_SET: return createValueSet();
            case BusinessconfigurationPackage.VALUE_SET_ENTRY: return createValueSetEntry();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ScopingContext createScopingContext() {
        ScopingContextImpl scopingContext = new ScopingContextImpl();
        return scopingContext;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Industry createIndustry() {
        IndustryImpl industry = new IndustryImpl();
        return industry;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Country createCountry() {
        CountryImpl country = new CountryImpl();
        return country;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ConfigurationElement createConfigurationElement() {
        ConfigurationElementImpl configurationElement = new ConfigurationElementImpl();
        return configurationElement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusinessTopic createBusinessTopic() {
        BusinessTopicImpl businessTopic = new BusinessTopicImpl();
        return businessTopic;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusinessPackage createBusinessPackage() {
        BusinessPackageImpl businessPackage = new BusinessPackageImpl();
        return businessPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusinessOption createBusinessOption() {
        BusinessOptionImpl businessOption = new BusinessOptionImpl();
        return businessOption;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusinessArea createBusinessArea() {
        BusinessAreaImpl businessArea = new BusinessAreaImpl();
        return businessArea;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ValueSet createValueSet() {
        ValueSetImpl valueSet = new ValueSetImpl();
        return valueSet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ValueSetEntry createValueSetEntry() {
        ValueSetEntryImpl valueSetEntry = new ValueSetEntryImpl();
        return valueSetEntry;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusinessconfigurationPackage getBusinessconfigurationPackage() {
        return (BusinessconfigurationPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static BusinessconfigurationPackage getPackage() {
        return BusinessconfigurationPackage.eINSTANCE;
    }

} //BusinessconfigurationFactoryImpl
