/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
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
 * $Id: EvaluationEnvironment.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.evaluation;

import java.util.List;
import java.util.Map;

import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;
import org.eclipse.ocl.options.Customizable;
import org.eclipse.ocl.util.Adaptable;

/**
 * The evaluation environment keeps track of the current values of variables
 * in the evaluation of an OCL expression.  It also knows how to navigate
 * properties and association classes, etc. in M0 instances described by models
 * conformant to the metamodel supported by the environment implementation. 
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p><p>
 * As of the 1.2 release, evaluation environments are encouraged to implement
 * the {@link Adaptable} interface to provide optional interfaces such as
 * {@link Customizable} for specifying evaluation options.  Moreover, the
 * ({@link AbstractEvaluationEnvironment}) class implements the <tt>Adaptable</tt>
 * protocol.  Use the {@link OCLUtil#getAdapter(EvaluationEnvironment, Class)}
 * method to obtain adapters for any evaluation environment instance.
 * </p>
 * 
 * @author Tim Klinger (tklinger)
 * @author Christian W. Damus (cdamus)
 */
public interface EvaluationEnvironment {
    /**
     * Returns the value associated with the supplied name
     * 
     * @param name
     *            the name whose value is to be returned
     * @return the value associated with the name
     */
	Value getValueOf(String name);

    /**
     * Replaces the current value of the supplied name with the supplied value.
     * 
     * @param name
     *            the name
     * @param value
     *            the new value
     */
    void replace(String name, Value value);

    /**
     * Adds the supplied name and value binding to the environment.  The name
     * must not already be bound.
     * 
     * @param name
     *            the name to add
     * @param value
     *            the associated binding
     *            
     * @see #replace(String, Object)
     */
    void add(String name, Value value);
    void addVariable(VariableDeclaration declaration, VariableDeclaration definition);

    /**
     * Removes the supplied name and binding from the environment (if it exists)
     * and returns it.
     * 
     * @param name
     *            the name to remove
     * @return the value associated with the removed name
     */
    Value remove(String name);

    /**
     * Clears the environment of variables.
     */
    void clear();
    
    /**
     * Queries whether this evaluation environment provides a custom
     * implementation of the specified pre-defined OCL <code>operation</code>.
     * In the case that the receiver does, then it must implement the
     * {@link #callOperation} method to apply the operation.
     * 
     * @param operation an OCL operation
     * @param opcode the operation code, if one of the operations pre-defined
     *    by OCL.  Otherwise, <code>-1</code>
     *    
     * @return <code>true</code> if this evaluation environment provides an
     *    implementation of this <code>operation</code>; <code>false</code>,
     *    otherwise
     *    
     * @see #callOperation
     */
    boolean overrides(Operation operation, int opcode);
   
    /**
     * Invokes the specified operation on the given source element, according
     * to the particular metamodel semantics.
     * 
     * @param operation the operation to invoke
     * @param opcode the operation code, if this is an OCL Standard Library
     *     operation (which this environment {@linkplain #overrides overrides})
     * @param source the source element on which the operation is invoked
     * @param args the arguments, or an empty array if none
     * @return the result of the operation (the operation necessarily is a
     *     query if it is invoked by OCL)
     * 
     * @throws IllegalArgumentException if the operation is not supported
     *     by this environment
     */
    Object callOperation(Operation operation, int opcode, Object source, Object[] args)
		throws IllegalArgumentException;
    
    /**
     * Obtains the value of the specified operation, for the given source element,
     * according to the particular metamodel semantics.
     * 
     * @param property the property to navigate
     * @param qualifiers the association-end qualifier values, or an empty list
     *     if none
     * @param source the source element owning the property value
     * @return the property value
     * 
     * @throws IllegalArgumentException if the property is not supported by the
     *     element or by this environment
     */
    Value navigateProperty(Property property, List<?> qualifiers, Object source)
    	throws IllegalArgumentException;
    
    /**
     * Obtains the instance of the specified association class that links the
     * specified source element, optionally via the specified property.
     * 
     * @param associationClass the association class to navigate to
     * @param navigationSource in case of ambiguity, the property of the
     *     source element's classifier through which to navigate to the
     *     association class
     * @param source the source element from which to navigate
     * @return the association class instance
     * 
     * @throws IllegalArgumentException if the association class is not
     *     associated with the source element, or is not supported by this
     *     environment
     */
    Value navigateAssociationClass(Type associationClass, Property navigationSource, Object source)
    	throws IllegalArgumentException;
	
	/**
	 * Creates an extent map for invocation of <tt>OclType.allInstances()</tt>
	 * using the specified <code>object</code> as a context from which to find
	 * the scope in which OCL classifier extents are defined.  This scope may
	 * be a resource, resource set, or some metamodel-specific scope.  Note that
	 * in the case that the <code>object</code> is not an
	 * {@link org.eclipse.emf.ecore.EObject} but is, instead, some primitive
	 * type, then this may be difficult to determine.
	 * <p>
	 * Clients are encouraged to do what they can to optimize this mapping, by
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
    ModelManager createModelManager(Object object);
    
    /**
     * Queries whether an object is an instance of the specified classifier or
     * some specialization thereof.
     * 
     * @param object an object
     * @param classifier a classifier
     * @return <code>true</code> if the specified classifier is the object's
     *     type or some supertype thereof; <code>false</code>, otherwise
     */
    boolean isKindOf(Object object, Type classifier);
    
    /**
     * Queries whether an object's type is the specified classifier.
     * 
     * @param object an object
     * @param classifier a classifier
     * @return <code>true</code> if ths specified classifier is the object's
     *     type; <code>false</code>, otherwise
     */
    boolean isTypeOf(Object object, Type classifier);
    
    /**
     * Queries the type of the specified object.
     * 
     * @param object an object
     * @return its type
     */
    Type getType(Object object);
    
    /**
     * Creates a new tuple instance.
     * 
     * @param type the type (a {@link TupleType}) of the tuple to be created
     * @param values a mapping of the tuple parts
     * @return the new tuple instance
     */
//    Tuple createTuple(Type type, Map<TypedElement, Object> values);

	/**
	 * Obtains the Java-language value of the specified enumeration literal.
	 * Often, this is an instance of an EMF-generated enumeration type.
	 * 
	 * @param enumerationLiteral the enumeration literal model element
	 * @return the corresponding run-time instance
	 */
	Value getValue(EnumerationLiteral enumerationLiteral);

	VariableDeclaration getVariable(VariableDeclaration variableDeclaration);

	TypeManager getTypeManager();

	ValueFactory getValueFactory();
}