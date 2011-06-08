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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Injector Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.InjectorActionImpl#getInjectorActionsBlock <em>Injector Actions Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InjectorActionImpl extends EObjectImpl implements InjectorAction {
        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected InjectorActionImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TCSPackage.Literals.INJECTOR_ACTION;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InjectorActionsBlock getInjectorActionsBlock() {
        if (eContainerFeatureID() != TCSPackage.INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK) return null;
        return (InjectorActionsBlock)eContainer();
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInjectorActionsBlock(InjectorActionsBlock newInjectorActionsBlock, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newInjectorActionsBlock, TCSPackage.INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK, msgs);
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInjectorActionsBlock(InjectorActionsBlock newInjectorActionsBlock) {
        if (newInjectorActionsBlock != eInternalContainer() || (eContainerFeatureID() != TCSPackage.INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK && newInjectorActionsBlock != null)) {
            if (EcoreUtil.isAncestor(this, newInjectorActionsBlock))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInjectorActionsBlock != null)
                msgs = ((InternalEObject)newInjectorActionsBlock).eInverseAdd(this, TCSPackage.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS, InjectorActionsBlock.class, msgs);
            msgs = basicSetInjectorActionsBlock(newInjectorActionsBlock, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK, newInjectorActionsBlock, newInjectorActionsBlock));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TCSPackage.INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetInjectorActionsBlock((InjectorActionsBlock)otherEnd, msgs);
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
            case TCSPackage.INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK:
                return basicSetInjectorActionsBlock(null, msgs);
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
            case TCSPackage.INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK:
                return eInternalContainer().eInverseRemove(this, TCSPackage.INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS, InjectorActionsBlock.class, msgs);
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
            case TCSPackage.INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK:
                return getInjectorActionsBlock();
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
            case TCSPackage.INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK:
                setInjectorActionsBlock((InjectorActionsBlock)newValue);
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
            case TCSPackage.INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK:
                setInjectorActionsBlock((InjectorActionsBlock)null);
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
            case TCSPackage.INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK:
                return getInjectorActionsBlock() != null;
        }
        return super.eIsSet(featureID);
    }

} //InjectorActionImpl
