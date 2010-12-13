/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.query.util;

import data.classes.InScope;
import data.classes.TypedElement;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ObjectBasedExpression;

import dataaccess.query.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see dataaccess.query.QueryPackage
 * @generated
 */
public class QueryAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static QueryPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public QueryAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = QueryPackage.eINSTANCE;
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
	protected QuerySwitch<Adapter> modelSwitch =
		new QuerySwitch<Adapter>() {
            @Override
            public Adapter caseSelection(Selection object) {
                return createSelectionAdapter();
            }
            @Override
            public Adapter caseOqlQuery(OqlQuery object) {
                return createOqlQueryAdapter();
            }
            @Override
            public Adapter caseFromClause(FromClause object) {
                return createFromClauseAdapter();
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
     * Creates a new adapter for an object of class '{@link dataaccess.query.Selection <em>Selection</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.query.Selection
     * @generated
     */
	public Adapter createSelectionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.query.OqlQuery <em>Oql Query</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.query.OqlQuery
     * @generated
     */
	public Adapter createOqlQueryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.query.FromClause <em>From Clause</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.query.FromClause
     * @generated
     */
	public Adapter createFromClauseAdapter() {
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

} //QueryAdapterFactory
