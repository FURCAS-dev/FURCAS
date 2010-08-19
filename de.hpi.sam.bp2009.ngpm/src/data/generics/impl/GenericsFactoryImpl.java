/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.generics.impl;

import data.generics.*;

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
public class GenericsFactoryImpl extends EFactoryImpl implements GenericsFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static GenericsFactory init() {
        try {
            GenericsFactory theGenericsFactory = (GenericsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///data/generics.ecore"); 
            if (theGenericsFactory != null) {
                return theGenericsFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new GenericsFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GenericsFactoryImpl() {
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
            case GenericsPackage.FORMAL_TYPE_PARAMETER: return createFormalTypeParameter();
            case GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION: return createParameterizedClassInstantiation();
            case GenericsPackage.CLASS_PARAMETERIZATION: return createClassParameterization();
            case GenericsPackage.ACTUAL_TYPE_PARAMETER: return createActualTypeParameter();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FormalTypeParameter createFormalTypeParameter() {
        FormalTypeParameterImpl formalTypeParameter = new FormalTypeParameterImpl();
        return formalTypeParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ParameterizedClassInstantiation createParameterizedClassInstantiation() {
        ParameterizedClassInstantiationImpl parameterizedClassInstantiation = new ParameterizedClassInstantiationImpl();
        return parameterizedClassInstantiation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ClassParameterization createClassParameterization() {
        ClassParameterizationImpl classParameterization = new ClassParameterizationImpl();
        return classParameterization;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ActualTypeParameter createActualTypeParameter() {
        ActualTypeParameterImpl actualTypeParameter = new ActualTypeParameterImpl();
        return actualTypeParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GenericsPackage getGenericsPackage() {
        return (GenericsPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static GenericsPackage getPackage() {
        return GenericsPackage.eINSTANCE;
    }

} //GenericsFactoryImpl
