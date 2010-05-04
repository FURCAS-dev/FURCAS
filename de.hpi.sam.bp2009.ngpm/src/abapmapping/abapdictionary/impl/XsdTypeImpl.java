/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.abapdictionary.impl;

import abapmapping.abapdictionary.AbapdictionaryPackage;
import abapmapping.abapdictionary.XsdType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xsd Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.impl.XsdTypeImpl#getXsdType <em>Xsd Type</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.impl.XsdTypeImpl#getLength <em>Length</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.impl.XsdTypeImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.impl.XsdTypeImpl#getTotalDigits <em>Total Digits</em>}</li>
 *   <li>{@link abapmapping.abapdictionary.impl.XsdTypeImpl#getFractionDigits <em>Fraction Digits</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XsdTypeImpl extends EObjectImpl implements XsdType
{
  /**
   * The cached value of the '{@link #getXsdType() <em>Xsd Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXsdType()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String xsdType;

  /**
   * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLength()
   * @generated
   * @ordered
   */
  protected static final long LENGTH_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLength()
   * @generated
   * @ordered
   */
  protected long length = LENGTH_EDEFAULT;

  /**
   * The cached value of the '{@link #getPattern() <em>Pattern</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPattern()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String pattern;

  /**
   * The default value of the '{@link #getTotalDigits() <em>Total Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTotalDigits()
   * @generated
   * @ordered
   */
  protected static final long TOTAL_DIGITS_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getTotalDigits() <em>Total Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTotalDigits()
   * @generated
   * @ordered
   */
  protected long totalDigits = TOTAL_DIGITS_EDEFAULT;

  /**
   * The default value of the '{@link #getFractionDigits() <em>Fraction Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFractionDigits()
   * @generated
   * @ordered
   */
  protected static final long FRACTION_DIGITS_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getFractionDigits() <em>Fraction Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFractionDigits()
   * @generated
   * @ordered
   */
  protected long fractionDigits = FRACTION_DIGITS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XsdTypeImpl()
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
    return AbapdictionaryPackage.Literals.XSD_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getXsdType()
  {
    return xsdType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetXsdType(runtime.primitivetypes.String newXsdType, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldXsdType = xsdType;
    xsdType = newXsdType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.XSD_TYPE__XSD_TYPE, oldXsdType, newXsdType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXsdType(runtime.primitivetypes.String newXsdType)
  {
    if (newXsdType != xsdType)
    {
      NotificationChain msgs = null;
      if (xsdType != null)
        msgs = ((InternalEObject)xsdType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AbapdictionaryPackage.XSD_TYPE__XSD_TYPE, null, msgs);
      if (newXsdType != null)
        msgs = ((InternalEObject)newXsdType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AbapdictionaryPackage.XSD_TYPE__XSD_TYPE, null, msgs);
      msgs = basicSetXsdType(newXsdType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.XSD_TYPE__XSD_TYPE, newXsdType, newXsdType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getLength()
  {
    return length;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLength(long newLength)
  {
    long oldLength = length;
    length = newLength;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.XSD_TYPE__LENGTH, oldLength, length));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getPattern()
  {
    return pattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPattern(runtime.primitivetypes.String newPattern, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldPattern = pattern;
    pattern = newPattern;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.XSD_TYPE__PATTERN, oldPattern, newPattern);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPattern(runtime.primitivetypes.String newPattern)
  {
    if (newPattern != pattern)
    {
      NotificationChain msgs = null;
      if (pattern != null)
        msgs = ((InternalEObject)pattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AbapdictionaryPackage.XSD_TYPE__PATTERN, null, msgs);
      if (newPattern != null)
        msgs = ((InternalEObject)newPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AbapdictionaryPackage.XSD_TYPE__PATTERN, null, msgs);
      msgs = basicSetPattern(newPattern, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.XSD_TYPE__PATTERN, newPattern, newPattern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getTotalDigits()
  {
    return totalDigits;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTotalDigits(long newTotalDigits)
  {
    long oldTotalDigits = totalDigits;
    totalDigits = newTotalDigits;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.XSD_TYPE__TOTAL_DIGITS, oldTotalDigits, totalDigits));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getFractionDigits()
  {
    return fractionDigits;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFractionDigits(long newFractionDigits)
  {
    long oldFractionDigits = fractionDigits;
    fractionDigits = newFractionDigits;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AbapdictionaryPackage.XSD_TYPE__FRACTION_DIGITS, oldFractionDigits, fractionDigits));
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
      case AbapdictionaryPackage.XSD_TYPE__XSD_TYPE:
        return basicSetXsdType(null, msgs);
      case AbapdictionaryPackage.XSD_TYPE__PATTERN:
        return basicSetPattern(null, msgs);
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
      case AbapdictionaryPackage.XSD_TYPE__XSD_TYPE:
        return getXsdType();
      case AbapdictionaryPackage.XSD_TYPE__LENGTH:
        return getLength();
      case AbapdictionaryPackage.XSD_TYPE__PATTERN:
        return getPattern();
      case AbapdictionaryPackage.XSD_TYPE__TOTAL_DIGITS:
        return getTotalDigits();
      case AbapdictionaryPackage.XSD_TYPE__FRACTION_DIGITS:
        return getFractionDigits();
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
      case AbapdictionaryPackage.XSD_TYPE__XSD_TYPE:
        setXsdType((runtime.primitivetypes.String)newValue);
        return;
      case AbapdictionaryPackage.XSD_TYPE__LENGTH:
        setLength((Long)newValue);
        return;
      case AbapdictionaryPackage.XSD_TYPE__PATTERN:
        setPattern((runtime.primitivetypes.String)newValue);
        return;
      case AbapdictionaryPackage.XSD_TYPE__TOTAL_DIGITS:
        setTotalDigits((Long)newValue);
        return;
      case AbapdictionaryPackage.XSD_TYPE__FRACTION_DIGITS:
        setFractionDigits((Long)newValue);
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
      case AbapdictionaryPackage.XSD_TYPE__XSD_TYPE:
        setXsdType((runtime.primitivetypes.String)null);
        return;
      case AbapdictionaryPackage.XSD_TYPE__LENGTH:
        setLength(LENGTH_EDEFAULT);
        return;
      case AbapdictionaryPackage.XSD_TYPE__PATTERN:
        setPattern((runtime.primitivetypes.String)null);
        return;
      case AbapdictionaryPackage.XSD_TYPE__TOTAL_DIGITS:
        setTotalDigits(TOTAL_DIGITS_EDEFAULT);
        return;
      case AbapdictionaryPackage.XSD_TYPE__FRACTION_DIGITS:
        setFractionDigits(FRACTION_DIGITS_EDEFAULT);
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
      case AbapdictionaryPackage.XSD_TYPE__XSD_TYPE:
        return xsdType != null;
      case AbapdictionaryPackage.XSD_TYPE__LENGTH:
        return length != LENGTH_EDEFAULT;
      case AbapdictionaryPackage.XSD_TYPE__PATTERN:
        return pattern != null;
      case AbapdictionaryPackage.XSD_TYPE__TOTAL_DIGITS:
        return totalDigits != TOTAL_DIGITS_EDEFAULT;
      case AbapdictionaryPackage.XSD_TYPE__FRACTION_DIGITS:
        return fractionDigits != FRACTION_DIGITS_EDEFAULT;
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
    result.append(" (length: ");
    result.append(length);
    result.append(", totalDigits: ");
    result.append(totalDigits);
    result.append(", fractionDigits: ");
    result.append(fractionDigits);
    result.append(')');
    return result.toString();
  }

} //XsdTypeImpl
