package com.sap.furcas.parsergenerator.tcs.generator;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.sap.furcas.parsergenerator.GenerationErrorHandler;
import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.GrammarGenerationTargetConfiguration;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.parsergenerator.emf.lookup.QueryBasedEcoreMetaModelLookUp;
import com.sap.furcas.parsergenerator.tcs.t2m.ModelBasedTCSGrammarGenerator;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.GenerationReport;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;

/**
 * Reads a syntax definition given as a file and generates a ANTLR gramamr for it.
 * 
 * TODO: In the feature me way want to start with a syntax model, not with a syntax file.
 */
public class GrammarGenerator {

    /**
     * Takes a syntax definition in file form, parses that file and then writes a corresponding ANTLR grammar to the given grammar
     * file.
     * 
     * @throws GrammarGenerationException
     */
    public static void buildGrammar(GrammarGenerationSourceConfiguration sourceConfiguration,
            GrammarGenerationTargetConfiguration targetConfiguration, GenerationErrorHandler errorhandler,
            TCSSyntaxContainerBean syntaxBean) throws GrammarGenerationException {

        buildGrammar(sourceConfiguration, targetConfiguration, errorhandler, /* use default parser super class */null,
                new NullProgressMonitor(), syntaxBean);
    }

    /**
     * Takes a syntax definition in file form, parses that file and then writes a corresponding ANTLR grammar to the given grammar
     * file.
     * 
     * @throws GrammarGenerationException
     */
    public static void buildGrammar(GrammarGenerationSourceConfiguration sourceConfiguration,
            GrammarGenerationTargetConfiguration targetConfiguration, GenerationErrorHandler errorhandler,
            IProgressMonitor monitor, TCSSyntaxContainerBean syntaxBean) throws GrammarGenerationException {

        buildGrammar(sourceConfiguration, targetConfiguration, errorhandler, /* use default parser super class */null, monitor,
                syntaxBean);
    }

    /**
     * Takes a syntax definition in file form, parses that file and then writes a corresponding ANTLR grammar to the given grammar
     * file.
     * 
     * @throws GrammarGenerationException
     */
    public static void buildGrammar(GrammarGenerationSourceConfiguration sourceConfiguration,
            GrammarGenerationTargetConfiguration targetConfiguration, GenerationErrorHandler errorhandler,
            Class<? extends ObservableInjectingParser> parserSuperClass, IProgressMonitor monitor,
            TCSSyntaxContainerBean syntaxBean) throws GrammarGenerationException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            generateGrammar(sourceConfiguration, targetConfiguration, parserSuperClass, errorhandler, monitor, outputStream,
                    syntaxBean);

        } catch (SyntaxParsingException e) {
            handleSyntaxParsingException(errorhandler, e);
        } catch (ModelAdapterException e) {
            throw new GrammarGenerationException("Model adapter failed", e);
        } catch (IOException e) {
            throw new GrammarGenerationException("Grammar generation failed with IO error", e);
        } catch (ParserInvokationException e) {
            throw new GrammarGenerationException("Failed to instantiate the TCS Parser", e);
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                throw new GrammarGenerationException("Grammar generation failed with IO error", e);
            }
        }
    }

    private static void generateGrammar(GrammarGenerationSourceConfiguration sourceConfiguration,
            GrammarGenerationTargetConfiguration targetConfiguration,
            Class<? extends ObservableInjectingParser> parserSuperClass, GenerationErrorHandler errorhandler,
            IProgressMonitor monitor, ByteArrayOutputStream outputStream, TCSSyntaxContainerBean syntaxBean)
            throws ParserInvokationException, SyntaxParsingException, IOException, ModelAdapterException,
            GrammarGenerationException {

        QueryBasedEcoreMetaModelLookUp metamodelLookup = new QueryBasedEcoreMetaModelLookUp(sourceConfiguration.getResourceSet(),
                sourceConfiguration.getReferenceScope());

        ModelBasedTCSGrammarGenerator modelBasedGenerator = new ModelBasedTCSGrammarGenerator(outputStream, metamodelLookup,
                targetConfiguration.getParserTargetPackageName(), syntaxBean);

        GenerationReport report = modelBasedGenerator.generateGrammar(sourceConfiguration.getResourceSet(),
                sourceConfiguration.getReferenceScope(), parserSuperClass);

        // TODO Not needed for now. Keep it disabled until we have a reasonable way to test
        // writeMappingToFile(targetConfiguration.getMappingTargetFile(), report.getSyntax());

        boolean hasErrors = checkForErrorsAndReport(report, errorhandler);
        if (!hasErrors) {
            File grammarFile = targetConfiguration.getGrammarTargetFile();
            writeGrammarToFile(grammarFile, outputStream, monitor);
        }
    }

    private static boolean checkForErrorsAndReport(GenerationReport report, GenerationErrorHandler errorhandler) {
        boolean hasErrors = false;
        if (report.getWarnings() != null && report.getWarnings().size() > 0) {
            for (ParsingError warning : report.getWarnings()) {
                errorhandler.warning(warning);
            }
        }
        if (report.getErrors() != null && report.getErrors().size() > 0) {
            hasErrors = true;
            for (ParsingError error : report.getErrors()) {
                errorhandler.error(error);
            }
        }
        return hasErrors;
    }

    private static void writeGrammarToFile(File grammarFile, ByteArrayOutputStream grammarDataStream, IProgressMonitor mointor)
            throws IOException {
        if (grammarFile.exists()) {
            grammarFile.delete();
        }
        grammarFile.createNewFile();

        FileOutputStream outputStream = new FileOutputStream(grammarFile);
        outputStream.write(grammarDataStream.toByteArray());
        outputStream.close();
    }

    // TODO Not needed for now. Keep it disabled until we have a reason to use (and test) it
    // /**
    // * Writes the given syntax to a default resource. The resource location is constructed within the src folder of the given
    // * <tt>project</tt> with the name of the {@link ConcreteSyntax syntax} postfixed with "Mapping.xmi". If the resource already
    // * exists it will be emptied.
    // *
    // * @param project
    // * @param syntax
    // */
    // private static void writeMappingToFile(IFile mappingFile, ConcreteSyntax syntax) {
    // Resource resource = createOrLoadEmptyMappingResource(mappingFile, syntax.eResource().getResourceSet());
    // try {
    // resource.getContents().add(syntax);
    // resource.save(null);
    // } catch (IOException e) {
    // Activator.logger.logError("Failed to write mapping to file", e);
    // }
    // }
    // private static Resource createOrLoadEmptyMappingResource(IFile mappingFile, ResourceSet resourceSet) {
    // IPath partitionRelativePath = mappingFile.getProjectRelativePath();
    // Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(partitionRelativePath.toString(), true), true);
    // if (resource != null) {
    // resource.getContents().clear();
    // } else {
    // resource = resourceSet.createResource(URI.createPlatformResourceURI(partitionRelativePath.toString(), true));
    // }
    // return resource;
    // }

    private static void handleSyntaxParsingException(GenerationErrorHandler errorhandler, SyntaxParsingException e)
            throws GrammarGenerationException {
        List<ParsingError> errors = e.getErrorList();
        if (errors != null) {
            for (ParsingError parsingError : errors) {
                errorhandler.fatalError(parsingError);
            }
        } else {
            throw new GrammarGenerationException("No Parsing Errors delievered with " + e.getMessage());
        }
    }

}
