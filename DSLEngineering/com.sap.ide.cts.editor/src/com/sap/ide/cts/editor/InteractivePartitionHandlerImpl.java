package com.sap.ide.cts.editor;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

import tcs.PartitionHandling;

import com.sap.ide.cts.parser.incremental.InteractivePartitionHandler;
import com.sap.ide.cts.parser.incremental.SetInteractiveResult;
import com.sap.mi.fwk.ModelManager;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/*
 * return a PRI of the Partition after interacting with the user
 */
public class InteractivePartitionHandlerImpl extends Dialog implements
		InteractivePartitionHandler {

	private Object object;
	private IProject project;
	private PRI targetPRI;
	private static String response;
	Shell shell;

	public InteractivePartitionHandlerImpl(Shell shell2) {
		super(Display.getCurrent().getActiveShell());
		shell = shell2;
	}

	/*
	 * return a PRI of the Partition after interacting with the user
	 */

	@Override
	public SetInteractiveResult getPartitionFor(PartitionHandling ph,
			ModelPartition partition, RefObject newElement,
			Connection connection) {

		MessageBox messageBox2 = new MessageBox(shell, SWT.OK | SWT.CANCEL
				| SWT.ICON_WARNING);
		messageBox2.setText("MANUAL PARTITION?");
		messageBox2.setMessage("Do you want a manual partition?");

		if (messageBox2.open() == SWT.OK) {

			project = ModelManager.getModelAdapter().getProject(
					partition.getPri().getCri());
			object = getIndividualResourcesToExport(project);

			IPath path = new Path("src/".concat(object.toString()));
			targetPRI = ModelManager.getPartitionService()
					.getPRI(project, path);

			return new SetInteractiveResult(targetPRI,
					getDialogResult(new Shell(Display.getCurrent().getActiveShell().getShell(), Display.getCurrent().getActiveShell().getStyle())));

		} else {
			// use the automatic assignToPartition
			return new SetInteractiveResult(targetPRI, "");
		}

	}

	protected Object getIndividualResourcesToExport(IAdaptable rootResource) {

		ResourceSelectionDialog dialog = new ResourceSelectionDialog(PlatformUI
				.getWorkbench().getActiveWorkbenchWindow().getShell(),
				rootResource, "Select the project to get the path");
		dialog.open();
		Object[] result = new Object[dialog.getResult().length];
		result = dialog.getResult();

		// just the last selected Project will be return
		return result[dialog.getResult().length - 1];
	}
	

	private String getDialogResult(final Shell shell2) {

		shell2.setText("Please choose one of this options");
		shell2.setSize(350, 160);
		shell2.setLayout(new RowLayout());

		final Button button1 = new Button(shell2, SWT.PUSH);
		button1.setText("Model");
		final Button button2 = new Button(shell2, SWT.PUSH);
		button2.setText("Textblock");
		final Button button3 = new Button(shell2, SWT.PUSH);
		button3.setText("All");

		shell2.open();

		Listener listener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				response = "";
				if (event.widget == button1) {
					response = "Model";
					// eventResponse.add(response);
					// responses.put(new Integer(2), eventResponse);
					System.out.println("Model was clicked ");
					shell2.close();
				} else if (event.widget == button2) {
					response = "Textblocks";
					// eventResponse.add(response);
					// responses.put(new Integer(2), eventResponse);
					System.out.println("Textblocks was clicked ");
					shell2.close();
				} else if (event.widget == button3) {
					response = "All";
					// eventResponse.add(response);
					// responses.put(new Integer(2), eventResponse);
					System.out.println("All was clicked ");
					shell2.close();
				}
			}

		};

		button1.addListener(SWT.Selection, listener);
		button2.addListener(SWT.Selection, listener);
		button3.addListener(SWT.Selection, listener);

		while (!shell2.isDisposed()) {
			if (!shell2.getDisplay().readAndDispatch()) {
				shell2.getDisplay().sleep();
			}
		}

		return response;

	}

}
