package com.sap.mi.gfw.pattern.template;

import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.mapping.data.ITextDataMapping;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * Implements a binding capability between domain and pictogram model based on XPath paths.
 * 
 * @author d023588 A DataBinder transports checks of data - e.g. a domain attribute - is consistent between the current domain model class
 *         and its visualization in the pictogram model. A single DataBinder is good for a single atomic attribute. If the type on both,
 *         domain and pictogram models is the same, the binder will do the work automatically. If the types are different or if lists must
 *         me mapped, override setValue or setListElementValue.
 */
public class DataBinder implements ITextDataMapping {
	private String fromPath, toPath;

	private boolean directEdit;

	private boolean immediateDirectEdit;

	/**
	 * Creates a binding between domain and pictogram models with partial XPath and target shape. The full XPath for the pictogram model is
	 * automatically calculated from the parameters pictogramProperty, mainShape, and pictogramElement.
	 * 
	 * @param domainPath
	 *            The full XPath from the main domain object to the attribute that should be bound. Example: "@name"
	 * @param pictogramProperty
	 *            The attribute of pictogramElement set should be bound to.
	 * @param mainShape
	 *            The main shape, typically a container shape.
	 * @param directEdit
	 *            Controls of direct editing is enabled for pictogramElement. This only works, if pictogramElement is a Text.
	 * @param immediateDirectEdit
	 *            Controls of direct editing is turned on directly after creating a new pattern. This parameter requires directEdit to be
	 *            true.
	 * @param pictogramElement
	 *            the pictogram element
	 */
	public DataBinder(String domainPath, String pictogramProperty, Shape mainShape, RefObject pictogramElement, boolean directEdit,
			boolean immediateDirectEdit) {
		this.fromPath = domainPath;
		this.toPath = XPath.calculatePath(mainShape, pictogramElement, pictogramProperty);
		this.directEdit = directEdit;
		this.immediateDirectEdit = immediateDirectEdit;
	}

	/**
	 * Instantiates a new data binder.
	 * 
	 * @param domainPath
	 *            the domain path
	 * @param pictogramProperty
	 *            the pictogram property
	 * @param mainShape
	 *            the main shape
	 * @param pe
	 *            the pe
	 */
	public DataBinder(String domainPath, String pictogramProperty, Shape mainShape, RefObject pe) {
		this(domainPath, pictogramProperty, mainShape, pe, false, false);
	}

	/**
	 * Creates a binding between domain and pictogram models with complete XPaths.
	 * 
	 * @param domainPath
	 *            The full XPath from the main domain object to the attribute that should be bound. Example: "@name"
	 * @param pictogramPath
	 *            The full XPath from the main shape to the attribute to be updated. The main shape is typically a ContainerShape, so the
	 *            path must consider child shapes and graphic algorithms associations. Example: "children[0]/graphicsAlgorithm/@value"
	 */
	public DataBinder(String domainPath, String pictogramPath) {
		this.fromPath = domainPath;
		this.toPath = pictogramPath;
	}

	/**
	 * Gets the domain path.
	 * 
	 * @return the domain path
	 */
	public String getDomainPath() {
		return fromPath;
	}

	/**
	 * Gets the pictogram path.
	 * 
	 * @return the pictogram path
	 */
	public String getPictogramPath() {
		return toPath;
	}

	/**
	 * Update.
	 * 
	 * @param source
	 *            the source
	 * @param mainShape
	 *            the main shape
	 */
	public void update(RefObject source, Shape mainShape) {
		Object sourceValue = XPath.getValue(source, fromPath);
		setValue(sourceValue, mainShape, toPath);
	}

	/**
	 * The method called for each entry in the list to assign the corresponding element.
	 * 
	 * @param value
	 *            the value
	 * @param index
	 *            the index
	 * @param elements
	 *            the elements
	 * @param target
	 *            the target
	 * @param targetPath
	 *            the target path
	 */
	protected void setListElementValue(Object value, int index, int elements, Shape target, String targetPath) {
		// Can be overridden
	}

	/**
	 * Assigns a value from the domain model to the pictogram model The setValue method is called to assign the value from the domain model
	 * to the target pictogram model. If the source attribute is a list, the setListElementValue method is called for each entry in the
	 * list. The default implementation simply assigns the value to the target "XPath.setValue(mainShape, toPath, sourceValue);" Override to
	 * customize the behavior.
	 * 
	 * @param sourceValue
	 *            the source value
	 * @param mainShape
	 *            the main shape
	 * @param targetPath
	 *            the target path
	 */
	protected void setValue(Object sourceValue, Shape mainShape, String targetPath) {
		if (sourceValue instanceof List) {
			List listValue = (List) sourceValue;
			for (int i = 0; i < listValue.size(); i++)
				setListElementValue(listValue.get(i), i, listValue.size(), mainShape, toPath);
		} else
			XPath.setValue(mainShape, toPath, sourceValue);
	}

	/**
	 * Needs update.
	 * 
	 * @param source
	 *            the source
	 * @param mainShape
	 *            the main shape
	 * @return true, if successful
	 */
	public boolean needsUpdate(RefObject source, Shape mainShape) {
		Object o1 = XPath.getValue(source, fromPath);
		Object o2 = XPath.getValue(mainShape, toPath);
		if (o1 == null)
			return o2 != null;
		else
			return !isInSynch(o1, o2);

	}

	/**
	 * Checks if the values from domain model and pictogram models are in synch. The default implementation calls "equals".
	 * 
	 * @param domainValue
	 *            the domain value
	 * @param pictogramValue
	 *            the pictogram value
	 * @return true, if is in synch
	 */
	protected boolean isInSynch(Object domainValue, Object pictogramValue) {
		return domainValue.equals(pictogramValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mapping.data.ITextDataMapping#getText(com.sap.mi.gfw.mm.links.PictogramLink)
	 */
	public String getText(PictogramLink link) {
		RefObject domainObject = link.getBusinessObjects().get(0);
		Object o = XPath.getValue(domainObject, this.fromPath);
		if (o instanceof String)
			return (String) o;
		return null;
	}

	/**
	 * Gets the update warning.
	 * 
	 * @param source
	 *            the source
	 * @param mainShape
	 *            the main shape
	 * @return the update warning
	 */
	public String getUpdateWarning(RefObject source, Shape mainShape) {
		if (needsUpdate(source, mainShape))
			return Messages.DataBinder_0_xmsg + " " + this.fromPath + " " + Messages.DataBinder_1_xmsg; //$NON-NLS-1$//$NON-NLS-2$

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.mapping.data.IDataMapping#getUpdateWarning(com.sap.mi.gfw.mm.links.PictogramLink)
	 */
	public String getUpdateWarning(PictogramLink pictogramLink) {
		RefObject domainObject = pictogramLink.getBusinessObjects().get(0);
		Shape shape = (Shape) pictogramLink.getPictogramElement();
		return getUpdateWarning(domainObject, shape);
	}

	/**
	 * Gets the pictogram path without attruibute.
	 * 
	 * @return the pictogram path without attruibute
	 */
	public String getPictogramPathWithoutAttribute() {
		return getPathWithoutAttribute(toPath);
	}

	/**
	 * Gets the domain XPath without attribute.
	 * 
	 * @return the domain XPath without attribute
	 */
	public String getDomainXPathWithoutAttribute() {
		// transform things like "attrA/attrB/@attrC" into "attrA/@attrB"
		String xPath = getPathWithoutAttribute(fromPath);
		int lastSlash = xPath.lastIndexOf('/');
		if (lastSlash > 0) {
			return xPath.substring(0, lastSlash) + "/@" + xPath.substring(lastSlash + 1, xPath.length()); //$NON-NLS-1$
		}
		return "@" + xPath; //$NON-NLS-1$
	}

	private String getPathWithoutAttribute(String path) {
		int lastSlash = path.lastIndexOf('/');
		if (lastSlash > 0) {
			return path.substring(0, lastSlash);
		}
		return path;
	}

	/**
	 * Can direct edit.
	 * 
	 * @return true, if successful
	 */
	public boolean canDirectEdit() {
		return directEdit;
	}

	/**
	 * Can direct edit.
	 * 
	 * @param pictogramPath
	 *            the pictogram path
	 * @return true, if successful
	 */
	public boolean canDirectEdit(String pictogramPath) {
		return directEdit && pictogramPath.equals(getPictogramPathWithoutAttribute());
	}

	/**
	 * Can direct edit.
	 * 
	 * @param mainShape
	 *            the main shape
	 * @param ga
	 *            the ga
	 * @return true, if successful
	 */
	public boolean canDirectEdit(Shape mainShape, GraphicsAlgorithm ga) {
		return canDirectEdit(XPath.calculatePath(mainShape, ga));
	}

	/**
	 * Can immediate direct edit.
	 * 
	 * @return true, if successful
	 */
	public boolean canImmediateDirectEdit() {
		return directEdit && immediateDirectEdit;
	}

}
