/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.util;

import de.hpi.sam.bp2009.solution.eventManager.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.hpi.sam.bp2009.solution.eventManager.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.AssociationFilter;
import de.hpi.sam.bp2009.solution.eventManager.AttributeFilter;
import de.hpi.sam.bp2009.solution.eventManager.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter;
import de.hpi.sam.bp2009.solution.eventManager.OrFilter;
import de.hpi.sam.bp2009.solution.eventManager.PackageFilter;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage
 * @generated
 */
public class EventManagerAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EventManagerPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventManagerAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EventManagerPackage.eINSTANCE;
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
	protected EventManagerSwitch<Adapter> modelSwitch =
		new EventManagerSwitch<Adapter>() {
			@Override
			public Adapter caseEventManager(EventManager object) {
				return createEventManagerAdapter();
			}
			@Override
			public Adapter caseEventFilter(EventFilter object) {
				return createEventFilterAdapter();
			}
			@Override
			public Adapter caseEventTypeFilter(EventTypeFilter object) {
				return createEventTypeFilterAdapter();
			}
			@Override
			public Adapter caseAndFilter(AndFilter object) {
				return createAndFilterAdapter();
			}
			@Override
			public Adapter caseOrFilter(OrFilter object) {
				return createOrFilterAdapter();
			}
			@Override
			public Adapter caseClassFilter(ClassFilter object) {
				return createClassFilterAdapter();
			}
			@Override
			public Adapter caseAttributeFilter(AttributeFilter object) {
				return createAttributeFilterAdapter();
			}
			@Override
			public Adapter casePackageFilter(PackageFilter object) {
				return createPackageFilterAdapter();
			}
			@Override
			public Adapter caseAssociationFilter(AssociationFilter object) {
				return createAssociationFilterAdapter();
			}
			@Override
			public Adapter caseOldValueClassFilter(OldValueClassFilter object) {
				return createOldValueClassFilterAdapter();
			}
			@Override
			public Adapter caseContainmentFilter(ContainmentFilter object) {
				return createContainmentFilterAdapter();
			}
			@Override
			public Adapter caseNewValueClassFilter(NewValueClassFilter object) {
				return createNewValueClassFilterAdapter();
			}
			@Override
			public Adapter caseStructuralFeatureFilter(StructuralFeatureFilter object) {
				return createStructuralFeatureFilterAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.EventManager <em>Event Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManager
	 * @generated
	 */
	public Adapter createEventManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter <em>Event Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventFilter
	 * @generated
	 */
	public Adapter createEventFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter <em>Event Type Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter
	 * @generated
	 */
	public Adapter createEventTypeFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.AndFilter <em>And Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AndFilter
	 * @generated
	 */
	public Adapter createAndFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.OrFilter <em>Or Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.OrFilter
	 * @generated
	 */
	public Adapter createOrFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.ClassFilter <em>Class Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ClassFilter
	 * @generated
	 */
	public Adapter createClassFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeFilter <em>Attribute Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AttributeFilter
	 * @generated
	 */
	public Adapter createAttributeFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.PackageFilter <em>Package Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.PackageFilter
	 * @generated
	 */
	public Adapter createPackageFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.AssociationFilter <em>Association Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AssociationFilter
	 * @generated
	 */
	public Adapter createAssociationFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.OldValueClassFilter <em>Old Value Class Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.OldValueClassFilter
	 * @generated
	 */
	public Adapter createOldValueClassFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.ContainmentFilter <em>Containment Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ContainmentFilter
	 * @generated
	 */
	public Adapter createContainmentFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.NewValueClassFilter <em>New Value Class Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.NewValueClassFilter
	 * @generated
	 */
	public Adapter createNewValueClassFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.StructuralFeatureFilter <em>Structural Feature Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.StructuralFeatureFilter
	 * @generated
	 */
	public Adapter createStructuralFeatureFilterAdapter() {
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

} //EventManagerAdapterFactory
