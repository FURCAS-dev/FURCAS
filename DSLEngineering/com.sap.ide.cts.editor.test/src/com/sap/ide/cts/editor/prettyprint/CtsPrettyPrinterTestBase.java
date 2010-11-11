package com.sap.ide.cts.editor.prettyprint;

import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

<<<<<<< HEAD
import com.sap.furcas.metamodel.textblocks.TextBlock;
=======
import textblocks.TextBlock;

import com.sap.furcas.test.util.TcsTestHelper;
import com.sap.furcas.textual.textblocks.model.TextBlocksModel;
import com.sap.furcas.textual.textblocks.testutils.TextblocksTestHelper;
>>>>>>> 339c4f6827f2205a0254bfb911d75ecfc4a51698
import com.sap.ide.cts.editor.test.util.ConcreteSyntaxBasedTest;

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
