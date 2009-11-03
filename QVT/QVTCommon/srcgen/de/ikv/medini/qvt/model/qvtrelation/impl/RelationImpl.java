/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtrelation.impl;

import de.ikv.medini.qvt.model.qvtbase.Pattern;
import de.ikv.medini.qvt.model.qvtbase.QvtBasePackage;

import de.ikv.medini.qvt.model.qvtbase.impl.RuleImpl;

import de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationImplementation;

import de.ikv.medini.qvt.qvt.QvtVisitor;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.impl.RelationImpl#isIsTopLevel <em>Is Top Level</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.impl.RelationImpl#getWhere <em>Where</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.impl.RelationImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.impl.RelationImpl#getOperationalImpl <em>Operational Impl</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.impl.RelationImpl#getWhen <em>When</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationImpl extends RuleImpl implements Relation {
	/**
	 * The default value of the '{@link #isIsTopLevel() <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTopLevel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TOP_LEVEL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsTopLevel() <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTopLevel()
	 * @generated
	 * @ordered
	 */
	protected boolean isTopLevel = IS_TOP_LEVEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWhere() <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhere()
	 * @generated
	 * @ordered
	 */
	protected Pattern where;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected EList variable;

	/**
	 * The cached value of the '{@link #getOperationalImpl() <em>Operational Impl</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationalImpl()
	 * @generated
	 * @ordered
	 */
	protected EList operationalImpl;

	/**
	 * The cached value of the '{@link #getWhen() <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
	protected Pattern when;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QvtRelationPackage.Literals.RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsTopLevel() {
		return isTopLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTopLevel(boolean newIsTopLevel) {
		boolean oldIsTopLevel = isTopLevel;
		isTopLevel = newIsTopLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtRelationPackage.RELATION__IS_TOP_LEVEL, oldIsTopLevel, isTopLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getWhere() {
		return where;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhere(Pattern newWhere, NotificationChain msgs) {
		Pattern oldWhere = where;
		where = newWhere;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtRelationPackage.RELATION__WHERE, oldWhere, newWhere);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhere(Pattern newWhere) {
		if (newWhere != where) {
			NotificationChain msgs = null;
			if (where != null)
				msgs = ((InternalEObject)where).eInverseRemove(this, QvtBasePackage.PATTERN__WHERE_OWNER, Pattern.class, msgs);
			if (newWhere != null)
				msgs = ((InternalEObject)newWhere).eInverseAdd(this, QvtBasePackage.PATTERN__WHERE_OWNER, Pattern.class, msgs);
			msgs = basicSetWhere(newWhere, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtRelationPackage.RELATION__WHERE, newWhere, newWhere));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getVariable() {
		if (variable == null) {
			variable = new EObjectContainmentEList(VariableDeclaration.class, this, QvtRelationPackage.RELATION__VARIABLE);
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOperationalImpl() {
		if (operationalImpl == null) {
			operationalImpl = new EObjectWithInverseResolvingEList(RelationImplementation.class, this, QvtRelationPackage.RELATION__OPERATIONAL_IMPL, QvtRelationPackage.RELATION_IMPLEMENTATION__RELATION);
		}
		return operationalImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getWhen() {
		return when;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhen(Pattern newWhen, NotificationChain msgs) {
		Pattern oldWhen = when;
		when = newWhen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtRelationPackage.RELATION__WHEN, oldWhen, newWhen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhen(Pattern newWhen) {
		if (newWhen != when) {
			NotificationChain msgs = null;
			if (when != null)
				msgs = ((InternalEObject)when).eInverseRemove(this, QvtBasePackage.PATTERN__WHEN_OWNER, Pattern.class, msgs);
			if (newWhen != null)
				msgs = ((InternalEObject)newWhen).eInverseAdd(this, QvtBasePackage.PATTERN__WHEN_OWNER, Pattern.class, msgs);
			msgs = basicSetWhen(newWhen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtRelationPackage.RELATION__WHEN, newWhen, newWhen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return ((QvtVisitor)visitor).visit(this,data);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtRelationPackage.RELATION__WHERE:
				if (where != null)
					msgs = ((InternalEObject)where).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtRelationPackage.RELATION__WHERE, null, msgs);
				return basicSetWhere((Pattern)otherEnd, msgs);
			case QvtRelationPackage.RELATION__OPERATIONAL_IMPL:
				return ((InternalEList)getOperationalImpl()).basicAdd(otherEnd, msgs);
			case QvtRelationPackage.RELATION__WHEN:
				if (when != null)
					msgs = ((InternalEObject)when).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtRelationPackage.RELATION__WHEN, null, msgs);
				return basicSetWhen((Pattern)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtRelationPackage.RELATION__WHERE:
				return basicSetWhere(null, msgs);
			case QvtRelationPackage.RELATION__VARIABLE:
				return ((InternalEList)getVariable()).basicRemove(otherEnd, msgs);
			case QvtRelationPackage.RELATION__OPERATIONAL_IMPL:
				return ((InternalEList)getOperationalImpl()).basicRemove(otherEnd, msgs);
			case QvtRelationPackage.RELATION__WHEN:
				return basicSetWhen(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtRelationPackage.RELATION__IS_TOP_LEVEL:
				return isIsTopLevel() ? Boolean.TRUE : Boolean.FALSE;
			case QvtRelationPackage.RELATION__WHERE:
				return getWhere();
			case QvtRelationPackage.RELATION__VARIABLE:
				return getVariable();
			case QvtRelationPackage.RELATION__OPERATIONAL_IMPL:
				return getOperationalImpl();
			case QvtRelationPackage.RELATION__WHEN:
				return getWhen();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QvtRelationPackage.RELATION__IS_TOP_LEVEL:
				setIsTopLevel(((Boolean)newValue).booleanValue());
				return;
			case QvtRelationPackage.RELATION__WHERE:
				setWhere((Pattern)newValue);
				return;
			case QvtRelationPackage.RELATION__VARIABLE:
				getVariable().clear();
				getVariable().addAll((Collection)newValue);
				return;
			case QvtRelationPackage.RELATION__OPERATIONAL_IMPL:
				getOperationalImpl().clear();
				getOperationalImpl().addAll((Collection)newValue);
				return;
			case QvtRelationPackage.RELATION__WHEN:
				setWhen((Pattern)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case QvtRelationPackage.RELATION__IS_TOP_LEVEL:
				setIsTopLevel(IS_TOP_LEVEL_EDEFAULT);
				return;
			case QvtRelationPackage.RELATION__WHERE:
				setWhere((Pattern)null);
				return;
			case QvtRelationPackage.RELATION__VARIABLE:
				getVariable().clear();
				return;
			case QvtRelationPackage.RELATION__OPERATIONAL_IMPL:
				getOperationalImpl().clear();
				return;
			case QvtRelationPackage.RELATION__WHEN:
				setWhen((Pattern)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QvtRelationPackage.RELATION__IS_TOP_LEVEL:
				return isTopLevel != IS_TOP_LEVEL_EDEFAULT;
			case QvtRelationPackage.RELATION__WHERE:
				return where != null;
			case QvtRelationPackage.RELATION__VARIABLE:
				return variable != null && !variable.isEmpty();
			case QvtRelationPackage.RELATION__OPERATIONAL_IMPL:
				return operationalImpl != null && !operationalImpl.isEmpty();
			case QvtRelationPackage.RELATION__WHEN:
				return when != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isTopLevel: ");
		result.append(isTopLevel);
		result.append(')');
		return result.toString();
	}

} //RelationImpl
