/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.events;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Change Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.events.ModelChangeEvent#getSourceResourceSet <em>Source Resource Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.events.EventsPackage#getModelChangeEvent()
 * @model
 * @generated
 */
public interface ModelChangeEvent extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Resource Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Resource Set</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Resource Set</em>' attribute.
	 * @see #setSourceResourceSet(ResourceSet)
	 * @see de.hpi.sam.bp2009.solution.events.EventsPackage#getModelChangeEvent_SourceResourceSet()
	 * @model transient="true"
	 * @generated
	 */
	ResourceSet getSourceResourceSet();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.events.ModelChangeEvent#getSourceResourceSet <em>Source Resource Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Resource Set</em>' attribute.
	 * @see #getSourceResourceSet()
	 * @generated
	 */
	void setSourceResourceSet(ResourceSet value);

} // ModelChangeEvent
