/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package modelmanagement.deploymentunits.impl;

import modelmanagement.deploymentunits.DeploymentUnit;
import modelmanagement.deploymentunits.DeploymentunitsPackage;

import modelmanagement.impl.PackageOwnerImpl;

import modelmanagement.processcomponents.ProcessComponent;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployment Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modelmanagement.deploymentunits.impl.DeploymentUnitImpl#getPcsInsideCompany <em>Pcs Inside Company</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeploymentUnitImpl extends PackageOwnerImpl implements DeploymentUnit {
	/**
	 * The cached value of the '{@link #getPcsInsideCompany() <em>Pcs Inside Company</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPcsInsideCompany()
	 * @generated
	 * @ordered
	 */
	protected ProcessComponent pcsInsideCompany;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeploymentUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeploymentunitsPackage.Literals.DEPLOYMENT_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessComponent getPcsInsideCompany() {
		return pcsInsideCompany;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPcsInsideCompany(ProcessComponent newPcsInsideCompany, NotificationChain msgs) {
		ProcessComponent oldPcsInsideCompany = pcsInsideCompany;
		pcsInsideCompany = newPcsInsideCompany;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DeploymentunitsPackage.DEPLOYMENT_UNIT__PCS_INSIDE_COMPANY, oldPcsInsideCompany, newPcsInsideCompany);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPcsInsideCompany(ProcessComponent newPcsInsideCompany) {
		if (newPcsInsideCompany != pcsInsideCompany) {
			NotificationChain msgs = null;
			if (pcsInsideCompany != null)
				msgs = ((InternalEObject)pcsInsideCompany).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DeploymentunitsPackage.DEPLOYMENT_UNIT__PCS_INSIDE_COMPANY, null, msgs);
			if (newPcsInsideCompany != null)
				msgs = ((InternalEObject)newPcsInsideCompany).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DeploymentunitsPackage.DEPLOYMENT_UNIT__PCS_INSIDE_COMPANY, null, msgs);
			msgs = basicSetPcsInsideCompany(newPcsInsideCompany, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeploymentunitsPackage.DEPLOYMENT_UNIT__PCS_INSIDE_COMPANY, newPcsInsideCompany, newPcsInsideCompany));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DeploymentunitsPackage.DEPLOYMENT_UNIT__PCS_INSIDE_COMPANY:
				return basicSetPcsInsideCompany(null, msgs);
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
			case DeploymentunitsPackage.DEPLOYMENT_UNIT__PCS_INSIDE_COMPANY:
				return getPcsInsideCompany();
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
			case DeploymentunitsPackage.DEPLOYMENT_UNIT__PCS_INSIDE_COMPANY:
				setPcsInsideCompany((ProcessComponent)newValue);
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
			case DeploymentunitsPackage.DEPLOYMENT_UNIT__PCS_INSIDE_COMPANY:
				setPcsInsideCompany((ProcessComponent)null);
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
			case DeploymentunitsPackage.DEPLOYMENT_UNIT__PCS_INSIDE_COMPANY:
				return pcsInsideCompany != null;
		}
		return super.eIsSet(featureID);
	}

} //DeploymentUnitImpl
