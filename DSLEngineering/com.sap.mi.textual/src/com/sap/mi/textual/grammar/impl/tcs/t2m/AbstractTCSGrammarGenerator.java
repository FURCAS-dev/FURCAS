/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-08-30 09:55:26 +0200 (So, 30 Aug 2009) $
 * @version $Revision: 7769 $
 * @author: $Author: c5127705 $
 *******************************************************************************/
package com.sap.mi.textual.grammar.impl.tcs.t2m;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.textblocks.TextblocksPackage;
import com.sap.furcas.textual.common.exceptions.GrammarGenerationException;
import com.sap.furcas.textual.common.exceptions.ModelAdapterException;
import com.sap.furcas.textual.common.exceptions.ParserInvokationException;
import com.sap.furcas.textual.common.interfaces.IMetaModelLookup;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.ANTLR3GrammarWriter;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.ANTLRGrammarGenerator;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.GenerationReport;
import com.sap.mi.textual.grammar.impl.tcs.t2m.validation.SyntaxDefinitionValidation;


/**
 * generates ANTLR grammar file contents based on TCS input.
 * 
 * implementations of this class have to provide a way to retrieve a
 * ConcreteSyntax object and a Set of used Keywords. The formal detail of
 * implementation hidden in this abstract class is that no assumption is made on
 * what format is the Syntax is provided in. While the target is always a TCS
 * compliant ConcreteSyntax object, the source may i.e.be an inputStream in TCS
 * syntax, in XML, a database, or some other repository or data source.
 * 
 * The TCS input is parsed, then divided into different parts (header, lexer,
 * primitive templates, templates, tokens, symbols). On this description of the
 * TCS syntax, different grammar generation modules are applied that all append
 * to a file.
 * 
 * @author C5107456
 */
public abstract class AbstractTCSGrammarGenerator {

    /** The out. */
    private final OutputStream out;

    /** The lookup. */
    private final IMetaModelLookup<?> lookup;

    private String targetPackage = "generated";

    /**
     * Instantiates a new abstract tcs grammar generator.
     * 
     * @param out
     *            the out
     * @param lookup
     *            the lookup
     * @param qualifiedNamesSeparator 
     * @param targetPackage 
     */
    public AbstractTCSGrammarGenerator(OutputStream out, IMetaModelLookup<?> lookup, String targetPackage) {
        super();
        this.out = out;
        this.lookup = lookup;
        this.targetPackage = targetPackage; 
    }

    public GenerationReport generateGrammar(ResourceSet resourceSet, Set<URI> metamodelURIs, Class<? extends ObservableInjectingParser> paserSuperClass) throws ParserInvokationException, SyntaxParsingException, IOException, ModelAdapterException,  GrammarGenerationException {
    	return generateGrammar(resourceSet, metamodelURIs, paserSuperClass, null);
    }
    /**
     * validates the syntax, then generates ANTLR3 grammar and writes it to
     * OutputStream.
     * @param resourceSet a transient MOIN connection having the TCS metamodel registered 
     * @param paserSuperClass Superclass of parser, may be null, then default will be used
     * @return 
     * @throws ModelAdapterException 
     * @throws IOException 
     * @throws SyntaxParsingException 
     * @throws ParserInvokationException 
     * @throws GrammarGenerationException 
     */
    public GenerationReport generateGrammar(ResourceSet resourceSet, Set<URI> metamodelURIs, Class<? extends ObservableInjectingParser> paserSuperClass, String languageId) throws ParserInvokationException, SyntaxParsingException, IOException, ModelAdapterException,  GrammarGenerationException {
        
        if (resourceSet == null) {
            throw new IllegalArgumentException("ResurceSet was null");
        } 
//        if (! resourceSet.isAlive()) {
//            throw new IllegalArgumentException("Connection was closed");
//        }
        if (resourceSet.getPackageRegistry().getEFactory(TextblocksPackage.eNS_URI)== null) {
            throw new IllegalArgumentException("TCS Metamodel not registered for connection");
        }
        
        TCSSyntaxContainerBean bean = doGetSyntaxDef(resourceSet, metamodelURIs, languageId);
//        ConcreteSyntax syntax = bean.getSyntax();
//        Set<Keyword> keywordSet = bean.getKeywords();
//        Map<Object, TextLocation> locationMap = bean.getElementToLocationMap();


        ANTLR3GrammarWriter writer = new ANTLR3GrammarWriter();
        ANTLRGrammarGenerator mapper = new ANTLRGrammarGenerator();

        GenerationReport report = mapper.generateGrammar(writer,
                lookup, bean, new SyntaxDefinitionValidation(), paserSuperClass);

        writer.setTargetPackage(targetPackage);
        
        // write OuputStream
        out.write(writer.getOutput().getBytes());
        
        return report;
    }

    /**
     * Do get syntax def.
     * @param metamodelURIs 
     * 
     * @return the tCS syntax container bean
     * 
     * @throws SyntaxParsingException
     *             the syntax parsing exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws ModelAdapterException
     *             the model handler exception
     * @throws ParserInvokationException 
     */
    protected abstract TCSSyntaxContainerBean doGetSyntaxDef(ResourceSet resourceSet, Set<URI> metamodelURIs)
            throws SyntaxParsingException, IOException, ModelAdapterException, ParserInvokationException;

    /**
     * Do get syntax def for the given languageid.
     * @param metamodelURIs 
     * @param languageId
     * 
     * @return the tCS syntax container bean
     * 
     * @throws SyntaxParsingException
     *             the syntax parsing exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws ModelAdapterException
     *             the model handler exception
     * @throws ParserInvokationException 
     */
	protected abstract TCSSyntaxContainerBean doGetSyntaxDef(ResourceSet resourceSet,
			Set<URI> metamodelURIs, String languageId)
			throws SyntaxParsingException, IOException, ModelAdapterException,
			ParserInvokationException;

}
