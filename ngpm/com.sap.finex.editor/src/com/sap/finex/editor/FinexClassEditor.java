package com.sap.finex.editor;

import textblocks.TextBlock;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.tc.moin.repository.Connection;

public class FinexClassEditor extends AbstractGrammarBasedEditor {
	public FinexClassEditor() {
		super(new FinexClassParserFactory(), new FinexClassMapper());
	}

	@Override
	public TextBlock parse(TextBlock rootBlock) throws SemanticParserException {
		Connection connection = getWorkingConnection();
		initializeNewParser(connection);
		TextBlock newRoot =  super.parse(rootBlock);
		return newRoot;
	}
}
