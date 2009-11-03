package com.sap.mi.gfw.eclipse.internal.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditPart;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;
import com.sap.mi.gfw.mm.pictograms.ChopboxAnchor;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.tb.IToolBehaviorProvider;

/**
 * A class, which contains helper-methods, which are necessarry to implement the interface IAnchorContainerEditPart. It is not possible to
 * make this an EditPart itself, because of different inheritance-hierarchies used in the sub-classes.
 */
public class AnchorContainerDelegate extends PictogramElementDelegate implements IAnchorContainerDelegate {

	/**
	 * Creates a new AnchorContainerDelegate.
	 * 
	 * @param configurationProvider
	 *            the configuration provider
	 * @param pictogramElement
	 *            the pictogram element
	 * @param containerEditPart
	 *            the container edit part
	 */
	protected AnchorContainerDelegate(IConfigurationProvider configurationProvider, PictogramElement pictogramElement,
			EditPart containerEditPart) {
		super(configurationProvider, pictogramElement, containerEditPart);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.IAnchorContainerDelegate#getModelChildren()
	 */
	public List<PictogramElement> getModelChildren() {
		List<PictogramElement> result = new ArrayList<PictogramElement>();
		AnchorContainer notAnAnchorElement = (AnchorContainer) getPictogramElement();
		if (!MoinHelper.isObjectAlive(notAnAnchorElement)) {
			return result;
		}
		Collection allAnchors = notAnAnchorElement.getAnchors();
		for (Iterator iter = allAnchors.iterator(); iter.hasNext();) {
			Anchor anchor = (Anchor) iter.next();
			if (anchor.isActive() && !(anchor instanceof ChopboxAnchor)) {
				result.add(anchor);
			}
		}
		return result;
	}

	public void refreshRenderingDecorators() {
		PictogramElement pe = getPictogramElement();
		GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
		IToolBehaviorProvider tbp = getConfigurationProvider().getDiagramTypeProvider().getCurrentToolBehaviorProvider();
		addRenderingDecorators(ga, pe, getFigureForGraphicsAlgorithm(ga), tbp);
	}
}