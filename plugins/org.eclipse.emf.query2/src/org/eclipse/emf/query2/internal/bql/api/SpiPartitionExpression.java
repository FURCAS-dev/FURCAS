/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.bql.api;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

/**
 * Partition search criterion. A partition expression contains the information
 * whether selected objects belong to certain partitions or not.
 */
public final class SpiPartitionExpression {

	// partition list containing the MRIs of the partitions that shall be included or excluded.
	// An empty partition list means there are no restrictions regarding the partitions.
	private URI[] partitionList;

	private Set<URI> partitionSet;

	// if isIncludeList is true then partitionList is an include list otherwise an exclude list.
	private boolean isIncludeList;

	/**
	 * Constructs partition expression. If partitionList is empty or null then
	 * this PartitionExpression expresses that there are no partition
	 * restrictions. If isIncludeList is true then partitionList has the meaning
	 * of a partition include list, otherwise partitionList has the meaning of
	 * an partition exclude list
	 */
	public SpiPartitionExpression(URI[] partitionList, boolean isIncludeList) {

		this.partitionList = partitionList;
		this.partitionSet = null;

		if (partitionList != null && partitionList.length > 0) {
			this.partitionSet = new HashSet<URI>(partitionList.length);
			for (int i = 0; i < partitionList.length; i++) {
				this.partitionSet.add(partitionList[i]);
			}
		}
		this.isIncludeList = isIncludeList;
	}

	/**
	 * Gets the partition list. If the list is null then there is no partition
	 * restriction.
	 * 
	 * @return the partition list.
	 */
	public URI[] getPartitionList() {

		return this.partitionList;
	}

	/**
	 * Gets the partition set. If the set is null then there is no partition
	 * restriction.
	 * 
	 * @return the partition lset.
	 */
	public Set<URI> getPartitionSet() {

		if (this.partitionSet == null) {
			return new HashSet<URI>(0);
		} else {
			return this.partitionSet;
		}
	}

	/**
	 * @return the isIncludeList flag.
	 */
	public boolean isIncludeList() {

		return this.isIncludeList;
	}

	/**
     *
     */
	@SuppressWarnings("nls")
	public void toString(StringBuffer sb, int ident, boolean newline) {

		if (newline) {
			SpiUtils.toStringNewLine(sb, ident);
		}
		sb.append(SpiUtils.OPENING_PARENTHESES);
		sb.append(SpiUtils.PARTITIONS);
		sb.append(": ");
		if (this.partitionList != null) {
			if (this.isIncludeList) {
				sb.append(SpiUtils.INCLUDE_LIST);
			} else {
				sb.append(SpiUtils.EXCLUDE_LIST);
			}
			sb.append(SpiUtils.OPENING_PARENTHESES);
			for (int i = 0; i < this.partitionList.length; i++) {
				if (i > 0) {
					sb.append(',');
				}
				sb.append(SpiUtils.uriIdForPrinting(this.partitionList[i]));
			}
			sb.append(SpiUtils.CLOSING_PARENTHESES);
		}
		sb.append(SpiUtils.CLOSING_PARENTHESES);
	}

}
