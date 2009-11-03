package com.sap.coghead.editor;

import textblocks.TextBlock;

import com.sap.coghead.syntax.CollectionLevelPermissionParserFactory;
import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.tc.moin.repository.Connection;

public class CollectionLevelPermissionEditor extends AbstractGrammarBasedEditor {

	public CollectionLevelPermissionEditor() {
		super(new CollectionLevelPermissionParserFactory(), new CollectionLevelPermissionMapper());
	}

	@Override
	public TextBlock parse(TextBlock rootBlock) throws SemanticParserException {
		Connection connection = getWorkingConnection();
		initializeNewParser(connection);
		//Call super implementation to do the actual stuff
		TextBlock newRoot =  super.parse(rootBlock);
		return newRoot;
	}
}
