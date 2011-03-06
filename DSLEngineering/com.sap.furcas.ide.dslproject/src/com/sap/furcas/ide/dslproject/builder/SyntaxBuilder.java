package com.sap.furcas.ide.dslproject.builder;

import java.io.File;
import java.io.IOException;
import java.util.Map;

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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.sap.furcas.ide.dslproject.Activator;
import com.sap.furcas.ide.dslproject.Constants;
import com.sap.furcas.ide.dslproject.conf.IProjectMetaRefConf;
import com.sap.furcas.ide.dslproject.conf.ReferenceScopeBean;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.parsergenerator.GenerationErrorHandler;
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
                doFullBuild(resource, mymonitor);
            } catch (CoreException e) {
                Activator.logger.logError("Failed to build grammar from resource " + resource, e);
            }
            // return true to continue visiting children.
            return true;
        }
    }

    private class TCSCleanVisitor implements IResourceVisitor {

        @SuppressWarnings("unused")
        private final IProgressMonitor mymonitor;

        public TCSCleanVisitor(IProgressMonitor monitor) {
            mymonitor = monitor;
        }

        @Override
        public boolean visit(IResource resource) {
              // TODO implement cleaning. For now we do simply overwrite
//            try {
//                 cleanResource(resource, mymonitor);
//            } catch (CoreException e) {
//                Activator.logger.logError("Failed to clean resource " + resource);
//            }
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
                doFullBuild(resource, mymonitor);
                break;
            case IResourceDelta.REMOVED:
                // handle removed resource
                break;
            case IResourceDelta.CHANGED:
                // handle changed resource
                doFullBuild(resource, mymonitor);
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

    /**
     * Builds a new parsers. Works on plaintext TCS files and also TCS syntax models.
     * When run on a plaintext file a model is created and stored.
     * 
     * FIXME: hardcoded project relative paths are used. We have to make them configurable.
     */
    private void doFullBuild(IResource resource, IProgressMonitor monitor) throws CoreException {
        if (!resource.getName().endsWith(Constants.TCS_EXTENSION) || resource.isDerived()) {
            return; // nothing to build
        }
        monitor.beginTask("Building FURCAS Parser", 110);

        SyntaxGenerationNature nature = SyntaxGenerationNature.getNatureFromProject(resource.getProject());
        IProjectMetaRefConf conf = nature.getMetaModelReferenceConf();
        if (conf == null) {
            String message = "Build failed: Project " + resource.getProject().getName()
                    + " has DSL Syntax Definition Nature but no metamodel reference configured.";
            EclipseMarkerUtil.addMarker(resource, message, -1, IMarker.SEVERITY_ERROR);
            return;
        }

        EclipseMarkerUtil.deleteMarkers(resource);
        ReferenceScopeBean refScopeBean = conf.getMetaLookUpForProject();
        try {
            GrammarGenerationSourceConfiguration sourceConfig = new GrammarGenerationSourceConfiguration(
                    refScopeBean.getResourceSet(), refScopeBean.getReferenceScope());

            IFile grammarFile = getGrammarFile(resource);
            GrammarGenerationTargetConfiguration targetConfig = new GrammarGenerationTargetConfiguration(
                    getPackageName(grammarFile), convertIFileToFile(grammarFile));

            TCSSyntaxContainerBean syntaxBean;
            if (!hasModelContent(resource, refScopeBean)) {
                monitor.subTask("Parsing Syntax " + resource.getName());
                syntaxBean = parseSyntax(resource, sourceConfig);
                IResource modelResource = resource.getProject().getFile("mapping" + File.separator + getFileNameBase(resource) + "." + "tcs");
                if (modelResource.getModificationStamp() > resource.getModificationStamp()) {
                    // The plaintext file is older than the model. We do not want to overwrite the model file.
                    // (happens when the project is cleaned and a rebuilt is triggered)
                    return;
                }
                saveSyntaxAsModel(modelResource, sourceConfig, syntaxBean);
            } else {
                syntaxBean = loadSyntaxFromModelFile(resource, sourceConfig);
            }
            if (syntaxBean == null) {
                return;
            }
            GenerationErrorHandler errorHandler = new ResourceMarkingGenerationErrorHandler(resource);
            monitor.subTask("Generating Parser for " + resource.getName());
            buildParser(syntaxBean, grammarFile, sourceConfig, targetConfig, errorHandler);

        } catch (GrammarGenerationException e) {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus(e, Activator.PLUGIN_ID));
        } catch (ParserGeneratorInvocationException e) {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus(e, Activator.PLUGIN_ID));
        } catch (ParserInvokationException e) {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus(e, Activator.PLUGIN_ID));
        } catch (IOException e) {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus(e, Activator.PLUGIN_ID));
        } finally {
            monitor.done();
        }
    }

    private TCSSyntaxContainerBean parseSyntax(IResource resource, GrammarGenerationSourceConfiguration sourceConfig) throws ParserInvokationException, ParserGeneratorInvocationException {
        TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
        
        TCSSyntaxContainerBean syntaxBean = generator.parseSyntax(sourceConfig, convertIFileToFile(resource), new ResourceMarkingGenerationErrorHandler(resource));
        if (syntaxBean.getSyntax() == null) {
            return null; // failed with errors. Markers have been created.
        }
        return syntaxBean;
    }

    private void saveSyntaxAsModel(IResource resource, GrammarGenerationSourceConfiguration sourceConfig,
            TCSSyntaxContainerBean syntaxBean) throws IOException {
        URI modelFileURI = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
        Resource mappingResource;
        try {
            mappingResource = sourceConfig.getResourceSet().getResource(modelFileURI, true);
        } catch (Exception e){
            mappingResource = sourceConfig.getResourceSet().createResource(modelFileURI);
        }
        mappingResource.getContents().clear();
        mappingResource.getContents().add(syntaxBean.getSyntax());
        // FIXME: We have to replace replace all /resource/ uris with /plugin/
        // See https://bugzilla.furcas.org/cgi-bin/bugzilla3/show_bug.cgi?id=88
        mappingResource.save(null);
    }
    
    private TCSSyntaxContainerBean loadSyntaxFromModelFile(IResource resource, GrammarGenerationSourceConfiguration sourceConfig) {
        URI modelFileURI = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
        Resource mappingResource = sourceConfig.getResourceSet().getResource(modelFileURI, true);
        
        EObject concreteSyntax = mappingResource.getContents().iterator().next();
        if (!(concreteSyntax instanceof ConcreteSyntax)) {
            Activator.logger.displayError("Expected mapping resource: " + mappingResource.getURI()
                    + " to contain Concrete Sytnax element but found: " + concreteSyntax.eClass().getName());
            return null;
        }
        TCSSyntaxContainerBean syntaxBean = new TCSSyntaxContainerBean();
        syntaxBean.setSyntax((ConcreteSyntax) concreteSyntax);
        return syntaxBean;
    }

    private void buildParser(TCSSyntaxContainerBean syntaxBean, IFile grammarFile, GrammarGenerationSourceConfiguration sourceConfig, GrammarGenerationTargetConfiguration targetConfig, GenerationErrorHandler errorHandler) throws GrammarGenerationException, CoreException, ParserGeneratorInvocationException {
        TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();

        generator.generateGrammarFromSyntax(syntaxBean, sourceConfig, targetConfig, errorHandler);
        grammarFile.getParent().refreshLocal(1, new NullProgressMonitor());
        if (targetConfig.getGrammarTargetFile().exists()) {
            generator.generateParserFromGrammar(targetConfig, new ResourceMarkingGenerationErrorHandler(grammarFile));
        }
        // refresh dir where java was generated so that Java builder can compile
        grammarFile.getParent().refreshLocal(1, new NullProgressMonitor());
    }
        
    private static boolean hasModelContent(IResource resource, ReferenceScopeBean refScopeBean) {
        URI modelFileURI = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
        try {
            refScopeBean.getResourceSet().getResource(modelFileURI, true);
            return true;
        } catch (Exception ex) {
            // load failed, so it seems to be a plain text file
            return false;
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
    
    private static IFile getGrammarFile(IResource resource) {
        String newFileName = "generated" + File.separator + "generated" + File.separator + getFileNameBase(resource) + GRAMMAR_ANTLR_POSTFIX;
        return resource.getProject().getFile(new Path(IPath.SEPARATOR + newFileName));
    }
    
    private static File convertIFileToFile(IResource file) {
        return new File(file.getRawLocation().toOSString());
    }

    private static String getFileNameBase(IResource file) {
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

}
