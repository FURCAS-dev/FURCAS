/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.editor.internal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.imp.core.ErrorHandler;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.ServiceFactory;
import org.eclipse.imp.parser.IModelListener;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.IOutliner;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

/*
 * Licensed Materials - Property of IBM,
 * (c) Copyright IBM Corp. 2005  All Rights Reserved
 */

/**
 * @author Claffra
 * @deprecated This class is no longer needed; the IMP outline view is
 * now produced using a TreeModelBuilder, if one is available for the
 * given language.
 */
public class OutlineController implements IContentOutlinePage, IModelListener {
    protected Tree tree;

    private IParseController controller;

    private IOutliner outliner;

    private UIJob job;

    private int DELAY= 50; //500;

    public OutlineController(ITextEditor editor, Language language)  {
    	outliner = ServiceFactory.getInstance().getOutliner(language);
        if (outliner != null) {
            outliner.setEditor(editor);     // SMS 5 Apr 2007
        }
    }

    public AnalysisRequired getAnalysisRequired() {
        return AnalysisRequired.SYNTACTIC_ANALYSIS;
    }

    public void createControl(Composite parent) {
    	tree= new Tree(parent, SWT.NONE);
    	if (outliner != null)
    	    outliner.setTree(tree);
    }

    public void dispose() {}

    public Control getControl() {
	return tree;
    }

    public void setActionBars(IActionBars actionBars) {}

    public void setFocus() {}

    public void addSelectionChangedListener(ISelectionChangedListener listener) {}

    public ISelection getSelection() {
	return null;
    }

    public void removeSelectionChangedListener(ISelectionChangedListener listener) {}

    public void setSelection(ISelection selection) {}

    public void update(IParseController result, IProgressMonitor monitor) {
        // TODO RMF 10/18/2006: Shouldn't even create this controller if we have no
        // language-specific outliner, but UniversalEditor doesn't know that when it
        // instantiates this class... What to do?
        if (outliner == null)
            return;

 	this.controller= result;
	if (job != null) {
		job.cancel();
	}
	else {
		job= new UIJob("Outline View Controller" + result.toString()) {
			public IStatus runInUIThread(IProgressMonitor monitor) {
			    int offset= 0;
			    try {
			        outliner.createOutlinePresentation(controller, offset);
			    } catch (Throwable e) {
			        ErrorHandler.reportError("Outline View Controller", e);
			    }
			    return Status.OK_STATUS;
			}
		};

	} // else
	job.schedule(DELAY);
    }
}
