/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.oslo.ocl20.syntax.ast.Visitor;
import org.oslo.ocl20.syntax.ast.impl.VisitableImpl;
import org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.QueryAS;
import org.oslo.ocl20.syntax.ast.qvt.QvtPackage;
import org.oslo.ocl20.syntax.ast.qvt.RelationAS;
import org.oslo.ocl20.syntax.ast.qvt.TransformationAS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.TransformationASImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.TransformationASImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.TransformationASImpl#getKeyDeclarations <em>Key Declarations</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.TransformationASImpl#getRelations <em>Relations</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.TransformationASImpl#getModelDeclarations <em>Model Declarations</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.TransformationASImpl#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationASImpl extends VisitableImpl implements TransformationAS {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getExtends() <em>Extends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected static final List EXTENDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected List extends_ = EXTENDS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getKeyDeclarations() <em>Key Declarations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList keyDeclarations;

	/**
	 * The cached value of the '{@link #getRelations() <em>Relations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelations()
	 * @generated
	 * @ordered
	 */
	protected EList relations;

	/**
	 * The cached value of the '{@link #getModelDeclarations() <em>Model Declarations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList modelDeclarations;

	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected EList query;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return org.oslo.ocl20.syntax.ast.qvt.Package.Literals.TRANSFORMATION_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getExtends() {
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtends(List newExtends) {
		List oldExtends = extends_;
		extends_ = newExtends;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__EXTENDS, oldExtends, extends_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRelations() {
		if (relations == null) {
			relations = new EObjectResolvingEList(RelationAS.class, this, org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__RELATIONS);
		}
		return relations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getModelDeclarations() {
		if (modelDeclarations == null) {
			modelDeclarations = new EObjectResolvingEList(ModelDeclarationAS.class, this, org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__MODEL_DECLARATIONS);
		}
		return modelDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getQuery() {
		if (query == null) {
			query = new EObjectResolvingEList(QueryAS.class, this, org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__QUERY);
		}
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getKeyDeclarations() {
		if (keyDeclarations == null) {
			keyDeclarations = new EObjectResolvingEList(KeyDeclarationAS.class, this, org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__KEY_DECLARATIONS);
		}
		return keyDeclarations;
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__NAME:
				return getName();
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__EXTENDS:
				return getExtends();
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__KEY_DECLARATIONS:
				return getKeyDeclarations();
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__RELATIONS:
				return getRelations();
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__MODEL_DECLARATIONS:
				return getModelDeclarations();
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__QUERY:
				return getQuery();
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__NAME:
				setName((String)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__EXTENDS:
				setExtends((List)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__KEY_DECLARATIONS:
				getKeyDeclarations().clear();
				getKeyDeclarations().addAll((Collection)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__RELATIONS:
				getRelations().clear();
				getRelations().addAll((Collection)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__MODEL_DECLARATIONS:
				getModelDeclarations().clear();
				getModelDeclarations().addAll((Collection)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__QUERY:
				getQuery().clear();
				getQuery().addAll((Collection)newValue);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__EXTENDS:
				setExtends(EXTENDS_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__KEY_DECLARATIONS:
				getKeyDeclarations().clear();
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__RELATIONS:
				getRelations().clear();
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__MODEL_DECLARATIONS:
				getModelDeclarations().clear();
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__QUERY:
				getQuery().clear();
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__EXTENDS:
				return EXTENDS_EDEFAULT == null ? extends_ != null : !EXTENDS_EDEFAULT.equals(extends_);
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__KEY_DECLARATIONS:
				return keyDeclarations != null && !keyDeclarations.isEmpty();
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__RELATIONS:
				return relations != null && !relations.isEmpty();
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__MODEL_DECLARATIONS:
				return modelDeclarations != null && !modelDeclarations.isEmpty();
			case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS__QUERY:
				return query != null && !query.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", extends: ");
		result.append(extends_);
		result.append(')');
		return result.toString();
	}

} //TransformationASImpl
