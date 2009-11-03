package com.sap.tc.moin.repository.core.xmi.reader;

import java.text.DecimalFormat;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassImpl;

import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * Represents a link found in the XMI.
 */
public class LinkInfo implements Comparable<LinkInfo> {

    private AssociationInternal association;

    private LinkEnd first;

    private LinkEnd second;

    private double order;

    private boolean isAssociationOrdered;

    private byte orderedEnd;

    private String compareString;

    private static DecimalFormat orderingFormatter;

    private final SpiJmiHelper jmiHelper;

    private CoreSession session;

    static {
        orderingFormatter = new DecimalFormat( "-0000000,000" ); //$NON-NLS-1$
        orderingFormatter.setMinimumIntegerDigits( 7 );
        orderingFormatter.setMinimumFractionDigits( 3 );
        orderingFormatter.setGroupingUsed( false );
    }

    public LinkInfo( CoreSession session, SpiJmiHelper jmiHelper, AssociationInternal association, LinkEnd first, LinkEnd second, double order ) {

        this.session = session;
        this.jmiHelper = jmiHelper;
        this.association = association;
        this.first = first;
        this.second = second;
        this.order = order;
        List<AssociationEnd> ends = jmiHelper.getAssociationEnds( session, (Association) association );
        if ( ends.get( 0 ).getMultiplicity( ).isOrdered( ) ) {
            this.isAssociationOrdered = true;
            this.orderedEnd = 0;
        } else if ( ends.get( 1 ).getMultiplicity( ).isOrdered( ) ) {
            this.isAssociationOrdered = true;
            this.orderedEnd = 1;
        }
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj instanceof LinkInfo ) {
            LinkInfo other = (LinkInfo) obj;
            return association.equals( other.association ) && first.equals( other.first ) && second.equals( other.second );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        int result = 17;
        result = 37 * result + association.hashCode( );
        result = 37 * result + first.hashCode( );
        result = 37 * result + second.hashCode( );
        return result;
    }

    public LinkEnd getFirstEnd( ) {

        return first;
    }

    public AssociationInternal getAssociation( ) {

        return association;
    }

    public LinkEnd getSecondEnd( ) {

        return second;
    }

    public double getOrder( ) {

        return order;
    }

    @Override
    @SuppressWarnings( "nls" )
    public String toString( ) {

        StringBuilder buf = new StringBuilder( "Association: " );
        buf.append( jmiHelper.getQualifiedName( session, (ModelElement) association ) );
        buf.append( ", first: " );
        if ( first instanceof InstanceInfo ) {
            MofClassImpl type = (MofClassImpl) ( (InstanceInfo) first ).getType( );
            buf.append( jmiHelper.getQualifiedName( session, type ) );
        } else if ( first instanceof CrossPartitionReference ) {
            buf.append( ( (CrossPartitionReference) first ).getHref( ) );
        }
        buf.append( ", second: " );
        if ( second instanceof InstanceInfo ) {
            MofClassImpl type = (MofClassImpl) ( (InstanceInfo) second ).getType( );
            buf.append( jmiHelper.getQualifiedName( session, type ) );
        } else if ( second instanceof CrossPartitionReference ) {
            buf.append( ( (CrossPartitionReference) second ).getHref( ) );
        }
        if ( isAssociationOrdered ) {
            buf.append( ", order: " );
            buf.append( order );
        }
        return buf.toString( );
    }

    private String getCompareString( ) {

        if ( compareString == null ) {
            double ordering = order;
            if ( ordering < -1 ) {
                ordering = 1 / ordering;
            }
            LinkEnd orderedLinkEnd = ( orderedEnd == 0 ? first : second );
            LinkEnd unorderedLinkEnd = ( orderedEnd == 0 ? second : first );
            compareString = getLinkEndString( unorderedLinkEnd ) + orderingFormatter.format( ordering ) + getLinkEndString( orderedLinkEnd );
        }
        return compareString;
    }

    private String getLinkEndString( LinkEnd end ) {

        return end.getMofId( );
    }

    public int compareTo( LinkInfo otherLinkInfo ) {

        return getCompareString( ).compareTo( otherLinkInfo.getCompareString( ) );
    }
}
