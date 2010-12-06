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

package org.eclipse.emf.query.internal.statements;

import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.eobjects.IEObjectSource;
import org.eclipse.emf.query.internal.EMFQueryPlugin;
import org.eclipse.emf.query.internal.EMFQueryStatusCodes;
import org.eclipse.emf.query.internal.l10n.QueryMessages;
import org.eclipse.emf.query.statements.IQueryResult;

/**
 * @author Yasser Lulu 
 */
public abstract class QueryStatement implements IEObjectSource {
	/** Basic unit of work in tracking query progress. */
    public static final int WORK_UNIT = 1;
    private static final String EXECUTING_QUERY = QueryMessages.QueryStatement_Executing_Query____1_INFO_;
    private QueryResultSet resultSet = new QueryResultSet();
    private boolean cancellable;
    private IProgressMonitor progressMonitor;

    /**
     * Initializes me.
     * 
     * @param cancellable whether I can be canceled
     * @param progressMonitor a monitor to track progress
     */
    public QueryStatement(
        boolean cancellable,
        IProgressMonitor progressMonitor) {
        this.cancellable = cancellable;
        this.progressMonitor = progressMonitor;
    }

    /**
     * Handles an exception by logging and recording it.
     * 
     * @param exception the exception
     * @param functionName the method in which it was caught
     */
    protected void handleException(Exception exception, String functionName) {
        EMFQueryPlugin.catching(getClass(), functionName, exception);
        EMFQueryPlugin.log(EMFQueryStatusCodes.IGNORED_EXCEPTION_WARNING,exception.getMessage(),exception);
        resultSet.clear();
        resultSet.setException(exception);
    }

    /**
     * Execute the query in order to produce a result.
     * 
     * @return The results produced by the query.
     */
    public IQueryResult execute() {
        try {
            getProgressMonitor().beginTask(
                EXECUTING_QUERY,
                IProgressMonitor.UNKNOWN);
            doExecute();
        } catch (Exception exception) {
            handleException(exception, "execute"); //$NON-NLS-1$
        }
        getProgressMonitor().done();
        return getResultSet();
    }

    /**
     * Resume query execution if such an option is available.
     * 
     * @param progressMon The progress monitor to be used by the query
     *  statement while resuming.
     * @return The results of the query execution.
     */
    public IQueryResult resume(IProgressMonitor progressMon) {
        this.progressMonitor = progressMon;
        try {
            if (canBeResumed() == false) {
                IllegalStateException ex = new IllegalStateException("Cannot to resume a query"); //$NON-NLS-1$
                EMFQueryPlugin.throwing(getClass(), "resume", ex); //$NON-NLS-1$
                throw ex;
            }
            getProgressMonitor().beginTask(
                EXECUTING_QUERY,
                IProgressMonitor.UNKNOWN);
            doResume();
        } catch (Exception exception) {
            handleException(exception, "resume"); //$NON-NLS-1$
        }
        getProgressMonitor().done();
        return getResultSet();
    }

    /**
     * Determines whether or not this particular query statement can
     *  be resumed.
     * 
     * @return true (if the statement can be can resumed) or false (otherwise)
     */
    public abstract boolean canBeResumed();
    
    /** Performs the statement. */
    protected abstract void doExecute();
    
    /** Resumes a paused statement. */
    protected abstract void doResume();

    /**
     * Obtains the statement's results.
     * 
     * @return the results
     */
    protected final IQueryResult getResultSet() {
        return resultSet;
    }

    public Set<? extends EObject> getEObjects() {
        return execute().getEObjects();
    }

    /**
     * Assigns the statement's results.
     * 
     * @param set the results
     */
    protected void setResultSet(QueryResultSet set) {
        resultSet = set;
    }

    /**
     * Queries whether the statement can be cancelled.
     * 
     * @return whether the statement is cancellable
     */
    protected boolean isCancellable() {
        return cancellable;
    }

    /**
     * Obtains the monitor tracking the statement's progress.
     * 
     * @return the progress monitor
     */
    protected IProgressMonitor getProgressMonitor() {
        return progressMonitor;
    }

    /**
     * Assigns the monitor tracking the statement's progress.
     * 
     * @param progressMonitor the progress monitor
     */
    protected void setProgressMonitor(IProgressMonitor progressMonitor) {
        this.progressMonitor = progressMonitor;
    }

}
