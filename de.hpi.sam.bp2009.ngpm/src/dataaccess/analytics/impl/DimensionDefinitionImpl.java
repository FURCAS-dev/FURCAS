/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.analytics.impl;

import behavioral.actions.Iterator;

import dataaccess.analytics.AnalyticsPackage;
import dataaccess.analytics.DimensionDefinition;

import dataaccess.expressions.Expression;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dimension Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.analytics.impl.DimensionDefinitionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link dataaccess.analytics.impl.DimensionDefinitionImpl#getIterator <em>Iterator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DimensionDefinitionImpl extends EObjectImpl implements DimensionDefinition
{
  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * The cached value of the '{@link #getIterator() <em>Iterator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIterator()
   * @generated
   * @ordered
   */
  protected Iterator iterator;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DimensionDefinitionImpl()
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
    return AnalyticsPackage.Literals.DIMENSION_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Iterator getIterator()
  {
    return iterator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIterator(Iterator newIterator, NotificationChain msgs)
  {
    Iterator oldIterator = iterator;
    iterator = newIterator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR, oldIterator, newIterator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIterator(Iterator newIterator)
  {
    if (newIterator != iterator)
    {
      NotificationChain msgs = null;
      if (iterator != null)
        msgs = ((InternalEObject)iterator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR, null, msgs);
      if (newIterator != null)
        msgs = ((InternalEObject)newIterator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR, null, msgs);
      msgs = basicSetIterator(newIterator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR, newIterator, newIterator));
  }

  /**
   * The cached invocation delegate for the '{@link #getName() <em>Get Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_NAME__EINVOCATION_DELEGATE = ((EOperation.Internal)AnalyticsPackage.Literals.DIMENSION_DEFINITION.getEOperations().get(0)).getInvocationDelegate();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    try
    {
      return (String)GET_NAME__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION:
        return basicSetExpression(null, msgs);
      case AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR:
        return basicSetIterator(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION:
        return getExpression();
      case AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR:
        return getIterator();
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
      case AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION:
        setExpression((Expression)newValue);
        return;
      case AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR:
        setIterator((Iterator)newValue);
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
      case AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION:
        setExpression((Expression)null);
        return;
      case AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR:
        setIterator((Iterator)null);
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
      case AnalyticsPackage.DIMENSION_DEFINITION__EXPRESSION:
        return expression != null;
      case AnalyticsPackage.DIMENSION_DEFINITION__ITERATOR:
        return iterator != null;
    }
    return super.eIsSet(featureID);
  }

} //DimensionDefinitionImpl
