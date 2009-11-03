package com.sap.mi.gfw.features.custom.impl;

import java.util.Collection;
import java.util.HashSet;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.PackageUtil;

/**
 * The Class AbstractDrillDownFeature.
 */
public abstract class AbstractDrillDownFeature extends AbstractCustomFeature {

	private static final String NAME = Messages.AbstractDrillDownFeature_0_xfld;

	/**
	 * Instantiates a new abstract drill down feature.
	 * 
	 * @param fp
	 *            the fp
	 */
	public AbstractDrillDownFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeature#getName()
	 */
	@Override
	public String getName() {
		return NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.custom.ICustomFeature#execute(com.sap.mi.gfw.features.context.ICustomContext)
	 */
	public void execute(ICustomContext context) {
		PictogramElement pe = context.getPictogramElements()[0];
		Collection<Diagram> possibleDiagramsList = getLinkedDiagrams(pe);

		if (!possibleDiagramsList.isEmpty()) {
			Diagram[] possibleDiagrams = possibleDiagramsList.toArray(new Diagram[0]);
			if (possibleDiagramsList.size() == 1) {
				Diagram diagram = possibleDiagrams[0];
				getPlatformService().openDiagram(diagram, getFeatureProvider().getDiagramTypeProvider().getProviderId());
			} else {
				Object[] userResult = getPlatformService().objectSelection(Messages.AbstractDrillDownFeature_1_xmsg, Messages.AbstractDrillDownFeature_2_xmsg,
						possibleDiagrams, new Diagram[] { possibleDiagrams[0] }, true, new DiagramLabelProvider());
				if (userResult != null) {
					for (int i = 0; i < userResult.length; i++) {
						Diagram diagram = (Diagram) userResult[i];
						getPlatformService().openDiagram(diagram, getFeatureProvider().getDiagramTypeProvider().getProviderId());
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.custom.AbstractCustomFeature#canExecute(com.sap.mi.gfw.features.context.ICustomContext)
	 */
	@Override
	public boolean canExecute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			PictogramElement pe = context.getPictogramElements()[0];
			Collection<Diagram> possibleDiagramsList = getLinkedDiagrams(pe);

			return possibleDiagramsList.size() >= 1;
		}
		return false;
	}

	/**
	 * Returns a list of all diagrams, which are connected to the given pictogram element. This means, that the diagrams and the pictogram
	 * element have at least one linked business object in common.
	 * 
	 * @param pe
	 *            The pictogram element for which to return the connected diagrams.
	 * @return A list of all diagrams, which are connected to the given pictogram element.
	 */
	protected Collection<Diagram> getLinkedDiagrams(PictogramElement pe) {
		Collection<Diagram> ret = new HashSet<Diagram>();

		Object[] businessObjectsForPictogramElement = getAllBusinessObjectsForPictogramElement(pe);

		Collection<Diagram> allDiagrams = MoinHelper.refAllOfClass(PackageUtil.getPictogramsPackage(pe).getDiagram());
		for (Diagram d : allDiagrams) {
			Diagram currentDiagram = getDiagram();
			if (!currentDiagram.equals(d)) { // always filter out the current
				// diagram
				Object[] businessObjectsForDiagram = getAllBusinessObjectsForPictogramElement(d);
				for (int i = 0; i < businessObjectsForDiagram.length; i++) {
					Object diagramBo = businessObjectsForDiagram[i];
					for (int j = 0; j < businessObjectsForPictogramElement.length; j++) {
						Object currentBo = businessObjectsForPictogramElement[j];
						if (diagramBo.equals(currentBo)) {
							ret.add(d);
						}
					}
				}
			}
		}

		return ret;
	}
}
