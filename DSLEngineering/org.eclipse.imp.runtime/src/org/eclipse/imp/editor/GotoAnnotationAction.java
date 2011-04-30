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

package org.eclipse.imp.editor;

import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.TextEditorAction;

/**
 * Essentially a clone of the class of the same name from JDT/UI, for navigating from one annotation to the
 * next/previous in a source file.
 * 
 * @author rfuhrer
 */
public class GotoAnnotationAction extends TextEditorAction {
    public static final String PREFIX= RuntimePlugin.IMP_RUNTIME + '.';

    private static final String nextAnnotationContextID= PREFIX + "goto_next_error_action";

    private static final String prevAnnotationContextID= PREFIX + "goto_previous_error_action";

    private boolean fForward;

    public GotoAnnotationAction(String prefix, boolean forward) {
        super(UniversalEditor.fgBundleForConstructedKeys, prefix, null);
        fForward= forward;
        if (forward)
            PlatformUI.getWorkbench().getHelpSystem().setHelp(this, nextAnnotationContextID);
        else
            PlatformUI.getWorkbench().getHelpSystem().setHelp(this, prevAnnotationContextID);
    }

    public void run() {
        UniversalEditor e= (UniversalEditor) getTextEditor();

        e.gotoAnnotation(fForward);
    }

    public void setEditor(ITextEditor editor) {
        if (editor instanceof UniversalEditor)
            super.setEditor(editor);
        update();
    }

    public void update() {
        setEnabled(getTextEditor() instanceof UniversalEditor);
    }
}
