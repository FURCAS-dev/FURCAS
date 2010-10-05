package com.sap.ide.cts.editor.prettyprint;

import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.ide.cts.editor.test.util.ConcreteSyntaxBasedTest;
import com.sap.ide.cts.editor.test.util.TcsTestHelper;
import com.sap.mi.textual.parsing.textblocks.TextblocksTestHelper;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;

public class CtsPrettyPrinterTestBase extends ConcreteSyntaxBasedTest {

	protected String languageName;

	private String getReferenceOutput(String testCaseName) {
		InputStream fixtureStream = CtsPrettyPrinterTestBase.class
				.getResourceAsStream("fixtures/" + languageName + "_"
						+ testCaseName + ".out");

		return TcsTestHelper.getStreamContents(fixtureStream);
	}

	protected void assertOutput(String output, String testCaseName) {

		TcsTestHelper.assertByLines(output, getReferenceOutput(testCaseName));
	}

	protected void assertOutput(TextBlock rootBlock, String testCaseName) {
		TextblocksTestHelper.assertTextBlockAndChildren(rootBlock);
		TextBlocksModel model = new TextBlocksModel(rootBlock, null);
		String output = model.get(0, rootBlock.getLength());
		TcsTestHelper.assertByLines(output, getReferenceOutput(testCaseName));
	}

	protected void initSyntax(String languageName, InputStream languageTcsFile) {
		assertNotNull(connection);

		this.languageName = languageName;

		initSyntax(languageTcsFile);
	}
}
