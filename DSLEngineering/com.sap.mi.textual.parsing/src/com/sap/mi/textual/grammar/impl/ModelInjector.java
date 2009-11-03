/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-08-30 09:59:50 +0200 (So, 30 Aug 2009) $
 * Revision: $Revision: 7772 $
 * Author: $Author: c5127705 $
 *******************************************************************************/
package com.sap.mi.textual.grammar.impl;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.BaseRecognizer;

import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.grammar.IModelInjector;
import com.sap.mi.textual.grammar.ModelElementCreationException;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.mi.textual.grammar.exceptions.DeferredActionResolvingException;
import com.sap.mi.textual.grammar.exceptions.DeferredModelElementCreationException;
import com.sap.mi.textual.grammar.exceptions.ModelCreationOntheFlyRuntimeException;
import com.sap.mi.textual.grammar.impl.context.ContextManager;


/**
 * The Class AbstractModelInjector.
 */
public class ModelInjector extends AbstractModelInjector implements IModelInjector {


    // Helper for lengthy methods. Package access to allow for easy stubbing in unit tests
    /** The helper. */
    DelayedReferencesHelper helper = new DelayedReferencesHelper(this);
   


    /**
     * Instantiates a new tCS injector.
     * 
     * @param parserTokens
     *                the token names, such as those returned by
     *                {@link BaseRecognizer#getTokenNames()}. Needed only for error reporting for parse
     *                errors (see
     *                {@link ErrorMessageGenerator#getParsingError(org.antlr.runtime.RecognitionException, String[])}
     *                and {@link #reportError(org.antlr.runtime.RecognitionException)}) and only if the
     *                errors involve keyword recognition. Can be <tt>null</tt>. 
     */
    public ModelInjector(String[] parserTokens) {
        super(parserTokens);
    }


    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelInjector#createModelElementProxy(java.lang.String, boolean, boolean)
     */
    @Override
    public Object createOrResolve(Object proxyObject, ANTLR3LocationToken firstToken, ANTLR3LocationToken lastToken) throws ModelElementCreationException {
        if (getModelAdapter() == null) {
            throw new IllegalStateException("Cannot use ModelInjector when ModelAdapter is set to null");
        }
        ModelElementProxy proxy = (ModelElementProxy) proxyObject;
        try {           

            Map<String, List<Object>> attributes = proxy.getAttributeMap();
            
            Object createdObject = getModelAdapter().createOrResolveElement(proxy.getType(), attributes, firstToken, lastToken, proxy.isReferenceOnly(), false);

            proxy.setRealObject(createdObject);
            return createdObject;
        } catch (ModelAdapterException e) {
            // TODO move this to getModelAdapter() and delete ModelElement on errors (?)
            throw new ModelElementCreationException("Exception resolving proxy " + proxy, e);
        }
    }

 
    /**
     * @param object 
     * @param string 
     * @param string 
     * @return
     * @throws ModelElementCreationException 
     */
    Object doCreate(List<String> list, String keyname, Object keyValue) throws ModelElementCreationException {
        if (getModelAdapter() == null) {
            throw new IllegalStateException("Cannot use ModelInjector when ModelAdapter is set to null");
        }
        Object element;
        try {
            Map<String, List<Object>> valueMap = new HashMap<String, List<Object>>();
            List<Object> values = new ArrayList<Object>();
            values.add(keyValue);
            valueMap.put(keyname, values);
            element = getModelAdapter().createOrResolveElement(list, valueMap, null, null, false, false );
        } catch (ModelAdapterException e) {
            throw new ModelElementCreationException("Exception while creating type " + list + ": " + e.getMessage(), e);
        }
        if (element == null) {
            throw new RuntimeException("Invalid ModelAdapter implementation " + getModelAdapter().getClass() +  ": Model Adapter returned null instead of created element of type " + list);
        }

        return element;
    }





    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelInjector#createEnumLiteral(java.util.List, java.lang.String)
     */
    @Override
    public Object createEnumLiteral(List<String> enumName, String name) {
        if (getModelAdapter() == null) {
            throw new IllegalStateException("Cannot use ModelInjector when ModelAdapter is set to null");
        }
        try {
            return getModelAdapter().createEnumLiteral(enumName, name);
        } catch (ModelAdapterException e) {
            throw new ModelCreationOntheFlyRuntimeException("Exception while creating enum literal " + name + " : " + e.getMessage(), e);
        }
    }



    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IModelInjector#set(java.lang.Object, java.lang.String, java.lang.Object)
     */
    public void set(Object modelElement, String prop, Object value)  {
        if (getModelAdapter() == null) {
            throw new IllegalStateException("Cannot use ModelInjector when ModelAdapter is set to null");
        }
        if (modelElement instanceof ModelElementProxy) {
            ModelElementProxy proxy = (ModelElementProxy) modelElement;
            // TODO: maybe check here if feature exists for type?
            proxy.addProxyAttribute(prop, value);
        } else { // may happen for delayed references
            try {
                getModelAdapter().set(modelElement, prop, value);
            } catch (ModelAdapterException e) {
                throw new ModelCreationOntheFlyRuntimeException("Exception setting feature " + prop + " for object " + modelElement + " to " + value +":" + e.getMessage(), e);
            }
        }
    }
    
    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IModelInjector#set(java.lang.Object, java.lang.String, java.lang.Object, int)
     */
    public void set(Object modelElement, String prop, Object value, int index)  {
        if (getModelAdapter() == null) {
            throw new IllegalStateException("Cannot use ModelInjector when ModelAdapter is set to null");
        }
        if (modelElement instanceof ModelElementProxy) {
            ModelElementProxy proxy = (ModelElementProxy) modelElement;
            // TODO: maybe check here if feature exists for type?
            proxy.addProxyAttribute(prop, value, index);
        } else { // may happen for delayed references
            try {
                getModelAdapter().set(modelElement, prop, value, index);
            } catch (ModelAdapterException e) {
                throw new ModelCreationOntheFlyRuntimeException("Exception setting feature " + prop + " for object " + modelElement + " to " + value +":" + e.getMessage(), e);
            }
        }
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IModelInjector#setCommentsAfter(java.lang.Object, java.lang.Object[])
     */
    public void setCommentsAfter(Object ret, org.antlr.runtime.TokenStream stream, org.antlr.runtime.Token nextToken) {
//      System.out.println("setCommentsAfter" + ret);
        //TODO find out what we could use this for (conservation of comments in roundtrip?)
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IModelInjector#setCommentsBefore(java.lang.Object, java.lang.Object[])
     */
    public void setCommentsBefore(Object ret, org.antlr.runtime.TokenStream stream, org.antlr.runtime.Token firstToken) {
//      System.out.println("setCommentsBefore" + ret);
        //TODO find out what we could use this for (conservation of comments in roundtrip?)

    }


    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IModelInjector#setDelayedReferences()
     */
    public boolean resolveReference(DelayedReference reference,ContextManager contextManager, ObservableInjectingParser parser) throws ModelElementCreationException {
        if (getModelAdapter() == null) {
            throw new IllegalStateException("Cannot use ModelInjector when ModelAdapter is set to null");
        }
        try {
            return helper.setDelayedReference(reference, getModelAdapter(), contextManager, parser);
        } catch (ModelAdapterException e) {
            addError(new ParsingError(e.getMessage(), reference.getToken()));
            return false;
        }
    }


    /**
     * 
     */
    public void performAdapterDeferredActions() {
        if (getModelAdapter() == null) {
            throw new IllegalStateException("Cannot use ModelInjector when ModelAdapter is set to null");
        }
        if (getErrorList().size() == 0) {
            // the getModelAdapter() gets the right to replace mocked objects with real objects.
            if (getModelAdapter().hasDeferredActions()) {
                try {
                    Map<Object, Object> replacementMap = getModelAdapter().performAllDeferredActions();
                    if (replacementMap != null) {
                        // replace mock objects with real objects in textLocation map
                        Map<Object, TextLocation> locationByElement = getLocationsMap();
                        for (Iterator<Object> iterator = replacementMap.keySet().iterator(); iterator.hasNext();) {
                            Object mock = iterator.next();
                            TextLocation location = locationByElement.get(mock);
                            locationByElement.remove(mock);
                            locationByElement.put(replacementMap.get(mock), location);
                        }
                    }
                } catch (DeferredActionResolvingException e) {
                    List<DeferredModelElementCreationException> causes = e.getCauses();
                    for (Iterator<DeferredModelElementCreationException> iterator = causes.iterator(); iterator.hasNext();) {
                        DeferredModelElementCreationException modelAdapterException = iterator
                        .next();
                        addError(new ParsingError(modelAdapterException.getMessage(), getLocationsMap().get(modelAdapterException.getErrorCausingMockObject())));
                    }
                }
            }
        }
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IModelInjector#unescapeString(java.lang.String, int)
     */
    public String unescapeString(String s, int delimLength) {
        StringBuilder ret = new StringBuilder();
        // get rid of the starting and ending delimiters (e.g., '\'', '"')
        s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));

        CharacterIterator ci = new StringCharacterIterator(s);
        char c = ci.first();
        while(c != CharacterIterator.DONE) {
            char tc = 0;
            switch(c) {
            case '\\':
                c = ci.next();
                switch(c) {
                case 'n':
                    tc = '\n';
                    break;
                case 'r':
                    tc = '\r';
                    break;
                case 't':
                    tc = '\t';
                    break;
                case 'b':
                    tc = '\b';
                    break;
                case 'f':
                    tc = '\f';
                    break;
                case '"':
                    tc = '"';
                    break;
                case '\'':
                    tc = '\'';
                    break;
                case '\\':
                    tc = '\\';
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                    throw new RuntimeException("octal escape sequences not supported yet");
                default:
                    throw new RuntimeException("unknown escape sequence: '\\" + c + "'");
                }
                break;
            default:
                tc = c;
            break;
            }
            ret.append(tc);
            c = ci.next();
        }
        return ret.toString();
    }



  

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.impl.IModelInjector#setLocation(java.lang.Object,
     *      java.lang.String)
     */
    @Override
	public final void setLocation(Object modelElement, TextLocation location) {
        super.setLocation(modelElement, location);
        if (modelElement != null) {
            if (this.options != null && this.options.isStoreLocationsInModel()) {
                try {
                    if (getModelAdapter() == null) {
                        throw new IllegalStateException("Cannot use ModelInjector when ModelAdapter is set to null");
                    }
                    getModelAdapter().set(modelElement, options
                            .getLocationsPropertyNameInModel(), location.toString());
                } catch (ModelAdapterException e) {
                }
            }
            
        }
    }


    @Override
    public void unset(Object modelElement, String prop, Object value) {
	if (getModelAdapter() == null) {
            throw new IllegalStateException("Cannot use ModelInjector when ModelAdapter is set to null");
        }
        if (modelElement instanceof ModelElementProxy) {
            ModelElementProxy proxy = (ModelElementProxy) modelElement;
            // TODO: maybe check here if feature exists for type?
            proxy.unsetProxyAttribute(prop, value);
        } else { // may happen for delayed references
            try {
                getModelAdapter().unset(modelElement, prop, value);
            } catch (ModelAdapterException e) {
                throw new ModelCreationOntheFlyRuntimeException("Exception unsetting feature " + prop + " for object " + modelElement + " to null :" + e.getMessage(), e);
            }
        }
    }


}
