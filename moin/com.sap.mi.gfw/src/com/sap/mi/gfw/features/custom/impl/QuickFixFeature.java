package com.sap.mi.gfw.features.custom.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class QuickFixFeature.
 */
public class QuickFixFeature extends AbstractCustomFeature {
	private static final String NAME = Messages.QuickFixFeature_0_xfld;

	/**
	 * Instantiates a new quick fix feature.
	 * 
	 * @param fp
	 *            the fp
	 */
	public QuickFixFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.custom.AbstractCustomFeature#canExecute(com.sap.mi.gfw.features.context.ICustomContext)
	 */
	@Override
	public boolean canExecute(ICustomContext context) {
		PictogramElement[] pictogramElements = context.getPictogramElements();
		for (PictogramElement pe : pictogramElements) {
			Object[] bos = getAllBusinessObjectsForPictogramElement(pe);
			RefObject[] ros = new RefObject[bos.length];
			for (int i = 0; i < bos.length; i++) {
				Object bo = bos[i];
				if (!(bo instanceof RefObject)) {
					return false;
				} else {
					ros[i] = (RefObject) bos[i];
				}
			}

			if (getPlatformService().canDoFixes(ros)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.custom.ICustomFeature#execute(com.sap.mi.gfw.features.context.ICustomContext)
	 */
	public void execute(ICustomContext context) {
		PictogramElement[] pictogramElements = context.getPictogramElements();
		List<RefObject> objList = new ArrayList<RefObject>();
		for (PictogramElement pe : pictogramElements) {
			Object[] bos = getAllBusinessObjectsForPictogramElement(pe);
			for (Object bo : bos) {
				if (bo instanceof RefObject) {
					RefObject ro = (RefObject) bo;
					objList.add(ro);
				}
			}
		}

		RefObject[] toArray = objList.toArray(new RefObject[objList.size()]);
		getPlatformService().doFixes(toArray);
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
}