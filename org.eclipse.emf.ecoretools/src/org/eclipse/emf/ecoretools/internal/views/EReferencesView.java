/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EReferencesView.java,v 1.6 2008/05/19 09:26:31 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.internal.views;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.internal.Messages;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.progress.WorkbenchJob;

/**
 * This class displays all the references to an EClass
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class EReferencesView extends AnalysisView {

	/**
	 * The ID of the view
	 */
	public static final String VIEW_ID = "org.eclipse.emf.ecoretools.internal.views.EReferencesView"; //$NON-NLS-1$

	private TreeViewer referencesTree;

	/**
	 * The job used to refresh the tree.
	 */
	private Job refreshJob;

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		referencesTree = new TreeViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);

		referencesTree.setContentProvider(new EReferencesContentProvider());
		referencesTree.setLabelProvider(new EReferencesLabelProvider());

		referencesTree.getControl().addDisposeListener(new DisposeListener() {

			/**
			 * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
			 */
			public void widgetDisposed(DisposeEvent e) {
				if (refreshJob != null) {
					refreshJob.cancel();
				}
			}
		});
	}

	/**
	 * @see org.eclipse.emf.ecoretools.internal.views.AnalysisView#refresh(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected void refresh(EObject object) {
		// cancel currently running job first, to prevent unnecessary redraw
		if (refreshJob != null) {
			refreshJob.cancel();
		}

		if (object instanceof EClass) {
			EClass selectedEClass = (EClass) object;
			if (selectedEClass != null) {
				refreshJob = createRefreshJob(selectedEClass);
				refreshJob.schedule(200);
			} else {
				getViewSite().getActionBars().getStatusLineManager().setErrorMessage(Messages.EReferencesView_InvalidSelection);
			}
			// // TODO see whether we want to refresh the view even if the
			// selected element is not an EClass
			// } else {
			// referencesTree.setInput(object);
		}
	}

	private Job createRefreshJob(final EClass selection) {
		Job job = new WorkbenchJob(Messages.EReferencesView_RefreshReferences) {

			/**
			 * @see org.eclipse.ui.progress.UIJob#runInUIThread(org.eclipse.core.runtime.IProgressMonitor)
			 */
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				if (referencesTree.getControl().isDisposed()) {
					return Status.CANCEL_STATUS;
				}
				try {
					referencesTree.getControl().setRedraw(false);

					// TODO Calling setInput() and then refresh() causes a
					// refreshment of the view twice : setInput() should be
					// performed elsewhere.
					referencesTree.setInput(selection);
					referencesTree.refresh();
					referencesTree.expandAll();
				} finally {
					// done updating the tree - set redraw back to true
					referencesTree.getControl().setRedraw(true);
				}
				return Status.OK_STATUS;
			}

		};
		job.setSystem(true);

		return job;
	}
}
