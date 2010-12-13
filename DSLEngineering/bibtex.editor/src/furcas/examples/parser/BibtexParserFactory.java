package furcas.examples.parser; 

import generated.BibtexLexer;
import generated.BibtexParser;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import Bibtex.BibtexPackage;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;

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
	public EPackage getMetamodelPackage(ResourceSet connection) {;
		return BibtexPackage.eINSTANCE;
	}

//	@Override
//	public Integer[] getOmittedTokensForFormatting() {
//		// TODO Auto-generated method stub
//		return null;
//	} 

}