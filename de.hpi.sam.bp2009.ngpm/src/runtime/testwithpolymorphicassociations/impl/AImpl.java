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

import runtime.testwithpolymorphicassociations.A;
import runtime.testwithpolymorphicassociations.B;
import runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link runtime.testwithpolymorphicassociations.impl.AImpl#getAtoB <em>Ato B</em>}</li>
 *   <li>{@link runtime.testwithpolymorphicassociations.impl.AImpl#getB <em>B</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AImpl extends EObjectImpl implements A
{
  /**
   * The default value of the '{@link #getAtoB() <em>Ato B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAtoB()
   * @generated
   * @ordered
   */
  protected static final String ATO_B_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAtoB() <em>Ato B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAtoB()
   * @generated
   * @ordered
   */
  protected String atoB = ATO_B_EDEFAULT;

  /**
   * The cached value of the '{@link #getB() <em>B</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getB()
   * @generated
   * @ordered
   */
  protected EList<B> b;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AImpl()
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
    return TestwithpolymorphicassociationsPackage.Literals.A;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAtoB()
  {
    return atoB;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAtoB(String newAtoB)
  {
    String oldAtoB = atoB;
    atoB = newAtoB;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TestwithpolymorphicassociationsPackage.A__ATO_B, oldAtoB, atoB));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<B> getB()
  {
    if (b == null)
    {
      b = new EObjectWithInverseResolvingEList.ManyInverse<B>(B.class, this, TestwithpolymorphicassociationsPackage.A__B, TestwithpolymorphicassociationsPackage.B__A);
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
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TestwithpolymorphicassociationsPackage.A__B:
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
      case TestwithpolymorphicassociationsPackage.A__B:
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
      case TestwithpolymorphicassociationsPackage.A__ATO_B:
        return getAtoB();
      case TestwithpolymorphicassociationsPackage.A__B:
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
      case TestwithpolymorphicassociationsPackage.A__ATO_B:
        setAtoB((String)newValue);
        return;
      case TestwithpolymorphicassociationsPackage.A__B:
        getB().clear();
        getB().addAll((Collection<? extends B>)newValue);
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
      case TestwithpolymorphicassociationsPackage.A__ATO_B:
        setAtoB(ATO_B_EDEFAULT);
        return;
      case TestwithpolymorphicassociationsPackage.A__B:
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
      case TestwithpolymorphicassociationsPackage.A__ATO_B:
        return ATO_B_EDEFAULT == null ? atoB != null : !ATO_B_EDEFAULT.equals(atoB);
      case TestwithpolymorphicassociationsPackage.A__B:
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
    result.append(" (AtoB: ");
    result.append(atoB);
    result.append(')');
    return result.toString();
  }

} //AImpl
