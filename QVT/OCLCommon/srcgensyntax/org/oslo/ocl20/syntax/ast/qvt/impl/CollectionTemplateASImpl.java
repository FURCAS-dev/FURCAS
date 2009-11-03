/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt.impl;

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
import org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage;
import org.oslo.ocl20.syntax.ast.expressions.IfExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

import org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS;
import org.oslo.ocl20.syntax.ast.qvt.QvtPackage;
import org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS;

import org.oslo.ocl20.syntax.ast.types.TypeAS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Template AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.CollectionTemplateASImpl#getCollectionKind <em>Collection Kind</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.CollectionTemplateASImpl#getMemberSelectionExpressions <em>Member Selection Expressions</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.CollectionTemplateASImpl#getOclExpressions <em>Ocl Expressions</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.CollectionTemplateASImpl#getSetComprehensionExpression <em>Set Comprehension Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionTemplateASImpl extends TemplateASImpl implements CollectionTemplateAS {
	/**
	 * The default value of the '{@link #getCollectionKind() <em>Collection Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionKind()
	 * @generated
	 * @ordered
	 */
	protected static final CollectionKindAS COLLECTION_KIND_EDEFAULT = CollectionKindAS.SET_LITERAL;

	/**
	 * The cached value of the '{@link #getCollectionKind() <em>Collection Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionKind()
	 * @generated
	 * @ordered
	 */
	protected CollectionKindAS collectionKind = COLLECTION_KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMemberSelectionExpressions() <em>Member Selection Expressions</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberSelectionExpressions()
	 * @generated
	 * @ordered
	 */
	protected MemberSelectionExpressionAS memberSelectionExpressions;

	/**
	 * The cached value of the '{@link #getOclExpressions() <em>Ocl Expressions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList oclExpressions;

	/**
	 * The cached value of the '{@link #getSetComprehensionExpression() <em>Set Comprehension Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetComprehensionExpression()
	 * @generated
	 * @ordered
	 */
	protected SetComprehensionExpressionAS setComprehensionExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionTemplateASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return org.oslo.ocl20.syntax.ast.qvt.Package.Literals.COLLECTION_TEMPLATE_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionKindAS getCollectionKind() {
		return collectionKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollectionKind(CollectionKindAS newCollectionKind) {
		CollectionKindAS oldCollectionKind = collectionKind;
		collectionKind = newCollectionKind == null ? COLLECTION_KIND_EDEFAULT : newCollectionKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__COLLECTION_KIND, oldCollectionKind, collectionKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetComprehensionExpressionAS getSetComprehensionExpression() {
		if (setComprehensionExpression != null && setComprehensionExpression.eIsProxy()) {
			InternalEObject oldSetComprehensionExpression = (InternalEObject)setComprehensionExpression;
			setComprehensionExpression = (SetComprehensionExpressionAS)eResolveProxy(oldSetComprehensionExpression);
			if (setComprehensionExpression != oldSetComprehensionExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__SET_COMPREHENSION_EXPRESSION, oldSetComprehensionExpression, setComprehensionExpression));
			}
		}
		return setComprehensionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetComprehensionExpressionAS basicGetSetComprehensionExpression() {
		return setComprehensionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetComprehensionExpression(SetComprehensionExpressionAS newSetComprehensionExpression) {
		SetComprehensionExpressionAS oldSetComprehensionExpression = setComprehensionExpression;
		setComprehensionExpression = newSetComprehensionExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__SET_COMPREHENSION_EXPRESSION, oldSetComprehensionExpression, setComprehensionExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOclExpressions() {
		if (oclExpressions == null) {
			oclExpressions = new EObjectResolvingEList(OclExpressionAS.class, this, org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__OCL_EXPRESSIONS);
		}
		return oclExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemberSelectionExpressionAS getMemberSelectionExpressions() {
		if (memberSelectionExpressions != null && memberSelectionExpressions.eIsProxy()) {
			InternalEObject oldMemberSelectionExpressions = (InternalEObject)memberSelectionExpressions;
			memberSelectionExpressions = (MemberSelectionExpressionAS)eResolveProxy(oldMemberSelectionExpressions);
			if (memberSelectionExpressions != oldMemberSelectionExpressions) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__MEMBER_SELECTION_EXPRESSIONS, oldMemberSelectionExpressions, memberSelectionExpressions));
			}
		}
		return memberSelectionExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemberSelectionExpressionAS basicGetMemberSelectionExpressions() {
		return memberSelectionExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemberSelectionExpressions(MemberSelectionExpressionAS newMemberSelectionExpressions) {
		MemberSelectionExpressionAS oldMemberSelectionExpressions = memberSelectionExpressions;
		memberSelectionExpressions = newMemberSelectionExpressions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__MEMBER_SELECTION_EXPRESSIONS, oldMemberSelectionExpressions, memberSelectionExpressions));
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__COLLECTION_KIND:
				return getCollectionKind();
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__MEMBER_SELECTION_EXPRESSIONS:
				if (resolve) return getMemberSelectionExpressions();
				return basicGetMemberSelectionExpressions();
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__OCL_EXPRESSIONS:
				return getOclExpressions();
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__SET_COMPREHENSION_EXPRESSION:
				if (resolve) return getSetComprehensionExpression();
				return basicGetSetComprehensionExpression();
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__COLLECTION_KIND:
				setCollectionKind((CollectionKindAS)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__MEMBER_SELECTION_EXPRESSIONS:
				setMemberSelectionExpressions((MemberSelectionExpressionAS)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__OCL_EXPRESSIONS:
				getOclExpressions().clear();
				getOclExpressions().addAll((Collection)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__SET_COMPREHENSION_EXPRESSION:
				setSetComprehensionExpression((SetComprehensionExpressionAS)newValue);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__COLLECTION_KIND:
				setCollectionKind(COLLECTION_KIND_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__MEMBER_SELECTION_EXPRESSIONS:
				setMemberSelectionExpressions((MemberSelectionExpressionAS)null);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__OCL_EXPRESSIONS:
				getOclExpressions().clear();
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__SET_COMPREHENSION_EXPRESSION:
				setSetComprehensionExpression((SetComprehensionExpressionAS)null);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__COLLECTION_KIND:
				return collectionKind != COLLECTION_KIND_EDEFAULT;
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__MEMBER_SELECTION_EXPRESSIONS:
				return memberSelectionExpressions != null;
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__OCL_EXPRESSIONS:
				return oclExpressions != null && !oclExpressions.isEmpty();
			case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS__SET_COMPREHENSION_EXPRESSION:
				return setComprehensionExpression != null;
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
		result.append(" (collectionKind: ");
		result.append(collectionKind);
		result.append(')');
		return result.toString();
	}

} //CollectionTemplateASImpl
