/**
 * <copyright>
 *
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias)- Initial API and implementation
 *
 * </copyright>
 *
 * $Id: DerivedPrsStream.java,v 1.1 2010/01/22 18:37:53 asanchez Exp $
 */
package org.eclipse.ocl.lpg;

import java.util.ArrayList;

import lpg.runtime.ErrorToken;
import lpg.runtime.ILexStream;
import lpg.runtime.IToken;
import lpg.runtime.ParseErrorCodes;
import lpg.runtime.PrsStream;


/**
 * This DerivedLexStream will be used in favour of the LpgLexStream for the 
 * OCLLexer, so that some customization are introduced and exploited by the 
 * generated OCLLexer. 
 * 
 * @since 3.0
 */
public class DerivedPrsStream extends PrsStream {
	
	 private BasicEnvironment environment;
	 
	 public DerivedPrsStream(BasicEnvironment env, ILexStream iLexStream) {
		 super(iLexStream);
		 this.environment = env;
	 }
	 
	/**
	 * This function returns the index of the token element containing the
	 * offset specified. If such a token does not exist, it returns the negation
	 * of the index of the element immediately preceding the offset.
	 * 
	 * @since 1.3
	 */
	public ErrorToken getErrorTokenAtCharacter(int offset) {
		ErrorToken bestToken = null;
		for (int i = getSize(); --i >= 0;) {
			IToken token = getTokenAt(i);
			if (!(token instanceof ErrorToken)) {
				break;
			}
			IToken errorToken = ((ErrorToken) token).getErrorToken();
			if (offset >= errorToken.getStartOffset()
				&& offset <= errorToken.getEndOffset()) {
				if ((bestToken == null)
					|| ((bestToken.getStartOffset() <= errorToken
						.getStartOffset()) && (token.getEndOffset() <= errorToken
						.getEndOffset()))) {
					bestToken = (ErrorToken) token;
				}
			}
		}
		return bestToken;
	}
	
	/**
	 * @since 1.3
	 */
	public int getErrorTokens() {
		return getTokens().size() - getStreamLength();
	}
	
	/**
	 * Overridden to search only the non-Error nodes, which are the only tokens
	 * in monotonic order.
	 */
	@Override
	public int getTokenIndexAtCharacter(int offset) {
		int low = 0;
		int high = getSize();
		while (high > low) {
			IToken highToken = getTokenAt(high - 1);
			if (!(highToken instanceof ErrorToken)) {
				break;
			}
			high--;
		}
		while (high > low) {
			int mid = (high + low) / 2;
			IToken mid_element = getTokenAt(mid);
			if (offset >= mid_element.getStartOffset()
				&& offset <= mid_element.getEndOffset()) {
				return mid;
			} else if (offset < mid_element.getStartOffset()) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return -(low - 1);
	}
	
	@Override
	public int makeErrorToken(int firsttok, int lasttok, int errortok, int kind) {
		@SuppressWarnings("unchecked")
		ArrayList<IToken> tokens = getTokens();
		int index = tokens.size(); // the next index

		//
		// Note that when creating an error token, we do not remap its kind.
		// Since this is not a lexical operation, it is the responsibility of
		// the calling program (a parser driver) to pass to us the proper kind
		// that it wants for an error token.
		//
		IToken token = new ErrorToken(getIToken(firsttok), getIToken(lasttok),
			getIToken(errortok), getStartOffset(firsttok),
			getEndOffset(lasttok), kind) {

			@Override
			public String toString() {
				if (getIPrsStream() == null) {
					return "<toString>"; //$NON-NLS-1$
				}
				int startOffset = getStartOffset();
				int length = getEndOffset() + 1 - startOffset;
				if (length < 0) {
					length = -length - 1;
					startOffset = getEndOffset();
				}
				if ((startOffset + length) > getIPrsStream().getInputChars().length) {
					return String.valueOf(IToken.EOF);
				}
				return new String(getIPrsStream().getInputChars(), startOffset,
					length);
			}

		};
		token.setTokenIndex(index);
		tokens.add(token);
		token.setAdjunctIndex(getAdjuncts().size());
		return index;
	}

	/**
	 * 
	 * @since 3.0
	 */
	@Override 
	public void reportError(int errorCode, int leftToken, int errorToken, 
			int rightToken, String[] errorInfo) {

		if (environment == null) { 
			super.reportError(errorCode, leftToken, errorToken, rightToken, errorInfo); 
		} else {			 
			// TODO Revise this. BasicEnvironment.parserError doesn't have a String[] argument
			String tokenText = errorInfo.length > 0 ? errorInfo[0] : ""; //$NON-NLS-1$
			if (errorCode == PrsStream.DELETION_CODE || errorCode == PrsStream.MISPLACED_CODE) {  
				tokenText = ""; //$NON-NLS-1$  
			}  
			environment.parserError(errorCode, leftToken, rightToken, tokenText); 
		} 
	}
	
	/**
	 * Report error message for given error_token.
	 * 
	 * @param error_token
	 *            the error taken index
	 * @param msg
	 *            the message to report
	 * 
	 * @since 1.3
	 */
	public final void reportErrorTokenMessage(int error_token, String msg) {
		int firsttok = super.getFirstRealToken(error_token);
		int lasttok = super.getLastRealToken(error_token);
		if (firsttok > lasttok) {
			reportError(ParseErrorCodes.INSERTION_CODE, lasttok,
				lasttok, msg);
		} else {
			reportError(ParseErrorCodes.SUBSTITUTION_CODE, firsttok,
				lasttok, msg);
		}
	}	
}