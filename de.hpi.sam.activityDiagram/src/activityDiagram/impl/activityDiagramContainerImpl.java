/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package activityDiagram.impl;

import activityDiagram.Activity;
import activityDiagram.ActivityDiagramPackage;
import activityDiagram.Element;
import activityDiagram.activityDiagramContainer;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>activity Diagram Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link activityDiagram.impl.activityDiagramContainerImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link activityDiagram.impl.activityDiagramContainerImpl#getActivities <em>Activities</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class activityDiagramContainerImpl extends EObjectImpl implements activityDiagramContainer {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> elements;

	/**
	 * The cached value of the '{@link #getActivities() <em>Activities</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivities()
	 * @generated
	 * @ordered
	 */
	protected Activity activities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected activityDiagramContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityDiagramPackage.Literals.ACTIVITY_DIAGRAM_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<Element>(Element.class, this, ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getActivities() {
		return activities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActivities(Activity newActivities, NotificationChain msgs) {
		Activity oldActivities = activities;
		activities = newActivities;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ACTIVITIES, oldActivities, newActivities);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivities(Activity newActivities) {
		if (newActivities != activities) {
			NotificationChain msgs = null;
			if (activities != null)
				msgs = ((InternalEObject)activities).eInverseRemove(this, ActivityDiagramPackage.ACTIVITY__CONTAINER, Activity.class, msgs);
			if (newActivities != null)
				msgs = ((InternalEObject)newActivities).eInverseAdd(this, ActivityDiagramPackage.ACTIVITY__CONTAINER, Activity.class, msgs);
			msgs = basicSetActivities(newActivities, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ACTIVITIES, newActivities, newActivities));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ACTIVITIES:
				if (activities != null)
					msgs = ((InternalEObject)activities).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ACTIVITIES, null, msgs);
				return basicSetActivities((Activity)otherEnd, msgs);
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
			case ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
			case ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ACTIVITIES:
				return basicSetActivities(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ELEMENTS:
				return getElements();
			case ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ACTIVITIES:
				return getActivities();
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
			case ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends Element>)newValue);
				return;
			case ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ACTIVITIES:
				setActivities((Activity)newValue);
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
			case ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ELEMENTS:
				getElements().clear();
				return;
			case ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ACTIVITIES:
				setActivities((Activity)null);
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
			case ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ACTIVITIES:
				return activities != null;
		}
		return super.eIsSet(featureID);
	}

} //activityDiagramContainerImpl
