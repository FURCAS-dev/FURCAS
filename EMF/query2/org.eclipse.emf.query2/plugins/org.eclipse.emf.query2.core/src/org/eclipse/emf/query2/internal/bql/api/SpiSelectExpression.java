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

import org.eclipse.emf.query2.internal.index.SpiFacilityQueryServiceException;

/**
 * Select expression for model elements and selected primitive attributes.
 */
public final class SpiSelectExpression {

	/**
	 * cluster from which we select
	 */
	private SpiModelElementClusterExpression modelElementClusterExpression;

	/**
	 * select lists over the cluster
	 */
	private SpiSelectList[] selectLists;

	public SpiSelectExpression(SpiModelElementClusterExpression modelElementClusterExpression, SpiSelectList[] selectLists) {

		if (modelElementClusterExpression == null) {
			throw new SpiFacilityQueryServiceException(SpiFacilityQueryServiceException.ERROR_CODE_UNSPECIFIED,
					BQLBugMessages.MODELELEMENTEXPRESSION_MUST_NOT_BE_NULL);
		}

		this.modelElementClusterExpression = modelElementClusterExpression;
		this.selectLists = selectLists;
	}

	/**
	 * @return Returns the cluster.
	 */
	public SpiModelElementClusterExpression getModelElementClusterExpression() {

		return this.modelElementClusterExpression;
	}

	/**
	 * @return Returns the selectLists.
	 */
	public SpiSelectList[] getSelectLists() {

		return selectLists;
	}

	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();
		this.toString(sb, 0);
		return sb.toString();
	}

	/**
     *
     */
	@SuppressWarnings("nls")
	private void toString(StringBuffer sb, int ident) {

		SpiUtils.toStringNewLine(sb, ident);
		sb.append(SpiUtils.OPENING_PARENTHESES);
		sb.append(SpiUtils.SELECT);
		sb.append(": "); //$NON-NLS-1$
		this.modelElementClusterExpression.toString(sb, ident + 1, true);
		sb.append(',');
		SpiUtils.toStringNewLine(sb, ident + 1);
		if (this.selectLists != null && this.selectLists.length > 0) {
			sb.append(SpiUtils.SELECT_LIST);
			sb.append(": "); //$NON-NLS-1$
			for (int i = 0; i < this.selectLists.length - 1; i++) {
				this.selectLists[i].toString(sb, ident + 2, true);
				sb.append(',');
			}
			this.selectLists[this.selectLists.length - 1].toString(sb, ident + 2, true);
		}
		SpiUtils.toStringNewLine(sb, ident);
		sb.append(SpiUtils.CLOSING_PARENTHESES);
	}

}
