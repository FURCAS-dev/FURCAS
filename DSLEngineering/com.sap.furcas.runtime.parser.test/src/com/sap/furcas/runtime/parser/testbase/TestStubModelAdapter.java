package com.sap.furcas.runtime.parser.testbase;

import static com.sap.furcas.test.testutils.StringListHelper.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.sap.furcas.test.testutils.StringListHelper;

/**
 * Tests the Stub ModelAdapter used in Scenario tests.
 */
public class TestStubModelAdapter {

    @Test
    public void testStubHandlerCreate() throws Exception {
        StubModelAdapter handler = new StubModelAdapter();

        Object object = handler.createElement(list("test"));
        assertNotNull(object);
        Set<StubModelElement> objects = handler.getElementsbyType("test");
        assertNotNull(objects);
        assertEquals(1, objects.size());
        assertTrue(objects.contains(object));

        Object object2 = handler.createElement(list("test"));
        objects = handler.getElementsbyType("test");
        assertNotNull(objects);
        assertEquals(2, objects.size());
        assertTrue(objects.contains(object));
        assertTrue(objects.contains(object2));

        objects = handler.getElementsbyType("test");
        assertNotNull(objects);
        assertEquals(2, objects.size());
        objects = handler.getElementsbyType("test2");
        assertNull("No such element was created", objects);
    }

    @Test
    public void testStubHandlerSet() throws Exception {
        StubModelAdapter handler = new StubModelAdapter();

        Object object = handler.createElement(list("test"));
        assertNotNull(object);
        assertNull(handler.get(object, "name"));
        handler.set(object, "name", "name1");
        assertEquals("name1", handler.get(object, "name"));

        object = handler.createElement(list("test"));
        handler.set(object, "name", "name2");
        assertEquals("name2", handler.get(object, "name"));

        object = handler.createElement(list("Other"));

        Object object2 = handler.createElement(list("Other"));
        handler.set(object, "reference", object2);
        assertEquals(object2, handler.get(object, "reference"));
    }

    @Test
    public void testStubHandlerSetRef() throws Exception {
        StubModelAdapter handler = new StubModelAdapter();

        Object object = handler.createElement(list("test"));

        Object object1 = handler.createElement(list("Other"));
        handler.set(object1, "id", "1111");
        Object object2 = handler.createElement(list("Other"));
        handler.set(object2, "id", "1234");
        Object object3 = handler.createElement(list("Other"));
        handler.set(object3, "id", "4444");
        handler.setReference(object, "reference", StringListHelper.list("Other"), "id", "1234");
        assertEquals(object2, handler.get(object, "reference"));
    }

}
