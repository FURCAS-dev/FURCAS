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


public class GotoPreviousTargetAction extends TargetNavigationAction {
    public GotoPreviousTargetAction() {
        this(null);
    }

    public GotoPreviousTargetAction(UniversalEditor editor) {
        super(editor, "Go to Previous Navigation Target", UniversalEditor.GOTO_PREVIOUS_TARGET_COMMAND);
    }

    @Override
    protected Object getNavTarget(Object o, Object astRoot) {
        return fNavTargetFinder.getPreviousTarget(o, astRoot);
    }
}
