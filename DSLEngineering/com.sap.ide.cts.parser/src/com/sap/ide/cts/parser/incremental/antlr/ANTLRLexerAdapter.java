package com.sap.ide.cts.parser.incremental.antlr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;
import com.sap.furcas.metamodel.textblocks.Version;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.impl.ModelInjector;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.ide.cts.parser.incremental.IncrementalLexer;
import com.sap.ide.cts.parser.incremental.LexerAdapter;
import com.sap.ide.cts.parser.incremental.TextBlockReuseStrategy;


public class ANTLRLexerAdapter implements LexerAdapter {

	public static final String LEXER_INJECTOR_FIELD_NAME = "ei";
	private Lexer antlrLexer;
	private TextblocksPackage textblocksPackage;
	private final ResourceSet connection;
	private IncrementalLexer incrementalLexer;
	private Set<AbstractToken> reusedTokens = new HashSet<AbstractToken>();
	private TextBlockReuseStrategy reuseStrategy = null;

	public Lexer getANTLRLexer() {
		return antlrLexer;
	}

	public ANTLRLexerAdapter(Lexer antlrLexer, TextBlockReuseStrategy reuseStrategy, ResourceSet conn) {
		this.reuseStrategy = reuseStrategy;
		this.connection = conn;
		this.textblocksPackage = connection
				.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
		this.antlrLexer = antlrLexer;
	}

	public int getState(AbstractToken tok) {
		//State was already set in the moreTokens phase.	    
		return tok.getState();
	}

	/**
	 * IMPORTANT: The returned token's offset is relative to the last construction location!!!
	 */
	public List<AbstractToken> moreTokens() {
		// ANTLR always seems to return one token at a time, no token sequences
		// seem to be supported
		List<AbstractToken> tokens = new ArrayList<AbstractToken>(1);
		Token nextToken = antlrLexer.nextToken();
		if (nextToken == Token.EOF_TOKEN) {
			tokens.add(TbVersionUtil.getOtherVersion(
					incrementalLexer.getEOS(), Version.CURRENT));
		} else {
			AbstractToken tok = null;
			AbstractToken reuseableToken = getReuseableToken(nextToken);
			if(reuseableToken != null) {
				//TODO change this when the versioning is corrected to only version 
				//changed tokens. Then just re-use the construction loc token.
				
				//use the already present version of the current version
				//this was created by the copy mechanism at the start of the incremental lexing process
				//TODO change to real re-use if versioning is selective
				tok = TbVersionUtil.getOtherVersion(reuseableToken, Version.CURRENT);
				ANTLR3LocationToken aToken = (ANTLR3LocationToken) nextToken;
					
				tok.setType(aToken.getType());
				//REMEBER: the startIndex is only relative to the last constructionloc !!!
				tok.setOffset(aToken.getStartIndex());
				tok.setOffsetRelative(false);
				
				String text = aToken.getText();

				int originalEscapedLength = aToken.getStopIndex() - aToken.getStartIndex() + 1;
				
				if (originalEscapedLength != text.length()) {
				    throw new RuntimeException("Creating inconsistent TextBlocks Model (String within ><) : >" + text + "<.length = " +text.length() + " but expecting " + originalEscapedLength + " for tokenType="+aToken.getType()  );
				}
				
				tok.setLength(originalEscapedLength);
				tok.setValue(text);
						
				tok.setVersion(Version.CURRENT);
				//TODO: this could be moved to an extra property called "wasRelexed"
				tok.setRelexingNeeded(incrementalLexer.getReadToken().isRelexingNeeded());
				reusedTokens.add(tok);
			} else {
				if(nextToken.getChannel() == Token.HIDDEN_CHANNEL) {
					tok = (AbstractToken) textblocksPackage.getOmittedToken()
						.refCreateInstance();
					tok.setState(Token.HIDDEN_CHANNEL);
				} else {
					tok = (AbstractToken) textblocksPackage.getLexedToken()
						.refCreateInstance();
				}
				ANTLR3LocationToken aToken = (ANTLR3LocationToken) nextToken;
				
				tok.setType(aToken.getType());
				//REMEBER: the startIndex is only relative to the last constructionloc !!!
				tok.setOffset(aToken.getStartIndex());
				tok.setOffsetRelative(false);
				
				String text = aToken.getText();
				// in case the token is a String need escaping
	//			if (aToken.getType() == 5) {
	//			    text = escape(text);
	//			    // token need embracing hyphens (workaround)
	//			    text = "\"" + text +"\"";
	//			}
				int originalEscapedLength = aToken.getStopIndex() - aToken.getStartIndex() + 1;
	//			if (aToken.getType() == 4) {
	//			    if (originalEscapedLength != text.length()) {
	//			    
	//			        text = "\'" + text +"\'";
	//			    }
	//			}
				
				if (originalEscapedLength != text.length()) {
				    throw new RuntimeException("Creating inconsistent TextBlocks Model (String within ><) : >" + text + "<.length = " +text.length() + " but expecting " + originalEscapedLength + " for tokenType="+aToken.getType()  );
				}
	//			lexedToken.setLength(((ANTLR3LocationToken) nextToken).getText().length());
				
				tok.setLength(originalEscapedLength);
				tok.setValue(text);
				
				
				tok.setVersion(Version.CURRENT);
				//TODO: this could be moved to an extra property called "wasRelexed"
				tok.setRelexingNeeded(true);
			}
			tokens.add(tok);
		}
		return tokens;
	}

	/**
	 * Returns the token from the old version that can be reused for the given
	 * ANTLR token. This may either be the last read token from the incremental
	 * lexer or the token that is currently in the lookahead of the lexer.
	 * 
	 * @param nextToken
	 * @return A reusable {@link AbstractToken} or <code>null</code> of no token can be reused.
	 */
	private AbstractToken getReuseableToken(Token nextToken) {
		//The order of tries is important!
	        //construction loc is always the PREVIOUS version of the token!
		AbstractToken candidate = incrementalLexer.getConstructionLoc().getTok();
		while(true) {
			//first check if the token was already re-used, if not check if it can be re-used now 
			if(!wasReused(candidate) && reuseStrategy.canBeReUsed(candidate, nextToken)) {
				return candidate;
			}
			if(candidate.equals(incrementalLexer.getReadToken())) {
				break;
			}
			candidate = TbNavigationUtil.nextToken(candidate);
		}
		return null;
	}

	
	/**
	 * Checks whether the given <tt>candidate was already reused.
	 * @param candidate
	 * @return
	 */
    private boolean wasReused(AbstractToken candidate) {
    	return TbVersionUtil.getOtherVersion(candidate, Version.CURRENT) != null && 
    		reusedTokens.contains(TbVersionUtil.getOtherVersion(candidate, Version.CURRENT));
    }

	public void setIncrementalLexer(IncrementalLexer incrementalLexer) {
		antlrLexer
				.setCharStream((ANTLRIncrementalLexerAdapter) incrementalLexer);
		this.incrementalLexer = incrementalLexer;
	}

	public void setState(int state) {
		// TODO Auto-generated method stub

	}

	public Set<AbstractToken> getReusedTokens() {
		return reusedTokens;
	}

	@Override
	public boolean hasErrors() {
		ModelInjector mi;
		try {
			mi = (ModelInjector) antlrLexer.getClass().getField(LEXER_INJECTOR_FIELD_NAME).get(antlrLexer);
			if(mi != null) {
				return mi.getErrorList().size() > 0;
			} else {
				return false;
			}
		} catch (Exception e) {
			//there is no field ModelInjector. So no errors could be reported.
			return false;
		} 		
	}

}
