/**
 * 
 */
package com.sap.mi.gfw.pattern.template;

import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.LinkUtil;

/**
 * The Class PortAllignBinder.
 * 
 * @author d023588
 */
public class PortAllignBinder extends DataBinder {

	private IFeatureProvider fp;

	/**
	 * The Constructor.
	 * 
	 * @param domainPath
	 *            the domain path
	 * @param pictogramPath
	 *            the pictogram path
	 * @param fp
	 *            the fp
	 */
	public PortAllignBinder(String domainPath, String pictogramPath, IFeatureProvider fp) {
		super(domainPath, pictogramPath);
		this.fp = fp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.template.DataBinder#setListElementValue(java.lang.Object, int, int, com.sap.mi.gfw.mm.pictograms.Shape,
	 *      java.lang.String)
	 */
	@Override
	protected void setListElementValue(Object value, int index, int elements, Shape target, String targetPath) {
		double currentValue = (index + 1) * 1.0 / (elements + 1);
		List<PictogramElement> pes = LinkUtil.getPictogramElements(fp.getDiagramTypeProvider().getDiagramLink(), (RefObject) value);
		XPath.setValue(pes.get(0), targetPath, currentValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.template.DataBinder#needsUpdate(com.sap.tc.moin.repository.mmi.reflect.RefObject, com.sap.mi.gfw.mm.pictograms.Shape)
	 */
	@Override
	public boolean needsUpdate(RefObject source, Shape mainShape) {
		return false;
		// For now we don't try to rearrange ports in there location.
	}

}
