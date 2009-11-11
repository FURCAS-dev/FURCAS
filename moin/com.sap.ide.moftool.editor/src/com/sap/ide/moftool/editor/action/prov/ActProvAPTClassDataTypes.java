/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG (MITG-Version0.1 (ActionProvider_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.action.prov;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.actions.ActionContext;

import com.sap.ide.moftool.editor.action.ActionActionCreateEnumerationTypeForClassEditor;
import com.sap.ide.moftool.editor.action.ActionActionCreateStructureTypeForClassEditor;

/**
 * Constructs list of actions for programmatic construction of a context menu Determines action applicability is
 * determined on the individual action
 * 
 * @author SAP AG
 * @generated
 */
public class ActProvAPTClassDataTypes extends AbstractActionProvider {

	@Override
	protected void createActionsInternal(ActionContext context) {
		addToContextMenu(new ActionActionCreateStructureTypeForClassEditor(
				(IStructuredSelection) context.getSelection(), (MofClass) context.getInput()));

		addToContextMenu(new ActionActionCreateEnumerationTypeForClassEditor(
				(IStructuredSelection) context.getSelection(), (MofClass) context.getInput()));
	}
}
