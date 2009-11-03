/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvttemplate.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.expressions.impl.LiteralExpImpl;

import de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage;
import de.ikv.medini.qvt.model.qvttemplate.TemplateExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Template Exp</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.impl.TemplateExpImpl#getBindsTo <em>Binds To</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.impl.TemplateExpImpl#getWhere <em>Where</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TemplateExpImpl extends LiteralExpImpl implements TemplateExp {
	/**
	 * The cached value of the '{@link #getBindsTo() <em>Binds To</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBindsTo()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration bindsTo;

	/**
	 * The cached value of the '{@link #getWhere() <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWhere()
	 * @generated
	 * @ordered
	 */
	protected OclExpression where;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QvtTemplatePackage.Literals.TEMPLATE_EXP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration getBindsTo() {
		if (bindsTo != null && bindsTo.eIsProxy()) {
			InternalEObject oldBindsTo = (InternalEObject)bindsTo;
			bindsTo = (VariableDeclaration)eResolveProxy(oldBindsTo);
			if (bindsTo != oldBindsTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtTemplatePackage.TEMPLATE_EXP__BINDS_TO, oldBindsTo, bindsTo));
			}
		}
		return bindsTo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetBindsTo() {
		return bindsTo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindsTo(VariableDeclaration newBindsTo) {
		VariableDeclaration oldBindsTo = bindsTo;
		bindsTo = newBindsTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtTemplatePackage.TEMPLATE_EXP__BINDS_TO, oldBindsTo, bindsTo));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getWhere() {
		return where;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhere(OclExpression newWhere, NotificationChain msgs) {
		OclExpression oldWhere = where;
		where = newWhere;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtTemplatePackage.TEMPLATE_EXP__WHERE, oldWhere, newWhere);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhere(OclExpression newWhere) {
		if (newWhere != where) {
			NotificationChain msgs = null;
			if (where != null)
				msgs = ((InternalEObject)where).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtTemplatePackage.TEMPLATE_EXP__WHERE, null, msgs);
			if (newWhere != null)
				msgs = ((InternalEObject)newWhere).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtTemplatePackage.TEMPLATE_EXP__WHERE, null, msgs);
			msgs = basicSetWhere(newWhere, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtTemplatePackage.TEMPLATE_EXP__WHERE, newWhere, newWhere));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtTemplatePackage.TEMPLATE_EXP__WHERE:
				return basicSetWhere(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtTemplatePackage.TEMPLATE_EXP__BINDS_TO:
				if (resolve) return getBindsTo();
				return basicGetBindsTo();
			case QvtTemplatePackage.TEMPLATE_EXP__WHERE:
				return getWhere();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QvtTemplatePackage.TEMPLATE_EXP__BINDS_TO:
				setBindsTo((VariableDeclaration)newValue);
				return;
			case QvtTemplatePackage.TEMPLATE_EXP__WHERE:
				setWhere((OclExpression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case QvtTemplatePackage.TEMPLATE_EXP__BINDS_TO:
				setBindsTo((VariableDeclaration)null);
				return;
			case QvtTemplatePackage.TEMPLATE_EXP__WHERE:
				setWhere((OclExpression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QvtTemplatePackage.TEMPLATE_EXP__BINDS_TO:
				return bindsTo != null;
			case QvtTemplatePackage.TEMPLATE_EXP__WHERE:
				return where != null;
		}
		return super.eIsSet(featureID);
	}

} // TemplateExpImpl
