/**
 * 
 */
package com.sap.ide.cts.parser.incremental;

import java.util.Collection;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;

import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.mi.textual.grammar.antlr3.ITokenFactory;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.ITextBlocksTokenStream;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 *
 */
public interface ParserFactory<P extends ObservableInjectingParser,
		L extends Lexer> {
    public P createParser(TokenStream input, Connection connection, Collection<PRI> additionalScope, Collection<CRI> collection);
    
    public P createParser(TokenStream input, Connection connection);
    
    public L createLexer(CharStream input);
    
    public L createLexer(CharStream input, ITokenFactory<? extends ANTLR3LocationToken> factory);
    
    public Class<P> getParserClass();
    
    public Class<L> getLexerClass();
    
    public ITextBlocksTokenStream createIncrementalTokenStream(IncrementalLexer incrementalLexer);
    
    public CRI getMetamodelCri(Connection connection);
    
    public RefPackage getMetamodelPackage(Connection connection);
    
    public String getLanguageId();

    public Collection<PRI> getParserLookupScope(Connection connection);

    public String getSyntaxUUID();
}
