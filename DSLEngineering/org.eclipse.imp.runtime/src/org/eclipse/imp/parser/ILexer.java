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

public interface ILexer {
    public int[] getKeywordKinds();

    public ILexStream getILexStream();

    public void initialize(char[] contents, String filename);

    public void lexer(Monitor monitor, IPrsStream prsStream);

    public void reset(char[] contentsArray, String filePath);
}
