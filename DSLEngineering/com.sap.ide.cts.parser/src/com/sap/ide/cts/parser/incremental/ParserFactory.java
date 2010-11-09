/**
 * 
 */
package com.sap.ide.cts.parser.incremental;

import java.util.Collection;
import java.util.Set;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.runtime.common.interfaces.IRuleName;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.antlr3.ITokenFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.textblocks.ITextBlocksTokenStream;

/**
 *
 */
public interface ParserFactory<P extends ObservableInjectingParser,
		L extends Lexer> {
    public P createParser(TokenStream input, ResourceSet connection, Collection<URI> additionalScope, Collection<URI> collection);
    
    public P createParser(TokenStream input, ResourceSet connection);
    
    public L createLexer(CharStream input);
    
    public L createLexer(CharStream input, ITokenFactory<? extends ANTLR3LocationToken> factory);
    
    public Class<P> getParserClass();
    
    public Class<L> getLexerClass();
    
    public ITextBlocksTokenStream createIncrementalTokenStream(IncrementalLexer incrementalLexer);
    
    public URI getMetamodelUri(ResourceSet connection);
    
    public EPackage getMetamodelPackage(ResourceSet connection);
    
    public String getLanguageId();

    public Set<URI> getParserLookupScope(ResourceSet connection);

    public String getSyntaxUUID();

    public IRuleName getRuleNameFinder();
}
