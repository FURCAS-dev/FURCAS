package com.sap.ide.moftool.editor.graphics.connection.association.decorations;

import com.sap.tc.moin.repository.mmi.model.Association;

import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public abstract class AbstractConnectionDecoratorDirectEditingFeature extends
		AbstractDirectEditingFeature {

	public AbstractConnectionDecoratorDirectEditingFeature(IFeatureProvider fp) {
		super(fp);
	}

	/* (non-Javadoc)
	 * @see com.sap.mi.gfw.features.impl.AbstractFeature#updatePictogramElement(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	@Override
	protected void updatePictogramElement(PictogramElement pe) {
        ConnectionDecoratorUpdateContext context = new ConnectionDecoratorUpdateContext(pe, true);
        getFeatureProvider().updateIfPossible(context);
	}

	/* (non-Javadoc)
	 * @see com.sap.mi.gfw.features.impl.AbstractDirectEditingFeature#canDirectEdit(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		boolean ret = super.canDirectEdit(context);
		if (!ret) {
			return false;
		}
		PictogramElement pe = context.getPictogramElement();
		if (pe != null) {
			Object bo = getBusinessObjectForPictogramElement(pe);
			if (bo instanceof Association) {     
				ret = !ModelElementService.isForeignObject(getDiagram(), (Association)bo);
			}
		}
		return ret;
	}
}
