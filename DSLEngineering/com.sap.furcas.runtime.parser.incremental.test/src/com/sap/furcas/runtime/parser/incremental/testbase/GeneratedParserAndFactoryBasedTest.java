package com.sap.furcas.runtime.parser.incremental.testbase;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.parser.testbase.ClassLookup;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.ide.cts.parser.incremental.PartitionAssignmentHandler;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;

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
            GeneratedParserAndFactoryTestConfiguration testConfig, EditingDomain editingDomain, OppositeEndFinder oppositeEndFinder,
            PartitionAssignmentHandler partitionAssignmentHandler,
            ClassLookup classLookup) throws GrammarGenerationException, ParserGeneratorInvocationException, InstantiationException, IllegalAccessException {

        ParserAndFactoryGenerator generator = new ParserAndFactoryGenerator(testConfig);
        try {
            generator.generateGrammar(syntaxBean);
            generator.generateParser();
            generator.generateParserFactory();
            generator.compileParser();
            generator.compileParserFactory();

            return generator.loadIncrementalParserFacade(classLookup, editingDomain, oppositeEndFinder, partitionAssignmentHandler);
        } finally {
            generator.cleanUp();
        }
    }
}
 