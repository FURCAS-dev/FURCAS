/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see abapmapping.AbapmappingFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface AbapmappingPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "abapmapping";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///abapmapping.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "abapmapping";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	AbapmappingPackage eINSTANCE = abapmapping.impl.AbapmappingPackageImpl.init();

	/**
     * The meta object id for the '{@link abapmapping.impl.AbapClassImplementationAnnotationImpl <em>Abap Class Implementation Annotation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.impl.AbapClassImplementationAnnotationImpl
     * @see abapmapping.impl.AbapmappingPackageImpl#getAbapClassImplementationAnnotation()
     * @generated
     */
	int ABAP_CLASS_IMPLEMENTATION_ANNOTATION = 0;

	/**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_CLASS_IMPLEMENTATION_ANNOTATION__KIND = 0;

	/**
     * The feature id for the '<em><b>Abap Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_CLASS_IMPLEMENTATION_ANNOTATION__ABAP_TYPE = 1;

	/**
     * The number of structural features of the '<em>Abap Class Implementation Annotation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_CLASS_IMPLEMENTATION_ANNOTATION_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link abapmapping.impl.AbapAssociationImplementationAnnotationImpl <em>Abap Association Implementation Annotation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.impl.AbapAssociationImplementationAnnotationImpl
     * @see abapmapping.impl.AbapmappingPackageImpl#getAbapAssociationImplementationAnnotation()
     * @generated
     */
	int ABAP_ASSOCIATION_IMPLEMENTATION_ANNOTATION = 1;

	/**
     * The number of structural features of the '<em>Abap Association Implementation Annotation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_ASSOCIATION_IMPLEMENTATION_ANNOTATION_FEATURE_COUNT = 0;

	/**
     * The meta object id for the '{@link abapmapping.impl.AbapAssociationEndImplementationAnnotationImpl <em>Abap Association End Implementation Annotation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.impl.AbapAssociationEndImplementationAnnotationImpl
     * @see abapmapping.impl.AbapmappingPackageImpl#getAbapAssociationEndImplementationAnnotation()
     * @generated
     */
	int ABAP_ASSOCIATION_END_IMPLEMENTATION_ANNOTATION = 2;

	/**
     * The number of structural features of the '<em>Abap Association End Implementation Annotation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_ASSOCIATION_END_IMPLEMENTATION_ANNOTATION_FEATURE_COUNT = 0;

	/**
     * The meta object id for the '{@link abapmapping.impl.AbapSignatureImplementationAnnotationImpl <em>Abap Signature Implementation Annotation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.impl.AbapSignatureImplementationAnnotationImpl
     * @see abapmapping.impl.AbapmappingPackageImpl#getAbapSignatureImplementationAnnotation()
     * @generated
     */
	int ABAP_SIGNATURE_IMPLEMENTATION_ANNOTATION = 3;

	/**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_SIGNATURE_IMPLEMENTATION_ANNOTATION__KIND = 0;

	/**
     * The number of structural features of the '<em>Abap Signature Implementation Annotation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_SIGNATURE_IMPLEMENTATION_ANNOTATION_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link abapmapping.AbapClassKind <em>Abap Class Kind</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.AbapClassKind
     * @see abapmapping.impl.AbapmappingPackageImpl#getAbapClassKind()
     * @generated
     */
	int ABAP_CLASS_KIND = 4;

	/**
     * The meta object id for the '{@link abapmapping.AbapSignatureKind <em>Abap Signature Kind</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.AbapSignatureKind
     * @see abapmapping.impl.AbapmappingPackageImpl#getAbapSignatureKind()
     * @generated
     */
	int ABAP_SIGNATURE_KIND = 5;


	/**
     * Returns the meta object for class '{@link abapmapping.AbapClassImplementationAnnotation <em>Abap Class Implementation Annotation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abap Class Implementation Annotation</em>'.
     * @see abapmapping.AbapClassImplementationAnnotation
     * @generated
     */
	EClass getAbapClassImplementationAnnotation();

	/**
     * Returns the meta object for the attribute '{@link abapmapping.AbapClassImplementationAnnotation#getKind <em>Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see abapmapping.AbapClassImplementationAnnotation#getKind()
     * @see #getAbapClassImplementationAnnotation()
     * @generated
     */
	EAttribute getAbapClassImplementationAnnotation_Kind();

	/**
     * Returns the meta object for the reference '{@link abapmapping.AbapClassImplementationAnnotation#getAbapType <em>Abap Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Abap Type</em>'.
     * @see abapmapping.AbapClassImplementationAnnotation#getAbapType()
     * @see #getAbapClassImplementationAnnotation()
     * @generated
     */
	EReference getAbapClassImplementationAnnotation_AbapType();

	/**
     * Returns the meta object for class '{@link abapmapping.AbapAssociationImplementationAnnotation <em>Abap Association Implementation Annotation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abap Association Implementation Annotation</em>'.
     * @see abapmapping.AbapAssociationImplementationAnnotation
     * @generated
     */
	EClass getAbapAssociationImplementationAnnotation();

	/**
     * Returns the meta object for class '{@link abapmapping.AbapAssociationEndImplementationAnnotation <em>Abap Association End Implementation Annotation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abap Association End Implementation Annotation</em>'.
     * @see abapmapping.AbapAssociationEndImplementationAnnotation
     * @generated
     */
	EClass getAbapAssociationEndImplementationAnnotation();

	/**
     * Returns the meta object for class '{@link abapmapping.AbapSignatureImplementationAnnotation <em>Abap Signature Implementation Annotation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abap Signature Implementation Annotation</em>'.
     * @see abapmapping.AbapSignatureImplementationAnnotation
     * @generated
     */
	EClass getAbapSignatureImplementationAnnotation();

	/**
     * Returns the meta object for the attribute '{@link abapmapping.AbapSignatureImplementationAnnotation#getKind <em>Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see abapmapping.AbapSignatureImplementationAnnotation#getKind()
     * @see #getAbapSignatureImplementationAnnotation()
     * @generated
     */
	EAttribute getAbapSignatureImplementationAnnotation_Kind();

	/**
     * Returns the meta object for enum '{@link abapmapping.AbapClassKind <em>Abap Class Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Abap Class Kind</em>'.
     * @see abapmapping.AbapClassKind
     * @generated
     */
	EEnum getAbapClassKind();

	/**
     * Returns the meta object for enum '{@link abapmapping.AbapSignatureKind <em>Abap Signature Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Abap Signature Kind</em>'.
     * @see abapmapping.AbapSignatureKind
     * @generated
     */
	EEnum getAbapSignatureKind();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	AbapmappingFactory getAbapmappingFactory();

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
         * The meta object literal for the '{@link abapmapping.impl.AbapClassImplementationAnnotationImpl <em>Abap Class Implementation Annotation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.impl.AbapClassImplementationAnnotationImpl
         * @see abapmapping.impl.AbapmappingPackageImpl#getAbapClassImplementationAnnotation()
         * @generated
         */
		EClass ABAP_CLASS_IMPLEMENTATION_ANNOTATION = eINSTANCE.getAbapClassImplementationAnnotation();

		/**
         * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ABAP_CLASS_IMPLEMENTATION_ANNOTATION__KIND = eINSTANCE.getAbapClassImplementationAnnotation_Kind();

		/**
         * The meta object literal for the '<em><b>Abap Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ABAP_CLASS_IMPLEMENTATION_ANNOTATION__ABAP_TYPE = eINSTANCE.getAbapClassImplementationAnnotation_AbapType();

		/**
         * The meta object literal for the '{@link abapmapping.impl.AbapAssociationImplementationAnnotationImpl <em>Abap Association Implementation Annotation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.impl.AbapAssociationImplementationAnnotationImpl
         * @see abapmapping.impl.AbapmappingPackageImpl#getAbapAssociationImplementationAnnotation()
         * @generated
         */
		EClass ABAP_ASSOCIATION_IMPLEMENTATION_ANNOTATION = eINSTANCE.getAbapAssociationImplementationAnnotation();

		/**
         * The meta object literal for the '{@link abapmapping.impl.AbapAssociationEndImplementationAnnotationImpl <em>Abap Association End Implementation Annotation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.impl.AbapAssociationEndImplementationAnnotationImpl
         * @see abapmapping.impl.AbapmappingPackageImpl#getAbapAssociationEndImplementationAnnotation()
         * @generated
         */
		EClass ABAP_ASSOCIATION_END_IMPLEMENTATION_ANNOTATION = eINSTANCE.getAbapAssociationEndImplementationAnnotation();

		/**
         * The meta object literal for the '{@link abapmapping.impl.AbapSignatureImplementationAnnotationImpl <em>Abap Signature Implementation Annotation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.impl.AbapSignatureImplementationAnnotationImpl
         * @see abapmapping.impl.AbapmappingPackageImpl#getAbapSignatureImplementationAnnotation()
         * @generated
         */
		EClass ABAP_SIGNATURE_IMPLEMENTATION_ANNOTATION = eINSTANCE.getAbapSignatureImplementationAnnotation();

		/**
         * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ABAP_SIGNATURE_IMPLEMENTATION_ANNOTATION__KIND = eINSTANCE.getAbapSignatureImplementationAnnotation_Kind();

		/**
         * The meta object literal for the '{@link abapmapping.AbapClassKind <em>Abap Class Kind</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.AbapClassKind
         * @see abapmapping.impl.AbapmappingPackageImpl#getAbapClassKind()
         * @generated
         */
		EEnum ABAP_CLASS_KIND = eINSTANCE.getAbapClassKind();

		/**
         * The meta object literal for the '{@link abapmapping.AbapSignatureKind <em>Abap Signature Kind</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.AbapSignatureKind
         * @see abapmapping.impl.AbapmappingPackageImpl#getAbapSignatureKind()
         * @generated
         */
		EEnum ABAP_SIGNATURE_KIND = eINSTANCE.getAbapSignatureKind();

	}

} //AbapmappingPackage
