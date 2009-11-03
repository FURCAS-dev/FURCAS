/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.oslo.ocl20.syntax.ast.qvt.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QvtFactoryImpl extends EFactoryImpl implements QvtFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QvtPackage.COLLECTION_TEMPLATE_AS: return createCollectionTemplateAS();
			case QvtPackage.DOMAIN_AS: return createDomainAS();
			case QvtPackage.KEY_DECLARATION_AS: return createKeyDeclarationAS();
			case QvtPackage.MEMBER_SELECTION_EXPRESSION_AS: return createMemberSelectionExpressionAS();
			case QvtPackage.MODEL_DECLARATION_AS: return createModelDeclarationAS();
			case QvtPackage.OBJECT_TEMPLATE_AS: return createObjectTemplateAS();
			case QvtPackage.PARAMETER_DECLARATION_AS: return createParameterDeclarationAS();
			case QvtPackage.PRIMITIVE_DOMAIN_AS: return createPrimitiveDomainAS();
			case QvtPackage.PROPERTY_TEMPLATE_AS: return createPropertyTemplateAS();
			case QvtPackage.QUERY_AS: return createQueryAS();
			case QvtPackage.RELATION_AS: return createRelationAS();
			case QvtPackage.SET_COMPREHENSION_EXPRESSION_AS: return createSetComprehensionExpressionAS();
			case QvtPackage.TEMPLATE_AS: return createTemplateAS();
			case QvtPackage.TOP_LEVEL_AS: return createTopLevelAS();
			case QvtPackage.TRANSFORMATION_AS: return createTransformationAS();
			case QvtPackage.VARIABLE_DECLARATION_AS: return createVariableDeclarationAS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case QvtPackage.EXECUTION_KIND_AS: {
				ExecutionKindAS result = ExecutionKindAS.get(initialValue);
				if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
				return result;
			}
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case QvtPackage.EXECUTION_KIND_AS:
				return instanceValue == null ? null : instanceValue.toString();
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionTemplateAS createCollectionTemplateAS() {
		CollectionTemplateASImpl collectionTemplateAS = new CollectionTemplateASImpl();
		return collectionTemplateAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainAS createDomainAS() {
		DomainASImpl domainAS = new DomainASImpl();
		return domainAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyDeclarationAS createKeyDeclarationAS() {
		KeyDeclarationASImpl keyDeclarationAS = new KeyDeclarationASImpl();
		return keyDeclarationAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemberSelectionExpressionAS createMemberSelectionExpressionAS() {
		MemberSelectionExpressionASImpl memberSelectionExpressionAS = new MemberSelectionExpressionASImpl();
		return memberSelectionExpressionAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelDeclarationAS createModelDeclarationAS() {
		ModelDeclarationASImpl modelDeclarationAS = new ModelDeclarationASImpl();
		return modelDeclarationAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateAS createObjectTemplateAS() {
		ObjectTemplateASImpl objectTemplateAS = new ObjectTemplateASImpl();
		return objectTemplateAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDeclarationAS createParameterDeclarationAS() {
		ParameterDeclarationASImpl parameterDeclarationAS = new ParameterDeclarationASImpl();
		return parameterDeclarationAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveDomainAS createPrimitiveDomainAS() {
		PrimitiveDomainASImpl primitiveDomainAS = new PrimitiveDomainASImpl();
		return primitiveDomainAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyTemplateAS createPropertyTemplateAS() {
		PropertyTemplateASImpl propertyTemplateAS = new PropertyTemplateASImpl();
		return propertyTemplateAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryAS createQueryAS() {
		QueryASImpl queryAS = new QueryASImpl();
		return queryAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationAS createRelationAS() {
		RelationASImpl relationAS = new RelationASImpl();
		return relationAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetComprehensionExpressionAS createSetComprehensionExpressionAS() {
		SetComprehensionExpressionASImpl setComprehensionExpressionAS = new SetComprehensionExpressionASImpl();
		return setComprehensionExpressionAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateAS createTemplateAS() {
		TemplateASImpl templateAS = new TemplateASImpl();
		return templateAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopLevelAS createTopLevelAS() {
		TopLevelASImpl topLevelAS = new TopLevelASImpl();
		return topLevelAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationAS createTransformationAS() {
		TransformationASImpl transformationAS = new TransformationASImpl();
		return transformationAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclarationAS createVariableDeclarationAS() {
		VariableDeclarationASImpl variableDeclarationAS = new VariableDeclarationASImpl();
		return variableDeclarationAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtPackage getQvtPackage() {
		return (QvtPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static QvtPackage getPackage() {
		return QvtPackage.eINSTANCE;
	}

} //QvtFactoryImpl
