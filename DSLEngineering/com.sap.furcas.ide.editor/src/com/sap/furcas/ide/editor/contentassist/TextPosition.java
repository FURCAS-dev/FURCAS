/**
 * 
 */
package com.sap.furcas.ide.editor.contentassist;

public class TextPosition {
	private int line;
	private int charPositionInLine;

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getCharPositionInLine() {
		return charPositionInLine;
	}

	public void setCharPositionInLine(int charPositionInLine) {
		this.charPositionInLine = charPositionInLine;
	}

	public TextPosition(int line, int charPositionInLine) {
		this.line = line;
		this.charPositionInLine = charPositionInLine;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TextPosition) {
			TextPosition p = (TextPosition) obj;
			return (line == p.getLine() && charPositionInLine == p
					.getCharPositionInLine());
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return line * 1000 * charPositionInLine + charPositionInLine;
	}

	@Override
	public String toString() {
		return "[" + line + ", " + charPositionInLine + "]";
	}

}