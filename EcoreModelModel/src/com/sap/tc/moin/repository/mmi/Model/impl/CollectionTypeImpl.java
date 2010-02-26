/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model.impl;

import com.sap.tc.moin.repository.mmi.Model.Classifier;
import com.sap.tc.moin.repository.mmi.Model.CollectionType;
import com.sap.tc.moin.repository.mmi.Model.DataType;
import com.sap.tc.moin.repository.mmi.Model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.Model.ModelElement;
import com.sap.tc.moin.repository.mmi.Model.ModelPackage;
import com.sap.tc.moin.repository.mmi.Model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.Model.Namespace;
import com.sap.tc.moin.repository.mmi.Model.VisibilityKind;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.impl.CollectionTypeImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.impl.CollectionTypeImpl#isIsRoot <em>Is Root</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.impl.CollectionTypeImpl#isIsLeaf <em>Is Leaf</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.impl.CollectionTypeImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.impl.CollectionTypeImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.impl.CollectionTypeImpl#getSupertypes <em>Supertypes</em>}</li>
 *   <li>{@link com.sap.tc.moin.repository.mmi.Model.impl.CollectionTypeImpl#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionTypeImpl extends TypedElementImpl implements CollectionType {
	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElement> contents;

	/**
	 * The default value of the '{@link #isIsRoot() <em>Is Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRoot()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ROOT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsRoot() <em>Is Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRoot()
	 * @generated
	 * @ordered
	 */
	protected boolean isRoot = IS_ROOT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsLeaf() <em>Is Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLeaf()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LEAF_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsLeaf() <em>Is Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLeaf()
	 * @generated
	 * @ordered
	 */
	protected boolean isLeaf = IS_LEAF_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final VisibilityKind VISIBILITY_EDEFAULT = VisibilityKind.PUBLIC_VIS;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected VisibilityKind visibility = VISIBILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSupertypes() <em>Supertypes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupertypes()
	 * @generated
	 * @ordered
	 */
	protected EList<GeneralizableElement> supertypes;

	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityType multiplicity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.COLLECTION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElement> getContents() {
		if (contents == null) {
			contents = new EObjectContainmentWithInverseEList<ModelElement>(ModelElement.class, this, ModelPackage.COLLECTION_TYPE__CONTENTS, ModelPackage.MODEL_ELEMENT__CONTAINER);
		}
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsRoot() {
		return isRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsRoot(boolean newIsRoot) {
		boolean oldIsRoot = isRoot;
		isRoot = newIsRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.COLLECTION_TYPE__IS_ROOT, oldIsRoot, isRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsLeaf() {
		return isLeaf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsLeaf(boolean newIsLeaf) {
		boolean oldIsLeaf = isLeaf;
		isLeaf = newIsLeaf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.COLLECTION_TYPE__IS_LEAF, oldIsLeaf, isLeaf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAbstract() {
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.COLLECTION_TYPE__IS_ABSTRACT, oldIsAbstract, isAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisibilityKind getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(VisibilityKind newVisibility) {
		VisibilityKind oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.COLLECTION_TYPE__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneralizableElement> getSupertypes() {
		if (supertypes == null) {
			supertypes = new EObjectResolvingEList<GeneralizableElement>(GeneralizableElement.class, this, ModelPackage.COLLECTION_TYPE__SUPERTYPES);
		}
		return supertypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityType getMultiplicity() {
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMultiplicity(MultiplicityType newMultiplicity, NotificationChain msgs) {
		MultiplicityType oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.COLLECTION_TYPE__MULTIPLICITY, oldMultiplicity, newMultiplicity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(MultiplicityType newMultiplicity) {
		if (newMultiplicity != multiplicity) {
			NotificationChain msgs = null;
			if (multiplicity != null)
				msgs = ((InternalEObject)multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.COLLECTION_TYPE__MULTIPLICITY, null, msgs);
			if (newMultiplicity != null)
				msgs = ((InternalEObject)newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.COLLECTION_TYPE__MULTIPLICITY, null, msgs);
			msgs = basicSetMultiplicity(newMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.COLLECTION_TYPE__MULTIPLICITY, newMultiplicity, newMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneralizableElement> allSupertypes() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement lookupElementExtended(String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElement> findElementsByTypeExtended(com.sap.tc.moin.repository.mmi.Model.Class ofType, boolean includeSubtypes) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement lookupElement(String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement resolveQualifiedName(EList<String> qualifiedName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElement> findElementsByType(com.sap.tc.moin.repository.mmi.Model.Class ofType, boolean includeSubtypes) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean nameIsValid(String proposedName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case ModelPackage.COLLECTION_TYPE__CONTENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContents()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.COLLECTION_TYPE__CONTENTS:
				return ((InternalEList<?>)getContents()).basicRemove(otherEnd, msgs);
			case ModelPackage.COLLECTION_TYPE__MULTIPLICITY:
				return basicSetMultiplicity(null, msgs);
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
			case ModelPackage.COLLECTION_TYPE__CONTENTS:
				return getContents();
			case ModelPackage.COLLECTION_TYPE__IS_ROOT:
				return isIsRoot();
			case ModelPackage.COLLECTION_TYPE__IS_LEAF:
				return isIsLeaf();
			case ModelPackage.COLLECTION_TYPE__IS_ABSTRACT:
				return isIsAbstract();
			case ModelPackage.COLLECTION_TYPE__VISIBILITY:
				return getVisibility();
			case ModelPackage.COLLECTION_TYPE__SUPERTYPES:
				return getSupertypes();
			case ModelPackage.COLLECTION_TYPE__MULTIPLICITY:
				return getMultiplicity();
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
			case ModelPackage.COLLECTION_TYPE__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends ModelElement>)newValue);
				return;
			case ModelPackage.COLLECTION_TYPE__IS_ROOT:
				setIsRoot((Boolean)newValue);
				return;
			case ModelPackage.COLLECTION_TYPE__IS_LEAF:
				setIsLeaf((Boolean)newValue);
				return;
			case ModelPackage.COLLECTION_TYPE__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case ModelPackage.COLLECTION_TYPE__VISIBILITY:
				setVisibility((VisibilityKind)newValue);
				return;
			case ModelPackage.COLLECTION_TYPE__SUPERTYPES:
				getSupertypes().clear();
				getSupertypes().addAll((Collection<? extends GeneralizableElement>)newValue);
				return;
			case ModelPackage.COLLECTION_TYPE__MULTIPLICITY:
				setMultiplicity((MultiplicityType)newValue);
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
			case ModelPackage.COLLECTION_TYPE__CONTENTS:
				getContents().clear();
				return;
			case ModelPackage.COLLECTION_TYPE__IS_ROOT:
				setIsRoot(IS_ROOT_EDEFAULT);
				return;
			case ModelPackage.COLLECTION_TYPE__IS_LEAF:
				setIsLeaf(IS_LEAF_EDEFAULT);
				return;
			case ModelPackage.COLLECTION_TYPE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case ModelPackage.COLLECTION_TYPE__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case ModelPackage.COLLECTION_TYPE__SUPERTYPES:
				getSupertypes().clear();
				return;
			case ModelPackage.COLLECTION_TYPE__MULTIPLICITY:
				setMultiplicity((MultiplicityType)null);
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
			case ModelPackage.COLLECTION_TYPE__CONTENTS:
				return contents != null && !contents.isEmpty();
			case ModelPackage.COLLECTION_TYPE__IS_ROOT:
				return isRoot != IS_ROOT_EDEFAULT;
			case ModelPackage.COLLECTION_TYPE__IS_LEAF:
				return isLeaf != IS_LEAF_EDEFAULT;
			case ModelPackage.COLLECTION_TYPE__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case ModelPackage.COLLECTION_TYPE__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case ModelPackage.COLLECTION_TYPE__SUPERTYPES:
				return supertypes != null && !supertypes.isEmpty();
			case ModelPackage.COLLECTION_TYPE__MULTIPLICITY:
				return multiplicity != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Namespace.class) {
			switch (derivedFeatureID) {
				case ModelPackage.COLLECTION_TYPE__CONTENTS: return ModelPackage.NAMESPACE__CONTENTS;
				default: return -1;
			}
		}
		if (baseClass == GeneralizableElement.class) {
			switch (derivedFeatureID) {
				case ModelPackage.COLLECTION_TYPE__IS_ROOT: return ModelPackage.GENERALIZABLE_ELEMENT__IS_ROOT;
				case ModelPackage.COLLECTION_TYPE__IS_LEAF: return ModelPackage.GENERALIZABLE_ELEMENT__IS_LEAF;
				case ModelPackage.COLLECTION_TYPE__IS_ABSTRACT: return ModelPackage.GENERALIZABLE_ELEMENT__IS_ABSTRACT;
				case ModelPackage.COLLECTION_TYPE__VISIBILITY: return ModelPackage.GENERALIZABLE_ELEMENT__VISIBILITY;
				case ModelPackage.COLLECTION_TYPE__SUPERTYPES: return ModelPackage.GENERALIZABLE_ELEMENT__SUPERTYPES;
				default: return -1;
			}
		}
		if (baseClass == Classifier.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == DataType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Namespace.class) {
			switch (baseFeatureID) {
				case ModelPackage.NAMESPACE__CONTENTS: return ModelPackage.COLLECTION_TYPE__CONTENTS;
				default: return -1;
			}
		}
		if (baseClass == GeneralizableElement.class) {
			switch (baseFeatureID) {
				case ModelPackage.GENERALIZABLE_ELEMENT__IS_ROOT: return ModelPackage.COLLECTION_TYPE__IS_ROOT;
				case ModelPackage.GENERALIZABLE_ELEMENT__IS_LEAF: return ModelPackage.COLLECTION_TYPE__IS_LEAF;
				case ModelPackage.GENERALIZABLE_ELEMENT__IS_ABSTRACT: return ModelPackage.COLLECTION_TYPE__IS_ABSTRACT;
				case ModelPackage.GENERALIZABLE_ELEMENT__VISIBILITY: return ModelPackage.COLLECTION_TYPE__VISIBILITY;
				case ModelPackage.GENERALIZABLE_ELEMENT__SUPERTYPES: return ModelPackage.COLLECTION_TYPE__SUPERTYPES;
				default: return -1;
			}
		}
		if (baseClass == Classifier.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == DataType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isRoot: ");
		result.append(isRoot);
		result.append(", isLeaf: ");
		result.append(isLeaf);
		result.append(", isAbstract: ");
		result.append(isAbstract);
		result.append(", visibility: ");
		result.append(visibility);
		result.append(')');
		return result.toString();
	}

} //CollectionTypeImpl
