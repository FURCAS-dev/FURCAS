/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary.util;

import com.sap.tc.moin.repository.mmi.Model.Classifier;
import com.sap.tc.moin.repository.mmi.Model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.Model.ModelElement;
import com.sap.tc.moin.repository.mmi.Model.Namespace;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.omg.OCL.StdLibrary.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage
 * @generated
 */
public class StdLibraryAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StdLibraryPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StdLibraryAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StdLibraryPackage.eINSTANCE;
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
	protected StdLibrarySwitch<Adapter> modelSwitch =
		new StdLibrarySwitch<Adapter>() {
			@Override
			public Adapter caseOclAnyStdLib(OclAnyStdLib object) {
				return createOclAnyStdLibAdapter();
			}
			@Override
			public Adapter caseStringStdLib(StringStdLib object) {
				return createStringStdLibAdapter();
			}
			@Override
			public Adapter caseBooleanStdLib(BooleanStdLib object) {
				return createBooleanStdLibAdapter();
			}
			@Override
			public Adapter caseFloatStdLib(FloatStdLib object) {
				return createFloatStdLibAdapter();
			}
			@Override
			public Adapter caseCollectionTypeStdLib(CollectionTypeStdLib object) {
				return createCollectionTypeStdLibAdapter();
			}
			@Override
			public Adapter caseSetTypeStdLib(SetTypeStdLib object) {
				return createSetTypeStdLibAdapter();
			}
			@Override
			public Adapter caseSequenceTypeStdLib(SequenceTypeStdLib object) {
				return createSequenceTypeStdLibAdapter();
			}
			@Override
			public Adapter caseBagTypeStdLib(BagTypeStdLib object) {
				return createBagTypeStdLibAdapter();
			}
			@Override
			public Adapter caseOrderedSetTypeStdLib(OrderedSetTypeStdLib object) {
				return createOrderedSetTypeStdLibAdapter();
			}
			@Override
			public Adapter caseOclVoidStdLib(OclVoidStdLib object) {
				return createOclVoidStdLibAdapter();
			}
			@Override
			public Adapter caseIntegerStdLib(IntegerStdLib object) {
				return createIntegerStdLibAdapter();
			}
			@Override
			public Adapter caseOclTypeStdLib(OclTypeStdLib object) {
				return createOclTypeStdLibAdapter();
			}
			@Override
			public Adapter caseTupleTypeStdLib(TupleTypeStdLib object) {
				return createTupleTypeStdLibAdapter();
			}
			@Override
			public Adapter caseDoubleStdLib(DoubleStdLib object) {
				return createDoubleStdLibAdapter();
			}
			@Override
			public Adapter caseLongStdLib(LongStdLib object) {
				return createLongStdLibAdapter();
			}
			@Override
			public Adapter caseOclInvalidStdLib(OclInvalidStdLib object) {
				return createOclInvalidStdLibAdapter();
			}
			@Override
			public Adapter caseModelElement(ModelElement object) {
				return createModelElementAdapter();
			}
			@Override
			public Adapter caseNamespace(Namespace object) {
				return createNamespaceAdapter();
			}
			@Override
			public Adapter caseGeneralizableElement(GeneralizableElement object) {
				return createGeneralizableElementAdapter();
			}
			@Override
			public Adapter caseClassifier(Classifier object) {
				return createClassifierAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.OclAnyStdLib <em>Ocl Any Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.OclAnyStdLib
	 * @generated
	 */
	public Adapter createOclAnyStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.StringStdLib <em>String Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.StringStdLib
	 * @generated
	 */
	public Adapter createStringStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.BooleanStdLib <em>Boolean Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.BooleanStdLib
	 * @generated
	 */
	public Adapter createBooleanStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.FloatStdLib <em>Float Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.FloatStdLib
	 * @generated
	 */
	public Adapter createFloatStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.CollectionTypeStdLib <em>Collection Type Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.CollectionTypeStdLib
	 * @generated
	 */
	public Adapter createCollectionTypeStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.SetTypeStdLib <em>Set Type Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.SetTypeStdLib
	 * @generated
	 */
	public Adapter createSetTypeStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.SequenceTypeStdLib <em>Sequence Type Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.SequenceTypeStdLib
	 * @generated
	 */
	public Adapter createSequenceTypeStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.BagTypeStdLib <em>Bag Type Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.BagTypeStdLib
	 * @generated
	 */
	public Adapter createBagTypeStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.OrderedSetTypeStdLib <em>Ordered Set Type Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.OrderedSetTypeStdLib
	 * @generated
	 */
	public Adapter createOrderedSetTypeStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.OclVoidStdLib <em>Ocl Void Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.OclVoidStdLib
	 * @generated
	 */
	public Adapter createOclVoidStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.IntegerStdLib <em>Integer Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.IntegerStdLib
	 * @generated
	 */
	public Adapter createIntegerStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.OclTypeStdLib <em>Ocl Type Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.OclTypeStdLib
	 * @generated
	 */
	public Adapter createOclTypeStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.TupleTypeStdLib <em>Tuple Type Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.TupleTypeStdLib
	 * @generated
	 */
	public Adapter createTupleTypeStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.DoubleStdLib <em>Double Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.DoubleStdLib
	 * @generated
	 */
	public Adapter createDoubleStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.LongStdLib <em>Long Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.LongStdLib
	 * @generated
	 */
	public Adapter createLongStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.omg.OCL.StdLibrary.OclInvalidStdLib <em>Ocl Invalid Std Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.omg.OCL.StdLibrary.OclInvalidStdLib
	 * @generated
	 */
	public Adapter createOclInvalidStdLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.sap.tc.moin.repository.mmi.Model.ModelElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelElement
	 * @generated
	 */
	public Adapter createModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.sap.tc.moin.repository.mmi.Model.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.sap.tc.moin.repository.mmi.Model.Namespace
	 * @generated
	 */
	public Adapter createNamespaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.sap.tc.moin.repository.mmi.Model.GeneralizableElement <em>Generalizable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.sap.tc.moin.repository.mmi.Model.GeneralizableElement
	 * @generated
	 */
	public Adapter createGeneralizableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.sap.tc.moin.repository.mmi.Model.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.sap.tc.moin.repository.mmi.Model.Classifier
	 * @generated
	 */
	public Adapter createClassifierAdapter() {
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

} //StdLibraryAdapterFactory
