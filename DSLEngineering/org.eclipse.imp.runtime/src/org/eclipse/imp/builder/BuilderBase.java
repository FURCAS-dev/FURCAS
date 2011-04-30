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

package org.eclipse.imp.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.imp.preferences.IPreferencesService;
import org.eclipse.imp.preferences.PreferenceConstants;
import org.eclipse.imp.preferences.PreferencesService;
import org.eclipse.imp.runtime.PluginBase;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.imp.utils.UnimplementedError;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public abstract class BuilderBase extends IncrementalProjectBuilder {
    /**
     * The name of the console used for any builders that don't provide an override
     * of getConsoleName() to use their own unique console
     */
    public static final String IMP_BUILDER_CONSOLE= "IMP Builders";

    /**
     * @return the plugin associated with this builder instance
     */
    protected abstract PluginBase getPlugin();

    /**
     * @return the extension ID of this builder
     */
    public String getBuilderID() {
    	throw new UnimplementedError("Not implemented for builder for plug-in " + getPlugin().getID());
    }
    
    /**
     * @return true iff the given file is a source file that this builder should compile.
     */
    protected abstract boolean isSourceFile(IFile file);

    /**
     * @return true iff the given file is a source file that this builder should scan
     * for dependencies, but not compile as a top-level compilation unit.<br>
     * <code>isNonRootSourceFile()</code> and <code>isSourceFile()</code> should never
     * return true for the same file.
     */
    protected abstract boolean isNonRootSourceFile(IFile file);

    /**
     * @return true iff the given resource is an output folder
     */
    protected abstract boolean isOutputFolder(IResource resource);

    /**
     * Does whatever is necessary to "compile" the given "source file".
     * @param file the "source file" to compile
     * @param monitor used to indicate progress in the UI
     */
    protected abstract void compile(IFile file, IProgressMonitor monitor);

    /**
     * Collects compilation-unit dependencies for the given file, and records
     * them via calls to <code>fDependency.addDependency()</code>.
     */
    protected abstract void collectDependencies(IFile file);

    /**
     * @return the ID of the marker type to be used to indicate compiler errors
     */
    protected abstract String getErrorMarkerID();

    /**
     * @return the ID of the marker type to be used to indicate compiler warnings
     */
    protected abstract String getWarningMarkerID();

    /**
     * @return the ID of the marker type to be used to indicate compiler information
     * messages
     */
    protected abstract String getInfoMarkerID();

    private final IResourceVisitor fResourceVisitor= new SourceCollectorVisitor();

    private final IResourceDeltaVisitor fDeltaVisitor= new SourceDeltaVisitor();

    private IPreferencesService fPrefService;

    protected DependencyInfo fDependencyInfo;

    private final Collection<IFile> fChangedSources= new HashSet<IFile>();

    private final Collection<IFile> fSourcesToCompile= new HashSet<IFile>();

    private final Collection<IFile> fSourcesForDeps= new HashSet<IFile>();

    private final class SourceDeltaVisitor implements IResourceDeltaVisitor {
        public boolean visit(IResourceDelta delta) throws CoreException {
            return processResource(delta.getResource());
        }
    }

    private class SourceCollectorVisitor implements IResourceVisitor {
        public boolean visit(IResource res) throws CoreException {
            return processResource(res);
        }
    }

    private boolean processResource(IResource resource) {
        if (resource instanceof IFile) {
            IFile file= (IFile) resource;

            if (file.exists()) {
                if (isSourceFile(file) || isNonRootSourceFile(file)) {
                    fChangedSources.add(file);
                }
            }
            return false;
        } else if (isOutputFolder(resource)) {
            return false;
        }
        return true;
    }

    private class AllSourcesVisitor implements IResourceVisitor {
        private final Collection<IFile> fResult;

        public AllSourcesVisitor(Collection<IFile> result) {
            fResult= result;
        }

        public boolean visit(IResource resource) throws CoreException {
            if (resource instanceof IFile) {
                IFile file= (IFile) resource;

                if (file.exists()) {
                    if (isSourceFile(file) || isNonRootSourceFile(file)) {
                        fResult.add(file);
                    }
                }
                return false;
            } else if (isOutputFolder(resource)) {
                return false;
            }
            return true;
        }
    }

    protected DependencyInfo createDependencyInfo(IProject project) {
        return new DependencyInfo(project);
    }

    @SuppressWarnings("unchecked")
    protected IProject[] build(int kind, Map args, IProgressMonitor monitor) {
        if (getPreferencesService().getProject() == null) {
            getPreferencesService().setProject(getProject());
        }

        fChangedSources.clear();
        fSourcesForDeps.clear();
        fSourcesToCompile.clear();

        boolean partialDeps= true;
        Collection<IFile> allSources= new ArrayList<IFile>();

        if (fDependencyInfo == null || kind == FULL_BUILD || kind == CLEAN_BUILD) {
            fDependencyInfo= createDependencyInfo(getProject());
            try {
                getProject().accept(new AllSourcesVisitor(allSources));
            } catch (CoreException e) {
                getPlugin().getLog().log(new Status(IStatus.ERROR, getPlugin().getID(), e.getLocalizedMessage(), e));
            }
            fSourcesForDeps.addAll(allSources);
            // Collect deps now, so we can compile everything necessary in the case where
            // we have no dep info yet (e.g. first build for this Eclipse invocation --
            // we don't persist the dep info yet) but we've been asked to do an auto build
            // b/c of workspace changes.
            collectDependencies(monitor);
            partialDeps= false;
        }

        if (kind == FULL_BUILD || kind == CLEAN_BUILD) {
            clearMarkersOn(allSources);
        }

        try {
            collectSourcesToCompile(monitor);
            clearDependencyInfoForChangedFiles();
            if (partialDeps) {
                fSourcesForDeps.addAll(fSourcesToCompile);
                fSourcesForDeps.addAll(fChangedSources);
                collectDependencies(monitor);
            }
            compileNecessarySources(monitor);
            if (getDiagPreference()) {
                getConsoleStream().print(fDependencyInfo.toString());
            }
        } catch (CoreException e) {
            getPlugin().writeErrorMsg("Build failed: " + e.getMessage());
        }
        return new IProject[0];
    }

    protected void compileNecessarySources(IProgressMonitor monitor) {
        for(Iterator<IFile> iter= fSourcesToCompile.iterator(); iter.hasNext(); ) {
            IFile srcFile= iter.next();

            clearMarkersOn(srcFile);
            if (isSourceFile(srcFile)) {
                compile(srcFile, monitor);
            }
        }
    }

    protected void collectDependencies(IProgressMonitor monitor) {
        for(IFile srcFile: fSourcesForDeps) {
            collectDependencies(srcFile);
        }
    }

    /**
     * Clears all problem markers (all markers whose type derives from IMarker.PROBLEM)
     * from the given file. A utility method for the use of derived builder classes.
     */
    protected void clearMarkersOn(IFile file) {
        try {
            // SMS 28 Mar 2007
    		// Clear the markers for this builder only (and clear all of them)
    		// (may be a simpler way to do this, given a more complex set up of
    		// marker types)
    	    //file.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
    	    file.deleteMarkers(getErrorMarkerID(), true, IResource.DEPTH_INFINITE);
    	    file.deleteMarkers(getWarningMarkerID(), true, IResource.DEPTH_INFINITE);
    	    file.deleteMarkers(getInfoMarkerID(), true, IResource.DEPTH_INFINITE);
    	} catch (CoreException e) {
    	}
    }

    protected void clearMarkersOn(Collection<IFile> files) {
        for(IFile file: files) {
            clearMarkersOn(file);
        }
    }

    private void dumpSourceList(Collection<IFile> sourcesToCompile) {
        MessageConsoleStream consoleStream= getConsoleStream();

        for(Iterator<IFile> iter= sourcesToCompile.iterator(); iter.hasNext(); ) {
            IFile srcFile= iter.next();

            consoleStream.println("  " + srcFile.getFullPath());
        }
    }

    /**
     * Clears the dependency information maintained for all files marked as
     * having changed (i.e. in <code>fSourcesToCompile</code>).
     */
    private void clearDependencyInfoForChangedFiles() {
        for(Iterator<IFile> iter= fSourcesToCompile.iterator(); iter.hasNext(); ) {
            IFile srcFile= iter.next();

            fDependencyInfo.clearDependenciesOf(srcFile.getFullPath().toString());
        }
    }

    protected IPreferencesService getPreferencesService() {
        if (fPrefService == null) {
            fPrefService= new PreferencesService(null, getPlugin().getLanguageID());        
        }
        return fPrefService;
    }

    protected boolean getDiagPreference() {
        final IPreferencesService builderPrefSvc= getPlugin().getPreferencesService();
        final IPreferencesService impPrefSvc= RuntimePlugin.getInstance().getPreferencesService();
        
        boolean msgs= builderPrefSvc.isDefined(PreferenceConstants.P_EMIT_BUILDER_DIAGNOSTICS) ?
            builderPrefSvc.getBooleanPreference(PreferenceConstants.P_EMIT_BUILDER_DIAGNOSTICS) :
                impPrefSvc.getBooleanPreference(PreferenceConstants.P_EMIT_BUILDER_DIAGNOSTICS);
        return msgs;
    }

    /**
     * Visits the project delta, if any, or the entire project, and determines the set
     * of files needed recompilation, and adds them to <code>fSourcesToCompile</code>.
     * @param monitor
     * @throws CoreException
     */
    private void collectSourcesToCompile(IProgressMonitor monitor) throws CoreException {
        IResourceDelta delta= getDelta(getProject());
        boolean emitDiags= getDiagPreference();

        if (delta != null) {
            if (emitDiags)
                getConsoleStream().println("==> Scanning resource delta for project '" + getProject().getName() + "'... <==");
            delta.accept(fDeltaVisitor);
            if (emitDiags)
                getConsoleStream().println("Delta scan completed for project '" + getProject().getName() + "'...");
        } else {
            if (emitDiags)
                getConsoleStream().println("==> Scanning for source files in project '" + getProject().getName() + "'... <==");
            getProject().accept(fResourceVisitor);
            if (emitDiags)
                getConsoleStream().println("Source file scan completed for project '" + getProject().getName() + "'...");
        }
        collectChangeDependents();
        if (emitDiags) {
            getConsoleStream().println("All files to compile:");
            dumpSourceList(fSourcesToCompile);
        }
    }

    // TODO This really *shouldn't* be transitive; the real problem w/ the LPGBuilder is that it
    // doesn't account for transitive includes itself when computing its dependency info. That is,
    // when file A includes B includes C, A should be marked as a dependent of C.
    private void collectChangeDependents() {
        if (fChangedSources.size() == 0) return;

        Collection<IFile> changeDependents= new HashSet<IFile>();
        boolean emitDiags= getDiagPreference();

        changeDependents.addAll(fChangedSources);
        if (emitDiags) {
            getConsoleStream().println("Changed files:");
            dumpSourceList(changeDependents);
        }

        boolean changed= false;
        do {
            Collection<IFile> additions= new HashSet<IFile>();
            scanSourceList(changeDependents, additions);
            changed= changeDependents.addAll(additions);
        } while (changed);

        for(IFile f: changeDependents) {
            if (isSourceFile(f)) {
                fSourcesToCompile.add(f);
            }
        }
//      getConsoleStream().println("Changed files + dependents:");
//      dumpSourceList(fSourcesToCompile);
    }

    private boolean scanSourceList(Collection<IFile> srcList, Collection<IFile> changeDependents) {
        boolean result= false;
        for(Iterator<IFile> iter= srcList.iterator(); iter.hasNext(); ) {
            IFile srcFile= iter.next();
            Set<String> fileDependents= fDependencyInfo.getDependentsOf(srcFile.getFullPath().toString());

            if (fileDependents != null) {
                for(Iterator<String> iterator= fileDependents.iterator(); iterator.hasNext(); ) {
                    String depPath= iterator.next();
                    IFile depFile= getProject().getWorkspace().getRoot().getFile(new Path(depPath));

                    result= result || changeDependents.add(depFile);
                }
            }
        }
        return result;
    }

    /**
     * Refreshes all resources in the entire project tree containing the given resource.
     * Crude but effective.
     */
    protected void doRefresh(final IResource resource) {
        IWorkspaceRunnable r= new IWorkspaceRunnable() {
            public void run(IProgressMonitor monitor) throws CoreException {
                resource.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
            }
        };
        try {
            getProject().getWorkspace().run(r, resource.getProject(), IWorkspace.AVOID_UPDATE, null);
        } catch (CoreException e) {
            getPlugin().logException("Error while refreshing after a build", e);
        }
    }

    /**
     * @return the ID of the marker type for the given marker severity (one of
     * <code>IMarker.SEVERITY_*</code>). If the severity is unknown/invalid,
     * returns <code>getInfoMarkerID()</code>.
     */
    protected String getMarkerIDFor(int severity) {
        switch(severity) {
            case IMarker.SEVERITY_ERROR: return getErrorMarkerID();
            case IMarker.SEVERITY_WARNING: return getWarningMarkerID();
            case IMarker.SEVERITY_INFO: return getInfoMarkerID();
            default: return getInfoMarkerID();
        }
    }

    /**
     * Utility method to create a marker on the given resource using the given
     * information.
     * @param errorResource
     * @param startLine the line with which the error is associated
     * @param charStart the offset of the first character with which the error is associated               
     * @param charEnd the offset of the last character with which the error is associated
     * @param message a human-readable text message to appear in the "Problems View"
     * @param severity the message severity, one of <code>IMarker.SEVERITY_*</code>
     */
    public IMarker createMarker(IResource errorResource, int startLine, int charStart, int charEnd, String message, int severity) {
        try {
        	// TODO:  Address this situation properly after demo
        	// Issue is resources that are templates and not in user's workspace
        	if (!errorResource.exists())
        		return null;
        	
            IMarker m = errorResource.createMarker(getMarkerIDFor(severity));

            String[] attributeNames = new String[] {IMarker.LINE_NUMBER, IMarker.MESSAGE, IMarker.PRIORITY, IMarker.SEVERITY};
            Object[] values = new Object[] {startLine, message, IMarker.PRIORITY_HIGH, severity};        
            m.setAttributes(attributeNames, values);
            
            if (charStart >= 0 && charEnd >= 0) {
            	attributeNames = new String[] {IMarker.CHAR_START, IMarker.CHAR_END};
            	values = new Object[] {charStart, charEnd};
                m.setAttributes(attributeNames, values);
            } else if (charStart >= 0) {
            	m.setAttribute(IMarker.CHAR_START, charStart);
            } else if (charEnd >= 0) {
            	m.setAttribute(IMarker.CHAR_END, charEnd);
            }
            return m;
        } catch (CoreException e) {
            getPlugin().writeErrorMsg("Unable to create marker: " + e.getMessage());
        }
        return null;
    }

    /**
     * Posts a dialog displaying the given message as soon as "conveniently possible".
     * This is not a synchronous call, since this method will get called from a
     * different thread than the UI thread, which is the only thread that can
     * post the dialog box.
     */
    protected void postMsgDialog(final String title, final String msg) {
        PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
            public void run() {
                Shell shell= RuntimePlugin.getInstance().getWorkbench().getActiveWorkbenchWindow().getShell();
    
                MessageDialog.openInformation(shell, title, msg);
            }
        });
    }

    /**
     * Posts a dialog displaying the given message as soon as "conveniently possible".
     * This is not a synchronous call, since this method will get called from a
     * different thread than the UI thread, which is the only thread that can
     * post the dialog box.
     */
    protected void postQuestionDialog(final String title, final String query, final Runnable runIfYes, final Runnable runIfNo) {
        PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
            public void run() {
                Shell shell= RuntimePlugin.getInstance().getWorkbench().getActiveWorkbenchWindow().getShell();
                boolean response= MessageDialog.openQuestion(shell, title, query);
    
                if (response)
                    runIfYes.run();
                else if (runIfNo != null)
                    runIfNo.run();
            }
        });
    }

    /**
     * Derived classes may override to specify a unique name for a separate console;
     * otherwise, all IMP builders share a single console. @see IMP_BUILDER_CONSOLE.
     * @return the name of the console to use for diagnostic output, if any
     */
    protected String getConsoleName() {
        return IMP_BUILDER_CONSOLE;
    }

    /**
     * If you want your builder to have its own console, be sure to override
     * getConsoleName().
     * @return the console whose name is returned by getConsoleName()
     */
    protected MessageConsoleStream getConsoleStream() {
        return findConsole(getConsoleName()).newMessageStream();
    }

    /**
     * Find or create the console with the given name
     * @param consoleName
     */
    protected MessageConsole findConsole(String consoleName) {
        if (consoleName == null) {
            RuntimePlugin.getInstance().getLog().log(new Status(IStatus.ERROR, RuntimePlugin.IMP_RUNTIME, "BuilderBase.findConsole() called with a null console name; substituting default console"));
            consoleName= IMP_BUILDER_CONSOLE;
        }
        MessageConsole myConsole= null;
        final IConsoleManager consoleManager= ConsolePlugin.getDefault().getConsoleManager();
        IConsole[] consoles= consoleManager.getConsoles();
        for(int i= 0; i < consoles.length; i++) {
            IConsole console= consoles[i];
            if (console.getName().equals(consoleName))
                myConsole= (MessageConsole) console;
        }
        if (myConsole == null) {
            myConsole= new MessageConsole(consoleName, null);
            consoleManager.addConsoles(new IConsole[] { myConsole });
        }
//      consoleManager.showConsoleView(myConsole);
        return myConsole;
    }
}
