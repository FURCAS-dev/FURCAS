/*
 * Created on 16.11.2005
 */
package com.sap.mi.gfw.features;

/**
 * The Interface IResizeFeature.
 */
public interface IResizeFeature extends IFeature {

	/**
	 * Provides configuration object, which describes the resize behavior
	 * 
	 * @return configuration object
	 */
	IResizeConfiguration getResizeConfiguration();
}
