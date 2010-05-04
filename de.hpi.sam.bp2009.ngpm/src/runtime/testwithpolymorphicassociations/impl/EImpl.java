/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithpolymorphicassociations.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import runtime.testwithpolymorphicassociations.E;
import runtime.testwithpolymorphicassociations.F;
import runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>E</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtime.testwithpolymorphicassociations.impl.EImpl#getEtoF <em>Eto F</em>}</li>
 *   <li>{@link runtime.testwithpolymorphicassociations.impl.EImpl#getB <em>B</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EImpl extends EObjectImpl implements E
{
  /**
   * The default value of the '{@link #getEtoF() <em>Eto F</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEtoF()
   * @generated
   * @ordered
   */
  protected static final String ETO_F_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEtoF() <em>Eto F</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEtoF()
   * @generated
   * @ordered
   */
  protected String etoF = ETO_F_EDEFAULT;

  /**
   * The cached value of the '{@link #getB() <em>B</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getB()
   * @generated
   * @ordered
   */
  protected EList<F> b;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EImpl()
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
    return TestwithpolymorphicassociationsPackage.Literals.E;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEtoF()
  {
    return etoF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEtoF(String newEtoF)
  {
    String oldEtoF = etoF;
    etoF = newEtoF;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestwithpolymorphicassociationsPackage.E__ETO_F, oldEtoF, etoF));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<F> getB()
  {
    if (b == null)
    {
      b = new EObjectWithInverseResolvingEList.ManyInverse<F>(F.class, this, TestwithpolymorphicassociationsPackage.E__B, TestwithpolymorphicassociationsPackage.F__A);
    }
    return b;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void a()
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void c()
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void e()
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TestwithpolymorphicassociationsPackage.E__B:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getB()).basicAdd(otherEnd, msgs);
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
      case TestwithpolymorphicassociationsPackage.E__B:
        return ((InternalEList<?>)getB()).basicRemove(otherEnd, msgs);
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
      case TestwithpolymorphicassociationsPackage.E__ETO_F:
        return getEtoF();
      case TestwithpolymorphicassociationsPackage.E__B:
        return getB();
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
      case TestwithpolymorphicassociationsPackage.E__ETO_F:
        setEtoF((String)newValue);
        return;
      case TestwithpolymorphicassociationsPackage.E__B:
        getB().clear();
        getB().addAll((Collection<? extends F>)newValue);
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
      case TestwithpolymorphicassociationsPackage.E__ETO_F:
        setEtoF(ETO_F_EDEFAULT);
        return;
      case TestwithpolymorphicassociationsPackage.E__B:
        getB().clear();
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
      case TestwithpolymorphicassociationsPackage.E__ETO_F:
        return ETO_F_EDEFAULT == null ? etoF != null : !ETO_F_EDEFAULT.equals(etoF);
      case TestwithpolymorphicassociationsPackage.E__B:
        return b != null && !b.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (EtoF: ");
    result.append(etoF);
    result.append(')');
    return result.toString();
  }

} //EImpl
