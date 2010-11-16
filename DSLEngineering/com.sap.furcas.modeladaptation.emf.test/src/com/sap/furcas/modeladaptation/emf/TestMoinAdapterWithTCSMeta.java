/**
 * 
 */
package com.sap.furcas.modeladaptation.emf;

import static com.sap.furcas.test.testutils.StringListHelper.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Associativity;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.test.testutils.ScopeHelper;

public class TestMoinAdapterWithTCSMeta {

    private EMFModelAdapterTestAdapter adapter;
        
    @Before
    public void setup() {
        EPackage rootPkg = FURCASPackage.eINSTANCE;
        assertNotNull(rootPkg);
        adapter = new EMFModelAdapterTestAdapter(rootPkg, ScopeHelper.createResourceSet(), ScopeHelper.createFURCASReferenceScope());
    }
        
    @Test
    public void testTCSElementCreation() throws Exception {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        assertNotNull(syntax);
        assertTrue(syntax instanceof ConcreteSyntax);
        
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        assertNotNull(classTemplate);
        assertTrue(classTemplate instanceof ClassTemplate);
        
    }

    @Test
    public void testTCSEnumLitCreationError() {
        boolean exceptionCaught = false;
        try {
            adapter.createEnumLiteral("FURCAS::TCS::ErrorTypeNothing", "left");
        } catch (ModelAdapterException e) {
            exceptionCaught = true;
        }
        assertTrue("Expected Exception because type does not exist", exceptionCaught);

    }
    
    @Test
    public void testTCSElementCreationError() throws Exception {
        boolean exceptionCaught = false;
        try {
            adapter.createElement("FURCAS::TCS::ErrorTypeNothing");
        } catch (ModelAdapterException e) {
            exceptionCaught = true;
        }
        assertTrue("Expected Exception because type does not exist", exceptionCaught);


    }

    @Test
    public void testTCSEnumLitCreation() throws Exception {
        Object enumLit = adapter.createEnumLiteral("FURCAS::TCS::Associativity", "left");
        assertNotNull(enumLit);
        assertTrue(enumLit instanceof Associativity);

    }
    
    @Test
    public void testTCSSetError() throws Exception {
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        boolean exceptionCaught = false;
        try {
            adapter.set(classTemplate, "error", true);
        } catch (ModelAdapterException e) {
            exceptionCaught = true;
        }
        assertTrue("Expected Exception because type does not have such feature", exceptionCaught);
    }

    @Test
    public void testTCSGetError() throws Exception {
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        boolean exceptionCaught = false;
        try {
            adapter.get(classTemplate, "error");
        } catch (ModelAdapterException e) {
            exceptionCaught = true;
        }
        assertTrue("Expected Exception because type does not have such feature", exceptionCaught);


    }

    @Test
    public void testTCSSetGetBoolean() throws Exception {
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        assertEquals(false, adapter.get(classTemplate, "isMain"));
        
        adapter.set(classTemplate, "isMain", true);
        assertEquals(true, adapter.get(classTemplate, "isMain"));
    }
    
    @Test
    public void testTCSSetGetString() throws Exception {
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        assertEquals(null, adapter.get(primTemplate, "templateName"));
        
        adapter.set(primTemplate, "templateName", "testName");
        assertEquals("testName", adapter.get(primTemplate, "templateName"));

    }
    
    @Test
    public void testTCSSetGetInteger() throws Exception {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        assertEquals(null, adapter.get(syntax, "k"));
        
        adapter.set(syntax, "k", 3);
        assertEquals(3, adapter.get(syntax, "k"));
    }
    
    @Test
    public void testTCSInstanceOf() throws Exception {
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        assertNotNull(classTemplate);
        
        assertTrue(adapter.instanceOf(classTemplate, TCSPackage.Literals.TEMPLATE));
        assertTrue(adapter.instanceOf(classTemplate, TCSPackage.Literals.CLASS_TEMPLATE));
        assertTrue(adapter.instanceOf(classTemplate, TCSPackage.Literals.LOCATED_ELEMENT));
        
    }

    @Test
    @Ignore
    public void testTCSQuery() throws Exception {
        // ... TODO test setup for MQL query
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        adapter.set(syntax, "templates", classTemplate);
        
        Object opList = adapter.createElement("FURCAS::TCS::OperatorList");
        adapter.set(opList, "name", "test");
        adapter.set(syntax, "operatorLists", opList);
        
        String oclQuery = "Select from where";
        adapter.setOclReference(classTemplate, "operatorList", "test", oclQuery, null, null);
    }
    
    @Test
    public void testTCSSetGetAsso() throws Exception {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");

        assertEquals(new ArrayList<Object>(), adapter.get(syntax, "templates"));
        
        adapter.set(syntax, "templates", classTemplate);
        
        Object rawResult = adapter.get(syntax, "templates");
        assertNotNull(rawResult);
        assertTrue(rawResult instanceof Collection);
        Collection<?> templates = (Collection<?>) rawResult;
        assertEquals(1, templates.size());
        assertEquals(classTemplate, templates.iterator().next());
    }
    
    @Test
    public void testTCSSetGetAssoBackEnd() throws Exception {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object keyword = adapter.createElement("FURCAS::TCS::Keyword");

        Collection<?> keywordsListObject = (Collection<?>) adapter.get(syntax, "keywords");
        for (Object object : keywordsListObject) {
            System.out.println(object);
        }
        assertTrue(keywordsListObject.size() == 0);
        
        adapter.set(keyword, "concretesyntax", syntax);
        
        Object rawResult = adapter.get(syntax, "keywords");
        assertNotNull(rawResult);
        assertTrue(rawResult instanceof Collection);
        Collection<?> templates = (Collection<?>) rawResult;
        assertEquals(1, templates.size());
        assertEquals(keyword, templates.iterator().next());
    }
    
    @Test
    public void testTCSSetGetRefMulti() throws Exception {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");

        assertEquals(new ArrayList<Object>(), adapter.get(syntax, "templates"));
        
        adapter.set(syntax, "templates", classTemplate);
        adapter.set(syntax, "templates", primTemplate);
        
        Object rawResult = adapter.get(syntax, "templates");
        assertNotNull(rawResult);
        assertTrue(rawResult instanceof Collection);
        Collection<?> templates = (Collection<?>) rawResult;
        assertEquals(2, templates.size());
        assertTrue(templates.contains(classTemplate));
        assertTrue(templates.contains(primTemplate));
    }

    @Test
    public void testTCSSetReference() throws Exception {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name1");
        
        assertEquals(new ArrayList<Object>(), adapter.get(syntax, "templates"));
        
        adapter.setReference(syntax, "templates", list("FURCAS", "TCS", "PrimitiveTemplate"), "templateName", "name1");
        
        Object rawResult = adapter.get(syntax, "templates");
        assertNotNull(rawResult);
        assertTrue(rawResult instanceof Collection);
        Collection<?> templates = (Collection<?>) rawResult;
        assertEquals(1, templates.size());
        assertEquals(primTemplate, templates.iterator().next());
    }
    
    @Test
    public void testTCSSetReferenceSuperClass() throws Exception {
        // test by referring to abstract superclass
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "location", "location42");
        
        assertEquals(new ArrayList<Object>(), adapter.get(syntax, "templates"));
        
        adapter.setReference(syntax, "templates", list("FURCAS", "TCS", "LocatedElement"), "location", "location42");
        
        Object rawResult = adapter.get(syntax, "templates");
        assertNotNull(rawResult);
        assertTrue(rawResult instanceof Collection);
        Collection<?> templates = (Collection<?>) rawResult;
        assertEquals(1, templates.size());
        assertEquals(primTemplate, templates.iterator().next());
    }
    
    @Test
    public void testTCSSetReferenceNull() throws Exception {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name12");
        

        Object result = adapter.setReference(syntax, "templates", list("FURCAS", "TCS", "PrimitiveTemplate"), "templateName", "error");
        assertNull(result);
    }
    
    @Test
    public void testTCSSetReferenceDuplicate() throws Exception {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name9");
        Object primTemplate2 = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        adapter.set(primTemplate2, "templateName", "name9");
    
        boolean exceptionCaught = false;
        try {
            adapter.setReference(syntax, "templates", list("FURCAS", "TCS", "PrimitiveTemplate"), "templateName", "name9");
        } catch (ReferenceSettingException e) {
            exceptionCaught = true;
        } 
        assertTrue("Expected Exception because reference is ambiguous", exceptionCaught);
    }
    
    @Test
    public void testTCSSetReferenceBadClass() throws Exception {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name2");
        boolean exceptionCaught = false;
        try {
            adapter.setReference(syntax, "templates", list("FURCAS", "TCS", "NoSuchClass"), "templateName", "name2");
        } catch (ModelAdapterException e) {
            exceptionCaught = true;
        } 
        assertTrue("Expected Exception because class does not exist", exceptionCaught);
    }

    @Test
    public void testTCSSetReferenceBadFeature() throws Exception {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name3");
        boolean exceptionCaught = false;
        try {
            adapter.setReference(syntax, "errorFeature", list("FURCAS", "TCS", "PrimitiveTemplate"), "templateName", "name3");
        } catch (ModelAdapterException e) {
            exceptionCaught = true;
        } 
        assertTrue("Expected Exception because feature does not exist", exceptionCaught);
    }

    @Test
    public void testTCSSetReferenceBadKeyFeature() throws Exception {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name4");
        boolean exceptionCaught = false;
        try {
            adapter.setReference(syntax, "templates", list("FURCAS", "TCS", "PrimitiveTemplate"), "errorFeature", "name4");
        } catch (ModelAdapterException e) {
            exceptionCaught = true;
        } 
        assertTrue("Expected Exception because key feature does not exist", exceptionCaught);
    }
    
}
