package com.sap.tc.moin.xm.generation.core.code.parser.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.generation.core.code.parser.template.JavaNameAndName;
import com.sap.tc.moin.xm.generation.core.code.parser.template.PrefixToChildAssociation;
import com.sap.tc.moin.xm.generation.core.code.parser.template.PrefixToElementHandlers;
import com.sap.tc.moin.xm.generation.core.code.parser.template.PrefixToSimpleElementOrAttribute;
import com.sap.tc.moin.xm.generation.core.code.parser.template.XmHandlerTemplate;
import com.sap.tc.moin.xm.generation.core.code.parser.template.XmParserHandlerTemplate;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.QualifiedName;
import com.sap.tc.moin.xm.generation.core.code.util.XmParserSerializerTemplateImpl;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmAssociation;


/**
 * Represents the information from which a parser handler is generated.
 */
public final class XmParserHandlerTemplateImpl extends XmParserSerializerTemplateImpl implements XmParserHandlerTemplate {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_GEN, XmParserHandlerTemplateImpl.class );

    /* Contains the unique local names of the XML elements. */
    private final List<JavaNameAndName> elementNames = new ArrayList<JavaNameAndName>( );

    /* Contains the unique local names of the XML attributes. */
    private final List<JavaNameAndName> attributeNames = new ArrayList<JavaNameAndName>( );

    /* ID to sub-handler map. AS ID the class name of the sub-handler is used. */
    private final Map<String, XmHandlerTemplate> id2SubHandlers = new LinkedHashMap<String, XmHandlerTemplate>( );

    /*
     * Maps the prefix to root element names with their handlers.
     */
    private final Map<String, PrefixToElementHandlers> prefix2RootHandlers = new LinkedHashMap<String, PrefixToElementHandlers>( );

    /*
     * Maps the prefix to root element names with their associations to the
     * document root meta-model element.
     */
    private final Map<String, PrefixToChildAssociation> prefix2ChildAssociations = new LinkedHashMap<String, PrefixToChildAssociation>( );

    /* JMI class name of the root document MOF class. */
    private final String qualifiedRootDocumentJmiClassName;

    /* Maps the XML root elements of simple types to MOIN attribute names. */
    private final Map<String, PrefixToSimpleElementOrAttribute> xmlSimpleRootElementToMoinAttributeName = new LinkedHashMap<String, PrefixToSimpleElementOrAttribute>( );


    /**
     * Constructor.
     * 
     * @param javaClassName
     * @param javaPackageName
     * @param schemaName
     * @throws NullPointerException if <tt>schemaName</tt> or
     * <tt>aQualifiedRootDocumentJmiClassName</tt> is <code>null</code>
     */
    public XmParserHandlerTemplateImpl( final String javaClassName, final String javaPackageName, final String schemaName, final String aQualifiedRootDocumentJmiClassName ) {

        super( javaClassName, javaPackageName, schemaName );
        if ( aQualifiedRootDocumentJmiClassName == null ) {
            throw new MoinNullPointerException( "aQualifiedRootDocumentJmiClassName" ); //$NON-NLS-1$
        }
        this.qualifiedRootDocumentJmiClassName = aQualifiedRootDocumentJmiClassName;
    }


    /**
     * Adds a local element name.
     * 
     * @param localName
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public void addElementLocalName( final String localName ) {

        if ( localName == null ) {
            throw new MoinNullPointerException( "localName" ); //$NON-NLS-1$
        }
        final JavaNameAndName name = new JavaNameAndName( localName );
        if ( this.elementNames.contains( name ) ) {
            // do nothing
        } else {
            this.elementNames.add( name );
        }
    }

    /**
     * Adds a local attribute name.
     * 
     * @param localName
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public void addAttributeLocalName( final String localName ) {

        if ( localName == null ) {
            throw new MoinNullPointerException( "localName" ); //$NON-NLS-1$
        }
        final JavaNameAndName name = new JavaNameAndName( localName );
        if ( this.attributeNames.contains( name ) ) {
            // do nothing
        } else {
            this.attributeNames.add( name );
        }
    }


    /**
     * The local element names are used to generate the static string constants
     * for the local element names
     * 
     * @return local unique element name list, cannot be <code>null</code>
     */
    public List<JavaNameAndName> getLocalElementNames( ) {

        return this.elementNames;
    }

    /**
     * The local attribute names are used to generate the static string
     * constants for the local attribute names.
     * 
     * @return local unique attribute name list, cannot be <code>null</code>
     */
    public List<JavaNameAndName> getLocalAttributeNames( ) {

        return this.attributeNames;
    }


    /**
     * Returns the dot separated qualified JMI java class name for the root
     * document model element.
     * <p>
     * From this information the method "rootElementStarted" is generated.
     * 
     * @return qualified JMI java class name for the root document model
     * element; cannot be <code>null</code>
     */
    public String getQualifiedRootDocumentJmiClassName( ) {

        return this.qualifiedRootDocumentJmiClassName;
    }


    public Collection<PrefixToChildAssociation> getChildAssociations( ) {

        return this.prefix2ChildAssociations.values( );
    }

    /**
     * Adds an association for a global element declaration.
     * 
     * @param qName QName of the global element declaration
     * @param prefix prefix of the the global element declaration
     * @param association association
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public void addChildAssociation( final QualifiedName qName, final XmAssociation association ) {

        if ( qName == null ) {
            throw new MoinNullPointerException( "localName" ); //$NON-NLS-1$
        }

        if ( association == null ) {
            throw new MoinNullPointerException( "association" ); //$NON-NLS-1$
        }

        PrefixToChildAssociation assoc = this.prefix2ChildAssociations.get( qName.getPrefix( ) );
        if ( assoc == null ) {
            assoc = new PrefixToChildAssocaitionImpl( qName.getPrefix( ) );
            this.prefix2ChildAssociations.put( qName.getPrefix( ), assoc );
        }
        assoc.getChildAssociations( ).add( new ChildAssociationImpl( qName.getLocalPart( ), association, true ) );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Global element declaration {0} with association {1} added for document root method {2}", new Object[] { qName.getQName( ), association.getMofName( ), "\"rootElementClosed\"" } ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * Adds a sub-handler.
     * 
     * @param id unique ID, typically the qualified name of the handler class
     * @param subHandler
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public void addHandler( final String id, final XmHandlerTemplateImpl subHandler ) {

        if ( id == null ) {
            throw new MoinNullPointerException( "id" ); //$NON-NLS-1$
        }

        if ( subHandler == null ) {
            throw new MoinNullPointerException( "subHandler" ); //$NON-NLS-1$
        }
        this.id2SubHandlers.put( id, subHandler );
    }

    /**
     * Returns the sub-handler list.
     * <p>
     * This information is used to generate the registration of the sub-handlers
     * and to generate the code for the sub-handlers.
     * 
     * @return sub-handler list, cannot be <code>null</code>
     */
    public Collection<XmHandlerTemplate> getSubHandlers( ) {

        return this.id2SubHandlers.values( );
    }


    public boolean existsSubHandler( final String id ) {

        if ( id == null ) {
            throw new NullPointerException( "id is null" ); //$NON-NLS-1$
        }
        return this.id2SubHandlers.containsKey( id );
    }

    /**
     * Adds a handler for the root XML elements.
     * 
     * @param subHandler
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public void addRootHandler( final String prefix, final String rootElementLocalName, final String id ) {

        if ( prefix == null ) {
            throw new MoinNullPointerException( "prefix" ); //$NON-NLS-1$
        }
        if ( rootElementLocalName == null ) {
            throw new MoinNullPointerException( "rootElementLocalName" ); //$NON-NLS-1$
        }
        if ( id == null ) {
            throw new MoinNullPointerException( "id" ); //$NON-NLS-1$
        }

        PrefixToElementHandlers rootEls = this.prefix2RootHandlers.get( prefix );
        if ( rootEls == null ) {
            rootEls = new PrefixToElementHandlersImpl( prefix );
            this.prefix2RootHandlers.put( prefix, rootEls );
        }
        rootEls.getElements( ).add( new ElementNameAndHandlerClassNameImpl( rootElementLocalName, id ) );
    }

    public Collection<PrefixToElementHandlers> getRootElements( ) {

        return this.prefix2RootHandlers.values( );
    }

    /**
     * Adds a XML root element of simple type which is mapped to an attribute of
     * the document root MOF class.
     * 
     * @param name local XML root element name
     * @param prefix prefix
     * @param moinAttributeName attribute name of the MOF class
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public void addXmlSimpleRootElement( final String name, final String prefix, final String moinAttributeName ) {

        PrefixToSimpleElementOrAttribute list = this.xmlSimpleRootElementToMoinAttributeName.get( prefix );
        if ( list == null ) {
            list = new PrefixToSimpleElementOrAttributeImpl( prefix );
            this.xmlSimpleRootElementToMoinAttributeName.put( prefix, list );
        }
        list.getMoinAttributes( ).add( new XmlElementOrAttributeNameToMoinAttributeNameImpl( name, moinAttributeName, this.getQualifiedRootDocumentJmiClassName( ), true ) );
    }

    public Collection<PrefixToSimpleElementOrAttribute> getXmlSimpleRootElementToMoinAttributeName( ) {

        return this.xmlSimpleRootElementToMoinAttributeName.values( );
    }


    private static final List<String> EXTENDS_LIST = new ArrayList<String>( 1 );

    static {
        EXTENDS_LIST.add( "com.sap.tc.moin.repository.xm.parser.XmParserHandlerAbstract" ); //$NON-NLS-1$
    }

    public List<String> getExtends( ) {

        return EXTENDS_LIST;
    }
}
