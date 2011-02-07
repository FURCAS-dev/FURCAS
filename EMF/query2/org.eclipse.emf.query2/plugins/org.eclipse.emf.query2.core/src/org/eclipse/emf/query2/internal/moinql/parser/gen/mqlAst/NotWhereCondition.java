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
 *<li>Rule 56:  negativeWhereCondition ::= not negativeWhereCondition
 *</b>
 */
public class NotWhereCondition extends Node implements InegativeWhereCondition
{
    private InegativeWhereCondition _negativeWhereCondition;

    public InegativeWhereCondition getnegativeWhereCondition() { return _negativeWhereCondition; }

    public NotWhereCondition(IToken leftIToken, IToken rightIToken,
                             InegativeWhereCondition _negativeWhereCondition)
    {
        super(leftIToken, rightIToken);

        this._negativeWhereCondition = _negativeWhereCondition;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


