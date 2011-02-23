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
 *<li>Rule 30:  typePathNameN ::= fragmentaddress , typePathNameN
 *</b>
 */
public class TypePathNameN extends Node implements ItypePathNameN
{
    private FragmentAddress _fragmentaddress;
    private ItypePathNameN _typePathNameN;

    public FragmentAddress getfragmentaddress() { return _fragmentaddress; }
    public ItypePathNameN gettypePathNameN() { return _typePathNameN; }

    public TypePathNameN(IToken leftIToken, IToken rightIToken,
                         FragmentAddress _fragmentaddress,
                         ItypePathNameN _typePathNameN)
    {
        super(leftIToken, rightIToken);

        this._fragmentaddress = _fragmentaddress;
        this._typePathNameN = _typePathNameN;
        initialize();
    }

    public void accept(MqlAstVisitor v) { v.visit(this); }
}


