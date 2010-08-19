/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.Block;
import behavioral.actions.ConditionalStatement;
import behavioral.actions.Statement;

import data.classes.ClassesPackage;
import data.classes.InScope;
import data.classes.NamedValue;
import data.classes.SapClass;

import dataaccess.expressions.impl.ConditionalImpl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.actions.impl.ConditionalStatementImpl#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConditionalStatementImpl extends ConditionalImpl implements ConditionalStatement {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ConditionalStatementImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ActionsPackage.Literals.CONDITIONAL_STATEMENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Block getBlock() {
        if (eContainerFeatureID() != ActionsPackage.CONDITIONAL_STATEMENT__BLOCK) return null;
        return (Block)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Block basicGetBlock() {
        if (eContainerFeatureID() != ActionsPackage.CONDITIONAL_STATEMENT__BLOCK) return null;
        return (Block)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetBlock(Block newBlock, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newBlock, ActionsPackage.CONDITIONAL_STATEMENT__BLOCK, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBlock(Block newBlock) {
        if (newBlock != eInternalContainer() || (eContainerFeatureID() != ActionsPackage.CONDITIONAL_STATEMENT__BLOCK && newBlock != null)) {
            if (EcoreUtil.isAncestor(this, newBlock))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newBlock != null)
                msgs = ((InternalEObject)newBlock).eInverseAdd(this, ActionsPackage.BLOCK__STATEMENTS, Block.class, msgs);
            msgs = basicSetBlock(newBlock, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.CONDITIONAL_STATEMENT__BLOCK, newBlock, newBlock));
    }

	/**
     * The cached invocation delegate for the '{@link #getOutermostBlock() <em>Get Outermost Block</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOutermostBlock()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_OUTERMOST_BLOCK__EINVOCATION_DELEGATE = ((EOperation.Internal)ActionsPackage.Literals.STATEMENT.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Block getOutermostBlock() {
        try {
            return (Block)GET_OUTERMOST_BLOCK__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #isSideEffectFree() <em>Is Side Effect Free</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSideEffectFree()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate IS_SIDE_EFFECT_FREE__EINVOCATION_DELEGATE = ((EOperation.Internal)ActionsPackage.Literals.STATEMENT.getEOperations().get(1)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSideEffectFree() {
        try {
            return (Boolean)IS_SIDE_EFFECT_FREE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #isSideEffectFreeForBlock(behavioral.actions.Block) <em>Is Side Effect Free For Block</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSideEffectFreeForBlock(behavioral.actions.Block)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate IS_SIDE_EFFECT_FREE_FOR_BLOCK_BLOCK__EINVOCATION_DELEGATE = ((EOperation.Internal)ActionsPackage.Literals.STATEMENT.getEOperations().get(2)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSideEffectFreeForBlock(Block block) {
        try {
            return (Boolean)IS_SIDE_EFFECT_FREE_FOR_BLOCK_BLOCK__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{block}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getNamedValuesInScope() <em>Get Named Values In Scope</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNamedValuesInScope()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_NAMED_VALUES_IN_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)ActionsPackage.Literals.STATEMENT.getEOperations().get(3)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<NamedValue> getNamedValuesInScope() {
        try {
            return (EList<NamedValue>)GET_NAMED_VALUES_IN_SCOPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getOwningClass() <em>Get Owning Class</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOwningClass()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_OWNING_CLASS__EINVOCATION_DELEGATE = ((EOperation.Internal)ActionsPackage.Literals.STATEMENT.getEOperations().get(4)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getOwningClass() {
        try {
            return (SapClass)GET_OWNING_CLASS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #addNamedValuesWithNewNames(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Add Named Values With New Names</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #addNamedValuesWithNewNames(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate ADD_NAMED_VALUES_WITH_NEW_NAMES_ELIST_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.IN_SCOPE.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<NamedValue> addNamedValuesWithNewNames(EList<NamedValue> inner, EList<NamedValue> outer) {
        try {
            return (EList<NamedValue>)ADD_NAMED_VALUES_WITH_NEW_NAMES_ELIST_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(2, new Object[]{inner, outer}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ActionsPackage.CONDITIONAL_STATEMENT__BLOCK:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetBlock((Block)otherEnd, msgs);
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
            case ActionsPackage.CONDITIONAL_STATEMENT__BLOCK:
                return basicSetBlock(null, msgs);
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
            case ActionsPackage.CONDITIONAL_STATEMENT__BLOCK:
                return eInternalContainer().eInverseRemove(this, ActionsPackage.BLOCK__STATEMENTS, Block.class, msgs);
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
            case ActionsPackage.CONDITIONAL_STATEMENT__BLOCK:
                if (resolve) return getBlock();
                return basicGetBlock();
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
            case ActionsPackage.CONDITIONAL_STATEMENT__BLOCK:
                setBlock((Block)newValue);
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
            case ActionsPackage.CONDITIONAL_STATEMENT__BLOCK:
                setBlock((Block)null);
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
            case ActionsPackage.CONDITIONAL_STATEMENT__BLOCK:
                return basicGetBlock() != null;
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == InScope.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == Statement.class) {
            switch (derivedFeatureID) {
                case ActionsPackage.CONDITIONAL_STATEMENT__BLOCK: return ActionsPackage.STATEMENT__BLOCK;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == InScope.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == Statement.class) {
            switch (baseFeatureID) {
                case ActionsPackage.STATEMENT__BLOCK: return ActionsPackage.CONDITIONAL_STATEMENT__BLOCK;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //ConditionalStatementImpl
