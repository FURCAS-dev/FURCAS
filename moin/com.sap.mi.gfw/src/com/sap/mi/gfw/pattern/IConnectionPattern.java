package com.sap.mi.gfw.pattern;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.func.IAdd;
import com.sap.mi.gfw.func.ICreateConnection;

/**
 * The Interface IConnectionPattern.
 */
public interface IConnectionPattern extends IAdd, ICreateConnection {

	/**
	 * Sets the feature provider.
	 * 
	 * @param fp
	 *            the new feature provider
	 */
	void setFeatureProvider(IFeatureProvider fp);

}
