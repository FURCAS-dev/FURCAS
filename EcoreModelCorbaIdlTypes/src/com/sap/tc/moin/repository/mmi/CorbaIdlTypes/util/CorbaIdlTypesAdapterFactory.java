/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.CorbaIdlTypes.util;

import com.sap.tc.moin.repository.mmi.CorbaIdlTypes.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaIdlTypesPackage
 * @generated
 */
public class CorbaIdlTypesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CorbaIdlTypesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorbaIdlTypesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CorbaIdlTypesPackage.eINSTANCE;
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
	protected CorbaIdlTypesSwitch<Adapter> modelSwitch =
		new CorbaIdlTypesSwitch<Adapter>() {
			@Override
			public Adapter caseCorbaOctet(CorbaOctet object) {
				return createCorbaOctetAdapter();
			}
			@Override
			public Adapter caseCorbaShort(CorbaShort object) {
				return createCorbaShortAdapter();
			}
			@Override
			public Adapter caseCorbaUnsignedShort(CorbaUnsignedShort object) {
				return createCorbaUnsignedShortAdapter();
			}
			@Override
			public Adapter caseCorbaUnsignedLong(CorbaUnsignedLong object) {
				return createCorbaUnsignedLongAdapter();
			}
			@Override
			public Adapter caseCorbaUnsignedLongLong(CorbaUnsignedLongLong object) {
				return createCorbaUnsignedLongLongAdapter();
			}
			@Override
			public Adapter caseCorbaLongDouble(CorbaLongDouble object) {
				return createCorbaLongDoubleAdapter();
			}
			@Override
			public Adapter caseCorbaString(CorbaString object) {
				return createCorbaStringAdapter();
			}
			@Override
			public Adapter caseCorbaChar(CorbaChar object) {
				return createCorbaCharAdapter();
			}
			@Override
			public Adapter caseCorbaWChar(CorbaWChar object) {
				return createCorbaWCharAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaOctet <em>Corba Octet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaOctet
	 * @generated
	 */
	public Adapter createCorbaOctetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaShort <em>Corba Short</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaShort
	 * @generated
	 */
	public Adapter createCorbaShortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaUnsignedShort <em>Corba Unsigned Short</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaUnsignedShort
	 * @generated
	 */
	public Adapter createCorbaUnsignedShortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaUnsignedLong <em>Corba Unsigned Long</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaUnsignedLong
	 * @generated
	 */
	public Adapter createCorbaUnsignedLongAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaUnsignedLongLong <em>Corba Unsigned Long Long</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaUnsignedLongLong
	 * @generated
	 */
	public Adapter createCorbaUnsignedLongLongAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaLongDouble <em>Corba Long Double</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaLongDouble
	 * @generated
	 */
	public Adapter createCorbaLongDoubleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaString <em>Corba String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaString
	 * @generated
	 */
	public Adapter createCorbaStringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaChar <em>Corba Char</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaChar
	 * @generated
	 */
	public Adapter createCorbaCharAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaWChar <em>Corba WChar</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaWChar
	 * @generated
	 */
	public Adapter createCorbaWCharAdapter() {
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

} //CorbaIdlTypesAdapterFactory
