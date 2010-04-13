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
package org.eclipse.emf.query2.internal.moinql.ast;

import org.eclipse.emf.query2.internal.fql.SpiFqlLikeConstraint;
import org.eclipse.emf.query2.internal.fql.SpiFqlPrimitiveType;
import org.eclipse.emf.query2.internal.shared.AuxServices;

/**
 * This predicate is true if the attribute value is an instance of the pattern
 * in stringPattern. A pattern is a string and may contain the following special
 * pattern matching characters:
 * <ul>
 * <li>'?' : matches with any character</li>
 * <li>'*' : matches with any sequence of characters, including the empty
 * sequence</li>
 * <li>'\' : escapes the pattern matching characters '?' and '*', including '\',
 * i.e. itself</li>
 * </ul>
 */
final public class LikeComparison extends ConstantComparison implements SpiFqlLikeConstraint {

	private String stringPattern;

	private boolean not;

	public LikeComparison(AtomicEntry _alias, String _attrName, boolean not, String _stringPattern) {

		this.atomicEntry = _alias;
		this.attrName = _attrName;
		this.stringPattern = _stringPattern;
		this.attrType = SpiFqlPrimitiveType.STRING;
		this.not = not;
	}

	public String getLikePattern() {

		return this.stringPattern;
	}

	public void setLikePattern(String stringPattern) {

		this.stringPattern = stringPattern;
	}

	public boolean isNegated() {

		return this.not;
	}

	/*
	 * Pretty-printing
	 */
	@Override
	public String toString(int indent, StringBuilder accumSb) {

		StringBuilder sb = new StringBuilder();

		sb.append(this.attrName);

		if (this.isMultiValued) {
			sb.append(AuxServices.OPENPAREN_T + AuxServices.ISMULTIVALUED_T + AuxServices.CLOSEPAREN_T);
		}

		String pattern = (this.stringPattern == null ? "null" : AuxServices.OPENQUOTE_T + this.stringPattern + AuxServices.CLOSEQUOTE_T); //$NON-NLS-1$

		if (this.not) {
			sb.append(AuxServices.SPACE_T + AuxServices.NOT_T);
		}

		sb.append(AuxServices.SPACE_T + AuxServices.LIKE_T + AuxServices.SPACE_T + pattern);

		accumSb.append(sb);

		return sb.toString();
	}

	@Override
	public String toString() {

		return toString(0, new StringBuilder());
	}

}
