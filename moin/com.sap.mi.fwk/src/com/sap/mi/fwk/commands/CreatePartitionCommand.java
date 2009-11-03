package com.sap.mi.fwk.commands;

import java.util.Collection;
import java.util.Collections;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.util.properties.PropertiesPackage;
import com.sap.tc.moin.util.properties.Property;
import com.sap.tc.moin.util.properties.PropertyBag;

public class CreatePartitionCommand extends Command {

	PRI partition;
	String creatorId;
	String creatorVersion;
	public ModelPartition newPartition;

	public static final String PROPERTY_BAG_ID = "PartitionCreationInfo"; //$NON-NLS-1$
	public static final String CREATOR_ID_KEY = "creatorId"; //$NON-NLS-1$
	public static final String CREATOR_VERSION_KEY = "creatorVersion"; //$NON-NLS-1$

	/**
	 * @param connection
	 */
	public CreatePartitionCommand(Connection connection, String description, PRI partition, String creatorId, String creatorVersion) {
		super(connection, description);
		this.partition = partition;
		this.creatorId = creatorId;
		this.creatorVersion = creatorVersion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return partition != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.commands.Command#doExecute()
	 */
	@Override
	public void doExecute() {
		// Create Partition
		newPartition = this.getConnection().createPartition(partition);

 		// Create PropertyBag
		PropertyBag pBag = newPartition.createElement(PropertyBag.CLASS_DESCRIPTOR);
		pBag.setId(PROPERTY_BAG_ID);

		PropertiesPackage pp = this.getConnection().getPackage(PropertiesPackage.PACKAGE_DESCRIPTOR);
		StructureFieldContainer<Property> structureFieldContainer;

		// Create CreatorId Property
		structureFieldContainer = new StructureFieldContainer<Property>();
		structureFieldContainer.put(Property.DESCRIPTORS.KEY(), CREATOR_ID_KEY);
		structureFieldContainer.put(Property.DESCRIPTORS.VALUE(), this.creatorId);
		pBag.getProperties().add(pp.createProperty(structureFieldContainer));

		// Create CreatorVersion Property
		structureFieldContainer = new StructureFieldContainer<Property>();
		structureFieldContainer.put(Property.DESCRIPTORS.KEY(), CREATOR_VERSION_KEY);
		structureFieldContainer.put(Property.DESCRIPTORS.VALUE(), this.creatorVersion);
		pBag.getProperties().add(pp.createProperty(structureFieldContainer));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.commands.Command#getAffectedPartitions()
	 */
	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		Collection<PartitionOperation> ap = Collections
				.singletonList(new PartitionOperation(PartitionOperation.Operation.CREATE, partition));
		return ap;
	}

}
