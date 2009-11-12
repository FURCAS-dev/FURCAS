package com.sap.ide.moftool.editor.graphics.connection.association;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.core.service.StorageService;
import com.sap.ide.moftool.editor.graphics.connection.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class ToggleStorageFeature extends AbstractCustomFeature {

	private String mName = Messages.ToggleStorageFeature_0_xbut;
	private String mDescription = Messages.ToggleStorageFeature_1_xmsg;

	public ToggleStorageFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean isAvailable(IContext context) {
		boolean ret = false;
		if (context instanceof ICustomContext) {
			PictogramElement[] pes = ((ICustomContext)context).getPictogramElements();
			if (pes != null && pes.length == 1) {
				PictogramElement pe = pes[0];
				if (pe instanceof Connection) {
					Object bo = getBusinessObjectForPictogramElement(pe);
					if (bo instanceof Association) {
						return true;
					}
				}
			}
		}
		return ret;
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			PictogramElement pe = pes[0];
			if (pe instanceof Connection) {
				Object bo = getBusinessObjectForPictogramElement(pe);
				if (bo instanceof Association) {
					if (ModelElementService.isForeignObject(getDiagram(), (Association)bo)) {
						// Association from another DC --> editing not allowed at all
						return false;
					}
					Association association = (Association)bo;
					AssociationEnd[] aes = AssociationService.getAssociationEnds(association);
					if (aes == null || aes.length ==  2) {
						if (aes[0] != null && aes[0].getType() != null && 
								aes[1] != null && aes[1].getType() != null) {
							return (!ModelElementService.isForeignObject(getDiagram(), aes[0].getType())) &&
								(!ModelElementService.isForeignObject(getDiagram(), aes[1].getType()));
						}
						return false;
					}
				}
			}
		}
		return ret;
	}

	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			PictogramElement pe = pes[0];
			if (pe instanceof Connection) {
				Object bo = getBusinessObjectForPictogramElement(pe);
				if (bo instanceof Association) {
					Association association = (Association)bo;
					AssociationEnd[] aes = AssociationService.getAssociationEnds(association);
					// Default for the end with storage is the first one (relevant in case no
					// storage is defined or storage is defined wrongly)
					AssociationEnd aeWithStorage = aes[0];
					for (int i = 0; i < aes.length; i++) {
						Tag tag = StorageService.getRelevantStorageTag(aes[i], true);
						if (tag != null && tag.getElements().contains(aes[i])) {
							// Tag with value 'yes' found that tags this association end
							aeWithStorage = aes[i];
							break;
						}
					}
					
					// Get the storage tags
					Tag yesTag = StorageService.getOrCreateRelevantStorageTag(aeWithStorage,
							true, getConnection());
					Tag noTag = StorageService.getOrCreateRelevantStorageTag(aeWithStorage.otherEnd(),
							false, getConnection());
					
					// Exchange storage
					yesTag.getElements().remove(aeWithStorage);
					yesTag.getElements().add(aeWithStorage.otherEnd());
					noTag.getElements().remove(aeWithStorage.otherEnd());
					noTag.getElements().add(aeWithStorage);
					
					// Update UI
					getFeatureProvider().updateIfPossible(new UpdateContext(pe));
				}
			}
		}
	}

	public String getName() {
		return mName;
	}

	@Override
	public String getDescription() {
		return mDescription;
	}
}
