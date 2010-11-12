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
 * $Id: TypeResolver.java,v 1.1 2007/01/25 18:24:37 cdamus Exp $
 */
package org.eclipse.ocl;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.utilities.TypedElement;


/**
 * Definition of a resolver for the dynamically-generated OCL types based on the types
 * in the user model.  It is expected that an implementation of this interface will
 * cache types for the duration of the associated {@link Environment} and, if
 * serialization of {@link OCLExpression}s is required, persist them in a
 * {@link Resource}.
 * <p>
 * This interface is not intended to be implemented directly by clients; use or
 * extend the {@link AbstractTypeResolver} class, instead.
 * </p>
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface TypeResolver<C, O, P> {
	/**
	 * Obtains the resource in which the types that I generate are stored for
	 * persistence.
	 * 
	 * @return my resource
	 */
	Resource getResource();
	
	/**
	 * Resolves the specified <code>type</code>, returning my own persistent
	 * type instance representing the same OCL type.
	 * <p>
	 * The <code>type</code> may have been newly created by the parser and be
	 * a duplicate of a type previously resolved, or it may actually be a
	 * type that was previously resolved.  In the latter case, the
	 * <code>type</code> is returned as is.  The <code>null</code> type is
	 * considered to be resolved (i.e., the result is also <code>null</code>).
	 * </p>
	 * <p>
	 * Usually, this method will delegate to one of the
	 * <code>resolveXyzType()</code> methods defined by this interface.
	 * </p>
	 * 
	 * @param type a type to resolve
	 * 
	 * @return the resolved type, or <code>type</code> if it is already resolved
	 */
	C resolve(C type);

	/**
	 * Resolves the collection type of the specified <code>kind</code> and
	 * element type, either created anew or previously created.
	 * 
	 * @param kind the kind of collection type to create
	 * @param elementType the element type
	 * 
	 * @return the new or existing collection type
	 */
	CollectionType<C, O> resolveCollectionType(CollectionKind kind, C elementType);

	/**
	 * Resolves the tuple type consisting of the specified <code>parts</code>,
	 * in no particular order, either created anew or previously created.  The
	 * resulting type is uniquely defined by the names and types of its parts, and
	 * twp tuple types are considered equal if they have the same number of parts
	 * and their parts correspond one-for-one in name and type (order is not
	 * significant).
	 * 
	 * @param parts a list of {@link TypedElement}s defining the name and type of
	 *     each tuple part.  The part names are unique
	 *     
	 * @return the new or existing tuple type
	 */
	TupleType<O, P> resolveTupleType(EList<? extends TypedElement<C>> parts);

	/**
	 * Resolves the type for a type expression referencing the specified
	 * <code>type</code>.  This is, effectively, the OCL metatype counterpart
	 * for the specified model type.
	 * 
	 * @param type a model type
	 * @return the new or existing type type
	 */
	TypeType<C, O> resolveTypeType(C type);

	/**
	 * Resolves the type for a message expression referencing the specified
	 * <code>operation</code>.
	 * 
	 * @param operation the operation call that the message represents
	 * @return the new or existing message type
	 */
	MessageType<C, O, P> resolveOperationMessageType(O operation);

	/**
	 * Resolves the type for a message expression referencing the specified
	 * <code>signal</code>.
	 * 
	 * @param signal the signal send that the message represents
	 * @return the new or existing message type
	 */
	MessageType<C, O, P> resolveSignalMessageType(C signal);
	
	/**
	 * Resolves the specified "additional operation" defined by the OCL client
	 * on the specified <code>owner</code> type.
	 * 
	 * @param owner the type on which the additional operation is defined
	 * @param operation the additional operation
	 * 
	 * @return the persistent operation
	 */
	O resolveAdditionalOperation(C owner, O operation);
	
    /**
     * Obtains the additional operations defined (via OCL) in the specified
     * classifier context.
     * 
     * @param owner the context classifier
     * @return its additional operations, or an empty list if none
     */
	List<O> getAdditionalOperations(C owner);
	
	/**
	 * Resolves the specified "additional attribute" defined by the OCL client
	 * on the specified <code>owner</code> type.
	 * 
	 * @param owner the type on which the additional attribute is defined
	 * @param property the additional attribute
	 * 
	 * @return the persistent attribute
	 */
	P resolveAdditionalAttribute(C owner, P property);
	
    /**
     * Obtains the additional attributes defined (via OCL) in the specified
     * classifier context.
     * 
     * @param owner the context classifier
     * @return its additional attributes, or an empty list if none
     */
	List<P> getAdditionalAttributes(C owner);
}
