package com.sap.ide.cts.parser.incremental;

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



	/**
	 * Assigns the <code>newElement</code> with the given Template
	 * <code>template</code> to a partition according to the given Tag
	 * ""org.omg.sap2mof.requiresPartition" in the metamodel. If the tag is
	 * false or not specified assigns the <code>newElement</code> to the created
	 * partition <code>partition</code> or to the defaultPartition .
	 * 
	 * @param partition
	 * @param newElement
	 * @param template
	 */
	@Override
	public void assignToPartition(ModelPartition partition,
			RefObject newElement, Template template) {
		// setMainPartition(mainPartition);
		if (template != null) {
			if (template instanceof ClassTemplate) {

				ClassTemplate classTemplate = (ClassTemplate) template;
				classTemplate.getPartitionHandling();
				PRI originalPartition = partition.getPri();
				
				/*
				 * the automatic partition of ClassTemplate
				 */

				if (classTemplate.getPartitionHandling() == null) {

					// to check if the default partition has been set from the
					// concrete syntax
					if (template.getConcretesyntax() != null) {
						if (template.getConcretesyntax().getPartitionHandling() != null) {
							partition = getMainPartition();
							// setPartition(partition);
							partition
									.assignElementIncludingChildren(newElement);
						}
					} else {
						partition = newElement.get___Partition();
						partition.assignElementIncludingChildren(newElement);
					}

				} else if (classTemplate.getPartitionHandling()
						.isAutomaticPartition()) {

					assignToPartitionAutomatic(partition, originalPartition,
							newElement, classTemplate, newElement.get___Connection(),
							getMainPartition(), template.getConcretesyntax());

					/*
					 * The manual partition of ClassTemplate
					 */

				} else if (!classTemplate.getPartitionHandling()
						.isAutomaticPartition()) {

					assignToPartitionNotAutomatic(partition, originalPartition,
							newElement, classTemplate, newElement.get___Connection(),
							getMainPartition(), template.getConcretesyntax());
				}
				/*
				 * the case without Template
				 */

			} else if (!(template instanceof ClassTemplate)) {
				PRI originalPartition = partition.getPri();
				if (getMainPartition() != null) {
					assignToPartitionWithoutTemplate(getMainPartition(),
							originalPartition, newElement,newElement.get___Connection(),
							getMainPartition(), template.getConcretesyntax());
				} else {
					assignToPartitionWithoutTemplate(partition,
							originalPartition, newElement, newElement.get___Connection(),
							getMainPartition(), template.getConcretesyntax());

				}

			}

		}

	}

	/*
	 * Assign a partition for Property if needed
	 */
	@Override
	public void assignToPartition(ModelPartition partition,
			RefObject refObject, PartitionHandling partitionHandling) {
		PRI originalPartition = partition.getPri();
		setMainPartition(getMainPartition());

		if (partitionHandling == null) {
			// to check if the default partition has been set from the
			// concrete syntax
			if (getConcreteSyntax() != null) {
				if (getConcreteSyntax().getPartitionHandling() != null) {
					partition = getMainPartition();
					partition.assignElementIncludingChildren(refObject);
				}
			} else {
				partition = refObject.get___Partition();
				partition.assignElementIncludingChildren(refObject);
			}

		} else if (partitionHandling.isAutomaticPartition()) {

			assignToPartitionAutomaticForProperty(partition, originalPartition,
					refObject, partitionHandling, refObject.get___Connection(), getMainPartition(),
					getConcreteSyntax());
			/*
			 * The manual partition of ClassTemplate
			 */

		} else if (!partitionHandling.isAutomaticPartition()) {

			assignToPartitionNotAutomaticForProperty(partition,
					originalPartition, refObject, partitionHandling,
					refObject.get___Connection(), getMainPartition(), getConcreteSyntax());
		}

	}

	// automatic partition for Properties
	private void assignToPartitionAutomaticForProperty(
			ModelPartition partition, PRI originalPartition,
			RefObject refObject, PartitionHandling partitionHandling,
			Connection connection, ModelPartition mainPartition,
			ConcreteSyntax concreteSyntax) {

		if ((partitionHandling.getContainer() == null)
				&& (partitionHandling.getName() == null)) {

			if (mainPartition != null) {
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

		} else if ((partitionHandling != null)
				&& (partitionHandling.getName() == null)) {
			PRI newTargetPRI = connection.getSession().getMoin()
					.createPri(
							originalPartition.getDataAreaDescriptor()
									.getFacilityId(),
							originalPartition.getDataAreaDescriptor()
									.getDataAreaName(),
							partitionHandling.getContainer(),
							originalPartition.getPartitionName()); // The
			// original
			// name
			// will
			// be
			// taken
			partition = connection.createPartition(newTargetPRI);

		} else if ((partitionHandling.getContainer() == null)
				&& (partitionHandling.getName() != null)) {

			PRI newTargetPRI = connection.getSession().getMoin()
					.createPri(
							originalPartition.getDataAreaDescriptor()
									.getFacilityId(),
							originalPartition.getDataAreaDescriptor()
									.getDataAreaName(),
							originalPartition.getContainerName(),
							evaluatedOCLForProperty(refObject,
									partitionHandling, connection));

			if (connection.getPartition(newTargetPRI) != null) {
				partition = connection.getPartition(newTargetPRI);
			} else {

				partition = connection.createPartition(newTargetPRI);
			}

			// }

		}

		partition.assignElementIncludingChildren(refObject);

	}

	// automatic partition for classTemplate
	private void assignToPartitionAutomatic(ModelPartition partition,
			PRI originalPartition, RefObject newElement,
			ClassTemplate classTemplate, Connection connection,
			ModelPartition mainPartition, ConcreteSyntax concreteSyntax) {

		if ((classTemplate.getPartitionHandling().getContainer() == null)
				&& (classTemplate.getPartitionHandling().getName() == null)) {
			if (mainPartition != null) {
				partition = mainPartition;
			} else {
				partition = connection.getPartition(originalPartition);// the
				// original
				// partition
				// will
				// be
				// taken

			}

		} else if ((classTemplate.getPartitionHandling().getContainer() != null)
				&& (classTemplate.getPartitionHandling().getName() == null)) {
			PRI newTargetPRI = connection
					.getSession()
					.getMoin()
					.createPri(
							originalPartition.getDataAreaDescriptor()
									.getFacilityId(),
							originalPartition.getDataAreaDescriptor()
									.getDataAreaName(),
							classTemplate.getPartitionHandling().getContainer(),
							originalPartition.getPartitionName()); // The
			// original
			// name
			// will
			// be
			// taken
			partition = connection.createPartition(newTargetPRI);

		} else if ((classTemplate.getPartitionHandling().getContainer() == null)
				&& (classTemplate.getPartitionHandling().getName() != null)) {
			PRI newTargetPRI = connection.getSession().getMoin()
					.createPri(
							originalPartition.getDataAreaDescriptor()
									.getFacilityId(),
							originalPartition.getDataAreaDescriptor()
									.getDataAreaName(),
							originalPartition.getContainerName(),
							evaluateOCL(newElement, classTemplate, connection));

			if (connection.getPartition(newTargetPRI) != null) {
				partition = connection.getPartition(newTargetPRI);
			} else {

				partition = connection.createPartition(newTargetPRI);
			}
		}

		partition.assignElementIncludingChildren(newElement);

	}

	// to assign the partition for elements that are not ClassTemplate or
	// Property
	private void assignToPartitionWithoutTemplate(ModelPartition partition,
			PRI originalPartition, RefObject newElement, Connection connection,
			ModelPartition mainPartition, ConcreteSyntax concreteSyntax) {
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
			partition = connection.createPartition(targetPRI);
		}
		partition.assignElementIncludingChildren(newElement);

	}

	// not automatic partition for Properties
	private void assignToPartitionNotAutomaticForProperty(
			ModelPartition partition, PRI originalPartition,
			RefObject refObject, PartitionHandling partitionHandling,
			Connection connection, ModelPartition mainPartition,
			ConcreteSyntax concreteSyntax) {
		// //////////////////////
		// //////////////////////
		// /////////////////////////
		// //////////////////////
		// @christian Unterscheidung bei refObject bei Interaktion mit dem User
		// 
		// RefObject refObject kann noch instanceof texblock||RefObject sein

		SetInteractiveResult interactiveResult = interactivePartitionHandler.getPartitionFor(
				partitionHandling,partition, refObject, connection);
		if (interactiveResult.getMainPartitionContent().equalsIgnoreCase("model")  || interactiveResult.getMainPartitionContent().equalsIgnoreCase("all")  || partitionHandling.getContent().toString().equalsIgnoreCase("all")
				|| partitionHandling.getContent().toString().equalsIgnoreCase(
						"model")
				|| getMainPartitionContent().toString().equalsIgnoreCase("all")
				|| getMainPartitionContent().equalsIgnoreCase("model") ) {

			if (interactiveResult.getPri_Result() != null) {
				// to check if the partition already exists!
				if (connection.partitionExists(interactiveResult.getPri_Result())) {
					partition = connection.getPartition(interactiveResult.getPri_Result());
				} else {
					partition = connection.createPartition(interactiveResult.getPri_Result());

				}

			} else {
				/*
				 * the user don´t want a manual partition
				 */
				if (mainPartition != null) {
					partition = mainPartition;
				} else {
					partition = refObject.get___Partition();
				}

			}

			partition.assignElementIncludingChildren(refObject);
		}

	}

	// not automatic partition for classTemplate

	private void assignToPartitionNotAutomatic(ModelPartition partition,
			PRI originalPartition, RefObject newElement,
			ClassTemplate classTemplate, Connection connection,
			ModelPartition mainPartition, ConcreteSyntax concreteSyntax) {

		// //////////////////////
		// //////////////////////
		// /////////////////////////
		// //////////////////////
		// @christian Unterscheidung bei refObject bei Interaktion mit dem
		// User

		SetInteractiveResult interactiveResult2 = interactivePartitionHandler.getPartitionFor(
				classTemplate.getPartitionHandling(), partition ,newElement, connection);

		if (interactiveResult2.getMainPartitionContent().equalsIgnoreCase("model") || interactiveResult2.getMainPartitionContent().equalsIgnoreCase("all") ||classTemplate.getPartitionHandling().getContent().toString()
				.equalsIgnoreCase("all")
				|| classTemplate.getPartitionHandling().getContent().toString()
						.equalsIgnoreCase("model")
				|| getMainPartitionContent().toString().equalsIgnoreCase("all")
				|| getMainPartitionContent().equalsIgnoreCase("model")) {

			if (interactiveResult2.getPri_Result() != null) {
				// to check if the partition already exists!
				if (connection.partitionExists(interactiveResult2.getPri_Result())) {
					partition = connection.getPartition(interactiveResult2.getPri_Result());
				} else {
					partition = connection.createPartition(interactiveResult2.getPri_Result());

				}

			} else {
				/*
				 * the user don´t want a manual partition
				 */

				if (mainPartition != null) {
					partition = mainPartition; // The DefaultPartition is the partition of the
					// concretesyntax
				} else {
					partition = newElement.get___Partition();
				}

			}
			partition.assignElementIncludingChildren(newElement);

		}
	}

	public void setInteractivePartitionHandler(InteractivePartitionHandler iph) {
		this.interactivePartitionHandler = iph;

	}

	@Override
	public String evaluatedOCLForProperty(RefObject inputRefObject,
			PartitionHandling partitionHandling, Connection connection) {

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
								partitionHandling.getName(),
								OclRegistrationSeverity.Warning,
								new String[] { "TCSPropertyQuery" },
								refObject.refClass(), packagesForLookup);
			} catch (JmiException e) {
				e.printStackTrace();
			} catch (OclManagerException e) {
				e.printStackTrace();
			}

		}

		try {
			evaluatedOCL = reg.evaluateExpression(refObject).toString();
		} catch (OclManagerException e) {
			e.printStackTrace();
		}

		return evaluatedOCL;

	}

	private String evaluateOCL(RefObject inputRefObject, Template template,
			Connection connection) {
		RefObject refObject = null;

		if (inputRefObject instanceof TextBlock) {
			TextBlock tb = (TextBlock) inputRefObject;

			if (((TextBlock) inputRefObject).getCorrespondingModelElements()
					.size() > 1) {
				for (RefObject newRefObject : ((TextBlock) inputRefObject)
						.getCorrespondingModelElements()) {
					if (newRefObject.refIsInstanceOf(template
							.getMetaReference(), true)) {
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
						if (refObject.refIsInstanceOf(addTemp
								.getMetaReference(), false)) {
							template = addTemp;
							break;
						}
					}
				}
			} else {
				
				///////
				/////
				//Fehler hier size()  = 0
//				refObject = ((TextBlock) inputRefObject)
//				.getCorrespondingModelElements().iterator().next();
				refObject = inputRefObject;
			}
		} 
		else {

			refObject = inputRefObject;
		}

		String evaluatedOCL = "";
		packagesForLookup = new RefPackage[1];
		packagesForLookup[0] = refObject.refOutermostPackage();

		ClassTemplate classTemplate = (ClassTemplate) template;
		OclExpressionRegistration reg = (OclExpressionRegistration) connection
				.getOclRegistryService().getFreestyleRegistry()
				.getRegistration(refObject.get___Mri().toString());
		if (reg == null) {

			try {

				refObject.refOutermostPackage().getClass().getPackage();

				reg = connection.getOclRegistryService().getFreestyleRegistry()
						.createExpressionRegistration(
								refObject.get___Mri().toString(),
								classTemplate.getPartitionHandling().getName(),
								OclRegistrationSeverity.Warning,
								new String[] { "TCSPropertyQuery" },
								refObject.refClass(), packagesForLookup);
			} catch (JmiException e) {
				e.printStackTrace();
			} catch (OclManagerException e) {
				e.printStackTrace();
			}

		}

		try {
			evaluatedOCL = reg.evaluateExpression(refObject).toString();
		} catch (OclManagerException e) {
			e.printStackTrace();
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
			Template template, ModelPartition defaultPartition) {
		RefObject result = (RefObject) proxy.getRealObject();
		if (!proxy.isReferenceOnly()) {
			// assign to builded partition

			if (se instanceof Property) {
				Property seqElement = (Property) se;

				if ((TcsUtil.getPartitionHandlingParg(seqElement) != null)
						&& ((seqElement).getPropertyArgs() != null)) {
					// to lcheck

					if ((getMainPartitionContent().equalsIgnoreCase("all"))
							|| (getMainPartitionContent()
									.equalsIgnoreCase("model"))
							|| (TcsUtil.getPartitionHandlingParg(seqElement)
									.getPartitionhandling().getContent()
									.toString().equalsIgnoreCase("all"))
							|| (TcsUtil.getPartitionHandlingParg(seqElement)
									.getPartitionhandling().getContent()
									.toString().equalsIgnoreCase("model"))) {

						// the model element will be
						// stored just when content
						// equals all or model

						assignToPartition(defaultPartition, result, TcsUtil
								.getPartitionHandlingParg(seqElement)
								.getPartitionhandling());
					}
				}

			} else {

				if ((getMainPartitionContent().equalsIgnoreCase("all"))
						|| (getMainPartitionContent().equalsIgnoreCase("texblocks"))) {
					assignToPartition(defaultPartition, result, template);

				} else {

					assignToPartition(defaultPartition, result, template);
				}

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
				} else {

					mainPartition = connection
							.createPartition(concretSyntax_PRI);
					setMainPartition(mainPartition);
				}
			} else {
				SetInteractiveResult interactiveResult3 = interactivePartitionHandler
						.getPartitionFor(concreteSyntax.getPartitionHandling(),defaultPartition1,
								concreteSyntax, connection);
				
				if (interactiveResult3.getPri_Result()!= null) {
					if (connection.partitionExists(concretSyntax_PRI)) {
						mainPartition = connection.getPartition(concretSyntax_PRI);
						setMainPartition(mainPartition);

					} else {
						mainPartition = connection
								.createPartition(concretSyntax_PRI);
						setMainPartition(mainPartition);
					}
				}
			}
			mainPartitionContent = concreteSyntax.getPartitionHandling()
					.getContent().toString();
			setMainPartitionContent(mainPartitionContent);
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
			newPRI = connection.getSession().getMoin().createPri(
					defaultPartition2.getPri().getDataAreaDescriptor()
							.getFacilityId(),
					defaultPartition2.getPri().getDataAreaDescriptor()
							.getDataAreaName(),
					defaultPartition2.getPri().getContainerName(),
					evaluatedOCLForProperty(concrete_syntax, concrete_syntax
							.getPartitionHandling(), connection));

		}
		return newPRI;
	}

}
