/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd.impl;

import integration.xsd.AbstractContent;
import integration.xsd.Attribute;
import integration.xsd.ComplexType;
import integration.xsd.XsdPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.xsd.impl.ComplexTypeImpl#getAtts <em>Atts</em>}</li>
 *   <li>{@link integration.xsd.impl.ComplexTypeImpl#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComplexTypeImpl extends AbstractTypeImpl implements ComplexType {
	/**
     * The cached value of the '{@link #getAtts() <em>Atts</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAtts()
     * @generated
     * @ordered
     */
	protected EList<Attribute> atts;

	/**
     * The cached value of the '{@link #getContent() <em>Content</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getContent()
     * @generated
     * @ordered
     */
	protected AbstractContent content;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ComplexTypeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return XsdPackage.Literals.COMPLEX_TYPE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Attribute> getAtts() {
        if (atts == null) {
            atts = new EObjectResolvingEList<Attribute>(Attribute.class, this, XsdPackage.COMPLEX_TYPE__ATTS);
        }
        return atts;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbstractContent getContent() {
        if (content != null && content.eIsProxy()) {
            InternalEObject oldContent = (InternalEObject)content;
            content = (AbstractContent)eResolveProxy(oldContent);
            if (content != oldContent) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, XsdPackage.COMPLEX_TYPE__CONTENT, oldContent, content));
            }
        }
        return content;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbstractContent basicGetContent() {
        return content;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setContent(AbstractContent newContent) {
        AbstractContent oldContent = content;
        content = newContent;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XsdPackage.COMPLEX_TYPE__CONTENT, oldContent, content));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case XsdPackage.COMPLEX_TYPE__ATTS:
                return getAtts();
            case XsdPackage.COMPLEX_TYPE__CONTENT:
                if (resolve) return getContent();
                return basicGetContent();
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
            case XsdPackage.COMPLEX_TYPE__ATTS:
                getAtts().clear();
                getAtts().addAll((Collection<? extends Attribute>)newValue);
                return;
            case XsdPackage.COMPLEX_TYPE__CONTENT:
                setContent((AbstractContent)newValue);
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
            case XsdPackage.COMPLEX_TYPE__ATTS:
                getAtts().clear();
                return;
            case XsdPackage.COMPLEX_TYPE__CONTENT:
                setContent((AbstractContent)null);
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
            case XsdPackage.COMPLEX_TYPE__ATTS:
                return atts != null && !atts.isEmpty();
            case XsdPackage.COMPLEX_TYPE__CONTENT:
                return content != null;
        }
        return super.eIsSet(featureID);
    }

} //ComplexTypeImpl
