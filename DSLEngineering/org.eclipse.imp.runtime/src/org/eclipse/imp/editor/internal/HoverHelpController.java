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
import org.eclipse.imp.core.ErrorHandler;
import org.eclipse.imp.editor.HoverHelper;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.ServiceFactory;
import org.eclipse.imp.parser.IModelListener;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.IHoverHelper;
import org.eclipse.imp.services.base.HoverHelperBase;
import org.eclipse.imp.utils.AnnotationUtils;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;

public class HoverHelpController implements ITextHover, IModelListener {
    private IParseController controller;

    private IHoverHelper hoverHelper;

    public HoverHelpController(Language language) {
        hoverHelper= ServiceFactory.getInstance().getHoverHelper(language);
        if (hoverHelper == null)
            hoverHelper= new HoverHelper(language);
        else if (hoverHelper instanceof HoverHelperBase) {
            ((HoverHelperBase) hoverHelper).setLanguage(language);
        }
    }

    public AnalysisRequired getAnalysisRequired() {
        return AnalysisRequired.NAME_ANALYSIS;
    }

    public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
        return new Region(offset, 0);
    }

    public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
        try {
            final int offset= hoverRegion.getOffset();
            String help= null;

            if (controller != null && hoverHelper != null)
                help= hoverHelper.getHoverHelpAt(controller, (ISourceViewer) textViewer, offset);
            if (help == null)
                help= AnnotationUtils.formatAnnotationList(AnnotationUtils.getAnnotationsForOffset((ISourceViewer) textViewer, offset));

            return help;
        } catch (Throwable e) {
            ErrorHandler.reportError("Hover help service implementation threw an exception", e);
        }
        return null;
    }

    public void update(IParseController controller, IProgressMonitor monitor) {
        this.controller= controller;
    }
}
