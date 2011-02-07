/**
 * <copyright>
 * </copyright>
 *
 * $Id: CollectionexpressionsFactoryImpl.java,v 1.1 2011/02/07 17:16:11 auhl Exp $
 */
package dataaccess.expressions.collectionexpressions.impl;

import dataaccess.expressions.collectionexpressions.*;

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
public class CollectionexpressionsFactoryImpl extends EFactoryImpl implements CollectionexpressionsFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static CollectionexpressionsFactory init() {
        try {
            CollectionexpressionsFactory theCollectionexpressionsFactory = (CollectionexpressionsFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/dataaccess/expressions/collectionexpressions.ecore"); 
            if (theCollectionexpressionsFactory != null) {
                return theCollectionexpressionsFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new CollectionexpressionsFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CollectionexpressionsFactoryImpl() {
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
            case CollectionexpressionsPackage.INCLUDING: return createIncluding();
            case CollectionexpressionsPackage.EXCLUDING: return createExcluding();
            case CollectionexpressionsPackage.INCLUDING_AT: return createIncludingAt();
            case CollectionexpressionsPackage.ITERATE: return createIterate();
            case CollectionexpressionsPackage.EXCLUDING_AT: return createExcludingAt();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Including createIncluding() {
        IncludingImpl including = new IncludingImpl();
        return including;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Excluding createExcluding() {
        ExcludingImpl excluding = new ExcludingImpl();
        return excluding;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IncludingAt createIncludingAt() {
        IncludingAtImpl includingAt = new IncludingAtImpl();
        return includingAt;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Iterate createIterate() {
        IterateImpl iterate = new IterateImpl();
        return iterate;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExcludingAt createExcludingAt() {
        ExcludingAtImpl excludingAt = new ExcludingAtImpl();
        return excludingAt;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CollectionexpressionsPackage getCollectionexpressionsPackage() {
        return (CollectionexpressionsPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static CollectionexpressionsPackage getPackage() {
        return CollectionexpressionsPackage.eINSTANCE;
    }

} //CollectionexpressionsFactoryImpl
