package com.sap.furcas.test.parsing.base;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.AfterClass;

import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.ObservationDirectivesHelper;
import com.sap.furcas.runtime.common.exceptions.GrammarGenerationException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;

public class GeneratedParserBasedTest {

//    protected static String language;
    protected static IMetaModelLookup<?> lookup;
    protected static ParserGenerationTestHelper generationHelper;

    public static void setParserGenerationTestHelper(ParserGenerationTestHelper helper) {
	generationHelper = helper;
    }

    public static void setLookup(IMetaModelLookup<?> modelLookup) {
	lookup = modelLookup;
    }

    public static void generateParserForLanguage(String language) throws FileNotFoundException, GrammarGenerationException,
	    ModelAdapterException, IOException {
	assertNotNull(language);
	assertNotNull(generationHelper);
//	GeneratedParserBasedTest.language = language;

	ObservationDirectivesHelper.doAddObserverParts = ObservationDirectivesHelper.ALL;

//	Set<URI> priList = MOINTCSMetaConnectionProvider.getPartitionsOfMetamodel(metamodelId);

	assertNotNull(lookup);
//	if (lookup == null) {
//	    lookup = new EcoreMetaModelLookUp(priList);
//	}

	// FIXME: crude hack. Where should this happen?
        ResourceSet resourceSet =  new ResourceSetImpl();
	resourceSet.getPackageRegistry().put(TextblocksPackage.eNS_URI, TextblocksPackage.eINSTANCE);
	resourceSet.getPackageRegistry().put(TextblocksPackage.eNAME, TextblocksPackage.eINSTANCE);
	resourceSet.getPackageRegistry().put(TextblockdefinitionPackage.eNS_URI, TextblockdefinitionPackage.eINSTANCE);
	resourceSet.getPackageRegistry().put(TextblockdefinitionPackage.eNAME, TextblockdefinitionPackage.eINSTANCE);
	resourceSet.getPackageRegistry().put(TCSPackage.eNS_URI, TCSPackage.eINSTANCE);
	resourceSet.getPackageRegistry().put(TCSPackage.eNAME, TCSPackage.eINSTANCE);
	
	generateParser(language, lookup, resourceSet, /*priList*/ null);
    }

    private static void generateParser(String language, IMetaModelLookup<?> lookup, ResourceSet connection, Set<URI> partitions) throws FileNotFoundException, GrammarGenerationException, ModelAdapterException, IOException {
	
	generationHelper.generateParserGrammar(language, lookup, connection, partitions);
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
	    fail("Parser compilation failed with code '" + success + "'. Messages: \n" + errByteStream.toString());
	}

	// restore the original value
	System.setErr(systemErr);
    }

//    public static String getLanguage() {
//	return language;
//    }

//    public static ParserFacade getFacade() throws InvalidParserImplementationException {
//	if (generationHelper != null) {
//	    return generationHelper.getFacade(language);
//	}
//	return null;
//    }

    @AfterClass
    public static void teardown() {
	if (generationHelper != null) {
	    // delete generated Files
	    File genDir = generationHelper.getGenerationDir();
	    assertTrue(genDir.getAbsolutePath() + " is not a directory", genDir.isDirectory());
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
