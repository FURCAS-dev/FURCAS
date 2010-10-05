package com.sap.mi.textual.parsing.textblocks;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;


public class TestTextBlocksModelElementMoinFactory implements
		TestTextBlocksModelElementFactory {

	private ResourceSet connection;
	private TextblocksPackage rootPkg;

	public TestTextBlocksModelElementMoinFactory(ResourceSet connection2) {
		connection = connection2;
		rootPkg = connection.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	}

	@Override
	public Bostoken createBostoken() {
		Bostoken bostoken = (Bostoken) rootPkg.getBostoken().refCreateInstance();
		bostoken.setVersion(EEnum.REFERENCE);
		return bostoken;
	}

	@Override
	public Eostoken createEostoken() {
		Eostoken eostoken = (Eostoken) rootPkg.getEostoken().refCreateInstance();
		eostoken.setVersion(EEnum.REFERENCE);
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
