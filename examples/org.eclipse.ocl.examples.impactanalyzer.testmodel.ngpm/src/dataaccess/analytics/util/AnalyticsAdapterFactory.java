/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalyticsAdapterFactory.java,v 1.1 2011/02/07 16:53:52 auhl Exp $
 */
package dataaccess.analytics.util;

import data.classes.FunctionSignatureImplementation;
import data.classes.InScope;
import data.classes.SignatureImplementation;
import data.classes.TypedElement;

import dataaccess.analytics.*;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ObjectBasedExpression;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see dataaccess.analytics.AnalyticsPackage
 * @generated
 */
public class AnalyticsAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static AnalyticsPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AnalyticsAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = AnalyticsPackage.eINSTANCE;
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
	protected AnalyticsSwitch<Adapter> modelSwitch =
		new AnalyticsSwitch<Adapter>() {
            @Override
            public Adapter caseDimension(Dimension object) {
                return createDimensionAdapter();
            }
            @Override
            public Adapter caseCellSet(CellSet object) {
                return createCellSetAdapter();
            }
            @Override
            public Adapter caseDimensionExpression(DimensionExpression object) {
                return createDimensionExpressionAdapter();
            }
            @Override
            public Adapter caseGroupBy(GroupBy object) {
                return createGroupByAdapter();
            }
            @Override
            public Adapter caseDimensionDefinition(DimensionDefinition object) {
                return createDimensionDefinitionAdapter();
            }
            @Override
            public Adapter caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
            }
            @Override
            public Adapter caseSignatureImplementation(SignatureImplementation object) {
                return createSignatureImplementationAdapter();
            }
            @Override
            public Adapter caseFunctionSignatureImplementation(FunctionSignatureImplementation object) {
                return createFunctionSignatureImplementationAdapter();
            }
            @Override
            public Adapter caseTypedElement(TypedElement object) {
                return createTypedElementAdapter();
            }
            @Override
            public Adapter caseInScope(InScope object) {
                return createInScopeAdapter();
            }
            @Override
            public Adapter caseExpression(Expression object) {
                return createExpressionAdapter();
            }
            @Override
            public Adapter caseObjectBasedExpression(ObjectBasedExpression object) {
                return createObjectBasedExpressionAdapter();
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
     * Creates a new adapter for an object of class '{@link dataaccess.analytics.Dimension <em>Dimension</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.analytics.Dimension
     * @generated
     */
	public Adapter createDimensionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.analytics.CellSet <em>Cell Set</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.analytics.CellSet
     * @generated
     */
	public Adapter createCellSetAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.analytics.DimensionExpression <em>Dimension Expression</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.analytics.DimensionExpression
     * @generated
     */
	public Adapter createDimensionExpressionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.analytics.GroupBy <em>Group By</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.analytics.GroupBy
     * @generated
     */
	public Adapter createGroupByAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.analytics.DimensionDefinition <em>Dimension Definition</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.analytics.DimensionDefinition
     * @generated
     */
	public Adapter createDimensionDefinitionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link modelmanagement.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see modelmanagement.NamedElement
     * @generated
     */
	public Adapter createNamedElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.SignatureImplementation <em>Signature Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.SignatureImplementation
     * @generated
     */
	public Adapter createSignatureImplementationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.FunctionSignatureImplementation <em>Function Signature Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.FunctionSignatureImplementation
     * @generated
     */
	public Adapter createFunctionSignatureImplementationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.TypedElement <em>Typed Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.TypedElement
     * @generated
     */
	public Adapter createTypedElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link data.classes.InScope <em>In Scope</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.InScope
     * @generated
     */
	public Adapter createInScopeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.Expression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.Expression
     * @generated
     */
	public Adapter createExpressionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.ObjectBasedExpression <em>Object Based Expression</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.ObjectBasedExpression
     * @generated
     */
	public Adapter createObjectBasedExpressionAdapter() {
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

} //AnalyticsAdapterFactory
