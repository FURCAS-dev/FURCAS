/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content.impl;

import java.util.Collection;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import sproxy_content.Attribute;
import sproxy_content.Sproxy_contentPackage;
import sproxy_content.StatusAndActionSchema;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Status And Action Schema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sproxy_content.impl.StatusAndActionSchemaImpl#getStatusVariables <em>Status Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatusAndActionSchemaImpl extends NamedElementImpl implements StatusAndActionSchema
{
  /**
   * The cached value of the '{@link #getStatusVariables() <em>Status Variables</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatusVariables()
   * @generated
   * @ordered
   */
  protected EList<Attribute> statusVariables;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StatusAndActionSchemaImpl()
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
    return Sproxy_contentPackage.Literals.STATUS_AND_ACTION_SCHEMA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute> getStatusVariables()
  {
    if (statusVariables == null)
    {
      statusVariables = new EObjectResolvingEList<Attribute>(Attribute.class, this, Sproxy_contentPackage.STATUS_AND_ACTION_SCHEMA__STATUS_VARIABLES);
    }
    return statusVariables;
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
      case Sproxy_contentPackage.STATUS_AND_ACTION_SCHEMA__STATUS_VARIABLES:
        return getStatusVariables();
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
      case Sproxy_contentPackage.STATUS_AND_ACTION_SCHEMA__STATUS_VARIABLES:
        getStatusVariables().clear();
        getStatusVariables().addAll((Collection<? extends Attribute>)newValue);
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
      case Sproxy_contentPackage.STATUS_AND_ACTION_SCHEMA__STATUS_VARIABLES:
        getStatusVariables().clear();
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
      case Sproxy_contentPackage.STATUS_AND_ACTION_SCHEMA__STATUS_VARIABLES:
        return statusVariables != null && !statusVariables.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StatusAndActionSchemaImpl
