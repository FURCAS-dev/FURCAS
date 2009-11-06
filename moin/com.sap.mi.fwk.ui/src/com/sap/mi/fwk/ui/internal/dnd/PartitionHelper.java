package com.sap.mi.fwk.ui.internal.dnd;

import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Utility to do the partition assignment while pasting
 * 
 * @author d031150
 */
public final class PartitionHelper {

	private static final String PREFIX_COPY_OF = "CopyOf_"; //$NON-NLS-1$
	// Attached to controls that are referenced by UI test
	private static final String WIDGET_DATA_NAME = "name"; //$NON-NLS-1$

	/**
	 * Finds or creates a partition for the given element according to the
	 * partition scheme of a template element. Until a partion alignment concept
	 * is available the current approach is heuristic as follows:
	 * 
	 * <ul>
	 * <li>A partition with the same name and path is resolved in the element's
	 * project. If there is no such partition, it is created and returned.</li>
	 * <li>If an existing partition has the same "name" as the element, a
	 * conflict is assumed that needs to be resolved by renaming the element.
	 * This is done by raising a UI, or in case the <code>shell</code>
	 * parameter is <code>null</code>, prepending a <code>CopyOf_</code>
	 * prefix until a non-conflicting PRI is available. Such a partition is
	 * created and returned.</li>
	 * <li>If an existing partition has a different name than the element, a
	 * partition with the element's name is searched for and created if
	 * necessary. If the element does not have a human-readable name, a static
	 * partition name will be used.</li>
	 * <li>Hack: the Mof tooling's global partition is detected if it exists
	 * and just returned.</li>
	 * </ul>
	 * 
	 * @param element
	 *            the element to create the partition for. It is <em>not</em>
	 *            assigned.
	 * @param template
	 *            the element acting as a template for the new partition
	 * @param shell
	 *            a shell for raising some UI to the use (e.g. to query a new
	 *            name for the element/partition). If <code>null</code>, then
	 *            no UI is shown, but the element is renamed with a
	 *            <code>CopyOf_</code> prefix.
	 * @return <code>null</code> in case of a user cancellation or the new
	 *         partition
	 */
	public static ModelPartition findOrCreatePartitionFor(RefObject element, RefObject template, Shell shell) {
		ModelManager modelMgr = ModelManager.getInstance();
		PartitionService partService = PartitionService.getInstance();
		IProject targetProject = ModelAdapterUI.getInstance().getProject(element);
		Connection connection = ((Partitionable) element).get___Connection();

		// create a PRI analogous to the template's partition
		ModelPartition templPart = ((Partitionable) template).get___Partition();
		final PRI templPri = templPart.getPri();
		IPath templPartPath = new Path(templPri.getPartitionName());
		PRI targetPriNew = partService.getPRI(targetProject, templPartPath);

		// check if it exists
		ModelPartition targetPartNew = connection.getPartition(targetPriNew);
		if (targetPartNew != null) { // conflict -> resolve
			if (element instanceof ModelElement) {
				// TODO [CopyPaste] Hack for MOF tool: use global partition
				return targetPartNew;
			}

			Entry<Attribute, String> keyAttrAndValue = modelMgr.getObjectNameAttribute(template);
			Attribute keyAttr = null;
			String keyAttrValue = null;
			if (keyAttrAndValue != null) {
				keyAttr = keyAttrAndValue.getKey();
				keyAttrValue = keyAttrAndValue.getValue();
			}

			boolean isLeadingElement = keyAttr != null
					&& templPartPath.removeFileExtension().lastSegment().equalsIgnoreCase(keyAttrValue);
			if (isLeadingElement) {
				if (shell != null) { // UI for renaming
					PartitionInputDialog dialog = new PartitionInputDialog(shell, connection, targetProject, keyAttr
							.getName(), PREFIX_COPY_OF + keyAttrValue, templPri);
					if (dialog.open() != Window.OK)
						return null;
					keyAttrValue = dialog.getValue();
					targetPriNew = dialog.getPri();
				} else { // headless
					do {
						keyAttrValue = PREFIX_COPY_OF + keyAttrValue;
						templPartPath = new Path(templPri.getPartitionName());
						String fileExt = templPartPath.getFileExtension();
						templPartPath = templPartPath.removeLastSegments(1).append(keyAttrValue).addFileExtension(
								fileExt);
						targetPriNew = partService.getPRI(targetProject, templPartPath);
						targetPartNew = connection.getPartition(targetPriNew);
					} while (targetPartNew != null);
				}
				// set the new name on the element
				JmiHelper jmiHelper = connection.getJmiHelper();
				Attribute attr = jmiHelper.getAttributeByName((MofClass) element.refMetaObject(), keyAttr.getName(),
						true);
				element.refSetValue(attr, keyAttrValue);
				// create partition
				targetPartNew = connection.createPartition(targetPriNew);
				return targetPartNew;
			} else { // element's name does not match partition name
				// no name available -> use a static fallback
				if (keyAttrValue == null)
					keyAttrValue = "GenericContainer"; //$NON-NLS-1$
				// find or create a partition with this name
				templPartPath = new Path(templPri.getPartitionName());
				String fileExt = templPartPath.getFileExtension();
				templPartPath = templPartPath.removeLastSegments(1).append(keyAttrValue).addFileExtension(fileExt);
				targetPriNew = partService.getPRI(targetProject, templPartPath);
				targetPartNew = connection.getPartition(targetPriNew);
				if (targetPartNew == null)
					targetPartNew = connection.createPartition(targetPriNew);
				return targetPartNew;
			}
		} else { // no conflict
			// create partition
			targetPartNew = connection.createPartition(targetPriNew);
			return targetPartNew;
		}
	}

	private static final class PartitionInputDialog extends InputDialog {
		private PartitionInputDialog(Shell shell, Connection connection, IProject project, String keyAttributeName,
				String currentValue, PRI templPri) {
			super(shell, MiFwkUiMessages.Clipboard_conflictingPartitionDialog_title, MiFwkUiMessages.bind(
					MiFwkUiMessages.Clipboard_conflictingPartitionDialog_msg, keyAttributeName), currentValue,
					new InputValidator(templPri, connection, project));
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}

		PRI getPri() {
			return ((InputValidator) getValidator()).getPRI();
		}

		@Override
		protected void configureShell(Shell shell) {
			super.configureShell(shell);
			shell.setData(WIDGET_DATA_NAME, PartitionInputDialog.class.getSimpleName());
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Control control = super.createDialogArea(parent);
			getText().setData(WIDGET_DATA_NAME, "Input"); //$NON-NLS-1$
			return control;
		}

		private static final class InputValidator implements IInputValidator {
			private final PRI mTemplPri;
			private final Connection mConnection;
			private final IProject mProject;
			private PRI mNewPri;

			InputValidator(PRI templPri, final Connection connection, final IProject project) {
				mTemplPri = templPri;
				mConnection = connection;
				mProject = project;
			}

			PRI getPRI() {
				return mNewPri;
			}

			public String isValid(String newText) {
				if (newText != null && newText.length() == 0)
					return null;
				IPath path = new Path(mTemplPri.getPartitionName());
				String fileExt = path.getFileExtension();
				path = path.removeLastSegments(1).append(newText).addFileExtension(fileExt);
				try {
					PRI targetPriNew = PartitionService.getInstance().getPRI(mProject, path);
					if (mConnection.partitionExists(targetPriNew)) {
						return MiFwkUiMessages.bind(
								MiFwkUiMessages.Clipboard_conflictingPartitionDialog_conflict_error, targetPriNew
										.getPartitionName());
					}
					mNewPri = targetPriNew;
				} catch (RuntimeException e) { // $JL-EXC$
					String msg = e.getLocalizedMessage();
					if (msg == null)
						msg = e.getMessage();
					if (msg == null) { // exception without message
						msg = MiFwkUiMessages.bind(
								MiFwkUiMessages.Clipboard_conflictingPartitionDialog_conflictInvalidPath_error, path);
					}
					return msg;
				}
				return null;
			}
		}
	}

}
