package com.sap.ide.moftool.editor.graphics.connection.association.decorations;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.core.service.StyleService;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IReason;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.impl.AbstractUpdateFeature;
import com.sap.mi.gfw.features.impl.Reason;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.PeUtil;

public class UpdateAssociationEndCombinedDecoratorFeature extends AbstractUpdateFeature {

	private static final int NUMBER_NONE = 0;
	private static final int NUMBER_STOR = 1;
	private static final int NUMBER_NAVI = 2;
	private static final int NUMBER_NAVI_STOR = 3;
	private static final int NUMBER_COMP = 4;
	private static final int NUMBER_COMP_STOR = 5;
	private static final int NUMBER_COMP_NAVI = 6;
	private static final int NUMBER_COMP_NAVI_STOR = 7;
	
	private static final int[] COORDINATES_NONE = new int[] {};
	private static final int[] COORDINATES_STOR = new int[] {0,-3, 0,3, -2,3, -2,-3};
	private static final int[] COORDINATES_NAVI = new int[] {0,0, -6,6, 0,0, -6,-6};
	private static final int[] COORDINATES_NAVI_STOR = new int[] {0,-3, 0,3, -2,3, -2,0, -3,0, -9,6, -3,0, -9,-6, -3,0, -2,0, -2,-3};
	private static final int[] COORDINATES_COMP = new int[] {0,0, -6,6, -12,0, -6,-6};
	private static final int[] COORDINATES_COMP_STOR = new int[] {0,-3, 0,3, -2,3, -2,0, -3,0, -9,6, -15,0, -9,-6, -3,0, -2,0, -2,-3};
	private static final int[] COORDINATES_COMP_NAVI = new int[] {0,0, -6,6, -12,0, -13,0, -19,6, -13,0, -19,-6, -13,0, -12,0, -6,-6};
	private static final int[] COORDINATES_COMP_NAVI_STOR = new int[] {0,-3, 0,3, -2,3, -2,0, -3,0, -9,6, -15,0, -16,0, -22,6, -16,0, -22,-6, -16,0, -15,0, -9,-6, -3,0, -2,0, -2,-3};

	public UpdateAssociationEndCombinedDecoratorFeature(IFeatureProvider fp) {
		super(fp);
	}

	public boolean canUpdate(IUpdateContext context) {
		boolean ret = false;
		PictogramElement pe = context.getPictogramElement();
		if (pe instanceof ConnectionDecorator) {
			ret = true;
		}        
		return ret;
	}

	public IReason updateNeeded(IUpdateContext context) {
		IReason ret = Reason.createFalseReason();

		PictogramElement pe = context.getPictogramElement();
		if (pe instanceof ConnectionDecorator) {
			ConnectionDecorator decorator = (ConnectionDecorator)pe;
			Object businessObject = getBusinessObjectForPictogramElement(pe);
			if (businessObject instanceof AssociationEnd) {
				AssociationEnd ae = (AssociationEnd)businessObject;
				GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();

				if (ga != null) {
					// Decorator is visualized
					
					// Check aggregation
					if (AggregationKindEnum.COMPOSITE.equals(ae.getAggregation())) {
						// Should be composition
						if (!MOFToolConstants.VALUE_YES.equals(PeUtil.getPropertyValue(decorator, MOFToolConstants.COMPOSITE))) {
							ret = new Reason(true, "Should be composite"); //$NON-NLS-1$
						}
					}
					else {
						// Should be standard association
						if (!MOFToolConstants.VALUE_NO.equals(PeUtil.getPropertyValue(decorator, MOFToolConstants.COMPOSITE))) {
							ret = new Reason(true, "Should not be composite"); //$NON-NLS-1$
						}
					}
					
					// Check navigability
					if (AssociationService.isNavigationEnabled(ae)) {
						// Should be navigable
						if (!MOFToolConstants.VALUE_YES.equals(PeUtil.getPropertyValue(decorator, MOFToolConstants.NAVIGABLE))) {
							ret = new Reason(true, "Should be navigable"); //$NON-NLS-1$
						}
					}
					else {
						// Should not be navigable
						if (!MOFToolConstants.VALUE_NO.equals(PeUtil.getPropertyValue(decorator, MOFToolConstants.NAVIGABLE))) {
							ret = new Reason(true, "Should not be navigable"); //$NON-NLS-1$
						}
					}

					// Check storage
					if (ModelAdapter.getInstance().getConnection(ae).getJmiHelper().isEndStored(ae)) {
						// Storage should be shown
						if (!MOFToolConstants.VALUE_YES.equals(PeUtil.getPropertyValue(decorator, MOFToolConstants.STORAGE))) {
							ret = new Reason(true, "Storage should be shown"); //$NON-NLS-1$
						}
					}
					else {
						// Storage should not be shown
						if (!MOFToolConstants.VALUE_NO.equals(PeUtil.getPropertyValue(decorator, MOFToolConstants.STORAGE))) {
							ret = new Reason(true, "Storage should not be shown"); //$NON-NLS-1$
						}
					}
				}
				else {
					// Decorator is not visualized but should be shown in any case
					ret = new Reason(true, "Decorator needs to be added"); //$NON-NLS-1$
				}
			}
		}
		return ret;
	}

	public boolean update(IUpdateContext context) {
		boolean ret = false;

		ConnectionDecorator decorator = (ConnectionDecorator)context.getPictogramElement();
		Object object = getBusinessObjectForPictogramElement(decorator);
		if (object instanceof AssociationEnd) {
			AssociationEnd ae = (AssociationEnd)object;
			GraphicsAlgorithm ga = decorator.getGraphicsAlgorithm();

			// Cleanup of old graphics algorithm
			if (ga != null) {
				// Delete old graphics algorithm (needs to be adapted anyway)
				ga.refDelete();
				ret = true;
			}

			// Check what needs to be drawn
			int index = 0;
			if (AggregationKindEnum.COMPOSITE.equals(ae.getAggregation())) {
				index = index + 4;
			}
			if (AssociationService.isNavigationEnabled(ae)) {
				index = index + 2;
			}
			if (ModelAdapter.getInstance().getConnection(ae).getJmiHelper().isEndStored(ae)) {
				index = index + 1;
			}
			
			// Create new graphics algorithm
			switch (index) {
				case NUMBER_NONE:
					ga = GaUtil.createPolygon(decorator, COORDINATES_NONE);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.COMPOSITE, MOFToolConstants.VALUE_NO);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.NAVIGABLE, MOFToolConstants.VALUE_NO);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.STORAGE, MOFToolConstants.VALUE_NO);
					break;
				case NUMBER_STOR:
					ga = GaUtil.createPolygon(decorator, COORDINATES_STOR);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.COMPOSITE, MOFToolConstants.VALUE_NO);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.NAVIGABLE, MOFToolConstants.VALUE_NO);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.STORAGE, MOFToolConstants.VALUE_YES);
					break;
				case NUMBER_NAVI:
					ga = GaUtil.createPolygon(decorator, COORDINATES_NAVI);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.COMPOSITE, MOFToolConstants.VALUE_NO);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.NAVIGABLE, MOFToolConstants.VALUE_YES);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.STORAGE, MOFToolConstants.VALUE_NO);
					break;
				case NUMBER_NAVI_STOR:
					ga = GaUtil.createPolygon(decorator, COORDINATES_NAVI_STOR);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.COMPOSITE, MOFToolConstants.VALUE_NO);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.NAVIGABLE, MOFToolConstants.VALUE_YES);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.STORAGE, MOFToolConstants.VALUE_YES);
					break;
				case NUMBER_COMP:
					ga = GaUtil.createPolygon(decorator, COORDINATES_COMP);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.COMPOSITE, MOFToolConstants.VALUE_YES);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.NAVIGABLE, MOFToolConstants.VALUE_NO);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.STORAGE, MOFToolConstants.VALUE_NO);
					break;
				case NUMBER_COMP_STOR:
					ga = GaUtil.createPolygon(decorator, COORDINATES_COMP_STOR);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.COMPOSITE, MOFToolConstants.VALUE_YES);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.NAVIGABLE, MOFToolConstants.VALUE_NO);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.STORAGE, MOFToolConstants.VALUE_YES);
					break;
				case NUMBER_COMP_NAVI:
					ga = GaUtil.createPolygon(decorator, COORDINATES_COMP_NAVI);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.COMPOSITE, MOFToolConstants.VALUE_YES);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.NAVIGABLE, MOFToolConstants.VALUE_YES);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.STORAGE, MOFToolConstants.VALUE_NO);
					break;
				case NUMBER_COMP_NAVI_STOR:
					ga = GaUtil.createPolygon(decorator, COORDINATES_COMP_NAVI_STOR);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.COMPOSITE, MOFToolConstants.VALUE_YES);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.NAVIGABLE, MOFToolConstants.VALUE_YES);
					PeUtil.setPropertyValue(decorator, MOFToolConstants.STORAGE, MOFToolConstants.VALUE_YES);
					break;
				default:
					break;
			}
			GaUtil.ignoreAll(ga);
			ga.setStyle(StyleService.getConnectionAssociationDecoratorStyle(PeUtil.getDiagramForPictogramElement(decorator)));
			decorator.setGraphicsAlgorithm(ga);
			
			ret = true;
		}
		return ret;
	}
}
