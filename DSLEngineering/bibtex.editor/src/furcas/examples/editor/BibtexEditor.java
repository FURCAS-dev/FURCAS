package furcas.examples.editor; 

import textblocks.TextBlock; 

import furcas.examples.parser.BibtexParserFactory; 
import com.sap.ide.cts.editor.AbstractGrammarBasedEditor; 
import com.sap.ide.cts.parser.errorhandling.SemanticParserException; 
import com.sap.tc.moin.repository.Connection; 

public class BibtexEditor extends AbstractGrammarBasedEditor { 

	public BibtexEditor() { 
		super(new BibtexParserFactory(), new BibtexMapper()); 
	} 

	@Override 
	public TextBlock parse(TextBlock rootBlock) throws SemanticParserException { 
		Connection connection = getResourceSet();
		initializeNewParser(connection);
		TextBlock newRoot =  super.parse(rootBlock); 
		return newRoot; 
	} 

}