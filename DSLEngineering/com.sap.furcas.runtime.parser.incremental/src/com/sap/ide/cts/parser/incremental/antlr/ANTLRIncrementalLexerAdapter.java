package com.sap.ide.cts.parser.incremental.antlr;

import static com.sap.furcas.runtime.textblocks.modifcation.TbMarkingUtil.isBOS;
import static com.sap.furcas.runtime.textblocks.modifcation.TbMarkingUtil.isEOS;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.OmittedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.common.interfaces.IModelElementInvestigator;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.IModelInjector;
import com.sap.furcas.runtime.parser.IStreamIndexProvider;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationTokenImpl;
import com.sap.furcas.runtime.parser.impl.ModelInjector;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.ShortPrettyPrinter;
import com.sap.ide.cts.parser.incremental.IncrementalLexer;
import com.sap.ide.cts.parser.incremental.LexerAdapter;

/**
 * <b>Looahead tracking</b> To be able to compute the correct lookahead it needs to be tracked whether the lexer is doing a
 * lookahead using e.g. the DFA.predict() method. Before doing this ANTLR will store the position from which it is predicting
 * using a call to {@link #mark()}. Therefore, in this implementation makr sets the {@link #isLookingForward} flag to true. From
 * now on each call to {@link #consume()} which means that a character was recognized advances the <code>readLoc</code>. After
 * doing its prediction antlr will call {@link #rewind(int)} with the mark returned from the previous {@link #mark()} call. This
 * means {@link #isLookingForward} has to be
 * 
 * 
 * The difference between constructionLoc (the place representing the end of the further the lexer had to look to decide the the
 * boundaries and type of the token being constructed ) readLoc is lateron used to identify how much token.
 * 
 * @author C5106462
 * 
 */
public class ANTLRIncrementalLexerAdapter extends IncrementalLexer implements CharStream, TokenSource, IStreamIndexProvider {

    private boolean isLookingForward = false;

    private final HashMap<Token, AbstractToken> tokenToModelElement = new LinkedHashMap<Token, AbstractToken>();

    /**
     * This map is used as for lookups on which model element was created for which token because the standard token
     * implementation has no reference to the corresponding modelelement. TODO: This may change if the lexer actually creates real
     * model element tokens rather than just POJOs.
     * 
     * @return
     */
    public HashMap<Token, AbstractToken> getTokenToModelElement() {
        return tokenToModelElement;
    }

    public ANTLRIncrementalLexerAdapter(LexerAdapter lexerAdapter, IModelElementInvestigator mi) {
        super(lexerAdapter, mi);
    }

    @Override
    public int LT(int i) {
        return LA(i);
    }

    @Override
    public int getCharPositionInLine() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getLine() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setCharPositionInLine(int pos) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLine(int line) {
        // TODO Auto-generated method stub

    }

    /**
     * As it is possible that during relexing the new token ranges over several "old" tokens collect all characters that lie on
     * the way to the last <code>readToken</code> starting from the last <code>constructionLoc</code>.
     * 
     * @return the value of the new token
     */
    @Override
    public String substring(int start, int stop) {
        StringBuilder result = new StringBuilder();
        AbstractToken tok = getConstructionLoc().getTok();
        while (!tok.equals(readToken)) {
            String string = getSynchronizedValue(tok);
            if (start < string.length()) {
                result.append(string.substring(start, string.length()));
                start = 0;
            } else {
                start = start - string.length();
            }
            stop = stop - string.length();
            tok = TbNavigationUtil.nextToken(tok);
        }
        return result.append(getSynchronizedValue(readToken).substring(start, stop + 1)).toString();
    }

    @Override
    public int LA(int i) {
        if (i == 0) {
            return 0;
        }
        if (i < 0) {
            throw new RuntimeException("Currently no negtive lookahead supported");
        }
        int localReadOffset = readOffset + i - 1;
        AbstractToken localReadToken = readToken;
        while (!isEOS(localReadToken) && localReadOffset >= asString(localReadToken).length()) {
            int oldLength = asString(localReadToken).length();
            localReadToken = TbNavigationUtil.nextToken(localReadToken);
            localReadOffset -= oldLength;
        }
        if (isEOS(localReadToken)) {
            return getEOSTokenType();
        }
        return getSynchronizedValue(localReadToken).charAt(localReadOffset);
    }

    @Override
    public void consume() {
        while (readOffset == asString(readToken).length() && !isEOS(readToken)) {
            readToken = nextToken(readToken, Version.PREVIOUS);
            /*
             * this is needed to track the lookahead of the lexer.
             */
            if (isLookingForward) {
                readLoc.setTok(readToken);
                readLoc.setOffset(readOffset);
            }
            readOffset = 0;
        }
        readOffset++;
        if (isLookingForward) {
            // track lookahead behaviour of lexer
            readLoc.setTok(readToken);
            readLoc.setOffset(readOffset);
        }
    }

    /**
     * gives the index relative to the last construction location
     * 
     */
    @Override
    public int index() {
        return TbUtil.getAbsoluteOffset(readToken) + readOffset - TbUtil.getAbsoluteOffset(getConstructionLoc().getTok());
    }

    @Override
    public int makeIndexAbsolute(int relativeIndex) {
        return relativeIndex + TbUtil.getAbsoluteOffset(getConstructionLoc().getTok());
    }

    @Override
    public int mark() {
        isLookingForward = true;
        readLoc.setOffset(readOffset);
        readLoc.setTok(readToken);
        return TbUtil.getAbsoluteOffset(readToken) + readOffset;
    }

    @Override
    public void release(int marker) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("release not supported.");
    }

    /**
     * Rewinds so that <code>readOffset</code> and <code>readToken</code> are rewinded to the point they were when {@link #mark()}
     * was called.
     */
    @Override
    public void rewind(int marker) {
        while (TbUtil.getAbsoluteOffset(readToken) > marker && !isBOS(readToken)) {
            readToken = previousToken(readToken, Version.PREVIOUS);
            readOffset = getSynchronizedValue(readToken).length();
        }
        readOffset = marker - TbUtil.getAbsoluteOffset(readToken);
        // now finished with predicting/lookahead
        isLookingForward = false;
        // add one as LA(1) lookahead is done from every position
        readLoc.setOffset(readLoc.getOffset() + 1);
    }

    @Override
    public void rewind() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("release not supported.");
    }

    @Override
    public void seek(int index) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("release not supported.");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    // the following members and methods are needed for the ANTLR TokenSource
    // Interface
    /**
     * Stores the last token that was passed to the parser.
     */
    private AbstractToken currentTokenForParser;

    /**
     * Needs to be implemented to be used by ANTLRTokenStream
     */
    @Override
    public Token nextToken() {
        AbstractToken currentTokenForParser = getCurrentTokenForParser();
        if (currentTokenForParser == null) {
            throw new RuntimeException("Lexer not properly initialized, currentToken was null!");
        }
        AbstractToken nextTokenSibling = TbNavigationUtil.nextToken(currentTokenForParser);
        AbstractToken tokenForParser = setCurrentTokenForParser(nextTokenSibling);
        ANTLR3LocationToken nextToken = createToken(tokenForParser);

        return nextToken;
    }

    /**
     * creates an ANTLR Token from a TextBlock Token
     * 
     * @param abstractToken
     * @return
     */
    protected ANTLR3LocationToken createToken(AbstractToken abstractToken) {
        ANTLR3LocationToken tok = new ANTLR3LocationTokenImpl(abstractToken.getType(), getSynchronizedValue(abstractToken));
        if (abstractToken instanceof OmittedToken) {
            tok.setChannel(Token.HIDDEN_CHANNEL);
        }
        int absoluteOffset = TbUtil.getAbsoluteOffset(abstractToken);
        tok.setStartIndex(absoluteOffset);
        tok.setStopIndex(absoluteOffset + abstractToken.getLength());

        // add to tokentoModelElement map so relation between parser token
        // and textblocks token is maintained
        getTokenToModelElement().put(tok, abstractToken);
        return tok;
    }

    public AbstractToken setCurrentTokenForParser(AbstractToken currentTokenForParser) {
        return this.currentTokenForParser = currentTokenForParser;
    }

    public AbstractToken getCurrentTokenForParser() {
        return currentTokenForParser;
    }

    /**
     * Overridden make sure tokenlist is empty after parsing otherwise if tokensource is re-used by a parser all tokens well occur
     * twice in the source.
     */
    @Override
    public boolean lex(TextBlock root) {
        // clear the list of re used tokens
        ((ANTLRLexerAdapter) getBatchLexer()).getReusedTokens().clear();
        return super.lex(root);
        // getBatchLexer().flushTokenStream();
    }

    @Override
    protected String asString(AbstractToken token) {
        if (isEOS(token)) {
            return "EOS";
        }
        if (isBOS(token)) {
            return "BOS";
        }
        return getSynchronizedValue(token);
    }

    @Override
    public String getSourceName() {
        return "Unknown Filename";
    }

    @Override
    protected boolean wasReUsed(AbstractToken tok) {
        return ((ANTLRLexerAdapter) getBatchLexer()).getReusedTokens().contains(tok);
    }

    public void setModelInjector(IModelInjector injector) {
        shortPrettyPrinter = new ShortPrettyPrinter(((ModelInjector) injector).getModelAdapter());
        try {
            Lexer lexer = ((ANTLRLexerAdapter) getBatchLexer()).getANTLRLexer();
            lexer.getClass().getField(ANTLRLexerAdapter.LEXER_INJECTOR_FIELD_NAME).set(lexer, injector);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

}
