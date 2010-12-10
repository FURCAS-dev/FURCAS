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
package org.eclipse.emf.query2;

/**
 * A where-comparison aliases compares two aliases to each other for equality,
 * where both aliases have to be of the same type.
 */
final public class WhereComparisonAliases extends JoinWhereEntry {

	/*
	 * A where comparison aliases always compares the left-hand side alias with
	 * the right-hand side alias.
	 */
	private String rightAlias;

	/**
	 * Constructs a predicate which compares two aliases for equality. Both
	 * aliases have to be of the same type.
	 * 
	 * @param _leftAlias
	 *            the left alias.
	 * @param _rightAlias
	 *            the right alias.
	 */
	public WhereComparisonAliases(String _leftAlias, String _rightAlias) {

		this.leftAlias = _leftAlias;
		this.rightAlias = _rightAlias;
	}

	/**
	 * Returns the right alias used in the where comparison.
	 * 
	 * @return the right alias used in the where comparison.
	 */
	public String getRightAlias() {

		return this.rightAlias;
	}

	@Override
	protected void toString(StringBuilder sb, int indent) {

		sb.append(this.leftAlias);
		sb.append(" = "); //$NON-NLS-1$
		sb.append(this.rightAlias);
	}
}
