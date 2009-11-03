package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;

import com.sap.tc.moin.repository.spi.core.SpiPartitionable;

public interface EndStorageLinkFactory {

    public EndStorageLink createEndStorageLink( CoreSession session, byte endNumberOfStorageEnd, Association association, MriReference storageEnd, MoinReference referenceOtherEnd );

    public EndStorageLink createEndStorageLink( CoreSession session, byte endNumberOfStorageEnd, Attribute attribute, MriReference storageEnd, MoinReference referenceOtherEnd );

    public EndStorageLink createEndStorageLink( CoreSession session, SpiPartitionable elementAtEnd0, SpiPartitionable elementAtEnd1, Association association, byte endNumberOfStorageEnd );

    public EndStorageLink createEndStorageLink( CoreSession session, SpiPartitionable elementAtEnd0, SpiPartitionable elementAtEnd1, Attribute attribute, byte endNumberOfStorageEnd );

}