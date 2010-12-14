/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.util;

import com.sap.furcas.metamodel.FURCAS.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.EmptyDummyClassToWorkaroundGeneratorBug;
import com.sap.furcas.metamodel.FURCAS.FURCASPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.FURCAS.FURCASPackage
 * @generated
 */
public class FURCASAdapterFactory extends AdapterFactoryImpl {
        /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected static FURCASPackage modelPackage;

        /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public FURCASAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FURCASPackage.eINSTANCE;
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
        protected FURCASSwitch<Adapter> modelSwitch =
                new FURCASSwitch<Adapter>() {
			@Override
			public Adapter caseEmptyDummyClassToWorkaroundGeneratorBug(EmptyDummyClassToWorkaroundGeneratorBug object) {
				return createEmptyDummyClassToWorkaroundGeneratorBugAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.sap.furcas.metamodel.FURCAS.EmptyDummyClassToWorkaroundGeneratorBug <em>Empty Dummy Class To Workaround Generator Bug</em>}'.
	 * <!-- begin-user-doc -->
         * This default implementation returns null so that we can easily ignore cases;
         * it's useful to ignore a case when inheritance will catch all the cases anyway.
         * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.sap.furcas.metamodel.FURCAS.EmptyDummyClassToWorkaroundGeneratorBug
	 * @generated
	 */
        public Adapter createEmptyDummyClassToWorkaroundGeneratorBugAdapter() {
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

} //FURCASAdapterFactory
