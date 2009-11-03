package com.sap.mi.gfw.internal;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.links.DiagramLink;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObjectAdapter;

/**
 * The Class ExternalPictogramLink.
 */
public class ExternalPictogramLink extends RefBaseObjectAdapter implements PictogramLink {

	private PictogramElement pictogramElement;

	private DiagramLink diagramLink;

	/**
	 * The Constructor.
	 */
	public ExternalPictogramLink() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mm.links.PictogramLink#getBusinessObjects()
	 */
	public List<com.sap.tc.moin.repository.mmi.reflect.RefObject> getBusinessObjects() throws JmiException {
		throw new UnsupportedOperationException("Please use DataMapping.getBusinessObject(PictogramLink link)"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mm.links.PictogramLink#getDiagramLink()
	 */
	public DiagramLink getDiagramLink() throws JmiException {
		return diagramLink;
	}

	/**
	 * Gets the location.
	 * 
	 * @return the location
	 * 
	 * @throws JmiException
	 *             the jmi exception
	 */
	public Point getLocation() throws JmiException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mm.links.PictogramLink#getPictogramElement()
	 */
	public PictogramElement getPictogramElement() throws JmiException {
		return pictogramElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mm.links.PictogramLink#setDiagramLink(com.sap.mi.gfw.mm.links.DiagramLink)
	 */
	public void setDiagramLink(DiagramLink newValue) throws JmiException {
		diagramLink = newValue;
	}

	/**
	 * Sets the location.
	 * 
	 * @param newValue
	 *            the new location
	 * 
	 * @throws JmiException
	 *             the jmi exception
	 */
	public void setLocation(Point newValue) throws JmiException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mm.links.PictogramLink#setPictogramElement(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public void setPictogramElement(PictogramElement newValue) throws JmiException {
		pictogramElement = newValue;
	}

	/**
	 * Gets the height.
	 * 
	 * @return the height
	 * 
	 * @throws JmiException
	 *             the jmi exception
	 */
	public int getHeight() throws JmiException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mm.pictograms.PropertyContainer#getProperties()
	 */
	public Collection getProperties() throws JmiException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the width.
	 * 
	 * @return the width
	 * 
	 * @throws JmiException
	 *             the jmi exception
	 */
	public int getWidth() throws JmiException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Sets the height.
	 * 
	 * @param newValue
	 *            the new height
	 * 
	 * @throws JmiException
	 *             the jmi exception
	 */
	public void setHeight(int newValue) throws JmiException {
		// TODO Auto-generated method stub

	}

	/**
	 * Sets the width.
	 * 
	 * @param newValue
	 *            the new width
	 * 
	 * @throws JmiException
	 *             the jmi exception
	 */
	public void setWidth(int newValue) throws JmiException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refClass()
	 */
	public RefClass refClass() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refDelete()
	 */
	public void refDelete() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refImmediateComposite()
	 */
	public RefFeatured refImmediateComposite() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refIsInstanceOf(com.sap.tc.moin.repository.mmi.reflect.RefObject, boolean)
	 */
	public boolean refIsInstanceOf(RefObject objType, boolean considerSubtypes) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefObject#refOutermostComposite()
	 */
	public RefFeatured refOutermostComposite() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refGetValue(com.sap.tc.moin.repository.mmi.reflect.RefObject)
	 */
	public Object refGetValue(RefObject feature) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refGetValue(java.lang.String)
	 */
	public Object refGetValue(String featureName) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refInvokeOperation(com.sap.tc.moin.repository.mmi.reflect.RefObject, java.util.List)
	 */
	public Object refInvokeOperation(RefObject requestedOperation, List args) throws RefException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refInvokeOperation(java.lang.String, java.util.List)
	 */
	public Object refInvokeOperation(String requestedOperation, List args) throws RefException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refSetValue(com.sap.tc.moin.repository.mmi.reflect.RefObject, java.lang.Object)
	 */
	public void refSetValue(RefObject feature, Object value) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refSetValue(java.lang.String, java.lang.Object)
	 */
	public void refSetValue(String featureName, Object value) {
		// TODO Auto-generated method stub

	}

}
