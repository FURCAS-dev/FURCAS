/**
 * <copyright>
 * </copyright>
 *
 * $Id: DeploymentUnitImpl.java,v 1.1 2011/02/07 16:57:59 auhl Exp $
 */
package modelmanagement.deploymentunits.impl;

import java.util.Collection;
import modelmanagement.deploymentunits.DeploymentUnit;
import modelmanagement.deploymentunits.DeploymentunitsPackage;

import modelmanagement.impl.PackageOwnerImpl;

import modelmanagement.processcomponents.ProcessComponent;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
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
     * The cached value of the '{@link #getPcsInsideCompany() <em>Pcs Inside Company</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPcsInsideCompany()
     * @generated
     * @ordered
     */
	protected EList<ProcessComponent> pcsInsideCompany;

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
	public EList<ProcessComponent> getPcsInsideCompany() {
        if (pcsInsideCompany == null) {
            pcsInsideCompany = new EObjectContainmentEList.Resolving<ProcessComponent>(ProcessComponent.class, this, DeploymentunitsPackage.DEPLOYMENT_UNIT__PCS_INSIDE_COMPANY);
        }
        return pcsInsideCompany;
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
                return ((InternalEList<?>)getPcsInsideCompany()).basicRemove(otherEnd, msgs);
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case DeploymentunitsPackage.DEPLOYMENT_UNIT__PCS_INSIDE_COMPANY:
                getPcsInsideCompany().clear();
                getPcsInsideCompany().addAll((Collection<? extends ProcessComponent>)newValue);
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
                getPcsInsideCompany().clear();
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
                return pcsInsideCompany != null && !pcsInsideCompany.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //DeploymentUnitImpl
