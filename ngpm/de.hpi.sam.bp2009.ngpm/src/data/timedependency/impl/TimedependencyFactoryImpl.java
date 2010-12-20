/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.timedependency.impl;

import data.timedependency.*;

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
public class TimedependencyFactoryImpl extends EFactoryImpl implements TimedependencyFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static TimedependencyFactory init() {
        try {
            TimedependencyFactory theTimedependencyFactory = (TimedependencyFactory)EPackage.Registry.INSTANCE.getEFactory("http:///data/timedependency.ecore"); 
            if (theTimedependencyFactory != null) {
                return theTimedependencyFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new TimedependencyFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TimedependencyFactoryImpl() {
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
            case TimedependencyPackage.TIME_DEPENDENCY: return createTimeDependency();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TimeDependency createTimeDependency() {
        TimeDependencyImpl timeDependency = new TimeDependencyImpl();
        return timeDependency;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TimedependencyPackage getTimedependencyPackage() {
        return (TimedependencyPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static TimedependencyPackage getPackage() {
        return TimedependencyPackage.eINSTANCE;
    }

} //TimedependencyFactoryImpl
