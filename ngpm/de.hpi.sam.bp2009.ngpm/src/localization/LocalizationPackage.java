/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package localization;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Contains model snipplets useful for parts of the programming model that require translation of (parts of) their artifacts, such as UI texts, message texts or descriptions useful during design-time. This may require linking to concepts such as "development language" providing defaults for the language in which a string is given.
 * 
 * It will also be an interesting question how the languages, regions and dialects important for the translation process should be represented.
 * <!-- end-model-doc -->
 * @see localization.LocalizationFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface LocalizationPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "localization";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///localization.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "localization";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	LocalizationPackage eINSTANCE = localization.impl.LocalizationPackageImpl.init();

	/**
     * The meta object id for the '{@link localization.impl.TranslatableTextImpl <em>Translatable Text</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see localization.impl.TranslatableTextImpl
     * @see localization.impl.LocalizationPackageImpl#getTranslatableText()
     * @generated
     */
	int TRANSLATABLE_TEXT = 0;

	/**
     * The feature id for the '<em><b>Text</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSLATABLE_TEXT__TEXT = 0;

	/**
     * The feature id for the '<em><b>Hint For Translator</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR = 1;

	/**
     * The number of structural features of the '<em>Translatable Text</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSLATABLE_TEXT_FEATURE_COUNT = 2;


	/**
     * Returns the meta object for class '{@link localization.TranslatableText <em>Translatable Text</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Translatable Text</em>'.
     * @see localization.TranslatableText
     * @generated
     */
	EClass getTranslatableText();

	/**
     * Returns the meta object for the attribute '{@link localization.TranslatableText#getText <em>Text</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text</em>'.
     * @see localization.TranslatableText#getText()
     * @see #getTranslatableText()
     * @generated
     */
	EAttribute getTranslatableText_Text();

	/**
     * Returns the meta object for the attribute '{@link localization.TranslatableText#getHintForTranslator <em>Hint For Translator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Hint For Translator</em>'.
     * @see localization.TranslatableText#getHintForTranslator()
     * @see #getTranslatableText()
     * @generated
     */
	EAttribute getTranslatableText_HintForTranslator();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	LocalizationFactory getLocalizationFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link localization.impl.TranslatableTextImpl <em>Translatable Text</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see localization.impl.TranslatableTextImpl
         * @see localization.impl.LocalizationPackageImpl#getTranslatableText()
         * @generated
         */
		EClass TRANSLATABLE_TEXT = eINSTANCE.getTranslatableText();

		/**
         * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute TRANSLATABLE_TEXT__TEXT = eINSTANCE.getTranslatableText_Text();

		/**
         * The meta object literal for the '<em><b>Hint For Translator</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute TRANSLATABLE_TEXT__HINT_FOR_TRANSLATOR = eINSTANCE.getTranslatableText_HintForTranslator();

	}

} //LocalizationPackage
