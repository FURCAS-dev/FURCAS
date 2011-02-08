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
 *<li>Rule 55:  localWhereCondition ::= localWhereCondition or negativeWhereCondition
 *</b>
 */
public class OrWhereCondition extends Node implements IlocalWhereCondition
{
    private IlocalWhereCondition _localWhereCondition;
    private InegativeWhereCondition _negativeWhereCondition;

    public IlocalWhereCondition getlocalWhereCondition() { return _localWhereCondition; }
    public InegativeWhereCondition getnegativeWhereCondition() { return _negativeWhereCondition; }

    public OrWhereCondition(IToken leftIToken, IToken rightIToken,
                            IlocalWhereCondition _localWhereCondition,
                            InegativeWhereCondition _negativeWhereCondition)
    {
        super(leftIToken, rightIToken);

        this._localWhereCondition = _localWhereCondition;
        this._negativeWhereCondition = _negativeWhereCondition;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


