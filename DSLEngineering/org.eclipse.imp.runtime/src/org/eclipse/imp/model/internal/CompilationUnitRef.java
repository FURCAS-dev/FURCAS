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

package org.eclipse.imp.model.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.core.ErrorHandler;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.LanguageRegistry;
import org.eclipse.imp.language.ServiceFactory;
import org.eclipse.imp.model.ICompilationUnit;
import org.eclipse.imp.model.ISourceEntity;
import org.eclipse.imp.model.ISourceFolder;
import org.eclipse.imp.model.ISourceProject;
import org.eclipse.imp.model.IWorkspaceModel;
import org.eclipse.imp.model.ModelFactory;
import org.eclipse.imp.model.ModelFactory.ModelException;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;

public class CompilationUnitRef implements ICompilationUnit {
    /**
     * The containing ISourceProject. May be null if the associated path is
     * workspace-absolute.
     */
    final ISourceProject fProject;

    /**
     * Path may be either workspace-absolute or project-relative. If
     * workspace-absolute, fProject will be null.
     */
    final IPath fPath; // possibly src-folder-relative?

    // TODO This should be created lazily
    private IParseController fParseCtrlr;

    /**
     * @param path
     *            may be either workspace-absolute or project-relative
     * @param proj
     *            may be null if path is workspace-absolute
     */
    public CompilationUnitRef(IPath path, ISourceProject proj) {
        fProject= proj;
        fPath= path;
    }

    /**
     * @return the associated ISourceProject. May be null if the unit's path is
     *         workspace-absolute.
     */
    public ISourceProject getProject() {
        return fProject;
    }

    /**
     * @return the associated IPath, which may be either workspace-absolute or
     *         project-relative
     */
    public IPath getPath() {
        return fPath;
    }

    public String getName() {
        return fPath.lastSegment();
        // if (fPath.isAbsolute())
        // return fPath.toPortableString();
        // return fProject.getRawProject().getName() + ":" + fPath;
    }

    public ISourceEntity getParent() {
        IContainer parent= (IContainer) fProject.getRawProject().findMember(
                fPath.removeLastSegments(1));

        try {
            return ModelFactory.open(parent);
        } catch (ModelException e) {
            RuntimePlugin.getInstance().logException(
                    "Error obtaining parent of " + getName(), e);
            return null;
        }
    }

    public ISourceEntity getAncestor(Class ofType) {
        if (ofType == ICompilationUnit.class) {
            return this;
        } else if (ofType == ISourceProject.class) {
            return fProject;
        } else if (ofType == IWorkspaceModel.class) {
            return ModelFactory.getModelRoot();
        } else if (ofType == ISourceFolder.class) {
            return getParent();
        }
        return null;
    }

    public IResource getResource() {
        return getFile();
    }

    public IFile getFile() {
        if (fPath.getDevice() != null && fPath.getDevice().length() > 0)
            return null; // This is a filesystem-absolute path; can't build
                            // an IFile for that
        if (fPath.isAbsolute())
            return fProject.getRawProject().getWorkspace().getRoot().getFile(
                    fPath);
        return fProject.getRawProject().getFile(fPath);
    }

    public Object getAST(IMessageHandler msgHandler, IProgressMonitor monitor) {
        IFile file= getFile();
        TextFileDocumentProvider tfdp= new TextFileDocumentProvider();
        IDocument doc= (file != null) ? tfdp.getDocument(file) : null;

        // if (file == null)
        // return null;

        if (fParseCtrlr == null) {
            Language lang= LanguageRegistry.findLanguage(fPath, doc);

            fParseCtrlr= ServiceFactory.getInstance().getParseController(lang);
        }
        IPath projRelPath= fPath.isAbsolute() ? fPath.removeFirstSegments(1)
                : fPath;
        fParseCtrlr.initialize(projRelPath, fProject, msgHandler);
        return fParseCtrlr.parse(getSource(), monitor);
    }

    public String getSource() {
        String absPath= (fPath.getDevice() != null) ? fPath.toOSString()
                : (fPath.isAbsolute() ? ResourcesPlugin.getWorkspace()
                        .getRoot().getLocation().append(fPath).toOSString()
                        : fProject.getRawProject().getLocation().append(fPath)
                                .toOSString());
        File inFile= new File(absPath);

        if (!inFile.exists() || !inFile.canRead()) {
            throw new IllegalArgumentException(
                    "CompilationUnitRef.getSource(): file does not exist or cannot be read: "
                            + this);
        }

        // Get a buffered reader for the input file
        FileReader fileReader= null;
        long fileLen= inFile.length();
        try {
            fileReader= new FileReader(inFile);
            char[] buffer= new char[(int) fileLen];
            fileReader.read(buffer);
            return new String(buffer);
        } catch (FileNotFoundException e) {
            ErrorHandler
                    .reportError("CompilationUnitRef.getSource(): file not found: "
                            + this);
            return null;
        } catch (IOException e) {
            ErrorHandler
                    .reportError("CompilationUnitRef.getSource(): cannot read file: "
                            + this);
            return null;
        }
    }

    public void commit(IProgressMonitor mon) {
        // do nothing
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CompilationUnitRef))
            return false;
        CompilationUnitRef other= (CompilationUnitRef) obj;
        return fProject.equals(other.fProject) && fPath.equals(other.fPath);
    }

    @Override
    public int hashCode() {
        int result= 4831;
        result= result * 4933 + (fProject != null ? fProject.hashCode() : 13);
        result= result * 1627 + fPath.hashCode();
        return result;
    }

    public String toString() {
        return "<compilation unit " + getPath().toPortableString() + ">";
    }
}
