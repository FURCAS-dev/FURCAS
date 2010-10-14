/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.petriNet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.petriNet.Node;
import de.hpi.sam.petriNet.PetriNetPackage;
import de.hpi.sam.petriNet.Place;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.petriNet.impl.PlaceImpl#getNoTokens <em>No Tokens</em>}</li>
 *   <li>{@link de.hpi.sam.petriNet.impl.PlaceImpl#getTestHiddenOpposite <em>Test Hidden Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlaceImpl extends NodeImpl implements Place {
	/**
     * The default value of the '{@link #getNoTokens() <em>No Tokens</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNoTokens()
     * @generated
     * @ordered
     */
	protected static final int NO_TOKENS_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getNoTokens() <em>No Tokens</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNoTokens()
     * @generated
     * @ordered
     */
	protected int noTokens = NO_TOKENS_EDEFAULT;

	/**
     * The cached value of the '{@link #getTestHiddenOpposite() <em>Test Hidden Opposite</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTestHiddenOpposite()
     * @generated
     * @ordered
     */
	protected Node testHiddenOpposite;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PlaceImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return PetriNetPackage.Literals.PLACE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getNoTokens() {
        return noTokens;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNoTokens(int newNoTokens) {
        int oldNoTokens = noTokens;
        noTokens = newNoTokens;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PetriNetPackage.PLACE__NO_TOKENS, oldNoTokens, noTokens));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Node getTestHiddenOpposite() {
        if (testHiddenOpposite != null && testHiddenOpposite.eIsProxy()) {
            InternalEObject oldTestHiddenOpposite = (InternalEObject)testHiddenOpposite;
            testHiddenOpposite = (Node)eResolveProxy(oldTestHiddenOpposite);
            if (testHiddenOpposite != oldTestHiddenOpposite) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PetriNetPackage.PLACE__TEST_HIDDEN_OPPOSITE, oldTestHiddenOpposite, testHiddenOpposite));
            }
        }
        return testHiddenOpposite;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Node basicGetTestHiddenOpposite() {
        return testHiddenOpposite;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTestHiddenOpposite(Node newTestHiddenOpposite) {
        Node oldTestHiddenOpposite = testHiddenOpposite;
        testHiddenOpposite = newTestHiddenOpposite;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PetriNetPackage.PLACE__TEST_HIDDEN_OPPOSITE, oldTestHiddenOpposite, testHiddenOpposite));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PetriNetPackage.PLACE__NO_TOKENS:
                return getNoTokens();
            case PetriNetPackage.PLACE__TEST_HIDDEN_OPPOSITE:
                if (resolve) return getTestHiddenOpposite();
                return basicGetTestHiddenOpposite();
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
            case PetriNetPackage.PLACE__NO_TOKENS:
                setNoTokens((Integer)newValue);
                return;
            case PetriNetPackage.PLACE__TEST_HIDDEN_OPPOSITE:
                setTestHiddenOpposite((Node)newValue);
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
            case PetriNetPackage.PLACE__NO_TOKENS:
                setNoTokens(NO_TOKENS_EDEFAULT);
                return;
            case PetriNetPackage.PLACE__TEST_HIDDEN_OPPOSITE:
                setTestHiddenOpposite((Node)null);
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
            case PetriNetPackage.PLACE__NO_TOKENS:
                return noTokens != NO_TOKENS_EDEFAULT;
            case PetriNetPackage.PLACE__TEST_HIDDEN_OPPOSITE:
                return testHiddenOpposite != null;
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
        result.append(" (noTokens: ");
        result.append(noTokens);
        result.append(')');
        return result.toString();
    }

} //PlaceImpl
