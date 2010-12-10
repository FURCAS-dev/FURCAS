/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.syntax.query.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.query2.syntax.query.Import;
import org.eclipse.emf.query2.syntax.query.MQLquery;
import org.eclipse.emf.query2.syntax.query.Model;
import org.eclipse.emf.query2.syntax.query.NamedQuery;
import org.eclipse.emf.query2.syntax.query.QueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.impl.ModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.impl.ModelImpl#getDefaultQuery <em>Default Query</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.syntax.query.impl.ModelImpl#getNamedQueries <em>Named Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The cached value of the '{@link #getDefaultQuery() <em>Default Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultQuery()
   * @generated
   * @ordered
   */
  protected MQLquery defaultQuery;

  /**
   * The cached value of the '{@link #getNamedQueries() <em>Named Queries</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamedQueries()
   * @generated
   * @ordered
   */
  protected EList<NamedQuery> namedQueries;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return QueryPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, QueryPackage.MODEL__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MQLquery getDefaultQuery()
  {
    return defaultQuery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDefaultQuery(MQLquery newDefaultQuery, NotificationChain msgs)
  {
    MQLquery oldDefaultQuery = defaultQuery;
    defaultQuery = newDefaultQuery;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryPackage.MODEL__DEFAULT_QUERY, oldDefaultQuery, newDefaultQuery);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultQuery(MQLquery newDefaultQuery)
  {
    if (newDefaultQuery != defaultQuery)
    {
      NotificationChain msgs = null;
      if (defaultQuery != null)
        msgs = ((InternalEObject)defaultQuery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryPackage.MODEL__DEFAULT_QUERY, null, msgs);
      if (newDefaultQuery != null)
        msgs = ((InternalEObject)newDefaultQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QueryPackage.MODEL__DEFAULT_QUERY, null, msgs);
      msgs = basicSetDefaultQuery(newDefaultQuery, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.MODEL__DEFAULT_QUERY, newDefaultQuery, newDefaultQuery));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NamedQuery> getNamedQueries()
  {
    if (namedQueries == null)
    {
      namedQueries = new EObjectContainmentEList<NamedQuery>(NamedQuery.class, this, QueryPackage.MODEL__NAMED_QUERIES);
    }
    return namedQueries;
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
      case QueryPackage.MODEL__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case QueryPackage.MODEL__DEFAULT_QUERY:
        return basicSetDefaultQuery(null, msgs);
      case QueryPackage.MODEL__NAMED_QUERIES:
        return ((InternalEList<?>)getNamedQueries()).basicRemove(otherEnd, msgs);
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
      case QueryPackage.MODEL__IMPORTS:
        return getImports();
      case QueryPackage.MODEL__DEFAULT_QUERY:
        return getDefaultQuery();
      case QueryPackage.MODEL__NAMED_QUERIES:
        return getNamedQueries();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case QueryPackage.MODEL__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case QueryPackage.MODEL__DEFAULT_QUERY:
        setDefaultQuery((MQLquery)newValue);
        return;
      case QueryPackage.MODEL__NAMED_QUERIES:
        getNamedQueries().clear();
        getNamedQueries().addAll((Collection<? extends NamedQuery>)newValue);
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
      case QueryPackage.MODEL__IMPORTS:
        getImports().clear();
        return;
      case QueryPackage.MODEL__DEFAULT_QUERY:
        setDefaultQuery((MQLquery)null);
        return;
      case QueryPackage.MODEL__NAMED_QUERIES:
        getNamedQueries().clear();
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
      case QueryPackage.MODEL__IMPORTS:
        return imports != null && !imports.isEmpty();
      case QueryPackage.MODEL__DEFAULT_QUERY:
        return defaultQuery != null;
      case QueryPackage.MODEL__NAMED_QUERIES:
        return namedQueries != null && !namedQueries.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
