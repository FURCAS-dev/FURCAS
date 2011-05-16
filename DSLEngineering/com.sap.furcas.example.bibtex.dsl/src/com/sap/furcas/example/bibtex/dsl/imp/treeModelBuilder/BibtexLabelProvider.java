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
package com.sap.furcas.example.bibtex.dsl.imp.treeModelBuilder;

import java.util.Collections;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;

import Bibtex.provider.BibtexItemProviderAdapterFactory;

import com.sap.furcas.ide.editor.imp.services.FurcasLabelProvider;


public class BibtexLabelProvider extends FurcasLabelProvider {
    
    public BibtexLabelProvider() {
        super(Collections.<ComposeableAdapterFactory>singleton(new BibtexItemProviderAdapterFactory()));
    }
}
