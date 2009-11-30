/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.impl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.Generator;
import de.hpi.sam.bp2009.benchframework.OptionObject;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.GeneratorImpl#getDefaultOption <em>Default Option</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class GeneratorImpl extends EObjectImpl implements Generator {
	/**
	 * The cached value of the '{@link #getDefaultOption() <em>Default Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultOption()
	 * @generated
	 * @ordered
	 */
	protected OptionObject defaultOption;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BenchframeworkPackage.Literals.GENERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionObject getDefaultOption() {
		if (defaultOption != null && defaultOption.eIsProxy()) {
			InternalEObject oldDefaultOption = (InternalEObject)defaultOption;
			defaultOption = (OptionObject)eResolveProxy(oldDefaultOption);
			if (defaultOption != oldDefaultOption) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BenchframeworkPackage.GENERATOR__DEFAULT_OPTION, oldDefaultOption, defaultOption));
			}
		}
		return defaultOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionObject basicGetDefaultOption() {
		return defaultOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultOption(OptionObject newDefaultOption) {
		OptionObject oldDefaultOption = defaultOption;
		defaultOption = newDefaultOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.GENERATOR__DEFAULT_OPTION, oldDefaultOption, defaultOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource execute(OptionObject option) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BenchframeworkPackage.GENERATOR__DEFAULT_OPTION:
				if (resolve) return getDefaultOption();
				return basicGetDefaultOption();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BenchframeworkPackage.GENERATOR__DEFAULT_OPTION:
				setDefaultOption((OptionObject)newValue);
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
			case BenchframeworkPackage.GENERATOR__DEFAULT_OPTION:
				setDefaultOption((OptionObject)null);
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
			case BenchframeworkPackage.GENERATOR__DEFAULT_OPTION:
				return defaultOption != null;
		}
		return super.eIsSet(featureID);
	}

} //GeneratorImpl
