package com.sap.tc.moin.xm.generation.core.code.parser.impl;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.generation.core.code.parser.template.PrefixToChildAssociation;
import com.sap.tc.moin.xm.generation.core.code.parser.template.PrefixToElementHandlers;
import com.sap.tc.moin.xm.generation.core.code.parser.template.PrefixToSimpleElementOrAttribute;
import com.sap.tc.moin.xm.generation.core.code.parser.template.XmHandlerTemplate;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.QualifiedName;
import com.sap.tc.moin.xm.generation.core.code.util.HandlerAndComplexTypeMethodData;
import com.sap.tc.moin.xm.generation.core.code.util.PSUtil;
import com.sap.tc.moin.xm.generation.core.code.util.XmParserSerializerTemplateImpl;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmAssociation;

/**
 * Represents template for the code generation of a complex handler.
 * <p>
 * From this information the inner classes "ComplexElementHandler" are
 * generated.
 */
public final class XmHandlerTemplateImpl implements XmHandlerTemplate {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_GEN, XmHandlerTemplateImpl.class );

    private final HandlerAndComplexTypeMethodData info;

    /*
     * Maps the prefix to child element names with their handlers.
     */
    private final Map<String, PrefixToElementHandlers> prefix2ChildHandlers = new LinkedHashMap<String, PrefixToElementHandlers>( );

    /*
     * Maps the prefix to child element names with their associations.
     */
    private final Map<String, PrefixToChildAssociation> prefix2ChildAssociations = new LinkedHashMap<String, PrefixToChildAssociation>( );

    /* maps the xml attributes to moin attribute names. */
    private final Map<String, PrefixToSimpleElementOrAttribute> xmlAttributesToMoinAttributeName = new LinkedHashMap<String, PrefixToSimpleElementOrAttribute>( );

    /* maps the xml elements of simple types to moin attribute names. */
    private final Map<String, PrefixToSimpleElementOrAttribute> xmlSimpleElementToMoinAttributeName = new LinkedHashMap<String, PrefixToSimpleElementOrAttribute>( );



    /**
     * Constructor.
     * 
     * @param handlerInfo handler information
     * @param aMoinClass MOIN class, can be <code>null</code>
     * @throws NullPointerException if a parameter except <tt>aMoinClass</tt> is
     * <code>null</code>
     */
    public XmHandlerTemplateImpl( final HandlerAndComplexTypeMethodData handlerInfo ) {

        if ( handlerInfo == null ) {
            throw new MoinNullPointerException( "handlerInfo" ); //$NON-NLS-1$
        }
        this.info = handlerInfo;
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Template for complex type handler {0} created", this.getClassName( ) ); //$NON-NLS-1$
        }
    }


    public String getClassName( ) {

        return this.info.getHandlerClassName( );
    }

    public String getXmlEntityQName( ) {

        return PSUtil.getXmlEntityQName( this.info );
    }

    /**
     * Returns the dot separated qualified java class name of a MOF class if the
     * XML element or complex type treated by this handler is associated with a
     * MOF Class, otherwise <code>null</code> is returned.
     * <p>
     * From this information the method "elementStarted" is generated.
     */
    public String getQualifiedJavaClassName( ) {

        if ( this.info.getMoinClass( ) == null ) {
            return null;
        } else {
            return XmParserSerializerTemplateImpl.getQualifiedJmiClassName( this.info.getMoinClass( ).getNamespace( ), this.info.getMoinClass( ).getMofName( ) );
        }
    }

    /**
     * Adds a complex child.
     * 
     * @param qName QName of the child element
     * @param id of the child element handler
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public void addChild( final QualifiedName qName, final String id ) {

        if ( qName == null ) {
            throw new MoinNullPointerException( "qName" ); //$NON-NLS-1$
        }

        if ( id == null ) {
            throw new MoinNullPointerException( "id" ); //$NON-NLS-1$
        }

        PrefixToElementHandlers handlers = this.prefix2ChildHandlers.get( qName.getPrefix( ) );
        if ( handlers == null ) {
            handlers = new PrefixToElementHandlersImpl( qName.getPrefix( ) );
            this.prefix2ChildHandlers.put( qName.getPrefix( ), handlers );
        }
        handlers.getElements( ).add( new ElementNameAndHandlerClassNameImpl( qName.getLocalPart( ), id ) );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Element declaration {0} with complex type handler {1} added to complex type handler {2}", new Object[] { qName.getQName( ), id, this.getClassName( ) } ); //$NON-NLS-1$ 
        }
    }

    /**
     * Adds a association for a child XML element.
     * 
     * @param qName QName of the child element
     * @param association association
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public void addChildAssociation( final QualifiedName qName, final XmAssociation association ) {

        if ( qName == null ) {
            throw new MoinNullPointerException( "qName" ); //$NON-NLS-1$
        }
        if ( association == null ) {
            throw new MoinNullPointerException( "association" ); //$NON-NLS-1$
        }

        PrefixToChildAssociation handlers = this.prefix2ChildAssociations.get( qName.getPrefix( ) );
        if ( handlers == null ) {
            handlers = new PrefixToChildAssocaitionImpl( qName.getPrefix( ) );
            this.prefix2ChildAssociations.put( qName.getPrefix( ), handlers );
        }
        handlers.getChildAssociations( ).add( new ChildAssociationImpl( qName.getLocalPart( ), association, false ) );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Element declaration {0} with association {1} added to complex type handler {2}", new Object[] { qName.getQName( ), association.getMofName( ), this.getClassName( ) } ); //$NON-NLS-1$ 
        }
    }

    public Collection<PrefixToElementHandlers> getChilds( ) {

        return this.prefix2ChildHandlers.values( );
    }


    public Collection<PrefixToChildAssociation> getChildAssociations( ) {

        return this.prefix2ChildAssociations.values( );
    }


    /**
     * Adds a XML attribute which is mapped to an attribute of the MOF class
     * given by {@link #getQualifiedJavaClassName()}.
     * 
     * @param qName qualified XML attribute name
     * @param moinAttributeName attribute name of the MOF class
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public void addXmlAttribute( final QualifiedName qName, final String moinAttributeName ) {

        PrefixToSimpleElementOrAttribute list = this.xmlAttributesToMoinAttributeName.get( qName.getPrefix( ) );
        if ( list == null ) {
            list = new PrefixToSimpleElementOrAttributeImpl( qName.getPrefix( ) );
            this.xmlAttributesToMoinAttributeName.put( qName.getPrefix( ), list );
        }
        list.getMoinAttributes( ).add( new XmlElementOrAttributeNameToMoinAttributeNameImpl( qName.getLocalPart( ), moinAttributeName, this.getQualifiedJavaClassName( ), false ) );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Attribute declaration {0} with MOIN Attribute {1} added to complex type handler {2}", new Object[] { qName.getQName( ), moinAttributeName, this.getClassName( ) } ); //$NON-NLS-1$ 
        }
    }


    /**
     * Adds a XML element of simple type which is mapped to an attribute of the
     * MOF class given by {@link #getQualifiedJavaClassName()}.
     * 
     * @param qName QName of XML element
     * @param moinAttributeName attribute name of the MOF class
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public void addSimpleXmlElement( final QualifiedName qName, final String moinAttributeName ) {

        PrefixToSimpleElementOrAttribute list = this.xmlSimpleElementToMoinAttributeName.get( qName.getPrefix( ) );
        if ( list == null ) {
            list = new PrefixToSimpleElementOrAttributeImpl( qName.getPrefix( ) );
            this.xmlSimpleElementToMoinAttributeName.put( qName.getPrefix( ), list );
        }
        list.getMoinAttributes( ).add( new XmlElementOrAttributeNameToMoinAttributeNameImpl( qName.getLocalPart( ), moinAttributeName, this.getQualifiedJavaClassName( ), false ) );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Element declaration {0} with MOIN Attribute {1} added for method {2} of complex type handler {3}", new Object[] { qName.getQName( ), moinAttributeName, "\"addSimpleElementOrAttribute\"", this.getClassName( ) } ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }



    public Collection<PrefixToSimpleElementOrAttribute> getXmlAttributeToMoinAttributeNameMap( ) {

        return this.xmlAttributesToMoinAttributeName.values( );
    }


    public Collection<PrefixToSimpleElementOrAttribute> getXmlSimpleElementToMoinAttributeNameMap( ) {

        return this.xmlSimpleElementToMoinAttributeName.values( );
    }



    public boolean isAddSimpleElementOrAttribute( ) {

        return !( this.xmlAttributesToMoinAttributeName.isEmpty( ) && this.xmlSimpleElementToMoinAttributeName.isEmpty( ) );
    }


    public boolean isSimpleContent( ) {

        return this.info.isSimpleContent( );
    }

}
