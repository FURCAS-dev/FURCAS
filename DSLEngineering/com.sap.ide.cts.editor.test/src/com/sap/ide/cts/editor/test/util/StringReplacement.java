package com.sap.ide.cts.editor.test.util;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;

/**
 * Encapsulates a string replacement in one class.
 * 
 * This includes the position at which to replace, the length of the replacement
 * region and the string the replacement region should be replaced with.
 * 
 * @author C5126871
 * 
 */
public class StringReplacement {

	private int line;
	private int charPositionInLine;
	private int length;
	private String replacementString;

	public StringReplacement(int line, int charPositionInLine, int length,
			String replacementString) {
		this.line = line;
		this.length = length;
		this.charPositionInLine = charPositionInLine;
		this.replacementString = replacementString;

		assert (replacementString != null);
	}

	/**
	 * just inserts (length 0)
	 * 
	 * @param line
	 * @param charPositionInLine
	 * @param replacementString
	 */
	public StringReplacement(int line, int charPositionInLine,
			String replacementString) {
		this.line = line;
		this.length = 0;
		this.charPositionInLine = charPositionInLine;
		this.replacementString = replacementString;

		assert (replacementString != null);
	}

	public void applyTo(Document source) throws BadLocationException {
		int offset = source.getLineOffset(line) + charPositionInLine;
		source.replace(offset, length, replacementString);
	}

	public int getLine() {
		return line;
	}

	public int getCharPositionInLine() {
		return charPositionInLine;
	}

	public int getLength() {
		return length;
	}

	public String getReplacementString() {
		return replacementString;
	}
}
