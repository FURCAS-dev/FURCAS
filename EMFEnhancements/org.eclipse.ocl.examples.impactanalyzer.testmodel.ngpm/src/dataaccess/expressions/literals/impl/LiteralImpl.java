/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.literals.impl;

import dataaccess.expressions.impl.ExpressionImpl;

import dataaccess.expressions.literals.Literal;
import dataaccess.expressions.literals.LiteralsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.literals.impl.LiteralImpl#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LiteralImpl extends ExpressionImpl implements Literal {
	/**
     * The default value of the '{@link #getLiteral() <em>Literal</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLiteral()
     * @generated
     * @ordered
     */
	protected static final String LITERAL_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getLiteral() <em>Literal</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLiteral()
     * @generated
     * @ordered
     */
	protected String literal = LITERAL_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected LiteralImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return LiteralsPackage.Literals.LITERAL;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getLiteral() {
        return literal;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLiteral(String newLiteral) {
        String oldLiteral = literal;
        literal = newLiteral;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, LiteralsPackage.LITERAL__LITERAL, oldLiteral, literal));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case LiteralsPackage.LITERAL__LITERAL:
                return getLiteral();
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
            case LiteralsPackage.LITERAL__LITERAL:
                setLiteral((String)newValue);
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
            case LiteralsPackage.LITERAL__LITERAL:
                setLiteral(LITERAL_EDEFAULT);
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
            case LiteralsPackage.LITERAL__LITERAL:
                return LITERAL_EDEFAULT == null ? literal != null : !LITERAL_EDEFAULT.equals(literal);
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
        result.append(" (literal: ");
        result.append(literal);
        result.append(')');
        return result.toString();
    }

} //LiteralImpl
