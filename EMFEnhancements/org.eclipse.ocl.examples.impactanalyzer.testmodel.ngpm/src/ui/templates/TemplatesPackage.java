/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ui.templates;

import data.classes.ClassesPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see ui.templates.TemplatesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface TemplatesPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "templates";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/ui/templates.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "ui.templates";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	TemplatesPackage eINSTANCE = ui.templates.impl.TemplatesPackageImpl.init();

	/**
     * The meta object id for the '{@link ui.templates.impl.StringTemplateImpl <em>String Template</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see ui.templates.impl.StringTemplateImpl
     * @see ui.templates.impl.TemplatesPackageImpl#getStringTemplate()
     * @generated
     */
	int STRING_TEMPLATE = 0;

	/**
     * The feature id for the '<em><b>Implements </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_TEMPLATE__IMPLEMENTS_ = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__IMPLEMENTS_;

	/**
     * The feature id for the '<em><b>Function Signature</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_TEMPLATE__FUNCTION_SIGNATURE = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE;

	/**
     * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_TEMPLATE__EXPRESSIONS = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>String Template</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_TEMPLATE_FEATURE_COUNT = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 1;


	/**
     * Returns the meta object for class '{@link ui.templates.StringTemplate <em>String Template</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>String Template</em>'.
     * @see ui.templates.StringTemplate
     * @generated
     */
	EClass getStringTemplate();

	/**
     * Returns the meta object for the containment reference list '{@link ui.templates.StringTemplate#getExpressions <em>Expressions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Expressions</em>'.
     * @see ui.templates.StringTemplate#getExpressions()
     * @see #getStringTemplate()
     * @generated
     */
	EReference getStringTemplate_Expressions();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	TemplatesFactory getTemplatesFactory();

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
         * The meta object literal for the '{@link ui.templates.impl.StringTemplateImpl <em>String Template</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see ui.templates.impl.StringTemplateImpl
         * @see ui.templates.impl.TemplatesPackageImpl#getStringTemplate()
         * @generated
         */
		EClass STRING_TEMPLATE = eINSTANCE.getStringTemplate();

		/**
         * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference STRING_TEMPLATE__EXPRESSIONS = eINSTANCE.getStringTemplate_Expressions();

	}

} //TemplatesPackage
