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

package org.eclipse.imp.utils;

public class UnimplementedError extends Error {
    private static final long serialVersionUID= 5077799745785575339L;

    public UnimplementedError() {
        super();
    }

    public UnimplementedError(String s) {
        super(s);
    }
}
