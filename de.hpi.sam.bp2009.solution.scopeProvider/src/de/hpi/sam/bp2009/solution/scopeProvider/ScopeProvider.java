/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.scopeProvider;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.query2.QueryContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scope Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProviderPackage#getScopeProvider()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ScopeProvider extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Memory Resources</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Resource> getInMemoryResources();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="de.hpi.sam.bp2009.solution.scopeProvider.QueryContext"
	 * @generated
	 */
	QueryContext getForwardScopeAsQueryContext();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="de.hpi.sam.bp2009.solution.scopeProvider.QueryContext"
	 * @generated
	 */
	QueryContext getBackwardScopeAsQueryContext();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model initialObjectsRequired="true" initialObjectsMany="true"
	 * @generated
	 */
	void setupForEObjects(EList<EObject> initialObjects);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model initialResourcesRequired="true" initialResourcesMany="true"
	 * @generated
	 */
	void setupForResources(EList<Resource> initialResources);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model initialResourceSetsRequired="true" initialResourceSetsMany="true"
	 * @generated
	 */
	void setupForResourceSets(EList<ResourceSet> initialResourceSets);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<EObject> getForwardScopeAsEObjects();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="de.hpi.sam.bp2009.solution.scopeProvider.URI"
	 * @generated
	 */
	EList<URI> getForwardScopeAsURIs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<EObject> getBackwardScopeAsEObjects();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="de.hpi.sam.bp2009.solution.scopeProvider.URI"
	 * @generated
	 */
	EList<URI> getBackwardScopeAsURIs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model resourcesMany="true"
	 * @generated
	 */
	void setInMemoryResources(EList<Resource> resources);

} // ScopeProvider
