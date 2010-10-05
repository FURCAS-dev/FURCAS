/**
 * 
 */
package com.sap.ide.cts.editor.test.parsing;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.TCS.TCSPackage;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.ide.cts.editor.test.util.TestSourceTextBlockCreator;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;
import com.sap.mi.tcs.parser.TcsParserFactory;
import com.sap.mi.textual.grammar.IModelAdapter;
import com.sap.mi.textual.moin.standalone.MOINTCSMetaConnectionProvider;
import com.sap.mi.textual.parsing.textblocks.TextBlockTest;
import com.sap.mi.textual.parsing.textblocks.TextBlocksAwareModelAdapter;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;

/**
 * 
 */
public class TestParsingObserverWithTcsSyntax extends TextBlockTest {

	@Test
	public void testParseTcsItself() throws Exception {

		IncrementalParserFacade facade = getParserFacade();
		File syntaxDefFile = new File("scenariotestResource/TCS.tcs");

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
		assertEquals("TCS", syntax.getName());
		assertEquals(80, syntax.getTemplates().size());

		assertNotNull(currentVersionTb); // future version
		assertEquals(155, currentVersionTb.getSubNodes().size());
	}

	@Test
	public void testParseBibText() throws Exception {

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
	}

	@Test
	public void testMinimalSyntax() throws Exception {

		IncrementalParserFacade facade = getParserFacade();
		String syntaxString = "syntax test{}";

		AbstractToken content = createToken("");
		TextBlock root = TestSourceTextBlockCreator
				.initialiseTextBlocksWithContentToken(modelFactory, content);

		TextBlocksModel tbModel = new TextBlocksModel(root, null);
		tbModel.replace(0, 0, syntaxString);

		TextBlock tb = facade.parseIncrementally(root);
		Object syntaxObject = tb.getCorrespondingModelElements().iterator()
				.next();
		// assert no exception
		assertNotNull(syntaxObject);
		ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
		assertEquals("test", syntax.getName());
		assertEquals(0, syntax.getTemplates().size());

	}

	@Test
	public void testMinimalSyntaxWithMain() throws Exception {

		IncrementalParserFacade facade = getParserFacade();
		String syntaxString = "syntax test{template ->Foo main :\"foo\";}";

		AbstractToken content = createToken("");
		TextBlock root = TestSourceTextBlockCreator
				.initialiseTextBlocksWithContentToken(modelFactory, content);

		TextBlocksModel tbModel = new TextBlocksModel(root, null);
		tbModel.replace(0, 0, syntaxString);

		TextBlock tb = facade.parseIncrementally(root);
		Object syntaxObject = tb.getCorrespondingModelElements().iterator()
				.next();
		// assert no exception
		assertNotNull(syntaxObject);
		ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
		assertEquals("test", syntax.getName());
		assertEquals(1, syntax.getTemplates().size());

		Template fooTemplate = syntax.getTemplates().get(0);
		assertTrue(fooTemplate instanceof ClassTemplate);
		assertEquals("Foo", fooTemplate.getNames().get(0));
	}

	@Test
	public void testMinimalSyntaxWith2PrimitiveTemps() throws Exception {

		IncrementalParserFacade facade = getParserFacade();
		String syntaxString = "syntax test{\r\n"
				+ "    primitiveTemplate identifier for ->String using NAME:value=\"%token%\";\r\n"
				+ "    primitiveTemplate name for ->String using NAME:value=\"%token%\";\r\n"
				+ "}";

		AbstractToken content = createToken("");
		TextBlock root = TestSourceTextBlockCreator
				.initialiseTextBlocksWithContentToken(modelFactory, content);

		TextBlocksModel tbModel = new TextBlocksModel(root, null);
		tbModel.replace(0, 0, syntaxString);

		TextBlock tb = facade.parseIncrementally(root);
		Object syntaxObject = tb.getCorrespondingModelElements().iterator()
				.next();
		// assert no exception
		assertNotNull(syntaxObject);
		ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
		assertEquals("test", syntax.getName());
		assertEquals(2, syntax.getTemplates().size());

		Template fooTemplate = syntax.getTemplates().get(0);
		assertEquals("identifier", ((PrimitiveTemplate) fooTemplate)
				.getTemplateName());

		Template barTemplate = syntax.getTemplates().get(1);
		assertEquals("name", ((PrimitiveTemplate) barTemplate)
				.getTemplateName());
	}

	@Test
	public void testMinimalSyntaxWithMainAndBlanks() throws Exception {

		IncrementalParserFacade facade = getParserFacade();
		String syntaxString = "\r\n  \r\n\tsyntax test {\r\n  \r\n  \r\n  template ->Foo main \r\n  :  \"foo\"\r\n  ;}";

		AbstractToken content = createToken("");
		TextBlock root = TestSourceTextBlockCreator
				.initialiseTextBlocksWithContentToken(modelFactory, content);

		TextBlocksModel tbModel = new TextBlocksModel(root, null);
		tbModel.replace(0, 0, syntaxString);

		TextBlock tb = facade.parseIncrementally(root);
		Object syntaxObject = tb.getCorrespondingModelElements().iterator()
				.next();
		// assert no exception
		assertNotNull(syntaxObject);
		ConcreteSyntax syntax = (ConcreteSyntax) syntaxObject;
		assertEquals("test", syntax.getName());
		assertEquals(1, syntax.getTemplates().size());

		Template fooTemplate = syntax.getTemplates().get(0);
		assertTrue(fooTemplate instanceof ClassTemplate);
		assertEquals("Foo", fooTemplate.getNames().get(0));
	}

	@Test
	public void testParseATL() throws Exception {

		IncrementalParserFacade facade = getParserFacade();
		File syntaxDefFile = new File("scenariotestResource/ATL.tcs");

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
		assertEquals("ATL", syntax.getName());
		assertEquals(85, syntax.getTemplates().size());

		assertNotNull(currentVersionTb); // future version
		assertEquals(183, currentVersionTb.getSubNodes().size());
	}

	/**
	 * @return
	 */
	private IncrementalParserFacade getParserFacade() {
		TCSPackage tcsPackage = connection
				.getPackage(TCSPackage.PACKAGE_DESCRIPTOR);
		Collection<URI> priList = new ArrayList<URI>();
		Moin moin = MOINTCSMetaConnectionProvider.getBuildMoin();
		URI pri1 = moin
				.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm");
		URI pri2 = moin
				.createPri("PF.MetaModelDataArea:DCs/demo.sap.com/tcsmeta/_comp/moin/meta/Metamodel.moinmm");
		URI pri3 = moin
				.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm");
		URI pri4 = moin
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
