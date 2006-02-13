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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;

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
	public VariableDeclaration lookupLocal(String name);
	
	/**
	 * returns the VariableDeclaration for a variable  
	 * Looks in parent environment scope if not found in current scope.
	 * @param name
	 * @return VariableDeclaration
	 */
	public VariableDeclaration lookup(String name);
	
	
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
	 * Find attribute  in the specified class.
	 * If the class is empty, then search the named Elements table
	 * Checks superclasses also, by using the EAll Ecore operations. 
	 * @param parent -- EClass to search
	 * @param name -- name of attribute
	 * @return EAttribute
	 */ 	
	public EAttribute lookupAttribute(EClassifier parent, String name);
	
	/**
	 * Find reference  in the specified class.
	 * If the class is empty, then search the named Elements table
	 * Checks superclasses also, by using the EAll Ec
	 * @param parent -- EClass to search
	 * @param name of reference
	 * @return EReference
	 */ 	
	public EReference lookupReference(EClassifier parent, String name);
	
	/**
	 * Find reference in the specified class to the named association class.
	 * This is an implicit reference, derived from the existence of one or more
	 * {@link org.eclipse.emf.ocl.uml.AssociationClassEnd}s that are
	 * implemented by the named association class.
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
	 * Adds a variable declaration to the environment.
	 * If the name is null, then a new unique temporary name is generated.
	 * @param name
	 * @param elem -- variable declaration
	 * @param imp -- is the variable implicit?
	 * @return - boolean
	 */	
	public boolean addElement(String name, VariableDeclaration elem, boolean imp);
	
	/**
	 * Removes a name when it goes out of scope.
	 * @param name
	 */
	public void deleteElement(String name);
	
	/**
	 * Returns the {@link VariableDeclaration}s registered in me explicitly.
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
	public void setSelfVariable(VariableDeclaration var);
	
	/**
	 * Gets the self variable, looking it up in a parent environment if necessary.
	 * 
	 * @return the self variable, or <code>null</code> if none (which should not
	 *     happen as there is always <i>some</i> classifier context)
	 */
	public VariableDeclaration getSelfVariable();
	
	/** Return the Variable declaration in namedElements which contains the
	 * name as an EAttribute.  Variables are returned based on inner-most scope first.
	 * @param name
	 * @return the matching variable declaration
	 */
	public VariableDeclaration lookupImplicitSourceForAttribute(String name);
	
	/**
	 * Return the variable declaration in namedElements which contains the
	 * name as an EReference.  Variables are returned based on inner-most scope first.
	 * @param name
	 * @return the matching variable declaration
	 */	
	public VariableDeclaration lookupImplicitSourceForAssociationEnd(String name);
	
	/**
	 * Return the variable declaration in namedElements which references the
	 * named association class.  Variables are returned based on inner-most
	 * scope first.
	 * 
	 * @param name the association class name to seek
	 * @return the matching variable declaration, or <code>null</code> if none
	 *     is found
	 */	
	public VariableDeclaration lookupImplicitSourceForAssociationClass(String name);
	
	/** Return the Variable declaration in namedElements which contains the
	 * name as an EOperation.  Variables are returned based on inner-most scope first.
	 * @param name
	 * @return the matching variable declaration
	 */
	public VariableDeclaration lookupImplicitSourceForOperation(String name, EList params)
							throws antlr.SemanticException;
	
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

	

	