package com.sap.ide.cts.parser.incremental;

import tcs.PartitionHandling;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
public interface InteractivePartitionHandler {
	
	 PRI getPartitionFor( PartitionHandling ph, ModelPartition partition, RefObject newElement,
			 Connection connection);

}
