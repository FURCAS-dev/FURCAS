package bibtex.dsl.editor; 



import bibtex.dsl.parser.BibtexParserFactory;

import com.sap.furcas.ide.editor.AbstractGrammarBasedEditor;

public class BibtexEditor extends AbstractGrammarBasedEditor { 

	public BibtexEditor() { 

		super(new BibtexParserFactory(), new BibtexTokenMapper()); 
	} 

}
