package com.sap.tc.moin.repository.xm.parser;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import javax.xml.XMLConstants;

import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.xm.XmException;

/**
 * Implementation of a handler for the events of the XM Parser. This
 * implementation dispatches SAX like events to so called complex type handlers
 * ({@link ComplexTypeHandler}).
 * <p>
 * The handler and the complex type handlers are normally generated from an XML
 * schema. A complex type handler instance has other complex type handler
 * instances as children according to the XML structure defined in the XML
 * schema.
 * <p>
 * There is exactly one instance per complex type-handler class per XM Parser
 * instance. The complex type handler instances are registered under a certain
 * ID.
 * <p>
 * The complex type handlers which correspond to the complex types of the
 * current parsed XML element path are stored in the path stack
 * {@link PathStack}.
 * <p>
 * The dispatcher flow is as follows:
 * <ul>
 * <li>When the XM parser has reached the root XML element of an XML document,
 * the complex type handler corresponding to the complex type definition of the
 * root element is requested (see method
 * {@link #getRootComplexTypeHandler(String, String)}), the "element started"
 * event is forwarded to the root complex type handler (
 * {@link ComplexTypeHandler#elementStarted(String)} ), and the root complex
 * type handler is put to the peek entry of the stack.</li>
 * <li>When the XM parser has reached an XML element which is not the root XML
 * element, then the child handler which corresponds to the complex type of the
 * given XML element is requested from the stack peek complex type handler (
 * {@link ComplexTypeHandler#getChild(String, String)}).</li>
 * <ul>
 * <li>If the child handler for the given XML element is not found, then the
 * method
 * {@link ComplexTypeHandler#addSimpleElementOrAttribute(String, String, NodeType, String)}
 * is executed on the stack peek complex type handler.</li>
 * <li>If the child handler for the given XML element is found, the child
 * handler is put to the current peek stack entry and then the method
 * {@link ComplexTypeHandler#elementStarted(String))} is executed on the child
 * handler.</li>
 * </ul>
 * <li>XML attributes are added via the method
 * {@link ComplexTypeHandler#addSimpleElementOrAttribute(String, String, NodeType, String)}
 * to the current determined root or child complex type handler.</li>
 * <li>When the parser has reached the closing tag of an XML element, then</li>
 * <ul>
 * <li>the complex type handler is fetched from the peek stack entry</li>
 * <li>the method {@link ComplexTypeHandler#elementClosed()} is called</li>
 * <li>additionally the parent complex type handler of the stack entry with
 * depth 2 is fetched and then the method
 * {@link ComplexTypeHandler#childClosed(ComplexTypeHandler, String, String)} is
 * called on the parent handler.</li>
 * <li>And finally the stack is popped.</li>
 * </ul>
 * </ul>
 * <p>
 * There are further special events for the treatment of the root element, see
 * methods {@link #rootElementStarted()},
 * {@link #addSimpleRootElement(String, String, String)}, and
 * {@link #rootElementClosed(ComplexTypeHandler, String, String)}.
 */
public abstract class XmParserHandlerAbstract implements XmParserHandler {

    /*
     * Map which contains in the keys IDs for the complex type handlers
     * (typically the qualified class name is used) and as values the complex
     * type handler instances.
     */
    private final HashMap<String, ComplexTypeHandler> id2ComplexTypeHandler = new HashMap<String, ComplexTypeHandler>( );

    private ParserHelper helper;

    private boolean isStart = true;

    private final Map<String, String> namespace2Prefix = new HashMap<String, String>( );

    private final Map<String, String> prefix2Namespace = new HashMap<String, String>( );


    /**
     * Registers a prefix for a namespace. For all namespaces which occur in XML
     * documents which shall be parsed a unique prefix must be registered; the
     * parser will throw an exception, if it hits a namespace which is not
     * registered.
     * <p>
     * The registered prefixes are used in the stack {@link PathStack}.
     * 
     * @param namespace namespace; must not be <code>null</code> or the empty
     * string
     * @param prefix unique prefix for the namespace
     * @throws NullPointerException if a parameter is <code>null</code>
     * @throws IllegalArgumentException if a parameter is the empty string, or
     * if already another namespace has been registered with the same prefix, or
     * if more than one prefix shall be registered for one namespace
     */
    public final void registerPrefixForNamespace( final String namespace, final String prefix ) {

        if ( namespace == null ) {
            throw new MoinNullPointerException( "namespace" ); //$NON-NLS-1$
        }
        if ( prefix == null ) {
            throw new MoinNullPointerException( "prefix" ); //$NON-NLS-1$
        }
        if ( namespace.length( ) == 0 ) {
            throw new MoinIllegalArgumentException( XmApiMessages.STRINGPARAMETEREMPTY, "namespace" ); //$NON-NLS-1$
        }
        if ( prefix.length( ) == 0 ) {
            throw new MoinIllegalArgumentException( XmApiMessages.STRINGPARAMETEREMPTY, "prefix" ); //$NON-NLS-1$
        }
        final String alreadyRegisteredNs = this.prefix2Namespace.get( prefix );
        if ( alreadyRegisteredNs != null && !alreadyRegisteredNs.equals( namespace ) ) {
            throw new MoinIllegalArgumentException( XmApiMessages.PREFIXALREADYREGISTERED, new Object[] { prefix, alreadyRegisteredNs, namespace } );
        }
        final String alreadyRegisterdPrefix = this.namespace2Prefix.get( namespace );
        if ( alreadyRegisterdPrefix != null && !alreadyRegisterdPrefix.equals( prefix ) ) {
            throw new MoinIllegalArgumentException( XmApiMessages.SECONDFORNAMESPACE, new Object[] { namespace, alreadyRegisterdPrefix, prefix } );
        }
        this.namespace2Prefix.put( namespace, prefix );
        this.prefix2Namespace.put( prefix, namespace );
    }

    public Map<String, String> getNamespaceToPrefix( ) {

        return Collections.unmodifiableMap( this.namespace2Prefix );
    }

    /**
     * Returns an unmodifiable map containing the registered prefixes as keys
     * and the corresponding namespaces as values.
     * 
     * @return prefix to namespace map, cannot be <code>null</code>
     */
    public Map<String, String> getPrefixToNamespace( ) {

        return Collections.unmodifiableMap( this.prefix2Namespace );
    }


    /**
     * This implementation sets the parser helper and calls then the method
     * {@link #afterStartDocument()}.
     * 
     * @param aHelper parser helper
     * @throws XmException if {@link #afterStartDocument()} throws such an
     * exception
     */
    public final void startDocument( final ParserHelper aHelper ) throws XmException {

        if ( aHelper == null ) {
            throw new MoinNullPointerException( "aHelper" ); //$NON-NLS-1$
        }
        this.helper = aHelper;
        this.isStart = true;
        if ( this.namespace2Prefix.get( XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI ) == null ) {
            this.namespace2Prefix.put( XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, this.determineUniqueXsiPrefix( ) );
        }
        this.afterStartDocument( );
    }

    /**
     * Called at the end of method {@link #startDocument(ParserHelper)}. This
     * implementation does nothing.
     * 
     * @throws XmException can be used for error handling
     */
    protected void afterStartDocument( ) throws XmException {

        // do nothing
    }


    /**
     * This implementation does nothing.
     */
    public void endDocument( ) throws XmException {

        // do nothing
    }


    /**
     * This implementation dispatches the SAX like event to the registered
     * specific complex type handlers. See the class description for more
     * details.
     * 
     * @throws XmHandlerException if a prefix has not been registered for the
     * given namespace (see method
     * {@link #registerPrefixForNamespace(String, String)})
     */
    public void elementStarted( final String localName, final String namespace, final String value, final List<XmlAttribute> attributes ) throws XmException {

        final String prefix = this.getPrefix( namespace );
        // push stack
        this.helper.getStack( ).push( localName, prefix, NodeType.Element );


        final ComplexTypeHandler currentComplexTypeHandler;

        if ( isStart ) {
            isStart = false;
            // call method for creating document root model element
            this.rootElementStarted( );
            // get complex type handler for type of root element          
            currentComplexTypeHandler = this.getRootComplexTypeHandler( localName, prefix );
            if ( currentComplexTypeHandler == null ) {
                // assume that in this case the root element is of simple type
                this.addSimpleRootElement( localName, prefix, value );
            }
        } else {
            // depth 2 is parent
            final ComplexTypeHandler parentHandler = this.helper.getStack( ).getHandler( 2 );
            if ( parentHandler != null ) {
                currentComplexTypeHandler = parentHandler.getChild( localName, prefix );
                if ( currentComplexTypeHandler == null ) {
                    // can be an element with simple type 
                    parentHandler.addSimpleElementOrAttribute( localName, prefix, NodeType.Element, value );
                }
            } else {
                // do nothing; this does mean that the user wants to ignore the sub-elements.
                currentComplexTypeHandler = null;
            }

        }
        if ( currentComplexTypeHandler != null ) {
            this.helper.getStack( ).putHandler( currentComplexTypeHandler );

            // dispatch event
            currentComplexTypeHandler.elementStarted( value );

            this.addAttributes( attributes, currentComplexTypeHandler );
        }
    }

    private void addAttributes( final List<XmlAttribute> attributes, final ComplexTypeHandler element ) throws XmException {

        if ( element == null ) {
            throw new MoinNullPointerException( "element" ); //$NON-NLS-1$
        }
        if ( attributes == null ) {
            throw new MoinNullPointerException( "attributes" ); //$NON-NLS-1$
        }
        for ( final XmlAttribute a : attributes ) {
            final String prefix = this.getPrefix( a.getNamespace( ) );
            this.helper.getStack( ).push( a.getLocalName( ), prefix, NodeType.Attribute );
            element.addSimpleElementOrAttribute( a.getLocalName( ), prefix, NodeType.Attribute, a.getValue( ) );
            this.helper.getStack( ).pop( );
        }
    }

    /**
     * This implementation dispatches the SAX like event to the registered
     * specific complex type handlers. See the class description for more
     * details.
     */
    public void elementClosed( ) throws XmException {

        final ComplexTypeHandler closedElement = this.helper.getStack( ).getHandler( );
        if ( closedElement != null ) {
            closedElement.elementClosed( );
            if ( this.helper.getStack( ).size( ) > 1 ) {
                // parent has depth 2
                final ComplexTypeHandler parent = this.helper.getStack( ).getHandler( 2 );
                if ( parent != null ) {
                    parent.childClosed( closedElement, this.getHelper( ).getStack( ).getCurrentPrefix( ), this.getHelper( ).getStack( ).getCurrentLocalName( ) );
                }
            } else if ( this.helper.getStack( ).size( ) == 1 ) {
                // root element --> parent is document root
                this.rootElementClosed( closedElement, this.getHelper( ).getStack( ).getCurrentPrefix( ), this.getHelper( ).getStack( ).getCurrentLocalName( ) );
            }
        }
        //pop stack 
        this.helper.getStack( ).pop( );
    }



    /**
     * Registers a complex type handler which can be reused as child complex
     * type handler in different other complex type handlers.
     * <p>
     * This method can also be used for replacing an already registered complex
     * type handler by another handler.
     * 
     * @param id unique ID of the handler, typically the qualified class name
     * @param handler handler instance
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public final void registerHandler( final String id, final ComplexTypeHandler handler ) {

        if ( id == null ) {
            throw new MoinNullPointerException( "id" ); //$NON-NLS-1$
        }
        if ( handler == null ) {
            throw new MoinNullPointerException( "handler" ); //$NON-NLS-1$
        }
        this.id2ComplexTypeHandler.put( id, handler );
    }


    /**
     * Unregisters a complex type handler.
     * 
     * @param id unique ID of the handler, typically the qualified class name
     * @return unregistered handler or <code>null</code>, if there was no
     * handler registered for the given ID
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public final ComplexTypeHandler unregisterHandler( final String id ) {

        if ( id == null ) {
            throw new MoinNullPointerException( "id" ); //$NON-NLS-1$
        }
        return this.id2ComplexTypeHandler.remove( id );
    }


    /**
     * Returns a complex type handler which is registered with a certain ID.
     * 
     * @param id ID of the handler, typically the qualified class name of the
     * handler is used
     * @return handler or <code>null</code> if <tt>id</tt> does not denote a
     * handler which has been registered by the method
     * {@link #registerHandler(String, ComplexTypeHandler)}
     */
    public final ComplexTypeHandler getHandler( final String id ) {

        if ( id == null ) {
            throw new MoinNullPointerException( "id" ); //$NON-NLS-1$
        }
        return this.id2ComplexTypeHandler.get( id );
    }


    /**
     * Returns the parser helper.
     * 
     * @return parser helper or <code>null</code> if the method
     * {@link #startDocument(ParserHelper)} was not yet called
     */
    public final ParserHelper getHelper( ) {

        return this.helper;
    }

    /**
     * Returns the stack.
     * 
     * @return stack cannot be <code>null</code>
     * @throws IllegalStateException if the method is called before the method
     * {@link XmParserHandlerAbstract#startDocument(ParserHelper)} was called
     */
    public PathStack getStack( ) {

        this.checkExistenceOfHelper( );
        return this.getHelper( ).getStack( );
    }


    /**
     * Returns the complex type handler for the root element of the current
     * parsed XML document. This method is called after the method
     * {@link #rootElementStarted()}.
     * <p>
     * This parser handler can treat different XML documents with different root
     * elements. Therefore the local name and the prefix of the root element is
     * given.
     * <p>
     * This implementation returns null.
     * 
     * @param localName local name of the root element
     * @param prefix prefix of the root element
     * @return root complex type handler or <code>null</code> if no complex type
     * handler is found
     */
    protected ComplexTypeHandler getRootComplexTypeHandler( final String localName, final String prefix ) throws XmException {

        return null;
    }

    /**
     * This method is called after the method
     * {@link #getRootComplexTypeHandler(String, String)}, if the method
     * {@link #getRootComplexTypeHandler(String, String)} returns
     * <code>null</code>.
     * <p>
     * It can be used to set the simple type value of the root element to the
     * document root model element.
     * 
     * @param localName local name of the root element
     * @param prefix normalized prefix of the root element (see method
     * {@link #registerPrefixForNamespace(String, String)}
     * @param value value of the root element
     * @return <tt>true</tt> if the root XML element has been treated by this
     * implementation, otherwise <tt>false</tt>; this implementation returns
     * always <tt>false</tt>, this signals a implementation of a sub-class
     * whether the super class method has treated the root XML element
     * @throws XmException can be used for error handling, this implementation
     * does not throw such an exception
     */
    protected boolean addSimpleRootElement( final String localName, final String prefix, final String value ) throws XmException {

        return false;
    }

    /**
     * This method is called when the SAX parser reaches the opening tag of the
     * root element. At that point in time, the stack contains the path of the
     * root element. This method can be used to create the document root model
     * element.
     * <p>
     * This implementation does nothing.
     * 
     * @throws XmException can be used for error handling, this implementation
     * does not throw such an exception
     */
    protected void rootElementStarted( ) throws XmException {

        // do nothing
    }

    /**
     * This method is called when the SAX parser reaches the closing tag of the
     * root element. At this point in time, the stack still contains the entry
     * of the root element path. Further, this method is only called when the
     * root element is of complex type, i.e. the method
     * {@link #getRootComplexTypeHandler(String, String)} has returned a
     * handler.
     * <p>
     * This implementation does nothing.
     * 
     * @param rootElementTypeHandler handler of the complex type of the root
     * element
     * @param prefix normalized prefix of the root element (see method
     * {@link #registerPrefixForNamespace(String, String)}
     * @param localName local name of the root element
     * @throws XmException can be used for error handling, this implementation
     * does not throw such an exception
     */
    protected void rootElementClosed( final ComplexTypeHandler rootElementTypeHandler, final String prefix, final String localName ) throws XmException {

        // do nothing
    }



    private String getPrefix( final String uri ) throws XmHandlerException {

        if ( uri == null || uri.length( ) == 0 ) {
            return ""; //$NON-NLS-1$
        } else {
            final String result = this.namespace2Prefix.get( uri );
            if ( result == null ) {
                throw new XmHandlerException( XmApiMessages.PREFIXFORNAMESPACENOTREGISTERED, uri );
            }
            return result;
        }
    }

    private String determineUniqueXsiPrefix( ) {

        String proposedPrefix = "xsi"; //$NON-NLS-1$
        for ( int i = 0; this.namespace2Prefix.values( ).contains( proposedPrefix ); i++ ) {
            proposedPrefix = "xsi" + i; //$NON-NLS-1$
        }
        return proposedPrefix;
    }

    /*-------------- convenience methods -------------------------------------- */

    /**
     * Creates or fetches a model element in the partition which corresponds to
     * the current parsed XML document and puts the corresponding model element
     * handle to the top stack entry using a certain key. For the MOFID
     * calculation the default logical key is used, which consists of
     * <ul>
     * <li>model container name</li>
     * <li>partition name</li>
     * <li>the unique XPATH of the current parsed XML element/attribute</li>
     * </ul>
     * 
     * @param classDescriptor class descriptor which describes the type of the
     * model element
     * @param key key with which the model element handle can be accessed again
     * from the stack entry
     * @return created model element handle, cannot be <code>null</code>
     * @throws NullPointerException if a parameter is <code>null</code>
     * @throws IllegalStateException if the method is called before the method
     * {@link #startDocument(ParserHelper)} was called by the parser
     * @throws IndexOutOfBoundsException if the stack size is 0
     */
    public PModelElementHandle createOrGetModelElementAndPutToTopStackEntry( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, final String key ) {

        this.checkExistenceOfHelper( );
        final PModelElementHandle modelElement = this.getHelper( ).getOrCreateModelElement( classDescriptor );
        this.getHelper( ).getStack( ).putModelElement( key, modelElement );
        return modelElement;
    }

    /**
     * Creates or fetches a model element in the partition which corresponds to
     * the current parsed XML document and puts the corresponding model element
     * handle to the top stack entry using a certain key. For the MOFID
     * calculation the given logical key is used.
     * 
     * @param classDescriptor class descriptor which describes the type of the
     * model element
     * @param key key with which the model element handle can be accessed again
     * from the stack entry
     * @param logicalKey logical key of the model element
     * @throws NullPointerException if a parameter is <code>null</code>
     * @throws IllegalArgumentException if the array <tt>logicalKey</tt> is
     * empty
     * @throws IllegalStateException if the method is called before the method
     * {@link XmParserHandlerAbstract#startDocument(ParserHelper)} was called by
     * the parser
     * @throws IndexOutOfBoundsException if the stack size is 0
     */
    public PModelElementHandle createOrGetModelElementAndPutToTopStackEntry( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, final String key, final String... logicalKey ) {

        this.checkExistenceOfHelper( );
        final PModelElementHandle modelElement = getHelper( ).getOrCreateModelElement( classDescriptor, logicalKey );
        this.getHelper( ).getStack( ).putModelElement( key, modelElement );
        return modelElement;
    }

    /**
     * Creates a link between a child model element whose handle is stored in
     * the top stack entry and a model element whose handle is stored in the
     * parent stack entry (stack entry in the depth 2).
     * <p>
     * If one of the model elements is <code>null</code> nothing is done.
     * 
     * @param childModelElementKey key for identifying the child model element
     * in the top stack entry
     * @param parentModelElementKey key for identifying the parent model element
     * in the parent stack entry
     * @param associationDescriptor association descriptor
     * @param childEndName name of the association end of the child model
     * element
     * @throws IllegalArgumentException is thrown
     * <ul>
     * <li>if the child end name is not correct</li> <li>if the child model
     * element or parent model element does not have the type which is excepted
     * by the corresponding association end</li>
     * </ul>
     * @throws NullPointerException if a parameter is <code>null</code>
     * @throws IllegalStateException if the method is called before the method
     * {@link XmParserHandlerAbstract#startDocument(ParserHelper)} was called by
     * the parser
     * @throws IndexOutOfBoundsException if the stack size is smaller than 2
     */
    public void createLink( final String childModelElementKey, final String parentModelElementKey, final AssociationDescriptor<? extends RefAssociation> associationDescriptor, final String childEndName ) {

        this.checkExistenceOfHelper( );
        final PModelElementHandle childModelElement = this.getHelper( ).getStack( ).getModelElement( childModelElementKey );
        // parent stack entry has depth 2!
        final PModelElementHandle parentModelElement = this.getHelper( ).getStack( ).getModelElement( 2, parentModelElementKey );
        this.createLink( childModelElement, parentModelElement, associationDescriptor, childEndName );
    }

    /**
     * Creates a link between a child model element and a parent model element.
     * <p>
     * If one of the model elements is <code>null</code> nothing is done.
     * 
     * @param childModelElement the child model element
     * @param parentModelElement the parent model element
     * @param associationDescriptor association descriptor
     * @param childEndName name of the association end of the child model
     * element
     * @throws IllegalArgumentException is thrown
     * <ul>
     * <li>if the child end name is not correct</li> <li>if <tt>
     * childModelElement </tt> or <tt>parentModelElement</tt> are handles which
     * are not fetched by the method
     * {@link #getOrCreateModelElement(ClassDescriptor, String...)} or by the
     * method {@link #getOrCreateModelElement(ClassDescriptor)}</li> <li>if the
     * model element <tt>childModelElement</tt> or <tt> parentModelElement</tt>
     * does not have the type which is excepted by the corresponding association
     * end</li>
     * </ul>
     * @throws NullPointerException if a <tt>associationDescriptor</tt> or
     * <tt>endBName</tt> is <code>null</code>
     * @throws IllegalStateException if the method is called before the method
     * {@link XmParserHandlerAbstract#startDocument(ParserHelper)} was called
     */
    public void createLink( final PModelElementHandle childModelElement, final PModelElementHandle parentModelElement, final AssociationDescriptor<? extends RefAssociation> associationDescriptor, final String childEndName ) {

        this.checkExistenceOfHelper( );
        if ( childModelElement != null && parentModelElement != null ) {
            getHelper( ).createLink( associationDescriptor, childEndName, parentModelElement, childModelElement );
        } else {
            // do nothing
        }
    }



    /**
     * Sets or adds a value to an attribute of a model element which is stored
     * in the parent stack entry (stack entry in the depth 2).
     * <p>
     * Nothing is done if no model element for the given key is found in the
     * parent stack entry.
     * <p>
     * If the attribute is of type Boolean then the attribute value is set to
     * <code>true</code> if the value parameter is not <code>null</code> and is
     * equal, ignoring case, to the string <code>"true"</code>.
     * <p>
     * Example: <tt>Boolean.valueOf("True")</tt> leads to <tt>true</tt>.<br>
     * Example: <tt>Boolean.valueOf("yes")</tt> leads to <tt>false</tt>.
     * <p>
     * Note, there is a different exception handling for the Import/Export and
     * the CP/S integration strategy.
     * 
     * @param modelElementKey key identifying the model element in the parent
     * stack entry
     * @param attributeDescriptor attribute descriptor
     * @param value value of the attribute
     * @throws IllegalArgumentException if <code>value</code> is
     * <code>null</code>
     * @throws NullPointerException if a parameter except <code>value</code> is
     * <code>null</code>
     * @throws IllegalStateException if the method is called before the method
     * {@link XmParserHandlerAbstract#startDocument(ParserHelper)} was called by
     * the parser
     * @throws IndexOutOfBoundsException if the stack size is 0
     * @throws InvalidNameException if <code>attributeDescriptor</code> does not
     * denote a valid attribute of the model element; this exception is only
     * thrown in the Import/Export integration strategy; in the CP/S integration
     * strategy this situation can be handled by the SpiParserErrorHandler
     * @throws NumberFormatException if the attribute is a number primitive type
     * and <tt>value</tt> does not contain a parse-able number; this exception
     * is only thrown in the Import/Export integration strategy; in the CP/S
     * integration strategy this situation can be handled by the
     * SpiParserErrorHandler
     */
    public void setOrAddAttributeValue( final String modelElementKey, final AttributeDescriptor<? extends Attribute, ? extends RefObject, ? extends Object> attributeDescriptor, final String value ) {

        this.checkExistenceOfHelper( );
        final PModelElementHandle modelElement = this.getHelper( ).getStack( ).getModelElement( 2, modelElementKey );
        this.setOrAddAttributeValue( modelElement, attributeDescriptor, value );
    }


    /**
     * Sets or adds a value to an attribute of a model element .
     * <p>
     * Nothing is done if the model element is <code>null</code>.
     * <p>
     * If the attribute is of type Boolean then the attribute value is set to
     * <code>true</code> if the value parameter is not <code>null</code> and is
     * equal, ignoring case, to the string <code>"true"</code>.
     * <p>
     * Example: <tt>Boolean.valueOf("True")</tt> leads to <tt>true</tt>.<br>
     * Example: <tt>Boolean.valueOf("yes")</tt> leads to <tt>false</tt>.
     * <p>
     * Note, there is a different exception handling for the Import/Export and
     * the CP/S integration strategy.
     * 
     * @param modelElement the model element
     * @param attributeDescriptor attribute descriptor
     * @param value value of the attribute
     * @throws IllegalArgumentException if <code>value</code> is
     * <code>null</code>
     * @throws NullPointerException if a parameter except <code>value</code> is
     * <code>null</code>
     * @throws IllegalStateException if the method is called before the method
     * {@link XmParserHandlerAbstract#startDocument(ParserHelper)} was called by
     * the parser
     * @throws InvalidNameException if <code>attributeDescriptor</code> does not
     * denote a valid attribute of the model element; this exception is only
     * thrown in the Import/Export integration strategy; in the CP/S integration
     * strategy this situation can be handled by the SpiParserErrorHandler
     * @throws NumberFormatException if the attribute is a number primitive type
     * and <tt>value</tt> does not contain a parse-able number; this exception
     * is only thrown in the Import/Export integration strategy; in the CP/S
     * integration strategy this situation can be handled by the
     * SpiParserErrorHandler
     */
    public void setOrAddAttributeValue( final PModelElementHandle modelElement, final AttributeDescriptor<? extends Attribute, ? extends RefObject, ? extends Object> attributeDescriptor, final String value ) {

        if ( modelElement != null ) {
            modelElement.setOrAddAttribute( attributeDescriptor, value );
        } else {
            // do nothing
        }
    }


    /**
     * Checks whether the helper instance was already set by the method
     * {@link XmParserHandlerAbstract#startDocument(ParserHelper)}.
     * 
     * @throws IllegalStateException if the method is called before the method
     * {@link XmParserHandlerAbstract#startDocument(ParserHelper)} was called by
     * the parser
     */
    private void checkExistenceOfHelper( ) {

        if ( this.getHelper( ) == null ) {
            throw new MoinIllegalStateException( XmApiMessages.METHODMUSTBECALLED, "\"XmPrserHandlerAbstractstartDocument(ParserHelper)\"" ); //$NON-NLS-1$
        }
    }



    /** Exception thrown by the XM Handler framework. */
    static final class XmHandlerException extends XmException {

        private static final long serialVersionUID = -6346029142408526419L;

        XmHandlerException( final MoinLocalizedString message, final Object... args ) {

            super( message, args );
        }

    }
}
