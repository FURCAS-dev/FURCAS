/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.hpi.sam.bp2009.solution.eventManager.AttributeFilter;
import de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.AttributeFilterImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeFilterImpl extends EObjectImpl implements AttributeFilter {
	
	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EAttribute attribute;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeFilterImpl() {
		super();
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.ATTRIBUTE_FILTER;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute() {
		if (attribute != null && attribute.eIsProxy()) {
			InternalEObject oldAttribute = (InternalEObject)attribute;
			attribute = (EAttribute)eResolveProxy(oldAttribute);
			if (attribute != oldAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.ATTRIBUTE_FILTER__ATTRIBUTE, oldAttribute, attribute));
			}
		}
		return attribute;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetAttribute() {
		return attribute;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(EAttribute newAttribute) {
		EAttribute oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.ATTRIBUTE_FILTER__ATTRIBUTE, oldAttribute, attribute));
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean matchesFor(ModelChangeEvent event) {
		if(!(event.eClass().equals(EventManagerPackage.Literals.ATTRIBUTE_VALUE_CHANGE_EVENT)))
			return false;
		AttributeValueChangeEvent a= (AttributeValueChangeEvent)event;
		if(a.getChangedAttribute().equals(getAttribute()))
			return true;
		return false;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.ATTRIBUTE_FILTER__ATTRIBUTE:
				if (resolve) return getAttribute();
				return basicGetAttribute();
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
			case EventManagerPackage.ATTRIBUTE_FILTER__ATTRIBUTE:
				setAttribute((EAttribute)newValue);
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
			case EventManagerPackage.ATTRIBUTE_FILTER__ATTRIBUTE:
				setAttribute((EAttribute)null);
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
			case EventManagerPackage.ATTRIBUTE_FILTER__ATTRIBUTE:
				return attribute != null;
		}
		return super.eIsSet(featureID);
	}

} //AttributeFilterImpl
