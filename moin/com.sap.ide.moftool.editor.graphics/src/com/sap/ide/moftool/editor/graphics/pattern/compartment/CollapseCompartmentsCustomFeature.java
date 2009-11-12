package com.sap.ide.moftool.editor.graphics.pattern.compartment;

import java.util.Iterator;
import java.util.List;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.graphics.pattern.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Property;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.PeUtil;

public class CollapseCompartmentsCustomFeature extends AbstractCustomFeature {

	public CollapseCompartmentsCustomFeature(IFeatureProvider fp) {
		super(fp);
	}

	public String getName() {
		return Messages.CollapseCompartmentsCustomFeature_0_xbut;
	}

	@Override
	public boolean isAvailable(IContext context) {
		boolean ret = false;
		if (context instanceof ICustomContext) {
			PictogramElement[] pes = ((ICustomContext)context).getPictogramElements();
			if (pes.length > 0 && !(pes[0] instanceof Diagram) && pes[0] instanceof ContainerShape) {
				ContainerShape pe = (ContainerShape)pes[0];                 
				Property property = PeUtil.getProperty(pe, MOFToolConstants.COLLAPSE_FEATURE);
				if (property == null) {
					return true;
				}
			} 

		}
		return ret;
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes[0] instanceof ContainerShape) {

			ContainerShape pe = (ContainerShape) pes[0];
			Property property = PeUtil.getProperty(pe, MOFToolConstants.COLLAPSE_FEATURE);
			if (property == null) {
				PeUtil.setPropertyValue(pe, MOFToolConstants.COLLAPSE_FEATURE, null);
			}
			List<Shape> ch = pe.getChildren();
			for (Iterator<Shape> iter = ch.iterator(); iter.hasNext();) {
				Object object = iter.next();
				if (object instanceof ContainerShape) {
					ContainerShape cs = (ContainerShape) object;
					if (PeUtil.getProperty(cs, MOFToolConstants.COLLAPSE_FEATURE) == null) {
						PeUtil.setPropertyValue(cs, MOFToolConstants.COLLAPSE_FEATURE, null);
					}
				}
			}
			pe.getGraphicsAlgorithm().setHeight(0);
			updatePictogramElement(pe);
		}
	}
}
