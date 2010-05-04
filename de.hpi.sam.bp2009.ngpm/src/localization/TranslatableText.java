/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package localization;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Translatable Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link localization.TranslatableText#getText <em>Text</em>}</li>
 *   <li>{@link localization.TranslatableText#getHintForTranslator <em>Hint For Translator</em>}</li>
 * </ul>
 * </p>
 *
 * @see localization.LocalizationPackage#getTranslatableText()
 * @model
 * @generated
 */
public interface TranslatableText extends EObject
{
  /**
   * Returns the value of the '<em><b>Text</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Text</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text</em>' containment reference.
   * @see #setText(runtime.primitivetypes.String)
   * @see localization.LocalizationPackage#getTranslatableText_Text()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getText();

  /**
   * Sets the value of the '{@link localization.TranslatableText#getText <em>Text</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text</em>' containment reference.
   * @see #getText()
   * @generated
   */
  void setText(runtime.primitivetypes.String value);

  /**
   * Returns the value of the '<em><b>Hint For Translator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hint For Translator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hint For Translator</em>' containment reference.
   * @see #setHintForTranslator(runtime.primitivetypes.String)
   * @see localization.LocalizationPackage#getTranslatableText_HintForTranslator()
   * @model containment="true"
   * @generated
   */
  runtime.primitivetypes.String getHintForTranslator();

  /**
   * Sets the value of the '{@link localization.TranslatableText#getHintForTranslator <em>Hint For Translator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Hint For Translator</em>' containment reference.
   * @see #getHintForTranslator()
   * @generated
   */
  void setHintForTranslator(runtime.primitivetypes.String value);

} // TranslatableText
