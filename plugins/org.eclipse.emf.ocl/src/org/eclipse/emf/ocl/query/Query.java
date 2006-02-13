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

package org.eclipse.emf.ocl.query;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;

/**
 * An OCL constraint or query.  The query is validated for correctness
 * when it is created.  The query can subsequently be evaluated on a single
 * object or on multiple objects in one operation.
 * 
 * @author Edith Schonberg (edith)
 * 
 *
 */
public interface Query extends EObject {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * Sets the evaluation environment that I use to evaluate OCL expressions.
	 * 
	 * @param env my environment
	 * 
	 *
	 */
	void setEvaluationEnvironment(EvaluationEnvironment env);
	
	/**
	 * Obtains the evaluation environment that I use to evaluate OCL expressions.
	 * 
	 * @return my environment
	 * 
	 *
	 */
	EvaluationEnvironment getEvaluationEnvironment();
	
	/**
	 * Evaluates the query on the object.
	 * 
	 * @param obj an <code>Object</code>
	 * 
	 * @return the result of the query, which may be one or more
	 *    {@link EObject}s, Java objects, a mixture, or even <code>null</code>.
	 *    In any case, the results conform to the expression's
	 *    {@linkplain #resultType() result type}
	 * 
	 * @see #evaluate()
	 * @see #evaluate(List)
	 * @see #resultType()
	 * 
	 *
	 */
	public Object evaluate(Object obj);
	
	/**
	 * Evaluates the query. This method is used when there is no 'self' context
	 * required by the query.
	 * Either the query is constant, or uses <code>allInstances()</code>
	 * exclusively for evaluation.
	 * 
	 * @return the result of the query, which may be one or more
	 *    {@link EObject}s, Java objects, a mixture, or even <code>null</code>.
	 *    In any case, the results conform to the expression's
	 *    {@linkplain #resultType() result type}
	 * 
	 * @see #resultType()
	 * 
	 *
	 */
	public Object evaluate();  
	
	/**
	 * Evaluates the query on an object. The query must be a boolean valued
	 * constraint.
	 * 
	 * @param eobj an <code>Object</code> or <code>null</code> if the query
	 *     does not require an OCL 'self' context
	 * @return boolean <code>true</code> or <code>false</code> according to
	 *     whether the constraint is met
	 * 
	 * @see #check(List)
	 * 
	 *
	 */
	public boolean check(Object obj);
	
	/**
	 * Evaluates the query on the input list.
	 * The results are returned in a corresponding list of results.
	 * 
	 * @param eobjects a list of objects to evaluate the query on
	 * @return a list of results, corresponding one-for-one with the
	 *     <code>objects</code>.  Note that result elements may, themselves,
	 *     be collections of multiple results for a single input object.
	 *    In any case, the results conform to the expression's
	 *    {@linkplain #resultType() result type}
	 * 
	 * @see #evaluate(EObject)
	 * @see #resultType()
	 * 
	 * @model type="java.lang.Object"
	 */
	public List evaluate(List objects);
			
	/**
	 * Determines whether all of the input objects satisfy the query.
	 * The query must be a boolean-valued constraint.
	 * 
	 * @param objects a list of objects to evaluate the constraint on
	 * @return <code>true</code> if all of the <code>objects</code> satisfy
	 *     the constraint (including the trivial case of an empty input list);
	 *     <code>false</code>, otherwise
	 * 
	 * @see #check(EObject)
	 * 
	 *
	 */
	public boolean check(List objects); 
	
	/**
	 * Determines the subset of input objects that satisfy the query.
	 * The query must be a boolean valued constraint.
	 * 
	 * @param eobjects a list of objects to evaluate the constraint on
	 * @return the subset (possibly empty) of the <code>objects</code> that
	 *      satisfy the constraint
	 * 
	 * @model type="org.eclipse.emf.ecore.EObject"
	 */
	public List select(List objects);
	
	/**
	 * Determines the subset of input objects that do not satisfy the
	 * query.  The query must be a boolean valued constraint.
	 * 
	 * @param eobjects a list of objects to evaluate the constraint on
	 * @return the subset (possibly empty) of the <code>objects</code> that
	 *      do not satisfy the constraint
	 * 
	 * @model type="org.eclipse.emf.ecore.EObject"
	 */
	public List reject(List objects);
		
	/**
	 * Obtains the OCL result type of the query.  This may be an
	 * {@link EClassifier} in the user metamodel, or it may represent a core
	 * Java language type (such as {@link Boolean} in the case of constraints)
	 * or an OCL data type.
	 * 
	 * @return the query's result type
	 * 
	 *
	 */
	public EClassifier resultType(); 
	
	/**
	 * Translates the query back to an OCL text string.
	 * 
	 * @return the text of the OCL query expression
	 * 
	 *
	 */
	public String queryText();
	
	/**
	 * Obtains the mapping of {@link EClassifier}s representing OCL types to
	 * their extents (set of all instances).
	 * 
	 * @return the map of classifiers ({@link EClassifier}) to their extents
	 *    ({@link List})
	 * 
	 * @see #setExtentMap(Map)
	 * 
	 *
	 */
	public Map getExtentMap();
	
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see org.eclipse.emf.ocl.query.QueryPackage#getQuery_Expression()
	 * @model changeable="false"
	 * @generated
	 */
	OCLExpression getExpression();

	/**
	 * Sets the mapping of {@link EClassifier}s representing OCL types to
	 * their extents (set of all instances).
	 * 
	 * @param extentMap a map of classifiers ({@link EClassifier}) to their
	 *    extents ({@link List})
	 * 
	 * @see #getExtentMap()
	 * 
	 * @generated NOT
	 */
	public void setExtentMap(Map extentMap);
}

