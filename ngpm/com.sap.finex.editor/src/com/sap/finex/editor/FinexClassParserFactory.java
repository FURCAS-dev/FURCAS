package com.sap.finex.editor;

import finex.FinexPackage;
import generated.FinexClassLexer;
import generated.FinexClassParser;

import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;



public class FinexClassParserFactory extends AbstractParserFactory<FinexClassParser, FinexClassLexer> {
    private static final String FINEX_CLASS_LANGUAGE_ID = "FinexClass";

    protected String[] getHiddenChannelTokenNames() {
	return new String[] { "WS", "NL", "COMMENT", "MULTI_LINE_COMMENT" };
    }

    @Override
    public RefPackage getMetamodelPackage(Connection connection) {
        return connection.getPackage(FinexPackage.PACKAGE_DESCRIPTOR);
    }

    @Override
    public Class<FinexClassLexer> getLexerClass() {
	return FinexClassLexer.class;
    }

    @Override
    public Class<FinexClassParser> getParserClass() {
	return FinexClassParser.class;
    }

    @Override
    public String getLanguageId() {
	return FINEX_CLASS_LANGUAGE_ID;
    }
}
