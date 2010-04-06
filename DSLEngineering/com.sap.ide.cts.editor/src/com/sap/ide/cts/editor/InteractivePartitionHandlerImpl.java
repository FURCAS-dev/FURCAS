package com.sap.ide.cts.editor;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

import tcs.PartitionHandling;
import textblocks.TextBlock;

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
	private String response;
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

		return getDialogResult(new Shell(Display.getCurrent().getActiveShell()
				.getShell(), Display.getCurrent().getActiveShell().getStyle()),
				newElement, partition);
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

	private SetInteractiveResult getDialogResult(final Shell shell3,
			RefObject newElement, final ModelPartition partition) {
		final SetInteractiveResult setResult = new SetInteractiveResult(null,
				null, false);
		String name = "";

		shell3.setText("Please choose one of this options");
		shell3.setSize(400, 300);
		shell3.setLayout(new GridLayout());

		Text text = new Text(shell3, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		text.setEditable(false);
		text.setBounds(5, 5, 200, 20);
		text.setLayoutData(new GridData(SWT.UP, SWT.CENTER, true, true));
		if (newElement instanceof TextBlock) {
			if (((TextBlock) newElement).getCorrespondingModelElements().size() > 0) {
				RefObject newRefObject = ((TextBlock) newElement)
						.getCorrespondingModelElements().get(0);
				name = (String) newRefObject.refGetValue("name");
				text.setText("The TextBlock of the Element : " + name);
			}
		} else {
			name = (String) newElement.refGetValue("name");
			text.setText("the Element with the value : " + name);
		}

		final Button browse = new Button(shell3, SWT.PUSH);
		browse.setText("BROWSE");
		browse.setSize(15, 15);
		browse.setLayoutData(new GridData(SWT.RIGHT, SWT.UP, true, true));

		final Button button1 = new Button(shell3, SWT.RADIO);
		button1.setText("Model");
		final Button button2 = new Button(shell3, SWT.RADIO);
		button2.setText("Textblock");
		final Button button3 = new Button(shell3, SWT.RADIO);
		button3.setText("All");
		// button3.setEnabled(true);
		final Button button4 = new Button(shell3, SWT.CHECK);
		button4.setText("For All the next Elements");

		final Button ok = new Button(shell3, SWT.PUSH);
		ok.setText("OK");
		ok.setSize(15, 15);
		ok.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true));

		final Button cancel = new Button(shell3, SWT.PUSH);
		cancel.setText("CANCEL");
		// cancel.setSize(15, 15);
		cancel.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, true));

		Listener listener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				response = "";
				// interactivePartition = false;
				targetPRI = null; 
				
				if (event.widget == browse) {
					project = ModelManager.getModelAdapter().getProject(
							partition.getPri().getCri());
					object = getIndividualResourcesToExport(project);

					IPath path = new Path("src/".concat(object.toString()));
					targetPRI = ModelManager.getPartitionService().getPRI(
							project, path);
					setResult.setPri_Result(targetPRI);
					System.out.println("browse was clicked ");
					browse.setEnabled(false);
				} else if (event.widget == ok) {
					System.out.println("ok was clicked ");
					if (button1.getSelection()) {
						response = "Model";
						setResult.setMainPartitionContent(response);
						System.out.println("Model was clicked ");
					} else if (button2.getSelection()) {
						response = "Textblocks";
						setResult.setMainPartitionContent(response);
						System.out.println("Textblocks was clicked ");
					} else {
						response = "All";
						setResult.setMainPartitionContent(response);
						System.out.println("All was clicked ");
					}
					if (button4.getSelection()) {
						setResult.setInteractivePartition(true);
						System.out.println("For All the Elements was clicked ");
					}
					shell3.close();

				} else if (event.widget == cancel) {
					System.out.println("cancel was clicked ");
					 shell3.close();
				}
			}

		};

		browse.addListener(SWT.Selection, listener);
		ok.addListener(SWT.Selection, listener);
		cancel.addListener(SWT.Selection, listener);

		shell3.open();
		while (!shell3.isDisposed()) {
			if (!shell3.getDisplay().readAndDispatch()) {
				shell3.getDisplay().sleep();
			}
		}

		return setResult;
	}
}
