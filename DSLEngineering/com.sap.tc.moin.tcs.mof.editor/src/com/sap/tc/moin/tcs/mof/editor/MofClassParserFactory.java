package com.sap.tc.moin.tcs.mof.editor;

import generated.MofClassLexer;
import generated.MofClassParser;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

public class MofClassParserFactory extends
	AbstractParserFactory<MofClassParser, MofClassLexer> {

    private static final String CLASS_LANGUAGE_ID = "MofClass";

    @Override
    public Class<MofClassLexer> getLexerClass() {
	return MofClassLexer.class;
    }

    @Override
    public Class<MofClassParser> getParserClass() {
	return MofClassParser.class;
    }

    @Override
    public String getLanguageId() {
	return CLASS_LANGUAGE_ID;
    }

    public String[] getHiddenChannelTokenNames() {
	return new String[] { "WS", "NL", "COMMENT" };
    }

    @Override
    public RefPackage getMetamodelPackage(Connection connection) {
	return connection.getPackage(MoinPackage.PACKAGE_DESCRIPTOR);
    }

	@Override
	public Integer[] getOmittedTokensForFormatting() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
