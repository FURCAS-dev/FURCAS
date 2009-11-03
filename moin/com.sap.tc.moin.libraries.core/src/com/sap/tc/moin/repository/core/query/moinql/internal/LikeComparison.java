/*
 * Created on 16.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

import com.sap.tc.moin.repository.core.query.moinql.shared.MQLAuxServices;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlLikeConstraint;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlPrimitiveType;

/**
 * This predicate is true if the attribute value is an instance of the pattern
 * in stringPattern. A pattern is a string and may contain the following special
 * pattern matching characters:
 * <ul>
 * <li>'?' : matches with any character</li>
 * <li>'*' : matches with any sequence of characters, including the empty
 * sequence</li>
 * <li>'\' : escapes the pattern matching characters '?' and '*', including '\',
 * i.e. itself</li>
 * </ul>
 */
final public class LikeComparison extends ConstantComparison implements SpiFqlLikeConstraint {

    private String stringPattern;

    private boolean not;

    public LikeComparison( AtomicEntry _alias, String _attrName, boolean not, String _stringPattern ) {

        this.atomicEntry = _alias;
        this.attrName = _attrName;
        this.stringPattern = _stringPattern;
        this.attrType = SpiFqlPrimitiveType.STRING;
        this.not = not;
    }

    public String getLikePattern( ) {

        return this.stringPattern;
    }

    public void setLikePattern( String stringPattern ) {

        this.stringPattern = stringPattern;
    }

    public boolean isNegated( ) {

        return this.not;
    }

    /*
     * Pretty-printing
     */
    @Override
    public String toString( int indent, StringBuilder accumSb ) {

        StringBuilder sb = new StringBuilder( );

        sb.append( this.attrName );

        if ( this.isMultiValued ) {
            sb.append( MQLAuxServices.OPENPAREN_T + MQLAuxServices.ISMULTIVALUED_T + MQLAuxServices.CLOSEPAREN_T );
        }

        String pattern = ( this.stringPattern == null ? "null" : MQLAuxServices.OPENQUOTE_T + this.stringPattern + MQLAuxServices.CLOSEQUOTE_T ); //$NON-NLS-1$

        if ( this.not ) {
            sb.append( MQLAuxServices.SPACE_T + MQLAuxServices.NOT_T );
        }

        sb.append( MQLAuxServices.SPACE_T + MQLAuxServices.LIKE_T + MQLAuxServices.SPACE_T + pattern );

        accumSb.append( sb );

        return sb.toString( );
    }

    @Override
    public String toString( ) {

        return toString( 0, new StringBuilder( ) );
    }

}
