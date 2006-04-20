/**
 * <copyright>
 *
 * Copyright (c) 2005-2006 IBM Corporation and others.
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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.Variable;

/**
 * An Environment stores the variables created while evaluating an OCL expression,
 * including self.  It also maintains the package, if the OCL package statement is used.
 * <p>
 * This interface is <b>not</b> intended to be implemented by clients "directly".
 * It is highly recommended to extend the {@link EcoreEnvironment} class,
 * instead.
 * </p>
 * 
 * @author Edith Schonberg (edith)
 * @author Christian W. Damus (cdamus)
 * 
 * @see EcoreEnvironment
 * @see EnvironmentFactory
 */
public interface Environment {
	/**
	 * Source URI of the annotation for the expression defining an additional
	 * property or operation.
	 */
	String ANNOTATION_URI_DEFINE = "http://www.eclipse.org/OCL/1.0.0/define"; //$NON-NLS-1$
	
	/**
	 * Source URI of the annotation for the expression defining the initial
	 * value of a property.
	 */
	String ANNOTATION_URI_INIT = "http://www.eclipse.org/OCL/1.0.0/init"; //$NON-NLS-1$
	
	/**
	 * Source URI of the annotation for the expression defining the derived
	 * value of a property.
	 */
	String ANNOTATION_URI_DERIVE = "http://www.eclipse.org/OCL/1.0.0/derive"; //$NON-NLS-1$
	
	/**
	 * Source URI of the annotation for the body expression of an operation.
	 */
	String ANNOTATION_URI_BODY = "http://www.eclipse.org/OCL/1.0.0/body"; //$NON-NLS-1$
	
	/**
	 * Obtains the factory that created me, or an appropriate default factory
	 * if I was not created using a factory.  This factory can be used to create
	 * nested environments within me.
	 * 
	 * @return my originating factory
	 * 
	 * @see EnvironmentFactory#createEnvironment(Environment)
	 */
	EnvironmentFactory getFactory();
	
	/**
	* Set the parent environment
	* @param env
	*/
	public void setParent(Environment env);
	
	/**
	 * get the parent environment
	 * @return Environment
	*/
	public Environment getParent();
	
	/**
	 * Obtains the context classifier of this environment.
	 * 
	 * @return the context classifier
	 */
	public EClassifier getContextClassifier();
	
	/**
	 * Obtains the context operation of this environment, if it is an operation
	 * context.
	 * 
	 * @return the context operation, or <code>null</code> if this is not an
	 *     operation environment
	 */
	public EOperation getContextOperation();
	
	/**
	 * Obtains the context property of this environment, if it is a property
	 * context.
	 * 
	 * @return the context property, or <code>null</code> if this is not a
	 *     property environment
	 */
	public EStructuralFeature getContextProperty();
	
	/**
	 * Is the environment empty?
	 * @return boolean
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the VariableDeclaration for a variable name.
	 * Does not look in parent environment scopes.
	 * @param name
	 * @return VariableDeclaration
	 */
	public Variable lookupLocal(String name);
	
	/**
	 * returns the VariableDeclaration for a variable  
	 * Looks in parent environment scope if not found in current scope.
	 * @param name
	 * @return VariableDeclaration
	 */
	public Variable lookup(String name);
	
	
	/**
	 * Finds the EPackage corresponding to the path:   name::...::name
	 * If no EPackage is found, return <code>null</code>.
	 * 
	 * @param names the path name
	 * @return the package, or <code>null</code> if not found
	 */	
	public EPackage lookupPackage(List names); 
	
	/**
	 * Finds the EClassifier corresponding to the path:   name::...::name
	 * If no EClassifier is found, return null.
	 * @param names
	 * @return EClassifier
	 */	
	public EClassifier lookupPathName(List names); 
	
	/**
	 * Find the operation in the specified class.
	 * 
	 * @param owner the owner type of the called operation
	 * @param name the name of the called operation
	 * @param args the arguments (as {@link OCLExpression}s) passed to the operation
	 * 
	 * @return the matching operation, or <code>null</code> if not found
	 */ 	
	public EOperation lookupOperation(EClassifier owner, String name, EList args);
	
	/**
	 * Find a property defined or inherited by the specified classifier.
	 * 
	 * @param owner the owner of the property that we are looking for, or
	 *     <code>null</code> to find an implicit owner type
	 * @param name the property name
	 * 
	 * @return the property, or <code>null</code> if it could not be found
	 */ 	
	public EStructuralFeature lookupProperty(EClassifier parent, String name);
	
	/**
	 * Find reference in the specified class to the named association class.
	 * 
	 * @param parent the referencing class to search
	 * @param name the association class name (with an initial lower case as
	 *     per the OCL convention)
	 * @return the association class, or <code>null</code> if the specified
	 *     <code>parent</code> classifier does not have any references
	 *     implemented by the named association class
	 */ 	
	public EClass lookupAssociationClassReference(EClassifier parent,
			String name);
	
	/**
	 * Retrieves a list of all possible states of the specified <code>owner</code>
	 * whose paths are prefixed by the specified partial name.  If the
	 * owner is <code>null</code>, then the target of the <code>oclIsInState()</code>
	 * operation call is implicit and must be looked up in the usual way for
	 * implicit operation call targets.
	 * 
	 * @param owner the classifier for which states are being sought.  Can be
	 *    <code>null</code> in the case of an oclIsInState() call on an
	 *    implicit target
	 * @param pathPrefix partial path name of the states being sought.  This
	 *    can be empty to find the first level of state names
	 * 
	 * @return the list of all possible states directly contained in the
	 *    namespace indicated by the path prefix (i.e., only one level of
	 *    state nesting)
	 */
	public EList getStates(EClassifier owner, List pathPrefix);
	
	/**
	 * Obtains the simple name of the specified state (not the qualified name
	 * path).
	 * 
	 * @param state representation of a UML state
	 * @return its simple name
	 */
	String getStateName(EObject state);
	
	/**
	 * Find a received signal in the specified classifier.
	 * 
	 * @param owner the owner type of the signal reception
	 * @param name the name of the signal
	 * @param args the arguments (as {@link OCLExpression}s) passed in the signal
	 * 
	 * @return the matching signal, or <code>null</code> if not found
	 */ 	
	public EClass lookupSignal(EClassifier owner, String name, EList args);
	
	/**
	 * Retrieves a list of all signal receptions defined by the specified
	 * <code>owner</code> classifier.  This must include also signals
	 * defined by supertypes of the owner.
	 * 
	 * @param owner the owner type of the signal receptions
	 * 
	 * @return the available signals (as {@link EClass}es), or an empty list if none
	 */ 	
	public EList getSignals(EClassifier owner);
	
	/**
	 * Determines whether the specified <code>operation</code> is a query
	 * operation.
	 * 
	 * @param operation an operation
	 * @return whether it is a query operation
	 */
	boolean isQuery(EOperation operation);
	
	/**
	 * Gets the qualifiers of a property representing a UML association end.
	 * 
	 * @param property a property of the model class
	 * @return the qualifiers (as a list of {@link EStructuralFeature}s, or an
	 *     empty list if the property has no qualifiers
	 */
	EList getQualifiers(EStructuralFeature property);

	/**
	 * Determines whether the specified <code>eclass</code> is an association
	 * class.
	 * 
	 * @param eclass an Ecore class
	 * @return whether it is an association class
	 */
	boolean isAssociationClass(EClass eclass);
	
	/**
	 * Obtains the association class that the specified reference represents,
	 * as an {@link EClass}, if any.  This gets the "class" aspect of the
	 * association class, for which the reference represents the "association"
	 * aspect.
	 * 
	 * @param reference a reference
	 * @return the association class, or <code>null</code> if the reference
	 *     does not represent an association class
	 */
	EClass getAssociationClass(EReference reference);
	
	/**
	 * Obtains the ends of the specified association class as a list of
	 * {@link EReference}s.
	 * 
	 * @param associationClass an EClass representing an association class
	 * @return the {@link EReference}s representing its member ends (the
	 *     association roles)
	 */
	EList getMemberEnds(EClass associationClass);
	
	/**
	 * Adds a variable declaration to the environment.
	 * If the name is null, then a new unique temporary name is generated.
	 * @param name
	 * @param elem -- variable declaration
	 * @param imp -- is the variable implicit?
	 * @return - boolean
	 */	
	public boolean addElement(String name, Variable elem, boolean imp);
	
	/**
	 * Removes a name when it goes out of scope.
	 * @param name
	 */
	public void deleteElement(String name);
	
	/**
	 * Returns the {@link Variable}s registered in me explicitly.
	 * 
	 * @return my variable declarations
	 */
	public Collection getVariables();
		
	/**
	 * Sets the "self" variable that is the implicit source of any attribute,
	 * association end, or operation call.
	 * 
	 * @param var the "self" variable
	 */
	public void setSelfVariable(Variable var);
	
	/**
	 * Gets the self variable, looking it up in a parent environment if necessary.
	 * 
	 * @return the self variable, or <code>null</code> if none (which should not
	 *     happen as there is always <i>some</i> classifier context)
	 */
	public Variable getSelfVariable();
	
	/**
	 * Return the most appropriate matching variable to use as the implicit
	 * source of a call to the specified property.  Variables are returned based
	 * on inner-most scope first.
	 * 
	 * @param name the property name
	 * 
	 * @return the matching variable
	 */
	public Variable lookupImplicitSourceForProperty(String name);
	
	/**
	 * Return the variable declaration in namedElements which references the
	 * named association class.  Variables are returned based on inner-most
	 * scope first.
	 * 
	 * @param name the association class name to seek
	 * @return the matching variable declaration, or <code>null</code> if none
	 *     is found
	 */	
	public Variable lookupImplicitSourceForAssociationClass(String name);
	
	/** Return the Variable declaration in namedElements which contains the
	 * name as an EOperation.  Variables are returned based on inner-most scope first.
	 * @param name
	 * @return the matching variable declaration
	 */
	public Variable lookupImplicitSourceForOperation(String name, EList params)
							throws SemanticException;
	
	/**
	 * Obtains the user-presentable description of a named Ecore element.
	 * For example, this might be the type name of an
	 * {@link org.eclipse.emf.ecore.ETypedElement} (the user model name)
	 * or the localized metaclass name of the underlying adapted element
	 * in the case of an {@link EClassifier}.
	 * 
	 * @param namedElement a named element obtained by adaptation of a user
	 *     model element
	 * @return the named element's description
	 */
	String getDescription(ENamedElement namedElement);
			
}

	

	