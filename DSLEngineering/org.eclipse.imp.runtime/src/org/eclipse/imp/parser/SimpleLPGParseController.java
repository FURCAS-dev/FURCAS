/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
 *    Stan Sutton (suttons@us.ibm.com) - maintenance of iterator
 *******************************************************************************/

package org.eclipse.imp.parser;

import java.util.Iterator;

import lpg.runtime.IPrsStream;
import lpg.runtime.IToken;
import lpg.runtime.Monitor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.core.ErrorHandler;
import org.eclipse.imp.services.IAnnotationTypeInfo;
import org.eclipse.jface.text.IRegion;

/**
 * Base class for an IParseController implementation that encapsulates a simple
 * LPG-based scanner and parser.
 * 
 * @author rfuhrer@watson.ibm.com
 * @author Stan Sutton (suttons@us.ibm.com): rewrote token iterator
 */
public abstract class SimpleLPGParseController extends ParseControllerBase {
//  private char fKeywords[][];

    private boolean fIsKeyword[];

    protected IParser fParser;

    protected ILexer fLexer;

    private ISourcePositionLocator fSourcePositionLocator;

    private final SimpleAnnotationTypeInfo fSimpleAnnotationTypeInfo= new SimpleAnnotationTypeInfo();

    /**
     * An adapter from an Eclipse IProgressMonitor to an LPG Monitor
     */
    protected class PMMonitor implements Monitor {
        private IProgressMonitor monitor;

        private boolean wasCancelled= false;

        public PMMonitor(IProgressMonitor monitor) {
            this.monitor= monitor;
        }

        public boolean isCancelled() {
            if (!wasCancelled)
                wasCancelled= monitor.isCanceled();
            return wasCancelled;
        }

        public void setMonitor(IProgressMonitor monitor) {
            this.monitor= monitor;
        }
    }

    /**
     * Note: the derived class constructor should instantiate the lexer and parser
     * and store them in fLexer/fParser.
     */
    public SimpleLPGParseController(String languageID) {
        super(languageID);
    }

    public IParser getParser() {
        return fParser;
    }

    public ILexer getLexer() {
        return fLexer;
    }

    public ISourcePositionLocator getSourcePositionLocator() {
        if (fSourcePositionLocator == null) {
            fSourcePositionLocator= new LPGSourcePositionLocator(this);
        }
        return fSourcePositionLocator;
    }

    public Object parse(String contents, IProgressMonitor monitor) {
        PMMonitor my_monitor = new PMMonitor(monitor);
        char[] contentsArray = contents.toCharArray();

        fLexer.reset(contentsArray, (fFilePath != null ? fFilePath.toPortableString() : null));
        fParser.reset(fLexer.getILexStream());
        fParser.getIPrsStream().setMessageHandler(new MessageHandlerAdapter(handler));

        // RMF 1 Mar 2010: Don't do any resource-related operations, like clearing markers: what we're parsing may not come from a resource.
        
        fLexer.lexer(my_monitor, fParser.getIPrsStream()); // Lex the stream to produce the token stream
        if (my_monitor.isCancelled())
            return fCurrentAst; // TODO currentAst might (probably will) be inconsistent wrt the lex stream now

        fCurrentAst = fParser.parser(my_monitor, 0);

        cacheKeywordsOnce(); // better place/time to do this?

        return fCurrentAst;
    }

    public Iterator<IToken> getTokenIterator(final IRegion region) {
        final int regionOffset= region.getOffset();
        final int regionLength= region.getLength();
        final int regionEnd= regionOffset + regionLength - 1;

        return new Iterator<IToken>() {
            final IPrsStream stream= SimpleLPGParseController.this.getParser().getIPrsStream();
            final int firstTokIdx= getTokenIndexAtCharacter(regionOffset);
            final int lastTokIdx;
            {
                int endIdx= getTokenIndexAtCharacter(regionEnd);
                char[] streamChars= stream.getInputChars();
                int streamLen= streamChars.length;
                try {
                    if (regionEnd >= 1 && regionEnd < streamLen
                            && streamChars[regionEnd] == IToken.EOF) {
                        // skip EOF token (assume LPG puts one at end of input
                        // character stream, since it does)
                        endIdx--;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    ErrorHandler.logError("SimpleLPGParseController.getTokenIterator(IRegion):  error initializing lastTokIdx",
                            e);
                    // System.err.println("getTokenIterator: new Iterator(..)<init>: ArrayIndexOutOfBoundsException");
                    // System.err.println(" regionEnd = " + regionEnd + ", endIdx = " + endIdx + ", streamLen = " + streamLen + ",
                    // inputChars.length = " + streamChars.length);
                }
                lastTokIdx= endIdx;
            }
            int curTokIdx= Math.max(1, firstTokIdx); // skip bogus initial token

            private int getTokenIndexAtCharacter(int offset) {
                int result= stream.getTokenIndexAtCharacter(offset);
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
                    result= stream.getTokens().size() - 1;

                return result;
            }

            // The following declarations cover the whole input stream, which
            // may be a proper superset of the range of the given region.
            // For now, that's a simple way to collect the information, and
            // most often the given region corresponds to the whole input anyway.
            // In any case, iteration is based on the range of the given region.

            // The preceding adjuncts for each token
            IToken[][] precedingAdjuncts= new IToken[lastTokIdx + 1][];
            {
                stream.setStreamLength();
                for(int i= 0; i < precedingAdjuncts.length; i++) {
                    precedingAdjuncts[i]= stream.getPrecedingAdjuncts(i);
                }
            }

            // The current indices for each array of preceding adjuncts
            int[] nextPrecedingAdjunct= new int[lastTokIdx + 1];
            {
                for(int i= 0; i < nextPrecedingAdjunct.length; i++) {
                    if (precedingAdjuncts[i].length == 0)
                        nextPrecedingAdjunct[i]= -1;
                    else
                        nextPrecedingAdjunct[i]= 0;
                }
            }

            // The following adjuncts (for the last token only)
            IToken[] followingAdjuncts;
            {
                if (lastTokIdx <= 0)
                    followingAdjuncts= new IToken[0];
                else
                    followingAdjuncts= stream.getFollowingAdjuncts(lastTokIdx);
            }

            // The current index for the array of following adjuncts
            int nextFollowingAdjunct;
            {
                if (followingAdjuncts.length == 0)
                    nextFollowingAdjunct= -1;
                else
                    nextFollowingAdjunct= 0;
            }

            // To support hasNext(); initial values may be reset if appropriate
            private boolean finalTokenReturned= regionEnd < 1 || lastTokIdx <= 0;
            private boolean finalAdjunctsReturned= !(followingAdjuncts.length > 0);

            /**
             * Tests whether the iterator has any unreturned tokens. These may
             * include "regular" tokens and "adjunct" tokens (e.g., representing
             * comments).
             * 
             * @return True if there is another token available, false otherwise
             */
            public boolean hasNext() {
                return !(finalTokenReturned && finalAdjunctsReturned);
            }

            /**
             * Returns the next available token in the iterator (or null if
             * there is none)
             * 
             * Will return a valid token under conditions that would cause
             * hasNext() to to return true; conversely, will return null under
             * conditions that would cause hasNext() to return false.
             * 
             * As a side effect, updates the flags that are used to compute the
             * value returned by hasNext().
             * 
             * The returned token may be a "regular" token (which will have a
             * corresponding AST node) or an "adjunct" token (which will
             * represent a comment). The tokens are returned in the order in
             * which they occur in the text, regardless of their kind.
             * 
             */
            public IToken next() {
                int next= -1; // for convenience

                // If we're not all the way through the tokens
                if (curTokIdx <= lastTokIdx) {

                    // First check for any remaining preceding adjuncts
                    // of the current token
                    next= nextPrecedingAdjunct[curTokIdx];
                    // If the current token has any unreturned preceding
                    // adjuncts
                    if (next >= 0 && next < precedingAdjuncts[curTokIdx].length) {
                        // Return the next preceding adjunct, incrementing the
                        // adjunct index afterwards
                        return precedingAdjuncts[curTokIdx][nextPrecedingAdjunct[curTokIdx]++];
                    }

                    // Flag whether the current token is the last one
                    finalTokenReturned= curTokIdx >= lastTokIdx;

                    // Return the current token, incrementing the token index
                    // afterwards
                    return stream.getIToken(curTokIdx++);
                }

                // If there are any adjuncts following the last token
                if (nextFollowingAdjunct >= 0 && nextFollowingAdjunct < followingAdjuncts.length) {
                    // Flag whether the current adjunct is the last one
                    finalAdjunctsReturned= (nextFollowingAdjunct + 1) >= followingAdjuncts.length;

                    // Return the current adjunct, incrementing the adjunct
                    // index afterwards
                    return followingAdjuncts[nextFollowingAdjunct++];
                }

                return null;
            }

            public void remove() {
                throw new IllegalArgumentException("Unimplemented");
            }
        };
    }

    public IAnnotationTypeInfo getAnnotationTypeInfo() {
        return fSimpleAnnotationTypeInfo;
    }

    public boolean isKeyword(int kind) {
        return kind >= 0 && kind < fIsKeyword.length && fIsKeyword[kind];
    }

    protected void cacheKeywordsOnce() {
        if (fIsKeyword == null) {
            IParser parser= getParser();
            String tokenKindNames[]= parser.orderedTerminalSymbols();
            fIsKeyword= new boolean[tokenKindNames.length];
//          fKeywords= new char[tokenKindNames.length][];
            int[] keywordKinds= getLexer().getKeywordKinds();
            for(int i= 1; i < keywordKinds.length; i++) {
                int index= parser.getIPrsStream().mapKind(keywordKinds[i]);
                fIsKeyword[index]= true;
//              fKeywords[index]= parser.orderedTerminalSymbols()[index].toCharArray();
            }
        }
    }
}
