package com.sap.mi.textual.parsing.textblocks;

import org.junit.Before;

import textblocks.LexedToken;
import textblocks.VersionEnum;

import com.sap.ide.cts.editor.test.util.StandaloneConnectionBasedTest;

/**
 * Base class for TextBlock related test cases. Sets up a common fixture model
 * and makes all elements available through protected members.
 * 
 * @author D052602
 * 
 */
public class TextBlockTest extends StandaloneConnectionBasedTest {

	protected TestTextBlocksModelElementFactory modelFactory;

	@Before
	public void setModelFactory() {
		modelFactory = new TestTextBlocksModelElementMoinFactory(connection);
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
		contentToken.setVersion(VersionEnum.REFERENCE);
		return contentToken;
	}
}
