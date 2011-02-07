/**
 * <copyright>
 * </copyright>
 *
 * $Id: ComplexContentImpl.java,v 1.1 2011/02/07 17:21:36 auhl Exp $
 */
package integration.xsd.impl;

import integration.xsd.ComplexContent;
import integration.xsd.Containable;
import integration.xsd.XsdPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.xsd.impl.ComplexContentImpl#isMixed <em>Mixed</em>}</li>
 *   <li>{@link integration.xsd.impl.ComplexContentImpl#getContentModel <em>Content Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComplexContentImpl extends AbstractContentImpl implements ComplexContent {
	/**
     * The default value of the '{@link #isMixed() <em>Mixed</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isMixed()
     * @generated
     * @ordered
     */
	protected static final boolean MIXED_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isMixed() <em>Mixed</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isMixed()
     * @generated
     * @ordered
     */
	protected boolean mixed = MIXED_EDEFAULT;

	/**
     * The cached value of the '{@link #getContentModel() <em>Content Model</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getContentModel()
     * @generated
     * @ordered
     */
	protected Containable contentModel;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ComplexContentImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return XsdPackage.Literals.COMPLEX_CONTENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isMixed() {
        return mixed;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMixed(boolean newMixed) {
        boolean oldMixed = mixed;
        mixed = newMixed;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.COMPLEX_CONTENT__MIXED, oldMixed, mixed));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Containable getContentModel() {
        if (contentModel != null && contentModel.eIsProxy()) {
            InternalEObject oldContentModel = (InternalEObject)contentModel;
            contentModel = (Containable)eResolveProxy(oldContentModel);
            if (contentModel != oldContentModel) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, XsdPackage.COMPLEX_CONTENT__CONTENT_MODEL, oldContentModel, contentModel));
            }
        }
        return contentModel;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Containable basicGetContentModel() {
        return contentModel;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setContentModel(Containable newContentModel) {
        Containable oldContentModel = contentModel;
        contentModel = newContentModel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.COMPLEX_CONTENT__CONTENT_MODEL, oldContentModel, contentModel));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case XsdPackage.COMPLEX_CONTENT__MIXED:
                return isMixed();
            case XsdPackage.COMPLEX_CONTENT__CONTENT_MODEL:
                if (resolve) return getContentModel();
                return basicGetContentModel();
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
            case XsdPackage.COMPLEX_CONTENT__MIXED:
                setMixed((Boolean)newValue);
                return;
            case XsdPackage.COMPLEX_CONTENT__CONTENT_MODEL:
                setContentModel((Containable)newValue);
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
            case XsdPackage.COMPLEX_CONTENT__MIXED:
                setMixed(MIXED_EDEFAULT);
                return;
            case XsdPackage.COMPLEX_CONTENT__CONTENT_MODEL:
                setContentModel((Containable)null);
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
            case XsdPackage.COMPLEX_CONTENT__MIXED:
                return mixed != MIXED_EDEFAULT;
            case XsdPackage.COMPLEX_CONTENT__CONTENT_MODEL:
                return contentModel != null;
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
        result.append(" (mixed: ");
        result.append(mixed);
        result.append(')');
        return result.toString();
    }

} //ComplexContentImpl
