package com.sap.ide.moftool.editor.core.service;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.moin.friends.MetaModelChecker;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.NameViolation;

public abstract class NamespaceService {

	/**
	 * Validates the name that was provided for an existing subobject of a MOF namespace object: - The name for the object is checked if it
	 * is a valid MOF model element name - The namespace must not already contain an element with the same name. ([C-5])
	 * 
	 * @param object
	 *            The object to be validated
	 * @param description
	 *            The default text of the return status (in case there is no error)
	 * @return The status for the check: <code>Status.OK_STATUS</code> if the namespace may contain an additional object with the given
	 *         name, otherwise a status object with severity warning or error and a message describing the reason.
	 */
	public static IStatus validate(RefBaseObject object, String description) {
		Namespace namespace = null;
		NameViolation nv = null;
		IStatus okstatus = new Status(IStatus.OK, MOFToolEditorPlugin.ID, description);
		if (object == null) {
			return okstatus;
		}
		Connection conn = ModelAdapter.getInstance().getConnection(object);
		if (conn == null) {
			return okstatus;
		}
		// JmiHelper helper = conn.getJmiHelper();
		// if (helper == null) {
		MetaModelChecker checker = UtilitiesFactory.getMetaModelChecker();
		if (checker == null) {
			return okstatus;
		}
		if (!(object instanceof ModelElement)) {
			return okstatus;
		} else {
			namespace = ((ModelElement) object).getContainer();
		}
		if (namespace == null) {
			// call root package validation if possible
			if (object instanceof MofPackage) {
				MofPackage mofPackage = (MofPackage) object;
				CRI containerCri = ModelAdapter.getInstance().getContainer(conn);
				if (containerCri != null) {
					nv = checker.checkToplevelPackageName(conn, containerCri, mofPackage);
				} else {
					return okstatus;
				}
			} else {
				return okstatus;
			}
		} else {
			// MOIN name validation
			// NameViolation nv = helper.checkModelElementName(namespace, ((ModelElement)object));
			nv = checker.checkModelElementName(conn, namespace, ((ModelElement) object));
		}
		if (nv != null) {
			String msg = nv.getDescription();
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID, msg);
		} else {
			// additional name restriction within MOF Editor
			IStatus status = ModelElementService.checkNewName(((ModelElement) object).getName());
			if (status.getSeverity() == IStatus.ERROR) {
				return status;
			}
		}
		return okstatus;

		// String msg = null;
		// if (object instanceof ModelElement) {
		// IStatus mystatus = NamespaceService.checkSubobject(((ModelElement)object).getContainer(), ((ModelElement)object));
		// if (mystatus.getSeverity() == IStatus.ERROR) {
		// msg = mystatus.getMessage();
		// }
		// if (msg != null) {
		// return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID, msg);
		//						
		// }
		// }
		// return new Status(IStatus.OK, MOFToolEditorPlugin.ID,
		// description);

	}

	/**
	 * Checks the name that was provided for a new subobject of a MOF namespace object: - The name for the new object is checked if it is a
	 * valid MOF model element name - The namespace must not already contain an element with the same name. ([C-5])
	 * 
	 * @param namespace
	 *            The namespace object that shall contain the new element
	 * @param newObjectName
	 *            The name for the new element
	 * @return The status for the check: <code>Status.OK_STATUS</code> if the namespace may contain an additional object with the given
	 *         name, otherwise a status object with severity warning or error and a message describing the reason.
	 */
	public static IStatus checkForNewSubobject(Namespace namespace, String newObjectName) {

		if (namespace == null) {
			return Status.OK_STATUS;
		}
		Connection conn = ModelAdapter.getInstance().getConnection(namespace);
		if (conn == null) {
			return Status.OK_STATUS;
		}
		// JmiHelper helper = conn.getJmiHelper();
		// if (helper == null) {
		MetaModelChecker checker = UtilitiesFactory.getMetaModelChecker();
		if (checker == null) {
			return Status.OK_STATUS;
		}
		// MOIN name validation
		// NameViolation nv = helper.checkModelElementName(namespace, newObjectName, null);
		NameViolation nv = checker.checkModelElementName(conn, namespace, newObjectName);
		if (nv != null) {
			String msg = nv.getDescription();
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID, msg);
		} else {
			// additional name restriction within MOF Editor
			IStatus status = ModelElementService.checkNewName(newObjectName);
			if (status.getSeverity() == IStatus.ERROR) {
				return status;
			}
		}
		return Status.OK_STATUS;

		/*
		 * MultiStatus multiStatus = new MultiStatus(MOFToolEditorPlugin.PLUGIN_SUBPROJECT, 0, "Check for new subobject", null);
		 * 
		 * // Check for valid object name { IStatus status = ModelElementService.checkNewName(newObjectName); if (status.getSeverity() ==
		 * IStatus.ERROR) { return status; } else if (status.getSeverity() == IStatus.WARNING) { multiStatus.add(status); } }
		 * 
		 * // [C-5]: The names of the contents of a Namespace must not collide List<ModelElement> list = namespace.getContents(); for
		 * (ModelElement element : list) { if (newObjectName.equalsIgnoreCase(element.getName())) { String error =
		 * ModelElementService.getMetaObjectName(namespace) + " ''" + namespace.getName() + "'' already contains an object with the name ''"
		 * + element.getName() + "'' (of type " + ModelElementService.getMetaObjectName(element) + ")"; return new Status(IStatus.ERROR,
		 * MOFToolEditorPlugin.PLUGIN_SUBPROJECT, 0, error, null); } }
		 * 
		 * if (multiStatus.getChildren().length != 0) { // Warnings exist return multiStatus; } else { // Everything ok return
		 * Status.OK_STATUS; }
		 */

	}

	/**
	 * Same as @see {@link NamespaceService#checkForNewSubobject(Namespace, String)} augmented by the {@link ModelElement}. This was
	 * necessary since the MOIN name checker {@link MetaModelChecker#checkModelElementName(Connection, Namespace, ModelElement)} needs the
	 * {@link ModelElement}; see CSN 0120031469 0003581172 2008.
	 */
	public static IStatus checkForNewSubobject(Namespace namespace, String newObjectName, ModelElement modelElement) {

		if (namespace == null) {
			return Status.OK_STATUS;
		}
		Connection conn = ModelAdapter.getInstance().getConnection(namespace);
		if (conn == null) {
			return Status.OK_STATUS;
		}
		// JmiHelper helper = conn.getJmiHelper();
		// if (helper == null) {
		MetaModelChecker checker = UtilitiesFactory.getMetaModelChecker();
		if (checker == null) {
			return Status.OK_STATUS;
		}
		// MOIN name validation
		// NameViolation nv = helper.checkModelElementName(namespace, newObjectName, null);
		NameViolation nv = checker.checkModelElementName(conn, namespace, modelElement);
		if (nv != null) {
			String msg = nv.getDescription();
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID, msg);
		} else {
			// additional name restriction within MOF Editor
			IStatus status = ModelElementService.checkNewName(newObjectName);
			if (status.getSeverity() == IStatus.ERROR) {
				return status;
			}
		}
		return Status.OK_STATUS;

		/*
		 * MultiStatus multiStatus = new MultiStatus(MOFToolEditorPlugin.PLUGIN_SUBPROJECT, 0, "Check for new subobject", null);
		 * 
		 * // Check for valid object name { IStatus status = ModelElementService.checkNewName(newObjectName); if (status.getSeverity() ==
		 * IStatus.ERROR) { return status; } else if (status.getSeverity() == IStatus.WARNING) { multiStatus.add(status); } }
		 * 
		 * // [C-5]: The names of the contents of a Namespace must not collide List<ModelElement> list = namespace.getContents(); for
		 * (ModelElement element : list) { if (newObjectName.equalsIgnoreCase(element.getName())) { String error =
		 * ModelElementService.getMetaObjectName(namespace) + " ''" + namespace.getName() + "'' already contains an object with the name ''"
		 * + element.getName() + "'' (of type " + ModelElementService.getMetaObjectName(element) + ")"; return new Status(IStatus.ERROR,
		 * MOFToolEditorPlugin.PLUGIN_SUBPROJECT, 0, error, null); } }
		 * 
		 * if (multiStatus.getChildren().length != 0) { // Warnings exist return multiStatus; } else { // Everything ok return
		 * Status.OK_STATUS; }
		 */

	}

	public static IStatus checkForNewToplevelPackage(Connection con, String packageName, String prefixName) {
		NameViolation nv = null;
		if (con == null) {
			return Status.OK_STATUS;
		}
		CRI containerCri = ModelAdapter.getInstance().getContainer(con);
		if (containerCri == null) {
			return Status.OK_STATUS;
		}
		MetaModelChecker checker = UtilitiesFactory.getMetaModelChecker();
		if (checker == null) {
			return Status.OK_STATUS;
		}
		nv = checker.checkToplevelPackageName(con, containerCri, packageName, prefixName);
		if (nv != null) {
			String msg = nv.getDescription();
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID, msg);
		} else {
			// additional name restriction within MOF Editor
			IStatus status = ModelElementService.checkNewName(packageName);
			if (status.getSeverity() == IStatus.ERROR) {
				return status;
			}
		}
		return Status.OK_STATUS;
	}

	/**
	 * Constructs a valid name for a new subobject of the given namespace. The given base name is taken and extended by a running number as
	 * long as an object with the contructed name exists. This method will construct the name <baseName><nr> where nr is the lowest integer
	 * (starting with 1) for which an object with that name does+ not yet exists within the given namespace.
	 * 
	 * @param container
	 *            The containing object
	 * @param baseName
	 *            The base name to use
	 * @return A valid name for a new subobject
	 */
	public static String getValidNameForNewSubobject(Namespace container, String baseName) {
		int index = 0;
		String name = baseName;
		while (!NamespaceService.checkForNewSubobject(container, name).isOK()) {
			index = index + 1;
			if (index == 100) {
				return null;
			}
			name = baseName + index;
		}
		return name;
	}
}
