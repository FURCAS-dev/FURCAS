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
 * $Id: EClassHierarchyView.java,v 1.6 2008/05/19 09:26:31 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.internal.views;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecoretools.internal.Activator;
import org.eclipse.emf.ecoretools.internal.Messages;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.progress.WorkbenchJob;

/**
 * This view analyzes the hierarchy of an EClass (ascendant, descendant...)
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class EClassHierarchyView extends AnalysisView {

	/**
	 * The ID of the view
	 */
	public static final String VIEW_ID = "org.eclipse.emf.ecoretools.internal.views.EClassHierarchyView"; //$NON-NLS-1$

	private static final int ASCENDANT = 0;

	private static final int DESCENDANT = 1;

	private TreeViewer hierarchyTree;

	private int kind = ASCENDANT;

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
		hierarchyTree = new TreeViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);

		hierarchyTree.getControl().addDisposeListener(new DisposeListener() {

			/**
			 * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
			 */
			public void widgetDisposed(DisposeEvent e) {
				if (refreshJob != null) {
					refreshJob.cancel();
				}
			}
		});

		setKind(ASCENDANT);
	}

	/**
	 * Changes the kind of hierarchy displayed in this view
	 * 
	 * @param hierarchyKind
	 *            the new kind of hierarchy
	 */
	private void setKind(int hierarchyKind) {
		kind = hierarchyKind;
		switch (kind) {
		case ASCENDANT:
			hierarchyTree.setContentProvider(new EClassHierarchyContentProvider());
			hierarchyTree.setLabelProvider((new AdapterFactoryLabelProvider(new EcoreItemProviderAdapterFactory())));
			break;
		case DESCENDANT:
			hierarchyTree.setContentProvider(new EClassDescendentHierarchyContentProvider());
			hierarchyTree.setLabelProvider((new AdapterFactoryLabelProvider(new EcoreItemProviderAdapterFactory())));
			break;
		default:
			break;
		}

		refresh();
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
				getViewSite().getActionBars().getStatusLineManager().setErrorMessage(Messages.EClassHierarchyView_InvalidSelection);
			}
		}
	}

	private Job createRefreshJob(final EClass selection) {
		Job job = new WorkbenchJob(Messages.EClassHierarchyView_RefreshHierarchy) {

			/**
			 * @see org.eclipse.ui.progress.UIJob#runInUIThread(org.eclipse.core.runtime.IProgressMonitor)
			 */
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				if (hierarchyTree.getControl().isDisposed()) {
					return Status.CANCEL_STATUS;
				}
				try {
					hierarchyTree.getControl().setRedraw(false);

					hierarchyTree.setInput(new EClass[] { selection });
					hierarchyTree.refresh();
					switch (kind) {
					case ASCENDANT:
						hierarchyTree.expandAll();
						break;
					case DESCENDANT:
						hierarchyTree.expandToLevel(2);
						break;
					default:
						break;
					}
				} finally {
					// done updating the tree - set redraw back to true
					hierarchyTree.getControl().setRedraw(true);
				}
				return Status.OK_STATUS;
			}

		};
		job.setSystem(true);

		return job;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.internal.views.AnalysisView#fillToolBar(org.eclipse.jface.action.IToolBarManager)
	 */
	@Override
	protected void fillToolBar(IToolBarManager toolBar) {
		IAction ascendantAction = new Action(Messages.EClassHierarchyView_Ascendant, IAction.AS_RADIO_BUTTON) {

			@Override
			public void run() {
				EClassHierarchyView.this.setKind(ASCENDANT);
			}
		};
		ascendantAction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/elcl16/super_co.gif")); //$NON-NLS-1$
		ascendantAction.setChecked(true);

		IAction descendantAction = new Action(Messages.EClassHierarchyView_Descendant, IAction.AS_RADIO_BUTTON) {

			@Override
			public void run() {
				EClassHierarchyView.this.setKind(DESCENDANT);
			}
		};
		descendantAction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/elcl16/sub_co.gif")); //$NON-NLS-1$

		toolBar.add(ascendantAction);
		toolBar.add(descendantAction);
		super.fillToolBar(toolBar);
	}
}
