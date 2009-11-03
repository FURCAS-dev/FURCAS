/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.SemanticsVisitable;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Element</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.Element#getTag <em>Tag</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getElement()
 * @model
 * @generated
 */
public interface Element extends SemanticsVisitable {
	/**
	 * Returns the value of the '<em><b>Tag</b></em>' reference list. The list contents are of type
	 * {@link org.oslo.ocl20.semantics.bridge.Tag}. It is bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.bridge.Tag#getElement <em>Element</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Tag</em>' reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Tag</em>' reference list.
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getElement_Tag()
	 * @see org.oslo.ocl20.semantics.bridge.Tag#getElement
	 * @model type="org.oslo.ocl20.semantics.bridge.Tag" opposite="element"
	 * @generated
	 */
	EList getTag();

} // Element
