package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;


public class SharedStageImpl extends AbstractStageImpl {

    public SharedStageImpl( DataAreaDescriptor dataAreaDescriptor, String name ) {

        super( dataAreaDescriptor, name );
    }

    @Override
    public String getClientSpecId( ) {

        throw new MoinUnsupportedOperationException( CoreImplMessages.NOCLIENTSPECID );
    }

    public boolean isClientSpecific( ) {

        return false;
    }

    public boolean isShared( ) {

        return true;
    }

    @Override
    public int hashCode( ) {

        if ( hashCode == 0 ) {
            hashCode = 17;
            hashCode = 37 * hashCode + ( dataAreaDescriptor != null ? dataAreaDescriptor.hashCode( ) : 0 );
            hashCode = 37 * hashCode + ( name != null ? name.hashCode( ) : 0 );
        }
        return hashCode;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) {
            return true;
        } else if ( obj instanceof AbstractStageImpl ) {
            AbstractStageImpl stage = (AbstractStageImpl) obj;
            return ( this.dataAreaDescriptor != null && this.dataAreaDescriptor.equals( stage.dataAreaDescriptor ) || this.dataAreaDescriptor == null && stage.dataAreaDescriptor == null ) && ( this.name != null && this.name.equals( stage.name ) || this.name == null && stage.name == null );
        } else {
            return false;
        }
    }

    @Override
    public String toString( ) {

        return name;
    }
}
