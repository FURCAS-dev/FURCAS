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

package org.eclipse.imp.services;

import org.eclipse.imp.language.ILanguageService;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextAttribute;

/*
 * Licensed Materials - Property of IBM,
 * (c) Copyright IBM Corp. 2005  All Rights Reserved
 */

/**
 */
public interface ITokenColorer extends ILanguageService {
    /**
     * @param seed the nominal damage area
     * @return a possibly expanded region of damage
     */
    public IRegion calculateDamageExtent(IRegion seed, IParseController ctlr);

    /**
     * Provide coloring and font to use for a given token in the model.
     * @param model The model that contains the token
     * @param token The token to be colored
     * @return a TextAttribute
     */
    public TextAttribute getColoring(IParseController controller, Object token);
}
