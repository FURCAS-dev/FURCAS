/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: MessageTypeImpl.java,v 1.12 2010/04/23 05:52:13 ewillink Exp $
 */
package org.eclipse.ocl.uml.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DelegatingEList;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.uml.MessageType;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.uml.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.uml.util.OCLUMLUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.internal.impl.ClassifierImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.uml.impl.MessageTypeImpl#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.MessageTypeImpl#getReferredSignal <em>Referred Signal</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.MessageTypeImpl#getFeatures <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.MessageTypeImpl#getAttributes <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.MessageTypeImpl#getOwnedOperations <em>Owned Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.MessageTypeImpl#getOwnedAttributes <em>Owned Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class MessageTypeImpl
		extends ClassifierImpl
		implements MessageType {

	/**
	 * The cached value of the '{@link #getReferredOperation() <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation referredOperation;

	/**
	 * The cached value of the '{@link #getReferredSignal() <em>Referred Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredSignal()
	 * @generated
	 * @ordered
	 */
	protected Classifier referredSignal;

	/**
	 * The cached value of the '{@link #getOwnedOperations() <em>Owned Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> ownedOperations;

	/**
	 * The cached value of the '{@link #getOwnedAttributes() <em>Owned Attribute</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> ownedAttributes;

	private EList<Operation> operations;

	private EList<Property> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLPackage.Literals.MESSAGE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getReferredOperation() {
		if (referredOperation != null
			&& ((EObject) referredOperation).eIsProxy()) {
			InternalEObject oldReferredOperation = (InternalEObject) referredOperation;
			referredOperation = (Operation) eResolveProxy(oldReferredOperation);
			if (referredOperation != oldReferredOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						UMLPackage.MESSAGE_TYPE__REFERRED_OPERATION,
						oldReferredOperation, referredOperation));
			}
		}
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetReferredOperation() {
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setReferredOperation(Operation newReferredOperation) {
		Operation oldReferredOperation = referredOperation;
		referredOperation = newReferredOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.MESSAGE_TYPE__REFERRED_OPERATION,
				oldReferredOperation, referredOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getReferredSignal() {
		if (referredSignal != null && ((EObject) referredSignal).eIsProxy()) {
			InternalEObject oldReferredSignal = (InternalEObject) referredSignal;
			referredSignal = (Classifier) eResolveProxy(oldReferredSignal);
			if (referredSignal != oldReferredSignal) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						UMLPackage.MESSAGE_TYPE__REFERRED_SIGNAL,
						oldReferredSignal, referredSignal));
			}
		}
		return referredSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetReferredSignal() {
		return referredSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setReferredSignal(Classifier newReferredSignal) {
		Classifier oldReferredSignal = referredSignal;
		referredSignal = newReferredSignal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.MESSAGE_TYPE__REFERRED_SIGNAL, oldReferredSignal,
				referredSignal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public EList<Feature> getFeatures() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Feature> features = (EList<Feature>) cache.get(eResource,
				this,
				org.eclipse.uml2.uml.UMLPackage.Literals.CLASSIFIER__FEATURE);
			if (features == null) {
				cache
					.put(
						eResource,
						this,
						org.eclipse.uml2.uml.UMLPackage.Literals.CLASSIFIER__FEATURE,
						features = new DerivedUnionEObjectEList<Feature>(
							Feature.class, this,
							UMLPackage.MESSAGE_TYPE__FEATURE, FEATURE_ESUBSETS));
			}
			return features;
		}
		return new DerivedUnionEObjectEList<Feature>(Feature.class, this,
			UMLPackage.MESSAGE_TYPE__FEATURE, FEATURE_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getFeatures() <em>Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final int[] FEATURE_ESUBSETS = new int[]{
		UMLPackage.MESSAGE_TYPE__ATTRIBUTE,
		UMLPackage.MESSAGE_TYPE__OWNED_OPERATION};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getOwnedOperations() {
		if (ownedOperations == null) {
			ownedOperations = new EObjectContainmentEList<Operation>(
				Operation.class, this, UMLPackage.MESSAGE_TYPE__OWNED_OPERATION);
		}
		return ownedOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getOwnedOperation(String name,
			EList<String> ownedParameterNames, EList<Type> ownedParameterTypes) {
		return getOwnedOperation(name, ownedParameterNames,
			ownedParameterTypes, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getOwnedOperation(String name,
			EList<String> ownedParameterNames, EList<Type> ownedParameterTypes,
			boolean ignoreCase) {
		ownedOperationLoop : for (Operation ownedOperation : getOwnedOperations()) {
			if (name != null && !(ignoreCase
				? name.equalsIgnoreCase(ownedOperation.getName())
				: name.equals(ownedOperation.getName())))
				continue ownedOperationLoop;
			EList<Parameter> ownedParameterList = ownedOperation
				.getOwnedParameters();
			int ownedParameterListSize = ownedParameterList.size();
			if (ownedParameterNames != null
				&& ownedParameterNames.size() != ownedParameterListSize
				|| (ownedParameterTypes != null && ownedParameterTypes.size() != ownedParameterListSize))
				continue ownedOperationLoop;
			for (int j = 0; j < ownedParameterListSize; j++) {
				Parameter ownedParameter = ownedParameterList.get(j);
				if (ownedParameterNames != null
					&& !(ignoreCase
						? (ownedParameterNames.get(j))
							.equalsIgnoreCase(ownedParameter.getName())
						: ownedParameterNames.get(j).equals(
							ownedParameter.getName())))
					continue ownedOperationLoop;
				if (ownedParameterTypes != null
					&& !ownedParameterTypes.get(j).equals(
						ownedParameter.getType()))
					continue ownedOperationLoop;
			}
			return ownedOperation;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getOwnedAttributes() {
		if (ownedAttributes == null) {
			ownedAttributes = new EObjectContainmentEList<Property>(
				Property.class, this, UMLPackage.MESSAGE_TYPE__OWNED_ATTRIBUTE);
		}
		return ownedAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getOwnedAttribute(String name, Type type) {
		return getOwnedAttribute(name, type, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getOwnedAttribute(String name, Type type,
			boolean ignoreCase, EClass eClass) {
		ownedAttributeLoop : for (Property ownedAttribute : getOwnedAttributes()) {
			if (eClass != null && !eClass.isInstance(ownedAttribute))
				continue ownedAttributeLoop;
			if (name != null && !(ignoreCase
				? name.equalsIgnoreCase(ownedAttribute.getName())
				: name.equals(ownedAttribute.getName())))
				continue ownedAttributeLoop;
			if (type != null && !type.equals(ownedAttribute.getType()))
				continue ownedAttributeLoop;
			return ownedAttribute;
		}
		return null;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public String getName() {
		if (name == null) {
			name = SINGLETON_NAME;
		}

		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getAttributes() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Property> attributes = (EList<Property>) cache.get(eResource,
				this,
				org.eclipse.uml2.uml.UMLPackage.Literals.CLASSIFIER__ATTRIBUTE);
			if (attributes == null) {
				cache
					.put(
						eResource,
						this,
						org.eclipse.uml2.uml.UMLPackage.Literals.CLASSIFIER__ATTRIBUTE,
						attributes = new DerivedUnionEObjectEList<Property>(
							Property.class, this,
							UMLPackage.MESSAGE_TYPE__ATTRIBUTE,
							ATTRIBUTE_ESUBSETS));
			}
			return attributes;
		}
		return new DerivedUnionEObjectEList<Property>(Property.class, this,
			UMLPackage.MESSAGE_TYPE__ATTRIBUTE, ATTRIBUTE_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getAttributes() <em>Attribute</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected static final int[] ATTRIBUTE_ESUBSETS = new int[]{UMLPackage.MESSAGE_TYPE__OWNED_ATTRIBUTE};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetAttributes() {
		return super.isSetAttributes()
			|| eIsSet(UMLPackage.MESSAGE_TYPE__OWNED_ATTRIBUTE);
	}

	/**
	 * @generated NOT
	 */
	public EList<Property> oclProperties() {
		if (properties == null) {
			properties = new DelegatingEList<Property>() {

				private static final long serialVersionUID = -4735888938397681302L;

				@Override
				protected List<Property> delegateList() {
					return getOwnedAttributes();
				}
			};

			EList<Property> features = getOwnedAttributes();

			if (features.isEmpty()) {
				// don't do this computation if we already have operations
				//   which would be the case if we were deserialized from some
				//   resource

				Environment<?, Classifier, Operation, Property, ?, ?, ?, ?, ?, ?, ?, ?> env = Environment.Registry.INSTANCE
					.getEnvironmentFor(this);

				UMLReflection<?, Classifier, Operation, Property, ?, ?, ?, ?, ?, ?> reflection = env
					.getUMLReflection();

				EList<? extends TypedElement> typedElements;
				if (getReferredOperation() != null) {
					typedElements = getReferredOperation().getOwnedParameters();
				} else if (getReferredSignal() != null) {
					typedElements = OCLUMLUtil
						.getAllAttributes(getReferredSignal());
				} else {
					typedElements = ECollections.emptyEList();
				}

				for (TypedElement next : typedElements) {
					features
						.add(reflection.createProperty(next.getName(), TypeUtil
							.resolveType(env, reflection.getOCLType(next))));
				}
			}
		}

		return properties;
	}

	/**
	 * @generated NOT
	 */
	public EList<Operation> oclOperations() {
		if (operations == null) {
			MessageType prototype = (MessageType) OCLStandardLibraryImpl.INSTANCE
				.getOclMessage();

			if (prototype == this) {
				// I *am* the standard library type!
				operations = getOwnedOperations();
			} else {
				// the prototype defines my operations for me
				operations = prototype.oclOperations();
			}
		}

		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkExclusiveSignature(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return org.eclipse.ocl.types.operations.MessageTypeOperations
			.checkExclusiveSignature(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkOperationParameters(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return org.eclipse.ocl.types.operations.MessageTypeOperations
			.checkOperationParameters(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkSignalAttributes(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return org.eclipse.ocl.types.operations.MessageTypeOperations
			.checkSignalAttributes(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLPackage.MESSAGE_TYPE__OWNED_OPERATION :
				return ((InternalEList<?>) getOwnedOperations()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.MESSAGE_TYPE__OWNED_ATTRIBUTE :
				return ((InternalEList<?>) getOwnedAttributes()).basicRemove(
					otherEnd, msgs);
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
			case UMLPackage.MESSAGE_TYPE__REFERRED_OPERATION :
				if (resolve)
					return getReferredOperation();
				return basicGetReferredOperation();
			case UMLPackage.MESSAGE_TYPE__REFERRED_SIGNAL :
				if (resolve)
					return getReferredSignal();
				return basicGetReferredSignal();
			case UMLPackage.MESSAGE_TYPE__OWNED_OPERATION :
				return getOwnedOperations();
			case UMLPackage.MESSAGE_TYPE__OWNED_ATTRIBUTE :
				return getOwnedAttributes();
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
			case UMLPackage.MESSAGE_TYPE__REFERRED_OPERATION :
				setReferredOperation((Operation) newValue);
				return;
			case UMLPackage.MESSAGE_TYPE__REFERRED_SIGNAL :
				setReferredSignal((Classifier) newValue);
				return;
			case UMLPackage.MESSAGE_TYPE__OWNED_OPERATION :
				getOwnedOperations().clear();
				getOwnedOperations().addAll(
					(Collection<? extends Operation>) newValue);
				return;
			case UMLPackage.MESSAGE_TYPE__OWNED_ATTRIBUTE :
				getOwnedAttributes().clear();
				getOwnedAttributes().addAll(
					(Collection<? extends Property>) newValue);
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
			case UMLPackage.MESSAGE_TYPE__REFERRED_OPERATION :
				setReferredOperation((Operation) null);
				return;
			case UMLPackage.MESSAGE_TYPE__REFERRED_SIGNAL :
				setReferredSignal((Classifier) null);
				return;
			case UMLPackage.MESSAGE_TYPE__OWNED_OPERATION :
				getOwnedOperations().clear();
				return;
			case UMLPackage.MESSAGE_TYPE__OWNED_ATTRIBUTE :
				getOwnedAttributes().clear();
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
			case UMLPackage.MESSAGE_TYPE__REFERRED_OPERATION :
				return referredOperation != null;
			case UMLPackage.MESSAGE_TYPE__REFERRED_SIGNAL :
				return referredSignal != null;
			case UMLPackage.MESSAGE_TYPE__OWNED_OPERATION :
				return ownedOperations != null && !ownedOperations.isEmpty();
			case UMLPackage.MESSAGE_TYPE__OWNED_ATTRIBUTE :
				return ownedAttributes != null && !ownedAttributes.isEmpty();
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
		if (baseClass == PredefinedType.class) {
			switch (derivedFeatureID) {
				default :
					return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.types.MessageType.class) {
			switch (derivedFeatureID) {
				case UMLPackage.MESSAGE_TYPE__REFERRED_OPERATION :
					return TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION;
				case UMLPackage.MESSAGE_TYPE__REFERRED_SIGNAL :
					return TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL;
				default :
					return -1;
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
		if (baseClass == PredefinedType.class) {
			switch (baseFeatureID) {
				default :
					return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.types.MessageType.class) {
			switch (baseFeatureID) {
				case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION :
					return UMLPackage.MESSAGE_TYPE__REFERRED_OPERATION;
				case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL :
					return UMLPackage.MESSAGE_TYPE__REFERRED_SIGNAL;
				default :
					return -1;
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
	public boolean isSetFeatures() {
		return super.isSetFeatures()
			|| eIsSet(UMLPackage.MESSAGE_TYPE__OWNED_OPERATION);
	}

} //MessageTypeImpl
