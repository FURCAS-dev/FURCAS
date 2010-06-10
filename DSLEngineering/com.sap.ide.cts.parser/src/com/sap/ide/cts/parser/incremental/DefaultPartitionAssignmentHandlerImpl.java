package com.sap.ide.cts.parser.incremental;

import org.w3c.dom.Text;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.PartitionHandling;
import tcs.Property;
import tcs.SequenceElement;
import tcs.Template;
import textblocks.TextBlock;

import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

public class DefaultPartitionAssignmentHandlerImpl implements
		PartitionAssignmentHandler {

	private RefPackage[] packagesForLookup;
	private InteractivePartitionHandler interactivePartitionHandler;
	private String mainPartitionContent;
	private ModelPartition mainPartition;
	private ConcreteSyntax concreteSyntax2;
	private SetInteractiveResult interactiveResult;
	private String interactiveContent = "nothing";

	/**
	 * Assigns the <code>textblock</code> with the given Template
	 * <code>template</code> to a partition according to the given Tag
	 * ""org.omg.sap2mof.requiresPartition" in the metamodel. If the tag is
	 * false or not specified assigns the <code>newElement</code> to the created
	 * partition <code>partition</code> or to the defaultPartition .
	 * 
	 * @param partition
	 * @param textblock
	 * @param template
	 */

	public void assignToPartition(ModelPartition partition,
			TextBlock textblock,TextBlock parent,PartitionHandlingWithRefObject partitionHandlingWithRef, Template template) {
		assignToPartition(partition, textblock, textblock,parent,partitionHandlingWithRef, template);
	}

	/**
	 * Assigns the <code>newElement</code> with the <code>textblock</code> and
	 * the given Template <code>template</code> to a partition according to the
	 * given Tag ""org.omg.sap2mof.requiresPartition" in the metamodel. If the
	 * tag is false or not specified assigns the <code>newElement</code> to the
	 * created partition <code>partition</code> or to the defaultPartition .
	 * 
	 * @param partition
	 * @param newElement
	 * @param textblock
	 * @param template
	 */
	@Override
	
	public void assignToPartition(ModelPartition partition,
			RefObject newElement, TextBlock textblock,TextBlock parent,PartitionHandlingWithRefObject partitionHandlingWithRefObject1, Template template) {
		if (template != null) {
			if (template instanceof ClassTemplate) {
				PartitionHandlingWithRefObject partitionHandlingWithRefObject = null;
				ClassTemplate classTemplate = (ClassTemplate) template;
				
				if (partitionHandlingWithRefObject1.getPartitionHandling() != null) {
					partitionHandlingWithRefObject = partitionHandlingWithRefObject1;
				} else {
					partitionHandlingWithRefObject = new PartitionHandlingWithRefObject(classTemplate.getPartitionHandling(), newElement);
				}
				PRI originalPartition = partition.getPri();

				/*
				 * the automatic partition of ClassTemplate
				 */

				if (partitionHandlingWithRefObject.getPartitionHandling() == null) {

					PartitionHandlingWithRefObject parentPartitionHandling = takeParentPartitionHandling(textblock, parent);
					// assign to Parent, if it have a PartitionHandling
					if (parentPartitionHandling.getPartitionHandling() != null) {

						if (parentPartitionHandling.getPartitionHandling().isAutomaticPartition()) {
							
							assignToPartitionAutomatic(partition, originalPartition,
									newElement, textblock,parent, partitionHandlingWithRefObject ,classTemplate, newElement
											.get___Connection(), getMainPartition(),
									template.getConcretesyntax());
							
						} else {
							assignToPartitionNotAutomatic(partition,
									newElement, textblock,partitionHandlingWithRefObject, classTemplate,
									newElement.get___Connection(),
									getMainPartition());
						}

					} else if (template.getConcretesyntax() != null) {
						// Assign to DefaultPartition(concreteSyntax partition)
						if (template.getConcretesyntax().getPartitionHandling() != null) {
							partition = getMainPartition();

							if (template.getConcretesyntax()
									.getPartitionHandling()
									.isAutomaticPartition()) {
								System.out.println("");
								System.out.println(partition);
								System.out.println("");
								partition
										.assignElementIncludingChildren(newElement);
							} else {
								assignToPartitionNotAutomatic(partition,
										newElement, textblock ,partitionHandlingWithRefObject, classTemplate,
										newElement.get___Connection(),
										getMainPartition());
							}

						}
					} else {
						partition = newElement.get___Partition();
						System.out.println("");
						System.out.println(partition);
						System.out.println("");
						partition.assignElementIncludingChildren(newElement);
					}

				} else if (partitionHandlingWithRefObject.getPartitionHandling()
						.isAutomaticPartition()) {

					assignToPartitionAutomatic(partition, originalPartition,
							newElement, textblock,parent, partitionHandlingWithRefObject ,classTemplate, newElement
									.get___Connection(), getMainPartition(),
							template.getConcretesyntax());

					/*
					 * The manual partition of ClassTemplate
					 */

				} else if (!partitionHandlingWithRefObject.getPartitionHandling()
						.isAutomaticPartition()) {

					assignToPartitionNotAutomatic(partition, newElement,
							textblock,partitionHandlingWithRefObject, classTemplate, newElement
									.get___Connection(), getMainPartition());
				}
				/*
				 * the case without Template
				 */

			} else if (!(template instanceof ClassTemplate)) {
				PRI originalPartition = partition.getPri();
				if (getMainPartition() != null) {
					assignToPartitionWithoutTemplate(getMainPartition(),
							originalPartition, newElement, textblock,
							newElement.get___Connection(), getMainPartition(),
							template.getConcretesyntax());
				} else {
					assignToPartitionWithoutTemplate(partition,
							originalPartition, newElement, textblock,
							newElement.get___Connection(), getMainPartition(),
							template.getConcretesyntax());

				}

			}

		}

	}
	


	/**
	 * Assigns the <code>textblock</code> and the PartitionHandling
	 * <code>template</code> to a partition according to the given Tag
	 * ""org.omg.sap2mof.requiresPartition" in the metamodel. If the tag is
	 * false or not specified assigns the <code>refObject</code> to the created
	 * partition <code>partition</code> or to the defaultPartition .
	 * 
	 * @param partition
	 * @param textblock
	 * @param partitionHandling
	 */

	public void assignToPartition(ModelPartition partition,
			TextBlock textblock,TextBlock parent, PartitionHandlingWithRefObject partitionHandling) {
		assignToPartition(partition, (RefObject) textblock, textblock,parent,
				partitionHandling);
	}

	/*
	 * Assign a partition to Property if needed
	 */
	/**
	 * Assigns the <code>refObject</code> with the <code>textblock</code> and
	 * the PartitionHandling <code>template</code> to a partition according to
	 * the given Tag ""org.omg.sap2mof.requiresPartition" in the metamodel. If
	 * the tag is false or not specified assigns the <code>refObject</code> to
	 * the created partition <code>partition</code> or to the defaultPartition .
	 * 
	 * @param partition
	 * @param newElement
	 * @param textblock
	 * @param partitionHandling
	 */
	@Override
	public void assignToPartition(ModelPartition partition,
			RefObject refObject, TextBlock textblock,TextBlock parent,
			PartitionHandlingWithRefObject partitionHandling) {
		PRI originalPartition = partition.getPri();
		setMainPartition(getMainPartition());

		if (partitionHandling.getPartitionHandling() == null) {
			

			PartitionHandlingWithRefObject parentPartitionHandling2 = takeParentPartitionHandling(textblock, parent);
			// assign to Parent, if it have a PartitionHandling
			if (parentPartitionHandling2.getPartitionHandling()!= null) {

				if (parentPartitionHandling2.getPartitionHandling().isAutomaticPartition()) {
					assignToPartitionAutomaticForProperty(partition, originalPartition,
							refObject, textblock,parent, partitionHandling, refObject
									.get___Connection(), getMainPartition(),
							getConcreteSyntax());
				} else  if (!partitionHandling.getPartitionHandling().isAutomaticPartition()){
					assignToPartitionNotAutomaticForProperty(partition,
							refObject, textblock, partitionHandling, refObject
									.get___Connection());
				}
				
			} else if (getConcreteSyntax() != null) {
				if (getConcreteSyntax().getPartitionHandling() != null) {
					partition = getMainPartition();

					if (getConcreteSyntax().getPartitionHandling()
							.isAutomaticPartition()) {
						System.out.println("");
						System.out.println(partition);
						System.out.println("");
						partition.assignElementIncludingChildren(refObject);
					} else {
						assignToPartitionNotAutomaticForProperty(partition,
								refObject, textblock, partitionHandling,
								refObject.get___Connection());
					}
				}
			} else {
				partition = refObject.get___Partition();
				System.out.println("");
				System.out.println(partition);
				System.out.println("");
				partition.assignElementIncludingChildren(refObject);
			}

		} else if (partitionHandling.getPartitionHandling().isAutomaticPartition()) {

			assignToPartitionAutomaticForProperty(partition, originalPartition,
					refObject, textblock,parent, partitionHandling, refObject
							.get___Connection(), getMainPartition(),
					getConcreteSyntax());
			/*
			 * The manual partition of ClassTemplate
			 */

		} else if (!partitionHandling.getPartitionHandling().isAutomaticPartition()) {

			assignToPartitionNotAutomaticForProperty(partition, refObject,
					textblock, partitionHandling, refObject.get___Connection());
		}

	}

	// automatic partition for Properties
	private void assignToPartitionAutomaticForProperty(
			ModelPartition partition, PRI originalPartition,
			RefObject refObject, TextBlock textb1,TextBlock parent,
			PartitionHandlingWithRefObject partitionHandling, Connection connection,
			ModelPartition mainPartition, ConcreteSyntax concreteSyntax) {

		if ((partitionHandling.getPartitionHandling().getContainer() == null)
				&& (partitionHandling.getPartitionHandling().getName() == null)) {
			PartitionHandlingWithRefObject parentPartitionHandling3 = takeParentPartitionHandling(textb1,parent);
			// assign to Parent, if it have a PartitionHandling
			if (parentPartitionHandling3 != null) {
				assignToPartitionAutomaticForProperty(
						 partition,  originalPartition,
						 refObject,  textb1,parent,
						 parentPartitionHandling3,  connection,
						 mainPartition,  concreteSyntax);

			} else if (mainPartition != null) {
				partition = mainPartition; // the partition of the main
				// (concrete
				// syntax will be taken)
			} else {
				partition = connection.getPartition(originalPartition);// the
				// original
				// partition
				// will
				// be
				// taken

			}

		} else if ((partitionHandling.getPartitionHandling() != null)
				&& (partitionHandling.getPartitionHandling().getName() == null)) {
			PRI newTargetPRI = connection.getSession().getMoin()
					.createPri(
							originalPartition.getDataAreaDescriptor()
									.getFacilityId(),
							originalPartition.getDataAreaDescriptor()
									.getDataAreaName(),
							partitionHandling.getPartitionHandling().getContainer(),
							originalPartition.getPartitionName()); // The
			// original
			// name
			// will
			// be
			// taken
			partition = connection.createPartition(newTargetPRI);

		} else if ((partitionHandling.getPartitionHandling().getContainer() == null)
				&& (partitionHandling.getPartitionHandling().getName() != null)) {

			PRI newTargetPRI = connection.getSession().getMoin()
					.createPri(
							originalPartition.getDataAreaDescriptor()
									.getFacilityId(),
							originalPartition.getDataAreaDescriptor()
									.getDataAreaName(),
							originalPartition.getContainerName(),
							evaluatedOCLForProperty(refObject,
									partitionHandling,
									connection));

			if (connection.getPartition(newTargetPRI) != null) {
				partition = connection.getPartition(newTargetPRI);
			} else {

				partition = connection.createPartition(newTargetPRI);
			}

			// }

		}

		System.out.println("");
		System.out.println(partition);
		System.out.println("");
		partition.assignElementIncludingChildren(refObject);

	}

	// automatic partition for classTemplate
	private void assignToPartitionAutomatic(ModelPartition partition,
			PRI originalPartition, RefObject newElement, TextBlock textb2,TextBlock parent,PartitionHandlingWithRefObject partitionHandlingWithRefObject,
			ClassTemplate classTemplate, Connection connection,
			ModelPartition mainPartition, ConcreteSyntax concreteSyntax) {

		if ((partitionHandlingWithRefObject.getPartitionHandling().getContainer() == null)
				&& (partitionHandlingWithRefObject.getPartitionHandling().getName() == null)) {

			PartitionHandlingWithRefObject parentPartitionHandling4 = takeParentPartitionHandling(textb2, parent);
			// assign to Parent, if it have a PartitionHandling
			if (parentPartitionHandling4 != null) {
				assignToPartitionAutomatic( partition,
						 originalPartition,  newElement,  textb2, parent, parentPartitionHandling4,
						 classTemplate,  connection,
						 mainPartition,  concreteSyntax);
			} else if (mainPartition != null) {
				partition = mainPartition;
			} else {
				partition = connection.getPartition(originalPartition);// the
				// original
				// partition
				// will
				// be
				// taken

			}

		} else if ((partitionHandlingWithRefObject.getPartitionHandling().getContainer() != null)
				&& (partitionHandlingWithRefObject.getPartitionHandling().getName() == null)) {
			PRI newTargetPRI = connection
					.getSession()
					.getMoin()
					.createPri(
							originalPartition.getDataAreaDescriptor()
									.getFacilityId(),
							originalPartition.getDataAreaDescriptor()
									.getDataAreaName(),
									partitionHandlingWithRefObject.getPartitionHandling().getContainer(),
							originalPartition.getPartitionName()); // The
			// original
			// name
			// will
			// be
			// taken
			partition = connection.createPartition(newTargetPRI);

		} else if ((partitionHandlingWithRefObject.getPartitionHandling().getContainer() == null)
				&& (partitionHandlingWithRefObject.getPartitionHandling().getName() != null)) {
			PRI newTargetPRI = connection.getSession().getMoin()
					.createPri(
							originalPartition.getDataAreaDescriptor()
									.getFacilityId(),
							originalPartition.getDataAreaDescriptor()
									.getDataAreaName(),
							originalPartition.getContainerName(),
							evaluateOCL(newElement, classTemplate,partitionHandlingWithRefObject, connection));

			if (connection.getPartition(newTargetPRI) != null) {
				partition = connection.getPartition(newTargetPRI);
			} else {

				partition = connection.createPartition(newTargetPRI);
			}
		}

		System.out.println("");
		System.out.println(partition);
		System.out.println("");

		partition.assignElementIncludingChildren(newElement);

	}

	// to assign the partition for elements that are not ClassTemplate or
	// Property
	private void assignToPartitionWithoutTemplate(ModelPartition partition,
			PRI originalPartition, RefObject newElement, TextBlock textb3,
			Connection connection, ModelPartition mainPartition,
			ConcreteSyntax concreteSyntax) {
		originalPartition = partition.getPri();
		PRI targetPRI = connection.getSession().getMoin().createPri(
				originalPartition.getDataAreaDescriptor().getFacilityId(),
				originalPartition.getDataAreaDescriptor().getDataAreaName(),
				originalPartition.getContainerName(),
				getPartitionName(newElement, originalPartition
						.getPartitionName()));

		if (connection.partitionExists(targetPRI)) {
			partition = connection.getPartition(targetPRI);
		} else {
			partition = mainPartition;
			// partition = connection.createPartition(targetPRI);
		}
		System.out.println("");
		System.out.println(partition);
		System.out.println("");
		partition.assignElementIncludingChildren(newElement);

	}

	// not automatic partition for Properties
	private void assignToPartitionNotAutomaticForProperty(
			ModelPartition partition, RefObject refObject, TextBlock textb4,
			PartitionHandlingWithRefObject partitionHandling, Connection connection) {
		// interactiveContent = "";
		if (interactiveResult == null
				|| !interactiveResult.isInteractivePartition()) {
			interactiveResult = interactivePartitionHandler.getPartitionFor(
					partitionHandling.getPartitionHandling(), partition, refObject, connection);
		}
		interactiveContent = interactiveResult.getMainPartitionContent();
		if (refObject instanceof TextBlock
				&& (interactiveContent.equalsIgnoreCase("textBlocks") || interactiveContent
						.equalsIgnoreCase("all"))) {
			TextBlock resultTB = (TextBlock) refObject;
			
			if (interactiveResult.getPri_Result() != null) {
				// to check if the partition already exists!
				if (connection.partitionExists(interactiveResult
						.getPri_Result())) {
					partition = connection.getPartition(interactiveResult
							.getPri_Result());
				} else {
					partition = connection.createPartition(interactiveResult
							.getPri_Result());

				}
				System.out.println("");
				System.out.println("The textBlock" + resultTB
						+ "has been stored in");
				System.out.println("");

				System.out.println("");
				System.out.println(partition);
				System.out.println("");

				partition.assignElementIncludingChildren(resultTB);

			} else {
				/*
				 * the user don´t want a manual partition and it will be stored
				 * in the main partition
				 */
				if (getMainPartition() != null) {
					partition = getMainPartition();
				} else {
					partition = refObject.get___Partition();
				}
				System.out.println("");
				System.out.println("The textBlock" + resultTB
						+ "has been stored in");
				System.out.println("");

				System.out.println("");
				System.out.println(partition);
				System.out.println("");

				partition.assignElementIncludingChildren(resultTB);
			}

		} else {
			if ( (!(refObject instanceof TextBlock)) &&(interactiveContent.equalsIgnoreCase("all")
					|| interactiveContent.equalsIgnoreCase("model"))) {

				if (interactiveResult.getPri_Result() != null) {
					// to check if the partition already exists!
					if (connection.partitionExists(interactiveResult
							.getPri_Result())) {
						partition = connection.getPartition(interactiveResult
								.getPri_Result());
					} else {
						partition = connection
								.createPartition(interactiveResult
										.getPri_Result());

					}
					System.out.println("");
					System.out.println(partition);
					System.out.println("");

					partition.assignElementIncludingChildren(refObject);

				} else {
					/*
					 * the user don´t want a manual partition and it will be
					 * stored in the main partition
					 */
					if (getMainPartition() != null) {
						partition = getMainPartition();
					} else {
						partition = refObject.get___Partition();
					}
					System.out.println("");
					System.out.println(partition);
					System.out.println("");

					partition.assignElementIncludingChildren(refObject);
				}
				
			} 

		}

	}

	// not automatic partition for classTemplate

	private void assignToPartitionNotAutomatic(ModelPartition partition,
			RefObject refObject, TextBlock textb5,PartitionHandlingWithRefObject partitionHandling, ClassTemplate classTemplate,
			Connection connection, ModelPartition mainPartition) {
		interactiveContent = "";
		if (interactiveResult == null
				|| !interactiveResult.isInteractivePartition()) {
			interactiveResult = interactivePartitionHandler.getPartitionFor(
					partitionHandling.getPartitionHandling(), partition, refObject,
					connection);
		}
		interactiveContent = interactiveResult.getMainPartitionContent();

		if (refObject instanceof TextBlock && (interactiveContent.equalsIgnoreCase("textBlocks") || interactiveContent
				.equalsIgnoreCase("all"))) {
			TextBlock resultTB = (TextBlock) refObject;

				if (interactiveResult.getPri_Result() != null) {
					// to check if the partition already exists!
					if (connection.partitionExists(interactiveResult
							.getPri_Result())) {
						partition = connection.getPartition(interactiveResult
								.getPri_Result());
					} else {
						partition = connection
								.createPartition(interactiveResult
										.getPri_Result());

					}
					System.out.println("");
					System.out.println(partition);
					System.out.println("");

					partition.assignElementIncludingChildren(resultTB);

				} else {
					/*
					 * the user don´t want a manual partition and it will be
					 * stored in the main partition
					 */
					if (getMainPartition() != null) {
						partition = getMainPartition();
					} else {
						partition = refObject.get___Partition();
					}
					System.out.println("");
					System.out.println(partition);
					System.out.println("");

					partition.assignElementIncludingChildren(resultTB);
				}
				

		} else {
			if ((!(refObject instanceof TextBlock)) && (interactiveContent.equalsIgnoreCase("all")
					|| interactiveContent.equalsIgnoreCase("model"))) {

				if (interactiveResult.getPri_Result() != null) {
					// to check if the partition already exists!
					if (connection.partitionExists(interactiveResult
							.getPri_Result())) {
						partition = connection.getPartition(interactiveResult
								.getPri_Result());
					} else {
						partition = connection
								.createPartition(interactiveResult
										.getPri_Result());

					}
					
					System.out.println("");
					System.out.println(partition);
					System.out.println("");

					partition.assignElementIncludingChildren(refObject);

				} else {
					/*
					 * the user don´t want a manual partition and it will be
					 * stored in the main partition
					 */
					if (getMainPartition() != null) {
						partition = getMainPartition();
					} else {
						partition = refObject.get___Partition();
					}
					System.out.println("");
					System.out.println(partition);
					System.out.println("");

					partition.assignElementIncludingChildren(refObject);
				}
				
			}
		
		}

	}

	public void setInteractivePartitionHandler(InteractivePartitionHandler iph) {
		this.interactivePartitionHandler = iph;
	}

	@Override
	public String evaluatedOCLForProperty(RefObject inputRefObject,
			 PartitionHandlingWithRefObject partitionHandling, Connection connection) {

//		RefObject refObject = partitionHandling.getRefObject();
		RefObject refObject = inputRefObject;

		String evaluatedOCL = "";
		packagesForLookup = new RefPackage[1];
		packagesForLookup[0] = refObject.refOutermostPackage();

		OclExpressionRegistration reg = (OclExpressionRegistration) connection
				.getOclRegistryService().getFreestyleRegistry()
				.getRegistration(refObject.get___Mri().toString());
		if (reg == null) {

			try {
				

				refObject.refOutermostPackage().getClass().getPackage();

				reg = connection.getOclRegistryService().getFreestyleRegistry()
						.createExpressionRegistration(
								 refObject.get___Mri().toString(),
								partitionHandling.getPartitionHandling().getName(),
								OclRegistrationSeverity.Warning,
								new String[] { "TCSPropertyQuery" },
								 refObject.refClass(), packagesForLookup);
			} catch (JmiException e) {
				e.printStackTrace();
			} catch (OclManagerException e) {
				e.printStackTrace();
			}
			try {
				evaluatedOCL = reg.evaluateExpression( refObject).toString();
			} catch (OclManagerException e) {
				e.printStackTrace();
			}

		} else {
			try {
				evaluatedOCL = reg.evaluateExpression( refObject).toString();
			} catch (OclManagerException e) {
				e.printStackTrace();
			}
		}

		return evaluatedOCL;

	}

	private String evaluateOCL(RefObject inputRefObject, Template template,PartitionHandlingWithRefObject partitionHandling,
			Connection connection) {
		RefObject refObject = null;
		String evaluatedOCL = "";
		packagesForLookup = new RefPackage[1];
		

		if (partitionHandling.getRefObject() instanceof TextBlock) {

			evaluatedOCL = evaluatedOCL_For_TextBlocks(partitionHandling.getRefObject(),
					template,partitionHandling, packagesForLookup, connection);

		} else {

			refObject = partitionHandling.getRefObject();
			packagesForLookup[0] = refObject.refOutermostPackage();

			OclExpressionRegistration reg = (OclExpressionRegistration) connection
					.getOclRegistryService().getFreestyleRegistry()
					.getRegistration(refObject.get___Mri().toString());
			if (reg == null) {

				try {

					refObject.refOutermostPackage().getClass().getPackage();

					reg = connection.getOclRegistryService()
							.getFreestyleRegistry()
							.createExpressionRegistration(
									refObject.get___Mri().toString(),
									partitionHandling.getPartitionHandling()
											.getName(),
									OclRegistrationSeverity.Warning,
									new String[] { "TCSPropertyQuery" },
									refObject.refClass(), packagesForLookup);
				} catch (JmiException e) {
					e.printStackTrace();
				} catch (OclManagerException e) {
					e.printStackTrace();
				}

				try {
					evaluatedOCL = reg.evaluateExpression(refObject).toString();
				} catch (OclManagerException e) {
					e.printStackTrace();
				}

			} else {
				try {
					evaluatedOCL = reg.evaluateExpression(refObject).toString();
				} catch (OclManagerException e) {
					e.printStackTrace();
				}

			}
		}
		return evaluatedOCL;
	}

	private String evaluatedOCL_For_TextBlocks(RefObject inputRefObject,
			Template template,PartitionHandlingWithRefObject partitionHandling, RefPackage[] packagesForLookup2,
			Connection connection) {
		RefObject refObject = null;
		String unnamed = "";
		String evaluatedOCL = "";
		packagesForLookup = new RefPackage[1];

		TextBlock tb = (TextBlock) partitionHandling.getRefObject();

		if (((TextBlock) inputRefObject).getCorrespondingModelElements().size() > 1) {
			for (RefObject newRefObject : ((TextBlock) inputRefObject)
					.getCorrespondingModelElements()) {
				if (newRefObject.refIsInstanceOf(template.getMetaReference(),
						true)) {
					refObject = newRefObject;
					break;

				}
			}

			template = null;
			if (refObject.refIsInstanceOf(tb.getType().getParseRule()
					.getMetaReference(), false)) {
				template = tb.getType().getParseRule();
			} else {
				for (Template addTemp : tb.getAdditionalTemplates()) {
					if (refObject.refIsInstanceOf(addTemp.getMetaReference(),
							false)) {
						template = addTemp;
						break;
					}
				}
			}

			// refObject = inputRefObject;
			// unnamed = classTemplate.getPartitionHandling().getName().replace(
			// "self.name", " \'_unnamed \' ");
			packagesForLookup[0] = refObject.refOutermostPackage();

			OclExpressionRegistration reg = (OclExpressionRegistration) connection
					.getOclRegistryService().getFreestyleRegistry()
					.getRegistration(refObject.get___Mri().toString());
			if (reg == null) {

				try {

					refObject.refOutermostPackage().getClass().getPackage();

					// if (((TextBlock) inputRefObject)
					// .getCorrespondingModelElements().size() == 0) {

					reg = connection.getOclRegistryService()
							.getFreestyleRegistry()
							.createExpressionRegistration(
									refObject.get___Mri().toString(),
									partitionHandling.getPartitionHandling()
											.getName(),
									OclRegistrationSeverity.Warning,
									new String[] { "TCSPropertyQuery" },
									refObject.refClass(), packagesForLookup);
					// }
				} catch (JmiException e) {
					e.printStackTrace();
				} catch (OclManagerException e) {
					e.printStackTrace();
				}
				try {
					evaluatedOCL = reg.evaluateExpression(refObject).toString();
				} catch (OclManagerException e) {
					e.printStackTrace();
				}
			} else {
				try {
					evaluatedOCL = reg.evaluateExpression(refObject).toString();
				} catch (OclManagerException e) {
					e.printStackTrace();
				}

			}

		} else if (((TextBlock) inputRefObject).getCorrespondingModelElements()
				.size() == 0) {
			refObject = inputRefObject;
			unnamed = partitionHandling.getPartitionHandling().getName().replace(
					"self.name", " \'_unnamed \' ");
			packagesForLookup[0] = refObject.refOutermostPackage();

			OclExpressionRegistration reg = (OclExpressionRegistration) connection
					.getOclRegistryService().getFreestyleRegistry()
					.getRegistration(refObject.get___Mri().toString());
			if (reg == null) {

				try {

					refObject.refOutermostPackage().getClass().getPackage();

					if (((TextBlock) inputRefObject)
							.getCorrespondingModelElements().size() == 0) {

						reg = connection
								.getOclRegistryService()
								.getFreestyleRegistry()
								.createExpressionRegistration(
										refObject.get___Mri().toString(),
										unnamed,
										OclRegistrationSeverity.Warning,
										new String[] { "TCSPropertyQuery" },
										refObject.refClass(), packagesForLookup);
					}
				} catch (JmiException e) {
					e.printStackTrace();
				} catch (OclManagerException e) {
					e.printStackTrace();
				}
				try {
					evaluatedOCL = reg.evaluateExpression(refObject).toString();
				} catch (OclManagerException e) {
					e.printStackTrace();
				}
			} else {
				try {
					evaluatedOCL = reg.evaluateExpression(refObject).toString();
				} catch (OclManagerException e) {
					e.printStackTrace();
				}

			}

		} else {

			refObject = ((TextBlock) inputRefObject)
					.getCorrespondingModelElements().get(0);
			// refObject = inputRefObject;

			packagesForLookup[0] = refObject.refOutermostPackage();

			OclExpressionRegistration reg = (OclExpressionRegistration) connection
					.getOclRegistryService().getFreestyleRegistry()
					.getRegistration(refObject.get___Mri().toString());
			if (reg == null) {

				try {

					refObject.refOutermostPackage().getClass().getPackage();

					reg = connection.getOclRegistryService()
							.getFreestyleRegistry()
							.createExpressionRegistration(
									refObject.get___Mri().toString(),
									partitionHandling.getPartitionHandling()
											.getName(),
									OclRegistrationSeverity.Warning,
									new String[] { "TCSPropertyQuery" },
									refObject.refClass(), packagesForLookup);
				} catch (JmiException e) {
					e.printStackTrace();
				} catch (OclManagerException e) {
					e.printStackTrace();
				}

				try {
					evaluatedOCL = reg.evaluateExpression(refObject).toString();
				} catch (OclManagerException e) {
					e.printStackTrace();
				}
			} else {
				try {
					evaluatedOCL = reg.evaluateExpression(refObject).toString();
				} catch (OclManagerException e) {
					e.printStackTrace();
				}
			}
		}
		return evaluatedOCL;
	}

	private String getPartitionName(RefObject newElement,
			String originalPartitionName) {
		String ts = Long.toHexString(System.currentTimeMillis());
		String name = null;
		java.lang.reflect.Method[] methods = newElement.getClass().getMethods();
		for (java.lang.reflect.Method m : methods) {
			if (m.getName().equals("getName")) {
				try {
					name = (String) m.invoke(newElement);
					break;
				} catch (Exception e) {
					// do nothing;
				}
			}
		}
		if (name == null) {
			name = (String) newElement.refMetaObject().refGetValue("name");
		}
		if (originalPartitionName != null
				&& originalPartitionName.lastIndexOf('.') > 0) {
			return originalPartitionName.substring(0, originalPartitionName
					.lastIndexOf("/") + 1)
					+ name
					+ ts
					+ originalPartitionName.substring(originalPartitionName
							.lastIndexOf('.'));
		} else {
			return "src/" + name + ts + ".xmi";
		}
	}

	@Override
	public void assignFromProxy(IModelElementProxy proxy, SequenceElement se,
			TextBlock textBlock, TextBlock parent, Template template,
			ModelPartition defaultPartition) {
		setInteractivePartitionHandler(interactivePartitionHandler);
		RefObject result = (RefObject) proxy.getRealObject();
		if (!proxy.isReferenceOnly()) {

			if (result instanceof TextBlock) {
				assign_TB_Fromproxy(proxy, textBlock,parent, se, template,
						defaultPartition);

			} else {
				// if result is a model element
				assign_Model_from_Proxy(proxy, se, textBlock,parent, template,
						defaultPartition);
			}

		}

	}

	private void assign_Model_from_Proxy(IModelElementProxy proxy,
			SequenceElement se, TextBlock tb2,TextBlock parent, Template template,
			ModelPartition defaultPartition) {
		RefObject result = (RefObject) proxy.getRealObject();
	
		
		if (interactiveContent != null) {
			if (!(interactiveContent.equalsIgnoreCase("textblocks"))) {
				if (se != null && se instanceof Property) {
					
					Property seqElement = (Property) se;
					if ((TcsUtil.getPartitionHandlingParg(seqElement) != null)
							&& ((seqElement).getPropertyArgs() != null)) {
						// to lcheck

						if (TcsUtil.getPartitionHandlingParg(seqElement)
								.getPartitionhandling().getContent().toString()
								.equalsIgnoreCase("all")
								|| TcsUtil.getPartitionHandlingParg(seqElement)
										.getPartitionhandling().getContent()
										.toString().equalsIgnoreCase("model")) {

							// the model element will be
							// stored just when content
							// equals all or model
							Object refGetValue = "";
							try {
								refGetValue = result.refGetValue("name");
							} catch (Exception e) {
								// TODO: handle exception
							}
							System.out
									.println("The element "
											+ result
											+ " mit name "
											+ refGetValue
											+ " in assignFromProxy1 has been stored in .....");
							PartitionHandlingWithRefObject partitionHandlingWithRefObject = new PartitionHandlingWithRefObject(TcsUtil
											.getPartitionHandlingParg(
													seqElement)
											.getPartitionhandling(), result);
							assignToPartition(defaultPartition, result, tb2,parent,
									partitionHandlingWithRefObject);
						}else {
							defaultPartition.assignElementIncludingChildren(result);
						}
					} else {
						if (template instanceof ClassTemplate
								&& ((ClassTemplate) template).getPartitionHandling() != null) {

							if (((ClassTemplate) template).getPartitionHandling()
									.getContent().toString().equalsIgnoreCase("model")
									|| ((ClassTemplate) template)
											.getPartitionHandling().getContent()
											.toString().equalsIgnoreCase("all")) {
								Object refGetValue = "";
								try {
									refGetValue = result.refGetValue("name");
								} catch (Exception e) {
									// TODO: handle exception
								}
								System.out
										.println("The element "
												+ result
												+ "mit name "
												+ refGetValue
												+ "in assignFromProxy30 has been stored in .....");
								PartitionHandlingWithRefObject parthandl2 = new PartitionHandlingWithRefObject(null, result);
								assignToPartition(defaultPartition, result, tb2,parent,parthandl2,
										template);

							}else {
								defaultPartition.assignElementIncludingChildren(result);
							}

						} else {
							PartitionHandlingWithRefObject parentPartitionHandling3 = takeParentPartitionHandling(tb2, parent);
							if (parentPartitionHandling3.getPartitionHandling() != null) {
								if (parentPartitionHandling3.getPartitionHandling().getContent()
										.toString().equalsIgnoreCase("all")
										|| parentPartitionHandling3.getPartitionHandling().getContent()
												.toString().equals("model")) {
									Object refGetValue = "";
									try {
										refGetValue = result.refGetValue("name");
									} catch (Exception e) {
										// TODO: handle exception
									}
									System.out
											.println("The element "
													+ result
													+ "mit name "
													+ refGetValue
													+ "in assignFromProxy2 has been stored in .....");

									assignToPartition(defaultPartition, result,
											tb2,parent, parentPartitionHandling3, template);

								}else {
									defaultPartition.assignElementIncludingChildren(result);
								}
							} else {
								PartitionHandlingWithRefObject parthandl = new PartitionHandlingWithRefObject(null, result);
								if ((getMainPartitionContent()
										.equalsIgnoreCase("all"))
										|| (getMainPartitionContent()
												.equalsIgnoreCase("model"))) {
									Object refGetValue = "";
									try {
										refGetValue = result.refGetValue("name");
									} catch (Exception e) {
										// TODO: handle exception
									}
									System.out
											.println("The element "
													+ result
													+ " mit name "
													+ refGetValue
													+ " in assignFromProxy2 has been stored in .....");
									
									assignToPartition(defaultPartition, result,
											tb2,parent, parthandl,template);

								}else {
									defaultPartition.assignElementIncludingChildren(result);
								}
							}
						}

					

					}

				} else if (template instanceof ClassTemplate
						&& ((ClassTemplate) template).getPartitionHandling() != null) {

					if (((ClassTemplate) template).getPartitionHandling()
							.getContent().toString().equalsIgnoreCase("model")
							|| ((ClassTemplate) template)
									.getPartitionHandling().getContent()
									.toString().equalsIgnoreCase("all")) {
						Object refGetValue = "";
						try {
							refGetValue = result.refGetValue("name");
						} catch (Exception e) {
							// TODO: handle exception
						}
						System.out
								.println("The element "
										+ result
										+ "mit name "
										+ refGetValue
										+ "in assignFromProxy30 has been stored in .....");
						PartitionHandlingWithRefObject parthandl2 = new PartitionHandlingWithRefObject(null, result);
						assignToPartition(defaultPartition, result, tb2,parent,parthandl2,
								template);

					}else {
						defaultPartition.assignElementIncludingChildren(result);
					}

				} else {
					
					PartitionHandlingWithRefObject parentPartitionHandling1 = takeParentPartitionHandling(tb2, parent);
					if (parentPartitionHandling1.getPartitionHandling() != null) {
						if (parentPartitionHandling1.getPartitionHandling().getContent().toString()
								.equalsIgnoreCase("all")
								|| parentPartitionHandling1.getPartitionHandling().getContent()
										.toString().equals("model")) {
							Object refGetValue = "";
							try {
								refGetValue = result.refGetValue("name");
							} catch (Exception e) {
								// TODO: handle exception
							}
							System.out
									.println("The element "
											+ result
											+ "mit name "
											+ refGetValue
											+ "in assignFromProxy31 has been stored in .....");
							assignToPartition(defaultPartition, result, tb2,parent,
									parentPartitionHandling1, template);

						}else {
							defaultPartition.assignElementIncludingChildren(result);
						}
					} else if ((getMainPartitionContent()
							.equalsIgnoreCase("all"))
							|| (getMainPartitionContent()
									.equalsIgnoreCase("model"))) {
						PartitionHandlingWithRefObject parthandl4 = new PartitionHandlingWithRefObject(null, result);

						Object refGetValue = "";
						try {
							refGetValue = result.refGetValue("name");
						} catch (Exception e) {
							// TODO: handle exception
						}
						System.out
								.println("The element "
										+ result
										+ "mit name "
										+ refGetValue
										+ "in assignFromProxy32 has been stored in .....");

						assignToPartition(defaultPartition, result, tb2,parent,parthandl4,
								template);

					}else {
						defaultPartition.assignElementIncludingChildren(result);
					}
				}
			}

		}
	}

	private void assign_TB_Fromproxy(IModelElementProxy proxy,
			TextBlock textBlock1, TextBlock parent, SequenceElement se, Template template,
			ModelPartition defaultPartition) {
		RefObject result = (RefObject) proxy.getRealObject();
		
		if (interactiveContent != null) {
			if (!(interactiveContent.equalsIgnoreCase("model"))) {

				if (se != null && se instanceof Property) {
					Property seqElement = (Property) se;

					if ((TcsUtil.getPartitionHandlingParg(seqElement) != null)
							&& ((seqElement).getPropertyArgs() != null)) {
						// to lcheck

						if (TcsUtil.getPartitionHandlingParg(seqElement)
								.getPartitionhandling().getContent().toString()
								.equalsIgnoreCase("all")
								|| TcsUtil.getPartitionHandlingParg(seqElement)
										.getPartitionhandling().getContent()
										.toString().equalsIgnoreCase(
												"textblocks")) {

							// the model element will be
							// stored just when content
							// equals all or model
							Object refGetValue = "";
							try {
								refGetValue = result.refGetValue("name");
							} catch (Exception e) {
								// TODO: handle exception
							}
							System.out
									.println("The element "
											+ result
											+ " mit name "
											+ refGetValue
											+ " in assignFromProxy1 has been stored in .....");
							PartitionHandlingWithRefObject partitionHandlingWithRefObject1 = new PartitionHandlingWithRefObject(TcsUtil.getPartitionHandlingParg(
												seqElement)
												.getPartitionhandling(), result);
							if (result instanceof TextBlock) {
								assignToPartition(defaultPartition,
										(TextBlock) result, (TextBlock) result,
										partitionHandlingWithRefObject1);
							} else {
								assignToPartition(defaultPartition,
										(RefObject) result, textBlock1,parent, partitionHandlingWithRefObject1);
							}

						}
//						else {
//							defaultPartition.assignElementIncludingChildren(result);
//						}
					} else {
						if (template instanceof ClassTemplate
								&& ((ClassTemplate) template).getPartitionHandling()
										.getContent() != null) {

							if (((ClassTemplate) template).getPartitionHandling()
									.getContent().toString().equalsIgnoreCase(
											"textblocks")
									|| ((ClassTemplate) template)
											.getPartitionHandling().getContent()
											.toString().equalsIgnoreCase("all")) {
								Object refGetValue = "";
								try {
									refGetValue = result.refGetValue("name");
								} catch (Exception e) {
									// TODO: handle exception
								}
								System.out
										.println("The element "
												+ result
												+ "mit name "
												+ refGetValue
												+ "in assignFromProxy311 has been stored in .....");
								PartitionHandlingWithRefObject partHandl5 = new PartitionHandlingWithRefObject(null, result);
								assignToPartition(defaultPartition, (TextBlock) result,parent,partHandl5,
										template);

							}
//							else {
//								defaultPartition.assignElementIncludingChildren(result);
//							}

						} else {
							PartitionHandlingWithRefObject parentPartitionHandling1 = null;
							if (result instanceof TextBlock) {
								parentPartitionHandling1 = takeParentPartitionHandling((TextBlock) result, parent);
							} else {
								parentPartitionHandling1 = takeParentPartitionHandling(textBlock1, parent);
							}

							if (parentPartitionHandling1.getPartitionHandling() != null) {
								if (parentPartitionHandling1.getPartitionHandling().getContent()
										.toString().equalsIgnoreCase("all")
										|| parentPartitionHandling1.getPartitionHandling().getContent()
												.toString().equals("textblocks")) {

									System.out
											.println("The element "
													+ result
													+ "in CtsDocument has been stored in .....");

									assignToPartition(defaultPartition,
											(TextBlock) result,parent,parentPartitionHandling1, template);
								}
//								else {
//									defaultPartition.assignElementIncludingChildren(result);
//								}
							} else if ((getMainPartitionContent()
									.equalsIgnoreCase("all"))
									|| (getMainPartitionContent()
											.equalsIgnoreCase("textblocks"))) {
								PartitionHandlingWithRefObject partHandl4 = new PartitionHandlingWithRefObject(null, result);
								Object refGetValue = "";
								try {
									refGetValue = result.refGetValue("name");
								} catch (Exception e) {
									// TODO: handle exception
								}
								System.out
										.println("The element "
												+ result
												+ " mit name "
												+ refGetValue
												+ " in assignFromProxy2 has been stored in .....");

								assignToPartition(defaultPartition,
										(TextBlock) result, parent,partHandl4, template);

							}
//							else {
//								defaultPartition.assignElementIncludingChildren(result);
//							}
						}
						
						
						
						
					}

				} else if (template instanceof ClassTemplate
						&& ((ClassTemplate) template).getPartitionHandling()
								.getContent() != null) {

					if (((ClassTemplate) template).getPartitionHandling()
							.getContent().toString().equalsIgnoreCase(
									"textblocks")
							|| ((ClassTemplate) template)
									.getPartitionHandling().getContent()
									.toString().equalsIgnoreCase("all")) {
						Object refGetValue = "";
						try {
							refGetValue = result.refGetValue("name");
						} catch (Exception e) {
							// TODO: handle exception
						}
						System.out
								.println("The element "
										+ result
										+ "mit name "
										+ refGetValue
										+ "in assignFromProxy311 has been stored in .....");
						PartitionHandlingWithRefObject partHandl5 = new PartitionHandlingWithRefObject(null, result);
						assignToPartition(defaultPartition, (TextBlock) result,parent,partHandl5,
								template);

					}
//					else {
//						defaultPartition.assignElementIncludingChildren(result);				
//						}

				} else {

					PartitionHandlingWithRefObject parentPartitionHandling2 = null;
					if (result instanceof TextBlock) {
						parentPartitionHandling2 = takeParentPartitionHandling((TextBlock) result, parent);
					} else {
						parentPartitionHandling2 = takeParentPartitionHandling(textBlock1, parent);
					}
					if (parentPartitionHandling2.getPartitionHandling() != null) {
						if (parentPartitionHandling2.getPartitionHandling().getContent().toString()
								.equalsIgnoreCase("all")
								|| parentPartitionHandling2.getPartitionHandling().getContent()
										.toString().equals("textblocks")) {

							System.out.println("The element " + result
									+ "in assignTB has been stored in .....");

							assignToPartition(defaultPartition,
									(TextBlock) result, parent,parentPartitionHandling2, template);
						}
//						else {
//							defaultPartition.assignElementIncludingChildren(result);
//						}
					}
				}

				if ((getMainPartitionContent().equalsIgnoreCase("all"))
						|| (getMainPartitionContent()
								.equalsIgnoreCase("textblocks"))) {
					Object refGetValue = "";
					try {
						refGetValue = result.refGetValue("name");
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println("The element " + result + "mit name "
							+ refGetValue
							+ "in assignTB has been stored in .....");
					PartitionHandlingWithRefObject partHandl6 = new PartitionHandlingWithRefObject(null, result);
					assignToPartition(defaultPartition, (TextBlock) result,parent,partHandl6,
							template);

				}
//				else {
//					defaultPartition.assignElementIncludingChildren(result);
//				}
			}

		}

	}

	@Override
	public String getMainPartitionContent() {
		return mainPartitionContent;

	}

	public void setMainPartitionContent(String mainPartitionContent) {
		this.mainPartitionContent = mainPartitionContent;
	}

	public ModelPartition getMainPartition() {
		return mainPartition;
	}

	private void setMainPartition(ModelPartition mainPartition) {
		this.mainPartition = mainPartition;
	}

	@Override
	public void SetMainPartition_And_MainContent(ConcreteSyntax concreteSyntax,
			Connection connection, ModelPartition defaultPartition1) {
		setConcreteSyntax(concreteSyntax);

		// to set the mainPartition content
		if ((concreteSyntax != null)
				&& (concreteSyntax.getPartitionHandling() != null)) {
			PRI concretSyntax_PRI = null;
			if (concreteSyntax.getPartitionHandling().isAutomaticPartition()) {
				concretSyntax_PRI = getPRI_Of_ConcreteSyntax(concreteSyntax,
						connection, defaultPartition1);

				if (connection.getPartition(concretSyntax_PRI) != null) {
					mainPartition = connection.getPartition(concretSyntax_PRI);
					setMainPartition(mainPartition);
					mainPartitionContent = concreteSyntax
							.getPartitionHandling().getContent().toString();
					setMainPartitionContent(mainPartitionContent);
				} else {

					mainPartition = connection
							.createPartition(concretSyntax_PRI);
					setMainPartition(mainPartition);
					mainPartitionContent = concreteSyntax
							.getPartitionHandling().getContent().toString();
					setMainPartitionContent(mainPartitionContent);
				}
			} else {
				
				PRI concretSyntax_PRI1 = null;
				concretSyntax_PRI1 = getPRI_Of_ConcreteSyntax(concreteSyntax,
						connection, defaultPartition1);

				if (connection.getPartition(concretSyntax_PRI1) != null) {
					mainPartition = connection.getPartition(concretSyntax_PRI1);
					setMainPartition(mainPartition);
					mainPartitionContent = concreteSyntax
							.getPartitionHandling().getContent().toString();
					setMainPartitionContent(mainPartitionContent);
				} else {

					mainPartition = connection
							.createPartition(concretSyntax_PRI1);
					setMainPartition(mainPartition);
					mainPartitionContent = concreteSyntax
							.getPartitionHandling().getContent().toString();
					setMainPartitionContent(mainPartitionContent);
				}

			}
		}

	}

	public void setConcreteSyntax(ConcreteSyntax concreteSyntax2) {
		this.concreteSyntax2 = concreteSyntax2;

	}

	public ConcreteSyntax getConcreteSyntax() {
		return concreteSyntax2;
	}

	/*
	 * to get get the PRI of a ConcreteSyntax
	 */
	private PRI getPRI_Of_ConcreteSyntax(ConcreteSyntax concrete_syntax,
			Connection connection, ModelPartition defaultPartition2) {
		PRI newPRI = null;
		if ((concrete_syntax.getPartitionHandling().getContainer() == null)
				&& (concrete_syntax.getPartitionHandling().getName() == null)) {
			newPRI = defaultPartition2.getPri();

		} else if ((concrete_syntax.getPartitionHandling() != null)
				&& (concrete_syntax.getPartitionHandling().getName() == null)) {
			newPRI = connection.getSession().getMoin().createPri(
					defaultPartition2.getPri().getDataAreaDescriptor()
							.getFacilityId(),
					defaultPartition2.getPri().getDataAreaDescriptor()
							.getDataAreaName(),
					concrete_syntax.getPartitionHandling().getContainer(),
					defaultPartition2.getPri().getPartitionName());

		} else if ((concrete_syntax.getPartitionHandling().getContainer() == null)
				&& (concrete_syntax.getPartitionHandling().getName() != null)) {
			PartitionHandlingWithRefObject partHand = new PartitionHandlingWithRefObject(concrete_syntax.getPartitionHandling(), concrete_syntax);
			newPRI = connection.getSession().getMoin().createPri(
					defaultPartition2.getPri().getDataAreaDescriptor()
							.getFacilityId(),
					defaultPartition2.getPri().getDataAreaDescriptor()
							.getDataAreaName(),
					defaultPartition2.getPri().getContainerName(),
					evaluatedOCLForProperty(concrete_syntax, partHand, connection));

		}
		return newPRI;
	}

	@Override
	public PartitionHandlingWithRefObject takeParentPartitionHandling(TextBlock textblock,
			TextBlock parent) {
			PartitionHandlingWithRefObject partHand = null;
			if (textblock == null) {
				return partHand;
			}
			Template temp1 = textblock.getType().getParseRule();
			if (temp1 instanceof ClassTemplate) {
				ClassTemplate temp = (ClassTemplate) temp1;
				if (temp == null) {
					return partHand;
				} else {
					if(textblock.getCorrespondingModelElements().size() > 0) {
						partHand = new PartitionHandlingWithRefObject(temp.getPartitionHandling(), 
							textblock.getCorrespondingModelElements().iterator().next());
					}
				}
				if ( partHand == null || partHand.getPartitionHandling() == null) {
					if (parent != null) {
						textblock = parent;
						parent = parent.getParentBlock();
						return takeParentPartitionHandling( textblock, parent);
					} else {
						return partHand;
					}
				}
			}

			return partHand;

		}

	



}
