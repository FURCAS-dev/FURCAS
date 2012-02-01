package com.sap.furcas.runtime.parser.testbase;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

import com.sap.furcas.runtime.parser.impl.DefaultPartitionAssignmentHandlerImpl;

public class MockPartitionAssignmentHandler extends DefaultPartitionAssignmentHandlerImpl {
    
    public MockPartitionAssignmentHandler(Resource partition) {
        this.defaultPartition = partition;
        this.defaultTextBlocksPartition = partition;
    }

    @Override
    public void setDefaultPartition(Resource defaultPartition) {
        //do nothing
    }
   
    @Override
    public void saveAllPartitions(Map<?, ?> options) throws IOException {
        //do nothing
    }

}
