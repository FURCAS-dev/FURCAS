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
package com.sap.furcas.metamodel.texteditor.parser;


import com.sap.furcas.ide.editor.imp.parsing.FurcasParseController;
import com.sap.furcas.ide.editor.imp.services.DefaultLanguageSyntaxProperties;
import com.sap.furcas.parser.tcs.stable.TCSParserFactory;

public class TCSParseController extends FurcasParseController {

    public TCSParseController() {
        super(new TCSParserFactory(), new DefaultLanguageSyntaxProperties(new TCSParserFactory()) {
            
            @Override
            public String[][] getFences() {
                String[][] fences = { {"{", "}"},  {"(", ")"}, {"[[", "]]"}, {"[", "]"} }; 
                return fences;
            }
         });
    }

}
