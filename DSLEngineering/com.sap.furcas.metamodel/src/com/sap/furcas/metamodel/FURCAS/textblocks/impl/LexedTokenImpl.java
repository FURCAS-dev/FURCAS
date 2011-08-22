/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lexed Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.LexedTokenImpl#isOperator <em>Operator</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.LexedTokenImpl#getReferencedElements <em>Referenced Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LexedTokenImpl extends AbstractTokenImpl implements LexedToken {
    /**
     * The default value of the '{@link #isOperator() <em>Operator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isOperator()
     * @generated
     * @ordered
     */
    protected static final boolean OPERATOR_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isOperator() <em>Operator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isOperator()
     * @generated
     * @ordered
     */
    protected boolean operator = OPERATOR_EDEFAULT;

    /**
     * The cached value of the '{@link #getReferencedElements() <em>Referenced Elements</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReferencedElements()
     * @generated
     * @ordered
     */
    protected EList<EObject> referencedElements;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LexedTokenImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TextblocksPackage.Literals.LEXED_TOKEN;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isOperator() {
        return operator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setOperator(boolean newOperator) {
        boolean oldOperator = operator;
        operator = newOperator;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.LEXED_TOKEN__OPERATOR, oldOperator, operator));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<EObject> getReferencedElements() {
        if (referencedElements == null) {
            referencedElements = new EObjectResolvingEList<EObject>(EObject.class, this,
                    TextblocksPackage.LEXED_TOKEN__REFERENCED_ELEMENTS);
        }
        return referencedElements;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case TextblocksPackage.LEXED_TOKEN__OPERATOR:
            return isOperator();
        case TextblocksPackage.LEXED_TOKEN__REFERENCED_ELEMENTS:
            return getReferencedElements();
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
        case TextblocksPackage.LEXED_TOKEN__OPERATOR:
            setOperator((Boolean) newValue);
            return;
        case TextblocksPackage.LEXED_TOKEN__REFERENCED_ELEMENTS:
            getReferencedElements().clear();
            getReferencedElements().addAll((Collection<? extends EObject>) newValue);
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
        case TextblocksPackage.LEXED_TOKEN__OPERATOR:
            setOperator(OPERATOR_EDEFAULT);
            return;
        case TextblocksPackage.LEXED_TOKEN__REFERENCED_ELEMENTS:
            getReferencedElements().clear();
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
        case TextblocksPackage.LEXED_TOKEN__OPERATOR:
            return operator != OPERATOR_EDEFAULT;
        case TextblocksPackage.LEXED_TOKEN__REFERENCED_ELEMENTS:
            return referencedElements != null && !referencedElements.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * @generated NOT
     */
    @Override
    public String toString() {
        return super.toString();
    }

} //LexedTokenImpl
