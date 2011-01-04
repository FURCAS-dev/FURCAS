package com.sap.furcas.runtime.parser.incremental;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.sap.ide.cts.parser.incremental.PartitionAssignmentHandler;

public class MockPartitionAssignmentHandler implements
        PartitionAssignmentHandler {
    
    private final Resource partition;

    
    public MockPartitionAssignmentHandler(Resource partition) {
        super();
        this.partition = partition;
    }

    @Override
    public void assignToPartition(EObject element, EObject elementInpartition) {
        partition.getContents().add(element);
    }

    @Override
    public void setDefaultPartition(Resource defaultPartition) {
        //do nothing
    }

    @Override
    public void assignToDefaultPartition(EObject element) {
        partition.getContents().add(element);
    }

    @Override
    public void assignToDefaultTextBlocksPartition(EObject element) {
        if(!partition.equals(element.eResource())) {
            partition.getContents().add(element);
        }
    }

    @Override
    public Resource getDefaultPartition() {
        return partition;
    }

    @Override
    public void saveAllPartitions(Map<?, ?> options) throws IOException {
        //do nothing
    }

}
