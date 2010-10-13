/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-08-30 09:59:50 +0200 (So, 30 Aug 2009) $
 * Revision: $Revision: 7772 $
 * Author: $Author: c5127705 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser;

import java.util.List;

import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.impl.DelayedReference;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.impl.context.ContextManager;

/**
 * A model Injector supports the process of parsing a DSL sample into a DSL
 * Model. It may use an IModelAdapter to create / update / delete ModelElements,
 * but also needs to deal with setting References and collecting and reporting
 * Errors. For Errors, it also has to maintain Token locations for Model
 * Elements derived from tokens.
 * 
 * This interface is used in generated parsers to launch model creation or error
 * occurrence actions. This package already ships with a default ModelInjector
 * which should serve all purposes, so this class does not need subclassing in
 * general.
 */
public interface IModelInjector extends IInjectionHelper {

    /**
     * creates a model element of the given typename. In case of error, no
     * exception is expected, but rather an error added to the error list.
     * 
     * @param name
     * @param context
     * @param addToContext
     * @return
     * @throws ModelElementCreationException
     */
    Object createOrResolve(Object proxy, ANTLR3LocationToken firstToken,
	    ANTLR3LocationToken lastToken) throws ModelElementCreationException;

    /**
     * creates or returns the enum literal of the given enumeration.
     * 
     * @param enumName
     * @param name
     * @return
     */
    Object createEnumLiteral(List<String> enumName, String name);

    /**
     * sets a named feature of a modelelement to some value, which might also be
     * a modelElement.
     * 
     * @param modelElement
     * @param prop
     * @param value
     */
    void set(Object modelElement, String prop, Object value);

    /**
     * sets a named feature of a modelelement to some value, which might also be
     * a modelElement. Additionally an index may be provided that indicates at
     * which position within an ordered property the value should be added.
     * 
     * @param modelElement
     * @param prop
     * @param value
     * @param index
     */
    void set(Object modelElement, String prop, Object value, int index);

    /**
     * Used to remove the <tt>value</tt> from the given property of the
     * <tt>modelElement</tt>.
     * 
     * @param modelElement
     * @param propertyName
     * @param value
     */
    void unset(Object modelElement, String propertyName, Object value);

    void setCommentsAfter(Object ret, org.antlr.runtime.TokenStream stream,
	    org.antlr.runtime.Token nextToken);

    void setCommentsBefore(Object ret, org.antlr.runtime.TokenStream stream,
	    org.antlr.runtime.Token firstToken);

    /**
     * unescapes the String and removes delimiters from both ends, such as ".
     * 
     * @param text
     * @param delimLength
     * @return
     * @deprecated use lexers own unescapeString method instead.
     */
    @Deprecated
    String unescapeString(String text, int delimLength);

    /**
     * performs delayed actions on the adapter (usually like delayed creation
     * until more properties are known).
     */
    void performAdapterDeferredActions();

    /**
     * resolves a reference using the context map as In-Text scope, may create
     * elements to reference, and throw exceptions when that fails.
     * 
     * @param reference
     * @return <code>true</code> if the reference was resolved successfully,
     *         <code>false</code> else.
     * @throws ModelElementCreationException
     */
    boolean resolveReference(DelayedReference reference,
	    ContextManager contextManager, ObservableInjectingParser parser) throws ModelElementCreationException; 
    // TODO: use primitives instead?

    
    /**
     * Returns the {@link IModelAdapter} that is used by this injector.
     */
    IModelAdapter getModelAdapter();
}
