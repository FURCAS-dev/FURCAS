/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.syntax.ast.Visitable;

import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

import org.oslo.ocl20.syntax.ast.qvt.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.oslo.ocl20.syntax.ast.qvt.Package
 * @generated
 */
public class AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static org.oslo.ocl20.syntax.ast.qvt.Package modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = org.oslo.ocl20.syntax.ast.qvt.Package.eINSTANCE;
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
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Switch modelSwitch =
		new Switch() {
			public Object caseCollectionTemplateAS(CollectionTemplateAS object) {
				return createCollectionTemplateASAdapter();
			}
			public Object caseDomainAS(DomainAS object) {
				return createDomainASAdapter();
			}
			public Object caseGeneralDomainAS(GeneralDomainAS object) {
				return createGeneralDomainASAdapter();
			}
			public Object caseKeyDeclarationAS(KeyDeclarationAS object) {
				return createKeyDeclarationASAdapter();
			}
			public Object caseMemberSelectionExpressionAS(MemberSelectionExpressionAS object) {
				return createMemberSelectionExpressionASAdapter();
			}
			public Object caseModelDeclarationAS(ModelDeclarationAS object) {
				return createModelDeclarationASAdapter();
			}
			public Object caseObjectTemplateAS(ObjectTemplateAS object) {
				return createObjectTemplateASAdapter();
			}
			public Object caseParameterDeclarationAS(ParameterDeclarationAS object) {
				return createParameterDeclarationASAdapter();
			}
			public Object casePrimitiveDomainAS(PrimitiveDomainAS object) {
				return createPrimitiveDomainASAdapter();
			}
			public Object casePropertyTemplateAS(PropertyTemplateAS object) {
				return createPropertyTemplateASAdapter();
			}
			public Object caseQueryAS(QueryAS object) {
				return createQueryASAdapter();
			}
			public Object caseRelationAS(RelationAS object) {
				return createRelationASAdapter();
			}
			public Object caseSetComprehensionExpressionAS(SetComprehensionExpressionAS object) {
				return createSetComprehensionExpressionASAdapter();
			}
			public Object caseTemplateAS(TemplateAS object) {
				return createTemplateASAdapter();
			}
			public Object caseTopLevelAS(TopLevelAS object) {
				return createTopLevelASAdapter();
			}
			public Object caseTransformationAS(TransformationAS object) {
				return createTransformationASAdapter();
			}
			public Object caseVariableDeclarationAS(VariableDeclarationAS object) {
				return createVariableDeclarationASAdapter();
			}
			public Object caseVisitable(Visitable object) {
				return createVisitableAdapter();
			}
			public Object caseOclExpressionAS(OclExpressionAS object) {
				return createOclExpressionASAdapter();
			}
			public Object defaultCase(EObject object) {
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
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS <em>Collection Template AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS
	 * @generated
	 */
	public Adapter createCollectionTemplateASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS <em>Domain AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.DomainAS
	 * @generated
	 */
	public Adapter createDomainASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.GeneralDomainAS <em>General Domain AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.GeneralDomainAS
	 * @generated
	 */
	public Adapter createGeneralDomainASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS <em>Key Declaration AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS
	 * @generated
	 */
	public Adapter createKeyDeclarationASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS <em>Member Selection Expression AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS
	 * @generated
	 */
	public Adapter createMemberSelectionExpressionASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS <em>Model Declaration AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS
	 * @generated
	 */
	public Adapter createModelDeclarationASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.ObjectTemplateAS <em>Object Template AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.ObjectTemplateAS
	 * @generated
	 */
	public Adapter createObjectTemplateASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.ParameterDeclarationAS <em>Parameter Declaration AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.ParameterDeclarationAS
	 * @generated
	 */
	public Adapter createParameterDeclarationASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.PrimitiveDomainAS <em>Primitive Domain AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.PrimitiveDomainAS
	 * @generated
	 */
	public Adapter createPrimitiveDomainASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS <em>Property Template AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS
	 * @generated
	 */
	public Adapter createPropertyTemplateASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.QueryAS <em>Query AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.QueryAS
	 * @generated
	 */
	public Adapter createQueryASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS <em>Relation AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.RelationAS
	 * @generated
	 */
	public Adapter createRelationASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS <em>Set Comprehension Expression AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS
	 * @generated
	 */
	public Adapter createSetComprehensionExpressionASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.TemplateAS <em>Template AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TemplateAS
	 * @generated
	 */
	public Adapter createTemplateASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.TopLevelAS <em>Top Level AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TopLevelAS
	 * @generated
	 */
	public Adapter createTopLevelASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS <em>Transformation AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TransformationAS
	 * @generated
	 */
	public Adapter createTransformationASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS <em>Variable Declaration AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS
	 * @generated
	 */
	public Adapter createVariableDeclarationASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.Visitable
	 * @generated
	 */
	public Adapter createVisitableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS <em>Ocl Expression AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS
	 * @generated
	 */
	public Adapter createOclExpressionASAdapter() {
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

} //AdapterFactory
