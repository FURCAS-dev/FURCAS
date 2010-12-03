/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence In Alternative</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceInAlternativeImpl#getAlternativeContainer <em>Alternative Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceInAlternativeImpl#getDisambiguate <em>Disambiguate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceInAlternativeImpl extends SequenceImpl implements SequenceInAlternative {
        /**
	 * The default value of the '{@link #getDisambiguate() <em>Disambiguate</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getDisambiguate()
	 * @generated
	 * @ordered
	 */
        protected static final String DISAMBIGUATE_EDEFAULT = null;

        /**
	 * The cached value of the '{@link #getDisambiguate() <em>Disambiguate</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getDisambiguate()
	 * @generated
	 * @ordered
	 */
        protected String disambiguate = DISAMBIGUATE_EDEFAULT;

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected SequenceInAlternativeImpl() {
		super();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return TCSPackage.Literals.SEQUENCE_IN_ALTERNATIVE;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public Alternative getAlternativeContainer() {
		if (eContainerFeatureID() != TCSPackage.SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER) return null;
		return (Alternative)eContainer();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetAlternativeContainer(Alternative newAlternativeContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAlternativeContainer, TCSPackage.SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER, msgs);
		return msgs;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setAlternativeContainer(Alternative newAlternativeContainer) {
		if (newAlternativeContainer != eInternalContainer() || (eContainerFeatureID() != TCSPackage.SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER && newAlternativeContainer != null)) {
			if (EcoreUtil.isAncestor(this, newAlternativeContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAlternativeContainer != null)
				msgs = ((InternalEObject)newAlternativeContainer).eInverseAdd(this, TCSPackage.ALTERNATIVE__SEQUENCES, Alternative.class, msgs);
			msgs = basicSetAlternativeContainer(newAlternativeContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER, newAlternativeContainer, newAlternativeContainer));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getDisambiguate() {
		return disambiguate;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setDisambiguate(String newDisambiguate) {
		String oldDisambiguate = disambiguate;
		disambiguate = newDisambiguate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE_IN_ALTERNATIVE__DISAMBIGUATE, oldDisambiguate, disambiguate));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TCSPackage.SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAlternativeContainer((Alternative)otherEnd, msgs);
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
			case TCSPackage.SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER:
				return basicSetAlternativeContainer(null, msgs);
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
			case TCSPackage.SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER:
				return eInternalContainer().eInverseRemove(this, TCSPackage.ALTERNATIVE__SEQUENCES, Alternative.class, msgs);
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
			case TCSPackage.SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER:
				return getAlternativeContainer();
			case TCSPackage.SEQUENCE_IN_ALTERNATIVE__DISAMBIGUATE:
				return getDisambiguate();
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
			case TCSPackage.SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER:
				setAlternativeContainer((Alternative)newValue);
				return;
			case TCSPackage.SEQUENCE_IN_ALTERNATIVE__DISAMBIGUATE:
				setDisambiguate((String)newValue);
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
			case TCSPackage.SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER:
				setAlternativeContainer((Alternative)null);
				return;
			case TCSPackage.SEQUENCE_IN_ALTERNATIVE__DISAMBIGUATE:
				setDisambiguate(DISAMBIGUATE_EDEFAULT);
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
			case TCSPackage.SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER:
				return getAlternativeContainer() != null;
			case TCSPackage.SEQUENCE_IN_ALTERNATIVE__DISAMBIGUATE:
				return DISAMBIGUATE_EDEFAULT == null ? disambiguate != null : !DISAMBIGUATE_EDEFAULT.equals(disambiguate);
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
		result.append(" (disambiguate: ");
		result.append(disambiguate);
		result.append(')');
		return result.toString();
	}

} //SequenceInAlternativeImpl
