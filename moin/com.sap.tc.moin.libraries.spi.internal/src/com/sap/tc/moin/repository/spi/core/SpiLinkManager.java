package com.sap.tc.moin.repository.spi.core;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;

import com.sap.tc.moin.repository.LRI;

public interface SpiLinkManager {

    public SpiWorkspace getWorkspace( );

    public void loadLink( SpiSession session, SpiPartitionable elementAtEnd0, LRI elementAtEnd1, Association association );

    public void loadLink( SpiSession session, SpiPartitionable elementAtEnd0, LRI elementAtEnd1, Attribute attribute );

    public void loadLink( SpiSession session, LRI elementAtEnd0, SpiPartitionable elementAtEnd1, Association association );

    public void loadLink( SpiSession session, LRI elementAtEnd0, SpiPartitionable elementAtEnd1, Attribute attribute );

    public void loadLink( SpiSession session, SpiPartitionable elementAtEnd0, SpiPartitionable elementAtEnd1, Attribute attribute );

    public void loadLink( SpiSession session, SpiPartitionable elementAtEnd0, SpiPartitionable elementAtEnd1, Association assocation );

}
