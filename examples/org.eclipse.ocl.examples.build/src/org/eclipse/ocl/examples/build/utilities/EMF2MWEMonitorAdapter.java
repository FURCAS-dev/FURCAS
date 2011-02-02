/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EMF2MWEMonitorAdapter.java,v 1.1 2011/02/02 18:51:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Enable Acceleo's EMF Monitor to interact with MWE's ProgressMonitor.
 */
public class EMF2MWEMonitorAdapter implements Monitor
{
	private ProgressMonitor monitor;
	
	public EMF2MWEMonitorAdapter (ProgressMonitor monitor) {
		this.monitor = monitor;
	}
	
	public void beginTask(String name, int totalWork) {
		monitor.beginTask(name, totalWork);
	}

	public void clearBlocked() {
	}

	public void done() {
		monitor.done();
	}

	public void finished(Object element, Object context){		
		monitor.finished(element, context);
	}

	public void internalWorked(double work) {
		monitor.internalWorked(work);
	}

	public boolean isCanceled() {
		return monitor.isCanceled();
	}

	public void postTask(Object element, Object context) {
		monitor.postTask(element, context);
	}

	public void preTask(Object element, Object context) {
		monitor.preTask(element, context);
	}

	public void setBlocked(Diagnostic diagnostic) {
	}

	public void setCanceled(boolean value) {
		monitor.setCanceled(value);
	}

	public void setTaskName(String name) {
		monitor.setTaskName(name);
	}

	public void started(Object element, Object context){
		monitor.started(element, context);
	}

	public void subTask(String name) {
		monitor.subTask(name);
	}

	public void worked(int work) {
		monitor.worked(work);
	}
}
