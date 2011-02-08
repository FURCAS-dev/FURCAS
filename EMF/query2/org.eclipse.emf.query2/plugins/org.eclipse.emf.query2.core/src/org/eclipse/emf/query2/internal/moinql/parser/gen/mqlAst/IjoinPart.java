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
/**
   * This file is generated for MOIN-MQL with LPG. 
   */

package org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst;

import lpg.lpgjavaruntime.IToken;



/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>LinkPredicate
 *<li>AssocOrComparisonPredicate
 *<li>ComparisonSmallerPredicate
 *<li>ComparisonGreaterPredicate
 *<li>ComparisonSmallerEqualPredicate
 *<li>ComparisonGreaterEqualPredicate
 *<li>ComparisonNotEqualPredicate
 *<li>ComparisonLikePredicate
 *<li>ComparisonNotLikePredicate
 *</ul>
 *</b>
 */
public interface IjoinPart
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(MqlAstVisitor v);
}


