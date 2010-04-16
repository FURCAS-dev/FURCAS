/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLinEcoreCSTAdapterFactory.java,v 1.2 2010/04/16 18:05:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.*;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeOrEnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EAttributeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EDataTypeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EObjectRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EReferenceRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumLiteralCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ImportCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ObjectRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage
 * @generated
 */
public class OCLinEcoreCSTAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OCLinEcoreCSTPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLinEcoreCSTAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = OCLinEcoreCSTPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCLinEcoreCSTSwitch<Adapter> modelSwitch =
		new OCLinEcoreCSTSwitch<Adapter>() {
			@Override
			public Adapter caseAnnotationCS(AnnotationCS object) {
				return createAnnotationCSAdapter();
			}
			@Override
			public Adapter caseAnnotationElementCS(AnnotationElementCS object) {
				return createAnnotationElementCSAdapter();
			}
			@Override
			public Adapter caseAttributeCS(AttributeCS object) {
				return createAttributeCSAdapter();
			}
			@Override
			public Adapter caseAttributeCSRef(AttributeCSRef object) {
				return createAttributeCSRefAdapter();
			}
			@Override
			public Adapter caseAttributeRef(AttributeRef object) {
				return createAttributeRefAdapter();
			}
			@Override
			public Adapter caseClassCS(ClassCS object) {
				return createClassCSAdapter();
			}
			@Override
			public Adapter caseClassCSRef(ClassCSRef object) {
				return createClassCSRefAdapter();
			}
			@Override
			public Adapter caseClassRef(ClassRef object) {
				return createClassRefAdapter();
			}
			@Override
			public Adapter caseClassifierCS(ClassifierCS object) {
				return createClassifierCSAdapter();
			}
			@Override
			public Adapter caseConstraintCS(ConstraintCS object) {
				return createConstraintCSAdapter();
			}
			@Override
			public Adapter caseDataTypeRef(DataTypeRef object) {
				return createDataTypeRefAdapter();
			}
			@Override
			public Adapter caseDataTypeCS(DataTypeCS object) {
				return createDataTypeCSAdapter();
			}
			@Override
			public Adapter caseDataTypeOrEnumCS(DataTypeOrEnumCS object) {
				return createDataTypeOrEnumCSAdapter();
			}
			@Override
			public Adapter caseDataTypeCSRef(DataTypeCSRef object) {
				return createDataTypeCSRefAdapter();
			}
			@Override
			public Adapter caseDetailCS(DetailCS object) {
				return createDetailCSAdapter();
			}
			@Override
			public Adapter caseDocumentCS(DocumentCS object) {
				return createDocumentCSAdapter();
			}
			@Override
			public Adapter caseDocumentationCS(DocumentationCS object) {
				return createDocumentationCSAdapter();
			}
			@Override
			public Adapter caseEAttributeRef(EAttributeRef object) {
				return createEAttributeRefAdapter();
			}
			@Override
			public Adapter caseEClassRef(EClassRef object) {
				return createEClassRefAdapter();
			}
			@Override
			public Adapter caseEClassifierCSRef(EClassifierCSRef object) {
				return createEClassifierCSRefAdapter();
			}
			@Override
			public Adapter caseEClassifierRef(EClassifierRef object) {
				return createEClassifierRefAdapter();
			}
			@Override
			public Adapter caseEDataTypeRef(EDataTypeRef object) {
				return createEDataTypeRefAdapter();
			}
			@Override
			public Adapter caseEObjectRef(EObjectRef object) {
				return createEObjectRefAdapter();
			}
			@Override
			public Adapter caseEReferenceRef(EReferenceRef object) {
				return createEReferenceRefAdapter();
			}
			@Override
			public Adapter caseEnumCS(EnumCS object) {
				return createEnumCSAdapter();
			}
			@Override
			public Adapter caseEnumLiteralCS(EnumLiteralCS object) {
				return createEnumLiteralCSAdapter();
			}
			@Override
			public Adapter caseImportCS(ImportCS object) {
				return createImportCSAdapter();
			}
			@Override
			public Adapter caseModelElementCS(ModelElementCS object) {
				return createModelElementCSAdapter();
			}
			@Override
			public Adapter caseModelElementCSRef(ModelElementCSRef object) {
				return createModelElementCSRefAdapter();
			}
			@Override
			public Adapter caseNamedElementCS(NamedElementCS object) {
				return createNamedElementCSAdapter();
			}
			@Override
			public Adapter caseObjectRef(ObjectRef object) {
				return createObjectRefAdapter();
			}
			@Override
			public Adapter caseOperationCS(OperationCS object) {
				return createOperationCSAdapter();
			}
			@Override
			public Adapter casePackageCS(PackageCS object) {
				return createPackageCSAdapter();
			}
			@Override
			public Adapter caseParameterCS(ParameterCS object) {
				return createParameterCSAdapter();
			}
			@Override
			public Adapter caseReferenceCS(ReferenceCS object) {
				return createReferenceCSAdapter();
			}
			@Override
			public Adapter caseReferenceCSRef(ReferenceCSRef object) {
				return createReferenceCSRefAdapter();
			}
			@Override
			public Adapter caseReferenceRef(ReferenceRef object) {
				return createReferenceRefAdapter();
			}
			@Override
			public Adapter caseStructuralFeatureCS(StructuralFeatureCS object) {
				return createStructuralFeatureCSAdapter();
			}
			@Override
			public Adapter caseTypeCS(TypeCS object) {
				return createTypeCSAdapter();
			}
			@Override
			public Adapter caseTypeCSRef(TypeCSRef object) {
				return createTypeCSRefAdapter();
			}
			@Override
			public Adapter caseTypeParameterCS(TypeParameterCS object) {
				return createTypeParameterCSAdapter();
			}
			@Override
			public Adapter caseTypeRef(TypeRef object) {
				return createTypeRefAdapter();
			}
			@Override
			public Adapter caseTypeRefCS(TypeRefCS object) {
				return createTypeRefCSAdapter();
			}
			@Override
			public Adapter caseTypedElementCS(TypedElementCS object) {
				return createTypedElementCSAdapter();
			}
			@Override
			public Adapter caseTypedTypeRefCS(TypedTypeRefCS object) {
				return createTypedTypeRefCSAdapter();
			}
			@Override
			public Adapter caseWildcardTypeRefCS(WildcardTypeRefCS object) {
				return createWildcardTypeRefCSAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS <em>Annotation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS
	 * @generated
	 */
	public Adapter createAnnotationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationElementCS <em>Annotation Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationElementCS
	 * @generated
	 */
	public Adapter createAnnotationElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCS <em>Attribute CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCS
	 * @generated
	 */
	public Adapter createAttributeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCSRef <em>Attribute CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCSRef
	 * @generated
	 */
	public Adapter createAttributeCSRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeRef <em>Attribute Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeRef
	 * @generated
	 */
	public Adapter createAttributeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS <em>Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS
	 * @generated
	 */
	public Adapter createClassCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCSRef <em>Class CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCSRef
	 * @generated
	 */
	public Adapter createClassCSRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassRef <em>Class Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassRef
	 * @generated
	 */
	public Adapter createClassRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS <em>Classifier CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS
	 * @generated
	 */
	public Adapter createClassifierCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS <em>Document CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS
	 * @generated
	 */
	public Adapter createDocumentCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS <em>Documentation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS
	 * @generated
	 */
	public Adapter createDocumentationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EAttributeRef <em>EAttribute Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EAttributeRef
	 * @generated
	 */
	public Adapter createEAttributeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassRef <em>EClass Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassRef
	 * @generated
	 */
	public Adapter createEClassRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef <em>EClassifier CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef
	 * @generated
	 */
	public Adapter createEClassifierCSRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierRef <em>EClassifier Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierRef
	 * @generated
	 */
	public Adapter createEClassifierRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EDataTypeRef <em>EData Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EDataTypeRef
	 * @generated
	 */
	public Adapter createEDataTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EObjectRef <em>EObject Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EObjectRef
	 * @generated
	 */
	public Adapter createEObjectRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EReferenceRef <em>EReference Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EReferenceRef
	 * @generated
	 */
	public Adapter createEReferenceRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS <em>Enum CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS
	 * @generated
	 */
	public Adapter createEnumCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumLiteralCS <em>Enum Literal CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumLiteralCS
	 * @generated
	 */
	public Adapter createEnumLiteralCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ImportCS <em>Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ImportCS
	 * @generated
	 */
	public Adapter createImportCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCS <em>Model Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCS
	 * @generated
	 */
	public Adapter createModelElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCSRef <em>Model Element CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCSRef
	 * @generated
	 */
	public Adapter createModelElementCSRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.NamedElementCS <em>Named Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.NamedElementCS
	 * @generated
	 */
	public Adapter createNamedElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ObjectRef <em>Object Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ObjectRef
	 * @generated
	 */
	public Adapter createObjectRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS <em>Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS
	 * @generated
	 */
	public Adapter createOperationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS <em>Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS
	 * @generated
	 */
	public Adapter createPackageCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ParameterCS <em>Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ParameterCS
	 * @generated
	 */
	public Adapter createParameterCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCS <em>Reference CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCS
	 * @generated
	 */
	public Adapter createReferenceCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCSRef <em>Reference CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCSRef
	 * @generated
	 */
	public Adapter createReferenceCSRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceRef <em>Reference Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceRef
	 * @generated
	 */
	public Adapter createReferenceRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS <em>Structural Feature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS
	 * @generated
	 */
	public Adapter createStructuralFeatureCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCS
	 * @generated
	 */
	public Adapter createTypeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCSRef <em>Type CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCSRef
	 * @generated
	 */
	public Adapter createTypeCSRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS <em>Typed Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS
	 * @generated
	 */
	public Adapter createTypedElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedTypeRefCS <em>Typed Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedTypeRefCS
	 * @generated
	 */
	public Adapter createTypedTypeRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.WildcardTypeRefCS <em>Wildcard Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.WildcardTypeRefCS
	 * @generated
	 */
	public Adapter createWildcardTypeRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeParameterCS <em>Type Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeParameterCS
	 * @generated
	 */
	public Adapter createTypeParameterCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRef
	 * @generated
	 */
	public Adapter createTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRefCS <em>Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRefCS
	 * @generated
	 */
	public Adapter createTypeRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS <em>Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS
	 * @generated
	 */
	public Adapter createConstraintCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeRef <em>Data Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeRef
	 * @generated
	 */
	public Adapter createDataTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS <em>Data Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS
	 * @generated
	 */
	public Adapter createDataTypeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeOrEnumCS <em>Data Type Or Enum CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeOrEnumCS
	 * @generated
	 */
	public Adapter createDataTypeOrEnumCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCSRef <em>Data Type CS Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCSRef
	 * @generated
	 */
	public Adapter createDataTypeCSRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS <em>Detail CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS
	 * @generated
	 */
	public Adapter createDetailCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //OCLinEcoreCSTAdapterFactory
