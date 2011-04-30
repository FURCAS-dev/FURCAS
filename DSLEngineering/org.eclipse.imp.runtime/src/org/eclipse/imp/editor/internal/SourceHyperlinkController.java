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

/*
 * Created on Feb 8, 2006
 */
package org.eclipse.imp.editor.internal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.parser.IModelListener;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.ISourceHyperlinkDetector;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.ui.texteditor.ITextEditor;

public class SourceHyperlinkController implements IHyperlinkDetector, IModelListener {
    private final ISourceHyperlinkDetector fSourceHyperlinkDetector;
    private IParseController fParseController;
    private final ITextEditor fEditor;

    public SourceHyperlinkController(ISourceHyperlinkDetector sourceHyperlinkDetector, ITextEditor editor) {
        fSourceHyperlinkDetector= sourceHyperlinkDetector;
        fEditor= editor;
    }

    public AnalysisRequired getAnalysisRequired() {
        return AnalysisRequired.NAME_ANALYSIS;
    }

    public IHyperlink[] detectHyperlinks(final ITextViewer textViewer, final IRegion region, boolean canShowMultipleHyperlinks) {
        return fSourceHyperlinkDetector.detectHyperlinks(region, fEditor, textViewer, fParseController);
    }

    public void update(IParseController parseController, IProgressMonitor monitor) {
        fParseController= parseController;
    }
}
