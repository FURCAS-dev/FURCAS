/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExpressionsAdapterFactory.java,v 1.1 2011/02/07 17:20:42 auhl Exp $
 */
package dataaccess.expressions.util;

import data.classes.InScope;
import data.classes.TypedElement;

import dataaccess.expressions.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see dataaccess.expressions.ExpressionsPackage
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
	protected ExpressionsSwitch<Adapter> modelSwitch =
		new ExpressionsSwitch<Adapter>() {
            @Override
            public Adapter caseExpression(Expression object) {
                return createExpressionAdapter();
            }
            @Override
            public Adapter caseVariableExpression(VariableExpression object) {
                return createVariableExpressionAdapter();
            }
            @Override
            public Adapter caseMethodCallExpression(MethodCallExpression object) {
                return createMethodCallExpressionAdapter();
            }
            @Override
            public Adapter caseObjectBasedExpression(ObjectBasedExpression object) {
                return createObjectBasedExpressionAdapter();
            }
            @Override
            public Adapter caseObjectCreationExpression(ObjectCreationExpression object) {
                return createObjectCreationExpressionAdapter();
            }
            @Override
            public Adapter caseFunctionCallExpression(FunctionCallExpression object) {
                return createFunctionCallExpressionAdapter();
            }
            @Override
            public Adapter caseWithArgument(WithArgument object) {
                return createWithArgumentAdapter();
            }
            @Override
            public Adapter caseThis(This object) {
                return createThisAdapter();
            }
            @Override
            public Adapter caseEquals(Equals object) {
                return createEqualsAdapter();
            }
            @Override
            public Adapter caseAssociationEndNavigationExpression(AssociationEndNavigationExpression object) {
                return createAssociationEndNavigationExpressionAdapter();
            }
            @Override
            public Adapter caseSignatureCallExpression(SignatureCallExpression object) {
                return createSignatureCallExpressionAdapter();
            }
            @Override
            public Adapter caseObjectCount(ObjectCount object) {
                return createObjectCountAdapter();
            }
            @Override
            public Adapter caseReplace(Replace object) {
                return createReplaceAdapter();
            }
            @Override
            public Adapter caseNavigationStep(NavigationStep object) {
                return createNavigationStepAdapter();
            }
            @Override
            public Adapter caseHead(Head object) {
                return createHeadAdapter();
            }
            @Override
            public Adapter caseTail(Tail object) {
                return createTailAdapter();
            }
            @Override
            public Adapter caseAsList(AsList object) {
                return createAsListAdapter();
            }
            @Override
            public Adapter caseConditional(Conditional object) {
                return createConditionalAdapter();
            }
            @Override
            public Adapter caseTernary(Ternary object) {
                return createTernaryAdapter();
            }
            @Override
            public Adapter caseContentEquals(ContentEquals object) {
                return createContentEqualsAdapter();
            }
            @Override
            public Adapter caseExpressionWithArgument(ExpressionWithArgument object) {
                return createExpressionWithArgumentAdapter();
            }
            @Override
            public Adapter caseConditionalExpression(ConditionalExpression object) {
                return createConditionalExpressionAdapter();
            }
            @Override
            public Adapter caseMap(Map object) {
                return createMapAdapter();
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
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.VariableExpression <em>Variable Expression</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.VariableExpression
     * @generated
     */
	public Adapter createVariableExpressionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.MethodCallExpression <em>Method Call Expression</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.MethodCallExpression
     * @generated
     */
	public Adapter createMethodCallExpressionAdapter() {
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
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.ObjectCreationExpression <em>Object Creation Expression</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.ObjectCreationExpression
     * @generated
     */
	public Adapter createObjectCreationExpressionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.FunctionCallExpression <em>Function Call Expression</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.FunctionCallExpression
     * @generated
     */
	public Adapter createFunctionCallExpressionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.WithArgument <em>With Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.WithArgument
     * @generated
     */
	public Adapter createWithArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.This <em>This</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.This
     * @generated
     */
	public Adapter createThisAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.Equals <em>Equals</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.Equals
     * @generated
     */
	public Adapter createEqualsAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.AssociationEndNavigationExpression <em>Association End Navigation Expression</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.AssociationEndNavigationExpression
     * @generated
     */
	public Adapter createAssociationEndNavigationExpressionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.SignatureCallExpression <em>Signature Call Expression</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.SignatureCallExpression
     * @generated
     */
	public Adapter createSignatureCallExpressionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.ObjectCount <em>Object Count</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.ObjectCount
     * @generated
     */
	public Adapter createObjectCountAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.Replace <em>Replace</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.Replace
     * @generated
     */
	public Adapter createReplaceAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.NavigationStep <em>Navigation Step</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.NavigationStep
     * @generated
     */
	public Adapter createNavigationStepAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.Head <em>Head</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.Head
     * @generated
     */
	public Adapter createHeadAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.Tail <em>Tail</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.Tail
     * @generated
     */
	public Adapter createTailAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.AsList <em>As List</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.AsList
     * @generated
     */
	public Adapter createAsListAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.Conditional <em>Conditional</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.Conditional
     * @generated
     */
	public Adapter createConditionalAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.Ternary <em>Ternary</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.Ternary
     * @generated
     */
	public Adapter createTernaryAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.ContentEquals <em>Content Equals</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.ContentEquals
     * @generated
     */
	public Adapter createContentEqualsAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.ExpressionWithArgument <em>Expression With Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.ExpressionWithArgument
     * @generated
     */
	public Adapter createExpressionWithArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.ConditionalExpression <em>Conditional Expression</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.ConditionalExpression
     * @generated
     */
	public Adapter createConditionalExpressionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link dataaccess.expressions.Map <em>Map</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see dataaccess.expressions.Map
     * @generated
     */
	public Adapter createMapAdapter() {
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
