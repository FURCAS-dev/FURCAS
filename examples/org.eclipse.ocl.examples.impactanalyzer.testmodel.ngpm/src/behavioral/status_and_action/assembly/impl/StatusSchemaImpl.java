/**
 * <copyright>
 * </copyright>
 *
 * $Id: StatusSchemaImpl.java,v 1.1 2011/02/07 16:43:33 auhl Exp $
 */
package behavioral.status_and_action.assembly.impl;

import behavioral.status_and_action.assembly.AssemblyPackage;
import behavioral.status_and_action.assembly.SchemaElement;
import behavioral.status_and_action.assembly.StatusSchema;

import data.classes.ClassesPackage;
import data.classes.SapClass;

import java.util.Collection;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Status Schema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action.assembly.impl.StatusSchemaImpl#getNode <em>Node</em>}</li>
 *   <li>{@link behavioral.status_and_action.assembly.impl.StatusSchemaImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatusSchemaImpl extends NamedElementImpl implements StatusSchema {
	/**
     * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNode()
     * @generated
     * @ordered
     */
	protected SapClass node;

	/**
     * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getElements()
     * @generated
     * @ordered
     */
	protected EList<SchemaElement> elements;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected StatusSchemaImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return AssemblyPackage.Literals.STATUS_SCHEMA;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getNode() {
        if (node != null && node.eIsProxy()) {
            InternalEObject oldNode = (InternalEObject)node;
            node = (SapClass)eResolveProxy(oldNode);
            if (node != oldNode) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssemblyPackage.STATUS_SCHEMA__NODE, oldNode, node));
            }
        }
        return node;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass basicGetNode() {
        return node;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetNode(SapClass newNode, NotificationChain msgs) {
        SapClass oldNode = node;
        node = newNode;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssemblyPackage.STATUS_SCHEMA__NODE, oldNode, newNode);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNode(SapClass newNode) {
        if (newNode != node) {
            NotificationChain msgs = null;
            if (node != null)
                msgs = ((InternalEObject)node).eInverseRemove(this, ClassesPackage.SAP_CLASS__BEHAVIOURAL_MODEL, SapClass.class, msgs);
            if (newNode != null)
                msgs = ((InternalEObject)newNode).eInverseAdd(this, ClassesPackage.SAP_CLASS__BEHAVIOURAL_MODEL, SapClass.class, msgs);
            msgs = basicSetNode(newNode, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AssemblyPackage.STATUS_SCHEMA__NODE, newNode, newNode));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SchemaElement> getElements() {
        if (elements == null) {
            elements = new EObjectContainmentEList.Resolving<SchemaElement>(SchemaElement.class, this, AssemblyPackage.STATUS_SCHEMA__ELEMENTS);
        }
        return elements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case AssemblyPackage.STATUS_SCHEMA__NODE:
                if (node != null)
                    msgs = ((InternalEObject)node).eInverseRemove(this, ClassesPackage.SAP_CLASS__BEHAVIOURAL_MODEL, SapClass.class, msgs);
                return basicSetNode((SapClass)otherEnd, msgs);
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
            case AssemblyPackage.STATUS_SCHEMA__NODE:
                return basicSetNode(null, msgs);
            case AssemblyPackage.STATUS_SCHEMA__ELEMENTS:
                return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
            case AssemblyPackage.STATUS_SCHEMA__NODE:
                if (resolve) return getNode();
                return basicGetNode();
            case AssemblyPackage.STATUS_SCHEMA__ELEMENTS:
                return getElements();
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
            case AssemblyPackage.STATUS_SCHEMA__NODE:
                setNode((SapClass)newValue);
                return;
            case AssemblyPackage.STATUS_SCHEMA__ELEMENTS:
                getElements().clear();
                getElements().addAll((Collection<? extends SchemaElement>)newValue);
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
            case AssemblyPackage.STATUS_SCHEMA__NODE:
                setNode((SapClass)null);
                return;
            case AssemblyPackage.STATUS_SCHEMA__ELEMENTS:
                getElements().clear();
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
            case AssemblyPackage.STATUS_SCHEMA__NODE:
                return node != null;
            case AssemblyPackage.STATUS_SCHEMA__ELEMENTS:
                return elements != null && !elements.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //StatusSchemaImpl
