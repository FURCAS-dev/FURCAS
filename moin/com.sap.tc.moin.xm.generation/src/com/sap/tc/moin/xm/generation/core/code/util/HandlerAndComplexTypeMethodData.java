package com.sap.tc.moin.xm.generation.core.code.util;

import org.eclipse.xsd.XSDContentTypeCategory;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.code.parser.impl.XmHandlerTemplateImpl;
import com.sap.tc.moin.xm.generation.core.code.serializer.impl.ComplexTypeMethodImpl;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmClass;

/**
 * Data which are need for the creation of an instance of
 * {@link ComplexTypeMethodImpl} or {@link XmHandlerTemplateImpl}
 */
public class HandlerAndComplexTypeMethodData {


    private final String handlerClassName;

    private final String methodName;

    private final String localName;

    private final String namespace;

    private final XsdKind kind;

    private final XmClass moinClass;

    private final String qNameOfMoinClass;

    /**
     * Constructor.
     * 
     * @param aKind XSD kind
     * @param aLocalName local name of the XSD element declaration or complex
     * type definition for which the handler shall be generated
     * @param aNamespace namespace of the XSD element declaration or complex
     * type definition; the no-namespace is indicated by an empty string
     * @param aHandlerClassName handler class name (without packages)
     * @param aMoinClass moinClass
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public HandlerAndComplexTypeMethodData( final XsdKind aKind, final String aLocalName, final String aNamespace, final String aHandlerClassName, final XmClass aMoinClass ) {

        if ( aHandlerClassName == null ) {
            throw new MoinNullPointerException( "aHandlerClassName" ); //$NON-NLS-1$
        }
        if ( aKind == null ) {
            throw new MoinNullPointerException( "aKind" ); //$NON-NLS-1$
        }
        if ( aLocalName == null ) {
            throw new MoinNullPointerException( "aLocalName" ); //$NON-NLS-1$
        }
        if ( aNamespace == null ) {
            throw new MoinNullPointerException( "aNamespace" ); //$NON-NLS-1$
        }
        if ( aMoinClass == null ) {
            throw new MoinNullPointerException( "aMoinClass" ); //$NON-NLS-1$
        }
        this.handlerClassName = aHandlerClassName;
        this.methodName = "write" + this.handlerClassName; //$NON-NLS-1$
        this.localName = aLocalName;
        this.namespace = aNamespace;
        this.kind = aKind;
        this.moinClass = aMoinClass;
        this.qNameOfMoinClass = XmParserSerializerTemplateImpl.getQualifiedJmiClassName( this.moinClass.getNamespace( ), this.moinClass.getMofName( ) );
    }



    public String getHandlerClassName( ) {

        return handlerClassName;
    }

    public String getMethodName( ) {

        return this.methodName;
    }


    public String getLocalName( ) {

        return localName;
    }


    /**
     * Namespace of the global element declaration or complex type definition.
     * 
     * @return namespace, no-namespace is represented by the empty string;
     * cannot be <code>null</code>
     */
    public String getNamespace( ) {

        return namespace;
    }


    public XsdKind getKind( ) {

        return kind;
    }

    /** Returns the MOIN class to which the handler and method correspond. */
    public XmClass getMoinClass( ) {

        return this.moinClass;
    }

    /**
     * Returns the qualified java class name of the parameter of the method
     * which represents the type of the model element for which the XML element
     * is created.
     * 
     * @return qualified java class name, cannot be <code>null</code>
     */
    public String getQualifiedJavaClassNameOfMoinClass( ) {

        return this.qNameOfMoinClass;
    }

    /**
     * Returns <tt>true</tt> if the complex type definition has simple content.
     * 
     * @return Returns <tt>true</tt> if the complex type definition has simple
     * content, otherwise <tt>false</tt>
     */
    public boolean isSimpleContent( ) {

        return XSDContentTypeCategory.SIMPLE_LITERAL.equals( this.moinClass.getContentType( ) );
    }
}
