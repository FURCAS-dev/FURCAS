package com.sap.ide.cts.parser.incremental;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import tcs.Block;
import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.LiteralRef;
import tcs.PrimitiveTemplate;
import tcs.TcsPackage;
import tcs.Template;
import textblocks.AbstractToken;
import textblocks.TextBlock;

import com.sap.ide.cts.editor.test.util.TcsTestHelper;
import com.sap.ide.cts.editor.test.util.TestSourceTextBlockCreator;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;
import com.sap.mi.tcs.parser.TcsParserFactory;
import com.sap.mi.textual.grammar.IModelAdapter;
import com.sap.mi.textual.moin.standalone.MOINTCSMetaConnectionProvider;
import com.sap.mi.textual.parsing.textblocks.TbChangeUtil;
import com.sap.mi.textual.parsing.textblocks.TextBlockTest;
import com.sap.mi.textual.parsing.textblocks.TextBlocksAwareModelAdapter;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.textual.moinadapter.adapter.MOINModelAdapter;

public class TestIncrementalParser extends TextBlockTest {

	public void testContextReconstruction() {
		// TODO write testCase for reconsrtuction of context while
		// parsing incrementally
	}

	/**
	 * Tests whether an simple addition to a textblock is correctly mapped to an
	 * insertion in the model without re-creating the parent element.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testParseBibTextAddNewSubBlock() throws Exception {
		//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);

		IncrementalParserFacade facade = getParserFacade();
		File syntaxDefFile = new File("scenariotestResource/Bibtext.tcs");

		AbstractToken content = createToken("");
		TextBlock root = TestSourceTextBlockCreator
				.initialiseTextBlocksWithContentToken(modelFactory, content);

		TextBlocksModel tbModel = new TextBlocksModel(root, null);
		tbModel.replace(0, 0, getTcsFileContent(syntaxDefFile));

		TextBlock currentVersionTb = facade.parseIncrementally(root);
		Object syntaxObject = currentVersionTb.getCorrespondingModelElements()
				.iterator().next();
		// assert no exception
		assertNotNull(syntaxObject);
		ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
		assertEquals("Bibtext", syntax.getName());
		assertEquals(7, syntax.getTemplates().size());

		assertNotNull(currentVersionTb); // future version
		assertEquals(88, currentVersionTb.getSubNodes().size());

		TbChangeUtil.cleanUp(currentVersionTb);
		// add a new template
		tbModel = new TextBlocksModel(currentVersionTb, null);
		tbModel
				.replace(26, 0,
						"primitiveTemplate identifier2 for ->String using NAME:value = \"%token%\";");
		TextBlock currentVersionTbNew = facade
				.parseIncrementally(currentVersionTb);
		// textBlock shouldn't have changed
		assertEquals(currentVersionTb, currentVersionTb);
		ConcreteSyntax syntaxObject2 = (ConcreteSyntax) currentVersionTbNew
				.getCorrespondingModelElements().iterator().next();

		// syntax element shouldn't have changed
		assertEquals(syntaxObject, syntaxObject2);

		// check if primitive template was added
		Template newTemplate = syntaxObject2.getTemplates().get(0);
		assertEquals(true, newTemplate instanceof PrimitiveTemplate);
		assertEquals("identifier2", ((PrimitiveTemplate) newTemplate)
				.getTemplateName());
	}

	/**
	 * Tests whether a reference where the reference by value was replaced is
	 * correctly set to thw new value;
	 * 
	 * @throws Exception
	 */
	@Test
	public void testParseBibTextReplaceReference() throws Exception {
		//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
		
		IncrementalParserFacade facade = getParserFacade();
		File syntaxDefFile = new File("scenariotestResource/Bibtext.tcs");

		AbstractToken content = createToken("");
		TextBlock root = TestSourceTextBlockCreator
				.initialiseTextBlocksWithContentToken(modelFactory, content);

		TextBlocksModel tbModel = new TextBlocksModel(root, null);
		tbModel.replace(0, 0, getTcsFileContent(syntaxDefFile));

		TextBlock currentVersionTb = facade.parseIncrementally(root);
		ConcreteSyntax syntaxObject = (ConcreteSyntax) currentVersionTb
				.getCorrespondingModelElements().iterator().next();
		// assert no exception
		assertNotNull(syntaxObject);
		ConcreteSyntax syntax = syntaxObject;
		assertEquals("Bibtext", syntax.getName());
		assertEquals(7, syntax.getTemplates().size());

		Template article = syntaxObject.getTemplates().get(3);

		assertNotNull(currentVersionTb); // future version
		assertEquals(88, currentVersionTb.getSubNodes().size());

		TbChangeUtil.cleanUp(currentVersionTb);
		// replace a reference that referred to the "." token with one that
		// refers to the "{" token
		tbModel = new TextBlocksModel(currentVersionTb, null);
		tbModel.replace(423, 1, "{");
		TextBlock currentVersionTbNew = facade
				.parseIncrementally(currentVersionTb);
		// textBlock shouldn't have changed
		assertEquals(currentVersionTb, currentVersionTb);
		ConcreteSyntax syntaxObject2 = (ConcreteSyntax) currentVersionTbNew
				.getCorrespondingModelElements().iterator().next();

		// syntax element shouldn't have changed
		assertEquals(syntaxObject, syntaxObject2);

		ClassTemplate article2 = (ClassTemplate) syntaxObject2.getTemplates()
				.get(3);
		assertEquals(article, article2);
		Block b = (Block) article2.getTemplateSequence().getElements().get(2);
		LiteralRef lit = (LiteralRef) b.getBlockSequence().getElements().get(3);
		assertEquals("{", lit.getReferredLiteral().getValue());
	}

	/**
	 * @return
	 */
	private IncrementalParserFacade getParserFacade() {
		TcsPackage tcsPackage = connection
				.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
		Collection<PRI> priList = new ArrayList<PRI>();
		Moin moin = MOINTCSMetaConnectionProvider.getBuildMoin();
		PRI pri1 = moin
				.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm");
		PRI pri2 = moin
				.createPri("PF.MetaModelDataArea:DCs/demo.sap.com/tcsmeta/_comp/moin/meta/Metamodel.moinmm");
		PRI pri3 = moin
				.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm");
		PRI pri4 = moin
				.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/MOIN.moinmm");
		priList.add(pri1);
		priList.add(pri2);
		priList.add(pri3);
		priList.add(pri4);

		IModelAdapter adapter = new TextBlocksAwareModelAdapter(
				new MOINModelAdapter(tcsPackage, connection, priList, null));
		IncrementalParserFacade facade = new IncrementalParserFacade(
				new TcsParserFactory(), adapter, connection, null);

		return facade;
	}

	private String getTcsFileContent(File syntaxDefFile) {
		String content = null;
		if (syntaxDefFile != null) {
			try {
				FileInputStream inputStream = new FileInputStream(syntaxDefFile);
				StringBuilder out = new StringBuilder();
				byte[] b = new byte[4096];
				for (int n; (n = inputStream.read(b)) != -1;) {
					out.append(new String(b, 0, n));
				}
				content = out.toString();
				inputStream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return content;
	}
}
