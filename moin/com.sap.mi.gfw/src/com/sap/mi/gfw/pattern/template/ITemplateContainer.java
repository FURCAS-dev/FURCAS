package com.sap.mi.gfw.pattern.template;

/**
 * The Interface ITemplateContainer.
 */
public interface ITemplateContainer {

	/**
	 * Call this method from <tt>TemplatePattern.buildVisualTree()</tt> to add a new DataBinder that connect a domain metamodel attribute
	 * with a pictogramm MM attribute.
	 * 
	 * @param elementBinder
	 *            the element binder
	 */
	public void addDataBinder(DataBinder elementBinder);

	/**
	 * Adds the layout binder.
	 * 
	 * @param posBinder
	 *            the pos binder
	 */
	public void addLayoutBinder(LayoutBinder posBinder);

	/**
	 * Adds the nested template pattern.
	 * 
	 * @param nested
	 *            the nested
	 */
	public void addNestedTemplatePattern(TemplatePattern nested);

}
