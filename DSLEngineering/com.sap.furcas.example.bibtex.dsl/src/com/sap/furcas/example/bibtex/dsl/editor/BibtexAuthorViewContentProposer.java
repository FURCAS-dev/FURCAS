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
package com.sap.furcas.example.bibtex.dsl.editor;


import com.sap.furcas.example.bibtex.dsl.parser.BibtexAuthorViewParserFactory;
import com.sap.furcas.ide.editor.imp.services.FurcasContentProposer;

public class BibtexAuthorViewContentProposer extends FurcasContentProposer {
    
    public BibtexAuthorViewContentProposer() {
        super(new BibtexAuthorViewParserFactory());
    }
}
