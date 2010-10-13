/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import static com.sap.furcas.parsergenerator.testutils.ResolutionBeanHelper.refE;
import static com.sap.furcas.test.parsing.testutils.StringListHelper.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import com.sap.furcas.metamodel.TCS.Keyword;
import com.sap.furcas.metamodel.TCS.OperatorList;
import com.sap.furcas.metamodel.TCS.Symbol;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.metamodel.TCS.stubs.ClassTemplateStub;
import com.sap.furcas.metamodel.TCS.stubs.ConcreteSyntaxStub;
import com.sap.furcas.metamodel.TCS.stubs.LiteralStub;
import com.sap.furcas.metamodel.TCS.stubs.OperatorListStub;
import com.sap.furcas.metamodel.TCS.stubs.PrimitiveTemplateStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.MetaModelElementResolutionHelperStub;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.tcs.MetamodelNameResolvingException;
import com.sap.furcas.runtime.tcs.SyntaxLookup;


/**
 *
 */
public class TestSyntaxLookup {


    /**
     * Test method for {@link com.sap.furcas.textual.tcs.tcs.util.tcs.util.SyntaxLookup#getDefaultPrimitiveTemplateRule(java.util.List)}.
     * @throws SyntaxParsingException 
     */
    @Test
    public void testGetDefaultPrimitiveTemplateRule() throws SyntaxElementException {
        MetaModelElementResolutionHelperStub namingHelper = new MetaModelElementResolutionHelperStub();
        ConcreteSyntaxStub syntax = new ConcreteSyntaxStub();
        
       
        SyntaxLookup lookup = new SyntaxLookup(syntax, null, namingHelper);
        // no primitive templates defined in SyntaxStub, so null should be returned
        assertNull(lookup.getDefaultPrimitiveTemplateRule(refE("test")));
        
        syntax.templates = new BasicEList<Template>();
        PrimitiveTemplateStub pStub = new PrimitiveTemplateStub();
        pStub.names = list("error");
        syntax.templates.add(pStub);
        
        lookup = new SyntaxLookup(syntax, null, namingHelper);
        
        // template names don't match, so still return null
        assertNull(lookup.getDefaultPrimitiveTemplateRule(refE("test")));
        
        ClassTemplateStub cStub = new ClassTemplateStub();
        cStub.names = list("test");
        syntax.templates.add(pStub);
        
        lookup = new SyntaxLookup(syntax, null, namingHelper);
        
     // template names match, but is not primitive, so still return null
        assertNull(lookup.getDefaultPrimitiveTemplateRule(refE("test")));
        
        pStub = new PrimitiveTemplateStub();
        pStub.names = list("test");
        syntax.templates.add(pStub);
        
        lookup = new SyntaxLookup(syntax, null, namingHelper);
        assertEquals(pStub, lookup.getDefaultPrimitiveTemplateRule(refE("test")));
        
        // qualified names now
        assertNull(lookup.getDefaultPrimitiveTemplateRule(refE("package", "test")));
        
        pStub = new PrimitiveTemplateStub();
        pStub.names = list("package", "test");
        syntax.templates.add(pStub);
        lookup = new SyntaxLookup(syntax, null, namingHelper);
        assertEquals(pStub, lookup.getDefaultPrimitiveTemplateRule(refE("package", "test")));
    }

    /**
     * Test method for {@link com.sap.furcas.textual.tcs.tcs.util.tcs.util.SyntaxLookup#getSymbolRule(java.lang.String)}.
     */
    @Test
    public void testGetSymbolRule() {
        MetaModelElementResolutionHelperStub namingHelper = new MetaModelElementResolutionHelperStub();
        ConcreteSyntaxStub syntax = new ConcreteSyntaxStub();
        
        SyntaxLookup lookup = new SyntaxLookup(syntax, null, namingHelper);
        
        // no symbols defined in SyntaxStub, so symbol is returned in hyphons
        assertEquals("'test'", lookup.getSymbolRule("test"));
      
        syntax.symbols = new BasicEList<Symbol>();
        // no change, as no symbols present
        assertEquals("'test'", lookup.getSymbolRule("test"));
        
        LiteralStub symbol = new LiteralStub();
        syntax.symbols.add(symbol );
     // no change, as no symbols has no name
        assertEquals("'test'", lookup.getSymbolRule("test"));
        
        symbol.value = "error";
        // no change, as no symbols has wrong name
        assertEquals("'test'", lookup.getSymbolRule("test"));
        
        symbol.value = "test";
        symbol.name = "name";
        // no change, as no symbols has wrong name
        assertEquals(" NAME ", lookup.getSymbolRule("test"));
        
        symbol.value = "othertest";
        symbol.name = "othername";
        // no change, as no symbols has wrong name
        assertEquals(" OTHERNAME ", lookup.getSymbolRule("othertest"));
        
    }

    /**
     * Test method for {@link com.sap.furcas.textual.tcs.tcs.util.tcs.util.SyntaxLookup#getTCSTemplate(java.util.List)}.
     * @throws SyntaxElementException 
     * @throws MetamodelNameResolvingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testGetTCSTemplate() throws MetamodelNameResolvingException, SyntaxElementException, MetaModelLookupException {
        MetaModelElementResolutionHelperStub namingHelper = new MetaModelElementResolutionHelperStub();
        ConcreteSyntaxStub syntax = new ConcreteSyntaxStub();
        
        SyntaxLookup lookup = new SyntaxLookup(syntax, null, namingHelper);
        assertEquals(0, lookup.getTCSTemplate(refE("test"), null).size());
        
        PrimitiveTemplateStub pStub = new PrimitiveTemplateStub();
        pStub.names = list("match");
        syntax.templates = new BasicEList<Template>();
        syntax.templates.add(pStub);
        
        // template names don't match, so still return null
        assertEquals(pStub, lookup.getTCSTemplate(refE("match"), null).iterator().next());
    }
    
    /**
     * tests that a qualified or unqualified reference to a template with an unqualified reference works
     * @throws MetamodelNameResolvingException
     * @throws SyntaxElementException
     * @throws MetaModelLookupException
     */
    @Test
    public void testGetTCSTemplateResolve() throws MetamodelNameResolvingException, SyntaxElementException, MetaModelLookupException {
        MetaModelElementResolutionHelperStub namingHelper = new MetaModelElementResolutionHelperStub();
        ConcreteSyntaxStub syntax = new ConcreteSyntaxStub();
        
        SyntaxLookup lookup = new SyntaxLookup(syntax, null, namingHelper);
        
        assertEquals(0, lookup.getTCSTemplate(refE("test"), null).size());
        
        PrimitiveTemplateStub pStub = new PrimitiveTemplateStub();
        pStub.names = list("package", "test");
        syntax.templates = new BasicEList<Template>();
        syntax.templates.add(pStub);
        
        assertEquals(pStub, lookup.getTCSTemplate(refE("package", "test"), null).iterator().next());
    }

    /**
     * Test method for {@link com.sap.furcas.textual.tcs.tcs.util.tcs.util.SyntaxLookup#getAnonymousOperatorList()}.
     */
    @Test
    public void testGetAnonymousOperatorList() {
        MetaModelElementResolutionHelperStub namingHelper = new MetaModelElementResolutionHelperStub();
        ConcreteSyntaxStub syntax = new ConcreteSyntaxStub();
        
        SyntaxLookup lookup = new SyntaxLookup(syntax, null, namingHelper);
        assertNull(lookup.getAnonymousOperatorList());
        
        syntax.operatorListList = new BasicEList<OperatorList>();
        assertNull(lookup.getAnonymousOperatorList());
       
        OperatorListStub opList = new OperatorListStub();
        opList.name = "error";
        syntax.operatorListList.add(opList );
        // return null, as this one has a name, and we want the anonymous one.
        assertNull(lookup.getAnonymousOperatorList());
        
        opList = new OperatorListStub();
        opList.name = "";
        syntax.operatorListList.add(opList );
        
        assertEquals(opList, lookup.getAnonymousOperatorList());
    }

    @Test
    public void testGetAllKeywords() {
        MetaModelElementResolutionHelperStub namingHelper = new MetaModelElementResolutionHelperStub();
        Set<Keyword> keywords = new HashSet<Keyword>();
        Keyword keyStub1 = new KeywordStub();
        
        keywords.add(keyStub1 );
        ConcreteSyntaxStub syntax = new ConcreteSyntaxStub();
        EList<Keyword> keywordList = new BasicEList<Keyword>();
        Keyword keyStub2 = new KeywordStub();
        keywords.add(keyStub2 );
        syntax.keywords = keywordList;
        
        SyntaxLookup lookup = new SyntaxLookup(syntax, keywords, namingHelper);
        Set<Keyword> result = lookup.getAllKeywords();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(keyStub1));
        assertTrue(result.contains(keyStub2));
    }

    
    private class KeywordStub extends LiteralStub implements Keyword {
        
    }

}
