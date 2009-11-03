/*
 * Created on 06.07.2005
 */
package com.sap.mi.gfw.features.jam;

import com.sap.mi.fwk.ui.dnd.ModelClipboard;
import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IPasteFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IPasteContext;
import com.sap.mi.gfw.features.impl.AbstractFeature;

/**
 * The Class AbstractPasteFeature.
 */
public abstract class AbstractPasteFeature extends AbstractFeature implements IPasteFeature {

	private static final String NAME = Messages.AbstractPasteFeature_0_xfld;

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public AbstractPasteFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public boolean canExecute(IContext context) {
		boolean ret = false;
		if (context instanceof IPasteContext) {
			ret = canPaste((IPasteContext) context);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		if (context instanceof IPasteContext) {
			paste((IPasteContext) context);
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
	 * Gets the from clipboard.
	 * 
	 * @return the from clipboard
	 */
	protected Object[] getFromClipboard() {
		return ModelClipboard.getDefault().getContentAsRefBaseObjects(getConnection());
	}
}