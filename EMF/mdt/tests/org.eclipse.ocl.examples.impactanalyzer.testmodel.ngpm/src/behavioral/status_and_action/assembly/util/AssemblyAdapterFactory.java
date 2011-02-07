/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssemblyAdapterFactory.java,v 1.1 2011/02/07 17:17:58 auhl Exp $
 */
package behavioral.status_and_action.assembly.util;

import behavioral.status_and_action.assembly.*;

import behavioral.status_and_action.design.AbstractAction;
import behavioral.status_and_action.design.AbstractStatusValue;
import behavioral.status_and_action.design.AbstractStatusVariable;
import behavioral.status_and_action.design.Action;
import behavioral.status_and_action.design.StatusValue;
import behavioral.status_and_action.design.StatusVariable;

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
 * @see behavioral.status_and_action.assembly.AssemblyPackage
 * @generated
 */
public class AssemblyAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static AssemblyPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssemblyAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = AssemblyPackage.eINSTANCE;
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
	protected AssemblySwitch<Adapter> modelSwitch =
		new AssemblySwitch<Adapter>() {
            @Override
            public Adapter caseStatusSchema(StatusSchema object) {
                return createStatusSchemaAdapter();
            }
            @Override
            public Adapter caseConnector(Connector object) {
                return createConnectorAdapter();
            }
            @Override
            public Adapter caseOperator(Operator object) {
                return createOperatorAdapter();
            }
            @Override
            public Adapter caseConnectableElement(ConnectableElement object) {
                return createConnectableElementAdapter();
            }
            @Override
            public Adapter caseActionProxy(ActionProxy object) {
                return createActionProxyAdapter();
            }
            @Override
            public Adapter caseStatusValueProxy(StatusValueProxy object) {
                return createStatusValueProxyAdapter();
            }
            @Override
            public Adapter caseTransition(Transition object) {
                return createTransitionAdapter();
            }
            @Override
            public Adapter caseSynchroniser(Synchroniser object) {
                return createSynchroniserAdapter();
            }
            @Override
            public Adapter casePrecondition(Precondition object) {
                return createPreconditionAdapter();
            }
            @Override
            public Adapter caseStatusVariableProxy(StatusVariableProxy object) {
                return createStatusVariableProxyAdapter();
            }
            @Override
            public Adapter caseAndOperator(AndOperator object) {
                return createAndOperatorAdapter();
            }
            @Override
            public Adapter caseOrOperator(OrOperator object) {
                return createOrOperatorAdapter();
            }
            @Override
            public Adapter caseRequiredStrategy(RequiredStrategy object) {
                return createRequiredStrategyAdapter();
            }
            @Override
            public Adapter caseNeutralStrategy(NeutralStrategy object) {
                return createNeutralStrategyAdapter();
            }
            @Override
            public Adapter caseEnablingStrategy(EnablingStrategy object) {
                return createEnablingStrategyAdapter();
            }
            @Override
            public Adapter caseInhibitingStrategy(InhibitingStrategy object) {
                return createInhibitingStrategyAdapter();
            }
            @Override
            public Adapter caseStrategy(Strategy object) {
                return createStrategyAdapter();
            }
            @Override
            public Adapter caseSchemaElement(SchemaElement object) {
                return createSchemaElementAdapter();
            }
            @Override
            public Adapter caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
            }
            @Override
            public Adapter caseAbstractAction(AbstractAction object) {
                return createAbstractActionAdapter();
            }
            @Override
            public Adapter caseAction(Action object) {
                return createActionAdapter();
            }
            @Override
            public Adapter caseAbstractStatusValue(AbstractStatusValue object) {
                return createAbstractStatusValueAdapter();
            }
            @Override
            public Adapter caseStatusValue(StatusValue object) {
                return createStatusValueAdapter();
            }
            @Override
            public Adapter caseAbstractStatusVariable(AbstractStatusVariable object) {
                return createAbstractStatusVariableAdapter();
            }
            @Override
            public Adapter caseStatusVariable(StatusVariable object) {
                return createStatusVariableAdapter();
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
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.StatusSchema <em>Status Schema</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.StatusSchema
     * @generated
     */
	public Adapter createStatusSchemaAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.Connector <em>Connector</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.Connector
     * @generated
     */
	public Adapter createConnectorAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.Operator <em>Operator</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.Operator
     * @generated
     */
	public Adapter createOperatorAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.ConnectableElement <em>Connectable Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.ConnectableElement
     * @generated
     */
	public Adapter createConnectableElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.ActionProxy <em>Action Proxy</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.ActionProxy
     * @generated
     */
	public Adapter createActionProxyAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.StatusValueProxy <em>Status Value Proxy</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.StatusValueProxy
     * @generated
     */
	public Adapter createStatusValueProxyAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.Transition <em>Transition</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.Transition
     * @generated
     */
	public Adapter createTransitionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.Synchroniser <em>Synchroniser</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.Synchroniser
     * @generated
     */
	public Adapter createSynchroniserAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.Precondition <em>Precondition</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.Precondition
     * @generated
     */
	public Adapter createPreconditionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.StatusVariableProxy <em>Status Variable Proxy</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.StatusVariableProxy
     * @generated
     */
	public Adapter createStatusVariableProxyAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.AndOperator <em>And Operator</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.AndOperator
     * @generated
     */
	public Adapter createAndOperatorAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.OrOperator <em>Or Operator</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.OrOperator
     * @generated
     */
	public Adapter createOrOperatorAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.RequiredStrategy <em>Required Strategy</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.RequiredStrategy
     * @generated
     */
	public Adapter createRequiredStrategyAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.NeutralStrategy <em>Neutral Strategy</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.NeutralStrategy
     * @generated
     */
	public Adapter createNeutralStrategyAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.EnablingStrategy <em>Enabling Strategy</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.EnablingStrategy
     * @generated
     */
	public Adapter createEnablingStrategyAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.InhibitingStrategy <em>Inhibiting Strategy</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.InhibitingStrategy
     * @generated
     */
	public Adapter createInhibitingStrategyAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.Strategy <em>Strategy</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.Strategy
     * @generated
     */
	public Adapter createStrategyAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.assembly.SchemaElement <em>Schema Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.assembly.SchemaElement
     * @generated
     */
	public Adapter createSchemaElementAdapter() {
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
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.design.AbstractAction <em>Abstract Action</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.design.AbstractAction
     * @generated
     */
	public Adapter createAbstractActionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.design.Action <em>Action</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.design.Action
     * @generated
     */
	public Adapter createActionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.design.AbstractStatusValue <em>Abstract Status Value</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.design.AbstractStatusValue
     * @generated
     */
	public Adapter createAbstractStatusValueAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.design.StatusValue <em>Status Value</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.design.StatusValue
     * @generated
     */
	public Adapter createStatusValueAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.design.AbstractStatusVariable <em>Abstract Status Variable</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.design.AbstractStatusVariable
     * @generated
     */
	public Adapter createAbstractStatusVariableAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.design.StatusVariable <em>Status Variable</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.design.StatusVariable
     * @generated
     */
	public Adapter createStatusVariableAdapter() {
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

} //AssemblyAdapterFactory
