package org.eclipse.imp.services;

public interface IASTMatchAdapter {

    /**
     * @return the value of the child of the given AST node at the given position
     */
    public abstract Object getChildAtPosition(int pos, Object astNode);

    /**
     * @return a possibly empty array of immediate children of the given AST node
     * <code>astNode</code> in positional order
     */
    public abstract Object[] getChildren(Object astNode);

    /**
     * Returns the character offset (not the byte offset) of the first character of
     * source text corresponding to the given AST node <code>astNode</code>.
     */
    public abstract int getOffset(Object astNode);

    /**
     * Returns a boolean value indicating whether or not this AST node is
     * a meta variable (placeholder) for a real AST node. This is used for matching AST patterns
     * against real AST's.
     */
    public abstract boolean isMetaVariable(Object astNode);

    /**
     * Returns a boolean value indicating whether or not this AST is to be
     * considered a list. A list node that a varyadic number of children, as
     * opposed to a normal AST node which has a fixed number of children.
     */
    public abstract boolean isList(Object astNode);

}