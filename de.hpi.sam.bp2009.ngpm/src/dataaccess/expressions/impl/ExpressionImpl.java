/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.impl;

import behavioral.actions.Iterator;

import data.classes.ClassesPackage;
import data.classes.NamedValue;
import data.classes.SapClass;

import data.classes.impl.TypedElementImpl;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionsPackage;

import dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage;
import dataaccess.expressions.collectionexpressions.Iterate;

import dataaccess.query.FromClause;
import dataaccess.query.QueryPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import ui.templates.StringTemplate;
import ui.templates.TemplatesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getInIterator <em>In Iterator</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getFromClause <em>From Clause</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ExpressionImpl#getTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ExpressionImpl extends TypedElementImpl implements Expression
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionImpl()
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
    return ExpressionsPackage.Literals.EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Iterate getInIterator()
  {
    if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__IN_ITERATOR) return null;
    return (Iterate)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInIterator(Iterate newInIterator, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newInIterator, ExpressionsPackage.EXPRESSION__IN_ITERATOR, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInIterator(Iterate newInIterator)
  {
    if (newInIterator != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__IN_ITERATOR && newInIterator != null))
    {
      if (EcoreUtil.isAncestor(this, newInIterator))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newInIterator != null)
        msgs = ((InternalEObject)newInIterator).eInverseAdd(this, CollectionexpressionsPackage.ITERATE__ITERATOR_EXPRESSION, Iterate.class, msgs);
      msgs = basicSetInIterator(newInIterator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__IN_ITERATOR, newInIterator, newInIterator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromClause getFromClause()
  {
    if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__FROM_CLAUSE) return null;
    return (FromClause)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFromClause(FromClause newFromClause, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newFromClause, ExpressionsPackage.EXPRESSION__FROM_CLAUSE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFromClause(FromClause newFromClause)
  {
    if (newFromClause != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__FROM_CLAUSE && newFromClause != null))
    {
      if (EcoreUtil.isAncestor(this, newFromClause))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newFromClause != null)
        msgs = ((InternalEObject)newFromClause).eInverseAdd(this, QueryPackage.FROM_CLAUSE__FROM_EXPRESSION, FromClause.class, msgs);
      msgs = basicSetFromClause(newFromClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__FROM_CLAUSE, newFromClause, newFromClause));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringTemplate getTemplate()
  {
    if (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__TEMPLATE) return null;
    return (StringTemplate)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTemplate(StringTemplate newTemplate, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newTemplate, ExpressionsPackage.EXPRESSION__TEMPLATE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTemplate(StringTemplate newTemplate)
  {
    if (newTemplate != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.EXPRESSION__TEMPLATE && newTemplate != null))
    {
      if (EcoreUtil.isAncestor(this, newTemplate))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newTemplate != null)
        msgs = ((InternalEObject)newTemplate).eInverseAdd(this, TemplatesPackage.STRING_TEMPLATE__EXPRESSIONS, StringTemplate.class, msgs);
      msgs = basicSetTemplate(newTemplate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXPRESSION__TEMPLATE, newTemplate, newTemplate));
  }

  /**
   * The cached invocation delegate for the '{@link #isSideEffectFree() <em>Is Side Effect Free</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSideEffectFree()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate IS_SIDE_EFFECT_FREE__EINVOCATION_DELEGATE = ((EOperation.Internal)ExpressionsPackage.Literals.EXPRESSION.getEOperations().get(0)).getInvocationDelegate();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSideEffectFree()
  {
    try
    {
      return (Boolean)IS_SIDE_EFFECT_FREE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    }
    catch (InvocationTargetException ite)
    {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #evaluatesToEqualAs(dataaccess.expressions.Expression) <em>Evaluates To Equal As</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #evaluatesToEqualAs(dataaccess.expressions.Expression)
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate EVALUATES_TO_EQUAL_AS_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)ExpressionsPackage.Literals.EXPRESSION.getEOperations().get(1)).getInvocationDelegate();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean evaluatesToEqualAs(Expression e)
  {
    try
    {
      return (Boolean)EVALUATES_TO_EQUAL_AS_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{e}));
    }
    catch (InvocationTargetException ite)
    {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getUsedAliases() <em>Get Used Aliases</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsedAliases()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_USED_ALIASES__EINVOCATION_DELEGATE = ((EOperation.Internal)ExpressionsPackage.Literals.EXPRESSION.getEOperations().get(2)).getInvocationDelegate();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Iterator getUsedAliases()
  {
    try
    {
      return (Iterator)GET_USED_ALIASES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    }
    catch (InvocationTargetException ite)
    {
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
  protected static final EOperation.Internal.InvocationDelegate GET_NAMED_VALUES_IN_SCOPE__EINVOCATION_DELEGATE = ((EOperation.Internal)ExpressionsPackage.Literals.EXPRESSION.getEOperations().get(3)).getInvocationDelegate();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedValue getNamedValuesInScope()
  {
    try
    {
      return (NamedValue)GET_NAMED_VALUES_IN_SCOPE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    }
    catch (InvocationTargetException ite)
    {
      throw new WrappedException(ite);
    }
  }

  /**
   * The cached invocation delegate for the '{@link #getOwningExpression() <em>Get Owning Expression</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwningExpression()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_OWNING_EXPRESSION__EINVOCATION_DELEGATE = ((EOperation.Internal)ExpressionsPackage.Literals.EXPRESSION.getEOperations().get(4)).getInvocationDelegate();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getOwningExpression()
  {
    try
    {
      return (Expression)GET_OWNING_EXPRESSION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    }
    catch (InvocationTargetException ite)
    {
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
  protected static final EOperation.Internal.InvocationDelegate GET_OWNING_CLASS__EINVOCATION_DELEGATE = ((EOperation.Internal)ExpressionsPackage.Literals.EXPRESSION.getEOperations().get(5)).getInvocationDelegate();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SapClass getOwningClass()
  {
    try
    {
      return (SapClass)GET_OWNING_CLASS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    }
    catch (InvocationTargetException ite)
    {
      throw new WrappedException(ite);
    }
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

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ExpressionsPackage.EXPRESSION__IN_ITERATOR:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetInIterator((Iterate)otherEnd, msgs);
      case ExpressionsPackage.EXPRESSION__FROM_CLAUSE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetFromClause((FromClause)otherEnd, msgs);
      case ExpressionsPackage.EXPRESSION__TEMPLATE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetTemplate((StringTemplate)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ExpressionsPackage.EXPRESSION__IN_ITERATOR:
        return basicSetInIterator(null, msgs);
      case ExpressionsPackage.EXPRESSION__FROM_CLAUSE:
        return basicSetFromClause(null, msgs);
      case ExpressionsPackage.EXPRESSION__TEMPLATE:
        return basicSetTemplate(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case ExpressionsPackage.EXPRESSION__IN_ITERATOR:
        return eInternalContainer().eInverseRemove(this, CollectionexpressionsPackage.ITERATE__ITERATOR_EXPRESSION, Iterate.class, msgs);
      case ExpressionsPackage.EXPRESSION__FROM_CLAUSE:
        return eInternalContainer().eInverseRemove(this, QueryPackage.FROM_CLAUSE__FROM_EXPRESSION, FromClause.class, msgs);
      case ExpressionsPackage.EXPRESSION__TEMPLATE:
        return eInternalContainer().eInverseRemove(this, TemplatesPackage.STRING_TEMPLATE__EXPRESSIONS, StringTemplate.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ExpressionsPackage.EXPRESSION__IN_ITERATOR:
        return getInIterator();
      case ExpressionsPackage.EXPRESSION__FROM_CLAUSE:
        return getFromClause();
      case ExpressionsPackage.EXPRESSION__TEMPLATE:
        return getTemplate();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ExpressionsPackage.EXPRESSION__IN_ITERATOR:
        setInIterator((Iterate)newValue);
        return;
      case ExpressionsPackage.EXPRESSION__FROM_CLAUSE:
        setFromClause((FromClause)newValue);
        return;
      case ExpressionsPackage.EXPRESSION__TEMPLATE:
        setTemplate((StringTemplate)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ExpressionsPackage.EXPRESSION__IN_ITERATOR:
        setInIterator((Iterate)null);
        return;
      case ExpressionsPackage.EXPRESSION__FROM_CLAUSE:
        setFromClause((FromClause)null);
        return;
      case ExpressionsPackage.EXPRESSION__TEMPLATE:
        setTemplate((StringTemplate)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ExpressionsPackage.EXPRESSION__IN_ITERATOR:
        return getInIterator() != null;
      case ExpressionsPackage.EXPRESSION__FROM_CLAUSE:
        return getFromClause() != null;
      case ExpressionsPackage.EXPRESSION__TEMPLATE:
        return getTemplate() != null;
    }
    return super.eIsSet(featureID);
  }

} //ExpressionImpl
