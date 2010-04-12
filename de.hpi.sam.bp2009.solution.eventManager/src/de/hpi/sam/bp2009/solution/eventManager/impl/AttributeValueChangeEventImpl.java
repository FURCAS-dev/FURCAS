/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import de.hpi.sam.bp2009.solution.eventManager.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.AttributeFilter;
import de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Value Change Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.AttributeValueChangeEventImpl#getChangedAttribute <em>Changed Attribute</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.AttributeValueChangeEventImpl#getBefore <em>Before</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.AttributeValueChangeEventImpl#getAfter <em>After</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeValueChangeEventImpl extends ElementChangeEventImpl implements AttributeValueChangeEvent {
	/**
	 * The cached value of the '{@link #getChangedAttribute() <em>Changed Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangedAttribute()
	 * @generated
	 * @ordered
	 */
	protected EAttribute changedAttribute;
	/**
	 * The default value of the '{@link #getBefore() <em>Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBefore()
	 * @generated
	 * @ordered
	 */
	protected static final Object BEFORE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getBefore() <em>Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBefore()
	 * @generated
	 * @ordered
	 */
	protected Object before = BEFORE_EDEFAULT;
	/**
	 * The default value of the '{@link #getAfter() <em>After</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAfter()
	 * @generated
	 * @ordered
	 */
	protected static final Object AFTER_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getAfter() <em>After</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAfter()
	 * @generated
	 * @ordered
	 */
	protected Object after = AFTER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeValueChangeEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.ATTRIBUTE_VALUE_CHANGE_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangedAttribute() {
		if (changedAttribute != null && changedAttribute.eIsProxy()) {
			InternalEObject oldChangedAttribute = (InternalEObject)changedAttribute;
			changedAttribute = (EAttribute)eResolveProxy(oldChangedAttribute);
			if (changedAttribute != oldChangedAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__CHANGED_ATTRIBUTE, oldChangedAttribute, changedAttribute));
			}
		}
		return changedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetChangedAttribute() {
		return changedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangedAttribute(EAttribute newChangedAttribute) {
		EAttribute oldChangedAttribute = changedAttribute;
		changedAttribute = newChangedAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__CHANGED_ATTRIBUTE, oldChangedAttribute, changedAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getBefore() {
		return before;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBefore(Object newBefore) {
		Object oldBefore = before;
		before = newBefore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__BEFORE, oldBefore, before));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAfter() {
		return after;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAfter(Object newAfter) {
		Object oldAfter = after;
		after = newAfter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__AFTER, oldAfter, after));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__CHANGED_ATTRIBUTE:
				if (resolve) return getChangedAttribute();
				return basicGetChangedAttribute();
			case EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__BEFORE:
				return getBefore();
			case EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__AFTER:
				return getAfter();
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
			case EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__CHANGED_ATTRIBUTE:
				setChangedAttribute((EAttribute)newValue);
				return;
			case EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__BEFORE:
				setBefore(newValue);
				return;
			case EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__AFTER:
				setAfter(newValue);
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
			case EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__CHANGED_ATTRIBUTE:
				setChangedAttribute((EAttribute)null);
				return;
			case EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__BEFORE:
				setBefore(BEFORE_EDEFAULT);
				return;
			case EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__AFTER:
				setAfter(AFTER_EDEFAULT);
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
			case EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__CHANGED_ATTRIBUTE:
				return changedAttribute != null;
			case EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__BEFORE:
				return BEFORE_EDEFAULT == null ? before != null : !BEFORE_EDEFAULT.equals(before);
			case EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT__AFTER:
				return AFTER_EDEFAULT == null ? after != null : !AFTER_EDEFAULT.equals(after);
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
		result.append(" (before: ");
		result.append(before);
		result.append(", after: ");
		result.append(after);
		result.append(')');
		return result.toString();
	}

	@Override
	public EventFilter getFilter() {
		EventManagerFactory f =EventManagerFactory.eINSTANCE;
		AttributeFilter attr= f.createAttributeFilter();
		attr.setAttribute(getChangedAttribute());
		EventFilter result= attr;
		if(getChangedClass()!=null){
			ClassFilter cls= f.createClassFilter();
			cls.setWantedClass(getChangedClass());
			AndFilter and = f.createAndFilter();
			and.getFilters().add(attr);
			and.getFilters().add(cls);
			result=and;
		}
		return result;
	}

} //AttributeValueChangeEventImpl
