package com.sap.furcas.runtime.textblocks.testutils;

import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;

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
    
    @Override
    public LexedToken createToken(String content) {
        LexedToken contentToken = createLexedToken();
        contentToken.setValue(content);
        contentToken.setLength(content.length());
        contentToken.setEndColumn(content.length());
        contentToken.setType(0);
        contentToken.setVersion(Version.REFERENCE);
        return contentToken;
    }

}
