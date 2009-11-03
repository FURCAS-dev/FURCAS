package com.sap.mi.gfw.pattern;

import com.sap.mi.gfw.features.context.IConnectionContext;
import com.sap.mi.gfw.features.context.ICreateConnectionContext;
import com.sap.mi.gfw.features.context.impl.AddConnectionContext;
import com.sap.mi.gfw.features.context.impl.LayoutContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.mapping.IStructureMapping;
import com.sap.mi.gfw.mapping.data.IDataMapping;
import com.sap.mi.gfw.mapping.data.ITextDataMapping;
import com.sap.mi.gfw.mm.datatypes.Color;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.IColorConstant;

/**
 * The Class AbstractConnectionPattern.
 */
public abstract class AbstractConnectionPattern extends AbstractBasePattern implements IConnectionPattern {

	/**
	 * Gets the adds the connection context.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return the adds the connection context
	 */
	protected static AddConnectionContext getAddConnectionContext(ICreateConnectionContext context) {
		AddConnectionContext result = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
		return result;
	}

	/**
	 * Instantiates a new abstract connection pattern.
	 */
	public AbstractConnectionPattern() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.ICreateConnectionFeature#canCreate(com.sap.mi.gfw.features.context.ICreateConnectionContext)
	 */
	public boolean canCreate(ICreateConnectionContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.ICreateConnectionFeature#canStartConnection(com.sap.mi.gfw.features.context.ICreateConnectionContext)
	 */
	public boolean canStartConnection(ICreateConnectionContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.ICreateConnectionFeature#create(com.sap.mi.gfw.features.context.ICreateConnectionContext)
	 */
	public Connection create(ICreateConnectionContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Adds the graphical representation.
	 * 
	 * @param context
	 *            the context
	 * @param newObject
	 *            the new object
	 * 
	 * @return the connection
	 */
	protected Connection addGraphicalRepresentation(IConnectionContext context, Object newObject) {
		AddConnectionContext newContext = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
		newContext.setNewObject(newObject);
		return (Connection) getFeatureProvider().addIfPossible(newContext);
	}

	/**
	 * Gets the text.
	 * 
	 * @param structureMapping
	 *            the structure mapping
	 * @param link
	 *            the link
	 * 
	 * @return the text
	 */
	protected String getText(IStructureMapping structureMapping, PictogramLink link) {
		String ret = null;
		IDataMapping dm = structureMapping.getDataMapping();
		if (dm instanceof ITextDataMapping) {
			ret = ((ITextDataMapping) dm).getText(link);
		}
		return ret;
	}

	/**
	 * Layout pictogram element.
	 * 
	 * @param pe
	 *            the pe
	 */
	protected void layoutPictogramElement(PictogramElement pe) {
		LayoutContext context = new LayoutContext(pe);
		getFeatureProvider().layoutIfPossible(context);
	}

	/**
	 * Manage color.
	 * 
	 * @param colorConstant
	 *            the color constant
	 * 
	 * @return the color
	 */
	protected Color manageColor(IColorConstant colorConstant) {
		return GaUtil.manageColor(getFeatureProvider().getDiagramTypeProvider().getDiagram(), colorConstant);
	}

	/**
	 * Manage color.
	 * 
	 * @param red
	 *            the red
	 * @param green
	 *            the green
	 * @param blue
	 *            the blue
	 * 
	 * @return the color
	 */
	protected Color manageColor(int red, int green, int blue) {
		return GaUtil.manageColor(getFeatureProvider().getDiagramTypeProvider().getDiagram(), red, green, blue);
	}

	/**
	 * Update pictogram element.
	 * 
	 * @param pe
	 *            the pe
	 */
	protected void updatePictogramElement(PictogramElement pe) {
		UpdateContext context = new UpdateContext(pe);
		getFeatureProvider().updateIfPossible(context);
		layoutPictogramElement(pe);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ICreateInfo#getCreateDescription()
	 */
	public String getCreateDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ICreateInfo#getCreateImageId()
	 */
	public String getCreateImageId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCreateLargeImageId() {
		return getCreateImageId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.ICreateInfo#getCreateName()
	 */
	public String getCreateName() {
		// TODO Auto-generated method stub
		return null;
	}
}
