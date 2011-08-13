package com.sap.furcas.runtime.parser;

import org.eclipse.emf.ecore.EObject;


public interface PartitionAssignmentHandlerBase {

	/**
	 * Assigns the given element <tt>element</tt> to a partition
	 */
	public void assignToDefaultPartition(EObject element);

}
