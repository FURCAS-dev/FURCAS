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
 *<li>Rule 18:  fromEntryN ::= fromEntry , fromEntryN
 *</b>
 */
public class FromEntryN extends Node implements IfromEntryN
{
    private FromEntry _fromEntry;
    private IfromEntryN _fromEntryN;

    public FromEntry getfromEntry() { return _fromEntry; }
    public IfromEntryN getfromEntryN() { return _fromEntryN; }

    public FromEntryN(IToken leftIToken, IToken rightIToken,
                      FromEntry _fromEntry,
                      IfromEntryN _fromEntryN)
    {
        super(leftIToken, rightIToken);

        this._fromEntry = _fromEntry;
        this._fromEntryN = _fromEntryN;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


