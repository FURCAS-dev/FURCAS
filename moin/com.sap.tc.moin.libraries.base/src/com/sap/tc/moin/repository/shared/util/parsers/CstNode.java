package com.sap.tc.moin.repository.shared.util.parsers;

/**
 * Utility interface for nodes
 */
public interface CstNode {

    boolean equals( Object o );

    int hashCode( );

    String toString( );

    /**
     * @return the start offset
     */
    int getStartOffset( );

    /**
     * @return the line
     */
    int getLine( );

    /**
     * @return the column
     */
    int getColumn( );

    /**
     * @return the end offset
     */
    int getEndOffset( );

    /**
     * @return the end line
     */
    int getEndLine( );

    /**
     * @return the end column
     */
    int getEndColumn( );
}
