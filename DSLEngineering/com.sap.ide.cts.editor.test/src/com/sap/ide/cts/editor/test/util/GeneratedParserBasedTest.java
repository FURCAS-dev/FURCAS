package com.sap.ide.cts.editor.test.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

import org.junit.AfterClass;

import com.sap.furcas.textual.common.exceptions.GrammarGenerationException;
import com.sap.furcas.textual.common.exceptions.ModelAdapterException;
import com.sap.furcas.textual.common.interfaces.IMetaModelLookup;
import com.sap.mi.textual.grammar.ParserFacade;
import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.ObservationDirectivesHelper;
import com.sap.mi.textual.moin.standalone.MOINTCSMetaConnectionProvider;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;

public class GeneratedParserBasedTest extends ConcreteSyntaxBasedTest {

	protected static String language;
	private static IMetaModelLookup<?> lookup;

	protected static ParserGenerationTestHelper generationHelper;

	public static void setParserGenerationTestHelper(
			ParserGenerationTestHelper helper) {
		generationHelper = helper;
	}

	public static void setLookup(IMetaModelLookup<?> modelLookup) {
		lookup = modelLookup;
	}

	public static void generateParserForLanguage(String language)
			throws FileNotFoundException, GrammarGenerationException,
			ModelAdapterException, IOException {
		assertNotNull(language);
		assertNotNull(generationHelper);
		GeneratedParserBasedTest.language = language;

		ObservationDirectivesHelper.doAddObserverParts = ObservationDirectivesHelper.ALL;

		Set<PRI> priList = MOINTCSMetaConnectionProvider
				.getPartitionsOfMetamodel(metamodelId);

		if (lookup == null) {
			lookup = new StandaloneMoinLookUp(connection, priList);
		}
		generateParser(language, lookup, connection, priList);
	}

	private static void generateParser(String language,
			IMetaModelLookup<?> lookup, Connection connection,
			Set<PRI> partitions) throws FileNotFoundException,
			ModelAdapterException, GrammarGenerationException, IOException {
		generationHelper.generateParserGrammar(language, lookup, connection,
				partitions);
		generateAndCompileParser(language);
	}

	protected static void generateAndCompileParser(String languageName) {

		// Hold on to the original value
		PrintStream systemErr = System.err;

		// redirect Std.err to be able to check it for errors
		ByteArrayOutputStream errByteStream = new ByteArrayOutputStream();

		System.setErr(new PrintStream(errByteStream));

		generationHelper.generateParserClasses(languageName);
		// if antlr wrote to System.err, fail the test with ANTLR messages. If
		// err is empty, continue
		String errString = errByteStream.toString().trim();
		if (!"".equals(errString)) {
			if (errString.toLowerCase().indexOf("error") > -1) { // ignore
				// warnings
				// written
				// to
				// System.err
				fail(errString);
			} else {
				System.out.println(errString);
				errByteStream.reset(); // discarding warnings from stream, so
				// that error only shows errors
			}
		}

		// compile generated Java
		int success = generationHelper.compileParser(languageName);
		if (success != 0) {
			systemErr.println(errByteStream.toString());
			fail("Parser compilation failed with code '" + success
					+ "'. Messages: \n" + errByteStream.toString());
		}

		// restore the original value
		System.setErr(systemErr);
	}

	public static String getLanguage() {
		return language;
	}

	public static ParserFacade getFacade()
			throws InvalidParserImplementationException {
		if (generationHelper != null) {
			return generationHelper.getFacade(language);
		}

		return null;
	}

	@AfterClass
	public static void teardown() {

		if (generationHelper != null) {
			// delete generated Files
			File genDir = generationHelper.getGenerationDir();
			assertTrue(genDir.getAbsolutePath() + " is not a directory", genDir
					.isDirectory());
			File[] files = genDir.listFiles();
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				if (file.getName().endsWith(".class")) { // keeping grammars for
					// lookup
					file.delete();

				}
			}
		}
	}

}
