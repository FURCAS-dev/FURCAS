package com.sap.mi.gfw.pattern;

import com.sap.mi.gfw.features.IDirectEditingInfo;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IResizeConfiguration;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.func.IAdd;
import com.sap.mi.gfw.func.ICreate;
import com.sap.mi.gfw.func.ILayout;
import com.sap.mi.gfw.func.IMoveShape;
import com.sap.mi.gfw.func.IResizeShape;
import com.sap.mi.gfw.func.IUpdate;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Interface IPattern.
 */
public interface IPattern extends ICreate, IAdd, IUpdate, ILayout, IResizeShape, IMoveShape {

	/**
	 * Gets the create name.
	 * 
	 * @return name for UI representation
	 */
	String getCreateName();

	/**
	 * Gets the create description.
	 * 
	 * @return description for UI representation
	 */
	String getCreateDescription();

	// *************************************************************
	// others
	// *************************************************************
	/**
	 * Sets the feature provider.
	 * 
	 * @param fp
	 *            the new feature provider
	 */
	void setFeatureProvider(IFeatureProvider fp);

	/**
	 * This method must be implemented by the pattern user. The main pictogram element of the pattern is linked with the main business
	 * object.
	 * 
	 * @param mainBusinessObject
	 *            the main business object
	 * 
	 * @return True, if this pattern is responsible for the main business object
	 */
	boolean isMainBusinessObjectApplicable(Object mainBusinessObject);

	/**
	 * Complete info.
	 * 
	 * @param info
	 *            the info
	 * @param bo
	 *            the bo
	 */
	void completeInfo(IDirectEditingInfo info, Object bo);

	/**
	 * Complete info.
	 * 
	 * @param info
	 *            the info
	 * @param bo
	 *            the bo
	 * @param keyProperty
	 *            the key property
	 */
	void completeInfo(IDirectEditingInfo info, Object bo, String keyProperty);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IAdd#add(com.sap.mi.gfw.features.context.IAddContext)
	 */
	public PictogramElement add(IAddContext context);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IAdd#canAdd(com.sap.mi.gfw.features.context.IAddContext)
	 */
	public boolean canAdd(IAddContext context);

	/**
	 * Provides configuration object, which describes the resize behavior
	 * 
	 * @return configuration object
	 */
	IResizeConfiguration getResizeConfiguration();
}
