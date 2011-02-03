/**
 * 
 */
package com.sap.furcas.ide.editor.contentassist;

import java.util.Comparator;

public class TextPositionComparator implements Comparator<TextPosition> {

	@Override
	public int compare(TextPosition a, TextPosition b) {
		if (a.getLine() < b.getLine()) {
			return -1;
		} else if (a.getLine() > b.getLine()) {
			return 1;

		} else {
			return a.getCharPositionInLine() - b.getCharPositionInLine();
		}
	}

}