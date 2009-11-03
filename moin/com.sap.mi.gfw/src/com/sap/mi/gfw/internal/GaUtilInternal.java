package com.sap.mi.gfw.internal;

import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.util.GaUtil;

/**
 * The Class GaUtilInternal.
 */
public class GaUtilInternal extends GaUtil {

	public static int getRelativeX(GraphicsAlgorithm ga, GraphicsAlgorithm referenceGA) {
		if (referenceGA == null || ga == null) {
			throw new IllegalArgumentException("ga and referenceGa must not be null, and ga must be a child of referenceGA"); //$NON-NLS-1$
		}
		if (ga.equals(referenceGA)) {
			return 0;
		}

		int ret = ga.getX();
		GraphicsAlgorithm parent = ga.getParentGraphicsAlgorithm();
		ret = ret + getRelativeX(parent, referenceGA);
		return ret;
	}

	public static int getRelativeY(GraphicsAlgorithm ga, GraphicsAlgorithm referenceGA) {
		if (referenceGA == null || ga == null) {
			throw new IllegalArgumentException("ga and referenceGa must not be null, and ga must be a child of referenceGA"); //$NON-NLS-1$
		}
		if (ga.equals(referenceGA)) {
			return 0;
		}

		int ret = ga.getY();
		GraphicsAlgorithm parent = ga.getParentGraphicsAlgorithm();
		ret = ret + getRelativeY(parent, referenceGA);
		return ret;
	}
}
