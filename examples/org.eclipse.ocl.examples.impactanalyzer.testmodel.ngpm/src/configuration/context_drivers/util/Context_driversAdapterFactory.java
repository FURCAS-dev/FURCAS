/**
 * <copyright>
 * </copyright>
 *
 * $Id: Context_driversAdapterFactory.java,v 1.1 2011/02/07 16:43:33 auhl Exp $
 */
package configuration.context_drivers.util;

import configuration.context_drivers.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see configuration.context_drivers.Context_driversPackage
 * @generated
 */
public class Context_driversAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static Context_driversPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Context_driversAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = Context_driversPackage.eINSTANCE;
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
	protected Context_driversSwitch<Adapter> modelSwitch =
		new Context_driversSwitch<Adapter>() {
            @Override
            public Adapter caseContextCategory(ContextCategory object) {
                return createContextCategoryAdapter();
            }
            @Override
            public Adapter caseContextCategoryValue(ContextCategoryValue object) {
                return createContextCategoryValueAdapter();
            }
            @Override
            public Adapter caseContextualElement(ContextualElement object) {
                return createContextualElementAdapter();
            }
            @Override
            public Adapter caseContexConfiguration(ContexConfiguration object) {
                return createContexConfigurationAdapter();
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
     * Creates a new adapter for an object of class '{@link configuration.context_drivers.ContextCategory <em>Context Category</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see configuration.context_drivers.ContextCategory
     * @generated
     */
	public Adapter createContextCategoryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link configuration.context_drivers.ContextCategoryValue <em>Context Category Value</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see configuration.context_drivers.ContextCategoryValue
     * @generated
     */
	public Adapter createContextCategoryValueAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link configuration.context_drivers.ContextualElement <em>Contextual Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see configuration.context_drivers.ContextualElement
     * @generated
     */
	public Adapter createContextualElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link configuration.context_drivers.ContexConfiguration <em>Contex Configuration</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see configuration.context_drivers.ContexConfiguration
     * @generated
     */
	public Adapter createContexConfigurationAdapter() {
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

} //Context_driversAdapterFactory
