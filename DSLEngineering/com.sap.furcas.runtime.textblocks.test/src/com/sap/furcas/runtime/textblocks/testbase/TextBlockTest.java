package com.sap.furcas.runtime.textblocks.testbase;

import org.junit.Before;

import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.textblocks.testutils.EMFTextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.testutils.TextBlocksModelElementFactory;

/**
 * Base class for TextBlock related test cases. Sets up a common fixture model
 * and makes all elements available through protected members.
 * 
 * @author D052602
 * 
 */
public class TextBlockTest {

    protected TextBlocksModelElementFactory modelFactory;

    @Before
    public void setModelFactory() {
	modelFactory = new EMFTextBlocksModelElementFactory();
    }

    /**
     * @param content
     * @return
     */
    protected LexedToken createToken(String content) {
	LexedToken contentToken = modelFactory.createLexedToken();
	contentToken.setValue(content);
	contentToken.setLength(content.length());
	contentToken.setEndColumn(content.length());
	contentToken.setType(0);
	contentToken.setVersion(Version.REFERENCE);
	return contentToken;
    }
}