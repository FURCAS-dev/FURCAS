/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package localization.impl;

import localization.LocalizationPackage;
import localization.TranslatableText;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Translatable Text</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link localization.impl.TranslatableTextImpl#getText <em>Text</em>}</li>
 *   <li>{@link localization.impl.TranslatableTextImpl#getHintForTranslator <em>Hint For Translator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TranslatableTextImpl extends EObjectImpl implements TranslatableText
{
  /**
   * The cached value of the '{@link #getText() <em>Text</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getText()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String text;

  /**
   * The cached value of the '{@link #getHintForTranslator() <em>Hint For Translator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHintForTranslator()
   * @generated
   * @ordered
   */
  protected runtime.primitivetypes.String hintForTranslator;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TranslatableTextImpl()
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
    return LocalizationPackage.Literals.TRANSLATABLE_TEXT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getText()
  {
    return text;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetText(runtime.primitivetypes.String newText, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldText = text;
    text = newText;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LocalizationPackage.TRANSLATABLE_TEXT__TEXT, oldText, newText);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setText(runtime.primitivetypes.String newText)
  {
    if (newText != text)
    {
      NotificationChain msgs = null;
      if (text != null)
        msgs = ((InternalEObject)text).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LocalizationPackage.TRANSLATABLE_TEXT__TEXT, null, msgs);
      if (newText != null)
        msgs = ((InternalEObject)newText).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LocalizationPackage.TRANSLATABLE_TEXT__TEXT, null, msgs);
      msgs = basicSetText(newText, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LocalizationPackage.TRANSLATABLE_TEXT__TEXT, newText, newText));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public runtime.primitivetypes.String getHintForTranslator()
  {
    return hintForTranslator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetHintForTranslator(runtime.primitivetypes.String newHintForTranslator, NotificationChain msgs)
  {
    runtime.primitivetypes.String oldHintForTranslator = hintForTranslator;
    hintForTranslator = newHintForTranslator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LocalizationPackage.TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR, oldHintForTranslator, newHintForTranslator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHintForTranslator(runtime.primitivetypes.String newHintForTranslator)
  {
    if (newHintForTranslator != hintForTranslator)
    {
      NotificationChain msgs = null;
      if (hintForTranslator != null)
        msgs = ((InternalEObject)hintForTranslator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LocalizationPackage.TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR, null, msgs);
      if (newHintForTranslator != null)
        msgs = ((InternalEObject)newHintForTranslator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LocalizationPackage.TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR, null, msgs);
      msgs = basicSetHintForTranslator(newHintForTranslator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LocalizationPackage.TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR, newHintForTranslator, newHintForTranslator));
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
      case LocalizationPackage.TRANSLATABLE_TEXT__TEXT:
        return basicSetText(null, msgs);
      case LocalizationPackage.TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR:
        return basicSetHintForTranslator(null, msgs);
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
      case LocalizationPackage.TRANSLATABLE_TEXT__TEXT:
        return getText();
      case LocalizationPackage.TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR:
        return getHintForTranslator();
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
      case LocalizationPackage.TRANSLATABLE_TEXT__TEXT:
        setText((runtime.primitivetypes.String)newValue);
        return;
      case LocalizationPackage.TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR:
        setHintForTranslator((runtime.primitivetypes.String)newValue);
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
      case LocalizationPackage.TRANSLATABLE_TEXT__TEXT:
        setText((runtime.primitivetypes.String)null);
        return;
      case LocalizationPackage.TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR:
        setHintForTranslator((runtime.primitivetypes.String)null);
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
      case LocalizationPackage.TRANSLATABLE_TEXT__TEXT:
        return text != null;
      case LocalizationPackage.TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR:
        return hintForTranslator != null;
    }
    return super.eIsSet(featureID);
  }

} //TranslatableTextImpl
