/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1)
 * (ActionClass_ATNOBJECTCONTRIBUTION.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.action;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.tc.moin.repository.Connection;



/**
 * Implementation of an (IObjectActionDelegate) Action targeted at an Artificial Node (explicitely referenced) ,
 * 
 * @author SAP AG
 * @generated
 */
public class ActionActionCreatePackageForRoot implements IObjectActionDelegate {

	// this is the suggested pattern, but the variable may be moved to the plugin in the future for GC-reasons.
	/**
	 * @generated
	 */
	private static final Logger sTracer = Logger.getLogger(ActionActionCreatePackageForRoot.class.getName());

	/**
	 * @generated
	 */
	private ISelection selection;
	/**
	 * @generated
	 */
	private IWorkbenchPart targetPart;

	/**
	 * Constructor for Action1.
	 * 
	 * @generated
	 */
	public ActionActionCreatePackageForRoot() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 * @generated
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}

	/**
	 * @generated
	 */
	public void run(IAction action) {
		try {
			if (targetPart != null) {
				runWithContext(targetPart, action, selection);
			}
		} catch (Exception e) {
			sTracer.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	/**
	 * @generated
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// store current context
		this.selection = selection;
		// consider more refined action enablement/disablement here.
		action.setEnabled(targetPart != null);
	}

	/**
	 * This is the main method to implement, as visible from code above, the method is invoked from the run() method using the current
	 * seleciton context, once for each entity within the context You may remove the <code>static</code> context
	 * 
	 * @param part
	 * @generated
	 */
	public static void runWithContext(IWorkbenchPart part, IAction action, ISelection selection) {	

		Object obj = ((IStructuredSelection) selection).getFirstElement();
		if (!(obj instanceof ITreeNode)) {
			return;
		}

		final Object ro = ((ITreeNode<?>) obj).getValue();
		
		Connection conn = ModelAdapter.getInstance().adaptObject(obj, Connection.class);
		
		if (conn == null && ro instanceof IProject) {
			conn = MofService.createConnectionWithBusyCursorWhile((IProject)ro);
			if (conn == null) {
				return;
			}
		
		}			
		MOFToolEditorPlugin.getDefault().getExecMOFToolDefault().execActionCreatePackageForRoot(conn);				
		

	}

}
