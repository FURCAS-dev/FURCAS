/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.textblocks.impl;

import com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
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
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getStartRow <em>Start Row</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getStartColumn <em>Start Column</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getEndRow <em>End Row</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getEndColumn <em>End Column</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getTokens <em>Tokens</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getSubNodes <em>Sub Nodes</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getSubBlocks <em>Sub Blocks</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getParentAltChoices <em>Parent Alt Choices</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.impl.TextBlockImpl#getElementsInContext <em>Elements In Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TextBlockImpl extends DocumentNodeImpl implements TextBlock {
	/**
	 * The default value of the '{@link #getStartRow() <em>Start Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartRow()
	 * @generated
	 * @ordered
	 */
	protected static final int START_ROW_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartRow() <em>Start Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartRow()
	 * @generated
	 * @ordered
	 */
	protected int startRow = START_ROW_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartColumn() <em>Start Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartColumn()
	 * @generated
	 * @ordered
	 */
	protected static final int START_COLUMN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartColumn() <em>Start Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartColumn()
	 * @generated
	 * @ordered
	 */
	protected int startColumn = START_COLUMN_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndRow() <em>End Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndRow()
	 * @generated
	 * @ordered
	 */
	protected static final int END_ROW_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndRow() <em>End Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndRow()
	 * @generated
	 * @ordered
	 */
	protected int endRow = END_ROW_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndColumn() <em>End Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndColumn()
	 * @generated
	 * @ordered
	 */
	protected static final int END_COLUMN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndColumn() <em>End Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndColumn()
	 * @generated
	 * @ordered
	 */
	protected int endColumn = END_COLUMN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubNodes() <em>Sub Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<DocumentNode> subNodes;

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
	 * The cached value of the '{@link #getSubBlocks() <em>Sub Blocks</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<TextBlock> subBlocks;

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
	public int getStartRow() {
		return startRow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartRow(int newStartRow) {
		int oldStartRow = startRow;
		startRow = newStartRow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.TEXT_BLOCK__START_ROW, oldStartRow, startRow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartColumn() {
		return startColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartColumn(int newStartColumn) {
		int oldStartColumn = startColumn;
		startColumn = newStartColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.TEXT_BLOCK__START_COLUMN, oldStartColumn, startColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndRow() {
		return endRow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndRow(int newEndRow) {
		int oldEndRow = endRow;
		endRow = newEndRow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.TEXT_BLOCK__END_ROW, oldEndRow, endRow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndColumn() {
		return endColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndColumn(int newEndColumn) {
		int oldEndColumn = endColumn;
		endColumn = newEndColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.TEXT_BLOCK__END_COLUMN, oldEndColumn, endColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractToken> getTokens() {
		// TODO: implement this method to return the 'Tokens' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DocumentNode> getSubNodes() {
		if (subNodes == null) {
			subNodes = new EObjectContainmentWithInverseEList<DocumentNode>(DocumentNode.class, this, TextblocksPackage.TEXT_BLOCK__SUB_NODES, TextblocksPackage.DOCUMENT_NODE__PARENT);
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
		if (subBlocks == null) {
			subBlocks = new EObjectResolvingEList<TextBlock>(TextBlock.class, this, TextblocksPackage.TEXT_BLOCK__SUB_BLOCKS);
		}
		return subBlocks;
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TextblocksPackage.TEXT_BLOCK__SUB_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubNodes()).basicAdd(otherEnd, msgs);
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
			case TextblocksPackage.TEXT_BLOCK__SUB_NODES:
				return ((InternalEList<?>)getSubNodes()).basicRemove(otherEnd, msgs);
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
			case TextblocksPackage.TEXT_BLOCK__START_ROW:
				return getStartRow();
			case TextblocksPackage.TEXT_BLOCK__START_COLUMN:
				return getStartColumn();
			case TextblocksPackage.TEXT_BLOCK__END_ROW:
				return getEndRow();
			case TextblocksPackage.TEXT_BLOCK__END_COLUMN:
				return getEndColumn();
			case TextblocksPackage.TEXT_BLOCK__TOKENS:
				return getTokens();
			case TextblocksPackage.TEXT_BLOCK__SUB_NODES:
				return getSubNodes();
			case TextblocksPackage.TEXT_BLOCK__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case TextblocksPackage.TEXT_BLOCK__SUB_BLOCKS:
				return getSubBlocks();
			case TextblocksPackage.TEXT_BLOCK__PARENT_ALT_CHOICES:
				return getParentAltChoices();
			case TextblocksPackage.TEXT_BLOCK__ELEMENTS_IN_CONTEXT:
				return getElementsInContext();
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
			case TextblocksPackage.TEXT_BLOCK__START_ROW:
				setStartRow((Integer)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__START_COLUMN:
				setStartColumn((Integer)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__END_ROW:
				setEndRow((Integer)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__END_COLUMN:
				setEndColumn((Integer)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__TOKENS:
				getTokens().clear();
				getTokens().addAll((Collection<? extends AbstractToken>)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__SUB_NODES:
				getSubNodes().clear();
				getSubNodes().addAll((Collection<? extends DocumentNode>)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__TYPE:
				setType((TextblockDefinition)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__SUB_BLOCKS:
				getSubBlocks().clear();
				getSubBlocks().addAll((Collection<? extends TextBlock>)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__PARENT_ALT_CHOICES:
				getParentAltChoices().clear();
				getParentAltChoices().addAll((Collection<? extends Integer>)newValue);
				return;
			case TextblocksPackage.TEXT_BLOCK__ELEMENTS_IN_CONTEXT:
				getElementsInContext().clear();
				getElementsInContext().addAll((Collection<? extends EObject>)newValue);
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
			case TextblocksPackage.TEXT_BLOCK__START_ROW:
				setStartRow(START_ROW_EDEFAULT);
				return;
			case TextblocksPackage.TEXT_BLOCK__START_COLUMN:
				setStartColumn(START_COLUMN_EDEFAULT);
				return;
			case TextblocksPackage.TEXT_BLOCK__END_ROW:
				setEndRow(END_ROW_EDEFAULT);
				return;
			case TextblocksPackage.TEXT_BLOCK__END_COLUMN:
				setEndColumn(END_COLUMN_EDEFAULT);
				return;
			case TextblocksPackage.TEXT_BLOCK__TOKENS:
				getTokens().clear();
				return;
			case TextblocksPackage.TEXT_BLOCK__SUB_NODES:
				getSubNodes().clear();
				return;
			case TextblocksPackage.TEXT_BLOCK__TYPE:
				setType((TextblockDefinition)null);
				return;
			case TextblocksPackage.TEXT_BLOCK__SUB_BLOCKS:
				getSubBlocks().clear();
				return;
			case TextblocksPackage.TEXT_BLOCK__PARENT_ALT_CHOICES:
				getParentAltChoices().clear();
				return;
			case TextblocksPackage.TEXT_BLOCK__ELEMENTS_IN_CONTEXT:
				getElementsInContext().clear();
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
			case TextblocksPackage.TEXT_BLOCK__START_ROW:
				return startRow != START_ROW_EDEFAULT;
			case TextblocksPackage.TEXT_BLOCK__START_COLUMN:
				return startColumn != START_COLUMN_EDEFAULT;
			case TextblocksPackage.TEXT_BLOCK__END_ROW:
				return endRow != END_ROW_EDEFAULT;
			case TextblocksPackage.TEXT_BLOCK__END_COLUMN:
				return endColumn != END_COLUMN_EDEFAULT;
			case TextblocksPackage.TEXT_BLOCK__TOKENS:
				return !getTokens().isEmpty();
			case TextblocksPackage.TEXT_BLOCK__SUB_NODES:
				return subNodes != null && !subNodes.isEmpty();
			case TextblocksPackage.TEXT_BLOCK__TYPE:
				return type != null;
			case TextblocksPackage.TEXT_BLOCK__SUB_BLOCKS:
				return subBlocks != null && !subBlocks.isEmpty();
			case TextblocksPackage.TEXT_BLOCK__PARENT_ALT_CHOICES:
				return parentAltChoices != null && !parentAltChoices.isEmpty();
			case TextblocksPackage.TEXT_BLOCK__ELEMENTS_IN_CONTEXT:
				return elementsInContext != null && !elementsInContext.isEmpty();
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
		result.append(" (startRow: ");
		result.append(startRow);
		result.append(", startColumn: ");
		result.append(startColumn);
		result.append(", endRow: ");
		result.append(endRow);
		result.append(", endColumn: ");
		result.append(endColumn);
		result.append(", parentAltChoices: ");
		result.append(parentAltChoices);
		result.append(')');
		return result.toString();
	}

} //TextBlockImpl
