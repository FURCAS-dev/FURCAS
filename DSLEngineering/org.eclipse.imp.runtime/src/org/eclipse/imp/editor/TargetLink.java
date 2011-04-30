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

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Common class to represent a hyperlink to a given target location.
 * 
 * @author rfuhrer
 */
public final class TargetLink implements IHyperlink {
    private final String fText;

    private final Object fTarget;

    private final int fStart;

    private final int fLength;

    private final int fTargetStart;

    private final int fTargetLength;

    private IRegionSelectionService fSelectionService;

    /**
     * @param text
     * @param srcStart
     * @param srcLength
     * @param target a workspace-relative or filesystem-absolute IPath to the file,
     * if 'editor' is null; otherwise, an object that indicates the particular target within the source file
     * @param targetStart
     * @param targetLength
     * @param editor may be null, if the target is in another compilation unit
     */
    public TargetLink(String text, int srcStart, int srcLength, Object target, int targetStart, int targetLength, IRegionSelectionService selService) {
        fText= text;
        fStart= srcStart;
        fTarget= target;
        fLength= srcLength;
        fTargetStart= targetStart;
        fTargetLength= targetLength;
        fSelectionService= selService;
    }

    public IRegion getHyperlinkRegion() {
        return new Region(fStart, fLength);
    }

    public String getTypeLabel() {
        return fTarget.getClass().getName();
    }

    public String getHyperlinkText() {
        return new String(fText);
    }

    public void open() {
        if (fSelectionService == null) {
            // Either we're opening up a new editor, or there's an existing one open on the target file.
            // Either way, get a handle to an IEditorPart for the target file, and try to get an
            // IRegionSelectionService interface on it.
            if (!(fTarget instanceof IPath)) {
                RuntimePlugin.getInstance().writeErrorMsg("Unable to link to a target of type other than IPath: " + fTarget.getClass().getName());
                return;
            }
            final IPath targetPath= (IPath) fTarget;
            IEditorDescriptor ed= PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(targetPath.lastSegment());
            IWorkbenchWindow activeWindow= PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            IWorkbenchPage activePage= activeWindow.getActivePage();

            if (ed == null) {
                MessageDialog.openError(activeWindow.getShell(), "Error", "No editor defined for target file "
                        + targetPath.toPortableString());
                return;
            }

            IWorkspaceRoot wsRoot= ResourcesPlugin.getWorkspace().getRoot();
            IPath wsLoc= wsRoot.getLocation();
            IEditorPart editor;

            // Abortive attempt to support links to class files embedded in jars (e.g., Java rt.jar).
            // if (targetPath.toPortableString().endsWith(".class")) {
            //     IFile jarFile= null; // Can't get an IFile for something not in the workspace... and rt.jar usually isn't...
            //     // Anyway, we'll have to use something other than a plain IFileEditorInput.
            //     // JDT has IClassFileEditorInput, but it's internal... Hmmm...
            //     JavaCore.createClassFileFrom(jarFile);
            // } else

            try {
                boolean targetPathHasWSPrefix= wsLoc.isPrefixOf(targetPath);

                if (targetPathHasWSPrefix || wsRoot.getFile(targetPath).exists()) {
                    IFile file= wsRoot.getFile(targetPathHasWSPrefix ? targetPath.removeFirstSegments(wsLoc.segmentCount()) : targetPath);
                    IEditorInput editorInput= new FileEditorInput(file);

                    editor= activePage.openEditor(editorInput, ed.getId());
                } else {
//              if (targetPath.isAbsolute() && !wsLoc.isPrefixOf(targetPath)) {
                    // http://wiki.eclipse.org/index.php/FAQ_How_do_I_open_an_editor_on_a_file_outside_the_workspace%3F
                    IFileStore fileStore = EFS.getLocalFileSystem().getStore(targetPath);

                    editor= IDE.openEditorOnFileStore(activePage, fileStore);
                }
            } catch (PartInitException e) {
                RuntimePlugin.getInstance().logException(e.getLocalizedMessage(), e);
                return;
            }
            // Don't assume the target editor is a text editor; the target might be
            // in a class file or another kind of binary file.
            if (editor instanceof IRegionSelectionService)
                fSelectionService= (IRegionSelectionService) editor;
            else
                fSelectionService= (IRegionSelectionService) editor.getAdapter(IRegionSelectionService.class);
        }
        if (fSelectionService != null)
            fSelectionService.selectAndReveal(fTargetStart, fTargetLength);
    }
}
