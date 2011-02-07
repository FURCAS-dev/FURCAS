/**
 * <copyright>
 * </copyright>
 *
 * $Id: BindingAdapterFactory.java,v 1.1 2011/02/07 17:21:39 auhl Exp $
 */
package integration.binding.util;

import integration.binding.*;

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
 * @see integration.binding.BindingPackage
 * @generated
 */
public class BindingAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static BindingPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BindingAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = BindingPackage.eINSTANCE;
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
	protected BindingSwitch<Adapter> modelSwitch =
		new BindingSwitch<Adapter>() {
            @Override
            public Adapter caseBinding(Binding object) {
                return createBindingAdapter();
            }
            @Override
            public Adapter caseHttpBinding(HttpBinding object) {
                return createHttpBindingAdapter();
            }
            @Override
            public Adapter caseHttpGetBinding(HttpGetBinding object) {
                return createHttpGetBindingAdapter();
            }
            @Override
            public Adapter caseHttpPutBinding(HttpPutBinding object) {
                return createHttpPutBindingAdapter();
            }
            @Override
            public Adapter caseUrlPattern(UrlPattern object) {
                return createUrlPatternAdapter();
            }
            @Override
            public Adapter caseSimpleUrlPattern(SimpleUrlPattern object) {
                return createSimpleUrlPatternAdapter();
            }
            @Override
            public Adapter caseRestUrlPattern(RestUrlPattern object) {
                return createRestUrlPatternAdapter();
            }
            @Override
            public Adapter caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
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
     * Creates a new adapter for an object of class '{@link integration.binding.Binding <em>Binding</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.binding.Binding
     * @generated
     */
	public Adapter createBindingAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.binding.HttpBinding <em>Http Binding</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.binding.HttpBinding
     * @generated
     */
	public Adapter createHttpBindingAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.binding.HttpGetBinding <em>Http Get Binding</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.binding.HttpGetBinding
     * @generated
     */
	public Adapter createHttpGetBindingAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.binding.HttpPutBinding <em>Http Put Binding</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.binding.HttpPutBinding
     * @generated
     */
	public Adapter createHttpPutBindingAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.binding.UrlPattern <em>Url Pattern</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.binding.UrlPattern
     * @generated
     */
	public Adapter createUrlPatternAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.binding.SimpleUrlPattern <em>Simple Url Pattern</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.binding.SimpleUrlPattern
     * @generated
     */
	public Adapter createSimpleUrlPatternAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.binding.RestUrlPattern <em>Rest Url Pattern</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.binding.RestUrlPattern
     * @generated
     */
	public Adapter createRestUrlPatternAdapter() {
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

} //BindingAdapterFactory
