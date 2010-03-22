package com.sap.ide.cts.parser.incremental;

import tcs.ConcreteSyntax;
import tcs.PartitionHandling;
import tcs.SequenceElement;
import tcs.Template;

import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public interface PartitionAssignmentHandler {

	
	/**
	 * evaluate the OCL expression of the given element <tt>inputRefObject<tt>
	 * 
	 * @param inputRefObject
	 * @param partitionHandling
	 * @param connection
	 * 
	 * @return the name of the partition
	 */
	
	String evaluatedOCLForProperty(RefObject inputRefObject,
			PartitionHandling partitionHandling, Connection connection);

//	/**
//	 * assign the given element<tt>newElement<tt> to her correspondent partition
//	 * 
//	 * @param elementInPartition
//	 * @param newElement
//	 * @param template
//	 * @param connection
//	 * @param mainPartition
//	 * @param concreteSyntax
//	 */
//	void assignToPartition(RefObject elementInPartition, RefObject newElement,
//			Template template);

	/**
	 * assign the given element<tt>newElement<tt> to her correspondent partition
	 * 
	 * @param partition
	 * @param newElement
	 * @param template
	 * @param connection
	 * @param mainPartition
	 * @param concreteSyntax
	 */
	void assignToPartition(ModelPartition partition, RefObject newElement,
			Template template);

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
	void assignToPartition(ModelPartition partition, RefObject refObject,
			PartitionHandling partitionHandling);

	

	/**
	 * assign the given element <tt>proxy<tt> to his specified partition
	 * @param proxy
	 * @param result
	 * @param template
	 * @param defaultPartition 
	 */
	void assignFromProxy(IModelElementProxy proxy, SequenceElement se, Template template, ModelPartition defaultPartition);


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


}
