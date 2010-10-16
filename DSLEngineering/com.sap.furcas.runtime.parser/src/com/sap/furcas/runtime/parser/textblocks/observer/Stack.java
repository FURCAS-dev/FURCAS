/**
 * 
 */
package com.sap.furcas.runtime.parser.textblocks.observer;

/**
 * List-based implementation of the stack (not synchronized like java.util.Stack).
 */
public class Stack<Type extends Object> {
    

    private ListNode<Type> topOfStack;
    
    /**
     * Construct the stack.
     */
    public Stack( ) {
        topOfStack = null;
    }
    
    /**
     * Test if the stack is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( ) {
        return topOfStack == null;
    }
    
    /**
     * Make the stack logically empty.
     */
    public void clear( ) {
        topOfStack = null;
    }
    
    /**
     * Insert a new item into the stack.
     * @param x the item to insert.
     */
    public void push( Type x ) {
        topOfStack = new ListNode<Type>( x, topOfStack );
    }
    
    /**
     * Remove the most recently inserted item from the stack.
     * @throws IllegalStateException if the stack is empty.
     */
    public Type pop( ) {
        if( isEmpty( ) )
            throw new IllegalStateException( "ListStack pop on empty Stack" );
        Type result = topOfStack.element;
        topOfStack = topOfStack.next;
        return result;
    }
    
    /**
     * Get the most recently inserted item in the stack.
     * Does not alter the stack.
     * @return the most recently inserted item in the stack.
     * @throws IllegalStateException if the stack is empty.
     */
    public Type peek( ) {
        if( isEmpty( ) )
            throw new IllegalStateException( "ListStack peek on empty Stack" );
        return topOfStack.element;
    }
    
   
    class ListNode<NodeType> {

        public ListNode( NodeType theElement, ListNode<NodeType> n ) {
            element = theElement;
            next    = n;
        }
        
        public NodeType   element;
        public ListNode<NodeType> next;
    }

}
