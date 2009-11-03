package com.sap.tc.moin.friends;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObjectAdapter;


public class RefBaseObjectDummyForCollectionAccess extends RefBaseObjectAdapter {

    private LRI lri = null;

    public RefBaseObjectDummyForCollectionAccess( LRI lri ) {

        this.lri = lri;
    }

    @Override
    public int hashCode( ) {

        return lri.getMofId( ).hashCode( );
    }

    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( !( obj instanceof RefBaseObject ) ) {
            return false;
        }

        RefBaseObject other = (RefBaseObject) obj;
        if ( lri == null ) {
            if ( other.get___Mri( ).getLri( ) != null ) {
                return false;
            }
        } else if ( !lri.equals( other.get___Mri( ).getLri( ) ) ) {
            return false;
        }
        return true;
    }

}
