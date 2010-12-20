/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.abapdictionary;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see abapmapping.abapdictionary.AbapdictionaryFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface AbapdictionaryPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "abapdictionary";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/abapmapping/abapdictionary.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "abapmapping.abapdictionary";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	AbapdictionaryPackage eINSTANCE = abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl.init();

	/**
     * The meta object id for the '{@link abapmapping.abapdictionary.impl.XsdTypeImpl <em>Xsd Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.abapdictionary.impl.XsdTypeImpl
     * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getXsdType()
     * @generated
     */
	int XSD_TYPE = 0;

	/**
     * The feature id for the '<em><b>Xsd Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int XSD_TYPE__XSD_TYPE = 0;

	/**
     * The feature id for the '<em><b>Length</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int XSD_TYPE__LENGTH = 1;

	/**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int XSD_TYPE__PATTERN = 2;

	/**
     * The feature id for the '<em><b>Total Digits</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int XSD_TYPE__TOTAL_DIGITS = 3;

	/**
     * The feature id for the '<em><b>Fraction Digits</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int XSD_TYPE__FRACTION_DIGITS = 4;

	/**
     * The number of structural features of the '<em>Xsd Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int XSD_TYPE_FEATURE_COUNT = 5;

	/**
     * The meta object id for the '{@link abapmapping.abapdictionary.impl.AbapTypeImpl <em>Abap Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.abapdictionary.impl.AbapTypeImpl
     * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getAbapType()
     * @generated
     */
	int ABAP_TYPE = 5;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_TYPE__NAME = 0;

	/**
     * The feature id for the '<em><b>Xsd Representation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_TYPE__XSD_REPRESENTATION = 1;

	/**
     * The number of structural features of the '<em>Abap Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_TYPE_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link abapmapping.abapdictionary.impl.UnstructuredAbapTypeImpl <em>Unstructured Abap Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.abapdictionary.impl.UnstructuredAbapTypeImpl
     * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getUnstructuredAbapType()
     * @generated
     */
	int UNSTRUCTURED_ABAP_TYPE = 1;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSTRUCTURED_ABAP_TYPE__NAME = ABAP_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Xsd Representation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSTRUCTURED_ABAP_TYPE__XSD_REPRESENTATION = ABAP_TYPE__XSD_REPRESENTATION;

	/**
     * The number of structural features of the '<em>Unstructured Abap Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int UNSTRUCTURED_ABAP_TYPE_FEATURE_COUNT = ABAP_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link abapmapping.abapdictionary.impl.CodeValueImpl <em>Code Value</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.abapdictionary.impl.CodeValueImpl
     * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getCodeValue()
     * @generated
     */
	int CODE_VALUE = 2;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CODE_VALUE__VALUE = 0;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CODE_VALUE__DESCRIPTION = 1;

	/**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CODE_VALUE__TYPE = 2;

	/**
     * The number of structural features of the '<em>Code Value</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CODE_VALUE_FEATURE_COUNT = 3;

	/**
     * The meta object id for the '{@link abapmapping.abapdictionary.impl.DataElementImpl <em>Data Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.abapdictionary.impl.DataElementImpl
     * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getDataElement()
     * @generated
     */
	int DATA_ELEMENT = 4;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_ELEMENT__NAME = UNSTRUCTURED_ABAP_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Xsd Representation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_ELEMENT__XSD_REPRESENTATION = UNSTRUCTURED_ABAP_TYPE__XSD_REPRESENTATION;

	/**
     * The feature id for the '<em><b>Abap Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_ELEMENT__ABAP_TYPE = UNSTRUCTURED_ABAP_TYPE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Data Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DATA_ELEMENT_FEATURE_COUNT = UNSTRUCTURED_ABAP_TYPE_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link abapmapping.abapdictionary.impl.CodeImpl <em>Code</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.abapdictionary.impl.CodeImpl
     * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getCode()
     * @generated
     */
	int CODE = 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CODE__NAME = DATA_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Xsd Representation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CODE__XSD_REPRESENTATION = DATA_ELEMENT__XSD_REPRESENTATION;

	/**
     * The feature id for the '<em><b>Abap Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CODE__ABAP_TYPE = DATA_ELEMENT__ABAP_TYPE;

	/**
     * The feature id for the '<em><b>Extensible</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CODE__EXTENSIBLE = DATA_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CODE__VALUES = DATA_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Code</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CODE_FEATURE_COUNT = DATA_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link abapmapping.abapdictionary.impl.AbapStructureTypeImpl <em>Abap Structure Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.abapdictionary.impl.AbapStructureTypeImpl
     * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getAbapStructureType()
     * @generated
     */
	int ABAP_STRUCTURE_TYPE = 6;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_STRUCTURE_TYPE__NAME = ABAP_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Xsd Representation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_STRUCTURE_TYPE__XSD_REPRESENTATION = ABAP_TYPE__XSD_REPRESENTATION;

	/**
     * The feature id for the '<em><b>Fields</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_STRUCTURE_TYPE__FIELDS = ABAP_TYPE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Abap Structure Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_STRUCTURE_TYPE_FEATURE_COUNT = ABAP_TYPE_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link abapmapping.abapdictionary.impl.AbapStructureFieldImpl <em>Abap Structure Field</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.abapdictionary.impl.AbapStructureFieldImpl
     * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getAbapStructureField()
     * @generated
     */
	int ABAP_STRUCTURE_FIELD = 7;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_STRUCTURE_FIELD__NAME = 0;

	/**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_STRUCTURE_FIELD__TYPE = 1;

	/**
     * The number of structural features of the '<em>Abap Structure Field</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_STRUCTURE_FIELD_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link abapmapping.abapdictionary.impl.AbapPrimtiveTypeImpl <em>Abap Primtive Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see abapmapping.abapdictionary.impl.AbapPrimtiveTypeImpl
     * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getAbapPrimtiveType()
     * @generated
     */
	int ABAP_PRIMTIVE_TYPE = 8;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_PRIMTIVE_TYPE__NAME = UNSTRUCTURED_ABAP_TYPE__NAME;

	/**
     * The feature id for the '<em><b>Xsd Representation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_PRIMTIVE_TYPE__XSD_REPRESENTATION = UNSTRUCTURED_ABAP_TYPE__XSD_REPRESENTATION;

	/**
     * The feature id for the '<em><b>Length</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_PRIMTIVE_TYPE__LENGTH = UNSTRUCTURED_ABAP_TYPE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Abap Primtive Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABAP_PRIMTIVE_TYPE_FEATURE_COUNT = UNSTRUCTURED_ABAP_TYPE_FEATURE_COUNT + 1;


	/**
     * Returns the meta object for class '{@link abapmapping.abapdictionary.XsdType <em>Xsd Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Xsd Type</em>'.
     * @see abapmapping.abapdictionary.XsdType
     * @generated
     */
	EClass getXsdType();

	/**
     * Returns the meta object for the attribute '{@link abapmapping.abapdictionary.XsdType#getXsdType <em>Xsd Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xsd Type</em>'.
     * @see abapmapping.abapdictionary.XsdType#getXsdType()
     * @see #getXsdType()
     * @generated
     */
	EAttribute getXsdType_XsdType();

	/**
     * Returns the meta object for the attribute '{@link abapmapping.abapdictionary.XsdType#getLength <em>Length</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Length</em>'.
     * @see abapmapping.abapdictionary.XsdType#getLength()
     * @see #getXsdType()
     * @generated
     */
	EAttribute getXsdType_Length();

	/**
     * Returns the meta object for the attribute '{@link abapmapping.abapdictionary.XsdType#getPattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pattern</em>'.
     * @see abapmapping.abapdictionary.XsdType#getPattern()
     * @see #getXsdType()
     * @generated
     */
	EAttribute getXsdType_Pattern();

	/**
     * Returns the meta object for the attribute '{@link abapmapping.abapdictionary.XsdType#getTotalDigits <em>Total Digits</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Total Digits</em>'.
     * @see abapmapping.abapdictionary.XsdType#getTotalDigits()
     * @see #getXsdType()
     * @generated
     */
	EAttribute getXsdType_TotalDigits();

	/**
     * Returns the meta object for the attribute '{@link abapmapping.abapdictionary.XsdType#getFractionDigits <em>Fraction Digits</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Fraction Digits</em>'.
     * @see abapmapping.abapdictionary.XsdType#getFractionDigits()
     * @see #getXsdType()
     * @generated
     */
	EAttribute getXsdType_FractionDigits();

	/**
     * Returns the meta object for class '{@link abapmapping.abapdictionary.UnstructuredAbapType <em>Unstructured Abap Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Unstructured Abap Type</em>'.
     * @see abapmapping.abapdictionary.UnstructuredAbapType
     * @generated
     */
	EClass getUnstructuredAbapType();

	/**
     * Returns the meta object for class '{@link abapmapping.abapdictionary.CodeValue <em>Code Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Code Value</em>'.
     * @see abapmapping.abapdictionary.CodeValue
     * @generated
     */
	EClass getCodeValue();

	/**
     * Returns the meta object for the attribute '{@link abapmapping.abapdictionary.CodeValue#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see abapmapping.abapdictionary.CodeValue#getValue()
     * @see #getCodeValue()
     * @generated
     */
	EAttribute getCodeValue_Value();

	/**
     * Returns the meta object for the containment reference '{@link abapmapping.abapdictionary.CodeValue#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Description</em>'.
     * @see abapmapping.abapdictionary.CodeValue#getDescription()
     * @see #getCodeValue()
     * @generated
     */
	EReference getCodeValue_Description();

	/**
     * Returns the meta object for the reference '{@link abapmapping.abapdictionary.CodeValue#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type</em>'.
     * @see abapmapping.abapdictionary.CodeValue#getType()
     * @see #getCodeValue()
     * @generated
     */
	EReference getCodeValue_Type();

	/**
     * Returns the meta object for class '{@link abapmapping.abapdictionary.Code <em>Code</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Code</em>'.
     * @see abapmapping.abapdictionary.Code
     * @generated
     */
	EClass getCode();

	/**
     * Returns the meta object for the attribute '{@link abapmapping.abapdictionary.Code#isExtensible <em>Extensible</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Extensible</em>'.
     * @see abapmapping.abapdictionary.Code#isExtensible()
     * @see #getCode()
     * @generated
     */
	EAttribute getCode_Extensible();

	/**
     * Returns the meta object for the containment reference list '{@link abapmapping.abapdictionary.Code#getValues <em>Values</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Values</em>'.
     * @see abapmapping.abapdictionary.Code#getValues()
     * @see #getCode()
     * @generated
     */
	EReference getCode_Values();

	/**
     * Returns the meta object for class '{@link abapmapping.abapdictionary.DataElement <em>Data Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Element</em>'.
     * @see abapmapping.abapdictionary.DataElement
     * @generated
     */
	EClass getDataElement();

	/**
     * Returns the meta object for the reference '{@link abapmapping.abapdictionary.DataElement#getAbapType <em>Abap Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Abap Type</em>'.
     * @see abapmapping.abapdictionary.DataElement#getAbapType()
     * @see #getDataElement()
     * @generated
     */
	EReference getDataElement_AbapType();

	/**
     * Returns the meta object for class '{@link abapmapping.abapdictionary.AbapType <em>Abap Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abap Type</em>'.
     * @see abapmapping.abapdictionary.AbapType
     * @generated
     */
	EClass getAbapType();

	/**
     * Returns the meta object for the attribute '{@link abapmapping.abapdictionary.AbapType#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see abapmapping.abapdictionary.AbapType#getName()
     * @see #getAbapType()
     * @generated
     */
	EAttribute getAbapType_Name();

	/**
     * Returns the meta object for the reference '{@link abapmapping.abapdictionary.AbapType#getXsdRepresentation <em>Xsd Representation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Xsd Representation</em>'.
     * @see abapmapping.abapdictionary.AbapType#getXsdRepresentation()
     * @see #getAbapType()
     * @generated
     */
	EReference getAbapType_XsdRepresentation();

	/**
     * Returns the meta object for class '{@link abapmapping.abapdictionary.AbapStructureType <em>Abap Structure Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abap Structure Type</em>'.
     * @see abapmapping.abapdictionary.AbapStructureType
     * @generated
     */
	EClass getAbapStructureType();

	/**
     * Returns the meta object for the reference list '{@link abapmapping.abapdictionary.AbapStructureType#getFields <em>Fields</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Fields</em>'.
     * @see abapmapping.abapdictionary.AbapStructureType#getFields()
     * @see #getAbapStructureType()
     * @generated
     */
	EReference getAbapStructureType_Fields();

	/**
     * Returns the meta object for class '{@link abapmapping.abapdictionary.AbapStructureField <em>Abap Structure Field</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abap Structure Field</em>'.
     * @see abapmapping.abapdictionary.AbapStructureField
     * @generated
     */
	EClass getAbapStructureField();

	/**
     * Returns the meta object for the attribute '{@link abapmapping.abapdictionary.AbapStructureField#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see abapmapping.abapdictionary.AbapStructureField#getName()
     * @see #getAbapStructureField()
     * @generated
     */
	EAttribute getAbapStructureField_Name();

	/**
     * Returns the meta object for the reference '{@link abapmapping.abapdictionary.AbapStructureField#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type</em>'.
     * @see abapmapping.abapdictionary.AbapStructureField#getType()
     * @see #getAbapStructureField()
     * @generated
     */
	EReference getAbapStructureField_Type();

	/**
     * Returns the meta object for class '{@link abapmapping.abapdictionary.AbapPrimtiveType <em>Abap Primtive Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abap Primtive Type</em>'.
     * @see abapmapping.abapdictionary.AbapPrimtiveType
     * @generated
     */
	EClass getAbapPrimtiveType();

	/**
     * Returns the meta object for the attribute '{@link abapmapping.abapdictionary.AbapPrimtiveType#getLength <em>Length</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Length</em>'.
     * @see abapmapping.abapdictionary.AbapPrimtiveType#getLength()
     * @see #getAbapPrimtiveType()
     * @generated
     */
	EAttribute getAbapPrimtiveType_Length();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	AbapdictionaryFactory getAbapdictionaryFactory();

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
         * The meta object literal for the '{@link abapmapping.abapdictionary.impl.XsdTypeImpl <em>Xsd Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.abapdictionary.impl.XsdTypeImpl
         * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getXsdType()
         * @generated
         */
		EClass XSD_TYPE = eINSTANCE.getXsdType();

		/**
         * The meta object literal for the '<em><b>Xsd Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute XSD_TYPE__XSD_TYPE = eINSTANCE.getXsdType_XsdType();

		/**
         * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute XSD_TYPE__LENGTH = eINSTANCE.getXsdType_Length();

		/**
         * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute XSD_TYPE__PATTERN = eINSTANCE.getXsdType_Pattern();

		/**
         * The meta object literal for the '<em><b>Total Digits</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute XSD_TYPE__TOTAL_DIGITS = eINSTANCE.getXsdType_TotalDigits();

		/**
         * The meta object literal for the '<em><b>Fraction Digits</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute XSD_TYPE__FRACTION_DIGITS = eINSTANCE.getXsdType_FractionDigits();

		/**
         * The meta object literal for the '{@link abapmapping.abapdictionary.impl.UnstructuredAbapTypeImpl <em>Unstructured Abap Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.abapdictionary.impl.UnstructuredAbapTypeImpl
         * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getUnstructuredAbapType()
         * @generated
         */
		EClass UNSTRUCTURED_ABAP_TYPE = eINSTANCE.getUnstructuredAbapType();

		/**
         * The meta object literal for the '{@link abapmapping.abapdictionary.impl.CodeValueImpl <em>Code Value</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.abapdictionary.impl.CodeValueImpl
         * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getCodeValue()
         * @generated
         */
		EClass CODE_VALUE = eINSTANCE.getCodeValue();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CODE_VALUE__VALUE = eINSTANCE.getCodeValue_Value();

		/**
         * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CODE_VALUE__DESCRIPTION = eINSTANCE.getCodeValue_Description();

		/**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CODE_VALUE__TYPE = eINSTANCE.getCodeValue_Type();

		/**
         * The meta object literal for the '{@link abapmapping.abapdictionary.impl.CodeImpl <em>Code</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.abapdictionary.impl.CodeImpl
         * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getCode()
         * @generated
         */
		EClass CODE = eINSTANCE.getCode();

		/**
         * The meta object literal for the '<em><b>Extensible</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute CODE__EXTENSIBLE = eINSTANCE.getCode_Extensible();

		/**
         * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CODE__VALUES = eINSTANCE.getCode_Values();

		/**
         * The meta object literal for the '{@link abapmapping.abapdictionary.impl.DataElementImpl <em>Data Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.abapdictionary.impl.DataElementImpl
         * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getDataElement()
         * @generated
         */
		EClass DATA_ELEMENT = eINSTANCE.getDataElement();

		/**
         * The meta object literal for the '<em><b>Abap Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DATA_ELEMENT__ABAP_TYPE = eINSTANCE.getDataElement_AbapType();

		/**
         * The meta object literal for the '{@link abapmapping.abapdictionary.impl.AbapTypeImpl <em>Abap Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.abapdictionary.impl.AbapTypeImpl
         * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getAbapType()
         * @generated
         */
		EClass ABAP_TYPE = eINSTANCE.getAbapType();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ABAP_TYPE__NAME = eINSTANCE.getAbapType_Name();

		/**
         * The meta object literal for the '<em><b>Xsd Representation</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ABAP_TYPE__XSD_REPRESENTATION = eINSTANCE.getAbapType_XsdRepresentation();

		/**
         * The meta object literal for the '{@link abapmapping.abapdictionary.impl.AbapStructureTypeImpl <em>Abap Structure Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.abapdictionary.impl.AbapStructureTypeImpl
         * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getAbapStructureType()
         * @generated
         */
		EClass ABAP_STRUCTURE_TYPE = eINSTANCE.getAbapStructureType();

		/**
         * The meta object literal for the '<em><b>Fields</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ABAP_STRUCTURE_TYPE__FIELDS = eINSTANCE.getAbapStructureType_Fields();

		/**
         * The meta object literal for the '{@link abapmapping.abapdictionary.impl.AbapStructureFieldImpl <em>Abap Structure Field</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.abapdictionary.impl.AbapStructureFieldImpl
         * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getAbapStructureField()
         * @generated
         */
		EClass ABAP_STRUCTURE_FIELD = eINSTANCE.getAbapStructureField();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ABAP_STRUCTURE_FIELD__NAME = eINSTANCE.getAbapStructureField_Name();

		/**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ABAP_STRUCTURE_FIELD__TYPE = eINSTANCE.getAbapStructureField_Type();

		/**
         * The meta object literal for the '{@link abapmapping.abapdictionary.impl.AbapPrimtiveTypeImpl <em>Abap Primtive Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see abapmapping.abapdictionary.impl.AbapPrimtiveTypeImpl
         * @see abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl#getAbapPrimtiveType()
         * @generated
         */
		EClass ABAP_PRIMTIVE_TYPE = eINSTANCE.getAbapPrimtiveType();

		/**
         * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ABAP_PRIMTIVE_TYPE__LENGTH = eINSTANCE.getAbapPrimtiveType_Length();

	}

} //AbapdictionaryPackage
