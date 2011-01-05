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
	    if(element != elementInPartition) {
		Resource partition = null;
		// AttachesTo attachesToAssoc = connection
		// .getAssociation(AttachesTo.ASSOCIATION_DESCRIPTOR);
		// Collection<Tag> tags = attachesToAssoc.getTag((ModelElement)
		// newElement
		// .refMetaObject());
		// for (Tag tag : tags) {
		// if (tag.getTagId().equals("org.omg.sap2mof.requiresPartition")) {
		// List<String> values = tag.getValues();
		// if (values.size() == 1 && Boolean.parseBoolean(values.get(0))) {
		// // create new partition
		// PRI originalPartition = elementInPartition
		// .get___Partition().getPri();
		// PRI targetPRI = connection
		// .getSession().getMoin().createPri(
		// originalPartition.getDataAreaDescriptor()
		// .getFacilityId(),
		// originalPartition.getDataAreaDescriptor()
		// .getDataAreaName(),
		// originalPartition.getContainerName(),
		// getPartitionName(newElement,
		// originalPartition
		// .getPartitionName()));
		// if(connection.partitionExists(targetPRI)) {
		// partition = connection.getPartition(targetPRI);
		// } else {
		// partition = connection.createPartition(targetPRI);
		// }
		// }
		// }
		// }
		//if (partition == null) {
			// store in partition of composite parent
			partition = elementInPartition.eResource();
		//}
		partition.getContents().add(element);
	    }
	}

	@Override
	public void setDefaultPartition(Resource defaultPartition) {
	    //TODO if the given default partition is already a textblocks partition, compute
	    //the default partition for model elements from it
		this.defaultPartition = defaultPartition;
		URI defaultTextblocksPartitionURI = defaultPartition.getURI().appendFileExtension(TEXTBLOCKS_PARTITION_EXTENSION);
		try {
		    defaultTextBlocksPartition = defaultPartition.getResourceSet().getResource(defaultTextblocksPartitionURI, true);
		} catch (Exception ex){
		    //resource does not exist yet.
		}
		if(defaultTextBlocksPartition == null) {
		    defaultTextBlocksPartition = defaultPartition.getResourceSet().createResource(defaultTextblocksPartitionURI);
		}
	}

	@Override
	public void assignToDefaultPartition(EObject element) {
	    if(element != null && element.eResource() != defaultPartition) {
		defaultPartition.getContents().add(element);
	    }
	}
	
	@Override
        public void assignToDefaultTextBlocksPartition(EObject element) {
            if(element != null && !defaultTextBlocksPartition.equals(element.eResource())) {
                defaultTextBlocksPartition.getContents().add(element);
            }
        }

    @Override
    public Resource getDefaultPartition() {
        return defaultPartition;
    }

    @Override
    public void saveAllPartitions(Map<?,?> options) throws IOException {
        this.defaultPartition.save(options);
        this.defaultTextBlocksPartition.save(options);
    }
}
