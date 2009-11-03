/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS;
import org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralPartAS;
import org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage;
import org.oslo.ocl20.syntax.ast.expressions.IfExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Exp AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.impl.CollectionLiteralExpASImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.impl.CollectionLiteralExpASImpl#getCollectionParts <em>Collection Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionLiteralExpASImpl extends LiteralExpASImpl implements CollectionLiteralExpAS {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final CollectionKindAS KIND_EDEFAULT = CollectionKindAS.SET_LITERAL;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected CollectionKindAS kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCollectionParts() <em>Collection Parts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionParts()
	 * @generated
	 * @ordered
	 */
	protected EList collectionParts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionLiteralExpASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.COLLECTION_LITERAL_EXP_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionKindAS getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(CollectionKindAS newKind) {
		CollectionKindAS oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.COLLECTION_LITERAL_EXP_AS__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCollectionParts() {
		if (collectionParts == null) {
			collectionParts = new EObjectResolvingEList(CollectionLiteralPartAS.class, this, ExpressionsPackage.COLLECTION_LITERAL_EXP_AS__COLLECTION_PARTS);
		}
		return collectionParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object accept(Visitor visitor, Object data) {
		return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.COLLECTION_LITERAL_EXP_AS__KIND:
				return getKind();
			case ExpressionsPackage.COLLECTION_LITERAL_EXP_AS__COLLECTION_PARTS:
				return getCollectionParts();
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
			case ExpressionsPackage.COLLECTION_LITERAL_EXP_AS__KIND:
				setKind((CollectionKindAS)newValue);
				return;
			case ExpressionsPackage.COLLECTION_LITERAL_EXP_AS__COLLECTION_PARTS:
				getCollectionParts().clear();
				getCollectionParts().addAll((Collection)newValue);
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
			case ExpressionsPackage.COLLECTION_LITERAL_EXP_AS__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ExpressionsPackage.COLLECTION_LITERAL_EXP_AS__COLLECTION_PARTS:
				getCollectionParts().clear();
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
			case ExpressionsPackage.COLLECTION_LITERAL_EXP_AS__KIND:
				return kind != KIND_EDEFAULT;
			case ExpressionsPackage.COLLECTION_LITERAL_EXP_AS__COLLECTION_PARTS:
				return collectionParts != null && !collectionParts.isEmpty();
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //CollectionLiteralExpASImpl
