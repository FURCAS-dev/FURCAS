package com.sap.ide.cts.editor.contentassist.processor;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.ide.cts.editor.test.util.StringReplacement;

public abstract class CtsContentAssistProcessorEditorTestMetamodelTestBase
		extends CtsContentAssistProcessorTestBase {

	protected static void initMetamodelTestbase(String language)
			throws FileNotFoundException, GrammarGenerationException,
			ModelAdapterException, IOException {
		initMetamodelId("sap.com/moin/mm/editor.test.metamodel");
		generateParserForLanguage(language);
		generateParserFactoryForLanguage(language, "test.TestPackage",
				"editor.test.metamodel.epi");
	}

	protected void initProcessorForPrefix(String prefix,
			StringReplacement postFixtureParseReplacement) throws IOException,
			UnknownProductionRuleException,
			InvalidParserImplementationException, InstantiationException,
			IllegalAccessException {
		initProcessorForFixture(prefix + "." + getLanguage(),
				postFixtureParseReplacement,
				CtsContentAssistProcessorTestBase.class
						.getResourceAsStream("../fixtures/syntax/"
								+ getLanguage() + ".tcs"));
	}

	protected void initProcessorForPrefix(String prefix) throws IOException,
			UnknownProductionRuleException,
			InvalidParserImplementationException, InstantiationException,
			IllegalAccessException {
		initProcessorForPrefix(prefix, null);
	}
}
