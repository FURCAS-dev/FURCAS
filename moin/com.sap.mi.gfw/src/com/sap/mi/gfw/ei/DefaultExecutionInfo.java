package com.sap.mi.gfw.ei;

import java.util.ArrayList;
import java.util.List;

import com.sap.mi.gfw.features.IFeatureAndContext;

/**
 * The Class DefaultExecutionInfo.
 */
public class DefaultExecutionInfo implements IExecutionInfo {
	private final List<IFeatureAndContext> executionList = new ArrayList<IFeatureAndContext>();

	/**
	 * Instantiates a new default execution info.
	 */
	public DefaultExecutionInfo() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.ei.IExecutionInfo#getExecutionList()
	 */
	public IFeatureAndContext[] getExecutionList() {
		return executionList.toArray(new IFeatureAndContext[0]);
	}

	/**
	 * Adds the feature and context.
	 * 
	 * @param fac
	 *            the fac
	 * 
	 * @return true, if successful
	 */
	public boolean addFeatureAndContext(IFeatureAndContext fac) {
		return executionList.add(fac);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String ret = getClass().getSimpleName();
		final int length = getExecutionList().length;
		if (length > 0) {
			for (int i = 0; i < length; i++) {
				IFeatureAndContext fac = getExecutionList()[i];
				ret = ret + "\n" + "  " + fac.toString() + "; "; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
		} else {
			ret = ret + " (execution list is empty)"; //$NON-NLS-1$
		}

		return ret;
	}
}
