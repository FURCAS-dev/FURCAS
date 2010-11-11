package com.sap.ide.cts.editor;

import org.eclipse.jface.text.IDocument;

public class ParserHelper {
	private static final String EOL = "\r\n";
	
	private static int positionToOffset(String document, int line, int column)
	{
		int offset = 0;
		String[] lines = document.split(EOL);
		for (int i=0; i<line-1; i++)
		{
			offset += lines[i].length()+EOL.length();
		}
		offset += column;
		return offset;
	}

	public static int positionToOffset(IDocument document, int line, int column)
	{
		return positionToOffset(document.get(), line, column);
	}
}
