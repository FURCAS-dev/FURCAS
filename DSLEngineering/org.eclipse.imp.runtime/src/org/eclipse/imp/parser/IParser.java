/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.parser;

import lpg.runtime.ILexStream;
import lpg.runtime.IPrsStream;
import lpg.runtime.Monitor;

/*
 * Licensed Materials - Property of IBM,
 * (c) Copyright IBM Corp. 1998, 2004  All Rights Reserved
 */


/**
 * @author rfuhrer, pcharles
 */
public interface IParser {
    /**
     * Run the parser to create a model.
     * @param monitor stop scanning/parsing when monitor.isCanceled() is true.
     * @return
     */
    public Object parser(Monitor monitor, int error_repair_count);

    public IPrsStream getIPrsStream();

    /**
     * @return array of keywords in the order in which they are mapped to integers.
     */
    public String[] orderedTerminalSymbols();

    /**
     * @return array of keywords in the order in which they are mapped to integers.
     */
    public int numTokenKinds();

    /**
     * @return the token kind for the EOF token
     */
    public int getEOFTokenKind();

    public void reset(ILexStream lexStream);
}
