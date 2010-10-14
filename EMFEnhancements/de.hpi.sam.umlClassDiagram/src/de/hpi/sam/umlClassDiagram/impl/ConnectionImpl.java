/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.umlClassDiagram.impl;

import de.hpi.sam.umlClassDiagram.Connection;
import de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.umlClassDiagram.impl.ConnectionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link de.hpi.sam.umlClassDiagram.impl.ConnectionImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link de.hpi.sam.umlClassDiagram.impl.ConnectionImpl#getAnnotation <em>Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConnectionImpl extends ElementImpl implements Connection {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected de.hpi.sam.umlClassDiagram.Class source;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected de.hpi.sam.umlClassDiagram.Class destination;

	/**
	 * The cached value of the '{@link #getAnnotation() <em>Annotation</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotation()
	 * @generated
	 * @ordered
	 */
	protected EList<String> annotation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlClassDiagramPackage.Literals.CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.hpi.sam.umlClassDiagram.Class getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (de.hpi.sam.umlClassDiagram.Class)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlClassDiagramPackage.CONNECTION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.hpi.sam.umlClassDiagram.Class basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(de.hpi.sam.umlClassDiagram.Class newSource, NotificationChain msgs) {
		de.hpi.sam.umlClassDiagram.Class oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlClassDiagramPackage.CONNECTION__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(de.hpi.sam.umlClassDiagram.Class newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, UmlClassDiagramPackage.CLASS__OUTGOING_CONNECTIONS, de.hpi.sam.umlClassDiagram.Class.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, UmlClassDiagramPackage.CLASS__OUTGOING_CONNECTIONS, de.hpi.sam.umlClassDiagram.Class.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlClassDiagramPackage.CONNECTION__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.hpi.sam.umlClassDiagram.Class getDestination() {
		if (destination != null && destination.eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject)destination;
			destination = (de.hpi.sam.umlClassDiagram.Class)eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlClassDiagramPackage.CONNECTION__DESTINATION, oldDestination, destination));
			}
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.hpi.sam.umlClassDiagram.Class basicGetDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestination(de.hpi.sam.umlClassDiagram.Class newDestination, NotificationChain msgs) {
		de.hpi.sam.umlClassDiagram.Class oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlClassDiagramPackage.CONNECTION__DESTINATION, oldDestination, newDestination);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(de.hpi.sam.umlClassDiagram.Class newDestination) {
		if (newDestination != destination) {
			NotificationChain msgs = null;
			if (destination != null)
				msgs = ((InternalEObject)destination).eInverseRemove(this, UmlClassDiagramPackage.CLASS__INCOMING_CONNECTIONS, de.hpi.sam.umlClassDiagram.Class.class, msgs);
			if (newDestination != null)
				msgs = ((InternalEObject)newDestination).eInverseAdd(this, UmlClassDiagramPackage.CLASS__INCOMING_CONNECTIONS, de.hpi.sam.umlClassDiagram.Class.class, msgs);
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlClassDiagramPackage.CONNECTION__DESTINATION, newDestination, newDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAnnotation() {
		if (annotation == null) {
			annotation = new EDataTypeUniqueEList<String>(String.class, this, UmlClassDiagramPackage.CONNECTION__ANNOTATION);
		}
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmlClassDiagramPackage.CONNECTION__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, UmlClassDiagramPackage.CLASS__OUTGOING_CONNECTIONS, de.hpi.sam.umlClassDiagram.Class.class, msgs);
				return basicSetSource((de.hpi.sam.umlClassDiagram.Class)otherEnd, msgs);
			case UmlClassDiagramPackage.CONNECTION__DESTINATION:
				if (destination != null)
					msgs = ((InternalEObject)destination).eInverseRemove(this, UmlClassDiagramPackage.CLASS__INCOMING_CONNECTIONS, de.hpi.sam.umlClassDiagram.Class.class, msgs);
				return basicSetDestination((de.hpi.sam.umlClassDiagram.Class)otherEnd, msgs);
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
			case UmlClassDiagramPackage.CONNECTION__SOURCE:
				return basicSetSource(null, msgs);
			case UmlClassDiagramPackage.CONNECTION__DESTINATION:
				return basicSetDestination(null, msgs);
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
			case UmlClassDiagramPackage.CONNECTION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case UmlClassDiagramPackage.CONNECTION__DESTINATION:
				if (resolve) return getDestination();
				return basicGetDestination();
			case UmlClassDiagramPackage.CONNECTION__ANNOTATION:
				return getAnnotation();
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
			case UmlClassDiagramPackage.CONNECTION__SOURCE:
				setSource((de.hpi.sam.umlClassDiagram.Class)newValue);
				return;
			case UmlClassDiagramPackage.CONNECTION__DESTINATION:
				setDestination((de.hpi.sam.umlClassDiagram.Class)newValue);
				return;
			case UmlClassDiagramPackage.CONNECTION__ANNOTATION:
				getAnnotation().clear();
				getAnnotation().addAll((Collection<? extends String>)newValue);
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
			case UmlClassDiagramPackage.CONNECTION__SOURCE:
				setSource((de.hpi.sam.umlClassDiagram.Class)null);
				return;
			case UmlClassDiagramPackage.CONNECTION__DESTINATION:
				setDestination((de.hpi.sam.umlClassDiagram.Class)null);
				return;
			case UmlClassDiagramPackage.CONNECTION__ANNOTATION:
				getAnnotation().clear();
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
			case UmlClassDiagramPackage.CONNECTION__SOURCE:
				return source != null;
			case UmlClassDiagramPackage.CONNECTION__DESTINATION:
				return destination != null;
			case UmlClassDiagramPackage.CONNECTION__ANNOTATION:
				return annotation != null && !annotation.isEmpty();
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
		result.append(" (annotation: ");
		result.append(annotation);
		result.append(')');
		return result.toString();
	}

} //ConnectionImpl
