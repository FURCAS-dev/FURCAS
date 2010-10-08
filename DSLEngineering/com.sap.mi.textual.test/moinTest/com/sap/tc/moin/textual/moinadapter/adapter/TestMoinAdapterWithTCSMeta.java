/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter;

import static com.sap.furcas.parsergenerator.testutils.StringListHelper.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.metamodel.TCS.Associativity;
import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.LocatedElement;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;

/**
 * Tests the moin Model adapter with a Moin in Eclipse connection and the TCS Metamodel.
 */
public class TestMoinAdapterWithTCSMeta {

    private static Connection connection;
    private static Set<PRI> transPRI = new HashSet<PRI>();
    
    @BeforeClass
    public static void setup() {
        try {
            connection = ConnectionManager.getInstance().createTransientConnection();
            Collection<ModelPartition> transparts = connection.getTransientPartitions();
            for (ModelPartition modelPartition : transparts) {
                transPRI.add(modelPartition.getPri());
            }
        } catch(IllegalStateException ex) {
            if (ex.getMessage().equals("Workspace is closed.")) {
                fail("Test can only be run as Eclipse Plugin Test.");
            } else {
                throw ex;
            }
        }
    }
    
    @AfterClass
    public static void tearDown() {
        if(connection != null) {
            connection.close();
        }
    
    }
    
    @Test
    public void testTCSJMI() throws Exception {
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        
        JmiHelper jmihelper = connection.getJmiHelper();
        assertNotNull(jmihelper.findRefPackageByQualifiedName(list("TCS"), rootPkg));
        assertNotNull(jmihelper.findElementByQualifiedName(list("TCS", "ConcreteSyntax"), rootPkg));
        assertNotNull(jmihelper.findElementByQualifiedName(list("TCS", "Template"), rootPkg));
        assertNotNull(jmihelper.findElementByQualifiedName(list("TCS", "Keyword"), rootPkg));
    }
    
    @Test
    public void testTCSElementCreation() throws Exception {
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object syntax = adapter.createElement("TCS::ConcreteSyntax");
        assertNotNull(syntax);
        assertTrue(syntax instanceof ConcreteSyntax);
        
        Object classTemplate = adapter.createElement("TCS::ClassTemplate");
        assertNotNull(classTemplate);
        assertTrue(classTemplate instanceof ClassTemplate);
        
    }

    @Test
    public void testTCSEnumLitCreationError() {
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        boolean exceptionCaught = false;
        try {
            adapter.createEnumLiteral("TCS::ErrorTypeNothing", "left");
        } catch (ModelAdapterException e) {
            exceptionCaught = true;
        }
        assertTrue("Expected Exception because type does not exist", exceptionCaught);

    }
    
    @Test
    public void testTCSElementCreationError() throws Exception {
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        boolean exceptionCaught = false;
        try {
            adapter.createElement("TCS::ErrorTypeNothing");
        } catch (ModelAdapterException e) {
            exceptionCaught = true;
        }
        assertTrue("Expected Exception because type does not exist", exceptionCaught);


    }

    @Test
    public void testTCSEnumLitCreation() throws Exception {
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object enumLit = adapter.createEnumLiteral("TCS::Associativity", "left");
        assertNotNull(enumLit);
        assertTrue(enumLit instanceof Associativity);

    }
    
    @Test
    public void testTCSSetError() throws Exception {
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object classTemplate = adapter.createElement("TCS::ClassTemplate");
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
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);

        Object classTemplate = adapter.createElement("TCS::ClassTemplate");
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
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object classTemplate = adapter.createElement("TCS::ClassTemplate");

        assertEquals(false, adapter.get(classTemplate, "isMain"));
        
        adapter.set(classTemplate, "isMain", true);
        
        assertEquals(true, adapter.get(classTemplate, "isMain"));

    }
    
    @Test
    public void testTCSSetGetString() throws Exception {
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object primTemplate = adapter.createElement("TCS::PrimitiveTemplate");

        assertEquals(null, adapter.get(primTemplate, "templateName"));
        
        adapter.set(primTemplate, "templateName", "testName");
        
        assertEquals("testName", adapter.get(primTemplate, "templateName"));

    }
    
    @Test
    public void testTCSSetGetInteger() throws Exception {
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object syntax = adapter.createElement("TCS::ConcreteSyntax");

        assertEquals(null, adapter.get(syntax, "k"));
        
        adapter.set(syntax, "k", 3);
        
        assertEquals(3, adapter.get(syntax, "k"));
    }
    
    @Test
    public void testTCSInstanceOf() throws Exception {
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object classTemplate = adapter.createElement("TCS::ClassTemplate");

        assertTrue(adapter.instanceOf(classTemplate, connection.getClass(Template.CLASS_DESCRIPTOR).refMetaObject()));
        assertTrue(adapter.instanceOf(classTemplate, connection.getClass(ClassTemplate.CLASS_DESCRIPTOR).refMetaObject()));
        assertTrue(adapter.instanceOf(classTemplate, connection.getClass(LocatedElement.CLASS_DESCRIPTOR).refMetaObject()));
        
    }

    @Test
    @Ignore
    public void testTCSQuery() throws Exception {
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
     // ... TODO test setup for MQL query
        Object syntax = adapter.createElement("TCS::ConcreteSyntax");
        Object classTemplate = adapter.createElement("TCS::ClassTemplate");
        adapter.set(syntax, "templates", classTemplate);
        
        Object opList = adapter.createElement("TCS::OperatorList");
        adapter.set(opList, "name", "test");
        adapter.set(syntax, "operatorLists", opList);
        
        String oclQuery = "Select from where";
        adapter.setOclReference(classTemplate, "operatorList", "test", oclQuery, null, null);
    }
    
    @Test
    public void testTCSSetGetAsso() throws Exception {
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object syntax = adapter.createElement("TCS::ConcreteSyntax");
        Object classTemplate = adapter.createElement("TCS::ClassTemplate");

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
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object syntax = adapter.createElement("TCS::ConcreteSyntax");
        Object keyword = adapter.createElement("TCS::Keyword");

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
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object syntax = adapter.createElement("TCS::ConcreteSyntax");
        Object classTemplate = adapter.createElement("TCS::ClassTemplate");
        Object primTemplate = adapter.createElement("TCS::PrimitiveTemplate");

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
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object syntax = adapter.createElement("TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name1");
        
        assertEquals(new ArrayList<Object>(), adapter.get(syntax, "templates"));
        
        adapter.setReference(syntax, "templates", list("TCS","PrimitiveTemplate"), "templateName", "name1");
        
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
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object syntax = adapter.createElement("TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "location", "location42");
        
        assertEquals(new ArrayList<Object>(), adapter.get(syntax, "templates"));
        
        adapter.setReference(syntax, "templates", list("TCS","LocatedElement"), "location", "location42");
        
        Object rawResult = adapter.get(syntax, "templates");
        assertNotNull(rawResult);
        assertTrue(rawResult instanceof Collection);
        Collection<?> templates = (Collection<?>) rawResult;
        assertEquals(1, templates.size());
        assertEquals(primTemplate, templates.iterator().next());
    }
    
    @Test
    public void testTCSSetReferenceNull() throws Exception {
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object syntax = adapter.createElement("TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name12");
        

        Object result = adapter.setReference(syntax, "templates", list("TCS","PrimitiveTemplate"), "templateName", "error");
        assertNull(result);
    }
    
    @Test
    public void testTCSSetReferenceDuplicate() throws Exception {
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object syntax = adapter.createElement("TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name9");
        Object primTemplate2 = adapter.createElement("TCS::PrimitiveTemplate");
        adapter.set(primTemplate2, "templateName", "name9");
    
        boolean exceptionCaught = false;
        try {
            adapter.setReference(syntax, "templates", list("TCS","PrimitiveTemplate"), "templateName", "name9");
        } catch (ReferenceSettingException e) {
            exceptionCaught = true;
        } 
        assertTrue("Expected Exception because reference is ambiguous", exceptionCaught);
    }
    
    @Test
    public void testTCSSetReferenceBadClass() throws Exception {
        
        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);
        
        Object syntax = adapter.createElement("TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name2");
        boolean exceptionCaught = false;
        try {
            adapter.setReference(syntax, "templates", list("TCS","NoSuchClass"), "templateName", "name2");
        } catch (ModelAdapterException e) {
            exceptionCaught = true;
        } 
        assertTrue("Expected Exception because class does not exist", exceptionCaught);
    }

    @Test
    public void testTCSSetReferenceBadFeature() throws Exception {

        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);

        Object syntax = adapter.createElement("TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name3");
        boolean exceptionCaught = false;
        try {
            adapter.setReference(syntax, "errorFeature", list("TCS","PrimitiveTemplate"), "templateName", "name3");
        } catch (ModelAdapterException e) {
            exceptionCaught = true;
        } 
        assertTrue("Expected Exception because feature does not exist", exceptionCaught);
    }

    @Test
    public void testTCSSetReferenceBadKeyFeature() throws Exception {

        final RefPackage rootPkg = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
        assertNotNull(rootPkg);
        MOINModelAdapterTestAdapter adapter = new MOINModelAdapterTestAdapter(rootPkg, connection, transPRI, null);

        Object syntax = adapter.createElement("TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name4");
        boolean exceptionCaught = false;
        try {
            adapter.setReference(syntax, "templates", list("TCS","PrimitiveTemplate"), "errorFeature", "name4");
        } catch (ModelAdapterException e) {
            exceptionCaught = true;
        } 
        assertTrue("Expected Exception because key feature does not exist", exceptionCaught);
    }
    
}
