package com.sap.ide.cts.parser.incremental;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class DefaultPartitionAssignmentHandlerImpl implements PartitionAssignmentHandler {

    private static final String TEXTBLOCKS_PARTITION_EXTENSION = "textblocks";
    private Resource defaultPartition;
    private Resource defaultTextBlocksPartition;

    /**
     * Assigns the <code>newElement</code> to a partition according to the given
     * Tag "org.omg.sap2mof.requiresPartition" in the metamodel. If the tag is
     * false or not specified assigns the <code>newElement</code> to the
     * partition of the <code>elementInPartition</code>.
     * 
     * @param elementInPartition
     * @param newElement
     */
    @Override
    public void assignToPartition(EObject element, EObject elementInPartition) {
        if (element != elementInPartition) {
            Resource partition = null;
            partition = elementInPartition.eResource();
            partition.getContents().add(element);
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
    public void assignToDefaultTextBlocksPartition(EObject element) {
        if (element != null && !defaultTextBlocksPartition.equals(element.eResource())) {
            defaultTextBlocksPartition.getContents().add(element);
        }
    }

    @Override
    public Resource getDefaultPartition() {
        return defaultPartition;
    }
    
    @Override
    public void saveAllPartitions(Map<?, ?> options) throws IOException {
        // It is imposible to store empty xmi resources
        if (!this.defaultPartition.getContents().isEmpty()) {
            this.defaultPartition.save(options);
        }
        if (!this.defaultTextBlocksPartition.getContents().isEmpty()) {
            this.defaultTextBlocksPartition.save(options);
        }
    }

}
