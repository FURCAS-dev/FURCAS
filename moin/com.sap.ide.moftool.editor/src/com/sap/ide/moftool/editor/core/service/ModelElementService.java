package com.sap.ide.moftool.editor.core.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.commands.CreatePackageCommand;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.mi.fwk.IPartitionScopeProvider;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;

public abstract class ModelElementService {

	/**
	 * Checks a given name if it is a valid MOF element name. According to the MOF specification valid names consist of letters (lower or
	 * upper case), digits, the underscore (_) and spaces ( ). The first character of a name must be a letter. As a derivation to the
	 * specification we do not allow spaces to be part of the model element name.
	 * 
	 * @param name
	 *            The name to check
	 * @return The status for the check: <code>Status.OK_STATUS</code> if the name is ok, otherwise a status object with severity warning
	 *         or error and a message describing the reason.
	 */
	public static IStatus checkNewName(String name) {

		// Name must not be emty
		if (name == null || name.length() == 0) {
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.PLUGIN_SUBPROJECT, 0, LocalizationMessages.ModelElementService_0_XMSG, null);
		}

		// Check for invalid characters
		if (!name.matches("[A-Za-z0-9_]+")) { //$NON-NLS-1$
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.PLUGIN_SUBPROJECT, 0, LocalizationMessages.ModelElementService_1_XMSG,
					null);
		}

		// Check for first character (must be a letter)
		if (!name.matches("^[A-Za-z].*")) { //$NON-NLS-1$
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.PLUGIN_SUBPROJECT, 0, LocalizationMessages.ModelElementService_2_XMSG, null);
		}

		// Everything ok
		return Status.OK_STATUS;
	}

	/**
	 * Checks a given prefix name if it is a valid MOF element name. According to the MOF specification valid names consist of letters
	 * (lower or upper case), digits, the underscore (_), hyphen(-), period(.) and spaces ( ). The first character of a prefix must be a
	 * letter. As a derivation to the specification we do not allow spaces and hyphens to be part of the prefix name.
	 * 
	 * @param name
	 *            The prefix name to check
	 * @return The status for the check: <code>Status.OK_STATUS</code> if the name is ok, otherwise a status object with severity warning
	 *         or error and a message describing the reason.
	 */
	public static IStatus checkNewPrefixName(String name) {
		// prefix must not be empty (currently only the root package has a prefix)
		if (name == null || name.length() == 0) {
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.PLUGIN_SUBPROJECT, 0, LocalizationMessages.ModelElementService_3_XMSG, null);
		}

		// Check for invalid characters
		if (!name.matches("[A-Za-z0-9_.]+")) { //$NON-NLS-1$
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.PLUGIN_SUBPROJECT, 0,
					LocalizationMessages.ModelElementService_4_XMSG, null);
		}

		// Check for first character (must be a letter)
		if (!name.matches("^[A-Za-z].*")) { //$NON-NLS-1$
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.PLUGIN_SUBPROJECT, 0, LocalizationMessages.ModelElementService_5_XMSG, null);
		}

		// Everything ok
		return Status.OK_STATUS;
	}

	/**
	 * Checks if two objects belong to the same MOIN container (project).
	 * 
	 * @param first
	 *            The first object
	 * @param second
	 *            The second object
	 * @return <code>true</code> in case both objects belong to the same container, <code>false</code> otherwise.
	 */
	public static boolean isForeignObject(RefBaseObject first, RefBaseObject second) {
		CRI firstContainer = ModelAdapter.getInstance().getContainer(first);
		CRI secondContainer = ModelAdapter.getInstance().getContainer(second);
		if (firstContainer == null || secondContainer == null) {
			return (firstContainer != secondContainer);
		}
		if (firstContainer.equals(secondContainer)) {
			return false;
		}
		return true;
	}

	public static boolean isForeignObject(RefBaseObject obj) {
		IProject project = ModelAdapter.getInstance().getProject(obj);
		if (project == null) {
			// Object from archive or metamodel
			return true;
		}
		IProject connectionProject = ModelAdapter.getInstance().getProjectUsingConnection(obj);
		return !project.equals(connectionProject);
	}

	/**
	 * Checks if the second object passed is contained in any visible partition of the DC/container of the first passed object.
	 * 
	 * @param first
	 *            The first object
	 * @param second
	 *            The second object
	 * @return <code>true</code> in case the second object is visible, <code>false</code> otherwise.
	 */
	public static boolean isVisibleObject(RefBaseObject first, RefBaseObject second) {
		IPartitionScopeProvider provider = PartitionService.getInstance().getPartitionScopeProvider(
				ModelAdapter.getInstance().getConnection(first), PartitionScope.VISIBLE);
		Collection<PRI> partitions = provider.getPartitions();
		ModelPartition partition = ((Partitionable) second).get___Partition();
		if (partitions.contains(partition.getPri())) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the fully qualified name of a <code>ModelElement</code> as a string. The name consists of the package prefix of the outer
	 * containing package, followed by the names of the MOF package hierarchy, followed by the object's name
	 * 
	 * @param element
	 *            The ModelElement
	 * @return The fully qualified name of the ModelEdlement
	 */
	public static String getQualifiedName(ModelElement element) {
		String qualifiedName = element.getName();
		Namespace namespace = element.getContainer();
		if (namespace != null) {
			qualifiedName = getQualifiedName(namespace) + "." + qualifiedName; //$NON-NLS-1$
			return qualifiedName;
		}
		String prefix = ""; //$NON-NLS-1$
		if (element instanceof MofPackage) {
			MofPackage mofPackage = (MofPackage) element;
			Iterator<ModelElement> it = mofPackage.getContents().iterator();
			while (it.hasNext()) {
				ModelElement child = it.next();
				if (child instanceof Tag) {
					Tag tag = (Tag) child;
					if (CreatePackageCommand.PACKAGE_PREFIX.equals(tag.getTagId())
							|| CreatePackageCommand.OLD_PACKAGE_PREFIX.equals(tag.getTagId())) {
						List<String> values = tag.getValues();
						if (values.size() > 0) {
							prefix = values.get(0) + "."; //$NON-NLS-1$
						}
					}
				}
			}
		}
		qualifiedName = prefix + qualifiedName;
		return qualifiedName;
	}

	/**
	 * Checks if a given model element is available within a project in the Eclipse workspace. An element is available if there is an open
	 * project within the workspace.
	 * 
	 * @param modelElement
	 *            The model element to check for
	 * @return <code>true</code> if the element is available, <code>false</code> otherwise.
	 */
	public static boolean isAvailableInWorkspace(RefBaseObject modelElement) {
		boolean isAvailable = false;
		IProject project = ModelAdapter.getInstance().getProject(modelElement);
		if (project != null) {
			isAvailable = project.isAccessible();
		}

		return isAvailable;
	}
}
