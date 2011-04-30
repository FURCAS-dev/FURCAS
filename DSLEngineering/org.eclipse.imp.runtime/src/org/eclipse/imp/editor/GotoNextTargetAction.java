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


public class GotoNextTargetAction extends TargetNavigationAction {
    public GotoNextTargetAction() {
        this(null);
    }

    public GotoNextTargetAction(UniversalEditor editor) {
        super(editor, "Go to Next Navigation Target", UniversalEditor.GOTO_NEXT_TARGET_COMMAND);
    }

    @Override
    protected Object getNavTarget(Object o, Object astRoot) {
        return fNavTargetFinder.getNextTarget(o, astRoot);
    }
}
