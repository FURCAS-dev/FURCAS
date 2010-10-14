/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.umlClassDiagram.impl;

import de.hpi.sam.umlClassDiagram.Attribute;
import de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.umlClassDiagram.impl.AttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hpi.sam.umlClassDiagram.impl.AttributeImpl#getAttributeOwner <em>Attribute Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends ElementImpl implements Attribute {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlClassDiagramPackage.Literals.ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlClassDiagramPackage.ATTRIBUTE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.hpi.sam.umlClassDiagram.Class getAttributeOwner() {
		if (eContainerFeatureID() != UmlClassDiagramPackage.ATTRIBUTE__ATTRIBUTE_OWNER) return null;
		return (de.hpi.sam.umlClassDiagram.Class)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttributeOwner(de.hpi.sam.umlClassDiagram.Class newAttributeOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAttributeOwner, UmlClassDiagramPackage.ATTRIBUTE__ATTRIBUTE_OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeOwner(de.hpi.sam.umlClassDiagram.Class newAttributeOwner) {
		if (newAttributeOwner != eInternalContainer() || (eContainerFeatureID() != UmlClassDiagramPackage.ATTRIBUTE__ATTRIBUTE_OWNER && newAttributeOwner != null)) {
			if (EcoreUtil.isAncestor(this, newAttributeOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAttributeOwner != null)
				msgs = ((InternalEObject)newAttributeOwner).eInverseAdd(this, UmlClassDiagramPackage.CLASS__ATTRIBUTE, de.hpi.sam.umlClassDiagram.Class.class, msgs);
			msgs = basicSetAttributeOwner(newAttributeOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlClassDiagramPackage.ATTRIBUTE__ATTRIBUTE_OWNER, newAttributeOwner, newAttributeOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmlClassDiagramPackage.ATTRIBUTE__ATTRIBUTE_OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAttributeOwner((de.hpi.sam.umlClassDiagram.Class)otherEnd, msgs);
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
			case UmlClassDiagramPackage.ATTRIBUTE__ATTRIBUTE_OWNER:
				return basicSetAttributeOwner(null, msgs);
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
			case UmlClassDiagramPackage.ATTRIBUTE__ATTRIBUTE_OWNER:
				return eInternalContainer().eInverseRemove(this, UmlClassDiagramPackage.CLASS__ATTRIBUTE, de.hpi.sam.umlClassDiagram.Class.class, msgs);
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
			case UmlClassDiagramPackage.ATTRIBUTE__NAME:
				return getName();
			case UmlClassDiagramPackage.ATTRIBUTE__ATTRIBUTE_OWNER:
				return getAttributeOwner();
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
			case UmlClassDiagramPackage.ATTRIBUTE__NAME:
				setName((String)newValue);
				return;
			case UmlClassDiagramPackage.ATTRIBUTE__ATTRIBUTE_OWNER:
				setAttributeOwner((de.hpi.sam.umlClassDiagram.Class)newValue);
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
			case UmlClassDiagramPackage.ATTRIBUTE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UmlClassDiagramPackage.ATTRIBUTE__ATTRIBUTE_OWNER:
				setAttributeOwner((de.hpi.sam.umlClassDiagram.Class)null);
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
			case UmlClassDiagramPackage.ATTRIBUTE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UmlClassDiagramPackage.ATTRIBUTE__ATTRIBUTE_OWNER:
				return getAttributeOwner() != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //AttributeImpl
