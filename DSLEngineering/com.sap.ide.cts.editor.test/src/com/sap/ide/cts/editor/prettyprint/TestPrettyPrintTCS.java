package com.sap.ide.cts.editor.prettyprint;

import generated.TCSLexer;

import org.junit.Before;
import org.junit.Test;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.Keyword;
import tcs.LiteralRef;
import tcs.Sequence;
import tcs.SpaceKindEnum;
import tcs.Symbol;
import textblocks.TextBlock;

import com.sap.furcas.textual.tcs.TcsUtil;
import com.sap.mi.tcs.parser.TcsParserFactory;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

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
		t.setMain(true);

		MofClass sclass = (MofClass) s.refMetaObject();

		Attribute attr = (Attribute) sclass.lookupElementExtended("name");
		t.setMetaReference(attr.getType());

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
		sym.getSpaces().add(SpaceKindEnum.LEFT_SPACE);
		sym.getSpaces().add(SpaceKindEnum.RIGHT_NONE);
		s.getSymbols().add(sym);

		sym = modelFactory.createSymbol();
		sym.setName("rsquare");
		sym.setValue("]");
		s.getSymbols().add(sym);

		sym = modelFactory.createSymbol();
		sym.setName("dlsquare");
		sym.setValue("[[");
		sym.getSpaces().add(SpaceKindEnum.LEFT_NONE);
		sym.getSpaces().add(SpaceKindEnum.RIGHT_NONE);
		s.getSymbols().add(sym);

		sym = modelFactory.createSymbol();
		sym.setName("drsquare");
		sym.setValue("]]");
		sym.getSpaces().add(SpaceKindEnum.RIGHT_SPACE);
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
	public void testCompleteTCSSyntax() throws SyntaxAndModelMismatchException {
		ConcreteSyntax s = TcsUtil.getTcsSyntax(connection);

		TextBlock output = TcsPrettyPrinterTestHelper.prettyPrintTextBlock(s,
				syntax, new TcsParserFactory());
		assertOutput(output, "CompleteTCSSyntax");
	}
}
