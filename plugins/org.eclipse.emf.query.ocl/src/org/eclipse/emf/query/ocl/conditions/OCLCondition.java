/**
 * <copyright>
 *
 * Copyright (c) 2002-2006 IBM Corporation and others.
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
 * $Id: OCLCondition.java,v 1.1 2006/02/13 16:12:06 cdamus Exp $
 */

package org.eclipse.emf.query.ocl.conditions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.IEStructuralFeatureValueGetter;
import org.eclipse.emf.query.handlers.PruneHandler;
import org.eclipse.emf.query.internal.EMFQueryPlugin;

/**
 * An abstract OCL condition class, used to apply OCL expressions to
 * <code>EObject</code>s. It allows the integration of OCL expressions with other
 * <code>EObjectCondition</code>s.
 * <p>
 * This supports OCL expressions with or without an OCL classifier
 * (<code>EClass</code>) context.  Expressions that have no OCL classifier context
 * are {@linkplain #isContextFree() context-free}.  Such conditions are useful
 * in situations where either the elements on which the expressions will be
 * evaluated are of an unknown type or where the same expression might be
 * applicable to multiple, unrelated context types.
 * </p>
 * <p>
 * <b>Note</b> that this class is not intended to be extended "directly"
 * by clients.  Clients may extend the <code>OCLConstraintCondition</code> class.
 * </p>
 * 
 * @see OCLConstraintCondition
 */
public abstract class OCLCondition
	extends EObjectCondition {

	private final EClass contextEObjectType;

	private String oclExpressionString;

	private Query oclQuery;

	private IEStructuralFeatureValueGetter eStructuralFeatureValueGetter;

	private Map contextFreeOclQueriesMap;

	/**
	 * A datastructure to be used with context-free conditions to hold queries
	 * applicable to a type, or <code>null</code> if the OCL expression is not
	 * applicable
	 */
	private static class OclQueryCacheEntry {

		private EClass contextEClass;

		private Query cachedOclQuery;

		/**
		 * Initializes a new entry mapping a context EClass to a query.
		 * 
		 * @param contextEClass the context EClass.  Must not be <code>null</code>
		 * @param oclQuery the OCL query.  May be <code>null</code>
		 */
		OclQueryCacheEntry(EClass contextEClass, Query oclQuery) {
			this.contextEClass = contextEClass;
			this.cachedOclQuery = oclQuery;
		}

		/**
		 * Obtains my cached OCL query.
		 * 
		 * @return my OCL query
		 */
		Query getCachedOclQuery() {
			return cachedOclQuery;
		}

		/**
		 * Obtains my context EClass.
		 * 
		 * @return my context class
		 */
		EClass getContextEClass() {
			return contextEClass;
		}

		/**
		 * Queries whether I have cached an OCL query.
		 * 
		 * @return <code>true</code> if I have a cached query;
		 *     <code>false</code>, otherwise
		 */
		boolean hasOclQuery() {
			return (getCachedOclQuery() != null);
		}
	}

	/**
	 * Initializes a query condition with an OCL expression string, an
	 * <code>EClass</code> representing the <code>EObject</code> type which the OCL
	 * expression uses as a context, and an
	 * <code>IEStructuralFeatureValueGetter</code> to use to get values of
	 * <code>EStructuralFeature</code>s referenced by the OCL
	 * expression. It defaults to using <code>PruneHandler.NEVER</code> to consult
	 * for pruning.
	 * <p>
	 * <b>NOTE: </b> if <code>contextEObjectType</code> is <code>null</code>,
	 * then this becomes a context-free OCL condition.
	 * </p>
	 * 
	 * @param oclExpressionString
	 *            The OCL expression to apply when evaluating this
	 *            <code>OCLCondition</code>
	 * @param contextEObjectType
	 *            The <code>EClass</code> representing the OCL context classifier.
	 *            Use <code>null</code> to create a context-free
	 *            <code>OCLCondition</code>.
	 * @param eStructuralFeatureValueGetter
	 *            The strategy for accessing structural feature values. It
	 *            serves as a layer of indirection to allow clients to intervene
	 *            between this condition object and the way it extracts the
	 *            <code>EStructuralFeature</code>s' values so
	 *            as to allow for manipulation of such values before subjecting
	 *            them to evaluation by the OCL interpreter.
	 */
	protected OCLCondition(String oclExpressionString,
			EClass contextEObjectType,
			IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
		this(oclExpressionString, contextEObjectType,
			eStructuralFeatureValueGetter, PruneHandler.NEVER);
	}

	/**
	 * Initializes a query condition with an OCL expression string, an
	 * <code>EClass</code> representing the <code>EObject</code> type which the OCL
	 * expression uses as a context, an <code>IEStructuralFeatureValueGetter</code>
	 * to use to get values of <code>EStructuralFeature</code>s
	 * referenced by the OCL expression, and a <code>PruneHandler</code> to consult
	 * for pruning the content tree.
	 * <p>
	 * <b>NOTE: </b> if <code>contextEObjectType</code> is <code>null</code>,
	 * then this becomes a context-free OCL condition.
	 * </p>
	 * 
	 * @param oclExpressionString
	 *            The OCL expression to apply when evaluating this
	 *            <code>OCLCondition</code>
	 * @param contextEObjectType
	 *            The <code>EClass</code> representing the OCL context classifier.
	 *            Use <code>null</code> to create a context-free
	 *            <code>OCLCondition</code>.
	 * @param eStructuralFeatureValueGetter
	 *            The strategy for accessing structural feature values. It
	 *            serves as a layer of indirection to allow clients to intervene
	 *            between this condition object and the way it extracts the
	 *            <code>EStructuralFeature</code>s' values so
	 *            as to allow for manipulation of such values before subjecting
	 *            them to evaluation by the OCL interpreter.
	 * @param pruneHandler
	 *            The <code>PruneHandler</code> to consult when pruning
	 */
	protected OCLCondition(String oclExpressionString,
		EClass contextEObjectType,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
		PruneHandler pruneHandler) {
		super(pruneHandler);
		this.oclExpressionString = oclExpressionString;
		this.contextEObjectType = contextEObjectType;
		this.eStructuralFeatureValueGetter = eStructuralFeatureValueGetter;
		if (contextEObjectType != null) {
			this.oclQuery = QueryFactory.eINSTANCE.createQuery(oclExpressionString,
				contextEObjectType);
		}
	}

	/**
	 * Initializes a query condition with a compiled OCL query, an
	 * <code>EClass</code> representing the <code>EObject</code> type which the OCL
	 * expression uses as a context, an <code>IEStructuralFeatureValueGetter</code>
	 * to use to get values of <code>EStructuralFeature</code>s
	 * referenced by the OCL expression, and a <code>PruneHandler</code> to consult
	 * for pruning the content tree.
	 * 
	 * @param oclQuery
	 *            The OCL query to apply when evaluating this
	 *            <code>OCLCondition</code>
	 * @param contextEObjectType
	 *            The <code>EClass</code> representing the OCL context classifier.
	 *            Must not be <code>null</code>.
	 * @param eStructuralFeatureValueGetter
	 *            The strategy for accessing structural feature values. It
	 *            serves as a layer of indirection to allow clients to intervene
	 *            between this condition object and the way it extracts the
	 *            <code>EStructuralFeature</code>s' values so
	 *            as to allow for manipulation of such values before subjecting
	 *            them to evaluation by the OCL interpreter.
	 * @param pruneHandler
	 *            The <code>PruneHandler</code> to consult when pruning
	 */
	protected OCLCondition(Query oclQuery,
		EClass contextEObjectType,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
		PruneHandler pruneHandler) {
		super(pruneHandler);
		this.oclQuery = oclQuery;
		this.oclExpressionString = oclQuery.queryText();
		
		if (contextEObjectType == null) {
			throw new NullPointerException("null contextEObjectType"); //$NON-NLS-1$
		}
		
		this.contextEObjectType = contextEObjectType;
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
	protected final Query getOclQuery() {
		return oclQuery;
	}

	/**
	 * Checks to see if an <code>eObject</code> is of a type conformant to the
	 * context of this <code>OCLCondition</code>.
	 * 
	 * @see #getContextEObjectType()
	 * @see #isContextFree()
	 */
	public boolean isSatisfied(EObject eObject) {
		if (isContextFree() == false) {
			return getContextEObjectType().isInstance(eObject);
		} else {
			return getOclQueryRecord(eObject.eClass()).hasOclQuery();
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
	 *         returned).  This may be an <code>EClass</code> from your EMF metamodel
	 *         or it may be an <code>EDataType</code>
	 *         representing a Java language type
	 * 
	 * @see #isContextFree()
	 * @see #evaluate(EObject)
	 */
	public EClassifier getResultType(EObject eObject) {
		if (isContextFree() == false) {
			return getOclQuery().resultType();
		} else if (eObject != null) {
			Query query = getOclQueryRecord(eObject.eClass())
				.getCachedOclQuery();
			if (query != null) {
				return query.resultType();
			}
		} else if (getOclQueryRecordMap().isEmpty() == false) {
			Iterator it = getOclQueryRecordMap().values().iterator();
			while (it.hasNext()) {
				Query query = ((OclQueryCacheEntry) it.next())
					.getCachedOclQuery();
				if (query != null) {
					return query.resultType();
				}
			}
		}
		return null;
	}

	/**
	 * Obtains the cache of <code>OclQueryCacheEntry</code>s.
	 * 
	 * @return the query cache
	 */
	private Map getOclQueryRecordMap() {
		if (contextFreeOclQueriesMap == null) {
			contextFreeOclQueriesMap = new HashMap();
		}
		return contextFreeOclQueriesMap;
	}

	/**
	 * Obtains a query cache entry for the specified context classifier.
	 * 
	 * @param contextEClass the context classifier
	 * @return the corresponding cache entry, or <code>null</code> if there is
	 *     nothing in the cache for this context classifier
	 */
	private OclQueryCacheEntry getOclQueryRecord(EClass contextEClass) {
		OclQueryCacheEntry oclQueryRecord = (OclQueryCacheEntry) getOclQueryRecordMap()
			.get(contextEClass);
		if (oclQueryRecord == null) {
			Query query = null;
			try {
				query = QueryFactory.eINSTANCE.createQuery(oclExpressionString,
					contextEClass);
			} catch (Exception ex) {
				EMFQueryPlugin.catching(getClass(), "getOclQueryRecord", ex); //$NON-NLS-1$
				query = null;
			}
			oclQueryRecord = new OclQueryCacheEntry(contextEClass, query);
			getOclQueryRecordMap().put(oclQueryRecord.getContextEClass(),
				oclQueryRecord);
		}
		//must set the oclQuery even if null
		oclQuery = oclQueryRecord.getCachedOclQuery();
		return oclQueryRecord;
	}

	/**
	 * Queries whether this <code>OCLCondition</code> is context-free.
	 * 
	 * @return <code>true</code> if this is a context-free OCL condition;
	 *     <code>false</code>, otherwise
	 * 
	 * @see #getResultType(EObject)
	 * @see #isSatisfied(EObject)
	 */
	protected final boolean isContextFree() {
		return (getContextEObjectType() == null);
	}

	/**
	 * Retrieves the strategy used by this <code>OCLCondition</code> to access
	 * the values of <code>EStructuralFeature</code>s of model
	 * elements.
	 *  
	 * @return the structural feature value accessor
	 */
	public final IEStructuralFeatureValueGetter getEStructuralFeatureValueGetter() {
		return eStructuralFeatureValueGetter;
	}

	/**
	 * Assigns the strategy to be used by this <code>OCLCondition</code> to
	 * access the values of <code>EStructuralFeature</code>s
	 * of model elements.
	 * 
	 * @param eStructuralFeatureValueGetter the structural feature value
	 *     accessor to use
	 */
	public final void setEStructuralFeatureValueGetter(
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
		this.eStructuralFeatureValueGetter = eStructuralFeatureValueGetter;
	}

	/**
	 * Evaluates the OCL condition. Uses context object, if there is any
	 * needed.
	 * 
	 * @param eObject
	 *            Context for evaluation; can be <code>null</code> if the OCL
	 *            expression has no "self" object
	 * @return the result of evaluation:  could be null, a single object
	 *      (either an <code>EObject</code> or a Java object), or any kind of
	 *      collection of such objects
	 */
	public Object evaluate(EObject eObject) {
		if ((isContextFree() == false)
			|| ((eObject != null) && (getOclQueryRecord(eObject.eClass())
				.hasOclQuery()))) {
			if (eObject == null) {
				return getOclQuery().evaluate();
			} else {
				return getOclQuery().evaluate(
					getEStructuralFeatureValueGetter().resolve(eObject));
			}
		}
		return null;
	}

	/**
	 * Return the context <code>EClass</code>.  Could be <code>null</code>
	 * if this is a context-free OCL condition.
	 * 
	 * @return the context OCL classifier
	 * 
	 * @see #isContextFree()
	 */
	protected final EClass getContextEObjectType() {
		return contextEObjectType;
	}

}