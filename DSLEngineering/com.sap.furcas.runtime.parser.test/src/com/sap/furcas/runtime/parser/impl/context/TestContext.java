/**
 * 
 */
package com.sap.furcas.runtime.parser.impl.context;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

import java.util.Collection;
import java.util.Set;

import org.junit.Test;



/**
 *
 */
public class TestContext {

    @Test
    public void testConstructor() throws Exception {
        Context context = new Context();
        assertNull(context.getParent());
        assertNull(context.getElement());
        
        assertNull(context.getChildContexts());
        assertNotNull(context.iterator());
    }
    
    @Test
    public void testCreate() throws Exception {
        Context parent = new Context();
        String test = "test";
        
        Context child = parent.createContext(test);
        
        assertEquals(parent, child.getParent());
        assertEquals(test, child.getElement());
        
        assertTrue(parent.getChildContexts().contains(child));
        assertEquals(1, parent.getChildContexts().size());
        
        assertNotNull(child.iterator());
    }
    
    @Test
    public void testAdd() throws Exception {
        Context parent = new Context();
        String test = "test";
        parent.add(test);
        
        ContextIterator it = parent.iterator();
        assertNotNull(it);
        assertTrue(it.hasNext());
        assertEquals(test, it.next());
        assertFalse(it.hasNext());
    }
    
    @Test
    public void testSet() throws Exception {
        Context parent = new Context();
        String test = "test";
        parent.setElement(test);
        assertEquals(test, parent.getElement());
    }
    
    @Test
    public void testReplace() throws Exception {
        Context parent = new Context();
        String test = "test";
        String test2 = "test2";
        parent.add(test);
        parent.add(test2);
        
        String test3 = "test3";
        parent.replaceElement(test2, test3);
        
        ContextIterator it = parent.iterator();
        assertNotNull(it);
        assertTrue(it.hasNext());
        assertEquals(test, it.next());
        assertTrue(it.hasNext());
        assertEquals(test3, it.next());
        assertFalse(it.hasNext());
    }
    
    @Test
    public void testRemove() throws Exception {
        Context parent = new Context();
        String test = "test";
        String test2 = "test2";
        parent.add(test);
        parent.add(test2);
        
        
        parent.remove(test2);
        
        ContextIterator it = parent.iterator();
        assertNotNull(it);
        assertTrue(it.hasNext());
        assertEquals(test, it.next());
        assertFalse(it.hasNext());
    }
    
    @Test
    public void testRemoveWithChildren() throws Exception {
        Context parent = new Context();
        String test6 = "test6";
        parent.add(test6);
        
        String test = "test";
        Context child = parent.createContext(test);
        String test5 = "test5";
        child.add(test5);
        
        String test4 = "test4";
        Context otherchild = parent.createContext(test4);
        
        String test2 = "test2";
        Context childChild = child.createContext(test2);
        
        String test3 = "test3";
        childChild.add(test3);
       
        Set<Object> resultlist = Context.removeWithChildren(child);
        
        assertEquals(4, resultlist.size());
        assertTrue( resultlist.contains(test));
        assertTrue( resultlist.contains(test2));
        assertTrue( resultlist.contains(test3));
        assertTrue( resultlist.contains(test5));
        
        assertNull(parent.getElement());
        assertNull(child.getParent());
        assertEquals(parent, otherchild.getParent());
        Collection<Context> remainingChilds = parent.getChildContexts();
        assertEquals(1, remainingChilds.size());
        assertTrue(remainingChilds.contains(otherchild));
        
        ContextIterator it = parent.iterator();
        assertNotNull(it);
        assertTrue(it.hasNext());
        assertEquals(test6, it.next());
        assertFalse(it.hasNext());
    }
    
}
