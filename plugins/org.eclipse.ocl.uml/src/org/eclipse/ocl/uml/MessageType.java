/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: MessageType.java,v 1.2 2007/02/14 13:42:06 cdamus Exp $
 */
package org.eclipse.ocl.uml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.uml.MessageType#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.MessageType#getOwnedAttributes <em>Owned Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.uml.UMLPackage#getMessageType()
 * @model
 * @generated
 */
public interface MessageType extends Classifier, org.eclipse.ocl.types.MessageType<Classifier, Operation, Property> {
    /**
     * Returns the value of the '<em><b>Owned Operations</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.uml2.uml.Operation}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owned Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Owned Operations</em>' containment reference list.
     * @see org.eclipse.ocl.uml.UMLPackage#getMessageType_OwnedOperations()
     * @model type="org.eclipse.uml2.uml.Operation" containment="true"
     * @generated
     */
    EList<Operation> getOwnedOperations();

    /**
     * Returns the value of the '<em><b>Owned Attributes</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.uml2.uml.Property}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owned Attributes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Owned Attributes</em>' containment reference list.
     * @see org.eclipse.ocl.uml.UMLPackage#getMessageType_OwnedAttributes()
     * @model type="org.eclipse.uml2.uml.Property" containment="true"
     * @generated
     */
    EList<Property> getOwnedAttributes();

} // MessageType
