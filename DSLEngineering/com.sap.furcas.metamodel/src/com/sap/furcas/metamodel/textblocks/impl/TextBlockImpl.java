/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.textblocks.impl;

import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.ForEachContext;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getSubNodes <em>Sub Nodes</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getParentAltChoices <em>Parent Alt Choices</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getElementsInContext <em>Elements In Context</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getForEachContext <em>For Each Context</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#is___Alive <em>Alive</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getCachedString <em>Cached String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TextBlockImpl extends DocumentNodeImpl implements TextBlock {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TextblockDefinition type;

	/**
	 * The cached value of the '{@link #getSubNodes() <em>Sub Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TextBlock> subNodes;

	/**
	 * The cached value of the '{@link #getParentAltChoices() <em>Parent Alt Choices</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentAltChoices()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> parentAltChoices;

	/**
	 * The cached value of the '{@link #getElementsInContext() <em>Elements In Context</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementsInContext()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> elementsInContext;

	/**
	 * The cached value of the '{@link #getForEachContext() <em>For Each Context</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForEachContext()
	 * @generated
	 * @ordered
	 */
	protected EList<ForEachContext> forEachContext;

	/**
	 * The default value of the '{@link #is___Alive() <em>Alive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #is___Alive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean _ALIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #is___Alive() <em>Alive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #is___Alive()
	 * @generated
	 * @ordered
	 */
	protected boolean ___Alive = _ALIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCachedString() <em>Cached String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCachedString()
	 * @generated
	 * @ordered
	 */
	protected static final String CACHED_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCachedString() <em>Cached String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCachedString()
	 * @generated
	 * @ordered
	 */
	protected String cachedString = CACHED_STRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TextblocksPackage.Literals.TEXT_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractToken> getTokens() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Template> getAdditionalTemplates() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TextBlock> getSubNodes() {
		if (subNodes == null) {
			subNodes = new EObjectResolvingEList<TextBlock>(TextBlock.class, this, TextblocksPackage.TEXT_BLOCK__SUB_NODES);
		}
		return subNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextblockDefinition getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (TextblockDefinition)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TextblocksPackage.TEXT_BLOCK__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextblockDefinition basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TextblockDefinition newType) {
		TextblockDefinition oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.TEXT_BLOCK__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TextBlock> getSubBlocks() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getParentAltChoices() {
		if (parentAltChoices == null) {
			parentAltChoices = new EDataTypeUniqueEList<Integer>(Integer.class, this, TextblocksPackage.TEXT_BLOCK__PARENT_ALT_CHOICES);
		}
		return parentAltChoices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getElementsInContext() {
		if (elementsInContext == null) {
			elementsInContext = new EObjectResolvingEList<EObject>(EObject.class, this, TextblocksPackage.TEXT_BLOCK__ELEMENTS_IN_CONTEXT);
		}
		return elementsInContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ForEachContext> getForEachContext() {
		if (forEachContext == null) {
			forEachContext = new EObjectContainmentEList<ForEachContext>(ForEachContext.class, this, TextblocksPackage.TEXT_BLOCK__FOR_EACH_CONTEXT);
		}
		return forEachContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean is___Alive() {
		return ___Alive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void set___Alive(boolean new___Alive) {
		boolean old___Alive = ___Alive;
		___Alive = new___Alive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.TEXT_BLOCK__ALIVE, old___Alive, ___Alive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCachedString() {
		return cachedString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCachedString(String newCachedString) {
		String oldCachedString = cachedString;
		cachedString = newCachedString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.TEXT_BLOCK__CACHED_STRING, oldCachedString, cachedString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TextblocksPackage.TEXT_BLOCK__FOR_EACH_CONTEXT:
				return ((InternalEList<?>)getForEachContext()).basicRemove(otherEnd, msgs);
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
			case TextblocksPackage.TEXT_BLOCK__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case TextblocksPackage.TEXT_BLOCK__SUB_NODES:
				return getSubNodes();
			case TextblocksPackage.TEXT_BLOCK__PARENT_ALT_CHOICES:
				return getParentAltChoices();
			case TextblocksPackage.TEXT_BLOCK__ELEMENTS_IN_CONTEXT:
				return getElementsInContext();
			case TextblocksPackage.TEXT_BLOCK__FOR_EACH_CONTEXT:
				return getForEachContext();
			case TextblocksPackage.TEXT_BLOCK__ALIVE:
				return is___Alive();
			case TextblocksPackage.TEXT_BLOCK__CACHED_STRING:
				return getCachedString();
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
			case TextblocksPackage.TEXT_BLOCK__TYPE:
				setType((TextblockDefinition)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__SUB_NODES:
				getSubNodes().clear();
				getSubNodes().addAll((Collection<? extends TextBlock>)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__PARENT_ALT_CHOICES:
				getParentAltChoices().clear();
				getParentAltChoices().addAll((Collection<? extends Integer>)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__ELEMENTS_IN_CONTEXT:
				getElementsInContext().clear();
				getElementsInContext().addAll((Collection<? extends EObject>)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__FOR_EACH_CONTEXT:
				getForEachContext().clear();
				getForEachContext().addAll((Collection<? extends ForEachContext>)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__ALIVE:
				set___Alive((Boolean)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__CACHED_STRING:
				setCachedString((String)newValue);
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
			case TextblocksPackage.TEXT_BLOCK__TYPE:
				setType((TextblockDefinition)null);
				return;
			case TextblocksPackage.TEXT_BLOCK__SUB_NODES:
				getSubNodes().clear();
				return;
			case TextblocksPackage.TEXT_BLOCK__PARENT_ALT_CHOICES:
				getParentAltChoices().clear();
				return;
			case TextblocksPackage.TEXT_BLOCK__ELEMENTS_IN_CONTEXT:
				getElementsInContext().clear();
				return;
			case TextblocksPackage.TEXT_BLOCK__FOR_EACH_CONTEXT:
				getForEachContext().clear();
				return;
			case TextblocksPackage.TEXT_BLOCK__ALIVE:
				set___Alive(_ALIVE_EDEFAULT);
				return;
			case TextblocksPackage.TEXT_BLOCK__CACHED_STRING:
				setCachedString(CACHED_STRING_EDEFAULT);
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
			case TextblocksPackage.TEXT_BLOCK__TYPE:
				return type != null;
			case TextblocksPackage.TEXT_BLOCK__SUB_NODES:
				return subNodes != null && !subNodes.isEmpty();
			case TextblocksPackage.TEXT_BLOCK__PARENT_ALT_CHOICES:
				return parentAltChoices != null && !parentAltChoices.isEmpty();
			case TextblocksPackage.TEXT_BLOCK__ELEMENTS_IN_CONTEXT:
				return elementsInContext != null && !elementsInContext.isEmpty();
			case TextblocksPackage.TEXT_BLOCK__FOR_EACH_CONTEXT:
				return forEachContext != null && !forEachContext.isEmpty();
			case TextblocksPackage.TEXT_BLOCK__ALIVE:
				return ___Alive != _ALIVE_EDEFAULT;
			case TextblocksPackage.TEXT_BLOCK__CACHED_STRING:
				return CACHED_STRING_EDEFAULT == null ? cachedString != null : !CACHED_STRING_EDEFAULT.equals(cachedString);
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
		result.append(" (parentAltChoices: ");
		result.append(parentAltChoices);
		result.append(", ___Alive: ");
		result.append(___Alive);
		result.append(", cachedString: ");
		result.append(cachedString);
		result.append(')');
		return result.toString();
	}

} //TextBlockImpl
