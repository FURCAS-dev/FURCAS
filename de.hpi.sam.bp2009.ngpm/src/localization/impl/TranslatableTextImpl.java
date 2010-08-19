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

import org.eclipse.emf.ecore.EClass;

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
public class TranslatableTextImpl extends EObjectImpl implements TranslatableText {
	/**
     * The default value of the '{@link #getText() <em>Text</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getText()
     * @generated
     * @ordered
     */
	protected static final String TEXT_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getText()
     * @generated
     * @ordered
     */
	protected String text = TEXT_EDEFAULT;

	/**
     * The default value of the '{@link #getHintForTranslator() <em>Hint For Translator</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getHintForTranslator()
     * @generated
     * @ordered
     */
	protected static final String HINT_FOR_TRANSLATOR_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getHintForTranslator() <em>Hint For Translator</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getHintForTranslator()
     * @generated
     * @ordered
     */
	protected String hintForTranslator = HINT_FOR_TRANSLATOR_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TranslatableTextImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return LocalizationPackage.Literals.TRANSLATABLE_TEXT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getText() {
        return text;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setText(String newText) {
        String oldText = text;
        text = newText;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, LocalizationPackage.TRANSLATABLE_TEXT__TEXT, oldText, text));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getHintForTranslator() {
        return hintForTranslator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setHintForTranslator(String newHintForTranslator) {
        String oldHintForTranslator = hintForTranslator;
        hintForTranslator = newHintForTranslator;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, LocalizationPackage.TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR, oldHintForTranslator, hintForTranslator));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
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
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case LocalizationPackage.TRANSLATABLE_TEXT__TEXT:
                setText((String)newValue);
                return;
            case LocalizationPackage.TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR:
                setHintForTranslator((String)newValue);
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
	public void eUnset(int featureID) {
        switch (featureID) {
            case LocalizationPackage.TRANSLATABLE_TEXT__TEXT:
                setText(TEXT_EDEFAULT);
                return;
            case LocalizationPackage.TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR:
                setHintForTranslator(HINT_FOR_TRANSLATOR_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case LocalizationPackage.TRANSLATABLE_TEXT__TEXT:
                return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
            case LocalizationPackage.TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR:
                return HINT_FOR_TRANSLATOR_EDEFAULT == null ? hintForTranslator != null : !HINT_FOR_TRANSLATOR_EDEFAULT.equals(hintForTranslator);
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (text: ");
        result.append(text);
        result.append(", hintForTranslator: ");
        result.append(hintForTranslator);
        result.append(')');
        return result.toString();
    }

} //TranslatableTextImpl
