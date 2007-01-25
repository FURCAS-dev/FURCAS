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
 *
 * </copyright>
 *
 * $Id: Query.java,v 1.1 2007/01/25 18:24:37 cdamus Exp $
 */

package org.eclipse.ocl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.types.OCLStandardLibrary;


/**
 * An OCL constraint or query.  The query is validated for correctness
 * when it is created.  The query can subsequently be evaluated on a single
 * object or on multiple objects in one operation.
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p>
 * 
 * @author Edith Schonberg (edith)
 * @author Christian W. Damus (cdamus)
 */
public interface Query<C, CLS, E> {
	/**
	 * Obtains the evaluation environment that I use to evaluate OCL expressions.
	 * 
	 * @return my environment
	 */
	EvaluationEnvironment<C, ?, ?, CLS, E> getEvaluationEnvironment();
	
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
	 */
	public Object evaluate();  
	
	/**
	 * Evaluates the query on an object. The query must be a boolean valued
	 * constraint.
	 * 
	 * @param obj an <code>Object</code> or <code>null</code> if the query
	 *     does not require an OCL 'self' context
	 * @return boolean <code>true</code> or <code>false</code> according to
	 *     whether the constraint is met
	 * 
	 * @see #check(List)
	 */
	public boolean check(Object obj);
	
	/**
	 * Evaluates the query on the input list.
	 * The results are returned in a corresponding list of results.
	 * 
	 * @param objects a list of objects to evaluate the query on
	 * @return a list of results, corresponding one-for-one with the
	 *     <code>objects</code>.  Note that result elements may, themselves,
	 *     be collections of multiple results for a single input object.
	 *    In any case, the results conform to the expression's
	 *    {@linkplain #resultType() result type}
	 * 
	 * @see #evaluate(Object)
	 * @see #resultType()
	 */
	public List<?> evaluate(List<?> objects);
			
	/**
	 * Determines whether all of the input objects satisfy the query.
	 * The query must be a boolean-valued constraint.
	 * 
	 * @param objects a list of objects to evaluate the constraint on
	 * @return <code>true</code> if all of the <code>objects</code> satisfy
	 *     the constraint (including the trivial case of an empty input list);
	 *     <code>false</code>, otherwise
	 * 
	 * @see #check(Object)
	 */
	public boolean check(List<?> objects); 
	
	/**
	 * Determines the subset of input objects that satisfy the query.
	 * The query must be a boolean valued constraint.
	 * 
	 * @param objects a list of objects to evaluate the constraint on
	 * @return the subset (possibly empty) of the <code>objects</code> that
	 *      satisfy the constraint
	 */
	public <T> List<T> select(List<T> objects);
	
	/**
	 * Determines the subset of input objects that do not satisfy the
	 * query.  The query must be a boolean valued constraint.
	 * 
	 * @param objects a list of objects to evaluate the constraint on
	 * @return the subset (possibly empty) of the <code>objects</code> that
	 *      do not satisfy the constraint
	 */
	public <T> List<T> reject(List<T> objects);
		
	/**
	 * Obtains the OCL result type of the query.  This may be a classifier
	 * in the user model, or it may represent a pre-defined OCL data type
	 * such as {@link OCLStandardLibrary#getBoolean() Boolean}.
	 * 
	 * @return the query's result type
	 */
	public C resultType(); 
	
	/**
	 * Translates the query back to an OCL text string.
	 * 
	 * @return the text of the OCL query expression
	 */
	public String queryText();
	
	/**
	 * Obtains the mapping of classes to their extents (sets of all instances).
	 * 
	 * @return the map of classes to their extents
     *    
     * @see OCL#setExtentMap
	 */
	public Map<CLS, ? extends Set<? extends E>> getExtentMap();
	
	/**
	 * Obtains the expression that I evaluate (or check as a boolean constraint).
     * 
     * @return my OCL expression
	 */
	OCLExpression<C> getExpression();
}

