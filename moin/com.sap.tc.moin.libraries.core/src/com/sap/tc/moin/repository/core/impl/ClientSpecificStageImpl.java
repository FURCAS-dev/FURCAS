package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.DataAreaDescriptor;

/**
 * @author d020383
 */
public class ClientSpecificStageImpl extends AbstractStageImpl {

    String clientspecId;

    public ClientSpecificStageImpl( DataAreaDescriptor dataAreaDescriptor, String name, String clientspecId ) {

        super( dataAreaDescriptor, name );
        this.clientspecId = clientspecId;
    }

    @Override
    public String getClientSpecId( ) {

        return this.clientspecId;
    }

    public boolean isClientSpecific( ) {

        return true;
    }

    public boolean isShared( ) {

        return false;
    }

    @Override
    public int hashCode( ) {

        if ( hashCode == 0 ) {
            hashCode = 17;
            hashCode = 37 * hashCode + ( dataAreaDescriptor != null ? dataAreaDescriptor.hashCode( ) : 0 );
            hashCode = 37 * hashCode + ( clientspecId != null ? clientspecId.hashCode( ) : 0 );
        }
        return hashCode;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) {
            return true;
        } else if ( obj instanceof ClientSpecificStageImpl ) {
            ClientSpecificStageImpl stage = (ClientSpecificStageImpl) obj;
            return ( this.dataAreaDescriptor != null && this.dataAreaDescriptor.equals( stage.dataAreaDescriptor ) || this.dataAreaDescriptor == null && stage.dataAreaDescriptor == null )
                   && ( this.clientspecId != null && this.clientspecId.equals( stage.clientspecId ) || this.clientspecId == null && stage.clientspecId == null );
        } else {
            return false;
        }
    }

    @Override
    public String toString( ) {

        return name;
    }
}
