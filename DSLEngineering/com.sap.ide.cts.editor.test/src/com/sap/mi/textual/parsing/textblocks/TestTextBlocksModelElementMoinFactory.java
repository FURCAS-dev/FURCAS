package com.sap.mi.textual.parsing.textblocks;

import textblocks.Bostoken;
import textblocks.Eostoken;
import textblocks.LexedToken;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;
import textblocks.VersionEnum;

import com.sap.tc.moin.repository.Connection;

public class TestTextBlocksModelElementMoinFactory implements
		TestTextBlocksModelElementFactory {

	private Connection connection;
	private TextblocksPackage rootPkg;

	public TestTextBlocksModelElementMoinFactory(Connection connection2) {
		connection = connection2;
		rootPkg = connection.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	}

	@Override
	public Bostoken createBostoken() {
		Bostoken bostoken = (Bostoken) rootPkg.getBostoken().refCreateInstance();
		bostoken.setVersion(VersionEnum.REFERENCE);
		return bostoken;
	}

	@Override
	public Eostoken createEostoken() {
		Eostoken eostoken = (Eostoken) rootPkg.getEostoken().refCreateInstance();
		eostoken.setVersion(VersionEnum.REFERENCE);
		return eostoken;
	}

	@Override
	public LexedToken createLexedToken() {
		return (LexedToken) rootPkg.getLexedToken().refCreateInstance();
	}

	@Override
	public TextBlock createTextBlock() {
		return (TextBlock) rootPkg.getTextBlock().refCreateInstance();
	}

}
