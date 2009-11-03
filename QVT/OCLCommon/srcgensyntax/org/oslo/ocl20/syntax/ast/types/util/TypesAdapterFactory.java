/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.types.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.syntax.ast.Visitable;

import org.oslo.ocl20.syntax.ast.expressions.LiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;
import org.oslo.ocl20.syntax.ast.expressions.PrimaryExpAS;

import org.oslo.ocl20.syntax.ast.types.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.oslo.ocl20.syntax.ast.types.TypesPackage
 * @generated
 */
public class TypesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TypesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TypesPackage.eINSTANCE;
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
	protected TypesSwitch modelSwitch =
		new TypesSwitch() {
			public Object caseBagTypeAS(BagTypeAS object) {
				return createBagTypeASAdapter();
			}
			public Object caseClassifierAS(ClassifierAS object) {
				return createClassifierASAdapter();
			}
			public Object caseCollectionTypeAS(CollectionTypeAS object) {
				return createCollectionTypeASAdapter();
			}
			public Object caseOrderedSetTypeAS(OrderedSetTypeAS object) {
				return createOrderedSetTypeASAdapter();
			}
			public Object caseSequenceTypeAS(SequenceTypeAS object) {
				return createSequenceTypeASAdapter();
			}
			public Object caseSetTypeAS(SetTypeAS object) {
				return createSetTypeASAdapter();
			}
			public Object caseTupleTypeAS(TupleTypeAS object) {
				return createTupleTypeASAdapter();
			}
			public Object caseTypeAS(TypeAS object) {
				return createTypeASAdapter();
			}
			public Object caseVisitable(Visitable object) {
				return createVisitableAdapter();
			}
			public Object caseOclExpressionAS(OclExpressionAS object) {
				return createOclExpressionASAdapter();
			}
			public Object casePrimaryExpAS(PrimaryExpAS object) {
				return createPrimaryExpASAdapter();
			}
			public Object caseLiteralExpAS(LiteralExpAS object) {
				return createLiteralExpASAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.types.BagTypeAS <em>Bag Type AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.types.BagTypeAS
	 * @generated
	 */
	public Adapter createBagTypeASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.types.ClassifierAS <em>Classifier AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.types.ClassifierAS
	 * @generated
	 */
	public Adapter createClassifierASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.types.CollectionTypeAS <em>Collection Type AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.types.CollectionTypeAS
	 * @generated
	 */
	public Adapter createCollectionTypeASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.types.OrderedSetTypeAS <em>Ordered Set Type AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.types.OrderedSetTypeAS
	 * @generated
	 */
	public Adapter createOrderedSetTypeASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.types.SequenceTypeAS <em>Sequence Type AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.types.SequenceTypeAS
	 * @generated
	 */
	public Adapter createSequenceTypeASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.types.SetTypeAS <em>Set Type AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.types.SetTypeAS
	 * @generated
	 */
	public Adapter createSetTypeASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.types.TupleTypeAS <em>Tuple Type AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.types.TupleTypeAS
	 * @generated
	 */
	public Adapter createTupleTypeASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.types.TypeAS <em>Type AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.types.TypeAS
	 * @generated
	 */
	public Adapter createTypeASAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.PrimaryExpAS <em>Primary Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.PrimaryExpAS
	 * @generated
	 */
	public Adapter createPrimaryExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.LiteralExpAS <em>Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LiteralExpAS
	 * @generated
	 */
	public Adapter createLiteralExpASAdapter() {
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

} //TypesAdapterFactory
