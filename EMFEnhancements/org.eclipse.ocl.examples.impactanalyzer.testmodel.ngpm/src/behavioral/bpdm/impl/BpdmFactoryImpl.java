/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.bpdm.impl;

import behavioral.bpdm.*;

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
public class BpdmFactoryImpl extends EFactoryImpl implements BpdmFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static BpdmFactory init() {
        try {
            BpdmFactory theBpdmFactory = (BpdmFactory)EPackage.Registry.INSTANCE.getEFactory("http:///behavioral/bpdm.ecore"); 
            if (theBpdmFactory != null) {
                return theBpdmFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new BpdmFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BpdmFactoryImpl() {
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
            case BpdmPackage.DUMMY: return createDummy();
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
	public BpdmPackage getBpdmPackage() {
        return (BpdmPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static BpdmPackage getPackage() {
        return BpdmPackage.eINSTANCE;
    }

} //BpdmFactoryImpl
