
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1)
 * (ActionClass_OBJECTCONTRIBUTION.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.action;

import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.mi.fwk.ModelAdapter;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Implementation of an  (IEditorActionDelegate) Action, 
 * the action gets the editor as context. It typically appears in the toolbar of the editor. 
 *  
 * @author SAP AG
 * @generated
 */
public class ActionActionMoveParameterUp implements IObjectActionDelegate {

	/**
	 * this is the suggested pattern by MIE Fwk , but the variable may be moved to the plugin in the future for GC-reasons. 
	 * @generated
	 */
	private static final TracerI sTracer = TracingManager
			.getTracer(ActionActionMoveParameterUp.class);

	/**
	 * @generated
	 */
	private ISelection theSelection;

	/**
	 * @generated
	 */
	private IWorkbenchPart targetPart;

	/**
	 * Constructor for Action
	 * @generated
	 */
	public ActionActionMoveParameterUp() {
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
				runWithContext(targetPart, action, theSelection);
			}
		} catch (Exception e) {
			sTracer.error(e.getMessage(), e);
		}
	}

	/**
	 * @generated
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// store current context
		theSelection = selection;
		// consider more refined action enablement/disablement  here. 
		action.setEnabled(targetPart != null);
	}

	/**
	 * This is the main method to implement, 
	 * as visible from code above, the method is invoked from the run() method using the current seleciton context, 
	 * once for each entity within the context
	 * You may remove the <code>static</code> context  
	 * @param context
	 * @generated
	 */
	public static void runWithContext(IWorkbenchPart part, IAction action,
			ISelection selection) {

		{
			IStructuredSelection ssel = (IStructuredSelection) selection;
			Object obj = ssel.getFirstElement();

			Object ro = obj;
			if (!(ro instanceof Parameter)) {
				ro = ModelAdapter.getInstance().adaptObject(obj,
						RefObject.class);
			}
			if (ro instanceof Parameter) {
				Parameter modelElement = (Parameter) ro;
				MOFToolEditorPlugin.getDefault().getExecMOFToolDefault()
						.execActionMoveParameterUp(modelElement);

			}

		}
	}

}
