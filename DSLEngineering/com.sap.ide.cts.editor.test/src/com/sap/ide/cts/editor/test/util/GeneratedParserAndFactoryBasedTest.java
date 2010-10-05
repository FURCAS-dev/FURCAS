package com.sap.ide.cts.editor.test.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.runtime.Lexer;

import com.sap.furcas.textual.common.exceptions.GrammarGenerationException;
import com.sap.furcas.textual.common.exceptions.ModelAdapterException;
import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;
import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.moin.standalone.MOINTCSMetaConnectionProvider;
import com.sap.mi.textual.parsing.textblocks.TextBlocksAwareModelAdapter;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.textual.moinadapter.adapter.MOINModelAdapter;

public class GeneratedParserAndFactoryBasedTest extends
		GeneratedParserBasedTest {

	public static void generateParserFactoryForLanguage(String language,
			String completeMetamodelPackageName, String metamodelProjectName)
			throws FileNotFoundException, GrammarGenerationException,
			ModelAdapterException, IOException {
		assertNotNull(language);
		assertNotNull(completeMetamodelPackageName);
		assertNotNull(metamodelProjectName);
		assertNotNull(generationHelper);

		generationHelper.generateParserFactoryClasses(language,
				completeMetamodelPackageName);
		int success = generationHelper.compileParserFactory(language,
				metamodelProjectName);
		if (success != 0) {
			fail("ParserFactory compilation failed with code '" + success);
		}
	}

	public static IncrementalParserFacade getIncrementalFacade()
			throws InvalidParserImplementationException,
			InstantiationException, IllegalAccessException {

		if (generationHelper == null) {
			return null;
		}

		Class<AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>> parserFactoryClass = generationHelper
				.getParserFactoryClass(language);

		AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = parserFactoryClass
				.newInstance();

		RefPackage metamodelPackage = parserFactory
				.getMetamodelPackage(connection);

		IncrementalParserFacade facade = createFacade(parserFactory,
				metamodelPackage);
		return facade;
	}

	public static IncrementalParserFacade createFacade(
			AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory,
			RefPackage metamodelPackage) {
		return new IncrementalParserFacade(parserFactory,
				new TextBlocksAwareModelAdapter(new MOINModelAdapter(
						metamodelPackage, connection,
						MOINTCSMetaConnectionProvider
								.getPartitionsOfMetamodel(metamodelId), null)),
				connection, null);
	}
}
