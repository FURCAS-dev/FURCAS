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
package com.sap.furcas.prettyprinter;

import java.util.Collection;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.OmittedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;

/**
 * A factory for instances of {@link DocumentNode}s configured to be used by the {@linkTemplateHandler}
 * and {@link SequenceHandler}. Basically, it is a simple wrapper around the EMF {@link TextblocksFactory}.
 * 
 * @author Stephan Erb
 *
 */
public class TextBlocksFactory {

    private static final Version version = Version.REFERENCE;
    private final TextblocksFactory factory = TextblocksFactory.eINSTANCE;
    private final Lexer lexer;
    
    public TextBlocksFactory(ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) {
        lexer = parserFactory.createLexer(null);
    }
    
    public TextBlock createTextBlock(EObject modelElement, List<DocumentNode> subnodes, Template template,
            SequenceElement seqElem, int offset, Collection<Integer> parentAltChoices) {
        
        TextBlock textBlock = factory.createTextBlock();
        textBlock.setVersion(version);
        textBlock.getCorrespondingModelElements().add(modelElement);
        textBlock.setType(template);
        textBlock.setSequenceElement(seqElem);
        textBlock.getSubNodes().addAll(subnodes);
        textBlock.getParentAltChoices().addAll(parentAltChoices);
        textBlock.setOffsetRelative(true);
        textBlock.setComplete(true);
        textBlock.setOffset(offset);
        textBlock.setLength(getLengthOf(subnodes, /*default length*/ 0));
        return textBlock;
    }
    
    public AbstractToken createLexedToken(String value, SequenceElement seqElem, int offset) {
        LexedToken token = factory.createLexedToken();
        configure(token, value, offset);
        token.setSequenceElement(seqElem);
        return token;
    }

    public OmittedToken createOmittedToken(String value, int offset) {
        OmittedToken token = factory.createOmittedToken();
        configure(token, value, offset);
        token.setState(Token.HIDDEN_CHANNEL);
        return token;
    }
    
    public Bostoken createBOSToken() {
        return ANTLRIncrementalLexerAdapter.createBOSToken(factory, version,
                ANTLRIncrementalLexerAdapter.bosTokenType);
    }

    public Eostoken createEOSToken(int offset) {
        Eostoken token = ANTLRIncrementalLexerAdapter.createEOSToken(factory, version,
                ANTLRIncrementalLexerAdapter.eosTokenType);
        token.setOffset(offset);
        return token;
    }
    
    private void configure(AbstractToken token, String value, int offset) {
        token.setType(getTokenType(value));
        token.setValue(value);
        token.setLength(value.length());
        token.setOffset(offset);
        token.setVersion(version);
        token.setOffsetRelative(true);
    }

    private int getTokenType(String value) {
        lexer.setCharStream(new ANTLRStringStream(value));
        Token lexerToken = lexer.nextToken();
        return lexerToken.getType();
    }
    
    public static int getLengthOf(List<? extends DocumentNode> nodes, int defaultValue) {
        if (nodes == null || nodes.isEmpty()) {
            return defaultValue;
        } else {
            DocumentNode lastToken = nodes.get(nodes.size()-1);
            return lastToken.getOffset()+lastToken.getLength();
        }
    }

}
