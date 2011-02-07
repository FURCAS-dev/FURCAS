/**
 * <copyright>
 * </copyright>
 *
 * $Id: BusinessconfigurationAdapterFactory.java,v 1.1 2011/02/07 16:48:25 auhl Exp $
 */
package configuration.businessconfiguration.util;

import configuration.businessconfiguration.*;

import data.classes.TypedElement;

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
 * @see configuration.businessconfiguration.BusinessconfigurationPackage
 * @generated
 */
public class BusinessconfigurationAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static BusinessconfigurationPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusinessconfigurationAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = BusinessconfigurationPackage.eINSTANCE;
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
	protected BusinessconfigurationSwitch<Adapter> modelSwitch =
		new BusinessconfigurationSwitch<Adapter>() {
            @Override
            public Adapter caseScopingContext(ScopingContext object) {
                return createScopingContextAdapter();
            }
            @Override
            public Adapter caseIndustry(Industry object) {
                return createIndustryAdapter();
            }
            @Override
            public Adapter caseCountry(Country object) {
                return createCountryAdapter();
            }
            @Override
            public Adapter caseConfigurationElement(ConfigurationElement object) {
                return createConfigurationElementAdapter();
            }
            @Override
            public Adapter caseBusinessTopic(BusinessTopic object) {
                return createBusinessTopicAdapter();
            }
            @Override
            public Adapter caseBusinessPackage(BusinessPackage object) {
                return createBusinessPackageAdapter();
            }
            @Override
            public Adapter caseBusinessOption(BusinessOption object) {
                return createBusinessOptionAdapter();
            }
            @Override
            public Adapter caseBusinessArea(BusinessArea object) {
                return createBusinessAreaAdapter();
            }
            @Override
            public Adapter caseValueSet(ValueSet object) {
                return createValueSetAdapter();
            }
            @Override
            public Adapter caseValueSetEntry(ValueSetEntry object) {
                return createValueSetEntryAdapter();
            }
            @Override
            public Adapter caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
            }
            @Override
            public Adapter caseTypedElement(TypedElement object) {
                return createTypedElementAdapter();
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
     * Creates a new adapter for an object of class '{@link configuration.businessconfiguration.ScopingContext <em>Scoping Context</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see configuration.businessconfiguration.ScopingContext
     * @generated
     */
	public Adapter createScopingContextAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link configuration.businessconfiguration.Industry <em>Industry</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see configuration.businessconfiguration.Industry
     * @generated
     */
	public Adapter createIndustryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link configuration.businessconfiguration.Country <em>Country</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see configuration.businessconfiguration.Country
     * @generated
     */
	public Adapter createCountryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link configuration.businessconfiguration.ConfigurationElement <em>Configuration Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see configuration.businessconfiguration.ConfigurationElement
     * @generated
     */
	public Adapter createConfigurationElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link configuration.businessconfiguration.BusinessTopic <em>Business Topic</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see configuration.businessconfiguration.BusinessTopic
     * @generated
     */
	public Adapter createBusinessTopicAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link configuration.businessconfiguration.BusinessPackage <em>Business Package</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see configuration.businessconfiguration.BusinessPackage
     * @generated
     */
	public Adapter createBusinessPackageAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link configuration.businessconfiguration.BusinessOption <em>Business Option</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see configuration.businessconfiguration.BusinessOption
     * @generated
     */
	public Adapter createBusinessOptionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link configuration.businessconfiguration.BusinessArea <em>Business Area</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see configuration.businessconfiguration.BusinessArea
     * @generated
     */
	public Adapter createBusinessAreaAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link configuration.businessconfiguration.ValueSet <em>Value Set</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see configuration.businessconfiguration.ValueSet
     * @generated
     */
	public Adapter createValueSetAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link configuration.businessconfiguration.ValueSetEntry <em>Value Set Entry</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see configuration.businessconfiguration.ValueSetEntry
     * @generated
     */
	public Adapter createValueSetEntryAdapter() {
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

} //BusinessconfigurationAdapterFactory
