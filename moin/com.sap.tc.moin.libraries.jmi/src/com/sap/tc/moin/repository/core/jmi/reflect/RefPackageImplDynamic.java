/*
 * Created on 31.01.2006
 */
package com.sap.tc.moin.repository.core.jmi.reflect;

import java.util.Collections;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * A
 * 
 * @author d024227
 */
public class RefPackageImplDynamic extends RefPackageImpl implements RefPackage {

    /***************************************************************************
     * constructors
     **************************************************************************/

    public RefPackageImplDynamic( ) {

        super( );
    }

    public RefPackageImplDynamic( Object workspace, String mofId, RefPackage immediatePackage, RefObject metaObject ) {

        super( workspace, mofId, immediatePackage, metaObject );
    }

    /***************************************************************************
     * other methods
     **************************************************************************/

    @Override
    public Class get___JmiInterface( ) {

        return RefPackage.class;
    }

    /***************************************************************************
     * private methods
     **************************************************************************/
    @Override
    protected RefBaseObject create___Extent( Object workspace, String mofId, RefPackage immediatePackage, RefObject refMetaObject ) {

        throw new MoinUnsupportedOperationException( JmiReflectMessages.THEREISNOEXTENTTOBECREATEDALREADYDONEBYMOFROM );
    }

    @Override
    public Wrapper<? extends RefBaseObject> createWrapper( CoreConnection conn, boolean synchronize ) {

        return new RefPackageImplDynamicWrapper( conn, this, synchronize );
    }

    @Override
    protected void initialize( ) {

        if ( this.___refClasses == null ) {
            RefClassAndName rcan = new RefClassAndName( "Element", null ); //$NON-NLS-1$
            this.___refClasses = Collections.singletonList( rcan );
            this.___refClassesByName = Collections.singletonMap( rcan.name, rcan );
        }

        if ( this.___refPackages == null ) {
            this.___refPackages = Collections.emptyList( );
            this.___refPackagesByName = Collections.emptyMap( );
        }

        if ( this.___refAssociations == null ) {
            this.___refAssociations = Collections.emptyList( );
            this.___refAssociationsByName = Collections.emptyMap( );
        }

    }

}