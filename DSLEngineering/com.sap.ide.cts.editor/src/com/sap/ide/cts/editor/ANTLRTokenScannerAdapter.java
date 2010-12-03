/**
 * 
 */
package com.sap.ide.cts.editor;

import java.lang.reflect.InvocationTargetException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;

import com.sap.furcas.ide.editor.ITokenMapper;

/**
 * @author Steffen Becker
 * 
 */
public class ANTLRTokenScannerAdapter implements ITokenScanner {

	int lastTokenLength = 0;

	private int lastTokenOffset;

	private Class<? extends Lexer> scannerClass;

	private Lexer scanner;

	private String currentInput;

//	private IDocument currentDocument;

	private int baseOffset;

	private ITokenMapper myMapper;

//	private int lastTokenOffset;

	/**
	 * 
	 */
	public ANTLRTokenScannerAdapter(Class<? extends Lexer> scannerClass, ITokenMapper mapper) {
		this.scannerClass = scannerClass;
		this.myMapper = mapper;
		
	}
	
	private void initScanner(CharStream reader) {
	    if (scanner != null) {
	        scanner.setCharStream(reader);
	       
	    } else {
	        try {
	            scanner = scannerClass.getConstructor(CharStream.class)
	            .newInstance(new Object[] { reader });
	        } catch (SecurityException e) {
	            CtsActivator.logError(e);
	        } catch (InstantiationException e) {
	            CtsActivator.logError(e);
	        } catch (IllegalAccessException e) {
	            CtsActivator.logError(e);
	        } catch (InvocationTargetException e) {
	            CtsActivator.logError(e);
	        } catch (NoSuchMethodException e) {
	            CtsActivator.logError(e);
	        }
	    }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.ITokenScanner#getTokenLength()
	 */
	public int getTokenLength() {
		return lastTokenLength;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.ITokenScanner#getTokenOffset()
	 */
	public int getTokenOffset() {
		return lastTokenOffset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.ITokenScanner#nextToken()
	 */
	public IToken nextToken() {
	    lastTokenOffset = baseOffset + scanner.getCharIndex(); // Token starts at point where lexer is
		Token nextToken = scanner.nextToken();
        ANTLRTokenWrapper wrapper = new ANTLRTokenWrapper(nextToken , myMapper);
        // Bug: Text.length may not be acutal length of text, as "e" as a token has 'e' as text, but 3 as length (including the hyphens)
        if (nextToken instanceof ANTLR3LocationToken) {
            ANTLR3LocationToken aToken = (ANTLR3LocationToken) nextToken;
            lastTokenLength = ( aToken.getStopIndex() - aToken.getStartIndex() )+ 1;
        } else {
            lastTokenLength = nextToken.getText() == null ? 0 : nextToken.getText().length();
        }
	    int nextTokenIndex = scanner.getCharIndex();
	    lastTokenOffset += ( nextTokenIndex + baseOffset) - lastTokenOffset - lastTokenLength; // Correct the position in case of recognition exceptions
	    
		wrapper.setIsWhitespace(wrapper.getToken().getChannel() == BaseRecognizer.HIDDEN);// Token is a Whitespace
		return wrapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.ITokenScanner#setRange(org.eclipse.jface.text.IDocument,
	 *      int, int)
	 */
	public void setRange(IDocument document, int offset, int length) {
		currentInput = ""; 
//		currentDocument = document;
		try {
			currentInput = document.get(offset, length);
//			lastTokenOffset = 0;
			lastTokenOffset = offset; 
			baseOffset = offset;
		} catch (BadLocationException e1) {
		    CtsActivator.logError(e1);
		}
		/**
		 * Bug: TODO if this is an event in the middle of a multi line token, then we need to consider several lines!
		 */
		ANTLRStringStream reader = new ANTLRStringStream(currentInput);
		initScanner(reader);
//		scanner = (Lexer) scannerClass.getConstructor(CharStream.class)
//		.newInstance(new Object[] { reader });

	}

}
