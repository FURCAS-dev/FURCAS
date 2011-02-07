/**
 * <copyright>
 * </copyright>
 *
 * $Id: ForeachImpl.java,v 1.1 2011/02/07 16:47:38 auhl Exp $
 */
package behavioral.actions.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.Foreach;
import behavioral.actions.Iterator;

import dataaccess.expressions.Expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foreach</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.actions.impl.ForeachImpl#isParallel <em>Parallel</em>}</li>
 *   <li>{@link behavioral.actions.impl.ForeachImpl#getCollection <em>Collection</em>}</li>
 *   <li>{@link behavioral.actions.impl.ForeachImpl#getForVariable <em>For Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForeachImpl extends SingleBlockStatementImpl implements Foreach {
	/**
     * The default value of the '{@link #isParallel() <em>Parallel</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isParallel()
     * @generated
     * @ordered
     */
	protected static final boolean PARALLEL_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isParallel() <em>Parallel</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isParallel()
     * @generated
     * @ordered
     */
	protected boolean parallel = PARALLEL_EDEFAULT;

	/**
     * The cached value of the '{@link #getCollection() <em>Collection</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCollection()
     * @generated
     * @ordered
     */
	protected Expression collection;

	/**
     * The cached value of the '{@link #getForVariable() <em>For Variable</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getForVariable()
     * @generated
     * @ordered
     */
	protected Iterator forVariable;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ForeachImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ActionsPackage.Literals.FOREACH;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isParallel() {
        return parallel;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setParallel(boolean newParallel) {
        boolean oldParallel = parallel;
        parallel = newParallel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.FOREACH__PARALLEL, oldParallel, parallel));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getCollection() {
        if (collection != null && collection.eIsProxy()) {
            InternalEObject oldCollection = (InternalEObject)collection;
            collection = (Expression)eResolveProxy(oldCollection);
            if (collection != oldCollection) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionsPackage.FOREACH__COLLECTION, oldCollection, collection));
            }
        }
        return collection;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression basicGetCollection() {
        return collection;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCollection(Expression newCollection) {
        Expression oldCollection = collection;
        collection = newCollection;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.FOREACH__COLLECTION, oldCollection, collection));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Iterator getForVariable() {
        if (forVariable != null && forVariable.eIsProxy()) {
            InternalEObject oldForVariable = (InternalEObject)forVariable;
            forVariable = (Iterator)eResolveProxy(oldForVariable);
            if (forVariable != oldForVariable) {
                InternalEObject newForVariable = (InternalEObject)forVariable;
                NotificationChain msgs =  oldForVariable.eInverseRemove(this, ActionsPackage.ITERATOR__BOUND_TO_FOR, Iterator.class, null);
                if (newForVariable.eInternalContainer() == null) {
                    msgs =  newForVariable.eInverseAdd(this, ActionsPackage.ITERATOR__BOUND_TO_FOR, Iterator.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionsPackage.FOREACH__FOR_VARIABLE, oldForVariable, forVariable));
            }
        }
        return forVariable;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Iterator basicGetForVariable() {
        return forVariable;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetForVariable(Iterator newForVariable, NotificationChain msgs) {
        Iterator oldForVariable = forVariable;
        forVariable = newForVariable;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionsPackage.FOREACH__FOR_VARIABLE, oldForVariable, newForVariable);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setForVariable(Iterator newForVariable) {
        if (newForVariable != forVariable) {
            NotificationChain msgs = null;
            if (forVariable != null)
                msgs = ((InternalEObject)forVariable).eInverseRemove(this, ActionsPackage.ITERATOR__BOUND_TO_FOR, Iterator.class, msgs);
            if (newForVariable != null)
                msgs = ((InternalEObject)newForVariable).eInverseAdd(this, ActionsPackage.ITERATOR__BOUND_TO_FOR, Iterator.class, msgs);
            msgs = basicSetForVariable(newForVariable, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.FOREACH__FOR_VARIABLE, newForVariable, newForVariable));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ActionsPackage.FOREACH__FOR_VARIABLE:
                if (forVariable != null)
                    msgs = ((InternalEObject)forVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionsPackage.FOREACH__FOR_VARIABLE, null, msgs);
                return basicSetForVariable((Iterator)otherEnd, msgs);
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
            case ActionsPackage.FOREACH__FOR_VARIABLE:
                return basicSetForVariable(null, msgs);
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
            case ActionsPackage.FOREACH__PARALLEL:
                return isParallel();
            case ActionsPackage.FOREACH__COLLECTION:
                if (resolve) return getCollection();
                return basicGetCollection();
            case ActionsPackage.FOREACH__FOR_VARIABLE:
                if (resolve) return getForVariable();
                return basicGetForVariable();
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
            case ActionsPackage.FOREACH__PARALLEL:
                setParallel((Boolean)newValue);
                return;
            case ActionsPackage.FOREACH__COLLECTION:
                setCollection((Expression)newValue);
                return;
            case ActionsPackage.FOREACH__FOR_VARIABLE:
                setForVariable((Iterator)newValue);
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
            case ActionsPackage.FOREACH__PARALLEL:
                setParallel(PARALLEL_EDEFAULT);
                return;
            case ActionsPackage.FOREACH__COLLECTION:
                setCollection((Expression)null);
                return;
            case ActionsPackage.FOREACH__FOR_VARIABLE:
                setForVariable((Iterator)null);
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
            case ActionsPackage.FOREACH__PARALLEL:
                return parallel != PARALLEL_EDEFAULT;
            case ActionsPackage.FOREACH__COLLECTION:
                return collection != null;
            case ActionsPackage.FOREACH__FOR_VARIABLE:
                return forVariable != null;
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
        result.append(" (parallel: ");
        result.append(parallel);
        result.append(')');
        return result.toString();
    }

} //ForeachImpl
