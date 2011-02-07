/**
 * <copyright>
 * </copyright>
 *
 * $Id: BusinessObjectImpl.java,v 1.1 2011/02/07 16:48:24 auhl Exp $
 */
package behavioral.status_and_action.design.impl;

import behavioral.status_and_action.design.BusinessObject;
import behavioral.status_and_action.design.BusinessObjectNode;
import behavioral.status_and_action.design.DesignPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action.design.impl.BusinessObjectImpl#getNodes <em>Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessObjectImpl extends EObjectImpl implements BusinessObject {
	/**
     * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNodes()
     * @generated
     * @ordered
     */
	protected EList<BusinessObjectNode> nodes;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected BusinessObjectImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return DesignPackage.Literals.BUSINESS_OBJECT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<BusinessObjectNode> getNodes() {
        if (nodes == null) {
            nodes = new EObjectContainmentEList.Resolving<BusinessObjectNode>(BusinessObjectNode.class, this, DesignPackage.BUSINESS_OBJECT__NODES);
        }
        return nodes;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case DesignPackage.BUSINESS_OBJECT__NODES:
                return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
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
            case DesignPackage.BUSINESS_OBJECT__NODES:
                return getNodes();
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
            case DesignPackage.BUSINESS_OBJECT__NODES:
                getNodes().clear();
                getNodes().addAll((Collection<? extends BusinessObjectNode>)newValue);
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
            case DesignPackage.BUSINESS_OBJECT__NODES:
                getNodes().clear();
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
            case DesignPackage.BUSINESS_OBJECT__NODES:
                return nodes != null && !nodes.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //BusinessObjectImpl
