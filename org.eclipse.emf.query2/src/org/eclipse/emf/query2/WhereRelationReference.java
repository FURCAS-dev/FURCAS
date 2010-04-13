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
/*
 * Created on 16.02.2006
 */
package org.eclipse.emf.query2;

/**
 * A where-relation defines a where-entry which constrains two aliases to be
 * involved in an association relation.
 */
final public class WhereRelationReference extends JoinWhereEntry {

	/*
	 * A where relation always refers to an alias on its right-hand side as
	 * well.
	 */
	protected String rightAlias;

	/*
	 * The feature which encodes the association (this is a reference or
	 * attribute of a class-level attribute).
	 */
	private String featureName;

	/**
	 * This predicate is true whenever the right alias represents a model
	 * element, which is equal to the provided class-typed feature value, i.e.
	 * attribute or reference. For an association, if no reference exists and if
	 * there is no ambiguity, it is also allowed to use the association-end on
	 * the other side. In case of ambiguity, use {@link WhereRelationAssoc}. If
	 * the multiplicity <> 1, then the predicate is true whenever the equality
	 * holds for at least one element of the collection.
	 * 
	 * @param _leftAlias
	 *            the left alias.
	 * @param _featureName
	 *            the feature name.
	 * @param _rightAlias
	 *            the right alias.
	 */
	public WhereRelationReference(String _leftAlias, String _featureName, String _rightAlias) {

		this.leftAlias = _leftAlias;
		this.rightAlias = _rightAlias;
		this.featureName = _featureName;
	}

	/**
	 * Returns the right-hand side alias of this with relation.
	 * 
	 * @return the right-hand side alias of this with relation.
	 */
	public String getRightAlias() {

		return this.rightAlias;
	}

	/**
	 * Returns the feature which encodes the association.
	 * 
	 * @return the feature which encodes the association.
	 */
	public String getFeatureName() {

		return this.featureName;
	}

	@Override
	protected void toString(StringBuilder sb, int indent) {

		sb.append(this.leftAlias);
		sb.append("."); //$NON-NLS-1$
		sb.append(this.featureName);
		sb.append(" = "); //$NON-NLS-1$
		sb.append(this.rightAlias);
	}
}
