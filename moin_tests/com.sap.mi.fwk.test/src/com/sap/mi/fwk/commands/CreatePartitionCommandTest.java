package com.sap.mi.fwk.commands;

import java.util.Collection;

import org.eclipse.core.runtime.Path;

import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.util.properties.Property;
import com.sap.tc.moin.util.properties.PropertyBag;

public class CreatePartitionCommandTest extends ProjectBasedTest {

	private static final String DC_NAME = "test/CreatePartitionCommandTest";

	private static final String TEST_TOOL_ID = "test.tool";
	private static final String TEST_TOOL_VERSION = "1.2.3";

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected boolean deleteProjectOnSetUp() {
		return true;
	}

	@Override
	protected boolean deleteProjectOnTearDown() {
		return true;
	}

	public void testGetAffectedPartitions() {
		Connection con = createConnection();
		PRI pri = PartitionService.getInstance().getPRI(getProject(), new Path("src/dummy.xmi"));
		CreatePartitionCommand cpc = new CreatePartitionCommand(con, "desc", pri, "id", "version");

		Collection<PartitionOperation> affectedPartitions = cpc.getAffectedPartitions();
		PartitionOperation partitionOperation = new PartitionOperation(PartitionOperation.Operation.CREATE, pri);
		assertEquals("AffectedPartition list must contain exactly one element", 1, affectedPartitions.size());
		assertEquals("AffectedPartition list must contain correct partition operation", partitionOperation, affectedPartitions.toArray()[0]);
	}

	public void testDoExecute() {
		Connection con = createConnection();
		PRI pri = PartitionService.getInstance().getPRI(getProject(), new Path("src/dummy.xmi"));
		CreatePartitionCommand cpc = new CreatePartitionCommand(con, "desc", pri, TEST_TOOL_ID, TEST_TOOL_VERSION);

		cpc.execute();
		try {
			con.save();
		} catch (Exception e) {
			fail(e);
		}

		ModelPartition partition = con.getPartition(pri);
		assertNotNull(partition);

		Collection<Partitionable> elements = partition.getElements();
		assertEquals("Partition must contain only one element", 1, elements.size());

		PropertyBag bag = (PropertyBag) elements.toArray()[0];
		assertEquals("ids must match", cpc.PROPERTY_BAG_ID, bag.getId());
		assertEquals("Bag must contain only two properties", 2, bag.getProperties().size());

		boolean foundIdProperty = false;
		boolean foundVersionProperty = false;
		for (Property prop : bag.getProperties()) {
			if (cpc.CREATOR_ID_KEY.equals(prop.getKey())) {
				foundIdProperty = true;
				assertEquals("tool id must be correct", TEST_TOOL_ID, prop.getValue());
			}
			if (cpc.CREATOR_VERSION_KEY.equals(prop.getKey())) {
				foundVersionProperty = true;
				assertEquals("tool version must be correct", TEST_TOOL_VERSION, prop.getValue());
			}
		}
		assertTrue("ID Property not found", foundIdProperty);
		assertTrue("Version Property not found", foundVersionProperty);

		partition.delete();
		try {
			con.save();
		} catch (Exception e) {
			fail(e);
		}
	}
}
