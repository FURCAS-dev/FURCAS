/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-10-06 16:02:30 +0200 (Di, 06 Okt 2009) $
 * @version $Revision: 8209 $
 * @author: $Author: d043530 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.parsergenerator.emf.tcs.inject.ModelInjectionResult;
import com.sap.furcas.parsergenerator.emf.tcs.inject.TCSSpecificEMFModelInjector;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;

/**
 * The Class TCSInputStreamGrammarGenerator, generates a Grammar based on an InputStream containing a TCS definition of a syntax.
 */
public class InputStreamBasedTCSGrammarGenerator extends AbstractTCSGrammarGenerator {

    /** The syntax definition stream. */
    private final InputStream syntaxDefinitionStream;

    /**
     * Instantiates a new TCS input stream grammar generator.
     * 
     * @param syntaxDefinitionStream
     *            the syntax definition stream
     * @param outputStream
     * @param lookup
     * @param targetPackage
     *            the name of the java package the generated java class will be placed into.
     *            It is required to prevent compilation errors.               
     *          
     */
    public InputStreamBasedTCSGrammarGenerator(InputStream syntaxDefinitionStream, OutputStream outputStream, IMetaModelLookup<?> lookup,
            String targetPackage) {
        super(outputStream, lookup, targetPackage);
        this.syntaxDefinitionStream = syntaxDefinitionStream;
    }

    private TCSSyntaxContainerBean injectTCSModel(InputStream definitionInputStream, ResourceSet resourceSet, Set<URI> referenceScope)
            throws InvalidParserImplementationException, IOException, UnknownProductionRuleException, SyntaxParsingException {

        // By choosing this injector, we establish the dependency to EMF.
        ModelInjectionResult result = TCSSpecificEMFModelInjector.parseSyntaxDefinition(definitionInputStream, resourceSet,
                referenceScope, /* observer */null);

        List<ParsingError> errors = result.getResult().getErrors();
        if (errors != null && errors.size() > 0) {
            if (result.getSyntax() != null) {
                // also clean up unfinished syntax
                EcoreUtil.delete(result.getSyntax(), /* recursive */true);
            }
            throw new SyntaxParsingException(errors);
        }
        TCSSyntaxContainerBean returnBean = new TCSSyntaxContainerBean();
        returnBean.setSyntax(result.getSyntax());
        returnBean.setKeywords(result.getKeywords());
        returnBean.setElementToLocationMap(result.getResult().getLocationMap());

        return returnBean;
    }

    @Override
    protected TCSSyntaxContainerBean doGetSyntaxDef(ResourceSet resourceSet, Set<URI> referenceScope) throws IOException,
            SyntaxParsingException, ModelAdapterException, ParserInvokationException {
        try {
            return injectTCSModel(syntaxDefinitionStream, resourceSet, referenceScope);
        } catch (IllegalArgumentException e) {
            throw new ParserInvokationException(e);
        } catch (SecurityException e) {
            throw new ParserInvokationException(e);
        } catch (UnknownProductionRuleException e) {
            throw new ParserInvokationException(e);
        } catch (InvalidParserImplementationException e) {
            throw new ParserInvokationException(e);
        }
    }

    @Override
    protected TCSSyntaxContainerBean doGetSyntaxDef(ResourceSet connection, Set<URI> metamodelPRIs, String languageId)
            throws SyntaxParsingException, IOException, ModelAdapterException, ParserInvokationException {
        return doGetSyntaxDef(connection, metamodelPRIs);
    }

}
