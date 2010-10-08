package com.sap.ide.cts.editor.test.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.ecore.EPackage;

import com.sap.furcas.parsergenerator.moin.standalone.MOINTCSMetaConnectionProvider;
import com.sap.furcas.parsing.textblocks.TextBlocksAwareModelAdapter;
import com.sap.furcas.runtime.common.exceptions.GrammarGenerationException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;

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

		EPackage metamodelPackage = parserFactory
				.getMetamodelPackage(connection);

		IncrementalParserFacade facade = createFacade(parserFactory,
				metamodelPackage);
		return facade;
	}

	public static IncrementalParserFacade createFacade(
			AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory,
			EPackage metamodelPackage) {
		return new IncrementalParserFacade(parserFactory,
				new TextBlocksAwareModelAdapter(new MOINModelAdapter(
						metamodelPackage, connection,
						MOINTCSMetaConnectionProvider
								.getPartitionsOfMetamodel(metamodelId), null)),
				connection, null);
	}
}
