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
 *<li>Rule 81:  nonLinkPredicate ::= > comparisonPostElementOtherOperation
 *</b>
 */
public class ComparisonGreaterPredicate extends Node implements InonLinkPredicate
{
    private IcomparisonPostElementOtherOperation _comparisonPostElementOtherOperation;

    public IcomparisonPostElementOtherOperation getcomparisonPostElementOtherOperation() { return _comparisonPostElementOtherOperation; }

    public ComparisonGreaterPredicate(IToken leftIToken, IToken rightIToken,
                                      IcomparisonPostElementOtherOperation _comparisonPostElementOtherOperation)
    {
        super(leftIToken, rightIToken);

        this._comparisonPostElementOtherOperation = _comparisonPostElementOtherOperation;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}

