package com.sap.tc.moin.xm.generation.core.code.parser.impl;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.code.parser.template.ElementNameAndHandlerClassName;
import com.sap.tc.moin.xm.generation.core.code.util.PSUtil;


public final class ElementNameAndHandlerClassNameImpl implements ElementNameAndHandlerClassName {


    private final String name;

    private final String className;

    ElementNameAndHandlerClassNameImpl( final String elementLocalName, final String handlerClassName ) {

        if ( elementLocalName == null ) {
            throw new MoinNullPointerException( "elementLocalName" ); //$NON-NLS-1$
        }
        if ( handlerClassName == null ) {
            throw new MoinNullPointerException( "handlerClassName" ); //$NON-NLS-1$
        }

        this.name = PSUtil.replaceNonJavaCharacters( elementLocalName );
        this.className = handlerClassName;
    }

    public String getElementLocalName( ) {

        return this.name;
    }

    public String getHandlerClassName( ) {

        return this.className;
    }

}
