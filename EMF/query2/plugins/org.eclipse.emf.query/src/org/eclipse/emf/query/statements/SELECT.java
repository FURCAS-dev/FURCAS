/**
 * <copyright>
 *
 * Copyright (c) 2002, 2007 IBM Corporation and others.
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

package org.eclipse.emf.query.statements;

import java.util.ConcurrentModificationException;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query.internal.EMFQueryPlugin;
import org.eclipse.emf.query.internal.EMFQueryStatusCodes;
import org.eclipse.emf.query.internal.statements.QueryResultSet;
import org.eclipse.emf.query.internal.statements.QueryStatement;

/**
 * <p>
 * The select statement &quot;selects&quot; certain EObjects from the
 *  &quot;from&quot; clause that match the &quot;where&quot; clause.
 * </p>
 * <p>
 * The statement is further customizable to restrict the result set
 *  to be bounded by a certain maximum size and to allow the query to
 *  be cancellable.
 * </p>
 * 
 * @author Yasser Lulu 
 */
public class SELECT
	extends QueryStatement {

	public static final int UNBOUNDED = 0;

	private FROM from;

	private WHERE where;

	private int maximumResultSize;

	private TreeIterator<EObject> it;

	public SELECT(FROM from, WHERE where) {
		this(true, from, where);
	}

	public SELECT(boolean cancellable, FROM from, WHERE where) {
		this(UNBOUNDED, cancellable, from, where);
	}

	public SELECT(int maximumResultSize, FROM from, WHERE where) {
		this(maximumResultSize, true, from, where);
	}

	public SELECT(int maximumResultSize, boolean cancellable, FROM from,
		WHERE where) {
		this(maximumResultSize, cancellable, from, where,
			new NullProgressMonitor());
	}

	public SELECT(int maximumResultSize, boolean cancellable, FROM from,
		WHERE where, IProgressMonitor progressMonitor) {
		super(cancellable, progressMonitor);
		this.from = from;
		this.where = where;
		//streamline: any maximumResultSize <= 0 make it UNBOUNDED
		this.maximumResultSize = (maximumResultSize < 0) ? UNBOUNDED
			: maximumResultSize;
	}

	/**
	 * Performs the statement execution.
	 * 
	 * @see QueryStatement#execute()
	 */
	@Override
	protected void doExecute() {
		it = getFromClause().iterator();
		doResume();
	}

	@Override
	protected void handleException(Exception exception, String functionName) {
		it = null;
		super.handleException(exception, functionName);
	}

	@Override
	public boolean canBeResumed() {
		try {
			return ((it != null) && (it.hasNext()));
			//usually hasNext() never throw exception but just to be safe
		} catch (ConcurrentModificationException ex) {
			EMFQueryPlugin.catching(getClass(), "canBeResumed", ex); //$NON-NLS-1$
			EMFQueryPlugin.warning(
				EMFQueryStatusCodes.IGNORED_EXCEPTION_WARNING, ex.getMessage(),
				ex);
			it = null;
			return false;
		}
	}

	/**
	 * @see org.eclipse.emf.query.internal.statements.QueryStatement#doResume()
	 */
	@Override
	protected void doResume() {
		EObject eObject = null;
		//must set the newly created result-set
		setResultSet(new QueryResultSet());
		boolean canPrune = getFromClause().canBePruned();
		WHERE whereClause = getWhereClause();
		while (it.hasNext() && (isCancelled() == false)) {
			eObject = it.next();
			if (whereClause.matches(eObject)) {
				addEObject(eObject);
				if (getResultSet().size() == maximumResultSize) {
					break;
				}
			}
			if (canPrune && whereClause.shouldPrune(eObject)) {
				it.prune();
			}
			// a dummy update
			getProgressMonitor().worked(WORK_UNIT);
		} //while

		if (it.hasNext() == false) {
			it = null;
		}
		if (isCancelled()) {
			((QueryResultSet)getResultSet()).cancel();
			it = null;
		}

	}

	protected void addEObject(EObject eObject) {
		getResultSet().add(eObject);
	}

	protected boolean isCancelled() {
		return (isCancellable() && (getProgressMonitor().isCanceled()));
	}

	private FROM getFromClause() {
		return from;
	}

	private WHERE getWhereClause() {
		return where;
	}

	@Override
	public final IQueryResult execute() {		
		return super.execute();
	}

	@Override
	public final Set<? extends EObject> getEObjects() {
		return super.getEObjects();
	}

	@Override
	public final IQueryResult resume(IProgressMonitor progressMon) {
		return super.resume(progressMon);
	}
}