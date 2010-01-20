/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;

import de.hpi.sam.bp2009.benchframework.impl.OptionObjectImpl;

import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Option Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorOptionObjectImpl#getMetaModel <em>Meta Model</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorOptionObjectImpl#getInstanceParameters <em>Instance Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RandomGeneratorOptionObjectImpl extends OptionObjectImpl implements RandomGeneratorOptionObject {
	/**
	 * The default value of the '{@link #getMetaModel() <em>Meta Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModel()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceSet META_MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetaModel() <em>Meta Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModel()
	 * @generated
	 * @ordered
	 */
	protected ResourceSet metaModel = META_MODEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInstanceParameters() <em>Instance Parameters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceParameters()
	 * @generated
	 * @ordered
	 */
	protected Map<String, Integer> instanceParameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RandomGeneratorOptionObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RandomGeneratorPackage.Literals.RANDOM_GENERATOR_OPTION_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceSet getMetaModel() {
		return metaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaModel(ResourceSet newMetaModel) {
		ResourceSet oldMetaModel = metaModel;
		metaModel = newMetaModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL, oldMetaModel, metaModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, Integer> getInstanceParameters() {
		return instanceParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceParameters(Map<String, Integer> newInstanceParameters) {
		Map<String, Integer> oldInstanceParameters = instanceParameters;
		instanceParameters = newInstanceParameters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__INSTANCE_PARAMETERS, oldInstanceParameters, instanceParameters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
				return getMetaModel();
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__INSTANCE_PARAMETERS:
				return getInstanceParameters();
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
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
				setMetaModel((ResourceSet)newValue);
				return;
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__INSTANCE_PARAMETERS:
				setInstanceParameters((Map<String, Integer>)newValue);
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
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
				setMetaModel(META_MODEL_EDEFAULT);
				return;
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__INSTANCE_PARAMETERS:
				setInstanceParameters((Map<String, Integer>)null);
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
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
				return META_MODEL_EDEFAULT == null ? metaModel != null : !META_MODEL_EDEFAULT.equals(metaModel);
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__INSTANCE_PARAMETERS:
				return instanceParameters != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (metaModel: ");
		result.append(metaModel);
		result.append(", instanceParameters: ");
		result.append(instanceParameters);
		result.append(')');
		return result.toString();
	}

} //RandomGeneratorOptionObjectImpl
