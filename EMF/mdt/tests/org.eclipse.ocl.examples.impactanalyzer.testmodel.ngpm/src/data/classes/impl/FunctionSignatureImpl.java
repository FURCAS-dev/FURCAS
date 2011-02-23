/**
 * <copyright>
 * </copyright>
 *
 * $Id: FunctionSignatureImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.FunctionSignature;
import data.classes.FunctionSignatureImplementation;

import dataaccess.analytics.AnalyticsPackage;
import dataaccess.analytics.CellSet;
import dataaccess.analytics.Dimension;

import dataaccess.expressions.fp.AnonymousFunctionExpr;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.FunctionSignatureImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link data.classes.impl.FunctionSignatureImpl#getDimension <em>Dimension</em>}</li>
 *   <li>{@link data.classes.impl.FunctionSignatureImpl#getCellSetForValueFunction <em>Cell Set For Value Function</em>}</li>
 *   <li>{@link data.classes.impl.FunctionSignatureImpl#getCellSetForAggregationFunction <em>Cell Set For Aggregation Function</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionSignatureImpl extends SignatureImpl implements FunctionSignature {
	/**
     * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImplementation()
     * @generated
     * @ordered
     */
	protected FunctionSignatureImplementation implementation;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected FunctionSignatureImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.FUNCTION_SIGNATURE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FunctionSignatureImplementation getImplementation() {
        if (implementation != null && implementation.eIsProxy()) {
            InternalEObject oldImplementation = (InternalEObject)implementation;
            implementation = (FunctionSignatureImplementation)eResolveProxy(oldImplementation);
            if (implementation != oldImplementation) {
                InternalEObject newImplementation = (InternalEObject)implementation;
                NotificationChain msgs =  oldImplementation.eInverseRemove(this, ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE, FunctionSignatureImplementation.class, null);
                if (newImplementation.eInternalContainer() == null) {
                    msgs =  newImplementation.eInverseAdd(this, ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE, FunctionSignatureImplementation.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.FUNCTION_SIGNATURE__IMPLEMENTATION, oldImplementation, implementation));
            }
        }
        return implementation;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionSignatureImplementation basicGetImplementation() {
        return implementation;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetImplementation(FunctionSignatureImplementation newImplementation, NotificationChain msgs) {
        FunctionSignatureImplementation oldImplementation = implementation;
        implementation = newImplementation;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.FUNCTION_SIGNATURE__IMPLEMENTATION, oldImplementation, newImplementation);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImplementation(FunctionSignatureImplementation newImplementation) {
        if (newImplementation != implementation) {
            NotificationChain msgs = null;
            if (implementation != null)
                msgs = ((InternalEObject)implementation).eInverseRemove(this, ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE, FunctionSignatureImplementation.class, msgs);
            if (newImplementation != null)
                msgs = ((InternalEObject)newImplementation).eInverseAdd(this, ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE, FunctionSignatureImplementation.class, msgs);
            msgs = basicSetImplementation(newImplementation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.FUNCTION_SIGNATURE__IMPLEMENTATION, newImplementation, newImplementation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Dimension getDimension() {
        if (eContainerFeatureID() != ClassesPackage.FUNCTION_SIGNATURE__DIMENSION) return null;
        return (Dimension)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Dimension basicGetDimension() {
        if (eContainerFeatureID() != ClassesPackage.FUNCTION_SIGNATURE__DIMENSION) return null;
        return (Dimension)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetDimension(Dimension newDimension, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDimension, ClassesPackage.FUNCTION_SIGNATURE__DIMENSION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDimension(Dimension newDimension) {
        if (newDimension != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.FUNCTION_SIGNATURE__DIMENSION && newDimension != null)) {
            if (EcoreUtil.isAncestor(this, newDimension))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDimension != null)
                msgs = ((InternalEObject)newDimension).eInverseAdd(this, AnalyticsPackage.DIMENSION__CHARACTERISTIC_FUNCTION, Dimension.class, msgs);
            msgs = basicSetDimension(newDimension, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.FUNCTION_SIGNATURE__DIMENSION, newDimension, newDimension));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CellSet getCellSetForValueFunction() {
        if (eContainerFeatureID() != ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION) return null;
        return (CellSet)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CellSet basicGetCellSetForValueFunction() {
        if (eContainerFeatureID() != ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION) return null;
        return (CellSet)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetCellSetForValueFunction(CellSet newCellSetForValueFunction, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newCellSetForValueFunction, ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCellSetForValueFunction(CellSet newCellSetForValueFunction) {
        if (newCellSetForValueFunction != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION && newCellSetForValueFunction != null)) {
            if (EcoreUtil.isAncestor(this, newCellSetForValueFunction))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newCellSetForValueFunction != null)
                msgs = ((InternalEObject)newCellSetForValueFunction).eInverseAdd(this, AnalyticsPackage.CELL_SET__VALUE_FUNCTION, CellSet.class, msgs);
            msgs = basicSetCellSetForValueFunction(newCellSetForValueFunction, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION, newCellSetForValueFunction, newCellSetForValueFunction));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CellSet getCellSetForAggregationFunction() {
        if (eContainerFeatureID() != ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION) return null;
        return (CellSet)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CellSet basicGetCellSetForAggregationFunction() {
        if (eContainerFeatureID() != ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION) return null;
        return (CellSet)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetCellSetForAggregationFunction(CellSet newCellSetForAggregationFunction, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newCellSetForAggregationFunction, ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCellSetForAggregationFunction(CellSet newCellSetForAggregationFunction) {
        if (newCellSetForAggregationFunction != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION && newCellSetForAggregationFunction != null)) {
            if (EcoreUtil.isAncestor(this, newCellSetForAggregationFunction))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newCellSetForAggregationFunction != null)
                msgs = ((InternalEObject)newCellSetForAggregationFunction).eInverseAdd(this, AnalyticsPackage.CELL_SET__AGGREGATION_FUNCTION, CellSet.class, msgs);
            msgs = basicSetCellSetForAggregationFunction(newCellSetForAggregationFunction, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION, newCellSetForAggregationFunction, newCellSetForAggregationFunction));
    }

	/**
     * The cached invocation delegate for the '{@link #isAbstract() <em>Is Abstract</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isAbstract()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate IS_ABSTRACT__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.FUNCTION_SIGNATURE.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isAbstract() {
        try {
            return (Boolean)IS_ABSTRACT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getImplementedAnonymousFunctionExpression() <em>Get Implemented Anonymous Function Expression</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImplementedAnonymousFunctionExpression()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_IMPLEMENTED_ANONYMOUS_FUNCTION_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.FUNCTION_SIGNATURE.getEOperations().get(1)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AnonymousFunctionExpr getImplementedAnonymousFunctionExpression() {
        try {
            return (AnonymousFunctionExpr)GET_IMPLEMENTED_ANONYMOUS_FUNCTION_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ClassesPackage.FUNCTION_SIGNATURE__IMPLEMENTATION:
                if (implementation != null)
                    msgs = ((InternalEObject)implementation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.FUNCTION_SIGNATURE__IMPLEMENTATION, null, msgs);
                return basicSetImplementation((FunctionSignatureImplementation)otherEnd, msgs);
            case ClassesPackage.FUNCTION_SIGNATURE__DIMENSION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDimension((Dimension)otherEnd, msgs);
            case ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetCellSetForValueFunction((CellSet)otherEnd, msgs);
            case ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetCellSetForAggregationFunction((CellSet)otherEnd, msgs);
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
            case ClassesPackage.FUNCTION_SIGNATURE__IMPLEMENTATION:
                return basicSetImplementation(null, msgs);
            case ClassesPackage.FUNCTION_SIGNATURE__DIMENSION:
                return basicSetDimension(null, msgs);
            case ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION:
                return basicSetCellSetForValueFunction(null, msgs);
            case ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION:
                return basicSetCellSetForAggregationFunction(null, msgs);
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
            case ClassesPackage.FUNCTION_SIGNATURE__DIMENSION:
                return eInternalContainer().eInverseRemove(this, AnalyticsPackage.DIMENSION__CHARACTERISTIC_FUNCTION, Dimension.class, msgs);
            case ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION:
                return eInternalContainer().eInverseRemove(this, AnalyticsPackage.CELL_SET__VALUE_FUNCTION, CellSet.class, msgs);
            case ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION:
                return eInternalContainer().eInverseRemove(this, AnalyticsPackage.CELL_SET__AGGREGATION_FUNCTION, CellSet.class, msgs);
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
            case ClassesPackage.FUNCTION_SIGNATURE__IMPLEMENTATION:
                if (resolve) return getImplementation();
                return basicGetImplementation();
            case ClassesPackage.FUNCTION_SIGNATURE__DIMENSION:
                if (resolve) return getDimension();
                return basicGetDimension();
            case ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION:
                if (resolve) return getCellSetForValueFunction();
                return basicGetCellSetForValueFunction();
            case ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION:
                if (resolve) return getCellSetForAggregationFunction();
                return basicGetCellSetForAggregationFunction();
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
            case ClassesPackage.FUNCTION_SIGNATURE__IMPLEMENTATION:
                setImplementation((FunctionSignatureImplementation)newValue);
                return;
            case ClassesPackage.FUNCTION_SIGNATURE__DIMENSION:
                setDimension((Dimension)newValue);
                return;
            case ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION:
                setCellSetForValueFunction((CellSet)newValue);
                return;
            case ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION:
                setCellSetForAggregationFunction((CellSet)newValue);
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
            case ClassesPackage.FUNCTION_SIGNATURE__IMPLEMENTATION:
                setImplementation((FunctionSignatureImplementation)null);
                return;
            case ClassesPackage.FUNCTION_SIGNATURE__DIMENSION:
                setDimension((Dimension)null);
                return;
            case ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION:
                setCellSetForValueFunction((CellSet)null);
                return;
            case ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION:
                setCellSetForAggregationFunction((CellSet)null);
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
            case ClassesPackage.FUNCTION_SIGNATURE__IMPLEMENTATION:
                return implementation != null;
            case ClassesPackage.FUNCTION_SIGNATURE__DIMENSION:
                return basicGetDimension() != null;
            case ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION:
                return basicGetCellSetForValueFunction() != null;
            case ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION:
                return basicGetCellSetForAggregationFunction() != null;
        }
        return super.eIsSet(featureID);
    }

} //FunctionSignatureImpl
