/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.InScope;
import data.classes.NamedValue;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;

import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>In Scope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class InScopeImpl extends EObjectImpl implements InScope {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected InScopeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.IN_SCOPE;
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

} //InScopeImpl
