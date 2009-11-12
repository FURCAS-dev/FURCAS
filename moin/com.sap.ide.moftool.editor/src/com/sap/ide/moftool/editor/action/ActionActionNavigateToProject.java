/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG (MITG-Version0.1) (ActionClass_ATNOBJECTCONTRIBUTION.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.action;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.ide.moftool.editor.tree.tumcnf.men.NodeUsedMMDCs;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.tc.moin.repository.Connection;



/**
 * Implementation of an (IObjectActionDelegate) Action targeted at an Artificial Node (explicitely referenced) ,
 * 
 * @author SAP AG
 * @generated modified
 */
public class ActionActionNavigateToProject implements IObjectActionDelegate {

	// this is the suggested pattern, but the variable may be moved to the plugin in the future for GC-reasons.
	/**
	 * @generated
	 */
	private static final Logger sTracer = Logger.getLogger(ActionActionNavigateToProject.class.getName());

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
	public ActionActionNavigateToProject() {
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
				runWithContext(targetPart, selection);
			}
		} catch (Exception e) {
			sTracer.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	/**
	 * @modified
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// store current context
		this.selection = selection;

		// Additional enablement (overwritten)
		boolean enabled = false;
		if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			Object object = treeSelection.getFirstElement();
			if (object instanceof NodeUsedMMDCs) {
				NodeUsedMMDCs nodeUsedMMDC = (NodeUsedMMDCs) object;
				IProject project = nodeUsedMMDC.getProjectToNavigateTo();
				if (project != null) {
					enabled = true;
				}
			}
		}
		// consider more refined action enablement/disablement here.
		action.setEnabled(targetPart != null && enabled);
	}

	/**
	 * This is the main method to implement, as visible from code above, the method is invoked from the run() method
	 * using the current seleciton context, once for each entity within the context You may remove the
	 * <code>static</code> context
	 * 
	 * @param part
	 * @generated
	 */
	public static void runWithContext(IWorkbenchPart part, ISelection selection) {
		// vvvvvvvvvvvvvvvvvvvvvvvv^

		{

			Object obj = ((IStructuredSelection) selection).getFirstElement();
			if (!(obj instanceof ITreeNode)) {
				return;
			}

			MOFToolEditorPlugin.getDefault().getExecMOFToolDefault().execActionNavigateToProject(part,
					ModelAdapter.getInstance().adaptObject(obj, Connection.class));

		}
		// ^^^^^^^^^^if proceed ^^^^^^^^^^^^^^

	}

}
