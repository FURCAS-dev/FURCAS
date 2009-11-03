/**
 * 
 */
package com.sap.mi.gfw.pattern.template;

import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Class CollectionBinder.
 * 
 * @author d023588
 */
public class CollectionBinder {
	private String fromPath, toPath;

	/**
	 * Instantiates a new collection binder.
	 * 
	 * @param domainPath
	 *            the domain path
	 * @param mainShape
	 *            the main shape
	 * @param pe
	 *            the pe
	 */
	public CollectionBinder(String domainPath, Shape mainShape, RefObject pe) {
		this.fromPath = domainPath;
		this.toPath = XPath.calculatePath(mainShape, pe);
	}

	/**
	 * Instantiates a new collection binder.
	 * 
	 * @param domainPath
	 *            the domain path
	 * @param pictogramPath
	 *            the pictogram path
	 */
	public CollectionBinder(String domainPath, String pictogramPath) {
		this.fromPath = domainPath;
		this.toPath = pictogramPath;
	}

	/**
	 * Multiply.
	 * 
	 * @param domainObject
	 *            the domain object
	 * @param mainShape
	 *            the main shape
	 * @param dtp
	 *            the dtp
	 */
	public void multiply(RefObject domainObject, Shape mainShape, IDiagramTypeProvider dtp) {
		Object source = XPath.getValue(domainObject, fromPath);
		if (source instanceof List) {
			List targetList = (List) XPath.getValue(mainShape, removeLastSegment(toPath));

			List sourceList = (List) source;
			for (Iterator iter = sourceList.iterator(); iter.hasNext();) {
				RefObject element = (RefObject) iter.next();
				RefObject graphics = XPath.clone((RefObject) XPath.getValue(mainShape, toPath));
				targetList.add(graphics);
				if (graphics instanceof PictogramElement) {
					dtp.getFeatureProvider().link((PictogramElement) graphics, element);
				}
			}
		}

	}

	private String removeLastSegment(String path) {
		int lastSlash = path.lastIndexOf('/');
		return path.substring(0, lastSlash);
	}

}
