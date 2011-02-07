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
 *<b>
 *<li>Rule 80:  nonLinkPredicate ::= < comparisonPostElementOtherOperation
 *</b>
 */
public class ComparisonSmallerPredicate extends Node implements InonLinkPredicate
{
    private IcomparisonPostElementOtherOperation _comparisonPostElementOtherOperation;

    public IcomparisonPostElementOtherOperation getcomparisonPostElementOtherOperation() { return _comparisonPostElementOtherOperation; }

    public ComparisonSmallerPredicate(IToken leftIToken, IToken rightIToken,
                                      IcomparisonPostElementOtherOperation _comparisonPostElementOtherOperation)
    {
        super(leftIToken, rightIToken);

        this._comparisonPostElementOtherOperation = _comparisonPostElementOtherOperation;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


