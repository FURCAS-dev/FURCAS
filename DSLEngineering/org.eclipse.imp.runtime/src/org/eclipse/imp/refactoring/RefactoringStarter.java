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
package org.eclipse.imp.refactoring;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.swt.widgets.Shell;

/**
 * Simple class to wrap the processing flow for user-initiated refactorings. Copied from a similar class in JDT/UI.
 * 
 * @author rfuhrer
 */
public class RefactoringStarter {
    // TODO re-enable support for the "Save Helper", which had too many claws in the JDT/UI to excise conveniently.
    // private RefactoringSaveHelper fSaveHelper= new RefactoringSaveHelper();
    private RefactoringStatus fStatus;

    public void activate(Refactoring refactoring, RefactoringWizard wizard, Shell parent, String dialogTitle,
            boolean mustSaveEditors) {
        if (!canActivate(mustSaveEditors, parent))
            return;
        try {
            RefactoringWizardOpenOperation op= new RefactoringWizardOpenOperation(wizard);
            int result= op.run(parent, dialogTitle);
            fStatus= op.getInitialConditionCheckingStatus();
            if (result == IDialogConstants.CANCEL_ID
                    || result == RefactoringWizardOpenOperation.INITIAL_CONDITION_CHECKING_FAILED) {
                /* fSaveHelper.triggerBuild() */
            }
        } catch (InterruptedException e) {
            // do nothing. User action got cancelled
        }
    }

    public RefactoringStatus getInitialConditionCheckingStatus() {
        return fStatus;
    }

    private boolean canActivate(boolean mustSaveEditors, Shell shell) {
        // return !mustSaveEditors || fSaveHelper.saveEditors(shell);
        return true;
    }
}
