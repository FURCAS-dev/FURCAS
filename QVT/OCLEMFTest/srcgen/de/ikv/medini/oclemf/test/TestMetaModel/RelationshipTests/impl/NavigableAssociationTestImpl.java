/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl;

import de.ikv.medini.kernel.impl.MediniObjectImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticIntegerTest;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticLongTest;

import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.NavigableAssociationTest;
import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigable Association Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.NavigableAssociationTestImpl#getComponentEnd <em>Component End</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.NavigableAssociationTestImpl#getAggregate <em>Aggregate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NavigableAssociationTestImpl extends MediniObjectImpl implements NavigableAssociationTest {
	/**
	 * The cached value of the '{@link #getComponentEnd() <em>Component End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentEnd()
	 * @generated
	 * @ordered
	 */
	protected StaticIntegerTest componentEnd = null;

	/**
	 * The cached value of the '{@link #getAggregate() <em>Aggregate</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregate()
	 * @generated
	 * @ordered
	 */
	protected EList aggregate = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavigableAssociationTestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RelationshipTestsPackage.Literals.NAVIGABLE_ASSOCIATION_TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticIntegerTest getComponentEnd() {
		if (componentEnd != null && componentEnd.eIsProxy()) {
			InternalEObject oldComponentEnd = (InternalEObject)componentEnd;
			componentEnd = (StaticIntegerTest)eResolveProxy(oldComponentEnd);
			if (componentEnd != oldComponentEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipTestsPackage.NAVIGABLE_ASSOCIATION_TEST__COMPONENT_END, oldComponentEnd, componentEnd));
			}
		}
		return componentEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticIntegerTest basicGetComponentEnd() {
		return componentEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentEnd(StaticIntegerTest newComponentEnd) {
		StaticIntegerTest oldComponentEnd = componentEnd;
		componentEnd = newComponentEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationshipTestsPackage.NAVIGABLE_ASSOCIATION_TEST__COMPONENT_END, oldComponentEnd, componentEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAggregate() {
		if (aggregate == null) {
			aggregate = new EObjectResolvingEList(StaticLongTest.class, this, RelationshipTestsPackage.NAVIGABLE_ASSOCIATION_TEST__AGGREGATE);
		}
		return aggregate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RelationshipTestsPackage.NAVIGABLE_ASSOCIATION_TEST__COMPONENT_END:
				if (resolve) return getComponentEnd();
				return basicGetComponentEnd();
			case RelationshipTestsPackage.NAVIGABLE_ASSOCIATION_TEST__AGGREGATE:
				return getAggregate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RelationshipTestsPackage.NAVIGABLE_ASSOCIATION_TEST__COMPONENT_END:
				setComponentEnd((StaticIntegerTest)newValue);
				return;
			case RelationshipTestsPackage.NAVIGABLE_ASSOCIATION_TEST__AGGREGATE:
				getAggregate().clear();
				getAggregate().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case RelationshipTestsPackage.NAVIGABLE_ASSOCIATION_TEST__COMPONENT_END:
				setComponentEnd((StaticIntegerTest)null);
				return;
			case RelationshipTestsPackage.NAVIGABLE_ASSOCIATION_TEST__AGGREGATE:
				getAggregate().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RelationshipTestsPackage.NAVIGABLE_ASSOCIATION_TEST__COMPONENT_END:
				return componentEnd != null;
			case RelationshipTestsPackage.NAVIGABLE_ASSOCIATION_TEST__AGGREGATE:
				return aggregate != null && !aggregate.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NavigableAssociationTestImpl