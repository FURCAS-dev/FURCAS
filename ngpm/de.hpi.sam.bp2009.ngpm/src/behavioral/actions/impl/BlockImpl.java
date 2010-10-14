/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.Block;
import behavioral.actions.Statement;
import behavioral.actions.StatementWithNestedBlocks;

import data.classes.ClassesPackage;
import data.classes.NamedValue;
import data.classes.SapClass;

import data.classes.impl.FunctionSignatureImplementationImpl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.actions.impl.BlockImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link behavioral.actions.impl.BlockImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link behavioral.actions.impl.BlockImpl#getOwningStatement <em>Owning Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockImpl extends FunctionSignatureImplementationImpl implements Block {
	/**
     * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStatements()
     * @generated
     * @ordered
     */
	protected EList<Statement> statements;

	/**
     * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVariables()
     * @generated
     * @ordered
     */
	protected EList<NamedValue> variables;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected BlockImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ActionsPackage.Literals.BLOCK;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Statement> getStatements() {
        if (statements == null) {
            statements = new EObjectContainmentWithInverseEList.Resolving<Statement>(Statement.class, this, ActionsPackage.BLOCK__STATEMENTS, ActionsPackage.STATEMENT__BLOCK);
        }
        return statements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<NamedValue> getVariables() {
        if (variables == null) {
            variables = new EObjectContainmentWithInverseEList.Resolving<NamedValue>(NamedValue.class, this, ActionsPackage.BLOCK__VARIABLES, ClassesPackage.NAMED_VALUE__OWNER);
        }
        return variables;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public StatementWithNestedBlocks getOwningStatement() {
        if (eContainerFeatureID() != ActionsPackage.BLOCK__OWNING_STATEMENT) return null;
        return (StatementWithNestedBlocks)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StatementWithNestedBlocks basicGetOwningStatement() {
        if (eContainerFeatureID() != ActionsPackage.BLOCK__OWNING_STATEMENT) return null;
        return (StatementWithNestedBlocks)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOwningStatement(StatementWithNestedBlocks newOwningStatement, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOwningStatement, ActionsPackage.BLOCK__OWNING_STATEMENT, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOwningStatement(StatementWithNestedBlocks newOwningStatement) {
        if (newOwningStatement != eInternalContainer() || (eContainerFeatureID() != ActionsPackage.BLOCK__OWNING_STATEMENT && newOwningStatement != null)) {
            if (EcoreUtil.isAncestor(this, newOwningStatement))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOwningStatement != null)
                msgs = ((InternalEObject)newOwningStatement).eInverseAdd(this, ActionsPackage.STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS, StatementWithNestedBlocks.class, msgs);
            msgs = basicSetOwningStatement(newOwningStatement, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.BLOCK__OWNING_STATEMENT, newOwningStatement, newOwningStatement));
    }

	/**
     * The cached invocation delegate for the '{@link #getOutermostBlock() <em>Get Outermost Block</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOutermostBlock()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_OUTERMOST_BLOCK__EINVOCATION_DELEGATE = ((EOperation.Internal)ActionsPackage.Literals.BLOCK.getEOperations().get(0)).getInvocationDelegate();

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
     * The cached invocation delegate for the '{@link #localIsSideEffectFree() <em>Local Is Side Effect Free</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #localIsSideEffectFree()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate LOCAL_IS_SIDE_EFFECT_FREE__EINVOCATION_DELEGATE = ((EOperation.Internal)ActionsPackage.Literals.BLOCK.getEOperations().get(1)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean localIsSideEffectFree() {
        try {
            return (Boolean)LOCAL_IS_SIDE_EFFECT_FREE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	protected static final EOperation.Internal.InvocationDelegate GET_NAMED_VALUES_IN_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)ActionsPackage.Literals.BLOCK.getEOperations().get(2)).getInvocationDelegate();

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
	protected static final EOperation.Internal.InvocationDelegate GET_OWNING_CLASS__EINVOCATION_DELEGATE = ((EOperation.Internal)ActionsPackage.Literals.BLOCK.getEOperations().get(3)).getInvocationDelegate();

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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ActionsPackage.BLOCK__STATEMENTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getStatements()).basicAdd(otherEnd, msgs);
            case ActionsPackage.BLOCK__VARIABLES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getVariables()).basicAdd(otherEnd, msgs);
            case ActionsPackage.BLOCK__OWNING_STATEMENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOwningStatement((StatementWithNestedBlocks)otherEnd, msgs);
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
            case ActionsPackage.BLOCK__STATEMENTS:
                return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
            case ActionsPackage.BLOCK__VARIABLES:
                return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
            case ActionsPackage.BLOCK__OWNING_STATEMENT:
                return basicSetOwningStatement(null, msgs);
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
            case ActionsPackage.BLOCK__OWNING_STATEMENT:
                return eInternalContainer().eInverseRemove(this, ActionsPackage.STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS, StatementWithNestedBlocks.class, msgs);
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
            case ActionsPackage.BLOCK__STATEMENTS:
                return getStatements();
            case ActionsPackage.BLOCK__VARIABLES:
                return getVariables();
            case ActionsPackage.BLOCK__OWNING_STATEMENT:
                if (resolve) return getOwningStatement();
                return basicGetOwningStatement();
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
            case ActionsPackage.BLOCK__STATEMENTS:
                getStatements().clear();
                getStatements().addAll((Collection<? extends Statement>)newValue);
                return;
            case ActionsPackage.BLOCK__VARIABLES:
                getVariables().clear();
                getVariables().addAll((Collection<? extends NamedValue>)newValue);
                return;
            case ActionsPackage.BLOCK__OWNING_STATEMENT:
                setOwningStatement((StatementWithNestedBlocks)newValue);
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
            case ActionsPackage.BLOCK__STATEMENTS:
                getStatements().clear();
                return;
            case ActionsPackage.BLOCK__VARIABLES:
                getVariables().clear();
                return;
            case ActionsPackage.BLOCK__OWNING_STATEMENT:
                setOwningStatement((StatementWithNestedBlocks)null);
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
            case ActionsPackage.BLOCK__STATEMENTS:
                return statements != null && !statements.isEmpty();
            case ActionsPackage.BLOCK__VARIABLES:
                return variables != null && !variables.isEmpty();
            case ActionsPackage.BLOCK__OWNING_STATEMENT:
                return basicGetOwningStatement() != null;
        }
        return super.eIsSet(featureID);
    }

} //BlockImpl
