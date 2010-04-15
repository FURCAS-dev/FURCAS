package de.hpi.sam.bp2009.moin.impactAnalyzer.tag;

/**
 * This class represents a enumeration of classifications for
 * <tt>SubExpression</tt> and <tt>OclStatement</tt>s.
 * 
 * @author Thomas Hettel (D039141)
 */
public final class ExpressionKind {

    private final String kind;

    /**
     * @param theKind
     */
    private ExpressionKind( String theKind ) {

        this.kind = theKind;
    }

    /**
     * a <tt>SubExpression</tt> or a <tt>OclStatement</tt> can be classifed
     * as <tt>INSTANCE</tt> if it does not containy any calls to
     * <tt>allInstances()</tt> of a type
     */
    public final static ExpressionKind INSTANCE = new ExpressionKind( "INSTANCE" ); //$NON-NLS-1$

    /**
     * a <tt>SubExpression</tt> or a <tt>OclStatement</tt> can be classifed
     * as <tt>CLASS</tt> if it does only containy calls to
     * <tt>allInstances()</tt> of a type and does not refer to <tt>self</tt>.
     */
    public final static ExpressionKind CLASS = new ExpressionKind( "CLASS" ); //$NON-NLS-1$

    /**
     * a <tt>OclStatement</tt> can be classifed as <tt>PARTIAL</tt> if it is
     * not <tt>INSTANCE</tt> or <tt>CLASS</tt>.
     */
    public final static ExpressionKind PARTIAL = new ExpressionKind( "PARTIAL" ); //$NON-NLS-1$

    /**
     * @return the String representation
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString( ) {

        return this.kind;
    }
}