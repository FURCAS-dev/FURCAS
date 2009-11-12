package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.core.service.ReferenceService;
import com.sap.ide.moftool.editor.core.service.StorageService;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class DeleteAssociationCommand extends Command {

	private Association mAssociation = null;

	public DeleteAssociationCommand(Association association, Connection connection) {
		super(connection, LocalizationMessages.DeleteAssociationCommand_0_XMIT);
		mAssociation = association;
	}

	@Override
	public boolean canExecute() {
		return mAssociation != null;
	}

	@Override
	public void doExecute() {
		// if association is not alive any more: do nothing
		if (!((Partitionable)mAssociation).is___Alive()) {
			return;
		}
		// Find association ends
		AssociationEnd[] assocEnds = AssociationService.getAssociationEnds(mAssociation);
		
		// Loop over them
		for (int i = 0; i < assocEnds.length; i++) {
			
			// Find the references for the association end
			List<Reference> list = ReferenceService.findReferences(assocEnds[i]);
			
			// ... and delete them ...
			Reference[] references = new Reference[list.size()];
			references = list.toArray(references);
			for (int j = 0; j < references.length; j++) {
				// ... if they are not foreign
				if (!ModelElementService.isForeignObject(assocEnds[i], references[j])) {
					DeleteModelElementCommand command = new DeleteModelElementCommand(references[j], getConnection());
					command.doExecute();
				}
			}
		}

		for (int i = 0; i < assocEnds.length; i++) {
			// Check the storage tags for the association end (storage == true)
			Tag tag = StorageService.getRelevantStorageTag(assocEnds[i], true);
			checkAndRemoveTag(assocEnds[i], tag);

			// Check the storage tags for the association end (storage == false)
			tag = StorageService.getRelevantStorageTag(assocEnds[i], false);
			checkAndRemoveTag(assocEnds[i], tag);

			// Delete the association ends. Needs to be done in separate loop because we need
			// both ends for cleanup of the references
			if (((Partitionable)assocEnds[i]).is___Alive()) {
				assocEnds[i].refDelete();
			}
		}

		// Delete the association
		if (((Partitionable)mAssociation).is___Alive()) {
			mAssociation.refDelete();
		}
	}

	private void checkAndRemoveTag(AssociationEnd ae, Tag tag) {
		if (tag != null) {
			// Check the relevant tag if it tags this end
			Collection<ModelElement> taggedElements = tag.getElements();
			if (taggedElements.size() <= 1 && taggedElements.contains(ae)) {
				// If it tags this end and the list of tagged elements contains only
				// one element, deleting this end will remove the last entry from 
				// the elements list and cause an problem marker --> delete the tag
				// to avoid this
				if (((Partitionable)tag).is___Alive()) {
					tag.refDelete();
				}
			}
		}
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForObjectDeletion((Partitionable)mAssociation);
	}
}
