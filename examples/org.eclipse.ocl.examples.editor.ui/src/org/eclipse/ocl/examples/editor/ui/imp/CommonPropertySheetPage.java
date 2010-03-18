/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonPropertySheetPage.java,v 1.2 2010/03/18 15:13:06 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import java.util.List;

import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ocl.examples.common.label.LabelGeneratorRegistry;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;
import org.eclipse.ocl.examples.editor.ui.imp.CommonTextEditor;
import org.eclipse.ocl.examples.editor.ui.imp.ICommonParseResult;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPageSite;

public final class CommonPropertySheetPage extends ExtendedPropertySheetPage
{
 	protected final CommonTextEditor textEditor;
  	
	public CommonPropertySheetPage(CommonTextEditor textEditor) {
		super(textEditor.getAdapterFactoryEditingDomain());
		this.textEditor = textEditor;
	}

	@Override
	public void dispose() {
		super.dispose();
		getSite().getPage().removePostSelectionListener(this);
	}

	@Override
	public void init(IPageSite pageSite) {
		pageSite.getPage().addPostSelectionListener(this);
		super.init(pageSite);
	}


	@Override public void refresh() {
		if (!getControl().isDisposed())
			super.refresh();
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
//		System.out.println(getClass().getSimpleName() + ".selectionChanged()");
		ICommonParseResult currentResult = textEditor.getParseController().getCurrentResult();
		selection = currentResult != null ? textEditor.getASTorCSTSelection(selection, currentResult) : StructuredSelection.EMPTY;
        if (OCLExamplesEditorPlugin.SELECTION_OUTER.isActive())
			OCLExamplesEditorPlugin.SELECTION_OUTER.println(getClass(), "selectionChanged " + LabelGeneratorRegistry.debugLabelFor(selection));
		super.selectionChanged(part, selection);
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
		super.setActionBars(actionBars);
//		textEditor.getActionBarContributor().shareGlobalActions(this, actionBars);
	}

	@Override
	public void setSelectionToViewer(List<?> selection) {
//		textEditor.setSelectionToViewer(selection);
		textEditor.setFocus(); // FIXME Select Properties View corrupts editor selection
		// Need to copy code from e.g. EcoreEditor to CommonTextEditor so that THE (multi-page) editor keeps
		// track of the suggestion and passes it to each activate view in handleActivate(). THis probably
		// requires a revisit of all setSelection code and introduction of a
		// CommonSelectionProvider.
		
	}
}