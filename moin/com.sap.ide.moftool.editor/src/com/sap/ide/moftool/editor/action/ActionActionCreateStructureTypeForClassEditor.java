/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG (MITG-Version0.1) (ActionClass_DEFAULTEMPTY.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.action;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

/**
 * Implementation of an (IAction based) Action, the action will be used to dynamically (via code) construct
 * contextMenus.
 * 
 * The Action may be independently constructed (Default Constructor) and runWithContext() called in a typed manner
 * directly This action is typically invoked on an EMPTY Table or Tree control, (e.g. for the Create New ... entry ), It
 * has an explicit constructor where the ROOT object ( Table/Tree Input, may be a RefObject or a ModelEditorInput) is
 * passed which is then handed to the implementation call!
 * 
 * @author SAP AG
 * @generated modified
 */
public class ActionActionCreateStructureTypeForClassEditor extends AbstractMoftoolAction<MofClass> {

	public ActionActionCreateStructureTypeForClassEditor(IStructuredSelection selection, MofClass inputObject) {
		super(selection, inputObject, Messages.ActionActionCreateStructureTypeForClassEditor_0_xbut,
				"ACTION_ActionCreateStructureTypeForClassEditor"); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public ActionActionCreateStructureTypeForClassEditor() {
		this(StructuredSelection.EMPTY, null);
	}

	public void runWithSelection(MofClass inputObject, IStructuredSelection structuredSelection) {

		MOFToolEditorPlugin.getDefault().getExecMOFToolDefault().execActionCreateStructureTypeForClassEditor(
				(MofClass) inputObject);

	}
}
