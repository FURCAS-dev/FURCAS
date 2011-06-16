/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.runtime.parser.incremental.testbase;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.junit.Before;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.runtime.parser.incremental.ClassLookupImpl;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.furcas.runtime.textblocks.testutils.EMFTextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;
import com.sap.furcas.runtime.textblocks.testutils.TextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;
import com.sap.furcas.test.testutils.ResourceTestHelper;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException.Component;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;


public abstract class IncrementalParserBasedTest extends GeneratedParserAndFactoryBasedTest {

    protected static IncrementalParserFacade incrementalParserFacade;
    
    protected static Resource transientParsingResource;
    protected static ResourceSet resourceSet;
    
    protected TextBlocksModel model;
    
    protected static void setupParser(String languageName, File syntaxDefFile, File... metamodels) throws Exception {
        GeneratedParserAndFactoryTestConfiguration testConfig = new GeneratedParserAndFactoryTestConfiguration(languageName, syntaxDefFile, metamodels);

        resourceSet = testConfig.getSourceConfiguration().getResourceSet();
        
        TCSSyntaxContainerBean syntaxBean = parseSyntax(testConfig);
        transientParsingResource = ResourceTestHelper.createTransientResource(resourceSet);
        
        incrementalParserFacade = generateParserAndParserFactoryForLanguage(syntaxBean, testConfig,
                resourceSet, new MockPartitionAssignmentHandler(transientParsingResource), new ClassLookupImpl());
        
        ECrossReferenceAdapter crossRefAdapter = new ECrossReferenceAdapter();
        resourceSet.eAdapters().add(crossRefAdapter);
        crossRefAdapter.setTarget(resourceSet);
    }
    
    @Before
    public void setupTextBlocksModel() throws Exception {
        TextBlocksModelElementFactory  modelFactory = new EMFTextBlocksModelElementFactory();
        AbstractToken emptyToken = modelFactory.createToken("");
        TextBlock rootBlock = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, emptyToken);
        model = new TextBlocksModel(rootBlock);
    }
    
    /**
     * Parses with best effort. Use TB Version to descide whether parsing was successful.
     * This method is modeled after the implementation of the editor ParseCommand.
     */
    protected TextBlock triggerParser() {
        TextBlock blockWithUnparsedEdits = TbVersionUtil.getOtherVersion(model.getRoot(), Version.PREVIOUS);
        if (blockWithUnparsedEdits == null) {
            return model.getRoot();
        }
        String preParseContent = model.get(0, model.getLength());
        TextBlock resultBlock = null;
        try {
            TextBlock newBlock = incrementalParserFacade.parseIncrementally(blockWithUnparsedEdits);
            // Both lexing and parsing were successfull. Make a new REFERENCE version.
            resultBlock = (TextBlock) TbChangeUtil.cleanUp(newBlock);
            model.setRootTextBlock(resultBlock);
            
        } catch (SemanticParserException e) {
            if (e.getComponentThatFailed() == Component.LEXICAL_ANALYSIS) {
                resultBlock = TbVersionUtil.getOtherVersion(model.getRoot(), Version.PREVIOUS);
            } else {
                resultBlock = TbVersionUtil.getOtherVersion(model.getRoot(), Version.CURRENT);
            }
        } catch (RuntimeException e) {
            throw e;
        }
        String postParseContent = model.get(0, model.getLength());
        assertEquals("Textual representation must not be changed", preParseContent, postParseContent);
        
        TbValidationUtil.assertTextBlockConsistencyRecursive(resultBlock);
        TbValidationUtil.assertCacheIsUpToDate(resultBlock);
        return resultBlock;
    }
    
    
}
