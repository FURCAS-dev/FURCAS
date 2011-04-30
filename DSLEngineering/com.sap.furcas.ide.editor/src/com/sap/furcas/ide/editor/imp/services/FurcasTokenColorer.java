/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.ide.editor.imp.services;

import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.ITokenColorer;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextAttribute;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;

/**
 * {@link ITokenColorer} implementation for languages defined in FURCAS.
 *   
 * @author Stephan Erb
 *
 */
public abstract class FurcasTokenColorer implements ITokenColorer {

    @Override
    public TextAttribute getColoring(IParseController controller, Object o) {
        return getColoring((AbstractToken) o);
    }
    
    protected abstract TextAttribute getColoring(AbstractToken token);

    @Override
    public IRegion calculateDamageExtent(IRegion seed, IParseController ctlr) {
        return seed;
    }

}
