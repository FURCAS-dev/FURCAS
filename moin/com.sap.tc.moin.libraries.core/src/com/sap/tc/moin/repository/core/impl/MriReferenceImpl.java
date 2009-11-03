package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionable;

public class MriReferenceImpl extends AbstractMriReferenceImpl {

    private final CoreMoin moin;

    public MriReferenceImpl( CorePartitionable partitionable, MRI mri, boolean cacheable, CoreMoin moin ) {

        super( partitionable, mri, cacheable );
        this.moin = moin;
    }

    @Override
    protected CoreMoin getMoin( ) {

        return moin;
    }


}
