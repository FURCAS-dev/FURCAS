/**
 * 
 */
package com.sap.furcas.runtime.parser.impl.context;


import static com.sap.furcas.runtime.parser.testutils.StringListHelper.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.interfaces.IModelElementInvestigator;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.impl.ModelElementProxy;

/**
 * tests the ContextManager class.
 */
public class TestContextManager {

    @Test
    public void testAddRemove() throws Exception {
        ContextManager manager = new ContextManager();
        
        
        IModelElementProxy proxy = new ModelElementProxy(list("test"), false);
        assertFalse(manager.hasInTextContext(proxy));
        assertEquals(null, manager.getContextForElement(proxy));
        
        manager.addRootContext(proxy, null);
        
        assertTrue(manager.hasInTextContext(proxy));
        assertEquals(proxy, manager.getContextForElement(proxy));
        
    }
    
    @Test
    public void testGetTaggedContextNullTag() throws Exception {
        ContextManager manager = new ContextManager();
        
        assertEquals(null, manager.getTaggedContext(new Object(), null));
        
        IModelElementProxy proxy = new ModelElementProxy(list("test"), false);
        
        manager.addRootContext(proxy, null);
        
        // no tag means proxy itself should be returned
        assertEquals(proxy, manager.getTaggedContext(proxy, null));
        
        // context is only returned when passing in context objects
        Object someObject = new Object();
        manager.addToContext(someObject, proxy);
        assertNull(manager.getTaggedContext(someObject, null));
    }
    
    @Test
    public void testGetTaggedContextStringTag() throws Exception {
        ContextManager manager = new ContextManager();
        
        assertEquals(null, manager.getTaggedContext(new Object(), "tag"));
        
        IModelElementProxy proxy = new ModelElementProxy(list("test"), false);
        
        manager.addRootContext(proxy, new String[]{"tag1", "tag2"});
        
        // no tag means proxy itself should be returned
        assertEquals(proxy, manager.getTaggedContext(proxy, null));
        assertEquals(proxy, manager.getTaggedContext(proxy, "tag1"));
        assertEquals(proxy, manager.getTaggedContext(proxy, "tag2"));
        
        assertEquals(null, manager.getTaggedContext(proxy, "tag3"));
        assertEquals(null, manager.getTaggedContext(null, "tag1"));
        
        Object someObject = new Object();
        manager.addToContext(someObject, proxy);
        assertNull(manager.getTaggedContext(someObject, "tag1"));
    }

    @Test
    public void testGetTaggedContextStringTagDeep() throws Exception {
        // this is the real case for the usage of tags
        ContextManager manager = new ContextManager();
        
        assertEquals(null, manager.getTaggedContext(new Object(), "tag"));
        
        IModelElementProxy proxy = new ModelElementProxy(list("test"), false);
        manager.addRootContext(proxy, new String[]{"tagRoot"});
        IModelElementProxy proxy2 = new ModelElementProxy(list("test2"), false);
        manager.addContextChildFor(proxy, proxy2, new String[]{"foo", "bar"});
        IModelElementProxy proxy3 = new ModelElementProxy(list("test3"), false);
        manager.addContextChildFor(proxy2, proxy3, new String[]{"leaf"});
        
        // no tag means proxy itself should be returned
        assertEquals(proxy, manager.getTaggedContext(proxy3, "tagRoot"));
        assertEquals(proxy2, manager.getTaggedContext(proxy3, "foo"));
        assertEquals(proxy2, manager.getTaggedContext(proxy3, "bar"));
        assertEquals(proxy3, manager.getTaggedContext(proxy3, "leaf"));
        assertEquals(proxy3, manager.getTaggedContext(proxy3, null));
        
        assertEquals(proxy, manager.getTaggedContext(proxy2, "tagRoot"));
        assertEquals(proxy2, manager.getTaggedContext(proxy2, "foo"));
        assertEquals(proxy2, manager.getTaggedContext(proxy2, "bar"));
        assertEquals(null, manager.getTaggedContext(proxy2, "leaf"));
        
    }
    
    
    @Test
    public void testProxyResolved() throws Exception {
        ContextManager manager = new ContextManager();
        
        
        IModelElementProxy proxy = new ModelElementProxy(list("test"), false);
        assertFalse(manager.hasInTextContext(proxy));
        assertEquals(null, manager.getContextForElement(proxy));
        
        manager.addRootContext(proxy, null);
        assertTrue(manager.hasInTextContext(proxy));
        assertEquals(proxy, manager.getContextForElement(proxy));
        Object element = new Object();
        assertFalse(manager.hasInTextContext(element));
        assertEquals(null, manager.getContextForElement(element));
        
        manager.notifyProxyResolvedWith(proxy, element, null);
        //now manager should recognize element and not recognize proxy anymore 
        assertFalse(manager.hasInTextContext(proxy));
        assertEquals(null, manager.getContextForElement(proxy));
        assertTrue(manager.hasInTextContext(element));
        assertEquals(element, manager.getContextForElement(element));
    }
    
    @Test
    public void testGetParent() throws Exception {
        ContextManager manager = new ContextManager();
        
        
        IModelElementProxy proxy = new ModelElementProxy(list("test"), false);
        manager.addRootContext(proxy, null);
        IModelElementProxy proxy2 = new ModelElementProxy(list("test2"), false);
        manager.addContextChildFor(proxy, proxy2, null);
        IModelElementProxy proxy3 = new ModelElementProxy(list("test3"), false);
        manager.addContextChildFor(proxy2, proxy3, null);
        
        assertTrue(manager.hasInTextContext(proxy));
        assertEquals(proxy, manager.getContextForElement(proxy));
        assertTrue(manager.hasInTextContext(proxy2));
        assertEquals(proxy2, manager.getContextForElement(proxy2));
        assertTrue(manager.hasInTextContext(proxy3));
        assertEquals(proxy3, manager.getContextForElement(proxy3));
        
        assertEquals(proxy2, manager.getContextParent(proxy3));
        assertEquals(proxy, manager.getContextParent(proxy2));
        assertEquals(null, manager.getContextParent(proxy));
    }
    
    @Test
    public void testAddElementToContext() throws Exception {
        ContextManager manager = new ContextManager();
        
        IModelElementProxy proxy = new ModelElementProxy(list("test"), false);
        manager.addRootContext(proxy, null);
        Object element = new Object();
        manager.addToContext(proxy, element);
        
        assertTrue(manager.hasInTextContext(proxy));
        assertEquals(proxy, manager.getContextForElement(proxy));
        assertEquals(null, manager.getContextForElement(element));
        
        // fake setup so that lookup finds element to be a candidate
        SimpleAdapterStub modelAdapter = new SimpleAdapterStub();
        modelAdapter.feature = "test";
        Object result = manager.findCandidatesInContext(modelAdapter, proxy, null, null, "test");
        
        assertEquals(element, result);
    }
    
    
    class SimpleAdapterStub implements IModelElementInvestigator {

        public boolean isInstanceOf = true;
        public Object metatype = new Object();
        public Object feature;

        /* (non-Javadoc)
         * @see com.sap.mi.textual.grammar.IModelElementInvestigator#get(java.lang.Object, java.lang.String)
         */
        @Override
        public Object get(Object modelElement, String propertyName)
                throws ModelAdapterException {
            return feature;
        }

        /* (non-Javadoc)
         * @see com.sap.mi.textual.grammar.IModelElementInvestigator#getMetaType(java.util.List)
         */
        @Override
        public Object getMetaType(List<String> typeName)
                throws ModelAdapterException {
            return metatype;
        }

        /* (non-Javadoc)
         * @see com.sap.mi.textual.grammar.IModelElementInvestigator#instanceOf(java.lang.Object, java.lang.Object)
         */
        @Override
        public boolean instanceOf(Object instance, Object metaType)
                throws ModelAdapterException {
            return isInstanceOf;
        }
    }
}
