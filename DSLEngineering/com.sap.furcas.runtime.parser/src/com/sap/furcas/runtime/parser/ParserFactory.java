/**
 * 
 */
package com.sap.furcas.runtime.parser;

import java.util.Set;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.common.exceptions.ParserInstantiationException;
import com.sap.furcas.runtime.common.interfaces.IRuleName;
import com.sap.furcas.runtime.parser.antlr3.ITokenFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.textblocks.ITextBlocksTokenStream;

/**
 *
 */
public interface ParserFactory<P extends ObservableInjectingParser, L extends Lexer> {

    public P createParser(TokenStream input, IModelAdapter modelAdapter) throws ParserInstantiationException;

    public L createLexer(CharStream input);

    public L createLexer(CharStream input, ITokenFactory<? extends ANTLR3LocationToken> factory);

    public Class<P> getParserClass();

    public Class<L> getLexerClass();

    public ITextBlocksTokenStream createIncrementalTokenStream(Object incrementalLexer);

    public Set<URI> getMetamodelURIs();

    /**
     * @return the URI of the {@link Resource} holding as its single immediate {@link Resource#getContents() content
     *         object} the {@link ConcreteSyntax} element representing the syntax / mapping definition.
     */
    public URI getSyntaxResourceURI();

    public String getLanguageId();

    public String getSyntaxUUID();

    public IRuleName getRuleNameFinder();
    
    /** 
     * This method should be overridden if additional URIs should be added to
     * the lookup scope of the parser.<p>
     * 
     * By default, all resources in all dependent projects are sourced.
     * If new resources are saved in a project, those are included automatically
     * in the next parse run.
     */
    public Set<URI> getAdditionalQueryScope();
}
