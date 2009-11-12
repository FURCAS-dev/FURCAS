package com.sap.ide.moftool.editor.graphics.pattern.compartment;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.graphics.pattern.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Property;
import com.sap.mi.gfw.util.PeUtil;

public class ExpandCompartmentsCustomFeature extends AbstractCustomFeature {

	public ExpandCompartmentsCustomFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length > 0 &&pes[0] instanceof ContainerShape) {
			ContainerShape cs = (ContainerShape) pes[0];
		    PeUtil.removeProperty(cs, MOFToolConstants.COLLAPSE_FEATURE);
			updatePictogramElement(cs);

		}
	}

	@Override
	public boolean isAvailable(IContext context) {
		boolean ret = false;
		if (context instanceof ICustomContext) {
			PictogramElement[] pes = ((ICustomContext) context).getPictogramElements();

			if (pes != null && pes.length > 0 && pes[0] instanceof ContainerShape) {
				boolean expandPossible = false;
				ContainerShape cs = (ContainerShape) pes[0];

				if (!expandPossible) {
					Property property = PeUtil.getProperty(cs, MOFToolConstants.COLLAPSE_FEATURE);
					if (property != null ) {
						expandPossible = true;
					}
				}
				if (expandPossible) {
					return true;
				}
			}
		}
		return ret;
	}

	public String getName() {
		return Messages.ExpandCompartmentsCustomFeature_0_xbut;
	}
}
