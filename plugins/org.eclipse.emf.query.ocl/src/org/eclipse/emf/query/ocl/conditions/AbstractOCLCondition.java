/**
 * <copyright>
 *
 * Copyright (c) 2002, 2008 IBM Corporation and others.
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
 * $Id: AbstractOCLCondition.java,v 1.3 2008/03/27 19:40:58 cdamus Exp $
 */

package org.eclipse.emf.query.ocl.conditions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.IEStructuralFeatureValueGetter;
import org.eclipse.emf.query.handlers.PruneHandler;
import org.eclipse.emf.query.ocl.internal.OCLPlugin;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.helper.OCLHelper;

/**
 * An abstract OCL condition class, used to apply OCL expressions to
 * <code>EObject</code>s. It allows the integration of OCL expressions with other
 * <code>EObjectCondition</code>s.
 * <p>
 * This supports OCL expressions with or without an OCL classifier context.
 * Expressions that have no OCL classifier context
 * are {@linkplain #isContextFree() context-free}.  Such conditions are useful
 * in situations where either the elements on which the expressions will be
 * evaluated are of an unknown type or where the same expression might be
 * applicable to multiple, unrelated context types.
 * </p><p>
 * <b>Note</b> that this class is not intended to be extended "directly"
 * by clients.  Clients may extend the {@link BooleanOCLCondition} class.
 * </p>
 * 
 * @see BooleanOCLCondition
 */
public abstract class AbstractOCLCondition<C, CLS, E>
	extends EObjectCondition {

	private final C contextClassifier;

	private String oclExpressionString;

	private Query<C, CLS, E> oclQuery;

	private IEStructuralFeatureValueGetter eStructuralFeatureValueGetter;

	private Map<C, OCLQueryCacheEntry<C, CLS, E>> contextFreeOCLQueriesMap;

    private final OCL<?, C, ?, ?, ?, ?, ?, ?, ?, ?, CLS, E> ocl;
    private final EvaluationEnvironment<C, ?, ?, CLS, E> evalEnv;
    
	/**
	 * A datastructure used with context-free conditions to hold queries
	 * applicable to a type, or <code>null</code> if the OCL expression is not
	 * applicable.
	 */
	private static class OCLQueryCacheEntry<C, CLS, E> {

		private C contextClassifier;

		private Query<C, CLS, E> cachedOCLQuery;

		/**
		 * Initializes a new entry mapping a context EClass to a query.
		 * 
		 * @param contextClassifier the context classifier.  Must not be <code>null</code>
		 * @param oclQuery the OCL query.  May be <code>null</code>
		 */
		OCLQueryCacheEntry(C contextClassifier, Query<C, CLS, E> oclQuery) {
			this.contextClassifier = contextClassifier;
			this.cachedOCLQuery = oclQuery;
		}

		/**
		 * Obtains my cached OCL query.
		 * 
		 * @return my OCL query
		 */
        Query<C, CLS, E> getCachedOCLQuery() {
			return cachedOCLQuery;
		}

		/**
		 * Obtains my context classifier.
		 * 
		 * @return my context class
		 */
		C getContextClassifier() {
			return contextClassifier;
		}

		/**
		 * Queries whether I have cached an OCL query.
		 * 
		 * @return <code>true</code> if I have a cached query;
		 *     <code>false</code>, otherwise
		 */
		boolean hasOCLQuery() {
			return getCachedOCLQuery() != null;
		}
	}

	/**
	 * Initializes a query condition with an OCL expression string, a context
	 * classifier representing the type of "self" in the OCL expression, and an
	 * <code>IEStructuralFeatureValueGetter</code> to use to resolve the context
     * element for safe access to structural features.
     * It defaults to using <code>PruneHandler.NEVER</code> to consult
	 * for pruning.
	 * <p>
	 * <b>NOTE: </b> if <code>contextClassifier</code> is <code>null</code>,
	 * then this becomes a context-free OCL condition.
	 * </p>
	 * 
     * @param env an OCL environment in which to parse the expression.
     *            Must not be <code>null</code>
	 * @param oclExpressionString
	 *            The OCL expression to apply when evaluating this
	 *            <code>OCLCondition</code>
	 * @param contextClassifier
	 *            The OCL context classifier.
	 *            Use <code>null</code> to create a context-free condition.
	 * @param eStructuralFeatureValueGetter
	 *            The strategy for accessing structural feature values. It
	 *            serves as a layer of indirection to allow clients to intervene
	 *            between this condition object and the way it extracts the
	 *            structural features' values so
	 *            as to allow for manipulation of such values before subjecting
	 *            them to evaluation by the OCL interpreter.
     * 
     * @throws ParserException on failure to parse the specified expression in
     *     the given classifier context, if this is not a context-free query
	 */
	protected AbstractOCLCondition(
            Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, CLS, E> env,
            String oclExpressionString,
			C contextClassifier,
			IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) throws ParserException {
		this(env, oclExpressionString, contextClassifier,
			eStructuralFeatureValueGetter, PruneHandler.NEVER);
	}

	/**
     * Initializes a query condition with an OCL expression string, a context
     * classifier representing the type of "self" in the OCL expression, and an
     * <code>IEStructuralFeatureValueGetter</code> to use to resolve the context
     * element for safe access to structural features, and a prune-handler
     * to consult for pruning the object tree.
	 * <p>
	 * <b>NOTE: </b> if <code>contextClassifier</code> is <code>null</code>,
	 * then this becomes a context-free OCL condition.
	 * </p>
	 * 
     * @param env an OCL environment in which to parse the expression.
     *            Must not be <code>null</code>
	 * @param oclExpressionString
	 *            The OCL expression to apply when evaluating this
	 *            <code>OCLCondition</code>
	 * @param contextClassifier
	 *            The OCL context classifier.
	 *            Use <code>null</code> to create a context-free condition.
	 * @param eStructuralFeatureValueGetter
	 *            The strategy for accessing structural feature values. It
	 *            serves as a layer of indirection to allow clients to intervene
	 *            between this condition object and the way it extracts the
	 *            structural features' values so
	 *            as to allow for manipulation of such values before subjecting
	 *            them to evaluation by the OCL interpreter.
	 * @param pruneHandler
	 *            The <code>PruneHandler</code> to consult when pruning
     *            
     * @throws ParserException on failure to parse the specified expression in
     *     the given classifier context, if this is not a context-free query
	 */
	protected AbstractOCLCondition(
            Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, CLS, E> env,
            String oclExpressionString,
            C contextClassifier,
            IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
            PruneHandler pruneHandler) throws ParserException {
		super(pruneHandler);
        
        this.ocl = OCL.newInstance(env);
        this.evalEnv = env.getFactory().createEvaluationEnvironment();
        
		this.oclExpressionString = oclExpressionString;
		this.contextClassifier = contextClassifier;
		this.eStructuralFeatureValueGetter = eStructuralFeatureValueGetter;
        
		if (contextClassifier != null) {
            OCLHelper<C, ?, ? ,?> helper = ocl.createOCLHelper();
            helper.setContext(contextClassifier);
            
			this.oclQuery = ocl.createQuery(helper.createQuery(oclExpressionString));
		}
	}

	/**
     * Initializes a query condition with compiled OCL query, a context
     * classifier representing the type of "self" in the OCL expression, and an
     * <code>IEStructuralFeatureValueGetter</code> to use to resolve the context
     * element for safe access to structural features, and a
     * <code>PruneHandler</code> to consult for pruning the content tree.
	 * 
     * @param env the OCL environment in which the OCL query was parsed.
     *            Must not be <code>null</code>
	 * @param oclQuery
	 *            The OCL query to apply when evaluating this condition
	 * @param contextClassifier
	 *            The OCL context classifier.  Must not be <code>null</code>.
	 * @param eStructuralFeatureValueGetter
	 *            The strategy for accessing structural feature values. It
	 *            serves as a layer of indirection to allow clients to intervene
	 *            between this condition object and the way it extracts the
	 *            structural features' values so
	 *            as to allow for manipulation of such values before subjecting
	 *            them to evaluation by the OCL interpreter.
	 * @param pruneHandler
	 *            The <code>PruneHandler</code> to consult when pruning
	 */
	protected AbstractOCLCondition(
            Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, CLS, E> env,
            Query<C, CLS, E> oclQuery,
            C contextClassifier,
            IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
            PruneHandler pruneHandler) {
        
		super(pruneHandler);
        
        this.ocl = OCL.newInstance(env);
        this.evalEnv = env.getFactory().createEvaluationEnvironment();
        
		this.oclQuery = oclQuery;
		this.oclExpressionString = oclQuery.queryText();
		
		if (contextClassifier == null) {
			throw new NullPointerException("null contextEObjectType"); //$NON-NLS-1$
		}
		
		this.contextClassifier = contextClassifier;
		this.eStructuralFeatureValueGetter = eStructuralFeatureValueGetter;
	}

	/**
	 * Obtains the query compiled by the
	 * OCL interpreter, which represents the OCL expression.
	 * 
	 * @return the compiled OCL expression.  This can be <code>null</code> if
	 *         the condition is context-free and has not been initialized by
	 *         invocation of the {@link #isSatisfied(EObject)} method
	 * 
	 * @see #isContextFree()
	 * @see #isSatisfied(EObject)
	 * @see #getResultType(EObject)
	 */
	protected final Query<C, CLS, E> getOCLQuery() {
		return oclQuery;
	}

	/**
	 * Checks to see if an <code>eObject</code> is of a type conformant to the
	 * context classifier of this condition.
	 * 
	 * @see #getContextClassifier()
	 * @see #isContextFree()
	 */
	@Override
    public boolean isSatisfied(EObject eObject) {
		if (isContextFree() == false) {
            return evalEnv.isKindOf(eObject, getContextClassifier());
		} else {
			return getOCLQueryRecord(evalEnv.getType(eObject)).hasOCLQuery();
		}
	}

	/**
	 * Returns the type of the ocl expression. <b>Note</b> that the result
	 * can be <code>null</code> in the case of a context-free OCL condition.
	 * <p>
	 * In the case of a context-free OCL condition, a context
	 * <code>eObject</code> is required to guess the result type of the
	 * expression.  It is expected that the condition would subsequently be
	 * evaluated on objects of the same type as the <code>eObject</code>.
	 * </p>
	 * 
	 * @param eObject
	 *            required in the case of a context-free OCL condition, to
	 *            specify a context object.  Otherwise, it is ignored and
	 *            a <code>null</code> value is acceptable
	 * 
	 * @return The type of the OCL expression (that is, the type of objects
	 *         returned).  This may be any classifier from the appropriate
     *         metamodel
	 * 
	 * @see #isContextFree()
	 * @see #evaluate(EObject)
	 */
	public C getResultType(EObject eObject) {
		if (isContextFree() == false) {
			return getOCLQuery().resultType();
		} else if (eObject != null) {
            Query<C, CLS, E> query = getOCLQueryRecord(evalEnv.getType(eObject))
				.getCachedOCLQuery();
			if (query != null) {
				return query.resultType();
			}
		} else if (getOCLQueryRecordMap().isEmpty() == false) {
			for (OCLQueryCacheEntry<C, CLS, E> entry : getOCLQueryRecordMap().values()) {
                Query<C, CLS, E> query = entry.getCachedOCLQuery();
                
				if (query != null) {
					return query.resultType();
				}
			}
		}
		return null;
	}

	/**
	 * Obtains the cache of <code>OCLQueryCacheEntry</code>s.
	 * 
	 * @return the query cache
	 */
	private Map<C, OCLQueryCacheEntry<C, CLS, E>> getOCLQueryRecordMap() {
		if (contextFreeOCLQueriesMap == null) {
			contextFreeOCLQueriesMap = new HashMap<C, OCLQueryCacheEntry<C, CLS, E>>();
		}
		return contextFreeOCLQueriesMap;
	}

	/**
	 * Obtains a query cache entry for the specified context classifier.
	 * 
	 * @param context the context classifier
	 * @return the corresponding cache entry, or <code>null</code> if there is
	 *     nothing in the cache for this context classifier
	 */
	private OCLQueryCacheEntry<C, CLS, E> getOCLQueryRecord(C context) {
		OCLQueryCacheEntry<C, CLS, E> oclQueryRecord = getOCLQueryRecordMap()
			.get(context);
		if (oclQueryRecord == null) {
            Query<C, CLS, E> query = null;
			try {
                OCLHelper<C, ?, ? ,?> helper = ocl.createOCLHelper();
                helper.setContext(context);
                
                query = ocl.createQuery(helper.createQuery(oclExpressionString));
			} catch (Exception ex) {
				OCLPlugin.catching(getClass(), "getOCLQueryRecord", ex); //$NON-NLS-1$
				query = null;
			}
			oclQueryRecord = new OCLQueryCacheEntry<C, CLS, E>(context, query);
			getOCLQueryRecordMap().put(oclQueryRecord.getContextClassifier(),
				oclQueryRecord);
		}
        
		//must set the oclQuery even if null
		oclQuery = oclQueryRecord.getCachedOCLQuery();
		return oclQueryRecord;
	}

	/**
	 * Queries whether this OCL condition is context-free.
	 * 
	 * @return <code>true</code> if this is a context-free OCL condition;
	 *     <code>false</code>, otherwise
	 * 
	 * @see #getResultType(EObject)
	 * @see #isSatisfied(EObject)
	 */
	protected final boolean isContextFree() {
		return (getContextClassifier() == null);
	}

	/**
	 * Retrieves the strategy used by this OCL condition to access
	 * the values of structural featuress of model elements.
	 *  
	 * @return the structural feature value accessor
	 */
	public final IEStructuralFeatureValueGetter getEStructuralFeatureValueGetter() {
		return eStructuralFeatureValueGetter;
	}

	/**
	 * Assigns the strategy to be used by this OCL Condition to
	 * access the values of structural features of model elements.
	 * 
	 * @param eStructuralFeatureValueGetter the structural feature value
	 *     accessor to use
	 */
	public final void setEStructuralFeatureValueGetter(
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
		this.eStructuralFeatureValueGetter = eStructuralFeatureValueGetter;
	}

	/**
	 * Evaluates the OCL condition. Uses a context object, if there is any
	 * needed.
	 * 
	 * @param eObject
	 *            context for evaluation; can be <code>null</code> if the OCL
	 *            expression has no "self" object
	 * @return the result of evaluation:  could be null, a single object
	 *      (either an <code>EObject</code> or a Java object), or any kind of
	 *      collection of such objects
	 */
	public Object evaluate(EObject eObject) {
		if ((isContextFree() == false)
			|| ((eObject != null) && (getOCLQueryRecord(evalEnv.getType(eObject))
				.hasOCLQuery()))) {
			if (eObject == null) {
				return getOCLQuery().evaluate();
			} else {
				return getOCLQuery().evaluate(
					getEStructuralFeatureValueGetter().resolve(eObject));
			}
		}
		return null;
	}

	/**
	 * Return the context classifier.  Could be <code>null</code>
	 * if this is a context-free OCL condition.
	 * 
	 * @return the context OCL classifier
	 * 
	 * @see #isContextFree()
	 */
	protected final C getContextClassifier() {
		return contextClassifier;
	}
	
	/**
	 * {@linkplain OCL#dispose() Disposes} the OCL environment that I
	 * constructed for parsing and evaluation.  This is necessary in order to
	 * ensure that {@link EObject} constructed by the parser are correctly
	 * disposed.
	 * 
	 * @see OCL#dispose()
	 * 
	 * @since 1.2
	 */
	public void dispose() {
	    if (contextFreeOCLQueriesMap != null) {
	        contextFreeOCLQueriesMap.clear();
	    }
	    
	    ocl.dispose(); // implicitly disposes the queries created by it
	}

}