/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package vortrag.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import vortrag.Auto;
import vortrag.Container;
import vortrag.Person;
import vortrag.VortragPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Auto</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link vortrag.impl.AutoImpl#getKennzeichen <em>Kennzeichen</em>}</li>
 *   <li>{@link vortrag.impl.AutoImpl#getMarke <em>Marke</em>}</li>
 *   <li>{@link vortrag.impl.AutoImpl#getErstzulassung <em>Erstzulassung</em>}</li>
 *   <li>{@link vortrag.impl.AutoImpl#getBaujahr <em>Baujahr</em>}</li>
 *   <li>{@link vortrag.impl.AutoImpl#getBesitzer <em>Besitzer</em>}</li>
 *   <li>{@link vortrag.impl.AutoImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link vortrag.impl.AutoImpl#getEReference0 <em>EReference0</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AutoImpl extends EObjectImpl implements Auto {
	/**
	 * The default value of the '{@link #getKennzeichen() <em>Kennzeichen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKennzeichen()
	 * @generated
	 * @ordered
	 */
	protected static final String KENNZEICHEN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKennzeichen() <em>Kennzeichen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKennzeichen()
	 * @generated
	 * @ordered
	 */
	protected String kennzeichen = KENNZEICHEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getMarke() <em>Marke</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarke()
	 * @generated
	 * @ordered
	 */
	protected static final String MARKE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMarke() <em>Marke</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarke()
	 * @generated
	 * @ordered
	 */
	protected String marke = MARKE_EDEFAULT;

	/**
	 * The default value of the '{@link #getErstzulassung() <em>Erstzulassung</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErstzulassung()
	 * @generated
	 * @ordered
	 */
	protected static final int ERSTZULASSUNG_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getErstzulassung() <em>Erstzulassung</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErstzulassung()
	 * @generated
	 * @ordered
	 */
	protected int erstzulassung = ERSTZULASSUNG_EDEFAULT;

	/**
	 * The default value of the '{@link #getBaujahr() <em>Baujahr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaujahr()
	 * @generated
	 * @ordered
	 */
	protected static final int BAUJAHR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBaujahr() <em>Baujahr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaujahr()
	 * @generated
	 * @ordered
	 */
	protected int baujahr = BAUJAHR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBesitzer() <em>Besitzer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBesitzer()
	 * @generated
	 * @ordered
	 */
	protected Person besitzer;

	/**
	 * The cached value of the '{@link #getEReference0() <em>EReference0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReference0()
	 * @generated
	 * @ordered
	 */
	protected Container eReference0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AutoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VortragPackage.Literals.AUTO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKennzeichen() {
		return kennzeichen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKennzeichen(String newKennzeichen) {
		String oldKennzeichen = kennzeichen;
		kennzeichen = newKennzeichen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VortragPackage.AUTO__KENNZEICHEN, oldKennzeichen, kennzeichen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMarke() {
		return marke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMarke(String newMarke) {
		String oldMarke = marke;
		marke = newMarke;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VortragPackage.AUTO__MARKE, oldMarke, marke));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getErstzulassung() {
		return erstzulassung;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErstzulassung(int newErstzulassung) {
		int oldErstzulassung = erstzulassung;
		erstzulassung = newErstzulassung;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VortragPackage.AUTO__ERSTZULASSUNG, oldErstzulassung, erstzulassung));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBaujahr() {
		return baujahr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaujahr(int newBaujahr) {
		int oldBaujahr = baujahr;
		baujahr = newBaujahr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VortragPackage.AUTO__BAUJAHR, oldBaujahr, baujahr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getBesitzer() {
		if (besitzer != null && besitzer.eIsProxy()) {
			InternalEObject oldBesitzer = (InternalEObject)besitzer;
			besitzer = (Person)eResolveProxy(oldBesitzer);
			if (besitzer != oldBesitzer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VortragPackage.AUTO__BESITZER, oldBesitzer, besitzer));
			}
		}
		return besitzer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person basicGetBesitzer() {
		return besitzer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBesitzer(Person newBesitzer, NotificationChain msgs) {
		Person oldBesitzer = besitzer;
		besitzer = newBesitzer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VortragPackage.AUTO__BESITZER, oldBesitzer, newBesitzer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBesitzer(Person newBesitzer) {
		if (newBesitzer != besitzer) {
			NotificationChain msgs = null;
			if (besitzer != null)
				msgs = ((InternalEObject)besitzer).eInverseRemove(this, VortragPackage.PERSON__AUTOS, Person.class, msgs);
			if (newBesitzer != null)
				msgs = ((InternalEObject)newBesitzer).eInverseAdd(this, VortragPackage.PERSON__AUTOS, Person.class, msgs);
			msgs = basicSetBesitzer(newBesitzer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VortragPackage.AUTO__BESITZER, newBesitzer, newBesitzer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container getContainer() {
		if (eContainerFeatureID() != VortragPackage.AUTO__CONTAINER) return null;
		return (Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(Container newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer, VortragPackage.AUTO__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(Container newContainer) {
		if (newContainer != eInternalContainer() || (eContainerFeatureID() != VortragPackage.AUTO__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, VortragPackage.CONTAINER__AUTO, Container.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VortragPackage.AUTO__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container getEReference0() {
		if (eReference0 != null && eReference0.eIsProxy()) {
			InternalEObject oldEReference0 = (InternalEObject)eReference0;
			eReference0 = (Container)eResolveProxy(oldEReference0);
			if (eReference0 != oldEReference0) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VortragPackage.AUTO__EREFERENCE0, oldEReference0, eReference0));
			}
		}
		return eReference0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Container basicGetEReference0() {
		return eReference0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReference0(Container newEReference0) {
		Container oldEReference0 = eReference0;
		eReference0 = newEReference0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VortragPackage.AUTO__EREFERENCE0, oldEReference0, eReference0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VortragPackage.AUTO__BESITZER:
				if (besitzer != null)
					msgs = ((InternalEObject)besitzer).eInverseRemove(this, VortragPackage.PERSON__AUTOS, Person.class, msgs);
				return basicSetBesitzer((Person)otherEnd, msgs);
			case VortragPackage.AUTO__CONTAINER:
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
			case VortragPackage.AUTO__BESITZER:
				return basicSetBesitzer(null, msgs);
			case VortragPackage.AUTO__CONTAINER:
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
			case VortragPackage.AUTO__CONTAINER:
				return eInternalContainer().eInverseRemove(this, VortragPackage.CONTAINER__AUTO, Container.class, msgs);
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
			case VortragPackage.AUTO__KENNZEICHEN:
				return getKennzeichen();
			case VortragPackage.AUTO__MARKE:
				return getMarke();
			case VortragPackage.AUTO__ERSTZULASSUNG:
				return getErstzulassung();
			case VortragPackage.AUTO__BAUJAHR:
				return getBaujahr();
			case VortragPackage.AUTO__BESITZER:
				if (resolve) return getBesitzer();
				return basicGetBesitzer();
			case VortragPackage.AUTO__CONTAINER:
				return getContainer();
			case VortragPackage.AUTO__EREFERENCE0:
				if (resolve) return getEReference0();
				return basicGetEReference0();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VortragPackage.AUTO__KENNZEICHEN:
				setKennzeichen((String)newValue);
				return;
			case VortragPackage.AUTO__MARKE:
				setMarke((String)newValue);
				return;
			case VortragPackage.AUTO__ERSTZULASSUNG:
				setErstzulassung((Integer)newValue);
				return;
			case VortragPackage.AUTO__BAUJAHR:
				setBaujahr((Integer)newValue);
				return;
			case VortragPackage.AUTO__BESITZER:
				setBesitzer((Person)newValue);
				return;
			case VortragPackage.AUTO__CONTAINER:
				setContainer((Container)newValue);
				return;
			case VortragPackage.AUTO__EREFERENCE0:
				setEReference0((Container)newValue);
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
			case VortragPackage.AUTO__KENNZEICHEN:
				setKennzeichen(KENNZEICHEN_EDEFAULT);
				return;
			case VortragPackage.AUTO__MARKE:
				setMarke(MARKE_EDEFAULT);
				return;
			case VortragPackage.AUTO__ERSTZULASSUNG:
				setErstzulassung(ERSTZULASSUNG_EDEFAULT);
				return;
			case VortragPackage.AUTO__BAUJAHR:
				setBaujahr(BAUJAHR_EDEFAULT);
				return;
			case VortragPackage.AUTO__BESITZER:
				setBesitzer((Person)null);
				return;
			case VortragPackage.AUTO__CONTAINER:
				setContainer((Container)null);
				return;
			case VortragPackage.AUTO__EREFERENCE0:
				setEReference0((Container)null);
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
			case VortragPackage.AUTO__KENNZEICHEN:
				return KENNZEICHEN_EDEFAULT == null ? kennzeichen != null : !KENNZEICHEN_EDEFAULT.equals(kennzeichen);
			case VortragPackage.AUTO__MARKE:
				return MARKE_EDEFAULT == null ? marke != null : !MARKE_EDEFAULT.equals(marke);
			case VortragPackage.AUTO__ERSTZULASSUNG:
				return erstzulassung != ERSTZULASSUNG_EDEFAULT;
			case VortragPackage.AUTO__BAUJAHR:
				return baujahr != BAUJAHR_EDEFAULT;
			case VortragPackage.AUTO__BESITZER:
				return besitzer != null;
			case VortragPackage.AUTO__CONTAINER:
				return getContainer() != null;
			case VortragPackage.AUTO__EREFERENCE0:
				return eReference0 != null;
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
		result.append(" (kennzeichen: ");
		result.append(kennzeichen);
		result.append(", marke: ");
		result.append(marke);
		result.append(", erstzulassung: ");
		result.append(erstzulassung);
		result.append(", baujahr: ");
		result.append(baujahr);
		result.append(')');
		return result.toString();
	}

} //AutoImpl
