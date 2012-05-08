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
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import Bibtex.util.BibtexAdapterFactory;

import com.sap.furcas.example.bibtex.dsl.parser.BibtexLibraryViewParserFactory;
import com.sap.furcas.ide.editor.imp.AbstractFurcasEditor;

public class BibtexLibraryViewEditor extends AbstractFurcasEditor { 

    public BibtexLibraryViewEditor() {
        super(new BibtexLibraryViewParserFactory(), Activator.getDefault().getLibraryViewSyntaxProvider().getSyntax());
    }
    
    @Override
    protected ComposedAdapterFactory createAdapterFactory() {
        ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
        adapterFactory.addAdapterFactory(new BibtexAdapterFactory());
        adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
        return adapterFactory;
    }

}
