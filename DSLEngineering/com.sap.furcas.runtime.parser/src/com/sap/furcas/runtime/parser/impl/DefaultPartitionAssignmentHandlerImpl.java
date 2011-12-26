package com.sap.furcas.runtime.parser.impl;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandler;




public class DefaultPartitionAssignmentHandlerImpl implements PartitionAssignmentHandler {

    public static final String TEXTBLOCKS_PARTITION_EXTENSION = "textblocks";
    protected Resource defaultPartition;
    protected Resource defaultTextBlocksPartition;

    /**
     * Assigns the <code>element</code> to the partition of the <code>elementInPartition</code>.
     * 
     * @param elementInPartition
     * @param element 
     */
    @Override
    public void assignToPartition(EObject element, EObject elementInPartition) {
        if (element != elementInPartition) {
            elementInPartition.eResource().getContents().add(element);
        } else {
            assignToDefaultPartition(element);
        }	
    }

    @Override
    public void setDefaultPartition(Resource partition) {
        this.defaultPartition = partition;
        URI defaultTextblocksPartitionURI = partition.getURI().appendFileExtension(TEXTBLOCKS_PARTITION_EXTENSION);
        try {
            defaultTextBlocksPartition = partition.getResourceSet().getResource(defaultTextblocksPartitionURI, true);
        } catch (Exception ex) {
            //resource does not exist yet.
        }
        if (defaultTextBlocksPartition == null) {
            defaultTextBlocksPartition = partition.getResourceSet().createResource(defaultTextblocksPartitionURI);
        }
    }

    @Override
    public void assignToDefaultPartition(EObject element) {
        if (element != null && element.eResource() != defaultPartition) {
            defaultPartition.getContents().add(element);
        }
    }

    @Override
    public void assignToDefaultTextBlocksPartition(DocumentNode element) {
        if (element != null && element.eResource() != defaultTextBlocksPartition) {
            defaultTextBlocksPartition.getContents().add(element);
        }
    }
    
    @Override
    public void saveAllPartitions(Map<?,?> options) throws IOException {
        defaultPartition.save(options);
        defaultTextBlocksPartition.save(options);
    }

}
