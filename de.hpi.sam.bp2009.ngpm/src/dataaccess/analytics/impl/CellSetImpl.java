/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.analytics.impl;

import data.classes.ClassesPackage;
import data.classes.FunctionSignature;
import data.classes.TypeDefinition;

import data.classes.impl.FunctionSignatureImplementationImpl;

import dataaccess.analytics.AnalyticsPackage;
import dataaccess.analytics.CellSet;
import dataaccess.analytics.Dimension;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cell Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.analytics.impl.CellSetImpl#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link dataaccess.analytics.impl.CellSetImpl#getValueFunction <em>Value Function</em>}</li>
 *   <li>{@link dataaccess.analytics.impl.CellSetImpl#getAggregationFunction <em>Aggregation Function</em>}</li>
 *   <li>{@link dataaccess.analytics.impl.CellSetImpl#getFactsType <em>Facts Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CellSetImpl extends FunctionSignatureImplementationImpl implements CellSet {
	/**
	 * The cached value of the '{@link #getDimensions() <em>Dimensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<Dimension> dimensions;

	/**
	 * The cached value of the '{@link #getValueFunction() <em>Value Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueFunction()
	 * @generated
	 * @ordered
	 */
	protected FunctionSignature valueFunction;

	/**
	 * The cached value of the '{@link #getAggregationFunction() <em>Aggregation Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregationFunction()
	 * @generated
	 * @ordered
	 */
	protected FunctionSignature aggregationFunction;

	/**
	 * The cached value of the '{@link #getFactsType() <em>Facts Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactsType()
	 * @generated
	 * @ordered
	 */
	protected TypeDefinition factsType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CellSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalyticsPackage.Literals.CELL_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dimension> getDimensions() {
		if (dimensions == null) {
			dimensions = new EObjectContainmentWithInverseEList<Dimension>(Dimension.class, this, AnalyticsPackage.CELL_SET__DIMENSIONS, AnalyticsPackage.DIMENSION__CELL_SET);
		}
		return dimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionSignature getValueFunction() {
		return valueFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueFunction(FunctionSignature newValueFunction, NotificationChain msgs) {
		FunctionSignature oldValueFunction = valueFunction;
		valueFunction = newValueFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyticsPackage.CELL_SET__VALUE_FUNCTION, oldValueFunction, newValueFunction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueFunction(FunctionSignature newValueFunction) {
		if (newValueFunction != valueFunction) {
			NotificationChain msgs = null;
			if (valueFunction != null)
				msgs = ((InternalEObject)valueFunction).eInverseRemove(this, ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION, FunctionSignature.class, msgs);
			if (newValueFunction != null)
				msgs = ((InternalEObject)newValueFunction).eInverseAdd(this, ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION, FunctionSignature.class, msgs);
			msgs = basicSetValueFunction(newValueFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.CELL_SET__VALUE_FUNCTION, newValueFunction, newValueFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionSignature getAggregationFunction() {
		return aggregationFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAggregationFunction(FunctionSignature newAggregationFunction, NotificationChain msgs) {
		FunctionSignature oldAggregationFunction = aggregationFunction;
		aggregationFunction = newAggregationFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyticsPackage.CELL_SET__AGGREGATION_FUNCTION, oldAggregationFunction, newAggregationFunction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregationFunction(FunctionSignature newAggregationFunction) {
		if (newAggregationFunction != aggregationFunction) {
			NotificationChain msgs = null;
			if (aggregationFunction != null)
				msgs = ((InternalEObject)aggregationFunction).eInverseRemove(this, ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION, FunctionSignature.class, msgs);
			if (newAggregationFunction != null)
				msgs = ((InternalEObject)newAggregationFunction).eInverseAdd(this, ClassesPackage.FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION, FunctionSignature.class, msgs);
			msgs = basicSetAggregationFunction(newAggregationFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.CELL_SET__AGGREGATION_FUNCTION, newAggregationFunction, newAggregationFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeDefinition getFactsType() {
		return factsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFactsType(TypeDefinition newFactsType, NotificationChain msgs) {
		TypeDefinition oldFactsType = factsType;
		factsType = newFactsType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyticsPackage.CELL_SET__FACTS_TYPE, oldFactsType, newFactsType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFactsType(TypeDefinition newFactsType) {
		if (newFactsType != factsType) {
			NotificationChain msgs = null;
			if (factsType != null)
				msgs = ((InternalEObject)factsType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.CELL_SET__FACTS_TYPE, null, msgs);
			if (newFactsType != null)
				msgs = ((InternalEObject)newFactsType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.CELL_SET__FACTS_TYPE, null, msgs);
			msgs = basicSetFactsType(newFactsType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.CELL_SET__FACTS_TYPE, newFactsType, newFactsType));
	}

	/**
	 * The cached invocation delegate for the '{@link #keyFigureType() <em>Key Figure Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #keyFigureType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate KEY_FIGURE_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AnalyticsPackage.Literals.CELL_SET.getEOperations().get(0)).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeDefinition keyFigureType() {
		try {
			return (TypeDefinition)KEY_FIGURE_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #cellType() <em>Cell Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #cellType()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate CELL_TYPE__EINVOCATION_DELEGATE = ((EOperation.Internal)AnalyticsPackage.Literals.CELL_SET.getEOperations().get(1)).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeDefinition cellType() {
		try {
			return (TypeDefinition)CELL_TYPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #localIsSideEffectFree() <em>Local Is Side Effect Free</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #localIsSideEffectFree()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate LOCAL_IS_SIDE_EFFECT_FREE__EINVOCATION_DELEGATE = ((EOperation.Internal)AnalyticsPackage.Literals.CELL_SET.getEOperations().get(2)).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean localIsSideEffectFree() {
		try {
			return (Boolean)LOCAL_IS_SIDE_EFFECT_FREE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnalyticsPackage.CELL_SET__DIMENSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDimensions()).basicAdd(otherEnd, msgs);
			case AnalyticsPackage.CELL_SET__VALUE_FUNCTION:
				if (valueFunction != null)
					msgs = ((InternalEObject)valueFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.CELL_SET__VALUE_FUNCTION, null, msgs);
				return basicSetValueFunction((FunctionSignature)otherEnd, msgs);
			case AnalyticsPackage.CELL_SET__AGGREGATION_FUNCTION:
				if (aggregationFunction != null)
					msgs = ((InternalEObject)aggregationFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.CELL_SET__AGGREGATION_FUNCTION, null, msgs);
				return basicSetAggregationFunction((FunctionSignature)otherEnd, msgs);
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
			case AnalyticsPackage.CELL_SET__DIMENSIONS:
				return ((InternalEList<?>)getDimensions()).basicRemove(otherEnd, msgs);
			case AnalyticsPackage.CELL_SET__VALUE_FUNCTION:
				return basicSetValueFunction(null, msgs);
			case AnalyticsPackage.CELL_SET__AGGREGATION_FUNCTION:
				return basicSetAggregationFunction(null, msgs);
			case AnalyticsPackage.CELL_SET__FACTS_TYPE:
				return basicSetFactsType(null, msgs);
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
			case AnalyticsPackage.CELL_SET__DIMENSIONS:
				return getDimensions();
			case AnalyticsPackage.CELL_SET__VALUE_FUNCTION:
				return getValueFunction();
			case AnalyticsPackage.CELL_SET__AGGREGATION_FUNCTION:
				return getAggregationFunction();
			case AnalyticsPackage.CELL_SET__FACTS_TYPE:
				return getFactsType();
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
			case AnalyticsPackage.CELL_SET__DIMENSIONS:
				getDimensions().clear();
				getDimensions().addAll((Collection<? extends Dimension>)newValue);
				return;
			case AnalyticsPackage.CELL_SET__VALUE_FUNCTION:
				setValueFunction((FunctionSignature)newValue);
				return;
			case AnalyticsPackage.CELL_SET__AGGREGATION_FUNCTION:
				setAggregationFunction((FunctionSignature)newValue);
				return;
			case AnalyticsPackage.CELL_SET__FACTS_TYPE:
				setFactsType((TypeDefinition)newValue);
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
			case AnalyticsPackage.CELL_SET__DIMENSIONS:
				getDimensions().clear();
				return;
			case AnalyticsPackage.CELL_SET__VALUE_FUNCTION:
				setValueFunction((FunctionSignature)null);
				return;
			case AnalyticsPackage.CELL_SET__AGGREGATION_FUNCTION:
				setAggregationFunction((FunctionSignature)null);
				return;
			case AnalyticsPackage.CELL_SET__FACTS_TYPE:
				setFactsType((TypeDefinition)null);
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
			case AnalyticsPackage.CELL_SET__DIMENSIONS:
				return dimensions != null && !dimensions.isEmpty();
			case AnalyticsPackage.CELL_SET__VALUE_FUNCTION:
				return valueFunction != null;
			case AnalyticsPackage.CELL_SET__AGGREGATION_FUNCTION:
				return aggregationFunction != null;
			case AnalyticsPackage.CELL_SET__FACTS_TYPE:
				return factsType != null;
		}
		return super.eIsSet(featureID);
	}

} //CellSetImpl
