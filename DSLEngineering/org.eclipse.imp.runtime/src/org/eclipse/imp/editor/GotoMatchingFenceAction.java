/*******************************************************************************
* Copyright (c) 2008 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.editor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;

public class GotoMatchingFenceAction extends Action {
    private final UniversalEditor fEditor;

    public GotoMatchingFenceAction(UniversalEditor editor) {
            super("Go to Matching Fence");
            Assert.isNotNull(editor);
            fEditor= editor;
            setEnabled(true);
//          PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IJavaHelpContextIds.GOTO_MATCHING_BRACKET_ACTION);
    }

    public void run() {
            fEditor.gotoMatchingFence();
    }
}
