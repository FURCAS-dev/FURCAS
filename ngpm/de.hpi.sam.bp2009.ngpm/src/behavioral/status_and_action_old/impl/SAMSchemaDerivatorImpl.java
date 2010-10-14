/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action_old.impl;

import behavioral.status_and_action_old.SAMDerivator;
import behavioral.status_and_action_old.SAMSchemaDerivator;
import behavioral.status_and_action_old.SAMSchemaVariable;
import behavioral.status_and_action_old.SAMStatusSchema;
import behavioral.status_and_action_old.Status_and_action_oldPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SAM Schema Derivator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaDerivatorImpl#getSamDerivator <em>Sam Derivator</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaDerivatorImpl#getSamStatusSchema <em>Sam Status Schema</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaDerivatorImpl#getSamSourceSchemaVariables <em>Sam Source Schema Variables</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaDerivatorImpl#getSamTargetSchemaVariable <em>Sam Target Schema Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAMSchemaDerivatorImpl extends EObjectImpl implements SAMSchemaDerivator {
	/**
     * The cached value of the '{@link #getSamDerivator() <em>Sam Derivator</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamDerivator()
     * @generated
     * @ordered
     */
	protected SAMDerivator samDerivator;

	/**
     * The cached value of the '{@link #getSamSourceSchemaVariables() <em>Sam Source Schema Variables</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamSourceSchemaVariables()
     * @generated
     * @ordered
     */
	protected EList<SAMSchemaVariable> samSourceSchemaVariables;

	/**
     * The cached value of the '{@link #getSamTargetSchemaVariable() <em>Sam Target Schema Variable</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamTargetSchemaVariable()
     * @generated
     * @ordered
     */
	protected EList<SAMSchemaVariable> samTargetSchemaVariable;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SAMSchemaDerivatorImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Status_and_action_oldPackage.Literals.SAM_SCHEMA_DERIVATOR;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMDerivator getSamDerivator() {
        if (samDerivator != null && samDerivator.eIsProxy()) {
            InternalEObject oldSamDerivator = (InternalEObject)samDerivator;
            samDerivator = (SAMDerivator)eResolveProxy(oldSamDerivator);
            if (samDerivator != oldSamDerivator) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_DERIVATOR, oldSamDerivator, samDerivator));
            }
        }
        return samDerivator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMDerivator basicGetSamDerivator() {
        return samDerivator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSamDerivator(SAMDerivator newSamDerivator, NotificationChain msgs) {
        SAMDerivator oldSamDerivator = samDerivator;
        samDerivator = newSamDerivator;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_DERIVATOR, oldSamDerivator, newSamDerivator);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSamDerivator(SAMDerivator newSamDerivator) {
        if (newSamDerivator != samDerivator) {
            NotificationChain msgs = null;
            if (samDerivator != null)
                msgs = ((InternalEObject)samDerivator).eInverseRemove(this, Status_and_action_oldPackage.SAM_DERIVATOR__SAM_SCHEMA_DERIVATORS, SAMDerivator.class, msgs);
            if (newSamDerivator != null)
                msgs = ((InternalEObject)newSamDerivator).eInverseAdd(this, Status_and_action_oldPackage.SAM_DERIVATOR__SAM_SCHEMA_DERIVATORS, SAMDerivator.class, msgs);
            msgs = basicSetSamDerivator(newSamDerivator, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_DERIVATOR, newSamDerivator, newSamDerivator));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMStatusSchema getSamStatusSchema() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA) return null;
        return (SAMStatusSchema)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SAMStatusSchema basicGetSamStatusSchema() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA) return null;
        return (SAMStatusSchema)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSamStatusSchema(SAMStatusSchema newSamStatusSchema, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSamStatusSchema, Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSamStatusSchema(SAMStatusSchema newSamStatusSchema) {
        if (newSamStatusSchema != eInternalContainer() || (eContainerFeatureID() != Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA && newSamStatusSchema != null)) {
            if (EcoreUtil.isAncestor(this, newSamStatusSchema))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSamStatusSchema != null)
                msgs = ((InternalEObject)newSamStatusSchema).eInverseAdd(this, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_DERIVATORS, SAMStatusSchema.class, msgs);
            msgs = basicSetSamStatusSchema(newSamStatusSchema, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA, newSamStatusSchema, newSamStatusSchema));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaVariable> getSamSourceSchemaVariables() {
        if (samSourceSchemaVariables == null) {
            samSourceSchemaVariables = new EObjectWithInverseResolvingEList.ManyInverse<SAMSchemaVariable>(SAMSchemaVariable.class, this, Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_SOURCE_SCHEMA_VARIABLES, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_TARGET_SCHEMA_DERIVATORS);
        }
        return samSourceSchemaVariables;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaVariable> getSamTargetSchemaVariable() {
        if (samTargetSchemaVariable == null) {
            samTargetSchemaVariable = new EObjectWithInverseResolvingEList.ManyInverse<SAMSchemaVariable>(SAMSchemaVariable.class, this, Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_TARGET_SCHEMA_VARIABLE, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SOURCE_SCHEMA_DERIVATORS);
        }
        return samTargetSchemaVariable;
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
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_DERIVATOR:
                if (samDerivator != null)
                    msgs = ((InternalEObject)samDerivator).eInverseRemove(this, Status_and_action_oldPackage.SAM_DERIVATOR__SAM_SCHEMA_DERIVATORS, SAMDerivator.class, msgs);
                return basicSetSamDerivator((SAMDerivator)otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSamStatusSchema((SAMStatusSchema)otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_SOURCE_SCHEMA_VARIABLES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamSourceSchemaVariables()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_TARGET_SCHEMA_VARIABLE:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamTargetSchemaVariable()).basicAdd(otherEnd, msgs);
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
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_DERIVATOR:
                return basicSetSamDerivator(null, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA:
                return basicSetSamStatusSchema(null, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_SOURCE_SCHEMA_VARIABLES:
                return ((InternalEList<?>)getSamSourceSchemaVariables()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_TARGET_SCHEMA_VARIABLE:
                return ((InternalEList<?>)getSamTargetSchemaVariable()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA:
                return eInternalContainer().eInverseRemove(this, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_DERIVATORS, SAMStatusSchema.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_DERIVATOR:
                if (resolve) return getSamDerivator();
                return basicGetSamDerivator();
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA:
                if (resolve) return getSamStatusSchema();
                return basicGetSamStatusSchema();
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_SOURCE_SCHEMA_VARIABLES:
                return getSamSourceSchemaVariables();
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_TARGET_SCHEMA_VARIABLE:
                return getSamTargetSchemaVariable();
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
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_DERIVATOR:
                setSamDerivator((SAMDerivator)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA:
                setSamStatusSchema((SAMStatusSchema)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_SOURCE_SCHEMA_VARIABLES:
                getSamSourceSchemaVariables().clear();
                getSamSourceSchemaVariables().addAll((Collection<? extends SAMSchemaVariable>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_TARGET_SCHEMA_VARIABLE:
                getSamTargetSchemaVariable().clear();
                getSamTargetSchemaVariable().addAll((Collection<? extends SAMSchemaVariable>)newValue);
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
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_DERIVATOR:
                setSamDerivator((SAMDerivator)null);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA:
                setSamStatusSchema((SAMStatusSchema)null);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_SOURCE_SCHEMA_VARIABLES:
                getSamSourceSchemaVariables().clear();
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_TARGET_SCHEMA_VARIABLE:
                getSamTargetSchemaVariable().clear();
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
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_DERIVATOR:
                return samDerivator != null;
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA:
                return basicGetSamStatusSchema() != null;
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_SOURCE_SCHEMA_VARIABLES:
                return samSourceSchemaVariables != null && !samSourceSchemaVariables.isEmpty();
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_TARGET_SCHEMA_VARIABLE:
                return samTargetSchemaVariable != null && !samTargetSchemaVariable.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //SAMSchemaDerivatorImpl
