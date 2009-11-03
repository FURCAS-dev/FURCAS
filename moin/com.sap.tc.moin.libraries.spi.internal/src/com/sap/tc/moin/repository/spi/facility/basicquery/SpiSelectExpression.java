package com.sap.tc.moin.repository.spi.facility.basicquery;

import com.sap.tc.moin.repository.spi.facility.SpiFacilityQueryServiceException;

/**
 * Select expression for model elements and selected primitive attributes.
 */
@Deprecated
public final class SpiSelectExpression {

    /**
     * cluster from which we select
     */
    private SpiModelElementClusterExpression modelElementClusterExpression;

    /**
     * select lists over the cluster
     */
    private SpiSelectList[] selectLists;

    public SpiSelectExpression( SpiModelElementClusterExpression modelElementClusterExpression, SpiSelectList[] selectLists ) {

        if ( modelElementClusterExpression == null ) {
            throw new SpiFacilityQueryServiceException( SpiFacilityQueryServiceException.ERROR_CODE_UNSPECIFIED, BQLBugMessages.MODELELEMENTEXPRESSION_MUST_NOT_BE_NULL );
        }

        this.modelElementClusterExpression = modelElementClusterExpression;
        this.selectLists = selectLists;
    }

    /**
     * @return Returns the cluster.
     */
    public SpiModelElementClusterExpression getModelElementClusterExpression( ) {

        return this.modelElementClusterExpression;
    }

    /**
     * @return Returns the selectLists.
     */
    public SpiSelectList[] getSelectLists( ) {

        return selectLists;
    }

    @Override
    public String toString( ) {

        StringBuffer sb = new StringBuffer( );
        this.toString( sb, 0 );
        return sb.toString( );
    }

    /**
     *
     */
    @SuppressWarnings( "nls" )
    private void toString( StringBuffer sb, int ident ) {

        SpiUtils.toStringNewLine( sb, ident );
        sb.append( SpiUtils.OPENING_PARENTHESES );
        sb.append( SpiUtils.SELECT );
        sb.append( ": " );
        this.modelElementClusterExpression.toString( sb, ident + 1, true );
        sb.append( ',' );
        SpiUtils.toStringNewLine( sb, ident + 1 );
        if ( this.selectLists != null && this.selectLists.length > 0 ) {
            sb.append( SpiUtils.SELECT_LIST );
            sb.append( ": " );
            for ( int i = 0; i < this.selectLists.length - 1; i++ ) {
                this.selectLists[i].toString( sb, ident + 2, true );
                sb.append( ',' );
            }
            this.selectLists[this.selectLists.length - 1].toString( sb, ident + 2, true );
        }
        SpiUtils.toStringNewLine( sb, ident );
        sb.append( SpiUtils.CLOSING_PARENTHESES );
    }

}
