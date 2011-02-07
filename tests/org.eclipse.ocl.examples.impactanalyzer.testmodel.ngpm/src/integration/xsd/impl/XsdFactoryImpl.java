/**
 * <copyright>
 * </copyright>
 *
 * $Id: XsdFactoryImpl.java,v 1.1 2011/02/07 17:21:36 auhl Exp $
 */
package integration.xsd.impl;

import integration.xsd.*;

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
public class XsdFactoryImpl extends EFactoryImpl implements XsdFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static XsdFactory init() {
        try {
            XsdFactory theXsdFactory = (XsdFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/integration/xsd.ecore"); 
            if (theXsdFactory != null) {
                return theXsdFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new XsdFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public XsdFactoryImpl() {
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
            case XsdPackage.SEQUENCE: return createSequence();
            case XsdPackage.CHOICE: return createChoice();
            case XsdPackage.COMPLEX_TYPE: return createComplexType();
            case XsdPackage.ELEMENT_DEFINITION: return createElementDefinition();
            case XsdPackage.ATTRIBUTE: return createAttribute();
            case XsdPackage.ANY: return createAny();
            case XsdPackage.GROUP: return createGroup();
            case XsdPackage.ANNOTATION: return createAnnotation();
            case XsdPackage.NOTATION: return createNotation();
            case XsdPackage.SIMPLE_TYPE: return createSimpleType();
            case XsdPackage.ELEMENT_REFERENCE: return createElementReference();
            case XsdPackage.SIMPLE_CONTENT: return createSimpleContent();
            case XsdPackage.COMPLEX_CONTENT: return createComplexContent();
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
            case XsdPackage.ATT_USE_TYPE:
                return createAttUseTypeFromString(eDataType, initialValue);
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
            case XsdPackage.ATT_USE_TYPE:
                return convertAttUseTypeToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Sequence createSequence() {
        SequenceImpl sequence = new SequenceImpl();
        return sequence;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Choice createChoice() {
        ChoiceImpl choice = new ChoiceImpl();
        return choice;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ComplexType createComplexType() {
        ComplexTypeImpl complexType = new ComplexTypeImpl();
        return complexType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ElementDefinition createElementDefinition() {
        ElementDefinitionImpl elementDefinition = new ElementDefinitionImpl();
        return elementDefinition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Attribute createAttribute() {
        AttributeImpl attribute = new AttributeImpl();
        return attribute;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Any createAny() {
        AnyImpl any = new AnyImpl();
        return any;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Group createGroup() {
        GroupImpl group = new GroupImpl();
        return group;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Annotation createAnnotation() {
        AnnotationImpl annotation = new AnnotationImpl();
        return annotation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Notation createNotation() {
        NotationImpl notation = new NotationImpl();
        return notation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SimpleType createSimpleType() {
        SimpleTypeImpl simpleType = new SimpleTypeImpl();
        return simpleType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ElementReference createElementReference() {
        ElementReferenceImpl elementReference = new ElementReferenceImpl();
        return elementReference;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SimpleContent createSimpleContent() {
        SimpleContentImpl simpleContent = new SimpleContentImpl();
        return simpleContent;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ComplexContent createComplexContent() {
        ComplexContentImpl complexContent = new ComplexContentImpl();
        return complexContent;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AttUseType createAttUseTypeFromString(EDataType eDataType, String initialValue) {
        AttUseType result = AttUseType.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertAttUseTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public XsdPackage getXsdPackage() {
        return (XsdPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static XsdPackage getPackage() {
        return XsdPackage.eINSTANCE;
    }

} //XsdFactoryImpl
