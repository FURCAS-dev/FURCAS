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
 *<li>Rule 10:  query ::= selectClause fromClause whereClauseM
 *</b>
 */
public class MqlQuery extends Node implements Iquery
{
    private SelectClause _selectClause;
    private FromClause _fromClause;
    private IwhereClauseM _whereClauseM;

    public SelectClause getselectClause() { return _selectClause; }
    public FromClause getfromClause() { return _fromClause; }
    /**
     * The value returned by <b>getwhereClauseM</b> may be <b>null</b>
     */
    public IwhereClauseM getwhereClauseM() { return _whereClauseM; }

    public MqlQuery(IToken leftIToken, IToken rightIToken,
                    SelectClause _selectClause,
                    FromClause _fromClause,
                    IwhereClauseM _whereClauseM)
    {
        super(leftIToken, rightIToken);

        this._selectClause = _selectClause;
        this._fromClause = _fromClause;
        this._whereClauseM = _whereClauseM;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


