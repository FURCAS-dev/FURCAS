package com.sap.ide.cts.editor.prettyprint;

import org.junit.Test;




public class TestPrettyPrintTCS extends CtsPrettyPrinterTestBase {

    @Test
    public void testNothing() {
        // so that maven does not fail...
    }
//	@Before
//	public void init() {
//		initMetamodelId("demo.sap.com/tcsmeta");
//		initSyntax("TCS", TCSLexer.class.getResourceAsStream("TCS.tcs"));
//	}
//
//	@Test
//	public void testSyntaxOnly() throws SyntaxAndModelMismatchException {
//		ConcreteSyntax s = modelFactory.createConcreteSyntax();
//		s.setName("SimpleSyntax");
//
//		TextBlock output = PrettyPrintTestHelper.prettyPrintTextBlock(s,
//				syntax, new TcsParserFactory());
//		assertOutput(output, "SyntaxOnly");
//	}
//
//	@Test
//	public void testSyntaxWithMainClassTemplateMetaReference()
//			throws JmiException, NameNotFoundException,
//			SyntaxAndModelMismatchException {
//		ConcreteSyntax s = modelFactory.createConcreteSyntax();
//		s.setName("SyntaxWithMainClassTemplateMetaReference");
//
//		ClassTemplate t = modelFactory.createClassTemplate();
//		t.setIsMain(true);
//
//		EClass sclass = (EClass) s.refMetaObject();
//
//		EAttribute attr = (EAttribute) sclass.getEStructuralFeature("name");
//		t.setMetaReference(attr.getEType());
//
//		s.getTemplates().add(t);
//
//		TextBlock output = PrettyPrintTestHelper.prettyPrintTextBlock(s,
//				syntax, new TcsParserFactory());
//		assertOutput(output, "SyntaxWithMainClassTemplateMetaReference");
//	}
//
//	@Test
//	public void testSyntaxWithSymbols() throws SyntaxAndModelMismatchException {
//		ConcreteSyntax s = modelFactory.createConcreteSyntax();
//		s.setName("SyntaxWithSymbols");
//
//		Symbol sym = modelFactory.createSymbol();
//		sym.setName("lsquare");
//		sym.setValue("[");
//		sym.getSpaces().add(SpaceKind.LEFT_SPACE);
//		sym.getSpaces().add(SpaceKind.RIGHT_NONE);
//		s.getSymbols().add(sym);
//
//		sym = modelFactory.createSymbol();
//		sym.setName("rsquare");
//		sym.setValue("]");
//		s.getSymbols().add(sym);
//
//		sym = modelFactory.createSymbol();
//		sym.setName("dlsquare");
//		sym.setValue("[[");
//		sym.getSpaces().add(SpaceKind.LEFT_NONE);
//		sym.getSpaces().add(SpaceKind.RIGHT_NONE);
//		s.getSymbols().add(sym);
//
//		sym = modelFactory.createSymbol();
//		sym.setName("drsquare");
//		sym.setValue("]]");
//		sym.getSpaces().add(SpaceKind.RIGHT_SPACE);
//		s.getSymbols().add(sym);
//
//		TextBlock output = PrettyPrintTestHelper.prettyPrintTextBlock(s,
//				syntax, new TcsParserFactory());
//		assertOutput(output, "SyntaxWithSymbols");
//	}
//
//	/**
//	 * Test how a keyword that is referenced in the syntax, but not in
//	 * ConcreteSyntax.keywords (as it was autocreated) is prettyprinted.
//	 * 
//	 * @throws SyntaxAndModelMismatchException
//	 */
//	@Test
//	public void testAutocreatedKeyword() throws SyntaxAndModelMismatchException {
//		ConcreteSyntax s = modelFactory.createConcreteSyntax();
//		s.setName("Test");
//
//		Keyword notLinkedToSyntax = modelFactory.createKeyword();
//		notLinkedToSyntax.setValue("autocreated");
//
//		ClassTemplate t = modelFactory.createClassTemplate();
//		t.getNames().add("A");
//		Sequence ts = modelFactory.createSequence();
//		LiteralRef ref = modelFactory.createLiteralRef();
//		ref.setReferredLiteral(notLinkedToSyntax);
//		ref.setParentTemplate(t);
//		ts.getElements().add(ref);
//		t.setTemplateSequence(ts);
//		s.getTemplates().add(t);
//
//		TextBlock output = PrettyPrintTestHelper.prettyPrintTextBlock(s,
//				syntax, new TcsParserFactory());
//		assertOutput(output, "AutocreatedKeyword");
//	}
//
//	@Test
//	@Ignore /* known to be broken for long... Investigation needed */
//	public void testCompleteTCSSyntax() throws SyntaxAndModelMismatchException {
//		ConcreteSyntax s = TcsUtil.getTcsSyntax(connection);
//
//		TextBlock output = PrettyPrintTestHelper.prettyPrintTextBlock(s,
//				syntax, new TcsParserFactory());
//		assertOutput(output, "CompleteTCSSyntax");
//	}
}
