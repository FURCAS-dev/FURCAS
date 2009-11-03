package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.spi.core.SpiResourceInfo;
import com.sap.tc.moin.repository.spi.core.SpiStage;

public class ResourceInfoImpl implements SpiResourceInfo {

    private PRI pri;

    private SpiStage stage;

    /**
     * Buffers the hashCode in order to speed-up the hashCode() operation. This
     * is lazily calculated.
     */
    private int hashCode;

    /**
     * Constructor takes the PRI, the WorkspaceIdentifier. None of the arguments
     * must be <tt>null</tt>.
     * 
     * @param pri the {@link PRI} of the resource
     * @throws IllegalArgumentException if any of the parameters is
     * <tt>null</tt>
     */
    public ResourceInfoImpl( PRI pri, SpiStage stage ) {

        if ( pri == null ) {
            throw new MoinIllegalArgumentException( RepositoryCoreMessages.MANDATORY_PARAMETER_MISSING, "Pri" ); //$NON-NLS-1$
        }

        if ( stage == null ) {
            throw new MoinIllegalArgumentException( RepositoryCoreMessages.MANDATORY_PARAMETER_MISSING, "Stage" ); //$NON-NLS-1$
        }

        if ( !stage.getDataAreaDescriptor( ).equals( pri.getDataAreaDescriptor( ) ) ) {
            throw new MoinIllegalArgumentException( CoreImplMessages.DIFFERENTDATAAREAS, pri.getDataAreaDescriptor( ), stage.getDataAreaDescriptor( ) );
        }

        this.pri = pri;
        this.stage = stage;

        this.hashCode = -1;
    }

    /**
     * @see com.sap.tc.moin.repository.SpiResourceInfo#getPri()
     */
    public PRI getPri( ) {

        return this.pri;
    }

    public SpiStage getStage( ) {

        return this.stage;
    }

    /**
     * @see java.lang.Object#hashCode()
     * @return the hashcode of the resource info
     */
    @Override
    public int hashCode( ) {

        if ( this.hashCode == -1 ) {
            this.hashCode = this.pri.hashCode( ) + this.stage.hashCode( );
        }
        return this.hashCode;
    }

    /**
     * @see Object#equals(java.lang.Object)
     * @return true if the specified object is equal to this resource info
     */
    @Override
    public boolean equals( Object o ) {

        if ( o instanceof ResourceInfoImpl ) {
            ResourceInfoImpl ri = (ResourceInfoImpl) o;
            return ( this.pri.equals( ri.pri ) && this.stage.equals( ri.stage ) );
        } else {
            return false;
        }
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString( ) {

        String priStr = this.pri.toString( );
        String stageStr = this.stage.toString( );

        int len = 0;
        if ( priStr != null ) {
            len += priStr.length( );
        }
        if ( stageStr != null ) {
            len += stageStr.length( );
        }
        StringBuffer sb = new StringBuffer( len );
        sb.append( "Resource-Info: PRI='" ).append( priStr ).append( "', " ); //$NON-NLS-1$ //$NON-NLS-2$
        sb.append( "Stage='" ).append( stageStr ).append( "'" ); //$NON-NLS-1$ //$NON-NLS-2$
        return sb.toString( );
    }
}
