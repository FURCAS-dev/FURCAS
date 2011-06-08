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


import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

import Bibtex.util.BibtexAdapterFactory;

import com.sap.furcas.example.bibtex.dsl.parser.BibtexAuthorViewParserFactory;
import com.sap.furcas.ide.editor.imp.AbstractFurcasEditor;

public class BibtexAuthorViewEditor extends AbstractFurcasEditor { 

    public BibtexAuthorViewEditor() {
        super(new BibtexAuthorViewParserFactory());
    }
    
    @Override
    protected ComposedAdapterFactory createAdapterFactory() {
        ComposedAdapterFactory adapterFactory = super.createAdapterFactory();
        adapterFactory.addAdapterFactory(new BibtexAdapterFactory());
        return adapterFactory;
    }

}
