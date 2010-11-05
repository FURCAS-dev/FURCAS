/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling 
 *
 * </copyright>
 *
 * $Id: EnvironmentFactory.java,v 1.2 2007/10/11 23:05:04 cdamus Exp $
 */

package org.eclipse.ocl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.Adaptable;
import org.eclipse.ocl.util.OCLUtil;

/**
 * A factory for creating OCL parser {@link Environment}s.  Clients of the OCL
 * parser that wish to use OCL with their metamodels can provide the parser
 * a factory that creates the suitable environments.  The environment provides
 * mappings from the client's metamodel to the UML concepts required by the
 * parser (corresponding to the generic type parameters, below).  Many of these
 * mappings are optional (e.g., state machines, signals, and association
 * classes aren't supported by all metamodels).
 * <p>
 * This interface is <b>not</b> intended to be implemented to be implemented
 * "directly" by providers of metamodel bindings.
 * It is highly recommended to extend the {@link AbstractEnvironmentFactory}
 * class, instead.
 * </p><p>
 * Since 1.2, the {@link AbstractEnvironmentFactory} implements the
 * {@link Adaptable} interface and provides an adapter for the
 * {@link EnvironmentFactory.Lookup} interface.  Use the
 * {@link OCLUtil#getAdapter(EnvironmentFactory, Class)} method to obtain
 * adapters for any factory instance.
 * </p>
 * 
 * @param <PK> is substituted by the metaclass representing the metamodel's
 *    analogue for the UML 2.x <tt>Package</tt>
 * @param <C> corresponds to the UML <tt>Classifier</tt> metaclass
 * @param <O> corresponds to the UML <tt>Operation</tt> metaclass
 * @param <P> corresponds to the UML <tt>Property</tt> metaclass
 * @param <EL> corresponds to the UML <tt>EnumerationLiteral</tt> metaclass
 *    (<tt>Enumeration</tt>s are simply represented as classifiers)
 * @param <PM> corresponds to the UML <tt>Parameter</tt> metaclass
 * @param <S> corresponds to the UML <tt>State</tt> metaclass (for metamodels
 *    that describe state machines)
 * @param <COA> corresponds to the UML <tt>CallOperationAction</tt> metaclass
 *    (used in message expressions)
 * @param <SSA> corresponds to the UML <tt>SendSignalAction</tt> metaclass
 *    (used in message expressions)
 * @param <CT> corresponds to the UML <tt>Constraint</tt> metaclass
 * @param <CLS> corresponds to the UML <tt>Class</tt> metaclass
 * @param <E> corresponds to the UML <tt>Element</tt> metaclass
 *
 * @author Christian W. Damus (cdamus)
 */
public interface EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {
	
	/**
	 * Creates a root environment, in which package contexts and/or classifier
     * contexts will be created as nested environments.  All operation body
     * constraints, attribute initial/derived value constraints, and definitions
     * of additional attributes and operations should be maintained by the root
     * environment, so that they will be accessible from constraints parsed in
     * any nested environment.
	 * 
	 * @return a new root environment
	 */
	Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createEnvironment();
	
	/**
	 * Creates an environment suitable for parsing OCL expressions in the
	 * specified package context.  This context will become a classifier context
	 * when the {@linkplain Environment#setSelfVariable "self" variable}
	 * is defined.
	 * 
	 * @param pathname the qualified package name (the "::"-separated parts)
	 * @return the environment or null if lookup fails to locate a package
	 * 
	 * @see #createClassifierContext
	 * @see #createOperationContext
     * @see #createAttributeContext
	 */
	Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createPackageContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent,
			List<String> pathname);
	
	/**
	 * Loads an environment from the specified <tt>resource</tt>.  If not
	 * already loaded, this method will load the resource.  This resource will
	 * subsequently be used to persist new OCL constraints, so supplying a new,
	 * empty resource will allow the client to determine where the environment
	 * is persisted.
	 * 
	 * @param resource a resource containing the persisted environment
	 */
	Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	loadEnvironment(Resource resource);
	
	/**
	 * Creates an environment suitable for parsing OCL expressions in the
	 * specified <code>context</code>, which is some classifier
	 * in the client's model.
	 * 
	 * @param context the context classifier
	 * @return the environment
	 * 
	 * @see #createOperationContext(Environment, Object)
     * @see #createAttributeContext(Environment, Object)
     * @see #createInstanceContext(Environment, Object)
	 */
	Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createClassifierContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent,
			C context);
	
    /**
     * Creates an environment suitable for parsing OCL expressions on the
     * specified <code>context</code> object, which is an instance of some
     * classifier in the client's model.
     * <p>
     * The context may be an instance of a model class or a data type value
     * on which an OCL expression would be evaluated.  Note that the actual OCL
     * context classifier (as an OCL type or classifier) will be
     * inferred from the context instance according to the metamodel that the
     * environment factory supports, if possible.  If not possible, then the
     * {@link OCLStandardLibrary#getOclAny() OclAny} type is assumed.
     * </p>
     * 
     * @param context the context object or value
     * @return the environment
     * 
     * @see #createClassifierContext(Environment, Object)
     * @see OCLStandardLibrary#getOclAny()
     */
    Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    createInstanceContext(
            Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent,
            Object context);
    
	/**
	 * Creates an environment suitable for parsing OCL expressions on the
	 * specified <code>operation</code>, which is some operation
	 * in the client's metamodel.  Note that operation contexts can be defined
	 * in the context of any classifier to which that operation is applicable.
	 * 
	 * @param parent the parent environment, defining the classifier context
	 * @param operation an operation in the client's metamodel
	 * @return the environment
	 * 
	 * @see #createClassifierContext(Environment, Object)
	 */
	Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createOperationContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent,
			O operation);
	
	/**
	 * Creates an environment suitable for parsing OCL expressions on the
	 * specified <code>property</code>, which is some attribute
	 * in the client's metamodel.  Note that attribute contexts can be defined
	 * in the context of any classifier in which that attribute is available.
	 * 
     * @param parent the parent environment, defining the classifier context
	 * @param property an attribute in the client's metamodel
	 * @return the environment
	 * 
	 * @see #createClassifierContext(Environment, Object)
	 */
	Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createAttributeContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent,
			P property);
	
	/**
	 * Creates a child environment of a specified <code>parent</code>, for
	 * definition of nested scopes.
	 * 
	 * @param parent the parent environment
	 * @return the child environment
	 */
	Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createEnvironment(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent);
	
	/**
	 * Creates a new evaluation environment to track the values of variables in
	 * an OCL expression as it is evaluated.
	 * 
	 * @return a new evaluation environment
	 */
	EvaluationEnvironment<C, O, P, CLS, E> createEvaluationEnvironment();
	
	/**
	 * Creates a new evaluation environment as a nested environment of the
	 * specified <tt>parent</tt>.
	 * 
	 * @param parent a nesting evaluation environment
	 * @return a new nested evaluation environment
	 */
	EvaluationEnvironment<C, O, P, CLS, E> createEvaluationEnvironment(
			EvaluationEnvironment<C, O, P, CLS, E> parent);
	
    /**
     * Creates a new evaluation visitor, for the evaluation of OCL expressions.
     * 
     * @param env the environment in which the expression was originally parsed
     *    (or some compatible environment)
     * @param evalEnv the evaluation environment that the visitor is to use
     *    for tracking variables, navigating properties, etc.
     * @param extentMap the map of <tt>Class</tt>es to their extends
     * @return the new evaluation visitor
     */
	EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createEvaluationVisitor(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			EvaluationEnvironment<C, O, P, CLS, E> evalEnv,
			Map<? extends CLS, ? extends Set<? extends E>> extentMap);
	
	/**
	 * Optional adapter interface for look-up methods that throw
	 * {@link LookupException}s on abnormal failures (usually ambiguous names).
	 * 
	 * @author Christian W. Damus (cdamus)
	 * 
	 * @since 1.2
	 */
	interface Lookup<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {
		/**
		 * Creates an environment suitable for parsing OCL expressions in the
		 * specified package context.  This context will become a classifier context
		 * when the {@linkplain Environment#setSelfVariable "self" variable}
		 * is defined.
		 * 
		 * @param pathname the qualified package name (the "::"-separated parts)
		 * @return the environment or null if lookup fails to locate a package
		 * @throws LookupException if package lookup encounters an error such as an ambiguity
		 * 
		 * @see #createClassifierContext
		 * @see #createOperationContext
	     * @see #createAttributeContext
		 */
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		tryCreatePackageContext(
				Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent,
				List<String> pathname) throws LookupException;
	}
}
