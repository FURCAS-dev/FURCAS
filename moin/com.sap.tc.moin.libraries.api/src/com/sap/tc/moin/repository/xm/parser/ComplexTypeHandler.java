package com.sap.tc.moin.repository.xm.parser;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.xm.XmException;

/**
 * Represents a sub-handler of SAX events which are forwarded by the dispatcher
 * handler {@link XmParserHandlerAbstract}. The sub-handler handles events for
 * XML elements/attributes of the content model of a complex type definition. In
 * other words, the sub-handler handles the content defined by a complex type
 * definition.
 * <p>
 * Sub-classes of this class are typically generated from an XML schema.
 * <p>
 * Instances of the generated sub-classes build a tree (ore more precisely a
 * net, because the same handler can be reused in different node places of the
 * tree) which represents the XML document structure defined by the XML schema.
 * See method {@link #getChild(String, String)}.
 * <p>
 * In the implementing class, you can access the dispatcher
 * {@link XmParserHandlerAbstract} and {@link ParserHelper} which offer
 * convenience methods for creating MOIN model entities.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public abstract class ComplexTypeHandler {

    private final XmParserHandlerAbstract parser;

    /**
     * Constructor.
     * 
     * @param aParser parser
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public ComplexTypeHandler( final XmParserHandlerAbstract aParser ) {

        if ( aParser == null ) {
            throw new MoinNullPointerException( "aParser" ); //$NON-NLS-1$
        }
        this.parser = aParser;
    }

    /**
     * Called when the start tag of an XML element is reached whose content is
     * handled by this parser.
     * <p>
     * Typically model elements are created or fetched here via the method
     * {@link ParserHelper#getOrCreateModelElement(com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor)}
     * or
     * {@link ParserHelper#getOrCreateModelElement(ClassDescriptor, String...)}
     * and the meta model handles. After the creation or selection, the model
     * elements are typically put to the stack with the methods
     * {@link ParserHelper#getStack()} and
     * {@link PathStack#putModelElement(String, PModelElementHandle)} or
     * {@link PathStack#putModelElement(int, String, PModelElementHandle)}.
     * <p>
     * This implementation does nothing.
     * 
     * @param value value of the XML element; if the type of the element
     * declaration corresponding to the XML element has complex content then the
     * value will be an empty string, non-empty string values are only possible
     * for an element with simple content
     * @throws XmException can be used for error handling, this implementation
     * does not throw such an exception
     */
    public void elementStarted( final String value ) throws XmException {

        // do nothing
    }



    /**
     * Called when the parser reaches an XML element of the content model of the
     * complex element declaration corresponding to this handler.
     * <p>
     * If the XML element is of complex type, then this method shall return the
     * corresponding complex type handler.
     * <p>
     * <code>null</code> shall be returned if the XML element with its direct
     * and indirect XML sub-elements shall not be mapped to MOIN entities.
     * <p>
     * This method is also called, if the XML element is of simple type. In this
     * case the return value must be <code>null</code>.
     * <p>
     * Whenever <code>null</code> is returned then afterwards the method
     * {@link #addSimpleElementOrAttribute(String, String, NodeType, String)} is
     * called.
     * <p>
     * When this method is called, the top entry of the stack contains already
     * child information.
     * <p>
     * This implementation returns always <code>null</code>.
     * 
     * @param childLocalName local name of the XML element, cannot be
     * <code>null</code>
     * @param childPrefix prefix of the XML element, cannot be <code>null</code>
     * @return complex element handler representing the child XML element,
     * <code>null</code> if the XML element is not of complex type or if the XML
     * element with its direct and indirect XML sub-elements should not be
     * mapped to MOIN entities
     */
    public ComplexTypeHandler getChild( final String childLocalName, final String childPrefix ) {

        return null;
    }


    /**
     * Adds either an XML attribute or an XML element of simple type which is
     * defined by the content model of the complex type definition which
     * correspond to this complex type handler.
     * <p>
     * This method is called for an XML element, if the method
     * {@link #getChild(String, String)} has returned <code>null</code> for the
     * XML element. Therefore, this method can also be called for child XML
     * elements with complex types. We recommend to do nothing in this case.
     * <p>
     * If this method is called for an XML element with complex type then the
     * parameter <tt>value</tt> will contain an empty string.
     * <p>
     * If a XML element with simple type does not contain a value (e.g.
     * &lt;customer&gt;&lt;/customer&gt;) then the parameter<tt>value</tt> will
     * contain an empty string.
     * <p>
     * Typically this method is used to assign values to model element
     * attributes. You fetch a model element handle with the method sequence
     * {@link ParserHelper#getStack()} and
     * {@link PathStack#getModelElement(String)} or
     * {@link PathStack#getModelElement(int, String)} and then you use the
     * method
     * {@link PModelElementHandle#setOrAddAttribute(com.sap.tc.moin.repository.jmi. descriptors.AttributeDescriptor, String)}.
     * <p>
     * You can also store the value of the XML element/attribute in the stack,
     * so that you can use it later. In this case, you use the method sequence
     * {@link ParserHelper#getStack()} and
     * {@link PathStack#putProperty(String, String)} or
     * {@link PathStack#putProperty(int, String, String)}.
     * <p>
     * This implementation does nothing.
     * 
     * @param localName local Name of the XML attribute or child XML element,
     * cannot be <code>null</code>
     * @param prefix prefix of the XML attribute or child XML element,
     * normalized by the method,
     * {@link XmParserHandlerAbstract#registerPrefixForNamespace(String, String)}
     * ; cannot be <code>null</code> ( the no-namespace is represented by an
     * empty string)
     * @param nodeType node type, cannot be <code>null</code>
     * @param value value of the XML attribute or child XML element, cannot be
     * <code>null</code>
     * @return <tt>true</tt> if the XML attribute or child XML element has been
     * treated by this implementation, otherwise <tt>false</tt>; this
     * implementation returns always <tt>false</tt>, this signals an
     * implementation of a sub-class whether the super class method has treated
     * the XML attribute or child XML element
     * @throws XmException can be used for error handling, this implementation
     * does not throw such an exception
     */
    public boolean addSimpleElementOrAttribute( final String localName, final String prefix, final NodeType nodeType, final String value ) throws XmException {

        return false;
    }

    /**
     * This method is called on the parent complex type handler if the parser
     * reaches the closing tag of an XML element of complex type. At this point
     * in time {@link ParserHelper#getStack()} does still contain the path of
     * the XML element.
     * <p>
     * This method is typically used for creating a link between the child model
     * element and parent model element. A model element is fetched via the
     * method sequence {@link ParserHelper#getStack()} and
     * {@link PathStack#getModelElement(String)} or
     * {@link PathStack#getModelElement(int, String)}. Use depth level 1 to
     * fetch the child model element and depth level 2 to fetch the parent model
     * element. You create a link with the method
     * {@link ParserHelper#createLink(com.sap.tc.moin.repository.mmi.descriptors. AssociationDescriptor, String, PModelElementHandle, PModelElementHandle)}
     * or
     * {@link ParserHelper#createLink(com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor, String, PModelElementHandle, com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor, String[])}
     * .
     * <p>
     * This method is called after the method {@link #elementClosed()} is called
     * on the child handler.
     * 
     * @param childHandler handler of the type of the child element, cannot be
     * <code>null</code>
     * @param childPrefix prefix of the child XML element, cannot be
     * <code>null</code>
     * @param childLocalName local name of the child XML element, cannot be
     * <code>null</code>
     * @throws XmException can be used for error handling, this implementation
     * does not throw such an exception
     */
    public void childClosed( final ComplexTypeHandler childHandler, final String childPrefix, final String childLocalName ) throws XmException {

        // do nothing
    }


    /**
     * Called when parser reaches the closing tag of an XML element which is
     * typed by the complex type definition represented by this handler.
     * <p>
     * The method
     * {@link ComplexTypeHandler#childClosed(ComplexTypeHandler, String, String)}
     * is called on the parent handler after this method is called.
     * 
     * @throws XmException can be used for error handling, this implementation
     * does not throw such an exception
     */
    public void elementClosed( ) throws XmException {

        // do nothing
    }


    /**
     * Returns the parser helper.
     * 
     * @return parser helper or <code>null</code> if the method
     * {@link XmParserHandler#startDocument(ParserHelper)} was not yet called on
     * the parser handler
     */
    public final ParserHelper getHelper( ) {

        return this.parser.getHelper( );
    }

    /**
     * Returns the parser handler.
     * 
     * @return parser handler, cannot be <code>null</code>
     */
    public final XmParserHandlerAbstract getParser( ) {

        return this.parser;
    }

    /* ---- convenience methods ----- */

    /**
     * Returns a complex element handler which is registered with a certain ID.
     * 
     * @param id ID of the handler, typically the qualified class name of the
     * handler is used
     * @return handler or <code>null</code> if <tt>id</tt> does not denote
     * handler which has been registered by the method
     * {@link XmParserHandlerAbstract#registerHandler(String, ComplexTypeHandler)}
     */
    public ComplexTypeHandler getHandler( final String id ) {

        return this.parser.getHandler( id );
    }

    /**
     * Returns the stack.
     * 
     * @return stack cannot be <code>null</code>
     * @throws IllegalStateException if the method is called before the method
     * {@link XmParserHandlerAbstract#startDocument(ParserHelper)} was called
     */
    public PathStack getStack( ) {

        return this.parser.getStack( );
    }

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
     * {@link XmParserHandlerAbstract#startDocument(ParserHelper)} was called by
     * the parser
     * @throws IndexOutOfBoundsException if the stack size is 0
     */
    public PModelElementHandle createOrGetModelElementAndPutToTopStackEntry( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, final String key ) {

        return this.parser.createOrGetModelElementAndPutToTopStackEntry( classDescriptor, key );
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

        return this.parser.createOrGetModelElementAndPutToTopStackEntry( classDescriptor, key, logicalKey );
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
     * <li>if the child end name is not correct</li> <li>if the model of <tt>
     * childModelElementKey</tt> or <tt>parentModelElementKey</tt> does not have
     * the type which is excepted by the corresponding association end</li>
     * </ul>
     * @throws NullPointerException if a parameter is <code>null</code>
     * @throws IllegalStateException if the method is called before the method
     * {@link XmParserHandlerAbstract#startDocument(ParserHelper)} was called by
     * the parser
     * @throws IndexOutOfBoundsException if the stack size is smaller than 2
     */
    public void createLink( final String childModelElementKey, final String parentModelElementKey, final AssociationDescriptor<? extends RefAssociation> associationDescriptor, final String childEndName ) {

        this.parser.createLink( childModelElementKey, parentModelElementKey, associationDescriptor, childEndName );
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

        this.parser.setOrAddAttributeValue( modelElementKey, attributeDescriptor, value );
    }

}