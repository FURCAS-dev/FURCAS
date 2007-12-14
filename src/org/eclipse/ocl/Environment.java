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
 * $Id: Environment.java,v 1.6 2007/12/14 17:09:29 cdamus Exp $
 */

package org.eclipse.ocl;

import java.util.Collection;
import java.util.List;

import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.internal.EnvironmentRegistryImpl;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.Adaptable;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * An Environment stores the variables created while evaluating an OCL expression,
 * including <tt>self</tt>.  It also maintains the context classifier and,
 * if appropriate, operation or property.  This interface is not typically
 * used by clients of the parser API, but by providers of bindings for particular
 * UML-like metamodels.
 * <p>
 * The generic type parameters of this interface represent the UML concepts that
 * the OCL parser and evaluation engine require.  A binding for a particular
 * metamodel (e.g., Ecore or UML) is implemented as a concrete <code>Environment</code>
 * with appropriate metaclasses substituting for these type parameters.
 * </p>
 * <p>
 * This interface is <b>not</b> intended to be implemented "directly" by
 * providers of metamodel bindings.
 * It is highly recommended to extend the {@link AbstractEnvironment} class,
 * instead.
 * </p><p>
 * Since 1.2, the default abstract implementation of this interface
 * ({@link AbstractEnvironment}) implements the {@link Adaptable} protocol to
 * provide dynamic interface adapters.  Use the
 * {@link OCLUtil#getAdapter(Environment, Class)} method to obtain
 * adapters for any environment instance.
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
 * @author Edith Schonberg (edith)
 * @author Christian W. Damus (cdamus)
 * 
 * @see AbstractEnvironment
 * @see EnvironmentFactory
 */
public interface Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {
	/**
	 * Namespace URI of the OCL core metamodel, used for example as the
	 * source of certain Ecore annotations.
	 */
	String OCL_NAMESPACE_URI = "http://www.eclipse.org/ocl/1.1.0/OCL"; //$NON-NLS-1$
	
    /**
     * The name of the context variable 'self'.
     */
    String SELF_VARIABLE_NAME = "self"; //$NON-NLS-1$
    
    /**
     * The name of the operation result variable 'result'.
     */
    String RESULT_VARIABLE_NAME = "result"; //$NON-NLS-1$
   
	/**
	 * Obtains the factory that created me, or an appropriate default factory
	 * if I was not created using a factory.  This factory can be used to create
	 * nested environments within me.
	 * 
	 * @return my originating factory
	 * 
	 * @see EnvironmentFactory#createEnvironment(Environment)
	 */
	EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	getFactory();
    
    /**
     * Obtains my parent environment, if I have one.  My parent environment
     * implements a nesting scope of variable names, some of which names
     * may be shadowed by variables in my scope.
     * 
     * @return my parent, or <code>null</code> if I am a root environment
    */
    Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getParent();
	
	/**
	 * Sets my parent environment.  The parent environment should not generally
     * be set to <code>null</code> if it was not already <code>null</code>.
     * 
	 * @param env my new parent environment
	 */
	void setParent(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env);
	
    /**
     * Obtains my context package, if any.  The constraints in an OCL document
     * need not declare a package context, but it is at least implicit as the
     * nearest package containing the context classifier.
     * 
     * @return my context package
     * 
     * @see #getContextClassifier()
     */
	PK getContextPackage();
	
	/**
	 * Obtains the context classifier of this environment.  This is the type
     * of the <tt>self</tt> context variable.
	 * 
	 * @return the context classifier
	 */
	C getContextClassifier();
	
	/**
	 * Obtains the context operation of this environment, if it is an operation
	 * context.
	 * 
	 * @return the context operation, or <code>null</code> if this is not an
	 *     operation environment
	 */
	O getContextOperation();
	
	/**
	 * Obtains the context property of this environment, if it is a property
	 * context.
	 * 
	 * @return the context property, or <code>null</code> if this is not a
	 *     property environment
	 */
	P getContextProperty();
	
    /**
     * Obtains the collection of core types representing the OCL Standard
     * Library.  These are the singleton or generic instances of the OCL-defined
     * classifiers such as <tt>OclAny</tt>, <tt>Collection(T)</tt>, etc.
     * Implementers of OCL metamodel bindings are encouraged to share a single
     * instance of the standard library amonst all of the <tt>Environment</tt>s
     * constructed by a particular {@link EnvironmentFactory}.
     * 
     * @return the OCL Standard Library implementation for this environment
     */
	OCLStandardLibrary<C> getOCLStandardLibrary();
	
	/**
	 * Obtains a type resolver to be used to create (and cache) concrete bindings
	 * for the generic OCL types, based on the user model types provided by this
	 * environment.  These are the types that are parameterized by particular
     * user model elements:  collections of particular classifiers, meta-types
     * for particular classifiers, message types for particular operations or
     * signals, and tuple types.
	 * 
	 * @return the type resolver
	 */
	TypeResolver<C, O, P> getTypeResolver();
	
	/**
	 * Queries whether the environment has any local variables defined in it.
     * 
	 * @return <code>true</code> if no local variables are defined;
     *    <code>false</code>, otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Obtains the <tt>Variable</tt> bound to a local variable name.
	 * Does not look in parent environment scopes.
     * 
	 * @param name a variable name to look up
	 * @return the matching variable, or <code>null</code> if not found in
     *     this particular environment
	 */
	Variable<C, PM> lookupLocal(String name);
	
	/**
     * Obtains the <tt>Variable</tt> bound to a variable name.
     * Looks in parent environment scopes (recursively) for variables not
     * found in the local scope.
     * 
     * @param name a variable name to look up
     * @return the matching variable, or <code>null</code> if not found in
     *     this particular environment
	 */
	Variable<C, PM> lookup(String name);
	
	/**
	 * Finds the package identified by the specified sequence of names
     * (a qualified name).
	 * 
	 * @param names the qualified name
	 * @return the matching package, or <code>null</code> if not found
	 */	
	PK lookupPackage(List<String> names); 
	
	/**
	 * Finds the classifier identified by the specified sequence of names
     * (a qualified name).
     * 
	 * @param names the qualified name
	 * @return the matching classifier, or <code>null</code> if not found
	 */	
	C lookupClassifier(List<String> names); 
	
	/**
	 * Find an operation in the specified class.  Used to resolve operation
     * calls.
	 * 
	 * @param owner the owner type of the called operation, or <code>null</code>
     *     to find an implicit owner type (in iteration expressions)
	 * @param name the name of the called operation
	 * @param args the arguments (expressions or variables) to be matched against
     *     the parameter signature of the operation
	 * 
	 * @return the matching operation, or <code>null</code> if not found
	 */ 	
	O lookupOperation(C owner, String name, List<? extends TypedElement<C>> args);
	
	/**
	 * Finds a property defined or inherited by the specified classifier.
	 * 
	 * @param owner the owner of the property that we are looking for, or
	 *     <code>null</code> to find an implicit owner type (in iteration
     *     expressions)
	 * @param name the property name
	 * 
	 * @return the property, or <code>null</code> if it could not be found
	 */ 	
	P lookupProperty(C owner, String name);
	
	/**
	 * Finds a reference in the specified class to the named association class.
	 * 
	 * @param owner the referencing class to search, or
     *     <code>null</code> to find an implicit owner type (in iteration
     *     expressions)
	 * @param name the association class name (with an initial lower case as
	 *     per the OCL convention)
	 * @return the association class (generically as a classifier), or
     *     <code>null</code> if the specified <code>owner</code> is not at the
     *     end of an association with this particular name
	 */ 	
	C lookupAssociationClassReference(C owner, String name);
	
	/**
	 * Finds the state identified by the specified qualified name path, to
     * resolve an <tt>oclIsInState()</tt> operation.
	 * 
	 * @param owner the type on which the <tt>oclIsInState()</tt> operation is
	 *    invoked
	 * @param path the state name to seek
	 * @return the matching state object, or <code>null</code> if not found
	 * 
	 * @throws LookupException in the case that this <tt>path</tt> is
	 *     ambiguous; i.e., that it does not qualify a state reference with
	 *     the state machine name to select between same-named states in
	 *     different state machines
	 * @throws SemanticException which usually would actually be a
	 *     <tt>LookupException</tt> (see above)
	 */
	S lookupState(C owner, List<String> path) throws LookupException, SemanticException;
	
	/**
	 * Retrieves a list of all possible states of the specified <code>owner</code>
	 * whose paths are prefixed by the specified partial name.  If the
	 * owner is <code>null</code>, then the target of the <code>oclIsInState()</code>
	 * operation call is implicit and must be looked up in the usual way for
	 * implicit operation call targets.  This method is used for content-assist.
	 * 
	 * @param owner the classifier for which states are being sought.  Can be
	 *    <code>null</code> in the case of an <tt>oclIsInState()</tt> call on an
	 *    implicit target
	 * @param pathPrefix partial path name of the states being sought.  This
	 *    can be empty to find the first level of state names
	 * 
	 * @return the list of all possible states directly contained in the
	 *    namespace indicated by the path prefix (i.e., only one level of
	 *    state nesting)
	 */
	List<S> getStates(C owner, List<String> pathPrefix);
	
	/**
	 * Finds a received signal in the specified classifier.
	 * 
	 * @param owner the owner type of the signal reception
	 * @param name the name of the signal
	 * @param args the arguments (expressions or variables) matching the
     *     properties of the signal (parameters of the reception feature)
	 * 
	 * @return the matching signal, or <code>null</code> if not found
	 */ 	
	C lookupSignal(C owner, String name, List<? extends TypedElement<C>> args);

	/**
	 * Checks whether the specified OCL expression is in an operation
	 * postcondition constraint.  This is used in validating the usage of
     * constructs that are only valid in postconditions
     * (e.g., <tt>oclIsNew()</tt>).
	 * 
	 * @param exp an OCL expression
	 * @return <code>true</code> if it is in a postcondition constraint;
	 *    <code>false</code>, otherwise (including case of no constraint at all)
	 */
	boolean isInPostcondition(OCLExpression<C> exp);
	
	/**
	 * Adds a variable declaration to the environment.
	 * If the name is null, then a new unique temporary name is generated (this
     * is useful for implicit variables).
     * 
	 * @param name the name of the variable, or <code>null</code>
	 * @param elem a variable declaration
	 * @param explicit whether this is an explicitly declared variable
     * 
	 * @return <code>true</code> if the variable was successfully added because
     *    it wasn't already declared locally in this environment;
     *    <code>false</code>, otherwise
	 */	
	public boolean addElement(String name, Variable<C, PM> elem, boolean explicit);
	
	/**
	 * Removes a variable when it goes out of scope.
     * 
	 * @param name the name of the variable to delete
	 */
	public void deleteElement(String name);
	
	/**
	 * Returns the {@link Variable}s registered explicitly in me and any
     * parents that I may have.  This does not include implicit variables or
     * variables from parent environments that are shadowed by variables in
     * the nested scope.
	 * 
	 * @return my variable declarations
	 */
	public Collection<Variable<C, PM>> getVariables();
		
	/**
	 * Sets the "self" variable that is the implicit source of any property,
	 * operation, or association class call.
	 * 
	 * @param var the "self" variable
	 */
	public void setSelfVariable(Variable<C, PM> var);
	
	/**
	 * Gets the self variable, looking it up in a parent environment if necessary.
	 * 
	 * @return the self variable, or <code>null</code> if none (which should
     *    only be the case in a root environment having only a package context,
     *    if even that)
	 */
	public Variable<C, PM> getSelfVariable();
	
	/**
	 * Return the most appropriate matching variable to use as the implicit
	 * source of a call to the specified property.  Variables are returned based
	 * on inner-most scope first.
	 * 
	 * @param name the property name
	 * 
	 * @return the matching variable, or <code>null</code> if no appropriate
     *     variable can be found whose type defines a property of this name
	 */
	public Variable<C, PM> lookupImplicitSourceForProperty(String name);
	
	/**
	 * Return an implicit variable that references the
	 * named association class.  Variables are returned based on inner-most
	 * scope first.
	 * 
	 * @param name the association class name to seek
	 * @return the matching variable, or <code>null</code> if no appropriate
     *     variable can be found whose type defines a property of this name
	 */	
	public Variable<C, PM> lookupImplicitSourceForAssociationClass(String name);
	
	/**
     * Return an implicit variable declaration that defines the specified
     * operation signature.  Variables are returned based on inner-most scope
     * first.
     * 
	 * @param name the operation name
     * @param args the list of arguments (expressions or variables) to match
     *     against the operation parameters
	 * @return the matching variable, or <code>null</code> if no appropriate
     *     variable can be found whose type defines a property of this name
	 */
	public Variable<C, PM> lookupImplicitSourceForOperation(String name,
        List<? extends TypedElement<C>> args);
	
    /**
     * Return an implicit variable declaration that defines the specified
     * signal reception signature.  Variables are returned based on inner-most
     * scope first.
     * 
     * @param name the signal name
     * @param args the list of arguments (expressions or variables) to match
     *     against the signal reception parameters
     * @return the matching variable, or <code>null</code> if no appropriate
     *     variable can be found whose type defines a property of this name
     */
	public Variable<C, PM> lookupImplicitSourceForSignal(String name, List<? extends TypedElement<C>> args);
	
	/**
	 * Finds the best-matching implicit variable to use as a source for
	 * the unqualified <tt>oclIsInState()</tt> invocation with the specified
	 * state qualified name path.
	 * 
	 * @param path the state name to seek
	 * @return the implicit variable having the specified state,
	 *     or <code>null</code> if not found
	 * 
	 * @throws LookupException in the case that this <tt>path</tt> is
	 *     ambiguous; i.e., that it does not qualify a state reference with
	 *     the state machine name to select between same-named states in
	 *     different state machines
	 * @throws SemanticException which usually would actually be a
	 *     <tt>LookupException</tt> (see above)
	 */
	public Variable<C, PM> lookupImplicitSourceForState(List<String> path)
		throws LookupException, SemanticException;
	
	/**
     * In processing an additional attribute definition, constructs the
     * property and associates it with its definition constraint.
     * The operation definition is local to this environment.
     * 
     * @param owner the context classifier of the property definition constraint
     * @param variable the name and type of the property (conveniently
     *     encapsulated in a variable)
     * @param constraint the definition constraint
     * @return the defined property
	 */
	P defineAttribute(C owner, Variable<C, PM> variable, CT constraint);
    
    /**
     * Obtains the additional attributes defined in this environment in the
     * context of the specified classifier.
     * 
     * @param classifier a classifier
     * @return its additional attributes, or an empty list if none
     */
    List<P> getAdditionalAttributes(C classifier);
    
    /**
     * In processing an additional operation definition, constructs the
     * operation and associates it with its definition constraint.
     * The operation definition is local to this environment.
     * 
     * @param owner the context classifier of the property definition constraint
     * @param name the operation name
     * @param params the names and types of the parameters, if any (conveniently
     *     encapsulated in variables)
     * @param constraint the definition constraint
     * @return the defined operation
     */
	O defineOperation(C owner, String name, C type, List<Variable<C, PM>> params, CT constraint);
	
    /**
     * Obtains the additional operations defined in this environment in the
     * context of the specified classifier.
     * 
     * @param classifier a classifier
     * @return its additional operations, or an empty list if none
     */
    List<O> getAdditionalOperations(C classifier);
    
    /**
     * Obtains the definition constraint of the specified feature, if it is an
     * additional attribute or operation defined via an OCL constraint.
     * 
     * @param feature a property or operation
     * @return the definition constraint that defines it, or <code>null</code>
     *    if this feature is not defined by OCL
     */
	CT getDefinition(Object feature);
	
	/**
	 * Removes the definition of an additional operation or property.
	 * 
	 * @param feature an additional property or operation
	 * 
	 * @throws IllegalArgumentException if the specified <tt>feature</tt> is
	 *    not an additional feature defined via an OCL constraint
	 */
	void undefine(Object feature);
	
    /**
     * Associates a property with an initial-value constraint.
     * The constraint is local to this environment.
     * 
     * @param property an attribute
     * @param constraint its initial-value constraint
     */
	void setInitConstraint(P property, CT constraint);

    /**
     * Obtains a property's with an initial-value constraint, if any.
     * 
     * @param property an attribute
     * @return its initial-value constraint, or <code>null</code> if none
     */
	CT getInitConstraint(P property);
	
    /**
     * Associates a property with an derived-value constraint.
     * The constraint is local to this environment.
     * 
     * @param property an attribute
     * @param constraint its derived-value constraint
     */
	void setDeriveConstraint(P property, CT constraint);
	
    /**
     * Obtains a property's derived-value constraint.
     * 
     * @param property an attribute
     * @return its derived-value constraint
     */
	CT getDeriveConstraint(P property);
	
    /**
     * Associates an operation with an body condition constraint.
     * The constraint is local to this environment.
     * 
     * @param operation an operation
     * @param constraint its body condition constraint
     */
	void setBodyCondition(O operation, CT constraint);
	
    /**
     * Obtains an operation's body condition constraint.
     * 
     * @param operation an operation
     * @return its body condition constraint
     */
	CT getBodyCondition(O operation);
    
    /**
     * Obtains a factory for the creation of types that are parameterized
     * by model elements.  This type factory must create types that are
     * instances of the metaclass describing classifiers in the client
     * metamodel.
     * 
     * @return the appropriate type factory
     */
    OCLFactory getOCLFactory();
    
    /**
     * Obtains a utility for for reflection on the UML metaclasses that are
     * used by the OCL abstract syntax.
     * 
     * @return the appropriate reflection instance
     */
    UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> getUMLReflection();
	
    /**
     * A registry of environments.  The registry may be consulted to find a
     * default environment suitable for the introspection of a model element.
     * These environments will never be used for the definition of constraints
     * or variables.
     * <p>
     * This registry may be populated at run-time or, in an Eclipse environment,
     * statically on the <tt>org.eclipse.ocl.environments</tt> extension point.
     * </p>
     * 
     * @author Christian W. Damus (cdamus)
     */
	interface Registry {
        /**
         * The shared registry instance.
         */
		Registry INSTANCE = new EnvironmentRegistryImpl();
		
        /**
         * Obtains a suitable environment for introspection of the specified
         * expression.
         * 
         * @param expression a parsed OCL expression
         * @return the matching registered environment, or <code>null</code> if
         *     none is available
         */
		<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
        getEnvironmentFor(OCLExpression<C> expression);
		
        /**
         * Obtains a suitable environment for introspection of the specified
         * model element, type (such as a collection type), or other abstract
         * syntax element (e.g., a variable).
         * 
         * @param abstractSyntaxElement an element in or referenced by the
         *     AST of of an OCL constraint
         * @return the matching registered environment, or <code>null</code> if
         *     none is available
         */
		<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
        getEnvironmentFor(Object abstractSyntaxElement);
		
        /**
         * Adds the specified environment to the registry.
         * 
         * @param environment an environment to register
         */
		void registerEnvironment(Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> environment);
        
        /**
         * Removes the specified environment from the registry.
         * 
         * @param environment the environment to deregister
         */
        void deregisterEnvironment(Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> environment);
	}
	
	/**
	 * Optional adapter interface for look-up methods that throw
	 * {@link LookupException}s on abnormal failures (usually ambiguous names).
	 * 
	 * @author Christian W. Damus (cdamus)
	 * 
	 * @since 1.2
	 */
	interface Lookup<PK, C, O, P> {
		/**
		 * Finds the package identified by the specified sequence of names
	     * (a qualified name).
		 * 
		 * @param names the qualified name
		 * @return the matching package, or <code>null</code> if not found
		 * @throws LookupException if lookup fails due to an error such as an ambiguity
		 */	
		PK tryLookupPackage(List<String> names) throws LookupException; 
		
		/**
		 * Finds the classifier identified by the specified sequence of names
	     * (a qualified name).
	     * 
		 * @param names the qualified name
		 * @return the matching classifier, or <code>null</code> if not found
		 * @throws LookupException if lookup fails due to an error such as an ambiguity
		 */	
		C tryLookupClassifier(List<String> names) throws LookupException; 
	    
	    /**
	     * Find an operation in the specified class.  Used to resolve operation
	     * calls.
	     * 
	     * @param owner the owner type of the called operation, or <code>null</code>
	     *     to find an implicit owner type (in iteration expressions)
	     * @param name the name of the called operation
	     * @param args the arguments (expressions or variables) to be matched against
	     *     the parameter signature of the operation
	     * 
	     * @return the matching operation, or <code>null</code> if not found
         * @throws LookupException if lookup fails due to an error such as an ambiguity
	     */     
	    O tryLookupOperation(C owner, String name, List<? extends TypedElement<C>> args) throws LookupException;
	    
	    /**
	     * Finds a property defined or inherited by the specified classifier.
	     * 
	     * @param owner the owner of the property that we are looking for, or
	     *     <code>null</code> to find an implicit owner type (in iteration
	     *     expressions)
	     * @param name the property name
	     * 
	     * @return the property, or <code>null</code> if it could not be found
         * @throws LookupException if lookup fails due to an error such as an ambiguity
	     */     
	    P tryLookupProperty(C owner, String name) throws LookupException;
	    
	    /**
	     * Finds a reference in the specified class to the named association class.
	     * 
	     * @param owner the referencing class to search, or
	     *     <code>null</code> to find an implicit owner type (in iteration
	     *     expressions)
	     * @param name the association class name (with an initial lower case as
	     *     per the OCL convention)
	     *     
	     * @return the association class (generically as a classifier), or
	     *     <code>null</code> if the specified <code>owner</code> is not at the
	     *     end of an association with this particular name
         * @throws LookupException if lookup fails due to an error such as an ambiguity
	     */     
	    C tryLookupAssociationClassReference(C owner, String name) throws LookupException;
	    
	    /**
	     * Finds a received signal in the specified classifier.
	     * 
	     * @param owner the owner type of the signal reception
	     * @param name the name of the signal
	     * @param args the arguments (expressions or variables) matching the
	     *     properties of the signal (parameters of the reception feature)
	     * 
	     * @return the matching signal, or <code>null</code> if not found
         * @throws LookupException if lookup fails due to an error such as an ambiguity
	     */     
	    C tryLookupSignal(C owner, String name, List<? extends TypedElement<C>> args) throws LookupException;
	}
	
	/**
	 * <p>
	 * An interface that merges the {@link Environment} and
	 * {@link BasicEnviroment} interfaces that define the
	 * behaviour realised in abstract form by {@link AbstractEnviroment}.
	 * The purpose of this interface is primarily for internal use by the
	 * parser and/or the particular environment implementation and its
	 * corresponding factory.  Client applications will not usually need to
	 * use this interface.
	 * </p><p>
	 * This interface is not expected to be implemented by clients.  It may
	 * be implemented by custom {@link Environment} classes, but it is
	 * recommended to extend the {@link AbstractEnvironment} class.
	 * </p>
	 * 
	 * @author Christian W. Damus (cdamus)
	 * 
	 * @since 1.2
	 */
	interface Internal<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
        extends
            BasicEnvironment,
            Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {
    
        /**
         * Obtains my parent environment after construction.
         * 
         * @return my parent
         */
        Environment.Internal<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
        getInternalParent();
    
        /**
         * Assigns me a parent environment after construction.  It is not advisable
         * to set the parent to <code>null</code> if I previously had one.
         * 
         * @param parent my new parent
         */
        void setInternalParent(
                Environment.Internal<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent);
    
        /**
         * Adds an OCL-defined additional ("helper") operation to
         * the environment.  This is primarily intended for internal use by the
         * OCL environment implementation and should only be used for properties
         * defined via OCL (such as by the {@link Environment#defineOperation} method).
         * 
         * @param owner the classifier in which context the attribute is defined
         * @param operation the additional operation
         */
        void addHelperOperation(C owner, O operation);  
    
        /**
         * Adds an OCL-defined additional ("helper") attribute to
         * the environment.  This is primarily intended for internal use by the
         * OCL environment implementation and should only be used for properties
         * defined via OCL (such as by the {@link Environment#defineAttribute} method).
         * 
         * @param owner the classifier in which context the attribute is defined
         * @param property the additional attribute
         */
        void addHelperProperty(C owner, P property);
        
        /**
         * Disposes of any objects that I have created that should be cleaned
         * up.
         * 
         * @since 1.2
         */
        void dispose();
    }
}
