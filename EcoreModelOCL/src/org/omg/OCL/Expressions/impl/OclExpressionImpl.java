/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions.impl;

import com.sap.tc.moin.repository.mmi.Model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.Model.Attribute;
import com.sap.tc.moin.repository.mmi.Model.Classifier;
import com.sap.tc.moin.repository.mmi.Model.Operation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.omg.OCL.Expressions.ExpressionsPackage;
import org.omg.OCL.Expressions.OclExpression;
import org.omg.OCL.Expressions.OperationCallExp;
import org.omg.OCL.Expressions.PropertyCallExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.OCL.Expressions.impl.OclExpressionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.impl.OclExpressionImpl#getAppliedProperty <em>Applied Property</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.impl.OclExpressionImpl#getParentOperation <em>Parent Operation</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.impl.OclExpressionImpl#getAttributeForInitialValue <em>Attribute For Initial Value</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.impl.OclExpressionImpl#getAssociationEndForInitialValue <em>Association End For Initial Value</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.impl.OclExpressionImpl#getDefines <em>Defines</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.impl.OclExpressionImpl#getAssociationEndForDerivationExpression <em>Association End For Derivation Expression</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.impl.OclExpressionImpl#getAttributeForDerivationExpression <em>Attribute For Derivation Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OclExpressionImpl extends OclNamedElementImpl implements OclExpression {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Classifier type;

	/**
	 * The cached value of the '{@link #getAttributeForInitialValue() <em>Attribute For Initial Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeForInitialValue()
	 * @generated
	 * @ordered
	 */
	protected Attribute attributeForInitialValue;

	/**
	 * The cached value of the '{@link #getAssociationEndForInitialValue() <em>Association End For Initial Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationEndForInitialValue()
	 * @generated
	 * @ordered
	 */
	protected AssociationEnd associationEndForInitialValue;

	/**
	 * The cached value of the '{@link #getDefines() <em>Defines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefines()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> defines;

	/**
	 * The cached value of the '{@link #getAssociationEndForDerivationExpression() <em>Association End For Derivation Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationEndForDerivationExpression()
	 * @generated
	 * @ordered
	 */
	protected AssociationEnd associationEndForDerivationExpression;

	/**
	 * The cached value of the '{@link #getAttributeForDerivationExpression() <em>Attribute For Derivation Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeForDerivationExpression()
	 * @generated
	 * @ordered
	 */
	protected Attribute attributeForDerivationExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.OCL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Classifier)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OCL_EXPRESSION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Classifier newType) {
		Classifier oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyCallExp getAppliedProperty() {
		if (eContainerFeatureID() != ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY) return null;
		return (PropertyCallExp)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAppliedProperty(PropertyCallExp newAppliedProperty, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAppliedProperty, ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppliedProperty(PropertyCallExp newAppliedProperty) {
		if (newAppliedProperty != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY && newAppliedProperty != null)) {
			if (EcoreUtil.isAncestor(this, newAppliedProperty))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAppliedProperty != null)
				msgs = ((InternalEObject)newAppliedProperty).eInverseAdd(this, ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE, PropertyCallExp.class, msgs);
			msgs = basicSetAppliedProperty(newAppliedProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY, newAppliedProperty, newAppliedProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExp getParentOperation() {
		if (eContainerFeatureID() != ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION) return null;
		return (OperationCallExp)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentOperation(OperationCallExp newParentOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentOperation, ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentOperation(OperationCallExp newParentOperation) {
		if (newParentOperation != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION && newParentOperation != null)) {
			if (EcoreUtil.isAncestor(this, newParentOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentOperation != null)
				msgs = ((InternalEObject)newParentOperation).eInverseAdd(this, ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS, OperationCallExp.class, msgs);
			msgs = basicSetParentOperation(newParentOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION, newParentOperation, newParentOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute getAttributeForInitialValue() {
		if (attributeForInitialValue != null && attributeForInitialValue.eIsProxy()) {
			InternalEObject oldAttributeForInitialValue = (InternalEObject)attributeForInitialValue;
			attributeForInitialValue = (Attribute)eResolveProxy(oldAttributeForInitialValue);
			if (attributeForInitialValue != oldAttributeForInitialValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OCL_EXPRESSION__ATTRIBUTE_FOR_INITIAL_VALUE, oldAttributeForInitialValue, attributeForInitialValue));
			}
		}
		return attributeForInitialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute basicGetAttributeForInitialValue() {
		return attributeForInitialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeForInitialValue(Attribute newAttributeForInitialValue) {
		Attribute oldAttributeForInitialValue = attributeForInitialValue;
		attributeForInitialValue = newAttributeForInitialValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__ATTRIBUTE_FOR_INITIAL_VALUE, oldAttributeForInitialValue, attributeForInitialValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEnd getAssociationEndForInitialValue() {
		if (associationEndForInitialValue != null && associationEndForInitialValue.eIsProxy()) {
			InternalEObject oldAssociationEndForInitialValue = (InternalEObject)associationEndForInitialValue;
			associationEndForInitialValue = (AssociationEnd)eResolveProxy(oldAssociationEndForInitialValue);
			if (associationEndForInitialValue != oldAssociationEndForInitialValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OCL_EXPRESSION__ASSOCIATION_END_FOR_INITIAL_VALUE, oldAssociationEndForInitialValue, associationEndForInitialValue));
			}
		}
		return associationEndForInitialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEnd basicGetAssociationEndForInitialValue() {
		return associationEndForInitialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociationEndForInitialValue(AssociationEnd newAssociationEndForInitialValue) {
		AssociationEnd oldAssociationEndForInitialValue = associationEndForInitialValue;
		associationEndForInitialValue = newAssociationEndForInitialValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__ASSOCIATION_END_FOR_INITIAL_VALUE, oldAssociationEndForInitialValue, associationEndForInitialValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getDefines() {
		if (defines == null) {
			defines = new EObjectResolvingEList<Operation>(Operation.class, this, ExpressionsPackage.OCL_EXPRESSION__DEFINES);
		}
		return defines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEnd getAssociationEndForDerivationExpression() {
		if (associationEndForDerivationExpression != null && associationEndForDerivationExpression.eIsProxy()) {
			InternalEObject oldAssociationEndForDerivationExpression = (InternalEObject)associationEndForDerivationExpression;
			associationEndForDerivationExpression = (AssociationEnd)eResolveProxy(oldAssociationEndForDerivationExpression);
			if (associationEndForDerivationExpression != oldAssociationEndForDerivationExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OCL_EXPRESSION__ASSOCIATION_END_FOR_DERIVATION_EXPRESSION, oldAssociationEndForDerivationExpression, associationEndForDerivationExpression));
			}
		}
		return associationEndForDerivationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEnd basicGetAssociationEndForDerivationExpression() {
		return associationEndForDerivationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociationEndForDerivationExpression(AssociationEnd newAssociationEndForDerivationExpression) {
		AssociationEnd oldAssociationEndForDerivationExpression = associationEndForDerivationExpression;
		associationEndForDerivationExpression = newAssociationEndForDerivationExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__ASSOCIATION_END_FOR_DERIVATION_EXPRESSION, oldAssociationEndForDerivationExpression, associationEndForDerivationExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute getAttributeForDerivationExpression() {
		if (attributeForDerivationExpression != null && attributeForDerivationExpression.eIsProxy()) {
			InternalEObject oldAttributeForDerivationExpression = (InternalEObject)attributeForDerivationExpression;
			attributeForDerivationExpression = (Attribute)eResolveProxy(oldAttributeForDerivationExpression);
			if (attributeForDerivationExpression != oldAttributeForDerivationExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OCL_EXPRESSION__ATTRIBUTE_FOR_DERIVATION_EXPRESSION, oldAttributeForDerivationExpression, attributeForDerivationExpression));
			}
		}
		return attributeForDerivationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute basicGetAttributeForDerivationExpression() {
		return attributeForDerivationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeForDerivationExpression(Attribute newAttributeForDerivationExpression) {
		Attribute oldAttributeForDerivationExpression = attributeForDerivationExpression;
		attributeForDerivationExpression = newAttributeForDerivationExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_EXPRESSION__ATTRIBUTE_FOR_DERIVATION_EXPRESSION, oldAttributeForDerivationExpression, attributeForDerivationExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAppliedProperty((PropertyCallExp)otherEnd, msgs);
			case ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentOperation((OperationCallExp)otherEnd, msgs);
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
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				return basicSetAppliedProperty(null, msgs);
			case ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION:
				return basicSetParentOperation(null, msgs);
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
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				return eInternalContainer().eInverseRemove(this, ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE, PropertyCallExp.class, msgs);
			case ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION:
				return eInternalContainer().eInverseRemove(this, ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS, OperationCallExp.class, msgs);
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
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				return getAppliedProperty();
			case ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION:
				return getParentOperation();
			case ExpressionsPackage.OCL_EXPRESSION__ATTRIBUTE_FOR_INITIAL_VALUE:
				if (resolve) return getAttributeForInitialValue();
				return basicGetAttributeForInitialValue();
			case ExpressionsPackage.OCL_EXPRESSION__ASSOCIATION_END_FOR_INITIAL_VALUE:
				if (resolve) return getAssociationEndForInitialValue();
				return basicGetAssociationEndForInitialValue();
			case ExpressionsPackage.OCL_EXPRESSION__DEFINES:
				return getDefines();
			case ExpressionsPackage.OCL_EXPRESSION__ASSOCIATION_END_FOR_DERIVATION_EXPRESSION:
				if (resolve) return getAssociationEndForDerivationExpression();
				return basicGetAssociationEndForDerivationExpression();
			case ExpressionsPackage.OCL_EXPRESSION__ATTRIBUTE_FOR_DERIVATION_EXPRESSION:
				if (resolve) return getAttributeForDerivationExpression();
				return basicGetAttributeForDerivationExpression();
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
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				setType((Classifier)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION:
				setParentOperation((OperationCallExp)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__ATTRIBUTE_FOR_INITIAL_VALUE:
				setAttributeForInitialValue((Attribute)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__ASSOCIATION_END_FOR_INITIAL_VALUE:
				setAssociationEndForInitialValue((AssociationEnd)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__DEFINES:
				getDefines().clear();
				getDefines().addAll((Collection<? extends Operation>)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__ASSOCIATION_END_FOR_DERIVATION_EXPRESSION:
				setAssociationEndForDerivationExpression((AssociationEnd)newValue);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__ATTRIBUTE_FOR_DERIVATION_EXPRESSION:
				setAttributeForDerivationExpression((Attribute)newValue);
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
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				setType((Classifier)null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION:
				setParentOperation((OperationCallExp)null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__ATTRIBUTE_FOR_INITIAL_VALUE:
				setAttributeForInitialValue((Attribute)null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__ASSOCIATION_END_FOR_INITIAL_VALUE:
				setAssociationEndForInitialValue((AssociationEnd)null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__DEFINES:
				getDefines().clear();
				return;
			case ExpressionsPackage.OCL_EXPRESSION__ASSOCIATION_END_FOR_DERIVATION_EXPRESSION:
				setAssociationEndForDerivationExpression((AssociationEnd)null);
				return;
			case ExpressionsPackage.OCL_EXPRESSION__ATTRIBUTE_FOR_DERIVATION_EXPRESSION:
				setAttributeForDerivationExpression((Attribute)null);
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
			case ExpressionsPackage.OCL_EXPRESSION__TYPE:
				return type != null;
			case ExpressionsPackage.OCL_EXPRESSION__APPLIED_PROPERTY:
				return getAppliedProperty() != null;
			case ExpressionsPackage.OCL_EXPRESSION__PARENT_OPERATION:
				return getParentOperation() != null;
			case ExpressionsPackage.OCL_EXPRESSION__ATTRIBUTE_FOR_INITIAL_VALUE:
				return attributeForInitialValue != null;
			case ExpressionsPackage.OCL_EXPRESSION__ASSOCIATION_END_FOR_INITIAL_VALUE:
				return associationEndForInitialValue != null;
			case ExpressionsPackage.OCL_EXPRESSION__DEFINES:
				return defines != null && !defines.isEmpty();
			case ExpressionsPackage.OCL_EXPRESSION__ASSOCIATION_END_FOR_DERIVATION_EXPRESSION:
				return associationEndForDerivationExpression != null;
			case ExpressionsPackage.OCL_EXPRESSION__ATTRIBUTE_FOR_DERIVATION_EXPRESSION:
				return attributeForDerivationExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //OclExpressionImpl
