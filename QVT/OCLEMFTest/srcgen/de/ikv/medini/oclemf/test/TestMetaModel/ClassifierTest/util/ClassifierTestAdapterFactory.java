/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.util;

import de.ikv.medini.kernel.MediniObject;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage
 * @generated
 */
public class ClassifierTestAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ClassifierTestPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierTestAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ClassifierTestPackage.eINSTANCE;
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
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierTestSwitch modelSwitch =
		new ClassifierTestSwitch() {
			public Object caseAbstractSuperClass(AbstractSuperClass object) {
				return createAbstractSuperClassAdapter();
			}
			public Object caseSubClass(SubClass object) {
				return createSubClassAdapter();
			}
			public Object caseSuperClass(SuperClass object) {
				return createSuperClassAdapter();
			}
			public Object caseMediniObject(MediniObject object) {
				return createMediniObjectAdapter();
			}
			public Object defaultCase(EObject object) {
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
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass <em>Abstract Super Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.AbstractSuperClass
	 * @generated
	 */
	public Adapter createAbstractSuperClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass <em>Sub Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SubClass
	 * @generated
	 */
	public Adapter createSubClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SuperClass <em>Super Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SuperClass
	 * @generated
	 */
	public Adapter createSuperClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.ikv.medini.kernel.MediniObject <em>Medini Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.ikv.medini.kernel.MediniObject
	 * @generated
	 */
	public Adapter createMediniObjectAdapter() {
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

} //ClassifierTestAdapterFactory
