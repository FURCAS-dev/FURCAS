package com.sap.mi.fwk.ui.internal.monitor;

/**
 * Copyright (c) 2008 by SAP AG, Walldorf. http://www.sap.com All rights
 * reserved.
 * 
 * This software is the confidential and proprietary information of SAP AG,
 * Walldorf. You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered
 * into with SAP.
 * 
 */

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * This class acts as bridge between Eclipse {@link IProgressMonitor} and MOIN's
 * pendant {@link com.sap.tc.moin.friends.ProgressMonitor}.
 * 
 * NOT INTENDED TO BE IMPLEMENTED OR SUBCLASSED BY CLIENTS
 * 
 * <p>
 * (c) 2000 - 2009 SAP AG
 * 
 * @author d024127
 * 
 * 
 */
public final class ProgressMonitor extends com.sap.tc.moin.friends.ProgressMonitor {

	private final IProgressMonitor monitor;

	/**
	 * 
	 */
	public ProgressMonitor(final IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.friends.ProgressMonitor#beginTask(java.lang.String,
	 * int)
	 */
	@Override
	public void beginTask(final String name, final int totalWork) {
		this.monitor.beginTask(name, totalWork);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.friends.ProgressMonitor#done()
	 */
	@Override
	public void done() {
		this.monitor.done();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.friends.ProgressMonitor#isCanceled()
	 */
	@Override
	public boolean isCanceled() {
		return this.monitor.isCanceled();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.friends.ProgressMonitor#worked(int)
	 */
	@Override
	public void worked(final int work) {
		this.monitor.worked(work);
	}
}
