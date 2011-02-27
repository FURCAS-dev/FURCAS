package com.sap.furcas.ide.editor.recovery;


import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbMarkingUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.ShortPrettyPrinter;
import com.sap.ide.cts.parser.incremental.MappingLinkRecoveringIncrementalParser;
import com.sap.ide.cts.parser.incremental.TextBlockMappingRecoveringFailedException;
import com.sap.ide.cts.parser.incremental.TextBlockReuseStrategy;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRLexerAdapter;

public class TbRecoverUtil {

    /**
     * Tries to recover a broken TextBlock mapping. The recovery is based on a
     * special {@link TextBlockReuseStrategy} for the IncrementalParser that
     * allows to match TextBlocks without checking their mappings.
     * 
     * @param existingRoot
     * @param rootTemplate
     * @param grammarBasedEditor
     * @return
     */
    public static boolean recoverTextBlockFromBrokenMapping(TextBlock existingRoot, ClassTemplate rootTemplate,
	    MappingLinkRecoveringIncrementalParser incrementalParser, ObservableInjectingParser parser, ANTLRIncrementalLexerAdapter lexer,
	    ShortPrettyPrinter shortPrettyPrinter) {
	try {
	    checkAndMigrateTokenIds(existingRoot, parser, lexer, shortPrettyPrinter);
	    incrementalParser.recoverMappingLink(existingRoot, rootTemplate);
	    return true;
	} catch (TextBlockMappingRecoveringFailedException e) {
	    CtsActivator.logWarning(e);
	    return false;
	}
    }

    /**
     * Ensures that the token ids stored in the textblocks model are still in
     * sync with those from the generated parser. If only a token Id changed and
     * lexing is still possible without errors, the ids are updated
     * correspondingly.
     */
    public static void checkAndMigrateTokenIds(TextBlock rootBlock, ObservableInjectingParser parser,
	    ANTLRIncrementalLexerAdapter lexer, ShortPrettyPrinter shortPrettyPrinter) {
	AbstractToken tok = rootBlock.getTokens().get(0);
	// BOS token does not have to be checked. It also is not necessary to
	// check if the tb model is in its empty initial state
	// this is indicated by the only token having an id of -1
	Lexer antlrLexer = ((ANTLRLexerAdapter) lexer.getBatchLexer()).getANTLRLexer();
	CharStream originalStream = antlrLexer.getCharStream();
	try {
	    while (!TbMarkingUtil.isEOS(tok = TbNavigationUtil.nextToken(tok)) && tok != null && tok.getType() != 0) {
	        lexer.getBatchLexer().setState(tok.getState());
	        String value = shortPrettyPrinter.resynchronizeToEditableState(tok);
	        if (!TbMarkingUtil.isEOS(tok)) {
	            AbstractToken nextToken = TbNavigationUtil.nextToken(tok);
	            value += shortPrettyPrinter.resynchronizeToEditableState(nextToken);
	        }
	        antlrLexer.setCharStream(new ANTLRStringStream(value));
	        Token lexerToken = antlrLexer.nextToken();
	        if (lexerToken.getType() != tok.getType()) {
	            // token id may have changed
	            
	            // This works because lexer and parser are already connected
	            if (parser.getInjector().getErrorList().size() > 0) {
	                // Ok this means not only have the token ids changed
	                // but also the lexer rules do not work for this token
	                // anymore. Markin the token will force re-lexing.
	                TbMarkingUtil.mark(tok);
	            } else {
	                tok.setType(lexerToken.getType());
	            }
	        }
	    }
	} finally {
	    antlrLexer.setCharStream(originalStream);
	}
    }
}
