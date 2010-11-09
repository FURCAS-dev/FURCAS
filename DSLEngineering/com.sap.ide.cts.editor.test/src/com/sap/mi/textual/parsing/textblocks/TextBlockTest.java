package com.sap.mi.textual.parsing.textblocks;

import org.eclipse.emf.ecore.EEnum;
import org.junit.Before;

import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.test.base.StandaloneConnectionBasedTest;

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
		contentToken.setVersion(EEnum.REFERENCE);
		return contentToken;
	}
}
