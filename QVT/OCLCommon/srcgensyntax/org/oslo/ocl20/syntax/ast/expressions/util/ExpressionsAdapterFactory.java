/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.syntax.ast.Visitable;

import org.oslo.ocl20.syntax.ast.expressions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpressionsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExpressionsPackage.eINSTANCE;
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
	protected ExpressionsSwitch modelSwitch =
		new ExpressionsSwitch() {
			public Object caseAndExpAS(AndExpAS object) {
				return createAndExpASAdapter();
			}
			public Object caseArrowSelectionExpAS(ArrowSelectionExpAS object) {
				return createArrowSelectionExpASAdapter();
			}
			public Object caseAssociationCallExpAS(AssociationCallExpAS object) {
				return createAssociationCallExpASAdapter();
			}
			public Object caseBooleanLiteralExpAS(BooleanLiteralExpAS object) {
				return createBooleanLiteralExpASAdapter();
			}
			public Object caseCallExpAS(CallExpAS object) {
				return createCallExpASAdapter();
			}
			public Object caseCollectionItemAS(CollectionItemAS object) {
				return createCollectionItemASAdapter();
			}
			public Object caseCollectionLiteralExpAS(CollectionLiteralExpAS object) {
				return createCollectionLiteralExpASAdapter();
			}
			public Object caseCollectionLiteralPartAS(CollectionLiteralPartAS object) {
				return createCollectionLiteralPartASAdapter();
			}
			public Object caseCollectionRangeAS(CollectionRangeAS object) {
				return createCollectionRangeASAdapter();
			}
			public Object caseDotSelectionExpAS(DotSelectionExpAS object) {
				return createDotSelectionExpASAdapter();
			}
			public Object caseEnumLiteralExpAS(EnumLiteralExpAS object) {
				return createEnumLiteralExpASAdapter();
			}
			public Object caseIfExpAS(IfExpAS object) {
				return createIfExpASAdapter();
			}
			public Object caseImpliesExpAS(ImpliesExpAS object) {
				return createImpliesExpASAdapter();
			}
			public Object caseIntegerLiteralExpAS(IntegerLiteralExpAS object) {
				return createIntegerLiteralExpASAdapter();
			}
			public Object caseIterateExpAS(IterateExpAS object) {
				return createIterateExpASAdapter();
			}
			public Object caseIteratorExpAS(IteratorExpAS object) {
				return createIteratorExpASAdapter();
			}
			public Object caseLetExpAS(LetExpAS object) {
				return createLetExpASAdapter();
			}
			public Object caseLiteralExpAS(LiteralExpAS object) {
				return createLiteralExpASAdapter();
			}
			public Object caseLogicalExpAS(LogicalExpAS object) {
				return createLogicalExpASAdapter();
			}
			public Object caseLoopExpAS(LoopExpAS object) {
				return createLoopExpASAdapter();
			}
			public Object caseNotExpAS(NotExpAS object) {
				return createNotExpASAdapter();
			}
			public Object caseOclExpressionAS(OclExpressionAS object) {
				return createOclExpressionASAdapter();
			}
			public Object caseOclMessageArgAS(OclMessageArgAS object) {
				return createOclMessageArgASAdapter();
			}
			public Object caseOclMessageExpAS(OclMessageExpAS object) {
				return createOclMessageExpASAdapter();
			}
			public Object caseOperationCallExpAS(OperationCallExpAS object) {
				return createOperationCallExpASAdapter();
			}
			public Object caseOrExpAS(OrExpAS object) {
				return createOrExpASAdapter();
			}
			public Object casePathNameExpAS(PathNameExpAS object) {
				return createPathNameExpASAdapter();
			}
			public Object casePrimaryExpAS(PrimaryExpAS object) {
				return createPrimaryExpASAdapter();
			}
			public Object casePrimitiveLiteralExpAS(PrimitiveLiteralExpAS object) {
				return createPrimitiveLiteralExpASAdapter();
			}
			public Object caseRealLiteralExpAS(RealLiteralExpAS object) {
				return createRealLiteralExpASAdapter();
			}
			public Object caseSelectionExpAS(SelectionExpAS object) {
				return createSelectionExpASAdapter();
			}
			public Object caseStringLiteralExpAS(StringLiteralExpAS object) {
				return createStringLiteralExpASAdapter();
			}
			public Object caseTupleLiteralExpAS(TupleLiteralExpAS object) {
				return createTupleLiteralExpASAdapter();
			}
			public Object caseXorExpAS(XorExpAS object) {
				return createXorExpASAdapter();
			}
			public Object caseVisitable(Visitable object) {
				return createVisitableAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.AndExpAS <em>And Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.AndExpAS
	 * @generated
	 */
	public Adapter createAndExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.ArrowSelectionExpAS <em>Arrow Selection Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.ArrowSelectionExpAS
	 * @generated
	 */
	public Adapter createArrowSelectionExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.AssociationCallExpAS <em>Association Call Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.AssociationCallExpAS
	 * @generated
	 */
	public Adapter createAssociationCallExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.BooleanLiteralExpAS <em>Boolean Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.BooleanLiteralExpAS
	 * @generated
	 */
	public Adapter createBooleanLiteralExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.CallExpAS <em>Call Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CallExpAS
	 * @generated
	 */
	public Adapter createCallExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionItemAS <em>Collection Item AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionItemAS
	 * @generated
	 */
	public Adapter createCollectionItemASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralExpAS <em>Collection Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralExpAS
	 * @generated
	 */
	public Adapter createCollectionLiteralExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralPartAS <em>Collection Literal Part AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralPartAS
	 * @generated
	 */
	public Adapter createCollectionLiteralPartASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionRangeAS <em>Collection Range AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionRangeAS
	 * @generated
	 */
	public Adapter createCollectionRangeASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.DotSelectionExpAS <em>Dot Selection Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.DotSelectionExpAS
	 * @generated
	 */
	public Adapter createDotSelectionExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.EnumLiteralExpAS <em>Enum Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.EnumLiteralExpAS
	 * @generated
	 */
	public Adapter createEnumLiteralExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.IfExpAS <em>If Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.IfExpAS
	 * @generated
	 */
	public Adapter createIfExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.ImpliesExpAS <em>Implies Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.ImpliesExpAS
	 * @generated
	 */
	public Adapter createImpliesExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.IntegerLiteralExpAS <em>Integer Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.IntegerLiteralExpAS
	 * @generated
	 */
	public Adapter createIntegerLiteralExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.IterateExpAS <em>Iterate Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.IterateExpAS
	 * @generated
	 */
	public Adapter createIterateExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.IteratorExpAS <em>Iterator Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.IteratorExpAS
	 * @generated
	 */
	public Adapter createIteratorExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.LetExpAS <em>Let Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LetExpAS
	 * @generated
	 */
	public Adapter createLetExpASAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.LogicalExpAS <em>Logical Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LogicalExpAS
	 * @generated
	 */
	public Adapter createLogicalExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS <em>Loop Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LoopExpAS
	 * @generated
	 */
	public Adapter createLoopExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.NotExpAS <em>Not Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.NotExpAS
	 * @generated
	 */
	public Adapter createNotExpASAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS <em>Ocl Message Arg AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS
	 * @generated
	 */
	public Adapter createOclMessageArgASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS <em>Ocl Message Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS
	 * @generated
	 */
	public Adapter createOclMessageExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.OperationCallExpAS <em>Operation Call Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OperationCallExpAS
	 * @generated
	 */
	public Adapter createOperationCallExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.OrExpAS <em>Or Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OrExpAS
	 * @generated
	 */
	public Adapter createOrExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.PathNameExpAS <em>Path Name Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.PathNameExpAS
	 * @generated
	 */
	public Adapter createPathNameExpASAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.PrimitiveLiteralExpAS <em>Primitive Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.PrimitiveLiteralExpAS
	 * @generated
	 */
	public Adapter createPrimitiveLiteralExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.RealLiteralExpAS <em>Real Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.RealLiteralExpAS
	 * @generated
	 */
	public Adapter createRealLiteralExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.SelectionExpAS <em>Selection Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.SelectionExpAS
	 * @generated
	 */
	public Adapter createSelectionExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.StringLiteralExpAS <em>String Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.StringLiteralExpAS
	 * @generated
	 */
	public Adapter createStringLiteralExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.TupleLiteralExpAS <em>Tuple Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.TupleLiteralExpAS
	 * @generated
	 */
	public Adapter createTupleLiteralExpASAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.oslo.ocl20.syntax.ast.expressions.XorExpAS <em>Xor Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.oslo.ocl20.syntax.ast.expressions.XorExpAS
	 * @generated
	 */
	public Adapter createXorExpASAdapter() {
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

} //ExpressionsAdapterFactory
