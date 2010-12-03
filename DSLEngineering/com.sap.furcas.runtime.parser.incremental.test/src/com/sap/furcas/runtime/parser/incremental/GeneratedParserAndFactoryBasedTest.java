package com.sap.furcas.runtime.parser.incremental;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.textblocks.TextBlocksAwareModelAdapter;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;

public abstract class GeneratedParserAndFactoryBasedTest extends
		GeneratedParserBasedTest {

	protected static ParserGenerationTestHelper generationHelper;

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

	public static IncrementalParserFacade getIncrementalFacade(String language,
			ResourceSet rs, EditingDomain editingDomain, OppositeEndFinder oppositeEndFinder, Set<URI> resourcesForLookup) throws InvalidParserImplementationException,
			InstantiationException, IllegalAccessException {

		if (generationHelper == null) {
			return null;
		}

		Class<AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>> parserFactoryClass = generationHelper
				.getParserFactoryClass(language);

		AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = parserFactoryClass
				.newInstance();

		EPackage metamodelPackage = parserFactory.getMetamodelPackage(rs);

		IncrementalParserFacade facade = createFacade(parserFactory,
				metamodelPackage, rs, resourcesForLookup, editingDomain, oppositeEndFinder);
		return facade;
	}

	public static IncrementalParserFacade createFacade(
			AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory,
			EPackage metamodelPackage, ResourceSet rs,
			Set<URI> resourcesForLookup, EditingDomain editingDomain,
			OppositeEndFinder oppositeEndFinder) {
		return new IncrementalParserFacade(parserFactory,
				new TextBlocksAwareModelAdapter(new EMFModelAdapter(
						metamodelPackage, rs, resourcesForLookup)),
				editingDomain, resourcesForLookup, oppositeEndFinder);
	}
}
