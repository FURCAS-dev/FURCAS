package com.sap.tc.moin.tcs.mof.editor;

import generated.MofPackageLexer;
import generated.MofPackageParser;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

public class MofPackageParserFactory extends
	AbstractParserFactory<MofPackageParser, MofPackageLexer> {

    private static final String PACKAGE_LANGUAGE_ID = "MofPackage";

    @Override
    public Class<MofPackageLexer> getLexerClass() {
	return MofPackageLexer.class;
    }

    @Override
    public Class<MofPackageParser> getParserClass() {
	return MofPackageParser.class;
    }

    @Override
    public String getLanguageId() {
	return PACKAGE_LANGUAGE_ID;
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
