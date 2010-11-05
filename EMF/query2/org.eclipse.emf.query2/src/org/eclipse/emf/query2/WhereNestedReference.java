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
 * Created on 10.02.2006
 */
package org.eclipse.emf.query2;

/**
 * A nested where-entry defines a where-entry which constrains an alias by
 * connecting it via an association to the results of a nested query. Nested
 * where-entries can be negated.
 */
final public class WhereNestedReference extends JoinWhereEntry {

	/*
	 * By default, a nested where entry predicate is not negated
	 */
	protected boolean not = false;

	/*
	 * The feature which encodes the association (this is a reference or
	 * attribute of a class-level attribute).
	 */
	private String featureName;

	/**
	 * Returns whether this nested where entry was negated.
	 * 
	 * @return true if the nested where entry is negated
	 */
	public boolean isNot() {

		return this.not;
	}

	/*
	 * A nested where entry needs a nested query
	 */
	protected Query nestedQuery;

	/**
	 * The provided feature has to identify an object-valued attribute or
	 * reference and the nested query has to select one alias referring to the
	 * type of the feature. For an association, if no reference exists and if
	 * there is no ambiguity, it is also allowed to use the association-end on
	 * the other side. In case of ambiguity, use {@link WhereNestedAssoc}. The
	 * entry is true whenever the feature value has at least one element, which
	 * is contained in the result set of nested query.
	 * 
	 * @param _alias
	 *            the alias.
	 * @param _featureName
	 *            the feature name.
	 * @param _nestedQuery
	 *            the nested query.
	 */
	public WhereNestedReference(String _alias, String _featureName, Query _nestedQuery) {

		this(false, _alias, _featureName, _nestedQuery);
	}

	/**
	 * The provided feature has to identify an object-valued attribute or
	 * reference and the nested query has to select one alias referring to the
	 * type of the feature. For an association, if no reference exists and if
	 * there is no ambiguity, it is also allowed to use the association-end on
	 * the other side. In case of ambiguity, use {@link WhereNestedAssoc}. If
	 * the boolean is false, the entry is true whenever the feature value has at
	 * least one element, which is contained in the result set of nested query.
	 * If the boolean is true, the entry is true whenever the feature value has
	 * no elements, which are contained in the result set of nested query.
	 * 
	 * @param _not
	 *            the indicator if the nested association clause is negated
	 * @param _alias
	 *            the alias.
	 * @param _featureName
	 *            the feature name.
	 * @param _nestedQuery
	 *            the nested query.
	 */
	public WhereNestedReference(boolean _not, String _alias, String _featureName, Query _nestedQuery) {

		this.leftAlias = _alias;
		this.featureName = _featureName;
		this.nestedQuery = _nestedQuery;
		this.not = _not;
	}

	/**
	 * Returns the nested query used in this nested where-constraint.
	 * 
	 * @return the nested query used in this nested where-constraint.
	 */
	public Query getNestedQuery() {

		return this.nestedQuery;
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

		if (this.not) {
			sb.append(" not "); //$NON-NLS-1$
		}

		sb.append(" in\n"); //$NON-NLS-1$
		this.nestedQuery.toString(sb, indent + 1);
	}
}
