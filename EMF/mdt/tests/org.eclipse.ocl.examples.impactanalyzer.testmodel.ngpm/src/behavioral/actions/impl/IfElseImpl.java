/**
 * <copyright>
 * </copyright>
 *
 * $Id: IfElseImpl.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.actions.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.Block;
import behavioral.actions.IfElse;
import behavioral.actions.StatementWithNestedBlocks;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Else</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.actions.impl.IfElseImpl#getNestedBlocks <em>Nested Blocks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfElseImpl extends ConditionalStatementImpl implements IfElse {
	/**
     * The cached value of the '{@link #getNestedBlocks() <em>Nested Blocks</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNestedBlocks()
     * @generated
     * @ordered
     */
	protected EList<Block> nestedBlocks;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected IfElseImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ActionsPackage.Literals.IF_ELSE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Block> getNestedBlocks() {
        if (nestedBlocks == null) {
            nestedBlocks = new EObjectContainmentWithInverseEList.Resolving<Block>(Block.class, this, ActionsPackage.IF_ELSE__NESTED_BLOCKS, ActionsPackage.BLOCK__OWNING_STATEMENT);
        }
        return nestedBlocks;
    }

	/**
     * The cached invocation delegate for the '{@link #getIfBlock() <em>Get If Block</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIfBlock()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_IF_BLOCK__EINVOCATION_DELEGATE = ((EOperation.Internal)ActionsPackage.Literals.IF_ELSE.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Block getIfBlock() {
        try {
            return (Block)GET_IF_BLOCK__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getElseBlock() <em>Get Else Block</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getElseBlock()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_ELSE_BLOCK__EINVOCATION_DELEGATE = ((EOperation.Internal)ActionsPackage.Literals.IF_ELSE.getEOperations().get(1)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Block getElseBlock() {
        try {
            return (Block)GET_ELSE_BLOCK__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ActionsPackage.IF_ELSE__NESTED_BLOCKS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getNestedBlocks()).basicAdd(otherEnd, msgs);
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
            case ActionsPackage.IF_ELSE__NESTED_BLOCKS:
                return ((InternalEList<?>)getNestedBlocks()).basicRemove(otherEnd, msgs);
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
            case ActionsPackage.IF_ELSE__NESTED_BLOCKS:
                return getNestedBlocks();
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
            case ActionsPackage.IF_ELSE__NESTED_BLOCKS:
                getNestedBlocks().clear();
                getNestedBlocks().addAll((Collection<? extends Block>)newValue);
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
            case ActionsPackage.IF_ELSE__NESTED_BLOCKS:
                getNestedBlocks().clear();
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
            case ActionsPackage.IF_ELSE__NESTED_BLOCKS:
                return nestedBlocks != null && !nestedBlocks.isEmpty();
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
        if (baseClass == StatementWithNestedBlocks.class) {
            switch (derivedFeatureID) {
                case ActionsPackage.IF_ELSE__NESTED_BLOCKS: return ActionsPackage.STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS;
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
        if (baseClass == StatementWithNestedBlocks.class) {
            switch (baseFeatureID) {
                case ActionsPackage.STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS: return ActionsPackage.IF_ELSE__NESTED_BLOCKS;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //IfElseImpl
