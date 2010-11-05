package com.sap.furcas.parsergenerator.base;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.AfterClass;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;
import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.ObservationDirectivesHelper;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;


/**
 * Parser generation test base class. Allows to generate arbitrary parsers.
 *
 */
public class GeneratedParserBasedTest {

    private static IMetaModelLookup<?> lookup;
    private static ParserGenerationTestHelper generationHelper;
    
    
    public static void setParserGenerationTestHelper(ParserGenerationTestHelper helper) {
	generationHelper = helper;
    }
    
    public static ParserGenerationTestHelper getParserGenerationTestHelper() {
        return generationHelper;
    }

    public static void setLookup(IMetaModelLookup<?> modelLookup) {
	lookup = modelLookup;
    }

    public static void generateParserForLanguage(String language) throws FileNotFoundException, GrammarGenerationException,
	    ModelAdapterException, IOException {

        assertNotNull(generationHelper);
	assertNotNull(lookup);

	ObservationDirectivesHelper.doAddObserverParts = ObservationDirectivesHelper.ALL;

	ResourceSet resourceSet = createDefaultResourceSet();
	Set<URI> referenceScope = createDefaultReferenceScope();
	
	generateParser(language, resourceSet, referenceScope);
    }

    protected static Set<URI> createDefaultReferenceScope() {
        Set<URI> referenceScope = Collections.emptySet();
        return referenceScope;
    }

    protected static ResourceSet createDefaultResourceSet() {
        ResourceSet resourceSet =  new ResourceSetImpl();
        resourceSet.getPackageRegistry().put(FURCASPackage.eNS_URI, FURCASPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(FURCASPackage.eNAME, FURCASPackage.eINSTANCE);
        return resourceSet;
    }

    private static void generateParser(String language, ResourceSet resourceSet, Set<URI> referenceScope) throws FileNotFoundException, GrammarGenerationException, ModelAdapterException, IOException {
	generationHelper.generateParserGrammar(language, lookup, resourceSet, referenceScope);
	generateAndCompileParser(language);
    }

    private static void generateAndCompileParser(String languageName) {
	// Hold on to the original value
	PrintStream systemErr = System.err;
	// redirect Std.err to be able to check it for errors
	ByteArrayOutputStream errByteStream = new ByteArrayOutputStream();
	System.setErr(new PrintStream(errByteStream));

	generationHelper.generateParserClasses(languageName);
	checkSystemErrForErros(errByteStream);
	
	// compile generated Java
	int success = generationHelper.compileParser(languageName);
	if (success != 0) {
	    systemErr.println(errByteStream.toString());
	    fail("Parser compilation failed with code '" + success + "'. Messages: \n" + errByteStream.toString());
	}

	// restore the original value
	System.setErr(systemErr);
    }
    
    /**
     * If antlr wrote to System.err, fail the test with ANTLR messages. If err is empty, continue
     */
    private static void checkSystemErrForErros(ByteArrayOutputStream errByteStream) {
        String errString = errByteStream.toString().trim();
        if (!"".equals(errString)) {
            if (errString.toLowerCase().indexOf("error") > -1) { // ignore
        	// warnings written to System.err
        	fail(errString);
            } else {
        	System.out.println(errString);
        	errByteStream.reset(); // discarding warnings from stream, so
        	// that error only shows errors
            }
        }
    }

    
    @AfterClass
    public static void teardown() {
	if (generationHelper != null) {
	    // delete generated Files
	    File genDir = generationHelper.getGenerationDir();
	    assertTrue(genDir.getAbsolutePath() + " is not a directory", genDir.isDirectory());
	    File[] files = genDir.listFiles();
	    for (File file : files) {
		if (file.getName().endsWith(".class")) { // keeping grammars for
		    // lookup
		    file.delete();
		}
	    }
	}
	lookup = null;
	generationHelper = null;
    }

}
