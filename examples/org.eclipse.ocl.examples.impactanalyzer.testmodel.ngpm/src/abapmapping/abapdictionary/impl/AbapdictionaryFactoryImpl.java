/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbapdictionaryFactoryImpl.java,v 1.1 2011/02/07 16:43:30 auhl Exp $
 */
package abapmapping.abapdictionary.impl;

import abapmapping.abapdictionary.*;

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
public class AbapdictionaryFactoryImpl extends EFactoryImpl implements AbapdictionaryFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static AbapdictionaryFactory init() {
        try {
            AbapdictionaryFactory theAbapdictionaryFactory = (AbapdictionaryFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/abapmapping/abapdictionary.ecore"); 
            if (theAbapdictionaryFactory != null) {
                return theAbapdictionaryFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new AbapdictionaryFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapdictionaryFactoryImpl() {
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
            case AbapdictionaryPackage.XSD_TYPE: return createXsdType();
            case AbapdictionaryPackage.UNSTRUCTURED_ABAP_TYPE: return createUnstructuredAbapType();
            case AbapdictionaryPackage.CODE_VALUE: return createCodeValue();
            case AbapdictionaryPackage.CODE: return createCode();
            case AbapdictionaryPackage.DATA_ELEMENT: return createDataElement();
            case AbapdictionaryPackage.ABAP_TYPE: return createAbapType();
            case AbapdictionaryPackage.ABAP_STRUCTURE_TYPE: return createAbapStructureType();
            case AbapdictionaryPackage.ABAP_STRUCTURE_FIELD: return createAbapStructureField();
            case AbapdictionaryPackage.ABAP_PRIMTIVE_TYPE: return createAbapPrimtiveType();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public XsdType createXsdType() {
        XsdTypeImpl xsdType = new XsdTypeImpl();
        return xsdType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public UnstructuredAbapType createUnstructuredAbapType() {
        UnstructuredAbapTypeImpl unstructuredAbapType = new UnstructuredAbapTypeImpl();
        return unstructuredAbapType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CodeValue createCodeValue() {
        CodeValueImpl codeValue = new CodeValueImpl();
        return codeValue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Code createCode() {
        CodeImpl code = new CodeImpl();
        return code;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DataElement createDataElement() {
        DataElementImpl dataElement = new DataElementImpl();
        return dataElement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapType createAbapType() {
        AbapTypeImpl abapType = new AbapTypeImpl();
        return abapType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapStructureType createAbapStructureType() {
        AbapStructureTypeImpl abapStructureType = new AbapStructureTypeImpl();
        return abapStructureType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapStructureField createAbapStructureField() {
        AbapStructureFieldImpl abapStructureField = new AbapStructureFieldImpl();
        return abapStructureField;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapPrimtiveType createAbapPrimtiveType() {
        AbapPrimtiveTypeImpl abapPrimtiveType = new AbapPrimtiveTypeImpl();
        return abapPrimtiveType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapdictionaryPackage getAbapdictionaryPackage() {
        return (AbapdictionaryPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static AbapdictionaryPackage getPackage() {
        return AbapdictionaryPackage.eINSTANCE;
    }

} //AbapdictionaryFactoryImpl
