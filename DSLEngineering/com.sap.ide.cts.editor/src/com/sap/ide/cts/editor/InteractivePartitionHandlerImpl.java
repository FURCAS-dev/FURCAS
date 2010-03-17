package com.sap.ide.cts.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
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
import com.sun.org.apache.bcel.internal.generic.NEW;

/*
 * return a PRI of the Partition after interacting with the user
 */
public class InteractivePartitionHandlerImpl implements
	InteractivePartitionHandler {

	 	private Object object;
	    private IProject project;
	    private PRI targetPRI;
	    private static String response;
//	    private List<String> eventResponse = new ArrayList<String>();
//	    private List<PRI> priResponse = new ArrayList<PRI>();
//	    private Map<Integer,List> responses = new HashMap<Integer, List>();
	    private SetInteractiveResult InteractiveResult;
	    private Display display;
	    private Shell shell;
	    
	    
	    /*
	     * return a PRI of the Partition after interacting with the user
	     */

	    public InteractivePartitionHandlerImpl(Shell shell2) {
			shell = shell2;
			// TODO Auto-generated constructor stub
		}



		@Override
	    public SetInteractiveResult getPartitionFor(PartitionHandling ph, ModelPartition partition,
		    RefObject newElement , Connection connection) {
//		// Choose the correct element to be show to the user
//		int question = JOptionPane.showConfirmDialog(null,
//			"Do you want to create a new partition for this sequence:"
//				+ newElement + "?", " CREATION OF MANUAL PARTION ",
//			JOptionPane.YES_NO_CANCEL_OPTION);
//		if (question == 0) {
//		    // how to get the root element(IAdaptable) and the IPath
//		    project = ModelManager.getModelAdapter().getProject(
//			    partition.getPri().getCri());
//		    object = getIndividualResourcesToExport(project);
	//
//		   
//		    IPath path = new Path("src/".concat(object.toString()));
//		    targetPRI = ModelManager.getPartitionService()
//			    .getPRI(project, path);
//		  
//		} else {
//		    // use the automatic assignToPartition 
//		    targetPRI = null;
//		}
	//	
//		return targetPRI;
		
		
//		display = new Display();
//		shell = new Shell(display);
//		shell.setSize(300, 300);
//
//		final Shell shell2 = new Shell(display);
		shell.setText("Please choose one of this options");
		shell.setSize(350, 160);

		RowLayout rowLayout = new RowLayout();
		shell.setLayout(rowLayout);

		final Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("Model");
		final Button button2 = new Button(shell, SWT.PUSH);
		button2.setText("Textblock");
		final Button button3 = new Button(shell, SWT.PUSH);
		button3.setText("All");

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
//			priResponse.add(targetPRI);
//			responses.put(new Integer(1), priResponse);
				  
			
			shell.open();

			Listener listener = new Listener() {
				@Override
				public void handleEvent(Event event) {
					response = "";
					if (event.widget == button1) {
						response = "Model";
//						eventResponse.add(response);
//						responses.put(new Integer(2), eventResponse);
						System.out.println("Model was clicked ");
						shell.close();
					} else if (event.widget == button2) {
						response = "Textblocks";
//						eventResponse.add(response);
//						responses.put(new Integer(2), eventResponse);
						System.out.println("Textblocks was clicked ");
						shell.close();
					} else if (event.widget == button3) {
						response = "All";
//						eventResponse.add(response);
//						responses.put(new Integer(2), eventResponse);
						System.out.println("All was clicked ");
						shell.close();
					}
				}

			};
			//The second alternative
		 InteractiveResult = new SetInteractiveResult(targetPRI, response);
		

			button1.addListener(SWT.Selection, listener);
			button2.addListener(SWT.Selection, listener);
			button3.addListener(SWT.Selection, listener);
			
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
			display.dispose();
			
			 return InteractiveResult;
			
		}else {
		    // use the automatic assignToPartition 
//		    responses.put(new Integer(3), null);
		     InteractiveResult = new SetInteractiveResult(null, null);
		     return InteractiveResult;
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

	}

