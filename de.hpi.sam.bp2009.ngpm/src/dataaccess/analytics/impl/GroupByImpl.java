/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.analytics.impl;

import behavioral.actions.Iterator;

import dataaccess.analytics.AnalyticsPackage;
import dataaccess.analytics.DimensionDefinition;
import dataaccess.analytics.GroupBy;

import dataaccess.expressions.Expression;

import dataaccess.expressions.impl.ObjectBasedExpressionImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group By</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.analytics.impl.GroupByImpl#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link dataaccess.analytics.impl.GroupByImpl#getFact <em>Fact</em>}</li>
 *   <li>{@link dataaccess.analytics.impl.GroupByImpl#getMapExpression <em>Map Expression</em>}</li>
 *   <li>{@link dataaccess.analytics.impl.GroupByImpl#getGroupedFacts <em>Grouped Facts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupByImpl extends ObjectBasedExpressionImpl implements GroupBy {
	/**
	 * The cached value of the '{@link #getDimensions() <em>Dimensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<DimensionDefinition> dimensions;

	/**
	 * The cached value of the '{@link #getFact() <em>Fact</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFact()
	 * @generated
	 * @ordered
	 */
	protected Iterator fact;

	/**
	 * The cached value of the '{@link #getMapExpression() <em>Map Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression mapExpression;

	/**
	 * The cached value of the '{@link #getGroupedFacts() <em>Grouped Facts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupedFacts()
	 * @generated
	 * @ordered
	 */
	protected Iterator groupedFacts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupByImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalyticsPackage.Literals.GROUP_BY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DimensionDefinition> getDimensions() {
		if (dimensions == null) {
			dimensions = new EObjectContainmentEList<DimensionDefinition>(DimensionDefinition.class, this, AnalyticsPackage.GROUP_BY__DIMENSIONS);
		}
		return dimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterator getFact() {
		return fact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFact(Iterator newFact, NotificationChain msgs) {
		Iterator oldFact = fact;
		fact = newFact;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyticsPackage.GROUP_BY__FACT, oldFact, newFact);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFact(Iterator newFact) {
		if (newFact != fact) {
			NotificationChain msgs = null;
			if (fact != null)
				msgs = ((InternalEObject)fact).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.GROUP_BY__FACT, null, msgs);
			if (newFact != null)
				msgs = ((InternalEObject)newFact).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.GROUP_BY__FACT, null, msgs);
			msgs = basicSetFact(newFact, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.GROUP_BY__FACT, newFact, newFact));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getMapExpression() {
		return mapExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMapExpression(Expression newMapExpression, NotificationChain msgs) {
		Expression oldMapExpression = mapExpression;
		mapExpression = newMapExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyticsPackage.GROUP_BY__MAP_EXPRESSION, oldMapExpression, newMapExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapExpression(Expression newMapExpression) {
		if (newMapExpression != mapExpression) {
			NotificationChain msgs = null;
			if (mapExpression != null)
				msgs = ((InternalEObject)mapExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.GROUP_BY__MAP_EXPRESSION, null, msgs);
			if (newMapExpression != null)
				msgs = ((InternalEObject)newMapExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.GROUP_BY__MAP_EXPRESSION, null, msgs);
			msgs = basicSetMapExpression(newMapExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.GROUP_BY__MAP_EXPRESSION, newMapExpression, newMapExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterator getGroupedFacts() {
		return groupedFacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroupedFacts(Iterator newGroupedFacts, NotificationChain msgs) {
		Iterator oldGroupedFacts = groupedFacts;
		groupedFacts = newGroupedFacts;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyticsPackage.GROUP_BY__GROUPED_FACTS, oldGroupedFacts, newGroupedFacts);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupedFacts(Iterator newGroupedFacts) {
		if (newGroupedFacts != groupedFacts) {
			NotificationChain msgs = null;
			if (groupedFacts != null)
				msgs = ((InternalEObject)groupedFacts).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.GROUP_BY__GROUPED_FACTS, null, msgs);
			if (newGroupedFacts != null)
				msgs = ((InternalEObject)newGroupedFacts).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.GROUP_BY__GROUPED_FACTS, null, msgs);
			msgs = basicSetGroupedFacts(newGroupedFacts, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.GROUP_BY__GROUPED_FACTS, newGroupedFacts, newGroupedFacts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnalyticsPackage.GROUP_BY__DIMENSIONS:
				return ((InternalEList<?>)getDimensions()).basicRemove(otherEnd, msgs);
			case AnalyticsPackage.GROUP_BY__FACT:
				return basicSetFact(null, msgs);
			case AnalyticsPackage.GROUP_BY__MAP_EXPRESSION:
				return basicSetMapExpression(null, msgs);
			case AnalyticsPackage.GROUP_BY__GROUPED_FACTS:
				return basicSetGroupedFacts(null, msgs);
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
			case AnalyticsPackage.GROUP_BY__DIMENSIONS:
				return getDimensions();
			case AnalyticsPackage.GROUP_BY__FACT:
				return getFact();
			case AnalyticsPackage.GROUP_BY__MAP_EXPRESSION:
				return getMapExpression();
			case AnalyticsPackage.GROUP_BY__GROUPED_FACTS:
				return getGroupedFacts();
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
			case AnalyticsPackage.GROUP_BY__DIMENSIONS:
				getDimensions().clear();
				getDimensions().addAll((Collection<? extends DimensionDefinition>)newValue);
				return;
			case AnalyticsPackage.GROUP_BY__FACT:
				setFact((Iterator)newValue);
				return;
			case AnalyticsPackage.GROUP_BY__MAP_EXPRESSION:
				setMapExpression((Expression)newValue);
				return;
			case AnalyticsPackage.GROUP_BY__GROUPED_FACTS:
				setGroupedFacts((Iterator)newValue);
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
			case AnalyticsPackage.GROUP_BY__DIMENSIONS:
				getDimensions().clear();
				return;
			case AnalyticsPackage.GROUP_BY__FACT:
				setFact((Iterator)null);
				return;
			case AnalyticsPackage.GROUP_BY__MAP_EXPRESSION:
				setMapExpression((Expression)null);
				return;
			case AnalyticsPackage.GROUP_BY__GROUPED_FACTS:
				setGroupedFacts((Iterator)null);
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
			case AnalyticsPackage.GROUP_BY__DIMENSIONS:
				return dimensions != null && !dimensions.isEmpty();
			case AnalyticsPackage.GROUP_BY__FACT:
				return fact != null;
			case AnalyticsPackage.GROUP_BY__MAP_EXPRESSION:
				return mapExpression != null;
			case AnalyticsPackage.GROUP_BY__GROUPED_FACTS:
				return groupedFacts != null;
		}
		return super.eIsSet(featureID);
	}

} //GroupByImpl
