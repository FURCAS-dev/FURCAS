package com.sap.tc.moin.tcs.mof.editor; 

import textblocks.TextBlock;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.tc.moin.repository.Connection;

public class MofPackageEditor extends AbstractGrammarBasedEditor { 

	public MofPackageEditor() { 
		super(new MofPackageParserFactory(), new MofPackageMapper()); 
	} 

	@Override 
	public TextBlock parse(TextBlock rootBlock) throws SemanticParserException { 
		Connection connection = getWorkingConnection();
		initializeNewParser(connection);
		TextBlock newRoot =  super.parse(rootBlock); 
		return newRoot; 
	} 

}