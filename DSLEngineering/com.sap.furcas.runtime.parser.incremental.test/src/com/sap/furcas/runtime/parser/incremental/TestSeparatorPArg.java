package com.sap.furcas.runtime.parser.incremental;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Set;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.parser.tcs.scenario.ClassLookupImpl;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.parser.impl.DefaultPartitionAssignmentHandlerImpl;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.incremental.testbase.GeneratedParserAndFactoryBasedTest;
import com.sap.furcas.runtime.parser.incremental.testbase.GeneratedParserAndFactoryTestConfiguration;
import com.sap.furcas.runtime.parser.incremental.testbase.ParserAndFactoryGenerator;
import com.sap.furcas.runtime.parser.testbase.ClassLookup;
import com.sap.furcas.runtime.parser.testbase.EMFParsingHelper;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserTestConfiguration;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.testutils.EMFTextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;
import com.sap.furcas.test.fixture.FeatureFixtureData;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

/**
 * A test for the use of the separator PArg..
 * 
 * @author Thomas Goldschmidt
 */
public class TestSeparatorPArg extends GeneratedParserAndFactoryBasedTest {

    private static final String LANGUAGE = "SeparatorFeatureTestSyntax";
    private static final File TCS = FeatureFixtureData.PARG_SEPARATOR_TCS;
    private static final File METAMODEL = FeatureFixtureData.PARG_SEPARATOR_METAMODEL;
    private static final String PACKAGE_URI = FeatureFixtureData.PARG_SEPARATOR_PACKAGE_URI;

    private static EMFParsingHelper parsingHelper;
	private static ResourceSet resourceSet;
	private static ConcreteSyntax syntax;
	private static IncrementalParserFacade incrementalParserFacade;
    

    @BeforeClass
    public static void setupParser() throws Exception {
    	GeneratedParserAndFactoryTestConfiguration testConfig = 
    		new GeneratedParserAndFactoryTestConfiguration(LANGUAGE, TCS, METAMODEL);
        resourceSet = testConfig.getSourceConfiguration().getResourceSet();
        Set<URI> referenceScope = testConfig.getSourceConfiguration().getReferenceScope();
        
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        syntax = syntaxBean.getSyntax();
        incrementalParserFacade = generateParserAndParserFactoryForLanguage(syntaxBean, testConfig,
                resourceSet, new DefaultPartitionAssignmentHandlerImpl(), new ClassLookup() {

					@Override
					public Class<?> loadClass(String className)
							throws ClassNotFoundException {
						return Class.forName(className);
					}});
    }

	private EObject rootElement;
	private EMFTextBlocksModelElementFactory modelFactory;
	private Resource transientParsingResource;
	private TextBlock rootTextBlock;
    
    /**
     * The sequence elements of the separator and the property for which the separator is defined
     * should be correctly set.  
     */
    @Test
    public void testSeparatorSequenceElements() throws Exception {
        setupModelFromTextToParse(
        		"PropertyArgument_Separator.sam", FeatureFixtureData.EXAMPLE_FOLDER);
        
        // 
        Collection<?> usages = (Collection<?>) rootElement.eGet(rootElement.eClass().getEStructuralFeature("usages"));
        for (Object object : usages) {
            EObject usage = (EObject) object;
            assertTrue(usage.eIsSet(usage.eClass().getEStructuralFeature("name")));
        }
        //Make sure sequence elements where correctly set. 
        assertTrue(rootTextBlock != null);
        assertTrue(rootTextBlock.getType() != null);
        
        for (DocumentNode dn : rootTextBlock.getSubNodes()) {
			if(dn instanceof TextBlock) {
				assertTrue(dn.getSequenceElement() instanceof Property);
			} else if(dn instanceof LexedToken && ((LexedToken)dn).getValue().equals(",")) {
				assertTrue(dn.getSequenceElement() instanceof LiteralRef);
			}
		}
    }
    
    protected void setupModelFromTextToParse(String textToParse, String sampleDir) throws SemanticParserException, IOException {
        rootElement = parseFile(textToParse, sampleDir);
    }

    protected EObject parseFile(String dslSampleFile, String sampleDir) throws SemanticParserException, IOException {
    	InputStream in = new FileInputStream(new File(sampleDir + dslSampleFile));
    	InputStreamReader isr = new InputStreamReader(in);
        Reader reader = new BufferedReader(isr);
        StringBuilder s = new StringBuilder();
        char buffer[] = new char[2048];
        int size;
        while((size = reader.read(buffer)) > 0) {
            s.append(buffer, 0, size);
        }
    	
        modelFactory = new EMFTextBlocksModelElementFactory();
        transientParsingResource = ResourceTestHelper.createTransientResource(resourceSet);
        AbstractToken content = modelFactory.createToken("");
        rootTextBlock = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, content);
        transientParsingResource.getContents().add(rootTextBlock);
        TextBlocksModel tbModel = new TextBlocksModel(rootTextBlock);
        tbModel.replace(0, 0, s.toString());
        TextBlock currentVersionTb = incrementalParserFacade.parseIncrementally(rootTextBlock);
        rootTextBlock = (TextBlock) TbChangeUtil.cleanUp(currentVersionTb);
        EObject result = currentVersionTb.getCorrespondingModelElements().iterator().next();
        return result;
    }
    
}
