package com.sap.mi.tools.cockpit.mql.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Artificial root node, for easier root representation.
 * 
 */
public final class ArtificialRootNode {

	private final static String EXCEPTION_NOT_IN_LIST = "Node not found in List<QueryTemplateNode> children"; //$NON-NLS-1$

	private List<QueryTemplateNode> children;

	private final Model model;

	/**
	 * Constructor
	 */
	public ArtificialRootNode() {

		this.children = new ArrayList<QueryTemplateNode>();
		this.model = Model.getInstance();
	}

	/**
	 * @return Returns the children.
	 */
	public List<QueryTemplateNode> getChildren() {

		return this.children;
	}

	/**
	 * @return Returns the children.size > 0
	 */
	public boolean hasChildren() {

		return this.children.size() > 0;
	}

	/**
	 * @param children
	 *            The QueryTemplate children to set.
	 */
	public void setChildren(List<QueryTemplateNode> children) {

		this.children = children;
	}

	/**
	 * @param child
	 */
	public void addChildren(QueryTemplateNode child) {

		this.children.add(child);
		this.model.fireModelChanged(child, OP.ADDED);
	}

	/**
	 * @param child
	 */
	public void removeChildren(QueryTemplateNode child) {

		if (this.children.contains(child)) {
			this.children.remove(child);
			this.model.fireModelChanged(child, OP.DELETED);
		}
	}

	public void moveUp(QueryTemplateNode node) {

		final int index = this.children.indexOf(node);
		if (index == 0) {
			this.children.remove(index);
			this.children.add(node);
			this.model.fireModelChanged(node, OP.ADDED);
		} else if (index > 0) {
			this.children.remove(index);
			this.children.add(index - 1, node);
			this.model.fireModelChanged(node, OP.ADDED);
		} else if (index == -1) {
			throw new IllegalStateException(ArtificialRootNode.EXCEPTION_NOT_IN_LIST);
		}
	}

	public void moveDown(QueryTemplateNode node) {

		final int index = this.children.indexOf(node);
		if (index == this.children.size() -1) {
			this.children.remove(index);
			this.children.add(0, node);
			this.model.fireModelChanged(node, OP.ADDED);
		} else if (index > -1) {
			this.children.remove(index);
			this.children.add(index +1, node);
			this.model.fireModelChanged(node, OP.ADDED);
		} else if (index == -1) {
			throw new IllegalStateException(ArtificialRootNode.EXCEPTION_NOT_IN_LIST);
		}
	}
}
