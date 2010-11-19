package furcas.examples.parser; 

import generated.AlternativeBibtexLexer;
import generated.AlternativeBibtexParser;
import bibtex.BibtexPackage;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

public class AlternativeBibtexParserFactory extends AbstractParserFactory<AlternativeBibtexParser, AlternativeBibtexLexer> { 

	private static final String CLASS_LANGUAGE_ID = "AlternativeBibtex"; 

	@Override
    public String[] getHiddenChannelTokenNames() {
	return new String[] { "WS", "NL", "COMMENT" };
    }

	@Override 
	public Class<AlternativeBibtexLexer> getLexerClass() { 
		return AlternativeBibtexLexer.class;
	} 

	@Override 
	public Class<AlternativeBibtexParser> getParserClass() { 
		return AlternativeBibtexParser.class;
	} 

	@Override 
	public String getLanguageId() { 
		return CLASS_LANGUAGE_ID;
	}

	@Override
	public RefPackage getMetamodelPackage(Connection connection) {
	    BibtexPackage bibtexPackage = connection.getPackage(BibtexPackage.PACKAGE_DESCRIPTOR);
		return bibtexPackage;
	}

	@Override
	public Integer[] getOmittedTokensForFormatting() {
		// TODO Auto-generated method stub
		return null;
	} 

}