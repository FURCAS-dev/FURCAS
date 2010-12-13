package furcas.examples.editor;

import textblocks.TextBlock;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.tc.moin.repository.Connection;

import furcas.examples.parser.AlternativeBibtexParserFactory;

public class AlternativeBibtexEditor extends AbstractGrammarBasedEditor {

	public AlternativeBibtexEditor() {
		super(new AlternativeBibtexParserFactory(),
				new AlternativeBibtexMapper());
	}

	@Override
	public TextBlock parse(TextBlock rootBlock) throws SemanticParserException {
		Connection connection = getResourceSet();
		initializeNewParser(connection);
		TextBlock newRoot = super.parse(rootBlock);
		return newRoot;
	}

}