package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.spi.core.SpiStage;

/**
 * Base implementation of the Stage interface; this class represents only shared
 * stages.
 * 
 * @author d020383
 */
public abstract class AbstractStageImpl implements SpiStage {

    protected DataAreaDescriptor dataAreaDescriptor;

    protected String name;

    protected int hashCode;

    public AbstractStageImpl( DataAreaDescriptor dataAreaDescriptor, String name ) {

        this.dataAreaDescriptor = dataAreaDescriptor;
        this.name = name;
        hashCode = 0;
    }

    public DataAreaDescriptor getDataAreaDescriptor( ) {

        return dataAreaDescriptor;
    }

    public String getName( ) {

        return name;
    }

    public abstract String getClientSpecId( );

}
