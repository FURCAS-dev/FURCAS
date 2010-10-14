/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package localization;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see localization.LocalizationPackage
 * @generated
 */
public interface LocalizationFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	LocalizationFactory eINSTANCE = localization.impl.LocalizationFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Translatable Text</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Translatable Text</em>'.
     * @generated
     */
	TranslatableText createTranslatableText();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	LocalizationPackage getLocalizationPackage();

} //LocalizationFactory
