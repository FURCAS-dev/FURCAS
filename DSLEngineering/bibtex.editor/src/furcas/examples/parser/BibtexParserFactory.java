package furcas.examples.parser; 

import generated.BibtexLexer;
import generated.BibtexParser;
import bibtex.BibtexPackage;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

public class BibtexParserFactory extends AbstractParserFactory<BibtexParser, BibtexLexer> { 

	private static final String CLASS_LANGUAGE_ID = "Bibtex"; 

	@Override
	public String[] getHiddenChannelTokenNames() {
	return new String[] { "WS", "NL", "COMMENT" };
    }

	@Override 
	public Class<BibtexLexer> getLexerClass() { 
		return BibtexLexer.class;
	} 

	@Override 
	public Class<BibtexParser> getParserClass() { 
		return BibtexParser.class;
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