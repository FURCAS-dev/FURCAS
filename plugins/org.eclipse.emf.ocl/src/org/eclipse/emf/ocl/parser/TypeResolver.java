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
 * $Id: TypeResolver.java,v 1.5 2007/10/11 23:05:16 cdamus Exp $
 */
package org.eclipse.emf.ocl.parser;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.MessageType;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypeType;
import org.eclipse.emf.ocl.uml.TypedElement;


/**
 * Definition of a resolver for the dynamically-generated OCL types based on the types
 * in the user model.  It is expected that an implementation of this interface will
 * cache types for the duration of the associated {@link Environment} and, if
 * serialization of {@link OCLExpression}s is required, persist them in a
 * {@link Resource}.
 * <p>
 * This interface is not intended to be implemented directly by clients; use or
 * extend the {@link TypeResolverImpl} class, instead.
 * </p>
 * 
 * @deprecated Use the {@link org.eclipse.ocl.TypeResolver} interface with the
 * {@link org.eclipse.ocl.Environment}, instead.
 * 
 * @author Christian W. Damus (cdamus)
 */
@Deprecated
public interface TypeResolver {
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
	EClassifier resolve(EClassifier type);

	/**
	 * Resolves the collection type of the specified <code>kind</code> and
	 * element type, either created anew or previously created.
	 * 
	 * @param kind the kind of collection type to create
	 * @param elementType the element type
	 * 
	 * @return the new or existing collection type
	 */
	CollectionType resolveCollectionType(CollectionKind kind, EClassifier elementType);

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
	TupleType resolveTupleType(List parts);

	/**
	 * Resolves the type for a type expression referencing the specified
	 * <code>type</code>.  This is, effectively, the OCL metatype counterpart
	 * for the specified model type.
	 * 
	 * @param type a model type
	 * @return the new or existing type type
	 */
	TypeType resolveTypeType(EClassifier type);

	/**
	 * Resolves the type for a message expression referencing the specified
	 * <code>operation</code>.
	 * 
	 * @param operation the operation call that the message represents
	 * @return the new or existing message type
	 */
	MessageType resolveMessageType(EOperation operation);

	/**
	 * Resolves the type for a message expression referencing the specified
	 * <code>signal</code>.
	 * 
	 * @param signal the signal send that the message represents
	 * @return the new or existing message type
	 */
	MessageType resolveMessageType(EClass signal);
	
	/**
	 * Resolves the specified "additional operation" defined by the OCL client
	 * on the specified <code>owner</code> type.
	 * 
	 * @param owner the type on which the additional operation is defined
	 * @param operation the additional operation
	 * 
	 * @return the persistent operation
	 */
	EOperation resolveAdditionalOperation(EClassifier owner, EOperation operation);
	
	/**
	 * Resolves the specified "additional property" defined by the OCL client
	 * on the specified <code>owner</code> type.
	 * 
	 * @param owner the type on which the additional property is defined
	 * @param property the additional property
	 * 
	 * @return the persistent property
	 */
	EStructuralFeature resolveAdditionalProperty(EClassifier owner, EStructuralFeature property);
}
