package com.sap.mi.textual.test.tcf2emf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import tcs.AssociativityEnum;
import tcs.ClassTemplate;
import tcs.EnumerationTemplate;
import tcs.Keyword;
import tcs.OperatorList;
import tcs.OperatorTemplate;
import tcs.Priority;
import tcs.Template;
import tcs.Token;

import com.sap.furcas.textual.common.exceptions.ModelAdapterException;


public class TestLOTOSSample extends AbstractTCSInjectionTest {

	

	@BeforeClass	
	public static void doSetUp() throws Exception {

		 setup("scenariotestResource/LOTOS.tcs");     
		
	}

	@Test 
	public void testSyntax()  {
		// now check the generated model is okay


		assertNotNull(syntax);
		assertEquals("LOTOS", syntax.getName());
		assertEquals(0, modelParsingResult.getResult().getErrors().size());
	}

	@Test public void testTemplates() {
	    List<Template> templates = syntax.getTemplates();
	    assertNotNull(templates);
	    assertEquals(46, templates.size());

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
	    assertEquals(34, classCount);
	    assertEquals(0, enumerationCount);
	    assertEquals(7, operatoredCount);
	}
	
	/**
	 * tetst against bugs in operator List parsing
	 */
	@Test 
    public void testOperatorList()  {
        List<OperatorList> opListList = syntax.getOperatorLists();
        assertNotNull(opListList);
        assertEquals(2, opListList.size());
        
        OperatorList opList1 = opListList.get(0);
        assertNotNull(opList1);
        assertEquals("Behaviour", opList1.getName());
        
        List<Priority> prioList = opList1.getPriorities();
        assertNotNull(prioList);
        assertEquals(4, prioList.size());
        
        Priority prio0 = prioList.get(0);
        assertNotNull(prio0);
        assertEquals(0, prio0.getValue());
        assertEquals(AssociativityEnum.RIGHT, prio0.getAssociativity());
        assertEquals(1, prio0.getOperators().size());
        assertEquals(1, prio0.getOperators().get(0).getArity());
        

        
        Priority prio1 = prioList.get(1);
        assertNotNull(prio1);
        assertEquals(1, prio1.getValue());
        assertEquals(AssociativityEnum.LEFT, prio1.getAssociativity());
        assertEquals(1, prio1.getOperators().size());
        assertEquals(1, prio1.getOperators().get(0).getArity());

        
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
	@Test public void testKeywords() throws Exception  {
		

		Set<Keyword> keywords = modelParsingResult.getKeywords();
		Iterator<Keyword> iterator = keywords.iterator();
		for (; iterator.hasNext();) {
			Keyword keyword = (Keyword) iterator.next();
			keywords.add(keyword);
		}
		
//			syntax.getKeywords();
		assertEquals(29, keywords.size());
		for (Iterator<Keyword> iterator2 = keywords.iterator(); iterator2.hasNext();) {
			Keyword keyword = iterator2.next();
		}
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
