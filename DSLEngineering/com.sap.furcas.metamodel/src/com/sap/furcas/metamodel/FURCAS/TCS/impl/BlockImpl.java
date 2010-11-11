/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.BlockArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.BlockImpl#getBlockSequence <em>Block Sequence</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.BlockImpl#getBlockArgs <em>Block Args</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockImpl extends SequenceElementImpl implements Block {
        /**
	 * The cached value of the '{@link #getBlockSequence() <em>Block Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getBlockSequence()
	 * @generated
	 * @ordered
	 */
        protected Sequence blockSequence;

        /**
	 * The cached value of the '{@link #getBlockArgs() <em>Block Args</em>}' containment reference list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getBlockArgs()
	 * @generated
	 * @ordered
	 */
        protected EList<BlockArg> blockArgs;

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected BlockImpl() {
		super();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return TCSPackage.Literals.BLOCK;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public Sequence getBlockSequence() {
		return blockSequence;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetBlockSequence(Sequence newBlockSequence, NotificationChain msgs) {
		Sequence oldBlockSequence = blockSequence;
		blockSequence = newBlockSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.BLOCK__BLOCK_SEQUENCE, oldBlockSequence, newBlockSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setBlockSequence(Sequence newBlockSequence) {
		if (newBlockSequence != blockSequence) {
			NotificationChain msgs = null;
			if (blockSequence != null)
				msgs = ((InternalEObject)blockSequence).eInverseRemove(this, TCSPackage.SEQUENCE__BLOCK_CONTAINER, Sequence.class, msgs);
			if (newBlockSequence != null)
				msgs = ((InternalEObject)newBlockSequence).eInverseAdd(this, TCSPackage.SEQUENCE__BLOCK_CONTAINER, Sequence.class, msgs);
			msgs = basicSetBlockSequence(newBlockSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.BLOCK__BLOCK_SEQUENCE, newBlockSequence, newBlockSequence));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EList<BlockArg> getBlockArgs() {
		if (blockArgs == null) {
			blockArgs = new EObjectContainmentWithInverseEList<BlockArg>(BlockArg.class, this, TCSPackage.BLOCK__BLOCK_ARGS, TCSPackage.BLOCK_ARG__BLOCK);
		}
		return blockArgs;
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
			case TCSPackage.BLOCK__BLOCK_SEQUENCE:
				if (blockSequence != null)
					msgs = ((InternalEObject)blockSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.BLOCK__BLOCK_SEQUENCE, null, msgs);
				return basicSetBlockSequence((Sequence)otherEnd, msgs);
			case TCSPackage.BLOCK__BLOCK_ARGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBlockArgs()).basicAdd(otherEnd, msgs);
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
			case TCSPackage.BLOCK__BLOCK_SEQUENCE:
				return basicSetBlockSequence(null, msgs);
			case TCSPackage.BLOCK__BLOCK_ARGS:
				return ((InternalEList<?>)getBlockArgs()).basicRemove(otherEnd, msgs);
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
			case TCSPackage.BLOCK__BLOCK_SEQUENCE:
				return getBlockSequence();
			case TCSPackage.BLOCK__BLOCK_ARGS:
				return getBlockArgs();
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
			case TCSPackage.BLOCK__BLOCK_SEQUENCE:
				setBlockSequence((Sequence)newValue);
				return;
			case TCSPackage.BLOCK__BLOCK_ARGS:
				getBlockArgs().clear();
				getBlockArgs().addAll((Collection<? extends BlockArg>)newValue);
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
			case TCSPackage.BLOCK__BLOCK_SEQUENCE:
				setBlockSequence((Sequence)null);
				return;
			case TCSPackage.BLOCK__BLOCK_ARGS:
				getBlockArgs().clear();
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
			case TCSPackage.BLOCK__BLOCK_SEQUENCE:
				return blockSequence != null;
			case TCSPackage.BLOCK__BLOCK_ARGS:
				return blockArgs != null && !blockArgs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BlockImpl
