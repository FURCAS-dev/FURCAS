/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG (MITG-Version0.1 (ActionProvider_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.action.prov;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.actions.ActionContext;

import com.sap.ide.moftool.editor.action.ActionActionCreateAssociation;

/**
 * Constructs list of actions for programmatic construction of a context menu Determines action applicability is
 * determined on the individual action
 * 
 * @author SAP AG
 * @generated
 */
public class ActProvAPTPackageAssociations extends AbstractActionProvider {

	@Override
	protected void createActionsInternal(ActionContext context) {
		addToContextMenu(new ActionActionCreateAssociation((IStructuredSelection) context.getSelection(),
				(MofPackage) context.getInput()));
	}
}
