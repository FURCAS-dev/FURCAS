/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.Block;
import behavioral.actions.StatementWithNestedBlocks;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statement With Nested Blocks</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.actions.impl.StatementWithNestedBlocksImpl#getNestedBlocks <em>Nested Blocks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatementWithNestedBlocksImpl extends StatementImpl implements StatementWithNestedBlocks {
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
	protected StatementWithNestedBlocksImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ActionsPackage.Literals.STATEMENT_WITH_NESTED_BLOCKS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Block> getNestedBlocks() {
        if (nestedBlocks == null) {
            nestedBlocks = new EObjectContainmentWithInverseEList.Resolving<Block>(Block.class, this, ActionsPackage.STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS, ActionsPackage.BLOCK__OWNING_STATEMENT);
        }
        return nestedBlocks;
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
            case ActionsPackage.STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS:
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
            case ActionsPackage.STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS:
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
            case ActionsPackage.STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS:
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
            case ActionsPackage.STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS:
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
            case ActionsPackage.STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS:
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
            case ActionsPackage.STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS:
                return nestedBlocks != null && !nestedBlocks.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //StatementWithNestedBlocksImpl
