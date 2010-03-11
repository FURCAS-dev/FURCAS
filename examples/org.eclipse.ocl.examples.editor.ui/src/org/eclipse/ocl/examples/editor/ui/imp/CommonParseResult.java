/**
 * <copyright>
 * 
 * Copyright (c) 2009,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonParseResult.java,v 1.1 2010/03/11 14:51:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import lpg.runtime.ErrorToken;
import lpg.runtime.IPrsStream;
import lpg.runtime.IToken;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.imp.core.ErrorHandler;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.examples.editor.ui.imp.ICommonParseController.TokenKind;
import org.eclipse.ocl.examples.parser.environment.ICSTFileEnvironment;
import org.eclipse.ocl.examples.parser.environment.ICSTRootEnvironment;
import org.eclipse.ocl.lpg.AbstractLexer;
import org.eclipse.ocl.lpg.AbstractParser;

public class CommonParseResult implements ICommonParseResult
{
	public static final class NullTokenIterator implements Iterator<IToken>
	{
		public boolean hasNext() {
			return false;
		}

		public IToken next() {
			return null;
		}

		public void remove() {
		}
	}

	static final class TokenIterator implements Iterator<IToken>
	{
		final IPrsStream stream;
		final int firstTokIdx;
		final int lastTokIdx;
		int curTokIdx; // skip bogus initial token
		// The following declarations cover the whole input stream, which
		// may be a proper superset of the range of the given region.
		// For now, that's a simple way to collect the information, and
		// most often the given region corresponds to the whole input anyway.
		// In any case, iteration is based on the range of the given region.
		
		// The preceding adjuncts for each token
		IToken[][] precedingAdjuncts;
		// The current indices for each array of preceding adjuncts
		int[] nextPrecedingAdjunct;
		// The following adjuncts (for the last token only)
		IToken[] followingAdjuncts;
		// The current index for the array of following adjuncts
		int nextFollowingAdjunct;
		// To support hasNext(); initial values may be reset if appropriate
		private boolean finalTokenReturned;
		private boolean finalAdjunctsReturned;

		private TokenIterator(IPrsStream stream, int regionEnd, int regionOffset) {
			this.stream = stream;
			firstTokIdx = getTokenIndexAtCharacter(regionOffset);
			curTokIdx = Math.max(1, firstTokIdx);
			{
				int endIdx = getTokenIndexAtCharacter(regionEnd);
			    char[] streamChars = stream.getInputChars();
			    if (streamChars != null) {
			    	try {
			    		if ((1 <= regionEnd) && (regionEnd < streamChars.length) && (streamChars[regionEnd] == IToken.EOF)) {
			    			// skip EOF token (assume LPG puts one at end of input character stream, since it does)
			    			endIdx--;
			    		}
			    	} catch (ArrayIndexOutOfBoundsException e) {
				        ErrorHandler.logError("SimpleLPGParseController.getTokenIterator(IRegion):  error initializing lastTokIdx", e);
//	            			System.err.println("getTokenIterator:  new Iterator(..)<init>:  ArrayIndexOutOfBoundsException");
//	            			System.err.println("    regionEnd = " + regionEnd + ", endIdx = " + endIdx + ", streamLen = " + streamLen + ", inputChars.length = " + streamChars.length);
			    	}
				}
				while (endIdx >= 0) {
					IToken lastToken = stream.getIToken(endIdx);
					if (!(lastToken instanceof ErrorToken))
						break;
					endIdx--;
				}
				lastTokIdx = endIdx;
			}
			precedingAdjuncts = new IToken[lastTokIdx+1][];
			nextPrecedingAdjunct = new int[lastTokIdx+1];
			{
				for (int i = 0; i < precedingAdjuncts.length; i++) {
					precedingAdjuncts[i] = stream.getPrecedingAdjuncts(i);
				}
			}
			{
				for (int i = 0; i < nextPrecedingAdjunct.length; i++) {
					if (precedingAdjuncts[i].length == 0)
						nextPrecedingAdjunct[i] = -1;
					else 
						nextPrecedingAdjunct[i] = 0;
				}
			}
			{
				if (lastTokIdx <= 0)
					followingAdjuncts = new IToken[0];
				else
					followingAdjuncts = stream.getFollowingAdjuncts(lastTokIdx);
			}
			{
				if (followingAdjuncts.length == 0)
					nextFollowingAdjunct = -1;
				else
			    	nextFollowingAdjunct = 0;
			}
			finalTokenReturned = regionEnd < 1 || lastTokIdx <= 0;
			finalAdjunctsReturned = !(followingAdjuncts.length > 0);
		}

		private int getTokenIndexAtCharacter(int offset) {
		    int result = stream.getTokenIndexAtCharacter(offset);
		    // getTokenIndexAtCharacter() answers the negative of the index of the
		    // preceding token if the given offset is not actually within a token.
		    if (result < 0) {
		        result= -result + 1;
		    }
		    
		    // The above may leave result set to a value that is one more than the
		    // last token index, so return the last token index if that's the case
		    // (This can happen if the end of the file contains some text that
		    // does not correspond to a token--e.g., if the text represents an adjunct
		    // or something unrecognized)
		    if (result >= stream.getTokens().size())
		    	result = stream.getTokens().size() - 1;
		    
		    return result;
		}

		/**
		 * Tests whether the iterator has any unreturned tokens.  These may include
		 * "regular" tokens and "adjunct" tokens (e.g., representing comments).
		 * 
		 * @return	True if there is another token available, false otherwise
		 */
		public boolean hasNext() {
		   	return !(finalTokenReturned && finalAdjunctsReturned);
		}

		/**
		 * Returns the next available token in the iterator (or null if there is none)
		 *
		 * Will return a valid token under conditions that would cause hasNext() to
		 * to return true; conversely, will return null under conditions that would
		 * cause hasNext() to return false.
		 * 
		 * As a side effect, updates the flags that are used to compute the value
		 * returned by hasNext().
		 * 
		 * The returned token may be a "regular" token (which will have a
		 * corresponding AST node) or an "adjunct" token (which will represent
		 * a comment).  The tokens are returned in the order in which they occur
		 * in the text, regardless of their kind.
		 * 
		 */
		public IToken next()
		{	
			int next = -1;	// for convenience
			
			// If we're not all the way through the tokens
			if (curTokIdx <= lastTokIdx) {
				
				// First check for any remaining preceding adjuncts
				// of the current token
		    	next = nextPrecedingAdjunct[curTokIdx];
		    	// If the current token has any unreturned preceding adjuncts
		    	if (next >= 0 && next < precedingAdjuncts[curTokIdx].length) {
		    		// Return the next preceding adjunct, incrementing the adjunct index afterwards
		    		return precedingAdjuncts[curTokIdx][nextPrecedingAdjunct[curTokIdx]++];
		    	}
		    	
				// Flag whether the current token is the last one
				finalTokenReturned = curTokIdx >= lastTokIdx;
				
				// Return the current token, incrementing the token index afterwards
		    	return stream.getIToken(curTokIdx++);
			}
			
			// If there are any adjuncts following the last token
			if (nextFollowingAdjunct >= 0 && nextFollowingAdjunct < followingAdjuncts.length) {
				
				// Flag whether the current adjunct is the last one
				finalAdjunctsReturned = (nextFollowingAdjunct+1) >= followingAdjuncts.length;
				
				// Return the current adjunct, incrementing the adjunct index afterwards
				return followingAdjuncts[nextFollowingAdjunct++];
			}
			
			return null;
		}

		public void remove() {
		    throw new IllegalArgumentException("Unimplemented");
		}
	}
	
	protected final CommonParseController parseController;
	protected final ICSTFileEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> fileEnvironment;
	protected ICSTRootEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> rootEnvironment;		// Singly assigned by parse()
	private CSTNode cst = null;							// Singly assigned by parse()
	private Resource ast = null;						// Singly assigned by parse()
	
	public CommonParseResult(CommonParseController parseController, ICSTFileEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> fileEnvironment) {
		this.parseController = parseController;
		this.fileEnvironment = fileEnvironment;
	}

	public Resource getAST() {
		return ast;
	}

	public Object getASTNode(Object object) {
		if (object instanceof ModelTreeNode)
			object = ((ModelTreeNode)object).getASTNode();
		if (object instanceof CSTNode)
			object = ((CSTNode) object).getAst();
		return object;
	}

	public Object getASTorCSTNode(Object object) {
		if (object instanceof ModelTreeNode)
			object = ((ModelTreeNode)object).getASTNode();
		return object;
	}
	
	public CSTNode getCST() {
		return cst;
	}

	public CSTNode getCSTNode(Object object) {
		if (object instanceof ModelTreeNode)
			object = ((ModelTreeNode)object).getASTNode();
		return getRootEnvironment().getASTMapping(object);
	}

	public ICSTFileEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> getFileEnvironment() {
		return fileEnvironment;
	}

	public String getTextRange(int start, int length) {
		return new String(getLexer().getILexStream().getInputChars(), start, length);
	}

	protected int[] getKeywordKinds() {
		return getLexer().getKeywordKinds();
	}

	public List<ICommonKeyword> getKeywords() {
    	return parseController.getKeywords();
	}

	public AbstractLexer getLexer() {
		return getParser().getLexer();
	}

	public ICommonParseController getParseController() {
		return parseController;
	}

	public AbstractParser getParser() {
		return fileEnvironment.getParser();
	}

	public Collection<Resource> getResourcesVisibleAt(EObject astNode) {
		return fileEnvironment.getResourcesVisibleAt(astNode);
	}

	public ICSTRootEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> getRootEnvironment() {
		return rootEnvironment;
	}

	public ISourcePositionLocator getSourcePositionLocator() {
		return parseController.getCreationFactory().createSourcePositionLocator(getRootEnvironment());
	}
	
	public Iterator<IToken> getTokenIterator(final IRegion region) {
        int regionOffset= region.getOffset();
        int regionLength= region.getLength();
    	int regionEnd = regionOffset + regionLength - 1;
		IPrsStream stream =  getParser().getIPrsStream();
		if ((stream != null) && (stream.getStreamLength() > 0))
			return new TokenIterator(stream, regionEnd, regionOffset);
		else
			return new NullTokenIterator();
    }

    public TokenKind getTokenKind(int kind) {
    	return parseController.getTokenKind(kind);
    }

    public boolean isCompleteable(int kind) {
    	return parseController.isCompleteable(kind);
    }

    public boolean isIdentifier(int kind) {
    	return parseController.isIdentifier(kind);
    }

    public boolean isKeyword(int kind) {
    	return parseController.isKeyword(kind);
    }

	public ICSTRootEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> parse(Reader reader, IProgressMonitor progressMonitor) throws IOException, CoreException {
		rootEnvironment = fileEnvironment.parse(reader, fileEnvironment.getFile(), progressMonitor);
		if (rootEnvironment == null)
			return null;
		if (rootEnvironment.getCSTErrorTokens() <= 0)
			rootEnvironment.validate();
		cst = rootEnvironment.getCSTNode();
		ast = rootEnvironment.getASTNode();
		return rootEnvironment;
	}
}