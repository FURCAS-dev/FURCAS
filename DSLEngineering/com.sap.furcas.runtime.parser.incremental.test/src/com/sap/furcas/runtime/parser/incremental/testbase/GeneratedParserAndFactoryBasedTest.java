package com.sap.furcas.runtime.parser.incremental.testbase;

import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.common.exceptions.ParserInstantiationException;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandler;
import com.sap.furcas.runtime.parser.testbase.ClassLookup;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

/**
 * A Test base class that allows to generate a language specific parser and parserfactory from a given TCS file.
 * 
 * The base class is configured (what to create, where to create it, ...) with the help
 * {@link GeneratedParserAndFactoryTestConfiguration}.
 * 
 * @author Stephan Erb
 * 
 */
public abstract class GeneratedParserAndFactoryBasedTest extends GeneratedParserBasedTest {

    protected static IncrementalParserFacade generateParserAndParserFactoryForLanguage(TCSSyntaxContainerBean syntaxBean,
            GeneratedParserAndFactoryTestConfiguration testConfig, ResourceSet resourceSet,
            PartitionAssignmentHandler partitionAssignmentHandler,
            ClassLookup classLookup) throws GrammarGenerationException, ParserGeneratorInvocationException, InstantiationException, IllegalAccessException, ParserInstantiationException {

        ParserAndFactoryGenerator generator = new ParserAndFactoryGenerator(testConfig);
        try {
            System.out.println(""); // spacing to make our generation report easier to spot.
            generator.generateGrammar(syntaxBean);
            System.out.println(""); // spacing to make our generation report easier to spot.
            generator.generateParser();
            generator.generateParserFactory(syntaxBean);
            generator.compileParser();
            generator.compileParserFactory();

            return generator.loadIncrementalParserFacade(classLookup, resourceSet, partitionAssignmentHandler);
        } finally {
            generator.cleanUp();
        }
    }
}
 