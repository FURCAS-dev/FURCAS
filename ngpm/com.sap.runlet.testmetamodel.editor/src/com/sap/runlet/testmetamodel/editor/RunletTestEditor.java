package com.sap.runlet.testmetamodel.editor;

import textblocks.TextBlock;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.tc.moin.repository.Connection;

public class RunletTestEditor extends AbstractGrammarBasedEditor {

	private static final String RUNLET_TEST_LANGUAGE_ID = "RunletTest";

	public RunletTestEditor() {
	    super(new RunletTestParserFactory(), new RunletTestMapper());
	}

	@Override
	public TextBlock parse(TextBlock rootBlock) throws SemanticParserException {
		Connection connection = getWorkingConnection();
		initializeNewParser(connection);
		TextBlock newRoot =  super.parse(rootBlock);
		return newRoot;
	}

	@Override
	public String getLanguageId() {
		return RUNLET_TEST_LANGUAGE_ID;
	}

}
