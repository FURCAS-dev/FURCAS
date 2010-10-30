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
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.ParsingError;

/**
 * The Class TCSInputStreamGrammarGenerator, generates a Grammar based on an InputStream containing a TCS definition of a syntax.
 */
public class TCSInputStreamGrammarGenerator extends AbstractTCSGrammarGenerator {

    /** The syntax definition stream. */
    private final InputStream syntaxDefinitionStream;

    /**
     * Instantiates a new TCS input stream grammar generator.
     * 
     * @param syntaxDefinitionStream
     *            the syntax definition stream
     * @param out
     *            the out
     * @param lookup
     *            the lookup
     * @param qualifiedNamesSeparator
     * @param targetPackage
     */
    public TCSInputStreamGrammarGenerator(InputStream syntaxDefinitionStream, OutputStream out, IMetaModelLookup<?> lookup,
            String targetPackage) {
        super(out, lookup, targetPackage);
        this.syntaxDefinitionStream = syntaxDefinitionStream;
    }

    private TCSSyntaxContainerBean initMembers(InputStream definitionInputStream, ResourceSet connection, Set<URI> metamodelPRIs)
            throws InvalidParserImplementationException, IOException, UnknownProductionRuleException, SyntaxParsingException {

        // By choosing this injector, we establish the dependency to EMF.
        ModelInjectionResult result = TCSSpecificEMFModelInjector.parseSyntaxDefinition(definitionInputStream, connection,
                metamodelPRIs, /* observer */null);

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

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.impl.tcs.t2m.AbstractTCSGrammarGenerator# doGetSyntaxDef()
     */
    @Override
    protected TCSSyntaxContainerBean doGetSyntaxDef(ResourceSet connection, Set<URI> metamodelPRIs) throws IOException,
            SyntaxParsingException, ModelAdapterException, ParserInvokationException {
        try {
            return initMembers(syntaxDefinitionStream, connection, metamodelPRIs);
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
