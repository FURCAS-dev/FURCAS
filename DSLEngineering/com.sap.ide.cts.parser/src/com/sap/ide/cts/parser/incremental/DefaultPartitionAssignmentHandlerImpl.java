package com.sap.ide.cts.parser.incremental;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class DefaultPartitionAssignmentHandlerImpl implements PartitionAssignmentHandler {

	private ModelPartition defaultPartition;

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
	public void assignToPartition(Partitionable element, Partitionable elementInPartition) {
		ModelPartition partition = null;
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
			partition = elementInPartition.get___Partition();
		//}
		partition.assignElementIncludingChildren(element);
	}

	@Override
	public void setDefaultPartition(ModelPartition defaultPartition) {
		this.defaultPartition = defaultPartition;		
	}

	@Override
	public void assignToDefaultPartition(RefObject element) {
		defaultPartition.assignElementIncludingChildren(element);
	}

}
