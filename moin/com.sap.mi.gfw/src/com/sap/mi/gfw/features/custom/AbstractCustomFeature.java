/*
 * Created on 12.12.2005
 */
package com.sap.mi.gfw.features.custom;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.impl.AbstractFeature;
import com.sap.mi.gfw.util.T;

/**
 * The Class AbstractCustomFeature.
 */
public abstract class AbstractCustomFeature extends AbstractFeature implements ICustomFeature {

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public AbstractCustomFeature(IFeatureProvider fp) {
		super(fp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.custom.ICustomFeature#getDescription()
	 */
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return ""; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.custom.ICustomFeature#canExecute(com.sap.mi.gfw.features.context.ICustomContext)
	 */
	public boolean canExecute(ICustomContext context) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.custom.ICustomFeature#isAvailable(com.sap.mi.gfw.features.context.ICustomContext)
	 */
	@Override
	public boolean isAvailable(IContext context) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#canExecute(com.sap.mi.gfw.features.context.IContext)
	 */
	public final boolean canExecute(IContext context) {
		final String SIGNATURE = "canExecute(IContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractCustomFeature.class, SIGNATURE, new Object[] { context });
		}
		boolean ret = false;
		if (context instanceof ICustomContext) {
			ret = canExecute((ICustomContext) context);
		}
		if (info) {
			T.racer().exiting(AbstractCustomFeature.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeature#execute(com.sap.mi.gfw.features.context.IContext)
	 */
	public void execute(IContext context) {
		final String SIGNATURE = "execute(IContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractCustomFeature.class, SIGNATURE, new Object[] { context });
		}
		if (context instanceof ICustomContext) {
			ICustomContext customContext = (ICustomContext) context;
			execute(customContext);
		}
		if (info) {
			T.racer().exiting(AbstractCustomFeature.class, SIGNATURE);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.custom.ICustomFeature#getImageId()
	 */
	public String getImageId() {
		return null;
	}

}