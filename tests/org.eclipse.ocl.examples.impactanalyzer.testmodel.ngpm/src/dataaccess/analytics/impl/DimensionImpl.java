/**
 * <copyright>
 * </copyright>
 *
 * $Id: DimensionImpl.java,v 1.1 2011/02/07 17:20:41 auhl Exp $
 */
package dataaccess.analytics.impl;

import data.classes.ClassesPackage;
import data.classes.FunctionSignature;

import dataaccess.analytics.AnalyticsPackage;
import dataaccess.analytics.CellSet;
import dataaccess.analytics.Dimension;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dimension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.analytics.impl.DimensionImpl#getCellSet <em>Cell Set</em>}</li>
 *   <li>{@link dataaccess.analytics.impl.DimensionImpl#getCharacteristicFunction <em>Characteristic Function</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DimensionImpl extends NamedElementImpl implements Dimension {
	/**
     * The cached value of the '{@link #getCharacteristicFunction() <em>Characteristic Function</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCharacteristicFunction()
     * @generated
     * @ordered
     */
	protected FunctionSignature characteristicFunction;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DimensionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return AnalyticsPackage.Literals.DIMENSION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CellSet getCellSet() {
        if (eContainerFeatureID() != AnalyticsPackage.DIMENSION__CELL_SET) return null;
        return (CellSet)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CellSet basicGetCellSet() {
        if (eContainerFeatureID() != AnalyticsPackage.DIMENSION__CELL_SET) return null;
        return (CellSet)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetCellSet(CellSet newCellSet, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newCellSet, AnalyticsPackage.DIMENSION__CELL_SET, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCellSet(CellSet newCellSet) {
        if (newCellSet != eInternalContainer() || (eContainerFeatureID() != AnalyticsPackage.DIMENSION__CELL_SET && newCellSet != null)) {
            if (EcoreUtil.isAncestor(this, newCellSet))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newCellSet != null)
                msgs = ((InternalEObject)newCellSet).eInverseAdd(this, AnalyticsPackage.CELL_SET__DIMENSIONS, CellSet.class, msgs);
            msgs = basicSetCellSet(newCellSet, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION__CELL_SET, newCellSet, newCellSet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FunctionSignature getCharacteristicFunction() {
        if (characteristicFunction != null && characteristicFunction.eIsProxy()) {
            InternalEObject oldCharacteristicFunction = (InternalEObject)characteristicFunction;
            characteristicFunction = (FunctionSignature)eResolveProxy(oldCharacteristicFunction);
            if (characteristicFunction != oldCharacteristicFunction) {
                InternalEObject newCharacteristicFunction = (InternalEObject)characteristicFunction;
                NotificationChain msgs =  oldCharacteristicFunction.eInverseRemove(this, ClassesPackage.FUNCTION_SIGNATURE__DIMENSION, FunctionSignature.class, null);
                if (newCharacteristicFunction.eInternalContainer() == null) {
                    msgs =  newCharacteristicFunction.eInverseAdd(this, ClassesPackage.FUNCTION_SIGNATURE__DIMENSION, FunctionSignature.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnalyticsPackage.DIMENSION__CHARACTERISTIC_FUNCTION, oldCharacteristicFunction, characteristicFunction));
            }
        }
        return characteristicFunction;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionSignature basicGetCharacteristicFunction() {
        return characteristicFunction;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetCharacteristicFunction(FunctionSignature newCharacteristicFunction, NotificationChain msgs) {
        FunctionSignature oldCharacteristicFunction = characteristicFunction;
        characteristicFunction = newCharacteristicFunction;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION__CHARACTERISTIC_FUNCTION, oldCharacteristicFunction, newCharacteristicFunction);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCharacteristicFunction(FunctionSignature newCharacteristicFunction) {
        if (newCharacteristicFunction != characteristicFunction) {
            NotificationChain msgs = null;
            if (characteristicFunction != null)
                msgs = ((InternalEObject)characteristicFunction).eInverseRemove(this, ClassesPackage.FUNCTION_SIGNATURE__DIMENSION, FunctionSignature.class, msgs);
            if (newCharacteristicFunction != null)
                msgs = ((InternalEObject)newCharacteristicFunction).eInverseAdd(this, ClassesPackage.FUNCTION_SIGNATURE__DIMENSION, FunctionSignature.class, msgs);
            msgs = basicSetCharacteristicFunction(newCharacteristicFunction, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION__CHARACTERISTIC_FUNCTION, newCharacteristicFunction, newCharacteristicFunction));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case AnalyticsPackage.DIMENSION__CELL_SET:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetCellSet((CellSet)otherEnd, msgs);
            case AnalyticsPackage.DIMENSION__CHARACTERISTIC_FUNCTION:
                if (characteristicFunction != null)
                    msgs = ((InternalEObject)characteristicFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.DIMENSION__CHARACTERISTIC_FUNCTION, null, msgs);
                return basicSetCharacteristicFunction((FunctionSignature)otherEnd, msgs);
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
            case AnalyticsPackage.DIMENSION__CELL_SET:
                return basicSetCellSet(null, msgs);
            case AnalyticsPackage.DIMENSION__CHARACTERISTIC_FUNCTION:
                return basicSetCharacteristicFunction(null, msgs);
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
            case AnalyticsPackage.DIMENSION__CELL_SET:
                return eInternalContainer().eInverseRemove(this, AnalyticsPackage.CELL_SET__DIMENSIONS, CellSet.class, msgs);
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
            case AnalyticsPackage.DIMENSION__CELL_SET:
                if (resolve) return getCellSet();
                return basicGetCellSet();
            case AnalyticsPackage.DIMENSION__CHARACTERISTIC_FUNCTION:
                if (resolve) return getCharacteristicFunction();
                return basicGetCharacteristicFunction();
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
            case AnalyticsPackage.DIMENSION__CELL_SET:
                setCellSet((CellSet)newValue);
                return;
            case AnalyticsPackage.DIMENSION__CHARACTERISTIC_FUNCTION:
                setCharacteristicFunction((FunctionSignature)newValue);
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
            case AnalyticsPackage.DIMENSION__CELL_SET:
                setCellSet((CellSet)null);
                return;
            case AnalyticsPackage.DIMENSION__CHARACTERISTIC_FUNCTION:
                setCharacteristicFunction((FunctionSignature)null);
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
            case AnalyticsPackage.DIMENSION__CELL_SET:
                return basicGetCellSet() != null;
            case AnalyticsPackage.DIMENSION__CHARACTERISTIC_FUNCTION:
                return characteristicFunction != null;
        }
        return super.eIsSet(featureID);
    }

} //DimensionImpl
