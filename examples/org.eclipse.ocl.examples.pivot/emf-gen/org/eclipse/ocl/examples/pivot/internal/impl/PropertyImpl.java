/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PropertyImpl.java,v 1.3 2011/01/27 06:59:07 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.AssociationClass;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.MultiplicityElement;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation;
import org.eclipse.ocl.examples.pivot.internal.operations.MultiplicityElementOperations;
import org.eclipse.ocl.examples.pivot.internal.operations.ParameterableElementOperations;
import org.eclipse.ocl.examples.pivot.internal.operations.PropertyOperations;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getImplementationClass <em>Implementation Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getFeaturingClass <em>Featuring Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getTemplateParameter <em>Template Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getOwningTemplateParameter <em>Owning Template Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isReadOnly <em>Is Read Only</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isComposite <em>Is Composite</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isDerived <em>Is Derived</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isImplicit <em>Implicit</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isID <em>Is ID</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getKeys <em>Keys</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isResolveProxies <em>Is Resolve Proxies</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isTransient <em>Is Transient</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isUnsettable <em>Is Unsettable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#isVolatile <em>Is Volatile</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.PropertyImpl#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyImpl
		extends TypedElementImpl
		implements Property {

	/**
	 * The default value of the '{@link #isOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ORDERED_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_ORDERED_EFLAG = 1 << 9;

	/**
	 * The default value of the '{@link #isUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNIQUE_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_UNIQUE_EFLAG = 1 << 10;

	/**
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger LOWER_EDEFAULT = new BigInteger("1"); //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected BigInteger lower = LOWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger UPPER_EDEFAULT = new BigInteger("1"); //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected BigInteger upper = UPPER_EDEFAULT;

	/**
	 * The default value of the '{@link #getImplementationClass() <em>Implementation Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationClass()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPLEMENTATION_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImplementationClass() <em>Implementation Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationClass()
	 * @generated
	 * @ordered
	 */
	protected String implementationClass = IMPLEMENTATION_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected static final CallableImplementation IMPLEMENTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected CallableImplementation implementation = IMPLEMENTATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTemplateParameter() <em>Template Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateParameter()
	 * @generated
	 * @ordered
	 */
	protected TemplateParameter templateParameter;

	/**
	 * The default value of the '{@link #isReadOnly() <em>Is Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_READ_ONLY_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isReadOnly() <em>Is Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_READ_ONLY_EFLAG = 1 << 11;

	/**
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected String default_ = DEFAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #isComposite() <em>Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COMPOSITE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isComposite() <em>Is Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposite()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_COMPOSITE_EFLAG = 1 << 12;

	/**
	 * The default value of the '{@link #isDerived() <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DERIVED_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isDerived() <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_DERIVED_EFLAG = 1 << 13;

	/**
	 * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected Property opposite;

	/**
	 * The cached value of the '{@link #getAssociation() <em>Association</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociation()
	 * @generated
	 * @ordered
	 */
	protected AssociationClass association;

	/**
	 * The default value of the '{@link #isImplicit() <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMPLICIT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isImplicit() <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final int IMPLICIT_EFLAG = 1 << 14;

	/**
	 * The default value of the '{@link #isID() <em>Is ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isID()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ID_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isID() <em>Is ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isID()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_ID_EFLAG = 1 << 15;

	/**
	 * The cached value of the '{@link #getKeys() <em>Keys</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> keys;

	/**
	 * The default value of the '{@link #isResolveProxies() <em>Is Resolve Proxies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolveProxies()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_RESOLVE_PROXIES_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isResolveProxies() <em>Is Resolve Proxies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolveProxies()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_RESOLVE_PROXIES_EFLAG = 1 << 16;

	/**
	 * The default value of the '{@link #isTransient() <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TRANSIENT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isTransient() <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_TRANSIENT_EFLAG = 1 << 17;

	/**
	 * The default value of the '{@link #isUnsettable() <em>Is Unsettable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnsettable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNSETTABLE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isUnsettable() <em>Is Unsettable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnsettable()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_UNSETTABLE_EFLAG = 1 << 18;

	/**
	 * The default value of the '{@link #isVolatile() <em>Is Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVolatile()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_VOLATILE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isVolatile() <em>Is Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVolatile()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_VOLATILE_EFLAG = 1 << 19;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyImpl() {
		super();
		eFlags |= IS_UNIQUE_EFLAG;
		eFlags |= IS_RESOLVE_PROXIES_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdered()
	{
		return (eFlags & IS_ORDERED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOrdered(boolean newIsOrdered)
	{
		boolean oldIsOrdered = (eFlags & IS_ORDERED_EFLAG) != 0;
		if (newIsOrdered) eFlags |= IS_ORDERED_EFLAG; else eFlags &= ~IS_ORDERED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_ORDERED, oldIsOrdered, newIsOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnique()
	{
		return (eFlags & IS_UNIQUE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUnique(boolean newIsUnique)
	{
		boolean oldIsUnique = (eFlags & IS_UNIQUE_EFLAG) != 0;
		if (newIsUnique) eFlags |= IS_UNIQUE_EFLAG; else eFlags &= ~IS_UNIQUE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_UNIQUE, oldIsUnique, newIsUnique));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getLower()
	{
		return lower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(BigInteger newLower)
	{
		BigInteger oldLower = lower;
		lower = newLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__LOWER, oldLower, lower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getUpper()
	{
		return upper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(BigInteger newUpper)
	{
		BigInteger oldUpper = upper;
		upper = newUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__UPPER, oldUpper, upper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public org.eclipse.ocl.examples.pivot.Class getFeaturingClass()
	{
		return getClass_();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isStatic() {
		return (eFlags & IS_STATIC_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsStatic(boolean newIsStatic) {
		boolean oldIsStatic = (eFlags & IS_STATIC_EFLAG) != 0;
		if (newIsStatic) eFlags |= IS_STATIC_EFLAG; else eFlags &= ~IS_STATIC_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_STATIC, oldIsStatic, newIsStatic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter getTemplateParameter() {
		if (templateParameter != null && ((EObject)templateParameter).eIsProxy())
		{
			InternalEObject oldTemplateParameter = (InternalEObject)templateParameter;
			templateParameter = (TemplateParameter)eResolveProxy(oldTemplateParameter);
			if (templateParameter != oldTemplateParameter)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.PROPERTY__TEMPLATE_PARAMETER, oldTemplateParameter, templateParameter));
			}
		}
		return templateParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter basicGetTemplateParameter() {
		return templateParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplateParameter(
			TemplateParameter newTemplateParameter, NotificationChain msgs) {
		TemplateParameter oldTemplateParameter = templateParameter;
		templateParameter = newTemplateParameter;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__TEMPLATE_PARAMETER, oldTemplateParameter, newTemplateParameter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			TemplateParameter owningTemplateParameter = basicGetOwningTemplateParameter();
			if (owningTemplateParameter != null && owningTemplateParameter != newTemplateParameter)
			{
				setOwningTemplateParameter(null);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateParameter(TemplateParameter newTemplateParameter) {
		if (newTemplateParameter != templateParameter)
		{
			NotificationChain msgs = null;
			if (templateParameter != null)
				msgs = ((InternalEObject)templateParameter).eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
			if (newTemplateParameter != null)
				msgs = ((InternalEObject)newTemplateParameter).eInverseAdd(this, PivotPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
			msgs = basicSetTemplateParameter(newTemplateParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__TEMPLATE_PARAMETER, newTemplateParameter, newTemplateParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter getOwningTemplateParameter() {
		if (eContainerFeatureID() != PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER) return null;
		return (TemplateParameter)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter basicGetOwningTemplateParameter() {
		if (eContainerFeatureID() != PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER) return null;
		return (TemplateParameter)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTemplateParameter(
			TemplateParameter newOwningTemplateParameter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTemplateParameter, PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER, msgs);
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (newOwningTemplateParameter != null)
			{
				if (newOwningTemplateParameter != templateParameter)
				{
					setTemplateParameter(newOwningTemplateParameter);
				}
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningTemplateParameter(
			TemplateParameter newOwningTemplateParameter) {
		if (newOwningTemplateParameter != eInternalContainer() || (eContainerFeatureID() != PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER && newOwningTemplateParameter != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newOwningTemplateParameter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTemplateParameter != null)
				msgs = ((InternalEObject)newOwningTemplateParameter).eInverseAdd(this, PivotPackage.TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
			msgs = basicSetOwningTemplateParameter(newOwningTemplateParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER, newOwningTemplateParameter, newOwningTemplateParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsStatic() {
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplementationClass() {
		return implementationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationClass(String newImplementationClass) {
		String oldImplementationClass = implementationClass;
		implementationClass = newImplementationClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IMPLEMENTATION_CLASS, oldImplementationClass, implementationClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallableImplementation getImplementation() {
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(CallableImplementation newImplementation) {
		CallableImplementation oldImplementation = implementation;
		implementation = newImplementation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IMPLEMENTATION, oldImplementation, implementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		return (eFlags & IS_READ_ONLY_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsReadOnly(boolean newIsReadOnly) {
		boolean oldIsReadOnly = (eFlags & IS_READ_ONLY_EFLAG) != 0;
		if (newIsReadOnly) eFlags |= IS_READ_ONLY_EFLAG; else eFlags &= ~IS_READ_ONLY_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_READ_ONLY, oldIsReadOnly, newIsReadOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(String newDefault) {
		String oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComposite() {
		return (eFlags & IS_COMPOSITE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsComposite(boolean newIsComposite) {
		boolean oldIsComposite = (eFlags & IS_COMPOSITE_EFLAG) != 0;
		if (newIsComposite) eFlags |= IS_COMPOSITE_EFLAG; else eFlags &= ~IS_COMPOSITE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_COMPOSITE, oldIsComposite, newIsComposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDerived() {
		return (eFlags & IS_DERIVED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDerived(boolean newIsDerived) {
		boolean oldIsDerived = (eFlags & IS_DERIVED_EFLAG) != 0;
		if (newIsDerived) eFlags |= IS_DERIVED_EFLAG; else eFlags &= ~IS_DERIVED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_DERIVED, oldIsDerived, newIsDerived));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getOpposite() {
		if (opposite != null && ((EObject)opposite).eIsProxy())
		{
			InternalEObject oldOpposite = (InternalEObject)opposite;
			opposite = (Property)eResolveProxy(oldOpposite);
			if (opposite != oldOpposite)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.PROPERTY__OPPOSITE, oldOpposite, opposite));
			}
		}
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetOpposite() {
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpposite(Property newOpposite) {
		Property oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__OPPOSITE, oldOpposite, opposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass getAssociation() {
		if (association != null && ((EObject)association).eIsProxy())
		{
			InternalEObject oldAssociation = (InternalEObject)association;
			association = (AssociationClass)eResolveProxy(oldAssociation);
			if (association != oldAssociation)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.PROPERTY__ASSOCIATION, oldAssociation, association));
			}
		}
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass basicGetAssociation() {
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssociation(
			AssociationClass newAssociation, NotificationChain msgs) {
		AssociationClass oldAssociation = association;
		association = newAssociation;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__ASSOCIATION, oldAssociation, newAssociation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociation(AssociationClass newAssociation) {
		if (newAssociation != association)
		{
			NotificationChain msgs = null;
			if (association != null)
				msgs = ((InternalEObject)association).eInverseRemove(this, PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE, AssociationClass.class, msgs);
			if (newAssociation != null)
				msgs = ((InternalEObject)newAssociation).eInverseAdd(this, PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE, AssociationClass.class, msgs);
			msgs = basicSetAssociation(newAssociation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__ASSOCIATION, newAssociation, newAssociation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImplicit()
	{
		return (eFlags & IMPLICIT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplicit(boolean newImplicit)
	{
		boolean oldImplicit = (eFlags & IMPLICIT_EFLAG) != 0;
		if (newImplicit) eFlags |= IMPLICIT_EFLAG; else eFlags &= ~IMPLICIT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IMPLICIT, oldImplicit, newImplicit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isID()
	{
		return (eFlags & IS_ID_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsID(boolean newIsID)
	{
		boolean oldIsID = (eFlags & IS_ID_EFLAG) != 0;
		if (newIsID) eFlags |= IS_ID_EFLAG; else eFlags &= ~IS_ID_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_ID, oldIsID, newIsID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getKeys()
	{
		if (keys == null)
		{
			keys = new EObjectResolvingEList<Property>(Property.class, this, PivotPackage.PROPERTY__KEYS);
		}
		return keys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResolveProxies()
	{
		return (eFlags & IS_RESOLVE_PROXIES_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsResolveProxies(boolean newIsResolveProxies)
	{
		boolean oldIsResolveProxies = (eFlags & IS_RESOLVE_PROXIES_EFLAG) != 0;
		if (newIsResolveProxies) eFlags |= IS_RESOLVE_PROXIES_EFLAG; else eFlags &= ~IS_RESOLVE_PROXIES_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_RESOLVE_PROXIES, oldIsResolveProxies, newIsResolveProxies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransient()
	{
		return (eFlags & IS_TRANSIENT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTransient(boolean newIsTransient)
	{
		boolean oldIsTransient = (eFlags & IS_TRANSIENT_EFLAG) != 0;
		if (newIsTransient) eFlags |= IS_TRANSIENT_EFLAG; else eFlags &= ~IS_TRANSIENT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_TRANSIENT, oldIsTransient, newIsTransient));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnsettable()
	{
		return (eFlags & IS_UNSETTABLE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUnsettable(boolean newIsUnsettable)
	{
		boolean oldIsUnsettable = (eFlags & IS_UNSETTABLE_EFLAG) != 0;
		if (newIsUnsettable) eFlags |= IS_UNSETTABLE_EFLAG; else eFlags &= ~IS_UNSETTABLE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_UNSETTABLE, oldIsUnsettable, newIsUnsettable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVolatile()
	{
		return (eFlags & IS_VOLATILE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsVolatile(boolean newIsVolatile)
	{
		boolean oldIsVolatile = (eFlags & IS_VOLATILE_EFLAG) != 0;
		if (newIsVolatile) eFlags |= IS_VOLATILE_EFLAG; else eFlags &= ~IS_VOLATILE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__IS_VOLATILE, oldIsVolatile, newIsVolatile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.examples.pivot.Class getClass_() {
		if (eContainerFeatureID() != PivotPackage.PROPERTY__CLASS) return null;
		return (org.eclipse.ocl.examples.pivot.Class)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.examples.pivot.Class basicGetClass_() {
		if (eContainerFeatureID() != PivotPackage.PROPERTY__CLASS) return null;
		return (org.eclipse.ocl.examples.pivot.Class)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClass_(
			org.eclipse.ocl.examples.pivot.Class newClass,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newClass, PivotPackage.PROPERTY__CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass_(org.eclipse.ocl.examples.pivot.Class newClass) {
		if (newClass != eInternalContainer() || (eContainerFeatureID() != PivotPackage.PROPERTY__CLASS && newClass != null))
		{
			if (EcoreUtil.isAncestor(this, (EObject)newClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newClass != null)
				msgs = ((InternalEObject)newClass).eInverseAdd(this, PivotPackage.CLASS__OWNED_ATTRIBUTE, org.eclipse.ocl.examples.pivot.Class.class, msgs);
			msgs = basicSetClass_(newClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.PROPERTY__CLASS, newClass, newClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLowerGe0(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return MultiplicityElementOperations.validateLowerGe0(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUpperGeLower(DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return MultiplicityElementOperations.validateUpperGeLower(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger lowerBound()
	{
		return MultiplicityElementOperations.lowerBound(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger upperBound()
	{
		return MultiplicityElementOperations.upperBound(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMultivalued()
	{
		return MultiplicityElementOperations.isMultivalued(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean includesCardinality(BigInteger C)
	{
		return MultiplicityElementOperations.includesCardinality(this, C);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean includesMultiplicity(MultiplicityElement M)
	{
		return MultiplicityElementOperations.includesMultiplicity(this, M);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplateParameter() {
		return ParameterableElementOperations.isTemplateParameter(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBindingToAttribute(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return PropertyOperations.validateBindingToAttribute(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.PROPERTY__TEMPLATE_PARAMETER:
				if (templateParameter != null)
					msgs = ((InternalEObject)templateParameter).eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
				return basicSetTemplateParameter((TemplateParameter)otherEnd, msgs);
			case PivotPackage.PROPERTY__ASSOCIATION:
				if (association != null)
					msgs = ((InternalEObject)association).eInverseRemove(this, PivotPackage.ASSOCIATION_CLASS__UNOWNED_ATTRIBUTE, AssociationClass.class, msgs);
				return basicSetAssociation((AssociationClass)otherEnd, msgs);
			case PivotPackage.PROPERTY__CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetClass_((org.eclipse.ocl.examples.pivot.Class)otherEnd, msgs);
		}
		return eDynamicInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case PivotPackage.PROPERTY__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROPERTY__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRules()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROPERTY__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER:
				return basicSetOwningTemplateParameter(null, msgs);
			case PivotPackage.PROPERTY__TEMPLATE_PARAMETER:
				return basicSetTemplateParameter(null, msgs);
			case PivotPackage.PROPERTY__ASSOCIATION:
				return basicSetAssociation(null, msgs);
			case PivotPackage.PROPERTY__CLASS:
				return basicSetClass_(null, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID())
		{
			case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER:
				return eInternalContainer().eInverseRemove(this, PivotPackage.TEMPLATE_PARAMETER__OWNED_PARAMETERED_ELEMENT, TemplateParameter.class, msgs);
			case PivotPackage.PROPERTY__CLASS:
				return eInternalContainer().eInverseRemove(this, PivotPackage.CLASS__OWNED_ATTRIBUTE, org.eclipse.ocl.examples.pivot.Class.class, msgs);
		}
		return eDynamicBasicRemoveFromContainer(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case PivotPackage.PROPERTY__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.PROPERTY__MONIKER:
				return getMoniker();
			case PivotPackage.PROPERTY__NAME:
				return getName();
			case PivotPackage.PROPERTY__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.PROPERTY__IS_STATIC:
				return isStatic();
			case PivotPackage.PROPERTY__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.PROPERTY__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.PROPERTY__IS_ORDERED:
				return isOrdered();
			case PivotPackage.PROPERTY__IS_UNIQUE:
				return isUnique();
			case PivotPackage.PROPERTY__LOWER:
				return getLower();
			case PivotPackage.PROPERTY__UPPER:
				return getUpper();
			case PivotPackage.PROPERTY__IMPLEMENTATION_CLASS:
				return getImplementationClass();
			case PivotPackage.PROPERTY__IMPLEMENTATION:
				return getImplementation();
			case PivotPackage.PROPERTY__FEATURING_CLASS:
				return getFeaturingClass();
			case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER:
				if (resolve) return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case PivotPackage.PROPERTY__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.PROPERTY__IS_READ_ONLY:
				return isReadOnly();
			case PivotPackage.PROPERTY__DEFAULT:
				return getDefault();
			case PivotPackage.PROPERTY__IS_COMPOSITE:
				return isComposite();
			case PivotPackage.PROPERTY__IS_DERIVED:
				return isDerived();
			case PivotPackage.PROPERTY__OPPOSITE:
				if (resolve) return getOpposite();
				return basicGetOpposite();
			case PivotPackage.PROPERTY__ASSOCIATION:
				if (resolve) return getAssociation();
				return basicGetAssociation();
			case PivotPackage.PROPERTY__IMPLICIT:
				return isImplicit();
			case PivotPackage.PROPERTY__IS_ID:
				return isID();
			case PivotPackage.PROPERTY__KEYS:
				return getKeys();
			case PivotPackage.PROPERTY__IS_RESOLVE_PROXIES:
				return isResolveProxies();
			case PivotPackage.PROPERTY__IS_TRANSIENT:
				return isTransient();
			case PivotPackage.PROPERTY__IS_UNSETTABLE:
				return isUnsettable();
			case PivotPackage.PROPERTY__IS_VOLATILE:
				return isVolatile();
			case PivotPackage.PROPERTY__CLASS:
				if (resolve) return getClass_();
				return basicGetClass_();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case PivotPackage.PROPERTY__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.PROPERTY__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.PROPERTY__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.PROPERTY__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.PROPERTY__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.PROPERTY__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.PROPERTY__IS_ORDERED:
				setIsOrdered((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__IS_UNIQUE:
				setIsUnique((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__LOWER:
				setLower((BigInteger)newValue);
				return;
			case PivotPackage.PROPERTY__UPPER:
				setUpper((BigInteger)newValue);
				return;
			case PivotPackage.PROPERTY__IMPLEMENTATION_CLASS:
				setImplementationClass((String)newValue);
				return;
			case PivotPackage.PROPERTY__IMPLEMENTATION:
				setImplementation((CallableImplementation)newValue);
				return;
			case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.PROPERTY__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.PROPERTY__IS_READ_ONLY:
				setIsReadOnly((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__DEFAULT:
				setDefault((String)newValue);
				return;
			case PivotPackage.PROPERTY__IS_COMPOSITE:
				setIsComposite((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__IS_DERIVED:
				setIsDerived((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__OPPOSITE:
				setOpposite((Property)newValue);
				return;
			case PivotPackage.PROPERTY__ASSOCIATION:
				setAssociation((AssociationClass)newValue);
				return;
			case PivotPackage.PROPERTY__IMPLICIT:
				setImplicit((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__IS_ID:
				setIsID((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__KEYS:
				getKeys().clear();
				getKeys().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.PROPERTY__IS_RESOLVE_PROXIES:
				setIsResolveProxies((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__IS_TRANSIENT:
				setIsTransient((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__IS_UNSETTABLE:
				setIsUnsettable((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__IS_VOLATILE:
				setIsVolatile((Boolean)newValue);
				return;
			case PivotPackage.PROPERTY__CLASS:
				setClass_((org.eclipse.ocl.examples.pivot.Class)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case PivotPackage.PROPERTY__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.PROPERTY__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.PROPERTY__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.PROPERTY__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.PROPERTY__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IMPLEMENTATION_CLASS:
				setImplementationClass(IMPLEMENTATION_CLASS_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IMPLEMENTATION:
				setImplementation(IMPLEMENTATION_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.PROPERTY__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.PROPERTY__IS_READ_ONLY:
				setIsReadOnly(IS_READ_ONLY_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_COMPOSITE:
				setIsComposite(IS_COMPOSITE_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_DERIVED:
				setIsDerived(IS_DERIVED_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__OPPOSITE:
				setOpposite((Property)null);
				return;
			case PivotPackage.PROPERTY__ASSOCIATION:
				setAssociation((AssociationClass)null);
				return;
			case PivotPackage.PROPERTY__IMPLICIT:
				setImplicit(IMPLICIT_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_ID:
				setIsID(IS_ID_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__KEYS:
				getKeys().clear();
				return;
			case PivotPackage.PROPERTY__IS_RESOLVE_PROXIES:
				setIsResolveProxies(IS_RESOLVE_PROXIES_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_TRANSIENT:
				setIsTransient(IS_TRANSIENT_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_UNSETTABLE:
				setIsUnsettable(IS_UNSETTABLE_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__IS_VOLATILE:
				setIsVolatile(IS_VOLATILE_EDEFAULT);
				return;
			case PivotPackage.PROPERTY__CLASS:
				setClass_((org.eclipse.ocl.examples.pivot.Class)null);
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case PivotPackage.PROPERTY__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.PROPERTY__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.PROPERTY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.PROPERTY__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.PROPERTY__IS_STATIC:
				return isSetIsStatic();
			case PivotPackage.PROPERTY__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.PROPERTY__TYPE:
				return type != null;
			case PivotPackage.PROPERTY__IS_ORDERED:
				return ((eFlags & IS_ORDERED_EFLAG) != 0) != IS_ORDERED_EDEFAULT;
			case PivotPackage.PROPERTY__IS_UNIQUE:
				return ((eFlags & IS_UNIQUE_EFLAG) != 0) != IS_UNIQUE_EDEFAULT;
			case PivotPackage.PROPERTY__LOWER:
				return LOWER_EDEFAULT == null ? lower != null : !LOWER_EDEFAULT.equals(lower);
			case PivotPackage.PROPERTY__UPPER:
				return UPPER_EDEFAULT == null ? upper != null : !UPPER_EDEFAULT.equals(upper);
			case PivotPackage.PROPERTY__IMPLEMENTATION_CLASS:
				return IMPLEMENTATION_CLASS_EDEFAULT == null ? implementationClass != null : !IMPLEMENTATION_CLASS_EDEFAULT.equals(implementationClass);
			case PivotPackage.PROPERTY__IMPLEMENTATION:
				return IMPLEMENTATION_EDEFAULT == null ? implementation != null : !IMPLEMENTATION_EDEFAULT.equals(implementation);
			case PivotPackage.PROPERTY__FEATURING_CLASS:
				return getFeaturingClass() != null;
			case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER:
				return basicGetOwningTemplateParameter() != null;
			case PivotPackage.PROPERTY__TEMPLATE_PARAMETER:
				return templateParameter != null;
			case PivotPackage.PROPERTY__IS_READ_ONLY:
				return ((eFlags & IS_READ_ONLY_EFLAG) != 0) != IS_READ_ONLY_EDEFAULT;
			case PivotPackage.PROPERTY__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case PivotPackage.PROPERTY__IS_COMPOSITE:
				return ((eFlags & IS_COMPOSITE_EFLAG) != 0) != IS_COMPOSITE_EDEFAULT;
			case PivotPackage.PROPERTY__IS_DERIVED:
				return ((eFlags & IS_DERIVED_EFLAG) != 0) != IS_DERIVED_EDEFAULT;
			case PivotPackage.PROPERTY__OPPOSITE:
				return opposite != null;
			case PivotPackage.PROPERTY__ASSOCIATION:
				return association != null;
			case PivotPackage.PROPERTY__IMPLICIT:
				return ((eFlags & IMPLICIT_EFLAG) != 0) != IMPLICIT_EDEFAULT;
			case PivotPackage.PROPERTY__IS_ID:
				return ((eFlags & IS_ID_EFLAG) != 0) != IS_ID_EDEFAULT;
			case PivotPackage.PROPERTY__KEYS:
				return keys != null && !keys.isEmpty();
			case PivotPackage.PROPERTY__IS_RESOLVE_PROXIES:
				return ((eFlags & IS_RESOLVE_PROXIES_EFLAG) != 0) != IS_RESOLVE_PROXIES_EDEFAULT;
			case PivotPackage.PROPERTY__IS_TRANSIENT:
				return ((eFlags & IS_TRANSIENT_EFLAG) != 0) != IS_TRANSIENT_EDEFAULT;
			case PivotPackage.PROPERTY__IS_UNSETTABLE:
				return ((eFlags & IS_UNSETTABLE_EFLAG) != 0) != IS_UNSETTABLE_EDEFAULT;
			case PivotPackage.PROPERTY__IS_VOLATILE:
				return ((eFlags & IS_VOLATILE_EFLAG) != 0) != IS_VOLATILE_EDEFAULT;
			case PivotPackage.PROPERTY__CLASS:
				return basicGetClass_() != null;
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MultiplicityElement.class)
		{
			switch (derivedFeatureID)
			{
				case PivotPackage.PROPERTY__IS_ORDERED: return PivotPackage.MULTIPLICITY_ELEMENT__IS_ORDERED;
				case PivotPackage.PROPERTY__IS_UNIQUE: return PivotPackage.MULTIPLICITY_ELEMENT__IS_UNIQUE;
				case PivotPackage.PROPERTY__LOWER: return PivotPackage.MULTIPLICITY_ELEMENT__LOWER;
				case PivotPackage.PROPERTY__UPPER: return PivotPackage.MULTIPLICITY_ELEMENT__UPPER;
				default: return -1;
			}
		}
		if (baseClass == TypedMultiplicityElement.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == Feature.class)
		{
			switch (derivedFeatureID)
			{
				case PivotPackage.PROPERTY__IMPLEMENTATION_CLASS: return PivotPackage.FEATURE__IMPLEMENTATION_CLASS;
				case PivotPackage.PROPERTY__IMPLEMENTATION: return PivotPackage.FEATURE__IMPLEMENTATION;
				case PivotPackage.PROPERTY__FEATURING_CLASS: return PivotPackage.FEATURE__FEATURING_CLASS;
				default: return -1;
			}
		}
		if (baseClass == ParameterableElement.class)
		{
			switch (derivedFeatureID)
			{
				case PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER: return PivotPackage.PARAMETERABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER;
				case PivotPackage.PROPERTY__TEMPLATE_PARAMETER: return PivotPackage.PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER;
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
		if (baseClass == MultiplicityElement.class)
		{
			switch (baseFeatureID)
			{
				case PivotPackage.MULTIPLICITY_ELEMENT__IS_ORDERED: return PivotPackage.PROPERTY__IS_ORDERED;
				case PivotPackage.MULTIPLICITY_ELEMENT__IS_UNIQUE: return PivotPackage.PROPERTY__IS_UNIQUE;
				case PivotPackage.MULTIPLICITY_ELEMENT__LOWER: return PivotPackage.PROPERTY__LOWER;
				case PivotPackage.MULTIPLICITY_ELEMENT__UPPER: return PivotPackage.PROPERTY__UPPER;
				default: return -1;
			}
		}
		if (baseClass == TypedMultiplicityElement.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == Feature.class)
		{
			switch (baseFeatureID)
			{
				case PivotPackage.FEATURE__IMPLEMENTATION_CLASS: return PivotPackage.PROPERTY__IMPLEMENTATION_CLASS;
				case PivotPackage.FEATURE__IMPLEMENTATION: return PivotPackage.PROPERTY__IMPLEMENTATION;
				case PivotPackage.FEATURE__FEATURING_CLASS: return PivotPackage.PROPERTY__FEATURING_CLASS;
				default: return -1;
			}
		}
		if (baseClass == ParameterableElement.class)
		{
			switch (baseFeatureID)
			{
				case PivotPackage.PARAMETERABLE_ELEMENT__OWNING_TEMPLATE_PARAMETER: return PivotPackage.PROPERTY__OWNING_TEMPLATE_PARAMETER;
				case PivotPackage.PARAMETERABLE_ELEMENT__TEMPLATE_PARAMETER: return PivotPackage.PROPERTY__TEMPLATE_PARAMETER;
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == MultiplicityElement.class)
		{
			switch (baseOperationID)
			{
				case PivotPackage.MULTIPLICITY_ELEMENT___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP: return PivotPackage.PROPERTY___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP;
				case PivotPackage.MULTIPLICITY_ELEMENT___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP: return PivotPackage.PROPERTY___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP;
				case PivotPackage.MULTIPLICITY_ELEMENT___LOWER_BOUND: return PivotPackage.PROPERTY___LOWER_BOUND;
				case PivotPackage.MULTIPLICITY_ELEMENT___UPPER_BOUND: return PivotPackage.PROPERTY___UPPER_BOUND;
				case PivotPackage.MULTIPLICITY_ELEMENT___IS_MULTIVALUED: return PivotPackage.PROPERTY___IS_MULTIVALUED;
				case PivotPackage.MULTIPLICITY_ELEMENT___INCLUDES_CARDINALITY__BIGINTEGER: return PivotPackage.PROPERTY___INCLUDES_CARDINALITY__BIGINTEGER;
				case PivotPackage.MULTIPLICITY_ELEMENT___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT: return PivotPackage.PROPERTY___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT;
				default: return -1;
			}
		}
		if (baseClass == TypedMultiplicityElement.class)
		{
			switch (baseOperationID)
			{
				default: return -1;
			}
		}
		if (baseClass == Feature.class)
		{
			switch (baseOperationID)
			{
				default: return -1;
			}
		}
		if (baseClass == ParameterableElement.class)
		{
			switch (baseOperationID)
			{
				case PivotPackage.PARAMETERABLE_ELEMENT___IS_TEMPLATE_PARAMETER: return PivotPackage.PROPERTY___IS_TEMPLATE_PARAMETER;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID)
		{
			case PivotPackage.PROPERTY___HAS_MONIKER:
				return hasMoniker();
			case PivotPackage.PROPERTY___VALIDATE_LOWER_GE0__DIAGNOSTICCHAIN_MAP:
				return validateLowerGe0((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.PROPERTY___VALIDATE_UPPER_GE_LOWER__DIAGNOSTICCHAIN_MAP:
				return validateUpperGeLower((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case PivotPackage.PROPERTY___LOWER_BOUND:
				return lowerBound();
			case PivotPackage.PROPERTY___UPPER_BOUND:
				return upperBound();
			case PivotPackage.PROPERTY___IS_MULTIVALUED:
				return isMultivalued();
			case PivotPackage.PROPERTY___INCLUDES_CARDINALITY__BIGINTEGER:
				return includesCardinality((BigInteger)arguments.get(0));
			case PivotPackage.PROPERTY___INCLUDES_MULTIPLICITY__MULTIPLICITYELEMENT:
				return includesMultiplicity((MultiplicityElement)arguments.get(0));
			case PivotPackage.PROPERTY___IS_TEMPLATE_PARAMETER:
				return isTemplateParameter();
			case PivotPackage.PROPERTY___VALIDATE_BINDING_TO_ATTRIBUTE__DIAGNOSTICCHAIN_MAP:
				return validateBindingToAttribute((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return eDynamicInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitProperty(this);
	}
} //PropertyImpl
