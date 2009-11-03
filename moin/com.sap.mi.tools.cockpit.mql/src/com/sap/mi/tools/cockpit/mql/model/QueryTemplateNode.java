package com.sap.mi.tools.cockpit.mql.model;

/**
 * @author d003456
 * 
 */
public final class QueryTemplateNode {

	private String templateName;

	private String query;

	private TEMPLATE_TYPE templateType;

	private ArtificialRootNode parent;

	private final Model model;

	/**
	 * Creates {@link QueryTemplateNode}.
	 * 
	 * @param templateName
	 * @param query
	 */
	public QueryTemplateNode(String templateName, String query, TEMPLATE_TYPE templateType) {

		this.templateName = templateName;
		this.query = query;
		this.templateType = templateType;
		this.model = Model.getInstance();
	}

	/**
	 * Sets the ArtificialRootNode parent.
	 * 
	 * @param parent
	 *            ArtificialRootNode parent
	 */
	public void setParent(ArtificialRootNode parent) {

		this.parent = parent;
	}

	/**
	 * Returns the ArtificialRootNode parent.
	 * 
	 * @return the ArtificialRootNode parent
	 */
	public ArtificialRootNode getParent() {

		return this.parent;
	}

	/**
	 * @return the templateName
	 */
	public String getTemplateName() {

		return this.templateName;
	}

	/**
	 * @param templateName
	 *            the templateName to set
	 */
	public void setTemplateName(String templateName) {

		this.templateName = templateName;
		this.model.fireModelChanged(this, OP.MODIFIED);
	}

	/**
	 * @return the query
	 */
	public String getQuery() {

		return this.query;
	}

	/**
	 * @param query
	 *            the query to set
	 */
	public void setQuery(String query) {

		this.query = query;
		this.model.fireModelChanged(this, OP.MODIFIED);
	}

	/**
	 * @return the templateType
	 */
	public TEMPLATE_TYPE getTemplate_Type() {

		return this.templateType;
	}

	/**
	 * @param templateType
	 *            the templateType to set
	 */
	public void setTemplate_Type(TEMPLATE_TYPE templateType) {

		this.templateType = templateType;
		this.model.fireModelChanged(this, OP.MODIFIED);
	}

}
