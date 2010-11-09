package com.sap.furcas.test.parsing.textblocks;

import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;

public class EMFTextBlocksModelElementFactory implements TextBlocksModelElementFactory {

    @Override
    public TextBlock createTextBlock() {
	return TextblocksFactory.eINSTANCE.createTextBlock();
    }

    @Override
    public LexedToken createLexedToken() {
	return TextblocksFactory.eINSTANCE.createLexedToken();
    }

    @Override
    public Eostoken createEostoken() {
	return TextblocksFactory.eINSTANCE.createEostoken();
    }

    @Override
    public Bostoken createBostoken() {
	return TextblocksFactory.eINSTANCE.createBostoken();
    }

}
