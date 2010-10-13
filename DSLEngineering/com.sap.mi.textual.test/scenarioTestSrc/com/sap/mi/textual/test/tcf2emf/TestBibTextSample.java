package com.sap.mi.textual.test.tcf2emf;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.TCS.Block;
import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.Keyword;
import com.sap.furcas.metamodel.TCS.LiteralRef;
import com.sap.furcas.metamodel.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.TCS.Property;
import com.sap.furcas.metamodel.TCS.PropertyArg;
import com.sap.furcas.metamodel.TCS.RefersToPArg;
import com.sap.furcas.metamodel.TCS.Sequence;
import com.sap.furcas.metamodel.TCS.SequenceElement;
import com.sap.furcas.metamodel.TCS.Symbol;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.metamodel.TCS.Token;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;


public class TestBibTextSample extends AbstractTCSInjectionTest {
	


	@BeforeClass	
	public static void doSetUp() throws Exception {

	    setup("scenariotestResource/Bibtext.tcs");        
		
	}

	@Test 
	public void testSyntax()  {
		// now check the generated model is okay


		assertNotNull(syntax);
		assertEquals("Bibtext", syntax.getName());
		assertEquals(0, modelParsingResult.getResult().getErrors().size());
	}
	
	@Test public void testPrimitiveTemplate()  {

		
		List<Template> templates = syntax.getTemplates();
		assertNotNull(templates);
		assertEquals(7, templates.size());
		
		// have to assume order of templates to keep testing code simple
		Template identifier = templates.get(0);
		assertNotNull(identifier.getNames());
//		assertNotNull(identifier.getMetaReference().getQualifiedName());
		assertArrayEquals(new String[]{"String"}, identifier.getNames().toArray());
		PrimitiveTemplate idtemp = (PrimitiveTemplate) identifier;
		assertEquals("NAME", idtemp.getTokenName());
		assertEquals("identifier", idtemp.getTemplateName());
		assertEquals("unescapeString(%token%)", idtemp.getValue());
		assertEquals(syntax, idtemp.getConcreteSyntax());
	}
	
	@Test public void testTemplates() {
		List<Template> templates = syntax.getTemplates();
		assertNotNull(templates);
		assertEquals(7, templates.size());
	}
	
	@Test public void testBibTextFileTemplate()  {
	
		List<Template> templates = syntax.getTemplates();
		
		// have to assume order of templates to keep testing code simple
		Template file = templates.get(1);
		assertEquals(list("BibTextFile"), file.getNames());
		ClassTemplate filetemp = (ClassTemplate) file;
		assertEquals(true, filetemp.isIsMain());
		assertEquals(true, filetemp.isIsContext());
		assertEquals(false, filetemp.isIsAbstract());
		Sequence seq = filetemp.getTemplateSequence();
		
		assertNull(seq.getFunctionContainer());
		assertNull(seq.getElseContainer());
		assertNull(seq.getSeparatorContainer());
		
		assertEquals(1, seq.getElements().size());
		SequenceElement blocks = seq.getElements().get(0);
		assertEquals(1, blocks.getElementSequence().getElements().size());
		Block block = (Block) blocks.getElementSequence().
		getElements().
		get(0);
		SequenceElement entries = block.getBlockSequence().getElements().get(0);
		Property property = (Property) entries;
		assertEquals("entries", property.getPropertyReference().getName());
		assertEquals(0, property.getPropertyArgs().size());
	}
	
	
	@Test public void testBibTextEntryTemplate()  {
		
		List<Template> templates = syntax.getTemplates();
		
		// have to assume order of templates to keep testing code simple
		Template entry = templates.get(2);
		assertEquals(list("BibTextEntry"), entry.getNames());
		ClassTemplate entrytemp = (ClassTemplate) entry;
		assertEquals(false, entrytemp.isIsMain());
		assertEquals(false, entrytemp.isIsContext());
		assertEquals(true, entrytemp.isIsAbstract());
		assertNull(entrytemp.getTemplateSequence());
		assertNull(entrytemp.getPrefixSequence());
		assertNull(entrytemp.getOperatorList());
//		assertEquals(0, entrytemp.getModifiers().size());
	
	}
	
	@Test public void testArticleTemplate()  {

		List<Template> templates = syntax.getTemplates();

		// have to assume order of templates to keep testing code simple
		Template art = templates.get(3);
		assertEquals(list("Article"), art.getNames());
		ClassTemplate arttemp = (ClassTemplate) art;
		assertEquals(false, arttemp.isIsMain());
		assertEquals(false, arttemp.isIsContext());
		assertEquals(false, arttemp.isIsAbstract());
		assertEquals(4, arttemp.getTemplateSequence().getElements().size());
		assertNull(arttemp.getPrefixSequence());
		assertNull(arttemp.getOperatorList());
//		assertEquals(0, arttemp.getModifiers().size());
	}
	/**
	 * Tests contents which should be:
	 *  /**
	  * "article" "{"
		[
		key "," author{refersTo=name} "," attributes{separator = ","}
		]
		"}"
	  */
	@Test public void testArticleTemplateInterior()  {

		// used to check setting of references
		List<Symbol> symbols = syntax.getSymbols();
		Symbol lcurly = symbols.get(1); 
		Symbol coma = symbols.get(0);
		
		
		List<Template> templates = syntax.getTemplates();
		// have to assume order of templates to keep testing code simple
		Template art = templates.get(3);
		ClassTemplate arttemp = (ClassTemplate) art;
		List<SequenceElement> templateSequence = arttemp.getTemplateSequence().getElements();
		
		LiteralRef keyword = (LiteralRef) templateSequence.get(0);
		assertNotNull(keyword.getReferredLiteral());
		
		LiteralRef lcurlyRef = (LiteralRef) templateSequence.get(1);
		assertEquals(lcurly, lcurlyRef.getReferredLiteral());

		LiteralRef rcurlyRef = (LiteralRef) templateSequence.get(3);
		assertNotNull(rcurlyRef.getReferredLiteral());
		
		Block sequence = (Block) templateSequence.get(2);
		List<SequenceElement> seqElements = sequence.getBlockSequence().getElements();
		assertEquals(5, seqElements.size());
		Property key = (Property)seqElements.get(0);
		assertEquals("key", key.getPropertyReference().getName());
		
		LiteralRef litRef = (LiteralRef)seqElements.get(1);
		assertEquals(coma, litRef.getReferredLiteral());
		
		
		Property author = (Property)seqElements.get(2);
		assertEquals("author", author.getPropertyReference().getName());
		List<PropertyArg> propargs = author.getPropertyArgs();
		assertEquals(1, propargs.size());
		PropertyArg refersTo = propargs.get(0);
		RefersToPArg refersToP = (RefersToPArg) refersTo;
		assertEquals("name", refersToP.getPropertyName());
	}
	
	
//	public void testPrimitiveTemplate()  {
//		ConcreteSyntax syntax = (ConcreteSyntax) syntaxSet.iterator().next();
//		
//		List<Template> templates = syntax.getTemplates();
//		assertNotNull(templates);
//		assertEquals(7, templates.size());
//		
//		// have to assume order of templates to keep testing code simple
//		Template identifier = templates.get(0);
//		assertEquals("identifier", identifier.getName());
//		PrimitiveTemplate idtemp = (PrimitiveTemplate) identifier;
//		assertEquals("NAME", idtemp.getTokenName());
//		assertEquals("String", idtemp.getTypeName());
//		assertEquals("%token%", idtemp.getValue());
//		assertEquals(syntax, idtemp.getConcreteSyntax());
//	}
	
//		assertContainsOnce(templates, "identifier", "String", true, "NAME", "%token");
	@Test public void testSymbols()  {

		List<Symbol> symbols = syntax.getSymbols();
		assertNotNull(symbols);
		assertEquals(3, symbols.size());
		
		// have to assume order of symbols to keep testing easy
		Symbol coma = symbols.get(0);
		assertEquals("coma", coma.getName());
		assertEquals(",", coma.getValue());
		
		Symbol lcurly = symbols.get(1);
		assertEquals("lcurly", lcurly.getName());
		assertEquals("{", lcurly.getValue());
		
		Symbol rcurly = symbols.get(2);
		assertEquals("rcurly", rcurly.getName());
		assertEquals("}", rcurly.getValue());
		
		
	}
	
	/**
	 * Expects:
	 *  <TCS:Keyword location="26:5-26:14" literalRefs="/0/@templates.3/@templateSequence/@elements.0" value="article"/>
  <TCS:Keyword location="36:5-36:13" literalRefs="/0/@templates.5/@templateSequence/@elements.0" value="author"/>
  <TCS:Keyword location="36:14-36:17" literalRefs="/0/@templates.5/@templateSequence/@elements.1 /0/@templates.6/@templateSequence/@elements.1" value="="/>
  <TCS:Keyword location="36:23-36:26" literalRefs="/0/@templates.5/@templateSequence/@elements.3" value="."/>
  <TCS:Keyword location="40:5-40:11" literalRefs="/0/@templates.6/@templateSequence/@elements.0" value="year"/>
	 * @throws ModelAdapterException 
	 */
	@Test public void testKeywords() throws ModelAdapterException  {
		

		Set<Keyword> keywords = modelParsingResult.getKeywords();
		Iterator<Keyword> iterator = keywords.iterator();
		for (; iterator.hasNext();) {
			Keyword keyword = iterator.next();
			keywords.add(keyword);
		}
		
//			syntax.getKeywords();
		assertEquals(5, keywords.size());
		   for (Iterator<Keyword> iterator2 = syntax.getKeywords().iterator(); iterator2.hasNext();) {
	            Keyword keyword = iterator2.next();
	            keywords.add(keyword);
	        }
	        assertEquals(5, keywords.size());
	}
	
	@Test public void testTokens()  {

		List<Token> tokens = syntax.getTokens();
		assertNotNull(tokens);
		assertEquals(1, tokens.size());	
	}
	

    private static List<String> list(String entry) {
        ArrayList<String> list = new ArrayList<String>();
        list.add(entry);
        return list;
    }

}
