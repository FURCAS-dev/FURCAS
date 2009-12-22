package com.sap.mi.textual.grammar.impl;

import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.debug.DebugEventListener;

public abstract class DebugObservableInjectingParser extends ObservableInjectingParser {

    public DebugObservableInjectingParser(TokenStream input,
            RecognizerSharedState state) {
        super(input, state);
        // TODO Auto-generated constructor stub
    }

    public DebugObservableInjectingParser(TokenStream input,
            DebugEventListener lisener) {
        super(input);
        //setDebugListener(lisener);
        // TODO Auto-generated constructor stub
    }
}
