/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.scopeProvider;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Defines the basics of a component model for EMF models, defining visibility rules. An instance of a class
 * implementing this interface represents a view from some specific "point" in the EMF universe. This "point"
 * could be an {@link EObject} or a {@link Resource}, for example. The scope provider can then tell which other
 * model areas are visible from this "point," either as an explicit list of individual {@link EObject}s or
 * more coarse-grained, as a set of resource {@link URI}s (see {@link #getForwardScopeAsEObjects()} and
 * {@link #getForwardScopeAsURIs()}, respectively).<p>
 * 
 * Similarly, the scope provider that defines the view from a specific "point" can also be asked for the
 * reverse visibility relationship: "From where is the point represented by the scope provider visible?".
 * This is possible with the {@link #getBackwardScopeAsEObjects()} and {@link #getBackwardScopeAsURIs()}.
 * 
 * @author Tobias Hoppe, Axel Uhl
 * 
 */
public interface ScopeProvider {

    /**
     * Returns the value of the '<em><b>Forward Scope as EObjects</b></em>' attribute list. The list contents are of type
     * {@link EObject}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Forward Scope as EObjects</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Forward Scope as EObjects</em>' attribute list.
     */
    Collection<EObject> getForwardScopeAsEObjects();

    /**
     * Returns the value of the '<em><b>Forward Scope as URI</b></em>' attribute list. The list contents are of type {@link URI}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Forward Scope as URI</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Forward Scope as URI</em>' attribute list.
     */
    Collection<URI> getForwardScopeAsURIs();

    /**
     * Returns the value of the '<em><b>Backward Scope as URI</b></em>' attribute list. The list contents are of type {@link URI}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Backward Scope as URI</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Backward Scope as URI</em>' attribute list.
     */
    Collection<EObject> getBackwardScopeAsEObjects();

    /**
     * Returns the value of the '<em><b>Backward Scope as URI</b></em>' attribute list. The list contents are of type {@link URI}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Backward Scope as URI</em>' attribute list isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Backward Scope as URI</em>' attribute list.
     */
    Collection<URI> getBackwardScopeAsURIs();

} // ScopeProvider
