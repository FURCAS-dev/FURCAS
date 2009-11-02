/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package vortrag.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import vortrag.Auto;
import vortrag.Container;
import vortrag.Person;
import vortrag.VortragPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link vortrag.impl.PersonImpl#getAlter <em>Alter</em>}</li>
 *   <li>{@link vortrag.impl.PersonImpl#getAutos <em>Autos</em>}</li>
 *   <li>{@link vortrag.impl.PersonImpl#getKinder <em>Kinder</em>}</li>
 *   <li>{@link vortrag.impl.PersonImpl#getEltern <em>Eltern</em>}</li>
 *   <li>{@link vortrag.impl.PersonImpl#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PersonImpl extends EObjectImpl implements Person {
	/**
	 * The default value of the '{@link #getAlter() <em>Alter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlter()
	 * @generated
	 * @ordered
	 */
	protected static final int ALTER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAlter() <em>Alter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlter()
	 * @generated
	 * @ordered
	 */
	protected int alter = ALTER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAutos() <em>Autos</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutos()
	 * @generated
	 * @ordered
	 */
	protected EList<Auto> autos;

	/**
	 * The cached value of the '{@link #getKinder() <em>Kinder</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKinder()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> kinder;

	/**
	 * The cached value of the '{@link #getEltern() <em>Eltern</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEltern()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> eltern;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VortragPackage.Literals.PERSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAlter() {
		return alter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlter(int newAlter) {
		int oldAlter = alter;
		alter = newAlter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VortragPackage.PERSON__ALTER, oldAlter, alter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Auto> getAutos() {
		if (autos == null) {
			autos = new EObjectWithInverseResolvingEList<Auto>(Auto.class, this, VortragPackage.PERSON__AUTOS, VortragPackage.AUTO__BESITZER);
		}
		return autos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getKinder() {
		if (kinder == null) {
			kinder = new EObjectWithInverseResolvingEList.ManyInverse<Person>(Person.class, this, VortragPackage.PERSON__KINDER, VortragPackage.PERSON__ELTERN);
		}
		return kinder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getEltern() {
		if (eltern == null) {
			eltern = new EObjectWithInverseResolvingEList.ManyInverse<Person>(Person.class, this, VortragPackage.PERSON__ELTERN, VortragPackage.PERSON__KINDER);
		}
		return eltern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container getContainer() {
		if (eContainerFeatureID() != VortragPackage.PERSON__CONTAINER) return null;
		return (Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(Container newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer, VortragPackage.PERSON__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(Container newContainer) {
		if (newContainer != eInternalContainer() || (eContainerFeatureID() != VortragPackage.PERSON__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, VortragPackage.CONTAINER__PERSON, Container.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VortragPackage.PERSON__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person bekommtKind() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void hatGeburtstag() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VortragPackage.PERSON__AUTOS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAutos()).basicAdd(otherEnd, msgs);
			case VortragPackage.PERSON__KINDER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getKinder()).basicAdd(otherEnd, msgs);
			case VortragPackage.PERSON__ELTERN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEltern()).basicAdd(otherEnd, msgs);
			case VortragPackage.PERSON__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((Container)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VortragPackage.PERSON__AUTOS:
				return ((InternalEList<?>)getAutos()).basicRemove(otherEnd, msgs);
			case VortragPackage.PERSON__KINDER:
				return ((InternalEList<?>)getKinder()).basicRemove(otherEnd, msgs);
			case VortragPackage.PERSON__ELTERN:
				return ((InternalEList<?>)getEltern()).basicRemove(otherEnd, msgs);
			case VortragPackage.PERSON__CONTAINER:
				return basicSetContainer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case VortragPackage.PERSON__CONTAINER:
				return eInternalContainer().eInverseRemove(this, VortragPackage.CONTAINER__PERSON, Container.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VortragPackage.PERSON__ALTER:
				return getAlter();
			case VortragPackage.PERSON__AUTOS:
				return getAutos();
			case VortragPackage.PERSON__KINDER:
				return getKinder();
			case VortragPackage.PERSON__ELTERN:
				return getEltern();
			case VortragPackage.PERSON__CONTAINER:
				return getContainer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VortragPackage.PERSON__ALTER:
				setAlter((Integer)newValue);
				return;
			case VortragPackage.PERSON__AUTOS:
				getAutos().clear();
				getAutos().addAll((Collection<? extends Auto>)newValue);
				return;
			case VortragPackage.PERSON__KINDER:
				getKinder().clear();
				getKinder().addAll((Collection<? extends Person>)newValue);
				return;
			case VortragPackage.PERSON__ELTERN:
				getEltern().clear();
				getEltern().addAll((Collection<? extends Person>)newValue);
				return;
			case VortragPackage.PERSON__CONTAINER:
				setContainer((Container)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VortragPackage.PERSON__ALTER:
				setAlter(ALTER_EDEFAULT);
				return;
			case VortragPackage.PERSON__AUTOS:
				getAutos().clear();
				return;
			case VortragPackage.PERSON__KINDER:
				getKinder().clear();
				return;
			case VortragPackage.PERSON__ELTERN:
				getEltern().clear();
				return;
			case VortragPackage.PERSON__CONTAINER:
				setContainer((Container)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VortragPackage.PERSON__ALTER:
				return alter != ALTER_EDEFAULT;
			case VortragPackage.PERSON__AUTOS:
				return autos != null && !autos.isEmpty();
			case VortragPackage.PERSON__KINDER:
				return kinder != null && !kinder.isEmpty();
			case VortragPackage.PERSON__ELTERN:
				return eltern != null && !eltern.isEmpty();
			case VortragPackage.PERSON__CONTAINER:
				return getContainer() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (alter: ");
		result.append(alter);
		result.append(')');
		return result.toString();
	}

} //PersonImpl
