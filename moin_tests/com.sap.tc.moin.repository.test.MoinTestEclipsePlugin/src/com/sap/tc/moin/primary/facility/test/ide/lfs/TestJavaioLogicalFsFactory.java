package com.sap.tc.moin.primary.facility.test.ide.lfs;

import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFsFactory;
import com.sap.tc.moin.facility.primary.persistence.lfs.javaioimpl.FsFactory;


public class TestJavaioLogicalFsFactory extends AbstractTestLogicalFsFactory {

    @Override
    protected IpiLogicalFsFactory createLogicalFsFactoryTestInstance( ) {

        return new FsFactory( );
    }

    @Override
    protected String getTransformedTemporaryDirectoryPath( ) {

        return temporaryDirectory.getAbsolutePath( );
    }

}
