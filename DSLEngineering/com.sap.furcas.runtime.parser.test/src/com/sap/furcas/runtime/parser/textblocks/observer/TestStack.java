package com.sap.furcas.runtime.parser.textblocks.observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestStack  {
    
    @Test
    public void testpushPop() {
        Stack<Object> stack = new Stack<Object>();
        
        stack.push("test1");
        stack.push("test2");
        
        assertEquals("test2", stack.peek());
        assertEquals("test2", stack.pop());
        
        assertEquals("test1", stack.peek());
        assertEquals("test1", stack.pop());
        
        assertTrue(stack.isEmpty());
    }
    
    @Test
    public void testPushPop2() {
        Stack<Object> stack = new Stack<Object>();
        
        stack.push("test1");
        stack.pop();
        stack.push("test2");
        
        assertEquals("test2", stack.peek());
        assertEquals("test2", stack.pop());

        
        assertTrue(stack.isEmpty());
    }
    
    
    @Test
    public void testNewStackException() {
        Stack<Object> stack = new Stack<Object>();
        
        boolean caught;
        caught = false;
        try {
            stack.peek();
        } catch (IllegalStateException e) {
            caught = true;
        }
        assertTrue("Exception expected", caught);
        
        caught = false;
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            caught = true;
        }
        assertTrue("Exception expected", caught);
    }
    
    @Test
    public void testNewStack() {
        Stack<Object> stack = new Stack<Object>();
        
        assertTrue(stack.isEmpty());
    }
}
