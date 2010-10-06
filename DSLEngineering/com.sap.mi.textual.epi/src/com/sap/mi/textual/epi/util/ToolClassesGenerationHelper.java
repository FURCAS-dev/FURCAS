package com.sap.mi.textual.epi.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.textual.common.exceptions.GrammarGenerationException;
import com.sap.furcas.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.epi.conf.ReferenceScopeBean;
import com.sap.mi.textual.epi.errors.GrammarGenerationErrorHandler;
import com.sap.mi.textual.epi.filedefinition.TCSInputStreamGrammarGenerator;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.grammar.impl.ParsingError;
import com.sap.mi.textual.grammar.impl.TextLocation;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.GenerationReport;
import com.sap.mi.textual.moinlookup.MoinMetaLookup;


/**
 * helper class dealing with communication to syntax parser generation classes.
 * 
 * @author C5107456
 */
public class ToolClassesGenerationHelper {

    /**
     * Parses the syntaxDefFile, and generates an ANTLR grammar file using also the MetaModel for reference.
     * We may have 2 connections here, one from the scopeBean, one for the creation of elements.
     * 
     * @param lookup the lookup
     * @param syntaxDefFile the syntax def file
     * @param grammarFile the grammar file
     * @param errorhandler the errorhandler
     * @param monitor the monitor
     * @param qualifiedNamesSeparator 
     * @param targetPackage 
     * @param parserSuperClass may be null, then default wil be used 
     * 
     * @throws CoreException the core exception
     */
    public static void writeGrammarIfChanged( IFile syntaxDefFile, ReferenceScopeBean refScopeBean, ResourceSet targetConnection, IFile grammarFile, IProgressMonitor monitor, GrammarGenerationErrorHandler errorhandler, String targetPackage, Class<? extends ObservableInjectingParser> parserSuperClass) throws CoreException {

        InputStream in = syntaxDefFile.getContents();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ResourceSet transientConnection = null;
        try {

            MoinMetaLookup lookup = new MoinMetaLookup(refScopeBean.getConnection(), refScopeBean.getReferencePRIs());
            TCSInputStreamGrammarGenerator generator = new TCSInputStreamGrammarGenerator(in, out, lookup, targetPackage);
            // we may have 2 connections here, one from the scopeBean, one transient
            //transientConnection = ConnectionManager.getInstance().createTransientConnection();
            GenerationReport report = generator.generateGrammar(targetConnection, refScopeBean.getReferencePRIs(), parserSuperClass);

            generator.writeMappingToFile(syntaxDefFile.getProject(), report.getSyntax());

            boolean hasErrors = false;
            String fileNameWithoutSuffix = grammarFile.getName().substring(0, grammarFile.getName().length() - (grammarFile.getFileExtension().length() +1));
            if (! fileNameWithoutSuffix.equals(report.getSyntaxName()) ) {
                report.addError(new ParsingError("Syntax name and file name must be equal: "+ fileNameWithoutSuffix+" != " + report.getSyntaxName(), (TextLocation)null));
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
		    EclipseMarkerUtil
			    .addMarker(syntaxDefFile, parsingError, IMarker.SEVERITY_ERROR);
		}
	    }

            if (! hasErrors) {
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
                throw new CoreException(ExceptionHelper.getErrorStatus("No Parsing Errors delievered with " +e.getMessage()));
            }
        } catch (ModelAdapterException e) {
            throw  new CoreException(ExceptionHelper.getErrorStatus(e));
        } catch (GrammarGenerationException e) {
            throw new CoreException(ExceptionHelper.getErrorStatus(e));
        } catch (IOException e) {
            throw new CoreException(ExceptionHelper.getErrorStatus(e));
        } catch (RuntimeException e) {
            // TODO: Remove this, used only for debugging
            e.printStackTrace();
            throw e;

        } catch (Exception e) {
            // TODO: Remove this, used only for debugging
            e.printStackTrace();
        } finally {
            if (transientConnection != null) {
                transientConnection.close();
            }
        }


    }

}
