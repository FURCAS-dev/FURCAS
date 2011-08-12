package com.sap.furcas.parsergenerator.tcs.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.parsergenerator.GenerationErrorHandler;
import com.sap.furcas.parsergenerator.GrammarGenerationSourceConfiguration;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.parsergenerator.emf.tcs.inject.TCSSpecificEMFModelInjector;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;

/**
 * The SyntaxParser parses a TCS file and returns a TCSSyntaxContainerBean that contains the ConcreteSyntax.
 * It is used by the {@link TCSParsergenerator}.
 * 
 * @author Sebastian Schlag (D049672)
 * 
 */
public class SyntaxParser {

    public static TCSSyntaxContainerBean parse(GrammarGenerationSourceConfiguration sourceConfiguration, File syntaxDefFile, GenerationErrorHandler errorHandler)
            throws ParserInvokationException {

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(syntaxDefFile);

            // By choosing this injector, we establish the dependency to EMF.
            ModelParsingResult result = TCSSpecificEMFModelInjector.parseSyntaxDefinition(inputStream,
                    sourceConfiguration.getResourceSet(), sourceConfiguration.getReferenceScope(), /* observer */null);

            List<ParsingError> errors = result.getErrors();
            if (errors != null && errors.size() > 0) {
                if (result.getParsedModelElement() != null) {
                    // also clean up unfinished syntax
                    EcoreUtil.delete((EObject) result.getParsedModelElement(), true);
                }
                for (ParsingError error : errors) {
                    errorHandler.error(error);
                }
            }
            ConcreteSyntax syntax = (ConcreteSyntax) result.getParsedModelElement();

            TCSSyntaxContainerBean returnBean = new TCSSyntaxContainerBean();
            returnBean.setSyntax(syntax);
            returnBean.setElementToLocationMap(result.getLocationMap());

            return returnBean;

        } catch (FileNotFoundException e) {
            throw new ParserInvokationException(e);
        } catch (InvalidParserImplementationException e) {
            throw new ParserInvokationException(e);
        } catch (IOException e) {
            throw new ParserInvokationException(e);
        } catch (UnknownProductionRuleException e) {
            throw new ParserInvokationException(e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new ParserInvokationException(e);
            }
        }

    }
}
