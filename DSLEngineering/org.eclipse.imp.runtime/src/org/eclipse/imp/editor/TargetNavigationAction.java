/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
 *******************************************************************************/

package org.eclipse.imp.editor;

import org.eclipse.imp.language.ServiceFactory;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.services.INavigationTargetFinder;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ui.texteditor.ITextEditor;

public abstract class TargetNavigationAction extends Action {
    protected UniversalEditor fEditor;
    protected INavigationTargetFinder fNavTargetFinder;

    protected abstract Object getNavTarget(Object o, Object astRoot);

    protected TargetNavigationAction(String title, String actionDefID) {
        this(null, title, actionDefID);
    }

    public TargetNavigationAction(UniversalEditor editor, String title, String actionDefID) {
        setEditor(editor);
        setText(title);
        setActionDefinitionId(actionDefID);
    }

    public void setEditor(ITextEditor editor) {
        fNavTargetFinder= null;
        if (editor instanceof UniversalEditor) {
            fEditor= (UniversalEditor) editor;
            if (fEditor.fLanguage != null) {
                fNavTargetFinder= ServiceFactory.getInstance().getNavigationTargetFinder(fEditor.fLanguage);
            }
        } else {
            fEditor= null;
        }
        setEnabled(fNavTargetFinder != null);
    }

    @Override
    public void run() {
        IRegion selection= fEditor.getSelectedRegion();
        IParseController pc= fEditor.getParseController();
        ISourcePositionLocator locator= pc.getSourcePositionLocator();
        Object curNode= locator.findNode(pc.getCurrentAst(), selection.getOffset(), selection.getOffset() + selection.getLength() - 1);
        if (curNode == null || selection.getOffset() == 0) {
            curNode= pc.getCurrentAst();
        }
        Object prev= getNavTarget(curNode, pc.getCurrentAst());
    
        if (prev != null) {
            int prevOffset= locator.getStartOffset(prev);
    
            fEditor.selectAndReveal(prevOffset, 0);
        }
    }
}
