package com.sap.mi.tools.cockpit.editor.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.Assert;

/**
 * @author d003456
 * 
 */
public final class ContainerFragment {

	private ContainerFragment parent = null;

	private final java.util.List<ContainerFragment> children = new ArrayList<ContainerFragment>(1);

	private String name = null;

	private String key = null;

	/**
	 * Creates {@link ContainerFragment}.
	 * 
	 * @param parent
	 *            the parent
	 * @param name
	 *            the partition name
	 */
	public ContainerFragment(ContainerFragment parent, String name) {

		Assert.isNotNull(name);
		this.parent = parent;
		this.name = name;
	}

	public void addChild(ContainerFragment child) {

		this.children.add(child);
	}

	public void addAll(ContainerFragment[] children) {

		if (children.length == 0) {
			return;
		}
		this.children.addAll(Arrays.asList(children));
	}

	public String getName() {

		return this.name;
	}

	public ContainerFragment getParent() {

		return this.parent;
	}

	/**
	 * @return the key
	 */
	public String getKey() {

		return this.key;
	}

	/**
	 * @return returns true, if this node is the partition
	 */
	public boolean isLeaf() {

		final boolean res = false;
		if (this.key != null && this.key.length() > 0) {
			return true;
		}
		return res;

	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {

		this.key = key;
	}

	public ContainerFragment[] getChildren() {

		Collections.sort(this.children, new ContainerFragmentComparator());
		return this.children.toArray(new ContainerFragment[this.children.size()]);

	}

	public List<ContainerFragment> getCompactedChildren() {

		final List<ContainerFragment> containerFragments = new ArrayList<ContainerFragment>();
		int i = 0;
		for (final ContainerFragment child : this.children) {
			if (child.getChildren().length == 1) {
				ContainerFragment depth = child;
				String newName = child.getName();
				while (depth.getChildren().length == 1) {
					if (depth.getChildren()[0].getChildren().length == 0) {
						break;
					}
					depth = depth.getChildren()[0];
					newName = newName + "/" + depth.getName(); //$NON-NLS-1$
				}
				final ContainerFragment compacted = new ContainerFragment(this, newName);
				compacted.addAll(depth.getChildren());
				containerFragments.add(compacted);
			}
			else {
				containerFragments.add(child);
			}
			i++;
		}

		Collections.sort(containerFragments, new ContainerFragmentComparator());
		return containerFragments;

	}

	public void insertNewString(String value, String key) {

		if (value == null || "".equals(value)) { //$NON-NLS-1$
			return;
		}
		final int index = value.indexOf('/');
		if (index < 0) { // No more children
			final ContainerFragment leaf = new ContainerFragment(this, value);
			leaf.setKey(key);
			this.addChild(leaf);
			return;
		}
		final String nodeName = value.substring(0, index);
		final String remainder = value.substring(index + 1);
		ContainerFragment child = this.findChild(nodeName);
		if (child != null) {
			child.insertNewString(remainder, key);
		}
		else {
			child = new ContainerFragment(this, nodeName);
			child.insertNewString(remainder, key);
			this.addChild(child);
		}

	}

	private ContainerFragment findChild(String name) {

		for (final ContainerFragment child : this.children) {
			if (name.equals(child.getName())) {
				return child;
			}
		}
		return null;

	}

	@Override
	public String toString() {

		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ContainerFragment))
			return false;
		final ContainerFragment other = (ContainerFragment) obj;
		if (this.name == null) {
			if (other.name != null)
				return false;
		}
		else if (!this.name.equals(other.name))
			return false;
		return true;
	}

	private static class ContainerFragmentComparator implements Comparator<ContainerFragment>, Serializable  {

		private static final long serialVersionUID = -2015581078826759233L;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(ContainerFragment o1, ContainerFragment o2) {

			if (o1.getChildren().length != 0 && o2.getChildren().length == 0) {
				return 1;
			}
			if (o1.getChildren().length == 0 && o2.getChildren().length != 0) {
				return -1;
			}
			return o1.getName().compareTo(o2.getName());

		}

	}
}
