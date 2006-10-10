/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006 IBM Corporation and others.
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

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.internal.parser.LazyExtentMap;
import org.eclipse.emf.ocl.types.impl.TypeUtil;


/**
 * Partial implementation of the {@link EnvironmentFactory} interface, useful
 * for subclassing for client metamodels.  This abstract class takes care of
 * some of the more common (and mundane) chores, such as:
 * <ul>
 *   <li>defining the "self" variable in the classifier context</li>
 *   <li>converting types to corresponding OCL types wherever possible.  This
 *       includes primitive types that have OCL counterparts, as well as
 *       collection types</li>
 * </ul>
 * <p>
 * The subclass's responsibility is to define how to:
 * </p>
 * <ul>
 *   <li>{@linkplain #asEClassifier(Object) adapt} an OCL classifier in the
 *       client metamodel to the {@link EClassifier} API</li>
 *   <li>{@linkplain #asEOperation(Object) adapt} an OCL operation in the
 *       client metamodel to the {@link EOperation} API</li>
 *   <li>{@linkplain #asEStructuralFeature(Object) adapt} an OCL property in the
 *       client metamodel to the {@link EStructuralFeature} API</li>
 *   <li>{@linkplain #createEnvironment(EPackage)} create an environment in
 *       an {@link EPackage} context (determined from the classifier context)</li>
 *   <li>{@linkplain EnvironmentFactory#createEnvironment(Environment) create}
 *       a nested environment of a parent environment</li>
 * </ul>
 * <p>
 * This class is intended to be extended by clients, for the purpose of
 * implementing metamodel-specified environment factories.
 * </p>
 *
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractEnvironmentFactory
	implements EnvironmentFactory {

	private static final String SELF_NAME = "self"; //$NON-NLS-1$
	
	/**
	 * Initializes me.
	 */
	protected AbstractEnvironmentFactory() {
		super();
	}
	
	/**
	 * Implemented by subclasses to create a new environment implementation on
	 * the specified package context.  The package is obtained from the
	 * context classifier, which is adapted from the client metamodel by the
	 * {@link #asEClassifier(Object)} method.
	 * 
	 * @param packageContext the OCL package context (not <code>null</code>)
	 * @return the corresponding environment
	 */
	protected abstract Environment createEnvironment(EPackage packageContext);
	
	/**
	 * Adapts the specified client metamodel <code>context</code> to the
	 * {@link EClassifier} API.  This might just return the <code>context</code>
	 * if it already is an {@link EClassifier}, or might return its type if it
	 * is an instance of an <code>EClassifier</code>, or adapt it by some other
	 * means to the <code>EClassifier</code> API.
	 * 
	 * @param context a classifier in the client metamodel's definition of
	 *     what an OCL classifier is, or an instance thereof
	 * @return the Ecore representation of the client's classifier
	 */
	protected abstract EClassifier asEClassifier(Object context);
	
	/**
	 * Adapts the specified client metamodel <code>operation</code> to the
	 * {@link EOperation} API.
	 * 
	 * @param operation an operation in the client metamodel's definition of
	 *     what an OCL operation is
	 * @return the Ecore representation of the client's operation
	 */
	protected abstract EOperation asEOperation(Object operation);
	
	/**
	 * Adapts the specified client metamodel <code>property</code> to the
	 * {@link EStructuralFeature} API.
	 * 
	 * @param property a property in the client metamodel's definition of
	 *     what an OCL property is
	 * @return the Ecore representation of the client's property
	 */
	protected abstract EStructuralFeature asEStructuralFeature(Object property);
	
	public Environment createClassifierContext(Object context) {
		return createClassifierContext(asEClassifier(context));
	}

	public Environment createPackageContext(List pathname) {
		EPackage defaultPackage = EcoreEnvironment.findPackage(pathname);
		if (defaultPackage != null) {
			return new EcoreEnvironment(defaultPackage);
		}
		return null;
	}
	
	public Environment createOperationContext(Object context, Object operation) {
		return createOperationContext(
			asEClassifier(context),
			asEOperation(operation));
	}
	
	public Environment createPropertyContext(Object context, Object property) {
		return createPropertyContext(
			asEClassifier(context),
			asEStructuralFeature(property));
	}

	/**
	 * Default evaluation environment is implemented as a {@link java.util.Map}
	 * of {@link String} ==&gt; {@link Object}.
	 */
	public EvaluationEnvironment createEvaluationEnvironment() {
		return new EvalEnvironment();
	}

	/**
	 * Creates an environment for OCL constraints in the context of the
	 * specified <code>classifier</code>.
	 * 
	 * @param classifier the context classifier
	 * @return the OCL environment
	 */
	private Environment createClassifierContext(EClassifier classifier) {
		Environment result = createEnvironment(classifier.getEPackage());
		
		// in case it corresponds to an OCL primitive type
		classifier = TypeUtil.getOCLType(classifier);

		Variable self = createVariable(SELF_NAME, classifier);
		result.addElement(self.getName(), self, true);
		result.setSelfVariable(self);
		
		return result;
	}

	/**
	 * Creates an environment for OCL constraints in the context of the
	 * specified <code>classifier</code> and <code>operation</code>.
	 * This is useful when defining constraints on the redefinition of an
	 * operation in the context of a classifier that inherits it (i.e.,
	 * different from the classifier that defines the operation).
	 * 
	 * @param classifier the context classifier
	 * @param operation the operation context
	 * @return the OCL environment
	 * 
	 * @see #createOperationContext(EOperation)
	 */
	private Environment createOperationContext(EClassifier classifier,
			EOperation operation) {
		Environment classifierEnv = createClassifierContext(classifier);
		Environment result = createEnvironment(classifierEnv);
		
		for (Iterator iter = operation.getEParameters().iterator(); iter.hasNext();) {
			EParameter next = (EParameter) iter.next();
			
			// ensure that we use the OCL primitive types wherever possible
			Variable var = createVariable(
				next.getName(),
				TypeUtil.getOCLType(next));
			var.setRepresentedParameter(next);
			
			result.addElement(var.getName(), var, true);
		}
		
		if (result instanceof EcoreEnvironment) {
			((EcoreEnvironment) result).setContextOperation(operation);
		}
		
		return result;
	}

	/**
	 * Creates an environment for OCL constraints in the context of the
	 * specified <code>classifier</code> and <code>property</code>.
	 * This is useful when defining constraints on the redefinition of a
	 * property in the context of a classifier that inherits it (i.e.,
	 * different from the classifier that defines the property).
	 * 
	 * @param classifier the context classifier
	 * @param property the property context
	 * @return the OCL environment
	 * 
	 * @see #createPropertyContext(Object, Object)
	 */
	private Environment createPropertyContext(EClassifier classifier,
			EStructuralFeature property) {
		Environment classifierEnv = createClassifierContext(classifier);
		Environment result = createEnvironment(classifierEnv);
		
		if (result instanceof EcoreEnvironment) {
			((EcoreEnvironment) result).setContextProperty(property);
		}
		
		return result;
	}
	
	/**
	 * Default implementation considers the resource containing an EObject as
	 * defining the scope of the OCL classifier extents.  In the case that the
	 * specified <code>object</code> is not an {@link EObject}, we have no
	 * access to any such scope, so all extents will be empty.
	 */
	public Map createExtentMap(Object object) {
		if (object instanceof EObject) {
			return new LazyExtentMap((EObject) object);
		}
		
		return Collections.EMPTY_MAP;
	}
	
	/**
	 * Creates a variable declaration of the specified name and type.
	 * 
	 * @param name the variable name
	 * @param type the variable's type
	 * @return the variable declaration
	 */
	private static Variable createVariable(
			String name, EClassifier type) {
		
		Variable result =
			ExpressionsFactory.eINSTANCE.createVariable();		
		result.setName(name);
		result.setType(type);
		
		return result;
	}

}
