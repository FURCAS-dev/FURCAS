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
package com.sap.furcas.metamodel.texteditor.editor;

import com.sap.furcas.ide.editor.imp.services.FurcasContentProposer;
import com.sap.furcas.parser.tcs.TCSParserFactory;

public class TCSContentProposer extends FurcasContentProposer {
    
    public TCSContentProposer() {
        super(new TCSParserFactory());
    }
}
