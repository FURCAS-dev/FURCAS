package com.sap.ide.moftool.editor.exec;

import java.text.MessageFormat;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.BehavioralFeature;
import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.commands.CreateAssociationCommand;
import com.sap.ide.moftool.editor.core.commands.CreateAttributeCommand;
import com.sap.ide.moftool.editor.core.commands.CreateClassCommand;
import com.sap.ide.moftool.editor.core.commands.CreateConstantCommand;
import com.sap.ide.moftool.editor.core.commands.CreateConstraintCommand;
import com.sap.ide.moftool.editor.core.commands.CreateDiagramCommand;
import com.sap.ide.moftool.editor.core.commands.CreateEnumTypeCommand;
import com.sap.ide.moftool.editor.core.commands.CreateExceptionCommand;
import com.sap.ide.moftool.editor.core.commands.CreateImportCommand;
import com.sap.ide.moftool.editor.core.commands.CreateOperationCommand;
import com.sap.ide.moftool.editor.core.commands.CreatePackageCommand;
import com.sap.ide.moftool.editor.core.commands.CreateParameterCommand;
import com.sap.ide.moftool.editor.core.commands.CreateReferenceCommand;
import com.sap.ide.moftool.editor.core.commands.CreateStructureFieldCommand;
import com.sap.ide.moftool.editor.core.commands.CreateStructureTypeCommand;
import com.sap.ide.moftool.editor.core.commands.CreateTagCommand;
import com.sap.ide.moftool.editor.core.commands.DeleteAssociationCommand;
import com.sap.ide.moftool.editor.core.commands.DeleteClassCommand;
import com.sap.ide.moftool.editor.core.commands.DeleteDiagramCommand;
import com.sap.ide.moftool.editor.core.commands.DeleteModelElementCommand;
import com.sap.ide.moftool.editor.core.commands.DeletePackageCommand;
import com.sap.ide.moftool.editor.core.commands.InternalErrorException;
import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.commands.MoveParameterCommand;
import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.core.service.ReferenceService;
import com.sap.ide.moftool.editor.core.ui.wizards.CreateGeneralizableElementWizard;
import com.sap.ide.moftool.editor.core.ui.wizards.CreateGeneralizableElementWizardPage.ObjectTypeEnum;
import com.sap.ide.moftool.editor.sections.AssociationEndSelectionDialog;
import com.sap.ide.moftool.editor.sections.ImportsSelectionDialog;
import com.sap.ide.moftool.editor.tree.tcnf.NodeMofRoot;
import com.sap.ide.moftool.editor.tree.tumcnf.men.NodeUsedMMDCs;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.gfw.eclipse.platform.PlatformUtil;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;

public class ExecMOFToolDefaultImpl {

	public static final String NEW_ATTRIBUTE_NAME = "newAttribute"; //$NON-NLS-1$
	private static final String NEW_EXCEPTION_NAME = "newException"; //$NON-NLS-1$
	public static final String NEW_OPERATION_NAME = "newOperation"; //$NON-NLS-1$
	public static final String NEW_PARAMETER_NAME = "newParameter"; //$NON-NLS-1$
	private static final String NEW_TAG_NAME = "newTag"; //$NON-NLS-1$
	private static final String NEW_CONSTRAINT_NAME = "newConstraint"; //$NON-NLS-1$
	private static final String NEW_CONSTANT_NAME = "newConstant"; //$NON-NLS-1$
	public static final String NEW_STRUCTURE_FIELD_NAME = "newStructureField"; //$NON-NLS-1$

	private boolean askUserToDelete(RefObject objectToDelete) {
		String objectName = MofService.getName(objectToDelete);
		String deletionMessage = MessageFormat.format(LocalizationMessages.ExecMOFToolDefaultImpl_1_XMSG, objectName);
		boolean proceed = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getShell(),
				LocalizationMessages.ExecMOFToolDefaultImpl_0_XMSG, deletionMessage);
		return proceed;
	}

	public void execActionCreateAttribute(MofClass clazz) {
		// Create the name for the new attribute
		String name = NamespaceService.getValidNameForNewSubobject(clazz, NEW_ATTRIBUTE_NAME);

		// Create the new attribute
		CreateAttributeCommand command = new CreateAttributeCommand(name, clazz, MofService.getConnection(clazz));
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}
	}

	public void execActionCreateException(MofClass clazz) {
		// Create the name for the new exception
		String name = NamespaceService.getValidNameForNewSubobject(clazz, NEW_EXCEPTION_NAME);

		// Create the new exception
		CreateExceptionCommand command = new CreateExceptionCommand(name, clazz, MofService.getConnection(clazz));
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}
	}

	public void execActionCreateOperation(MofClass clazz) {

		// Create the name for the new operation
		String name = NamespaceService.getValidNameForNewSubobject(clazz, NEW_OPERATION_NAME);

		// Create the new operation
		CreateOperationCommand command = new CreateOperationCommand(name, clazz, MofService.getConnection(clazz));
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}
	}

	public void execActionCreateInParameter(BehavioralFeature parent) {
		createParameter(parent, DirectionKindEnum.IN_DIR);
	}

	private void createParameter(BehavioralFeature parent, DirectionKindEnum direction) {
		// Create the name for the new parameter
		String name = NamespaceService.getValidNameForNewSubobject(parent, NEW_PARAMETER_NAME);

		// Create the new parameter
		CreateParameterCommand command = new CreateParameterCommand(name, direction, parent, ModelAdapter.getInstance().getConnection(
				parent));
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}
	}

	public void execActionCreateOutParameter(BehavioralFeature parent) {
		createParameter(parent, DirectionKindEnum.OUT_DIR);
	}

	public void execActionCreateInOutParameter(BehavioralFeature parent) {
		createParameter(parent, DirectionKindEnum.INOUT_DIR);
	}

	public void execActionCreateAssociation(MofPackage inputObject) {
		// Get containing package
		MofPackage pack = (MofPackage) inputObject;
		// source class
		ModelElement modelElement = new AssociationEndSelectionDialog().openAddDialog(Display.getCurrent().getActiveShell(), MofService
				.getConnection(inputObject), pack);
		if (modelElement instanceof MofClass) {
			MofClass source = (MofClass) modelElement;
			// target class
			modelElement = new AssociationEndSelectionDialog().openAddDialog(Display.getCurrent().getActiveShell(), MofService
					.getConnection(inputObject), pack);
			if (modelElement instanceof MofClass) {
				MofClass target = (MofClass) modelElement;
				MofClass containingClass = ReferenceService.getContainingClassForAssociationEndReference(source);

				String name = AssociationService.createNewAssociationName(source, target);
				CreateAssociationCommand command = new CreateAssociationCommand(name, pack, source, target, containingClass,
						AggregationKindEnum.NONE, MofService.getConnection(inputObject));
				try {
					command.execute();
				} catch (ExecutionCancelledException e) {
					return;
				}
			}
		}
	}

	public void execActionCreateClass(MofPackage context) {
		Connection connection = ModelAdapter.getInstance().getConnection(context);

		// Ask for name of new class
		String className = null;
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		// Start Creation Wizard
		Namespace namespace = null;
		CreateGeneralizableElementWizard wizard = new CreateGeneralizableElementWizard(connection, context,
				LocalizationMessages.ExecMOFToolDefaultImpl_3_XGRP, LocalizationMessages.ExecMOFToolDefaultImpl_4_XGRP,
				LocalizationMessages.ExecMOFToolDefaultImpl_5_XMSG, LocalizationMessages.ExecMOFToolDefaultImpl_6_XFLD, true, false,
				ObjectTypeEnum.Class);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		if (dialog.open() != Window.OK) {
			return;
		}
		className = wizard.getElementName();
		namespace = wizard.getMofContainer();

		if (className == null) {
			// TODO: error
			return;
		}

		if (!(namespace instanceof MofPackage)) {
			// TODO: error
			return;
		}

		// Create the new class
		CreateClassCommand command = new CreateClassCommand(className, (MofPackage) namespace, connection);
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}

		// Save changes
		IProject project = ModelAdapter.getInstance().getProject(context);
		ModelManagerUI.getConnectionManagerUI().save(connection, project, null);

		// Open editor
		try {
			ModelManagerUI.getEditorManager().openEditor(command.getMofClass());
		} catch (PartInitException e) {
			throw new InternalErrorException(e);
		}
	}

	public void execActionCreateDiagramForPackage(MofPackage context) {
		Connection connection = ModelAdapter.getInstance().getConnection(context);
		IProject project = ModelAdapterUI.getInstance().getProject(connection);

		// Ask for name of new diagram
		String diagramName = null;
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		// Start Creation Wizard
		Namespace namespace = null;
		CreateGeneralizableElementWizard wizard = new CreateGeneralizableElementWizard(connection, context,
				LocalizationMessages.ExecMOFToolDefaultImpl_7_XGRP, LocalizationMessages.ExecMOFToolDefaultImpl_8_XGRP,
				LocalizationMessages.ExecMOFToolDefaultImpl_9_XMSG, LocalizationMessages.ExecMOFToolDefaultImpl_10_XFLD, true, false,
				ObjectTypeEnum.Diagram);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		if (dialog.open() != Window.OK) {
			return;
		}
		diagramName = wizard.getElementName();
		namespace = wizard.getMofContainer();
		if (diagramName == null) {
			return;
		}
		if (!(namespace instanceof MofPackage)) {
			// TODO: error
			return;
		}

		// Create non-root diagram
		CreateDiagramCommand command = new CreateDiagramCommand(diagramName, MOFToolConstants.CLASS_DIAGRAM_TYPE_ID,
				(MofPackage) namespace, connection);
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}

		// Save changes
		ModelManagerUI.getConnectionManagerUI().save(connection, project, null);

		// Open editor
		PlatformUtil.openDiagramEditor(command.getDiagram());
	}

	public void execActionCreatePackageForPackage(MofPackage context) {
		Connection connection = ModelAdapter.getInstance().getConnection(context);
		IProject project = ModelAdapterUI.getInstance().getProject(connection);

		// Ask for name of new package
		String packageName = null;
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		// Start Creation Wizard
		Namespace namespace = null;
		CreateGeneralizableElementWizard wizard = new CreateGeneralizableElementWizard(connection, context,
				LocalizationMessages.ExecMOFToolDefaultImpl_11_XGRP, LocalizationMessages.ExecMOFToolDefaultImpl_12_XGRP,
				LocalizationMessages.ExecMOFToolDefaultImpl_13_XMSG, LocalizationMessages.ExecMOFToolDefaultImpl_14_XFLD, true, false,
				ObjectTypeEnum.Package);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		if (dialog.open() != Window.OK) {
			return;
		}
		packageName = wizard.getElementName();
		namespace = wizard.getMofContainer();

		if (packageName == null) {
			return;
		}
		if (!(namespace instanceof MofPackage)) {
			// TODO: error
			return;
		}
		// Create non-root package
		CreatePackageCommand command = new CreatePackageCommand(packageName, (MofPackage) namespace, connection);

		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}

		// Save changes
		ModelManagerUI.getConnectionManagerUI().save(connection, project, null);

		// Open editor
		try {
			ModelManagerUI.getEditorManager().openEditor(command.getPackage());
		} catch (PartInitException e) {
			throw new InternalErrorException(e);
		}
	}

	public void execActionCreatePackageForRoot(Connection connection) {
		IProject project = ModelAdapterUI.getInstance().getProject(connection);

		// Ask for name of new package
		String packageName = null;
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		// Start Creation Wizard
		CreateGeneralizableElementWizard wizard = new CreateGeneralizableElementWizard(connection, null,
				LocalizationMessages.ExecMOFToolDefaultImpl_15_XGRP, LocalizationMessages.ExecMOFToolDefaultImpl_16_XGRP,
				LocalizationMessages.ExecMOFToolDefaultImpl_17_XMSG, LocalizationMessages.ExecMOFToolDefaultImpl_18_XFLD, false, true,
				ObjectTypeEnum.Package);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		if (dialog.open() != Window.OK) {
			return;
		}
		packageName = wizard.getElementName();
		if (packageName == null) {
			return;
		}
		String packagePrefix = wizard.getPrefix();
		String partitionName = wizard.getPartitionName();
		// Create root package and set prefix
		CreatePackageCommand command = new CreatePackageCommand(packageName, partitionName, project, connection);
		if (packagePrefix != null) {
			command.setPackagePrefix(packagePrefix);
		}

		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}

		// Save changes
		ModelManagerUI.getConnectionManagerUI().save(connection, project, null);

		// Open editor
		try {
			ModelManagerUI.getEditorManager().openEditor(command.getPackage());
		} catch (PartInitException e) {
			throw new InternalErrorException(e);
		}
	}

	public void execActionCreateEnumerationTypeForPackage(MofPackage context) {
		execActionCreateEnumerationType(context, false);
	}

	public void execActionCreateEnumerationTypeForClass(MofClass context) {
		execActionCreateEnumerationType(context, false);
	}

	private void execActionCreateEnumerationType(Namespace context, boolean fromEditor) {
		Connection connection = ModelAdapter.getInstance().getConnection(context);

		// Ask for name of new enumeration type
		String enumName = null;
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		// Start Creation Wizard
		Namespace namespace = null;
		CreateGeneralizableElementWizard wizard = new CreateGeneralizableElementWizard(connection, context,
				LocalizationMessages.ExecMOFToolDefaultImpl_19_XGRP, LocalizationMessages.ExecMOFToolDefaultImpl_20_XGRP,
				LocalizationMessages.ExecMOFToolDefaultImpl_21_XMSG, LocalizationMessages.ExecMOFToolDefaultImpl_22_XFLD, true, false,
				ObjectTypeEnum.EnumerationType);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		if (dialog.open() != Window.OK) {
			return;
		}
		enumName = wizard.getElementName();
		namespace = wizard.getMofContainer();
		if (enumName == null) {
			return;
		}
		if (namespace == null) {
			// TODO: error
			return;
		}

		// Create the new enumeration type
		CreateEnumTypeCommand command = new CreateEnumTypeCommand(enumName, namespace, connection);
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}

		if (!fromEditor) {
			// Save changes
			IProject project = ModelAdapter.getInstance().getProject(context);
			ModelManagerUI.getConnectionManagerUI().save(connection, project, null);

			// Open editor
			try {
				ModelManagerUI.getEditorManager().openEditor(command.getEnumType());
			} catch (PartInitException e) {
				throw new InternalErrorException(e);
			}
		}
	}

	public void execActionCreateImport(MofPackage pack) {
		// Ask user for package/class to import
		RefObject inpObject = MofService.getRefObject(pack);
		ModelElement modelElement = new ImportsSelectionDialog().openAddDialog(Display.getCurrent().getActiveShell(), MofService
				.getConnection(pack), pack);

		// // <!-- C-45: ImportedNamespaceMustBeVisible (not to be checked -
		// disabled by MOIN) -->
		// // <!-- TODO: C-48: CannotImportNestedComponents -->
		// // <!-- C-47: CannotImportSelf -->
		// // <!-- C-46: CanOnlyImportPackagesAndClasses -->
		if (modelElement instanceof MofPackage || modelElement instanceof MofClass) {
			Namespace namespace = (Namespace) modelElement;
			CreateImportCommand command = new CreateImportCommand(pack, namespace, MofService.getConnection(pack));
			try {
				command.execute();
			} catch (ExecutionCancelledException e) {
				return;
			}
		}
	}

	public void execActionCreateConstraint(Namespace parent) {

		// Create the name for the new constraint
		String name = NamespaceService.getValidNameForNewSubobject(parent, NEW_CONSTRAINT_NAME);

		CreateConstraintCommand command = new CreateConstraintCommand(parent, name, MofService.getConnection(parent));
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}
	}

	public void execActionCreateTag(Namespace parent) {
		// Create the name for the new tag
		String name = NamespaceService.getValidNameForNewSubobject(parent, NEW_TAG_NAME);

		CreateTagCommand command = new CreateTagCommand(parent, name, MofService.getConnection(parent));
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}
	}

	public void execActionCreateTagForNamespace(Namespace parent) {
		// Create the name for the new tag
		String name = NamespaceService.getValidNameForNewSubobject(parent, NEW_TAG_NAME);

		CreateTagCommand command = new CreateTagCommand(parent, name, MofService.getConnection(parent));
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}
	}

	public void execActionCreateConstant(Namespace parent) {
		// Create the name for the new constant
		String name = NamespaceService.getValidNameForNewSubobject(parent, NEW_CONSTANT_NAME);

		CreateConstantCommand command = new CreateConstantCommand(parent, name, MofService.getConnection(parent));
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}
	}

	public void execActionMoveParameterDown(Parameter parameter) {
		MoveParameterCommand command = new MoveParameterCommand(parameter, MoveParameterCommand.DIR_DOWN, ModelAdapter.getInstance()
				.getConnection(parameter));
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}
	}

	public void execActionMoveParameterUp(Parameter parameter) {
		MoveParameterCommand command = new MoveParameterCommand(parameter, MoveParameterCommand.DIR_UP, ModelAdapter.getInstance()
				.getConnection(parameter));
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}
	}

	public void execActionCreateStructureField(StructureType type) {
		// Create the name for the new structure field
		String name = NamespaceService.getValidNameForNewSubobject(type, NEW_STRUCTURE_FIELD_NAME);

		// Create the new structure field
		CreateStructureFieldCommand command = new CreateStructureFieldCommand(name, type, MofService.getConnection(type));
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}
	}

	public void execActionCreateStructureTypeForPackage(MofPackage context) {
		execActionCreateStructureType(context, false);
	}

	public void execActionCreateStructureTypeForClass(MofClass context) {
		execActionCreateStructureType(context, false);
	}

	private void execActionCreateStructureType(Namespace context, boolean fromEditor) {
		Connection connection = ModelAdapter.getInstance().getConnection(context);

		// Ask for name of new structure type
		String structureName = null;
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		// Start Creation Wizard
		Namespace namespace = null;
		CreateGeneralizableElementWizard wizard = new CreateGeneralizableElementWizard(connection, context,
				LocalizationMessages.ExecMOFToolDefaultImpl_23_XGRP, LocalizationMessages.ExecMOFToolDefaultImpl_24_XGRP,
				LocalizationMessages.ExecMOFToolDefaultImpl_25_XMSG, LocalizationMessages.ExecMOFToolDefaultImpl_26_XFLD, true, false,
				ObjectTypeEnum.StructureType);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		if (dialog.open() != Window.OK) {
			return;
		}
		structureName = wizard.getElementName();
		namespace = wizard.getMofContainer();
		if (structureName == null) {
			return;
		}
		if (namespace == null) {
			// TODO: error
			return;
		}
		// Create the new structure type
		CreateStructureTypeCommand command = new CreateStructureTypeCommand(structureName, namespace, connection);
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}

		if (!fromEditor) {
			// Save changes
			IProject project = ModelAdapter.getInstance().getProject(context);
			ModelManagerUI.getConnectionManagerUI().save(connection, project, null);

			// Open editor
			try {
				ModelManagerUI.getEditorManager().openEditor(command.getStructureType());
			} catch (PartInitException e) {
				throw new InternalErrorException(e);
			}
		}
	}

	public void execActionDeleteForCommonNavigator(RefObject context) {
		execActionDeleteModelelement(context);
		// Save changes
		ModelManagerUI.getConnectionManagerUI().save(ModelAdapter.getInstance().getConnection(context),
				ModelAdapterUI.getInstance().getProject(context), null);
	}

	public void execActionDeleteModelelement(RefObject context) {

		if (!askUserToDelete(context)) {
			return;
		}

		Connection connection = ModelAdapter.getInstance().getConnection(context);
		Command command;
		if (context instanceof Association) {
			command = new DeleteAssociationCommand((Association) context, connection);
		} else if (context instanceof Diagram) {
			command = new DeleteDiagramCommand(((Diagram) context), connection);
		} else if (context instanceof MofPackage) {
			command = new DeletePackageCommand(((MofPackage) context), connection);
		} else if (context instanceof MofClass) {
			command = new DeleteClassCommand(((MofClass) context), connection);
		} else if (context instanceof DataType) {
			command = new DeleteModelElementCommand(((DataType) context), connection);
		} else {
			command = new DeleteModelElementCommand(context, connection);
		}
		if (!command.canExecute()) {
			throw new InternalErrorException("Cannot execute delete command"); //$NON-NLS-1$
		}
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}
	}

	public void execActionCreateReferenceForAssociationEnd(AssociationEnd refObject) {
		MofClass mofClass = (MofClass) (refObject).otherEnd().getType();
		// Always (that's the true parameter) ask the user for the class that
		// shall
		// contain the new reference
		MofClass containingClass = ReferenceService.getContainingClassForAssociationEndReference(mofClass, true);

		if (containingClass != null) {
			CreateReferenceCommand command = new CreateReferenceCommand(refObject.otherEnd(), refObject, containingClass, ModelAdapter
					.getInstance().getConnection(refObject));
			command.doExecute();
		}
	}

	public void execActionCreateConstraintForAssociation(Association parent) {
		// Create the name for the new constraint
		String name = NamespaceService.getValidNameForNewSubobject(parent, NEW_CONSTRAINT_NAME);

		CreateConstraintCommand command = new CreateConstraintCommand(parent, name, MofService.getConnection(parent));
		try {
			command.execute();
		} catch (ExecutionCancelledException e) {
			return;
		}
	}

	public void execActionCreateEnumerationTypeForClassEditor(MofClass mofClass) {
		execActionCreateEnumerationType(mofClass, true);
	}

	public void execActionCreateStructureTypeForClassEditor(MofClass mofClass) {
		execActionCreateStructureType(mofClass, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.sap.ide.moftool.editor.exec.ExecMOFToolDefault#
	 * execActionNavigateToProject(com.sap.tc.moin.repository.mmi.model.MofPackage)
	 */

	public void execActionNavigateToProject(IWorkbenchPart part, Connection conn) {
		if (part instanceof CommonNavigator) {
			CommonNavigator navigator = (CommonNavigator) part;
			ISelection selection = navigator.getCommonViewer().getSelection();
			if (selection instanceof TreeSelection) {
				TreeSelection treeSelection = (TreeSelection) selection;
				Object object = treeSelection.getFirstElement();
				if (object instanceof NodeUsedMMDCs) {
					NodeUsedMMDCs nodeUsedMMDC = (NodeUsedMMDCs) object;
					IProject project = nodeUsedMMDC.getProjectToNavigateTo();
					if (project != null && project.isAccessible()) {
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getSite()
								.getSelectionProvider().setSelection(new StructuredSelection(new NodeMofRoot(project)));
					}
				}
			}

		}
	}
}
