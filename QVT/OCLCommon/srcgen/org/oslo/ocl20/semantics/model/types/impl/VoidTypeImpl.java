/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.types.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;

import org.oslo.ocl20.semantics.model.types.BagType;
import org.oslo.ocl20.semantics.model.types.BooleanType;
import org.oslo.ocl20.semantics.model.types.CollectionType;
import org.oslo.ocl20.semantics.model.types.IntegerType;
import org.oslo.ocl20.semantics.model.types.OrderedSetType;
import org.oslo.ocl20.semantics.model.types.RealType;
import org.oslo.ocl20.semantics.model.types.SequenceType;
import org.oslo.ocl20.semantics.model.types.SetType;
import org.oslo.ocl20.semantics.model.types.TypesPackage;
import org.oslo.ocl20.semantics.model.types.VoidType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Void Type</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.types.impl.VoidTypeImpl#getElementType <em>Element Type
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VoidTypeImpl extends StringTypeImpl implements VoidType {
	/**
	 * The cached value of the '{@link #getElementType() <em>Element Type</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
	protected Classifier elementType;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected VoidTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.Literals.VOID_TYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Classifier getElementType() {
		if (elementType != null && elementType.eIsProxy()) {
			InternalEObject oldElementType = (InternalEObject) elementType;
			elementType = (Classifier) eResolveProxy(oldElementType);
			if (elementType != oldElementType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.VOID_TYPE__ELEMENT_TYPE,
					    oldElementType, elementType));
			}
		}
		return elementType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Classifier basicGetElementType() {
		return elementType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setElementType(Classifier newElementType) {
		Classifier oldElementType = elementType;
		elementType = newElementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.VOID_TYPE__ELEMENT_TYPE, oldElementType,
			    elementType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return ((OclVisitor) visitor).visit(this, data);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Classifier getBaseElementType() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.VOID_TYPE__ELEMENT_TYPE:
				if (resolve)
					return getElementType();
				return basicGetElementType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TypesPackage.VOID_TYPE__ELEMENT_TYPE:
				setElementType((Classifier) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case TypesPackage.VOID_TYPE__ELEMENT_TYPE:
				setElementType((Classifier) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TypesPackage.VOID_TYPE__ELEMENT_TYPE:
				return elementType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == CollectionType.class) {
			switch (derivedFeatureID) {
				case TypesPackage.VOID_TYPE__ELEMENT_TYPE:
					return TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE;
				default:
					return -1;
			}
		}
		if (baseClass == OrderedSetType.class) {
			switch (derivedFeatureID) {
				default:
					return -1;
			}
		}
		if (baseClass == RealType.class) {
			switch (derivedFeatureID) {
				default:
					return -1;
			}
		}
		if (baseClass == IntegerType.class) {
			switch (derivedFeatureID) {
				default:
					return -1;
			}
		}
		if (baseClass == BooleanType.class) {
			switch (derivedFeatureID) {
				default:
					return -1;
			}
		}
		if (baseClass == SetType.class) {
			switch (derivedFeatureID) {
				default:
					return -1;
			}
		}
		if (baseClass == SequenceType.class) {
			switch (derivedFeatureID) {
				default:
					return -1;
			}
		}
		if (baseClass == OclModelElementType.class) {
			switch (derivedFeatureID) {
				default:
					return -1;
			}
		}
		if (baseClass == BagType.class) {
			switch (derivedFeatureID) {
				default:
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == CollectionType.class) {
			switch (baseFeatureID) {
				case TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE:
					return TypesPackage.VOID_TYPE__ELEMENT_TYPE;
				default:
					return -1;
			}
		}
		if (baseClass == OrderedSetType.class) {
			switch (baseFeatureID) {
				default:
					return -1;
			}
		}
		if (baseClass == RealType.class) {
			switch (baseFeatureID) {
				default:
					return -1;
			}
		}
		if (baseClass == IntegerType.class) {
			switch (baseFeatureID) {
				default:
					return -1;
			}
		}
		if (baseClass == BooleanType.class) {
			switch (baseFeatureID) {
				default:
					return -1;
			}
		}
		if (baseClass == SetType.class) {
			switch (baseFeatureID) {
				default:
					return -1;
			}
		}
		if (baseClass == SequenceType.class) {
			switch (baseFeatureID) {
				default:
					return -1;
			}
		}
		if (baseClass == OclModelElementType.class) {
			switch (baseFeatureID) {
				default:
					return -1;
			}
		}
		if (baseClass == BagType.class) {
			switch (baseFeatureID) {
				default:
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} // VoidTypeImpl
