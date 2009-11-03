package com.sap.mi.gfw.features;

import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Interface IMappingProvider.
 */
public interface IMappingProvider {

	/**
	 * Returns all business objects which are linked to the given pictogram element.
	 * 
	 * @param pictogramElement
	 *            The pictogram element for which to return the business objects.
	 * @return The business objects which are linked to the given pictogram element. Can be empty but not null.
	 * @see #link(PictogramElement, Object[])
	 */
	Object[] getAllBusinessObjectsForPictogramElement(PictogramElement pictogramElement);

	/**
	 * Returns the first of possibly several business objects which are linked to the given pictogram element. This is a convenience method
	 * for {@link #getAllBusinessObjectsForPictogramElement(PictogramElement)}, because in many usecases only a single business object is
	 * linked.
	 * 
	 * @param pictogramElement
	 *            The pictogram element for which to return the business object.
	 * @return The first of possibly several business objects which are linked to the given pictogram element. Can be null.
	 * @see #link(PictogramElement, Object)
	 */
	Object getBusinessObjectForPictogramElement(PictogramElement pictogramElement);

	/**
	 * Provides the pictogram elements which represents the given business object.
	 * 
	 * @param businessObject
	 *            the given business object
	 * @return the pictogram elements
	 */
	PictogramElement[] getAllPictogramElementsForBusinessObject(Object businessObject);

	/**
	 * Links the pictogram element with a business object. This deletes all previous links of this pictogram element.
	 * 
	 * @param pictogramElement
	 *            The pictogram element which to link to a new business object.
	 * @param businessObject
	 *            The business object to link. Can be null to just delete previous links.
	 */
	void link(PictogramElement pictogramElement, Object businessObject);

	/**
	 * Links the pictogram element with several business objects. This deletes all previous links of this pictogram element.
	 * 
	 * @param pictogramElement
	 *            The pictogram element which to link to new business objects.
	 * @param businessObject
	 *            The business objects to link. Can be null or empty to just delete previous links.
	 */
	void link(PictogramElement pictogramElement, Object[] businessObjects);

	/**
	 * Check does there have pictogram element linked to this business object.
	 * 
	 * @param businessObject
	 *            the business object
	 * @return true when at least one pictogram element is linked, otherwise return false.
	 */
	boolean hasPictogramElementForBusinessObject(Object businessObject);

	/**
	 * This method is similar to.
	 * 
	 * @param businessObject
	 *            the business object
	 * @return linked pictogram element
	 * @see "getPictogramElementsForBusinessObject(Object businessObject)", but only return the first PictogramElement.
	 */
	PictogramElement getPictogramElementForBusinessObject(Object businessObject);

}