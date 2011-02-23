/**
 * <copyright>
 * </copyright>
 *
 * $Id: LocalizationFactoryImpl.java,v 1.1 2011/02/07 17:21:38 auhl Exp $
 */
package localization.impl;

import localization.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LocalizationFactoryImpl extends EFactoryImpl implements LocalizationFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static LocalizationFactory init() {
        try {
            LocalizationFactory theLocalizationFactory = (LocalizationFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/localization.ecore"); 
            if (theLocalizationFactory != null) {
                return theLocalizationFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new LocalizationFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LocalizationFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case LocalizationPackage.TRANSLATABLE_TEXT: return createTranslatableText();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TranslatableText createTranslatableText() {
        TranslatableTextImpl translatableText = new TranslatableTextImpl();
        return translatableText;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LocalizationPackage getLocalizationPackage() {
        return (LocalizationPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static LocalizationPackage getPackage() {
        return LocalizationPackage.eINSTANCE;
    }

} //LocalizationFactoryImpl
