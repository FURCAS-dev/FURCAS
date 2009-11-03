package com.sap.mi.gfw.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.internal.ExternalPictogramLink;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.links.DiagramLink;
import com.sap.mi.gfw.mm.links.DiagramLinkReferencesDiagram;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Property;

/**
 * The Class LinkUtil.
 */
public class LinkUtil {

	private static long cumulativeTime = 0; // just for performance tracing
	private static int cumulativeCalls = 0; // just for performance tracing

	// property-key for the property of a pictgram-element which is part of a
	// link-object and the business-object(s) of the link-object is not unique
	private static final String KEY_LINK_PROPERTY = "keyLinkProperty"; //$NON-NLS-1$

	private static final String KEY_INDEPENDENT_PROPERTY = "independentObject"; //$NON-NLS-1$

	/**
	 * Assign to diagram.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param object
	 *            the object
	 */
	public static void assignToDiagram(Diagram diagram, RefObject object) {
		PictogramLink link = getLinkForPictogramElement(diagram);
		if (link == null) {
			link = (PictogramLink) PackageUtil.getLinksPackage(diagram).getPictogramLink().refCreateInstance();
			getDiagramLink(diagram, true).getPictogramLinks().add(link);
		}
		link.setPictogramElement(diagram);
		MoinHelper.assignSamePartition(link, diagram);

		link.getBusinessObjects().add(object);
	}

	/**
	 * Returns all business objects which are linked to the given pictogram element.
	 * 
	 * @param pictogramElement
	 *            The pictogram element for which to return the business objects.
	 * @return The business objects which are linked to the given pictogram element. Can be empty but not null.
	 * @see #link(PictogramElement, Object[])
	 */
	public static RefObject[] getAllBusinessObjectsForLinkedPictogramElement(PictogramElement pictogramElement) {
		RefObject[] ret = new RefObject[0];
		if (pictogramElement != null && MoinHelper.isObjectAlive(pictogramElement)) {
			PictogramLink pl = LinkUtil.getLinkForPictogramElement(pictogramElement);
			if (pl != null && (!(pl instanceof ExternalPictogramLink)) && MoinHelper.isObjectAlive(pl)) {
				List<RefObject> boList = pl.getBusinessObjects();
				if (boList != null && boList.size() > 0) {
					ret = boList.toArray(new RefObject[boList.size()]);
				}
			}
		}
		return ret;
	}

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
	public static RefObject getBusinessObjectForLinkedPictogramElement(PictogramElement pictogramElement) {
		RefObject ret = null;
		RefObject refObject[] = getAllBusinessObjectsForLinkedPictogramElement(pictogramElement);
		if (refObject != null && refObject.length > 0) {
			ret = refObject[0];
		}
		return ret;
	}

	/**
	 * Gets the diagram link.
	 * 
	 * @param diagram
	 *            the diagram
	 * @return the diagram link
	 * @deprecated use getDiagramLink(Diagram diagram, boolean createIfNotYetThere) instead
	 */
	@Deprecated
	public static DiagramLink getDiagramLink(Diagram diagram) {
		return getDiagramLink(diagram, true);
	}

	/**
	 * Gets the diagram link.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param createIfNotYetThere
	 *            create if not yet there
	 * @return the diagram link
	 */
	public static DiagramLink getDiagramLink(Diagram diagram, boolean createIfNotYetThere) {
		DiagramLinkReferencesDiagram diagramLinkReferencesDiagram = PackageUtil.getLinksPackage(diagram).getDiagramLinkReferencesDiagram();
		DiagramLink ret = diagramLinkReferencesDiagram.getLink(diagram);
		if (ret == null && createIfNotYetThere) {
			ret = createDiagramLink(diagram);
		}
		return ret;
	}

	/**
	 * Returns the pictogram link referencing the given pictogram element.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * @return the pictogram link referencing the given pictogram element
	 */
	public static PictogramLink getLinkForPictogramElement(PictogramElement pictogramElement) {
		long start = System.currentTimeMillis();

		PictogramLink ret = null;

		if (pictogramElement != null && MoinHelper.isObjectAlive(pictogramElement)) {
			ret = pictogramElement.getLink();
		}

		if (T.racer().info()) {
			long end = System.currentTimeMillis();
			long time = (end - start);
			cumulativeTime += time;
			cumulativeCalls++;
			double averageTime = (double) cumulativeTime / (double) cumulativeCalls;
			String averageTimeString = new DecimalFormat("0.000").format(averageTime); //$NON-NLS-1$
			T.racer().info("LinkUtil.getLinkForPictogramElement() took " + time + " ms (cumulative: " + cumulativeTime + " ms for " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ cumulativeCalls + " calls; average: " + averageTimeString + " ms/call)"); //$NON-NLS-1$ //$NON-NLS-2$
			T.racer().info("LinkUtil.getLinkForPictogramElement() average time: " + averageTimeString + " ms/call)"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		if (ret == null) {
			Property independentProperty = getIndependentProperty(pictogramElement);
			if (independentProperty != null) {
				ret = new ExternalPictogramLink();
				ret.setPictogramElement(pictogramElement);
			}
		}

		return ret;
	}

	/**
	 * get all pictogram elements which references the given refObject.
	 * 
	 * @param refObject
	 *            the ref object
	 * @param diagramLink
	 *            the diagram link
	 * @return the pictogram elements
	 */
	public static List<PictogramElement> getPictogramElements(DiagramLink diagramLink, RefObject refObject) {
		List<PictogramElement> ret = new ArrayList<PictogramElement>();
		if (refObject != null && MoinHelper.isObjectAlive(refObject)) {
			Collection<PictogramLink> links = diagramLink.getPictogramLinks();
			for (PictogramLink link : links) {
				RefObject bo = getBusinessObjectForLinkedPictogramElement(link.getPictogramElement());
				if (refObject.equals(bo)) {
					ret.add(link.getPictogramElement());
				}
			}
		}
		return ret;
	}

	/**
	 * Gets the pictogram elements.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param refObjects
	 *            business objects
	 * @param onlyActive
	 *            if true, then only active pictogram elements of the diagram will be considered; if false all pictogram elements will be
	 *            considered
	 * @return all (active) pictogram elements in the diagram, which have at least one reference to one of the business objects
	 */
	public static List<PictogramElement> getPictogramElements(Diagram diagram, List<RefObject> refObjects, boolean onlyActive) {
		List<PictogramElement> ret = new ArrayList<PictogramElement>();
		if (diagram != null && refObjects != null && refObjects.size() > 0) {
			DiagramLink diagramLink = getDiagramLink(diagram, true);
			if (diagramLink != null) {
				Collection<PictogramLink> links = diagramLink.getPictogramLinks();
				for (PictogramLink link : links) {
					PictogramElement pe = link.getPictogramElement();
					if (!onlyActive || pe.isActive()) {
						RefObject[] bos = getAllBusinessObjectsForLinkedPictogramElement(pe);
						for (RefObject bo : bos) {
							if (refObjects.contains(bo)) {
								ret.add(pe);
								break;
							}
						}
					}
				}
			}
		}
		return ret;
	}

	/**
	 * Checks existence and value of a property to a given pictogram element. It is intended to use this property to be able to disinguish
	 * multiple pictogram elements linked to same domain model element.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * @param propertyValue
	 *            the value to check against the property
	 * @return true if property exists an has the given value; false if not
	 */
	public static boolean hasLinkProperty(PictogramElement pictogramElement, String propertyValue) {
		boolean ret = false;
		if (pictogramElement != null && propertyValue != null) {
			Property property = getLinkProperty(pictogramElement);
			if (property != null) {
				if (propertyValue.equals(property.getValue())) {
					ret = true;
				}
			}
		}
		return ret;
	}

	/**
	 * Adds or modifies a property to a given pictogram element. It is intended to use this property to be able to disinguish multiple
	 * pictogram elements linked to same domain model element.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * @param propertyValue
	 *            the new property value
	 */
	public static void setLinkProperty(PictogramElement pictogramElement, String propertyValue) {
		PeUtil.setPropertyValue(pictogramElement, KEY_LINK_PROPERTY, propertyValue);
	}

	/**
	 * Gets the link property.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * @return the link property
	 */
	public static Property getLinkProperty(PictogramElement pictogramElement) {
		return PeUtil.getProperty(pictogramElement, KEY_LINK_PROPERTY);
	}

	/**
	 * Sets the independent property.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * @param propertyValue
	 *            the property value
	 */
	public static void setIndependentProperty(PictogramElement pictogramElement, String propertyValue) {
		PeUtil.setPropertyValue(pictogramElement, KEY_INDEPENDENT_PROPERTY, propertyValue);
	}

	/**
	 * Gets the independent property.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * @return the independent property
	 */
	public static Property getIndependentProperty(PictogramElement pictogramElement) {
		return PeUtil.getProperty(pictogramElement, KEY_INDEPENDENT_PROPERTY);
	}

	/**
	 * Checks for independent property.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * @param propertyValue
	 *            the property value
	 * @return true, if successful
	 */
	public static boolean hasIndependentProperty(PictogramElement pictogramElement, String propertyValue) {
		boolean ret = false;
		if (pictogramElement != null && propertyValue != null) {
			Property property = getIndependentProperty(pictogramElement);
			if (property != null) {
				if (propertyValue.equals(property.getValue())) {
					ret = true;
				}
			}
		}
		return ret;
	}

	private static DiagramLink createDiagramLink(Diagram diagram) {
		DiagramLink ret;
		ret = (DiagramLink) PackageUtil.getLinksPackage(diagram).getDiagramLink().refCreateInstance();
		ret.setDiagram(diagram);
		MoinHelper.assignSamePartition(ret, diagram);
		return ret;
	}

	/**
	 * Remove from diagram.
	 * 
	 * @param object
	 *            the object
	 */
	public static void removeFromRefObject(Diagram diagram, RefObject object) {
		PictogramLink link = getLinkForPictogramElement(diagram);
		link.getBusinessObjects().remove(object);
	}
}
