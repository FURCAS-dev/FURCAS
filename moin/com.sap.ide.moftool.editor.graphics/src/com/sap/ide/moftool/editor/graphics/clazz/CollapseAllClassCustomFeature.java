package com.sap.ide.moftool.editor.graphics.clazz;

import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.graphics.pattern.compartment.AbstractMofCompartmentCollapseExpandFeature;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.DiagramUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.impl.CustomContext;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Property;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.PeUtil;

public class CollapseAllClassCustomFeature extends AbstractMofCompartmentCollapseExpandFeature {

	public CollapseAllClassCustomFeature(IFeatureProvider fp) {
		super(fp, Messages.CollapseAllClassCustomFeature_0_xbut, Messages.CollapseAllClassCustomFeature_1_xmsg);
	}

	@Override
	public boolean isAvailable(IContext context) {
		boolean ret = false;
		if (context instanceof ICustomContext) {
			CustomContext customContext = (CustomContext)context;
			PictogramElement[] pes = customContext.getPictogramElements();
			Diagram diagram = getDiagram();
			List<ContainerShape> allCS = DiagramUtil.getAllClassContainerShapesFromDiagram(diagram);
			if (!allCS.isEmpty() && pes[0] instanceof Diagram) {
				ret = true;
			}
		}
		return ret;
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	public void execute(ICustomContext context) {
		List<ContainerShape> allCS = DiagramUtil.getAllClassContainerShapesFromDiagram(getDiagram());
		for (int i = 0; i < allCS.size(); i++) {
			ContainerShape pe = allCS.get(i);
			Object obj = getBusinessObjectForPictogramElement(pe);
			if (obj instanceof MofClass) {
				ContainerShape classShape = (ContainerShape) pe;
				Property property = PeUtil.getProperty(pe, MOFToolConstants.COLLAPSE_FEATURE);
				if (property == null) {
					PeUtil.setPropertyValue(pe, MOFToolConstants.COLLAPSE_FEATURE, null);
				}
				List<Shape> ch = classShape.getChildren();
				for (Iterator<Shape> iter = ch.iterator(); iter.hasNext();) {
					Object object = iter.next();
					if (object instanceof ContainerShape) {
						ContainerShape cs = (ContainerShape)object;
						if (PeUtil.getProperty(cs, MOFToolConstants.COLLAPSE_FEATURE) == null
								&& PeUtil.getProperty(cs, MOFToolConstants.COMPARTMENT_NUMBER) != null) {
							PeUtil.setPropertyValue(cs, MOFToolConstants.COLLAPSE_FEATURE, null);
						}
					}
				}
				pe.getGraphicsAlgorithm().setHeight(0);
				updatePictogramElement(pe);
			}
		}
	}
}
