/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG (MITG-Version0.1) (ActionClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.action;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

/**
 * Implementation of an (IAction based) Action, the action will be used to dynamically (via code) construct
 * contextMenus.
 * 
 * The Action may be independently constructed (Default Constructor) and runWithContext() called in a typed manner
 * directly
 * 
 * @author SAP AG
 * @generated
 */
public class ActionActionCreateEnumerationTypeForPackage extends AbstractFilteredMoftoolAction<MofPackage> {

	private static AbstractFilteredMoftoolAction<MofPackage> actionActionCreateEnumerationTypeForPackage = new ActionActionCreateEnumerationTypeForPackage();

	/**
	 * @generated
	 */
	public ActionActionCreateEnumerationTypeForPackage() {
		this(StructuredSelection.EMPTY);
	}

	/**
	 * @generated
	 */
	public ActionActionCreateEnumerationTypeForPackage(IStructuredSelection selection) {

		super(selection, Messages.ActionActionCreateEnumerationTypeForPackage_0_xbut, MOFToolEditorPlugin.getDefault()
				.getImageDescriptor("ACTION_ActionCreateEnumerationTypeForPackage")); //$NON-NLS-1$

	}

	/**
	 * This is the main method to implement, as visible from code above, the method is invoked from the run() method
	 * using the current seleciton context, once for each entity within the context You may remove the
	 * <code>static</code> context
	 * 
	 * @param context
	 * @generated
	 */
	public void runSingleWithContext(MofPackage context) {
		MOFToolEditorPlugin.getDefault().getExecMOFToolDefault().execActionCreateEnumerationTypeForPackage(context);

	}

	/**
	 * @generated
	 */
	public static IAction createActionForSelection(IStructuredSelection selection) {
		if (!actionActionCreateEnumerationTypeForPackage.visibleForSelection(selection)) {
			return null;
		}
		return new ActionActionCreateEnumerationTypeForPackage(selection);
	}
	
	@Override
	protected boolean visibleForContext(RefObject devobj) {
		return devobj instanceof MofPackage;
	}

}
