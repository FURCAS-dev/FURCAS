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

package org.eclipse.imp.model;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.imp.core.ErrorHandler;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.LanguageRegistry;
import org.eclipse.imp.model.IPathEntry.PathEntryType;
import org.eclipse.imp.model.internal.CompilationUnitRef;
import org.eclipse.imp.model.internal.PathEntry;
import org.eclipse.imp.model.internal.SourceFolder;
import org.eclipse.imp.model.internal.SourceProject;
import org.eclipse.imp.model.internal.WorkspaceModel;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;

/**
 * A factory for implementations of the various common model interfaces, e.g., ISourceProject,
 * ICompilationUnit, and so on.
 * @author rfuhrer
 */
public class ModelFactory {
    public class ModelException extends Exception {
        private static final long serialVersionUID= -1051581958821533299L;

        public ModelException() {
            super();
        }
        public ModelException(String message) {
            super(message);
        }
        public ModelException(String message, Throwable cause) {
            super(message, cause);
        }
        public ModelException(Throwable cause) {
            super(cause);
        }
    }

    public static final String NO_SUCH_ELEMENT= "No such element: ";

    public static final String ELEMENT_ALREADY_EXISTS= "Element already exists: ";

    private static ModelFactory sInstance= new ModelFactory();

    public static ModelFactory getInstance() {
        return sInstance;
    }

    /**
     * Implementations of this interface, once registered, can augment the model entities
     * created by the factory before they are returned to the client.<br>
     * This provides a mechanism for language-specific customization of core model entity
     * properties. E.g, the project's search path can be augmented based on a global
     * language-specific preference setting.
     */
    // TODO Implementations of this interface should probably be provided via an extension point
    public interface IFactoryExtender {
        /**
         * This method gets called for the extender corresponding to each language nature
         * configured on the given project.
         */
        void extend(ISourceProject project);

        /**
         * This method gets called only for the extender of the "host language" contained
         * within the given compilation unit (i.e. for the language to which the associated
         * content type maps).
         */
        void extend(ICompilationUnit unit);
    }

    private ModelFactory() {}

    private IWorkspaceModel fModelRoot= new WorkspaceModel(ResourcesPlugin.getWorkspace().getRoot());

    private Map<IProject, ISourceProject> fProjectMap= new HashMap<IProject, ISourceProject>();

    private Map<Language, IFactoryExtender> fExtenderMap= new HashMap<Language, IFactoryExtender>();

    public void installExtender(IFactoryExtender extender, Language language) {
        fExtenderMap.put(language, extender);
    }

    public static IWorkspaceModel getModelRoot() {
        return getInstance().fModelRoot;
    }

//    public static IWorkspaceModel open(IWorkspaceRoot wsRoot) throws ModelException {
//        return getInstance().doOpen(wsRoot);
//    }
//
//    private IWorkspaceModel doOpen(IWorkspaceRoot wsRoot) throws ModelException {
//        if (!wsRoot.exists())
//            throw new ModelException(NO_SUCH_ELEMENT);
//
//        return new WorkspaceModel(wsRoot);
//    }

    public static ISourceProject open(IProject project) throws ModelException {
        return getInstance().doOpen(project);
    }

    private ISourceProject doOpen(IProject project) throws ModelException {
        if (!project.exists())
            throw new ModelException(NO_SUCH_ELEMENT);

        ISourceProject sp= fProjectMap.get(project);

        if (sp == null) {
            fProjectMap.put(project, sp= new SourceProject(project));

            // Find each language nature configured on the underlying project, find the
            // corresponding factory extender, and invoke it before returning the project.
            try {
                String[] natures= project.getDescription().getNatureIds();

                for(int i= 0; i < natures.length; i++) {
                    String natureID= natures[i];
                    Language lang= LanguageRegistry.findLanguageByNature(natureID);

                    if (lang != null) {
                        IFactoryExtender ext= fExtenderMap.get(lang);

                        if (ext != null) {
                            ext.extend(sp);
                        }
                    }
                }
            } catch (CoreException e) {
                ErrorHandler.reportError(e.getMessage());
            }
        }
        return sp;
    }

    // TODO needs a progress monitor
    public static ISourceProject create(IProject project) throws ModelException {
        return getInstance().doCreate(project);
    }

    // TODO needs a progress monitor
    private ISourceProject doCreate(IProject project) throws ModelException {
        throw new ModelException(ELEMENT_ALREADY_EXISTS);
    }

    public static ISourceEntity open(IContainer container) throws ModelException {
        return getInstance().doOpen(container);
    }

    public static ISourceEntity open(IResource resource) throws ModelException {
        if (resource instanceof IContainer) {
            return getInstance().doOpen((IContainer) resource);
        } else if (resource instanceof IFile) {
            ISourceProject srcProject= getInstance().doOpen(resource.getProject());
            return getInstance().doOpen((IFile) resource, srcProject);
        }
        return null;
    }

    private ISourceEntity doOpen(IContainer container) throws ModelException {
        if (container instanceof IProject) {
            return doOpen((IProject) container);
        } else if (container instanceof IFolder) {
            return doOpen((IFolder) container);
        } else if (container instanceof IWorkspaceRoot) {
            return fModelRoot; // doOpen((IWorkspaceRoot) container);
        }
        throw new ModelException("Inappropriate argument type " + container.getClass() + " to ModelFactory.doOpen(IContainer).");
    }

    // TODO needs a progress monitor
    public static ISourceEntity create(IContainer container) throws ModelException {
        return getInstance().doCreate(container);
    }

    // TODO needs a progress monitor
    private ISourceEntity doCreate(IContainer container) throws ModelException {
        if (container instanceof IProject) {
            return doCreate((IProject) container);
        } else if (container instanceof IFolder) {
            return doOpen((IFolder) container);
        } else if (container instanceof IWorkspaceRoot) {
            return fModelRoot; // doOpen((IWorkspaceRoot) container);
        }
        throw new ModelException("Inappropriate argument type " + container.getClass() + " to ModelFactory.doOpen(IContainer).");
    }

    public static ISourceFolder open(IFolder folder) throws ModelException {
        return getInstance().doOpen(folder);
    }

    private ISourceFolder doOpen(IFolder folder) throws ModelException {
        if (!folder.exists()) {
            throw new ModelException(NO_SUCH_ELEMENT);
        }
        ISourceProject sp= doOpen(folder.getProject());
        SourceFolder sf= new SourceFolder(sp, folder.getProjectRelativePath());

        return sf;
    }

    /**
     * Creates a source folder. Must not already exist. Containing project
     * must already exist.
     */
    // TODO needs a progress monitor
    public static ISourceFolder create(IFolder folder) throws ModelException {
        return getInstance().doCreate(folder);
    }

    // TODO needs a progress monitor
    private ISourceFolder doCreate(IFolder folder) throws ModelException {
        ISourceProject sp= doOpen(folder.getProject());

        if (!folder.exists()) {
            try {
                folder.create(true, false, null);
            } catch (CoreException e) {
                throw new ModelException("Unable to create underlying folder for source folder " + folder.getLocation().toPortableString(), e);
            }
        }

        SourceFolder sf= new SourceFolder(sp, folder.getProjectRelativePath());

        return sf;
    }

    public static ICompilationUnit open(IPath path, ISourceProject srcProject) {
        return getInstance().doOpen(path, srcProject);
    }

    private ICompilationUnit doOpen(IPath path, ISourceProject srcProject) {
        ICompilationUnit unit;
        IPath resolvedPath;

        if (path.isAbsolute())
            unit= new CompilationUnitRef(resolvedPath= path, null);
        else {
            resolvedPath= srcProject.resolvePath(path);

            if (resolvedPath == null)
                return null;
            unit= new CompilationUnitRef(resolvedPath, srcProject);
        }

        // Determine the language of this compilation unit, find the corresponding
        // factory extender, and invoke it before returning the compilation unit.
        Language lang= LanguageRegistry.findLanguage(resolvedPath, null);
        IFactoryExtender ext= fExtenderMap.get(lang);

        if (ext != null)
            ext.extend(unit);

        return unit;
    }

    public static ICompilationUnit open(IFile file, ISourceProject srcProject) {
        return getInstance().doOpen(file, srcProject);
    }

    private ICompilationUnit doOpen(IFile file, ISourceProject srcProject) {
        if (!file.exists())
            return null;

        ICompilationUnit unit= new CompilationUnitRef(file.getFullPath(), srcProject);

        // Determine the language of this compilation unit, find the corresponding
        // factory extender, and invoke it before returning the compilation unit.
        TextFileDocumentProvider tfdp= new TextFileDocumentProvider(); // TODO perhaps this should be in a field? or another type of doc provider?
        IDocument doc= tfdp.getDocument(file);
        Language lang= LanguageRegistry.findLanguage(file.getLocation(), doc);
        IFactoryExtender ext= fExtenderMap.get(lang);

        if (ext != null)
            ext.extend(unit);

        return unit;
    }

    /**
     * 
     * @param projRelPath
     * @param srcProject
     * @return never returns null
     */
    // TODO needs a progress monitor
    public static ICompilationUnit create(IPath projRelPath, ISourceProject srcProject) throws ModelException {
        return getInstance().doCreate(projRelPath, srcProject);
    }

    // TODO needs a progress monitor
    private ICompilationUnit doCreate(IPath projRelPath, ISourceProject srcProject) throws ModelException {
        throw new ModelException(ELEMENT_ALREADY_EXISTS);
    }

    /**
     * @param file
     * @param srcProject
     * @return the new ICompilationUnit corresponding to the given file
     */
    // TODO needs a progress monitor
    public static ICompilationUnit create(IFile file, ISourceProject srcProject) throws ModelException {
        return getInstance().doCreate(file, srcProject);
    }

    // TODO needs a progress monitor
    private ICompilationUnit doCreate(IFile file, ISourceProject srcProject) throws ModelException {
        return doCreate(file.getProjectRelativePath(), srcProject);
    }

    // TODO needs a progress monitor
    public static IPathEntry createPathEntry(PathEntryType type, IPath path) {
        return new PathEntry(type, path);
    }
}
