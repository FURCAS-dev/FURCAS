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
import org.oslo.ocl20.syntax.ast.qvt.QvtPackage;
import org.oslo.ocl20.syntax.ast.qvt.TopLevelAS;
import org.oslo.ocl20.syntax.ast.qvt.TransformationAS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Level AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.TopLevelASImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.impl.TopLevelASImpl#getTransformations <em>Transformations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopLevelASImpl extends VisitableImpl implements TopLevelAS {
	/**
	 * The default value of the '{@link #getImports() <em>Imports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected static final List IMPORTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected List imports = IMPORTS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTransformations() <em>Transformations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformations()
	 * @generated
	 * @ordered
	 */
	protected EList transformations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopLevelASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return org.oslo.ocl20.syntax.ast.qvt.Package.Literals.TOP_LEVEL_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getImports() {
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImports(List newImports) {
		List oldImports = imports;
		imports = newImports;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, org.oslo.ocl20.syntax.ast.qvt.Package.TOP_LEVEL_AS__IMPORTS, oldImports, imports));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTransformations() {
		if (transformations == null) {
			transformations = new EObjectResolvingEList(TransformationAS.class, this, org.oslo.ocl20.syntax.ast.qvt.Package.TOP_LEVEL_AS__TRANSFORMATIONS);
		}
		return transformations;
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.TOP_LEVEL_AS__IMPORTS:
				return getImports();
			case org.oslo.ocl20.syntax.ast.qvt.Package.TOP_LEVEL_AS__TRANSFORMATIONS:
				return getTransformations();
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.TOP_LEVEL_AS__IMPORTS:
				setImports((List)newValue);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.TOP_LEVEL_AS__TRANSFORMATIONS:
				getTransformations().clear();
				getTransformations().addAll((Collection)newValue);
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.TOP_LEVEL_AS__IMPORTS:
				setImports(IMPORTS_EDEFAULT);
				return;
			case org.oslo.ocl20.syntax.ast.qvt.Package.TOP_LEVEL_AS__TRANSFORMATIONS:
				getTransformations().clear();
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
			case org.oslo.ocl20.syntax.ast.qvt.Package.TOP_LEVEL_AS__IMPORTS:
				return IMPORTS_EDEFAULT == null ? imports != null : !IMPORTS_EDEFAULT.equals(imports);
			case org.oslo.ocl20.syntax.ast.qvt.Package.TOP_LEVEL_AS__TRANSFORMATIONS:
				return transformations != null && !transformations.isEmpty();
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
		result.append(" (imports: ");
		result.append(imports);
		result.append(')');
		return result.toString();
	}

} //TopLevelASImpl
