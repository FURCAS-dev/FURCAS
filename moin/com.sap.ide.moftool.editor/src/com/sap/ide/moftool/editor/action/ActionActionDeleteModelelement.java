/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG (MITG-Version0.1) (ActionClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.action;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

/**
 * Implementation of an (IAction based) Action, the action will be used to dynamically (via code) construct
 * contextMenus.
 * 
 * The Action may be independently constructed (Default Constructor) and runWithContext() called in a typed manner
 * directly
 * 
 * @author SAP AG
 * @generated modified
 */
public class ActionActionDeleteModelelement extends AbstractFilteredMoftoolAction<ModelElement> {

	/**
	 * @generated
	 */
	public ActionActionDeleteModelelement() {
		this(StructuredSelection.EMPTY);
	}

	/**
	 * @generated
	 */
	public ActionActionDeleteModelelement(IStructuredSelection selection) {

		super(selection, Messages.ActionActionDeleteModelelement_0_xbut, PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		this.setDisabledImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
				ISharedImages.IMG_TOOL_DELETE_DISABLED));
		this.setId(ActionFactory.DELETE.getId());

	}

	/**
	 * This is the main method to implement, as visible from code above, the method is invoked from the run() method
	 * using the current seleciton context, once for each entity within the context You may remove the
	 * <code>static</code> context
	 * 
	 * @param context
	 * @generated
	 */
	public void runSingleWithContext(ModelElement context) {
			MOFToolEditorPlugin.getDefault().getExecMOFToolDefault().execActionDeleteModelelement(context);
	}

	/**
	 * @generated
	 */
	public static IAction createActionForSelection(IStructuredSelection selection) {
		return new ActionActionDeleteModelelement(selection);
	}
	
	@Override
	protected boolean visibleForContext(RefObject devobj) {
		return true;
	}

}
