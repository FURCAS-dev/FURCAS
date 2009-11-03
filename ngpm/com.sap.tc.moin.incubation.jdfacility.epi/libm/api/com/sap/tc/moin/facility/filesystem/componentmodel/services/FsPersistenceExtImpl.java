package com.sap.tc.moin.facility.filesystem.componentmodel.services;

import java.lang.ref.ReferenceQueue;

import com.sap.tc.moin.facility.componentmodel.CMContainer;
import com.sap.tc.moin.facility.componentmodel.CMManager;
import com.sap.tc.moin.facility.primary.persistence.fs.FsPersistenceImpl;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XDocument;


public class FsPersistenceExtImpl extends FsPersistenceImpl {

    private CMManager cmManager;

    public void bind( CMManager cmManager ) {

        this.cmManager = cmManager;
    }

    public FsPersistenceExtImpl( String moinId, ReferenceQueue<?> refQueue ) {

        super( moinId, refQueue );
    }

    @Override
    protected void storePartitionTexts( SpiPartitionSaveContext partition ) {

        if ( textFileExists( partition.getPri( ) ) || partition.hasTranslatableTexts( ) ) {

            CMContainer cmContainer = cmManager.getContainer( partition.getPri( ).getCri( ) );
            SpiS2XDocument s2XDocument = new SpiS2XDocument( cmContainer.getOriginalLanguage( ), cmContainer.getApplicationComponent( ) );
            storePartitionTexts( partition, s2XDocument );

        }
    }

}
