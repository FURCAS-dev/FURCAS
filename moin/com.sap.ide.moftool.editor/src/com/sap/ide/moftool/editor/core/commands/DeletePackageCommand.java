package com.sap.ide.moftool.editor.core.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.eclipse.core.resources.IProject;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.service.DiagramService;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class DeletePackageCommand extends Command {
	
	private MofPackage mPackage = null;

	public DeletePackageCommand(MofPackage pack, Connection connection) {
		super(connection, LocalizationMessages.DeletePackageCommand_0_XMIT);
		mPackage = pack;
	}

	@Override
	public boolean canExecute() {
		return mPackage != null;
	}

	@Override
	public void doExecute() {

		// Delete all diagrams in the package
		List<Diagram> diagrams = new ArrayList<Diagram>();
        Diagram diagram = null;
        MofPackage diagramPackage = null;
        IProject project = ModelAdapter.getInstance().getProject(mPackage);
        Connection connection = ModelAdapter.getInstance().getConnection(mPackage);	
        if (project != null) {
        	diagrams = DiagramService.getAllClassDiagrams(project);
        	Iterator<Diagram> it = diagrams.iterator();
        	while (it.hasNext()) {
        		diagram = it.next();
        		diagramPackage = DiagramService.getDiagramPackage(diagram);
        		if (isPackageContainedInOrEqualPackage(diagramPackage, mPackage)) {
    				DeleteDiagramCommand command = new DeleteDiagramCommand(diagram, connection);
    				if (!command.canExecute()) {
    					throw new InternalErrorException("Cannot execute delete diagram command"); //$NON-NLS-1$
    				}
    		        command.execute();
        		}
        	}
        }
      
		// Delete the package
		if (((Partitionable)mPackage).is___Alive()) {
			mPackage.refDelete();
		}
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		Collection<PartitionOperation> affectedPartitions = MofPartitionService.getAffectedDefaultPartitionsForObjectDeletion((Partitionable)mPackage);
        IProject project = ModelAdapter.getInstance().getProject(mPackage);
        Connection connection = ModelAdapter.getInstance().getConnection(mPackage);	
        List<Diagram> diagrams = new ArrayList<Diagram>();
        Diagram diagram = null;
        MofPackage diagramPackage = null;
        if (project != null) {
        	diagrams = DiagramService.getAllClassDiagrams(project);
        	Iterator<Diagram> it = diagrams.iterator();
        	while (it.hasNext()) {
        		diagram = it.next();
        		diagramPackage = DiagramService.getDiagramPackage(diagram);
        		if (isPackageContainedInOrEqualPackage(diagramPackage, mPackage)) {
    				DeleteDiagramCommand command = new DeleteDiagramCommand(diagram, connection);    				
    				affectedPartitions.addAll(command.getAffectedPartitions());
        		}
        	}
        }
		return affectedPartitions;
	}
	
	private boolean isPackageContainedInOrEqualPackage(MofPackage innerPackage, MofPackage outerPackage) {		

		if (innerPackage == null) {
			return false;
		}
		if (outerPackage == null) {
			return false;
		}
		if (innerPackage == outerPackage) {
			return true;
		} else {
			if (innerPackage.getContainer() == null) {
				return false;
			} else {
				if (innerPackage.getContainer() instanceof MofPackage) {
					return isPackageContainedInOrEqualPackage((MofPackage)innerPackage.getContainer(), outerPackage);
				} else {
					return false;
				}
			}
			
		}
	}

}
