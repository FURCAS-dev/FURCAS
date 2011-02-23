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
import org.eclipse.emf.query2.internal.report.ProcessErrorImpl;
import org.eclipse.emf.query2.internal.report.ProcessWarningImpl;
import org.eclipse.emf.query2.report.LocalizedProcessException;
import org.eclipse.emf.query2.report.ProcessMessages;
import org.eclipse.emf.query2.report.ProcessReport;

import lpg.lpgjavaruntime.*;



/**
 *<b>
 *<li>Rule 90:  comparisonPostElementOtherOperation ::= identifier . identifier
 *</b>
 */
public class IdentifierComparisonInPredicate extends Node implements IcomparisonPostElementOtherOperation
{
    private Ident _identifier;
    private Ident _identifier3;

    public Ident getidentifier() { return _identifier; }
    public Ident getidentifier3() { return _identifier3; }

    public IdentifierComparisonInPredicate(IToken leftIToken, IToken rightIToken,
                                           Ident _identifier,
                                           Ident _identifier3)
    {
        super(leftIToken, rightIToken);

        this._identifier = _identifier;
        this._identifier3 = _identifier3;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


