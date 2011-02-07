/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActionsAdapterFactory.java,v 1.1 2011/02/07 16:47:39 auhl Exp $
 */
package behavioral.actions.util;

import behavioral.actions.*;

import data.classes.FunctionSignatureImplementation;
import data.classes.InScope;
import data.classes.NamedValue;
import data.classes.SignatureImplementation;
import data.classes.TypedElement;

import dataaccess.expressions.Conditional;
import dataaccess.expressions.WithArgument;

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
 * @see behavioral.actions.ActionsPackage
 * @generated
 */
public class ActionsAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static ActionsPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ActionsAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ActionsPackage.eINSTANCE;
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
	protected ActionsSwitch<Adapter> modelSwitch =
		new ActionsSwitch<Adapter>() {
            @Override
            public Adapter caseAssignment(Assignment object) {
                return createAssignmentAdapter();
            }
            @Override
            public Adapter caseStatement(Statement object) {
                return createStatementAdapter();
            }
            @Override
            public Adapter caseBlock(Block object) {
                return createBlockAdapter();
            }
            @Override
            public Adapter caseIfElse(IfElse object) {
                return createIfElseAdapter();
            }
            @Override
            public Adapter caseWhileLoop(WhileLoop object) {
                return createWhileLoopAdapter();
            }
            @Override
            public Adapter caseForeach(Foreach object) {
                return createForeachAdapter();
            }
            @Override
            public Adapter caseReturn(Return object) {
                return createReturnAdapter();
            }
            @Override
            public Adapter caseAddLink(AddLink object) {
                return createAddLinkAdapter();
            }
            @Override
            public Adapter caseRemoveLink(RemoveLink object) {
                return createRemoveLinkAdapter();
            }
            @Override
            public Adapter caseLinkManipulationStatement(LinkManipulationStatement object) {
                return createLinkManipulationStatementAdapter();
            }
            @Override
            public Adapter caseExpressionStatement(ExpressionStatement object) {
                return createExpressionStatementAdapter();
            }
            @Override
            public Adapter caseSort(Sort object) {
                return createSortAdapter();
            }
            @Override
            public Adapter caseQueryInvocation(QueryInvocation object) {
                return createQueryInvocationAdapter();
            }
            @Override
            public Adapter caseConstant(Constant object) {
                return createConstantAdapter();
            }
            @Override
            public Adapter caseVariable(Variable object) {
                return createVariableAdapter();
            }
            @Override
            public Adapter caseIterator(Iterator object) {
                return createIteratorAdapter();
            }
            @Override
            public Adapter caseNamedValueDeclaration(NamedValueDeclaration object) {
                return createNamedValueDeclarationAdapter();
            }
            @Override
            public Adapter caseStatementWithNestedBlocks(StatementWithNestedBlocks object) {
                return createStatementWithNestedBlocksAdapter();
            }
            @Override
            public Adapter caseSingleBlockStatement(SingleBlockStatement object) {
                return createSingleBlockStatementAdapter();
            }
            @Override
            public Adapter caseStatementWithArgument(StatementWithArgument object) {
                return createStatementWithArgumentAdapter();
            }
            @Override
            public Adapter caseNamedValueWithOptionalInitExpression(NamedValueWithOptionalInitExpression object) {
                return createNamedValueWithOptionalInitExpressionAdapter();
            }
            @Override
            public Adapter caseConditionalStatement(ConditionalStatement object) {
                return createConditionalStatementAdapter();
            }
            @Override
            public Adapter caseInScope(InScope object) {
                return createInScopeAdapter();
            }
            @Override
            public Adapter caseWithArgument(WithArgument object) {
                return createWithArgumentAdapter();
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
            public Adapter caseConditional(Conditional object) {
                return createConditionalAdapter();
            }
            @Override
            public Adapter caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
            }
            @Override
            public Adapter caseTypedElement(TypedElement object) {
                return createTypedElementAdapter();
            }
            @Override
            public Adapter caseNamedValue(NamedValue object) {
                return createNamedValueAdapter();
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
     * Creates a new adapter for an object of class '{@link behavioral.actions.Assignment <em>Assignment</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.Assignment
     * @generated
     */
	public Adapter createAssignmentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.Statement <em>Statement</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.Statement
     * @generated
     */
	public Adapter createStatementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.Block <em>Block</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.Block
     * @generated
     */
	public Adapter createBlockAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.IfElse <em>If Else</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.IfElse
     * @generated
     */
	public Adapter createIfElseAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.WhileLoop <em>While Loop</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.WhileLoop
     * @generated
     */
	public Adapter createWhileLoopAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.Foreach <em>Foreach</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.Foreach
     * @generated
     */
	public Adapter createForeachAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.Return <em>Return</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.Return
     * @generated
     */
	public Adapter createReturnAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.AddLink <em>Add Link</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.AddLink
     * @generated
     */
	public Adapter createAddLinkAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.RemoveLink <em>Remove Link</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.RemoveLink
     * @generated
     */
	public Adapter createRemoveLinkAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.LinkManipulationStatement <em>Link Manipulation Statement</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.LinkManipulationStatement
     * @generated
     */
	public Adapter createLinkManipulationStatementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.ExpressionStatement <em>Expression Statement</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.ExpressionStatement
     * @generated
     */
	public Adapter createExpressionStatementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.Sort <em>Sort</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.Sort
     * @generated
     */
	public Adapter createSortAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.QueryInvocation <em>Query Invocation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.QueryInvocation
     * @generated
     */
	public Adapter createQueryInvocationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.Constant <em>Constant</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.Constant
     * @generated
     */
	public Adapter createConstantAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.Variable <em>Variable</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.Variable
     * @generated
     */
	public Adapter createVariableAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.Iterator <em>Iterator</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.Iterator
     * @generated
     */
	public Adapter createIteratorAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.NamedValueDeclaration <em>Named Value Declaration</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.NamedValueDeclaration
     * @generated
     */
	public Adapter createNamedValueDeclarationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.StatementWithNestedBlocks <em>Statement With Nested Blocks</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.StatementWithNestedBlocks
     * @generated
     */
	public Adapter createStatementWithNestedBlocksAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.SingleBlockStatement <em>Single Block Statement</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.SingleBlockStatement
     * @generated
     */
	public Adapter createSingleBlockStatementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.StatementWithArgument <em>Statement With Argument</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.StatementWithArgument
     * @generated
     */
	public Adapter createStatementWithArgumentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.NamedValueWithOptionalInitExpression <em>Named Value With Optional Init Expression</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.NamedValueWithOptionalInitExpression
     * @generated
     */
	public Adapter createNamedValueWithOptionalInitExpressionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.actions.ConditionalStatement <em>Conditional Statement</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.actions.ConditionalStatement
     * @generated
     */
	public Adapter createConditionalStatementAdapter() {
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
     * Creates a new adapter for an object of class '{@link data.classes.NamedValue <em>Named Value</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see data.classes.NamedValue
     * @generated
     */
	public Adapter createNamedValueAdapter() {
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

} //ActionsAdapterFactory
