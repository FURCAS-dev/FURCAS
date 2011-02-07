/**
 * <copyright>
 * </copyright>
 *
 * $Id: QuantitystructureFactoryImpl.java,v 1.1 2011/02/07 16:49:09 auhl Exp $
 */
package data.quantitystructure.impl;

import data.quantitystructure.*;

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
public class QuantitystructureFactoryImpl extends EFactoryImpl implements QuantitystructureFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static QuantitystructureFactory init() {
        try {
            QuantitystructureFactory theQuantitystructureFactory = (QuantitystructureFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/data/quantitystructure.ecore"); 
            if (theQuantitystructureFactory != null) {
                return theQuantitystructureFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new QuantitystructureFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public QuantitystructureFactoryImpl() {
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
            case QuantitystructurePackage.DUMMY: return createDummy();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Dummy createDummy() {
        DummyImpl dummy = new DummyImpl();
        return dummy;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public QuantitystructurePackage getQuantitystructurePackage() {
        return (QuantitystructurePackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static QuantitystructurePackage getPackage() {
        return QuantitystructurePackage.eINSTANCE;
    }

} //QuantitystructureFactoryImpl
