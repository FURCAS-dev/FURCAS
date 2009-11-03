/*
 * Created on 06.07.2005
 */
package com.sap.mi.gfw.features.jam;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.mi.fwk.ui.dnd.ModelClipboard;
import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.ICopyFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICopyContext;
import com.sap.mi.gfw.features.impl.AbstractFeature;

/**
 * The Class AbstractCopyFeature.
 */
public abstract class AbstractCopyFeature extends AbstractFeature implements ICopyFeature {

	private static final String NAME = Messages.AbstractCopyFeature_0_xfld;

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public AbstractCopyFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof ICopyContext) {
			ret = canCopy((ICopyContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		if (context instanceof ICopyContext) {
			copy((ICopyContext) context);
		}
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

	/**
	 * Put to clipboard.
	 * 
	 * @param objects
	 *            the objects
	 */
	protected void putToClipboard(Object[] objects) {
		List list = new ArrayList<RefBaseObject>();
		for (Object o : objects) {
			if (o instanceof RefBaseObject) {
				RefBaseObject rbo = (RefBaseObject) o;
				list.add(rbo);
			}
		}
		RefBaseObject[] moinContent = (RefBaseObject[]) list.toArray(new RefBaseObject[0]);
		ModelClipboard.getDefault().setContent(moinContent);
	}
}