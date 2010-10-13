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

import org.eclipse.emf.query2.exception.BaseException;
import org.eclipse.emf.query2.internal.moinql.parser.AstException;
import org.eclipse.emf.query2.internal.moinql.parser.LPGMessages;
import org.eclipse.emf.query2.report.LocalizedProcessException;
import org.eclipse.emf.query2.report.ProcessErrorImpl;
import org.eclipse.emf.query2.report.ProcessMessages;
import org.eclipse.emf.query2.report.ProcessReport;
import org.eclipse.emf.query2.report.ProcessWarningImpl;

import lpg.lpgjavaruntime.*;



/**
 *<b>
 *<li>Rule 13:  selectEntryN ::= selectEntry , selectEntryN
 *</b>
 */
public class SelectEntryN extends Node implements IselectEntryN
{
    private IselectEntry _selectEntry;
    private IselectEntryN _selectEntryN;

    public IselectEntry getselectEntry() { return _selectEntry; }
    public IselectEntryN getselectEntryN() { return _selectEntryN; }

    public SelectEntryN(IToken leftIToken, IToken rightIToken,
                        IselectEntry _selectEntry,
                        IselectEntryN _selectEntryN)
    {
        super(leftIToken, rightIToken);

        this._selectEntry = _selectEntry;
        this._selectEntryN = _selectEntryN;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


