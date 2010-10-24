package com.sap.furcas.parsergenerator.tcs.injection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.TCS.Token;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;


public class TestEnumSample extends AbstractTCSInjectionTest {
	


	@BeforeClass	
	public static void doSetUp() throws Exception {

		 setup("scenariotestResource/EnumTest.tcs");       
		
	}

	@Test 
	public void testSyntax()  {
		// now check the generated model is okay


		assertNotNull(syntax);
		assertEquals("EnumTest", syntax.getName());
		assertEquals(0, modelParsingResult.getResult().getErrors().size());
	}

	@Test public void testTemplates() {
	    List<Template> templates = syntax.getTemplates();
	    assertNotNull(templates);
	    assertEquals(7, templates.size());

	    int operatoredCount = 0;
	    int enumerationCount = 0;
	    int classCount = 0;

	    for (Template template : templates) {
	        if (template instanceof ClassTemplate) {
//	            ClassTemplate new_name = (ClassTemplate) template;
	            classCount ++;
	        } else if (template instanceof EnumerationTemplate) {
//	            ClassTemplate new_name = (ClassTemplate) template;
	            enumerationCount ++;
	        } else if (template instanceof OperatorTemplate) {
//	            ClassTemplate new_name = (ClassTemplate) template;
	            operatoredCount ++;
	        }
	    }
	    assertEquals(4, classCount);
	    assertEquals(2, enumerationCount);
	    assertEquals(0, operatoredCount);
	}

	@Test public void testEnumTemplates() {
	    List<Template> templates = syntax.getTemplates();

	    ArrayList<EnumerationTemplate> enumTemplates = new ArrayList<EnumerationTemplate>();
	    for (Template template : templates) {
	        if (template instanceof EnumerationTemplate) {
	            EnumerationTemplate etemplate = (EnumerationTemplate) template;
	            enumTemplates.add(etemplate);
	        }
	    }
	    
	    EnumerationTemplate e1 = enumTemplates.get(0);
	    assertEquals(list("Planet"), e1.getNames());
	    assertEquals(3, e1.getMappings().size());
	    assertEquals("mercury", e1.getMappings().get(0).getLiteral().getName());
	    assertEquals("venus", e1.getMappings().get(1).getLiteral().getName());
	    assertEquals("mars", e1.getMappings().get(2).getLiteral().getName());
	    
	    EnumerationTemplate e2 = enumTemplates.get(1);
        assertEquals(list("Speed"), e2.getNames());
        assertEquals(3, e2.getMappings().size());
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
		
//		for (Iterator iterator2 = keywords.iterator(); iterator2.hasNext();) {
//            Keyword keyword = (Keyword) iterator2.next();
//            System.out.println(keyword.getValue() + " : " + keyword.getName());
//        }
		assertEquals(8, keywords.size());
		for (Iterator<Keyword> iterator2 = syntax.getKeywords().iterator(); iterator2.hasNext();) {
			Keyword keyword = iterator2.next();
			keywords.add(keyword);
		}
		assertEquals(8, keywords.size());
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
