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
 * $Id: ChooseDialog.java,v 1.1 2008/05/26 12:25:13 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.sections.widgets;

import org.eclipse.emf.ecoretools.tabbedproperties.internal.Messages;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * The dialog used to choose between the different objects
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ChooseDialog extends SelectionDialog {

	/**
	 * The default width of a dialog
	 */
	private int DEFAULT_DIALOG_WIDTH = 400;

	/**
	 * The default height of a dialog
	 */
	private int DEFAULT_DIALOG_HEIGHT = 300;

	/**
	 * The minimum width of a dialog
	 */
	private int MIN_DIALOG_WIDTH = 300;

	/**
	 * The minimum height of a dialog
	 */
	private int MIN_DIALOG_HEIGHT = 300;

	private SearchableTree tree;

	private ILabelProvider labelProvider;

	private Object[] objects;

	/**
	 * Wrapper to adapt the ArrayContentProvider to a TreeViewer
	 * 
	 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
	 */
	private class TreeArrayContentProvider extends ArrayContentProvider implements ITreeContentProvider {

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
		 */
		public Object[] getChildren(Object parentElement) {
			return new Object[0];
		}

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 */
		public Object getParent(Object element) {
			return null;
		}

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
		 */
		public boolean hasChildren(Object element) {
			return false;
		}

	}

	/**
	 * Constructor
	 * 
	 * @param parentShell
	 *            the paren shell
	 * @param objects
	 *            The available objects
	 */
	public ChooseDialog(Shell parentShell, Object[] objects) {
		super(parentShell);
		this.objects = objects;

		setTitle(Messages.ChooseDialog_ChooseDialog_title);
		setMessage(Messages.ChooseDialog_ChooseDialog_message);
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	/**
	 * @see org.eclipse.ui.dialogs.SelectionDialog#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	protected void configureShell(Shell shell) {
		shell.setMinimumSize(MIN_DIALOG_WIDTH, MIN_DIALOG_HEIGHT);

		super.configureShell(shell);
	}

	/**
	 * Create the Dialog area
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createDialogArea(Composite parent) {
		// Dialog
		Composite dialogComposite = (Composite) super.createDialogArea(parent);

		GridLayout dialogLayout = new GridLayout();
		dialogLayout.marginWidth = 10;
		dialogLayout.marginHeight = 10;
		GridData dialogLayoutData = new GridData(GridData.FILL_BOTH);
		dialogLayoutData.widthHint = DEFAULT_DIALOG_WIDTH;
		dialogLayoutData.heightHint = DEFAULT_DIALOG_HEIGHT;
		dialogComposite.setLayout(dialogLayout);
		dialogComposite.setLayoutData(dialogLayoutData);

		tree = new SearchableTree(dialogComposite, SWT.SINGLE);
		tree.setLayoutData(new GridData(GridData.FILL_BOTH));
		tree.setContentProvider(new TreeArrayContentProvider());
		tree.setLabelProvider(this.labelProvider);

		tree.setInput(this.objects);
		tree.setInitialSelection(new StructuredSelection(getInitialElementSelections()));

		hookListeners();

		return dialogComposite;
	}

	/**
	 * This method had the UI listeners on the SWT widgets
	 */
	private void hookListeners() {
		tree.getTreeViewer().addOpenListener(new IOpenListener() {

			/**
			 * @see org.eclipse.jface.viewers.IOpenListener#open(org.eclipse.jface.viewers.OpenEvent)
			 */
			public void open(OpenEvent event) {
				okPressed();
			}
		});
	}

	/**
	 * Set the provider that displays the objects
	 * 
	 * @param provider
	 *            the LabelProvider
	 */
	public void setLabelProvider(ILabelProvider provider) {
		this.labelProvider = provider;
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	protected void okPressed() {
		IStructuredSelection selection = (IStructuredSelection) tree.getTreeViewer().getSelection();
		setResult(selection.toList());
		super.okPressed();
	}

}