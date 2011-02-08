/**
 * <copyright>
 * </copyright>
 *
 * $Id: DesignAdapterFactory.java,v 1.1 2011/02/07 17:17:58 auhl Exp $
 */
package behavioral.status_and_action.design.util;

import behavioral.status_and_action.design.*;

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
 * @see behavioral.status_and_action.design.DesignPackage
 * @generated
 */
public class DesignAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static DesignPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DesignAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = DesignPackage.eINSTANCE;
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
	protected DesignSwitch<Adapter> modelSwitch =
		new DesignSwitch<Adapter>() {
            @Override
            public Adapter caseBusinessObject(BusinessObject object) {
                return createBusinessObjectAdapter();
            }
            @Override
            public Adapter caseBusinessObjectNode(BusinessObjectNode object) {
                return createBusinessObjectNodeAdapter();
            }
            @Override
            public Adapter caseStatusVariable(StatusVariable object) {
                return createStatusVariableAdapter();
            }
            @Override
            public Adapter caseStatusValue(StatusValue object) {
                return createStatusValueAdapter();
            }
            @Override
            public Adapter caseAction(Action object) {
                return createActionAdapter();
            }
            @Override
            public Adapter caseAbstractStatusVariable(AbstractStatusVariable object) {
                return createAbstractStatusVariableAdapter();
            }
            @Override
            public Adapter caseAbstractStatusValue(AbstractStatusValue object) {
                return createAbstractStatusValueAdapter();
            }
            @Override
            public Adapter caseAbstractAction(AbstractAction object) {
                return createAbstractActionAdapter();
            }
            @Override
            public Adapter caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
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
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.design.BusinessObject <em>Business Object</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.design.BusinessObject
     * @generated
     */
	public Adapter createBusinessObjectAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link behavioral.status_and_action.design.BusinessObjectNode <em>Business Object Node</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see behavioral.status_and_action.design.BusinessObjectNode
     * @generated
     */
	public Adapter createBusinessObjectNodeAdapter() {
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

} //DesignAdapterFactory
