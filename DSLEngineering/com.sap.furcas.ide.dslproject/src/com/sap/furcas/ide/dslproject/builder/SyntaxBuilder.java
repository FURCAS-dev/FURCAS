package com.sap.furcas.ide.dslproject.builder;

import java.io.File;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.sap.furcas.ide.dslproject.Activator;
import com.sap.furcas.ide.dslproject.Constants;
import com.sap.furcas.ide.dslproject.conf.IProjectMetaRefConf;
import com.sap.furcas.ide.dslproject.conf.ReferenceScopeBean;
import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.GrammarGenerationTargetConfiguration;
import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSParserGeneratorFactory;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;
import com.sap.furcas.utils.exceptions.EclipseExceptionHelper;

/**
 * An incremental project builder for .tcs-files. It generates lexer, parser and mapping according to .tcs-files found within a
 * project.
 */
public class SyntaxBuilder extends IncrementalProjectBuilder {

    /** The Constant BUILDER_ID. */
    public static final String BUILDER_ID = Activator.class.getPackage().getName() + ".syntaxBuilder";
    private static final String GRAMMAR_ANTLR_POSTFIX = ".g";


    /**
     * Runs a full build
     */
    private class TCSBuildVisitor implements IResourceVisitor {

        private final IProgressMonitor mymonitor;

        public TCSBuildVisitor(IProgressMonitor monitor) {
            mymonitor = monitor;
        }

        @Override
        public boolean visit(IResource resource) {
            try {
                buildGrammar(resource, mymonitor);
            } catch (CoreException e) {
                Activator.logger.logError("Failed to build grammar from resource " + resource, e);
            }
            // return true to continue visiting children.
            return true;
        }
    }

    private class TCSCleanVisitor implements IResourceVisitor {

        private final IProgressMonitor mymonitor;

        public TCSCleanVisitor(IProgressMonitor monitor) {
            mymonitor = monitor;
        }

        @Override
        public boolean visit(IResource resource) {

            try {
                cleanResource(resource, mymonitor);
            } catch (CoreException e) {
                Activator.logger.logError("Failed to clean resource " + resource);
            }
            // return true to continue visiting children.
            return true;
        }
    }

    /**
     * Runs a build according to a given resource delta.
     */
    private class TCSProjectDeltaVisitor implements IResourceDeltaVisitor {

        private final IProgressMonitor mymonitor;

        public TCSProjectDeltaVisitor(IProgressMonitor mymonitor) {
            this.mymonitor = mymonitor;
        }

        @Override
        public boolean visit(IResourceDelta delta) throws CoreException {
            IResource resource = delta.getResource();
            switch (delta.getKind()) {
            case IResourceDelta.ADDED:
                // handle added resource
                buildGrammar(resource, mymonitor);
                break;
            case IResourceDelta.REMOVED:
                // handle removed resource
                break;
            case IResourceDelta.CHANGED:
                // handle changed resource
                buildGrammar(resource, mymonitor);
                break;
            default:
                break;
            }
            // return true to continue visiting children.
            return true;
        }
    }

    @Override
    @SuppressWarnings("rawtypes")
    // Map is defined without generic in supertype
    protected IProject[] build(int kind, Map args, IProgressMonitor pm) throws CoreException {
        try {
            if (kind == FULL_BUILD) {
                getProject().accept(new TCSBuildVisitor(pm));
            } else {
                IResourceDelta delta = getDelta(getProject());
                if (delta == null) {
                    // full build
                    getProject().accept(new TCSBuildVisitor(pm));
                } else {
                    // incremental build
                    delta.accept(new TCSProjectDeltaVisitor(pm));
                }
            }
        } catch (CoreException e) {
            Activator.logger.logError("Failed during build of " + getProject(), e);
            throw e;

        }
        return null;
    }

    private void buildGrammar(IResource resource, IProgressMonitor monitor) throws CoreException {
        if (!(resource instanceof IFile && resource.getName().endsWith(Constants.TCS_EXTENSION))) {
            return; // nothing to build
        }
        IFile syntaxDefFile = (IFile) resource;
        if (syntaxDefFile.isDerived()) {
            return;
        }
        EclipseMarkerUtil.deleteMarkers(syntaxDefFile);
        IProject project = resource.getProject();
        EclipseMarkerUtil.deleteMarkers(project);

        SyntaxGenerationNature nature = SyntaxGenerationNature.getNatureFromProject(project);
        if (nature == null) {
            Activator.logger.logWarning("getProject was null for IFile: " + resource.getName());
        }

        monitor.beginTask("Building Grammar", 110);
        IProjectMetaRefConf conf = nature.getMetaModelReferenceConf();
        if (conf != null) {
            ReferenceScopeBean refScopeBean = conf.getMetaLookUpForProject();
            try {
                GrammarGenerationSourceConfiguration sourceConfig = new GrammarGenerationSourceConfiguration(
                        refScopeBean.getResourceSet(), refScopeBean.getReferenceScope());
                
                IFile grammarFile = getGrammarFile(syntaxDefFile);
                URI createFileURI = URI.createFileURI(project.getFullPath() + File.separator + "mappings" + File.separator + getFileNameBase(syntaxDefFile) + "." + "tcs");
                Resource mappingResource =  refScopeBean.getResourceSet().createResource(createFileURI);
                GrammarGenerationTargetConfiguration targetConfig = new GrammarGenerationTargetConfiguration(
                        getPackageName(grammarFile), convertIFileToFile(grammarFile), mappingResource);

                TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
                TCSSyntaxContainerBean syntaxBean = generator.parseSyntax(sourceConfig, convertIFileToFile(syntaxDefFile), targetConfig,
                        new ResourceMarkingGenerationErrorHandler(
                                syntaxDefFile));
                if(syntaxBean != null) {
                generator.generateGrammarFromSyntax(syntaxBean, sourceConfig, targetConfig, new ResourceMarkingGenerationErrorHandler(
                                syntaxDefFile));
                    if (grammarFile.exists()) {
                        generator.generateParserFromGrammar(targetConfig, new ResourceMarkingGenerationErrorHandler(grammarFile));
    
                        // refresh dir where java was generated so that Java builder can compile
                        grammarFile.getParent().refreshLocal(1, new SubProgressMonitor(monitor, 10));
                    }
                }
            } catch (GrammarGenerationException e) {
               throw new CoreException(EclipseExceptionHelper.getErrorStatus(e, Activator.PLUGIN_ID));
            } catch (ParserGeneratorInvocationException e) {
                throw new CoreException(EclipseExceptionHelper.getErrorStatus(e, Activator.PLUGIN_ID));
            } catch (ParserInvokationException e) {
                throw new CoreException(EclipseExceptionHelper.getErrorStatus(e, Activator.PLUGIN_ID));
            } finally {
                monitor.done();
            }

        } else { // conf is null
            String message = "Build failed: Project " + project.getName()
                    + " has DSL Syntax Definition Nature but no metamodel reference configured.";
            EclipseMarkerUtil.addMarker(project, message, -1, IMarker.SEVERITY_ERROR);
        }
    }
    
    /**
     * Returns the files path in package notation except for the filename,
     * or returns "generated" if no such path exists
     */
    private static String getPackageName(IFile file) {
        String targetPackage = null;
        IPath path = file.getParent().getProjectRelativePath();
        if (path != null && path.segmentCount() >= 2) { // source folder /
            // packagefolder1
            targetPackage = path.segment(1);
            for (int i = 2; i < path.segmentCount(); i++) {
                String segment = path.segment(i);
                targetPackage += '.' + segment;
            }
        } else {
            targetPackage = "generated";
        }
        return targetPackage;
    }
    
    private static IFile getGrammarFile(IFile syntaxDefFile) {
        IContainer directory = syntaxDefFile.getParent();
        String newFileName = getFileNameBase(syntaxDefFile) + GRAMMAR_ANTLR_POSTFIX;
        IFile newFile = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
        return newFile;
    }
    
    private static File convertIFileToFile(IFile file) {
        return new File(file.getRawLocation().toOSString());
    }

    private static String getFileNameBase(IFile file) {
        String fileName = file.getName();
        // "s m i  l e s".substring(1, 5) returns "mile"
        // 0 1 2 3 4 5
        String newFileName = fileName.substring(0, (fileName.length() - file.getFileExtension().length() - 1)); // -1
        return newFileName;
    }

    @Override
    protected void clean(IProgressMonitor monitor) throws CoreException {
        super.clean(monitor);
        try {
            getProject().accept(new TCSCleanVisitor(monitor));
        } catch (CoreException e) {
            Activator.logger.logError("Failed cleaning project " + getProject(), e);
        }
    }

    private void cleanResource(IResource resource, IProgressMonitor mymonitor) throws CoreException {
        // TODO: implement this

        // if (resource instanceof IFile && resource.getName().endsWith(Constants.TCS_EXTENSION)) {
        // // Only delete if we are sure that we can rebuild it
        // // one condition for that is the availability of the metamodel
        // SyntaxGenerationNature nature = SyntaxGenerationNature.getNatureFromProject(resource.getProject());
        //
        // if (nature != null) {
        // IProjectMetaRefConf conf = nature.getMetaModelReferenceConf();
        // if (conf.getMetaLookUpForProject() != null) {
        // IFile file = (IFile) resource;
        // // delete markers
        // EclipseMarkerUtil.deleteMarkers(file);
        // // delete grammarfile
        // IFile[] genfiles = GrammarGenerator.getFilesForClean(file);
        // for (IFile genfile : genfiles) {
        // if (genfile.exists()) {
        // EclipseMarkerUtil.deleteMarkers(genfile);
        // genfile.delete(IResource.FORCE, mymonitor);
        // }
        // }
        // }
        // }
        // }
    }

    // /**
    // * returns the name of the grammarfile that would be created in build.
    // */
    // public static IFile[] getFilesForClean(IFile file) {
    // IFile[] files = new IFile[5];
    //
    // files[0] = getGrammarFile(file);
    //
    // IContainer directory = file.getParent();
    // String newFileName = getFileNameBase(file) + "Parser.java";
    // files[1] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
    // newFileName = getFileNameBase(file) + "Lexer.java";
    // files[2] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
    // newFileName = getFileNameBase(file) + "__.g";
    // files[3] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
    // newFileName = getFileNameBase(file) + ".tokens";
    // files[4] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
    //
    // return files;
    // }
}
