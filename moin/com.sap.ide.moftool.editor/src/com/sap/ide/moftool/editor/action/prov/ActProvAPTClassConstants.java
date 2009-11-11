/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (ActionProvider_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.action.prov;

import com.sap.tc.moin.repository.mmi.model.Namespace;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.actions.ActionContext;

import com.sap.ide.moftool.editor.action.ActionActionCreateConstant;

/**
 * Constructs list of actions for programmatic construction of a context menu Determines action applicability is determined on the
 * individual action
 * 
 * @author SAP AG
 * @generated
 */
public class ActProvAPTClassConstants extends AbstractActionProvider {

	@Override
	protected void createActionsInternal(ActionContext context) {
		addToContextMenu(new ActionActionCreateConstant((IStructuredSelection) context.getSelection(), (Namespace) context
				.getInput()));		
	}

}
