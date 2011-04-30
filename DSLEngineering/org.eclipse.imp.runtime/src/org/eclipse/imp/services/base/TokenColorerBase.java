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

package org.eclipse.imp.services.base;

import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.ITokenColorer;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

public abstract class TokenColorerBase implements ITokenColorer {
    protected TextAttribute keywordAttribute;

    public TokenColorerBase() {
        this(new TextAttribute(Display.getDefault().getSystemColor(SWT.COLOR_DARK_MAGENTA), null, SWT.BOLD));
    }

    public TokenColorerBase(TextAttribute keywordAttribute) {
        this.keywordAttribute = keywordAttribute;
    }

    public TextAttribute getColoring(IParseController controller, Object token) {
//        switch (token.getKind()) {
//            default:
//                if (isKeyword(token.getKind(), controller))
//                     return keywordAttribute;
//               else
        return null;
//        }
    }

    public IRegion calculateDamageExtent(IRegion seed, IParseController ctlr) {
        return seed;
    }
}
