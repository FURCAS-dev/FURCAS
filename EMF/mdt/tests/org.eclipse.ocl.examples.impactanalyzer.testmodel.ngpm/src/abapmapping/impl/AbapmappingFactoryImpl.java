/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbapmappingFactoryImpl.java,v 1.1 2011/02/07 17:16:11 auhl Exp $
 */
package abapmapping.impl;

import abapmapping.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class AbapmappingFactoryImpl extends EFactoryImpl implements AbapmappingFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static AbapmappingFactory init() {
        try {
            AbapmappingFactory theAbapmappingFactory = (AbapmappingFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/abapmapping.ecore"); 
            if (theAbapmappingFactory != null) {
                return theAbapmappingFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new AbapmappingFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapmappingFactoryImpl() {
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
            case AbapmappingPackage.ABAP_CLASS_IMPLEMENTATION_ANNOTATION: return createAbapClassImplementationAnnotation();
            case AbapmappingPackage.ABAP_ASSOCIATION_IMPLEMENTATION_ANNOTATION: return createAbapAssociationImplementationAnnotation();
            case AbapmappingPackage.ABAP_ASSOCIATION_END_IMPLEMENTATION_ANNOTATION: return createAbapAssociationEndImplementationAnnotation();
            case AbapmappingPackage.ABAP_SIGNATURE_IMPLEMENTATION_ANNOTATION: return createAbapSignatureImplementationAnnotation();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case AbapmappingPackage.ABAP_CLASS_KIND:
                return createAbapClassKindFromString(eDataType, initialValue);
            case AbapmappingPackage.ABAP_SIGNATURE_KIND:
                return createAbapSignatureKindFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case AbapmappingPackage.ABAP_CLASS_KIND:
                return convertAbapClassKindToString(eDataType, instanceValue);
            case AbapmappingPackage.ABAP_SIGNATURE_KIND:
                return convertAbapSignatureKindToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapClassImplementationAnnotation createAbapClassImplementationAnnotation() {
        AbapClassImplementationAnnotationImpl abapClassImplementationAnnotation = new AbapClassImplementationAnnotationImpl();
        return abapClassImplementationAnnotation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapAssociationImplementationAnnotation createAbapAssociationImplementationAnnotation() {
        AbapAssociationImplementationAnnotationImpl abapAssociationImplementationAnnotation = new AbapAssociationImplementationAnnotationImpl();
        return abapAssociationImplementationAnnotation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapAssociationEndImplementationAnnotation createAbapAssociationEndImplementationAnnotation() {
        AbapAssociationEndImplementationAnnotationImpl abapAssociationEndImplementationAnnotation = new AbapAssociationEndImplementationAnnotationImpl();
        return abapAssociationEndImplementationAnnotation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapSignatureImplementationAnnotation createAbapSignatureImplementationAnnotation() {
        AbapSignatureImplementationAnnotationImpl abapSignatureImplementationAnnotation = new AbapSignatureImplementationAnnotationImpl();
        return abapSignatureImplementationAnnotation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapClassKind createAbapClassKindFromString(EDataType eDataType, String initialValue) {
        AbapClassKind result = AbapClassKind.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertAbapClassKindToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapSignatureKind createAbapSignatureKindFromString(EDataType eDataType, String initialValue) {
        AbapSignatureKind result = AbapSignatureKind.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertAbapSignatureKindToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapmappingPackage getAbapmappingPackage() {
        return (AbapmappingPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static AbapmappingPackage getPackage() {
        return AbapmappingPackage.eINSTANCE;
    }

} //AbapmappingFactoryImpl
