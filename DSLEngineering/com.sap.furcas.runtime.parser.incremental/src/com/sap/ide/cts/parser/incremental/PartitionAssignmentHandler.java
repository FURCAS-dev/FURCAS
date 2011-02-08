package com.sap.ide.cts.parser.incremental;

import java.io.IOException;
import java.util.Map;

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

	/**
	 * Assigns the given element to the default textblocks partition. Notice, however
	 * that if the element is not an element of the TextBlocks metamodel the element will
	 * NOT be added.
	 * 
	 * @param element the textblocks element to add to the default textblocks partition.
	 */
        void assignToDefaultTextBlocksPartition(EObject element);

        /**
         * Returns the default model element resource set by {@link #setDefaultPartition(Resource)}.
         * 
         * @return the default model {@link Resource}
         */
        Resource getDefaultPartition();
        
        /**
         * Saves all handled partitions.
         * 
         * @param options the options to use when saving the handled partitions.
         * @throws IOException re-throws any exception that occurs when saving the partitions.
         */
        void saveAllPartitions(Map<?,?> options) throws IOException;
}
