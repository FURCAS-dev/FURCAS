package com.sap.ide.cts.editor.integration.prettyprint;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.junit.Before;

import tcs.ConcreteSyntax;
import textblocks.TextBlock;

import com.sap.furcas.textual.tcs.TcsUtil;
import com.sap.furcas.textual.textblocks.model.TextBlocksModel;
import com.sap.furcas.textual.textblocks.testutils.TextblocksTestHelper;
import com.sap.ide.cts.editor.contentassist.TcsModelElementFactory;
import com.sap.ide.cts.editor.contentassist.TcsModelElementMoinFactory;
import com.sap.ide.cts.editor.test.util.FixtureBasedTest;
import com.sap.ide.cts.editor.test.util.TcsTestHelper;

public class CtsPrettyPrinterIntegrationTestBase extends FixtureBasedTest {

	protected String languageName;
	protected ConcreteSyntax syntax;
	protected TcsModelElementFactory modelFactory;

	@Before
	public void setupModelFactory() {
		modelFactory = new TcsModelElementMoinFactory(connection);
	}

	private String getReferenceOutput(String testCaseName) {
		InputStream fixtureStream = CtsPrettyPrinterIntegrationTestBase.class
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

	protected void initSyntax(String languageName) {
		// assumes that mapping exists in fixtures
		assertNotNull(connection);

		this.languageName = languageName;

		syntax = TcsUtil.getSyntaxByName(connection, languageName);

		assertNotNull(syntax);
	}

}
