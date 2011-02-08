/**
 * <copyright>
 * </copyright>
 *
 * $Id: LinkManipulationStatementImpl.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.actions.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.LinkManipulationStatement;

import data.classes.Association;

import dataaccess.expressions.Expression;

import java.util.Collection;

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
 * An implementation of the model object '<em><b>Link Manipulation Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.actions.impl.LinkManipulationStatementImpl#getAt <em>At</em>}</li>
 *   <li>{@link behavioral.actions.impl.LinkManipulationStatementImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link behavioral.actions.impl.LinkManipulationStatementImpl#getObjects <em>Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LinkManipulationStatementImpl extends StatementImpl implements LinkManipulationStatement {
	/**
     * The default value of the '{@link #getAt() <em>At</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAt()
     * @generated
     * @ordered
     */
	protected static final int AT_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getAt() <em>At</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAt()
     * @generated
     * @ordered
     */
	protected int at = AT_EDEFAULT;

	/**
     * The cached value of the '{@link #getAssociation() <em>Association</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAssociation()
     * @generated
     * @ordered
     */
	protected Association association;

	/**
     * The cached value of the '{@link #getObjects() <em>Objects</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getObjects()
     * @generated
     * @ordered
     */
	protected EList<Expression> objects;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected LinkManipulationStatementImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ActionsPackage.Literals.LINK_MANIPULATION_STATEMENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getAt() {
        return at;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAt(int newAt) {
        int oldAt = at;
        at = newAt;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.LINK_MANIPULATION_STATEMENT__AT, oldAt, at));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Association getAssociation() {
        if (association != null && association.eIsProxy()) {
            InternalEObject oldAssociation = (InternalEObject)association;
            association = (Association)eResolveProxy(oldAssociation);
            if (association != oldAssociation) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionsPackage.LINK_MANIPULATION_STATEMENT__ASSOCIATION, oldAssociation, association));
            }
        }
        return association;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Association basicGetAssociation() {
        return association;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAssociation(Association newAssociation) {
        Association oldAssociation = association;
        association = newAssociation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.LINK_MANIPULATION_STATEMENT__ASSOCIATION, oldAssociation, association));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Expression> getObjects() {
        if (objects == null) {
            objects = new EObjectContainmentEList.Resolving<Expression>(Expression.class, this, ActionsPackage.LINK_MANIPULATION_STATEMENT__OBJECTS);
        }
        return objects;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ActionsPackage.LINK_MANIPULATION_STATEMENT__OBJECTS:
                return ((InternalEList<?>)getObjects()).basicRemove(otherEnd, msgs);
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
            case ActionsPackage.LINK_MANIPULATION_STATEMENT__AT:
                return getAt();
            case ActionsPackage.LINK_MANIPULATION_STATEMENT__ASSOCIATION:
                if (resolve) return getAssociation();
                return basicGetAssociation();
            case ActionsPackage.LINK_MANIPULATION_STATEMENT__OBJECTS:
                return getObjects();
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
            case ActionsPackage.LINK_MANIPULATION_STATEMENT__AT:
                setAt((Integer)newValue);
                return;
            case ActionsPackage.LINK_MANIPULATION_STATEMENT__ASSOCIATION:
                setAssociation((Association)newValue);
                return;
            case ActionsPackage.LINK_MANIPULATION_STATEMENT__OBJECTS:
                getObjects().clear();
                getObjects().addAll((Collection<? extends Expression>)newValue);
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
            case ActionsPackage.LINK_MANIPULATION_STATEMENT__AT:
                setAt(AT_EDEFAULT);
                return;
            case ActionsPackage.LINK_MANIPULATION_STATEMENT__ASSOCIATION:
                setAssociation((Association)null);
                return;
            case ActionsPackage.LINK_MANIPULATION_STATEMENT__OBJECTS:
                getObjects().clear();
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
            case ActionsPackage.LINK_MANIPULATION_STATEMENT__AT:
                return at != AT_EDEFAULT;
            case ActionsPackage.LINK_MANIPULATION_STATEMENT__ASSOCIATION:
                return association != null;
            case ActionsPackage.LINK_MANIPULATION_STATEMENT__OBJECTS:
                return objects != null && !objects.isEmpty();
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
        result.append(" (at: ");
        result.append(at);
        result.append(')');
        return result.toString();
    }

} //LinkManipulationStatementImpl
