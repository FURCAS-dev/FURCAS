package com.sap.furcas.ide.editor.contentassist.processor;

import java.io.File;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

import com.sap.furcas.ide.editor.test.utils.ClassLookupImpl;
import com.sap.furcas.ide.editor.test.utils.StringReplacement;
import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.common.exceptions.ParserInstantiationException;
import com.sap.furcas.runtime.common.exceptions.ParserInvokationException;
import com.sap.furcas.runtime.parser.incremental.testbase.GeneratedParserAndFactoryTestConfiguration;
import com.sap.furcas.runtime.parser.incremental.testbase.MockPartitionAssignmentHandler;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

public abstract class CtsContentAssistProcessorEditorTestMetamodelTestBase extends CtsContentAssistProcessorTestBase {

    private static final File[] METAMODELS = { new File("model/EditorTestMetamodel.ecore") };
    private static IncrementalParserFacade incrementalParserFacade;
    private static Resource transientParsingResource;

    protected static void initMetamodelTestbase(String language) throws GrammarGenerationException,
            ParserGeneratorInvocationException, ParserInstantiationException, InstantiationException, IllegalAccessException,
            ParserInvokationException {

        File tcs = new File("src/com/sap/furcas/ide/editor/contentassist/fixtures/syntax/" + language + ".tcs");
        GeneratedParserAndFactoryTestConfiguration testConfig = new GeneratedParserAndFactoryTestConfiguration(
                language, tcs, METAMODELS);

        ResourceSet resourceSet = testConfig.getSourceConfiguration().getResourceSet();

        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        transientParsingResource = ResourceTestHelper.createTransientResource(resourceSet);

        incrementalParserFacade = generateParserAndParserFactoryForLanguage(syntaxBean, testConfig, resourceSet,
                new MockPartitionAssignmentHandler(transientParsingResource), new ClassLookupImpl());

        ECrossReferenceAdapter crossRefAdapter = new ECrossReferenceAdapter();
        resourceSet.eAdapters().add(crossRefAdapter);
        crossRefAdapter.setTarget(resourceSet);

    }

    protected void initProcessorForPrefix(String prefix, StringReplacement postFixtureParseReplacement)
            throws ParserInstantiationException, SemanticParserException {

        initProcessorForFixture(prefix + "." + incrementalParserFacade.getParserFactory().getLanguageId(),
                postFixtureParseReplacement, incrementalParserFacade);
    }

    protected void initProcessorForPrefix(String prefix) throws ParserInstantiationException, SemanticParserException {

        initProcessorForPrefix(prefix, null);
    }
}
