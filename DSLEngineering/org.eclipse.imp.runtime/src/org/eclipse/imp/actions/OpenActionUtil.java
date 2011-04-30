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
package org.eclipse.imp.actions;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.imp.editor.EditorUtility;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.ServiceFactory;
import org.eclipse.imp.model.ISourceEntity;
import org.eclipse.imp.services.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

public class OpenActionUtil {
    private OpenActionUtil() {
        // no instance.
    }

    /**
     * Opens the editor on the given element and subsequently selects it.
     */
    public static void open(Object element) throws PartInitException {
        open(element, true);
    }

    /**
     * Opens the editor on the given element and subsequently selects it.
     */
    public static void open(Object element, boolean activate) throws PartInitException {
        IEditorPart part= EditorUtility.openInEditor(element, activate);

        if (element instanceof ISourceEntity) {
            EditorUtility.revealInEditor(part, (ISourceEntity) element);
        }
    }

    /**
     * Filters out source references from the given code resolve results. A utility method that can be called by subclasses.
     */
    public static List<ISourceEntity> filterResolveResults(ISourceEntity[] codeResolveResults) {
        int nResults= codeResolveResults.length;
        List<ISourceEntity> refs= new ArrayList<ISourceEntity>(nResults);

        for(int i= 0; i < nResults; i++) {
//          if (codeResolveResults[i] instanceof ISourceReference) {
                refs.add(codeResolveResults[i]);
//          }
        }
        return refs;
    }

    /**
     * Shows a dialog for resolving an ambiguous source entity. Utility method that can be called by subclasses.
     */
    public static ISourceEntity selectSourceEntity(ISourceEntity[] entities, Shell shell, String title, String message,
            Language lang) {
        int nResults= entities.length;
        if (nResults == 0)
            return null;
        if (nResults == 1)
            return entities[0];
        ILabelProvider labelProvider= ServiceFactory.getInstance().getLabelProvider(lang);
//      int flags= JavaElementLabelProvider.SHOW_DEFAULT | JavaElementLabelProvider.SHOW_QUALIFIED | JavaElementLabelProvider.SHOW_ROOT;
        ElementListSelectionDialog dialog= new ElementListSelectionDialog(shell, labelProvider);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setElements(entities);
        if (dialog.open() == Window.OK) {
            Object[] selection= dialog.getResult();
            if (selection != null && selection.length > 0) {
                nResults= selection.length;
                for(int i= 0; i < nResults; i++) {
                    Object current= selection[i];
                    if (current instanceof ISourceEntity) {
                        return (ISourceEntity) current;
                    }
                }
            }
        }
        return null;
    }
}
