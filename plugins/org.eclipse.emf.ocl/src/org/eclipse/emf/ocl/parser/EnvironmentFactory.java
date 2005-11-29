/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.parser;

import java.util.Map;

/**
 * A facotry for creating OCL parser {@link Environment}s.  Clients of the OCL
 * parser that wish to use OCL with their metamodels can provide the parser
 * a factory that creates the suitable environments.  The environment provides
 * mappings from the client's metamodel to the Ecore metamodel, extended by
 * UML constructs defined and/or used by the OCL language.  Many of these
 * mappings are optional (e.g., OclState, OclMessage, AssociationClass).
 * <p>
 * This interface is <b>not</b> intended to be implemented by clients "directly".
 * It is highly recommended to extend the {@link AbstractEnvironmentFactory} or
 * {@link EcoreEnvironmentFactory} class, instead.
 * </p>
 *
 * @author Christian W. Damus (cdamus)
 */
public interface EnvironmentFactory {
	/**
	 * An instance that creates {@link Environment}s suitable for parsing OCL
	 * expressions on the Ecore metamodel.  This factory expects classifiers
	 * to be instances of the {@link org.eclipse.emf.ecore.EClassifier} type
	 * and operations to be {@link org.eclipse.emf.ecore.EOperation}s.
	 */
	static EnvironmentFactory ECORE_INSTANCE = new EcoreEnvironmentFactory();
	
	/**
	 * Creates an environment suitable for parsing OCL expressions on the
	 * specified <code>object</code>, which is some classifier
	 * in the client's metamodel or an instance thereof.
	 * <p>
	 * The context may be either the specific model element or primitive value
	 * on which an OCL expression would be evaluated, or it may be an
	 * {@link EClassifier} of the target metamodel against which an OCL
	 * expression would be parsed.  Note that, in the former case, the actual
	 * OCL context classifier (as an OCL type or {@link EClassifier}) will be
	 * inferred from the context object according to the nature of the
	 * {@linkplain #getEnvironmentFactory() environment factory}
	 * </p>
	 * 
	 * @param context the context object or classifier
	 * @return the environment
	 * 
	 * @see #createOperationContext(Object, Object)
	 */
	Environment createClassifierContext(Object context);
	
	/**
	 * Creates an environment suitable for parsing OCL expressions on the
	 * specified <code>operation</code>, which is some operation
	 * in the client's metamodel.  Note that operations contexts can be defined
	 * in the context of any classifier to which that operation is applicable.
	 * 
	 * @pararm context the context element or classifier.  Either way, this
	 *     indicates the classifier context in which to define the operation
	 *     context (as in the {@link #createClassifierContext(Object)} method)
	 * @param operation an operation in the client's metamodel
	 * @return the environment
	 * 
	 * @see #createClassifierContext(Object)
	 */
	Environment createOperationContext(Object context, Object operation);
	
	/**
	 * Creates a child environment of a specified <code>parent</code>, for
	 * definition of nested scopes.
	 * 
	 * @param parent the parent environment
	 * @return the child environment
	 */
	Environment createEnvironment(Environment parent);
	
	/**
	 * Creates a new evaluation environment to track the values of variables in
	 * an OCL expression as it is evaluated.
	 * 
	 * @return a new evaluation environment
	 */
	EvaluationEnvironment createEvaluationEnvironment();
	
	/**
	 * Creates an extent map for invocation of <tt>OclType.allInstances()</tt>
	 * using the specified <code>object</code> as a context from which to find
	 * the scope in which OCL classifier extents are defined.  This scope may
	 * be a resource, resource set, or some metamodel-specific scope.  Note that
	 * in the case that the <code>object</code> is not an
	 * {@link org.eclipse.emf.ecore.EObject} but is, instead, some primitive
	 * type, then this may be difficult to determine.
	 * <p>
	 * Clients are encourage to do what they can to optimize this mapping, by
	 * lazy initialization of key-value pairs, workspace indices, or whatever
	 * means is available.  Note that the map will only ever be accessed by
	 * key ({@link Map#get(java.lang.Object)}); it will never be queried for
	 * all entries, all keys, all values, etc.  This knowledge could help
	 * optimization.
	 * </p>
	 * 
	 * @param object a context object in the scope that covers the OCL
	 *     classifier extents
	 * @return the extent map
	 */
	Map createExtentMap(Object object);
}
