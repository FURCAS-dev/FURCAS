/*******************************************************************************
 * Copyright (c) 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.modeladaptation.emf;

import static com.sap.furcas.test.testutils.StringListHelper.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.junit.Before;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Associativity;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.test.testutils.ScopeHelper;

public class TestEMFModelAdapter {

    private TestableEMFModelAdapter adapter;
        
    @Before
    public void setup() {
        adapter = new TestableEMFModelAdapter(FURCASPackage.eINSTANCE, ScopeHelper.createResourceSet(), ScopeHelper.createFURCASReferenceScope());
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
    public void testTCSElementCreationWithUnqualifiedName() throws Exception {
        Object syntax = adapter.createElement("TCS::ConcreteSyntax");
        assertNotNull(syntax);
        assertTrue(syntax instanceof ConcreteSyntax);
        
        syntax = adapter.createElement("ConcreteSyntax");
        assertNotNull(syntax);
        assertTrue(syntax instanceof ConcreteSyntax);
    }

    @Test(expected=ModelAdapterException.class)
    public void testTCSEnumLitCreationError() throws ModelAdapterException {
        adapter.createEnumLiteral("FURCAS::TCS::ErrorTypeNothing", "left");
    }
    
    @Test(expected=ModelAdapterException.class)
    public void testTCSElementCreationError() throws ModelAdapterException {
        adapter.createElement("FURCAS::TCS::ErrorTypeNothing");
    }

    @Test
    public void testTCSEnumCreation() throws Exception {
        Object enumLit = adapter.createEnumLiteral("FURCAS::TCS::Associativity", "left");
        assertNotNull(enumLit);
        assertTrue(enumLit instanceof Associativity);
    }
    
    @Test
    public void testTCSEnumCreationWithUnQualifiedName() throws Exception {
        Object enumLit = adapter.createEnumLiteral("TCS::Associativity", "left");
        assertNotNull(enumLit);
        assertTrue(enumLit instanceof Associativity);
        
        enumLit = adapter.createEnumLiteral("Associativity", "left");
        assertNotNull(enumLit);
        assertTrue(enumLit instanceof Associativity);
    }
    
    @Test(expected=ModelAdapterException.class)
    public void testTCSSetError() throws ModelAdapterException {
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        adapter.set(classTemplate, "nonExistingPropertyName", true);
    }

    @Test(expected=ModelAdapterException.class)
    public void testTCSGetError() throws ModelAdapterException {
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        adapter.get(classTemplate, "nonExistingPropertyName");
    }

    @Test
    public void testTCSSetGetUnsetBoolean() throws ModelAdapterException {
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        assertEquals(false, adapter.get(classTemplate, "isMain"));
        
        adapter.set(classTemplate, "isMain", true);
        assertEquals(true, adapter.get(classTemplate, "isMain"));

        adapter.unset(classTemplate, "isMain", true);
        assertEquals(false, adapter.get(classTemplate, "isMain"));
    }
    
    @Test
    public void testTCSSetGetUnsetString() throws ModelAdapterException {
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        assertEquals(null, adapter.get(primTemplate, "templateName"));
        
        adapter.set(primTemplate, "templateName", "testName");
        assertEquals("testName", adapter.get(primTemplate, "templateName"));

        adapter.unset(primTemplate, "templateName", "testName");
        assertEquals(null, adapter.get(primTemplate, "templateName"));
    }
    
    @Test
    public void testTCSSetGetUnsetInteger() throws ModelAdapterException {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        assertEquals(null, adapter.get(syntax, "k"));
        
        adapter.set(syntax, "k", 3);
        assertEquals(3, adapter.get(syntax, "k"));
        
        adapter.unset(syntax, "k", 3);
        assertEquals(null, adapter.get(syntax, "k"));
    }
        
    @Test
    public void testTCSSetGetUnsetModelElement() throws ModelAdapterException {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        assertEquals(new ArrayList<Object>(), adapter.get(syntax, "templates"));
        
        adapter.set(syntax, "templates", classTemplate);
        Object rawResult = adapter.get(syntax, "templates");
        assertTrue(rawResult instanceof Collection);
        Collection<?> templates = (Collection<?>) rawResult;
        assertEquals(1, templates.size());
        assertEquals(classTemplate, templates.iterator().next());
        
        adapter.unset(syntax, "templates", classTemplate);
        assertEquals(new ArrayList<Object>(), adapter.get(syntax, "templates"));
    }
     
    /**
     * Imagine the TCS bootstrap, where we describe the concrete syntax of templates
     * using templates.
     */
    @Test
    public void testTCSGetHiddenOpposite() throws ModelAdapterException {
        Object metaClass = adapter.getMetaType("FURCAS::TCS::ClassTemplate");
        Object templateForMetaClass = adapter.createElement("FURCAS::TCS::ClassTemplate");
        
        Object metaReference = adapter.get(templateForMetaClass, "metaReference");
        assertNull(metaReference);
        
        adapter.set(templateForMetaClass, "metaReference", metaClass);
        
        Object rawResult = adapter.get(metaClass, "furcasTemplates"); // hidden opposite
        assertNotNull(rawResult);
        assertTrue(rawResult instanceof Collection);
        
        Collection<?> templates = (Collection<?>) rawResult;
        assertEquals(1, templates.size());
        assertEquals(templateForMetaClass, templates.iterator().next());
    }
    
    @Test
    public void testTCSSetGetMultivalue() throws ModelAdapterException {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");

        assertEquals(new ArrayList<Object>(), adapter.get(syntax, "templates"));
        
        adapter.set(syntax, "templates", classTemplate);
        adapter.set(syntax, "templates", primTemplate);
        
        Object rawResult = adapter.get(syntax, "templates");
        assertTrue(rawResult instanceof Collection);

        Collection<?> templates = (Collection<?>) rawResult;
        assertEquals(2, templates.size());
        assertTrue(templates.contains(classTemplate));
        assertTrue(templates.contains(primTemplate));
    }
    
    @Test
    public void testTCSSetGetOrderedMultivalueWithIndex() throws ModelAdapterException {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        Object primTemplate1 = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        Object primTemplate2 = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");

        assertEquals(new ArrayList<Object>(), adapter.get(syntax, "templates"));
        
        adapter.set(syntax, "templates", classTemplate, 0);
        adapter.set(syntax, "templates", primTemplate1, 0);
        adapter.set(syntax, "templates", primTemplate2, 2);
        // order should now be: prim1, class, prim2
        
        Object rawResult = adapter.get(syntax, "templates");
        assertTrue(rawResult instanceof Collection);
        
        ArrayList<Object> templates = new ArrayList<Object>((Collection<?>) rawResult);
        assertEquals(classTemplate, templates.get(1));
        assertEquals(primTemplate1, templates.get(0));
        assertEquals(primTemplate2, templates.get(2));
    }
    
    @Test
    public void testTCSUnsetMultivalue() throws ModelAdapterException {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");

        assertEquals(new ArrayList<Object>(), adapter.get(syntax, "templates"));
        
        adapter.set(syntax, "templates", classTemplate);
        adapter.set(syntax, "templates", primTemplate);
        
        adapter.unset(syntax, "templates", classTemplate);
        
        Object rawResult = adapter.get(syntax, "templates");
        assertTrue(rawResult instanceof Collection);
        
        Collection<?> templates = (Collection<?>) rawResult;
        assertEquals(1, templates.size());
        assertFalse(templates.contains(classTemplate));
        assertTrue(templates.contains(primTemplate));
    }

    @Test
    public void testTCSSetReference() throws ModelAdapterException {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name1");
        
        assertEquals(new ArrayList<Object>(), adapter.get(syntax, "templates"));
        
        adapter.setReferenceWithLookup(syntax, "templates", list("FURCAS", "TCS", "PrimitiveTemplate"), "templateName", "name1");
        
        Object rawResult = adapter.get(syntax, "templates");
        assertNotNull(rawResult);
        assertTrue(rawResult instanceof Collection);
        Collection<?> templates = (Collection<?>) rawResult;
        assertEquals(1, templates.size());
        assertEquals(primTemplate, templates.iterator().next());
    }
    
    @Test
    public void testTCSSetReferenceSuperClass() throws ModelAdapterException {
        // test by referring to abstract superclass
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "location", "location42");
        
        assertEquals(new ArrayList<Object>(), adapter.get(syntax, "templates"));
        
        adapter.setReferenceWithLookup(syntax, "templates", list("FURCAS", "TCS", "LocatedElement"), "location", "location42");
        
        Object rawResult = adapter.get(syntax, "templates");
        assertNotNull(rawResult);
        assertTrue(rawResult instanceof Collection);
        Collection<?> templates = (Collection<?>) rawResult;
        assertEquals(1, templates.size());
        assertEquals(primTemplate, templates.iterator().next());
    }
    
    @Test
    public void testTCSSetReferenceNull() throws ModelAdapterException {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name12");
        
        Object result = adapter.setReferenceWithLookup(syntax, "templates", list("FURCAS", "TCS", "PrimitiveTemplate"), "templateName", "error");
        assertNull(result);
    }
    
    @Test
    public void testTCSSetReferenceDuplicate() throws ModelAdapterException {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object primTemplate = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        adapter.set(primTemplate, "templateName", "name9");
        Object primTemplate2 = adapter.createElement("FURCAS::TCS::PrimitiveTemplate");
        adapter.set(primTemplate2, "templateName", "name9");

        boolean exceptionCaught = false;
        try {
            adapter.setReferenceWithLookup(syntax, "templates", list("FURCAS", "TCS", "PrimitiveTemplate"), "templateName", "name9");
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
            adapter.setReferenceWithLookup(syntax, "templates", list("FURCAS", "TCS", "NoSuchClass"), "templateName", "name2");
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
            adapter.setReferenceWithLookup(syntax, "errorFeature", list("FURCAS", "TCS", "PrimitiveTemplate"), "templateName", "name3");
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
            adapter.setReferenceWithLookup(syntax, "templates", list("FURCAS", "TCS", "PrimitiveTemplate"), "errorFeature", "name4");
        } catch (ModelAdapterException e) {
            exceptionCaught = true;
        } 
        assertTrue("Expected Exception because key feature does not exist", exceptionCaught);
    }
    
    @Test
    public void testTCSInstanceOf() throws ModelAdapterException {
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        assertNotNull(classTemplate);
        
        assertTrue(adapter.instanceOf(classTemplate, TCSPackage.Literals.TEMPLATE));
        assertTrue(adapter.instanceOf(classTemplate, TCSPackage.Literals.CLASS_TEMPLATE));
        assertTrue(adapter.instanceOf(classTemplate, TCSPackage.Literals.LOCATED_ELEMENT));
        
        assertFalse(adapter.instanceOf(classTemplate, TCSPackage.Literals.PRIMITIVE_TEMPLATE));
        assertFalse(adapter.instanceOf(classTemplate, TCSPackage.Literals.KEYWORD));
    }
    
    @Test
    public void testTCSGetMetaType() throws ModelAdapterException {
        EObject classTemplate = (EObject) adapter.createElement("FURCAS::TCS::ClassTemplate");
        
        Object classTemplateMetaType = adapter.getMetaType("FURCAS::TCS::ClassTemplate");
        assertNotNull(classTemplateMetaType);
        assertEquals(classTemplate.eClass(), classTemplateMetaType);
    }
    
    @Test
    public void testTCSGetMetaTypeWithUnqualifiedName() throws ModelAdapterException {
        EObject classTemplate = (EObject) adapter.createElement("FURCAS::TCS::ClassTemplate");
        
        Object classTemplateMetaType = adapter.getMetaType("TCS::ClassTemplate");
        assertNotNull(classTemplateMetaType);
        assertEquals(classTemplate.eClass(), classTemplateMetaType);
        
        classTemplateMetaType = adapter.getMetaType("ClassTemplate");
        assertNotNull(classTemplateMetaType);
        assertEquals(classTemplate.eClass(), classTemplateMetaType);
    }
    
    public void testTCSGetMetaTypeInstanceOfInteraction() throws ModelAdapterException {
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        assertNotNull(classTemplate);
        
        assertTrue(adapter.instanceOf(classTemplate, adapter.getMetaType("FURCAS::TCS::Template")));
        assertTrue(adapter.instanceOf(classTemplate, adapter.getMetaType("FURCAS::TCS::ClassTemplate")));
        assertTrue(adapter.instanceOf(classTemplate, adapter.getMetaType("FURCAS::TCS::LocatedElement")));
        
        assertFalse(adapter.instanceOf(classTemplate, adapter.getMetaType("FURCAS::TCS::PrimitiveTemplate")));
        assertFalse(adapter.instanceOf(classTemplate, adapter.getMetaType("FURCAS::TCS::Keyword")));
    }
        
    @Test
    public void testTCSSetReferenceWithOCLQuery() throws ModelAdapterException {
        Object syntax = adapter.createElement("FURCAS::TCS::ConcreteSyntax");
        Object classTemplate = adapter.createElement("FURCAS::TCS::ClassTemplate");
        adapter.set(syntax, "templates", classTemplate);
        
        Object opList = adapter.createElement("FURCAS::TCS::OperatorList");
        adapter.set(opList, "name", "test");
        adapter.set(syntax, "operatorLists", opList);
        
        String oclQuery = "OCL:self.concreteSyntax.operatorLists->select(list | list.name = ?)";
        
        // first, just run the query
        Collection<?> result = adapter.evaluateOCLQuery(classTemplate, "test", oclQuery, /*contextObject*/ null);
        assertEquals(1, result.size());
        assertEquals(opList, result.iterator().next());
        
        // run the query again and use it to set the reference
        adapter.setReferenceWithOCLQuery(classTemplate, "operatorList", "test", oclQuery, /*contextObject*/ null, /*currentForeachElement*/ null);
        
        assertEquals(opList, adapter.get(classTemplate, "operatorList"));
    }
    
    @Test
    public void testTCSElementsOfType() throws Exception {
        Object literal1 = adapter.createElement("FURCAS::TCS::Keyword");
        Object literal2 = adapter.createElement("FURCAS::TCS::Symbol");
        
        Object template1 = adapter.createElement("FURCAS::TCS::ClassTemplate");
        Object template2 = adapter.createElement("FURCAS::TCS::OperatorTemplate");

        // search for super type and hope to find the sub-classes
        Collection<?> resultWithLiterals = adapter.getElementsOfType("FURCAS::TCS::Literal");
        assertEquals(2, resultWithLiterals.size());
        assertTrue(resultWithLiterals.contains(literal1));
        assertTrue(resultWithLiterals.contains(literal2));
        
        // search for super type and hope to find the sub-classes
        Collection<?> resultWithTemplates = adapter.getElementsOfType("FURCAS::TCS::Template");
        assertEquals(2, resultWithTemplates.size());
        assertTrue(resultWithTemplates.contains(template1));
        assertTrue(resultWithTemplates.contains(template2));
        
        // search for specific type
        Collection<?> resultWithClassTemplate = adapter.getElementsOfType("FURCAS::TCS::ClassTemplate");
        assertEquals(1, resultWithClassTemplate.size());
        assertTrue(resultWithClassTemplate.contains(template1));
    }
}
