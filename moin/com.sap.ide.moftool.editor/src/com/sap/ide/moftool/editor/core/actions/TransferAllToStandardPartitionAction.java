package com.sap.ide.moftool.editor.core.actions;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.sap.ide.moftool.editor.core.commands.MofPartitionService;
import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;

public class TransferAllToStandardPartitionAction implements IObjectActionDelegate {

	private IProject mProject = null;

	public TransferAllToStandardPartitionAction() {
		super();
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// Nothing to do
	}

	public void run(IAction action) {	
		
		Connection connection = MofService.createConnectionWithBusyCursorWhile(mProject); 
		if (connection == null) {
			return;
		}		

		// Get the standard metamodel partition
		ModelPartition standardPartition = MofPartitionService.getStandardMetamodelPartition(mProject, connection, true);
		
		// Get all non-standard partitions in project and loop over them
		Collection<PRI> partitions = PartitionService.getInstance().getPartitions(connection, mProject);
		for (PRI pri : partitions) {
			ModelPartition partition = connection.getPartition(pri);
			if (!partition.getPri().equals(standardPartition.getPri())) {
				// Not the standard partition
				if (!partition.getPri().getPartitionName().startsWith(
						MofPartitionService.DIAGRAMS_FOLDER.toString())) {
					// Not a diagram partition -> transfer objects
					Collection<Partitionable> elements = partition.getElements();
					for (Partitionable partitionable : elements) {
						partitionable.assign___Partition(standardPartition);
					}
					// Delete the now empty partition
					partition.delete();
				}
			}
		}

        // Save changes
       	ModelManagerUI.getConnectionManagerUI().save(connection, mProject, null);
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IProject) {
			mProject = (IProject)selection;
		}
		else if (selection instanceof StructuredSelection) {
			StructuredSelection strSel = (StructuredSelection)selection;
			Object object = strSel.getFirstElement();
			if (object instanceof IProject) {
				mProject = (IProject)object;
			}
		}
	}

}
