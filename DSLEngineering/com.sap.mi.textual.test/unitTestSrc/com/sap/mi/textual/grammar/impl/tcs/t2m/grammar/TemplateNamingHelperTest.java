/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import static com.sap.mi.textual.test.util.StringListHelper.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tcs.QualifiedNamedElement;

import com.sap.furcas.textual.common.exceptions.MetaModelLookupException;
import com.sap.furcas.textual.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.textual.common.exceptions.SyntaxElementException;
import com.sap.furcas.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.MetaModelElementResolutionHelperStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.FunctionTemplateStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.PrimitiveTemplateStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.TemplateStub;
import com.sap.mi.textual.moinlookup.util.MetamodelNameResolvingException;
import com.sap.mi.textual.moinlookup.util.TemplateNamingHelper;
import com.sap.mi.textual.test.util.ResolutionBeanHelper;

/**
 *
 */
public class TemplateNamingHelperTest {

    /**
     * Test method for {@link com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.naming.TemplateNamingHelper#TemplateNamingHelper(com.sap.mi.textual.interfaces.IMetaModelLookup, java.lang.String)}.
     * @throws SyntaxParsingException 
     * @throws MetamodelNameResolvingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testTemplateNamingHelper() throws SyntaxElementException, MetamodelNameResolvingException, MetaModelLookupException {
        
        MetaModelElementResolutionHelperStub metaStub = new MetaModelElementResolutionHelperStub();
        
        TemplateNamingHelper helper = new TemplateNamingHelper(metaStub);
        

        assertEquals("test_test2_class", helper.buildRuleName(ResolutionBeanHelper.refE("test", "test2", "class")));
        
        /** test it uses the separator**/
        TemplateStub template = new TemplateStub();
        template.names = list("test2", "test", "class");
        
        assertEquals("list(\"test2\",\"test\",\"class\")", helper.getMetaTypeListParameter(template));

    }


    
 

    /**
     * Test method for {@link com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.naming.TemplateNamingHelper#buildRuleName(TCS.QualifiedNamedElement)}.
     * @throws SyntaxElementException 
     */
    @Test
    public void testGetRuleNameQualifiedNamedElement() throws SyntaxElementException {
       
        MetaModelElementResolutionHelperStub metaStub = new MetaModelElementResolutionHelperStub();
        
        TemplateNamingHelper helper = new TemplateNamingHelper(metaStub);
        TemplateStub template = new TemplateStub();
        template.names = list("test", "class");
        
        assertEquals("test_class", helper.getRuleName(template));
        
        PrimitiveTemplateStub stub = new PrimitiveTemplateStub();
        stub.templateName = "templateName";
        stub.names = list("test", "class");
        assertEquals("templateName", helper.getRuleName(stub));

    }
    
    /**
     * Test method for {@link com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.naming.TemplateNamingHelper#buildRuleName(TCS.QualifiedNamedElement)}.
     * @throws SyntaxElementException 
     */
    @Test
    public void testGetRuleNameQualifiedNamedElementException() throws SyntaxElementException {
       
        MetaModelElementResolutionHelperStub metaStub = new MetaModelElementResolutionHelperStub() {

            @Override
            public ResolvedNameAndReferenceBean resolve(
                    QualifiedNamedElement template)
                    throws NameResolutionFailedException{
                throw new NameResolutionFailedException("test");
            }
            
        };
        
        TemplateNamingHelper helper = new TemplateNamingHelper(metaStub);
        TemplateStub template = new TemplateStub();
        template.names = list("test", "class");
        
        boolean caught = false;
        try {
            helper.getRuleName(template);
        } catch(SyntaxElementException e) {
            caught = true;
        }
        assertTrue("SyntaxElementException expected because metaStub does not know this class", caught);
    }
    
    /**
     * Test method for {@link com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.naming.TemplateNamingHelper#buildRuleName(TCS.QualifiedNamedElement)}.
     * @throws SyntaxElementException 
     */
    @Test
    public void testGetRuleNamePrimitive() throws SyntaxElementException {
       
        MetaModelElementResolutionHelperStub metaStub = new MetaModelElementResolutionHelperStub();
        
        TemplateNamingHelper helper = new TemplateNamingHelper(metaStub);
        
        PrimitiveTemplateStub stub = new PrimitiveTemplateStub();
        stub.templateName = "templateName";
        stub.names = list("test", "class");
        assertEquals("templateName", helper.getRuleName(stub));

    }
    
    /**
     * Test method for {@link com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.naming.TemplateNamingHelper#buildRuleName(TCS.QualifiedNamedElement)}.
     * @throws SyntaxElementException 
     */
    @Test
    public void testGetRuleNameFunction() throws SyntaxElementException {
       
        MetaModelElementResolutionHelperStub metaStub = new MetaModelElementResolutionHelperStub();
        
        TemplateNamingHelper helper = new TemplateNamingHelper(metaStub);
        
        FunctionTemplateStub stub = new FunctionTemplateStub();
        stub.functionName = "functionName";
        stub.names = list("test", "class");
        assertEquals("functionname", helper.getRuleName(stub));

        stub.functionName = "OTHERName";
        stub.names = list("test", "class");
        assertEquals("othername", helper.getRuleName(stub));
    }

    /**
     * Test method for {@link com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.naming.TemplateNamingHelper#buildRuleName(java.util.List)}.
     * @throws SyntaxElementException 
     * @throws MetamodelNameResolvingException 
     */
    @Test
    public void testGetRuleNameListOfString() throws Exception {
       
        MetaModelElementResolutionHelperStub metaStub = new MetaModelElementResolutionHelperStub();
        
        TemplateNamingHelper helper = new TemplateNamingHelper(metaStub);
        
       
        boolean caught = false;
        
        // Nullpointer is acceptable here as it points to a bug, and should in the integration case never happen.
        caught = false;
        try {
            helper.buildRuleName(null);
        } catch(NullPointerException e) {
            caught = true;
        }
        assertTrue("NullPointerException expected", caught);
        
    
    }

    /**
     * Test method for {@link com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.naming.TemplateNamingHelper#getMetaTypeListParameter(TCS.QualifiedNamedElement)}.
     * @throws SyntaxElementException 
     * @throws MetamodelNameResolvingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testGetReferedMetaObjectName() throws SyntaxElementException, MetaModelLookupException, MetamodelNameResolvingException {
       
        MetaModelElementResolutionHelperStub metaStub = new MetaModelElementResolutionHelperStub();

        TemplateNamingHelper helper = new TemplateNamingHelper(metaStub);
        TemplateStub template = new TemplateStub();
        template.names = list("test","class");
        
        assertEquals("list(\"test\",\"class\")", helper.getMetaTypeListParameter(template));

    }

}
