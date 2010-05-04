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
public abstract class InScopeImpl extends EObjectImpl implements InScope
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InScopeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ClassesPackage.Literals.IN_SCOPE;
  }

  /**
   * The cached invocation delegate for the '{@link #addNamedValuesWithNewNames(data.classes.NamedValue, data.classes.NamedValue) <em>Add Named Values With New Names</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #addNamedValuesWithNewNames(data.classes.NamedValue, data.classes.NamedValue)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate ADD_NAMED_VALUES_WITH_NEW_NAMES_NAMED_VALUE_NAMED_VALUE__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.IN_SCOPE.getEOperations().get(0)).getInvocationDelegate();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedValue addNamedValuesWithNewNames(NamedValue inner, NamedValue outer)
  {
    try
    {
      return (NamedValue)ADD_NAMED_VALUES_WITH_NEW_NAMES_NAMED_VALUE_NAMED_VALUE__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(2, new Object[]{inner, outer}));
    }
    catch (InvocationTargetException ite)
    {
      throw new WrappedException(ite);
    }
  }

} //InScopeImpl
