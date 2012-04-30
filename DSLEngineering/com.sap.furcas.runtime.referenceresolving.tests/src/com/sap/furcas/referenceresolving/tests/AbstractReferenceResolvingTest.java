package com.sap.furcas.referenceresolving.tests;

import java.io.File;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;

import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.incremental.testbase.IncrementalParserBasedTest;
import com.sap.furcas.runtime.referenceresolving.SyntaxRegistry;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;

/**
 * A test base class that use a FURCAS mapping specification (".tcs" file) and based on this produce lexer and
 * parser, then parse a text resource and register all reference resolving callbacks. 
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public abstract class AbstractReferenceResolvingTest extends IncrementalParserBasedTest {

    protected EObject rootElement;
    protected TextBlock rootTextBlock;
    
    private static SyntaxRegistry syntaxRegistry;
    protected static TriggerManager triggerManager;

    
    /**
     * Call from a @BeforeClass operation in your subclass
     * 
     * @param TCS
     *            the .tcs file containing the mapping definition
     * @param LANGUAGE
     *            name of the language; should conform to the name of the language as specified in the mapping
     *            definition file
     */
    public static void setupParser(File TCS, String LANGUAGE, File... METAMODELS) throws Exception {
        setupParser(LANGUAGE, TCS, new ClassLookupImpl(), METAMODELS);

        syntaxRegistry = SyntaxRegistry.getInstance();
        triggerManager = syntaxRegistry.getTriggerManagerForSyntax(incrementalParserFacade.getParserScope().getSyntax(), DefaultOppositeEndFinder.getInstance(),
                /* progress monitor */ null, incrementalParserFacade.getParserFactory());
        triggerManager.addToObservedResourceSets(resourceSet);
    }

    /**
     * Call from an @Before operation to parse some text into the {@link #rootElement} attribute
     * 
     * @param textToParse
     *            this text is parsed using the grammar passed to {@link #setupParser(File, String, String, File...)} as first argument.
     */
    protected void setupModelFromTextToParse(String textToParse) throws SemanticParserException {
        ParsingResult result = parseFile(textToParse);
        rootElement = result.newRoot;
        rootTextBlock = result.newResultBlock;
        
        if (model.getRoot().getVersion() != Version.REFERENCE) {
            throw new SemanticParserException(Collections.<ParsingError>emptyList(),
                    SemanticParserException.Component.SEMANTIC_ANALYSIS);
        }
    }

    private ParsingResult parseFile(String textToParse) {
        model.replace(0, model.getLength(), textToParse);
        
        triggerManager.removeFromObservedResourceSets(resourceSet);
        ParsingResult result = triggerParser();
        triggerManager.addToObservedResourceSets(resourceSet);
        
        return result;
    }
    
}
