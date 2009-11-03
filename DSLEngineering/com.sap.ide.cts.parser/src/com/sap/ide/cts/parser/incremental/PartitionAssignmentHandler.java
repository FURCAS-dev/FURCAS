package com.sap.ide.cts.parser.incremental;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public interface PartitionAssignmentHandler {

	/**
	 * Assigns the <tt>element</tt> to a partition that may be computed given the already
	 * <tt>elementInPartition</tt> that resides already in a partition that may serve as
	 * reference.
	 * 
	 * @param element
	 * @param partition
	 */
	void assignToPartition(Partitionable element, Partitionable elementInpartition);

	/**
	 * Specifies which partition to use as default.
	 * 
	 * @param defaultPartition
	 */
	void setDefaultPartition(ModelPartition defaultPartition);

	/**
	 * Assigns the given element <tt>element</tt> to the default partition set using
	 * {@link #setDefaultPartition(ModelPartition)}.
	 */
	void assignToDefaultPartition(RefObject element);
}
