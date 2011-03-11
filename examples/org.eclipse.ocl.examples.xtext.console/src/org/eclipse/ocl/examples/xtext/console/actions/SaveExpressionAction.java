/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - rework of LPG OCL Console for Xtext
 *
 * </copyright>
 *
 * $Id: SaveExpressionAction.java,v 1.1 2011/03/11 20:23:43 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.console.actions;

import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.console.OCLConsolePage;
import org.eclipse.ocl.examples.xtext.console.XtextConsolePlugin;
import org.eclipse.ocl.examples.xtext.console.messages.OCLInterpreterMessages;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.model.BaseDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * An action that saves the last-evaluated OCL expression to an XMI file.
 */
public class SaveExpressionAction extends Action
{
    static Map<String, Object> saveOptions = new java.util.HashMap<String, Object>();
    
    static {
        saveOptions.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, true);
    }

    protected final OCLConsolePage consolePage;
	private final String tip;
	
	/**
	 * Initializes me.
	 */
	public SaveExpressionAction(OCLConsolePage consolePage) {
		super(
			OCLInterpreterMessages.console_saveAction_label,
			ImageDescriptor.createFromURL(
				FileLocator.find(
						XtextConsolePlugin.getInstance().getBundle(),
						new Path("$nl$/icons/elcl16/save.gif"), //$NON-NLS-1$
						null)));
		this.consolePage = consolePage;
		tip = OCLInterpreterMessages.console_saveAction_tip;
	}
	
	@Override
    public String getToolTipText() {
		return tip;
	}
	
	@Override
    public void run() {
		Shell shell = consolePage.getControl().getShell();
		
		if (consolePage.getLastOCLExpression() != null) {
			FileDialog dlg = new FileDialog(shell, SWT.SAVE);
			dlg.setFilterExtensions(new String[] {"*.xmi"}); //$NON-NLS-1$
			dlg.setText(OCLInterpreterMessages.console_saveDlg_title);
			
			final String file = dlg.open();
			if (file != null) {
				try {
					BaseDocument editorDocument = consolePage.getEditorDocument();
					editorDocument.modify(new IUnitOfWork<Object, XtextResource>()
					{
						public Object exec(XtextResource resource) throws Exception {
							CS2PivotResourceAdapter csAdapter = CS2PivotResourceAdapter.getAdapter((BaseCSResource)resource, null);
							csAdapter.refreshPivotMappings();
							Resource pivotResource = csAdapter.getPivotResource(resource);
							pivotResource.setURI(URI.createFileURI(file));
							pivotResource.save(saveOptions);
							return null;
						}
					});
// FIXME			OCLResource.save(file, document, lastOCLExpression);
				} catch (Exception e) {
					MessageDialog.openError(
						shell,
						OCLInterpreterMessages.console_saveError_title,
						e.getLocalizedMessage());
				}
			}
		} else {
			MessageDialog.openWarning(
				shell,
				OCLInterpreterMessages.console_saveWarn_title,
				OCLInterpreterMessages.console_saveWarn_noExpr);
		}
	}
}