package com.sap.furcas.referenceresolving.tests;

import java.io.File;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.incremental.testbase.IncrementalParserBasedTest;
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
        
    /**
     * Call from a @BeforeClass operation in your subclass
     * @param LANGUAGE
     *            name of the language; should conform to the name of the language as specified in the mapping
     *            definition file
     * @param TCS
     *            the .tcs file containing the mapping definition
     */
    public static void setupParser(String LANGUAGE, File TCS, File... METAMODELS) throws Exception {
        setupParser(LANGUAGE, TCS, new ClassLookupImpl(), /*useModelUpdaters*/ true, METAMODELS);
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
        
        ParsingResult result = triggerParser();
        // FIXME The following statements are required due to a bug in
        // the event managers EventAdapter (overriding addAdapter() breaks its protocol).
        // Re-Registering ensures that each model element has correctly set an adapter
        // to be notified.
        syntaxRegistry.unregisterAllLoadedSyntaxesTriggerManagers(resourceSet);
        syntaxRegistry.registerAllLoadedSyntaxesTriggerManagers(resourceSet);
        
        return result;
    }
    
}
