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
package com.sap.furcas.metamodel.texteditor.tree;

import java.util.Collections;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;

import com.sap.furcas.ide.editor.imp.services.FurcasLabelProvider;
import com.sap.furcas.metamodel.FURCAS.TCS.provider.TCSItemProviderAdapterFactory;



public class TCSLabelProvider extends FurcasLabelProvider {
    
    public TCSLabelProvider() {
        super(Collections.<ComposeableAdapterFactory>singleton(new TCSItemProviderAdapterFactory()));
    }
}
