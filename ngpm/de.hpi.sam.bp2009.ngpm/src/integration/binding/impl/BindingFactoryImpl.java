/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.binding.impl;

import integration.binding.*;

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
public class BindingFactoryImpl extends EFactoryImpl implements BindingFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static BindingFactory init() {
        try {
            BindingFactory theBindingFactory = (BindingFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/integration/binding.ecore"); 
            if (theBindingFactory != null) {
                return theBindingFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new BindingFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BindingFactoryImpl() {
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
            case BindingPackage.HTTP_GET_BINDING: return createHttpGetBinding();
            case BindingPackage.HTTP_PUT_BINDING: return createHttpPutBinding();
            case BindingPackage.SIMPLE_URL_PATTERN: return createSimpleUrlPattern();
            case BindingPackage.REST_URL_PATTERN: return createRestUrlPattern();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public HttpGetBinding createHttpGetBinding() {
        HttpGetBindingImpl httpGetBinding = new HttpGetBindingImpl();
        return httpGetBinding;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public HttpPutBinding createHttpPutBinding() {
        HttpPutBindingImpl httpPutBinding = new HttpPutBindingImpl();
        return httpPutBinding;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SimpleUrlPattern createSimpleUrlPattern() {
        SimpleUrlPatternImpl simpleUrlPattern = new SimpleUrlPatternImpl();
        return simpleUrlPattern;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RestUrlPattern createRestUrlPattern() {
        RestUrlPatternImpl restUrlPattern = new RestUrlPatternImpl();
        return restUrlPattern;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BindingPackage getBindingPackage() {
        return (BindingPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static BindingPackage getPackage() {
        return BindingPackage.eINSTANCE;
    }

} //BindingFactoryImpl
