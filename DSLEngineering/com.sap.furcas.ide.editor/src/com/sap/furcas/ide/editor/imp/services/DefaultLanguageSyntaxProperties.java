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

import org.antlr.runtime.Lexer;
import org.eclipse.imp.services.ILanguageSyntaxProperties;

import com.sap.furcas.ide.editor.EditorUtil;
import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.tcs.TcsUtil;

/**
 * This class <b>can</b>  be extended by clients in order to provide languge specific
 * information to the editor. It is ok to always simply return <code>null</code>
 * 
 * @author Stephan Erb
 *
 */
public class DefaultLanguageSyntaxProperties implements ILanguageSyntaxProperties {
    
    private final ConcreteSyntax syntax;

    public DefaultLanguageSyntaxProperties(AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) {
        this.syntax = EditorUtil.loadConcreteSyntax(parserFactory);
    }

    @Override
    public String getSingleLineCommentPrefix() {
        return TcsUtil.getEndOfLineCommentPrefix(TcsUtil.getCommentToken(syntax));
    }

    @Override
    public String getBlockCommentStart() {
        return null;
    }

    @Override
    public String getBlockCommentContinuation() {
        return null;
    }

    @Override
    public String getBlockCommentEnd() {
        return null;
    }

    @Override
    public String[][] getFences() {
        return null;
    }

    @Override
    public String getIdentifierConstituentChars() {
        return null;
    }

    @Override
    public int[] getIdentifierComponents(String ident) {
        return null;
    }

}
