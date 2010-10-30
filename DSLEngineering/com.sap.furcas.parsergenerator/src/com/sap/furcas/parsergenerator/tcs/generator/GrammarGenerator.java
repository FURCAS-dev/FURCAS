package com.sap.furcas.parsergenerator.tcs.generator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.parsergenerator.Activator;
import com.sap.furcas.parsergenerator.emf.lookup.EcoreMetaLookup;
import com.sap.furcas.parsergenerator.tcs.generator.errorhandling.EclipseMarkerUtil;
import com.sap.furcas.parsergenerator.tcs.generator.errorhandling.GenerationErrorHandler;
import com.sap.furcas.parsergenerator.tcs.t2m.TCSInputStreamGrammarGenerator;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.GenerationReport;
import com.sap.furcas.runtime.common.exceptions.GrammarGenerationException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.impl.ParsingError;
import com.sap.furcas.runtime.parser.impl.TextLocation;
import com.sap.furcas.utils.exceptions.EclipseExceptionHelper;
import com.sap.furcas.utils.projects.ReferenceScopeBean;

/**
 * The Class GrammarGenerationBuildHelper.
 */
public class GrammarGenerator {

    private static final String MAPPING_XMI_POSTFIX = "Mapping.xmi";

    
    /**
     * Assumes file is a Syntax definition, parses that file, creates a grammar file in the same directory, and returns it.
     * 
     * @param refScopeBean
     *            the lookup
     * @param syntaxDefFile
     *            the file
     * @param monitor
     *            the monitor
     * @param errorhandler
     *            the errorhandler
     * @param qualifiedNamesSeparator
     * @param targetpackage
     * @param parserSuperClass
     * 
     * @return the generated grammar file
     * 
     * @throws CoreException
     *             the core exception
     */
    public static IFile buildGrammar(ReferenceScopeBean refScopeBean, ResourceSet targetConnection, IFile syntaxDefFile,
            IProgressMonitor monitor, GenerationErrorHandler errorhandler, String targetpackage,
            Class<? extends ObservableInjectingParser> parserSuperClass) throws CoreException {

        IFile newGrammarFile = getGrammarFile(syntaxDefFile);
        monitor.worked(10);

        // IContainer directory = file.getParent();

        parseSyntaxAndGenerateGrammar(syntaxDefFile, refScopeBean, targetConnection, newGrammarFile, monitor, errorhandler, targetpackage, parserSuperClass);
        // was grammar file written (implies has changed)?
        // grammar without errors?
        return newGrammarFile;
    }

    private static IFile getGrammarFile(IFile file) {
        IContainer directory = file.getParent();

        String newFileName = getFileNameBase(file) + ".g";
        IFile newFile = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
        return newFile;
    }

    private static String getFileNameBase(IFile file) {
        String fileName = file.getName();
        // "s m i  l e s".substring(1, 5) returns "mile"
        // 0 1 2 3 4 5
        String newFileName = fileName.substring(0, (fileName.length() - file.getFileExtension().length() - 1)); // -1
        return newFileName;
    }

    /**
     * Parses the syntaxDefFile, and generates an ANTLR grammar file using also the MetaModel for reference. We may have 2
     * connections here, one from the scopeBean, one for the creation of elements.
     * 
     * @param parserSuperClass
     *            may be null, then default wil be used
     * @throws CoreException
     *             the core exception
     */
    private static void parseSyntaxAndGenerateGrammar(IFile syntaxDefFile, ReferenceScopeBean refScopeBean, ResourceSet targetConnection,
            IFile grammarFile, IProgressMonitor monitor, GenerationErrorHandler errorhandler, String targetPackage,
            Class<? extends ObservableInjectingParser> parserSuperClass) throws CoreException {

        InputStream in = syntaxDefFile.getContents();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {

            EcoreMetaLookup lookup = new EcoreMetaLookup(refScopeBean.getResourceSet(), refScopeBean.getReferenceScope());
            TCSInputStreamGrammarGenerator generator = new TCSInputStreamGrammarGenerator(in, out, lookup, targetPackage);
            // we may have 2 connections here, one from the scopeBean, one
            // transient
            // transientConnection =
            // ConnectionManager.getInstance().createTransientConnection();
            GenerationReport report = generator.generateGrammar(targetConnection, refScopeBean.getReferenceScope(),
                    parserSuperClass);

            writeMappingToFile(syntaxDefFile.getProject(), report.getSyntax());

            boolean hasErrors = false;
            String fileNameWithoutSuffix = grammarFile.getName().substring(0,
                    grammarFile.getName().length() - (grammarFile.getFileExtension().length() + 1));
            if (!fileNameWithoutSuffix.equals(report.getSyntaxName())) {
                report.addError(new ParsingError("Syntax name and file name must be equal: " + fileNameWithoutSuffix + " != "
                        + report.getSyntaxName(), (TextLocation) null));
                hasErrors = true;
            }

            if (report.getWarnings() != null && report.getWarnings().size() > 0) {
                for (ParsingError warning : report.getWarnings()) {
                    EclipseMarkerUtil.addMarker(syntaxDefFile, warning, IMarker.SEVERITY_WARNING);
                }
            }
            if (report.getErrors() != null && report.getErrors().size() > 0) {
                hasErrors = true;
                for (ParsingError parsingError : report.getErrors()) {
                    EclipseMarkerUtil.addMarker(syntaxDefFile, parsingError, IMarker.SEVERITY_ERROR);
                }
            }

            if (!hasErrors) {
                InputStream resultingIn = new ByteArrayInputStream(out.toByteArray());
                monitor.worked(50);
                if (grammarFile.exists()) {
                    grammarFile.delete(true, monitor);
                }
                grammarFile.create(resultingIn, true, null);
            }
        } catch (SyntaxParsingException e) {
            List<ParsingError> errors = e.getErrorList();
            if (errors != null) {
                for (ParsingError parsingError : errors) {
                    EclipseMarkerUtil.addMarker(syntaxDefFile, parsingError, IMarker.SEVERITY_ERROR);
                }
            } else {
                throw new CoreException(EclipseExceptionHelper.getErrorStatus(
                        "No Parsing Errors delievered with " + e.getMessage(), Activator.PLUGIN_ID));
            }
        } catch (ModelAdapterException e) {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus(e, Activator.PLUGIN_ID));
        } catch (GrammarGenerationException e) {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus(e, Activator.PLUGIN_ID));
        } catch (IOException e) {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus(e, Activator.PLUGIN_ID));
        } catch (ParserInvokationException e) {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus(e, Activator.PLUGIN_ID));
        }
    }
    
    
    /**
     * Writes the given syntax to a default resource. The resource location is constructed within the src folder of the given
     * <tt>project</tt> with the name of the {@link ConcreteSyntax syntax} postfixed with "Mapping.xmi". If the resource already
     * exists it will be emptied.
     * 
     * @param project
     * @param syntax
     */
    private static void writeMappingToFile(IProject project, ConcreteSyntax syntax) {
        Resource resource = getOrCreateMappingResource(project, syntax, syntax.eResource().getResourceSet());
        try {
            resource.getContents().add(syntax);
            resource.save(null);
        } catch (IOException e) {
            Activator.logger.logError("Failed to write mapping to file", e);
        }
    }

    private static Resource getOrCreateMappingResource(IProject project, ConcreteSyntax syntax, ResourceSet resourceSet) {
        IPath partitionRelativePath = project.getFullPath().append(
                project.getFile("mappings/" + syntax.getName() + MAPPING_XMI_POSTFIX).getProjectRelativePath());
        Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(partitionRelativePath.toString(), true), true);
        if (resource != null) {
            resource.getContents().clear();
        } else {
            resource = resourceSet.createResource(URI.createPlatformResourceURI(partitionRelativePath.toString(), true));
        }
        return resource;
    }

    /**
     * returns the name of the grammarfile that would be created in build.
     */
    public static IFile[] getFilesForClean(IFile file) {
        IFile[] files = new IFile[5];

        files[0] = getGrammarFile(file);

        IContainer directory = file.getParent();
        String newFileName = getFileNameBase(file) + "Parser.java";
        files[1] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
        newFileName = getFileNameBase(file) + "Lexer.java";
        files[2] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
        newFileName = getFileNameBase(file) + "__.g";
        files[3] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));
        newFileName = getFileNameBase(file) + ".tokens";
        files[4] = directory.getFile(new Path(IPath.SEPARATOR + newFileName));

        return files;
    }

}
