package com.sap.ide.cts.parser.incremental;

import tcs.ConcreteSyntax;
import tcs.PartitionHandling;
import tcs.SequenceElement;
import tcs.Template;
import textblocks.TextBlock;

import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public interface PartitionAssignmentHandler {

	
	


	/**
	 * assign the given element<tt>newElement<tt> to her correspondent partition
	 * 
	 * @param partition
	 * @param newElement
	 * @param template
	 * @param partitionHandling
	 */

	
	void assignToPartition(ModelPartition partition,
			 TextBlock textblock, TextBlock parent, PartitionHandlingWithRefObject partitionHandling, Template template);

	/**
	 * assign the given element<tt>newElement<tt> that is a property or a concrete syntax to her correspondent partition
	 * 
	 * @param partition
	 * @param refObject
	 * @param template
	 * @param connection
	 * @param mainPartition
	 * @param concreteSyntax
	 */
	void assignToPartition(ModelPartition partition, TextBlock textblock,TextBlock parent,
			PartitionHandlingWithRefObject partitionHandling);

	/**
	 * assign the given element<tt>newElement<tt> that is a property or a concrete syntax to her correspondent partition
	 * 
	 * @param partition
	 * @param refObject
	 * @param template
	 * @param connection
	 * @param mainPartition
	 * @param concreteSyntax
	 */
	void assignToPartition(ModelPartition partition, RefObject refObject, TextBlock textblock,TextBlock parent,
			PartitionHandlingWithRefObject partitionHandling);


	/**
	 * assign the given element <tt>proxy<tt> to his specified partition
	 * @param proxy
	 * @param result
	 * @param template
	 * @param defaultPartition 
	 */
	void assignToPartition(ModelPartition partition, RefObject newElement,
			TextBlock textblock,TextBlock parent, PartitionHandlingWithRefObject partitionHandling,
			Template template);


	/**
	 * set the partition and the Content of the Concrete syntax as the default partition and main content 
	 * @param concreteSyntax
	 * @param connection
	 * @param defaultPartition
	 */
	void SetMainPartition_And_MainContent(ConcreteSyntax concreteSyntax,
			Connection connection, ModelPartition defaultPartition);
	
	ModelPartition getMainPartition();
	
	String getMainPartitionContent();
	
	void setConcreteSyntax(ConcreteSyntax concSyntax);
	
	ConcreteSyntax getConcreteSyntax();

	void setInteractivePartitionHandler(
			InteractivePartitionHandler interactivePartitionHandler);
	
	/**
	 * assign the given element <tt>proxy<tt> with the correspondent <tt>textBlock<tt>to his specified partition
	 * @param proxy
	 * @param parent 
	 * @param result
	 * @param template
	 * @param defaultPartition 
	 */
	void assignFromProxy(IModelElementProxy proxy,
			SequenceElement sequenceElement, TextBlock textBlock,
			TextBlock parent, Template template, ModelPartition defaultPartition);


	PartitionHandlingWithRefObject takeParentPartitionHandling(TextBlock textblock, TextBlock parent);

	String evaluatedOCLForProperty(RefObject inputRefObject,
			PartitionHandlingWithRefObject partitionHandling,
			Connection connection); 

	

}
