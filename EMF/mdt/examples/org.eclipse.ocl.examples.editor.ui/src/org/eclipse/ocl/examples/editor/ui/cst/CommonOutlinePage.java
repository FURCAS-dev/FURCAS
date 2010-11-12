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
 * $Id: CommonOutlinePage.java,v 1.3 2010/03/22 01:15:45 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.cst;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.imp.editor.IMPOutlinePage;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.examples.common.label.LabelGeneratorRegistry;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;
import org.eclipse.ocl.examples.editor.ui.imp.CommonTextEditor;
import org.eclipse.ocl.examples.editor.ui.imp.CommonTreeModelBuilder;
import org.eclipse.ocl.examples.editor.ui.imp.ICommonParseResult;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPageSite;

public abstract class CommonOutlinePage extends IMPOutlinePage implements ICSTOutlinePage, ISelectionListener
{
	protected final CommonTextEditor editor;
	protected final CommonTreeModelBuilder treeModelBuilder;
	
	public CommonOutlinePage(CommonTextEditor editor, CommonTreeModelBuilder treeModelBuilder) {
		super(editor.getParseController(), treeModelBuilder,
			editor.getLanguageServiceManager().getLabelProvider(),
			editor.getLanguageServiceManager().getImageProvider(),
			null, null);
		this.editor = editor;
		this.treeModelBuilder = treeModelBuilder;
	}

	@Override
	public void dispose() {
		super.dispose();
		IWorkbenchPage page = getSite().getPage();
		page.removePostSelectionListener(this);
		page.removeSelectionListener(this);
		editor.removeModelListener(this);
	}

	protected ISelection getItemSelection(ISelection selection) {
		if ((selection instanceof IStructuredSelection) && !selection.isEmpty()) {
			Object[] selections = ((IStructuredSelection)selection).toArray();
			Object[] unwrappedSelections = new Object[selections.length];
			for (int i = 0; i < selections.length; i++) {
				for (Object n = selections[i]; n != null; n = (n instanceof EObject) ? ((EObject)n).eContainer() : null) {
					ModelTreeNode item = treeModelBuilder.getItem(n);
					if (item != null) {
						unwrappedSelections[i] = item;
						break;
					}
				}
			}
			selection = new StructuredSelection(unwrappedSelections);
			
		}
		return selection;
	}

	@Override
	public void init(IPageSite pageSite) {
		editor.addModelListener(this);
		IWorkbenchPage page = pageSite.getPage();
		page.addSelectionListener(this);			// Outline Click and Text Double Click, Text Single Click after Double Click
		page.addPostSelectionListener(this);		// Text Single Click after Single Click	
		super.init(pageSite);
	}

	protected void resumeSelectionListening() {
		IWorkbenchPage page = getSite().getPage();
		page.addSelectionListener(this);
		page.addPostSelectionListener(this);	
        getTreeViewer().addSelectionChangedListener(this);
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
        if (OCLExamplesEditorPlugin.SELECTION.isActive())
			OCLExamplesEditorPlugin.SELECTION.println(getClass(), "selectionChanged1 " + LabelGeneratorRegistry.debugLabelFor(event.getSelection()));
    	try {
    		suspendSelectionListening();
        	ISelection selection = event.getSelection();
			fireSelectionChanged(selection);
//    		if ((selection instanceof IStructuredSelection) && (((IStructuredSelection)selection).size() == 1)) {
//    			Object object = ((IStructuredSelection)selection).getFirstElement();
    			ICommonParseResult currentResult = editor.getParseController().getCurrentResult();
    			List<CSTNode> cstNodes = editor.getCSTNodes(selection, currentResult);
    			int minStartOffset = -1;
    			int maxEndOffset = 0;
    			for (CSTNode cstNode : cstNodes) {
    				int startOffset = cstNode.getStartOffset();
    				int endOffset = cstNode.getEndOffset();
    				if ((startOffset >= 0) && (endOffset >= startOffset)) {
	    				if (minStartOffset < 0) {
	    					minStartOffset = startOffset;
	    					maxEndOffset = endOffset;
	    				}
	    				else {
	    					if (startOffset < minStartOffset) {
		    					minStartOffset = startOffset;
	    					}
	    					if (endOffset > maxEndOffset) {
		    					maxEndOffset = endOffset;
	    					}
	    				}
    				}
    			}
    			if (minStartOffset >= 0) {
    				editor.selectAndReveal(minStartOffset, maxEndOffset - minStartOffset + 1);
    			}
    			else {
       				editor.selectAndReveal(0, 0);
    			}
//				CSTNode cstNode = currentResult != null ? currentResult.getCSTNode(object) : null;
//    			if (cstNode != null)
//    				editor.selectAndReveal(cstNode.getStartOffset(), cstNode.getEndOffset() - cstNode.getStartOffset() + 1);
//    		}	      	
    	}
    	finally {
       		resumeSelectionListening();
    	}
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		setSelection(selection);
	}

	@Override
	public void setSelection(ISelection selection) {
    	try {
			if (OCLExamplesEditorPlugin.SELECTION.isActive())
				OCLExamplesEditorPlugin.SELECTION.println(getClass(), "setSelection " + LabelGeneratorRegistry.debugLabelFor(selection));
			suspendSelectionListening();
			ISelection itemSelection = getItemSelection(selection);
    		super.setSelection(itemSelection);
    	}
    	finally {
    		resumeSelectionListening();
    	}
	}

	protected void suspendSelectionListening() {
		IWorkbenchPage page = getSite().getPage();
		page.removeSelectionListener(this);
		page.removePostSelectionListener(this);
        getTreeViewer().removeSelectionChangedListener(this);
	}

	@Override
	public void update(IParseController parseController, IProgressMonitor monitor) {
	    if ((getTreeViewer() != null) && (getTreeViewer().getContentProvider() != null))
	    	super.update(parseController, monitor);
	}
}
