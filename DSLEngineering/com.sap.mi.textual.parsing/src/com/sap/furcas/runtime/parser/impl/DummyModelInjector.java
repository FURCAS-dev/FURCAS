package com.sap.furcas.runtime.parser.impl;

import java.util.List;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import com.sap.furcas.runtime.parser.IModelInjector;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.impl.context.ContextManager;

/**
 * does not inject nor create or set model Elements, stores Parsing Errors though.
 */
public class DummyModelInjector extends AbstractModelInjector implements IModelInjector {

//	private static ITokenFactory<ANTLR3LocationTokenImpl> tokenFactory = new DefaultANTLR3LocationTokenFactory();

    public DummyModelInjector(String[] parserTokens) {
		super(parserTokens);
	}

	@Override
	public Object createEnumLiteral(List<String> enumName, String name) {
		return null;
	}

	@Override
	public Object createOrResolve(Object proxy, ANTLR3LocationToken firstToken, ANTLR3LocationToken lastToken) {
		return null;
	}


	@Override
	public void performAdapterDeferredActions() {

	}



	@Override
	public void set(Object modelElement, String prop, Object value) {

	}

	@Override
	public void setCommentsAfter(Object ret, TokenStream stream, Token nextToken) {
	
	}

	@Override
	public void setCommentsBefore(Object ret, TokenStream stream,
			Token firstToken) {
		
	}

	@Override
	public String unescapeString(String text, int delimLength) {
		return null;
	}

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.ModelInjector#resolveReference(com.sap.mi.textual.grammar.impl.DelayedReference, com.sap.mi.textual.grammar.impl.context.ContextManager)
     */
    @Override
    public boolean resolveReference(DelayedReference reference,
            ContextManager contextManager,ObservableInjectingParser parser) {
    	return false;
    }

	@Override
	public void set(Object modelElement, String prop, Object value, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unset(Object modelElement, String propertyName, Object value) {
		// TODO Auto-generated method stub
		
	}

}
