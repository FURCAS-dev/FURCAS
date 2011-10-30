package com.sap.furcas.ide.editor.test.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.common.exceptions.ParserInstantiationException;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.incremental.testbase.GeneratedParserAndFactoryBasedTest;
import com.sap.furcas.runtime.parser.incremental.testbase.TcsTestHelper;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.furcas.runtime.textblocks.testutils.EMFTextBlocksModelElementFactory;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;
import com.sap.furcas.runtime.textblocks.testutils.TextBlocksModelElementFactory;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

public abstract class GeneratedTextblocksBasedTest extends GeneratedParserAndFactoryBasedTest {

    protected TextBlocksModel tbModel;

    public void initTbModel(InputStream contentStream, IncrementalParserFacade facade,
            StringReplacement postFixtureParseReplacement) throws SemanticParserException, ParserInstantiationException {
        
        AbstractToken content = createToken("");
        TextBlock rootBlock = initialiseTextBlocksWithContentToken(content);

        tbModel = new TextBlocksModel(rootBlock);

        String fixtureContents = TcsTestHelper.getStreamContents(contentStream);
        tbModel.replace(0, 0, fixtureContents);

        rootBlock = TbVersionUtil.getOtherVersion(rootBlock, Version.PREVIOUS);
        List<ParsingError> errorList = facade.dryParse(rootBlock);

        if (errorList.size() != 0) {
            if (!fixtureContents.equals("")) {
                // empty fixture fails to parse but should still be a valid
                // fixture
                // as a special case

                System.out.println("Error parsing fixture:");
                for (ParsingError pe : errorList) {
                    System.out.println(pe.toString());
                }
                fail("error parsing fixture");
            }
        } else {

            TextBlock result = facade.parseIncrementally(rootBlock);
            assertNotNull(result);

            // re-create tbModel
            TbChangeUtil.cleanUp(result);
            // add a new template
            tbModel = new TextBlocksModel(rootBlock);

            // add post-parse replacement
            // this is used for strings that would otherwise throw parse errors
            // if
            // contained in the fixture directly
            if (postFixtureParseReplacement != null) {
                // used to compute offset
                Document dummyDoc = new Document(fixtureContents);
                int offset = 0;
                try {
                    offset = dummyDoc.getLineOffset(postFixtureParseReplacement.getLine())
                            + postFixtureParseReplacement.getCharPositionInLine();
                } catch (BadLocationException e) {
                    fail("post-fixture-pase replacement failed");
                }
                tbModel.replace(offset, postFixtureParseReplacement.getLength(),
                        postFixtureParseReplacement.getReplacementString());
            }
        }
    }

    private static TextBlock initialiseTextBlocksWithContentToken(AbstractToken contentToken) {
        TextBlocksModelElementFactory modelFactory = new EMFTextBlocksModelElementFactory();
        return TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, contentToken);
    }

    private static LexedToken createToken(String content) {
        TextBlocksModelElementFactory modelFactory = new EMFTextBlocksModelElementFactory();
        return modelFactory.createToken(content);
    }

}
