/**
 * 
 */
package com.sap.ide.cts.parser.incremental;

import java.util.Collection;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.URI;

import com.sap.mi.textual.common.interfaces.IRuleName;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.mi.textual.grammar.antlr3.ITokenFactory;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.ITextBlocksTokenStream;

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
    
    public URI getMetamodelCri(ResourceSet connection);
    
    public EPackage getMetamodelPackage(ResourceSet connection);
    
    public String getLanguageId();

    public Collection<URI> getParserLookupScope(ResourceSet connection);

    public String getSyntaxUUID();

    public IRuleName getRuleNameFinder();
}
