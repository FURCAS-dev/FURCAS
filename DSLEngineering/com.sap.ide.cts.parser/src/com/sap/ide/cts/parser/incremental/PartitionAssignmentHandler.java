package com.sap.ide.cts.parser.incremental;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;


public interface PartitionAssignmentHandler {

	/**
	 * Assigns the <tt>element</tt> to a partition that may be computed given the already
	 * <tt>elementInPartition</tt> that resides already in a partition that may serve as
	 * reference.
	 * 
	 * @param element
	 * @param partition
	 */
	void assignToPartition(EObject element, EObject elementInpartition);

	/**
	 * Specifies which partition to use as default.
	 * 
	 * @param defaultPartition
	 */
	void setDefaultPartition(Resource defaultPartition);

	/**
	 * Assigns the given element <tt>element</tt> to the default partition set using
	 * {@link #setDefaultPartition(Resource)}.
	 */
	void assignToDefaultPartition(EObject element);
}
