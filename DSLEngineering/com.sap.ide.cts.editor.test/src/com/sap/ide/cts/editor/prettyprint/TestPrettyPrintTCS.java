package com.sap.ide.cts.editor.prettyprint;


import javax.naming.NameNotFoundException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind;
import com.sap.furcas.metamodel.FURCAS.TCS.Symbol;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.ide.cts.editor.prettyprint.imported.SyntaxAndModelMismatchException;
import com.sap.mi.tcs.parser.TcsParserFactory;


public class TestPrettyPrintTCS extends CtsPrettyPrinterTestBase {

	@Before
	public void init() {
		initMetamodelId("demo.sap.com/tcsmeta");
		initSyntax("TCS", TCSLexer.class.getResourceAsStream("TCS.tcs"));
	}

	@Test
	public void testSyntaxOnly() throws SyntaxAndModelMismatchException {
		ConcreteSyntax s = modelFactory.createConcreteSyntax();
		s.setName("SimpleSyntax");

		TextBlock output = TcsPrettyPrinterTestHelper.prettyPrintTextBlock(s,
				syntax, new TcsParserFactory());
		assertOutput(output, "SyntaxOnly");
	}

	@Test
	public void testSyntaxWithMainClassTemplateMetaReference()
			throws JmiException, NameNotFoundException,
			SyntaxAndModelMismatchException {
		ConcreteSyntax s = modelFactory.createConcreteSyntax();
		s.setName("SyntaxWithMainClassTemplateMetaReference");

		ClassTemplate t = modelFactory.createClassTemplate();
		t.setIsMain(true);

		EClass sclass = (EClass) s.refMetaObject();

		EAttribute attr = (EAttribute) EcoreHelper.lookupElementExtended(sclass,"name");
		t.setMetaReference((EClass) attr.getEType());

		s.getTemplates().add(t);

		TextBlock output = TcsPrettyPrinterTestHelper.prettyPrintTextBlock(s,
				syntax, new TcsParserFactory());
		assertOutput(output, "SyntaxWithMainClassTemplateMetaReference");
	}

	@Test
	public void testSyntaxWithSymbols() throws SyntaxAndModelMismatchException {
		ConcreteSyntax s = modelFactory.createConcreteSyntax();
		s.setName("SyntaxWithSymbols");

		Symbol sym = modelFactory.createSymbol();
		sym.setName("lsquare");
		sym.setValue("[");
		sym.getSpaces().add(SpaceKind.LEFT_SPACE);
		sym.getSpaces().add(SpaceKind.RIGHT_NONE);
		s.getSymbols().add(sym);

		sym = modelFactory.createSymbol();
		sym.setName("rsquare");
		sym.setValue("]");
		s.getSymbols().add(sym);

		sym = modelFactory.createSymbol();
		sym.setName("dlsquare");
		sym.setValue("[[");
		sym.getSpaces().add(SpaceKind.LEFT_NONE);
		sym.getSpaces().add(SpaceKind.RIGHT_NONE);
		s.getSymbols().add(sym);

		sym = modelFactory.createSymbol();
		sym.setName("drsquare");
		sym.setValue("]]");
		sym.getSpaces().add(SpaceKind.RIGHT_SPACE);
		s.getSymbols().add(sym);

		TextBlock output = TcsPrettyPrinterTestHelper.prettyPrintTextBlock(s,
				syntax, new TcsParserFactory());
		assertOutput(output, "SyntaxWithSymbols");
	}

	/**
	 * Test how a keyword that is referenced in the syntax, but not in
	 * ConcreteSyntax.keywords (as it was autocreated) is prettyprinted.
	 * 
	 * @throws SyntaxAndModelMismatchException
	 */
	@Test
	public void testAutocreatedKeyword() throws SyntaxAndModelMismatchException {
		ConcreteSyntax s = modelFactory.createConcreteSyntax();
		s.setName("Test");

		Keyword notLinkedToSyntax = modelFactory.createKeyword();
		notLinkedToSyntax.setValue("autocreated");

		ClassTemplate t = modelFactory.createClassTemplate();
		t.getNames().add("A");
		Sequence ts = modelFactory.createSequence();
		LiteralRef ref = modelFactory.createLiteralRef();
		ref.setReferredLiteral(notLinkedToSyntax);
		ref.setParentTemplate(t);
		ts.getElements().add(ref);
		t.setTemplateSequence(ts);
		s.getTemplates().add(t);

		TextBlock output = TcsPrettyPrinterTestHelper.prettyPrintTextBlock(s,
				syntax, new TcsParserFactory());
		assertOutput(output, "AutocreatedKeyword");
	}

	@Test
	@Ignore /* known to be broken for long... Investigation needed */
	public void testCompleteTCSSyntax() throws SyntaxAndModelMismatchException {
		ConcreteSyntax s = TcsUtil.getTcsSyntax(connection);

		TextBlock output = TcsPrettyPrinterTestHelper.prettyPrintTextBlock(s,
				syntax, new TcsParserFactory());
		assertOutput(output, "CompleteTCSSyntax");
	}
}
