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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.DomainAS;
import org.oslo.ocl20.syntax.ast.qvt.ExecutionKindAS;
import org.oslo.ocl20.syntax.ast.qvt.Factory;
import org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS;
import org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.ObjectTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.ParameterDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.PrimitiveDomainAS;
import org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.QueryAS;
import org.oslo.ocl20.syntax.ast.qvt.RelationAS;
import org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS;
import org.oslo.ocl20.syntax.ast.qvt.TemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.TopLevelAS;
import org.oslo.ocl20.syntax.ast.qvt.TransformationAS;
import org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class FactoryImpl extends EFactoryImpl implements Factory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Factory init() {
		try {
			Factory theFactory = (Factory) EPackage.Registry.INSTANCE.getEFactory("urn:ast.qvt.ecore");
			if (theFactory != null) {
				return theFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case org.oslo.ocl20.syntax.ast.qvt.Package.COLLECTION_TEMPLATE_AS:
			return this.createCollectionTemplateAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.DOMAIN_AS:
			return this.createDomainAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.KEY_DECLARATION_AS:
			return this.createKeyDeclarationAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.MEMBER_SELECTION_EXPRESSION_AS:
			return this.createMemberSelectionExpressionAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.MODEL_DECLARATION_AS:
			return this.createModelDeclarationAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.OBJECT_TEMPLATE_AS:
			return this.createObjectTemplateAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.PARAMETER_DECLARATION_AS:
			return this.createParameterDeclarationAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.PRIMITIVE_DOMAIN_AS:
			return this.createPrimitiveDomainAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.PROPERTY_TEMPLATE_AS:
			return this.createPropertyTemplateAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.QUERY_AS:
			return this.createQueryAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.RELATION_AS:
			return this.createRelationAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.SET_COMPREHENSION_EXPRESSION_AS:
			return this.createSetComprehensionExpressionAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.TEMPLATE_AS:
			return this.createTemplateAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.TOP_LEVEL_AS:
			return this.createTopLevelAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.TRANSFORMATION_AS:
			return this.createTransformationAS();
		case org.oslo.ocl20.syntax.ast.qvt.Package.VARIABLE_DECLARATION_AS:
			return this.createVariableDeclarationAS();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case org.oslo.ocl20.syntax.ast.qvt.Package.EXECUTION_KIND_AS:
			return this.createExecutionKindASFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case org.oslo.ocl20.syntax.ast.qvt.Package.EXECUTION_KIND_AS:
			return this.convertExecutionKindASToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionTemplateAS createCollectionTemplateAS() {
		CollectionTemplateASImpl collectionTemplateAS = new CollectionTemplateASImpl();
		return collectionTemplateAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DomainAS createDomainAS() {
		DomainASImpl domainAS = new DomainASImpl();
		return domainAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public KeyDeclarationAS createKeyDeclarationAS() {
		KeyDeclarationASImpl keyDeclarationAS = new KeyDeclarationASImpl();
		return keyDeclarationAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MemberSelectionExpressionAS createMemberSelectionExpressionAS() {
		MemberSelectionExpressionASImpl memberSelectionExpressionAS = new MemberSelectionExpressionASImpl();
		return memberSelectionExpressionAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelDeclarationAS createModelDeclarationAS() {
		ModelDeclarationASImpl modelDeclarationAS = new ModelDeclarationASImpl();
		return modelDeclarationAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ObjectTemplateAS createObjectTemplateAS() {
		ObjectTemplateASImpl objectTemplateAS = new ObjectTemplateASImpl();
		return objectTemplateAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ParameterDeclarationAS createParameterDeclarationAS() {
		ParameterDeclarationASImpl parameterDeclarationAS = new ParameterDeclarationASImpl();
		return parameterDeclarationAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimitiveDomainAS createPrimitiveDomainAS() {
		PrimitiveDomainASImpl primitiveDomainAS = new PrimitiveDomainASImpl();
		return primitiveDomainAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PropertyTemplateAS createPropertyTemplateAS() {
		PropertyTemplateASImpl propertyTemplateAS = new PropertyTemplateASImpl();
		return propertyTemplateAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QueryAS createQueryAS() {
		QueryASImpl queryAS = new QueryASImpl();
		return queryAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RelationAS createRelationAS() {
		RelationASImpl relationAS = new RelationASImpl();
		return relationAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SetComprehensionExpressionAS createSetComprehensionExpressionAS() {
		SetComprehensionExpressionASImpl setComprehensionExpressionAS = new SetComprehensionExpressionASImpl();
		return setComprehensionExpressionAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TemplateAS createTemplateAS() {
		TemplateASImpl templateAS = new TemplateASImpl();
		return templateAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TopLevelAS createTopLevelAS() {
		TopLevelASImpl topLevelAS = new TopLevelASImpl();
		return topLevelAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TransformationAS createTransformationAS() {
		TransformationASImpl transformationAS = new TransformationASImpl();
		return transformationAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariableDeclarationAS createVariableDeclarationAS() {
		VariableDeclarationASImpl variableDeclarationAS = new VariableDeclarationASImpl();
		return variableDeclarationAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExecutionKindAS createExecutionKindASFromString(EDataType eDataType, String initialValue) {
		ExecutionKindAS result = ExecutionKindAS.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertExecutionKindASToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.oslo.ocl20.syntax.ast.qvt.Package getPackage() {
		return (org.oslo.ocl20.syntax.ast.qvt.Package) this.getEPackage();
	}

} // FactoryImpl
